/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.logic;

import java.util.Date;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOIDLong;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;
import com.netxforge.netxstudio.server.service.NetxForgeService;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Starts a netxforge service
 * 
 * @author Martin Taal
 */
public class ResourceMonitoringService implements NetxForgeService {

	public static final String SERVICE_PARAM = "rfsService";
	public static final String NODE_PARAM = "node";
	public static final String NODETYPE_PARAM = "nodeType";
	public static final String START_TIME_PARAM = "startTime";
	public static final String END_TIME_PARAM = "endTime";

	public Object run(Map<String, String> parameters) {
		final ResourceMonitoringRunner runner = LogicActivator.getInstance()
				.getInjector().getInstance(ResourceMonitoringRunner.class);
		runner.setParameters(parameters);
		return ((AbstractCDOIDLong)runner.run()).getLongValue();
	}

	public static class ResourceMonitoringRunner {
		@Inject
		@Server
		private IDataProvider dataProvider;

		private Map<String, String> parameters;

		private CDOID run() {
			final ServerWorkFlowRunMonitor monitor = createMonitor();
			final BaseResourceMonitoringLogic capacityLogic;
			if (parameters.containsKey(SERVICE_PARAM)) {
				final CDOID id = getCDOID(parameters.get(SERVICE_PARAM),
						ServicesPackage.Literals.RFS_SERVICE);
				capacityLogic = LogicActivator.getInstance().getInjector()
						.getInstance(RFSServiceResourceMonitoringLogic.class);
				((RFSServiceResourceMonitoringLogic) capacityLogic).setRfsService(id);
			} else if (parameters.containsKey(NODE_PARAM)) {
				final CDOID id = getCDOID(parameters.get(NODE_PARAM),
						OperatorsPackage.Literals.NODE);
				capacityLogic = LogicActivator.getInstance().getInjector()
						.getInstance(NodeResourceMonitoringLogic.class);
				((NodeResourceMonitoringLogic) capacityLogic).setNode(id);
			} else if (parameters.containsKey(NODETYPE_PARAM)) {
				final CDOID id = getCDOID(parameters.get(NODETYPE_PARAM),
						LibraryPackage.Literals.NODE_TYPE);
				capacityLogic = LogicActivator.getInstance().getInjector()
						.getInstance(NodeResourceMonitoringLogic.class);
				((NodeResourceMonitoringLogic) capacityLogic).setNodeType(id);
			} else {
				throw new IllegalArgumentException("No valid parameters found");
			}
			capacityLogic.setJobMonitor(monitor);
			capacityLogic.setStartTime(getStartTime(parameters));
			capacityLogic.setEndTime(getEndTime(parameters));
			// run in a separate thread
			new Thread() {
				@Override
				public void run() {
					// sleep to give the system
					// time to return
					try {
						sleep(100);
					} catch (final Exception e) {
						// do nothing, ignore
					}
					capacityLogic.run();
				};
			}.start();
			return monitor.getWorkFlowRunId();
		}

		private Date getStartTime(Map<String, String> parameters) {
			final XMLGregorianCalendar xmlDate = XMLTypeFactory.eINSTANCE
					.createDateTime(parameters.get(START_TIME_PARAM));
			return xmlDate.toGregorianCalendar().getTime();
		}

		private Date getEndTime(Map<String, String> parameters) {
			final XMLGregorianCalendar xmlDate = XMLTypeFactory.eINSTANCE
					.createDateTime(parameters.get(END_TIME_PARAM));
			return xmlDate.toGregorianCalendar().getTime();
		}

		private ServerWorkFlowRunMonitor createMonitor() {
			final ServerWorkFlowRunMonitor runMonitor = LogicActivator.getInstance()
					.getInjector().getInstance(ServerWorkFlowRunMonitor.class);
			dataProvider.openSession();
			dataProvider.getTransaction();
			final Resource res = dataProvider
					.getResource(SchedulingPackage.Literals.WORK_FLOW_RUN);

			final WorkFlowRun wfRun = SchedulingFactory.eINSTANCE
					.createExpressionWorkFlowRun();
			res.getContents().add(wfRun);

			dataProvider.commitTransaction();
			dataProvider.closeSession();
			runMonitor.setWorkFlowRunId(wfRun.cdoID());
			runMonitor.setStartRunning();
			return runMonitor;
		}

		private CDOID getCDOID(String idString,
				org.eclipse.emf.ecore.EClass eClass) {
			return CDOIDUtil.createLongWithClassifier(new CDOClassifierRef(
					eClass), Long.parseLong(idString));
		}

		public Map<String, String> getParameters() {
			return parameters;
		}

		public void setParameters(Map<String, String> parameters) {
			this.parameters = parameters;
		}
	}

}
