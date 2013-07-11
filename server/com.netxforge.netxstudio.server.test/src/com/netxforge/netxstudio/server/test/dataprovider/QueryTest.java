/*******************************************************************************
 * Copyright (c) 18 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.server.test.dataprovider;

import java.util.Calendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.session.CDORepositoryInfo;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;

public class QueryTest extends AbstractDataServiceTest4 {

	@Inject
	private ModelUtils modelUtils;
	
	@Before
	public void before(){
		this.getClientInjector().injectMembers(this);
	}
	
	
	@Test
	public void test1_CDO_SQL_QUERY() {

		service.getProvider().openSession("admin", "admin");

		// Resolve the object from an existing resource.

		// Use a new view to execute the query.
		CDOView cdoView = service.getProvider().getSession().openView();

		// Find a single value in for a date. (Hard coded OID and date!).
		System.out.println(doQuerySingleValue(cdoView,
				IQueryService.QUERY_MYSQL));

		cdoView.close();
	}

	@Test
	public void test2_CDO_SQL_QUERY() {

		service.getProvider().openSession("admin", "admin");

		// Resolve the object from an existing resource.

		// Use a new view to execute the query.
		CDOView cdoView = service.getProvider().getSession().openView();

		// Find values in a period. (Hard coded OID and period!).
		System.out.println(doQueryValues(cdoView, IQueryService.QUERY_MYSQL));

		// Perform twice.
		System.out.println(doQueryValues(cdoView, IQueryService.QUERY_MYSQL));

		cdoView.close();

	}

	// @Test
	public void test3_CDO_SQL_QUERY() {

		service.getProvider().openSession("admin", "admin");

		// Resolve the object from an existing resource.

		// Use a new view to execute the query.
		CDOView cdoView = service.getProvider().getSession().openView();

		// Perform twice to see effect of caching.
		// Query Syntax wrong.
		doQueryAllResourcesAllRanges(cdoView, IQueryService.QUERY_OCL, true);
		doQueryAllResourcesAllRanges(cdoView, IQueryService.QUERY_OCL, true);

		cdoView.close();

	}

	@Test
	public void test4_CDO_SQL_QUERY() {

		service.getProvider().openSession("admin", "admin");
		// Use a new view to execute the query.
		CDOView cdoView = service.getProvider().getSession().openView();
		// Resolve the object from an existing resource.
		doQueryValues_CS(cdoView, IQueryService.QUERY_OCL);

		cdoView.close();

	}

	/**
	 * Do a case sensitive query to the DB.
	 * 
	 * @param cdoView
	 * @param dialect
	 * @return
	 */
	private String doQueryValues_CS(CDOView cdoView, String dialect) {
		@SuppressWarnings("unused")
		CDORepositoryInfo repositoryInfo = cdoView.getSession()
				.getRepositoryInfo();

		return "";
	}

	private String doQueryValues(CDOView cdoView, String dialect) {

		DateTimeRange dtr = GenericsFactory.eINSTANCE.createDateTimeRange();

		// Get the period.
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 4, 13);
		modelUtils.adjustToDayStart(cal);

		dtr.setBegin(modelUtils.toXMLDate(cal.getTime()));

		cal.add(Calendar.HOUR_OF_DAY, 24);
		modelUtils.adjustToDayStart(cal);
		dtr.setEnd(modelUtils.toXMLDate(cal.getTime()));

		String objectID = "46639";

		CDOID createLongWithClassifier = CDOIDUtil
				.createLongWithClassifier(new CDOClassifierRef(
						MetricsPackage.Literals.METRIC_VALUE_RANGE), Long
						.parseLong(objectID));

		// This should be a MetricValueRange object.

		CDOObject object = cdoView.getObject(createLongWithClassifier);

		IQueryService queryService = service.getQueryService();

		List<Value> sortedValues = queryService.mvrValues(cdoView,
				(MetricValueRange) object, dialect, dtr);

		return " found " + sortedValues.size() + " for object: "
				+ object.cdoRevision() + " in period "
				+ modelUtils.dateAndTime(dtr.getBegin()) + " to "
				+ modelUtils.dateAndTime(dtr.getEnd());

	}
	
	
	/**
	 * Uses an OBJECTID, WRONG TEST.  
	 * 
	 * @param cdoView
	 * @param dialect
	 * @return
	 */
	private String doQuerySingleValue(CDOView cdoView, String dialect) {

		// Get the period.
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 4, 13);
		modelUtils.adjustToDayStart(cal);

		XMLGregorianCalendar xmlDate = modelUtils.toXMLDate(cal.getTime());

		String objectID = "46639";

		CDOID createLongWithClassifier = CDOIDUtil
				.createLongWithClassifier(new CDOClassifierRef(
						MetricsPackage.Literals.METRIC_VALUE_RANGE), Long
						.parseLong(objectID));

		// This should be a MetricValueRange object.

		CDOObject object = cdoView.getObject(createLongWithClassifier);

		IQueryService queryService = service.getQueryService();

		List<Value> sortedValues = queryService.mvrValues(cdoView,
				(MetricValueRange) object, dialect, xmlDate);

		return " found " + sortedValues.size() + " for object: "
				+ object.cdoRevision() + " for date "
				+ modelUtils.dateAndTime(xmlDate);

	}

	/**
	 * @param cdoView
	 */
	private String doQueryAllResourcesAllRanges(CDOView cdoView,
			String dialect, boolean performance) {
		CDOResourceNode folder = cdoView.getResourceNode("/Node_/");

		int sumResources = 0;
		int sumRanges = 0;
		int sumValues = 0;

		// Limit the number of netXResources, to save some time.
		int numOfNetXResourceToQuery = 3;

		// determine the duration of the query.
		long totalTime = System.nanoTime();

		// Loop through all CDO resources under this CDO folder.

		// Name is produced as: LibraryPackage.Literals.NET_XRESOURCE.getName()
		// + "_" + "sgrstp01";

		if (folder instanceof CDOResourceFolder) {
			for (CDOResourceNode n : ((CDOResourceFolder) folder).getNodes()) {
				if (n instanceof CDOResource) {
					CDOResource resource = (CDOResource) n;
					// The CDO Resource will contain many NetXResource
					if (!performance) {
						System.out
								.println("Number of NetXResource in CDOResource: "
										+ resource.getName()
										+ " : "
										+ resource.getContents().size());
					}

					for (int i = 0; i < resource.getContents().size()
							&& i < numOfNetXResourceToQuery; i++) {
						EObject eo = resource.getContents().get(i);
						if (eo instanceof NetXResource) {
							NetXResource res = (NetXResource) eo;
							sumResources++;
							if (!performance) {
								Component componentRef = res.getComponentRef();
								System.out
										.println(" NetXResource: "
												+ res.getExpressionName()
												+ " cdo: " + res.cdoRevision()
												+ componentRef != null ? " from component"
												+ modelUtils
														.printModelObject(componentRef)
												: "");
							}
							for (MetricValueRange mvr : res
									.getMetricValueRanges()) {

								if (!performance) {
									System.out.println(" MetricValueRange: "
											+ mvr.getIntervalHint()
											+ mvr.getKindHint() + " cdo: "
											+ mvr.cdoRevision());
								}
								sumRanges++;
								IQueryService queryService = service
										.getQueryService();

								// determine the duration of the query.
								long startTime = System.nanoTime();

								List<Value> sortedValues = queryService
										.mvrValues(cdoView, mvr, dialect);

								String timeDurationNano = modelUtils
										.timeDurationNanoElapsed(startTime);

								if (sortedValues != null) {

									sumValues += sortedValues.size();

									if (!sortedValues.isEmpty()) {
										Value lastValue = sortedValues
												.get(sortedValues.size() - 1);
										if (!performance) {
											System.out.println("  Mvr:"
													+ mvr.getIntervalHint()
													+ mvr.getKindHint()
													+ " last value ("
													+ (sortedValues.size() - 1)
													+ ") "
													+ this.modelUtils
															.value(lastValue)
													+ " cdo: "
													+ lastValue.cdoRevision()
													+ " in: "
													+ timeDurationNano);
										}
									} else {
										if (!performance) {
											System.out.println("  Mvr:"
													+ mvr.getIntervalHint()
													+ mvr.getKindHint()
													+ " empty, in: "
													+ timeDurationNano);
										}
									}
								}
							}
						}
					}
				}
			}
		}

		String timeDurationNano = modelUtils.timeDurationNanoElapsed(totalTime);

		return " NetXResource: " + sumResources + ", MetricValueRange: "
				+ sumRanges + " Value: " + sumValues + " in: "
				+ timeDurationNano;
	}

	 @Test
	public void testValueQuery() {

		String funtionName = "Mobility";
		DateTimeRange createDateTimeRange = GenericsFactory.eINSTANCE
				.createDateTimeRange();

		Calendar cal = Calendar.getInstance();
		cal.set(2012, 5, 1);
		System.out.println(modelUtils.dateAndTime(cal.getTime()));
		createDateTimeRange.setBegin(modelUtils.toXMLDate(cal.getTime()));
		cal.add(Calendar.MONTH, 1);
		createDateTimeRange.setEnd(modelUtils.toXMLDate(cal.getTime()));

		service.getProvider().openSession("admin", "admin");
		CDOTransaction openTransaction = service.getProvider().getSession()
				.openTransaction();
		final CDOQuery cdoQuery = openTransaction
				.createQuery(
						"sql",
						"select val.cdo_id"
								+ " from TM.library_function"
								+ " join TM.library_function_resourcerefs_list as res_list"
								+ " on res_list.cdo_source = TM.library_function.cdo_id"
								+ " join TM.library_netxresource as res"
								+ " on res_list.cdo_value = res.cdo_id"
								+ " join TM.library_netxresource_metricvalueranges_list as mvr_list"
								+ " on mvr_list.cdo_source = res.cdo_id"
								+ " join TM.metrics_metricvaluerange as mvr"
								+ " on mvr_list.cdo_value = mvr.cdo_id"
								+ " join TM.metrics_metricvaluerange_metricvalues_list as val_list"
								+ " on val_list.cdo_source = mvr.cdo_id"
								+ " join TM.generics_value as val"
								+ " on val_list.cdo_value = val.cdo_id"
								+ " where TM.library_function.name = :function and mvr.intervalHint=60 and mvr.kindHint = 1 "
								+ " and value.timeStamp0 >= :dateFrom and value.timeStamp0 <= :dateTo"
								+ " order by val.timeStamp0 DESC;");

		cdoQuery.setParameter("function", funtionName);
		cdoQuery.setParameter("dateFrom",
				dateString(createDateTimeRange.getBegin()));
		cdoQuery.setParameter("dateTo",
				dateString(createDateTimeRange.getEnd()));
		// cdoQuery.setParameter("intervalHint", new Integer(60).toString());
		// cdoQuery.setParameter("kindHint", KindHintType.AVG);

		List<Value> result = cdoQuery.getResult(Value.class);
		for (Value v : result) {
			System.out.println(modelUtils.value(v));
		}
		openTransaction.close();
		service.getProvider().closeSession();
	}

	public void testResourceQuery() {

		// String expressionName = "CS_M80B2C4";
		// DateTimeRange createDateTimeRange =
		// GenericsFactory.eINSTANCE.createDateTimeRange();
		//
		// Calendar cal = Calendar.getInstance();
		// cal.set(2012, 5, 1);
		// System.out.println(modelUtils.dateAndTime(cal.getTime()));
		// createDateTimeRange.setBegin(modelUtils.toXMLDate(cal.getTime()));
		// cal.add(Calendar.MONTH, 1);
		// createDateTimeRange.setEnd(modelUtils.toXMLDate(cal.getTime()));
		//
		service.getProvider().openSession("admin", "admin");
		CDOTransaction openTransaction = service.getProvider().getSession()
				.openTransaction();
		final CDOQuery cdoQuery = openTransaction
				.createQuery(
						"sql",
						"select res.cdo_id"
								+ " from TM.library_function"
								+ " join TM.library_function_resourcerefs_list as res_list"
								+ " on res_list.cdo_source = TM.library_function.cdo_id"
								+ " join TM.library_netxresource as res"
								+ " on res_list.cdo_value = res.cdo_id"
								+ " where TM.library_function.name = 'Mobility';");
		// cdoQuery.setParameter("name", expressionName);
		// cdoQuery.setParameter("dateFrom",
		// dateString(createDateTimeRange.getBegin()));
		// cdoQuery.setParameter("dateTo",
		// dateString(createDateTimeRange.getEnd()));
		// cdoQuery.setParameter("intervalHint", new Integer(60).toString());
		// cdoQuery.setParameter("kindHint", KindHintType.AVG);

		List<NetXResource> result = cdoQuery.getResult(NetXResource.class);

		for (NetXResource res : result) {
			String printModelObject = modelUtils.printModelObject(res);
			System.out.println(printModelObject);
		}
		openTransaction.close();
		service.getProvider().closeSession();
	}

	private String dateString(XMLGregorianCalendar date) {
		return XMLTypeFactory.eINSTANCE.convertDateTime(date);
	}

}
