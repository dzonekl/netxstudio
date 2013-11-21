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
package com.netxforge.netxstudio.server.reporting;

import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.server.logic.BasePeriodLogic;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.server.logic.reporting.ReportingEngine;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;

/**
 * Performs the resource monitoring logic execution for a RFSService. </br>
 * 
 * The emitting logic executes the write operations in the following order:
 * <ul>
 * 	<li>getServicesToExecuteFor</li>
 * 	<li>	=> e.nextPage</li>
 * 	<li>	=> e.writeHeader</li>
 * 	<li>	=> processServiceUser(service)</li>
 *  <li>	=> processNodesByNodeType(service)</li>
 *   <li>	=> e.writeFinal</li>
 * </ul>
 * 
 * 
 * Note:</br> This format is rather fixed for chunks to write and the
 * corresponding dataset, as we are migrating the existing report system to use
 * composition and injection. </br>
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class EmittingLogic extends BasePeriodLogic {

	private ReportingEngine engine;

	@Inject
	private IStreamProducer producer;

	private List<NodeType> nodeTypeAcceptor;

	private static final IReportEmitter NULLEMITTER = new InternalEmitter();

	// Our emitter.
	private IReportEmitter emitter;

	/**
	 * An Emitting engine.
	 * 
	 * @author Christophe
	 */
	protected static class InternalEmitter implements IReportEmitter {
		@Inject
		private ModelUtils modelUtils;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.netxforge.netxstudio.server.reporting.IInternalEmitter#activate()
		 */
		public void activate(IData dataProvider) {
			System.out.println(">>activate()");
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.netxforge.netxstudio.server.reporting.IInternalEmitter#writeHeader
		 * (com.netxforge.netxstudio.generics.DateTimeRange)
		 */
		public void writeHeader(DateTimeRange dtr) {
			System.out.println(">>writeHeader()"
					+ modelUtils.periodToString(dtr));
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.netxforge.netxstudio.server.reporting.IInternalEmitter#writeContent
		 * (com.netxforge.netxstudio.library.NodeType)
		 */
		public void writeContent(NodeType nodeType) {
			System.out.println(">>writeContent()");
			System.out.println(modelUtils.printModelObject(nodeType));

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.netxforge.netxstudio.server.reporting.IInternalEmitter#writeContent
		 * (com.netxforge.netxstudio.services.Service,
		 * com.netxforge.netxstudio.operators.Node, int, int)
		 */
		public void writeContent(Service service, Node node, int rowIndex,
				int columnIndex) {
			System.out.println(">>writeContent() (" + rowIndex + ","
					+ columnIndex + ")");
			System.out.println(modelUtils.printModelObject(service));
			System.out.println(modelUtils.printModelObject(node));

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.netxforge.netxstudio.server.reporting.IInternalEmitter#writeContent
		 * (com.netxforge.netxstudio.services.Service,
		 * com.netxforge.netxstudio.services.ServiceUser, int, int)
		 */
		public void writeContent(Service service, ServiceUser serviceUser,
				int rowIndex, int columnIndex) {
			System.out.println(">>writeContent() (" + rowIndex + ","
					+ columnIndex + ")");
			System.out.println(modelUtils.printModelObject(service));
			System.out.println(modelUtils.printModelObject(serviceUser));
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.netxforge.netxstudio.server.reporting.IInternalEmitter#writeContent
		 * (com.netxforge.netxstudio.library.Component)
		 */
		public void writeContent(Component component) {
			System.out.println(">>writeContent()");
			System.out.println(modelUtils.printModelObject(component));
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.netxforge.netxstudio.server.reporting.IInternalEmitter#writeFinal
		 * ()
		 */
		public void writeFinal() {
			System.out.println(">>writeFinal()");
		}

		public String getExtension() {
			return "";
		}

		public void nextPage(String serviceName) {
			System.out.println(">>nextPage()");
		}

		public String getReportName() {
			return "System.out";
		}

		public void flush(OutputStream stream) {
			System.out.println(">>flush()");
		}

	}

	/**
	 * Clients should implement.
	 * 
	 * @return
	 */
	protected abstract List<Service> getServicesToExecuteFor();

	/**
	 * Clients should implement.
	 * 
	 * @param service
	 * @return
	 */
	protected abstract List<NodeType> getNodeTypesToExecuteFor(
			RFSService service);

	@Override
	protected ReportingEngine getEngine() {
		if (engine == null) {
			engine = LogicActivator.getInstance().getInjector()
					.getInstance(ReportingEngine.class);
		}
		return engine;
	}

	public List<NodeType> getNodeTypeAcceptor() {
		return nodeTypeAcceptor;
	}

	public void setNodeTypeAcceptor(List<NodeType> nodeTypeAcceptor) {
		this.nodeTypeAcceptor = nodeTypeAcceptor;
	}

	protected void doRun() {

		// Set the emitter, if none is set. 
		if (emitter == null) {
			emitter = NULLEMITTER;
		}
		
		producer.setSettings(getSettings());

		// initialize our stream producer
		producer.initializeStream(emitter, getBeginTime(), getEndTime(),
				emitter.getExtension());

		emitter.activate(this.getData());

		// start a transaction.
		this.getData().getTransaction();

		final List<Service> allServices = this.getServicesToExecuteFor();

		getJobMonitor().setTotalWork(allServices.size());
		getJobMonitor().setTask("Performing reporting");

		for (Service service : allServices) {
			if (service instanceof RFSService) {

				emitter.nextPage(service.getServiceName());

				// WRITE EMMITTER.
				emitter.writeHeader(getPeriod());

				processServiceUser(service);

				// PROCESS NODES BY NODE TYPE.
				processNodesByNodeType(service);

				emitter.writeFinal();
			}

		}

		getJobMonitor().updateFailures(this.getFailures());

		emitter.flush(producer.getStream());

		this.getData().commitTransactionThenClose();
		this.getData().closeSession();
	}

	protected void processServiceUser(Service service) {
		// Do Nothing Implementation.
	}

	protected void processNodesByNodeType(Service service) {
		List<NodeType> nodeTypes = this
				.getNodeTypesToExecuteFor((RFSService) service);

		List<NodeType> uniqueNodeTypes = this.getModelUtils().uniqueNodeTypes(
				nodeTypes);

		int nodeTypeCount = 0;
		for (final NodeType nodeType : uniqueNodeTypes) {

			getJobMonitor().appendToLog(
					"reporting for node type" + nodeType.getName());

			getJobMonitor().setTask("Resource reporting Data for nodeType");

			// EXCEL WRITE
			emitter.writeContent(nodeType);

			if (nodeType.eIsSet(LibraryPackage.Literals.NODE_TYPE__NAME)) {
				// Output only the one matching nt.
				int nodeCount = 0;
				for (NodeType nt : nodeTypes) {

					if (nt.eIsSet(LibraryPackage.Literals.NODE_TYPE__NAME)
							&& nt.getName().equals(nodeType.getName())) {
						// EXCEL WRITE
						// nodeCount = row, nodeTypeCount = column.
						emitter.writeContent(service, (Node) nt.eContainer(),
								nodeCount, nodeTypeCount);

						// EXCEL WRITE, DELEGATED TO ENGINE
						// OPTIONAL FOR SOME REPORTS....
						processNode(nt);
						nodeCount++;
					}

				}
			} else {
				getJobMonitor().appendToLog(
						"skipping node type" + nodeType.getName()
								+ ", Node Type name is not set!");
			}

			nodeTypeCount++;
		}
	}

	/**
	 * Clients should override to avoid walking the NodeType Hierarchy if not
	 * required.
	 * 
	 * @param sheet
	 * @param nodeType
	 */
	protected void processNode(NodeType nodeType) {
		int cnt = 0;

		// FUNCTIONS
		for (Function fu : nodeType.getFunctions()) {
			processFunction(fu);
			getJobMonitor().incrementProgress(0, (cnt++ % 10) == 0);
		}
		// EQUIPMENTS
		for (Equipment eq : nodeType.getEquipments()) {
			processEquipment(eq);
			getJobMonitor().incrementProgress(0, (cnt++ % 10) == 0);
		}
	}

	/*
	 * Iterates through hierarchy and produce the component output.
	 */
	protected void processEquipment(Equipment eq) {
		this.getJobMonitor().setTask("Reporting for " + eq.getName());
		// TODO set total work correctly.
		this.getJobMonitor().incrementProgress(1, false);
		emitter.writeContent(eq);
		for (Equipment child : eq.getEquipments()) {
			processEquipment(child);
		}
	}

	/*
	 * Iterates through hierarchy and produce the component output.
	 */
	protected void processFunction(Function fu) {
		this.getJobMonitor().setTask("Reporting for " + fu.getName());
		// TODO set total work correctly.
		this.getJobMonitor().incrementProgress(1, false);
		emitter.writeContent(fu);
		for (Function child : fu.getFunctions()) {
			processFunction(child);
		}
	}

	public IReportEmitter getEmitter() {
		return emitter;
	}

	public void setEmitter(IReportEmitter emitter) {
		this.emitter = emitter;
	}

}
