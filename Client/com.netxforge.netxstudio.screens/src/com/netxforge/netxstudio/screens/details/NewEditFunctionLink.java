/*******************************************************************************
 * Copyright (c) Aug 3, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.details;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.FunctionFilterDialog;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class NewEditFunctionLink extends NewEditLink implements IScreen {

	private Text txtFunction1;
	private Text txtFunction2;

	public NewEditFunctionLink(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, SWT.NONE, editingService);
		// buildUI();
	}

	public boolean isValid() {
		return false;
	}

	public void buildUI() {

		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		super.buildInfoSection(widgetStyle);
		this.buildProtocol(widgetStyle);
		super.buildNodeLinkSection(widgetStyle);
		buildFunctionLinkSection();
	}

	private void buildFunctionLinkSection() {

		Section sctnFunctionLink = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnFunctionLink);
		sctnFunctionLink.setText("Function Link");

		Composite composite_1 = toolkit.createComposite(sctnFunctionLink,
				SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnFunctionLink.setClient(composite_1);
		composite_1.setLayout(new GridLayout(4, false));

		Label lblFunction1 = toolkit.createLabel(composite_1, "Function #1",
				SWT.NONE);
		lblFunction1.setAlignment(SWT.RIGHT);
		GridData gd_lblFunction1 = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFunction1.widthHint = 80;
		lblFunction1.setLayoutData(gd_lblFunction1);

		txtFunction1 = toolkit.createText(composite_1, "New Text",
				SWT.READ_ONLY);
		txtFunction1.setText("");
		GridData gd_txtFunction1 = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFunction1.widthHint = 150;
		txtFunction1.setLayoutData(gd_txtFunction1);

		ImageHyperlink hypLnkFunction1 = toolkit.createImageHyperlink(
				composite_1, SWT.NONE);
		hypLnkFunction1.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// Set the ref to null.
				Command set = new SetCommand(
						editingService.getEditingDomain(),
						relationship,
						OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION1_REF,
						null);
				editingService.getEditingDomain().getCommandStack()
						.execute(set);
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});

		GridData gd_HypLnkFunction1 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_HypLnkFunction1.widthHint = 18;
		hypLnkFunction1.setLayoutData(gd_HypLnkFunction1);
		hypLnkFunction1.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(hypLnkFunction1);
		hypLnkFunction1.setText("");

		Button btnSelectFunction1 = toolkit.createButton(composite_1,
				"Select...", SWT.NONE);
		btnSelectFunction1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// Operator->Network->Node->Nodetype->Function......
				// Resource operatorResource = editingService
				// .getData(OperatorsPackage.Literals.OPERATOR);

				if (relationship.getNodeID1Ref() != null) {
					FunctionFilterDialog dialog = new FunctionFilterDialog(
							NewEditFunctionLink.this.getShell(), relationship
									.getNodeID1Ref());
					if (dialog.open() == IDialogConstants.OK_ID) {
						Function function1 = (Function) dialog.getFirstResult();
						((FunctionRelationship) relationship)
								.setFunction1Ref(function1);
					}
				} else {

				}
			}
		});

		Label lblFunction2 = toolkit.createLabel(composite_1, "Function #2",
				SWT.NONE);
		lblFunction2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtFunction2 = toolkit.createText(composite_1, "New Text",
				SWT.READ_ONLY);
		txtFunction2.setText("");
		txtFunction2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		ImageHyperlink hypLnkFunction2 = toolkit.createImageHyperlink(
				composite_1, SWT.NONE);
		hypLnkFunction2.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		GridData gd_HypLnkFunction2 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_HypLnkFunction2.widthHint = 18;
		hypLnkFunction2.setLayoutData(gd_HypLnkFunction2);
		toolkit.paintBordersFor(hypLnkFunction2);
		hypLnkFunction2.setText("");
		hypLnkFunction2.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// Set the ref to null.
				Command set = new SetCommand(
						editingService.getEditingDomain(),
						relationship,
						OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION2_REF,
						null);
				editingService.getEditingDomain().getCommandStack()
						.execute(set);
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});

		Button btnSelectFunction2 = toolkit.createButton(composite_1,
				"Select...", SWT.NONE);
		btnSelectFunction2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node->Nodetype->Function......
				// Resource operatorResource = editingService
				// .getData(OperatorsPackage.Literals.OPERATOR);

				if (relationship.getNodeID2Ref() != null) {

					FunctionFilterDialog dialog = new FunctionFilterDialog(
							NewEditFunctionLink.this.getShell(),
							relationship.getNodeID2Ref());
					if (dialog.open() == IDialogConstants.OK_ID) {
						Function function2 = (Function) dialog.getFirstResult();
						((FunctionRelationship) relationship)
								.setFunction2Ref(function2);
					}
				}
			}
		});
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = super.initDataBindings_();
		bindInfoSection(context);
		bindNodeLinkSection(context);
		bindProtocolSection(context);
		bindFunctionLinkSection(context);
		return context;
	}

	private void bindFunctionLinkSection(EMFDataBindingContext context) {
		// Binding of sub relationships

		IObservableValue function1Observable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtFunction1, SWT.Modify));

		IObservableValue function2Observable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtFunction2, SWT.Modify));

		IEMFValueProperty linkFunction1Property = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION1_REF,
										LibraryPackage.Literals.COMPONENT__NAME));

		IEMFValueProperty linkFunction2Property = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION2_REF,
										LibraryPackage.Literals.COMPONENT__NAME));

		context.bindValue(function1Observable,
				linkFunction1Property.observe(relationship), null, null);
		context.bindValue(function2Observable,
				linkFunction2Property.observe(relationship), null, null);
	}
}
