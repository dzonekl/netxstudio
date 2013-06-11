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

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
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
import org.eclipse.ui.IMemento;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.actions.NodeTypeExportHTMLAction;
import com.netxforge.netxstudio.screens.actions.NodeTypeExportXLSAction;
import com.netxforge.netxstudio.screens.editing.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.screens.editing.filter.TreeSearchFilter;
import com.netxforge.netxstudio.screens.f2.details.NewEditEquipment;
import com.netxforge.netxstudio.screens.f2.details.NewEditFunction;
import com.netxforge.netxstudio.screens.f2.details.NewEditNodeType;
import com.netxforge.netxstudio.screens.f2.support.NodeTypeTreeFactoryImpl;
import com.netxforge.netxstudio.screens.f2.support.NodeTypeTreeLabelProvider;
import com.netxforge.netxstudio.screens.f3.NetworkViewerComparator;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class NodeTypes extends AbstractScreen implements IDataServiceInjection {

	private static final String MEM_KEY_NODETYPES_SELECTION_TREE = "MEM_KEY_NODETYPES_SELECTION_TREE";

	/*
	 * Remember the state for Details => Function.
	 */
	private static final String MEM_KEY_DETAILS_FUNCTION = "MEM_KEY_DETAILS_FUNCTION";
	private static final String MEM_KEY_DETAILS_EQUIPMENT = "MEM_KEY_DETAILS_EQUIPMENT";
	private static final String MEM_KEY_DETAILS_NODE_TYPE = "MEM_KEY_DETAILS_NODE_TYPE";

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	@SuppressWarnings("unused")
	private DataBindingContext bindingContext;
	private Form frmNodeTypes;
	private CDOResource nodeTypeResource;
	private TreeViewer nodeTypeTreeViewer;
	private Composite cmpDetails;
	private SashForm sashForm;

	@Inject
	private MonitoringStateModel stateModel;
	
	private NodeTypeTreeLabelProvider ntTreeLabelProvider;

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
				// obm.dispose();
				toolkit.dispose();
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
		nodeTypeResource = (CDOResource) editingService
				.getData(LibraryPackage.Literals.NODE_TYPE);
		buildUI();
		initDataBindings_();
	}

	Thread updateDetails;

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
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
		composite.setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(composite, "Filter:",
				SWT.NONE);
		lblFilterLabel.setSize(64, 81);

		txtFilterText = toolkit.createText(composite, "New Text", SWT.H_SCROLL
				| SWT.SEARCH | SWT.CANCEL);
		GridData gd_txtFilterText = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		// gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);
		// txtFilterText.setSize(64, 81);
		txtFilterText.setText("");

		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				ViewerFilter[] filters = nodeTypeTreeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof TreeSearchFilter) {
						((TreeSearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
				nodeTypeTreeViewer.refresh();
				nodeTypeTreeViewer.expandAll();
			}
		});

		if (!readonly) {

			hypLnkNewNodeType = toolkit.createImageHyperlink(composite,
					SWT.NONE);
			hypLnkNewNodeType.setImage(ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/ctool16/Node_E.png"));
			hypLnkNewNodeType.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					// Create a new top level nodetype.
					NodeType newNodeType = LibraryFactory.eINSTANCE
							.createNodeType();
					newNodeType.setName("<new NE Type>");
					Command add = new AddCommand(editingService
							.getEditingDomain(),
							nodeTypeResource.getContents(), newNodeType);

					editingService.getEditingDomain().getCommandStack()
							.execute(add);
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});
			hypLnkNewNodeType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
					false, false, 1, 1));
			toolkit.paintBordersFor(hypLnkNewNodeType);
			hypLnkNewNodeType.setText("New");

		}

		nodeTypeTreeViewer = new TreeViewer(composite, SWT.BORDER | SWT.MULTI
				| SWT.VIRTUAL | widgetStyle);
		nodeTypeTreeViewer.setUseHashlookup(true);
		nodeTypeTreeViewer.setComparer(new CDOElementComparer());
		nodeTypeTreeViewer.addFilter(new TreeSearchFilter(editingService));
		nodeTypeTreeViewer.setComparator(new NetworkViewerComparator());

		nodeTypeTreeViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						final ISelection s = event.getSelection();
						// TODO, We coud even wait to see if we get another
						// update within 100ms.
						// If we do, we would cancel.

						NodeTypes.this.getDisplay().asyncExec(new Runnable() {
							public void run() {
								if (s instanceof IStructuredSelection) {
									IStructuredSelection ss = (IStructuredSelection) s;
									Object o = ss.getFirstElement();
									try {
										handleDetailsSelection(o);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						});

					}
				});
		Tree tree = nodeTypeTreeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2));
		tree.setSize(74, 81);
		toolkit.paintBordersFor(tree);

		cmpDetails = toolkit.createComposite(sashForm, SWT.NONE);
		toolkit.paintBordersFor(cmpDetails);
		cmpDetails.setLayout(new FillLayout());
		sashForm.setWeights(new int[] { 3, 7 });

	}

	class HistoryAction extends Action {

		public HistoryAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			ISelection s = nodeTypeTreeViewer.getSelection();
			if (s instanceof IStructuredSelection) {
				Object object = ((IStructuredSelection) s).getFirstElement();
				if (object instanceof NodeType) {
					NodeTypeHistory nodeTypeHistoryScreen = new NodeTypeHistory(
							screenService.getScreenContainer(), SWT.NONE);
					nodeTypeHistoryScreen.setScreenService(screenService);
					nodeTypeHistoryScreen
							.setOperation(ScreenUtil.OPERATION_READ_ONLY);
					nodeTypeHistoryScreen.injectData(null, object);
					screenService.setActiveScreen(nodeTypeHistoryScreen);
				}
			}
		}
	}

	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		if (actions.isEmpty()) {
			actions.add(new NodeTypeExportHTMLAction("Export to HTML", SWT.PUSH));
			actions.add(new NodeTypeExportXLSAction("Export to XLS", SWT.PUSH));
			actions.add(new HistoryAction("History..."));
		}
		return actions.toArray(new IAction[actions.size()]);
	}

	// public void disposeData() {
	// if (editingService != null) {
	// editingService.disposeData(nodeTypeResource);
	// }
	// }

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		ObservableListTreeContentProvider cp = new ObservableListTreeContentProvider(
				new NodeTypeTreeFactoryImpl(editingService.getEditingDomain()),
				new NodeTypeTreeStructureAdvisorImpl());
		nodeTypeTreeViewer.setContentProvider(cp);
		IObservableSet set = cp.getKnownElements();

		List<IObservableMap> mapList = Lists.newArrayList();

		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				LibraryPackage.Literals.NODE_TYPE__NAME).observeDetail(set));

		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				LibraryPackage.Literals.NODE_TYPE__FUNCTIONS)
				.observeDetail(set));

		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS).observeDetail(
				set));

		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS).observeDetail(
				set));

		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				LibraryPackage.Literals.FUNCTION__FUNCTIONS).observeDetail(set));

		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				LibraryPackage.Literals.COMPONENT__NAME).observeDetail(set));

		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_CODE)
				.observeDetail(set));

		IObservableMap[] map = new IObservableMap[mapList.size()];
		mapList.toArray(map);
		
		
		ntTreeLabelProvider = new NodeTypeTreeLabelProvider(stateModel);
		ntTreeLabelProvider.registerMap(map);

		nodeTypeTreeViewer.setLabelProvider(ntTreeLabelProvider);
		IEMFListProperty projects = EMFEditProperties.resource(editingService
				.getEditingDomain());

		IObservableList nodeTypeObservableList = projects
				.observe(nodeTypeResource);
		// obm.addObservable(nodeTypeObservableList);
		nodeTypeTreeViewer.setInput(nodeTypeObservableList);

		return bindingContext;
	}

	class NodeTypeTreeStructureAdvisorImpl extends TreeStructureAdvisor {
		@Override
		public Object getParent(Object element) {
			if (element instanceof EObject) {
				EObject eo = (EObject) element;
				if (eo.eContainer() != null) {
					return eo.eContainer();
				}
			}
			return null;
		}

		@Override
		public Boolean hasChildren(Object element) {

			// Important to return null if no children, otherwise child
			// observables won;t be created.
			if (element instanceof NodeType) {
				NodeType nt = (NodeType) element;
				if (nt.getFunctions().size() > 0
						|| nt.getEquipments().size() > 0) {
					return Boolean.TRUE;
				} else {
					return null;
				}
			} else if (element instanceof Function) {
				if (((Function) element).getFunctions().size() > 0) {
					return Boolean.TRUE;
				} else {
					return null;
				}
			} else if (element instanceof Equipment) {
				if (((Equipment) element).getEquipments().size() > 0) {
					return Boolean.TRUE;
				} else {
					return null;
				}
			}
			// TMNL 04082011, don't show resources in tree.
			// if (element instanceof Component
			// && ((Component) element).getResourceRefs().size() > 0) {
			// return Boolean.TRUE;
			// }
			return super.hasChildren(element);
		}
	}

	Composite currentDetails;
	private ImageHyperlink hypLnkNewNodeType;

	private void handleDetailsSelection(Object o) {

		if (currentDetails != null && !currentDetails.isDisposed()) {
			this.saveDetailsState(currentDetails);
			currentDetails.dispose();
		}

		if (o instanceof Function) {
			NewEditFunction screen = null;
			screen = new NewEditFunction(this.cmpDetails, SWT.NONE,
					editingService);
			screen.setScreenService(screenService);
			screen.setOperation(getOperation());
			screen.setParentScreen(this);
			screen.injectData(null, o);
			this.currentDetails = screen;
			this.restoreDetailsState(currentDetails);
			sashForm.layout(true, true);
		}
		if (o instanceof Equipment) {

			NewEditEquipment screen = null;
			screen = new NewEditEquipment(this.cmpDetails, SWT.NONE,
					editingService);
			screen.setScreenService(screenService);
			screen.setOperation(getOperation());
			screen.setParentScreen(this);
			screen.injectData(null, o);
			this.currentDetails = screen;
			this.restoreDetailsState(currentDetails);
			sashForm.layout(true, true);

		}
		if (o instanceof NodeType) {
			NewEditNodeType nnt = new NewEditNodeType(this.cmpDetails,
					SWT.NONE, editingService);
			nnt.setOperation(getOperation());
			nnt.setScreenService(screenService);
			nnt.setParentScreen(this);
			nnt.injectData(null, o);
			this.currentDetails = nnt;
			this.restoreDetailsState(currentDetails);
			sashForm.layout(true, true);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		// http://work.netxforge.com/issues/320
		return nodeTypeTreeViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#isValid()
	 */
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return this.frmNodeTypes;
	}

	@Override
	public String getScreenName() {
		return "NE Types";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#saveState(org.eclipse
	 * .ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {

		// sash state vertical.
		mementoUtils.rememberStructuredViewerSelection(memento,
				nodeTypeTreeViewer, MEM_KEY_NODETYPES_SELECTION_TREE);

	}

	public void saveDetailsState(Composite currentDetails) {
		IMemento memento = this.getScreenService().getAbsViewPart()
				.getMemento();
		String key = keyForComposite(currentDetails);
		if (key != null) {
			mementoUtils.rememberSectionsInComposite(memento, currentDetails,
					key);
		}
	}

	/**
	 * Find the IMemento Key for a Composite, to remember UI Details state.
	 * 
	 * @param currentDetails
	 * @return
	 */
	private String keyForComposite(Composite currentDetails) {
		String key = null;

		if (currentDetails instanceof NewEditNodeType) {
			key = MEM_KEY_DETAILS_NODE_TYPE;
		} else if (currentDetails instanceof NewEditFunction) {
			key = MEM_KEY_DETAILS_FUNCTION;
		} else if (currentDetails instanceof NewEditEquipment) {
			key = MEM_KEY_DETAILS_EQUIPMENT;
		}
		return key;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#init(org.eclipse.
	 * ui.IMemento)
	 */
	@Override
	public void restoreState(IMemento memento) {
		if (memento != null) {
			mementoUtils.retrieveStructuredViewerSelection(memento,
					nodeTypeTreeViewer, MEM_KEY_NODETYPES_SELECTION_TREE,
					this.nodeTypeResource.cdoView());
		}

	}

	public void restoreDetailsState(Composite currentDetails) {
		IMemento memento = this.getScreenService().getAbsViewPart()
				.getMemento();

		String key = keyForComposite(currentDetails);
		if (key != null) {
			mementoUtils.retrieveSectionsInComposite(memento, currentDetails,
					key);
		}
	}
}
