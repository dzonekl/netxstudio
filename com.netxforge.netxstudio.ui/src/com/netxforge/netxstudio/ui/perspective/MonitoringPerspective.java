package com.netxforge.netxstudio.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class MonitoringPerspective implements IPerspectiveFactory {
	
	public static String ID = "com.netxforge.netxstudio.ui.monitoring";
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		String editorArea = layout.getEditorArea();
		IFolderLayout left = layout.createFolder(
				"left", IPageLayout.LEFT, 0.4f, editorArea); //$NON-NLS-1$	 //$NON-NLS-2$
		left.addView("com.netxforge.netxstudio.navigator.ProjectExplorer");
		IFolderLayout bottom = layout.createFolder(
				"bottom", IPageLayout.BOTTOM, 0.4f, editorArea); //$NON-NLS-1$	 //$NON-NLS-2$
		bottom.addView("org.eclipse.ui.views.ProgressView");
	}

}
