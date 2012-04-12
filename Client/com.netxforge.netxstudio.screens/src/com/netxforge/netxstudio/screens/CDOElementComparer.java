/*******************************************************************************
 * Copyright (c) Apr 6, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.jface.viewers.IElementComparer;


/**
 * A custom comparer which can deal with CDO Objects. 
 * @author Christophe
 *
 */
public class CDOElementComparer implements IElementComparer {
    
    public int hashCode(Object element) {
        if( element instanceof IObservable ) {
            return System.identityHashCode(element);
        } else if( element instanceof CDOObject ) {
        	CDOID cdoID = ((CDOObject)element).cdoID();
            return (element.getClass().getName() + "+" + cdoID).hashCode();
        }
        return element.hashCode();
    }
    
    public boolean equals(Object a, Object b) {
        if( a instanceof IObservable && b instanceof IObservable ) {
            return a == b;
        } else if( a instanceof CDOObject && b instanceof CDOObject ) {
            return hashCode(a) == hashCode(b); 
        }
        return a.equals(b);
    }
}

