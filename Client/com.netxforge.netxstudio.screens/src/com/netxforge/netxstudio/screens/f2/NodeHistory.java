/*******************************************************************************
 * Copyright (c) May 16, 2011 NetXForge.
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

import java.util.Date;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.actions.CompareAction;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f2.model.WrappedNode;
import com.netxforge.netxstudio.screens.f2.model.WrappedNodeType;
import com.netxforge.netxstudio.screens.f2.parts.NodeEditPartsFactory;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class NodeHistory extends AbstractScreen implements IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;

	// CB 15-12-2011 disable for now.
	private ScrollingGraphicalViewer graphicalViewer;

	public NodeHistory(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {

				// CB 15-12-2011 disable for now.
				// disposeCDOViewForGraphicalViewer();
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}


	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// SashForm sashForm = new SashForm(this, SWT.VERTICAL);
		// sashForm.setSashWidth(5);
		// toolkit.adapt(sashForm);
		// toolkit.paintBordersFor(sashForm);

		frmHistory = toolkit.createForm(this);
		frmHistory.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmHistory);

		frmHistory.setText("Network Element Editing History: " + node.getNodeID());
		frmHistory.getBody().setLayout(new FormLayout());

		Section sctnInfo = toolkit.createSection(frmHistory.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(frmHistory.getBody(), 12);
		fd_sctnInfo.bottom = new FormAttachment(100, -12);
		fd_sctnInfo.right = new FormAttachment(100, -12);
		fd_sctnInfo.left = new FormAttachment(0, 12);
		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("History");

		Composite composite_1 = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnInfo.setClient(composite_1);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.horizontalSpacing = 8;
		composite_1.setLayout(gl_composite_1);

		tableViewerRevisions = new TableViewer(composite_1, SWT.BORDER
				| SWT.VIRTUAL | SWT.FULL_SELECTION | SWT.MULTI);
		tableViewerRevisions.setUseHashlookup(true);
		table = tableViewerRevisions.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// CB 15-12 -2011 Disable for now.
				@SuppressWarnings("unused")
				IStructuredSelection selection = (IStructuredSelection) tableViewerRevisions
						.getSelection();
				// updateSelection(selection.getFirstElement());
			}

		});
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				tableViewerRevisions, SWT.NONE);
		TableColumn tblclmnVersion = tableViewerColumn_4.getColumn();
		tblclmnVersion.setWidth(100);
		tblclmnVersion.setText("Version");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewerRevisions, SWT.NONE);
		TableColumn tblclmnDateTime = tableViewerColumn.getColumn();
		tblclmnDateTime.setWidth(150);
		tblclmnDateTime.setText("Date / Time");

		// CB 15-12-2011 Disable the graphical viewer, as the layout is way to
		// slow for large structures.
		// Composite structureComposite = new Composite(sashForm, SWT.NONE);
		// toolkit.adapt(structureComposite);
		// toolkit.paintBordersFor(structureComposite);
		// buildStructure(structureComposite);
		//
		// sashForm.setWeights(new int[] { 1, 1 });
	}

	// CB 15-12-2011 disabled for now.
	@SuppressWarnings("unused")
	private void updateSelection(Object firstElement) {

		// Clear the previous session.
		disposeCDOViewForGraphicalViewer();

		if (firstElement instanceof CDORevision) {
			CDORevision rev = (CDORevision) firstElement;
			CDOObject cdoObject = null;
			cdoObject = modelUtils.cdoObject(node, rev);
			if (cdoObject instanceof Node) {
				Node n = (Node) cdoObject;
				graphicalViewer.setContents(new WrappedNode(n));
				return;
			}

		}
		graphicalViewer.setContents(null);
	}

	private void disposeCDOViewForGraphicalViewer() {
		if (graphicalViewer.getContents() != null) {
			Object model = graphicalViewer.getContents().getModel();
			if (model instanceof WrappedNodeType) {
				NodeType nodeType = ((WrappedNodeType) model).getNodeType();
				if (nodeType.eContainer() != null
						&& nodeType.eContainer() instanceof Node) {
					Node n = (Node) nodeType.eContainer();
					n.cdoView().close();

				}
			}
		}
	}

	@SuppressWarnings("unused")
	private void buildStructure(Composite structureComposite) {
		FillLayout fl = new FillLayout(SWT.HORIZONTAL);
		fl.marginHeight = 20;
		fl.marginWidth = 20;
		structureComposite.setLayout(fl);

		ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart();
		graphicalViewer = new ScrollingGraphicalViewer();
		graphicalViewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, true);
		graphicalViewer.createControl(structureComposite);
		graphicalViewer.getControl().setBackground(
				ColorConstants.listBackground);
		graphicalViewer.setRootEditPart(rootEditPart);
		graphicalViewer.setEditPartFactory(new NodeEditPartsFactory());

		rootEditPart.refresh();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.selector.IScreen#getOperation()
	 */
	public int getOperation() {
		return ScreenUtil.OPERATION_READ_ONLY;
	}

	private TableViewer tableViewerRevisions;
	private Form frmHistory;
	private Node node;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataScreenInjection#injectData(java.lang
	 * .Object, java.lang.Object)
	 */
	public void injectData(Object owner, Object object) {
		if (object instanceof Node) {
			node = (Node) object;
			buildUI();
		} else {
			throw new java.lang.IllegalArgumentException();
		}
		this.initDataBindings_();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataScreenInjection#addData()
	 */
	public void addData() {
		throw new java.lang.UnsupportedOperationException();
	}

	public EMFDataBindingContext initDataBindings_() {

		tableViewerRevisions.setContentProvider(new ArrayContentProvider());
		tableViewerRevisions
				.setLabelProvider(new NodeHistoryLabelProvider(node));
		List<CDORevision> newArrayList = Lists.newArrayList();
		newArrayList.addAll(Lists.newArrayList(modelUtils.cdoRevisions(node)));
		tableViewerRevisions.setInput(newArrayList);
		return null;
	}

	@SuppressWarnings("unused")
	private void historicalNodes(List<HistoricNode> histNodes) {
		String historicalResourceName = editingService
				.resolveHistoricalResourceName(node);

		if (historicalResourceName != null) {
			URI uri = URI.createURI(historicalResourceName);
			// Do we have an existing resource for this historical node.
			// If not we add at least the node.

			if (editingService.getDataService().getProvider().hasResource(uri)) {

				Resource historyResource = editingService
						.getDataService()
						.getProvider()
						.getResource(
								editingService.getEditingDomain()
										.getResourceSet(), uri);

				int entryCount = historyResource.getContents().size();

				// Don't add the current node, it will already be in the
				// resource (If saved).
				// histNodes.add(new HistoricNode(entryCount, node));
				// entryCount--;

				// We need the resource list backwards.
				for (EObject object : Iterables.reverse(historyResource
						.getContents())) {
					histNodes.add(new HistoricNode(entryCount, (Node) object));
					entryCount--;
				}
			} else {
				histNodes.add(new HistoricNode(1, node));
			}

		}
	}

	/**
	 * Holds the Node and a revision for presentation.
	 * 
	 * @author dzonekl
	 * @deprecated
	 */
	class HistoricNode {

		int revision;
		Node node;

		public HistoricNode(int revision, Node nt) {
			super();
			this.revision = revision;
			this.node = nt;
		}

		public int getRevision() {
			return revision;
		}

		public void setRevision(int revision) {
			this.revision = revision;
		}

		public Node getNode() {
			return node;
		}

		public void setNode(Node nt) {
			this.node = nt;
		}

	}

	class NodeHistoryLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		Node current;

		public NodeHistoryLabelProvider(Node current) {
			super();
			this.current = current;
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {

			if (element instanceof HistoricNode) {

				switch (columnIndex) {
				case 0: {
					String revision = new Integer(
							((HistoricNode) element).getRevision()).toString();
					if (((HistoricNode) element).getNode().equals(current)) {
						revision += " (current)";
					}
					return revision;
				}
				case 1: {
					Date d = new Date(((HistoricNode) element).getNode()
							.cdoRevision().getTimeStamp());
					return modelUtils.date(d) + " @ " + modelUtils.time(d);
				}
				case 2: {
					Node nt = ((HistoricNode) element).getNode();
					return nt.getNodeID();
				}
				}
			}

			if (element instanceof CDORevision) {
				CDORevision rev = (CDORevision) element;
				switch (columnIndex) {
				case 0: {
					return new Integer(rev.getVersion()).toString();
				}
				case 1: {
					Date d = new Date(rev.getTimeStamp());
					return modelUtils.date(d) + " @ " + modelUtils.time(d);
				}
				case 2: {
					return "perhaps remove this.";
				}
				}
			}

			return null;
		}

	}
	
	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		// Lazy init actions. 
		if(actions.isEmpty()){
			actions.add(new CompareAction(modelUtils, "Compare...") );
		}
		return actions.toArray(new IAction[actions.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return this.getTableViewerWidget();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#isValid()
	 */
	public boolean isValid() {
		return true;
	}

	public TableViewer getTableViewerWidget() {
		return tableViewerRevisions;
	}

	@Override
	public Form getScreenForm() {
		return frmHistory;
	}

	public void disposeData() {
		// N/A
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

	public String getScreenName() {
		return "Network Element Editing History";
	}
}
