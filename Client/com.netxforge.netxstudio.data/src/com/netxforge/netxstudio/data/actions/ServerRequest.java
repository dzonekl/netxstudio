/*******************************************************************************
 * Copyright (c) Jun 23, 2011 NetXForge.
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
package com.netxforge.netxstudio.data.actions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOIDLong;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;


/**
 * Returns CDO Object ID, to follow the processing. 
 * 
 * final String result = doRequest(url.toString());
		final CDOID resultCDOID = CDOIDUtil.createLongWithClassifier(
				new CDOClassifierRef(SchedulingPackage.Literals.WORK_FLOW_RUN),
				Long.parseLong(result));
		return (WorkFlowRun) dataProvider.getTransaction().getObject(
				resultCDOID);
 * 
 * @author dzonekl
 *
 */
public class ServerRequest {

	// final String IMPORT_REQUEST =
	// "http://localhost:8080/netxforge/service?service=com.netxforge.netxstudio.server.metrics.MetricSourceImportService&metricSource=7246";

	@Inject
	ModelUtils modelUtils;

	private String server;

	public static final String NETXSTUDIO_SERVER = "http://localhost:8080";

	public static final String COMMAND_PARAM_NAME = "command";
	public static final String SERVICE_PARAM_NAME = "service";
	public static final String DEFAULT_SUCCESS_RESULT = "success";

	public static final String METRIC_IMPORT_SERVICE = "com.netxforge.netxstudio.server.metrics.MetricSourceImportService";
	public static final String MONITOR_SERVICE = "com.netxforge.netxstudio.server.logic.ResourceMonitoringService";
	public static final String RETENTION_SERVICE = "com.netxforge.netxstudio.server.logic.RetentionService";
	public static final String REPORTING_SERVICE = "com.netxforge.netxstudio.server.logic.reporting.ReportingService";

	public static final String MS_PARAM = "metricSource";
	public static final String SERVICE_PARAM = "rfsService";
	public static final String NODE_PARAM = "node";
	public static final String NODETYPE_PARAM = "nodeType";
	public static final String START_TIME_PARAM = "startTime";
	public static final String END_TIME_PARAM = "endTime";

	public String callMetricImportAction(CDOObject cdoObject) throws Exception {
		return callMetricAction(METRIC_IMPORT_SERVICE, MS_PARAM,
				cdoObject.cdoID());
	}

	public String callMonitorAction(CDOObject cdoObject, Date fromDate,
			Date toDate) throws Exception {
		return callPeriodAction(MONITOR_SERVICE, SERVICE_PARAM,
				cdoObject.cdoID(), fromDate, toDate);
	}

	public String callReportingAction(CDOObject cdoObject, Date fromDate,
			Date toDate) throws Exception {
		return callPeriodAction(REPORTING_SERVICE, SERVICE_PARAM,
				cdoObject.cdoID(), fromDate, toDate);
	}

	public String callRetentionAction() throws Exception {
		// Retention can deal with RFSService, Node, Nodetype etc..).
		// Get all services.

		// return this.callRetentionAction(RETENTION_SERVICE, parameterName,
		// cdoId, from, to)
		return "TODO Not implemented yet.";
	}

	private String callMetricAction(String serviceName, String parameterName,
			CDOID cdoId) throws Exception {

		if (server == null) {
			server = NETXSTUDIO_SERVER;
		} else {
			if (server.startsWith("localhost")) {
				server = NETXSTUDIO_SERVER;
			} else {
				// Change the port, if any specified.
				int portIndex = server.indexOf(':');
				if (portIndex != -1) {
					server = server.substring(0, portIndex);
				} else {
					server = "http://" + server + ":8080";
				}

			}
		}

		final StringBuilder url = new StringBuilder();
		url.append(server + "/netxforge/service");
		url.append("?" + SERVICE_PARAM_NAME + "=" + serviceName);
		url.append("&" + parameterName + "="
				+ ((AbstractCDOIDLong) cdoId).getLongValue());

		System.err.println(url.toString());
		final String result = doRequest(url.toString());
		System.err.println(result);
		return result;
	}

	public String callPeriodAction(String serviceName, String parameterName,
			CDOID cdoId, Date from, Date to) throws Exception {

		if (server == null) {
			server = NETXSTUDIO_SERVER;
		} else {
			if (server.startsWith("localhost")) {
				server = NETXSTUDIO_SERVER;
			} else {
				// Change the port, if any specified.
				int portIndex = server.indexOf(':');
				if (portIndex != -1) {
					server = server.substring(0, portIndex);
				} else {
					server = "http://" + server + ":8080";
				}

			}
		}

		if (from == null) {
			from = modelUtils.oneMonthAgo();
		}

		if (to == null) {
			to = modelUtils.todayAndNow();
		}

		final StringBuilder url = new StringBuilder();
		url.append(server + "/netxforge/service");
		url.append("?" + SERVICE_PARAM_NAME + "=" + serviceName);

		url.append("&" + START_TIME_PARAM + "=" + getDateParamValue(from));
		url.append("&" + END_TIME_PARAM + "=" + getDateParamValue(to));

		url.append("&" + parameterName + "="
				+ ((AbstractCDOIDLong) cdoId).getLongValue());

		System.err.println(url.toString());
		final String result = doRequest(url.toString());
		System.err.println(result);
		return result;
	}

	public String callRetentionAction(String serviceName, String parameterName,
			CDOID cdoId, Date from, Date to) throws Exception {

		if (server == null) {
			server = NETXSTUDIO_SERVER;
		}

		final StringBuilder url = new StringBuilder();
		url.append(server + "/netxforge/service");
		url.append("?" + SERVICE_PARAM_NAME + "=" + serviceName);

		url.append("&" + START_TIME_PARAM + "=" + getDateParamValue(from));
		url.append("&" + END_TIME_PARAM + "=" + getDateParamValue(to));

		url.append("&" + parameterName + "="
				+ ((AbstractCDOIDLong) cdoId).getLongValue());

		System.err.println(url.toString());
		final String result = doRequest(url.toString());
		System.err.println(result);
		return result;
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

	private String getDateParamValue(Date d) {
		final XMLGregorianCalendar xmlDate = modelUtils.toXMLDate(d);
		return XMLTypeFactory.eINSTANCE.convertDateTime(xmlDate);
	}

	@SuppressWarnings("unused")
	private String getDateParamValue(long offset) {
		final XMLGregorianCalendar xmlDate = modelUtils.toXMLDate(new Date(
				System.currentTimeMillis() + offset));
		return XMLTypeFactory.eINSTANCE.convertDateTime(xmlDate);
	}

	public void setServer(String server) {
		this.server = server;
	}

}
