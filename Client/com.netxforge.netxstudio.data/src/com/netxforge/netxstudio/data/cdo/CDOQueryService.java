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

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.scheduling.Job;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class CDOQueryService implements IQueryService {

	private IDataProvider provider;
	private CDOQueryUtil queryService;
	@SuppressWarnings("unused")
	private ModelUtils modelUtils;

	@Inject
	public CDOQueryService(IDataProvider dataProvider,
			CDOQueryUtil queryService, ModelUtils modelUtils) {
		this.provider = dataProvider;
		this.queryService = queryService;
		this.modelUtils = modelUtils;
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
		CDOQuery q = t.createQuery("hql", ICDOQueries.SELECT_ROLES_FROM_PERSON);
		q.setParameter("name", userID);
		queryService.setCacheParameter(q);
		return q.getResult(Role.class);
	}
	
	
	public List<Job> getJobWithMetricSource(MetricSource source) {

		CDOTransaction t = provider.getSession().openTransaction();
		CDOQuery q = t.createQuery("hql", ICDOQueries.SELECT_JOBS_WITH_METRICSOURCE);
		q.setParameter("metricSource", source);
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
		final CDOQuery cdoQuery = transaction
				.createQuery(
						"hql",
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
		final CDOQuery cdoQuery = transaction
				.createQuery(
						"hql",
						"select r from NetXResource r, Component c, Node n"
								+ "r in elements(c.resources) " 
								+ "and r.name=:expressionName and n.nodeID=:nodeid");
		cdoQuery.setParameter("nodeid", nodeID);
		cdoQuery.setParameter("expressioName", expressionName);
		
		queryService.setCacheParameter(cdoQuery);
		final List<NetXResource> resources = cdoQuery.getResult(NetXResource.class);
		return resources;	
	}
	
	
	public List<Value> getMetricsFromResource(String expressionName,
			XMLGregorianCalendar from, XMLGregorianCalendar to, int intervalHint, KindHintType kindHint) {
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
		cdoQuery.setParameter("intervalHint", new Integer(intervalHint).toString());
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
								+"v in elements(res.capacityValues) "
								+"and v.timeStamp >= :dateFrom and v.timeStamp <= :dateTo "
								+"and res.expressionName=:name");
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


	
}
