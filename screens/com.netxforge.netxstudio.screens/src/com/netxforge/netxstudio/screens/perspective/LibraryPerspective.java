package com.netxforge.netxstudio.screens.perspective;

import org.eclipse.ui.IPageLayout;


public class LibraryPerspective extends AbstractFormPerspective {

	public static String ID = "com.netxforge.netxstudio.ui.perspective.library";

	public void createInitialLayout(IPageLayout layout) {
		super.createInitialLayout(layout);
		layout.addStandaloneView("com.netxforge.netxstudio.screens.selector.library", false, IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
	}
}
