/*******************************************************************************
 * Copyright (c) Apr 26, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IContributionItem perspectivesMenu;
	private IContributionItem viewsMenu;
	private IWorkbenchAction prefAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction helpAction;
	private IWorkbenchAction saveAction;

	@Inject
	private ModelUtils modelUtils;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {

		prefAction = ActionFactory.PREFERENCES.create(window);
		aboutAction = ActionFactory.ABOUT.create(window);
		helpAction = ActionFactory.HELP_CONTENTS.create(window);
		saveAction = ActionFactory.SAVE.create(window);

		perspectivesMenu = ContributionItemFactory.PERSPECTIVES_SHORTLIST
				.create(window);

		viewsMenu = ContributionItemFactory.VIEWS_SHORTLIST.create(window);

		getAction(ActionFactory.SAVE.getId());

		register(prefAction);
		register(aboutAction);
		register(helpAction);
		register(ActionFactory.INTRO.create(window));
		register(ActionFactory.EDIT_ACTION_SETS.create(window));
		register(ActionFactory.NEW.create(window));
		register(ActionFactory.SAVE.create(window));
		register(ActionFactory.SAVE_AS.create(window));
		register(ActionFactory.SAVE_ALL.create(window));
		register(ActionFactory.UNDO.create(window));
		register(ActionFactory.REDO.create(window));
		register(ActionFactory.CUT.create(window));
		register(ActionFactory.COPY.create(window));
		register(ActionFactory.PASTE.create(window));
		register(ActionFactory.DELETE.create(window));
		register(ActionFactory.SELECT_ALL.create(window));
		// register(ActionFactory.PRINT.create(window));
		register(ActionFactory.IMPORT.create(window));
		register(ActionFactory.EXPORT.create(window));
		register(ActionFactory.CLOSE.create(window));
		register(ActionFactory.CLOSE_ALL.create(window));

		register(ActionFactory.QUIT.create(window));

	}

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {

		// Example on how to add a ToolBarManager, via a contribution item to
		// the coolbar.
		coolBar.add(new GroupMarker(IWorkbenchActionConstants.GROUP_FILE));
		{
			ToolBarManager navToolBar = new ToolBarManager(SWT.FLAT);
			navToolBar
					.add(new GroupMarker(IWorkbenchActionConstants.GROUP_APP));

			navToolBar.add(saveAction);
			ToolBarContributionItem tbci = new ToolBarContributionItem(
					navToolBar, IWorkbenchActionConstants.TOOLBAR_FILE);
			coolBar.add(tbci);
		}
	}

	@Override
	protected void fillStatusLine(IStatusLineManager statusLine) {

//		ToolBarManager clockToolBar = new ToolBarManager(SWT.FLAT);
//		clockToolBar.add(new Clock("statusline_clock"));
//		clockToolBar.add(new GroupMarker("statusline.group"));
//		ToolBarContributionItem tbci = new ToolBarContributionItem(
//				clockToolBar, IWorkbenchActionConstants.TOOLBAR_FILE);
		
		statusLine.add(new Clock("statusline_clock"));
		super.fillStatusLine(statusLine);
	}

	/*
	 * A clock wrapped in a contribution item. Can be placed on status line or
	 * coolbar.
	 */
	public class Clock extends ContributionItem {

		private CLabel label;

		public Clock(String ID) {
			super(ID);

			final IActionBarConfigurer abc = getActionBarConfigurer();

			final SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");

			ScheduledExecutorService exec = Executors
					.newSingleThreadScheduledExecutor();

			exec.scheduleAtFixedRate(new Runnable() {
				public void run() {

					abc.getWindowConfigurer().getWindow().getShell()
							.getDisplay().asyncExec(new Runnable() {

								public void run() {
									String format = df.format(new Date(System
											.currentTimeMillis()));
									label.setText(format);
									label.pack();
								}
							});
				}
			}, 5, 1, TimeUnit.SECONDS);
		}

		private String generateString(Random rng, String characters, int length) {
			char[] text = new char[length];
			for (int i = 0; i < length; i++) {
				text[i] = characters.charAt(rng.nextInt(characters.length()));
			}
			return new String(text);
		}

		public void fill(Composite parent) {
			final IActionBarConfigurer abc = getActionBarConfigurer();
			Color systemColor = abc.getWindowConfigurer().getWindow()
					.getShell().getDisplay().getSystemColor(SWT.COLOR_WHITE);
			label = new CLabel(parent, SWT.SHADOW_ETCHED_OUT | SWT.BORDER | SWT.CENTER);
			label.setText("               ");
			label.setBackground(systemColor);
		}
	}

	protected void fillMenuBar(IMenuManager menu) {

		// OS SPECIFICS, for OSX, the preference and about are in the action.
		// For other OS, we add these to window.

		{
			assert prefAction != null;

			// See bug# http://bugzilla.kualasoft.com/show_bug.cgi?id=174

			String platform = SWT.getPlatform();
			if ("carbon".equals(platform) || "cocoa".equals(platform)) {
				ActionContributionItem item = new ActionContributionItem(
						prefAction);
				item.setVisible(false);
				menu.add(item);
			}

			assert aboutAction != null;

			platform = SWT.getPlatform();
			if ("carbon".equals(platform) || "cocoa".equals(platform)) {
				ActionContributionItem item = new ActionContributionItem(
						aboutAction);
				item.setVisible(false);
				menu.add(item);
			}

		}

		// FILE MENU
		{
			IMenuManager menuX = new MenuManager("File",
					IWorkbenchActionConstants.M_FILE);

			menuX.add(new GroupMarker(IWorkbenchActionConstants.FILE_START));
			IMenuManager menuY = new MenuManager("New",
					"com.netxforge.d.ui.newmenu");
			menuY.add(getAction(ActionFactory.NEW.getId()));
			menuX.add(menuY);
			menuX.add(new Separator());
			menuX.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			menuX.add(saveAction);
			menuX.add(getAction(ActionFactory.SAVE_AS.getId()));
			menuX.add(getAction(ActionFactory.SAVE_ALL.getId()));
			menuX.add(new Separator());
			menuX.add(getAction(ActionFactory.CLOSE.getId()));
			menuX.add(getAction(ActionFactory.CLOSE_ALL.getId()));
			menuX.add(new Separator());
			menuX.add(getAction(ActionFactory.IMPORT.getId()));
			menuX.add(getAction(ActionFactory.EXPORT.getId()));
			menuX.add(new Separator());
			// menuX.add(getAction(ActionFactory.PRINT.getId()));
			// menuX.add(new Separator());
			menuX.add(getAction(ActionFactory.QUIT.getId()));
			menuX.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));
			menu.add(menuX);
		}

		{
			IMenuManager menuX = new MenuManager("Edit",
					IWorkbenchActionConstants.M_EDIT);

			menuX.add(new GroupMarker(IWorkbenchActionConstants.EDIT_START));

			menuX.add(getAction(ActionFactory.UNDO.getId()));

			menuX.add(getAction(ActionFactory.REDO.getId()));

			menuX.add(new GroupMarker(IWorkbenchActionConstants.UNDO_EXT));

			menuX.add(new Separator());

			menuX.add(getAction(ActionFactory.CUT.getId()));

			menuX.add(getAction(ActionFactory.COPY.getId()));

			menuX.add(getAction(ActionFactory.PASTE.getId()));

			menuX.add(new GroupMarker(IWorkbenchActionConstants.CUT_EXT));

			menuX.add(new Separator());

			menuX.add(getAction(ActionFactory.DELETE.getId()));

			menuX.add(getAction(ActionFactory.SELECT_ALL.getId()));

			menuX.add(new Separator());

			menuX.add(new GroupMarker(IWorkbenchActionConstants.ADD_EXT));
			menuX.add(new GroupMarker(IWorkbenchActionConstants.FIND_EXT));
			menuX.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));
			// menuX.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));

			menu.add(menuX);
		}

		// LIBRARY MENU
		// Actions are added declarative.
		{
			// IMenuManager menuX = new MenuManager("Library",
			// "com.netxforge.d.ui.librarymenu");
			// IMenuManager menuY = new MenuManager("Functions",
			// "com.netxforge.d.ui.functionsmenu");
			// menuY.add(new
			// GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			// menuX.add(menuY);
			// menuY = new MenuManager("Systems",
			// "com.netxforge.d.ui.systemsmenu");
			// menuY.add(new
			// GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			// menuX.add(menuY);
			// menuY = new MenuManager("Geo", "com.netxforge.d.ui.geomenu");
			// menuY.add(new
			// GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			// menuX.add(menuY);
			// menuX.add(new
			// GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
			// menu.add(menuX);
		}
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		// WINDOW MENU
		{

			IMenuManager menuX = new MenuManager("Window",
					IWorkbenchActionConstants.M_WINDOW);
			IMenuManager menuY = new MenuManager("Task",
					"com.netxforge.d.ui.taskmenu");
			menuY.add(getAction(ActionFactory.EDIT_ACTION_SETS.getId()));
			menuY.add(new Separator());
			menuY.add(perspectivesMenu);

			MenuManager menuZ = new MenuManager("Views",
					"com.netxforge.d.ui.viewsmenu");
			// By default only "other..." is shown.
			menuZ.add(viewsMenu);

			menuX.add(menuY);
			menuX.add(menuZ);
			menuX.add(new Separator());

			String platform = SWT.getPlatform();
			if (!("carbon".equals(platform) || "cocoa".equals(platform))) {
				menuX.add(prefAction);
			}
			menu.add(menuX);
		}
		// HELP MENU
		{
			IMenuManager menuX = new MenuManager("Help",
					IWorkbenchActionConstants.M_HELP);
			menuX.add(getAction(ActionFactory.INTRO.getId()));
			menuX.add(new Separator());
			menuX.add(helpAction);
			menuX.add(aboutAction);
			menu.add(menuX);
		}
	}
}
