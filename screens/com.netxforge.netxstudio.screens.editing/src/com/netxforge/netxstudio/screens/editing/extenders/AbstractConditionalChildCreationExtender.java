/*******************************************************************************
 * Copyright (c) Aug 3, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.extenders;

import java.util.Collection;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IChildCreationExtender;

import com.google.common.collect.Lists;


/**
 * Custom child extender, capable to add conditional ( Type etc...) child descriptors
 * It works best, by disabling the generated EMF descriptors. 
 *  
 * @author Christophe Bouhier
 */
public abstract class AbstractConditionalChildCreationExtender implements IChildCreationExtender {

	public Collection<?> getNewChildDescriptors(Object object,
			EditingDomain editingDomain) {

		Collection<Object> newChildDescriptors = Lists.newArrayList();
		return newChildDescriptors;
	}
	
	public ResourceLocator getResourceLocator() {
		return EMFEditPlugin.INSTANCE;
	}

	protected CommandParameter createChildParameter(Object feature, Object child) {
		return new CommandParameter(null, feature, child);
	}

}
