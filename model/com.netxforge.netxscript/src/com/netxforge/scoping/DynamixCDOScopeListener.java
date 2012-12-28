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

import java.util.Set;

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
 * A listener for various CDO events. 
 * 
 * <uL>
 * <li>{@link CDOViewInvalidationEvent}</li>
 * <li>{@link CDOTransactionConflictEvent}</li>
 * <li>{@link ILifecycleEvent}</li>
 * </ul>
 * 
 * Most of the implementations have no purpose. 
 * This method only acts on the <code>CDOViewInvalidationEvent</code>
 * For this it calls our {@link DynamixCDOScopeProvider#updateURIMap(Set)} on the 
 * dirty objects. 
 * 
 * 
 * @author Martin Fluegge
 * @author Christophe Bouhier
 */
public class DynamixCDOScopeListener implements ICDOScopeListener {
	
	private DynamixCDOScopeProvider provider;

	public DynamixCDOScopeListener(DynamixCDOScopeProvider provider) {
		this.provider = provider;
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
		// Do nothing;
	}

	/**
	 * @since 1.0
	 */
	public void attachingObject(CDOTransaction transaction, CDOObject object) {
		// Do nothing;
	}

	/**
	 * @since 1.0
	 */
	public void detachingObject(CDOTransaction transaction, CDOObject object) {
		// Do nothing;
	}

	/**
	 * @since 1.0
	 */
	public void modifyingObject(CDOTransaction transaction, CDOObject object,
			CDOFeatureDelta featureDelta) { // This method can be overwritten be
											// subclasses
		// Do nothing;
	}

	/**
	 * @since 1.0
	 */
	public void committingTransaction(CDOTransaction transaction,
			CDOCommitContext commitContext) { // This method can be overwritten
												// be subclasses
		// Do nothing;
	}

	/**
	 * @since 1.0
	 */
	public void committedTransaction(CDOTransaction transaction,
			CDOCommitContext commitContext) { // This method can be overwritten
												// be subclasses
		// Do nothing;
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
		// Do nothing;
	}

	/**
	 * Invalidation could be on the CDOResource or any of the objects.
	 */
	public void handleViewInvalidationEvent(CDOViewInvalidationEvent event) {

		if (RuntimeActivator.DEBUG) {
			Set<CDOObject> dirtyObjects = event.getDirtyObjects();
			RuntimeActivator.TRACE.trace(
					RuntimeActivator.TRACE_NETXSCRIPT_SCOPING_OPTION,
					"invalidation: " + dirtyObjects.size());
			for (CDOObject dirtyObject : dirtyObjects) {
				RuntimeActivator.TRACE.trace(
						RuntimeActivator.TRACE_NETXSCRIPT_SCOPING_OPTION,
						"invalidation: " + dirtyObject);
			}
		}
		// update our scope provider.
		if (provider != null) {
			try {
				provider.updateURIMap(event.getDirtyObjects());
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		// Do nothing;
	}
}
