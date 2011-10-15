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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.service.datalocation.Location;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.netxforge.netxstudio.workspace.IWorkspaceUtil;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {
	
	IWorkspaceUtil util;
	
	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) {
		
		Display display = PlatformUI.createDisplay();
		
		// Immidiatly set the workspace location. 
		this.setWorkspaceLocation(display.getActiveShell());
		
		try {
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART) {
				return IApplication.EXIT_RESTART;
			}
			return IApplication.EXIT_OK;
		} finally {
			display.dispose();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		if (!PlatformUI.isWorkbenchRunning())
			return;
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}
	
	
	//// DS Actication/Deactivation
	public void startup(){
		util.initProjectCreationWizard();
	}
	
	public void shutdown(){
		// No specific shutdown.
	}
	
	public void setWorkspaceUtil(IWorkspaceUtil util ){
		this.util = util;
	}
	
	
	public void setWorkspaceLocation(Shell splash) {
		// set location to c:\temp

		// fetch the Location that we will be modifying
		Location instanceLoc = Platform.getInstanceLocation();
		if (instanceLoc.isSet()) {
			return;
		}
		try {
			// // temp should always return a location.
			// String temp = System.getProperty("java.io.tmpdir");
			// if (temp != null) {
			// instanceLoc.set(new URL("file", null, temp), false);
			// }
			//

			// get what the user last said about remembering the workspace
			// location
			boolean remember = PickWorkspaceDialog.isRememberWorkspace();

			// get the last used workspace location
			String lastUsedWs = PickWorkspaceDialog
					.getLastSetWorkspaceDirectory();

			// if we have a "remember" but no last used workspace, it's not much
			// to
			// remember
			if (remember && (lastUsedWs == null || lastUsedWs.length() == 0)) {
				remember = false;
			}

			// check to ensure the workspace location is still OK
			if (remember) {
				// if there's any problem whatsoever with the workspace, force a
				// dialog which in its turn will tell them what's bad
				String ret = PickWorkspaceDialog.checkWorkspaceDirectory(
						splash, lastUsedWs,
						false, false);
				if (ret != null) {
					remember = false;
				}

			}

			// if we don't remember the workspace, show the dialog
			if (!remember) {
				PickWorkspaceDialog pwd = new PickWorkspaceDialog(splash, false);
				int pick = pwd.open();

				// if the user cancelled, we can't do anything as we need a
				// workspace, so in this case, we tell them and exit
				if (pick == Window.CANCEL) {
					if (pwd.getSelectedWorkspaceLocation() == null) {
						MessageDialog
								.openError(splash, "Error",
										"The application can not start without a workspace root and will now exit.");
						try {
							PlatformUI.getWorkbench().close();
						} catch (Exception err) {

						}
					}
				} else {
					// tell Eclipse what the selected location was and continue
					instanceLoc.set(
							new URL("file", null, pwd
									.getSelectedWorkspaceLocation()), false);
				}
			} else {
				// set the last used location and continue
				instanceLoc.set(new URL("file", null, lastUsedWs), false);
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
