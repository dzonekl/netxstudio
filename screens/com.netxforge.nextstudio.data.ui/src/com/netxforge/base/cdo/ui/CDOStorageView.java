/*******************************************************************************
 * Copyright (c) 4 mrt. 2014 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.base.cdo.ui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.ViewPart;

import com.google.inject.Inject;
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.data.cdo.IClientCDODataProvider;

/**
 * A view for the CDO System. Access the repository and get running sessions,
 * transactions and views.
 * 
 * @author Christophe Bouhier
 * 
 */
public class CDOStorageView extends ViewPart {

	@Inject
	IClientCDODataProvider clientDataProvider;

	private TreeViewer treeViewer;

	public CDOStorageView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());

		treeViewer = new TreeViewer(parent, SWT.NONE);

		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		{
			TreeViewerColumn tblViewerC = new TreeViewerColumn(treeViewer,
					SWT.LEFT);

			TreeColumn tblclmnName = tblViewerC.getColumn();
			tblclmnName.setWidth(200);
			tblclmnName.setText("Provider");
		}
		{
			TreeViewerColumn tblViewerC = new TreeViewerColumn(treeViewer,
					SWT.LEFT);

			TreeColumn tblclmnName = tblViewerC.getColumn();
			tblclmnName.setWidth(200);
			tblclmnName.setText("Session (S)");

		}
		{
			TreeViewerColumn tblViewerC = new TreeViewerColumn(treeViewer,
					SWT.LEFT);

			TreeColumn tblclmnName = tblViewerC.getColumn();
			tblclmnName.setWidth(150);
			tblclmnName.setText("Transaction (S)");
		}

		// {
		// TableViewerColumn tblViewerC = new TableViewerColumn(tableViewer,
		// SWT.LEFT);
		// TableColumn tblclmnName = tblViewerC.getColumn();
		// tblclmnName.setWidth(150);
		// tblclmnName.setText("View)");
		// }

		initDataBindings();
	}

	@Override
	public void setFocus() {
	}

	public void initDataBindings() {

		@SuppressWarnings("unused")
		DataBindingContext ctx = new DataBindingContext();

		ObservableListTreeContentProvider listTreeContentProvider = new ObservableListTreeContentProvider(
				new CDOObservableFactory(), new CDODataTreeStructureAdvisor());

		treeViewer.setContentProvider(listTreeContentProvider);

		IObservableSet knownElements = listTreeContentProvider
				.getKnownElements();

		IObservableMap[] labelMaps = new IObservableMap[2];
		
		labelMaps[0] = BeanProperties.value(ICDOData.class, "session")
				.observeDetail(knownElements);

		labelMaps[1] = BeanProperties.value(ICDOData.class, "transaction")
				.observeDetail(knownElements);

		ILabelProvider labelProvider = new ObservableMapLabelProvider(labelMaps) {

			@Override
			public String getColumnText(Object element, int columnIndex) {
				if (element instanceof ICDOData) {
					ICDOData data = (ICDOData) element;
					switch (columnIndex) {
					case 0: {
						return "Data instance: " + data.hashCode();
					}
					case 1: {
						if (data.hasSession()) {
							return data.getSession().toString();
						} else {
							return "Session not set";
						}
					}
					case 2: {
						if (data.hasTransaction()) {
							return data.getTransaction().toString();
						} else {
							return "Transaction not set";
						}
					}
					}
				}
				return super.getColumnText(element, columnIndex);
			}
		};

		treeViewer.setLabelProvider(labelProvider);

		// Use the concrete class, to make sure we have the bean methods.
		IObservableList dataObservable = BeanProperties.list(
				IClientCDODataProvider.class, "CDODataCollection").observe(
				clientDataProvider);

		dataObservable.addChangeListener(new IChangeListener() {
			@Override
			public void handleChange(ChangeEvent event) {
				System.out.println("Change on our observable" + event);
			}

		});

		treeViewer.setInput(dataObservable);
	}

	public class CDODataTreeStructureAdvisor extends TreeStructureAdvisor {
		@Override
		public Object getParent(Object element) {

			return null;
		}

		@Override
		public Boolean hasChildren(Object element) {

			if (element instanceof ICDOData) {
				ICDOData data = (ICDOData) element;
				// Make sure we don't open a session by observing it.
				if (data.hasSession()) {
					if (data.getSession().getViews().length > 0) {
						return true;
					}
				}
			}
			return super.hasChildren(element);
		}
	}

	public class CDOObservableFactory implements IObservableFactory {

		@Override
		public IObservable createObservable(Object target) {
			IObservable ol = null;
			if (target instanceof IObservableList) {
				ol = (IObservable) target;
			} else if (target instanceof CDOSession) {
				// Observe the Views in the CDOSession.
				// These objects are not
			}
			return ol;
		}

	}

}
