/*******************************************************************************
 * Copyright (c) 5 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.parts;

import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ShowInContext;

import com.google.common.collect.Lists;
import com.netxforge.screens.editing.base.AbstractScreenViewer;
import com.netxforge.screens.editing.base.IScreen;
import com.netxforge.screens.editing.base.ScreenUtil;

/**
 * A Chart screen in a viewer.
 * 
 * @author Christophe Bouhier
 * 
 */
public class DataScreenViewer extends AbstractScreenViewer {

	private DataScreen dataScreen;

	public IScreen getScreen() {
		return dataScreen;
	}

	public void initScreen(Composite parent) {

		dataScreen = new DataScreen(parent, SWT.NONE);
		dataScreen.setOperation(ScreenUtil.OPERATION_READ_ONLY);
		dataScreen.setEditingService(getEditingService());
		dataScreen.buildUI();

		for (IAction action : getActions()) {
			getViewSite().getActionBars().getToolBarManager().add(action);
		}
		getViewSite().getActionBars().updateActionBars();
	}

	private IAction[] actions = null;

	public IAction[] getActions() {
		if (actions == null) {
			List<IAction> dataActions = Lists.newArrayList();
			actions = dataActions.toArray(new IAction[dataActions.size()]);
		}
		return actions;

	}

	protected void processSelection(ISelection selection) {
		if (selection != null && !selection.isEmpty()
				&& selection instanceof StructuredSelection) {
			IStructuredSelection ss = (StructuredSelection) selection;
			dataScreen.injectData(new Object[] { ss.getFirstElement() });
		}
	}

	@Override
	protected void customPartHook(IWorkbenchPart part, PART_EVENT event) {
		super.customPartHook(part, event);
	}

	@Override
	public boolean show(ShowInContext context) {

		final ShowInContext finalContext = context;

		Shell shell = getSite().getShell();
		Menu menu = new Menu(shell, SWT.POP_UP);

		{
			MenuItem item = new MenuItem(menu, SWT.RADIO);
			item.setText("Merge");
			item.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					MenuItem item = (MenuItem) e.widget;
					if (item.getSelection()) {

						// Do some merging
						getScreen().handleShowIn(finalContext);
					}

				}
			});
		}
		{
			MenuItem item = new MenuItem(menu, SWT.RADIO);
			item.setText("Replace");
			item.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					MenuItem item = (MenuItem) e.widget;
					if (item.getSelection()) {
						// So some replacement
						getScreen().handleShowIn(finalContext);
					}
				}
			});
		}

		menu.setEnabled(true);
		menu.setVisible(true);
		// Process merge/replace.
		return true;
	}

}
