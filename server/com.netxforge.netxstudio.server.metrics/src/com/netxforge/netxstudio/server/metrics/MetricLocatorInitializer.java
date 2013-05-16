/*******************************************************************************
 * Copyright (c) 16 mei 2013 NetXForge.
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
package com.netxforge.netxstudio.server.metrics;

import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.net4j.util.container.IElementProcessor;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent.Kind;

import com.google.inject.Injector;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.importer.IComponentLocator;
import com.netxforge.netxstudio.server.metrics.ServerImporterHelper.LocalDataProviderProvider;
import com.netxforge.netxstudio.server.metrics.internal.MetricsActivator;

/**
 * An initializer, which waits for the {@link IRepository} to be active.
 * 
 * @author Christophe Bouhier
 */
public class MetricLocatorInitializer implements IElementProcessor {
	public Object process(IManagedContainer container, String productGroup,
			String factoryType, String description, Object element) {
		if (element instanceof IRepository) {
			final IRepository repository = (IRepository) element;
			repository.addListener(new LifecycleEventAdapter() {
				@Override
				public void notifyLifecycleEvent(ILifecycleEvent event) {
					if (event.getKind() == Kind.ACTIVATED) {
						Injector injector = MetricsActivator.getInstance()
								.getInjector();
						// Start indexing (will trigger background job).
						IComponentLocator locator = injector
								.getInstance(IComponentLocator.class);
						IDataProvider provider = injector.getInstance(
								LocalDataProviderProvider.class)
								.getDataProvider();
						locator.setDataProvider(provider);
						locator.initialize();

					}
				}
			});
		}
		return element;
	}
}
