package com.netxforge.netxscript.rc1.rcp;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);
		String editorArea = layout.getEditorArea();
		IFolderLayout left = layout.createFolder(
				"left", IPageLayout.LEFT, 0.3f, editorArea); //$NON-NLS-1$	 //$NON-NLS-2$
		left.addView("com.netxforge.netxstudio.navigator.ProjectExplorer");

		IFolderLayout right = layout.createFolder(
				"right", IPageLayout.RIGHT, 0.3f, editorArea); //$NON-NLS-1$	 //$NON-NLS-2$
		right.addView("org.eclipse.ui.views.ContentOutline");
		
		IFolderLayout bottom = layout.createFolder(
				"bottom", IPageLayout.BOTTOM, 0.3f, editorArea); //$NON-NLS-1$	 //$NON-NLS-2$
		bottom.addView("org.eclipse.ui.console.ConsoleView");
		
		
	}

}
