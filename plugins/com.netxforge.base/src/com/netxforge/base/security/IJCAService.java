/*******************************************************************************
 * Copyright (c) May 22, 2011 NetXForge.
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
package com.netxforge.base.security;

import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public interface IJCAService {

	public abstract String encrypt(String password, Key key);

	public abstract String decrypt(String password, Key key);

	/**
	 * Create a key for use in the cipher code
	 */
	public abstract Key generateRandomKey() throws NoSuchAlgorithmException;

	/**
	 * Encode a secret key as a string that can be stored for later use.
	 * 
	 * @param key
	 * @return
	 */
	public abstract String encodeKey(Key key);

	/**
	 * Reconstruct a secret key from a string representation.
	 * 
	 * @param encodedKey
	 * @return
	 * @throws IOException
	 */
	public abstract Key decodeKey(String encodedKey) throws IOException;
	
	/**
	 * Create an MD5 message digest and return a hex String representation.
	 * 
	 * @param password
	 * @return
	 */
	public String digest(String password);
	
}