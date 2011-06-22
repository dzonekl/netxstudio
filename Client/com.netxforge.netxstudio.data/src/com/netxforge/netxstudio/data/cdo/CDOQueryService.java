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

import java.util.Date;
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

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class CDOQueryService implements IQueryService {

	private IDataProvider provider;
	private CDOQueryUtil queryService;
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

	public List<Value> getValuesFromResource(String shortName,
			XMLGregorianCalendar from, XMLGregorianCalendar to) {
		final String name = "name";
		final CDOTransaction transaction = provider.getTransaction();
		final CDOQuery cdoQuery = transaction
				.createQuery(
						"hql",
						"select v from Value v, MetricValueRange mvr, NetXResource res where "
								+ "v in elements(mvr.metricValues) and v.timeStamp >= :dateFrom and "
								+ "v.timeStamp <= :dateTo and mvr in elements(res.metricValueRanges) and res.shortName=:name");
		cdoQuery.setParameter("name", name);
		cdoQuery.setParameter("dateFrom", dateString(from));
		cdoQuery.setParameter("dateTo", dateString(to));
		// cdoQuery.setParameter(IHibernateStore.CACHE_RESULTS, true);
		queryService.setCacheParameter(cdoQuery);
		final List<Value> values = cdoQuery.getResult(Value.class);
		provider.commitTransaction();// ? What do we need to commit?
		return values;
	}

	public List<Value> getValuesFromResource(String shortName, Date from,
			Date to) {
		final String name = "name";
		final CDOTransaction transaction = provider.getTransaction();
		final CDOQuery cdoQuery = transaction
				.createQuery(
						"hql",
						"select v from Value v, MetricValueRange mvr, NetXResource res where "
								+ "v in elements(mvr.metricValues) and v.timeStamp >= :dateFrom and "
								+ "v.timeStamp <= :dateTo and mvr in elements(res.metricValueRanges) and res.shortName=:name");
		cdoQuery.setParameter("name", name);
		cdoQuery.setParameter("dateFrom", dateString(from));
		cdoQuery.setParameter("dateTo", dateString(to));
		// cdoQuery.setParameter(IHibernateStore.CACHE_RESULTS, true);
		queryService.setCacheParameter(cdoQuery);
		final List<Value> values = cdoQuery.getResult(Value.class);
		provider.commitTransaction();// ? What do we need to commit?
		return values;
	}

	private String dateString(Date date) {
		return XMLTypeFactory.eINSTANCE.convertDateTime(modelUtils
				.toXMLDate(date));
	}

	private String dateString(XMLGregorianCalendar date) {
		return XMLTypeFactory.eINSTANCE.convertDateTime(date);
	}

}
