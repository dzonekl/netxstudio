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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.base.NonModelUtils;
import com.netxforge.base.Tuple;
import com.netxforge.netxstudio.data.IDataService;

/**
 * 
 * This is our API to invoke services on the server.
 * 
 * 
 * Returns CDO Object ID, to follow the processing.
 * 
 * final String result = doRequest(url.toString()); final CDOID resultCDOID =
 * CDOIDUtil.createLongWithClassifier( new
 * CDOClassifierRef(SchedulingPackage.Literals.WORK_FLOW_RUN),
 * Long.parseLong(result)); return
 * (WorkFlowRun)dataProvider.getTransaction().getObject( resultCDOID);
 * 
 * @author Christophe Bouhier
 * 
 */
public class ServerRequest {

	private static final String NETXFORGE_SERVICE = "/netxforge/service";

	// final String IMPORT_REQUEST =
	// "http://localhost:8080/netxforge/service?service=com.netxforge.netxstudio.server.metrics.MetricSourceImportService&metricSource=7246";

	@Inject
	private IDataService dataService;

	private String server;

	public static final String LOCAL_HTTP_SERVER = "http://localhost:8080";

	public static final String COMMAND_PARAM_NAME = "command";
	public static final String SERVICE_PARAM_NAME = "service";
	public static final String DEFAULT_SUCCESS_RESULT = "success";

	public static final String METRIC_IMPORT_SERVICE = "com.netxforge.netxstudio.server.metrics.MetricSourceImportService";
	public static final String MONITOR_SERVICE = "com.netxforge.netxstudio.server.logic.monitoring.MonitoringService";
	public static final String RETENTION_SERVICE = "com.netxforge.netxstudio.server.logic.retention.RetentionService";
	public static final String REPORTING_SERVICE = "com.netxforge.netxstudio.server.logic.reporting.ReportingService";
	public static final String SCHEDULER_SERVICE = "com.netxforge.netxstudio.server.job.JobService";

	public static final String MS_PARAM = "metricSource";
	public static final String NETWORK_OPERATOR_PARAM = "operator";
	public static final String NETWORK_SERVICE_PARAM = "rfsService";
	public static final String NODE_PARAM = "node";
	public static final String NODETYPE_PARAM = "nodeType";
	public static final String START_TIME_PARAM = "startTime";
	public static final String END_TIME_PARAM = "endTime";

	// Scheduler commands.

	// List all scheduled and running jobs.
	public static final String COMMAND_SCHEDULER_LIST = "scheduler_list";

	// Stop the scheduler and abort all running jobs, for jobs in progress, we
	// set the status to aborted.
	public static final String COMMAND_SCHEDULER_STOP = "scheduler_stop";

	// Start the scheduler.
	public static final String COMMAND_SCHEDULER_START = "scheduler_start";

	// Start the scheduler.
	public static final String COMMAND_SCHEDULER_STATUS = "scheduler_status";

	// Communication error with scheduler.
	public static final String SCHEDULER_ERROR = "ERROR";

	// Scheduler is initializing.
	public static final String SCHEDULER_INITIALIZING = "INITIALIZING";

	public ServerRequest() {
	}

	public String callJobAction(String command) throws Exception {
		setServer();

		final StringBuilder url = new StringBuilder();
		url.append(server + NETXFORGE_SERVICE);
		url.append("?" + SERVICE_PARAM_NAME + "=" + SCHEDULER_SERVICE);
		url.append("&" + COMMAND_PARAM_NAME + "=" + command);

		// System.err.println(url.toString());
		final String result = doRequest(url.toString());
		// System.err.println(result);
		return result;
	}

	public String callMetricImportAction(CDOObject cdoObject) throws Exception {
		return callMetricAction(METRIC_IMPORT_SERVICE, MS_PARAM, cdoObject);
	}

	public String callMonitorAction(CDOObject cdoObject, Date fromDate,
			Date toDate) throws Exception {
		Tuple[] params = new Tuple[] { new Tuple(NETWORK_SERVICE_PARAM,
				NonModelUtils.cdoLongIDAsString(cdoObject)) };
		return callPeriodAction(MONITOR_SERVICE, fromDate, toDate, params);
	}

	public String callServiceReportingAction(CDOObject cdoObject,
			Date fromDate, Date toDate) throws Exception {
		Tuple[] params = new Tuple[] { new Tuple(NETWORK_SERVICE_PARAM,
				NonModelUtils.cdoLongIDAsString(cdoObject)) };
		return callPeriodAction(REPORTING_SERVICE, fromDate, toDate, params);
	}

	public String callNodeReportingAction(CDOObject cdoObject, Date fromDate,
			Date toDate) throws Exception {
		Tuple[] params = new Tuple[] { new Tuple(NODE_PARAM,
				NonModelUtils.cdoLongIDAsString(cdoObject)) };

		return callPeriodAction(REPORTING_SERVICE, fromDate, toDate, params);
	}

	/**
	 * Call for a Node Type for a service.
	 * 
	 * @param nodeTypeObject
	 * @param serviceObject
	 * @param fromDate
	 * @param toDate
	 * @return
	 * @throws Exception
	 */
	public String callNodeTypeReportingForServiceAction(
			CDOObject nodeTypeObject, CDOObject serviceObject, Date fromDate,
			Date toDate) throws Exception {

		Tuple[] params = new Tuple[] {
				new Tuple(NODETYPE_PARAM,
						NonModelUtils.cdoLongIDAsString(nodeTypeObject)),
				new Tuple(NETWORK_SERVICE_PARAM,
						NonModelUtils.cdoLongIDAsString(serviceObject)) };

		return callPeriodAction(REPORTING_SERVICE, fromDate, toDate, params);
	}

	public String callNodeTypeReportingForOperatorAction(
			CDOObject nodeTypeObject, CDOObject operatorObject, Date fromDate,
			Date toDate) throws Exception {

		Tuple[] params = new Tuple[] {
				new Tuple(NODETYPE_PARAM,
						NonModelUtils.cdoLongIDAsString(nodeTypeObject)),
				new Tuple(NETWORK_OPERATOR_PARAM,
						NonModelUtils.cdoLongIDAsString(operatorObject)) };

		return callPeriodAction(REPORTING_SERVICE, fromDate, toDate, params);
	}

	public String callOperatorReportingAction(CDOObject cdoObject,
			Date fromDate, Date toDate) throws Exception {

		Tuple[] params = new Tuple[] { new Tuple(NETWORK_OPERATOR_PARAM,
				NonModelUtils.cdoLongIDAsString(cdoObject)) };

		return callPeriodAction(REPORTING_SERVICE, fromDate, toDate, params);
	}

	public String callRetentionAction() throws Exception {
		return this.callRetentionAction(RETENTION_SERVICE);
	}

	private String callMetricAction(String serviceName, String parameterName,
			CDOObject cdoObject) throws Exception {

		setServer();

		final StringBuilder url = new StringBuilder();
		url.append(server + NETXFORGE_SERVICE);
		url.append("?" + SERVICE_PARAM_NAME + "=" + serviceName);
		url.append("&" + parameterName + "="
				+ NonModelUtils.cdoLongIDAsString(cdoObject));

		System.err.println(url.toString());
		final String result = doRequest(url.toString());
		System.err.println(result);
		return result;
	}

	public String callPeriodAction(String serviceName, Date from, Date to,
			Tuple... params) throws Exception {

		setServer();

		if (from == null) {
			from = NonModelUtils.oneMonthAgo();
		}

		if (to == null) {
			to = NonModelUtils.todayAndNow();
		}

		final StringBuilder url = new StringBuilder();
		url.append(server + NETXFORGE_SERVICE);
		url.append("?" + SERVICE_PARAM_NAME + "=" + serviceName);

		List<Tuple> paramsList = Lists.newArrayList(params);
		paramsList.add(new Tuple(START_TIME_PARAM, getDateParamValue(from)));
		paramsList.add(new Tuple(END_TIME_PARAM, getDateParamValue(to)));

		this.appendParams(url, paramsList);

		System.err.println(url.toString());
		final String result = doRequest(url.toString());
		System.err.println(result);
		return result;
	}

	public String callRetentionAction(String serviceName) throws Exception {

		setServer();

		final StringBuilder url = new StringBuilder();
		url.append(server + NETXFORGE_SERVICE);
		url.append("?" + SERVICE_PARAM_NAME + "=" + serviceName);

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

	public String setServer() {

		server = dataService.getServer();

		if (server == null) {
			server = LOCAL_HTTP_SERVER;
		} else {
			if (server.startsWith("http")) {
				return server;
			}
			if (server.startsWith("localhost")) {
				server = LOCAL_HTTP_SERVER;
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
		return server;
	}

	private StringBuilder appendParams(StringBuilder url, List<Tuple> params) {

		for (Tuple param : params) {
			this.appendParam(url, (String) param.getKey(),
					(String) param.getValue());
		}
		return url;
	}

	private StringBuilder appendParam(StringBuilder url, String parameterName,
			String parameterValue) {

		url.append("&" + parameterName + "=" + parameterValue);
		return url;
	}

	private String getDateParamValue(Date d) {
		final XMLGregorianCalendar xmlDate = NonModelUtils.toXMLDate(d);
		return XMLTypeFactory.eINSTANCE.convertDateTime(xmlDate);
	}

	@SuppressWarnings("unused")
	private String getDateParamValue(long offset) {
		final XMLGregorianCalendar xmlDate = NonModelUtils.toXMLDate(new Date(
				System.currentTimeMillis() + offset));
		return XMLTypeFactory.eINSTANCE.convertDateTime(xmlDate);
	}

	public void setCDOServer(String server) {
		this.server = server;
	}

	public static boolean schedulerRunning(String commandSchedulerStatus,
			String result) {
		if (commandSchedulerStatus.equals(COMMAND_SCHEDULER_STATUS)) {
			return result.equals("Scheduler started");
		}
		return false;
	}

	public static List<String[]> schedulerTriggers(String schedule) {

		BufferedReader reader = new BufferedReader(new StringReader(schedule));

		// Regex, splits quoted fragments separated by delimiter.
		// The fancy regexp, also considers double quotes sometimes used.
		Pattern p = Pattern.compile("(\".*?\"|[^,]++)");
		final List<String[]> localData = new ArrayList<String[]>();
		String line;
		try {
			while ((line = reader.readLine()) != null) {

				// Split (by default) for encapsulated by quote char...
				// CB: http://work.netxforge.com/issues/159
				// See also: http://mindprod.com/jgloss/regex.html
				ArrayList<String> matchingList = Lists.newArrayList();
				Matcher matcher = p.matcher(line);
				while (matcher.find()) {
					final int gc = matcher.groupCount();
					// group 0 is the whole pattern matched,
					// loops runs from from 0 to gc, not 0 to gc-1 as is
					// traditional.
					for (int i = 0; i <= gc; i++) {
						String match = matcher.group(i);
						if (i > 0) { // Skip the outer group.
							matchingList.add(match);
						}
					}
				}

				final List<String> lineData = new ArrayList<String>();

				for (String s : matchingList) {
					lineData.add(s);
				}

				localData.add(lineData.toArray(new String[lineData.size()]));
			}
		} catch (IOException e) {
		}
		localData.toArray(new String[localData.size()][]);

		return localData;
	}

}
