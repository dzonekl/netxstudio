package com.netxforge.netxstudio.screens.xtext.embedded;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;

/**
 * Concrete implementation which can set and clear the expression from an owner.
 * i
 * 
 * @author Christophe Bouhier
 */
public class EmbeddedSelectionExpression extends AbstractEmbeddedExpression {

	private EStructuralFeature expressionFeature;
	private EObject owner;
	private String identity;

	public EmbeddedSelectionExpression(IEditingService editingService,
			Composite parent, FormData fd, int operation) {
		super(editingService, parent, fd, operation);
	}

	public void buildUI(Composite parent, FormData fd) {
		Composite sectionClient = buildSection(identity, parent, fd);
		buildExpressionSelector(sectionClient);
		buildExpression(sectionClient);
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
	public void injectData(String identity, EObject owner, EStructuralFeature feature) {
		this.expressionFeature = feature;
		this.owner = owner;
		this.identity = identity;
		
		buildUI();
		// Disable the editor. 
		this.setEnabled(false);
		if(owner.eIsSet(feature)){
			this.injectData(owner.eGet(feature));
		}
	}

	public void bind(EMFDataBindingContext context) {
		IObservableValue capExpressionObservable = SWTObservables.observeText(
				this.getTxtExpressionName(), SWT.Modify);

		IEMFValueProperty profileExpressionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						expressionFeature,
						LibraryPackage.Literals.EXPRESSION__NAME));

		context.bindValue(capExpressionObservable,
				profileExpressionProperty.observe(owner), null, null);
	}

}
