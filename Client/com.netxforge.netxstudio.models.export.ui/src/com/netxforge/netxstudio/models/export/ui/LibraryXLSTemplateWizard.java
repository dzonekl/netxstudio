package com.netxforge.netxstudio.models.export.ui;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.models.export.XpandTemplate;

public class LibraryXLSTemplateWizard extends AbstractExportTempleWizard {
	
	@Override
	public boolean performFinish() {
		final XpandTemplate currentTemplate = super.getTemplate();
		currentTemplate.setTargetObject(LibraryPackage.eINSTANCE);
		return super.doPerformFinish(currentTemplate);

	}

}
