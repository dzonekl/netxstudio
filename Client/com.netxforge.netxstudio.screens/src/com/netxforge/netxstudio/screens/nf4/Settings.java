package com.netxforge.netxstudio.screens.nf4;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
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
import com.netxforge.netxstudio.generics.GenericsPackage;
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
	private Text txtQuick;
	private Text txtShort;
	private Text txtMedium;
	private Text txtLong;

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
		// buildUI();
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
				"Metric Sources Directory:", SWT.NONE);
		lblImportDirectory.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtImportDirectory = toolkit
				.createText(composite, "New Text", SWT.NONE);
		txtImportDirectory.setText("");
		GridData gd_txtImportDirectory = new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1);
		gd_txtImportDirectory.widthHint = 400;
		txtImportDirectory.setLayoutData(gd_txtImportDirectory);

		Label lblExportDirectory = toolkit.createLabel(composite,
				"Reports Directory:", SWT.NONE);
		lblExportDirectory.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtExportDirectory = toolkit
				.createText(composite, "New Text", SWT.NONE);
		txtExportDirectory.setText("");
		GridData gd_txtExportDirectory = new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1);
		gd_txtExportDirectory.widthHint = 400;
		txtExportDirectory.setLayoutData(gd_txtExportDirectory);

		Section sctnExpansionDuration = toolkit.createSection(
				frmSettings.getBody(), Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnExpansionDuration);
		sctnExpansionDuration.setText("Expansion Duration (# of days)");

		Composite expansionDurationComposite = toolkit.createComposite(
				sctnExpansionDuration, SWT.NONE);
		toolkit.paintBordersFor(expansionDurationComposite);
		sctnExpansionDuration.setClient(expansionDurationComposite);
		expansionDurationComposite.setLayout(new GridLayout(2, false));

		Label lblQuick = toolkit.createLabel(expansionDurationComposite,
				"QUICK:", SWT.NONE);
		lblQuick.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtQuick = toolkit.createText(expansionDurationComposite, "New Text",
				SWT.NONE);
		txtQuick.setText("");
		txtQuick.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label lblShort = toolkit.createLabel(expansionDurationComposite,
				"SHORT:", SWT.NONE);
		lblShort.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtShort = toolkit.createText(expansionDurationComposite, "New Text",
				SWT.NONE);
		txtShort.setText("");
		txtShort.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label lblMedium = toolkit.createLabel(expansionDurationComposite,
				"MEDIUM:", SWT.NONE);
		lblMedium.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtMedium = toolkit.createText(expansionDurationComposite, "New Text",
				SWT.NONE);
		txtMedium.setText("");
		txtMedium.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label lblLong = toolkit.createLabel(expansionDurationComposite,
				"LONG:", SWT.NONE);
		lblLong.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));

		txtLong = toolkit.createText(expansionDurationComposite, "New Text",
				SWT.NONE);
		txtLong.setText("");
		txtLong.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

	}

	public EMFDataBindingContext initDataBindings_() {

		// Import & export settings.
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

		// Expansion duration settings.

		IObservableValue quickDurationObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(
				this.txtQuick, SWT.Modify));

		IObservableValue shortDurationObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(
				this.txtShort, SWT.Modify));

		IObservableValue mediumDurationObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(
				this.txtMedium, SWT.Modify));

		IObservableValue longDurationObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(
				this.txtLong, SWT.Modify));

		IEMFValueProperty quickDurationProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										NetxstudioPackage.Literals.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS,
										GenericsPackage.Literals.EXPANSION_DURATION_SETTING__QUICK_DURATION,
										GenericsPackage.Literals.EXPANSION_DURATION_VALUE__VALUE));

		IEMFValueProperty shortDurationProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										NetxstudioPackage.Literals.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS,
										GenericsPackage.Literals.EXPANSION_DURATION_SETTING__SHORT_DURATION,
										GenericsPackage.Literals.EXPANSION_DURATION_VALUE__VALUE));

		IEMFValueProperty mediumDurationProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										NetxstudioPackage.Literals.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS,
										GenericsPackage.Literals.EXPANSION_DURATION_SETTING__MEDIUM_DURATION,
										GenericsPackage.Literals.EXPANSION_DURATION_VALUE__VALUE));

		IEMFValueProperty longDurationProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										NetxstudioPackage.Literals.SERVER_SETTINGS__EXPANSION_DURATION_SETTINGS,
										GenericsPackage.Literals.EXPANSION_DURATION_SETTING__LONG_DURATION,
										GenericsPackage.Literals.EXPANSION_DURATION_VALUE__VALUE));

//		EMFUpdateValueStrategy dayToTargetStrategy = new EMFUpdateValueStrategy();
//		dayToTargetStrategy.setConverter(new DayToTargetConverter());

//		bindingContext.bindValue(quickDurationObservable,
//				quickDurationProperty.observe(settings), null,
//				dayToTargetStrategy);

		bindingContext.bindValue(quickDurationObservable,
				quickDurationProperty.observe(settings), null,
				null);

		
//		bindingContext.bindValue(shortDurationObservable,
//				shortDurationProperty.observe(settings), null,
//				dayToTargetStrategy);

		bindingContext.bindValue(shortDurationObservable,
				shortDurationProperty.observe(settings), null,
				null);

		
//		bindingContext.bindValue(mediumDurationObservable,
//				mediumDurationProperty.observe(settings), null,
//				dayToTargetStrategy);

		bindingContext.bindValue(mediumDurationObservable,
		mediumDurationProperty.observe(settings), null,
		null);

		
//		bindingContext.bindValue(longDurationObservable,
//				longDurationProperty.observe(settings), null,
//				dayToTargetStrategy);

		bindingContext.bindValue(longDurationObservable,
				longDurationProperty.observe(settings), null,
				null);

		
		return bindingContext;
	}

	class DayToTargetConverter implements IConverter {

		public Object getFromType() {
			return Integer.class;
		}

		public Object getToType() {
			return String.class;
		}

		public Object convert(Object fromObject) {
			if (fromObject instanceof Integer) {
				return fromObject.toString();
			}
			return null;
		}

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

	@Override
	public String getScreenName() {
		return "Server Settings";
	}

}
