package com.netxforge.netxstudio.screens.f1;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.f1.model.WrappedRFSService;
import com.netxforge.netxstudio.screens.f1.parts.ServiceEditPartFactory;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.screens.editing.base.IDataScreenInjection;

public class ServiceHierarchy extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Form frmServices;

	private ScrollingGraphicalViewer graphicalViewer;
	private RFSService service;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ServiceHierarchy(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmServices = toolkit.createForm(this);
		frmServices.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmServices);
		frmServices.setText("Hierarchy");
		FillLayout fl = new FillLayout(SWT.HORIZONTAL);
		fl.marginHeight = 20;
		
		frmServices.getBody().setLayout(fl);

		// Do some gef here.
		ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart();
		graphicalViewer = new ScrollingGraphicalViewer();
//		graphicalViewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, true);
		graphicalViewer.createControl(frmServices.getBody());
		graphicalViewer.getControl().setBackground(
				ColorConstants.listBackground);
		graphicalViewer.setRootEditPart(rootEditPart);
		graphicalViewer.setEditPartFactory(new ServiceEditPartFactory());
		
		rootEditPart.refresh();

	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		graphicalViewer.setContents(new WrappedRFSService(service));
		return bindingContext;
	}

	public void injectData(Object owner, Object object) {

		if (object != null
				&& object instanceof RFSService) {
			service = (RFSService)object;
			// Always present the root service. 
			service = (RFSService) StudioUtils.resolveRootService(service);
		}

		buildUI();
		initDataBindings_();
	}

	public void disposeData() {
		// N/A
	}

	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return frmServices;
	}

	public void addData() {
		// N/A
	}

	@Override
	public String getScreenName() {
		return "Service Hierarchy";
	}
	
}
