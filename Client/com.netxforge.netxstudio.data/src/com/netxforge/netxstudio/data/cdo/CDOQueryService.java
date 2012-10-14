/*******************************************************************************
 * Copyright (c) May 17, 2011 NetXForge.
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
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.cdo;

import java.util.Calendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOIDLong;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.services.Service;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class CDOQueryService implements IQueryService {

	private IDataProvider provider;
	private CDOQueryUtil queryService;
	private ModelUtils modelUtils;
	private List<CDOTransaction> usedTransactions = Lists.newArrayList();

	@Inject
	public CDOQueryService(CDOQueryUtil queryService, ModelUtils modelUtils) {
		this.queryService = queryService;
		this.modelUtils = modelUtils;
	}

	public void setDataProvider(IDataProvider provider) {
		this.provider = provider;
	}

	public void close() {
		for (CDOTransaction t : usedTransactions) {
			t.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.cdo.ICDORoleHandler#getRole(java.lang.String
	 * )
	 */
	public List<Role> getRole(String userID) {

		CDOTransaction t = provider.getSession().openTransaction();

		if (!usedTransactions.contains(t)) {
			usedTransactions.add(t);
		}

		CDOQuery q = t.createQuery("hql", ICDOQueries.SELECT_ROLES_FROM_PERSON);
		q.setParameter("name", userID);
		queryService.setCacheParameter(q);
		return q.getResult(Role.class);
	}

	public List<Job> getJobWithMetricSource(MetricSource source) {

		CDOTransaction t = provider.getSession().openTransaction();
		CDOQuery q = t.createQuery("hql",
				ICDOQueries.SELECT_JOBS_WITH_METRICSOURCE);
		q.setParameter("metricSource", source);
		queryService.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	public List<Job> getJobWithService(Service service) {

		CDOTransaction t = provider.getSession().openTransaction();
		CDOQuery q = t.createQuery("hql", ICDOQueries.SELECT_JOBS_WITH_SERVICE);
		q.setParameter("rfsService", service);
		queryService.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	public List<Job> getJobWithServiceReporting(Service service) {
		CDOTransaction t = provider.getSession().openTransaction();
		CDOQuery q = t.createQuery("hql",
				ICDOQueries.SELECT_JOBS_WITH_SERVICE_REPORTING);
		q.setParameter("rfsService", service);
		queryService.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	public List<Job> getJobWithOperatorReporting(Operator operator) {
		CDOTransaction t = provider.getSession().openTransaction();
		CDOQuery q = t.createQuery("hql",
				ICDOQueries.SELECT_JOBS_WITH_OPERATOR_REPORTING);
		q.setParameter("operator", operator);
		queryService.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	public Role getCurrentRole() {

		String userID = provider.getSessionUserID();
		List<Role> roles = this.getRole(userID);
		if (roles.size() != 1) {
			throw new java.lang.IllegalStateException("Data corruption, user +"
					+ userID + "should have a role defined");
		} else {
			return roles.get(0);
		}
	}

	public List<Equipment> getEquipments(String nodeID, String equipmentCode) {
		final CDOTransaction transaction = provider.getTransaction();
		final CDOQuery cdoQuery = transaction
				.createQuery(
						"hql",
						"select e from Equipment e, Node n"
								+ "e in elements(n.equipments) "
								+ "and e.equipmentCode=:equipmentCode and n.nodeID=:nodeid");
		cdoQuery.setParameter("nodeid", nodeID);
		cdoQuery.setParameter("equipmentCode", equipmentCode);

		queryService.setCacheParameter(cdoQuery);
		final List<Equipment> equipments = cdoQuery.getResult(Equipment.class);
		return equipments;
	}

	public List<Function> getFunctions(String nodeID, String name) {
		final CDOTransaction transaction = provider.getTransaction();
		final CDOQuery cdoQuery = transaction.createQuery("hql",
				"select e from Function e, Node n"
						+ "e in elements(n.functions) "
						+ "and e.name=:name and n.nodeID=:nodeid");
		cdoQuery.setParameter("nodeid", nodeID);
		cdoQuery.setParameter("equipmentCode", name);

		queryService.setCacheParameter(cdoQuery);
		final List<Function> functions = cdoQuery.getResult(Function.class);
		return functions;
	}

	public List<NetXResource> getResources(String nodeID, String expressionName) {
		final CDOTransaction transaction = provider.getTransaction();
		final CDOQuery cdoQuery = transaction.createQuery("hql",
				"select r from NetXResource r, Component c, Node n"
						+ "r in elements(c.resources) "
						+ "and r.name=:expressionName and n.nodeID=:nodeid");
		cdoQuery.setParameter("nodeid", nodeID);
		cdoQuery.setParameter("expressioName", expressionName);

		queryService.setCacheParameter(cdoQuery);
		final List<NetXResource> resources = cdoQuery
				.getResult(NetXResource.class);
		return resources;
	}

	public List<Value> getMetricsFromResource(String expressionName,
			XMLGregorianCalendar from, XMLGregorianCalendar to,
			int intervalHint, KindHintType kindHint) {
		final CDOTransaction transaction = provider.getTransaction();
		final CDOQuery cdoQuery = transaction
				.createQuery(
						"hql",
						"select v from Value v, MetricValueRange mvr, NetXResource res where "
								+ "v in elements(mvr.metricValues) "
								+ "and v.timeStamp >= :dateFrom and v.timeStamp <= :dateTo "
								+ "and mvr.intervalHint=:intervalHint and mvr.kindHint = :kindHint "
								+ "and mvr in elements(res.metricValueRanges) and res.expressionName=:name");
		cdoQuery.setParameter("name", expressionName);
		cdoQuery.setParameter("dateFrom", dateString(from));
		cdoQuery.setParameter("dateTo", dateString(to));
		cdoQuery.setParameter("intervalHint",
				new Integer(intervalHint).toString());
		cdoQuery.setParameter("kindHint", kindHint);

		queryService.setCacheParameter(cdoQuery);
		final List<Value> values = cdoQuery.getResult(Value.class);
		return values;
	}

	public List<Value> getCapacityFromResource(String expressionName,
			XMLGregorianCalendar from, XMLGregorianCalendar to) {
		final CDOTransaction transaction = provider.getTransaction();
		final CDOQuery cdoQuery = transaction
				.createQuery(
						"hql",
						"select v from Value v, NetXResource res where "
								+ "v in elements(res.capacityValues) "
								+ "and v.timeStamp >= :dateFrom and v.timeStamp <= :dateTo "
								+ "and res.expressionName=:name");
		cdoQuery.setParameter("name", expressionName);
		cdoQuery.setParameter("dateFrom", dateString(from));
		cdoQuery.setParameter("dateTo", dateString(to));

		queryService.setCacheParameter(cdoQuery);
		final List<Value> values = cdoQuery.getResult(Value.class);
		return values;
	}

	public List<Value> getUtilizationFromResource(String expressionName,
			XMLGregorianCalendar from, XMLGregorianCalendar to) {
		final CDOTransaction transaction = provider.getTransaction();
		final CDOQuery cdoQuery = transaction
				.createQuery(
						"hql",
						"select v from Value v, NetXResource res where "
								+ "v in elements(res.utilizationValues) "
								+ "and v.timeStamp >= :dateFrom and v.timeStamp <= :dateTo "
								+ "and res.expressionName=:name");
		cdoQuery.setParameter("name", expressionName);
		cdoQuery.setParameter("dateFrom", dateString(from));
		cdoQuery.setParameter("dateTo", dateString(to));

		queryService.setCacheParameter(cdoQuery);
		final List<Value> values = cdoQuery.getResult(Value.class);
		return values;
	}

	private String dateString(XMLGregorianCalendar date) {
		return XMLTypeFactory.eINSTANCE.convertDateTime(date);
	}

	public List<Value> getSortedValues(MetricValueRange mvr) {

		DateTimeRange createDateTimeRange = GenericsFactory.eINSTANCE
				.createDateTimeRange();
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 5, 1);
		System.out.println(modelUtils.dateAndTime(cal.getTime()));
		createDateTimeRange.setBegin(modelUtils.toXMLDate(cal.getTime()));
		cal.add(Calendar.MONTH, 1);
		createDateTimeRange.setEnd(modelUtils.toXMLDate(cal.getTime()));

		CDOTransaction openTransaction = provider.getSession()
				.openTransaction();

		final CDOQuery cdoQuery = openTransaction
				.createQuery(
						"sql",
						"select val.cdo_id"
								+ " from TM.metrics_metricvaluerange as mvr"
								+ " join TM.metrics_metricvaluerange_metricvalues_list as val_list"
								+ " on val_list.cdo_source = mvr.cdo_id"
								+ " join TM.generics_value as val"
								+ " on val_list.cdo_value = val.cdo_id"
								+ " where mvr.cdo_id = :cdoid"
								+ " order by val.timeStamp0 DESC;");

		Long longValue = ((AbstractCDOIDLong) mvr.cdoID()).getLongValue();
		cdoQuery.setParameter("cdoid", longValue.toString());
		// cdoQuery.setParameter("dateFrom",
		// dateString(createDateTimeRange.getBegin()));
		// cdoQuery.setParameter("dateTo",
		// dateString(createDateTimeRange.getEnd()));

		List<Value> result = cdoQuery.getResult(Value.class);
		return result;
	}
	
	
	/**
	 * Create query text, for external access. 
	 * 
	 * http://work.netxforge.com/issues/312
	 */
	public String getValuesQuery(CDOID container, EReference ref) {
		Long longID = ((AbstractCDOIDLong) container).getLongValue();
		
		// dispatch the range. 
		if( ref == MetricsPackage.Literals.METRIC_VALUE_RANGE__METRIC_VALUES){
			return "select cdo_id, value, timeStamp0 from TM.generics_value where cdo_container = " + longID;
		}else if( ref == LibraryPackage.Literals.NET_XRESOURCE__CAPACITY_VALUES ){
			return "select genValues.cdo_id, genValues.value, genValues.timeStamp0 from TM.library_netxresource_capacityvalues_list " +
			"join TM.generics_value as genValues " + 
			" on TM.library_netxresource_capacityvalues_list.cdo_value = genValues.cdo_id " +
			"where TM.library_netxresource_capacityvalues_list.cdo_source = " + longID + ";";
		}else if( ref == LibraryPackage.Literals.NET_XRESOURCE__UTILIZATION_VALUES ){
			return "select genValues.cdo_id, genValues.value, genValues.timeStamp0 from TM.library_netxresource_utilizationvalues_list " +
			"join TM.generics_value as genValues " + 
			" on TM.library_netxresource_utilizationvalues_list.cdo_value = genValues.cdo_id " +
			"where TM.library_netxresource_utilizationvalues_list.cdo_source = " + longID + ";";
		}
		return "";
	}
}
