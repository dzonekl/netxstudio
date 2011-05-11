package com.netxforge.netxstudio.emf.poi.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
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



public class PoiResourceWizardPage extends WizardPage {
	
	
	@Override
	public IWizardPage getNextPage() {
		return ((PoiExportWizard)getWizard()).getPoiExportFilePage();
	}


	private Text sourceFileField;
	private FormToolkit toolkit;
	private ScrolledForm form;
	private IPath initSourcePath;
	
	protected PoiResourceWizardPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
//		form.setText(Messages.PoiResourceWizardPage_0);

		GridLayout layout = new GridLayout();
		form.getBody().setLayout(layout);

		Composite sectionClient = toolkit.createComposite(form.getBody());
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		sectionClient.setLayoutData(data);
		GridLayout layout1 = new GridLayout();
		layout1.numColumns = 3;
		sectionClient.setLayout(layout1);
		
		Label label1 = toolkit.createLabel(sectionClient,
		Messages.PoiResourceWizardPage_1);
		GridData data1 = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		data1.horizontalSpan = 3;
		label1.setLayoutData(data1);

		Label label2 = toolkit.createLabel(sectionClient, Messages.PoiResourceWizardPage_2);
		label2.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
		
		sourceFileField = toolkit.createText(sectionClient, ""); //$NON-NLS-1$
		GridData data2 = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL);
		sourceFileField.setLayoutData(data2);
		sourceFileField.addModifyListener(new ModifyListener(){
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Validation of the import file. 
				updatePageComplete();
			}

			
		});
		
		Button button = toolkit.createButton(sectionClient, Messages.PoiResourceWizardPage_4, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				browseForSourceFile();
			}
		});
		
		this.setControl(form);
		this.initContent();
	}
	
	
	private void browseForSourceFile() {
		
//		IPath location = WorkspaceUtil.INSTANCE.getLocation(sourceFileField.getText());
		IPath[] paths = WorkspaceUtil.INSTANCE.browseWorkspace(this.getShell());
		if(paths == null || paths.length == 0) return;
		sourceFileField.setText(WorkspaceUtil.INSTANCE.stripWorkspace(paths[0]).toString());		
	}
	
	
	public void init(IStructuredSelection selection){
		// only use the first. 
		Object sel = selection.getFirstElement();
		if(sel instanceof IFile){
			IFile file = (IFile)sel;
			this.initSourcePath = file.getLocation();
		}
	}
	
	private void initContent(){
		if(this.initSourcePath == null){
			setPageComplete(false);
			return;
		}
		IPath path = WorkspaceUtil.INSTANCE.stripWorkspace(initSourcePath);
		sourceFileField.setText(path.toString());
	}
	
	
	private void updatePageComplete() {
		IPath srcPath = this.getPath();
		if(srcPath == null || srcPath.isEmpty()){
			setMessage(null);
			setErrorMessage(Messages.PoiResourceWizardPage_5);
			return;
		}
		
		IFile file = WorkspaceUtil.INSTANCE.createFileHandle(srcPath);
		if (!file.exists()) {
			setMessage(null);
			setErrorMessage(Messages.PoiResourceWizardPage_6);
			return;
		}
		setMessage(null);
		setErrorMessage(null);
		setPageComplete(true);
	}
	
	
	/**
	 * Get the path for the selected resource. 
	 * @return
	 */
	public IPath getPath(){
		IPath srcPath = WorkspaceUtil.INSTANCE.getLocation(sourceFileField.getText());
		return srcPath;
	}
	
}
