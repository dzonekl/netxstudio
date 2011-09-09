package com.netxforge.netxstudio.screens.f2.details;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.details.AbstractDetailsScreen;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f2.model.WrappedNodeType;
import com.netxforge.netxstudio.screens.f2.parts.NodeTypeEditPartsFactory;
import com.netxforge.netxstudio.screens.f2.support.Totals;

public class NewEditNodeType extends AbstractDetailsScreen implements
		IScreen, IDataScreenInjection {

	private NodeType nodeType;
	private FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private IEditingService editingService;
	private Composite cmpHierachy;
	private Button btnLeafNode;
	private FormText frmTextNumberOfFunctions;
	private FormText frmTextNumberOfEquipments;
	private FormText frmTextNumberOfResources;

	public NewEditNodeType(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
//		this.buildUI();
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof NodeType) {
			this.nodeType = (NodeType) object;
		} else {
			return;
		}
		this.buildUI();
		this.initDataBindings_();
		this.showHierachy(cmpHierachy);
	}

	public boolean isValid() {
		return false;
	}

	private void buildUI() {

		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		Section sctnInfo = toolkit.createSection(this, Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");

		
		
		Composite cmpInfo = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(cmpInfo);
		sctnInfo.setClient(cmpInfo);
		cmpInfo.setLayout(new GridLayout(2, false));

		Label lblName_1 = toolkit.createLabel(cmpInfo, "Name:", SWT.NONE);
		lblName_1.setAlignment(SWT.RIGHT);
		GridData gd_lblName_1 = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblName_1.widthHint = 70;
		lblName_1.setLayoutData(gd_lblName_1);

		txtName = toolkit.createText(cmpInfo, "New Text", SWT.NONE
				| widgetStyle);
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);
		txtName.setText("");

		btnLeafNode = toolkit.createButton(cmpInfo,
				"Check if this Element Type will be deployed at the end of a service chain",
				SWT.CHECK );
		btnLeafNode.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		
		Section scnTotals = toolkit.createSection(this, Section.EXPANDED
				| Section.TITLE_BAR);
		toolkit.paintBordersFor(scnTotals);
		scnTotals.setText("Totals");

		Composite composite = toolkit.createComposite(scnTotals, SWT.NONE);
		toolkit.paintBordersFor(composite);
		scnTotals.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblName = toolkit.createLabel(composite, "# of Functions:",
				SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.BOTTOM, false, false,
				1, 1);
		gd_lblName.widthHint = 147;
		lblName.setLayoutData(gd_lblName);

		frmTextNumberOfFunctions = toolkit.createFormText(composite, false);
		GridData gd_frmTextNumberOfFunctions = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_frmTextNumberOfFunctions.widthHint = 40;
		frmTextNumberOfFunctions.setLayoutData(gd_frmTextNumberOfFunctions);
		toolkit.paintBordersFor(frmTextNumberOfFunctions);
		frmTextNumberOfFunctions.setText("", false, false);

		Label lblDescription = toolkit.createLabel(composite,
				"# of Equipments:", SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 1, 1));
		lblDescription.setAlignment(SWT.RIGHT);

		frmTextNumberOfEquipments = toolkit.createFormText(composite, false);
		GridData gd_frmTextNumberOfEquipments = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_frmTextNumberOfEquipments.widthHint = 40;
		frmTextNumberOfEquipments.setLayoutData(gd_frmTextNumberOfEquipments);
		toolkit.paintBordersFor(frmTextNumberOfEquipments);
		frmTextNumberOfEquipments.setText("", false, false);

		Label lblOfResources = toolkit.createLabel(composite,
				"# of Resources:", SWT.NONE);
		lblOfResources.setAlignment(SWT.RIGHT);
		lblOfResources.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		frmTextNumberOfResources = toolkit.createFormText(composite, false);
		toolkit.paintBordersFor(frmTextNumberOfResources);
		frmTextNumberOfResources.setText("", false, false);

		Section sctnHierachy = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		ColumnLayoutData cld_sctnHierachy = new ColumnLayoutData();
		cld_sctnHierachy.heightHint = 300;
		sctnHierachy.setLayoutData(cld_sctnHierachy);
		
		toolkit.paintBordersFor(sctnHierachy);
		sctnHierachy.setText("Hierachy");
		sctnHierachy.setExpanded(true);

		cmpHierachy = new Composite(sctnHierachy, SWT.BORDER);
		toolkit.adapt(cmpHierachy);
		toolkit.paintBordersFor(cmpHierachy);
		sctnHierachy.setClient(cmpHierachy);
		
		if(readonly){
			btnLeafNode.setEnabled(false);
		}
		
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		// Binding of name and Description
		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));
		IObservableValue leafObservable = SWTObservables
				.observeSelection(btnLeafNode);

		IEMFValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.NODE_TYPE__NAME);
		IEMFValueProperty leafProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.NODE_TYPE__LEAF_NODE);

		context.bindValue(nameObservable, nameProperty.observe(nodeType), null,
				null);
		context.bindValue(leafObservable, leafProperty.observe(nodeType), null,
				null);

		Totals totals = new Totals(nodeType);
		this.frmTextNumberOfFunctions.setText(totals.getFunctions(),
				false, false);
		this.frmTextNumberOfEquipments.setText(totals.getEquipments(),
				false, false);
		this.frmTextNumberOfResources.setText(totals.getResources(),
				false, false);
		return context;
	}

	ScrollingGraphicalViewer graphicalViewer;
	private Text txtName;

	private void showHierachy(Composite c) {
		c.setLayout(new FillLayout());
		// Do some gef here.
		ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart();
		graphicalViewer = new ScrollingGraphicalViewer();
		graphicalViewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, true);
		graphicalViewer.createControl(c);
		graphicalViewer.getControl().setBackground(
				ColorConstants.listBackground);
		graphicalViewer.setRootEditPart(rootEditPart);
		graphicalViewer.setEditPartFactory(new NodeTypeEditPartsFactory());
		graphicalViewer.setContents(new WrappedNodeType(nodeType));
		rootEditPart.refresh();
	}
}
