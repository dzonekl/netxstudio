/*******************************************************************************
 * Copyright (c) 21 jun. 2013 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.test.adapters;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.util.CDOLazyContentAdapter;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ComponentSummary;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.model.MonitoringAdapterFactory;
import com.netxforge.netxstudio.common.model.MonitoringStateEvent;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.MonitoringStateStateCallBack;
import com.netxforge.netxstudio.common.model.NetxresourceSummary;
import com.netxforge.netxstudio.common.model.NodeTypeSummary;
import com.netxforge.netxstudio.common.model.OperatorSummary;
import com.netxforge.netxstudio.common.model.RFSServiceSummary;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.impl.ComponentImpl;
import com.netxforge.netxstudio.library.impl.NetXResourceImpl;
import com.netxforge.netxstudio.library.impl.NodeTypeImpl;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.impl.OperatorImpl;
import com.netxforge.netxstudio.server.test.AbstractInjectedTestJUnit4;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.impl.RFSServiceImpl;

/**
 * Test {@link MonitoringStateModel} and produced implementation of
 * {@link IMonitoringSummary}. </p> The tests checks the adaptation process, as
 * we use {@link CDOLazyContentAdapter} which self-adapts for objects coming and
 * going. </p> Secondly we test the monitoring calculations per adaptation
 * implementation. </p> </p> Expected Hierarch: </p>
 * Operator-->Network-->Node-->
 * NodeType-->Component-->Component...>NetXResource-->MetricValueRange-->Value ^
 * | | -->Lifecycle. Service.............> </p>
 * 
 * The tests work on existing objects, lookup the OID's of objects and replace
 * them in the test.
 * 
 * @author Christophe Bouhier
 */
public class CDOMonitoringAdapterTest extends AbstractInjectedTestJUnit4 {

	private CDOID targetNetXResourceID;

	@Inject
	private IDataProvider provider;

	@Inject
	private ModelUtils modelUtils;

	@Inject
	private MonitoringStateModel stateModel;

	// THIS TEST WORKS ONLY ON EXISTING OBJECTS IN THE MODEL.
	// set the targets HERE:
	private static String NETXRESOURCE_OID = "10955120";
	private static int NETXRESOURCE_TARGET_MVR_INTERVAL = 60;

	private static String RFSSERVICE_OID = "10955120";

	@Before
	public void before() {

		this.getInjector().injectMembers(this);

		targetNetXResourceID = cdoIDFor(LibraryPackage.Literals.NET_XRESOURCE,
				NETXRESOURCE_OID);
		Assert.assertNotNull(targetNetXResourceID);
		Assert.assertNotNull(stateModel);

		provider.openSession("admin", "admin");
	}

	@After
	public void after() {
		provider.closeSession();
	}

	boolean finished = false;
	String failed = "";

	@Test
	public void testAdapterAdded() {

		EObject targetEObject = provider.getTransaction().getObject(
				targetNetXResourceID);

		if (targetEObject == null) {
			Assert.fail("target should be set");
		}
		Assert.assertTrue(targetEObject instanceof NetXResource);
		final NetXResource targetNetXResource = (NetXResource) targetEObject;

		{ // CALLBACK FOR NETXRESOURCE
			MonitoringStateStateCallBack callBack = new MonitoringStateStateCallBack() {

				public void callBackEvent(MonitoringStateEvent event) {

					try {

						Object result = event.getResult();
						if (result instanceof IMonitoringSummary) {

							testAdaptedGraph(targetNetXResource, 1);
							// testMonitoring();
							NetxresourceSummary sum = (NetxresourceSummary) result;
							System.out.println("Marker count:  "
									+ sum.markers().size());
							System.out.println("RAG:  " + sum.toString());
						}
					} catch (Error e) {
						failed = "Test failed";
						throw e;
					} catch (Exception e) {
						failed = e.getMessage();
					} finally {
						finished = true;
					}
				}
			};

			// Summary for NetXResource.
			stateModel.summary(callBack, targetNetXResource, new Object[] {});

			while (!finished) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		// Do some update on the metric value ranges.
		List<MetricValueRange> valueRangesForInterval = modelUtils
				.valueRangesForInterval(targetNetXResource,
						NETXRESOURCE_TARGET_MVR_INTERVAL);
		if (valueRangesForInterval.size() != 1) {
			Assert.fail("We need a resource with one target value range for interval: "
					+ NETXRESOURCE_TARGET_MVR_INTERVAL);
		}

		MetricValueRange targetMVR = valueRangesForInterval.get(0);
		
		
		// Note, this will sort the current collection, forcing the loading of the values.
		add20RandomValues(targetMVR);
		
		
		
		IMonitoringSummary adapted = MonitoringStateModel
				.getAdapted(targetNetXResource);

		if (!failed.isEmpty()) {
			Assert.fail(failed);
		}
	}

	private void add20RandomValues(MetricValueRange targetMVR) {
		DateTimeRange period = modelUtils.period(targetMVR.getMetricValues());
		XMLGregorianCalendar end = period.getEnd();
		
		for(int i = 0 ; i < 20; i++){
			XMLGregorianCalendar rollHours = modelUtils.rollHours(end, 1);	
		}
		
		
	}

	/**
	 * Check the adaptation graph (recursively) for the target object. 
	 * </p>Rules are: </p>
	 * <ul>
	 * <li>Filtered objects should not have an adapter of type
	 * {@li2nk IMonitoringSummary}</li>
	 * <li>
	 * Only non-filtered items, should have the same adapter installed in the
	 * hierarchy. If a child object is not-filtered, it could be on the parent
	 * adapter or have it's own depending on the result of
	 * {@link MonitoringAdapterFactory#isFactoryForType(Object)}</li>
	 * </ul>
	 * 
	 * @param eObject
	 */
	private void testAdaptedGraph(EObject eObject, int expectedQuantity)
			throws Exception {
		testAdapterType(eObject, expectedQuantity);

		// Test containments, the fact that we iterate will auto-adapt the
		// graph.
		// This only happens if context for computation is correct.
		for (EObject eo : eObject.eContents()) {
			this.testAdapterType(eo, expectedQuantity);
			// Recursively call.
			testAdaptedGraph(eo, expectedQuantity);
		}

		// Test x-refs, will not auto adapt with current adapter.
		// eObject.eCrossReferences();
	}

	public CDOID cdoIDFor(EClass eclass, String string) {
		return CDOIDUtil.createLong(Long.parseLong(string));

	}

	/**
	 * Checks the objects adapters, and if they are 1) installed and 2) are the
	 * right type.
	 * 
	 * @param object
	 */
	private void testAdapterType(EObject object, int expectedQuantity)
			throws Exception {

		// Types in hierarchy with own adapters.
		if (object instanceof NetXResource) {
			testAdaptation(NetxresourceSummary.class, NetXResourceImpl.class,
					object.eAdapters(), expectedQuantity);
		} else if (object instanceof Component) {
			testAdaptation(ComponentSummary.class, ComponentImpl.class,
					object.eAdapters(), expectedQuantity);
		} else if (object instanceof NodeType) {
			testAdaptation(NodeTypeSummary.class, NodeTypeImpl.class,
					object.eAdapters(), expectedQuantity);
		} else if (object instanceof RFSService) {
			testAdaptation(RFSServiceSummary.class, RFSServiceImpl.class,
					object.eAdapters(), expectedQuantity);
		} else if (object instanceof Operator) {
			testAdaptation(OperatorSummary.class, OperatorImpl.class,
					object.eAdapters(), expectedQuantity);
		}
		// Types with inherited adapters.
		else if (object instanceof MetricValueRange) {
			testAdaptation(NetxresourceSummary.class, NetXResourceImpl.class,
					object.eAdapters(), expectedQuantity);
		}
		// types which are filtered (And should not ever have any of the
		// IMonitoringSummary adapter).
		else if (object instanceof Value || object instanceof Lifecycle) {
			testAdaptation(null, null, object.eAdapters(), 0);
		}
	}

	/**
	 * Test if the adapters contains the expected quantity of adapters specified
	 * by type. When type is <code>null</code> the adapters should not contain
	 * any of type {@link IMonitoringSummary}
	 * 
	 * @param type
	 * @param adapters
	 * @param expectedQuantity
	 */
	protected void testAdaptation(Class<? extends IMonitoringSummary> type,
			Class<? extends EObject> targetType, EList<Adapter> adapters,
			int expectedQuantity) throws Exception {

		int countIMonitoringSummaryAdapters = 0;
		int countMatchingTypeAdapters = 0;

		for (Adapter a : adapters) {
			if (type != null && targetType != null) {
				// Are we the correct type!
				if (a.getClass().equals(type)) {
					countMatchingTypeAdapters++;
					Notifier target = a.getTarget();
					Class<? extends Notifier> targetClass = target.getClass();
					boolean equals = targetClass.equals(targetType);
					Assert.assertTrue(equals);
				}
			} else {
				if (a instanceof IMonitoringSummary) {
					countIMonitoringSummaryAdapters++;
				}
			}
		}

		if (type != null && targetType != null) {
			Assert.assertEquals(expectedQuantity, countMatchingTypeAdapters);
		} else {
			Assert.assertEquals(expectedQuantity,
					countIMonitoringSummaryAdapters);
		}
	}

}
