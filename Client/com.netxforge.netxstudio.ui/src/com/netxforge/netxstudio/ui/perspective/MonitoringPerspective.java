package com.netxforge.netxstudio.ui.perspective;

import org.eclipse.ui.IPageLayout;

public class MonitoringPerspective extends AbstractFormPerspective {
	
	public static String ID = "com.netxforge.netxstudio.ui.monitoring";
	public void createInitialLayout(IPageLayout layout) {
		super.createInitialLayout(layout);
		layout.addStandaloneView("com.netxforge.netxstudio.screens.selector.monitoring", false, IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
	}
}
