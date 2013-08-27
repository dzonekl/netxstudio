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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ViewerCell;

import com.netxforge.netxstudio.screens.editing.tables.CopyFeatureCommand.FeatureInitializer;
import com.netxforge.netxstudio.screens.editing.tables.CopyFeatureCommand.Helper;

/**
 * An Adapter for {@link IFocusBlockActionHandler}.
 * 
 * @author Christophe Bouhier
 */
public abstract class AbstractFocusBlockActionHandler implements
		IFocusBlockActionHandler {
	/*
	 * The editing domain holding the stack and resource set.
	 */
	private EditingDomain editingDomain;

	/*
	 * The command which will execute the drag copy.
	 */
	private Command command;

	/*
	 * The target resource for non-contained EReference copies.
	 */
	private Resource resource;

	/*
	 * The feature to drag copy.
	 */
	private FocusColumnToModelMap featureMap;

	/*
	 * Passed to the command to initialize the copied object.
	 */
	private FeatureInitializer featureInitializer;

	/**
	 * @return the editingDomain
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @param editingDomain
	 *            the editingDomain to set
	 */
	public void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	public void updateCommand(ViewerCell focusCell, Collection<EObject> targets) {

		if (!isPrepared(focusCell)) {
			// dispose the command.
			if (command != null) {
				command.dispose();
				command = null;
			}
			return;
		} else {
			EStructuralFeature feature = mapColumnToFeature(focusCell
					.getColumnIndex());
			EObject element = (EObject) focusCell.getElement();
			command = commandFor(editingDomain, element, targets, feature,
					new CopyFeatureCommand.Helper(), featureInitializer,
					resource);
		}
	}

	public abstract Command commandFor(EditingDomain editingDomain,
			EObject element, Collection<EObject> targets,
			EStructuralFeature feature, Helper helper,
			FeatureInitializer featureInitializer, Resource resource);

	/*
	 * We need a focus cell, an editing domain, a feature
	 */
	private boolean isPrepared(ViewerCell focusCell) {
		if (editingDomain == null | featureMap == null
				| featureMap.getColumnFeatureMap().isEmpty()) {
			return false;
		}
		if (focusCell != null && focusCell.getElement() instanceof EObject) {
			// Make sure the feature is a feature for the focus object.
			EStructuralFeature feature = mapColumnToFeature(focusCell
					.getColumnIndex());
			EObject element = (EObject) focusCell.getElement();
			if (element.eClass().getEAllStructuralFeatures().contains(feature)) {
				return true;
			}
		}
		return false;
	}

	public void executeCommand() {
		this.getEditingDomain().getCommandStack().execute(command);

	}

	public EStructuralFeature mapColumnToFeature(int columnIndex) {
		return featureMap.getColumnFeatureMap().get(columnIndex);
	}

	/**
	 * Set the target resource for non-contained EReference copies.
	 * 
	 * @param expressionsResource
	 */
	public void setTargetResourceForNonContainment(Resource resource) {
		this.resource = resource;
	}

	/**
	 * @param focusColumnToModelMap
	 *            the feature to set
	 */
	public void setFeatureMap(FocusColumnToModelMap focusColumnToModelMap) {
		this.featureMap = focusColumnToModelMap;
	}

	/**
	 * @return the featureInitializer
	 */
	public FeatureInitializer getFeatureInitializer() {
		return featureInitializer;
	}

	/**
	 * @param featureInitializer
	 *            the featureInitializer to set
	 */
	public void setFeatureInitializer(FeatureInitializer featureInitializer) {
		this.featureInitializer = featureInitializer;
	}
}
