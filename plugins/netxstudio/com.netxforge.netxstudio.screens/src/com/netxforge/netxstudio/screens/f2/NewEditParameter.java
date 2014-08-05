/*******************************************************************************
 * Copyright (c) 21 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.f2;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.eclipse.core.databinding.conversion.IConverter;
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.widgets.formattedtext.FormattedText;
import org.eclipse.nebula.widgets.formattedtext.LongFormatter;
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

import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.screens.editing.base.IDataScreenInjection;
import com.netxforge.screens.editing.base.ScreenUtil;


/**
 * Christophe Bouhier
 * @author Christophe
 */
public class NewEditParameter extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	
	private Form frmParameter;
	private Resource owner;
	private Parameter parameter;
	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;

	private Text txtName;
	private Text txtDescription;
	private Text txtExpressionName;
	private Text txtValue;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditParameter(Composite parent, int style) {
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

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmParameter = toolkit.createForm(this);
		frmParameter.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmParameter);

		frmParameter.setText(getOperationText() + "Expression Parameter");
		ColumnLayout cl = new ColumnLayout();
		cl.maxNumColumns = 1;
		frmParameter.getBody().setLayout(cl);

		Section sctnMappings = toolkit.createSection(frmParameter.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnMappings);
		sctnMappings.setText("Info");

		Composite composite_1 = toolkit.createComposite(sctnMappings, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnMappings.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));

		Label lblName = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 70;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite_1, "New Text", widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);

		Label lblExpressionName = toolkit.createLabel(composite_1,
				"Expression Name:", SWT.NONE);
		lblExpressionName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		lblExpressionName.setAlignment(SWT.RIGHT);

		txtExpressionName = toolkit.createText(composite_1, "New Text",
				widgetStyle);
		txtExpressionName.setText("");
		GridData gd_txtExpressionName = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtExpressionName.widthHint = 150;
		txtExpressionName.setLayoutData(gd_txtExpressionName);
		
		final Label lblValue = toolkit.createLabel(composite_1, "Value:", SWT.NONE);
		lblValue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblValue.setAlignment(SWT.RIGHT);
		
		FormattedText formattedText = new FormattedText(composite_1, SWT.BORDER | SWT.RIGHT | widgetStyle);
		LongFormatter numberFormatter = new LongFormatter(NonModelUtils.DEFAULT_VALUE_FORMAT_PATTERN);
		numberFormatter.setDecimalSeparatorAlwaysShown(true);
		formattedText.setFormatter(numberFormatter);
		txtValue = formattedText.getControl();
		
		GridData gd_txtValue = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtValue.widthHint = 150;
		txtValue.setLayoutData(gd_txtValue);
		
		final Label lblDescription = toolkit.createLabel(composite_1, "Description:",
				SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblDescription.setAlignment(SWT.RIGHT);

		txtDescription = toolkit.createText(composite_1, "New Text", SWT.WRAP
				| SWT.MULTI | widgetStyle);
		txtDescription.setText("");
		GridData gd_txtNewText = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_txtNewText.heightHint = 89;
		txtDescription.setLayoutData(gd_txtNewText);
		
		// bug 248, tab order. not sure why this is here??
//		composite_1.setTabList(new Control[] { txtName, txtDescription });
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		// text widgets.

		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));

		IObservableValue expressionNameObservable = SWTObservables
				.observeDelayedValue(400, SWTObservables.observeText(
						this.txtExpressionName, SWT.Modify));

		IObservableValue descriptionObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtDescription, SWT.Modify));

		IObservableValue valueObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtValue, SWT.Modify));
		
		
		// Strategies to convert the values. 
		EMFUpdateValueStrategy valueModelToTargetStrategy = new EMFUpdateValueStrategy();
		valueModelToTargetStrategy.setConverter(new IConverter() {
			public Object getFromType() {
				return Double.class;
			}

			public Object getToType() {
				return String.class;
			}

			public Object convert(Object fromObject) {
				
				// Use a Decimal formatter, so we don't display Exponent, 
				// which is default for a Double.toString()
				DecimalFormat decimalFormat = new DecimalFormat(NonModelUtils.DEFAULT_VALUE_FORMAT_PATTERN);
				return decimalFormat.format(fromObject);
			}
		});

		EMFUpdateValueStrategy valueTargetToModelStrategy = new EMFUpdateValueStrategy();
		valueTargetToModelStrategy.setConverter(new IConverter() {
			public Object getFromType() {
				return String.class;
			}

			public Object getToType() {
				return Double.class;
			}

			public Object convert(Object fromObject) {
				try {
					
					String s = (String) fromObject;
					Number parse = DecimalFormat.getInstance().parse(s);
					return parse.doubleValue();
				} catch (NumberFormatException nfe) {
				} catch (ParseException e) {
				}
				return null;
			}
		});

		// Properties
		IEMFValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.PARAMETER__NAME);

		IEMFValueProperty expressionNameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.PARAMETER__EXPRESSION_NAME);

		IEMFValueProperty descriptionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.PARAMETER__DESCRIPTION);

		IEMFValueProperty valueProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.PARAMETER__VALUE);

		context.bindValue(nameObservable, nameProperty.observe(parameter),
				null, null);
		context.bindValue(expressionNameObservable,
				expressionNameProperty.observe(parameter), null, null);

		context.bindValue(descriptionObservable,
				descriptionProperty.observe(parameter), null, null);

		context.bindValue(valueObservable, valueProperty.observe(parameter),
				valueTargetToModelStrategy, valueModelToTargetStrategy);

		return context;
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		if (object != null && object instanceof Parameter) {
			parameter = (Parameter) object;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		buildUI();
		m_bindingContext = initDataBindings_();
	}

	public void addData() {
		if (ScreenUtil.isNewOperation(this) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c;

			c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), parameter);

			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (parameter.cdoInvalid()) {
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
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return frmParameter;
	}

	public void disposeData() {
		// N/A
	}

	public String getScreenName() {
		return "Parameter";
	}

}
