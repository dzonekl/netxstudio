/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
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
 * 	Martin Taal - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.index;

import java.util.List;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.cdo.view.CDOView;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.metrics.Metric;

/**
 * Uses a Component indexer {@link IComponentMappingIndex } to lookup components
 * based on a collection of {@link IdentifierDescriptor descriptors }
 * 
 * @author Christophe Bouhier
 */
@Singleton
public class IndexComponentLocator extends JobChangeAdapter implements
		IComponentLocator {

	@Inject
	private ComponentMappingIndex index;

	private IData dataProvider;

	private boolean initialized = false;

	private List<IdentifierDescriptor> failedIdentifiers;

	/** This is the last result of our component lookup, it is considered before */
	private List<Component> componentsForIdentifiers;

	public IndexComponentLocator() {
	}

	public boolean isInitialized() {
		return initialized;
	}

	public void initialize() {

		if (!initialized && dataProvider != null) {
			if (index != null) {
				index.setDataProvider(dataProvider);
				// Register for the build completion on the first time we build
				// the index.
				index.registerBuildCompleteListener(this);
				index.buildIndex();
			}
		}
	}

	public Component locateComponent(Metric metric,
			List<IdentifierDescriptor> descriptors) {

		List<Component> locateComponents = locateComponents(metric, descriptors);
		if (!locateComponents.isEmpty()) {
			return locateComponents.get(0);
		}

		failedIdentifiers = descriptors;
		return null;
	}

	/**
	 * Locates components matching the {@link Metric } and
	 * {@link IdentifierDescriptor descriptors} criteria.
	 * 
	 * This method will query the index each time invoked.
	 * 
	 */
	public List<Component> locateComponents(Metric metric,
			List<IdentifierDescriptor> descriptors) {

		List<Component> result = Lists.newArrayList();
		final CDOView view = metric.cdoView();

		componentsForIdentifiers = this.locateComponents(view, descriptors);
		
		Iterable<Component> filter = StudioUtils.componentsForMetric(
				componentsForIdentifiers, metric);
		
		result.addAll(Lists.newArrayList(filter));
		return result;
	}

	public List<IdentifierDescriptor> getFailedIdentifiers() {
		return failedIdentifiers;
	}

	public IdentifierDescriptor getLastMatchingIdentifier() {
		return null;
	}

	public void setDataProvider(IData provider) {
		this.dataProvider = provider;
	}

	@Override
	public void done(IJobChangeEvent event) {
		index.unregisterBuildCompleteListener(this);
		initialized = true;
	}
	
	/**
	 * Locate components with a specified {@link CDOView}
	 */
	public List<Component> locateComponents(CDOView view,
			List<IdentifierDescriptor> descriptors) {

		List<Component> result = Lists.newArrayList();
		if (isInitialized()) {

			result = index.componentsForIdentifiers(view, descriptors);
		}
		return result;
	}
	
	
	/**
	 * Get the mapping index.
	 * 
	 * @return
	 */
	public IComponentMappingIndex getMappingIndex(){
		return index;
	}

}
