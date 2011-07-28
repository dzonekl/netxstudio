package com.netxforge.netxstudio.screens.details;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
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
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage.Literals;
import com.netxforge.netxstudio.screens.DateChooserComboObservableValue;
import com.netxforge.netxstudio.screens.NodeTypeFilterDialog;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class NewEditNode extends AbstractDetailsComposite implements IScreen,
		IDataScreenInjection {
	
	

	private Node node;
	private FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private IEditingService editingService;
	private Text txtNodeType;
	private Text txtRoom;

	@Inject
	ModelUtils modelUtils;
	private DateChooserCombo dcProposed;
	private DateChooserCombo dcPlanned;
	private DateChooserCombo dcConstruction;
	private DateChooserCombo dcInService;
	private DateChooserCombo dcOutOfService;
	private ImageHyperlink roomRefHyperlink;

	private ImageHyperlink nodeTypeHyperlink;

	public NewEditNode(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof Node) {
			this.node = (Node) object;
		} else {
			return;
		}
		this.buildUI();
		this.initDataBindings_();
	}

	public boolean isValid() {
		return false;
	}

	private void buildUI() {

		
		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;
		
		
		Section scnInfo = toolkit.createSection(this, Section.EXPANDED
				| Section.TITLE_BAR);
		FormData fd_scnInfo = new FormData();
		fd_scnInfo.top = new FormAttachment(0, 10);
		fd_scnInfo.left = new FormAttachment(0, 10);
		fd_scnInfo.right = new FormAttachment(100, -14);
		scnInfo.setLayoutData(fd_scnInfo);
		toolkit.paintBordersFor(scnInfo);
		scnInfo.setText("Info");

		Composite composite = toolkit.createComposite(scnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite);
		scnInfo.setClient(composite);
		composite.setLayout(new GridLayout(4, false));

		Label lblName = toolkit.createLabel(composite, "Node ID:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 80;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite, "New Text", SWT.NONE | widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblType = toolkit.createLabel(composite, "Type:", SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));

		txtNodeType = toolkit.createText(composite, "New Text", SWT.NONE | SWT.READ_ONLY);
		txtNodeType.setText("");
		txtNodeType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		
		nodeTypeHyperlink = toolkit.createImageHyperlink(composite, SWT.NONE);
		nodeTypeHyperlink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				
				// As we have a copy of the node type, we shall delete or make sure it's added to some 
				// sort of history. 
				RemoveCommand.create(editingService.getEditingDomain(), node,OperatorsPackage.Literals.NODE__NODE_TYPE, null);
				
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		GridData gd_imageHyperlink_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_imageHyperlink_1.widthHint = 18;
		nodeTypeHyperlink.setLayoutData(gd_imageHyperlink_1);
		nodeTypeHyperlink.setImage(ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(nodeTypeHyperlink);
		nodeTypeHyperlink.setText("");

		Button btnSelectNodeType = toolkit.createButton(composite, "Select...",
				SWT.NONE);
		btnSelectNodeType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource nodeTypeResource = editingService
						.getData(LibraryPackage.Literals.NODE_TYPE);
				NodeTypeFilterDialog dialog = new NodeTypeFilterDialog(
						NewEditNode.this.getShell(), nodeTypeResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					NodeType nt = (NodeType) dialog.getFirstResult();

					if (node.getOriginalNodeTypeRef() != null) {
						node.setOriginalNodeTypeRef(null);
					}
					
					
					// Copy the NodeType. 
					// As we copy references, we will aslo get. 
					// - Expressions
					// - Metrics 
					// - Resources. 
					// - Tolerances etc...
					EcoreUtil.Copier copier = new EcoreUtil.Copier();
					NodeType copyOf = (NodeType) copier.copy(nt);
					copier.copyReferences();
					
					node.setNodeType(copyOf); // Should now show with databinding.
				}
			}
		});
		Section sctnGeo = toolkit.createSection(this, Section.TITLE_BAR);
		FormData fd_sctnGeo = new FormData();
		fd_sctnGeo.bottom = new FormAttachment(100, -10);
		fd_sctnGeo.left = new FormAttachment(0, 10);
		fd_sctnGeo.right = new FormAttachment(100, -14);
		sctnGeo.setLayoutData(fd_sctnGeo);
		toolkit.paintBordersFor(sctnGeo);
		sctnGeo.setText("Geo");
		sctnGeo.setExpanded(true);

		Composite cmpTolerances = toolkit.createComposite(sctnGeo, SWT.NONE);
		toolkit.paintBordersFor(cmpTolerances);
		sctnGeo.setClient(cmpTolerances);
		cmpTolerances.setLayout(new GridLayout(5, false));

		Label lblRoomsite = toolkit.createLabel(cmpTolerances, "Room/Site:",
				SWT.NONE);
		lblRoomsite.setAlignment(SWT.RIGHT);
		GridData gd_lblRoomsite = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblRoomsite.widthHint = 80;
		lblRoomsite.setLayoutData(gd_lblRoomsite);
		
				txtRoom = toolkit.createText(cmpTolerances, "New Text", SWT.NONE);
				txtRoom.setText("");
				GridData gd_txtRoom = new GridData(SWT.FILL, SWT.CENTER, false, false,
						1, 1);
				gd_txtRoom.widthHint = 150;
				txtRoom.setLayoutData(gd_txtRoom);
		
		
		roomRefHyperlink = toolkit.createImageHyperlink(cmpTolerances, SWT.NONE);
		GridData gd_imageHyperlink = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_imageHyperlink.widthHint = 18;
		roomRefHyperlink.setLayoutData(gd_imageHyperlink);
		roomRefHyperlink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// Remove the romm ref link
				node.setRoomRef(null);
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		
		roomRefHyperlink.setImage(ResourceManager.getPluginImage("org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(roomRefHyperlink);
		roomRefHyperlink.setText("");
		
		
		Button btnSelectRoom = toolkit.createButton(cmpTolerances, "Select...",
				SWT.NONE);
		new Label(cmpTolerances, SWT.NONE);
		btnSelectRoom.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// TODO tricky, this is a multistage selection from
				// Country->Site->Room.

				// Resource nodeTypeResource =
				// editingService.getData(LibraryPackage.Literals.NODE_TYPE);
				// NodeTypeFilterDialog dialog = new NodeTypeFilterDialog(
				// NewEditNode.this.getShell(), nodeTypeResource);
				// if (dialog.open() == IDialogConstants.OK_ID) {
				// NodeType nt = (NodeType) dialog.getFirstResult();
				//
				// if(node.getOriginalNodeTypeRef() != null){
				// node.setOriginalNodeTypeRef(null);
				// }
				// node.setNodeType(nt); // Should now show with databinding.
				// }

			}
		});

		Section sctnLifecycle = toolkit.createSection(this, Section.TITLE_BAR);
		fd_sctnGeo.top = new FormAttachment(0, 302);
		fd_scnInfo.bottom = new FormAttachment(sctnLifecycle, -6);
		FormData fd_sctnLifecycle = new FormData();
		fd_sctnLifecycle.bottom = new FormAttachment(sctnGeo, -6);
		fd_sctnLifecycle.left = new FormAttachment(0, 10);
		fd_sctnLifecycle.top = new FormAttachment(0, 114);
		fd_sctnLifecycle.right = new FormAttachment(100, -14);
		sctnLifecycle.setLayoutData(fd_sctnLifecycle);
		toolkit.paintBordersFor(sctnLifecycle);
		sctnLifecycle.setText("Lifecycle");

		Composite composite_1 = toolkit
				.createComposite(sctnLifecycle, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnLifecycle.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));

		Label lblProposed = toolkit.createLabel(composite_1, "Proposed:",
				SWT.NONE);
		lblProposed.setAlignment(SWT.RIGHT);
		GridData gd_lblProposed = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblProposed.widthHint = 70;
		lblProposed.setLayoutData(gd_lblProposed);

		dcProposed = new DateChooserCombo(composite_1, SWT.BORDER | SWT.FLAT);
		GridData gd_dcProposed = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcProposed.heightHint = 20;
		dcProposed.setLayoutData(gd_dcProposed);
		toolkit.adapt(dcProposed);
		toolkit.paintBordersFor(dcProposed);

		Label lblPlanned = toolkit.createLabel(composite_1, "Planned:",
				SWT.NONE);
		lblPlanned.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblPlanned.setAlignment(SWT.RIGHT);

		dcPlanned = new DateChooserCombo(composite_1, SWT.BORDER | SWT.FLAT);
		GridData gd_dcPlanned = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcPlanned.heightHint = 20;
		dcPlanned.setLayoutData(gd_dcPlanned);
		toolkit.adapt(dcPlanned);
		toolkit.paintBordersFor(dcPlanned);

		Label lblConstruction = toolkit.createLabel(composite_1,
				"Construction:", SWT.NONE);
		lblConstruction.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		dcConstruction = new DateChooserCombo(composite_1, SWT.BORDER
				| SWT.FLAT);
		GridData gd_dcConstruction = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcConstruction.heightHint = 20;
		dcConstruction.setLayoutData(gd_dcConstruction);
		toolkit.adapt(dcConstruction);
		toolkit.paintBordersFor(dcConstruction);

		Label lblInService = toolkit.createLabel(composite_1, "In Service:",
				SWT.NONE);
		lblInService.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblInService.setAlignment(SWT.RIGHT);

		dcInService = new DateChooserCombo(composite_1, SWT.BORDER | SWT.FLAT);
		GridData gd_dcInService = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcInService.heightHint = 20;
		dcInService.setLayoutData(gd_dcInService);
		toolkit.adapt(dcInService);
		toolkit.paintBordersFor(dcInService);

		Label lblOutOfService = toolkit.createLabel(composite_1,
				"Out of Service:", SWT.NONE);
		GridData gd_lblOutOfService = new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1);
		gd_lblOutOfService.widthHint = 80;
		lblOutOfService.setLayoutData(gd_lblOutOfService);

		dcOutOfService = new DateChooserCombo(composite_1, SWT.BORDER
				| SWT.FLAT);
		GridData gd_dcOutOfService = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcOutOfService.heightHint = 20;
		dcOutOfService.setLayoutData(gd_dcOutOfService);
		dcOutOfService.setWeeksVisible(true);
		toolkit.adapt(dcOutOfService);
		toolkit.paintBordersFor(dcOutOfService);

	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		// Binding of name and Description

		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));

		IObservableValue nodeTypeObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtNodeType, SWT.Modify));

		IObservableValue roomObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtRoom, SWT.Modify));

		IEMFValueProperty nodeIDProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.NODE__NODE_ID);

		IEMFValueProperty nodetypeProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.NODE__NODE_TYPE,
						LibraryPackage.Literals.NODE_TYPE__NAME));

		IEMFValueProperty roomProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.NODE__ROOM_REF);

		context.bindValue(nameObservable, nodeIDProperty.observe(node), null,
				null);
		context.bindValue(nodeTypeObservable, nodetypeProperty.observe(node),
				null, null);
		context.bindValue(roomObservable, roomProperty.observe(node), null,
				null);
		
		// Action observables

		
//		EMFUpdateValueStrategy featureToTargetStrategy = new EMFUpdateValueStrategy();
//		featureToTargetStrategy.setConverter(new FeatureToTargetConverter(OperatorsPackage.Literals.NODE__NODE_TYPE));
//
//		IObservableValue noteTypeObserveEnabledObserveWidget = SWTObservables.observeVisible(this.nodeTypeHyperlink);
//		IEMFValueProperty nodeTypeObserveValue = EMFEditProperties.value(editingService.getEditingDomain(), Literals.NODE__NODE_TYPE);
//		
//		context.bindValue(noteTypeObserveEnabledObserveWidget, nodeTypeObserveValue.observe(node), null, featureToTargetStrategy);
//		
//		
//		IObservableValue roomRefEnabledObserveWidget = SWTObservables.observeVisible(roomRefHyperlink);
//		IEMFValueProperty roomRefObserveValue = EMFEditProperties.value(editingService.getEditingDomain(), Literals.NODE__ROOM_REF);
//		
//		context.bindValue(roomRefEnabledObserveWidget, roomRefObserveValue.observe(node), null, null);
//		
		

		// Lifecycle properties.

		IObservableValue dcProposedObservable = new DateChooserComboObservableValue(
				dcProposed, SWT.Modify);

		IObservableValue dcPlannedObservable = new DateChooserComboObservableValue(
				dcPlanned, SWT.Modify);

		IObservableValue dcConstructionObservable = new DateChooserComboObservableValue(
				dcConstruction, SWT.Modify);

		IObservableValue dcInServiceObservable = new DateChooserComboObservableValue(
				dcInService, SWT.Modify);

		IObservableValue dcOutOfServiceObservable = new DateChooserComboObservableValue(
				dcOutOfService, SWT.Modify);

		IEMFValueProperty proposedProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.NODE__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__PROPOSED));

		IEMFValueProperty plannedProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.NODE__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__PLANNED_DATE));

		IEMFValueProperty constructionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.NODE__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__CONSTRUCTION_DATE));

		IEMFValueProperty inServiceProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						OperatorsPackage.Literals.NODE__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__IN_SERVICE_DATE));

		IEMFValueProperty outOfServiceProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										OperatorsPackage.Literals.NODE__LIFECYCLE,
										GenericsPackage.Literals.LIFECYCLE__OUT_OF_SERVICE_DATE));

		EMFUpdateValueStrategy modelToTargetUpdateStrategy = new EMFUpdateValueStrategy();
		modelToTargetUpdateStrategy.setConverter(new IConverter() {

			public Object getFromType() {
				return XMLGregorianCalendar.class;
			}

			public Object getToType() {
				return Date.class;
			}

			public Object convert(Object fromObject) {
				return modelUtils
						.fromXMLDate((XMLGregorianCalendar) fromObject);
			}
		});

		EMFUpdateValueStrategy targetToModelUpdateStrategy = new EMFUpdateValueStrategy();
		targetToModelUpdateStrategy.setConverter(new IConverter() {

			public Object getFromType() {
				return Date.class;
			}

			public Object getToType() {

				return XMLGregorianCalendar.class;
			}

			public Object convert(Object fromObject) {
				return modelUtils.toXMLDate((Date) fromObject);
			}
		});

		// Create a new lifecycle if non-existent.
		if (node.getLifecycle() == null) {
			Lifecycle newLC = GenericsFactory.eINSTANCE.createLifecycle();
			node.setLifecycle(newLC);
		}

		context.bindValue(dcProposedObservable, proposedProperty.observe(node),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		context.bindValue(dcPlannedObservable, plannedProperty.observe(node),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		context.bindValue(dcConstructionObservable,
				constructionProperty.observe(node),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		context.bindValue(dcInServiceObservable,
				inServiceProperty.observe(node), targetToModelUpdateStrategy,
				modelToTargetUpdateStrategy);

		context.bindValue(dcOutOfServiceObservable,
				outOfServiceProperty.observe(node),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		return context;
	}
	
	
	private final class FeatureToTargetConverter implements IConverter {
		
		EStructuralFeature feature;
		
		public FeatureToTargetConverter(EStructuralFeature feature) {
			super();
			this.feature = feature;
		}

		public Object getFromType() {
			return EObject.class;
		}

		public Object getToType() {
			return Boolean.class;
		}

		public Object convert(Object fromObject) {
			if(fromObject instanceof EObject){
				return ((EObject) fromObject).eIsSet(feature);
			}
			return null;
		}
	}
}
