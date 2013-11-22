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

import junit.framework.Assert;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.junit.After;
import org.junit.Before;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.data.cdo.NonStatic;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.logic.monitoring.MonitoringService;
import com.netxforge.netxstudio.server.logic.retention.RetentionService;
import com.netxforge.netxstudio.server.service.NetxForgeService;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

/**
 * Calls actions using a http get request. Need the server side to be running.
 * 
 * @author Martin Taal
 */
public abstract class BaseRemoteActionTest extends AbstractInjectedTestJUnit4 {

	private static final long ONE_DAY = 24 * 60 * 60 * 1000;

	@Inject
	@NonStatic
	private IData dataProvider;

	@Inject
	@NonStatic
	private IData anotherDataProvider;

	@Inject
	private ModelUtils modelUtils;

	@Before
	protected void setUp() throws Exception {
		super.getClientInjector().injectMembers(this);
		dataProvider.setDoGetResourceFromOwnTransaction(false);
		dataProvider.openSession("admin", "admin");
	}

	@After
	protected void tearDown() throws Exception {
		dataProvider.closeSession();
	}

	public void testCallActionRfsService() throws Exception {
		dataProvider.getTransaction();
		final Resource res = dataProvider
				.getResource(OperatorsPackage.Literals.OPERATOR);
		for (final EObject eObject : res.getContents()) {

			if (eObject instanceof Operator) {

				for (Service s : ((Operator) eObject).getServices()) {

					if (s instanceof RFSService) {
						final CDOObject cdoObject = (CDOObject) s;
						callServerAction(MonitoringService.SERVICE_PARAM,
								cdoObject);
					}
				}
			}
		}
		dataProvider.commitTransactionThenClose();
	}

	public void testCallActionNode() throws Exception {
		dataProvider.getTransaction();
		final Resource res = dataProvider
				.getResource(OperatorsPackage.Literals.NETWORK);
		for (final EObject eObject : res.getContents()) {
			final Network network = (Network) eObject;
			for (final Node node : network.getNodes()) {
				callServerAction(MonitoringService.NODE_PARAM, node);
			}
		}
		dataProvider.commitTransactionThenClose();
	}

	public void testCallActionNodeType() throws Exception {
		dataProvider.getTransaction();
		final Resource res = dataProvider
				.getResource(OperatorsPackage.Literals.NETWORK);
		for (final EObject eObject : res.getContents()) {
			final Network network = (Network) eObject;
			for (final Node node : network.getNodes()) {
				callServerAction(MonitoringService.NODETYPE_PARAM,
						node.getNodeType());
			}
		}
		dataProvider.commitTransactionThenClose();
	}

	public void callServerAction(final String paramName,
			final CDOObject cdoObject) throws Exception {
		final WorkFlowRun wfRun = callAction(paramName, cdoObject.cdoID());
		// sleep for 5 seconds to give the server time to work
		int cnt = 0;
		while (true) {
			Thread.sleep(5000);
			cnt++;
			if (cnt == 20) {
				Assert.fail("WorkFlowRun did not finish, testing "
						+ cdoObject.eClass().getName() + " "
						+ cdoObject.cdoID());
			}

			final WorkFlowRun workFlowRun = (WorkFlowRun) anotherDataProvider
					.getTransaction().getObject(wfRun.cdoID());
			System.err.println(workFlowRun.getState());
			@SuppressWarnings("unused")
			final Object failures = ((ComponentWorkFlowRun) workFlowRun)
					.getFailureRefs();
			if (workFlowRun.getState() == JobRunState.FINISHED_SUCCESSFULLY) {
				break;
			}
			anotherDataProvider.commitTransactionThenClose();
		}
	}

	private WorkFlowRun callAction(String parameterName, CDOID cdoId)
			throws Exception {

		final StringBuilder url = new StringBuilder();
		url.append("http://localhost:8080/netxforge/service");
		url.append("?" + NetxForgeService.SERVICE_PARAM_NAME + "="
				+ getServiceName());
		url.append("&" + RetentionService.START_TIME_PARAM + "="
				+ getDateParamValue(-1000 * ONE_DAY));
		url.append("&" + RetentionService.END_TIME_PARAM + "="
				+ getDateParamValue(ONE_DAY));
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

	protected abstract String getServiceName();

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

	private String getDateParamValue(long offset) {
		final XMLGregorianCalendar xmlDate = modelUtils.toXMLDate(new Date(
				System.currentTimeMillis() + offset));
		return XMLTypeFactory.eINSTANCE.convertDateTime(xmlDate);
	}
}
