/*******************************************************************************
 * Copyright (c) Apr 23, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.actions.clipboard;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;

import com.google.inject.Singleton;

/**
 * Facility to bridge CDO to the clipboard.
 * Work In Progress, Do not use yet!
 * 
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
@Singleton
public class ClipboardService {

	Clipboard clipboard;

	final static boolean IS_MAC, IS_GTK, IS_MOTIF;
	static {
		String platform = SWT.getPlatform();
		IS_MAC = "carbon".equals(platform) || "cocoa".equals(platform);
		IS_GTK = "gtk".equals(platform);
		IS_MOTIF = "motif".equals(platform);
	}

	ClipboardService() {
		clipboard = new Clipboard(Display.getDefault());
	}

	/**
	 * Copy an object to the clipboard. Only clean objects are copied.
	 * 
	 * Specify which features of the object should be copied as text. Features
	 * of type string are nicely serialized, other types are converted with toString(). 
	 * 
	 */
	@SuppressWarnings("unused")
	public void copyCDOObjectToClipboard(CDOObject object, EAttribute[] features) {

		if (object.cdoState() == CDOState.CLEAN) {
			for (EAttribute feature : features) {
				
				Object eGet = object.eGet(feature);
				EClassifier eType = feature.getEType();
			}
		}
	}

	/**
	 * Copy as plain text, do not use the platform delimiters.
	 * 
	 * @param plainText
	 * @param clipboardType
	 * @throws SWTError
	 */
	public void setClipboardContent(String plainText, int clipboardType)
			throws SWTError {
		if (clipboardType == DND.SELECTION_CLIPBOARD && !(IS_MOTIF || IS_GTK))
			return;
		TextTransfer plainTextTransfer = TextTransfer.getInstance();
		// TextWriter plainTextWriter = new TextWriter(start, length);
		// String plainText = getPlatformDelimitedText(plainTextWriter);
		Object[] data = null;
		Transfer[] types = null;
		if (clipboardType == DND.SELECTION_CLIPBOARD) {
			data = new Object[] { plainText };
			types = new Transfer[] { plainTextTransfer };
		}

		// else {
		// RTFTransfer rtfTransfer = RTFTransfer.getInstance();
		// RTFWriter rtfWriter = new RTFWriter(start, length);
		// String rtfText = getPlatformDelimitedText(rtfWriter);
		// data = new Object[]{rtfText, plainText};
		// types = new Transfer[]{rtfTransfer, plainTextTransfer};
		// }
		clipboard.setContents(data, types, clipboardType);
	}

}
