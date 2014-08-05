package com.netxforge.netxstudio.screens.perspective;

import org.eclipse.ui.IPageLayout;

public class DesignPerspective extends AbstractFormPerspective {
	
	public static String ID = "com.netxforge.netxstudio.ui.perspective.design";
	
	public void createInitialLayout(IPageLayout layout) {
		
		super.createInitialLayout(layout);
		layout.addStandaloneView("com.netxforge.netxstudio.screens.selector.design", false, IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);		
		layout.addActionSet("com.netxforge.netxstudio.ui.designActionSet");
		
	}
}
