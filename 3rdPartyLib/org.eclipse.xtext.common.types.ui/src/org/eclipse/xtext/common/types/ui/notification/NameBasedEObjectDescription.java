/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.notification;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.Strings;

/**
 * Very simple description which actually wraps a qualified name. This description
 * cannot provide a {@link #getEObjectOrProxy() proxy} nor give access to an {@link #getEObjectURI() uri}.
 * It will return <code>null</code> when it is queried for an {@link #getEClass() EClass}.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NameBasedEObjectDescription implements IEObjectDescription {

	private final QualifiedName name;

	protected NameBasedEObjectDescription(QualifiedName name) {
		this.name = name;
	}
	
	public QualifiedName getName() {
		return name;
	}

	public QualifiedName getQualifiedName() {
		return name;
	}

	public EObject getEObjectOrProxy() {
		throw new UnsupportedOperationException("getEObjectOrProxy");
//		return null;
	}

	public URI getEObjectURI() {
		throw new UnsupportedOperationException("getEObjectURI");
//		return null;
	}

	public EClass getEClass() {
		return null;
	}

	public String getUserData(String name) {
		return null;
	}

	public String[] getUserDataKeys() {
		return Strings.EMPTY_ARRAY;
	}
	
	@Override
	public String toString() {
		return "[" + name + "] - NameBasedEObjectDescription";
	}

}
