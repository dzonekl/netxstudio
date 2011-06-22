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

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.generics.Value;

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
	 * Get the values for a period from a resource. 
	 * As the resource has multiple value ranges, we return 
	 * from the index. 
	 * 
	 * 
	 * @param shortName
	 * @param from
	 * @param to
	 * @return
	 */
	public List<Value> getValuesFromResource(String shortName, Date from, Date to);
	
	
	/**
	 * Get the values for a period from a resource. 
	 * As the resource has multiple value ranges, we return 
	 * from the index.
	 * 
	 * @param shortName
	 * @param from
	 * @param to
	 * @return
	 */
	public List<Value> getValuesFromResource(String shortName,
			XMLGregorianCalendar from, XMLGregorianCalendar to);
	

}