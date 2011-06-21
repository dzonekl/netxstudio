/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.netxstudio.server.test.metrics;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.cdo.server.hibernate.IHibernateStore;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.junit.Test;

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
public class MetricValueQueryTest extends AbstractDataProviderTest {

	private static final String RFS_NAME = "Speech";

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
	@Test
	public void testQuery() throws Exception {
		final String name = "name";
		final CDOTransaction transaction = dataProvider.getTransaction();
		final CDOQuery cdoQuery = transaction
				.createQuery(
						"hql",
						"select v from Value v, MetricValueRange mvr, NetXResource res where "
								+ "v in elements(mvr.metricValues) and v.timeStamp >= :dateFrom and " +
								"v.timeStamp <= :dateTo and mvr in elements(res.metricValueRanges) and res.shortName=:name");
		cdoQuery.setParameter("name", name);
		cdoQuery.setParameter("dateFrom", dateString());
		cdoQuery.setParameter("dateTo", dateString());
		cdoQuery.setParameter(IHibernateStore.CACHE_RESULTS, true);
		final List<Value> values = cdoQuery.getResult(Value.class);
		dataProvider.commitTransaction();
	}

	private String dateString() {
		return XMLTypeFactory.eINSTANCE.convertDateTime(modelUtils.toXMLDate(new Date()));
	}
	
	private RFSService createModelData() throws Exception {
		final Resource serviceResource = dataProvider
				.getResource(ServicesPackage.Literals.RFS_SERVICE);
		for (final EObject eObject : serviceResource.getContents()) {
			if (eObject instanceof RFSService
					&& ((RFSService) eObject).getServiceName().equals(RFS_NAME)) {
				return (RFSService) eObject;
			}
		}

		final RFSService rfsService = ServicesFactory.eINSTANCE
				.createRFSService();
		rfsService.setServiceName(RFS_NAME);

		final Node node = OperatorsFactory.eINSTANCE.createNode();
		rfsService.getNodes().add(node);

		serviceResource.getContents().add(rfsService);

		// Add some objects, which are referable from our xtext model.
		final Resource res = dataProvider
				.getResource(LibraryPackage.Literals.LIBRARY);
		if (res.getContents().isEmpty()) {
			final Library lib = LibraryFactory.eINSTANCE.createLibrary();
			res.getContents().add(lib);
		}
		final Library lib = (Library) res.getContents().get(0);

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

		// final Resource networkRes = dataProvider
		// .getResource(OperatorsPackage.Literals.NODE);
		// networkRes.getContents().add(network);
		// networkRes.save(Collections.emptyMap());
		res.getContents().add(network);
		res.save(Collections.emptyMap());

		serviceResource.save(Collections.emptyMap());

		final NetXResource sgsnRes = LibraryFactory.eINSTANCE
				.createNetXResource();
		final MetricValueRange range = MetricsFactory.eINSTANCE
				.createMetricValueRange();
		sgsnRes.getMetricValueRanges().add(range);

		sgsnFunction.getResources().add(sgsnRes);

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

		res.save(Collections.emptyMap());

		final RFSServiceJob job = SchedulingFactory.eINSTANCE
				.createRFSServiceJob();
		job.setRFSService(rfsService);
		job.setStartTime(modelUtils.toXMLDate(new Date(System
				.currentTimeMillis() + 6000)));
		job.setInterval(60);
		job.setName(rfsService.getServiceName());

		final Resource serviceJob = dataProvider
				.getResource(SchedulingPackage.Literals.JOB);
		serviceJob.getContents().add(job);
		serviceJob.save(Collections.emptyMap());
		return rfsService;
	}

}
