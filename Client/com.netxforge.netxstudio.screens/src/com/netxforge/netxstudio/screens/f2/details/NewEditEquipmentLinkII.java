package com.netxforge.netxstudio.screens.f2.details;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
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

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Relationship;
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.screens.AbstractDetailsScreen;
import com.netxforge.netxstudio.screens.dialog.EquipmentFilterDialog;
import com.netxforge.netxstudio.screens.dialog.NodeFilterDialog;
import com.netxforge.netxstudio.screens.dialog.ProtocolFilterDialog;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

public class NewEditEquipmentLinkII extends AbstractDetailsScreen implements
		IScreen, IDataScreenInjection {

	protected Relationship relationship;
	protected FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	protected IEditingService editingService;

	private ImageHyperlink hypLnkClearNode1;
	private Text txtNode2;
	private Text txtNode1;
	private Text txtProtocol;
	private ImageHyperlink hypLnkClearProtocol;

	private Text txtEquipment1;
	private Text txtEquipment2;

	public NewEditEquipmentLinkII(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
//		buildUI();
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
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		buildInfoSection(widgetStyle);
		buildProtocol(widgetStyle);
		buildNodeLinkSection(widgetStyle);
//		buildEquipmentLinkSection();
	}

	public void buildNodeLinkSection(int widgetStyle) {
		// Section Node links.

		final Section sctnNode = toolkit.createSection(this, Section.TITLE_BAR
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

		// NODE1.

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

		hypLnkClearNode1 = toolkit.createImageHyperlink(cmpLinks, SWT.NONE);
		GridData gd_hypLnkClearNode1 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_hypLnkClearNode1.widthHint = 18;
		hypLnkClearNode1.setLayoutData(gd_hypLnkClearNode1);
		hypLnkClearNode1.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {

				CompoundCommand cc = new CompoundCommand();
				// Potentially also remove the child ref.
				Command set = new SetCommand(editingService.getEditingDomain(),
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

				editingService.getEditingDomain().getCommandStack().execute(cc);
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
						NewEditEquipmentLinkII.this.getShell(),
						operatorResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Node node1 = (Node) dialog.getFirstResult();
					relationship.setNodeID1Ref(node1);
				}
			}
		});
		
		// EQUIPMENT1.

		Label lblEquipment1 = toolkit.createLabel(cmpLinks, "Equipment #1",
				SWT.NONE);
		lblEquipment1.setAlignment(SWT.RIGHT);
		GridData gd_lblEquipment1 = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblEquipment1.widthHint = 80;
		lblEquipment1.setLayoutData(gd_lblEquipment1);

		txtEquipment1 = toolkit.createText(cmpLinks, "New Text", SWT.READ_ONLY);
		txtEquipment1.setText("");
		GridData gd_txtEquipment1 = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtEquipment1.widthHint = 150;
		txtEquipment1.setLayoutData(gd_txtEquipment1);

		ImageHyperlink hypLnkEquipment1 = toolkit.createImageHyperlink(
				cmpLinks, SWT.NONE);
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

		Button btnSelectEquipment1 = toolkit.createButton(cmpLinks,
				"Select...", SWT.NONE);
		btnSelectEquipment1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node->Nodetype->Function......
				if (relationship.getNodeID1Ref() != null) {
					EquipmentFilterDialog dialog = new EquipmentFilterDialog(
							NewEditEquipmentLinkII.this.getShell(),
							relationship.getNodeID1Ref());
					if (dialog.open() == IDialogConstants.OK_ID) {
						Equipment Equipment1 = (Equipment) dialog
								.getFirstResult();

						Command set = new SetCommand(
								editingService.getEditingDomain(),
								relationship,
								OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF,
								Equipment1);
						editingService.getEditingDomain().getCommandStack()
								.execute(set);

					}
				}
			}
		});
		
		// NODE2.
		
		
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

		ImageHyperlink hypLnkRemoveNode2 = toolkit.createImageHyperlink(
				cmpLinks, SWT.NONE);
		hypLnkRemoveNode2.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				CompoundCommand cc = new CompoundCommand();
				// Potentially also remove the child ref.
				Command set = new SetCommand(editingService.getEditingDomain(),
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

				editingService.getEditingDomain().getCommandStack().execute(cc);
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		GridData gd_imageHyperlink = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
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
						NewEditEquipmentLinkII.this.getShell(),
						operatorResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Node node2 = (Node) dialog.getFirstResult();
					relationship.setNodeID2Ref(node2);
				}
			}
		});

		// EQUIPMENT 2.

		Label lblEquipment2 = toolkit.createLabel(cmpLinks, "Equipment #2",
				SWT.NONE);
		lblEquipment2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtEquipment2 = toolkit.createText(cmpLinks, "New Text", SWT.READ_ONLY);
		txtEquipment2.setText("");
		txtEquipment2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		ImageHyperlink hypLnkEquipment2 = toolkit.createImageHyperlink(
				cmpLinks, SWT.NONE);
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

		Button btnSelectEquipment2 = toolkit.createButton(cmpLinks,
				"Select...", SWT.NONE);
		btnSelectEquipment2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node->Nodetype->Function......

				if (relationship.getNodeID2Ref() != null) {
					EquipmentFilterDialog dialog = new EquipmentFilterDialog(
							NewEditEquipmentLinkII.this.getShell(),
							relationship.getNodeID2Ref());
					if (dialog.open() == IDialogConstants.OK_ID) {
						Equipment Equipment2 = (Equipment) dialog
								.getFirstResult();
						Command set = new SetCommand(
								editingService.getEditingDomain(),
								relationship,
								OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF,
								Equipment2);
						editingService.getEditingDomain().getCommandStack()
								.execute(set);
					}
				}
			}
		});
	}

	@SuppressWarnings("unused")
	private void buildEquipmentLinkSection() {
		Section sctnNewSection = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Equipment Link");
		sctnNewSection.setExpanded(true);

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
							NewEditEquipmentLinkII.this.getShell(),
							relationship.getNodeID1Ref());
					if (dialog.open() == IDialogConstants.OK_ID) {
						Equipment Equipment1 = (Equipment) dialog
								.getFirstResult();

						Command set = new SetCommand(
								editingService.getEditingDomain(),
								relationship,
								OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF,
								Equipment1);
						editingService.getEditingDomain().getCommandStack()
								.execute(set);

					}
				}
			}
		});

		// EQUIPMENT 2.

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

				if (relationship.getNodeID2Ref() != null) {
					EquipmentFilterDialog dialog = new EquipmentFilterDialog(
							NewEditEquipmentLinkII.this.getShell(),
							relationship.getNodeID2Ref());
					if (dialog.open() == IDialogConstants.OK_ID) {
						Equipment Equipment2 = (Equipment) dialog
								.getFirstResult();
						Command set = new SetCommand(
								editingService.getEditingDomain(),
								relationship,
								OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF,
								Equipment2);
						editingService.getEditingDomain().getCommandStack()
								.execute(set);
					}
				}
			}
		});
	}

	public void buildProtocol(int widgetStyle) {
		// Section Node links.

		Section sctnNode = toolkit.createSection(this, Section.TITLE_BAR
				| Section.TWISTIE);
		toolkit.paintBordersFor(sctnNode);
		sctnNode.setText("Protocol");
		sctnNode.setExpanded(true);

		Composite cmpProtocol = toolkit.createComposite(sctnNode, SWT.NONE);
		toolkit.paintBordersFor(cmpProtocol);
		sctnNode.setClient(cmpProtocol);
		cmpProtocol.setLayout(new GridLayout(4, false));

		Label lblRoomsite = toolkit.createLabel(cmpProtocol, "Protocol:",
				SWT.NONE);
		lblRoomsite.setAlignment(SWT.RIGHT);
		GridData gd_lblRoomsite = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblRoomsite.widthHint = 80;
		lblRoomsite.setLayoutData(gd_lblRoomsite);

		txtProtocol = toolkit.createText(cmpProtocol, "New Text", SWT.NONE);
		txtProtocol.setText("");
		GridData gd_txtNode1 = new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1);
		gd_txtNode1.widthHint = 150;
		txtProtocol.setLayoutData(gd_txtNode1);

		hypLnkClearProtocol = toolkit.createImageHyperlink(cmpProtocol,
				SWT.NONE);
		GridData gd_hypLnkClearNode1 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_hypLnkClearNode1.widthHint = 18;
		hypLnkClearProtocol.setLayoutData(gd_hypLnkClearNode1);
		hypLnkClearProtocol.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Command set = new SetCommand(editingService.getEditingDomain(),
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

		Button btnSelProtocol = toolkit.createButton(cmpProtocol, "Select...",
				SWT.NONE);
		btnSelProtocol.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node.
				// We can link to any node.
				Resource operatorResource = editingService
						.getData(ProtocolsPackage.Literals.PROTOCOL);
				ProtocolFilterDialog dialog = new ProtocolFilterDialog(
						NewEditEquipmentLinkII.this.getShell(),
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

	public void buildInfoSection(int widgetStyle) {
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
		bindProtocolSection(context);
		bindNodeLinkSection(context);
		bindEquipmentLinkSection(context);
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

	private void bindEquipmentLinkSection(EMFDataBindingContext context) {
		// Binding of sub relationships

		IObservableValue Equipment1Observable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtEquipment1, SWT.Modify));

		IObservableValue Equipment2Observable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtEquipment2, SWT.Modify));

		// combineEquipmentIDValue = new WritableValue();

		IEMFValueProperty linkEquipment1Property = EMFEditProperties
				.value(editingService.getEditingDomain(),
						OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF);

		IEMFValueProperty linkEquipment2Property = EMFEditProperties
				.value(editingService.getEditingDomain(),
						OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF);

		EMFUpdateValueStrategy equipmentToTarget = new EMFUpdateValueStrategy();
		equipmentToTarget.setConverter(new IConverter() {

			public Object getFromType() {
				return Equipment.class;
			}

			public Object getToType() {
				return String.class;
			}

			public Object convert(Object fromObject) {

				if (fromObject instanceof Equipment) {
					StringBuffer buf = new StringBuffer();
					if (((Equipment) fromObject)
							.eIsSet(LibraryPackage.Literals.COMPONENT__NAME)) {
						buf.append(((Equipment) fromObject).getName());
					}
					buf.append(" -  ");
					if (((Equipment) fromObject)
							.eIsSet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_CODE)) {
						buf.append(((Equipment) fromObject).getEquipmentCode());
					}
					return buf.toString();
				}
				return null;
			}

		});

		context.bindValue(Equipment1Observable,
				linkEquipment1Property.observe(relationship), null,
				equipmentToTarget);
		context.bindValue(Equipment2Observable,
				linkEquipment2Property.observe(relationship), null,
				equipmentToTarget);
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
