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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedXtextEditor;

/**
 * Sample showing how to handle an embedded xtext editor in a Viewpart.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class EmbeddedXtextScreen extends Composite implements IDataScreenInjection {

//	public static final String ID = "com.netxforge.netxstudio.screens.xtext.EmbeddedXtextViewPart"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private EmbeddedXtextEditor editor;
	private IEditingService editingService;
	
	/**
	 * Our expression being edited. 
	 */
	private Expression expression;
	
	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	public EmbeddedXtextScreen(Composite parent, int style, IEditingService eService) {
		super(parent, style);
		editingService = eService;
		
		Composite container = toolkit.createComposite(parent, SWT.NONE);
		toolkit.paintBordersFor(container);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		// The magic, our inject will be based on the grammar name, from this
		// all we be constructed.
		Injector injector = InjectorProxy
				.getInjector("com.netxforge.Netxscript");
		
		
		editor = new EmbeddedXtextEditor(parent, injector, SWT.BORDER);

		// TODO, deal with the dirty state @see our super.
		editor.getViewer().getTextWidget()
				.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						// if (!editor.getViewer().getTextWidget().getText()
						// .equals(getEditedEObject().getAsString())) {
						// setDirty(true);
						// getEditor().firePropertyChange(IEditorPart.PROP_DIRTY);
						// } else {
						// getEditor().setDirty(false);
						// getEditor().firePropertyChange(IEditorPart.PROP_DIRTY);
						// }

						System.out
								.println("TODO, Implement dirty state: text modified");

					}
				});

		editor.getDocument().addModelListener(new IXtextModelListener() {
			public void modelChanged(XtextResource resource) {
				reconcileChangedModel();
			}
		});

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

//		editor.getViewer().getTextWidget()
//				.addVerifyKeyListener(new VerifyKeyListener() {
//					public void verifyKey(VerifyEvent e) {
//						if (e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR) {
//							e.doit = false;
//						}
//					}
//				});

	}

	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}

	/**
	 * Testing Injection with a Guice data provider. s
	 */
	
	protected Expression getEditedEObject() {
		return expression;
	}
	
	protected String getAsString(Expression expression) {
		StringBuffer buf = new StringBuffer();
		for(String exprLine : expression.getExpressionLines()){
			buf.append(exprLine);
		}
		return buf.toString();
	}
	
	

	// CB, the reconciler, fires some commands, and needs an editing domain,
	// implement an EditingDomainProvider
	// in a IViewPart.
	private void reconcileChangedModel() {
		// The command to execute
		CompoundCommand compoundCommand = new CompoundCommand() {
			@Override
			public Collection<?> getAffectedObjects() {
				return Collections.singletonList(getEditedEObject());
			}
		};

		EditingDomain editingDomain = editingService.getEditingDomain();

		// 1) we will update the edited EObject only if there is a diff in the
		// source viewer

		boolean updateEditedEObject = !editor.getViewer().getDocument().get()
				.equals(getAsString(expression));

		if (updateEditedEObject) {
			
			
			// TODO, we would need to update the string line by line. 
			
//			compoundCommand.append(SetCommand.create(editingDomain,
//					getEditedEObject(),
//					XtextwrapperPackage.Literals.NET_XSCRIPT_WRAPPER__AS_STRING, editor
//							.getViewer().getDocument().get()));
			
		}
		
		
		// 2) we will additionally check for errors, and based on this, the evaluation
		// is replaced with the 
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

			EObject astRootElement = getEditedEObject().getEvaluationObject();
			if (!astRootElement.eContents().isEmpty()) {
				// remove all previous elements in the edited object
				compoundCommand.append(DeleteCommand.create(editingDomain,
						astRootElement.eContents()));
			}

			EObject rootASTElement = editor.getResource().getParseResult()
					.getRootASTElement();
			if (rootASTElement != null) {
				EObject copyOfRootASTElement = EcoreUtil.copy(rootASTElement);
				EStructuralFeature eContainingFeature = astRootElement
						.eContainingFeature();

				if (eContainingFeature.isMany()) {
					compoundCommand.append(AddCommand.create(editingDomain,
							astRootElement.eContainer(), eContainingFeature,
							Collections.singletonList(copyOfRootASTElement)));
				} else {
					compoundCommand.append(SetCommand.create(editingDomain,
							astRootElement.eContainer(), eContainingFeature,
							copyOfRootASTElement));
				}
			}
		}

		editingDomain.getCommandStack().execute(compoundCommand);
	}

	private boolean documentHasErrors(final IXtextDocument xtextDocument) {
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
	

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataScreenInjection#injectData(java.lang.Object, java.lang.Object)
	 */
	public void injectData(Object owner, Object object) {
		if(object instanceof Expression){
			expression = (Expression)object;
		}
		String asString = getAsString(expression);
		editor.update(getEditedEObject().getEvaluationObject(), asString == null ? "" : asString);
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataScreenInjection#addData()
	 */
	public void addData() {
		// TODO Auto-generated method stub
		
	}

}
