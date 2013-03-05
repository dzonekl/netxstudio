package com.netxforge.netxstudio.models.export.ui.pages;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.netxforge.netxstudio.models.export.ui.Messages;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public class ModelSourceWizardPage extends WizardPage {

	private Text sourceFileField;
	private FormToolkit toolkit;
	private ScrolledForm form;
	private IPath initSourcePath;
	private Button btnDbBased;

	protected ModelSourceWizardPage(String pageName) {
		super(pageName);
	}

	public void createControl(Composite parent) {

		toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
//		form.setText(Messages.XPandResourceWizardPage_0);

		GridLayout layout = new GridLayout();
		form.getBody().setLayout(layout);

		Composite dbSelection = toolkit.createComposite(form.getBody());
		dbSelection.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1));
		GridLayout gl_dbSelection = new GridLayout();
		gl_dbSelection.numColumns = 2;
		dbSelection.setLayout(gl_dbSelection);
		// section.setClient(sectionClient);

		Label lblSelectDbOr = toolkit.createLabel(dbSelection,
				Messages.XPandResourceWizardPage_lblSelectDbOr_text, SWT.NONE);
		GridData gd_lblSelectDbOr = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_lblSelectDbOr.widthHint = 163;
		lblSelectDbOr.setLayoutData(gd_lblSelectDbOr);

		btnDbBased = toolkit.createButton(dbSelection,
				Messages.XPandResourceWizardPage_btnDbBased_text, SWT.CHECK);

		Group group = new Group(form.getBody(), SWT.NONE);
		group.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1));
		toolkit.adapt(group);
		toolkit.paintBordersFor(group);
		group.setLayout(new GridLayout(4, false));

		final Label label1 = toolkit.createLabel(group,
				Messages.XPandResourceWizardPage_2);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);
		new Label(group, SWT.NONE);

		final Label label2 = toolkit.createLabel(group,
				Messages.XPandResourceWizardPage_3);
		new Label(group, SWT.NONE);

		sourceFileField = toolkit.createText(group, "");
		GridData gd_sourceFileField = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_sourceFileField.widthHint = 236;
		sourceFileField.setLayoutData(gd_sourceFileField);
		sourceFileField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updatePageComplete();
			}
		});

		final Button browseButton = toolkit.createButton(group,
				Messages.XPandResourceWizardPage_5, SWT.PUSH);
		browseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				browseForSourceFile();
			}
		});

		// Section section = toolkit.createSection(form.getBody(),
		// Section.DESCRIPTION | Section.TITLE_BAR | Section.TWISTIE
		// | Section.EXPANDED);
		// section.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// section.setText(Messages.XPandResourceWizardPage_1);
		// section.addExpansionListener(new ExpansionAdapter() {
		// public void expansionStateChanged(ExpansionEvent e) {
		// form.reflow(true);
		// }
		// });

		btnDbBased.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// System.out.println("Button checked" + e);
				// disable file based widgets when checked.
				sourceFileField.setEnabled(!btnDbBased.getSelection());
				label1.setEnabled(!btnDbBased.getSelection());
				label2.setEnabled(!btnDbBased.getSelection());
				browseButton.setEnabled(!btnDbBased.getSelection());
				updatePageComplete();
			}
		});

		this.setControl(form);
		this.initContent();
	}

	@SuppressWarnings("unused")
	private void browseForSourceFile() {

		// File system browser.
		if (false) {
			IPath location = WorkspaceUtil.INSTANCE.getLocation(sourceFileField
					.getText());

			IPath path = WorkspaceUtil.INSTANCE.browseFileSystem(
					this.getShell(), location, true);
			if (path != null)
				sourceFileField.setText(WorkspaceUtil.INSTANCE.stripWorkspace(
						path).toString());
		}

		// Workspace browser
		if (true) {
			IPath[] results = WorkspaceUtil.INSTANCE.browseWorkspace(this
					.getShell());

			if (results == null || results.length == 0)
				return;
			IPath o = results[0];
			sourceFileField.setText(results[0].toOSString());
		}

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

		if (btnDbBased.getSelection()) {
			this.setPageComplete(true);
			setMessage("The souce model is the DB");
			setErrorMessage(null);
			return;
		}

		IPath srcPath = this.getPath();
		
		if(srcPath == null || srcPath.isEmpty()){
			setMessage(null);
			setErrorMessage(Messages.XPandResourceWizardPage_6);
			return;
		}
		IFile file = WorkspaceUtil.INSTANCE.createFileHandle(srcPath);
		if (!file.exists()) {
			setMessage(null);
			setErrorMessage(Messages.XPandResourceWizardPage_6);
			return;
		}
		setMessage(null);
		setErrorMessage(null);
		setPageComplete(true);
	}

	/**
	 * Get the path for the selected resource.
	 * 
	 * @return
	 */
	public IPath getPath() {
		IPath srcPath = WorkspaceUtil.INSTANCE.getLocation(sourceFileField
				.getText());
		return srcPath;
	}

}
