package com.netxforge.netxstudio.screens.perspective;

import org.eclipse.ui.IPageLayout;

public class MonitoringPerspective extends AbstractFormPerspective {
	
	public static String ID = "com.netxforge.netxstudio.ui.perspective.monitoring";
	public void createInitialLayout(IPageLayout layout) {
		super.createInitialLayout(layout);
		layout.addStandaloneView("com.netxforge.netxstudio.screens.selector.monitoring", false, IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
	}
}
