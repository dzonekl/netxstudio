package com.netxforge.netxstudio.common.model;

/*
 * Copyright (c) 2004 - 2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Victor Roldan Betancort - initial API and implementation
 */

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOObjectHandler;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.spi.cdo.FSMUtil;
import org.eclipse.emf.spi.cdo.InternalCDOView;

import com.netxforge.netxstudio.common.internal.CommonActivator;

/**
 * A scalable {@link EContentAdapter content adapter} that uses CDO mechanism to
 * attach itself to {@link CDOObject objects} when they are lazily loaded. </p>
 * Changed to also register an object handler on any root EObject. Uses a
 * {@link MonitoringAdapterFactory factory} to self-adapt loaded objects
 * considering the criteria of the implementation. </p> --Will self-adapt for
 * non filtered {@link EClass object types} see {@link #isNotFiltered(EObject)}
 * </p> --Will self-adapt for related {@link EObject objects} see
 * {@link #isRelated(CDOObject)} </p> --Will attach the this adapter for
 * {@link EClass object types} see {@link #isSameAdapterFor(EObject)} In te last
 * case the target is not replaced, so the first {@link Notifier} holding the
 * adapter will be the {@link #getTarget() target } of the adapter.
 * 
 * @author Victor Roldan Betancort
 * @author Christophe Bouhier
 * @since 4.0
 */
public abstract class CDOLazyMonitoringAdapter extends EContentAdapter {

	private CDOObjectHandler handler = new CleanObjectHandler();

	private Set<WeakReference<CDOObject>> adaptedObjects = new HashSet<WeakReference<CDOObject>>();

	/**
	 * The root object to be adapted.
	 */
	private WeakReference<CDOObject> adaptedRoot;

	@Override
	protected void setTarget(EObject target) {

		if (isConnectedObject(target)) {
			if (adaptedRoot == null) {
				adaptedRoot = new WeakReference<CDOObject>(
						CDOUtil.getCDOObject(target));
			}
			// Do not change the target.
			if (this.getTarget() == null) {
				basicSetTarget(target);
				addCleanObjectHandler(target);
			}
		} else {
			super.setTarget(target);
		}
	}

	/**
	 * EContentAdapter removes adapter from all contained EObjects. In this
	 * case, we remove this adapter from all lazily loaded objects
	 */
	@Override
	protected void unsetTarget(EObject target) {

		if (CommonActivator.DEBUG) {
			CommonActivator.TRACE.trace(
					CommonActivator.TRACE_COMMON_MONITORING_OPTION,
					"Removed adapter (this) for: " + target);
		}
		if (isConnectedObject(target)) {
			basicUnsetTarget(target);
			// if (target instanceof Resource) {

			InternalCDOView view = getCDOView(target);
			if (view != null) {
				// Remove adapter from all self-adapted child objects.
				for (WeakReference<CDOObject> weakReference : adaptedObjects) {
					CDOObject object = weakReference.get();
					if (object != null) {
						IMonitoringSummary toRemove = null;
						for (Adapter a : object.eAdapters()) {
							if (a instanceof IMonitoringSummary) {
								toRemove = (IMonitoringSummary) a;
								break;
							}
						}
						if (toRemove != null) {
							object.eAdapters().remove(toRemove);
						}

						// removeAdapter(object);
					}
				}
			}

			target.eAdapters().remove(this);
			removeCleanObjectHandler(target);
			// }
		} else {
			super.unsetTarget(target);
		}
	}

	private void addCleanObjectHandler(EObject target) {
		InternalCDOView view = getCDOView(target);
		if (view != null) {
			CDOObjectHandler[] handlers = view.getObjectHandlers();
			for (CDOObjectHandler handler : handlers) {
				if (handler.equals(this.handler)) {
					return;
				}
			}

			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_MONITORING_OPTION,
						"Initial adapt loaded objects started");
			}
			view.addObjectHandler(handler);
			
			// Adapt already loaded objects, this will repeat several times.
			// As we iterate over the objects in the view, the body of the
			// iteration should never lead
			// to a case whereby additional objects are added to the list.

			// CB, SEPARATE CONCERN.

			// ImmutableList<InternalCDOObject> copyOf =
			// ImmutableList.copyOf(view
			// .getObjects().values());
			// for (CDOObject cdoObject : copyOf) {
//			 addAdapter(target);
			// }
		
		}
	}

	private void removeCleanObjectHandler(EObject target) {
		InternalCDOView view = getCDOView(target);
		if (view != null) {
			CDOObjectHandler[] handlers = view.getObjectHandlers();
			for (CDOObjectHandler handler : handlers) {
				if (handler.equals(this.handler)) {
					view.removeObjectHandler(handler);
					break;
				}
			}
		}
	}

	@Override
	protected void addAdapter(Notifier notifier) {

		boolean isConnected = isConnectedObject(notifier);
		boolean isAlreadyAdapted = isAlreadyAdapted(notifier);
		boolean isNotFiltered = isNotFiltered((EObject) notifier);
		
		// CB TODO Skip related, as this loads too many objects... 
//		boolean isRelated = isRelated((CDOObject) notifier);

		if (isConnected && !isAlreadyAdapted && isNotFiltered ) {

			adaptedObjects.add(new WeakReference<CDOObject>(CDOUtil
					.getCDOObject((EObject) notifier)));

			// For some types we would like to be notified, but with the same
			// adapter.
			// This is for example a Metric Value Range. (MVR).
			// Check if it's not filtered (So pass this guard) but a different
			// type.

			if (isSameAdapterFor((EObject) notifier)) {
				// WARNING! The call to super addAdapter replaces the target of
				// this adapter.
				// (EAdapterList calls setTarget on this adapter, which calls
				// basicSetTarget()
				// The implication is that getTarget() yields an arbitrary
				// result.
				super.addAdapter(notifier);

				if (CommonActivator.DEBUG) {
					CommonActivator.TRACE.trace(
							CommonActivator.TRACE_COMMON_MONITORING_OPTION,
							"result adapter: " + this + " (Same as this)");
				}
			} else {

				// We don't want to add self as adapter, so let the factory
				// adapt for
				// the notifier.
				
				// Don't do self-adaptation here...
				
//				final Adapter adapt = getAdapterFactory().adapt(notifier,
//						IMonitoringSummary.class);
//
//				if (CommonActivator.DEBUG) {
//					CommonActivator.TRACE.trace(
//							CommonActivator.TRACE_COMMON_MONITORING_OPTION,
//							"result adapter: " + adapt);
//				}
			}
		} else {
			// When not adapting the target object, the adapter instance if
			// still produced.
			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_MONITORING_DETAILS_OPTION,
						"Self-adapt cancelled for:" + notifier + "Connected ="
								+ isConnected + ", Adapted =" + isAlreadyAdapted
								+ ", Not filtered =" + isNotFiltered);
//								+ " Related=" + isRelated);
			}
			return;
		}

		//

	}

	private boolean isAlreadyAdapted(Notifier notifier) {

		for (Adapter a : notifier.eAdapters()) {
			if (a instanceof IMonitoringSummary) {
				return true;
			}
		}
		return false;

		// return notifier.eAdapters().contains(this);
	}

	private static InternalCDOView getCDOView(EObject target) {
		CDOObject object = CDOUtil.getCDOObject(target);
		if (object != null) {
			return (InternalCDOView) object.cdoView();
		}

		return null;
	}

	private static boolean isConnectedObject(Notifier target) {
		if (target instanceof EObject) {
			CDOObject object = CDOUtil.getCDOObject((EObject) target);
			if (object != null) {
				return !FSMUtil.isTransient(object);
			}
		}

		return false;
	}

	protected abstract boolean isRelated(CDOObject object);

	/**
	 * Checks if the argument is contained in the object graph of the root
	 * element
	 * 
	 */
	protected boolean isContained(CDOObject object) {
		if (adaptedRoot == null) {
			return false;
		}

		CDOObject root = adaptedRoot.get();
		if (object == null) {
			return false;
		}

		// In the CDO Version of this adapter, the root is always a Resource,
		// there for container hierachy is not checked, which would not lead to
		// a
		// concurrentmod exception. To solve, there for remove.
		// if (root instanceof Resource) {
		// return root == (object instanceof Resource ? object : object
		// .cdoResource());
		// }

		// CB isAncestor doesn't work on equality of CDO Objects!
		// Compare on cdo id.

		boolean isAncestor = isAncestor(root, object);
		return isAncestor;
	}

	public static boolean isAncestor(EObject ancestorEObject, EObject eObject) {
		if (eObject != null) {
			if (eObject == ancestorEObject) {
				return true;
			}

			int count = 0;
			for (InternalEObject eContainer = ((InternalEObject) eObject)
					.eInternalContainer(); eContainer != null
					&& eContainer != eObject; eContainer = eContainer
					.eInternalContainer()) {
				if (++count > 100000) {
					return isAncestor(ancestorEObject, eContainer);
				}

				if (eContainer instanceof CDOObject
						&& ancestorEObject instanceof CDOObject) {

					CDOID cdoID = ((CDOObject) eContainer).cdoID();
					CDOID cdoID2 = ((CDOObject) ancestorEObject).cdoID();

					return cdoID == cdoID2;
				} else {
					if (eContainer == ancestorEObject) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * When self-adapting, the implementation controls if child objects or
	 * objects already connected should use the same adapter or not. Note: We do
	 * not replace the target in contrary to {@link EContentAdapter}
	 * 
	 * @param object
	 * @return
	 */

	protected abstract boolean isSameAdapterFor(EObject object);

	/**
	 * When self-adapting, the implementation controls if child objects or
	 * objects already connected be self-adapted. This could add the very same
	 * adapter of the initial target, or invoke the adapter factory to create a
	 * new adapter.
	 * 
	 * @param object
	 * @return
	 */
	protected abstract boolean isNotFiltered(EObject object);

	/**
	 * @author Victor Roldan Betancort
	 */
	private final class CleanObjectHandler implements CDOObjectHandler {

		private CDOObject currentAddingObject;

		public void objectStateChanged(CDOView view, CDOObject object,
				CDOState oldState, CDOState newState) {
			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_MONITORING_DETAILS_OPTION,
						"Object handler invoked: " + object + "( " + oldState
								+ "-->" + newState + " )");
			}
			if (newState == CDOState.CLEAN || newState == CDOState.NEW) {
				
				
				
				// During this phase, we perform various checks which could load
				// objects in the CDOView, leading to this method being called.
				// to avoid circularity, we make sure we are not processing an
				// object currently
				// being processed.
				if (currentAddingObject == null) {
					addAdapter(object);

				} else if (currentAddingObject != object) {
					currentAddingObject = object;
				}

			}
		}
	}

	/**
	 * Only set the target once for this adapter.
	 */
	@Override
	protected void basicSetTarget(Notifier target) {
		if (super.getTarget() == null) {
			super.basicSetTarget(target);
		}
	}
}
