/*******************************************************************************
 * Copyright (c) 2006, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

package com.netxforge.netxstudio.internal.navigator.resources.workbench;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.netxforge.netxstudio.navigator.resources.NetXStudioExplorer;

/**
 * An property sheet page adapter factory for the Project Explorer.
 *  
 * @since 3.2
 */
public class TabbedPropertySheetAdapterFactory
    implements IAdapterFactory {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object,
     *      java.lang.Class)
     */
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adaptableObject instanceof NetXStudioExplorer) {
        	if (IPropertySheetPage.class == adapterType)
                return new TabbedPropertySheetPage(
                    new TabbedPropertySheetProjectExplorerContributor(
                        (CommonNavigator) adaptableObject));
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
     */
    public Class[] getAdapterList() {
        return new Class[] {IPropertySheetPage.class};
    }

}
