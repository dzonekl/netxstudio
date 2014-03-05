package com.netxforge.netxstudio.screens.f4;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
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

import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.screens.editing.base.IDataServiceInjection;

public class MetricSourceLocations extends AbstractScreen implements IDataServiceInjection {

	private static final String REPORTS_MONITORS_MONITORS_JSP = "/reports/monitors/monitors.jsp";
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Form frmServices;

	@Inject
	ServerRequest serverActions;
	private Browser browser;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public MetricSourceLocations(Composite parent, int style) {
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
		URI uri = URI.createURI(serverPath + REPORTS_MONITORS_MONITORS_JSP);
		if(uri.toString().equals(current)){
			browser.refresh();
		}else{
			browser.setUrl(uri.toString());
		}
		
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		return bindingContext;
	}

	public void injectData() {
		
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

	@Override
	public String getScreenName() {
		return "Reports";
	}

	
}
