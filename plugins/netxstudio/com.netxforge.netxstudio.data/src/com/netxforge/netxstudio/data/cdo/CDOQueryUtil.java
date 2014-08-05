/*******************************************************************************
 * Copyright (c) May 18, 2011 NetXForge.
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

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.view.CDOQuery;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class CDOQueryUtil {

	public static final String QUERY_MYSQL = "sql";
	public static final String QUERY_HQL = "hql";
	public static final String QUERY_OCL = "ocl";

	public static void setCacheParameter(CDOQuery query) {
		query.setParameter(ICDOQueries.CACHE_RESULTS, true);
	}
	
	public static String dateString(XMLGregorianCalendar date) {
		return XMLTypeFactory.eINSTANCE.convertDateTime(date);
	}


}
