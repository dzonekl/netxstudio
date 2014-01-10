/*******************************************************************************
 * Copyright (c) 21 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.server.test.base;

import java.io.IOException;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.EresourcePackage;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

/**
 * Test to expose a collection which can not resolve proxy objects. and attempt
 * to delete them.
 * 
 * @author Christophe Bouhier
 */
public class ProxyObjectTest extends AbstractInjectedTestJUnit4 {

	private static final String USERID_TEST = "admin";

	@Inject
	private IData provider;

	@Inject
	private ModelUtils modelUtils;

	@Before
	public void before() {

		this.getClientInjector().injectMembers(this);
		provider.openSession("admin", "admin");
	}

	@After
	public void after() {
		provider.closeSession();
	}

	@Test
	public void testNetXResourceAdapter() {

		CDOResource commitEntries = (CDOResource) provider
				.getCommitInfoResource(USERID_TEST);

		int indexLastNonProxyObject = 0;

		for (int i = 0; i < commitEntries.getContents().size(); i++) {
			EObject eo = commitEntries.getContents().get(i);
			CDOObject cdoObject = CDOUtil.getCDOObject(eo);
			if (CDOUtil.isStaleObject(eo)) {
				System.out.println(cdoObject + " is a stale object");
				CDOUtil.cleanStaleReference(commitEntries,
						EresourcePackage.Literals.CDO_RESOURCE__CONTENTS,
						i);

			} else {
				indexLastNonProxyObject = i;
			}
		}
		
		try {
			commitEntries.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out
				.println("index of last non-proxy object in CommitEntry for user: "
						+ USERID_TEST + " is: " + indexLastNonProxyObject);

	}
}
