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
package com.netxforge.netxstudio.data.test;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.netxforge.netxstudio.Netxstudio;
import com.netxforge.netxstudio.NetxstudioFactory;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Person;

/**
 * A test provider which creates dummy objects. 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class TestDataProvider implements IDataProvider {
	
	
	public EObject getObject() {
		return null;
	}
	
	public EObject getNetXScriptWrapper() {
//		NetXScriptWrapper wrapper = XtextwrapperFactory.eINSTANCE.createNetXScriptWrapper();
//		wrapper.setAsString("");
//		wrapper.setXblock(XbaseFactory.eINSTANCE.createXBlockExpression());
//		return wrapper;
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataProvider#getNetXStudio()
	 */
	public Netxstudio getNetXStudio() {
		Netxstudio studio = NetxstudioFactory.eINSTANCE.createNetxstudio();
		studio.getUsers().add(getPerson());
		studio.getUsers().add(getPerson("Eric", "Meijer", "eric.meijer","Eric@vdvl.nl"));
		return studio;
	}
	
	public Person getPerson() {
		Person p = GenericsFactory.eINSTANCE.createPerson();
		p.setFirstName("Christophe");
		p.setLastName("Bouhier");
		p.setLogin("christophe.bouhier");
		p.setEmail("christophe.bouhier@netxforge.com");
		return p;
	}
	
	public Person getPerson(String first, String last, String login, String email) {
		Person p = GenericsFactory.eINSTANCE.createPerson();
		p.setFirstName(first);
		p.setLastName(last);
		p.setLogin(login);
		p.setEmail(email);
		return p;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataProvider#getNetXStudio(org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public Netxstudio getNetXStudio(ResourceSet set) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataProvider#getResource(org.eclipse.emf.ecore.resource.ResourceSet, int)
	 */
	public Resource getResource(ResourceSet set, int feature) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataProvider#openSession(java.lang.String, java.lang.String)
	 */
	public void openSession(String uid, String passwd) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataProvider#getSessionUserID()
	 */
	public String getSessionUserID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataProvider#getResource(int)
	 */
	public Resource getResource(int feature) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataProvider#getSession()
	 */
	public CDOSession getSession() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
