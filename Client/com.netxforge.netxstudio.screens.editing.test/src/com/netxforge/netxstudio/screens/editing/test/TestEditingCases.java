package com.netxforge.netxstudio.screens.editing.test;

import java.util.Collection;

import junit.framework.Assert;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Warehouse;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.test.internal.TestInjector;

public class TestEditingCases {

	private static final String OPERATION_DECOMMISSION = "Decommission";

	private static final String NETWORK_TEST = "Network Test";
	private static final String OPERATOR_TEST = "Operator Test";
	private static final String NODE_TEST = "Node Test";
	private static final String NODETYPE_TEST = "NodeType Test";
	private static final String WAREHOUSE_TEST = "Warehouse Test";

	IEditingService editingService;

	private Node greenNode;

	@Before
	public void runBeforeEveryTest() {
		TestInjector testInjector = new TestInjector();
		editingService = testInjector.getInjector().getInstance(
				IEditingService.class);
	}

	@After
	public void runAfterEveryTest() {

	}

	@Test
	public void testEditingService() {
		Assert.assertNotNull(editingService != null);
	}

	@Test
	public void testOperations() {
		
		// Create the test model and commit. 
		testModelSetup();
		
		// Decommission a node and commit.  
		this.simulateOperation(OPERATION_DECOMMISSION);
		
		// Tear down the test model and commit. 
		testModelTearDown();
	}

	private void simulateOperation(String operation) {

		if (operation.equals(OPERATION_DECOMMISSION)) {
			this.op_Decommission();

		}
	}

	// Operations.
	private void op_Decommission() {
		// Move an object from an operator to the warehouse.
		// Get the object to move.

		if (this.greenNode != null
				&& this.greenNode.cdoState() == CDOState.CLEAN) {
			Resource wareHouseRes = editingService
					.getData(OperatorsPackage.Literals.WAREHOUSE);
			for (EObject eo : wareHouseRes.getContents()) {
				if (eo instanceof Warehouse
						&& ((Warehouse) eo).getName().equals(WAREHOUSE_TEST)) {
					Warehouse wh = (Warehouse) eo;
					wh.getNodes().add(greenNode); // Should move it away from the containment elsewhere. 
				}
			}
			if (editingService.isDirty()) {
				editingService.doSave(null);
			}
		}
	}

	private void testModelSetup() {
		editingService.getDataService().getProvider()
				.openSession("admin", "admin");

		// Simulate creation.
		this.buildSampleOperator();
		this.buildSampleWarehouse();

		// Simulate save.
		if (editingService.isDirty()) {
			editingService.doSave(null);
		}
	}

	private void testModelTearDown() {
		// Simulate deletion.
		this.removeSampleOperator();
		this.removeSampleWarehouse();

		// Simulate save
		if (editingService.isDirty()) {
			editingService.doSave(null);
		}

		// Dispose (Close the transaction and the session).
		editingService.disposeData();
		editingService.getDataService().getProvider().closeSession();
	}

	private void buildSampleOperator() {

		Resource operatorRes = editingService
				.getData(OperatorsPackage.Literals.OPERATOR);

		Operator createOperator = this.createOperator(operatorRes);
		createOperator.setName(OPERATOR_TEST);

		Network createNetwork = this.createNetwork(createOperator);
		createNetwork.setName(NETWORK_TEST);

		{
			Node createNode = this.createNode(createNetwork);
			createNode.setNodeID(NODE_TEST + " blue");
		}
		{
			Node createNode = this.createNode(createNetwork);
			createNode.setNodeID(NODE_TEST + " orange");
		}
		{
			greenNode = this.createNode(createNetwork);
			greenNode.setNodeID(NODE_TEST + " green");
		}
	}

	private void removeSampleOperator() {

		Resource operatorRes = editingService
				.getData(OperatorsPackage.Literals.OPERATOR);

		EList<EObject> contents = operatorRes.getContents();
		EObject toRemove = null;
		for (EObject eo : contents) {
			if (eo instanceof Operator) {
				if (((Operator) eo).getName().equals(OPERATOR_TEST)) {
					toRemove = eo;
				}
			}
		}
		// Removes the containment objects.
		if (toRemove != null) {
			contents.remove(toRemove);
		}
	}

	private void buildSampleWarehouse() {
		Resource wareHouseRes = editingService
				.getData(OperatorsPackage.Literals.WAREHOUSE);
		Warehouse createWarehouse = this.createWarehouse(wareHouseRes);
		createWarehouse.setName(WAREHOUSE_TEST);
	}

	private void removeSampleWarehouse() {

		Resource warehouseRes = editingService
				.getData(OperatorsPackage.Literals.WAREHOUSE);

		EList<EObject> contents = warehouseRes.getContents();
		EObject toRemove = null;
		for (EObject eo : contents) {
			if (eo instanceof Warehouse) {
				if (((Warehouse) eo).getName().equals(WAREHOUSE_TEST)) {
					toRemove = eo;
				}
			}
		}
		// Removes the containment objects.
		if (toRemove != null) {
			contents.remove(toRemove);
		}
	}

	private Operator createOperator(Resource res) {
		return (Operator) this.createObjectAddToParentList(res.getContents(),
				OperatorsPackage.Literals.OPERATOR);
	}

	private Network createNetwork(Operator parent) {
		return (Network) this.createObjectAddToParentList(parent.getNetworks(),
				OperatorsPackage.Literals.NETWORK);
	}

	private Warehouse createWarehouse(Resource res) {
		return (Warehouse) this.createObjectAddToParentList(res.getContents(),
				OperatorsPackage.Literals.WAREHOUSE);
	}

	private Node createNode(Network parent) {
		return (Node) this.createObjectAddToParentList(parent.getNodes(),
				OperatorsPackage.Literals.NODE);
	}

	private NodeType createNodeType(Resource res) {
		return (NodeType) this.createObjectAddToParentList(res.getContents(),
				LibraryPackage.Literals.NODE_TYPE);
	}

	private Function createFunction(Collection collection) {
		return (Function) this.createObjectAddToParentList(collection,
				LibraryPackage.Literals.FUNCTION);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private EObject createObjectAddToParentList(Collection collection,
			EClass eClass) {
		EObject create = EcoreUtil.create(eClass);
		collection.add(create);
		return create;
	}

}
