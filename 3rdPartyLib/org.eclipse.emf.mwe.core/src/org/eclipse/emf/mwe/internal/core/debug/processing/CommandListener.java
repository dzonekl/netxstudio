/*******************************************************************************
 * Copyright (c) 2005 - 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.mwe.internal.core.debug.processing;

import java.io.IOException;

/**
 * Interface to listen for regular process commands from the debug server (e.g. eclipse).
 */
public interface CommandListener {

	/**
	 * listen for the next regular process command. This method could be a long running one that waits until the
	 * user starts the next debug action.
	 * 
	 * @throws IOException
	 */
	public void listenCommand() throws IOException;

}
