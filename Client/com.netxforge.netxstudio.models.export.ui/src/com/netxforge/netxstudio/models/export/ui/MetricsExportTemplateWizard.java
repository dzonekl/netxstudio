package com.netxforge.netxstudio.models.export.ui;

import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.models.export.XpandTemplate;

public class MetricsExportTemplateWizard extends AbstractExportTempleWizard {
	
	@Override
	public boolean performFinish() {
		final XpandTemplate currentTemplate = this.getTemplate();
		currentTemplate.setTargetObject(MetricsPackage.eINSTANCE);
		return super.doPerformFinish(currentTemplate);
	}

}
