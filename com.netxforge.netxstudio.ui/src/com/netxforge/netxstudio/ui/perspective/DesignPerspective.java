package com.netxforge.netxstudio.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class DesignPerspective implements IPerspectiveFactory {
	
	public static String ID = "com.netxforge.netxstudio.ui.networkdesign";
	
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		String editorArea = layout.getEditorArea();
		IFolderLayout left = layout.createFolder(
				"left", IPageLayout.LEFT, 0.3f,editorArea); //$NON-NLS-1$	 //$NON-NLS-2$
		left.addView("com.netxforge.netxstudio.navigator.ProjectExplorer");
		left.addView(IPageLayout.ID_PROP_SHEET);
		
		layout.addActionSet("com.netxforge.netxstudio.ui.designActionSet");
		
	}
}
