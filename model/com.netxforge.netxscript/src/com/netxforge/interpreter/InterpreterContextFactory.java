// TODO CO here
package com.netxforge.interpreter;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

public class InterpreterContextFactory implements IInterpreterContextFactory {

	// Build the expected context classes, this can be used for validating
	// proper context settings.
	static {
		CAPACITY_CONTEXT_CLASSES.add(GenericsPackage.Literals.DATE_TIME_RANGE);
		CAPACITY_CONTEXT_CLASSES.add(OperatorsPackage.Literals.NODE);
		CAPACITY_CONTEXT_CLASSES.add(LibraryPackage.Literals.COMPONENT);

		RESOURCE_CONTEXT_CLASSES.addAll(CAPACITY_CONTEXT_CLASSES);
		RESOURCE_CONTEXT_CLASSES.add(LibraryPackage.Literals.NET_XRESOURCE);

		SERVICE_USER_CONTEXT_CLASSES
				.add(GenericsPackage.Literals.DATE_TIME_RANGE);
		SERVICE_USER_CONTEXT_CLASSES.add(ServicesPackage.Literals.SERVICE);
		SERVICE_USER_CONTEXT_CLASSES.add(ServicesPackage.Literals.SERVICE_USER);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.interpreter.IInterpreterContextFactory#createContext(T)
	 */
	public IInterpreterContext createContext(Object type) {
		return new ObjectContext<Object>(type);
	}

	public IInterpreterContext createPeriodContext(DateTimeRange dtr) {
		return new ObjectContext<DateTimeRange>(dtr);
	}

	public List<EClass> expectedContextForExpression(String expressionType) {

		if (expressionType.equals(EXPRESSION_COMPONENT_CAPACITY)) {
			return CAPACITY_CONTEXT_CLASSES;
		} else if (expressionType.equals(EXPRESSION_COMPONENT_UTILIZATION)
				|| expressionType.equals(EXPRESSION_TOLERANCE)) {
			return RESOURCE_CONTEXT_CLASSES;
		} else if (expressionType.equals(EXPRESSION_SERVICE_USER)) {
			return SERVICE_USER_CONTEXT_CLASSES;
		} else if (expressionType.equals(EXPRESSION_DATA_RETENTION)) {
			return RESOURCE_CONTEXT_CLASSES;
		}
		return null;
	}
}
