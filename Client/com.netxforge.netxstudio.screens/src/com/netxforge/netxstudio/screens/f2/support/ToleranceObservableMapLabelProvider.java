package com.netxforge.netxstudio.screens.f2.support;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Tolerance;

public class ToleranceObservableMapLabelProvider extends ObservableMapLabelProvider{

	public ToleranceObservableMapLabelProvider(
			IObservableMap[] attributeMaps) {
		super(attributeMaps);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if(element instanceof Tolerance){
			Tolerance t = (Tolerance)element;
			switch(columnIndex){
			case 2:{
				if(t.getExpressionRef() != null){
					Expression e = t.getExpressionRef();
					EList<String> s = e.getExpressionLines();
					if(s.size() > 0){
						return s.get(0) + "...";
					}
				}
			}break;
			}
		}
		
		return super.getColumnText(element, columnIndex);
	}
}