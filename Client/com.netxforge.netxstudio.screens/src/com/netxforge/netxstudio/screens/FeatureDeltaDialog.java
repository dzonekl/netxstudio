package com.netxforge.netxstudio.screens;

import java.util.Collection;

import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.common.model.ModelUtils;

public class FeatureDeltaDialog extends Dialog {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private Table table;
	private ModelUtils modelUtils;
	private CDORevisionDelta cdoRevisionDelta;
	private String deltaInfo;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public FeatureDeltaDialog(Shell parentShell, ModelUtils modelUtils) {
		super(parentShell);
		setShellStyle(SWT.TITLE);
		this.modelUtils = modelUtils;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));

		TableViewer tableViewer = new TableViewer(container, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		formToolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnFeature = tableViewerColumn_3.getColumn();
		tblclmnFeature.setWidth(150);
		tblclmnFeature.setText("Feature");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnAction = tableViewerColumn.getColumn();
		tblclmnAction.setWidth(100);
		tblclmnAction.setText("Activity");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewValue = tableViewerColumn_1.getColumn();
		tblclmnNewValue.setWidth(150);
		tblclmnNewValue.setText("New Value");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnOldValue = tableViewerColumn_2.getColumn();
		tblclmnOldValue.setWidth(150);
		tblclmnOldValue.setText("Old Value");
		tableViewer.setLabelProvider(new FeatureDeltaLabelProvider());
		tableViewer.setContentProvider(new IStructuredContentProvider() {

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}

			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof Collection<?>) {
					return ((Collection<?>) inputElement).toArray();
				}
				return null;
			}
		});

		if (cdoRevisionDelta != null) {
			tableViewer.setInput(cdoRevisionDelta.getFeatureDeltas());
		}

		return container;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Comparing: " + deltaInfo);
	}

	class FeatureDeltaLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {

			if (element instanceof CDOFeatureDelta) {
				return modelUtils.cdoFeatureDeltaIndex(
						(CDOFeatureDelta) element, columnIndex);
			}
			return null;
		}

	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		// createButton(parent, IDialogConstants.CANCEL_ID,
		// IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(600, 300);
	}

	public void setDelta(CDORevisionDelta delta) {
		this.cdoRevisionDelta = delta;
	}
	
	public void setDeltaInfo(String deltaInfo){
		this.deltaInfo = deltaInfo;
	}
	
	
}
