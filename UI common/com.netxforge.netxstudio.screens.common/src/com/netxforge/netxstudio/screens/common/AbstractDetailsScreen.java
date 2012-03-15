package com.netxforge.netxstudio.screens.common;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;

/**
 * Specialized Screen which forces a column layout on the composite.
 * 
 * @author Christophe
 * 
 */
public abstract class AbstractDetailsScreen extends AbstractScreenImpl {

	protected FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	@Inject
	protected ModelUtils modelUtils;

	public AbstractDetailsScreen(Composite parent, int style) {
		super(parent, style);
		super.setLayout(new ColumnLayout());
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}
	
	
	public void addData() {
		//N/A
	}

	public Viewer getViewer() {
		//N/A
		return null;
	}

	public Form getScreenForm() {
		//N/A
		return null;
	}
}
