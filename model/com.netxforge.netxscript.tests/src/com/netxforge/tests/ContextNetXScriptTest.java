/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.netxforge.tests;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit.AbstractXtextTests;

import com.google.common.collect.ImmutableList;
import com.netxforge.NetxscriptStandaloneSetup;
import com.netxforge.interpreter.IInterpreter;
import com.netxforge.interpreter.IInterpreterContext;
import com.netxforge.interpreter.IInterpreterContextFactory;
import com.netxforge.interpreter.IInterpreterFactory;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.generics.DateTimeRange;
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

/**
 * FIXME, Should target test repository.
 * 
 * @author dzonekl
 * 
 */
public class ContextNetXScriptTest extends AbstractXtextTests {

	IDataService dataService;
	IInterpreterFactory interpreterFactory;
	IInterpreterContextFactory<?> interpreterContextFactory;
	ModelUtils modelUtils;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new NetxscriptStandaloneSetup());
		
		// Inject whatever we need.
		dataService = get(IDataService.class);
		modelUtils = get(ModelUtils.class);
		interpreterFactory = get(IInterpreterFactory.class);
		interpreterContextFactory = get(IInterpreterContextFactory.class);
		
		
		dataService.getProvider().openSession("admin", "admin");
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		dataService.getProvider().closeSession();
	}

	/**
	 * @throws Exception
	 */
	public void testContext() throws Exception {
		
		this.createModelData();
		
		DateTimeRange timeRange = GenericsFactory.eINSTANCE.createDateTimeRange();
		
		XMLGregorianCalendar t0 = modelUtils.toXMLDate(modelUtils.todayAndNow());
		XMLGregorianCalendar t1 = modelUtils.toXMLDate(modelUtils.lastWeek());
		
		timeRange.setBegin(t1);
		timeRange.setEnd(t0);
		
		IInterpreterContext periodContext = interpreterContextFactory.createPeriodContext(timeRange);
		List<IInterpreterContext> contextList = ImmutableList.of(periodContext);
		IInterpreterContext[] contextArray = new IInterpreterContext[contextList.size()];
		IInterpreter i = interpreterFactory.create(contextList.toArray(contextArray));
		System.out.println(i.toString());
		// TODO, the interpretation, currently our interpreter doesn't do anything with the context. 
		
	}
	
	
	private void createModelData(){
		// Add some objects, which are referable from our xtext model.
		Resource res = dataService.getProvider().getResource(
				LibraryPackage.Literals.LIBRARY);
		Library lib = (Library) res.getContents().get(0);

		NodeType sgsnType = LibraryFactory.eINSTANCE.createNodeType();
		Function sgsnFunction = LibraryFactory.eINSTANCE.createFunction();
		sgsnFunction.setFunctionName("SGSN");
		sgsnType.getFunctions().add(sgsnFunction);
		
		lib.getNodeTypes().add(sgsnType);
		
		NetXResource sgsnRes = LibraryFactory.eINSTANCE.createNetXResource();
		MetricValueRange range = MetricsFactory.eINSTANCE.createMetricValueRange();
		sgsnRes.getMetricValueRanges().add(range);
		
		sgsnFunction.getFunctionResources().add(sgsnRes);
		
		Value v = GenericsFactory.eINSTANCE.createValue();
		v.setValue(2.0);
		v.setTimeStamp(modelUtils.toXMLDate(modelUtils.yesterday()));

		Value v1 = GenericsFactory.eINSTANCE.createValue();
		v1.setValue(2.1);
		v1.setTimeStamp(modelUtils.toXMLDate(modelUtils.twoDaysAgo()));

		Value v2 = GenericsFactory.eINSTANCE.createValue();
		v2.setValue(2.1);
		v2.setTimeStamp(modelUtils.toXMLDate(modelUtils.threeDaysAgo()));
		
		range.getMetricValues().addAll(ImmutableList.of(v,v1,v2));
		
	}
	
	

}
