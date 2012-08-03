package com.netxforge.netxstudio.server.test.dataprovider;

import java.util.Calendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.junit.Test;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;

public class QueryTest extends AbstractDataServiceTest4 {

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
