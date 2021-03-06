package com.netxforge.netxstudio.models.export.ui;

import com.netxforge.netxstudio.models.export.XpandTemplate;
import com.netxforge.netxstudio.operators.OperatorsPackage;

public class OperatorXLSTemplateWizard extends AbstractExportTempleWizard {
	
	@Override
	public boolean performFinish() {
		final XpandTemplate currentTemplate = this.getTemplate();
		currentTemplate.setTargetObject(OperatorsPackage.eINSTANCE);
		return super.doPerformFinish(currentTemplate);

	}
	
	@Override
	public String getHintFileName() {
		return "operators-template";
	}
}
