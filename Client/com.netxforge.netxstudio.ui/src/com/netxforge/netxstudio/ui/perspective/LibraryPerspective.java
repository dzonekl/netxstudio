package com.netxforge.netxstudio.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;


public class LibraryPerspective implements IPerspectiveFactory {

	public static String ID = "com.netxforge.netxstudio.ui.library";

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		String editorArea = layout.getEditorArea();
		
		IFolderLayout left = layout.createFolder(
				"left", IPageLayout.LEFT, 0.3f,editorArea); //$NON-NLS-1$	 //$NON-NLS-2$
		left.addView("com.netxforge.netxstudio.navigator.ProjectExplorer");
		
//		IFolderLayout right = layout.createFolder(
//				"right", IPageLayout.RIGHT, 0.6f, editorArea); //$NON-NLS-1$
		//right.addView(IPageLayout.ID_OUTLINE);
		
		IFolderLayout bottom = layout.createFolder(
				"bottom", IPageLayout.BOTTOM, 0.4f, "com.netxforge.netxstudio.navigator.ProjectExplorer"); //$NON-NLS-1$	 //$NON-NLS-2$
		bottom.addView(IConsoleConstants.ID_CONSOLE_VIEW);
		bottom.addView(IPageLayout.ID_PROP_SHEET);
//		bottom.addView("org.eclipse.pde.runtime.LogView");
		
		layout.addPerspectiveShortcut(DesignPerspective.ID);
		layout.addPerspectiveShortcut(MonitoringPerspective.ID);
		
		
	}
}
