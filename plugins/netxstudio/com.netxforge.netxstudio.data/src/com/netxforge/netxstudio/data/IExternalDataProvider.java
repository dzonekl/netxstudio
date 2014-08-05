/*******************************************************************************
 * Copyright (c) May 3, 2011 NetXForge.
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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.google.inject.ImplementedBy;
import com.netxforge.netxstudio.data.IExternalDataProvider.ExternalDataProvider;

/**
 * The external data provider.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
@ImplementedBy(ExternalDataProvider.class)
public interface IExternalDataProvider {
	
	public static class ExternalDataProvider implements IExternalDataProvider {
		
		public ExternalDataProvider(){
		}
		
		public Resource getResource(URI uri) {
			return new ResourceSetImpl().getResource(uri, true);
		}
	}
	/**
	 * Get an external resource from a specified URI. 
	 * @param uri
	 * @return
	 */
	public Resource getResource(URI uri);

}