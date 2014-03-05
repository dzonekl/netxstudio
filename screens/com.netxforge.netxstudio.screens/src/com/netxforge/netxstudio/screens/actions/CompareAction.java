/*******************************************************************************
 * Copyright (c) 1 mrt. 2014 NetXForge.
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
package com.netxforge.netxstudio.screens.actions;

import java.util.List;

import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.screens.FeatureDeltaDialog;
import com.netxforge.screens.editing.base.actions.BaseSelectionListenerAction;

public class CompareAction extends BaseSelectionListenerAction {

	public CompareAction(String text) {
		super(text);
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		System.out.println(selection);
		return selection.size() == 2;
	}

	@Override
	public void run() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List twoSelectionList = Lists.newArrayList(this
				.getStructuredSelection().iterator());
		CDORevision rev = (CDORevision) twoSelectionList.get(0);
		CDORevision rev2 = (CDORevision) twoSelectionList.get(1);

		try {
			CDORevisionDelta delta = rev.compare(rev2);
			FeatureDeltaDialog featureDeltaDialog = new FeatureDeltaDialog(
					Display.getDefault().getActiveShell());
			featureDeltaDialog.setDelta(delta);
			featureDeltaDialog.setDeltaInfo("version: " + rev.getVersion()
					+ " with version: " + rev2.getVersion());
			featureDeltaDialog.setBlockOnOpen(true);
			featureDeltaDialog.open();
		} catch (IllegalStateException iae) {
			// compare could throw this: java.lang.IllegalStateException: List
			// contains proxy elements
			// see bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=337054
		}
	}
}