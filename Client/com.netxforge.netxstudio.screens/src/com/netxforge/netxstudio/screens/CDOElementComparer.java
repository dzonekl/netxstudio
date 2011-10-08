package com.netxforge.netxstudio.screens;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.jface.viewers.IElementComparer;

import com.netxforge.netxstudio.generics.Base;


public class CDOElementComparer implements IElementComparer {
    
    public int hashCode(Object element) {
        if( element instanceof IObservable ) {
            return System.identityHashCode(element);
        } else if( element instanceof Base ) {
            return (element.getClass().getName() + "+" + ((Base)element).cdoID()).hashCode();
        }
        return element.hashCode();
    }
    
    public boolean equals(Object a, Object b) {
        if( a instanceof IObservable && b instanceof IObservable ) {
            return a == b;
        } else if( a instanceof Base && b instanceof Base ) {
            return hashCode(a) == hashCode(b);
        }
        return a.equals(b);
    }
}

