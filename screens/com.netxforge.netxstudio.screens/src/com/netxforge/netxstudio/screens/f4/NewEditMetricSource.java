/*******************************************************************************
 * Copyright (c) 17 dec. 2012 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.f4.support.MappingTypeDialog;
import com.netxforge.screens.editing.base.IDataScreenInjection;
import com.netxforge.screens.editing.base.ScreenUtil;
import com.netxforge.screens.editing.base.util.ValidationService;


/**
 * 
 * @author Christophe Bouhier
 */
public class NewEditMetricSource extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Text txtLocationUrl;
	private MetricSource metricSource;
	private Resource owner;
	private Form frmNewEditMetricSource;

	private EMFDataBindingContext context;
	
	// CB, 26012012, moved to AbstractFileBasedMapping. 
//	private Text txtFilePattern;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditMetricSource(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				validationService.dispose();
				validationService
						.removeValidationListener(NewEditMetricSource.this);
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
//		buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View: " : "Edit: ";
		
		@SuppressWarnings("unused")
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmNewEditMetricSource = toolkit.createForm(this);
		frmNewEditMetricSource.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewEditMetricSource);
		frmNewEditMetricSource.setText(actionText + " Metric Source");
		
		frmNewEditMetricSource.getBody().setLayout(new FormLayout());

		Section sctnNewSection = toolkit.createSection(
				frmNewEditMetricSource.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.top = new FormAttachment(0, 12);
		fd_sctnNewSection.right = new FormAttachment(100, -12);
		fd_sctnNewSection.left = new FormAttachment(0, 12);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Info");

		Composite composite_1 = toolkit.createComposite(sctnNewSection,
				SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnNewSection.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));

		Label lblName = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 70;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		txtName.setText("");

		Label lblLocationUrl = toolkit.createLabel(composite_1,
				"Location URL:", SWT.NONE);
		lblLocationUrl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblLocationUrl.setAlignment(SWT.RIGHT);

		txtLocationUrl = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtLocationUrl.setText("");
		txtLocationUrl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		
		Label lblNewEditMapping = toolkit.createLabel(composite_1, "Mapping:",
				SWT.NONE);
		lblNewEditMapping.setAlignment(SWT.RIGHT);
		lblNewEditMapping.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		Hyperlink hprlnkAddMapping = toolkit.createHyperlink(composite_1,
				"Mapping", SWT.NONE);
		hprlnkAddMapping.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				
				if(!validationService.isValid()){
					return;
				}
				
				Mapping mapping = null;
				int operation = ScreenUtil.OPERATION_NEW;
				if (metricSource.getMetricMapping() == null) {

					MappingTypeDialog mdg = new MappingTypeDialog(
							NewEditMetricSource.this.getShell());
					mdg.open();
					int result = mdg.getReturnCode();
					if (result == Dialog.CANCEL) {
						return;
					}
					switch (mdg.getSelection()) {
					case MappingTypeDialog.MAPPING_XLS: {
						mapping = MetricsFactory.eINSTANCE.createMappingXLS();

					}
						break;
					case MappingTypeDialog.MAPPING_CSV: {
						mapping = MetricsFactory.eINSTANCE.createMappingCSV();
					}
						break;

					case MappingTypeDialog.MAPPING_RDBMS: {
						mapping = MetricsFactory.eINSTANCE.createMappingRDBMS();
					}
						break;

					}
				} else {
					mapping = metricSource.getMetricMapping();
					operation = ScreenUtil.OPERATION_EDIT;
				}

				if (mapping instanceof MappingXLS) {
					NewEditMappingXLS mappingScreen = new NewEditMappingXLS(
							screenService.getScreenContainer(), SWT.NONE);
					mappingScreen.setOperation(operation);
					mappingScreen.setScreenService(screenService);
					mappingScreen.injectData(metricSource, mapping);
					screenService.setActiveScreen(mappingScreen);

				}
				if (mapping instanceof MappingCSV) {
					NewEditMappingCSV mappingScreen = new NewEditMappingCSV(
							screenService.getScreenContainer(), SWT.NONE);
					mappingScreen.setOperation(operation);
					mappingScreen.setScreenService(screenService);
					mappingScreen.injectData(metricSource, mapping);
					screenService.setActiveScreen(mappingScreen);
				}
				if (mapping instanceof MappingRDBMS) {
					NewEditMappingRDBMS mappingScreen = new NewEditMappingRDBMS(
							screenService.getScreenContainer(), SWT.NONE);
					mappingScreen.setOperation(operation);
					mappingScreen.setScreenService(screenService);
					mappingScreen.injectData(metricSource, mapping);
					screenService.setActiveScreen(mappingScreen);
				}

			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(hprlnkAddMapping);
		fd_sctnNewSection.bottom = new FormAttachment(0, 155);
	}

	public EMFDataBindingContext initDataBindings_() {
		
		EMFDataBindingContext context = new EMFDataBindingContext();
		
		// Validation Strategies
		EMFUpdateValueStrategy nameStrategy = ValidationService.getStrategyfactory()
				.strategyBeforeSetStringNotEmpty("Name is required");

		EMFUpdateValueStrategy locationStrategy = ValidationService.getStrategyfactory()
				.strategyBeforeSetStringNotEmpty("Metric Source Location URL is required");


		IObservableValue nameObservable = SWTObservables.observeText(txtName,
				SWT.Modify);
		
		IObservableValue locationObservable = SWTObservables.observeText(
				this.txtLocationUrl, SWT.Modify);
		
		IEMFValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.METRIC_SOURCE__NAME);
		
		IEMFValueProperty locationProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.METRIC_SOURCE__METRIC_LOCATION);

		context.bindValue(nameObservable, nameProperty.observe(metricSource),
				nameStrategy, null);

		context.bindValue(locationObservable,
				locationProperty.observe(metricSource), locationStrategy, null);
		
		return context;
	}

	public void injectData(Object owner, Object object) {

		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}

		if (object != null && object instanceof MetricSource) {
			metricSource = (MetricSource) object;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}

		buildUI();
		context = initDataBindings_();
		validationService.registerBindingContext(context);
		validationService.addValidationListener(this);
	}

	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), metricSource);
			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (metricSource.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}
	}

	public Viewer getViewer() {
		return null; // N/A
	}

	@Override
	public boolean isValid() {
		return validationService.isValid();
	}

	public Form getScreenForm() {
		return frmNewEditMetricSource;
	}

	public void disposeData() {
		// N/A
	}

	public String getScreenName() {
		return "Metric Source";
	}

}
