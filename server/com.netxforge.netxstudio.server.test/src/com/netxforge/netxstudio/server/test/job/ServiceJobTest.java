/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.netxstudio.server.test.job;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.internal.ImmutableList;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IDataService;
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
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.scheduling.RFSServiceJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.server.test.dataprovider.AbstractDataProviderTest;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ServicesFactory;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * FIXME, Should target test repository.
 * 
 * @author dzonekl
 * 
 */
public class ServiceJobTest extends AbstractDataProviderTest {

	private static final String RFS_NAME = "Speech";

	private IDataService dataService;
	private IDataProvider dataProvider;
	private ModelUtils modelUtils;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		dataService = super.getInjector().getInstance(IDataService.class);
		modelUtils = super.getInjector().getInstance(ModelUtils.class);
		dataProvider = dataService.getProvider();
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

		this.createModelData();
	}

	private RFSService createModelData() {
		final Resource serviceResource = dataProvider
				.getResource(ServicesPackage.Literals.RFS_SERVICE);
		for (final EObject eObject : serviceResource.getContents()) {
			if (eObject instanceof RFSService
					&& ((RFSService) eObject).getServiceName().equals(RFS_NAME)) {
				return (RFSService) eObject;
			}
		}

		final RFSService rfsService = ServicesFactory.eINSTANCE.createRFSService();
		rfsService.setServiceName(RFS_NAME);
		
		final Node node = OperatorsFactory.eINSTANCE.createNode();
		rfsService.getNodes().add(node);
		serviceResource.getContents().add(rfsService);
		
		// Add some objects, which are referable from our xtext model.
		final Resource res = dataProvider
				.getResource(LibraryPackage.Literals.LIBRARY);
		final Library lib = (Library) res.getContents().get(0);

		final NodeType sgsnType = LibraryFactory.eINSTANCE.createNodeType();
		node.setNodeType(sgsnType);
		node.setOriginalNodeTypeRef(sgsnType);
		node.setNodeID("SGSN");
		
		final Function sgsnFunction = LibraryFactory.eINSTANCE.createFunction();
		sgsnFunction.setFunctionName("SGSN");
		sgsnType.getFunctions().add(sgsnFunction);

		lib.getNodeTypes().add(sgsnType);

		final NetXResource sgsnRes = LibraryFactory.eINSTANCE
				.createNetXResource();
		final MetricValueRange range = MetricsFactory.eINSTANCE
				.createMetricValueRange();
		sgsnRes.getMetricValueRanges().add(range);

		sgsnFunction.getFunctionResources().add(sgsnRes);

		final Value v = GenericsFactory.eINSTANCE.createValue();
		v.setValue(2.0);
		v.setTimeStamp(modelUtils.xmlDate(modelUtils.yesterday()));

		final Value v1 = GenericsFactory.eINSTANCE.createValue();
		v1.setValue(2.1);
		v1.setTimeStamp(modelUtils.xmlDate(modelUtils.twoDaysAgo()));

		final Value v2 = GenericsFactory.eINSTANCE.createValue();
		v2.setValue(2.1);
		v2.setTimeStamp(modelUtils.xmlDate(modelUtils.threeDaysAgo()));

		range.getMetricValues().addAll(ImmutableList.of(v, v1, v2));

		final RFSServiceJob job = SchedulingFactory.eINSTANCE.createRFSServiceJob();
		job.setRFSService(rfsService);
		job.setStartTime(modelUtils.xmlDate(new Date(System.currentTimeMillis() + 6000)));
		job.setInterval(60);
		job.setName(rfsService.getServiceName());
		
		final Resource serviceJob = dataProvider.getResource(SchedulingPackage.Literals.RFS_SERVICE_JOB);
		serviceJob.getContents().add(job);		
		return rfsService;
	}

}
