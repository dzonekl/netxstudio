package com.netxforge.netxstudio.screens.f4;

import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class MetricSourceMDPage extends FormPage {

	private MetricSourceMDBlock msMDBlock;

	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	public MetricSourceMDPage(String id, String title) {
		super(id, title);
	}

	/**
	 * Create the form page.
	 * @param editor
	 * @param id
	 * @param title
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public MetricSourceMDPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
		msMDBlock = new MetricSourceMDBlock();
	}

	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Metric Sources");
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(form.getBody());
		msMDBlock.createContent(managedForm);
	}

}
