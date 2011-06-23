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
package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public class JobRuns extends AbstractScreen implements IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	
	public JobRuns(Composite parent, int style) {
		super(parent, style);
		
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmJobRuns = toolkit.createForm(this);
		frmJobRuns.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmJobRuns);

		frmJobRuns.setText("Job: \"Job name\"");
		frmJobRuns.getBody().setLayout(new FormLayout());
		
		Section sctnInfo = toolkit.createSection(frmJobRuns.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(frmJobRuns.getBody(), 12);
		fd_sctnInfo.bottom = new FormAttachment(100, -12);
		fd_sctnInfo.right = new FormAttachment(100, -12);
		fd_sctnInfo.left = new FormAttachment(0, 12);
		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Runs");

		Composite composite_1 = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnInfo.setClient(composite_1);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.horizontalSpacing = 8;
		composite_1.setLayout(gl_composite_1);
		
		tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(97);
		tblclmnNewColumn.setText("Date / Time");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnObject = tableViewerColumn_1.getColumn();
		tblclmnObject.setWidth(116);
		tblclmnObject.setText("Object");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnActivity = tableViewerColumn_2.getColumn();
		tblclmnActivity.setWidth(114);
		tblclmnActivity.setText("Activity");
		
		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnData = tableViewerColumn_3.getColumn();
		tblclmnData.setWidth(100);
		tblclmnData.setText("Data");
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#getOperation()
	 */
	public int getOperation() {
		return Screens.OPERATION_READ_ONLY;
	}
	
	private Resource commitEntries; 
	private TableViewer tableViewer;
	private Form frmJobRuns;
	
	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataScreenInjection#injectData(java.lang.Object, java.lang.Object)
	 */
	public void injectData(Object owner, Object object) {
		if(object instanceof Person){
			Person user = (Person)object;
			String userID = user.getLogin();
			this.getScreenForm().setText("User: " + userID);
			commitEntries = this.editingService.getDataService().getProvider().getCommitInfoResource(userID);
			if(commitEntries != null){
				this.initDataBindings_();
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataScreenInjection#addData()
	 */
	public void addData() {
		throw new java.lang.UnsupportedOperationException();
	}
	
	
	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] { GenericsPackage.Literals.COMMIT_LOG_ENTRY__TIME_STAMP,
					GenericsPackage.Literals.COMMIT_LOG_ENTRY__OBJECT_ID,GenericsPackage.Literals.COMMIT_LOG_ENTRY__ACTION,
					GenericsPackage.Literals.COMMIT_LOG_ENTRY__CHANGE});
		tableViewer
				.setLabelProvider(new CommitObservableMapLabelProvider(observeMaps));
		
		// Cool, observer the whole resource. 
		IEMFListProperty l = EMFProperties.resource();
		tableViewer.setInput(l.observe(commitEntries));
		return bindingContext;
	}
	
	
	class CommitObservableMapLabelProvider extends ObservableMapLabelProvider{

		public CommitObservableMapLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		public CommitObservableMapLabelProvider(IObservableMap attributeMap) {
			super(attributeMap);
		}

		@Override
		public String getText(Object element) {
			
			((EObject)element).eContainmentFeature();
			
			return super.getText(element);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			return super.getColumnText(element, columnIndex);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return this.getTableViewerWidget();
	}


	/* (non-Javadoc)
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
		return frmJobRuns;
	}
}