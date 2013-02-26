/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.emf.mwe.core.resources;

import java.io.InputStream;
import java.net.URL;

public interface ResourceLoader {

    /**
     * 
     * @param uri
     *            Identifier for a resource
     * @return InputStream for the specified resource.
     */
    public InputStream getResourceAsStream(String uri);

    /**
     * 
     * @param clazzName
     *            The class name
     * @return The class instance or null if no such class could be found
     */
    public Class<?> loadClass(String clazzName);

    public URL getResource(String uri);
    
}
