/*******************************************************************************
 * Copyright (c) 7 mrt. 2014 NetXForge.
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
package com.netxforge.netxstudio.data.cdo;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.cdo.view.CDOView;

import com.netxforge.netxstudio.Netxstudio;
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
 * Hibernate specific queries for {@link Netxstudio}
 * 
 * @author Christophe Bouhier
 * 
 */
public class CDOHQLQueries {

	/**
	 */
	public static List<Role> getRole(CDOView v, String userID) {

		CDOQuery q = v.createQuery("hql", ICDOQueries.SELECT_ROLES_FROM_PERSON);
		q.setParameter("name", userID);
		CDOQueryUtil.setCacheParameter(q);
		return q.getResult(Role.class);
	}

	/**
	 */
	public List<Job> getJobWithMetricSource(CDOView v, MetricSource source) {

		CDOQuery q = v.createQuery("hql",
				ICDOQueries.SELECT_JOBS_WITH_METRICSOURCE);
		q.setParameter("metricSource", source);
		CDOQueryUtil.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	/**
	 */
	public List<Job> getJobWithService(CDOView v, Service service) {

		CDOQuery q = v.createQuery("hql", ICDOQueries.SELECT_JOBS_WITH_SERVICE);
		q.setParameter("rfsService", service);
		CDOQueryUtil.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	/**
	 */
	public List<Job> getJobWithServiceReporting(CDOView v, Service service) {
		CDOQuery q = v.createQuery("hql",
				ICDOQueries.SELECT_JOBS_WITH_SERVICE_REPORTING);
		q.setParameter("rfsService", service);
		CDOQueryUtil.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	/**
	 */
	public List<Job> getJobWithOperatorReporting(CDOView v, Operator operator) {
		CDOQuery q = v.createQuery("hql",
				ICDOQueries.SELECT_JOBS_WITH_OPERATOR_REPORTING);
		q.setParameter("operator", operator);
		CDOQueryUtil.setCacheParameter(q);
		return q.getResult(Job.class);
	}

	/**
	 */
	public List<Equipment> getEquipments(CDOView v, String nodeID,
			String equipmentCode) {
		final CDOQuery cdoQuery = v
				.createQuery(
						"hql",
						"select e from Equipment e, Node n"
								+ "e in elements(n.equipments) "
								+ "and e.equipmentCode=:equipmentCode and n.nodeID=:nodeid");
		cdoQuery.setParameter("nodeid", nodeID);
		cdoQuery.setParameter("equipmentCode", equipmentCode);

		CDOQueryUtil.setCacheParameter(cdoQuery);
		final List<Equipment> equipments = cdoQuery.getResult(Equipment.class);
		return equipments;
	}

	/**
	 * @param nodeID
	 * @param name
	 * @return
	 */
	public List<Function> getFunctions(CDOView v, String nodeID, String name) {
		final CDOQuery cdoQuery = v.createQuery("hql",
				"select e from Function e, Node n"
						+ "e in elements(n.functions) "
						+ "and e.name=:name and n.nodeID=:nodeid");
		cdoQuery.setParameter("nodeid", nodeID);
		cdoQuery.setParameter("equipmentCode", name);

		CDOQueryUtil.setCacheParameter(cdoQuery);
		final List<Function> functions = cdoQuery.getResult(Function.class);
		return functions;
	}

	/**
	 */
	public List<NetXResource> getResources(CDOView v, String nodeID,
			String expressionName) {
		final CDOQuery cdoQuery = v.createQuery("hql",
				"select r from NetXResource r, Component c, Node n"
						+ "r in elements(c.resources) "
						+ "and r.name=:expressionName and n.nodeID=:nodeid");
		cdoQuery.setParameter("nodeid", nodeID);
		cdoQuery.setParameter("expressioName", expressionName);

		CDOQueryUtil.setCacheParameter(cdoQuery);
		final List<NetXResource> resources = cdoQuery
				.getResult(NetXResource.class);
		return resources;
	}

	/**
	 */
	public List<Value> getMetricsFromResource(CDOView v, String expressionName,
			XMLGregorianCalendar from, XMLGregorianCalendar to,
			int intervalHint, KindHintType kindHint) {
		final CDOQuery cdoQuery = v
				.createQuery(
						"hql",
						"select v from Value v, MetricValueRange mvr, NetXResource res where "
								+ "v in elements(mvr.metricValues) "
								+ "and v.timeStamp >= :dateFrom and v.timeStamp <= :dateTo "
								+ "and mvr.intervalHint=:intervalHint and mvr.kindHint = :kindHint "
								+ "and mvr in elements(res.metricValueRanges) and res.expressionName=:name");
		cdoQuery.setParameter("name", expressionName);
		cdoQuery.setParameter("dateFrom", CDOQueryUtil.dateString(from));
		cdoQuery.setParameter("dateTo", CDOQueryUtil.dateString(to));
		cdoQuery.setParameter("intervalHint",
				new Integer(intervalHint).toString());
		cdoQuery.setParameter("kindHint", kindHint);

		CDOQueryUtil.setCacheParameter(cdoQuery);
		final List<Value> values = cdoQuery.getResult(Value.class);
		return values;
	}
}
