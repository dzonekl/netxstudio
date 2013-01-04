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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.importer.IComponentLocator.IdentifierDescriptor;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.library.Component;
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
public class ComponentMappingIndex implements IComponentMappingIndex {

	@Inject
	private ModelUtils modelUtils;

	private IDataProvider dataProvider;

	/** Our index */
	private final List<ComponentIndexEntry> cachedIndex = Lists.newArrayList();

	/** When true our index is currently being re-created. */
	private boolean indexing = false;

	/** A background indexing job facility. */
	private IndexingJob indexingJob = new IndexingJob("Component indexer");

	public void buildIndex() {

		if (indexingJob.getState() != Job.RUNNING) {
			if (!indexing) {
				// Tell the service we are indenxing.
				indexing = true;
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
				List<Component> componentsForOperator = modelUtils
						.componentsForOperator((Operator) eo);
				allComponents.addAll(componentsForOperator);
			}
		}

		int totalWork = allComponents.size();

		SubMonitor cacheBuildWork = SubMonitor.convert(monitor, totalWork);

		// Create a subprogress monitor for this expected work.
		for (Component c : allComponents) {

			ComponentIndexEntry valueFor = ComponentIndexEntry.valueFor(c);

			if (valueFor != null) {
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_COMPONENT_INDEX_OPTION,
							"adding entry");
				}
				// Add to our value cache.
				cachedIndex.add(valueFor);
			}
			cacheBuildWork.worked(1);
		}

		// Tell we are done.
		monitor.done();
		indexing = false;
	}

	/**
	 * State of the service, while indexing the service is not available.
	 * 
	 * @return
	 */
	public boolean isIndexing() {
		return indexing;
	}

	public List<Component> componentsForIdentifiers(CDOView view,
			final List<IdentifierDescriptor> descriptors) {

		List<Component> components = Lists.newArrayList();

		if (indexing) {
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

	public void setDataProvider(IDataProvider dataProvider) {
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

		for (String s : transform) {
			System.out.println(s);
		}
		return "";

	}

	/**
	 * A job which can
	 * 
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
	 * Matches the {@link Component } {@link CDOID } with an entry in the index
	 * with the same CDOID. If none is found, <code>null</code> will be
	 * returned.
	 * 
	 */
	public ComponentIndexEntry entryForComponent(Component c) {
		if (indexing) {
			return null;
		}

		final CDOID cdoID = c.cdoID();

		Iterable<ComponentIndexEntry> filter = Iterables.filter(cachedIndex,
				new Predicate<ComponentIndexEntry>() {
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

}
