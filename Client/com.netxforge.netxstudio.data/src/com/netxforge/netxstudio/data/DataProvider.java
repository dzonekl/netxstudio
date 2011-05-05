/*******************************************************************************
 * Copyright (c) May 3, 2011 NetXForge.
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
package com.netxforge.netxstudio.data;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsFactory;
import org.eclipse.xtext.xbase.XbaseFactory;

import com.netxforge.netxstudio.models.xtextwrapper.ArithmeticWrapper;
import com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper;
import com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperFactory;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 *
 */
@SuppressWarnings("restriction")
public class DataProvider implements IDataProvider {
	
	
	public EObject getObject() {
		return null;
	}
	
	public EObject getArithmeticWrapper() {
		ArithmeticWrapper wrapper = XtextwrapperFactory.eINSTANCE.createArithmeticWrapper();
		wrapper.setAsString("");
		wrapper.setEval(ArithmeticsFactory.eINSTANCE.createEvaluation());
		return wrapper;
	}
	
	public EObject getNetXScriptWrapper() {
		NetXScriptWrapper wrapper = XtextwrapperFactory.eINSTANCE.createNetXScriptWrapper();
		wrapper.setAsString("");
		wrapper.setXblock(XbaseFactory.eINSTANCE.createXBlockExpression());
		return wrapper;
	}
	
}
