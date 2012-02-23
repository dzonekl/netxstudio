package com.netxforge.netxstudio.screens.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.netxforge.netxstudio.screens.editing.selector.AbstractScreenViewer;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f4.ChartScreen;

public class ChartScreenViewer extends AbstractScreenViewer {

	private ChartScreen chartScreen;

	public IScreen getScreen() {
		return chartScreen;
	}

	public void initScreen(Composite parent) {
		chartScreen = new ChartScreen(parent, SWT.NONE);
		chartScreen.setOperation(ScreenUtil.OPERATION_READ_ONLY);
		chartScreen.setEditingService(getEditingService());
		chartScreen.buildUI();
	}
}
