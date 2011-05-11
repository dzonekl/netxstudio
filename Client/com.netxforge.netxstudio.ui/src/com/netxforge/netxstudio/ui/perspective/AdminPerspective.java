package com.netxforge.netxstudio.ui.perspective;

import org.eclipse.ui.IPageLayout;

public class AdminPerspective extends AbstractFormPerspective {
	
	public static String ID = "com.netxforge.netxstudio.ui.admin";
	
	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		super.createInitialLayout(layout);
//		layout.addStandaloneView("com.netxforge.netxstudio.navigator.ProjectExplorer", false, IPageLayout.LEFT,0.95f, IPageLayout.ID_EDITOR_AREA);
		
//		IFolderLayout leftFolder = layout.createFolder("left", IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
//		leftFolder.addView("com.netxforge.netxstudio.navigator.ProjectExplorer");
		layout.addStandaloneView("com.netxforge.netxstudio.screens.selector.admin", false, IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
	}
}
