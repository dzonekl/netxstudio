/*******************************************************************************
 * Copyright (c) 2004 - 2011 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package com.netxforge.scoping;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionConflictEvent;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent;

import com.netxforge.internal.RuntimeActivator;

/**
 * @author Martin Fluegge
 * @author Christophe Bouhier
 */
public class CDOScopeListener implements ICDOScopeListener// implements
// IListener
{
	/**
	 * @since 1.0
	 */
	public CDOScopeListener() {
	}

	public void notifyEvent(IEvent event) {
		if (event instanceof CDOViewInvalidationEvent) {
			handleViewInvalidationEvent((CDOViewInvalidationEvent) event);
		} else if (event instanceof CDOTransactionConflictEvent) {
			handleTransactionConflictEvent((CDOTransactionConflictEvent) event);
		} else if (event instanceof ILifecycleEvent) {
			this.handleLifeCycleEvent((ILifecycleEvent) event);
		}

	}

	// Override.
	protected void handleLifeCycleEvent(ILifecycleEvent event) {
		if (RuntimeActivator.DEBUG) {
			System.out.println("CDOSCOPE lifecycle event");
		}
	}

	/**
	 * @since 1.0
	 */
	public void attachingObject(CDOTransaction transaction, CDOObject object) {
		if (RuntimeActivator.DEBUG) {
			System.out.println("CDOSCOPE attaching object event");
		}
	}

	/**
	 * @since 1.0
	 */
	public void detachingObject(CDOTransaction transaction, CDOObject object) {
		if (RuntimeActivator.DEBUG) {
			System.out.println("CDOSCOPE detaching object event");
		}
	}

	/**
	 * @since 1.0
	 */
	public void modifyingObject(CDOTransaction transaction, CDOObject object,
			CDOFeatureDelta featureDelta) { // This method can be overwritten be
											// subclasses
		if (RuntimeActivator.DEBUG) {
			System.out.println("CDOSCOPE modifying object event");
		}

	}

	/**
	 * @since 1.0
	 */
	public void committingTransaction(CDOTransaction transaction,
			CDOCommitContext commitContext) { // This method can be overwritten
												// be subclasses
		if (RuntimeActivator.DEBUG) {
			System.out.println("CDOSCOPE commit event");
		}

	}

	/**
	 * @since 1.0
	 */
	public void committedTransaction(CDOTransaction transaction,
			CDOCommitContext commitContext) { // This method can be overwritten
												// be subclasses
		if (RuntimeActivator.DEBUG) {
			System.out.println("CDOSCOPE committed event");
		}
	}

	/**
	 * @since 1.0
	 */
	public void rolledBackTransaction(CDOTransaction transaction) { // This
																	// method
																	// can be
																	// overwritten
																	// be
																	// subclasses
		if (RuntimeActivator.DEBUG) {
			System.out.println("CDOSCOPE rollback event");
		}
	}

	/**
	 * @since 1.0
	 */
	public void handleViewInvalidationEvent(CDOViewInvalidationEvent event) { // This
																				// method
																				// can
																				// be
																				// overwritten
																				// be
																				// subclasses
		if (RuntimeActivator.DEBUG) {
			System.out.println("CDOSCOPE invalidation event");
		}

	}

	/**
	 * @since 1.0
	 */
	public void handleTransactionConflictEvent(CDOTransactionConflictEvent event) { // This
																					// method
																					// can
																					// be
																					// overwritten
																					// be
																					// subclasses
		if (RuntimeActivator.DEBUG) {
			System.out.println("CDOSCOPE conflict event");
		}

	}
}
