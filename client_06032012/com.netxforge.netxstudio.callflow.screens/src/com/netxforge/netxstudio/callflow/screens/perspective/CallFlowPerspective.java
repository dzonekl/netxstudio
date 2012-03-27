package com.netxforge.netxstudio.callflow.screens.perspective;

import org.eclipse.ui.IPageLayout;

import com.netxforge.netxstudio.screens.common.perspective.AbstractFormPerspective;


public class CallFlowPerspective extends AbstractFormPerspective {

	public static String ID = "com.netxforge.netxstudio.ui.perspective.callflows";

	public void createInitialLayout(IPageLayout layout) {
		super.createInitialLayout(layout);
		layout.addStandaloneView("com.netxforge.netxstudio.screens.selector.callflow", false, IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);		
	}
}
