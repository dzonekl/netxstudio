package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;

public class Settings extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Form frmSettings;

	@Inject
	ServerRequest serverActions;
	private ServerSettings settings;
	private Text txtImportDirectory;
	private Text txtExportDirectory;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Settings(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
//		buildUI();
	}

	public Viewer getViewer() {
		// N/A
		return null;
	}

	public void injectData() {
		Resource serverSettingsResource = editingService
				.getData(NetxstudioPackage.Literals.SERVER_SETTINGS);
		if (serverSettingsResource.getContents().size() == 1) {
			settings = (ServerSettings) serverSettingsResource.getContents()
					.get(0);
		}

		buildUI();
		initDataBindings_();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmSettings = toolkit.createForm(this);
		frmSettings.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmSettings);
		frmSettings.setText("Settings");
		frmSettings.getBody().setLayout(new ColumnLayout());

		Section sctnServerDirectories = toolkit.createSection(
				frmSettings.getBody(), Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnServerDirectories);
		sctnServerDirectories.setText("Server Directories");
		sctnServerDirectories.setExpanded(true);

		Composite composite = toolkit.createComposite(sctnServerDirectories,
				SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnServerDirectories.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblImportDirectory = toolkit.createLabel(composite,
				"Import Directory:", SWT.NONE);
		lblImportDirectory.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtImportDirectory = toolkit
				.createText(composite, "New Text", SWT.NONE);
		txtImportDirectory.setText("");
		txtImportDirectory.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));

		Label lblExportDirectory = toolkit.createLabel(composite,
				"Export Directory:", SWT.NONE);
		lblExportDirectory.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtExportDirectory = toolkit
				.createText(composite, "New Text", SWT.NONE);
		txtExportDirectory.setText("");
		txtExportDirectory.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));

	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		IObservableValue importDirectoryObservable = SWTObservables
				.observeText(this.txtImportDirectory, SWT.Modify);

		IObservableValue exportDirectoryObservable = SWTObservables
				.observeText(this.txtExportDirectory, SWT.Modify);

		IEMFValueProperty importPathProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				NetxstudioPackage.Literals.SERVER_SETTINGS__IMPORT_PATH);
		IEMFValueProperty exportPathProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				NetxstudioPackage.Literals.SERVER_SETTINGS__EXPORT_PATH);

		bindingContext.bindValue(importDirectoryObservable,
				importPathProperty.observe(settings), null, null);
		bindingContext.bindValue(exportDirectoryObservable,
				exportPathProperty.observe(settings), null, null);

		return bindingContext;
	}

	public void disposeData() {
		// N/A
	}

	public boolean isValid() {
		return false;
	}

	@Override
	public Form getScreenForm() {
		return this.frmSettings;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

}
