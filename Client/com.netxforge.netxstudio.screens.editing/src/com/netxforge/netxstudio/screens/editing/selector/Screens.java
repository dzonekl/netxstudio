/*******************************************************************************
 * Copyright (c) May 9, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.selector;

/**
 * Screens operations and utilities on operations.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
public class Screens {
	
	public static final int OPERATION_EDIT = 0x0100;
	public static final int OPERATION_NEW = 0x0200;
	public static final int OPERATION_READ_ONLY = 0x0400;
	
	public static boolean isNewOperation(int operation){
		return (operation & OPERATION_NEW) != 0;
	}
	
	public static boolean isEditOperation(int operation){
		return (operation & OPERATION_EDIT) != 0;
	}
	
	public static boolean isReadOnlyOperation(int operation){
		return (operation & OPERATION_READ_ONLY) != 0;
	}

}
