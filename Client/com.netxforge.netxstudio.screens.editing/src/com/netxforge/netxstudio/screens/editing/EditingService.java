/*******************************************************************************
 * Copyright (c) May 10, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.editing;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;

import com.google.inject.Singleton;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
@Singleton
public class EditingService implements IEditingService {
	
	static AdapterFactoryEditingDomain domain = null;
	
	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.IEditingService#getEditingDomain()
	 */
	@Override
	public EditingDomain getEditingDomain() {
		
		if (domain == null) {
			BasicCommandStack commandStack = new BasicCommandStack();
			domain = new AdapterFactoryEditingDomain(this.getAdapterFactory(),
					commandStack);
		}
		return domain;
	}
	
	
	// The declared EMF edit adapter factory.
	static ComposedAdapterFactory emfEditAdapterFactory;

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.IEditingService#getAdapterFactory()
	 */
	@Override
	public ComposedAdapterFactory getAdapterFactory() {
		if (emfEditAdapterFactory == null) {
			emfEditAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		}
		return emfEditAdapterFactory;
	}
	
}
