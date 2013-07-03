/*******************************************************************************
 * Copyright (c) 3 jul. 2013 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.interpreter;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.common.context.IComputationContext;
import com.netxforge.netxstudio.common.context.ObjectContext;
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
	public IComputationContext createContext(Object type) {
		return new ObjectContext<Object>(type);
	}

	public IComputationContext createPeriodContext(DateTimeRange dtr) {
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
