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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

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
//		buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmNTHistory = toolkit.createForm(this);
		frmNTHistory.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNTHistory);

		frmNTHistory.setText("Network Element Type History");
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
				| SWT.FULL_SELECTION);
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

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnActivity = tableViewerColumn_2.getColumn();
		tblclmnActivity.setWidth(114);
		tblclmnActivity.setText("Data");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.selector.IScreen#getOperation()
	 */
	public int getOperation() {
		return Screens.OPERATION_READ_ONLY;
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
		tableViewer.setLabelProvider(new NodeTypeHistoryLabelProvider(nodeType));

		String historicalResourceName = editingService
				.resolveHistoricalResourceName(nodeType);
		if (historicalResourceName != null) {
			URI uri = URI.createURI(historicalResourceName);
			// Write a new version.
			Resource historyResource = editingService.getDataService()
					.getProvider().getResource(editingService.getEditingDomain().getResourceSet(), uri);
			
			// We should have as many entries as the revision count in the
			// Nodetype.
			int version = nodeType.cdoRevision().getVersion();
			List<HistoricNodeType> histNodeTypes = Lists.newArrayList();
			int entryCount = historyResource.getContents().size(); 
			if ( entryCount == ( version -1 ) ) {
				histNodeTypes.add(new HistoricNodeType(version, nodeType));
				version--;
				// We need the resource list backwards. 
				for (EObject object : Iterables.reverse(historyResource.getContents())) {
					histNodeTypes.add(new HistoricNodeType(version,
							(NodeType) object));
					version--;
				}
			}
			tableViewer.setInput(histNodeTypes.toArray());
		}
		return null;
	}
	
	
	/**
	 * Holds the NodeType and a revision for presentation. 
	 * 
	 * @author dzonekl
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
				
				
				switch (columnIndex) {
				case 0: {
					String revision = new Integer(
							((HistoricNodeType) element).getRevision())
							.toString();
					if(((HistoricNodeType) element).getNt().equals(current)){
						revision += " (current)";
					}
					return revision;
				}
				case 1: {
					Date d = new Date(((HistoricNodeType) element).getNt()
							.cdoRevision().getTimeStamp());
					return modelUtils.time(d) + " " + modelUtils.date(d);
				}
				case 2: {
					NodeType nt = ((HistoricNodeType) element).getNt();
					return nt.getName();
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

	@Override
	public Form getScreenForm() {
		return frmNTHistory;
	}

	public void disposeData() {
		// N/A
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}

}
