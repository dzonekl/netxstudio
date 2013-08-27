/*******************************************************************************
 * Copyright (c) 26 aug. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.tables;

import java.util.Collection;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ViewerCell;

import com.netxforge.netxstudio.screens.editing.tables.CopyFeatureCommand.FeatureInitializer;

/**
 * Definition for actions to be executed by an {@link SWTFocusBlockManager}.
 * 
 * @author Christophe Bouhier
 */
public interface IFocusBlockActionHandler {

	/**
	 * Set the {@link EditingDomain}.
	 * 
	 * @param editingDomain
	 */
	public void setEditingDomain(EditingDomain editingDomain);

	/**
	 * Get the {@link EditingDomain}
	 * 
	 * @return
	 */
	public EditingDomain getEditingDomain();

	/**
	 * Called by {@link SWTFocusBlockManager} when the EMF command needs to be
	 * updated with the focus block.
	 * 
	 * @param focusCell
	 * @param targets
	 */
	public void updateCommand(ViewerCell focusCell, Collection<EObject> targets);

	/**
	 * Called by the {@link SWTFocusBlockManager} when the EMF command needs to
	 * be executed on the {@link CommandStack} of the {@link EditingDomain}.
	 */
	public void executeCommand();

	/**
	 * @param focusColumnToModelMap
	 *            the feature to set
	 */
	public void setFeatureMap(FocusColumnToModelMap focusColumnToModelMap);

	/**
	 * 
	 * @param columnIndex
	 * @return
	 */
	public EStructuralFeature mapColumnToFeature(int columnIndex);

	/**
	 * @param featureInitializer
	 *            the featureInitializer to set
	 */
	public void setFeatureInitializer(FeatureInitializer featureInitializer);

	/**
	 * @return the featureInitializer
	 */
	public FeatureInitializer getFeatureInitializer();

	/**
	 * Set the target resource for non-contained EReference copies.
	 * 
	 * @param expressionsResource
	 */
	public void setTargetResourceForNonContainment(Resource resource);

}
