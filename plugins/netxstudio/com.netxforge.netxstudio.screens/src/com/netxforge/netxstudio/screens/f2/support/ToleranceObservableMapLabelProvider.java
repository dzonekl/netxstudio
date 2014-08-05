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
 *******************************************************************************/ package com.netxforge.netxstudio.screens.f2.support;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Tolerance;

public class ToleranceObservableMapLabelProvider extends
		ObservableMapLabelProvider {

	public ToleranceObservableMapLabelProvider(IObservableMap[] attributeMaps) {
		 super(attributeMaps);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof Tolerance) {
			Tolerance t = (Tolerance) element;
			switch (columnIndex) {
			case 0: {
				if (t.getName() != null) {
					return t.getName();
				}
			}
			case 1: {
				if (t.getLevel() != null) {
					return t.getLevel().getName();
				}
			}
			case 2: {
				if (t.getExpressionRef() != null) {
					Expression e = t.getExpressionRef();
					EList<String> s = e.getExpressionLines();
					if (s.size() > 0) {
						return s.get(0) + "...";
					}
				}
			}
				break;
			}
		}

		return super.getColumnText(element, columnIndex);
	}
}