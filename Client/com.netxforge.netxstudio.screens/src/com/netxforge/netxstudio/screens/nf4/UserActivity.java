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
package com.netxforge.netxstudio.screens.nf4;

import java.util.Date;

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
import org.eclipse.wb.swt.TableViewerColumnSorter;

import com.netxforge.netxstudio.generics.CommitLogEntry;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class UserActivity extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;

	public UserActivity(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);

	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmActivities = toolkit.createForm(this);
		frmActivities.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmActivities);

		frmActivities.setText("");
		frmActivities.getBody().setLayout(new FormLayout());

		Section sctnInfo = toolkit.createSection(frmActivities.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(frmActivities.getBody(), 12);
		fd_sctnInfo.bottom = new FormAttachment(100, -12);
		fd_sctnInfo.right = new FormAttachment(100, -12);
		fd_sctnInfo.left = new FormAttachment(0, 12);
		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Activities");

		Composite composite_1 = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnInfo.setClient(composite_1);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.horizontalSpacing = 8;
		composite_1.setLayout(gl_composite_1);

		tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.VIRTUAL
				| SWT.FULL_SELECTION);
		tableViewer.setUseHashlookup(true);
		tableViewer.setComparer(new CDOElementComparer());
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(150);
		tblclmnNewColumn.setText("Date / Time");

		TableViewerColumnSorter dateTimeColumnSorter = new TableViewerColumnSorter(tableViewerColumn) {
			protected int doCompare(Viewer viewer, Object e1, Object e2) {
				if (e1 instanceof CommitLogEntry
						&& e2 instanceof CommitLogEntry) {

					CommitLogEntry re1 = (CommitLogEntry) e1;
					CommitLogEntry re2 = (CommitLogEntry) e2;

					if (re1.eIsSet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__TIME_STAMP)
							&& re2.eIsSet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__TIME_STAMP))

						return Long.valueOf(
								re2.getTimeStamp().toGregorianCalendar()
										.getTimeInMillis()).compareTo(
								Long.valueOf(re1.getTimeStamp()
										.toGregorianCalendar()
										.getTimeInMillis()));
				}
				return 0;
			}

		};
		dateTimeColumnSorter.setSorter(TableViewerColumnSorter.ASC);

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnObject = tableViewerColumn_1.getColumn();
		tblclmnObject.setWidth(200);
		tblclmnObject.setText("Object");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnActivity = tableViewerColumn_2.getColumn();
		tblclmnActivity.setWidth(114);
		tblclmnActivity.setText("Activity");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnData = tableViewerColumn_3.getColumn();
		tblclmnData.setWidth(100);
		tblclmnData.setText("Data");
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

	private Resource commitEntries;
	private TableViewer tableViewer;
	private Form frmActivities;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataScreenInjection#injectData(java.lang
	 * .Object, java.lang.Object)
	 */
	public void injectData(Object owner, Object object) {
		if (object instanceof Person) {
			Person user = (Person) object;
			String userID = user.getLogin();
			buildUI();
			getScreenForm().setText("User: " + userID);
			commitEntries = this.editingService.getDataService().getProvider()
					.getCommitInfoResource(userID);
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

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						GenericsPackage.Literals.COMMIT_LOG_ENTRY__TIME_STAMP,
						GenericsPackage.Literals.COMMIT_LOG_ENTRY__OBJECT_ID,
						GenericsPackage.Literals.COMMIT_LOG_ENTRY__ACTION,
						GenericsPackage.Literals.COMMIT_LOG_ENTRY__CHANGE });
		tableViewer.setLabelProvider(new CommitObservableMapLabelProvider(
				observeMaps));

		// Cool, observer the whole resource.
		IEMFListProperty l = EMFProperties.resource();
		tableViewer.setInput(l.observe(commitEntries));
		return bindingContext;
	}

	class CommitObservableMapLabelProvider extends ObservableMapLabelProvider {

		public CommitObservableMapLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		public CommitObservableMapLabelProvider(IObservableMap attributeMap) {
			super(attributeMap);
		}

		@Override
		public String getText(Object element) {

			((EObject) element).eContainmentFeature();

			return super.getText(element);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof CommitLogEntry) {
				CommitLogEntry cle = (CommitLogEntry) element;
				switch (columnIndex) {
				case 0: {
					if (cle.eIsSet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__TIME_STAMP)) {
						Date d = modelUtils.fromXMLDate(cle.getTimeStamp());
						return modelUtils.date(d) + " @ " + modelUtils.time(d);
					}
				}
				case 1: {

				}
					break;

				}

			}

			return super.getColumnText(element, columnIndex);
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
		return frmActivities;
	}

	public String getScreenName() {
		return "Activity";
	}

}
