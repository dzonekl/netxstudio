package com.netxforge.netxstudio.screens.editing.test;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Warehouse;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.test.internal.TestInjector;

public class TestEditingCases {

	private static final String OPERATION_DECOMMISSION = "Decommission";

	private static final String METRICSOURCE_TEST = "MetricSource Test";

	private static final String NETWORK_TEST = "Network Test";
	private static final String OPERATOR_TEST = "Operator Test";
	private static final String NODE_TEST = "Node Test";
	@SuppressWarnings("unused")
	private static final String NODETYPE_TEST = "NodeType Test";
	private static final String WAREHOUSE_TEST = "Warehouse Test";
	private static final String NETXRESOURCE_TEST = "RESTest";

	IEditingService editingService;
	ModelUtils modelUtils;

	private Node greenNode;

	@Before
	public void runBeforeEveryTest() {
		TestInjector testInjector = new TestInjector();
		editingService = testInjector.getInjector().getInstance(
				IEditingService.class);

		modelUtils = testInjector.getInjector().getInstance(ModelUtils.class);
	}

	@After
	public void runAfterEveryTest() {

	}

	@Test
	public void testEditingService() {
		Assert.assertNotNull(editingService != null);
	}

//	@Test
	public void testAdminOperations() {

		connect();
		this.buildSampleMetricSourceAndJob();
		commit();

		this.removeSampleMetricSourceAndJob();
		commit();
		close();
	}
	
	@Test
	public void testNetXResource() {

		connect();
		this.buildSampleNetXResource();
		commit();

		this.removeSamplNetXResource();
		commit();
		close();
	}
	
	
	
	private void removeSamplNetXResource() {
		
		Resource resource = editingService.getDataService().getProvider().getResource(editingService.getEditingDomain()
								.getResourceSet(), "/Node_/netxresource_test");
		try {
			resource.delete(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void buildSampleNetXResource() {
		NetXResource createNetXResource = LibraryFactory.eINSTANCE.createNetXResource();
		createNetXResource.setShortName(NETXRESOURCE_TEST);
		createNetXResource.setExpressionName(NETXRESOURCE_TEST);
		createNetXResource.setLongName(NETXRESOURCE_TEST);
		
		final Resource resourcesResource = editingService
				.getDataService()
				.getProvider()
				.getResource(
						editingService.getEditingDomain()
								.getResourceSet(),
						"/Node_/netxresource_test");
		resourcesResource.getContents().add(createNetXResource);
	}

	// @Test
	public void testDesignOperations() {

		// Create the test model and commit.
		connect();
		// Simulate creation.
		this.buildSampleOperator();
		this.buildSampleWarehouse();
		commit();

		// Decommission a node and commit.
		this.simulateOperation(OPERATION_DECOMMISSION);

		// Simulate deletion.
		this.removeSampleOperator();
		this.removeSampleWarehouse();
		commit();
		close();

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
					wh.getNodes().add(greenNode); // Should move it away from
													// the containment
													// elsewhere.
				}
			}
			commit();
		}
	}

	private void connect() {
		editingService.getDataService().getProvider()
				.openSession("admin", "admin");
	}

	private void commit() {
		// Simulate save.
		if (editingService.isDirty()) {
			editingService.doSave(null);
		}
	}

	private void close() {
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

	/**
	 * 
	 * JobContainer -> Job -> MetricSource. Deleting MetricSource, should ask to
	 * delete the Job as well....
	 * 
	 */
	private void buildSampleMetricSourceAndJob() {

		Resource metricSourceRes = editingService
				.getData(MetricsPackage.Literals.METRIC_SOURCE);

		MetricSource createMetricSource = this
				.createMetricSource(metricSourceRes);
		createMetricSource.setName(METRICSOURCE_TEST);

		Resource jobResource = editingService
				.getData(SchedulingPackage.Literals.JOB);

		// Do we have this job?
		Job job = modelUtils.jobForMultipleObjects(jobResource,
				SchedulingPackage.Literals.METRIC_SOURCE_JOB,
				SchedulingPackage.Literals.METRIC_SOURCE_JOB__METRIC_SOURCES,
				Lists.newArrayList(createMetricSource));

		if (job == null) {
			// Create the job and add the metric source.
			job = SchedulingFactory.eINSTANCE.createMetricSourceJob();
			job.setName(METRICSOURCE_TEST);
			job.setJobState(JobState.IN_ACTIVE);
			job.setStartTime(modelUtils.toXMLDate(modelUtils.tomorrow()));
			((MetricSourceJob) job).getMetricSources().addAll(
					Lists.newArrayList(createMetricSource));
			jobResource.getContents().add(job);
		}

		// Simulate a JobContainer for this job.
		Resource jrcResource = editingService
				.getData(SchedulingPackage.Literals.JOB_RUN_CONTAINER);

		JobRunContainer container = SchedulingFactory.eINSTANCE
				.createJobRunContainer();
		container.setJob(job);
		jrcResource.getContents().add(container);

		// Potentially add some workflow runs to the container.
	}

	private void removeSampleMetricSourceAndJob() {

		Resource jobResource = editingService
				.getData(SchedulingPackage.Literals.JOB);
		Resource jobRunContainerResource = editingService
				.getData(SchedulingPackage.Literals.JOB_RUN_CONTAINER);
		
		List<Job> jobsToDelete = Lists.newArrayList();
		List<JobRunContainer> jobRunContainersToDelete = Lists.newArrayList();
		for (Object o : jobResource.getContents()) {
			if (o instanceof Job
					&& ((Job) o).getName().equals(METRICSOURCE_TEST)) {
				
				Job job = (Job) o;
				// find our jobcontainer .
				for (final EObject eObject : jobRunContainerResource
						.getContents()) {
					final JobRunContainer container = (JobRunContainer) eObject;
					final Job containerJob = container.getJob();
					final CDOID containerJobId = ((CDOObject) containerJob)
							.cdoID();
					if (job.cdoID().equals(containerJobId)) {
						jobRunContainersToDelete.add(container);
						break;
					}
				}
				jobsToDelete.add((Job) o);
			}
		}

		for (JobRunContainer j : jobRunContainersToDelete) {
			jobRunContainerResource.getContents().remove(j);
		}
		
		for (Job j : jobsToDelete) {
			jobResource.getContents().remove(j);
		}
		
		Resource metricSourceRes = editingService
				.getData(MetricsPackage.Literals.METRIC_SOURCE);
		List<MetricSource> metricsourcesToDelete = Lists.newArrayList();
		for (Object o : metricSourceRes.getContents()) {
			if (o instanceof MetricSource
					&& ((MetricSource) o).getName().equals(METRICSOURCE_TEST)) {
				metricsourcesToDelete.add((MetricSource) o);
			}
		}
		for (MetricSource ms : metricsourcesToDelete) {
			metricSourceRes.getContents().remove(ms);
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

	// / ADMIN

	private MetricSource createMetricSource(Resource res) {
		return (MetricSource) this.createObjectAddToParentList(
				res.getContents(), MetricsPackage.Literals.METRIC_SOURCE);
	}

	// / DESIGN

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

	@SuppressWarnings("unused")
	private NodeType createNodeType(Resource res) {
		return (NodeType) this.createObjectAddToParentList(res.getContents(),
				LibraryPackage.Literals.NODE_TYPE);
	}

	@SuppressWarnings({ "rawtypes", "unused" })
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
