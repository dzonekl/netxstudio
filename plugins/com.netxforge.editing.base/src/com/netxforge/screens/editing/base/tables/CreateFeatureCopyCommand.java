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
package com.netxforge.screens.editing.base.tables;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.command.ChildrenToCopyProvider;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateCopyCommand;
import org.eclipse.emf.edit.command.InitializeCopyCommand;
import org.eclipse.emf.edit.command.OverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * The create copy command is used to create an uninitialized object of the same
 * type as owner which will later be initialized using
 * {@link InitializeCopyCommand}.
 * 
 * <p>
 * A create copy command is an {@link OverrideableCommand}.
 */
public class CreateFeatureCopyCommand extends AbstractOverrideableCommand
		implements ChildrenToCopyProvider {
	
	/**
	 * This creates a command that will create and object for copying the given
	 * object
	 */
	public static Command create(EditingDomain domain, Object owner,
			EStructuralFeature feature, CopyFeatureCommand.Helper copyHelper) {
		return domain.createCommand(CreateCopyCommand.class,
				new CommandParameter(owner, null, copyHelper));
	}

	/**
	 * This caches the label.
	 */
	protected static final String LABEL = EMFEditPlugin.INSTANCE
			.getString("_UI_CreateCopyCommand_label");

	/**
	 * This caches the description.
	 */
	protected static final String DESCRIPTION = EMFEditPlugin.INSTANCE
			.getString("_UI_CreateCopyCommand_description");

	/**
	 * This is the object being copied.
	 */
	protected EObject owner;

	/**
	 * This is the copy of the feature.
	 */
	protected Object copy;

	/**
	 * This is a map of objects to their copies
	 */
	protected CopyFeatureCommand.Helper copyHelper;

	/**
	 * The feature to copy.
	 */
	private EStructuralFeature feature;

	private Collection<EObject> targets;

	/**
	 * This constructs a command that will create an object that is a copy of
	 * the given object.
	 * 
	 * @param targets
	 */
	public CreateFeatureCopyCommand(EditingDomain domain, EObject owner,
			Collection<EObject> targets, EStructuralFeature feature,
			CopyFeatureCommand.Helper copyHelper) {
		super(domain, LABEL, DESCRIPTION);

		this.owner = owner;
		this.targets = targets;
		this.copyHelper = copyHelper;
		this.feature = feature;

	}

	/**
	 * This is the object being copied.
	 */
	public EObject getOwner() {
		return owner;
	}

	/**
	 * This is the map of objects to their copies.
	 */
	public CopyFeatureCommand.Helper getCopyHelper() {
		return copyHelper;
	}

	@Override
	protected boolean prepare() {

		boolean allTargetsSupported = true;
		for (EObject target : targets) {
			// valid feature exists for this target.
			if (!target.eClass().getEAllStructuralFeatures().contains(feature)) {
				allTargetsSupported = false;
			}
		}
		// Only eobject feature values supported.
		copy = owner.eGet(feature);

		boolean result = owner != null && feature != null && copy != null
				&& copy instanceof EObject && allTargetsSupported;

//		System.out.println("CreateFeatureCopyCommand: can execute?  " + result);
		return result;
	}

	@Override
	public void doExecute() {
		// Store a copy of this feature for this owner.
//		System.out
//				.println("CreateFeatureCopyCommand:  set copy helper master value ="
//						+ copy);
		copyHelper.setMasterCopy(copy);
		for (EObject target : targets) {
			// make a copy from the master.
			Object masterCopy = copyHelper.getMasterCopy();
			EObject eObjectCopy = EcoreUtil.copy((EObject) masterCopy);
			copyHelper.put(target, eObjectCopy);
		}
	}

	@Override
	public void doUndo() {
		copyHelper.setMasterCopy(null);
	}

	@Override
	public void doRedo() {
		copyHelper.setMasterCopy(copy);
	}

	@Override
	public Collection<?> doGetResult() {
		return Collections.singleton(copy);
	}

	@Override
	public Collection<?> doGetChildrenToCopy() {
		// Create commands to create copies of the children.
		//
		HashSet<Object> result = new HashSet<Object>(owner.eContents());
		return result;
	}

	/**
	 * This gives an abbreviated name using this object's own class' name,
	 * without package qualification, followed by a space separated list of
	 * <tt>field:value</tt> pairs.
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (owner: " + owner + ")");
		result.append(" (copyHelper: " + copyHelper + ")");

		return result.toString();
	}
}
