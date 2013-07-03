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
package com.netxforge.netxstudio.server.logic.monitoring;

import java.util.Date;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.job.IRunMonitor;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.IDPProvider;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.server.logic.profile.RFSServiceProfileLogic;
import com.netxforge.netxstudio.server.service.NetxForgeService;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Starts a netxforge service
 * 
 * @author Martin Taal
 */
public class MonitoringService implements NetxForgeService {

	@Inject
	private static ModelUtils modelUtils;

	public static final String SERVICE_PARAM = "rfsService";
	public static final String NODE_PARAM = "node";
	public static final String NODETYPE_PARAM = "nodeType";
	public static final String START_TIME_PARAM = "startTime";
	public static final String END_TIME_PARAM = "endTime";

	public Object run(Map<String, String> parameters) {
		final ResourceMonitoringRunner runner = LogicActivator.getInstance()
				.getInjector().getInstance(ResourceMonitoringRunner.class);
		runner.setParameters(parameters);
		CDOID run = runner.run();
		return modelUtils.cdoLongIDAsString(run);
	}

	public static class ResourceMonitoringRunner {

		@Inject
		@Server
		private IDPProvider dpProvider;

		private IDataProvider dataProvider;

		private Map<String, String> parameters;

		private CDOID run() {
			final IRunMonitor monitor = createMonitor();
			final BaseMonitoringLogic monitoringLogic;
			final RFSServiceProfileLogic resourceProfileLogic;

			// TODO Also for Operator monitoring all services?
			if (parameters.containsKey(SERVICE_PARAM)) {
				final CDOID id = modelUtils.cdoLongIDFromString(
						ServicesPackage.Literals.RFS_SERVICE,
						parameters.get(SERVICE_PARAM));
				monitoringLogic = LogicActivator.getInstance().getInjector()
						.getInstance(RFSServiceMonitoringLogic.class);
				((RFSServiceMonitoringLogic) monitoringLogic).setRfsService(id);

				resourceProfileLogic = LogicActivator.getInstance()
						.getInjector()
						.getInstance(RFSServiceProfileLogic.class);

				resourceProfileLogic.setRfsService(id);
				resourceProfileLogic.setJobMonitor(monitor);
				resourceProfileLogic.initializeProfileLogic();
				resourceProfileLogic.setBeginTime(getStartTime(parameters));
				resourceProfileLogic.setEndTime(getEndTime(parameters));

			} else if (parameters.containsKey(NODE_PARAM)) {
				final CDOID id = modelUtils.cdoLongIDFromString(
						OperatorsPackage.Literals.NODE,
						parameters.get(NODE_PARAM));
				monitoringLogic = LogicActivator.getInstance().getInjector()
						.getInstance(NodeMonitoringLogic.class);
				((NodeMonitoringLogic) monitoringLogic).setNode(id);
				resourceProfileLogic = null;
			} else if (parameters.containsKey(NODETYPE_PARAM)) {
				final CDOID id = modelUtils.cdoLongIDFromString(
						LibraryPackage.Literals.NODE_TYPE,
						parameters.get(NODETYPE_PARAM));
				monitoringLogic = LogicActivator.getInstance().getInjector()
						.getInstance(NodeMonitoringLogic.class);
				((NodeMonitoringLogic) monitoringLogic).setNodeType(id);
				resourceProfileLogic = null;
			} else {
				throw new IllegalArgumentException("No valid parameters found");
			}
			monitoringLogic.setJobMonitor(monitor);
			monitoringLogic.setBeginTime(getStartTime(parameters));
			monitoringLogic.setEndTime(getEndTime(parameters));

			// Set the monitor for specific logic.
			if (monitoringLogic instanceof RFSServiceMonitoringLogic) {
				((RFSServiceMonitoringLogic) monitoringLogic)
						.initServiceMonitor(monitoringLogic.getPeriod());
			}

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
					monitoringLogic.run();
					if (resourceProfileLogic != null) {
						resourceProfileLogic.run();
					}
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
			final ServerWorkFlowRunMonitor runMonitor = LogicActivator
					.getInstance().getInjector()
					.getInstance(ServerWorkFlowRunMonitor.class);

			getDataProvider().openSession();
			getDataProvider().getTransaction();
			final Resource res = getDataProvider().getResource(
					SchedulingPackage.Literals.WORK_FLOW_RUN);

			final WorkFlowRun wfRun = SchedulingFactory.eINSTANCE
					.createComponentWorkFlowRun();
			res.getContents().add(wfRun);

			getDataProvider().commitTransactionThenClose();
			getDataProvider().closeSession();
			runMonitor.setWorkFlowRunId(wfRun.cdoID());
			runMonitor.setStartRunning();
			return runMonitor;
		}

		public Map<String, String> getParameters() {
			return parameters;
		}

		public void setParameters(Map<String, String> parameters) {
			this.parameters = parameters;
		}

		public IDataProvider getDataProvider() {
			if (dataProvider == null) {
				dataProvider = dpProvider.get();
			}
			return dataProvider;
		}
	}

}
