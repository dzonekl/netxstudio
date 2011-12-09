/*******************************************************************************
 * Copyright (c) Nov 7, 2011 NetXForge.
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
 *******************************************************************************/ package com.netxforge.netxstudio.screens.actions;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.editing.actions.WizardUtil;

/**
 * @author dzonekl
 */
public class NodeTypeExportXLSAction extends BaseSelectionListenerAction {

	public NodeTypeExportXLSAction(String text, int style) {
		super(text);
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		Object firstElement = selection.getFirstElement();
		return firstElement instanceof NodeType;
	}

	@Override
	public void run() {
		IStructuredSelection s = this.getStructuredSelection();
		WizardUtil
				.openWizard(
						"com.netxforge.netxstudio.models.export.wizard.ui.node.xls",
						(IStructuredSelection) s);
	}
}