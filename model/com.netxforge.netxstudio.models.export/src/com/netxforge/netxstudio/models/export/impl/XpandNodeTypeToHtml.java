package com.netxforge.netxstudio.models.export.impl;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Output;

import com.netxforge.netxstudio.library.LibraryPackage;

public class XpandNodeTypeToHtml extends XpandTemplateImpl {

//	public static String XLS_OUTPUT_PATH = "export/templates";
	public static String XPAND_NODETYPE2HTML = "templates::nodetype2html::Root";
	
	private EPackage[] metaModels = new EPackage[]{EcorePackage.eINSTANCE, LibraryPackage.eINSTANCE};
	
	public String getTemplateDescription() {
		return "Export a Network Element type to HTML";
	}

	public String getTemplateCall() {
		return XPAND_NODETYPE2HTML;
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
	}

	public boolean isMetaTarget() {
		return false;
	}

	public String getExtension() {
		return "html";
	}
	
}

