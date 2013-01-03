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

import java.util.ArrayList;
import java.util.List;

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
 * @author Christophe Bouhier
 */
public class ComponentMappingIndex implements IComponentMappingIndex {

	@Inject
	private ModelUtils modelUtils;

	private IDataProvider dataProvider;

	/** Our index */
	private final List<ComponentIndexEntry> cachedIndex = Lists.newArrayList();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.index.IResourceIndex#buildIndex()
	 */
	public void buildIndex() {

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_COMPONENT_INDEX_OPTION,
					"start building component index for operators");
		}
		Resource resource = dataProvider
				.getResource(OperatorsPackage.Literals.OPERATOR);
		for (EObject eo : resource.getContents()) {
			if (eo instanceof Operator) {
				List<Component> componentsForOperator = modelUtils
						.componentsForOperator((Operator) eo);
				for (Component c : componentsForOperator) {
					ComponentIndexEntry valueFor = ComponentIndexEntry
							.valueFor(c);
					// Add to our value cache.
					cachedIndex.add(valueFor);
					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_COMPONENT_INDEX_OPTION,
								"adding entry");
					}
				}
			}
		}
	}

	public List<Component> componentsForIdentifiers(
			final List<IdentifierDescriptor> descriptors) {

		Iterable<ComponentIndexEntry> filter = Iterables.filter(cachedIndex,
				new Predicate<ComponentIndexEntry>() {
					public boolean apply(ComponentIndexEntry entry) {
						return entry.equals(descriptors);
					}
				});

		// Get a transaction for the given provider.
		CDOView view = dataProvider.getView();
		List<Component> components = Lists.newArrayList();
		for (ComponentIndexEntry cie : filter) {
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

}
