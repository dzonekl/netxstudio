package com.netxforge.netxstudio.models.export.ui;

import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.models.export.XpandTemplate;

public class GeoExportTemplateWizard extends AbstractExportTempleWizard {
	
	@Override
	public boolean performFinish() {
		final XpandTemplate currentTemplate = getTemplate();
		currentTemplate.setTargetObject(GeoPackage.eINSTANCE);
		return super.doPerformFinish(currentTemplate);
	}

}
