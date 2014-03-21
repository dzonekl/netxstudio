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
package com.netxforge.netxstudio.callflow.screens.protocols;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
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
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.callflow.screens.AbstractScreen;
import com.netxforge.netxstudio.protocols.Message;
import com.netxforge.netxstudio.protocols.Procedure;
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.protocols.ProtocolsFactory;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.screens.editing.base.IDataServiceInjection;
import com.netxforge.screens.editing.base.ScreenUtil;
import com.netxforge.screens.editing.base.filter.SearchFilter;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class Protocols extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;

	private Tree tree;

	private TreeViewer treeViewer;

	@SuppressWarnings("unused")
	private DataBindingContext bindingContext;
	private Form frmProtocols;
	private Resource protocolResource;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Protocols(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View: " : "Edit: ";
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmProtocols = toolkit.createForm(this);
		frmProtocols.setSeparatorVisible(true);

		toolkit.decorateFormHeading(frmProtocols);
		toolkit.paintBordersFor(frmProtocols);

		frmProtocols.setText(actionText + "Protocols");
		frmProtocols.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmProtocols.getBody(),
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 36;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmProtocols.getBody(), "New Text",
				SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);

		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				treeViewer.refresh();
				ViewerFilter[] filters = treeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
			}
		});

		// Conditional widget.
		if (!readonly) {
			ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
					frmProtocols.getBody(), SWT.NONE);
			mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {

					NewEditProtocol protocolScreen = new NewEditProtocol(
							screenService.getScreenContainer(), SWT.NONE);
					protocolScreen.setOperation(ScreenUtil.OPERATION_NEW);
					protocolScreen.setScreenService(screenService);
					Protocol protocol = ProtocolsFactory.eINSTANCE
							.createProtocol();
					protocolScreen.injectData(protocolResource, protocol);
					screenService.setActiveScreen(protocolScreen);

				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});
			mghprlnkNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
					false, false, 1, 1));
			mghprlnkNew.setImage(ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/ctool16/Protocol_E.png"));
			mghprlnkNew.setBounds(0, 0, 114, 17);
			toolkit.paintBordersFor(mghprlnkNew);
			mghprlnkNew.setText("New");

		}

		// new Label(frmProtocols.getBody(), SWT.NONE);

		treeViewer = new TreeViewer(frmProtocols.getBody(), SWT.BORDER
				| SWT.FULL_SELECTION | widgetStyle);
		tree = treeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(tree);

		TreeViewerColumn tableViewerColumn = new TreeViewerColumn(treeViewer,
				SWT.NONE);
		TreeColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(111);
		tblclmnName.setText("Name");

		TreeViewerColumn tableViewerColumn_1 = new TreeViewerColumn(treeViewer,
				SWT.NONE);
		TreeColumn tblclmnDescription = tableViewerColumn_1.getColumn();
		tblclmnDescription.setWidth(214);
		tblclmnDescription.setText("Description");

		TreeViewerColumn tableViewerColumn_2 = new TreeViewerColumn(treeViewer,
				SWT.NONE);
		TreeColumn tblclmnOSI = tableViewerColumn_2.getColumn();
		tblclmnOSI.setWidth(250);
		tblclmnOSI.setText("OSI");

		TreeViewerColumn tableViewerColumn_3 = new TreeViewerColumn(treeViewer,
				SWT.NONE);
		TreeColumn tblclmnSpecification = tableViewerColumn_3.getColumn();
		tblclmnSpecification.setWidth(100);
		tblclmnSpecification.setText("Specification");
		treeViewer.addFilter(new SearchFilter());
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditProtocolAction extends Action {

		public EditProtocolAction(String text) {
			super(text);
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = treeViewer.getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if (o instanceof Protocol) {
						NewEditProtocol protocolScreen = new NewEditProtocol(
								screenService.getScreenContainer(), SWT.NONE);
						protocolScreen.setOperation(getOperation());
						protocolScreen.setScreenService(screenService);
						protocolScreen.injectData(protocolResource, o);
						screenService.setActiveScreen(protocolScreen);
					} else if (o instanceof Procedure) {

					} else if (o instanceof Message) {
						
						
						
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataServiceInjection#injectData()
	 */
	public void injectData() {
		protocolResource = editingService
				.getData(ProtocolsPackage.Literals.PROTOCOL);
		buildUI();
		bindingContext = initDataBindings_();
	}

	public EMFDataBindingContext initDataBindings_() {

		// Bind a tree viewer to call flows and reference interfaces in the call
		// flow.
		ObservableListTreeContentProvider listContentProvider = new ObservableListTreeContentProvider(
				new ProtocolsTreeFactoryImpl(editingService.getEditingDomain()),
				new ProtocolsTreeStructureAdvisorImpl());

		treeViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						ProtocolsPackage.Literals.PROTOCOL__NAME,
						ProtocolsPackage.Literals.PROTOCOL__DESCRIPTION,
						ProtocolsPackage.Literals.PROTOCOL__OSI,
						ProtocolsPackage.Literals.PROTOCOL__SPECIFICATION });
		treeViewer
				.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		IEMFListProperty l = EMFEditProperties.resource(editingService
				.getEditingDomain());
		IObservableList protocolObservableList = l.observe(protocolResource);

		// obm.addObservable(toleranceObservableList);
		treeViewer.setInput(protocolObservableList);

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		return bindingContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return treeViewer;
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
		return this.frmProtocols;
	}

	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		// Lazy init actions.
		if (actions.isEmpty()) {
			String actionText = ScreenUtil.isReadOnlyOperation(getOperation()) ? "View"
					: "Edit";
			actions.add(new EditProtocolAction(actionText + "..."));
		}
		return actions.toArray(new IAction[actions.size()]);
	}

	@Override
	public String getScreenName() {
		return "Protocols";
	}

	class ProtocolsTreeFactoryImpl implements IObservableFactory {

		EditingDomain domain;

		private IEMFListProperty protocolObservableProperty = EMFEditProperties
				.list(domain, ProtocolsPackage.Literals.PROTOCOL__PROCEDURES);

		private IEMFListProperty procedureObservableProperty = EMFEditProperties
				.list(domain, ProtocolsPackage.Literals.PROCEDURE__MESSAGES);

		ProtocolsTreeFactoryImpl(EditingDomain domain) {
			this.domain = domain;
		}

		public IObservable createObservable(final Object target) {

			IObservable ol = null;
			if (target instanceof IObservableList) {
				ol = (IObservable) target;
			} else if (target instanceof Protocol) {
				ol = protocolObservableProperty.observe(target);
			} else if (target instanceof Procedure) {
				ol = procedureObservableProperty.observe(target);
			}
			return ol;
		}
	}

	class ProtocolsTreeStructureAdvisorImpl extends TreeStructureAdvisor {
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
			if (element instanceof Protocol) {
				return ((Protocol) element).getProcedures().size() > 0 ? Boolean.TRUE
						: null;
			} else if (element instanceof Procedure) {
				return ((Procedure) element).getMessages().size() > 0 ? Boolean.TRUE
						: null;
			}

			return false;
		}
	}

}
