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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.data.Server;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;
import com.netxforge.netxstudio.server.logic.BaseLogic;
import com.netxforge.netxstudio.server.logic.BasePeriodLogic;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.server.service.NetxForgeService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Starts a netxforge service
 * 
 * @author Martin Taal
 */
public class ReportingService implements NetxForgeService {

	@Inject
	private static ModelUtils modelUtils;

	public static final String NETWORK_OPERATOR_PARAM = "operator";
	public static final String NETWORK_SERVICE_PARAM = "rfsService";
	public static final String NODE_PARAM = "node";
	public static final String NODETYPE_PARAM = "nodeType";
	public static final String START_TIME_PARAM = "startTime";
	public static final String END_TIME_PARAM = "endTime";

	public Object run(Map<String, String> parameters) {
		final ReportingRunner runner = LogicActivator.getInstance()
				.getInjector().getInstance(ReportingRunner.class);
		runner.setParameters(parameters);
		CDOID run = runner.run();
		return modelUtils.cdoLongIDAsString(run);
	}

	public static class ReportingRunner {
		@Inject
		@Server
		private IData dataProvider;

		private Map<String, String> parameters;

		private CDOID run() {

			final ServerWorkFlowRunMonitor monitor = createMonitor();

			// For a node type in an Operator or Service.
			if (parameters.containsKey(NODETYPE_PARAM)) {

				CDOID nodeTypeID = modelUtils.cdoLongIDFromString(
						LibraryPackage.Literals.NODE_TYPE,
						parameters.get(NODETYPE_PARAM));

				if (parameters.containsKey(NETWORK_OPERATOR_PARAM)) {

					CDOID operatorID = modelUtils.cdoLongIDFromString(
							OperatorsPackage.Literals.OPERATOR,
							parameters.get(NETWORK_OPERATOR_PARAM));

					runForOperator(monitor, operatorID, nodeTypeID,
							getOperatorReportingLogos());
				}

				if (parameters.containsKey(NETWORK_SERVICE_PARAM)) {
					CDOID serviceID = modelUtils.cdoLongIDFromString(
							ServicesPackage.Literals.RFS_SERVICE,
							parameters.get(NETWORK_SERVICE_PARAM));

					runForService(monitor, serviceID, nodeTypeID,
							getOperatorReportingLogos());
				}

			} else
			// For all Services from an operator.
			if (parameters.containsKey(NETWORK_OPERATOR_PARAM)) {
				CDOID operatorID = modelUtils.cdoLongIDFromString(
						OperatorsPackage.Literals.OPERATOR,
						parameters.get(NETWORK_OPERATOR_PARAM));
				runForOperator(monitor, operatorID, getOperatorReportingLogos());

			}
			// For a single Service.
			else if (parameters.containsKey(NETWORK_SERVICE_PARAM)) {
				CDOID serviceID = modelUtils.cdoLongIDFromString(
						ServicesPackage.Literals.RFS_SERVICE,
						parameters.get(NETWORK_SERVICE_PARAM));
				runForService(monitor, serviceID, getOperatorReportingLogos());

			}
			// For a Single Node.
			else if (parameters.containsKey(NODE_PARAM)) {
				CDOID nodeID = modelUtils.cdoLongIDFromString(
						OperatorsPackage.Literals.NODE,
						parameters.get(NODE_PARAM));
				NodeResourceReportingLogic reportingLogic = LogicActivator
						.getInstance().getInjector()
						.getInstance(NodeResourceReportingLogic.class);
				runForNodeOrNodeType(monitor, nodeID, reportingLogic);
			}

			else {
				throw new IllegalArgumentException("No valid parameters found");
			}

			return monitor.getWorkFlowRunId();
		}

		private void runForService(final ServerWorkFlowRunMonitor monitor,
				final CDOID serviceID, final List<? extends BaseLogic> logos) {
			this.runForService(monitor, serviceID, null, logos);
		}

		private void runForService(final ServerWorkFlowRunMonitor monitor,
				final CDOID serviceID, final CDOID nodeTypeID,
				final List<? extends BaseLogic> logos) {
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
									.getData().getTransaction()
									.getObject(serviceID);

							((OperatorReportingLogic) reportingLogic)
									.setServices(Lists.newArrayList(service));

							// Set an optional NodeType filter.
							if (nodeTypeID != null) {
								NodeType nt = (NodeType) reportingLogic
										.getData().getTransaction()
										.getObject(nodeTypeID);

								((OperatorReportingLogic) reportingLogic)
										.setNodeTypeAcceptor(Lists
												.newArrayList(nt));
							}

							((OperatorReportingLogic) reportingLogic)
									.initializeStream(path);
						}

						reportingLogic.run();

					}
				};
			}.start();
		}

		private void runForNodeOrNodeType(
				final ServerWorkFlowRunMonitor monitor, final CDOID finalID,
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

					CDOObject o = reportingLogic.getData()
							.getTransaction().getObject(finalID);

					if (o instanceof Node) {
						List<Node> nodes = Lists.newArrayList((Node) o);
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

		private void runForOperator(final ServerWorkFlowRunMonitor monitor,
				final CDOID finalID, final List<? extends BaseLogic> logos) {
			this.runForOperator(monitor, finalID, null, logos);
		}

		private void runForOperator(final ServerWorkFlowRunMonitor monitor,
				final CDOID operatorID, final CDOID nodeTypeID,
				final List<? extends BaseLogic> logos) {
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
									.getData().getTransaction()
									.getObject(operatorID);
							((OperatorReportingLogic) reportingLogic)
									.setServices(operator.getServices());

							// Set an optional NodeType filter.
							if (nodeTypeID != null) {
								NodeType nt = (NodeType) reportingLogic
										.getData().getTransaction()
										.getObject(nodeTypeID);

								((OperatorReportingLogic) reportingLogic)
										.setNodeTypeAcceptor(Lists
												.newArrayList(nt));
							}

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
			((BasePeriodLogic) reportingLogic).setBeginTime(start);
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
