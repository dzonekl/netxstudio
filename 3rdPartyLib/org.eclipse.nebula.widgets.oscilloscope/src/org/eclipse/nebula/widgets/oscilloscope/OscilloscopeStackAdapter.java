/*******************************************************************************
 *  Copyright (c) 2010 Weltevree Beheer BV, Remain Software & Industrial-TSI
 * 
 * All rights reserved. 
 * This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Wim S. Jongman - initial API and implementation
 ******************************************************************************/
package org.eclipse.nebula.widgets.oscilloscope;

/**
 * Listener for an empty stack. It enables you to input more values only if the
 * stack runs out of values.
 * 
 * @author Wim.Jongman (@remainsoftware.com)
 * 
 */
public abstract class OscilloscopeStackAdapter {

	/**
	 * Is called when the stack runs out of values.
	 * 
	 * @param scope
	 */
	public void stackEmpty(Oscilloscope scope) {
	}
}
