package com.netxforge.netxstudio.callflow.screens.connectivity;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.callflow.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

public class Connectivity extends AbstractScreen implements IDataServiceInjection {
	
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	
	private Form frmConnectivity;
	
	public Connectivity(Composite parent, int style) {
		super(parent, style);
		
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		buildUI();
	}

	private void buildUI() {
		
setLayout(new FillLayout(SWT.HORIZONTAL));
		
		@SuppressWarnings("unused")
		int widgetStyle = SWT.None;
		if (ScreenUtil.isReadOnlyOperation(getOperation())) {
			widgetStyle |= SWT.READ_ONLY;
		}

		// Create the form.
		frmConnectivity = toolkit.createForm(this);
		frmConnectivity.setSeparatorVisible(true);

		frmConnectivity.setText(this.getScreenName());
		frmConnectivity.getToolBarManager().update(true);
		frmConnectivity.setToolBarVerticalAlignment(SWT.TOP);

		
		toolkit.decorateFormHeading(frmConnectivity);
		toolkit.paintBordersFor(frmConnectivity);

		// Body of the form.
		FillLayout fl = new FillLayout();
		frmConnectivity.getBody().setLayout(fl); 
		
	}

	public Form getScreenForm() {
		return frmConnectivity;
	}

	public EMFDataBindingContext initDataBindings_() {
		
		@SuppressWarnings("unused")
		EMFDataBindingContext emfDataBindingContext = new EMFDataBindingContext();
		
		
		return null;
	}

	public Viewer getViewer() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.callflow.screens.AbstractScreenImpl#getScreenName()
	 */
	@Override
	public String getScreenName() {
		return "Connectivity";
	}

}
