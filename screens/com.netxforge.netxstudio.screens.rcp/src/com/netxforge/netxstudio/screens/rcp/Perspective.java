package com.netxforge.netxstudio.screens.rcp;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		// Top left: Resource Navigator view and Bookmarks view placeholder
		String ea = layout.getEditorArea();
		IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.25f,
					ea);
		topLeft.addView("com.netxforge.netxstudio.screens.demo.DemoViewPartSelector");
//		layout.addView("com.netxforge.netxstudio.screens.demo.DemoViewPartSelector", IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
	}
}
