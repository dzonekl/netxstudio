package com.netxforge.ui.interpreter;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.netxforge.interpreter.InterpreterTypeless;
import com.netxforge.netxscript.Function;
import com.netxforge.netxscript.Mod;

/**
 * An interpretation handler, which can test the ongoing expression. Various
 * tests are executed, first to make sure the model has no errors.
 * 
 * 
 * @author dzonekl
 */
public class InterpreterHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
		IXtextDocument doc = xtextEditor.getDocument();
		if (this.documentHasErrors(doc)) {
			System.out
					.println("Intepreter cancelled, as errors exist in script: "
							+ doc.get());
			return null;
		}
		@SuppressWarnings("unused")
		String rootElementName = doc
				.readOnly(new IUnitOfWork<String, XtextResource>() {
					
					// Note: Expression scoping i.e. 'mod' or 'def' are optional.  
					@Override
					public String exec(XtextResource resource) throws Exception {
						if (resource.getContents().isEmpty()) {
							return null;
						}
						
						// TODO, Consider validating the resource here.
						
						if ((resource.getContents().get(0) instanceof Mod)) {
							Mod root = (Mod) resource.getContents().get(0);
							InterpreterTypeless i = new InterpreterTypeless();
							i.evaluate(root);
						}
						if ((resource.getContents().get(0) instanceof Function)) {
							Function root = (Function) resource.getContents().get(0);
							InterpreterTypeless i = new InterpreterTypeless();
							i.evaluate(root);
						}
						return null;
					}
				});

		return null;
	}

	/**
	 * returns the resource error status (Explictly tests for syntax errors).
	 * 
	 * @param xtextDocument
	 * @return
	 */
	public boolean documentHasErrors(final IXtextDocument xtextDocument) {
		return (xtextDocument
				.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
					public Boolean exec(XtextResource state) throws Exception {
						IParseResult parseResult = state.getParseResult();
						// CB Change.
						return !state.getErrors().isEmpty()
								|| parseResult == null
								|| parseResult.getSyntaxErrors().iterator()
										.hasNext();
					}
				}));
	}

}
