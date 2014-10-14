/*******************************************************************************
 * Copyright (c) 14 okt. 2014 NetXForge.
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
package com.netxforge.oss2.mappings;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import com.netxforge.netxstudio.metrics.MappingExternal;

/**
 * Implementors should use the {@link IMappingService} interface to provide
 * {@link MappingExternal} implementations.
 * 
 * @author Christophe Bouhier
 */
public interface IMappingService {

	/**
	 * Get a {@link MappingExternal} instance for a given namespace. The
	 * namspace could correspond to i.e. the {@link EPackage#getNsURI()} in an
	 * {@link EPackage} implementation.
	 * 
	 * @param namespace
	 * @return
	 */
	public MappingExternal getMappingExternal(String namespace);

	/**
	 * If the implementor supports this service.
	 * 
	 * @param namespace
	 * @return
	 */
	public boolean serviceFor(String namespace);

	/**
	 * A {@link List} of supported namespaces by this {@link IMappingService}
	 * 
	 * @return
	 */
	public List<String> supportedNameSpaces();

}
