/*
 * <copyright>
 *
 * Copyright (c) 2009 Marc Schlienger (http://www.innoq.com/blog/mrs) and others.
 * All rights reserved.  
 * This program and the accompanying materials are made available under the terms of 
 * the Eclipse Public License v1.0 available at http://www.eclipse.org/legal/epl-v10.html
 *
 * </copyright>
 */
package com.netxforge.netxstudio.models.export.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.BlankLineSkippingOutput;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.expression.EvaluationException;
import org.eclipse.xtend.expression.Variable;

import com.netxforge.netxstudio.models.export.internal.Activator;

/**
 * A Xpand facade builder. Use like this: 1) Define an output, call
 * defineOutput() with the resource to output and if you wish to overwrite it.
 * 2) Add ecore packages needed by Xpand. 3) Perform the evaluation with your
 * packages and the defined output. 4) Evaluate with the created facade, the
 * template definition name and the target object.
 * 
 * @author dzonekl
 * 
 */
public class XpandCallerService {

	public static String FILE_NAME = "FileName";

	public static XpandEmfRegistryMetaModelsImpl addPackages(
			EPackage... packages) {
		XpandEmfRegistryMetaModelsImpl metaModels = new XpandEmfRegistryMetaModelsImpl();
		metaModels.addPackages(packages);
		return metaModels;
	}

	/**
	 * A resource based output.
	 * 
	 * @param resource
	 * @param overwrite
	 * @return
	 */
	public static Output defineOutput(IResource resource, boolean overwrite) {
		String containerName = resource.getLocation().toPortableString();
		OutputImpl out = new OutputImpl();
		Outlet outlet = new Outlet(containerName);
		outlet.setOverwrite(overwrite);
		out.addOutlet(outlet);
		return out;
	}

	public static Output defineBLSOutput(IResource resource, boolean overwrite) {
		String containerName = resource.getLocation().toPortableString();
		BlankLineSkippingOutput out = new BlankLineSkippingOutput();
		Outlet outlet = new Outlet(containerName);
		outlet.setOverwrite(overwrite);
		out.addOutlet(outlet);
		return out;
	}

	/**
	 * Creates an empty list of global vars. Created an Xpand Execution context.
	 * Register the metamodel from the parameter meta models. No global vars are
	 * provided.
	 * 
	 * @param mmFile
	 * @param out
	 */

	public static XpandFacade createXpandFacade(
			XpandEmfRegistryMetaModelsImpl mm, Output out) {
		Map<String, Variable> globalVarsMap = new HashMap<String, Variable>();
		return createXpandFacade(mm, globalVarsMap, out);
	}

	/**
	 * 
	 * @param mm
	 * @param globalVarsMap
	 * @param out
	 * @return
	 */
	public static XpandFacade createXpandFacade(
			XpandEmfRegistryMetaModelsImpl mm,
			Map<String, Variable> globalVarsMap, Output out) {
		XpandExecutionContextImpl contextImpl = new XpandExecutionContextImpl(
				out, null, globalVarsMap, null, null);
		contextImpl.registerMetaModel(mm);
		XpandFacade facade = XpandFacade.create(contextImpl);
		return facade;
	}

	/**
	 * 
	 * @param definitionName
	 *            The name of the Xpand main definition.
	 * @param targetObject
	 *            The target EMF Object.
	 * @param params
	 */
	public static void evaluate(XpandFacade facade, String definitionName,
			Object targetObject) {
		try {
			facade.evaluate(definitionName, targetObject);
		} catch (EvaluationException e) {
			Activator.logError("Evaluation Error", e);
		}

	}

	/**
	 * Evaluate with a list of arguments. TODO, what are the arguments?
	 * 
	 * @param facade
	 * @param definitionName
	 * @param targetObject
	 * @param arguments
	 */
	public static void evaluate(XpandFacade facade, String definitionName,
			Object targetObject, Object... arguments) {
		try {
			facade.evaluate(definitionName, targetObject, arguments);
		} catch (EvaluationException e) {
			Activator.logError("Evaluation Error", e);
		}
	}

	public static String getOutput(Output out) {
		return out.toString();
	}
}
