package com.netxforge.netxstudio.screens.f1;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class Reports extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Form frmServices;
	private Resource operatorsResource;

	@Inject
	ServerRequest serverActions;
	private Browser browser;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Reports(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
//		 buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmServices = toolkit.createForm(this);
		frmServices.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmServices);
		frmServices.setText("Reports");
		frmServices.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		browser = new Browser(frmServices.getBody(), SWT.NONE);
		toolkit.adapt(browser);
		toolkit.paintBordersFor(browser);

	}

	public EMFDataBindingContext initDataBindings_() {
		
		String current = browser.getUrl();
		
		String serverPath = serverActions.setServer();
		URI uri = URI.createURI(serverPath + "/reports/monitors/monitors.jsp");
		if(uri.toString().equals(current)){
			browser.refresh();
		}else{
			browser.setUrl(uri.toString());
		}
		
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		return bindingContext;
	}

	public void injectData() {
		
		operatorsResource = editingService
				.getData(OperatorsPackage.Literals.OPERATOR);

		// This piece goes in commons somewhere.
		Resource settingsResource = editingService
				.getData(NetxstudioPackage.Literals.SERVER_SETTINGS);
		ServerSettings settings = null;
		if (settingsResource != null
				&& settingsResource.getContents().size() == 1) {
			settings = (ServerSettings) settingsResource.getContents().get(0);
		}

		if (settings != null) {
			settings.getExportPath();

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

}
