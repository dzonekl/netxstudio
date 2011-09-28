package com.netxforge.netxstudio.screens.f4.support;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class MappingTypeDialog extends Dialog {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	public static final int MAPPING_XLS = 0;
	public static final int MAPPING_CSV = 1;
	public static final int MAPPING_RDBMS = 2;
	
	
	private int selection = MAPPING_XLS;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public MappingTypeDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = formToolkit.createComposite(container, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		composite.setLayout(new FormLayout());
		
		Section sctnNewSection = formToolkit.createSection(composite, Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.top = new FormAttachment(0, 10);
		fd_sctnNewSection.left = new FormAttachment(0, 10);
		fd_sctnNewSection.bottom = new FormAttachment(0, 135);
		fd_sctnNewSection.right = new FormAttachment(0, 395);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Mapping type");
		
		Composite composite_1 = formToolkit.createComposite(sctnNewSection, SWT.NONE);
		formToolkit.paintBordersFor(composite_1);
		sctnNewSection.setClient(composite_1);
		composite_1.setLayout(new GridLayout(1, false));
		
		Button btnXlsMapping = formToolkit.createButton(composite_1, "XLS Mapping", SWT.RADIO);
		btnXlsMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selection = MAPPING_XLS;
			}
		});
		
		
		
		
		Button btnCsvMapping = formToolkit.createButton(composite_1, "CSV Mapping", SWT.RADIO);
		btnCsvMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selection = MAPPING_CSV;
			}
		});
		
		Button btnRdbmsMapping = formToolkit.createButton(composite_1, "RDBMS Mapping", SWT.RADIO);
		btnRdbmsMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selection = MAPPING_RDBMS;
			}
		});
		
		btnXlsMapping.setSelection(true);

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(405, 217);
	}
	
	public int getSelection(){
		return selection;
	}
	
	
}
