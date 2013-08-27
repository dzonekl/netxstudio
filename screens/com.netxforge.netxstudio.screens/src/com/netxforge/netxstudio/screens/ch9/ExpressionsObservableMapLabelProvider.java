/*******************************************************************************
 * Copyright (c) 20 nov. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.ch9;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.Expression;

/**
 * 
 * @author Christophe Bouhier
 */
public class ExpressionsObservableMapLabelProvider extends
		ObservableMapLabelProvider {

	private ModelUtils modelUtils;

	public ExpressionsObservableMapLabelProvider(IObservableMap[] attributeMaps) {
		super(attributeMaps);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof Expression) {
			Expression expression = (Expression) element;
			switch (columnIndex) {
			case 0: {
				return "...[TODO]";
				// TODO Implement an Action to do a CDO XRef finding all
				// references and listing
				// then in a view. Or better, show-in references in a special
				// view.
			}
			case 1: {

				// Use a name provider....
				return expression.getName().startsWith(
						ModelUtils.GENERATED_EXPRESSION_PREFIX) ? "GENERATED"
						: "USER ENTRY";
			}

			case 2: {
				if (expression.getName() != null) {
					return expression.getName();
				}
			}
			case 3: {
				String expressionAsString = modelUtils
						.expressionAsString(expression);
				return expressionAsString;
			}
			}
		}

		return super.getColumnText(element, columnIndex);
	}

	public void setModelUtils(ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
	}
}