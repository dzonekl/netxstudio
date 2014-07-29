/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.screens.editing.base.util;

import java.util.List;

import org.eclipse.ui.forms.IMessage;

/**
 * A specialized event which provides validation information.
 * 
 * The event, could be aggregated, meaning one single message for as defined
 * by {@link AggregationValidationStatus}. 
 * 
 * @author Christophe Bouhier
 * 
 */
public class FormValidationEvent extends ValidationEvent {

	private static final long serialVersionUID = 1L;

	/*
	 * The messages.
	 */
	private List<IMessage> messages;

	public List<IMessage> getMessages() {
		return messages;
	}

	/**
	 * @param arg0
	 */
	public FormValidationEvent(Object arg0, List<IMessage> messages) {
		super(arg0);
		this.messages = messages;
	}

}
