package com.netxforge.netxstudio.screens.ch9;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

/**
 * Concrete implementation which can set and clear the expression from an owner.
 * i
 * 
 * @author dzonekl
 */
public class EmbeddedNonSelectionExpression extends EmbeddedExpression {

	private EStructuralFeature expressionFeature;
	private EObject owner;
	private String identity;

	public EmbeddedNonSelectionExpression(IEditingService editingService,
			Composite parent, FormData fd, int operation) {
		super(editingService, parent, fd, operation);
		buildUI();
	}

	public void buildUI(Composite parent, FormData fd) {

		int widgetStyle = SWT.None;
		if (Screens.isReadOnlyOperation(getOperation())) {
			widgetStyle |= SWT.READ_ONLY;
		}

		Composite sectionClient = buildSection(identity, parent, fd);
//		buildExpressionSelector(widgetStyle, sectionClient);
		buildExpression(widgetStyle, sectionClient);
	}

	@Override
	protected void setExpression(Expression exp) {
		Command c = new SetCommand(editingService.getEditingDomain(), owner,
				expressionFeature, exp);
		editingService.getEditingDomain().getCommandStack().execute(c);
	}

	@Override
	protected void clearExpression(Expression exp) {
		if (owner.eIsSet(expressionFeature)) {
			Command c = new SetCommand(editingService.getEditingDomain(),
					owner, expressionFeature, null);
			editingService.getEditingDomain().getCommandStack().execute(c);
		}
	}

	/**
	 * Inject the expression to work with.
	 */
//	public void injectData(String identity, EObject owner, EStructuralFeature feature) {
//		this.expressionFeature = feature;
//		this.owner = owner;
//		this.identity = identity; 
//	}

//	public void bind(EMFDataBindingContext context) {
//		IObservableValue capExpressionObservable = SWTObservables.observeText(
//				this.getTxtExpressionName(), SWT.Modify);
//
//		IEMFValueProperty profileExpressionProperty = EMFEditProperties.value(
//				editingService.getEditingDomain(), FeaturePath.fromList(
//						expressionFeature,
//						LibraryPackage.Literals.EXPRESSION__NAME));
//
//		context.bindValue(capExpressionObservable,
//				profileExpressionProperty.observe(owner), null, null);
//	}

}
