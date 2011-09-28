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
package com.netxforge.netxstudio.server.logic.reporting;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOIDLong;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;
import com.netxforge.netxstudio.server.logic.BaseLogic;
import com.netxforge.netxstudio.server.logic.BasePeriodLogic;
import com.netxforge.netxstudio.server.logic.LogicActivator;
import com.netxforge.netxstudio.server.service.NetxForgeService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Starts a netxforge service
 * 
 * @author Martin Taal
 */
public class ReportingService implements NetxForgeService {

	public static final String OPERATOR_PARAM = "operator";
	public static final String SERVICE_PARAM = "rfsService";
	public static final String NODE_PARAM = "node";
	public static final String NODETYPE_PARAM = "nodeType";
	public static final String START_TIME_PARAM = "startTime";
	public static final String END_TIME_PARAM = "endTime";

	public Object run(Map<String, String> parameters) {
		final ReportingRunner runner = LogicActivator.getInstance()
				.getInjector().getInstance(ReportingRunner.class);
		runner.setParameters(parameters);
		return ((AbstractCDOIDLong) runner.run()).getLongValue();
	}

	public static class ReportingRunner {
		@Inject
		@Server
		private IDataProvider dataProvider;

		private Map<String, String> parameters;

		private CDOID run() {

			final ServerWorkFlowRunMonitor monitor = createMonitor();
			CDOID id = null;
			if (parameters.containsKey(OPERATOR_PARAM)) {
				id = getCDOID(parameters.get(OPERATOR_PARAM),
						OperatorsPackage.Literals.OPERATOR);

				final CDOID finalID = id != null ? id : null;
				runOperatorService(monitor, finalID,
						getOperatorReportingLogos());

			} else if (parameters.containsKey(SERVICE_PARAM)) {
				id = getCDOID(parameters.get(SERVICE_PARAM),
						ServicesPackage.Literals.RFS_SERVICE);

				final CDOID finalID = id != null ? id : null;
				runService(monitor, finalID, getOperatorReportingLogos());

			} else if (parameters.containsKey(NODE_PARAM)) {
				id = getCDOID(parameters.get(NODE_PARAM),
						OperatorsPackage.Literals.NODE);
				NodeResourceReportingLogic reportingLogic = LogicActivator
						.getInstance().getInjector()
						.getInstance(NodeResourceReportingLogic.class);
				final CDOID finalID = id != null ? id : null;
				runForNodeOrNodeType(monitor, finalID, reportingLogic);
			} else if (parameters.containsKey(NODETYPE_PARAM)) {
				 id = getCDOID(parameters.get(NODETYPE_PARAM),LibraryPackage.Literals.NODE_TYPE);
				 NodeResourceReportingLogic reportingLogic = LogicActivator
							.getInstance().getInjector()
							.getInstance(NodeResourceReportingLogic.class);
					final CDOID finalID = id != null ? id : null;
					runForNodeOrNodeType(monitor, finalID, reportingLogic);
			} else {
				throw new IllegalArgumentException("No valid parameters found");
			}

			return monitor.getWorkFlowRunId();
		}

		private void runService(final ServerWorkFlowRunMonitor monitor,
				final CDOID finalID, final List<? extends BaseLogic> logos) {
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

					URI path = null;
					for (final BaseLogic reportingLogic : logos) {

						reportingLogic.setJobMonitor(monitor);

						if (reportingLogic instanceof BasePeriodLogic) {
							setPeriod(reportingLogic);
						}

						// Set Operator specific.
						if (reportingLogic instanceof OperatorReportingLogic) {
							if (path == null) {
								path = ((OperatorReportingLogic) reportingLogic)
										.folderURI();
							}
							Service service = (Service) reportingLogic
									.getDataProvider().getTransaction()
									.getObject(finalID);
							((OperatorReportingLogic) reportingLogic)
									.setServices(Lists.newArrayList(service));
							((OperatorReportingLogic) reportingLogic)
									.initializeStream(path);
						}

						reportingLogic.run();

					}
				};
			}.start();
		}

		private void runForNodeOrNodeType(final ServerWorkFlowRunMonitor monitor,
				final CDOID finalID,
				final NodeResourceReportingLogic reportingLogic) {
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

					URI path = null;

					reportingLogic.setJobMonitor(monitor);
					if (reportingLogic instanceof BasePeriodLogic) {
						setPeriod(reportingLogic);
					}
					
					CDOObject o = reportingLogic
							.getDataProvider().getTransaction()
							.getObject(finalID);
					
					if( o instanceof Node){
						List<Node> nodes = Lists.newArrayList((Node)o);
						reportingLogic.setNodes(nodes);
					}

					// Set Operator specific.
					if (path == null) {
						path = reportingLogic.folderURI();
					}
					reportingLogic.initializeStream(path);
					reportingLogic.run();
				};
			}.start();
		}

		private void runOperatorService(final ServerWorkFlowRunMonitor monitor,
				final CDOID finalID, final List<? extends BaseLogic> logos) {
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
					URI path = null;
					for (final BaseLogic reportingLogic : logos) {

						reportingLogic.setJobMonitor(monitor);

						if (reportingLogic instanceof BasePeriodLogic) {
							setPeriod(reportingLogic);
						}

						// Set Operator specific.
						if (reportingLogic instanceof OperatorReportingLogic) {
							if (path == null) {
								path = ((OperatorReportingLogic) reportingLogic)
										.folderURI();
							}

							Operator operator = (Operator) reportingLogic
									.getDataProvider().getTransaction()
									.getObject(finalID);
							((OperatorReportingLogic) reportingLogic)
									.setServices(operator.getServices());
							((OperatorReportingLogic) reportingLogic)
									.initializeStream(path);
						}
						reportingLogic.run();
					}
				}
			}.start();
		}

		private void setPeriod(final BaseLogic reportingLogic) {
			Date start = getStartTime(parameters);
			Date end = getEndTime(parameters);
			((BasePeriodLogic) reportingLogic).setStartTime(start);
			((BasePeriodLogic) reportingLogic).setEndTime(end);
		};

		/*
		 * 
		 * Possibly extract to a more generic place.
		 * 
		 * @return
		 */

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
			dataProvider.openSession();
			dataProvider.getTransaction();
			final Resource res = dataProvider
					.getResource(SchedulingPackage.Literals.WORK_FLOW_RUN);

			final WorkFlowRun wfRun = SchedulingFactory.eINSTANCE
					.createComponentWorkFlowRun();
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

	public static List<OperatorReportingLogic> getOperatorReportingLogos() {
		List<OperatorReportingLogic> logos = Lists.newArrayList();

		logos.add(LogicActivator.getInstance().getInjector()
				.getInstance(RFSServiceSummaryReportingLogic.class));
		logos.add(LogicActivator.getInstance().getInjector()
				.getInstance(RFSServiceDashboardReportingLogic.class));
		logos.add(LogicActivator.getInstance().getInjector()
				.getInstance(RFSServiceUserReportingLogic.class));
		logos.add(LogicActivator.getInstance().getInjector()
				.getInstance(RFSServiceResourceReportingLogic.class));

		// logos.add(LogicActivator.getInstance().getInjector()
		// .getInstance(RFSServiceDistributionReportingLogic.class));
		return logos;
	}

}
