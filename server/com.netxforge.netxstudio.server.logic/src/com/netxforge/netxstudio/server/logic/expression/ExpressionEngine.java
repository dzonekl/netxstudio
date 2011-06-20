/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.logic.expression;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.base.Joiner;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.netxforge.interpreter.IInterpreter;
import com.netxforge.interpreter.IInterpreterContext;
import com.netxforge.interpreter.InterpreterContextFactory;
import com.netxforge.interpreter.InterpreterFactory;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.server.logic.LogicActivator;

/**
 * Runs an expression and collects the results in a list of
 * {@link ExpressionResult} objects.
 * 
 * This Engine, has the following potential errors: 
 * <ul>
 * 		<li>The expression might not load, because of syntax issues.</li>
 * 		<li>Linking (resolve) could fail, CDO connection is required</li>
 * 		<li>Expression results not be written out</li>
 * </ul>
 * 
 * @author Martin Taal
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class ExpressionEngine implements IExpressionEngine {
	private Expression expression;
	private List<ExpressionResult> expressionResult =  new ArrayList<ExpressionResult>();

	private XtextResource xResource;
	
	@Inject
	private XtextResourceSet xResourceSet;
	
	@Inject
	private IResourceFactory xResourceFactory;
	
	@Inject
	private InterpreterContextFactory<Object> xInterpreterContextFactory;
	
	@Inject
	private InterpreterFactory xInterpreterFactory;

	private List<Object> context = new ArrayList<Object>();
	
	private Throwable throwable;
	
	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.server.logic.expression.IExpressionEngine#run()
	 */
	@SuppressWarnings("unchecked")
	public void run() {
		
		throwable = null;
		getExpressionResult().clear();
		
		final String asString = this.asString(expression);
		try {
			xResource = getResourceFromString(asString);
			// Get the parse tree. 
			final Mod m = (Mod) this.getModel(xResource);
			
			final List<IInterpreterContext> contextList = new ArrayList<IInterpreterContext>();
			for (final Object o : context) {
				contextList.add(xInterpreterContextFactory.createContext(o));
			}
			final IInterpreterContext[] contextArray = new IInterpreterContext[contextList.size()];
			final IInterpreter interpreter = xInterpreterFactory.create(contextList.toArray(contextArray));
			setExpressionResult((List<ExpressionResult>)interpreter.evaluate(m));
			xResource.unload();
		} catch (final Throwable t) {
			throwable = t;
		}
	}

	public boolean errorOccurred() {
		return throwable != null;
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.server.logic.expression.IExpressionEngine#getExpression()
	 */
	public Expression getExpression() {
		return expression;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.server.logic.expression.IExpressionEngine#setExpression(com.netxforge.netxstudio.library.Expression)
	 */
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.server.logic.expression.IExpressionEngine#getExpressionResult()
	 */
	public List<ExpressionResult> getExpressionResult() {
		return expressionResult;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.server.logic.expression.IExpressionEngine#setExpressionResult(java.util.List)
	 */
	public void setExpressionResult(List<ExpressionResult> expressionResult) {
		this.expressionResult = expressionResult;
	}
	
	private EObject getModel(XtextResource resource) {
		return resource.getParseResult().getRootASTElement();
	}
	
	private String asString(Expression expression){
		// TODO, check if the line feed is stored. 
		final Collection<String> lines = expression.getExpressionLines();
		return Joiner.on("\n").join(lines);
	}
	
	private final XtextResource getResourceFromString(String model) throws Exception {
		return getResource(getAsStream(model));
	}
	
	private InputStream getAsStream(String model) {
		return new StringInputStream(model);
	}
	
	private final XtextResource getResource(InputStream in) throws Exception {
		
		// TODO, consider some algorithm for URI generation, could be usefull for troubleshooting?
		return getResource(in, URI.createURI("mytestmodel."+getCurrentFileExtension()));
	}
	
	private String getCurrentFileExtension() {
		final String instance = LogicActivator.getInstance().getInjector().getInstance(Key.get(String.class,Names.named(Constants.FILE_EXTENSIONS)));
		if (instance.indexOf(',')==-1)
			return instance;
		return instance.split(",")[0];
	}
		
	private final XtextResource getResource(InputStream in, URI uri) throws Exception {
		final XtextResource resource = doGetResource(in, uri);
		for(final Diagnostic d: resource.getErrors()) {
			if (d instanceof ExceptionDiagnostic){
					// TODO Do something with the resource erros. 
			}
		}
		for(final Diagnostic d: resource.getWarnings())
			System.out.println("Resource Warning: "+d);
		return resource;
	}
	
	protected XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		xResourceSet.setClasspathURIContext(getClass());
		final XtextResource resource = (XtextResource)xResourceFactory.createResource(uri);
		xResourceSet.getResources().add(resource);
		resource.load(in, null);
		if (resource instanceof LazyLinkingResource) {
			// Linking process here. 
			((LazyLinkingResource) resource).resolveLazyCrossReferences(CancelIndicator.NullImpl);
		} else {
			EcoreUtil.resolveAll(resource);
		}
		return resource;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public List<Object> getContext() {
		return context;
	}

	public void setContext(List<Object> context) {
		this.context = context;
	}
	
}
