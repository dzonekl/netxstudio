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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.ResourceManager;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.FunctionFilterDialog;
import com.netxforge.netxstudio.screens.NodeFilterDialog;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class NewEditFunctionLink extends AbstractDetailsComposite implements IScreen,
		IDataScreenInjection {

	private FunctionRelationship relationship;
	private FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private IEditingService editingService;

	@Inject
	ModelUtils modelUtils;
	private Text txtNode2;
	private Text txtNode1;
	protected Section scnInfo;
	protected Section sctnNode;
	private Text txtFunction1;
	private Text txtFunction2;

	public NewEditFunctionLink(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, SWT.NONE);
		this.editingService = editingService;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
//		buildUI();
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof FunctionRelationship) {
			this.relationship = (FunctionRelationship) object;
		} else {
			return;
		}
		this.buildUI();
		this.initDataBindings_();
	}

	public boolean isValid() {
		return false;
	}

	protected void buildUI() {

		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		scnInfo = toolkit.createSection(this, Section.EXPANDED
				| Section.TITLE_BAR);
		FormData fd_scnInfo = new FormData();
		fd_scnInfo.left = new FormAttachment(0, 10);
		fd_scnInfo.top = new FormAttachment(0, 10);
		fd_scnInfo.right = new FormAttachment(100, -14);
		scnInfo.setLayoutData(fd_scnInfo);
		toolkit.paintBordersFor(scnInfo);
		scnInfo.setText("Info");

		Composite composite = toolkit.createComposite(scnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite);
		scnInfo.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblName = toolkit.createLabel(composite, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 80;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite, "New Text", SWT.NONE
				| widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);
		
		
		// Section Node links. 
		
		sctnNode = toolkit.createSection(this, Section.TITLE_BAR);
		fd_scnInfo.bottom = new FormAttachment(sctnNode, -6);
		FormData fd_sctnNode = new FormData();
		fd_sctnNode.top = new FormAttachment(0, 114);
		fd_sctnNode.left = new FormAttachment(0, 10);
		fd_sctnNode.right = new FormAttachment(100, -14);
		sctnNode.setLayoutData(fd_sctnNode);
		toolkit.paintBordersFor(sctnNode);
		sctnNode.setText("Node Link");
		sctnNode.setExpanded(true);

		Composite lblNode2 = toolkit.createComposite(sctnNode, SWT.NONE);
		toolkit.paintBordersFor(lblNode2);
		sctnNode.setClient(lblNode2);
		lblNode2.setLayout(new GridLayout(4, false));

		Label lblNode1 = toolkit.createLabel(lblNode2, "Node #1:",
				SWT.NONE);
		lblNode1.setAlignment(SWT.RIGHT);
		GridData gd_lblNode1 = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNode1.widthHint = 80;
		lblNode1.setLayoutData(gd_lblNode1);
		
		txtNode1 = toolkit.createText(lblNode2, "New Text", SWT.READ_ONLY);
		txtNode1.setText("");
		GridData gd_txtNode1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_txtNode1.widthHint = 150;
		txtNode1.setLayoutData(gd_txtNode1);

		ImageHyperlink hypLnkClearNode1 = toolkit
				.createImageHyperlink(lblNode2, SWT.NONE);
		GridData gd_hypLnkClearNode1 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_hypLnkClearNode1.widthHint = 18;
		hypLnkClearNode1.setLayoutData(gd_hypLnkClearNode1);
		hypLnkClearNode1.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Command set = new SetCommand(editingService.getEditingDomain(),
						relationship, OperatorsPackage.Literals.RELATIONSHIP__NODE_ID1_REF, null);
				editingService.getEditingDomain().getCommandStack()
						.execute(set);
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});

		hypLnkClearNode1.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(hypLnkClearNode1);
		hypLnkClearNode1.setText("");

		Button btnSelNode1 = toolkit.createButton(lblNode2, "Select...",
				SWT.NONE);
		btnSelNode1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node. 
				// We can link to any node. 
				Resource operatorResource = editingService
						.getData(OperatorsPackage.Literals.OPERATOR);
				NodeFilterDialog dialog = new NodeFilterDialog(NewEditFunctionLink.this
						.getShell(), operatorResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Node node1 = (Node) dialog.getFirstResult();
					relationship.setNodeID1Ref(node1);
				}
			}
		});
		
		Label lblNode = toolkit.createLabel(lblNode2, "Node #2:", SWT.NONE);
		lblNode.setAlignment(SWT.RIGHT);
		lblNode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtNode2 = toolkit.createText(lblNode2, "New Text", SWT.READ_ONLY);
		txtNode2.setText("");
		txtNode2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		ImageHyperlink hypLnkRemoveNode2 = toolkit.createImageHyperlink(lblNode2, SWT.NONE);
		hypLnkRemoveNode2.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Command set = new SetCommand(editingService.getEditingDomain(),
						relationship, OperatorsPackage.Literals.RELATIONSHIP__NODE_ID2_REF, null);
				editingService.getEditingDomain().getCommandStack()
						.execute(set);
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		GridData gd_imageHyperlink = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_imageHyperlink.widthHint = 18;
		hypLnkRemoveNode2.setLayoutData(gd_imageHyperlink);
		hypLnkRemoveNode2.setImage(ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(hypLnkRemoveNode2);
		hypLnkRemoveNode2.setText("");
		
		Button btnSelNode2 = toolkit.createButton(lblNode2, "Select...", SWT.NONE);
		btnSelNode2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node. 
				// We can link to any node. 
				Resource operatorResource = editingService
						.getData(OperatorsPackage.Literals.OPERATOR);
				NodeFilterDialog dialog = new NodeFilterDialog(NewEditFunctionLink.this
						.getShell(), operatorResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Node node2 = (Node) dialog.getFirstResult();
					relationship.setNodeID2Ref(node2);
				}
			}
		});
		Section sctnNewSection = toolkit.createSection(this, Section.EXPANDED | Section.TITLE_BAR);
		fd_sctnNode.bottom = new FormAttachment(sctnNewSection, -6);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.bottom = new FormAttachment(100, -10);
		fd_sctnNewSection.top = new FormAttachment(0, 229);
		fd_sctnNewSection.left = new FormAttachment(0, 10);
		fd_sctnNewSection.right = new FormAttachment(0, 440);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Function Link");
		
		Composite composite_1 = toolkit.createComposite(sctnNewSection, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnNewSection.setClient(composite_1);
		composite_1.setLayout(new GridLayout(4, false));
		
		Label lblFunction1 = toolkit.createLabel(composite_1, "Function #1", SWT.NONE);
		lblFunction1.setAlignment(SWT.RIGHT);
		GridData gd_lblFunction1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblFunction1.widthHint = 80;
		lblFunction1.setLayoutData(gd_lblFunction1);
		
		txtFunction1 = toolkit.createText(composite_1, "New Text", SWT.READ_ONLY);
		txtFunction1.setText("");
		GridData gd_txtFunction1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_txtFunction1.widthHint = 150;
		txtFunction1.setLayoutData(gd_txtFunction1);
		
		ImageHyperlink hypLnkFunction1 = toolkit.createImageHyperlink(composite_1, SWT.NONE);
		hypLnkFunction1.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// Set the ref to null.
				Command set = new SetCommand(editingService.getEditingDomain(),
						relationship, OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION1_REF, null);
				editingService.getEditingDomain().getCommandStack()
						.execute(set);
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		
		GridData gd_HypLnkFunction1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_HypLnkFunction1.widthHint = 18;
		hypLnkFunction1.setLayoutData(gd_HypLnkFunction1);
		hypLnkFunction1.setImage(ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(hypLnkFunction1);
		hypLnkFunction1.setText("");
		
		Button btnSelectFunction1 = toolkit.createButton(composite_1, "Select...", SWT.NONE);
		btnSelectFunction1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node->Nodetype->Function...... 
				Resource operatorResource = editingService
						.getData(OperatorsPackage.Literals.OPERATOR);
				FunctionFilterDialog dialog = new FunctionFilterDialog(NewEditFunctionLink.this
						.getShell(), operatorResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Function function1 = (Function) dialog.getFirstResult();
					relationship.setFunction1Ref(function1);
				}
			}
		});
		
		Label lblFunction2 = toolkit.createLabel(composite_1, "Function #2", SWT.NONE);
		lblFunction2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtFunction2 = toolkit.createText(composite_1, "New Text", SWT.READ_ONLY);
		txtFunction2.setText("");
		txtFunction2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		ImageHyperlink hypLnkFunction2 = toolkit.createImageHyperlink(composite_1, SWT.NONE);
		hypLnkFunction2.setImage(ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		GridData gd_HypLnkFunction2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_HypLnkFunction2.widthHint = 18;
		hypLnkFunction2.setLayoutData(gd_HypLnkFunction2);
		toolkit.paintBordersFor(hypLnkFunction2);
		hypLnkFunction2.setText("");
		hypLnkFunction2.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// Set the ref to null.
				Command set = new SetCommand(editingService.getEditingDomain(),
						relationship, OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION2_REF, null);
				editingService.getEditingDomain().getCommandStack()
						.execute(set);
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		
		Button btnSelectFunction2 = toolkit.createButton(composite_1, "Select...", SWT.NONE);
		btnSelectFunction2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node->Nodetype->Function...... 
				Resource operatorResource = editingService
						.getData(OperatorsPackage.Literals.OPERATOR);
				FunctionFilterDialog dialog = new FunctionFilterDialog(NewEditFunctionLink.this
						.getShell(), operatorResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Function function2 = (Function) dialog.getFirstResult();
					relationship.setFunction2Ref(function2);
				}
			}
		});
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		// Binding of name and node relationships

		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));


		IObservableValue node1Observable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtNode1, SWT.Modify));

		IObservableValue node2Observable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtNode2, SWT.Modify));

		
		IEMFValueProperty linkNameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.RELATIONSHIP__NAME);

		IEMFValueProperty linkNode1Property = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.RELATIONSHIP__NODE_ID1_REF,
						OperatorsPackage.Literals.NODE__NODE_ID));

		IEMFValueProperty linkNode2Property = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.RELATIONSHIP__NODE_ID2_REF,
						OperatorsPackage.Literals.NODE__NODE_ID));


		context.bindValue(nameObservable, linkNameProperty.observe(relationship), null,
				null);
		context.bindValue(node1Observable, linkNode1Property.observe(relationship),
				null, null);
		context.bindValue(node2Observable, linkNode2Property.observe(relationship), null,
				null);

		
		// Binding of sub relationships
		
		IObservableValue function1Observable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtFunction1, SWT.Modify));

		IObservableValue function2Observable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtFunction2, SWT.Modify));
		
		IEMFValueProperty linkFunction1Property = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION1_REF,
						LibraryPackage.Literals.COMPONENT__NAME));

		IEMFValueProperty linkFunction2Property = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION2_REF,
						LibraryPackage.Literals.COMPONENT__NAME));
		
		context.bindValue(function1Observable, linkFunction1Property.observe(relationship),
				null, null);
		context.bindValue(function2Observable, linkFunction2Property.observe(relationship), null,
				null);

		return context;
	}
}
