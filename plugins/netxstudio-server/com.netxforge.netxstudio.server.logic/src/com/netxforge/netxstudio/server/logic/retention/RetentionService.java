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
package com.netxforge.netxstudio.server.logic.retention;

import java.util.Date;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import com.google.inject.Inject;
import com.netxforge.base.cdo.CDO;
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.data.Server;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.server.service.NetxForgeService;
import com.netxforge.netxstudio.webservice.job.IRunMonitor;

/**
 * Starts a netxforge retention service
 * 
 * @author Martin Taal
 */
public class RetentionService implements NetxForgeService {

	public static final String SERVICE_PARAM = "rfsService";
	public static final String NODE_PARAM = "node";
	public static final String NODETYPE_PARAM = "nodeType";
	public static final String START_TIME_PARAM = "startTime";
	public static final String END_TIME_PARAM = "endTime";

	public Object run(Map<String, String> parameters) {
		final RetentionServiceRunner runner = LogicActivator.getInstance()
				.getInjector().getInstance(RetentionServiceRunner.class);
		runner.setParameters(parameters);
		CDOID run = runner.run();
		return CDO.cdoLongIDAsString(run);
	}

	public static class RetentionServiceRunner {
		@Inject
		@Server
		private ICDOData dataProvider;

		private Map<String, String> parameters;

		private CDOID run() {
			final IRunMonitor monitor = createMonitor();
			final RetentionLogic logic = LogicActivator.getInstance()
					.getInjector().getInstance(RetentionLogic.class);

			// if (parameters.containsKey(SERVICE_PARAM)) {
			// final CDOID id = getCDOID(parameters.get(SERVICE_PARAM),
			// ServicesPackage.Literals.RFS_SERVICE);
			// logic.setRfsService(id);
			// } else if (parameters.containsKey(NODE_PARAM)) {
			// final CDOID id = getCDOID(parameters.get(NODE_PARAM),
			// OperatorsPackage.Literals.NODE);
			// logic.setNode(id);
			// } else if (parameters.containsKey(NODETYPE_PARAM)) {
			// final CDOID id = getCDOID(parameters.get(NODETYPE_PARAM),
			// LibraryPackage.Literals.NODE_TYPE);
			// logic.setNodeType(id);
			// } else {
			// throw new IllegalArgumentException("No valid parameters found");
			// }

			logic.setJobMonitor(monitor);

			// logic.setBeginTime(getStartTime(parameters));
			// logic.setEndTime(getEndTime(parameters));
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
					logic.run();
				};
			}.start();
			return monitor.getWorkFlowRunId();
		}

		@SuppressWarnings("unused")
		private Date getStartTime(Map<String, String> parameters) {
			final XMLGregorianCalendar xmlDate = XMLTypeFactory.eINSTANCE
					.createDateTime(parameters.get(START_TIME_PARAM));
			return xmlDate.toGregorianCalendar().getTime();
		}

		@SuppressWarnings("unused")
		private Date getEndTime(Map<String, String> parameters) {
			final XMLGregorianCalendar xmlDate = XMLTypeFactory.eINSTANCE
					.createDateTime(parameters.get(END_TIME_PARAM));
			return xmlDate.toGregorianCalendar().getTime();
		}

		private ServerWorkFlowRunMonitor createMonitor() {
			final ServerWorkFlowRunMonitor runMonitor = LogicActivator
					.getInstance().getInjector()
					.getInstance(ServerWorkFlowRunMonitor.class);
			dataProvider.openSession();
			dataProvider.getTransaction();
			final Resource res = dataProvider
					.getResource(SchedulingPackage.Literals.WORK_FLOW_RUN);

			final WorkFlowRun wfRun = SchedulingFactory.eINSTANCE
					.createComponentWorkFlowRun();
			res.getContents().add(wfRun);

			dataProvider.commitTransactionThenClose();
			dataProvider.closeSession();
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
	}

}
