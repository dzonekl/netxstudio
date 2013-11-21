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
package com.netxforge.netxstudio.data;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EReference;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.services.Service;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public interface IQueryService {

	public static final String QUERY_MYSQL = "sql";
	public static final String QUERY_HQL = "hql";
	public static final String QUERY_OCL = "ocl";

	public void setDataProvider(IData provider);

	/**
	 * Get the role for this user.
	 * 
	 * @param userID
	 * @return
	 */
	public List<Role> getRole(String userID);

	/**
	 * Get the role for the current user.
	 * 
	 * @return
	 */
	public Role getCurrentRole();

	/**
	 * Get a list of job for a specified metric source.
	 * 
	 * @param source
	 * @return
	 */
	public List<Job> getJobWithMetricSource(MetricSource source);

	/**
	 * 
	 * Get a list of job for a specified service.
	 * 
	 * @param service
	 * @return
	 */
	public List<Job> getJobWithService(Service service);

	/**
	 * 
	 * Get a list of reporting job for a specified service.
	 * 
	 * @param service
	 * @return
	 */
	public List<Job> getJobWithServiceReporting(Service service);

	/**
	 * Get a list o reporting job for a specified operator.
	 * 
	 * @param operator
	 * @return
	 */
	public List<Job> getJobWithOperatorReporting(Operator operator);

	/**
	 * Get the metric values for a period from a resource. The period and kind
	 * hint, tell use which range exactly should be read.
	 * 
	 * @param expressionName
	 * @param from
	 * @param to
	 * @return A list of Value type.
	 */
	public List<Value> getMetricsFromResource(String expressionName,
			XMLGregorianCalendar from, XMLGregorianCalendar to, int periodHint,
			KindHintType kindHint);
	
	/**
	 * Get the capacity values from a resource.
	 * 
	 * @param view
	 * @param netXResource
	 * @param dialect
	 * @param period
	 * @return
	 */
	public List<Value> capacityValues(CDOView view, NetXResource netXResource,
			String dialect, DateTimeRange period);
	
	/**
	 * Get the capacity values from a resource.
	 * 
	 * @param view
	 * @param netXResource
	 * @param dialect
	 * @param period
	 * @param date
	 * @return
	 */
	public List<Value> capacityValues(CDOView view, NetXResource netXResource,
			String dialect, DateTimeRange period, XMLGregorianCalendar date);
	
	
	/**
	 * Get the utilization from a resource.
	 * 
	 * @param view
	 * @param netXResource
	 * @param dialect
	 * @param period
	 * @return
	 */
	public List<Value> utilizationValues(CDOView view, NetXResource netXResource,
			String dialect, DateTimeRange period);
	
	/**
	 * Get the utilization from a resource.
	 * 
	 * @param view
	 * @param netXResource
	 * @param dialect
	 * @param period
	 * @param date
	 * @return
	 */
	public List<Value> utilizationValues(CDOView view, NetXResource netXResource,
			String dialect, DateTimeRange period, XMLGregorianCalendar date);

	
	
	/**
	 * 
	 * @param nodeID
	 * @param equipmentCode
	 * @return
	 */
	public List<Equipment> getEquipments(String nodeID, String equipmentCode);

	/**
	 * 
	 * @param nodeID
	 * @param name
	 * @return
	 */
	public List<Function> getFunctions(String nodeID, String name);

	/**
	 * 
	 * @param nodeID
	 * @param expressionName
	 * @return
	 */
	public List<NetXResource> getResources(String nodeID, String expressionName);

	/**
	 * Close used transactions.
	 */
	public void close();

	/**
	 * Find a value with a specified timestamp from a range.
	 * 
	 * @param view
	 * @param mvr
	 * @param dialect
	 * @param date
	 * @return
	 */
	public List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect, XMLGregorianCalendar date);

	/**
	 * Find values within a specified period.
	 * 
	 * @param view
	 * @param mvr
	 * @param dialect
	 * @param dtr
	 * @return
	 */
	public List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect, DateTimeRange period);

	/**
	 * 
	 * @param view
	 * @param mvr
	 * @param dialect
	 * @param dtr
	 * @return
	 */
	public List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect, DateTimeRange period, XMLGregorianCalendar date);

	/**
	 * Get the sorted values for a Metric Value Range.
	 * 
	 * @param view
	 * @param mvr
	 * @param dialect
	 * @return
	 */
	public List<Value> mvrValues(CDOView view, MetricValueRange mvr,
			String dialect);

	public List<Value> removeMvrValues(CDOView view, MetricValueRange mvr,
			String dialect, XMLGregorianCalendar date);

	public List<Value> removeMvrValues(CDOView view, MetricValueRange mvr,
			String dialect, DateTimeRange period);
	
	public List<Value> removeMvrValues(CDOView view, MetricValueRange mvr,
			String dialect, DateTimeRange period, XMLGregorianCalendar date);

	/**
	 * Use a query to get the duplicate value timeStamps in a
	 * 
	 * @param view
	 * @param mvr
	 * @param dialect
	 * @return
	 */
	public List<Value> getDuplicateValues(CDOView view, MetricValueRange mvr,
			String dialect);

	/**
	 * Get an SQL query for the values with this container.
	 * 
	 * @param container
	 * @return
	 */
	public String getValuesQuery(CDOID container, EReference reference);

	/**
	 * Get all {@link NetXResource} objects with a
	 * {@link NetXResource#getComponentRef()} returns <code>null</code>
	 * 
	 * @param view
	 * @param dialect
	 * @return
	 */
	public List<NetXResource> getUnconnectedResources(CDOView view,
			String dialect);

}