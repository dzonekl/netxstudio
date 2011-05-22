/*******************************************************************************
 * Copyright (c) May 22, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.common.tests;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import com.netxforge.netxstudio.common.CommonService;
import com.netxforge.netxstudio.common.jca.JCAService;

/**
 */
public class JCATest extends TestCase {

	private String STRING_TO_ENCRYPT = "The quick red fox jumps over the wire";

	JCAService jcaService = new JCAService();

	public void testCipherJCA() {

		CommonService commonService = new CommonService(jcaService);
		try {
			Key k = commonService.getJcasService().generateRandomKey();
			String encrypted = commonService.getJcasService().encrypt(
					STRING_TO_ENCRYPT, k);

			String decrypt = commonService.getJcasService().decrypt(encrypted,
					k);

			assertEquals("Should be equal", STRING_TO_ENCRYPT, decrypt);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public void testDigestJCA() {

		CommonService commonService = new CommonService(jcaService);
		String digest = commonService.getJcasService()
				.digest(STRING_TO_ENCRYPT);
		String digest2 = commonService.getJcasService().digest(
				STRING_TO_ENCRYPT);
		assertEquals("Should be equal", digest, digest2);

	}

	public static void main(String[] args) {
		TestRunner.run(JCATest.class);
	}

}
