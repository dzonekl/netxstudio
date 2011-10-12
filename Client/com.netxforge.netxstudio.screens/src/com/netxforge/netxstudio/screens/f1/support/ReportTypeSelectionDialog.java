package com.netxforge.netxstudio.screens.f1.support;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.NodeTypeFilterDialog;
import com.netxforge.netxstudio.screens.editing.IEditingService;

public class ReportTypeSelectionDialog extends TitleAreaDialog {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtNodeType;
	private IEditingService editingService;
	private Button btnReportAllElements;
	private Button btnReportOnANodeType;
	
	private NodeType nt = null;
	

	private static final int REPORT_ON_SERVICE = 100;
	private static final int REPORT_ON_NODETYPE = 101;
	
	/**
	 * The current selection. 
	 */
	private int reportSelection = REPORT_ON_SERVICE;
	private Button btnSelect; 

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ReportTypeSelectionDialog(Shell parentShell, IEditingService editingService) {
		super(parentShell);
		this.editingService = editingService;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Report type");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Section sctnNewSection = formToolkit.createSection(container, Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Report type Selection");
		
		Composite composite = formToolkit.createComposite(sctnNewSection, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		sctnNewSection.setClient(composite);
		composite.setLayout(new GridLayout(3, false));
		
		btnReportAllElements = formToolkit.createButton(composite, "Report all Elements in Service", SWT.RADIO);
		btnReportAllElements.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setReportSelection(REPORT_ON_SERVICE);
				btnSelect.setEnabled(false);
			}
		});
		btnReportAllElements.setSelection(true);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		btnReportOnANodeType = formToolkit.createButton(composite, "Report on a Network Element Type", SWT.RADIO);
		btnReportOnANodeType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setReportSelection(REPORT_ON_NODETYPE);
				btnSelect.setEnabled(true);
			}
		});
		
		txtNodeType = formToolkit.createText(composite, "New Text", SWT.READ_ONLY);
		txtNodeType.setText("");
		txtNodeType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		btnSelect = formToolkit.createButton(composite, "Select...", SWT.NONE);
		btnSelect.addSelectionListener(new SelectionAdapter() {
			

			@Override
			public void widgetSelected(SelectionEvent e) {

				// Select reporting for a nodetype or all types ? 

				Resource nodeTypeResource = editingService
						.getData(LibraryPackage.Literals.NODE_TYPE);
				NodeTypeFilterDialog dialog = new NodeTypeFilterDialog(
						ReportTypeSelectionDialog.this.getParentShell(), nodeTypeResource);
				if (dialog.open() == IDialogConstants.CANCEL_ID) {
					return;
				}
				
				nt = (NodeType) dialog.getFirstResult();
				txtNodeType.setText(nt.getName());
				
			}
		});
		
		return area;
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
		return new Point(450, 300);
	}

	public int getReportSelection() {
		return reportSelection;
	}
	
	public NodeType getNodeType() {
		return nt;
	}

	private void setReportSelection(int reportSelection) {
		this.reportSelection = reportSelection;
	}

}
