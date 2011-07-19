package com.netxforge.netxstudio.screens.f2;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.f2.parts.NodeTypeEditPartsFactory;

public class ViewNodeType extends AbstractDetailsComposite implements IScreen, IDataScreenInjection {

	private NodeType nodeType;
	private FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private IEditingService editingService;
	private Composite cmpHierachy;
	
	public ViewNodeType(Composite parent, int style, final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		this.buildUI();
	}
	
	public void injectData(Object owner, Object object) {
		if(object instanceof NodeType){
			this.nodeType = (NodeType) object;
		}else{
			return;
		}
		this.initDataBindings_();
		this.showHierachy(cmpHierachy);
	}
	
	public boolean isValid() {
		return false;
	}
	
	private void buildUI(){
		
		Section scnInfo = toolkit.createSection(this,
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_scnInfo = new FormData();
		fd_scnInfo.top = new FormAttachment(0, 10);
		fd_scnInfo.left = new FormAttachment(0, 10);
		fd_scnInfo.bottom = new FormAttachment(0, 109);
		fd_scnInfo.right = new FormAttachment(100, -14);
		scnInfo.setLayoutData(fd_scnInfo);
		toolkit.paintBordersFor(scnInfo);
		scnInfo.setText("Info");		
		
		Composite composite = toolkit.createComposite(scnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite);
		scnInfo.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
		
		Label lblName = toolkit.createLabel(composite, "# of Functions:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1);
		gd_lblName.widthHint = 147;
		lblName.setLayoutData(gd_lblName);
		
		Label lblDescription = toolkit.createLabel(composite, "# of Equipments:", SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblDescription.setAlignment(SWT.RIGHT);
		
		Label lblOfResources = toolkit.createLabel(composite, "# of Resources:", SWT.NONE);
		lblOfResources.setAlignment(SWT.RIGHT);
		lblOfResources.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Section sctnHierachy = toolkit.createSection(this, Section.TWISTIE | Section.TITLE_BAR);
		FormData fd_sctnHierachy = new FormData();
		fd_sctnHierachy.bottom = new FormAttachment(100, -10);
		fd_sctnHierachy.top = new FormAttachment(scnInfo, 6);
		fd_sctnHierachy.left = new FormAttachment(0, 10);
		fd_sctnHierachy.right = new FormAttachment(0, 440);
		sctnHierachy.setLayoutData(fd_sctnHierachy);
		toolkit.paintBordersFor(sctnHierachy);
		sctnHierachy.setText("Hierachy");
		sctnHierachy.setExpanded(true);
		
		cmpHierachy = new Composite(sctnHierachy, SWT.BORDER);
		toolkit.adapt(cmpHierachy);
		toolkit.paintBordersFor(cmpHierachy);
		sctnHierachy.setClient(cmpHierachy);
		
		
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		
		// Binding of name and Description
		
//		IObservableValue nameObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(txtName,  SWT.Modify));
//		IObservableValue descriptionObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(text,  SWT.Modify));
//		
//		IEMFValueProperty componentNameProperty = EMFEditProperties.value(editingService.getEditingDomain(), LibraryPackage.Literals.COMPONENT__NAME);
//		IEMFValueProperty componentDescriptionProperty = EMFEditProperties.value(editingService.getEditingDomain(), LibraryPackage.Literals.COMPONENT__DESCRIPTION);
//		
//		context.bindValue(nameObservable, componentNameProperty.observe(comp), null, null);
//		context.bindValue(descriptionObservable, componentDescriptionProperty.observe(comp), null, null);
//		
//		// binding of tolerances. 
//		
//		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
//		tolerancesTableViewer.setContentProvider(listContentProvider);
//		IObservableMap[] observeMaps = EMFObservables.observeMaps(
//				listContentProvider.getKnownElements(),
//				new EStructuralFeature[] {
//						LibraryPackage.Literals.TOLERANCE__NAME,
//						LibraryPackage.Literals.TOLERANCE__LEVEL,
//						LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF });
//		tolerancesTableViewer
//				.setLabelProvider(new ToleranceObservableMapLabelProvider(observeMaps));
//		IEMFListProperty l = EMFEditProperties.list(editingService
//				.getEditingDomain(), LibraryPackage.Literals.COMPONENT__TOLERANCE_REFS);
//		
//		IObservableList toleranceObservableList = l.observe(comp); 
//		
////		obm.addObservable(toleranceObservableList);
//		tolerancesTableViewer.setInput(toleranceObservableList);
		
		return context;
	}
	
	ScrollingGraphicalViewer graphicalViewer;
	
	private void showHierachy(Composite c){
		c.setLayout(new FillLayout());
		// Do some gef here. 
		ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart();
		graphicalViewer = new ScrollingGraphicalViewer();
		graphicalViewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, true);
		graphicalViewer.createControl(c);
		graphicalViewer.getControl().setBackground(ColorConstants.listBackground);
		graphicalViewer.setRootEditPart(rootEditPart);
		graphicalViewer.setEditPartFactory(new NodeTypeEditPartsFactory());
		graphicalViewer.setContents(nodeType);
	}
}
