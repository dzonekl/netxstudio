package com.netxforge.netxstudio.models.export.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;

import com.netxforge.netxstudio.models.export.XpandEmfRegistryMetaModels;

public class XpandEmfRegistryMetaModelsImpl extends EmfRegistryMetaModel implements XpandEmfRegistryMetaModels {

	private Set<EPackage> packages = new HashSet<EPackage>();

	public XpandEmfRegistryMetaModelsImpl() {
		packages.add(EcorePackage.eINSTANCE);
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.m2t.impl.XpandEmfRegistryMetaModels#addPackages(org.eclipse.emf.ecore.EPackage)
	 */
	public void addPackages(EPackage... packages) {
		this.packages.addAll(Arrays.asList(packages));
	}

	@Override
	protected EPackage[] allPackages() {
		return packages.toArray(new EPackage[0]);
	}

}