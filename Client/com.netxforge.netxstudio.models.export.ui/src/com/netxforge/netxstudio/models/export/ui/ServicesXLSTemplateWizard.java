package com.netxforge.netxstudio.models.export.ui;

import com.netxforge.netxstudio.models.export.XpandTemplate;
import com.netxforge.netxstudio.services.ServicesPackage;

public class ServicesXLSTemplateWizard extends AbstractExportTempleWizard {
	
	@Override
	public boolean performFinish() {
		final XpandTemplate currentTemplate = this.getTemplate();
		currentTemplate.setTargetObject(ServicesPackage.eINSTANCE);
		return super.doPerformFinish(currentTemplate);

	}

}
