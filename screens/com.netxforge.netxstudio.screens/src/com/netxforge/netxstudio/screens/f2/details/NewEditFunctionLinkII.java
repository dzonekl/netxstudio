/*******************************************************************************
 * Copyright (c) 20 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.f2.details;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Relationship;
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.screens.AbstractDetailsScreen;
import com.netxforge.netxstudio.screens.dialog.FunctionFilterDialog;
import com.netxforge.netxstudio.screens.dialog.NodeFilterDialog;
import com.netxforge.netxstudio.screens.dialog.ProtocolFilterDialog;
import com.netxforge.screens.editing.base.IDataScreenInjection;
import com.netxforge.screens.editing.base.IEditingService;
import com.netxforge.screens.editing.base.ScreenUtil;

/**
 * 
 * @author Christophe Bouhier
 *
 */
public class NewEditFunctionLinkII extends AbstractDetailsScreen implements
		IDataScreenInjection {

	protected Relationship relationship;
	protected FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	protected IEditingService editingService;

	private ImageHyperlink hypLnkClearNode1;
	private Text txtNode2;
	private Text txtNode1;
	private Text txtProtocol;
	private ImageHyperlink hypLnkClearProtocol;

	private Text txtFunction1;
	private Text txtFunction2;
	private boolean readonly;
	private int widgetStyle;

	public NewEditFunctionLinkII(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof Relationship) {
			this.relationship = (Relationship) object;
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
		readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		buildInfoSection();
		buildProtocol();
		buildNodeLinkSection();
		// buildFunctionLinkSection();
	}

	public void buildNodeLinkSection() {
		// Section Node links.

		Section sctnNode = toolkit.createSection(this, Section.TITLE_BAR
				| Section.TWISTIE);
		toolkit.paintBordersFor(sctnNode);
		sctnNode.setText("Network Element Link");
		sctnNode.setExpanded(true);

		Composite cmpLinks = toolkit.createComposite(sctnNode, SWT.NONE);
		toolkit.paintBordersFor(cmpLinks);
		sctnNode.setClient(cmpLinks);
		cmpLinks.setLayout(new GridLayout(4, false));

		FormText formText = toolkit.createFormText(cmpLinks, false);
		GridData gd_formText = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				4, 1);
		gd_formText.widthHint = 322;
		formText.setLayoutData(gd_formText);
		toolkit.paintBordersFor(formText);
		formText.setText("<form><p><b>Left Connection:</b></p></form>", true,
				false);

		// NODE #1

		Label lblRoomsite = toolkit.createLabel(cmpLinks, "NE #1:", SWT.NONE);
		lblRoomsite.setAlignment(SWT.RIGHT);
		GridData gd_lblRoomsite = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblRoomsite.widthHint = 80;
		lblRoomsite.setLayoutData(gd_lblRoomsite);

		txtNode1 = toolkit.createText(cmpLinks, "New Text", SWT.READ_ONLY);
		txtNode1.setText("");
		GridData gd_txtNode1 = new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1);
		gd_txtNode1.widthHint = 150;
		txtNode1.setLayoutData(gd_txtNode1);

		if (!readonly) {

			hypLnkClearNode1 = toolkit.createImageHyperlink(cmpLinks, SWT.NONE);
			GridData gd_hypLnkClearNode1 = new GridData(SWT.LEFT, SWT.CENTER,
					false, false, 1, 1);
			gd_hypLnkClearNode1.widthHint = 18;
			hypLnkClearNode1.setLayoutData(gd_hypLnkClearNode1);
			hypLnkClearNode1.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {

					CompoundCommand cc = new CompoundCommand();
					// Potentially also remove the child ref.
					Command set = new SetCommand(
							editingService.getEditingDomain(),
							relationship,
							OperatorsPackage.Literals.RELATIONSHIP__NODE_ID1_REF,
							null);
					cc.append(set);

					if (relationship instanceof EquipmentRelationship) {
						EquipmentRelationship eqRelationship = (EquipmentRelationship) relationship;
						if (eqRelationship
								.eIsSet(OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF)) {
							Command setChild = new SetCommand(
									editingService.getEditingDomain(),
									eqRelationship,
									OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF,
									null);
							cc.append(setChild);
						}
					}
					if (relationship instanceof FunctionRelationship) {
						FunctionRelationship fcRelationship = (FunctionRelationship) relationship;
						if (fcRelationship
								.eIsSet(OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION1_REF)) {
							Command setChild = new SetCommand(
									editingService.getEditingDomain(),
									fcRelationship,
									OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION1_REF,
									null);
							cc.append(setChild);
						}
					}

					editingService.getEditingDomain().getCommandStack()
							.execute(cc);
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

			Button btnSelNode1 = toolkit.createButton(cmpLinks, "Select...",
					SWT.NONE);
			btnSelNode1.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					// Operator->Network->Node.
					// We can link to any node.
					Resource operatorResource = editingService
							.getData(OperatorsPackage.Literals.OPERATOR);
					NodeFilterDialog dialog = new NodeFilterDialog(
							NewEditFunctionLinkII.this.getShell(),
							operatorResource);
					if (dialog.open() == IDialogConstants.OK_ID) {
						Node node1 = (Node) dialog.getFirstResult();

						relationship.setNodeID1Ref(node1);
					}
				}
			});
		}

		// FUNCTION #1

		Label lblFunction1 = toolkit.createLabel(cmpLinks, "Function #1",
				SWT.NONE);
		lblFunction1.setAlignment(SWT.RIGHT);
		GridData gd_lblFunction1 = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFunction1.widthHint = 80;
		lblFunction1.setLayoutData(gd_lblFunction1);

		txtFunction1 = toolkit.createText(cmpLinks, "New Text", SWT.READ_ONLY);
		txtFunction1.setText("");
		GridData gd_txtFunction1 = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFunction1.widthHint = 150;
		txtFunction1.setLayoutData(gd_txtFunction1);

		if (!readonly) {
			ImageHyperlink hypLnkFunction1 = toolkit.createImageHyperlink(
					cmpLinks, SWT.NONE);
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

			GridData gd_HypLnkFunction1 = new GridData(SWT.LEFT, SWT.CENTER,
					false, false, 1, 1);
			gd_HypLnkFunction1.widthHint = 18;
			hypLnkFunction1.setLayoutData(gd_HypLnkFunction1);
			hypLnkFunction1.setImage(ResourceManager.getPluginImage(
					"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
			toolkit.paintBordersFor(hypLnkFunction1);
			hypLnkFunction1.setText("");

			Button btnSelectFunction1 = toolkit.createButton(cmpLinks,
					"Select...", SWT.NONE);
			btnSelectFunction1.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {

					// Operator->Network->Node->Nodetype->Function......
					// Resource operatorResource = editingService
					// .getData(OperatorsPackage.Literals.OPERATOR);

					if (relationship.getNodeID1Ref() != null) {
						FunctionFilterDialog dialog = new FunctionFilterDialog(
								NewEditFunctionLinkII.this.getShell(),
								relationship.getNodeID1Ref());
						if (dialog.open() == IDialogConstants.OK_ID) {
							Function function1 = (Function) dialog
									.getFirstResult();

							CompoundCommand cc = new CompoundCommand();

							{
								Command set = new SetCommand(
										editingService.getEditingDomain(),
										relationship,
										OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION1_REF,
										function1);

								cc.append(set);
							}

							{
								Command set = new AddCommand(editingService
										.getEditingDomain(), function1
										.getFunctionRelationshipRefs(),
										relationship);

								cc.append(set);
							}

							editingService.getEditingDomain().getCommandStack()
									.execute(cc);

						}
					} else {

					}
				}
			});
		}

		// NODE #2

		// Separator.
		Composite composite = toolkit.createComposite(cmpLinks, SWT.NONE);
		GridData gd_composite = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 4, 1);
		gd_composite.heightHint = 20;
		gd_composite.widthHint = 333;
		composite.setLayoutData(gd_composite);
		toolkit.paintBordersFor(composite);

		FormText formText_1 = toolkit.createFormText(cmpLinks, false);
		GridData gd_formText_1 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 4, 1);
		gd_formText_1.widthHint = 327;
		formText_1.setLayoutData(gd_formText_1);
		toolkit.paintBordersFor(formText_1);
		formText_1.setText("<form><p><b>Right Connection:</b></p></form>",
				true, false);

		Label lblNode = toolkit.createLabel(cmpLinks, "NE #2:", SWT.NONE);
		lblNode.setAlignment(SWT.RIGHT);
		lblNode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));

		txtNode2 = toolkit.createText(cmpLinks, "New Text", SWT.READ_ONLY);
		txtNode2.setText("");
		txtNode2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));

		if (!readonly) {
			ImageHyperlink hypLnkRemoveNode2 = toolkit.createImageHyperlink(
					cmpLinks, SWT.NONE);
			hypLnkRemoveNode2.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					CompoundCommand cc = new CompoundCommand();
					// Potentially also remove the child ref.
					Command set = new SetCommand(
							editingService.getEditingDomain(),
							relationship,
							OperatorsPackage.Literals.RELATIONSHIP__NODE_ID2_REF,
							null);
					cc.append(set);

					if (relationship instanceof EquipmentRelationship) {
						EquipmentRelationship eqRelationship = (EquipmentRelationship) relationship;
						if (eqRelationship
								.eIsSet(OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF)) {
							Command setChild = new SetCommand(
									editingService.getEditingDomain(),
									eqRelationship,
									OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF,
									null);
							cc.append(setChild);
						}
					}
					if (relationship instanceof FunctionRelationship) {
						FunctionRelationship fcRelationship = (FunctionRelationship) relationship;
						if (fcRelationship
								.eIsSet(OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION2_REF)) {
							Command setChild = new SetCommand(
									editingService.getEditingDomain(),
									fcRelationship,
									OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION2_REF,
									null);
							cc.append(setChild);
						}
					}

					editingService.getEditingDomain().getCommandStack()
							.execute(cc);
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});
			GridData gd_imageHyperlink = new GridData(SWT.LEFT, SWT.CENTER,
					false, false, 1, 1);
			gd_imageHyperlink.widthHint = 18;
			hypLnkRemoveNode2.setLayoutData(gd_imageHyperlink);
			hypLnkRemoveNode2.setImage(ResourceManager.getPluginImage(
					"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
			toolkit.paintBordersFor(hypLnkRemoveNode2);
			hypLnkRemoveNode2.setText("");

			Button btnSelNode2 = toolkit.createButton(cmpLinks, "Select...",
					SWT.NONE);
			btnSelNode2.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					// Operator->Network->Node.
					// We can link to any node.
					Resource operatorResource = editingService
							.getData(OperatorsPackage.Literals.OPERATOR);
					NodeFilterDialog dialog = new NodeFilterDialog(
							NewEditFunctionLinkII.this.getShell(),
							operatorResource);
					if (dialog.open() == IDialogConstants.OK_ID) {
						Node node2 = (Node) dialog.getFirstResult();
						relationship.setNodeID2Ref(node2);
					}
				}
			});
		}
		// FUNCTION #2.

		Label lblFunction2 = toolkit.createLabel(cmpLinks, "Function #2",
				SWT.NONE);
		lblFunction2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtFunction2 = toolkit.createText(cmpLinks, "New Text", SWT.READ_ONLY);
		txtFunction2.setText("");
		txtFunction2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		if (!readonly) {
			ImageHyperlink hypLnkFunction2 = toolkit.createImageHyperlink(
					cmpLinks, SWT.NONE);
			hypLnkFunction2.setImage(ResourceManager.getPluginImage(
					"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
			GridData gd_HypLnkFunction2 = new GridData(SWT.LEFT, SWT.CENTER,
					false, false, 1, 1);
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

			Button btnSelectFunction2 = toolkit.createButton(cmpLinks,
					"Select...", SWT.NONE);
			btnSelectFunction2.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					// Operator->Network->Node->Nodetype->Function......
					// Resource operatorResource = editingService
					// .getData(OperatorsPackage.Literals.OPERATOR);

					if (relationship.getNodeID2Ref() != null) {

						FunctionFilterDialog dialog = new FunctionFilterDialog(
								NewEditFunctionLinkII.this.getShell(),
								relationship.getNodeID2Ref());
						if (dialog.open() == IDialogConstants.OK_ID) {
							Function function2 = (Function) dialog
									.getFirstResult();
							CompoundCommand cc = new CompoundCommand();

							{
								Command set = new SetCommand(
										editingService.getEditingDomain(),
										relationship,
										OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION2_REF,
										function2);

								cc.append(set);
							}

							{
								Command set = new SetCommand(
										editingService.getEditingDomain(),
										function2,
										LibraryPackage.Literals.FUNCTION__FUNCTION_RELATIONSHIP_REFS,
										relationship);

								cc.append(set);
							}

							editingService.getEditingDomain().getCommandStack()
									.execute(cc);
						}
					}
				}
			});
		}
	}

	@SuppressWarnings("unused")
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

		// FUNCTION #1
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

		if (!readonly) {
			ImageHyperlink hypLnkRemove = toolkit.createImageHyperlink(
					composite_1, SWT.NONE);
			hypLnkRemove.addHyperlinkListener(new IHyperlinkListener() {
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

			GridData gd_HypLnkFunction1 = new GridData(SWT.LEFT, SWT.CENTER,
					false, false, 1, 1);
			gd_HypLnkFunction1.widthHint = 18;
			hypLnkRemove.setLayoutData(gd_HypLnkFunction1);
			hypLnkRemove.setImage(ResourceManager.getPluginImage(
					"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
			toolkit.paintBordersFor(hypLnkRemove);
			hypLnkRemove.setText("");

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
								NewEditFunctionLinkII.this.getShell(),
								relationship.getNodeID1Ref());
						if (dialog.open() == IDialogConstants.OK_ID) {
							Function function1 = (Function) dialog
									.getFirstResult();

							CompoundCommand cc = new CompoundCommand();

							{
								Command set = new SetCommand(
										editingService.getEditingDomain(),
										relationship,
										OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION1_REF,
										function1);

								cc.append(set);
							}

							{
								Command set = new SetCommand(
										editingService.getEditingDomain(),
										function1,
										LibraryPackage.Literals.FUNCTION__FUNCTION_RELATIONSHIP_REFS,
										relationship);

								cc.append(set);
							}

							editingService.getEditingDomain().getCommandStack()
									.execute(cc);
						}
					} else {

					}
				}
			});
		}
		Label lblFunction2 = toolkit.createLabel(composite_1, "Function #2",
				SWT.NONE);
		lblFunction2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtFunction2 = toolkit.createText(composite_1, "New Text",
				SWT.READ_ONLY);
		txtFunction2.setText("");
		txtFunction2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		if (!readonly) {
			ImageHyperlink hypLnkFunction2 = toolkit.createImageHyperlink(
					composite_1, SWT.NONE);
			hypLnkFunction2.setImage(ResourceManager.getPluginImage(
					"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
			GridData gd_HypLnkFunction2 = new GridData(SWT.LEFT, SWT.CENTER,
					false, false, 1, 1);
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
								NewEditFunctionLinkII.this.getShell(),
								relationship.getNodeID2Ref());
						if (dialog.open() == IDialogConstants.OK_ID) {
							Function function2 = (Function) dialog
									.getFirstResult();

							CompoundCommand cc = new CompoundCommand();

							{
								Command set = new SetCommand(
										editingService.getEditingDomain(),
										relationship,
										OperatorsPackage.Literals.FUNCTION_RELATIONSHIP__FUNCTION2_REF,
										function2);

								cc.append(set);
							}

							{
								Command set = new SetCommand(
										editingService.getEditingDomain(),
										function2,
										LibraryPackage.Literals.FUNCTION__FUNCTION_RELATIONSHIP_REFS,
										relationship);

								cc.append(set);
							}

							editingService.getEditingDomain().getCommandStack()
									.execute(cc);
							//
							//
							// ((FunctionRelationship) relationship)
							// .setFunction2Ref(function2);

						}
					}
				}
			});
		}
	}

	public void buildProtocol() {
		// Section Node links.

		Section sctnProtocol = toolkit.createSection(this, Section.TITLE_BAR
				| Section.TWISTIE);
		toolkit.paintBordersFor(sctnProtocol);
		sctnProtocol.setText("Protocol");
		sctnProtocol.setExpanded(true);

		Composite cmpProtocol = toolkit.createComposite(sctnProtocol, SWT.NONE);
		toolkit.paintBordersFor(cmpProtocol);
		sctnProtocol.setClient(cmpProtocol);
		cmpProtocol.setLayout(new GridLayout(4, false));

		Label lblRoomsite = toolkit.createLabel(cmpProtocol, "Protocol:",
				SWT.NONE);
		lblRoomsite.setAlignment(SWT.RIGHT);
		GridData gd_lblRoomsite = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblRoomsite.widthHint = 80;
		lblRoomsite.setLayoutData(gd_lblRoomsite);

		txtProtocol = toolkit.createText(cmpProtocol, "New Text", SWT.NONE
				| widgetStyle);
		txtProtocol.setText("");
		GridData gd_txtNode1 = new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1);
		gd_txtNode1.widthHint = 150;
		txtProtocol.setLayoutData(gd_txtNode1);

		if (!readonly) {
			hypLnkClearProtocol = toolkit.createImageHyperlink(cmpProtocol,
					SWT.NONE);
			GridData gd_hypLnkClearNode1 = new GridData(SWT.LEFT, SWT.CENTER,
					false, false, 1, 1);
			gd_hypLnkClearNode1.widthHint = 18;
			hypLnkClearProtocol.setLayoutData(gd_hypLnkClearNode1);
			hypLnkClearProtocol.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					Command set = new SetCommand(
							editingService.getEditingDomain(),
							relationship,
							OperatorsPackage.Literals.RELATIONSHIP__PROTOCOL_REF,
							null);
					editingService.getEditingDomain().getCommandStack()
							.execute(set);
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});

			hypLnkClearProtocol.setImage(ResourceManager.getPluginImage(
					"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
			toolkit.paintBordersFor(hypLnkClearProtocol);
			hypLnkClearProtocol.setText("");

			Button btnSelProtocol = toolkit.createButton(cmpProtocol,
					"Select...", SWT.NONE);
			btnSelProtocol.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					// Operator->Network->Node.
					// We can link to any node.
					Resource operatorResource = editingService
							.getData(ProtocolsPackage.Literals.PROTOCOL);
					ProtocolFilterDialog dialog = new ProtocolFilterDialog(
							NewEditFunctionLinkII.this.getShell(),
							operatorResource);
					if (dialog.open() == IDialogConstants.OK_ID) {
						Protocol protocol = (Protocol) dialog.getFirstResult();
						SetCommand sc = new SetCommand(
								editingService.getEditingDomain(),
								relationship,
								OperatorsPackage.Literals.RELATIONSHIP__PROTOCOL_REF,
								protocol);
						editingService.getEditingDomain().getCommandStack()
								.execute(sc);
					}
				}
			});
		}

	}

	public void buildInfoSection() {
		Section scnInfo = toolkit.createSection(this, Section.EXPANDED
				| Section.TITLE_BAR);
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
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		bindInfoSection(context);
		bindNodeLinkSection(context);
		bindProtocolSection(context);
		bindFunctionLinkSection(context);
		return context;
	}

	public void bindNodeLinkSection(EMFDataBindingContext context) {

		IObservableValue node1Observable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtNode1, SWT.Modify));

		IObservableValue node2Observable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtNode2, SWT.Modify));

		IEMFValueProperty linkNode1Property = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.RELATIONSHIP__NODE_ID1_REF,
						OperatorsPackage.Literals.NODE__NODE_ID));

		IEMFValueProperty linkNode2Property = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.RELATIONSHIP__NODE_ID2_REF,
						OperatorsPackage.Literals.NODE__NODE_ID));

		context.bindValue(node1Observable,
				linkNode1Property.observe(relationship), null, null);
		context.bindValue(node2Observable,
				linkNode2Property.observe(relationship), null, null);
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

	public void bindInfoSection(EMFDataBindingContext context) {
		// Binding of name and Description

		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));

		IEMFValueProperty linkNameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.RELATIONSHIP__NAME);

		context.bindValue(nameObservable,
				linkNameProperty.observe(relationship), null, null);
	}

	public void bindProtocolSection(EMFDataBindingContext context) {

		IObservableValue protocolObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtProtocol, SWT.Modify));

		IEMFValueProperty protocolProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.RELATIONSHIP__PROTOCOL_REF,
						ProtocolsPackage.Literals.PROTOCOL__NAME));

		context.bindValue(protocolObservable,
				protocolProperty.observe(relationship), null, null);
	}
}
