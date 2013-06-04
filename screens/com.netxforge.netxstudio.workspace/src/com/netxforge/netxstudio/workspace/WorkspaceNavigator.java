package com.netxforge.netxstudio.workspace;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.navigator.CommonNavigator;


/**
 * Custom CNF. 
 * 
 * See : http://rcpquickstart.com/2007/04/20/using-the-common-navigator-framework-in-an-rcp-application/
 * 
 * @author Christophe Bouhier
 *
 */
public class WorkspaceNavigator extends CommonNavigator {

	/**
	 * Override the root setting. 
	 * 
	 * @see org.eclipse.ui.navigator.CommonNavigator#getInitialInput()
	 */
	@Override
	protected Object getInitialInput() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}
	
}
