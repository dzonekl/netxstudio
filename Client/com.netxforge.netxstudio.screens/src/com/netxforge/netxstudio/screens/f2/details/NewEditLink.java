package com.netxforge.netxstudio.screens.f2.details;

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

import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Relationship;
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.screens.NodeFilterDialog;
import com.netxforge.netxstudio.screens.ProtocolFilterDialog;
import com.netxforge.netxstudio.screens.details.AbstractDetailsScreen;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class NewEditLink extends AbstractDetailsScreen implements IScreen,
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

	public NewEditLink(Composite parent, int style,
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
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		buildInfoSection(widgetStyle);
		buildNodeLinkSection(widgetStyle);
		buildProtocol(widgetStyle);
	}

	public void buildNodeLinkSection(int widgetStyle) {
		// Section Node links.

		Section sctnNode = toolkit.createSection(this, Section.TITLE_BAR
				| Section.TWISTIE);
		toolkit.paintBordersFor(sctnNode);
		sctnNode.setText("Node Link");

		Composite cmpTolerances = toolkit.createComposite(sctnNode, SWT.NONE);
		toolkit.paintBordersFor(cmpTolerances);
		sctnNode.setClient(cmpTolerances);
		cmpTolerances.setLayout(new GridLayout(4, false));

		Label lblRoomsite = toolkit.createLabel(cmpTolerances, "Node #1:",
				SWT.NONE);
		lblRoomsite.setAlignment(SWT.RIGHT);
		GridData gd_lblRoomsite = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblRoomsite.widthHint = 80;
		lblRoomsite.setLayoutData(gd_lblRoomsite);

		txtNode1 = toolkit.createText(cmpTolerances, "New Text", SWT.NONE);
		txtNode1.setText("");
		GridData gd_txtNode1 = new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1);
		gd_txtNode1.widthHint = 150;
		txtNode1.setLayoutData(gd_txtNode1);

		hypLnkClearNode1 = toolkit
				.createImageHyperlink(cmpTolerances, SWT.NONE);
		GridData gd_hypLnkClearNode1 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_hypLnkClearNode1.widthHint = 18;
		hypLnkClearNode1.setLayoutData(gd_hypLnkClearNode1);
		hypLnkClearNode1.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Command set = new SetCommand(editingService.getEditingDomain(),
						relationship,
						OperatorsPackage.Literals.RELATIONSHIP__NODE_ID1_REF,
						null);
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

		Button btnSelNode1 = toolkit.createButton(cmpTolerances, "Select...",
				SWT.NONE);
		btnSelNode1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node.
				// We can link to any node.
				Resource operatorResource = editingService
						.getData(OperatorsPackage.Literals.OPERATOR);
				NodeFilterDialog dialog = new NodeFilterDialog(NewEditLink.this
						.getShell(), operatorResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Node node1 = (Node) dialog.getFirstResult();
					relationship.setNodeID1Ref(node1);
				}
			}
		});

		Label lblNode = toolkit
				.createLabel(cmpTolerances, "Node #2:", SWT.NONE);
		lblNode.setAlignment(SWT.RIGHT);
		lblNode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));

		txtNode2 = toolkit.createText(cmpTolerances, "New Text", SWT.NONE);
		txtNode2.setText("");
		txtNode2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));

		ImageHyperlink hypLnkRemoveNode2 = toolkit.createImageHyperlink(
				cmpTolerances, SWT.NONE);
		hypLnkRemoveNode2.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Command set = new SetCommand(editingService.getEditingDomain(),
						relationship,
						OperatorsPackage.Literals.RELATIONSHIP__NODE_ID2_REF,
						null);
				editingService.getEditingDomain().getCommandStack()
						.execute(set);
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

		Button btnSelNode2 = toolkit.createButton(cmpTolerances, "Select...",
				SWT.NONE);
		btnSelNode2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Operator->Network->Node.
				// We can link to any node.
				Resource operatorResource = editingService
						.getData(OperatorsPackage.Literals.OPERATOR);
				NodeFilterDialog dialog = new NodeFilterDialog(NewEditLink.this
						.getShell(), operatorResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Node node2 = (Node) dialog.getFirstResult();
					relationship.setNodeID2Ref(node2);
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
						NewEditLink.this.getShell(), operatorResource);
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
