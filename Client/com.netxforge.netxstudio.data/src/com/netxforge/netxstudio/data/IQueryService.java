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

import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.services.Service;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public interface IQueryService {
	
	
	/**
	 * Get the role for this user. 
	 * @param userID
	 * @return
	 */
	public List<Role> getRole(String userID);
	
	
	/**
	 * Get the role for the current user. 
	 * @return
	 */
	public Role getCurrentRole();
	
	
	/**
	 * Get a list of job for a specified metric source. 
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
	 * @param service
	 * @return
	 */
	public List<Job> getJobWithServiceReporting(Service service);
	
	
	/**
	 * Get a list o reporting job for a specified operator.
	 * @param operator
	 * @return
	 */
	public List<Job> getJobWithOperatorReporting(Operator operator);
	
	/**
	 * Get the metric values for a period from a resource. 
	 * The period and kind hint, tell use which range exactly should be read. 
	 * 
	 * @param expressionName
	 * @param from
	 * @param to
	 * @return A list of Value type. 
	 */
	public List<Value> getMetricsFromResource(String expressionName,
			XMLGregorianCalendar from, XMLGregorianCalendar to, int periodHint, KindHintType kindHint);
		
	/**
	 * Get the capacity values from a resource. 
	 * 
	 * @param expressionName
	 * @param from
	 * @param to
	 * @return A list of Value type. 
	 */
	public List<Value> getCapacityFromResource(String expressionName,
			XMLGregorianCalendar from, XMLGregorianCalendar to);

	/**
	 * Get the utilization from a resource.  
	 * @param expressionName
	 * @param from
	 * @param to
	 * @return A list of Value type. 
	 */
	public List<Value> getUtilizationFromResource(String expressionName,
			XMLGregorianCalendar from, XMLGregorianCalendar to);
	
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
	
}