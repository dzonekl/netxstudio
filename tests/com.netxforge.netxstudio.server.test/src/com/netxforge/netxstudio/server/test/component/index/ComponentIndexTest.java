package com.netxforge.netxstudio.server.test.component.index;

import junit.framework.Assert;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.ecore.EClass;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.data.index.ComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

/**
 * @author Christophe Bouhier
 * 
 */
public class ComponentIndexTest extends AbstractInjectedTestJUnit4 {

	@Inject
	private IComponentMappingIndex index;

	@Inject
	private ModelUtils modelUtils;

	@Inject
	private IData provider;

	// TEST NETWORK, Freely create, change etc.. nodes, functions etc..
	private static String TESTNETWORK_OID = "2636154";

	@Before
	public void before() {
		getClientInjector().injectMembers(this);
	}

	@Test
	public void testIndex() throws Exception {

		provider.openSession("admin", "admin");

		((ComponentMappingIndex) index).setDataProvider(provider);

		long nanoTime = System.nanoTime();
		System.out.println("creating index");
		// Build the index.
		index.buildIndex();

		// Wait...
		waitForIndexing();

		System.out.println("index creation took "
				+ modelUtils.timeDurationNanoFromStart(nanoTime));

		int size = index.size();

		CDOID cdoIDFor = cdoIDFor(OperatorsPackage.Literals.NODE,
				TESTNETWORK_OID);
		
		Network network = (Network) provider.getTransaction().getObject(
				cdoIDFor);

		NodeType createNodeType = LibraryFactory.eINSTANCE.createNodeType();
		createNodeType.setName("testNodeType");
		
		// Should not affect the
		Node newNode = newNode(network, createNodeType, "testNode");

		provider.commitTransaction();

		// Wait...
		waitForIndexing();

		// Adding a node should not increase the size, 
		// because no resources can be added to a node alone, 
		// components are needed. 
		Assert.assertEquals(size, index.size());

		Equipment newEquipment = newEquipment(newNode, "testEq1", "testCode1");
		provider.commitTransaction();
		
		// Wait...
		waitForIndexing();
		
		Assert.assertEquals(size + 1, index.size());
		
		removeEquipment(newNode, newEquipment);
		removeNode(network, newNode);
//		nodeTypeResource.getContents().remove(createNodeType);
//		nodeTypeResource.save(null);
		provider.commitTransactionThenClose();
		provider.closeSession();

	}

	/**
	 * 
	 */
	private void waitForIndexing() {
		while (index.isIndexing()) {
			try {
				System.out.println("indexing...");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private Node newNode(Network n, NodeType nt, String string) {

		Node createNode = OperatorsFactory.eINSTANCE.createNode();
		createNode.setNodeID(string);
		createNode.setNodeType(nt);

		n.getNodes().add(createNode);
		return createNode;
	}

	private void removeNode(Network n, Node node) {
		n.getNodes().remove(node);
	}

	private Equipment newEquipment(CDOObject parent, String name, String code) {

		Equipment createEquipment = LibraryFactory.eINSTANCE.createEquipment();
		createEquipment.setName(name);
		createEquipment.setEquipmentCode(code);

		if (parent instanceof Equipment) {
			((Equipment) parent).getEquipments().add(createEquipment);
		} else if (parent instanceof Node) {
			Node n = (Node) parent;
			n.getNodeType().getEquipments().add(createEquipment);
		}
		return createEquipment;
	}

	private void removeEquipment(CDOObject parent, Equipment eq) {
		if (parent instanceof Equipment) {
			((Equipment) parent).getEquipments().remove(eq);
		} else if (parent instanceof Node) {
			Node n = (Node) parent;
			n.getNodeType().getEquipments().remove(eq);
		}
	}

	public CDOID cdoIDFor(EClass eclass, String string) {
		return CDOIDUtil.createLong(Long.parseLong(string));
	}

	/**
	 * 
	 */
	private IdentifierDataKind nodeIDK() {
		IdentifierDataKind idk = MetricsFactory.eINSTANCE
				.createIdentifierDataKind();
		// Set the default identifier.
		idk.setObjectKind(ObjectKindType.NODE);
		idk.setObjectProperty(ModelUtils.NODE_ID);
		return idk;
	}

	private IdentifierDataKind functionIDK(String property) {
		IdentifierDataKind idk = MetricsFactory.eINSTANCE
				.createIdentifierDataKind();
		// Set the default identifier.
		idk.setObjectKind(ObjectKindType.FUNCTION);
		idk.setObjectProperty(property);
		return idk;
	}

	@SuppressWarnings("unused")
	private IdentifierDataKind equipmentIDK(String property) {
		IdentifierDataKind idk = MetricsFactory.eINSTANCE
				.createIdentifierDataKind();
		// Set the default identifier.
		idk.setObjectKind(ObjectKindType.EQUIPMENT);
		idk.setObjectProperty(property);
		return idk;
	}

}
