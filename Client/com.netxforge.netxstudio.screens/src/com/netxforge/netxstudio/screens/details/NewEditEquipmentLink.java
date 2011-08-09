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

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.EquipmentFilterDialog;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class NewEditEquipmentLink extends NewEditLink implements IScreen {

	private Text txtEquipment1;
	private Text txtEquipment2;

	public NewEditEquipmentLink(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, SWT.NONE, editingService);
		this.editingService = editingService;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}

	public boolean isValid() {
		return false;
	}

	protected void buildUI() {

		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		super.buildInfoSection(widgetStyle);
		super.buildNodeLinkSection(widgetStyle);
		buildEquipmentLinkSection();
	}

	private void buildEquipmentLinkSection() {
		Section sctnNewSection = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Equipment Link");

		Composite composite_1 = toolkit.createComposite(sctnNewSection,
				SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnNewSection.setClient(composite_1);
		composite_1.setLayout(new GridLayout(4, false));

		Label lblEquipment1 = toolkit.createLabel(composite_1, "Equipment #1",
				SWT.NONE);
		lblEquipment1.setAlignment(SWT.RIGHT);
		GridData gd_lblEquipment1 = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblEquipment1.widthHint = 80;
		lblEquipment1.setLayoutData(gd_lblEquipment1);

		txtEquipment1 = toolkit.createText(composite_1, "New Text",
				SWT.READ_ONLY);
		txtEquipment1.setText("");
		GridData gd_txtEquipment1 = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtEquipment1.widthHint = 150;
		txtEquipment1.setLayoutData(gd_txtEquipment1);

		ImageHyperlink hypLnkEquipment1 = toolkit.createImageHyperlink(
				composite_1, SWT.NONE);
		hypLnkEquipment1.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// Set the ref to null.
				Command set = new SetCommand(
						editingService.getEditingDomain(),
						relationship,
						OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF,
						null);
				editingService.getEditingDomain().getCommandStack()
						.execute(set);
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});

		GridData gd_HypLnkEquipment1 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_HypLnkEquipment1.widthHint = 18;
		hypLnkEquipment1.setLayoutData(gd_HypLnkEquipment1);
		hypLnkEquipment1.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(hypLnkEquipment1);
		hypLnkEquipment1.setText("");

		Button btnSelectEquipment1 = toolkit.createButton(composite_1,
				"Select...", SWT.NONE);
		btnSelectEquipment1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node->Nodetype->Function......
				if (relationship.getNodeID1Ref() != null) {
					EquipmentFilterDialog dialog = new EquipmentFilterDialog(
							NewEditEquipmentLink.this.getShell(),
							relationship.getNodeID1Ref());
					if (dialog.open() == IDialogConstants.OK_ID) {
						Equipment Equipment1 = (Equipment) dialog
								.getFirstResult();
						((EquipmentRelationship) relationship)
								.setEquipment1Ref(Equipment1);
					}
				}
			}
		});

		Label lblEquipment2 = toolkit.createLabel(composite_1, "Equipment #2",
				SWT.NONE);
		lblEquipment2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtEquipment2 = toolkit.createText(composite_1, "New Text",
				SWT.READ_ONLY);
		txtEquipment2.setText("");
		txtEquipment2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		ImageHyperlink hypLnkEquipment2 = toolkit.createImageHyperlink(
				composite_1, SWT.NONE);
		hypLnkEquipment2.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		GridData gd_HypLnkEquipment2 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_HypLnkEquipment2.widthHint = 18;
		hypLnkEquipment2.setLayoutData(gd_HypLnkEquipment2);
		toolkit.paintBordersFor(hypLnkEquipment2);
		hypLnkEquipment2.setText("");
		hypLnkEquipment2.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// Set the ref to null.
				Command set = new SetCommand(
						editingService.getEditingDomain(),
						relationship,
						OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF,
						null);
				editingService.getEditingDomain().getCommandStack()
						.execute(set);
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});

		Button btnSelectEquipment2 = toolkit.createButton(composite_1,
				"Select...", SWT.NONE);
		btnSelectEquipment2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node->Nodetype->Function......
				
				if(relationship.getNodeID2Ref() != null){
				EquipmentFilterDialog dialog = new EquipmentFilterDialog(
						NewEditEquipmentLink.this.getShell(), relationship.getNodeID2Ref());
				if (dialog.open() == IDialogConstants.OK_ID) {
					Equipment Equipment2 = (Equipment) dialog.getFirstResult();
					((EquipmentRelationship) relationship)
								.setEquipment2Ref(Equipment2);
					}
				}
			}
		});
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = super.initDataBindings_();
		super.bindInfoSection(context);
		super.bindNodeLinkSection(context);
		bindEquipmentLinkSection(context);

		return context;
	}

	private void bindEquipmentLinkSection(EMFDataBindingContext context) {
		// Binding of sub relationships

		IObservableValue Equipment1Observable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtEquipment1, SWT.Modify));

		IObservableValue Equipment2Observable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtEquipment2, SWT.Modify));

		IEMFValueProperty linkEquipment1Property = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF,
										LibraryPackage.Literals.COMPONENT__NAME));

		IEMFValueProperty linkEquipment2Property = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF,
										LibraryPackage.Literals.COMPONENT__NAME));

		context.bindValue(Equipment1Observable,
				linkEquipment1Property.observe(relationship), null, null);
		context.bindValue(Equipment2Observable,
				linkEquipment2Property.observe(relationship), null, null);
	}
}
