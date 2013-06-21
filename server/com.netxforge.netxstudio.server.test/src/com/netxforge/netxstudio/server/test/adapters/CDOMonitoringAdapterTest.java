package com.netxforge.netxstudio.server.test.adapters;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.MonitoringStateEvent;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.MonitoringStateStateCallBack;
import com.netxforge.netxstudio.common.model.NetxresourceSummary;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.server.test.AbstractInjectedTestJUnit4;

public class CDOMonitoringAdapterTest extends AbstractInjectedTestJUnit4 {

	private CDOID targetNetXResourceID;

	@Inject
	private IDataProvider provider;

	@Inject
	private MonitoringStateModel stateModel;

	@Before
	public void before() {
		// NOTE:
		// THIS TEST WORKS ONLY ON EXISTING OBJECTS IN THE MODEL.
		// set the target.

		this.getInjector().injectMembers(this);

		targetNetXResourceID = cdoIDFor(LibraryPackage.Literals.NET_XRESOURCE,
				"10955120");
		Assert.assertNotNull(targetNetXResourceID);
		Assert.assertNotNull(stateModel);

		provider.openSession("admin", "admin");
	}

	@After
	public void after() {
		provider.closeSession();
	}

	boolean finished = false;

	@Test
	public void testAdapterAdded() {

		EObject targetEObject = provider.getTransaction().getObject(
				targetNetXResourceID);

		if (targetEObject == null) {
			Assert.fail("target should be set");
		}
		Assert.assertTrue(targetEObject instanceof NetXResource);
		NetXResource targetNetXResource = (NetXResource) targetEObject;

		MonitoringStateStateCallBack callBack = new MonitoringStateStateCallBack() {

			public void callBackEvent(MonitoringStateEvent event) {
				Object result = event.getResult();
				if (result instanceof IMonitoringSummary) {
					Assert.assertTrue(result instanceof NetxresourceSummary);
					NetxresourceSummary sum = (NetxresourceSummary) result;
					System.out
							.println("Marker count:  " + sum.markers().size());
					System.out.println("RAG:  " + sum.toString());
				}
				// Make sure our target as only one adapter. d
				finished = true;
			}
		};
		stateModel.summary(callBack, targetNetXResource, new Object[] {});

		while (!finished) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public CDOID cdoIDFor(EClass eclass, String string) {
		return CDOIDUtil.createLongWithClassifier(new CDOClassifierRef(eclass),
				Long.parseLong(string));

	}

}
