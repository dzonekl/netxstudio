package com.netxforge.netxstudio.screens.f1;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f1.model.WrappedRFSService;
import com.netxforge.netxstudio.screens.f1.parts.ServiceEditPartFactory;
import com.netxforge.netxstudio.services.RFSService;

public class ServiceHierarchy extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Form frmServices;
	private Resource operatorsResource;

	@Inject
	ServerRequest serverActions;
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
		}

		buildUI();
		initDataBindings_();
	}

	public void disposeData() {
		editingService.disposeData(operatorsResource);
	}

	@Override
	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmServices;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}

	@Override
	public IAction[] getActions() {

		@SuppressWarnings("unused")
		boolean readonly = Screens.isReadOnlyOperation(getOperation());
		@SuppressWarnings("unused")
		String actionText = Screens.isReadOnlyOperation(getOperation()) ? "View"
				: "Edit";

		List<IAction> actions = Lists.newArrayList();
		IAction[] actionArray = new IAction[actions.size()];
		return actions.toArray(actionArray);
	}

	public void addData() {
		// N/A
	}

	@Override
	public String getScreenName() {
		return "Service Hierarchy";
	}
	
}
