package com.netxforge.netxstudio.models.importer.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public class ImportResourceWizardPage extends WizardPage {

	private Text sourceFileField;
	private FormToolkit toolkit;
	private ScrolledForm form;
	private IPath initSourcePath;
	private boolean indexed;

	protected ImportResourceWizardPage(String pageName) {
		super(pageName);
	}

	public void createControl(Composite parent) {
		toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
		// form.setText(Messages.ImportResourceWizardPage_0);

		GridLayout layout = new GridLayout();
		form.getBody().setLayout(layout);

		Composite sectionClient = toolkit.createComposite(form.getBody());
		sectionClient.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout1 = new GridLayout();
		layout1.numColumns = 3;
		sectionClient.setLayout(layout1);

		Label label1 = toolkit.createLabel(sectionClient,
				Messages.ImportResourceWizardPage_1);
		GridData data1 = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		data1.horizontalSpan = 3;
		label1.setLayoutData(data1);

		Label label2 = toolkit.createLabel(sectionClient,
				Messages.ImportResourceWizardPage_2);
		label2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		sourceFileField = toolkit.createText(sectionClient, "");
		sourceFileField
				.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING
						| GridData.FILL_HORIZONTAL));
		sourceFileField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updatePageComplete();
			}
		});

		Button button = toolkit.createButton(sectionClient,
				Messages.ImportResourceWizardPage_4, SWT.PUSH);

		final Button btnIndexedButton = toolkit.createButton(form.getBody(),
				Messages.ImportResourceWizardPage_btnNewButton_text, SWT.CHECK);
		btnIndexedButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setIndexed(btnIndexedButton.getSelection());
			}
		});
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				browseForSourceFile();
			}
		});

		this.setControl(form);
		this.initContent();
	}

	private void browseForSourceFile() {

		// IPath location =
		// WorkspaceUtil.INSTANCE.getLocation(sourceFileField.getText());
		IPath[] paths = WorkspaceUtil.INSTANCE.browseWorkspace(this.getShell());
		if (paths == null || paths.length == 0)
			return;
		sourceFileField.setText(WorkspaceUtil.INSTANCE.stripWorkspace(paths[0])
				.toString());
	}

	public void init(IStructuredSelection selection) {
		// only use the first.
		Object sel = selection.getFirstElement();
		if (sel instanceof IFile) {
			IFile file = (IFile) sel;
			this.initSourcePath = file.getLocation();
		}
	}

	private void initContent() {
		if (this.initSourcePath == null) {
			setPageComplete(false);
			return;
		}
		IPath path = WorkspaceUtil.INSTANCE.stripWorkspace(initSourcePath);
		sourceFileField.setText(path.toString());
	}

	private void updatePageComplete() {
		IPath srcPath = WorkspaceUtil.INSTANCE.getLocation(sourceFileField
				.getText());
		if (srcPath == null || srcPath.isEmpty()) {
			setMessage(null);
			setErrorMessage(Messages.ImportResourceWizardPage_5);
			return;
		}
		// IFile file = WorkspaceUtil.INSTANCE.createFileHandle(srcPath);
		// if (!file.exists()) {
		// setMessage(null);
		// setErrorMessage(Messages.ImportResourceWizardPage_5);
		// return;
		// }

		setErrorMessage(null);
		setPageComplete(true);
	}

	/**
	 * Get the path for the selected resource.
	 * 
	 * @return
	 */
	public IPath getPath() {

		String text = sourceFileField.getText();
		IPath srcPath = WorkspaceUtil.INSTANCE.getLocation(text);
		return srcPath;
	}

	public boolean isIndexed() {
		return indexed;
	}

	public void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}

}
