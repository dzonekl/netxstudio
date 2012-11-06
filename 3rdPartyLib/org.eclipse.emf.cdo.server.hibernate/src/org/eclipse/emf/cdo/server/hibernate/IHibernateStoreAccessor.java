/**
 * Copyright (c) 2004 - 2011 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.server.hibernate;

import org.eclipse.emf.cdo.server.IStoreAccessor;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.hibernate.Session;

/**
 * @author Eike Stepper
 */
public interface IHibernateStoreAccessor extends IStoreAccessor
{
  public IHibernateStore getStore();

  /**
   * @since 2.0
   */
  public IHibernateStoreChunkReader createChunkReader(InternalCDORevision revision, EStructuralFeature feature);

  public Session getHibernateSession();
}
