package com.netxforge.netxstudio.screens.f1.support;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.screens.dialog.NodeTypeFilterDialog;
import com.netxforge.netxstudio.screens.editing.CDOEditingService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.screens.editing.base.IEditingService;

public class ScheduledReportTypeSelectionPage extends WizardPage {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());

	private Text txtNodeType;
	private IEditingService editingService;
	private Button btnReportAllElements;
	private Button btnReportOnANodeType;

	private NodeType nt = null;

	private Object selectedObject = null;

	public static final int REPORT_ON_SERVICE = 100;
	public static final int REPORT_ON_SERVICE_NODETYPE = 101;

	public static final int REPORT_ON_OPERATOR = 102;
	public static final int REPORT_ON_OPERATOR_NODETYPE = 103;

	public static final int REPORT_ON_NODE = 104;

	/**
	 * The current selection.
	 */
	private int reportSelection;
	private Button btnSelect;
	@SuppressWarnings("unused")
	private Label lblYourCurrentSelection;
	private Text txtSelectedObject;
	private Composite composite_1;
	private Composite composite_2;
	private Label lblYouCan;

	/**
	 * Create the wizard.
	 */
	public ScheduledReportTypeSelectionPage(IEditingService editingService) {
		super("Scheduled Reporting");
		setTitle("Report Type");
		setDescription("Select the type of report depending on your selection");
		this.editingService = editingService;
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		composite_1 = formToolkit.createComposite(parent, SWT.NONE);
		formToolkit.paintBordersFor(composite_1);
		composite_1.setLayout(new GridLayout(3, false));

		setControl(composite_1);
		buildUI(composite_1);

	}

	private void buildUI(Composite composite) {

		if (selectedObject != null) {

			lblYourCurrentSelection = formToolkit.createLabel(composite,
					"With your current selection: ", SWT.NONE);

			txtSelectedObject = formToolkit.createText(composite, "New Text",
					SWT.READ_ONLY);

			txtSelectedObject.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
					true, false, 2, 1));

			String converted = new AdapterFactoryItemDelegator(
					CDOEditingService.getAdapterFactory()).getText(selectedObject);

			txtSelectedObject.setText(converted);

		} else {

			Label lblNoSelection = formToolkit
					.createLabel(
							composite,
							"No selection made. Please select an Operator, Service or Node ",
							SWT.NONE);
			lblNoSelection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
					true, false, 3, 1));
		}

		buildSelectionIsService(composite);
		buildSelectionIsOperator(composite);
		buildSelectionIsNode(composite);
	}

	private void buildYouCan() {
		composite_2 = formToolkit.createCompositeSeparator(composite_1);
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 3, 1);
		gd_composite_2.heightHint = 4;
		composite_2.setLayoutData(gd_composite_2);
		formToolkit.paintBordersFor(composite_2);

		lblYouCan = formToolkit.createLabel(composite_1, "You can:", SWT.NONE);
		GridData gd_lblYouCan = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblYouCan.heightHint = 18;
		lblYouCan.setLayoutData(gd_lblYouCan);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);
	}

	private void buildSelectionIsNode(Composite composite) {
		if (selectedObject instanceof Node) {
			// No specific options for node.
		}
	}

	private void buildSelectionIsOperator(Composite composite) {
		if (selectedObject instanceof Operator) {

			buildYouCan();

			btnReportAllElements = formToolkit.createButton(composite,
					"Report all Services in Operator", SWT.RADIO);
			btnReportAllElements.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					setReportSelection(REPORT_ON_OPERATOR);
					btnSelect.setEnabled(false);
					txtNodeType.setEnabled(false);
					getWizard().getContainer().updateButtons();
				}
			});
			btnReportAllElements.setSelection(true);
			new Label(composite, SWT.NONE);
			new Label(composite, SWT.NONE);

			btnReportOnANodeType = formToolkit.createButton(composite,
					"Report on a Network Element Type for Operator", SWT.RADIO);
			btnReportOnANodeType.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					setReportSelection(REPORT_ON_OPERATOR_NODETYPE);
					btnSelect.setEnabled(true);
					txtNodeType.setEnabled(true);
					getWizard().getContainer().updateButtons();
				}
			});

			txtNodeType = formToolkit.createText(composite, "New Text",
					SWT.READ_ONLY);
			txtNodeType.setText("");
			txtNodeType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
					false, 1, 1));
			txtNodeType.setEnabled(false);

			btnSelect = formToolkit.createButton(composite, "Select...",
					SWT.NONE);
			btnSelect.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					// Select reporting for a nodetype or all types ?

					Resource nodeTypeResource = editingService
							.getData(LibraryPackage.Literals.NODE_TYPE);
					NodeTypeFilterDialog dialog = new NodeTypeFilterDialog(
							ScheduledReportTypeSelectionPage.this.getShell(),
							nodeTypeResource);
					if (dialog.open() == IDialogConstants.CANCEL_ID) {
						return;
					}

					nt = (NodeType) dialog.getFirstResult();
					txtNodeType.setText(nt.getName());
					getWizard().getContainer().updateButtons();
				}
			});
			btnSelect.setEnabled(false);

		}
	}

	private void buildSelectionIsService(Composite composite) {
		if (selectedObject instanceof Service) {

			buildYouCan();

			btnReportAllElements = formToolkit.createButton(composite,
					"Report all Elements in Service", SWT.RADIO);
			btnReportAllElements.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					setReportSelection(REPORT_ON_SERVICE);
					btnSelect.setEnabled(false);
					txtNodeType.setEnabled(false);
					getWizard().getContainer().updateButtons();
				}
			});
			btnReportAllElements.setSelection(true);
			new Label(composite, SWT.NONE);
			new Label(composite, SWT.NONE);

			btnReportOnANodeType = formToolkit.createButton(composite,
					"Report on a Network Element Type for Service", SWT.RADIO);
			btnReportOnANodeType.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					setReportSelection(REPORT_ON_SERVICE_NODETYPE);
					btnSelect.setEnabled(true);
					txtNodeType.setEnabled(true);
					getWizard().getContainer().updateButtons();
				}
			});

			txtNodeType = formToolkit.createText(composite, "New Text",
					SWT.READ_ONLY);
			txtNodeType.setText("");
			txtNodeType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
					false, 1, 1));
			txtNodeType.setEnabled(false);

			btnSelect = formToolkit.createButton(composite, "Select...",
					SWT.NONE);
			btnSelect.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {

					// Select reporting for a nodetype or all types ?

					Resource nodeTypeResource = editingService
							.getData(LibraryPackage.Literals.NODE_TYPE);
					NodeTypeFilterDialog dialog = new NodeTypeFilterDialog(
							ScheduledReportTypeSelectionPage.this.getShell(),
							nodeTypeResource);
					if (dialog.open() == IDialogConstants.CANCEL_ID) {
						return;
					}

					nt = (NodeType) dialog.getFirstResult();
					txtNodeType.setText(nt.getName());
					getWizard().getContainer().updateButtons();
				}
			});
			btnSelect.setEnabled(false);

		}
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

	public void setSelection(Object o) {
		this.selectedObject = o;

		if (o instanceof Operator) {
			this.reportSelection = REPORT_ON_OPERATOR;
		} else if (o instanceof Service) {
			this.reportSelection = REPORT_ON_SERVICE;
		}
		if (o instanceof Node) {
			this.reportSelection = REPORT_ON_NODE;
		}

		if (o == null) {
			this.setPageComplete(false);
		}

	}

	@Override
	public boolean canFlipToNextPage() {

		// if (getErrorMessage() != null) return false;

		if (selectedObject == null) {
			return false;
		}

		switch (reportSelection) {
		case REPORT_ON_SERVICE_NODETYPE:
		case REPORT_ON_OPERATOR_NODETYPE:

			if (getNodeType() != null) {
				this.setErrorMessage(null);
				return true;
			} else {
				this.setErrorMessage("Select a node type");
				return false;
			}
		}

		this.setErrorMessage(null);
		return super.canFlipToNextPage();
	}
	
	
	public String getIdentifier(){
		return this.txtSelectedObject.getText();
	}
	
}
