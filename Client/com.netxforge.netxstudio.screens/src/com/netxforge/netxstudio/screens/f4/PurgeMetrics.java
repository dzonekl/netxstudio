package com.netxforge.netxstudio.screens.f4;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;

public class PurgeMetrics extends AbstractScreen implements IDataScreenInjection{

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	@SuppressWarnings("unused")
	public PurgeMetrics(Composite parent, int style) {
		super(parent, SWT.BORDER);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Form frmNewForm = toolkit.createForm(this);
		frmNewForm.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewForm);
		frmNewForm.setText("Purge Collected Data");
		frmNewForm.getBody().setLayout(new FormLayout());
		
		Section sctnNewSection = toolkit.createSection(frmNewForm.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.top = new FormAttachment(0, 10);
		fd_sctnNewSection.right = new FormAttachment(100, -12);
		fd_sctnNewSection.left = new FormAttachment(0, 12);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Metric Source");
		
		Composite composite_1 = toolkit.createComposite(sctnNewSection, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnNewSection.setClient(composite_1);
		composite_1.setLayout(new GridLayout(1, false));
		
		Hyperlink hprlnkNewHyperlink = toolkit.createHyperlink(composite_1, "Select from which Metric Sources to purge", SWT.NONE);
		toolkit.paintBordersFor(hprlnkNewHyperlink);
		
		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");
		
		Section sctnPeriod = toolkit.createSection(frmNewForm.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		fd_sctnNewSection.bottom = new FormAttachment(sctnPeriod, -12);
		FormData fd_sctnPeriod = new FormData();
		fd_sctnPeriod.left = new FormAttachment(0, 12);
		fd_sctnPeriod.right = new FormAttachment(100, -12);
		fd_sctnPeriod.bottom = new FormAttachment(100, -12);
		fd_sctnPeriod.top = new FormAttachment(0, 177);
		sctnPeriod.setLayoutData(fd_sctnPeriod);
		toolkit.paintBordersFor(sctnPeriod);
		sctnPeriod.setText("Period");
		
		Composite composite_2 = toolkit.createComposite(sctnPeriod, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnPeriod.setClient(composite_2);
		composite_2.setLayout(new GridLayout(2, false));
		
		Label lblPurgeFromDate = toolkit.createLabel(composite_2, "Purge from date:", SWT.NONE);
		
		DateChooserCombo dateChooserCombo = new DateChooserCombo(composite_2, SWT.BORDER | SWT.FLAT);
		GridData gd_dateChooserCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateChooserCombo.heightHint = 19;
		dateChooserCombo.setLayoutData(gd_dateChooserCombo);
		toolkit.adapt(dateChooserCombo);
		toolkit.paintBordersFor(dateChooserCombo);
		
		Label lblToDate = toolkit.createLabel(composite_2, "To date:", SWT.NONE);
		lblToDate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		DateChooserCombo dateChooserCombo_1 = new DateChooserCombo(composite_2, SWT.BORDER | SWT.FLAT);
		GridData gd_dateChooserCombo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateChooserCombo_1.heightHint = 19;
		dateChooserCombo_1.setLayoutData(gd_dateChooserCombo_1);
		toolkit.adapt(dateChooserCombo_1);
		toolkit.paintBordersFor(dateChooserCombo_1);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Button btnTestPurging = toolkit.createButton(composite_2, "Test purging", SWT.NONE);
		new Label(composite_2, SWT.NONE);

	}

	public EMFDataBindingContext initDataBindings_() {
		return null;
	}

	public void disposeData() {
		
	}

	public void injectData(Object owner, Object object) {
		throw new UnsupportedOperationException();
		
	}

	public void addData() {
		throw new UnsupportedOperationException();
	}

	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return null;
	}
}
