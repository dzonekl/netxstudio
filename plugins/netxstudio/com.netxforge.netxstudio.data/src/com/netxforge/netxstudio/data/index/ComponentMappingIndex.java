/*******************************************************************************
 * Copyright (c) Mar 29, 2012 NetXForge.
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
package com.netxforge.netxstudio.data.index;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.net4j.util.event.IListener;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Singleton;
import com.netxforge.base.cdo.CDO;
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.index.IComponentLocator.IdentifierDescriptor;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;

/**
 * A Component indexing service. Holds to a {@link CDOView} during the lifecycle
 * of the service. Indexing occurs in the background with a system {@link Job}.
 * While indexing the service, is not available.
 * 
 * 
 * @author Christophe Bouhier
 */
@Singleton
public class ComponentMappingIndex implements IComponentMappingIndex {

	private ICDOData dataProvider;

	/** Our index */
	private final List<ComponentIndexEntry> cachedIndex = Lists.newArrayList();

	/** When true our index is currently being re-created. */
	private boolean indexing = false;

	/** A background indexing job facility. */
	private IndexingJob indexingJob = new IndexingJob("Component indexer");

	public void buildIndex() {

		if (indexingJob.getState() != Job.RUNNING) {
			if (!isIndexing()) {
				// Tell the service we are indenxing.
				setIndexing(true);
				indexingJob.schedule(1000);

			}
		}
	}

	public void registerBuildCompleteListener(JobChangeAdapter adapter) {
		indexingJob.addJobChangeListener(adapter);
	}

	public void unregisterBuildCompleteListener(JobChangeAdapter adapter) {
		indexingJob.removeJobChangeListener(adapter);
	}

	/**
	 * Builds an index, while updating an {@link IProgressMonitor}
	 */
	protected void doBuildIndex(IProgressMonitor monitor) {
		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_COMPONENT_INDEX_OPTION,
					"start building component index for operators");
		}

		Resource resource = dataProvider
				.getResource(OperatorsPackage.Literals.OPERATOR);

		// Create a flat list first.
		final List<Component> allComponents = Lists.newArrayList();

		for (EObject eo : resource.getContents()) {
			if (eo instanceof Operator) {
				final List<Component> componentsForOperator = StudioUtils
						.componentsForOperator((Operator) eo);
				allComponents.addAll(componentsForOperator);
			}
		}

		int totalWork = allComponents.size();

		final SubMonitor cacheBuildWork = SubMonitor
				.convert(monitor, totalWork);

		// Create a subprogress monitor for this expected work.
		for (Component c : allComponents) {

			final ComponentIndexEntry valueFor = ComponentIndexEntry
					.valueFor(c);

			if (valueFor != null) {
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_COMPONENT_INDEX_OPTION,
							"adding entry:" + valueFor);
				}
				// Add to our value cache.
				cachedIndex.add(valueFor);
			}
			cacheBuildWork.worked(1);
		}

		if (resource instanceof CDOResource) {

			// Perform updates on our index.
			// if revision delta is not available, we can't remove the removal
			// of a NodeType from a Node.
			// as there is no reference in the index to the Node.
			((CDOResource) resource).cdoView().addListener(new IndexUpdater());
		}
		// Tell we are done.
		monitor.done();
		setIndexing(false);
		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_COMPONENT_INDEX_OPTION,
					"done building component index for operators index size: "
							+ cachedIndex.size());
		}
	}

	/**
	 * State of the service, while indexing the service is not available.
	 * 
	 * @return
	 */
	public synchronized boolean isIndexing() {
		return indexing;
	}

	/**
	 * Set the indexing status;
	 * 
	 * @param status
	 */
	public synchronized void setIndexing(boolean status) {
		indexing = status;
	}

	public List<Component> componentsForIdentifiers(CDOView view,
			final List<IdentifierDescriptor> descriptors) {

		List<Component> components = Lists.newArrayList();

		if (isIndexing()) {
			return components;
		}

		Iterable<ComponentIndexEntry> filter = Iterables.filter(cachedIndex,
				new Predicate<ComponentIndexEntry>() {
					public boolean apply(ComponentIndexEntry entry) {
						return entry.equals(descriptors);
					}
				});

		for (ComponentIndexEntry cie : filter) {

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_COMPONENT_INDEX_OPTION,
						"found entry: " + cie);
			}

			CDOID componentID = cie.getComponentID();
			try {
				CDOObject object = view.getObject(componentID);
				if (object instanceof Component) {
					components.add((Component) object);
				}
			} catch (ObjectNotFoundException onfe) {
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_COMPONENT_INDEX_OPTION,
							"can't find OID", onfe);
				}
			}
		}

		return components;
	}

	public void setDataProvider(ICDOData dataProvider) {
		this.dataProvider = dataProvider;
	}

	@Override
	public String toString() {

		Iterable<String> transform = Iterables.transform(cachedIndex,
				new Function<ComponentIndexEntry, String>() {
					public String apply(ComponentIndexEntry entry) {
						return entry.toString();
					}
				});

		StringBuilder sb = new StringBuilder();
		for (String s : transform) {
			sb.append(s + "\n");
		}
		return sb.toString();

	}

	public class IndexUpdater implements IListener {
		public void notifyEvent(org.eclipse.net4j.util.event.IEvent event) {
			setIndexing(true);
			processEvent(event);
			setIndexing(false);
		}

		private void updateIndexForComponentBranch(Component... components) {

			// Rebuild all entries for this branch, clear the branch from the
			// index first.

			for (Component rootComponent : components) {
				List<Component> componentsForComponent = StudioUtils
						.componentsForComponent(rootComponent);
				for (Component c1 : componentsForComponent) {
					ComponentIndexEntry entryForComponent = entryForComponent(c1);
					if (entryForComponent != null) {
						entryForComponent.update(c1); // Just update the entry.
						if (DataActivator.DEBUG) {
							DataActivator.TRACE
									.trace(DataActivator.TRACE_COMPONENT_INDEX_OPTION,
											"updating entry: "
													+ entryForComponent);
						}
					} else {
						entryForComponent = ComponentIndexEntry.valueFor(c1);
						if (entryForComponent != null) {
							// Add to our value cache.
							cachedIndex.add(entryForComponent);
							if (DataActivator.DEBUG) {
								DataActivator.TRACE
										.trace(DataActivator.TRACE_COMPONENT_INDEX_OPTION,
												"adding entry: "
														+ entryForComponent);
							}
						}
					}
				}
			}
		}

		/**
		 * @param event
		 */
		private synchronized void processEvent(
				org.eclipse.net4j.util.event.IEvent event) {

			if (event instanceof CDOViewInvalidationEvent) {
				final CDOViewInvalidationEvent invalidationEvent = (CDOViewInvalidationEvent) event;

				if (DataActivator.DEBUG) {

					for (CDOObject object : invalidationEvent
							.getRevisionDeltas().keySet()) {
						CDORevisionDelta cdoRevisionDelta = invalidationEvent
								.getRevisionDeltas().get(object);

						// The revision delta is not necessarily available.
						if (cdoRevisionDelta != null) {
							StringBuffer sb = new StringBuffer();
							CDO.cdoPrintRevisionDelta(sb,
									cdoRevisionDelta);
							DataActivator.TRACE
									.trace(DataActivator.TRACE_COMPONENT_INDEX_OPTION,
											sb.toString());
						}
					}
				}

				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_COMPONENT_INDEX_OPTION,
							"updating index : " + invalidationEvent);
				}

				// Do we have detached? Remove from the index.
				// Detached objects returns all detached objects, so we just
				// remove them from the
				// index one by one. Note that the parent will also be notified
				// being dirty,
				// so the re-indexing of the parent will occur further below.
				final Set<CDOObject> detachedObjects = invalidationEvent
						.getDetachedObjects();

				if (!detachedObjects.isEmpty()) {
					if (DataActivator.DEBUG) {

						DataActivator.TRACE.trace(
								DataActivator.TRACE_COMPONENT_INDEX_OPTION,
								"processing detached objects : "
										+ detachedObjects);
					}

					for (CDOObject o : detachedObjects) {
						if (o instanceof Component) {
							clearIndexForComponentBranch((Component) o);
						}
					}
				}

				// Do we have dirty? Update the index .
				final Set<CDOObject> dirtyObjects = invalidationEvent
						.getDirtyObjects();

				if (!dirtyObjects.isEmpty()) {

					for (CDOObject o : dirtyObjects) {
						if (o instanceof Component) {
							updateIndexForComponentBranch((Component) o);
						} else if (o instanceof Network) {
							// For a network update, we should rebuild all
							// components, under each node branch.
							updateIndexForNetwork((Network) o);
						} else if (o instanceof Node) {
							// We might be changing Node ID, which should be
							// indexed, this would invalidate the whole all
							// components in this node.
							updateIndexForNode((Node) o);
						} else if (o instanceof NodeType) {
							// Check that we are a NodeType in a Node instance,
							// we
							// do not index the types as such.
							// will not occure, different CDOResource.
							Node nodeFor = StudioUtils.nodeFor(o);
							if (nodeFor != null) {
								List<Component> components = Lists
										.newArrayList();
								components.addAll(((NodeType) o)
										.getEquipments());
								components
										.addAll(((NodeType) o).getFunctions());
								updateIndexForComponentBranch(components
										.toArray(new Component[components
												.size()]));
							}
						}
					}
				}

				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_COMPONENT_INDEX_OPTION,
							"index size after update : " + size());
				}

			}
		}

		/**
		 * @param o
		 */
		private void updateIndexForNetwork(Network net) {
			for (Node n : net.getNodes()) {
				updateIndexForNode(n);
			}
			for (Network netChild : net.getNetworks()) {
				updateIndexForNetwork(netChild);
			}
		}

		private void updateIndexForNode(Node n) {
			if (n.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {
				List<Component> components = Lists.newArrayList();
				components.addAll(n.getNodeType().getEquipments());
				components.addAll(n.getNodeType().getFunctions());
				updateIndexForComponentBranch(components
						.toArray(new Component[components.size()]));
			} else {
				// If we remove the node type, we will have many
				// entries which should be removed.
			}
		}

		private void clearIndexForComponentBranch(Component c) {
			ComponentIndexEntry entryForComponent = entryForComponent(c);
			if (entryForComponent != null) {

				boolean remove = cachedIndex.remove(entryForComponent);
				if (remove) {
					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_COMPONENT_INDEX_OPTION,
								"removed entry: " + entryForComponent);
					}
				} else {
					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_COMPONENT_INDEX_OPTION,
								"failed to remove entry: " + entryForComponent);
					}

				}
			}
		}
	}

	/**
	 * @author Christophe Bouhier
	 */
	class IndexingJob extends Job {

		public IndexingJob(String name) {
			super(name);
			// A systems job.
			this.setSystem(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {

			doBuildIndex(monitor);

			return Status.OK_STATUS;
		}

	}

	/**
	 * Return the size of the index.
	 * 
	 * @return
	 */
	public int size() {
		return cachedIndex.size();
	}

	/**
	 * Matches the {@link Component } {@link CDOID } with an entry in the index
	 * with the same CDOID. If none is found, <code>null</code> will be
	 * returned.
	 * 
	 */
	public ComponentIndexEntry entryForComponent(Component c) {

		final CDOID cdoID = c.cdoID();
		return entryForComponent(cdoID);
	}

	private ComponentIndexEntry entryForComponent(final CDOID cdoID) {

		if (isIndexing()) {
			// CB Proceed anyway, as we actually set indexing.
		}

		Iterable<ComponentIndexEntry> filter = Iterables.filter(
				getChachedIndex(), new Predicate<ComponentIndexEntry>() {
					public boolean apply(ComponentIndexEntry entry) {
						return entry.getComponentID().equals(cdoID);
					}
				});
		// There should really only be one entry....
		if (Iterables.size(filter) == 1) {
			return filter.iterator().next();
		}
		return null;
	}

	private synchronized List<ComponentIndexEntry> getChachedIndex() {
		return cachedIndex;
	}

}
