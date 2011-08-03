package com.netxforge.netxstudio.models.export.impl;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Output;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.models.export.internal.Activator;

public class XpandPackageImport extends XpandTemplateImpl {

	public static String XPAND_IMPORT = "templates::import::Root";
		
	
	
	private EPackage[] metaModels = new EPackage[]{EcorePackage.eINSTANCE, LibraryPackage.eINSTANCE};
	
	public XpandPackageImport() {
	}

	public String getTemplateDescription() {
		return "Export a template Model to Excel";
	}

	public String getTemplateCall() {
		return XPAND_IMPORT;
	}

	public XpandEmfRegistryMetaModelsImpl getEmfMetaModels() {
		XpandEmfRegistryMetaModelsImpl reg =  XpandCallerService.addPackages(metaModels);
		return reg;
	}

	@Override
	public void xpand(IResource res) {
		assert target != null;
		Output output = XpandCallerService.defineOutput(res, true);
		XpandFacade facade = XpandCallerService.createXpandFacade(getEmfMetaModels(), getGlobalVarsMap(),  output);
		XpandCallerService.evaluate(facade, getTemplateCall(), target);
		Activator.logInfo(XpandCallerService.getOutput(output));
	}

	public boolean isMetaTarget() {
		return true;
	}

	public String getExtension() {
		return "xls";
	}
	
}