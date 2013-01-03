/*******************************************************************************
 * Copyright (c) 2 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.common;

/**
 * A Tuple object, which can be populated with any type. equality is delegated,
 * if both key and value are the same type and support the {@link Comparable}
 * interface.
 * 
 * @author Christophe Bouhier
 */
public class GenericsTuple<K, V> {

	protected K key;
	protected V value;

	private GenericsTuple(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public GenericsTuple<K, V> valueFor(K key, V value) {
		GenericsTuple<K, V> genericsTuple = new GenericsTuple<K, V>(key, value);
		return genericsTuple;
	}
	
	public boolean equals(Object object){
		
		return false;
	}
	
}
