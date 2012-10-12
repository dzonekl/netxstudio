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

import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.actions.CompareAction;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class NodeTypeHistory extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;

	public NodeTypeHistory(Composite parent, int style) {
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

		frmNTHistory = toolkit.createForm(this);
		frmNTHistory.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNTHistory);

		frmNTHistory.setText("Network Element Type editing History:" + nodeType.getName());
		frmNTHistory.getBody().setLayout(new FormLayout());

		Section sctnInfo = toolkit.createSection(frmNTHistory.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(frmNTHistory.getBody(), 12);
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

		tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.VIRTUAL
				| SWT.FULL_SELECTION | SWT.MULTI);
		tableViewer.setUseHashlookup(true);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnVersion = tableViewerColumn_4.getColumn();
		tblclmnVersion.setWidth(100);
		tblclmnVersion.setText("Version");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnDateTime = tableViewerColumn.getColumn();
		tblclmnDateTime.setWidth(150);
		tblclmnDateTime.setText("Date / Time");
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

	private TableViewer tableViewer;
	private Form frmNTHistory;
	private NodeType nodeType;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataScreenInjection#injectData(java.lang
	 * .Object, java.lang.Object)
	 */
	public void injectData(Object owner, Object object) {
		if (object instanceof NodeType) {
			nodeType = (NodeType) object;
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

		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer
				.setLabelProvider(new NodeTypeHistoryLabelProvider(nodeType));
		tableViewer.setInput(Lists.newArrayList(modelUtils.cdoRevisions(nodeType)));
		
//		List<HistoricNodeType> histNodeTypes = Lists.newArrayList();
		// use for non CDORevision supporting. 
				// how to check supported features? 
//		historicalNodeTypes(histNodeTypes);
//		tableViewer.setInput(histNodeTypes.toArray());
		return null;
	}

	@SuppressWarnings("unused")
	private void historicalNodeTypes(List<HistoricNodeType> histNodeTypes) {
		String historicalResourceName = editingService
				.resolveHistoricalResourceName(nodeType);

		
		if (historicalResourceName != null) {
			URI uri = URI.createURI(historicalResourceName);

			if (editingService.getDataService().getProvider().hasResource(uri)) {

				Resource historyResource = editingService
						.getDataService()
						.getProvider()
						.getResource(
								editingService.getEditingDomain()
										.getResourceSet(), uri);
				int entryCount = historyResource.getContents().size();
				// We need the resource list backwards.
				for (EObject object : Iterables.reverse(historyResource
						.getContents())) {
					histNodeTypes.add(new HistoricNodeType(entryCount,
							(NodeType) object));
					entryCount--;
				}
			} else {
				histNodeTypes.add(new HistoricNodeType(1, nodeType));
			}
		}
	}

	/**
	 * Holds the NodeType and a revision for presentation.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class HistoricNodeType {

		int revision;
		NodeType nt;

		public HistoricNodeType(int revision, NodeType nt) {
			super();
			this.revision = revision;
			this.nt = nt;
		}

		public int getRevision() {
			return revision;
		}

		public void setRevision(int revision) {
			this.revision = revision;
		}

		public NodeType getNt() {
			return nt;
		}

		public void setNt(NodeType nt) {
			this.nt = nt;
		}

	}

	class NodeTypeHistoryLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		NodeType current;

		public NodeTypeHistoryLabelProvider(NodeType current) {
			super();
			this.current = current;
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {

			if (element instanceof HistoricNodeType) {
				HistoricNodeType histNodeType = (HistoricNodeType) element;
				switch (columnIndex) {
				case 0: {
					String revision = new Integer(histNodeType.getRevision())
							.toString();
					if (histNodeType.getNt().equals(current)) {
						revision += " (current)";
					}
					return revision;
				}
				case 1: {

					Date d = new Date(histNodeType.getNt().cdoRevision()
							.getTimeStamp());
					return modelUtils.date(d) + " @ " + modelUtils.time(d);
				}
				case 2: {
					NodeType nt = histNodeType.getNt();
					return nt.getName();
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
				}
			}
			
			return null;
		}

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
		return tableViewer;
	}

	public Form getScreenForm() {
		return frmNTHistory;
	}

	public void disposeData() {
		// N/A
	}

	public String getScreenName() {
		return "Network Element Type editing sHistory";
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

	
}	
