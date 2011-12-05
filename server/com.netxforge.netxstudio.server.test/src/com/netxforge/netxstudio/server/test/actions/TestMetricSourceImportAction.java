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
 * Contributors: 
 * 	Martin Taal - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.test.actions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOIDLong;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.cdo.NonStatic;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.metrics.MetricSourceImportService;
import com.netxforge.netxstudio.server.service.NetxForgeService;
import com.netxforge.netxstudio.server.test.dataprovider.AbstractDataProviderTest;

/**
 * Calls the metric source import action.
 * 
 * @author Martin Taal
 */
public class TestMetricSourceImportAction extends AbstractDataProviderTest {

	@Inject
	@NonStatic
	private IDataProvider dataProvider;

	@Inject
	@NonStatic
	private IDataProvider anotherDataProvider;

	@Inject
	private ModelUtils modelUtils;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		super.getInjector().injectMembers(this);
		dataProvider.setDoGetResourceFromOwnTransaction(false);
		dataProvider.openSession("admin", "admin");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		dataProvider.closeSession();
	}

	public void testCallImportAction() throws Exception {
		dataProvider.getTransaction();
		final Resource res = dataProvider
				.getResource(MetricsPackage.Literals.METRIC_SOURCE);
		for (final EObject eObject : res.getContents()) {
			final CDOObject cdoObject = (CDOObject) eObject;
			callAction(MetricSourceImportService.MS_PARAM, cdoObject);
		}
		dataProvider.commitTransaction();
	}

	public void callAction(final String paramName,
			final CDOObject cdoObject) throws Exception {
		if (((AbstractCDOIDLong) cdoObject.cdoID()).getLongValue() == 741) {
			return;
		}
		
		final WorkFlowRun wfRun = callAction(paramName, cdoObject.cdoID());
		// sleep for 5 seconds to give the server time to work
		int cnt = 0;
		while (true) {
			Thread.sleep(5000);
			cnt++;
			if (cnt == 20) {
				fail("WorkFlowRun did not finish, testing "
						+ cdoObject.eClass().getName() + " "
						+ cdoObject.cdoID());
			}

			final WorkFlowRun workFlowRun = (WorkFlowRun) anotherDataProvider
					.getTransaction().getObject(wfRun.cdoID());
			System.err.println(workFlowRun.getState());
			if (workFlowRun.getState() == JobRunState.FINISHED_SUCCESSFULLY) {
				break;
			}
			anotherDataProvider.commitTransaction();
		}
	}

	private WorkFlowRun callAction(String parameterName, CDOID cdoId)
			throws Exception {

		final StringBuilder url = new StringBuilder();
		url.append("http://localhost:8080/netxforge/service");
		url.append("?" + NetxForgeService.SERVICE_PARAM_NAME + "="
				+ MetricSourceImportService.class.getName());
		url.append("&" + parameterName + "="
				+ ((AbstractCDOIDLong) cdoId).getLongValue());

		System.err.println(url.toString());
		final String result = doRequest(url.toString());
		final CDOID resultCDOID = CDOIDUtil.createLongWithClassifier(
				new CDOClassifierRef(SchedulingPackage.Literals.WORK_FLOW_RUN),
				Long.parseLong(result));
		return (WorkFlowRun) dataProvider.getTransaction().getObject(
				resultCDOID);
	}

	private String doRequest(String address) {
		try {
			final URL url = new URL(address);
			final HttpURLConnection hc = (HttpURLConnection) url
					.openConnection();
			hc.setRequestMethod("GET");
			hc.setAllowUserInteraction(false);
			hc.setDefaultUseCaches(false);
			hc.setDoOutput(true);
			hc.setDoInput(true);
			hc.setInstanceFollowRedirects(true);
			hc.setUseCaches(false);
			hc.setRequestProperty("Content-Type", "text/xml");
			hc.connect();
			final InputStream is = hc.getInputStream();
			final StringBuilder sb = new StringBuilder();
			final BufferedReader reader = new BufferedReader(
					new InputStreamReader(is, "UTF-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				if (sb.length() > 0) {
					sb.append("\n");
				}
				sb.append(line);
			}
			is.close();
			return sb.toString();
		} catch (final Exception e) {
			throw new IllegalStateException("Exception when connecting to: "
					+ address, e);
		}
	}

	@SuppressWarnings("unused")
	private String getDateParamValue(long offset) {
		final XMLGregorianCalendar xmlDate = modelUtils.toXMLDate(new Date(
				System.currentTimeMillis() + offset));
		return XMLTypeFactory.eINSTANCE.convertDateTime(xmlDate);
	}
}
