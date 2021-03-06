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

import static com.netxforge.netxstudio.data.cdo.CDOQueryUtil.dateString;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EReference;

import com.netxforge.base.cdo.CDO;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;

/**
 * Static queries.
 * 
 * TODO: As some of the methods need to be parameterized (Like the Style being
 * CAMEL or non-CAMEL case or the DB Name to use for SQL queries.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class CDOQueryService {

	private static final String ORDER_BY_VAL_TIME_STAMP0_ASC = " order by val.timeStamp0 ASC;";

	private static final String ORDER_BY_VAL_TIME_STAMP0_DSC = " order by val.timeStamp0 DESC";

	private static final String DB_NAME = "TM";

	private static final String SELECT_MVR_NON_CAMEL = "select val.cdo_id"
			+ " from " + DB_NAME
			+ ".metrics_metricvaluerange_metricvalues_list as val_list join "
			+ DB_NAME + ".generics_value as val"
			+ " on val_list.cdo_value = val.cdo_id"
			+ " where val_list.cdo_source = :mvr_cdoid";

	private static final String SELECT_MVR_CAMEL = "select val.cdo_id"
			+ " from " + DB_NAME
			+ ".metrics_MetricValueRange_metricValues_list as val_list join "
			+ DB_NAME + ".generics_Value as val"
			+ " on val_list.cdo_value = val.cdo_id"
			+ " where val_list.cdo_source = :mvr_cdoid";

	private static final String SELECT_MAXTS0_NON_CAMEL = "select max(timeStamp0)"
			+ " from "
			+ DB_NAME
			+ ".metrics_metricvaluerange_metricvalues_list as val_list join "
			+ DB_NAME
			+ ".generics_value as val"
			+ " on val_list.cdo_value = val.cdo_id"
			+ " where val_list.cdo_source = :mvr_cdoid";

	private static final String SELECT_MAXTS0_CAMEL = "select max(timeStamp0)"
			+ " from " + DB_NAME
			+ ".metrics_MetricValueRange_metricValues_list as val_list join "
			+ DB_NAME + ".generics_Value as val"
			+ " on val_list.cdo_value = val.cdo_id"
			+ " where val_list.cdo_source = :mvr_cdoid";

	private static final String LIMIT_ONE = " limit 1;";

	private static final String VALUE_PERIOD = " and val.timeStamp0 >= :dateFrom and val.timeStamp0 < :dateTo";

	private static final String VALUE_TS = " and val.timeStamp0 = :date";

	private static final String VALUE_TO_TS = " and val.timeStamp0 < :date";

	/**
	 * SQL Databases need the statements to be in a certain style.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public static enum STYLE {
		CAMEL_CASE, NON_CAMEL_CASE;
	}

	/**
	 * 
	 * @param view
	 * @param netXResource
	 * @param dialect
	 * @param period
	 * @return
	 */
	public static List<Value> capacityValues(CDOView view,
			NetXResource netXResource, String dialect, XMLGregorianCalendar date) {
		return capacityValues(view, netXResource, dialect, null, date,
				STYLE.CAMEL_CASE);
	}

	/**
	 * Get a {@link List collection} of values from
	 * {@link LibraryPackage.Literals#NET_XRESOURCE__CAPACITY_VALUES capacity
	 * range} for the given period or upto the given date.
	 * 
	 * @param view
	 * @param netXResource
	 * @param dialect
	 * @param period
	 * @param date
	 * @param style
	 * @return
	 */
	public static List<Value> capacityValues(CDOView view,
			NetXResource netXResource, String dialect, DateTimeRange period,
			XMLGregorianCalendar date, STYLE style) {

		List<Value> result = null; // Might become assigned.

		String queryString = null;
		if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {

			StringBuffer sb = new StringBuffer();

			if (style == STYLE.NON_CAMEL_CASE) {

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
				sb.append("select val.cdo_id "
						+ "from "
						+ DB_NAME
						+ ".library_NetXResource as res "
						+ "join "
						+ DB_NAME
						+ ".library_NetXResource_capacityValues_list as caps_list "
						+ "on caps_list.cdo_source = res.cdo_id " + "join "
						+ DB_NAME + ".generics_Value as val "
						+ "on caps_list.cdo_value = val.cdo_id "
						+ "where res.cdo_id = :res_cdodid");
			}
			// period or date is optional.
			if (period != null) {
				sb.append(" and val.timeStamp0 >= :dateFrom and val.timeStamp0 < :dateTo");
			} else if (date != null) {
				sb.append(VALUE_TO_TS);
			}

			sb.append(" order by val.timeStamp0 DESC;");
			queryString = sb.toString();

		} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
			// Syntax for OCL?
			// queryString =
			// "metrics::MetricValueRange.allInstances().metricValues->size()";
			throw new UnsupportedOperationException("OCL query not supported");
		} else if (dialect.equals(CDOQueryUtil.QUERY_HQL)) {
			// "select v from Value v, NetXResource res where "
			// + "v in elements(res.capacityValues) "
			// "and res.cdo_id=:res_cdoid"
			throw new UnsupportedOperationException("HQL query not supported");
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				String cdoLongIDAsString = CDO.cdoLongIDAsString(netXResource);
				cdoQuery.setParameter("res_cdodid", cdoLongIDAsString);

				if (period != null) {
					cdoQuery.setParameter("dateFrom",
							dateString(period.getBegin()));
					cdoQuery.setParameter("dateTo", dateString(period.getEnd()));
				} else if (date != null) {
					cdoQuery.setParameter("date", dateString(date));
				}
			} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
				cdoQuery = view.createQuery(dialect, queryString,
						netXResource.cdoID());
			}

			if (cdoQuery != null) {
				result = cdoQuery.getResult(Value.class);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param view
	 * @param netXResource
	 * @param dialect
	 * @param period
	 * @return
	 */
	public static List<Value> utilizationValues(CDOView view,
			NetXResource netXResource, String dialect, XMLGregorianCalendar date) {
		return utilizationValues(view, netXResource, dialect, null, date,
				STYLE.CAMEL_CASE);
	}

	/**
	 * Get a {@link List collection} of values from
	 * {@link LibraryPackage.Literals#NET_XRESOURCE__UTILIZATION_VALUES capacity
	 * range} for the given period or upto the given date.
	 * 
	 * @param view
	 * @param netXResource
	 * @param dialect
	 * @param period
	 * @param date
	 * @param style
	 * @return
	 */
	public static List<Value> utilizationValues(CDOView view,
			NetXResource netXResource, String dialect, DateTimeRange period,
			XMLGregorianCalendar date, STYLE style) {

		List<Value> result = null; // Might become assigned.

		String queryString = null;
		if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {

			StringBuffer sb = new StringBuffer();

			if (style == STYLE.NON_CAMEL_CASE) {

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
						+ DB_NAME + ".generics_Value as val "
						+ "on utils_list.cdo_value = val.cdo_id "
						+ "where res.cdo_id = :res_cdodid");
			}
			// period or date is optional.
			if (period != null) {
				sb.append(" and val.timeStamp0 >= :dateFrom and val.timeStamp0 < :dateTo");
			} else if (date != null) {
				sb.append(VALUE_TS);
			}

			sb.append(" order by val.timeStamp0 DESC;");
			queryString = sb.toString();

		} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
			// Syntax for OCL?
			// queryString =
			// "metrics::MetricValueRange.allInstances().metricValues->size()";
			throw new UnsupportedOperationException("OCL query not supported");
		} else if (dialect.equals(CDOQueryUtil.QUERY_HQL)) {
			// "select v from Value v, NetXResource res where "
			// + "v in elements(res.capacityValues) "
			// "and res.cdo_id=:res_cdoid"
			throw new UnsupportedOperationException("HQL query not supported");
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				String cdoLongIDAsString = CDO.cdoLongIDAsString(netXResource);
				cdoQuery.setParameter("res_cdodid", cdoLongIDAsString);

				if (period != null) {
					cdoQuery.setParameter("dateFrom",
							dateString(period.getBegin()));
					cdoQuery.setParameter("dateTo", dateString(period.getEnd()));
				} else if (date != null) {
					cdoQuery.setParameter("date", dateString(date));
				}
			} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
				cdoQuery = view.createQuery(dialect, queryString,
						netXResource.cdoID());
			}

			if (cdoQuery != null) {
				result = cdoQuery.getResult(Value.class);
			}
		}
		return result;
	}

	/**
	 * Default Query style is: {@link STYLE#NON_CAMEL_CASE}.
	 * 
	 * @param cdoView
	 * @param mvr
	 * @param dialect
	 * @return
	 * @see #mvrMaxTimestamp0(CDOView, MetricValueRange, String, STYLE)
	 * 
	 */
	public static Object mvrMaxTimestamp0(CDOView view, MetricValueRange mvr,
			String dialect) {
		return mvrMaxTimestamp0(view, mvr, dialect, STYLE.NON_CAMEL_CASE);
	}

	/**
	 * Creates a query which looks like this:
	 * 
	 * @param view
	 * @param mvr
	 * @param dialect
	 * @param style
	 * @return
	 */
	public static Object mvrMaxTimestamp0(CDOView view, MetricValueRange mvr,
			String dialect, STYLE style) {

		List<? extends Object> result = null; // Might become assigned.

		String queryString = "";
		if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {

			queryString = queryString
					.concat(style == STYLE.NON_CAMEL_CASE ? SELECT_MAXTS0_NON_CAMEL
							: SELECT_MAXTS0_CAMEL);

		} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
			throw new UnsupportedOperationException("OCL not supported");
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				String cdoLongIDAsString = CDO.cdoLongIDAsString(mvr);
				cdoQuery.setParameter("mvr_cdoid", cdoLongIDAsString);
			}
			if (cdoQuery != null) {
				result = cdoQuery.getResult(XMLGregorianCalendar.class);
			}
		}
		return result;
	}

	/**
	 * Default Query style is: {@link STYLE#NON_CAMEL_CASE}.
	 * 
	 * @param cdoView
	 * @param mvr
	 * @param dialect
	 * @return
	 * @See {@link #mvrValueLastFirstLimitOne(CDOView, MetricValueRange, String, STYLE)}
	 * 
	 */
	public static List<Value> mvrValueLastFirstLimitOne(CDOView cdoView,
			MetricValueRange mvr, String dialect) {
		return mvrValueLastFirstLimitOne(cdoView, mvr, dialect,
				STYLE.CAMEL_CASE);
	}

	/**
	 * Return a {@link List collection} of one {@link Value} which is the most
	 * recent value in the the {@link MetricValueRange range}.
	 * 
	 * @param view
	 * @param mvr
	 * @param dialect
	 * @param style
	 * @return
	 */
	public static List<Value> mvrValueLastFirstLimitOne(CDOView view,
			MetricValueRange mvr, String dialect, STYLE style) {

		List<Value> result = null; // Might become assigned.

		String queryString = "";
		if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {

			queryString = queryString
					.concat(style == STYLE.NON_CAMEL_CASE ? SELECT_MVR_NON_CAMEL
							: SELECT_MVR_CAMEL);
			queryString = queryString.concat(ORDER_BY_VAL_TIME_STAMP0_DSC);
			queryString = queryString.concat(LIMIT_ONE);

		} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
			throw new UnsupportedOperationException("OCL not supported");
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				String cdoLongIDAsString = CDO.cdoLongIDAsString(mvr);
				cdoQuery.setParameter("mvr_cdoid", cdoLongIDAsString);
			}
			if (cdoQuery != null) {
				result = cdoQuery.getResult(Value.class);
			}
		}
		return result;
	}

	public static List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect) {
		return mvrValues(view, mvr, dialect, null, null, STYLE.CAMEL_CASE,
				false);
	}

	public static List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect, XMLGregorianCalendar date) {
		return mvrValues(view, mvr, dialect, null, date, STYLE.CAMEL_CASE,
				false);
	}

	public static List<Value> mvrValuesPriortoDate(CDOView view,
			MetricValueRange mvr, String dialect, XMLGregorianCalendar date) {
		return mvrValues(view, mvr, dialect, null, date, STYLE.CAMEL_CASE, true);
	}

	public static List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect, DateTimeRange period) {
		return mvrValues(view, mvr, dialect, period, null, STYLE.CAMEL_CASE,
				false);
	}

	public static List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect, DateTimeRange period, XMLGregorianCalendar date,
			STYLE style, boolean allPriorToDate) {

		List<Value> result = null; // Might become assigned.

		String queryString = "";
		if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {

			queryString = queryString
					.concat(style == STYLE.NON_CAMEL_CASE ? SELECT_MVR_NON_CAMEL
							: SELECT_MVR_CAMEL);
			queryString = queryString
					.concat(period != null ? VALUE_PERIOD : "");

			if (date != null) {
				queryString = queryString.concat(allPriorToDate ? VALUE_TO_TS
						: VALUE_TS);
			}

			queryString = queryString.concat(ORDER_BY_VAL_TIME_STAMP0_ASC);

		} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
			// Syntax for OCL?
			queryString = "metrics::MetricValueRange.allInstances().metricValues->size()";
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				String cdoLongIDAsString = CDO.cdoLongIDAsString(mvr);
				cdoQuery.setParameter("mvr_cdoid", cdoLongIDAsString);

				if (period != null) {
					cdoQuery.setParameter("dateFrom",
							dateString(period.getBegin()));
					cdoQuery.setParameter("dateTo", dateString(period.getEnd()));
				} else if (date != null) {
					cdoQuery.setParameter("date", dateString(date));

				}

			} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
				cdoQuery = view.createQuery(dialect, queryString, mvr.cdoID());
			}

			if (cdoQuery != null) {
				result = cdoQuery.getResult(Value.class);
			}
		}
		return result;
	}

	/**
	 */
	public static List<Value> removeMvrValues(CDOView view,
			MetricValueRange mvr, String dialect, XMLGregorianCalendar date) {
		return removeMvrValues(view, mvr, dialect, null, date,
				STYLE.NON_CAMEL_CASE);
	}

	/**
	 */
	public static List<Value> removeMvrValues(CDOView view,
			MetricValueRange mvr, String dialect, DateTimeRange period) {
		return removeMvrValues(view, mvr, dialect, period, null,
				STYLE.NON_CAMEL_CASE);
	}

	/**
	 */
	public static List<Value> removeMvrValues(CDOView view,
			MetricValueRange mvr, String dialect, DateTimeRange period,
			XMLGregorianCalendar date, STYLE style) {

		List<Value> result = null; // Might become assigned.

		String queryString = null;
		if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {

			StringBuffer sb = new StringBuffer();

			if (style == STYLE.NON_CAMEL_CASE) {
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
				sb.append(VALUE_TS);
			}

			// order by not supported in join.
			// sb.append(" order by val.timeStamp0 DESC;");
			sb.append(";");
			queryString = sb.toString();

		} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
			// Syntax for OCL?
			queryString = "metrics::MetricValueRange.allInstances().metricValues->size()";
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				String cdoLongIDAsString = CDO.cdoLongIDAsString(mvr);
				cdoQuery.setParameter("mvr_cdoid", cdoLongIDAsString);

				if (period != null) {
					cdoQuery.setParameter("dateFrom",
							dateString(period.getBegin()));
					cdoQuery.setParameter("dateTo", dateString(period.getEnd()));
				} else if (date != null) {
					cdoQuery.setParameter("date", dateString(date));

				}

			} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
				cdoQuery = view.createQuery(dialect, queryString, mvr.cdoID());
			}

			if (cdoQuery != null) {
				result = cdoQuery.getResult(Value.class);
			}
		}
		return result;
	}

	public static List<Value> getDuplicateValues(CDOView view,
			MetricValueRange mvr, String dialect) {
		return getDuplicateValues(view, mvr, dialect, STYLE.NON_CAMEL_CASE);
	}

	public static List<Value> getDuplicateValues(CDOView view,
			MetricValueRange mvr, String dialect, STYLE style) {

		List<Value> result = null; // Might become assigned.

		String queryString = null;
		if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {

			StringBuffer sb = new StringBuffer();
			if (style == STYLE.NON_CAMEL_CASE) {
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

		} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
			// Syntax for OCL?
			queryString = "self.";
		}

		if (queryString != null) {

			CDOQuery cdoQuery = null;

			if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {
				cdoQuery = view.createQuery(dialect, queryString);
				String cdoLongIDAsString = CDO.cdoLongIDAsString(mvr);
				cdoQuery.setParameter("mvr_cdoid", cdoLongIDAsString);
			} else if (dialect.equals(CDOQueryUtil.QUERY_OCL)) {
				cdoQuery = view.createQuery(dialect, queryString, mvr.cdoID());
			}

			if (cdoQuery != null) {
				result = cdoQuery.getResult(Value.class);
			}
		}
		return result;
	}

	/**
	 * 
	 * Supported for MYSQL.
	 * 
	 * @param transaction
	 * @param dialect
	 * @return
	 */
	public static List<NetXResource> getUnconnectedResources(CDOView view,
			String dialect) {

		if (dialect.equals(CDOQueryUtil.QUERY_MYSQL)) {
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
	public static String getValuesQuery(CDOID container, EReference ref) {
		String longID = CDO.cdoLongIDAsString(container);

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
