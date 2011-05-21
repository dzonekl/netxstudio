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
package com.netxforge.netxstudio.screens.editing.observables;

import java.util.List;

import org.eclipse.ui.forms.IMessage;

/**
 * A specialized event which provides validation information 
 * suitable for a {@link org.eclipse.ui.forms.widgets.Form}
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class FormValidationEvent extends ValidationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The IMessage type.
	 */
	private int msgType;

	/**
	 * The list of IMessages, which have led to this event.
	 */
	private List<IMessage> messages;

	/**
	 * @param arg0
	 * @param msgType
	 * @param messages
	 */
	public FormValidationEvent(Object arg0, int msgType, List<IMessage> messages) {
		super(arg0);
		this.msgType = msgType;
		this.messages = messages;
	}

	public int getMsgType() {
		return msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

	public List<IMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<IMessage> messages) {
		this.messages = messages;
	}

	/**
	 * @param arg0
	 */
	public FormValidationEvent(Object arg0) {
		super(arg0);
	}
}
