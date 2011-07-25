/*******************************************************************************
 * Copyright (c) May 9, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f2.support.NodeTypeTreeLabelProvider;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class NodeTypes extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	@SuppressWarnings("unused")
	private DataBindingContext bindingContext;
	private Form frmNodeTypes;
	private Resource nodeTypeResource;
	private TreeViewer nodeTypeTreeViewer;
	private Composite cmpDetails;
	private SashForm sashForm;

	// private EMFObservablesManager mgr;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NodeTypes(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				obm.dispose();
				toolkit.dispose();
				System.err.println("disposed toolkit");
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataServiceInjection#injectData()
	 */
	public void injectData() {
		nodeTypeResource = editingService
				.getData(LibraryPackage.Literals.NODE_TYPE);
		buildUI();
		initDataBindings_();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		
		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation()); 
		String actionText = readonly ? "View: " : "Edit: "; 
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;
		
		frmNodeTypes = toolkit.createForm(this);
		frmNodeTypes.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNodeTypes);
		
		
		frmNodeTypes.setText(actionText + "Network Element Types");
		frmNodeTypes.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		sashForm = new SashForm(frmNodeTypes.getBody(), SWT.VERTICAL);
		sashForm.setOrientation(SWT.HORIZONTAL);
		toolkit.adapt(sashForm);
		toolkit.paintBordersFor(sashForm);

		Composite composite = toolkit.createComposite(sashForm, SWT.NONE);
		toolkit.paintBordersFor(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblFilterLabel = toolkit.createLabel(composite, "Filter:",
				SWT.NONE);
		lblFilterLabel.setSize(64, 81);

		txtFilterText = toolkit.createText(composite, "New Text", SWT.H_SCROLL
				| SWT.SEARCH | SWT.CANCEL);
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);
		txtFilterText.setSize(64, 81);
		txtFilterText.setText("");

		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				nodeTypeTreeViewer.refresh();
				ViewerFilter[] filters = nodeTypeTreeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
			}
		});

		nodeTypeTreeViewer = new TreeViewer(composite, SWT.BORDER | widgetStyle);
		nodeTypeTreeViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						ISelection s = event.getSelection();
						if (s instanceof IStructuredSelection) {
							IStructuredSelection ss = (IStructuredSelection) s;
							Object o = ss.getFirstElement();
							handleDetailsSelection(o);
						}
					}
				});
		Tree tree = nodeTypeTreeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 2));
		tree.setSize(74, 81);
		toolkit.paintBordersFor(tree);

		cmpDetails = toolkit.createComposite(sashForm, SWT.NONE);
		toolkit.paintBordersFor(cmpDetails);
		cmpDetails.setLayout(new FillLayout());
		sashForm.setWeights(new int[] { 1, 1 });

	}

	public void disposeData() {
		if (editingService != null) {
			editingService.disposeData(nodeTypeResource);
		}
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		ObservableListTreeContentProvider cp = new ObservableListTreeContentProvider(
				new NodeTypeTreeFactoryImpl(editingService.getEditingDomain(),
						obm), new NodeTypeTreeStructureAdvisorImpl());
		nodeTypeTreeViewer.setContentProvider(cp);

		IObservableSet set = cp.getKnownElements();
		IObservableMap[] map = new IObservableMap[2];

		EAttribute dummyA = EcoreFactory.eINSTANCE.createEAttribute();
		map[0] = EMFEditProperties.value(editingService.getEditingDomain(),
				dummyA).observeDetail(set);

		map[1] = EMFProperties.value(LibraryPackage.Literals.COMPONENT__NAME)
				.observeDetail(set);

		nodeTypeTreeViewer.setLabelProvider(new NodeTypeTreeLabelProvider(map));
		IEMFListProperty projects = EMFEditProperties.resource(editingService
				.getEditingDomain());

		IObservableList nodeTypeObservableList = projects
				.observe(nodeTypeResource);
		 obm.addObservable(nodeTypeObservableList);
		nodeTypeTreeViewer.setInput(nodeTypeObservableList);

		return bindingContext;
	}

	class NodeTypeTreeFactoryImpl implements IObservableFactory {

		EditingDomain domain;
		private ObservablesManager obm;

		private IEMFListProperty nodeTypeObservableProperty = EMFEditProperties
				.multiList(domain,
						LibraryPackage.Literals.NODE_TYPE__FUNCTIONS,
						LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS);

		private IEMFListProperty functionsObservableProperty = EMFEditProperties
				.multiList(domain, LibraryPackage.Literals.FUNCTION__FUNCTIONS);

		private IEMFListProperty equipmentsObservableProperty = EMFEditProperties
				.multiList(domain,
						LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS);

		NodeTypeTreeFactoryImpl(EditingDomain domain, ObservablesManager obm) {
			this.domain = domain;
			this.obm = obm;
		}

		public IObservable createObservable(final Object target) {

			IObservable ol = null;

			if (target instanceof IObservableList) {
				ol = (IObservable) target;
			} else if (target instanceof NodeType) {
				ol = nodeTypeObservableProperty.observe(target);
			} else if (target instanceof Function) {
				ol = functionsObservableProperty.observe(target);
			} else if (target instanceof Equipment) {
				ol = equipmentsObservableProperty.observe(target);
			}

			if (ol != null) {
				obm.addObservable(ol);
			}
			return ol;
		}
	}

	class NodeTypeTreeStructureAdvisorImpl extends TreeStructureAdvisor {
		@Override
		public Object getParent(Object element) {
			// Can't determine parent.
			// if (element instanceof Project)
			// {
			// return ((Project)element).getParent();
			// }
			return null;
		}

		@Override
		public Boolean hasChildren(Object element) {
			if (element instanceof NodeType
					&& (((NodeType) element).getFunctions().size() > 0 || ((NodeType) element)
							.getEquipments().size() > 0)) {
				return Boolean.TRUE;
			}

			if (element instanceof Function
					&& ((Function) element).getFunctions().size() > 0) {
				return Boolean.TRUE;
			}
			if (element instanceof Equipment
					&& ((Equipment) element).getEquipments().size() > 0) {
				return Boolean.TRUE;
			}
			return super.hasChildren(element);
		}
	}
	
	

	Composite currentDetails;

	private void handleDetailsSelection(Object o) {

		if (currentDetails != null) {
			currentDetails.dispose();
		}
		
		if (o instanceof Function) {
			NewEditComponent nef = null;
			nef = new NewEditFunction(this.cmpDetails, SWT.NONE, editingService);
			nef.setScreenService(screenService);
			nef.injectData(null, o);
			this.currentDetails = nef;
			sashForm.layout(true, true);
		}
		if (o instanceof Equipment) {
			NewEditComponent nef = null;
			nef = new NewEditEquipment(this.cmpDetails, SWT.NONE,
					editingService);
			nef.setScreenService(screenService);
			nef.injectData(null, o);
			this.currentDetails = nef;
			sashForm.layout(true, true);

		}
		if (o instanceof NodeType) {
			NewEditNodeType nnt = new NewEditNodeType(this.cmpDetails, SWT.NONE,
					editingService);
			nnt.injectData(null, o);
			this.currentDetails = nnt;
			sashForm.layout(true, true);
		}

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return this.nodeTypeTreeViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#isValid()
	 */
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return this.frmNodeTypes;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

}
