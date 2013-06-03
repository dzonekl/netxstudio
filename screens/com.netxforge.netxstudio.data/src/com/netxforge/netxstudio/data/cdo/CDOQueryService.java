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

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOIDLong;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.generics.DateTimeRange;
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
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class CDOQueryService implements IQueryService {

	private IDataProvider provider;

	private CDOQueryUtil queryService;

	@SuppressWarnings("unused")
	private ModelUtils modelUtils;

	private List<CDOTransaction> usedTransactions = Lists.newArrayList();

	private static final String DB_NAME = "TM";

	private boolean CamelCase = true;

	public boolean isCamelCase() {
		return CamelCase;
	}

	public void setCamelCase(boolean camelCase) {
		CamelCase = camelCase;
	}

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

	/**
	 * TODO
	 * 
	 * @deprecated
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

	/**
	 * @TODO
	 * @deprecated
	 */
	public List<Job> getJobWithMetricSource(MetricSource source) {

		CDOTransaction t = provider.getSession().openTransaction();
		CDOQuery q = t.createQuery("hql",
				ICDOQueries.SELECT_JOBS_WITH_METRICSOURCE);
		q.setParameter("metricSource", source);
		queryService.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	/**
	 * @TODO
	 * @deprecated
	 */
	public List<Job> getJobWithService(Service service) {

		CDOTransaction t = provider.getSession().openTransaction();
		CDOQuery q = t.createQuery("hql", ICDOQueries.SELECT_JOBS_WITH_SERVICE);
		q.setParameter("rfsService", service);
		queryService.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	/**
	 * TODO
	 * 
	 * @deprecated
	 */
	public List<Job> getJobWithServiceReporting(Service service) {
		CDOTransaction t = provider.getSession().openTransaction();
		CDOQuery q = t.createQuery("hql",
				ICDOQueries.SELECT_JOBS_WITH_SERVICE_REPORTING);
		q.setParameter("rfsService", service);
		queryService.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	/**
	 * TODO
	 * 
	 * @deprecated
	 */
	public List<Job> getJobWithOperatorReporting(Operator operator) {
		CDOTransaction t = provider.getSession().openTransaction();
		CDOQuery q = t.createQuery("hql",
				ICDOQueries.SELECT_JOBS_WITH_OPERATOR_REPORTING);
		q.setParameter("operator", operator);
		queryService.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	/**
	 * TODO
	 * 
	 * @deprecated
	 */
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

	/**
	 * TODO, Migrate to new API.
	 * 
	 * @deprecated
	 */
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

	/**
	 * TODO, Migrate to new API.
	 * 
	 * @param nodeID
	 * @param name
	 * @return
	 * @deprecated
	 */
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

	/**
	 * TODO Migrate to new API.
	 * 
	 * @deprecated
	 */
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

	/**
	 * TODO Migrate to new API.
	 * 
	 * @deprecated
	 */
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

	public List<Value> capacityValues(CDOView view, NetXResource netXResource,
			String dialect, DateTimeRange period) {
		return capacityValues(view, netXResource, dialect, period, null);
	}

	public List<Value> capacityValues(CDOView view, NetXResource netXResource,
			String dialect, DateTimeRange period, XMLGregorianCalendar date) {

		List<Value> result = null; // Might become assigned.

		String queryString = null;
		if (dialect.equals(QUERY_MYSQL)) {

			StringBuffer sb = new StringBuffer();

			if (!CamelCase) {

				sb.append("select val.cdo_id "
						+ "from "
						+ DB_NAME
						+ ".library_netxresource as res "
						+ "join "
						+ DB_NAME
						+ ".library_netxresource_capacityvalues_list as caps_list "
						+ "on caps_list.cdo_source = res.cdo_id " + "join "
						+ DB_NAME + ".generics_value as val "
						+ "on caps_list.cdo_value = val.cdo_id "
						+ "where res.cdo_id = :res_cdodid");
			} else {
				// TODO, Check CamelCase!
				sb.append("select val.cdo_id "
						+ "from "
						+ DB_NAME
						+ ".library_NetXResource as res "
						+ "join "
						+ DB_NAME
						+ ".library_NetXResource_capacityValues_list as caps_list "
						+ "on caps_list.cdo_source = res.cdo_id " + "join "
						+ DB_NAME + ".generics_value as val "
						+ "on caps_list.cdo_value = val.cdo_id "
						+ "where res.cdo_id = :res_cdodid");
			}
			// period or date is optional.
			if (period != null) {
				sb.append(" and val.timeStamp0 >= :dateFrom and val.timeStamp0 < :dateTo");
			} else if (date != null) {
				sb.append(" and val.timeStamp0 = :date");
			}

			sb.append(" order by val.timeStamp0 DESC;");
			queryString = sb.toString();

		} else if (dialect.equals(QUERY_OCL)) {
			// Syntax for OCL?
			// queryString =
			// "metrics::MetricValueRange.allInstances().metricValues->size()";
			throw new UnsupportedOperationException("OCL query not supported");
		} else if (dialect.equals(QUERY_HQL)) {
			// "select v from Value v, NetXResource res where "
			// + "v in elements(res.capacityValues) "
			// "and res.cdo_id=:res_cdoid"
			throw new UnsupportedOperationException("HQL query not supported");
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				Long longValue = ((AbstractCDOIDLong) netXResource.cdoID())
						.getLongValue();
				cdoQuery.setParameter("res_cdodid", longValue.toString());

				if (period != null) {
					cdoQuery.setParameter("dateFrom",
							dateString(period.getBegin()));
					cdoQuery.setParameter("dateTo", dateString(period.getEnd()));
				} else if (date != null) {
					cdoQuery.setParameter("date", dateString(date));
				}
			} else if (dialect.equals(QUERY_OCL)) {
				cdoQuery = view.createQuery(dialect, queryString,
						netXResource.cdoID());
			}

			if (cdoQuery != null) {
				result = cdoQuery.getResult(Value.class);
			}
		}
		return result;
	}

	public List<Value> utilizationValues(CDOView view,
			NetXResource netXResource, String dialect, DateTimeRange period) {
		return utilizationValues(view, netXResource, dialect, period, null);
	}

	public List<Value> utilizationValues(CDOView view,
			NetXResource netXResource, String dialect, DateTimeRange period,
			XMLGregorianCalendar date) {

		List<Value> result = null; // Might become assigned.

		String queryString = null;
		if (dialect.equals(QUERY_MYSQL)) {

			StringBuffer sb = new StringBuffer();

			if (!CamelCase) {

				sb.append("select val.cdo_id"
						+ "from "
						+ DB_NAME
						+ ".library_netxresource as res "
						+ "join "
						+ DB_NAME
						+ ".library_netxresource_utilizationvalues_list as utils_list "
						+ "on utils_list.cdo_source = res.cdo_id " + "join "
						+ DB_NAME + ".generics_value as val "
						+ "on utils_list.cdo_value = val.cdo_id "
						+ "where res.cdo_id = :res_cdodid");
			} else {
				// TODO, Check CamelCase!
				sb.append("select val.cdo_id "
						+ "from "
						+ DB_NAME
						+ ".library_NetXResource as res "
						+ "join "
						+ DB_NAME
						+ ".library_NetXResource_utilizationValues_list as utils_list "
						+ " on utils_list.cdo_source = res.cdo_id " + "join "
						+ DB_NAME + ".generics_value as val "
						+ "on utils_list.cdo_value = val.cdo_id "
						+ "where res.cdo_id = :res_cdodid");
			}
			// period or date is optional.
			if (period != null) {
				sb.append(" and val.timeStamp0 >= :dateFrom and val.timeStamp0 < :dateTo");
			} else if (date != null) {
				sb.append(" and val.timeStamp0 = :date");
			}

			sb.append(" order by val.timeStamp0 DESC;");
			queryString = sb.toString();

		} else if (dialect.equals(QUERY_OCL)) {
			// Syntax for OCL?
			// queryString =
			// "metrics::MetricValueRange.allInstances().metricValues->size()";
			throw new UnsupportedOperationException("OCL query not supported");
		} else if (dialect.equals(QUERY_HQL)) {
			// "select v from Value v, NetXResource res where "
			// + "v in elements(res.capacityValues) "
			// "and res.cdo_id=:res_cdoid"
			throw new UnsupportedOperationException("HQL query not supported");
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				Long longValue = ((AbstractCDOIDLong) netXResource.cdoID())
						.getLongValue();
				cdoQuery.setParameter("res_cdodid", longValue.toString());

				if (period != null) {
					cdoQuery.setParameter("dateFrom",
							dateString(period.getBegin()));
					cdoQuery.setParameter("dateTo", dateString(period.getEnd()));
				} else if (date != null) {
					cdoQuery.setParameter("date", dateString(date));
				}
			} else if (dialect.equals(QUERY_OCL)) {
				cdoQuery = view.createQuery(dialect, queryString,
						netXResource.cdoID());
			}

			if (cdoQuery != null) {
				result = cdoQuery.getResult(Value.class);
			}
		}
		return result;
	}

	private String dateString(XMLGregorianCalendar date) {
		return XMLTypeFactory.eINSTANCE.convertDateTime(date);
	}

	public List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect) {
		return mvrValues(view, mvr, dialect, null, null);
	}

	public List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect, XMLGregorianCalendar date) {
		return mvrValues(view, mvr, dialect, null, date);
	}

	public List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect, DateTimeRange period) {
		return mvrValues(view, mvr, dialect, period, null);
	}

	public List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect, DateTimeRange period, XMLGregorianCalendar date) {

		List<Value> result = null; // Might become assigned.

		String queryString = null;
		if (dialect.equals(QUERY_MYSQL)) {

			StringBuffer sb = new StringBuffer();

			if (!CamelCase) {
				sb.append("select val.cdo_id"
						+ " from "
						+ DB_NAME
						+ ".metrics_metricvaluerange as mvr"
						+ " join "
						+ DB_NAME
						+ ".metrics_metricvaluerange_metricvalues_list as val_list"
						+ " on val_list.cdo_source = mvr.cdo_id" + " join "
						+ DB_NAME + ".generics_value as val"
						+ " on val_list.cdo_value = val.cdo_id"
						+ " where mvr.cdo_id = :mvr_cdoid");
			} else {
				sb.append("select val.cdo_id"
						+ " from "
						+ DB_NAME
						+ ".metrics_MetricValueRange as mvr"
						+ " join "
						+ DB_NAME
						+ ".metrics_MetricValueRange_metricValues_list as val_list"
						+ " on val_list.cdo_source = mvr.cdo_id" + " join "
						+ DB_NAME + ".generics_Value as val"
						+ " on val_list.cdo_value = val.cdo_id"
						+ " where mvr.cdo_id = :mvr_cdoid");
			}
			// period or date is optional.
			if (period != null) {
				sb.append(" and val.timeStamp0 >= :dateFrom and val.timeStamp0 < :dateTo");
			} else if (date != null) {
				sb.append(" and val.timeStamp0 = :date");
			}

			sb.append(" order by val.timeStamp0 DESC;");
			queryString = sb.toString();

		} else if (dialect.equals(QUERY_OCL)) {
			// Syntax for OCL?
			queryString = "metrics::MetricValueRange.allInstances().metricValues->size()";
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				Long longValue = ((AbstractCDOIDLong) mvr.cdoID())
						.getLongValue();
				cdoQuery.setParameter("mvr_cdoid", longValue.toString());

				if (period != null) {
					cdoQuery.setParameter("dateFrom",
							dateString(period.getBegin()));
					cdoQuery.setParameter("dateTo", dateString(period.getEnd()));
				} else if (date != null) {
					cdoQuery.setParameter("date", dateString(date));

				}

			} else if (dialect.equals(QUERY_OCL)) {
				cdoQuery = view.createQuery(dialect, queryString, mvr.cdoID());
			}

			if (cdoQuery != null) {
				result = cdoQuery.getResult(Value.class);
			}
		}
		return result;
	}

	/**
	 * DO NOT USE
	 * 
	 * @deprecated
	 */
	public List<Value> removeMvrValues(CDOView view, MetricValueRange mvr,
			String dialect, XMLGregorianCalendar date) {
		return removeMvrValues(view, mvr, dialect, null, date);
	}

	/**
	 * DO NOT USE
	 * 
	 * @deprecated
	 */
	public List<Value> removeMvrValues(CDOView view, MetricValueRange mvr,
			String dialect, DateTimeRange period) {
		return removeMvrValues(view, mvr, dialect, period, null);
	}

	/**
	 * DO NOT USE
	 * 
	 * @deprecated
	 */
	public List<Value> removeMvrValues(CDOView view, MetricValueRange mvr,
			String dialect, DateTimeRange period, XMLGregorianCalendar date) {

		List<Value> result = null; // Might become assigned.

		String queryString = null;
		if (dialect.equals(QUERY_MYSQL)) {

			StringBuffer sb = new StringBuffer();

			if (!CamelCase) {
				sb.append("delete from "
						+ DB_NAME
						+ ".metrics_metricvaluerange as mvr"
						+ " join "
						+ DB_NAME
						+ ".metrics_metricvaluerange_metricvalues_list as val_list"
						+ " on val_list.cdo_source = mvr.cdo_id" + " join "
						+ DB_NAME + ".generics_value as val"
						+ " on val_list.cdo_value = val.cdo_id"
						+ " where mvr.cdo_id = :mvr_cdoid");
			} else {
				sb.append("delete from "
						+ DB_NAME
						+ ".metrics_MetricValueRange as mvr"
						+ " join "
						+ DB_NAME
						+ ".metrics_MetricValueRange_metricValues_list as val_list"
						+ " on val_list.cdo_source = mvr.cdo_id" + " join "
						+ DB_NAME + ".generics_Value as val"
						+ " on val_list.cdo_value = val.cdo_id"
						+ " where mvr.cdo_id = :mvr_cdoid");
			}
			// period or date is optional.
			if (period != null) {
				sb.append(" and val.timeStamp0 >= :dateFrom and val.timeStamp0 < :dateTo");
			} else if (date != null) {
				sb.append(" and val.timeStamp0 = :date");
			}

			// order by not supported in join.
			// sb.append(" order by val.timeStamp0 DESC;");
			sb.append(";");
			queryString = sb.toString();

		} else if (dialect.equals(QUERY_OCL)) {
			// Syntax for OCL?
			queryString = "metrics::MetricValueRange.allInstances().metricValues->size()";
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				Long longValue = ((AbstractCDOIDLong) mvr.cdoID())
						.getLongValue();
				cdoQuery.setParameter("mvr_cdoid", longValue.toString());

				if (period != null) {
					cdoQuery.setParameter("dateFrom",
							dateString(period.getBegin()));
					cdoQuery.setParameter("dateTo", dateString(period.getEnd()));
				} else if (date != null) {
					cdoQuery.setParameter("date", dateString(date));

				}

			} else if (dialect.equals(QUERY_OCL)) {
				cdoQuery = view.createQuery(dialect, queryString, mvr.cdoID());
			}

			if (cdoQuery != null) {
				result = cdoQuery.getResult(Value.class);
			}
		}
		return result;
	}

	public List<Value> getDuplicateValues(CDOView view, MetricValueRange mvr,
			String dialect) {

		List<Value> result = null; // Might become assigned.

		String queryString = null;
		if (dialect.equals(QUERY_MYSQL)) {

			StringBuffer sb = new StringBuffer();
			if (!CamelCase) {
				sb.append("select a.cdo_id from " + DB_NAME
						+ ".generics_value AS a ");
				sb.append("inner join " + DB_NAME + ".generics_value AS b ");
				sb.append("where a.timeStamp0 = b.timeStamp0 and a.cdo_container=:mvr_cdoid and b.cdo_container=:mvr_cdoid ");
				sb.append("and a.cdo_id <> b.cdo_id");
			} else {
				sb.append("select a.cdo_id from " + DB_NAME
						+ ".generics_Value AS a ");
				sb.append("inner join " + DB_NAME + ".generics_Value AS b ");
				sb.append("where a.timeStamp0 = b.timeStamp0 and a.cdo_container=:mvr_cdoid and b.cdo_container=:mvr_cdoid ");
				sb.append("and a.cdo_id <> b.cdo_id");
			}
			queryString = sb.toString();

		} else if (dialect.equals(QUERY_OCL)) {
			// Syntax for OCL?
			queryString = "self.";
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				Long longValue = ((AbstractCDOIDLong) mvr.cdoID())
						.getLongValue();
				cdoQuery.setParameter("mvr_cdoid", longValue.toString());
			} else if (dialect.equals(QUERY_OCL)) {
				cdoQuery = view.createQuery(dialect, queryString, mvr.cdoID());
			}

			if (cdoQuery != null) {
				result = cdoQuery.getResult(Value.class);
			}
		}
		return result;
	}

	// public List<Value> getSortedValues(MetricValueRange mvr) {
	//
	// DateTimeRange createDateTimeRange = GenericsFactory.eINSTANCE
	// .createDateTimeRange();
	// Calendar cal = Calendar.getInstance();
	// cal.set(2012, 5, 1);
	// System.out.println(modelUtils.dateAndTime(cal.getTime()));
	// createDateTimeRange.setBegin(modelUtils.toXMLDate(cal.getTime()));
	// cal.add(Calendar.MONTH, 1);
	// createDateTimeRange.setEnd(modelUtils.toXMLDate(cal.getTime()));
	//
	// CDOTransaction openTransaction = provider.getSession()
	// .openTransaction();
	//
	// final CDOQuery cdoQuery = openTransaction
	// .createQuery(
	// "sql",
	// "select val.cdo_id"
	// + " from TM.metrics_metricvaluerange as mvr"
	// + " join TM.metrics_metricvaluerange_metricvalues_list as val_list"
	// + " on val_list.cdo_source = mvr.cdo_id"
	// + " join TM.generics_value as val"
	// + " on val_list.cdo_value = val.cdo_id"
	// + " where mvr.cdo_id = :cdoid"
	// + " order by val.timeStamp0 DESC;");
	//
	// Long longValue = ((AbstractCDOIDLong) mvr.cdoID()).getLongValue();
	// cdoQuery.setParameter("cdoid", longValue.toString());
	// // cdoQuery.setParameter("dateFrom",
	// // dateString(createDateTimeRange.getBegin()));
	// // cdoQuery.setParameter("dateTo",
	// // dateString(createDateTimeRange.getEnd()));
	//
	// List<Value> result = cdoQuery.getResult(Value.class);
	// return result;
	// }

	/**
	 * 
	 * Supported for MYSQL.
	 * 
	 * @param transaction
	 * @param dialect
	 * @return
	 */
	public List<NetXResource> getUnconnectedResources(CDOView view,
			String dialect) {

		if (dialect.equals(QUERY_MYSQL)) {
			final CDOQuery cdoQuery = view
					.createQuery(
							"sql",
							"select * from TM.library_NetXResource where componentRef IS NULL and cdo_version > 0;");

			List<NetXResource> result = cdoQuery.getResult(NetXResource.class);
			return result;
		} else {
			return null;
		}
	}

	/**
	 * Create query text, for external access.
	 * 
	 * http://work.netxforge.com/issues/312
	 */
	public String getValuesQuery(CDOID container, EReference ref) {
		Long longID = ((AbstractCDOIDLong) container).getLongValue();

		// dispatch the range.
		if (ref == MetricsPackage.Literals.METRIC_VALUE_RANGE__METRIC_VALUES) {
			return "select cdo_id, value, timeStamp0 from TM.generics_value where cdo_container = "
					+ longID;
		} else if (ref == LibraryPackage.Literals.NET_XRESOURCE__CAPACITY_VALUES) {
			return "select genValues.cdo_id, genValues.value, genValues.timeStamp0 from TM.library_netxresource_capacityvalues_list "
					+ "join TM.generics_value as genValues "
					+ " on TM.library_netxresource_capacityvalues_list.cdo_value = genValues.cdo_id "
					+ "where TM.library_netxresource_capacityvalues_list.cdo_source = "
					+ longID + ";";
		} else if (ref == LibraryPackage.Literals.NET_XRESOURCE__UTILIZATION_VALUES) {
			return "select genValues.cdo_id, genValues.value, genValues.timeStamp0 from TM.library_netxresource_utilizationvalues_list "
					+ "join TM.generics_value as genValues "
					+ " on TM.library_netxresource_utilizationvalues_list.cdo_value = genValues.cdo_id "
					+ "where TM.library_netxresource_utilizationvalues_list.cdo_source = "
					+ longID + ";";
		}
		return "";
	}
}
