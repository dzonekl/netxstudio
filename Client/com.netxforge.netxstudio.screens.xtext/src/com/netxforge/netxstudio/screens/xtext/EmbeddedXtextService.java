/*******************************************************************************
 * Copyright (c) May 1, 2011 NetXForge.
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
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.xtext;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedXtextEditor;

/**
 * Acts as a service for embedded xtext editors.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class EmbeddedXtextService {

	private IEditingService editingService;

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	public EmbeddedXtextService(IEditingService eService) {
		editingService = eService;

		// we must deactivate the Cut/Copy/Paste global actions contributed by
		// the EditingDomain action bar
		// CB, we propably don't need this, as we don't have a parent editor.

		// editor.getViewer().getTextWidget().addFocusListener(new
		// FocusListener() {
		// public void focusLost(FocusEvent e) {
		// ((ActionBarContributor)getEditor().getActionBarContributor()).activateCCPActions();
		// }
		//
		// public void focusGained(FocusEvent e) {
		// ((ActionBarContributor)getEditor().getActionBarContributor()).deactivateCCPActions();
		// }
		// });

		// editor.getViewer().getTextWidget()
		// .addVerifyKeyListener(new VerifyKeyListener() {
		// public void verifyKey(VerifyEvent e) {
		// if (e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) {
		// e.doit = false;
		// }
		// }
		// });

	}

	public String getAsString(Expression expression) {
		StringBuffer buf = new StringBuffer();
		for (String exprLine : expression.getExpressionLines()) {
			buf.append(exprLine);
		}
		return buf.toString();
	}

	/**
	 * A two step reconciler. 1) Update the String representation. 2) Update the
	 * evaluation representation.
	 * 
	 * @param expression
	 * @param editor
	 */
	public EObject reconcileChangedModel(final Expression expression,
			EmbeddedXtextEditor editor) {

		// A compound command.
//		CompoundCommand compoundCommand = new CompoundCommand() {
//			@Override
//			public Collection<?> getAffectedObjects() {
//				return Collections.singletonList(expression);
//			}
//		};

		EditingDomain editingDomain = editingService.getEditingDomain();

		// 1) we will update the string representation first.

		boolean updateEditedEObject = !editor.getViewer().getDocument().get()
				.equals(getAsString(expression));

		if (updateEditedEObject) {

			// // remove all previous elements in the edited object

//			Command dc = DeleteCommand.create(editingDomain,
//					expression.getExpressionLines());
//			editingDomain.getCommandStack().execute(dc);

			 expression.getExpressionLines().clear();

			IDocument doc = editor.getViewer().getDocument();
			int lines = doc.getNumberOfLines();
			Collection<String> linesCollection = new ArrayList<String>();
			try {
				for (int i = 0; i < lines; i++) {
					int offset = doc.getLineOffset(i);
					int len = doc.getLineLength(i);
					String line = doc.get(offset, len);
					linesCollection.add(line);
				}

				Command ac = new AddCommand(editingDomain, expression,
						LibraryPackage.Literals.EXPRESSION__EXPRESSION_LINES,
						linesCollection);
				editingService.getEditingDomain().getCommandStack().execute(ac);
				Collection<?> result = ac.getResult();
				System.out.println(result);

			} catch (BadLocationException e) {
				// Algorithm error.
				e.printStackTrace();
			}
		}

		// 2) we will additionally check for errors, and based on this, update
		// the evaluation object
		// as well.
		if (editor.getDocument() != null) {
			if (documentHasErrors(editor.getDocument())) {
				// Parsing error, we don't do aything
				updateEditedEObject = false;
			}
		} else {
			// document is null or already disposed, we don't do anything
			updateEditedEObject = false;
		}

		if (updateEditedEObject) {

			EObject astRootElement = expression.getEvaluationObject();

			// if (!astRootElement.eContents().isEmpty()) {
			// // remove all previous elements in the edited object
			// compoundCommand.append(DeleteCommand.create(editingDomain,
			// astRootElement.eContents()));
			// }

			EObject rootASTElement = editor.getResource().getParseResult()
					.getRootASTElement();
			if (rootASTElement != null) {
				EObject copyOfRootASTElement = EcoreUtil.copy(rootASTElement);

//				compoundCommand.append(SetCommand.create(editingDomain,
//						expression, null, copyOfRootASTElement));
				
				
				return copyOfRootASTElement;
				
				
				// EStructuralFeature eContainingFeature = astRootElement
				// .eContainingFeature();

				// if (eContainingFeature.isMany()) {
				// compoundCommand.append(AddCommand.create(editingDomain,
				// astRootElement.eContainer(), eContainingFeature,
				// Collections.singletonList(copyOfRootASTElement)));
				// } else {
				// compoundCommand.append(SetCommand.create(editingDomain,
				// astRootElement.eContainer(), eContainingFeature,
				// copyOfRootASTElement));
				// }
			}
		}

//		editingDomain.getCommandStack().execute(compoundCommand);
//		printExpression(expression);
		return null;
		
	}

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

	public void printExpression(Expression expression) {

		for (String eLine : expression.getExpressionLines()) {
			System.out.print("Expression # " + eLine);
		}
		System.out.println("Current eval object:"
				+ expression.getEvaluationObject());
	}

}
