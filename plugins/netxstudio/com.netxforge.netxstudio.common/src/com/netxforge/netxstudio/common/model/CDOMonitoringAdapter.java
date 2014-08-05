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
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOObjectHandler;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.spi.cdo.FSMUtil;
import org.eclipse.emf.spi.cdo.InternalCDOView;

import com.netxforge.netxstudio.common.internal.CommonActivator;
import com.netxforge.netxstudio.metrics.MetricValueRange;

/**
 * A scalable {@link EContentAdapter content adapter} that uses CDO mechanism to
 * attach itself to {@link CDOObject objects} when they are lazily loaded. </p>
 * Changed to also register an object handler on any root EObject. Will not add
 * an adapter to, non-filtered {@link EClass} objects. as we only update the
 * monitor when Values are added to the container which is the
 * {@link MetricValueRange }
 * 
 * 
 * FIXME, This implementation merges EContentAdapter and CDOLazyMonitoringAdapter. 
 * Model updates (Notifications) are processed indirectly through a CDO Object Handler.
 * 
 * @author Victor Roldan Betancort
 * @author Christophe Bouhier
 * @since 4.0
 */
public abstract class CDOMonitoringAdapter extends AdapterImpl {
	private CDOObjectHandler handler = new CleanObjectHandler();

	private Set<WeakReference<CDOObject>> adaptedObjects = new HashSet<WeakReference<CDOObject>>();

	/**
	 * The root object to be adapted.
	 */
	private WeakReference<CDOObject> adaptedRoot;

	/**
	 * Handles a notification by calling {@link #selfAdapt selfAdapter}.
	 */
	@Override
	public void notifyChanged(Notification notification) {
		// Decide what to do with notification, as the object handler kind of
		// produces
		// object state changes.
		super.notifyChanged(notification);
	}

	/**
	 * Handles installation of the adapter by adding the adapter to each of the
	 * directly contained objects.
	 */
	@Override
	public void setTarget(Notifier target) {
		if (target instanceof EObject) {
			setTarget((EObject) target);
		} else if (target instanceof Resource) {
			setTarget((Resource) target);
		} else if (target instanceof ResourceSet) {
			setTarget((ResourceSet) target);
		} else {
			basicSetTarget(target);
		}
	}

	protected void setTarget(EObject target) {

		System.out.println("Monitoring adapted: " + adaptedObjects);

		if (isConnectedObject(target)) {
			if (adaptedRoot == null) {
				adaptedRoot = new WeakReference<CDOObject>(
						CDOUtil.getCDOObject(target));
			}

			// Do not change the target.
			if (this.getTarget() == null) {
				basicSetTarget(target);
				// if (target instanceof Resource) {
				addCleanObjectHandler(target);
			}
			// }
		} else {
			super.setTarget(target);
		}
	}

	/**
	 * EContentAdapter removes adapter from all contained EObjects. In this
	 * case, we remove this adapter from all lazily loaded objects
	 */
	protected void unsetTarget(EObject target) {

		if (CommonActivator.DEBUG) {
			CommonActivator.TRACE.trace(
					CommonActivator.TRACE_COMMON_MONITORING_OPTION,
					"Removing adapter for: " + target);
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

	/**
	 * Actually sets the target by calling super.
	 */
	protected void basicSetTarget(Notifier target) {
		super.setTarget(target);
	}

	/**
	 * Actually unsets the target by calling super.
	 */
	protected void basicUnsetTarget(Notifier target) {
		super.unsetTarget(target);
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

			view.addObjectHandler(handler);

			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_MONITORING_OPTION,
						"Initial adapt loaded objects started");
			}

			// Adapt already loaded objects, this will repeat several times.
			//
			for (CDOObject cdoObject : view.getObjects().values()) {
				addAdapter(cdoObject);
			}
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

	protected void addAdapter(Notifier notifier) {

		boolean shouldAdapt = isConnectedObject(notifier)
				&& !isAlreadyAdapted(notifier)
				&& isRelated((CDOObject) notifier)
				&& isNotFiltered((EObject) notifier);

		if (shouldAdapt) {

			adaptedObjects.add(new WeakReference<CDOObject>(CDOUtil
					.getCDOObject((EObject) notifier)));

			// For some types we would like to be notified, but with the same
			// adapter.
			// This is for example a Metric Value Range. (MVR).
			// Check if it's not filtered (So pass this guard) but a different
			// type.

			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_MONITORING_OPTION,
						"Self-adapt for: " + notifier);
			}

			if (isSameAdapterFor((EObject) notifier)) {
				doAddAdapter(notifier);
			} else {

				// We don't want to add self as adapter, so let the factory
				// adapt for
				// the notifier.
				final Adapter adapt = getAdapterFactory().adapt(notifier,
						IMonitoringSummary.class);
				if (CommonActivator.DEBUG) {
					CommonActivator.TRACE.trace(
							CommonActivator.TRACE_COMMON_MONITORING_OPTION,
							"result adapter: " + adapt);
				}
			}
		} else {
			// When not adapting the target object, the adapter instance if
			// still produced.
			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE
						.trace(CommonActivator.TRACE_COMMON_MONITORING_DETAILS_OPTION,
								"Self-adapt cancelled for:"
										+ notifier
										+ " (Already adapted, not connected, not allowed, not contained)");
			}
			return;
		}
	}

	protected void doAddAdapter(Notifier notifier) {
		notifier.eAdapters().add(this);
	}

	/**
	 * Clients must implement. {@link AdapterFactory#isFactoryForType(Object)}
	 * should be <code>true</code for the targets children.
	 */
	protected abstract AdapterFactory getAdapterFactory();

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

		if (root instanceof Resource) {
			return root == (object instanceof Resource ? object : object
					.cdoResource());
		}

		boolean isAncestor = EcoreUtil.isAncestor(root, object);
		return isAncestor;
	}

	/**
	 * When self-adapting, the implementation controls if child objects or
	 * objects already connected should use the same adapter or not.
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
		public void objectStateChanged(CDOView view, CDOObject object,
				CDOState oldState, CDOState newState) {
			if (CommonActivator.DEBUG) {
				CommonActivator.TRACE.trace(
						CommonActivator.TRACE_COMMON_MONITORING_DETAILS_OPTION,
						"Object handler invoked: " + object + "( " + oldState
								+ "-->" + newState + " )");
			}
			// REMOVE LATER
			System.out.println("Object handler invoked: " + object + "( "
					+ oldState + "-->" + newState + " )");

			if (newState == CDOState.CLEAN || newState == CDOState.NEW) {
				addAdapter(object);
			}
		}
	}
}
