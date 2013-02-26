/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.netxstudio.server.test.job;

import java.util.Collections;
import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.server.test.AbstractInjectedTestJUnit3;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServicesFactory;

/**
 * FIXME, Should target test repository.
 * 
 * @author Christophe Bouhier
 * 
 */
public class ServiceJobTest extends AbstractInjectedTestJUnit3 {

	private static final String RFS_NAME = "Speech";
	private static final String OPERATOR_NAME = "tmnl";

	@Inject
	private IDataProvider dataProvider;
	@Inject
	private ModelUtils modelUtils;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		super.getInjector().injectMembers(this);
		dataProvider.openSession("admin", "admin");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		dataProvider.closeSession();
	}

	/**
	 * @throws Exception
	 */
	public void testServiceJob() throws Exception {
		dataProvider.getTransaction();
		this.createModelData();
		dataProvider.commitTransactionThenClose();
	}

	private RFSService createModelData() throws Exception {
		
		final Resource operatorsResource = dataProvider
				.getResource(OperatorsPackage.Literals.OPERATOR);
		
		
		
		Operator op = null;
		for (final EObject eObject : operatorsResource.getContents()) {
			if (eObject instanceof Operator && ((Operator) eObject).getName().equals(OPERATOR_NAME)){
				op = (Operator) eObject;
			}
		}

		if( op == null){
			op = OperatorsFactory.eINSTANCE.createOperator();
			op.setName(OPERATOR_NAME);
			operatorsResource.getContents().add(op);
		}
		
		for( Service s : op.getServices()){
			if( ((RFSService) s).getServiceName().equals(RFS_NAME)) {
				return (RFSService)s;
			}
		}
		
		final RFSService rfsService = ServicesFactory.eINSTANCE.createRFSService();
		rfsService.setServiceName(RFS_NAME);
		
		final Node node = OperatorsFactory.eINSTANCE.createNode();
		rfsService.getNodes().add(node);
		
		op.getServices().add(rfsService);
		
		// Add some objects, which are referable from our xtext model.
		final Resource libraryResource = dataProvider
				.getResource(LibraryPackage.Literals.LIBRARY);
		
		if (libraryResource.getContents().isEmpty()) {
			final Library lib = LibraryFactory.eINSTANCE.createLibrary();
			libraryResource.getContents().add(lib);
		}
		final Library lib = (Library) libraryResource.getContents().get(0);
		
		final NodeType sgsnType = LibraryFactory.eINSTANCE.createNodeType();
		node.setOriginalNodeTypeRef(sgsnType);
		node.setNodeID("SGSN");
		
		final Function sgsnFunction = LibraryFactory.eINSTANCE.createFunction();
		sgsnFunction.setName("SGSN");
		sgsnType.getFunctions().add(sgsnFunction);

		lib.getNodeTypes().add(sgsnType);

		node.setNodeType(sgsnType);
		
		final Network network = OperatorsFactory.eINSTANCE.createNetwork();
		network.setName("test");
		network.getNodes().add(node);
		
		op.getNetworks().add(network);

		final NetXResource sgsnRes = LibraryFactory.eINSTANCE
				.createNetXResource();
		final MetricValueRange range = MetricsFactory.eINSTANCE
				.createMetricValueRange();
		sgsnRes.getMetricValueRanges().add(range);

		sgsnFunction.getResourceRefs().add(sgsnRes);

		final Value v = GenericsFactory.eINSTANCE.createValue();
		v.setValue(2.0);
		v.setTimeStamp(modelUtils.toXMLDate(modelUtils.yesterday()));

		final Value v1 = GenericsFactory.eINSTANCE.createValue();
		v1.setValue(2.1);
		v1.setTimeStamp(modelUtils.toXMLDate(modelUtils.twoDaysAgo()));

		final Value v2 = GenericsFactory.eINSTANCE.createValue();
		v2.setValue(2.1);
		v2.setTimeStamp(modelUtils.toXMLDate(modelUtils.threeDaysAgo()));

		range.getMetricValues().addAll(ImmutableList.of(v, v1, v2));


		final RFSServiceMonitoringJob job = SchedulingFactory.eINSTANCE.createRFSServiceMonitoringJob();
		job.setRFSService(rfsService);
		job.setStartTime(modelUtils.toXMLDate(new Date(System.currentTimeMillis() + 6000)));
		job.setInterval(60);
		job.setName(rfsService.getServiceName());
		
		final Resource serviceJob = dataProvider.getResource(SchedulingPackage.Literals.JOB);
		serviceJob.getContents().add(job);
		
		// Save the resources. 
		libraryResource.save(Collections.emptyMap());
		operatorsResource.save(Collections.emptyMap());
		serviceJob.save(Collections.emptyMap());
		
		return rfsService;
	}
}
