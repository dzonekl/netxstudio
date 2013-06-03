/*******************************************************************************
 * Copyright (c) 2 jan. 2013 NetXForge.
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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.spi.cdo.FSMUtil;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netxforge.netxstudio.data.importer.IComponentLocator;
import com.netxforge.netxstudio.data.importer.IComponentLocator.IdentifierDescriptor;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;

/**
 * Defines the interface for an an index for CDO Object ID's of a
 * {@link Component } branch within it's hierarchical path.</p>
 * 
 * A typical branch looks like:
 * <code>NODE -> COMPONENT -> COMPONENT -> COMPONENT</code> </p> Each of the
 * 'nodes' in the branch has a representation in the form of a key, value map.
 * 
 * The <code>Component(s)</code> can be located in the index with method
 * {@link #componentsForIdentifiers(List)}
 */
public interface IComponentMappingIndex {

	/**
	 * An {@link Component} index entry.
	 * 
	 * @author Christophe Bouhier
	 */
	public static class ComponentIndexEntry implements
			Comparable<ComponentIndexEntry> {

		/** The index entry 'value' */
		private final LinkedList<HashMap<String, String>> componentPath = Lists
				.newLinkedList();

		/** The CDOID of the component for this index entry */
		private final CDOID componentID;

		public CDOID getComponentID() {
			return componentID;
		}

		private ComponentIndexEntry(Component c) {
			componentID = c.cdoID();
		}

		/**
		 * Returns if the {@link IdentifierDescriptor} occurs in the path for
		 * this index entry. If a match occurs in the path, we abandon the
		 * search.
		 * 
		 * @author Christophe Bouhier
		 */
		class IdentifierInPathPredicate implements
				Predicate<IComponentLocator.IdentifierDescriptor> {

			public boolean apply(
					IComponentLocator.IdentifierDescriptor descriptor) {

				final String objectProperty = descriptor.getObjectProperty();
				final String value = descriptor.getValue();

				boolean match = false;

				for (Map<String, String> pathNode : componentPath) {
					if (pathNode.containsKey(objectProperty)) {
						match = pathNode.get(objectProperty).equals(value);
						break; // One match is enough.
					}
				}
				return match;
			}
		}
		
		
		/**
		 * A Strategy which will track if the leaf node in the path has been touched. 
		 * 
		 * @author Christophe Bouhier
		 *
		 */
		class IdentifierInLeafPredicate implements
				Predicate<IComponentLocator.IdentifierDescriptor> {
			
			boolean leafMatch = false; 
			
			public void reset(){
				leafMatch = true; 
			} 
			
			public boolean leafMatch(){
				return leafMatch;
			}
			
			public boolean apply(
					IComponentLocator.IdentifierDescriptor descriptor) {
				
				
				final String objectProperty = descriptor.getObjectProperty();
				final String value = descriptor.getValue();

				boolean match = false;

				for (Map<String, String> pathNode : componentPath) {
					
					int indexOf = componentPath.indexOf(pathNode);
					
					if (pathNode.containsKey(objectProperty)) {
						match = pathNode.get(objectProperty).equals(value);
						if(match && indexOf == componentPath.size() -1){
							leafMatch = true; 
						}
					}
				}
				return match;
			}
		}

		public final IdentifierInPathPredicate containsIdentifierInPathPredicate = new IdentifierInPathPredicate();
		
		public final IdentifierInLeafPredicate containsIdentifiersAndLeafPredicate = new IdentifierInLeafPredicate();
		
		
		/**
		 * Produces an index entry for the given {@link Component}.</p> Note
		 * that an entry is not necessarily produced, as the component could be:
		 * <ul>
		 * <li>Detached from CDO</li>
		 * <li>Has an empty path as properties might not have been set. </li>
		 * </ul>
		 * 
		 * @param c
		 * @return Returns a {@link ComponentIndexEntry} or <code>null</code> if
		 *         no entry could be produced.
		 * 
		 */
		public static ComponentIndexEntry valueFor(Component c) {

			if (FSMUtil.isTransient(c)) {
				return null;
			}

			ComponentIndexEntry cie = new ComponentIndexEntry(c);

			cie.produceIndex(c);

			if (cie.componentPath.isEmpty()) {
				return null;
			}

			return cie;
		}
		
		
		public void update(Component c){
			
			// Clear the path for this component. 
			componentPath.clear(); 
			produceIndex(c);
			
		}
		
		
		private void produceIndex(Component component) {

			// Should we be bother with components which don't have a resource
			// attached?

			// create a list of objects in the Component path, including self.
			List<EObject> componentObjectPath = Lists.newArrayList();
			objectPath(componentObjectPath, component);

			// iterate of the path and produce the index entries.
			for (EObject object : componentObjectPath) {

				final HashMap<String, String> entriesForPathNode;

				if (object.eClass() == LibraryPackage.Literals.FUNCTION) {
					entriesForPathNode = entriesForPathNode(object,
							IComponentLocator.IdentifierDescriptor
									.getFeaturesforfunction());
				} else if (object.eClass() == LibraryPackage.Literals.EQUIPMENT) {
					entriesForPathNode = entriesForPathNode(object,
							IComponentLocator.IdentifierDescriptor
									.getFeaturesforequipment());
				} else if (object.eClass() == OperatorsPackage.Literals.NODE) {
					entriesForPathNode = entriesForPathNode(object,
							IComponentLocator.IdentifierDescriptor
									.getFeaturesfornode());
				} else if (object.eClass() == OperatorsPackage.Literals.RELATIONSHIP) {
					entriesForPathNode = entriesForPathNode(object,
							IComponentLocator.IdentifierDescriptor
									.getFeaturesforrelationship());
				} else {
					entriesForPathNode = null;
				}

				// Add a new path entry, if we have something to contribute.
				if (entriesForPathNode != null && !entriesForPathNode.isEmpty()) {
					componentPath.add(0, entriesForPathNode);
				}
			}

		}

		/**
		 * Builds a collection (path) of objects following the containment
		 * hierarchy with {@link EObject#eContainer()}
		 * 
		 * @param result
		 * @param eo
		 */
		private void objectPath(List<EObject> result, EObject eo) {
			if (result != null) {
				if (eo instanceof Component || eo instanceof Node) {
					result.add(eo);
				}
				EObject container = eo.eContainer();
				if (container != null) {
					objectPath(result, container);
				}
			}
		}

		/**
		 * Produce a Map of key, value pair with the actual values of the object
		 * features as specified in the collection of {@link EStructuralFeature}
		 * 
		 * @param object
		 */
		private HashMap<String, String> entriesForPathNode(EObject object,
				Map<String, EStructuralFeature> featureMap) {

			final HashMap<String, String> keyValueMap = Maps.newHashMap();

			for (Entry<String, EStructuralFeature> entry : featureMap
					.entrySet()) {
				final EStructuralFeature feature = entry.getValue();
				final String key = entry.getKey();

				if (object.eIsSet(feature)) {
					Object featureValue = object.eGet(feature);
					// if we have a feature value and it's a string and it's not
					// empty produce a node index entry.
					if (featureValue instanceof String
							&& !((String) featureValue).isEmpty()) {
						// Trim white spaces. 
						String value = (String) featureValue;
						value = value.trim();
						keyValueMap.put(key, value);
					}
				} else {
					// the feature isn't set.

				}
			}
			return keyValueMap;

		}

		public String toString() {

			StringBuffer sb = new StringBuffer();
			sb.append(componentID);

			// walk the path and make string out of it.
			for (Map<String, String> pathNode : componentPath) {
				sb.append(": {");
				for (Entry<String, String> entry : pathNode.entrySet()) {
					sb.append("(" + entry.getKey() + "," + entry.getValue()
							+ ")");
				}
				sb.append("}");
			}
			return sb.toString();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof List<?>) {
				// Do we look for equality of an IdentifierDescriptor
				// collection?
				return matches((List<?>) obj);
			} else if (obj instanceof ComponentIndexEntry) {
				return compareTo((ComponentIndexEntry) obj) == 0;
			} else if (obj instanceof Component) {
				// TODO, create a volatile index entry and compare it to self
				// for equality.
			}

			return true;
		}

		/**
		 * Passing in anything else than a collection of
		 * {@link IComponentLocator.IdentifierDescriptor} type will throw a {@link ClassCastException casting Exception}
		 * Exception.
		 * 
		 * Currently only one Strategy is applied. Behavior can be changed, by considering different matching strategies, 
		 * using different Predicate filtering implementations. 
		 * 
		 * 
		 * @param collection
		 * @return
		 */
		@SuppressWarnings("unchecked")
		private boolean matches(List<?> collection) {

			containsIdentifiersAndLeafPredicate.reset(); 
			
			Iterable<IdentifierDescriptor> filter = Iterables.filter(
					(List<IComponentLocator.IdentifierDescriptor>) collection,
					containsIdentifiersAndLeafPredicate);
			
			// Should match all identifiers and the leaf. 
//			return Iterables.size(filter) == collection.size() && containsIdentifiersAndLeafPredicate.leafMatch();
			return Iterables.size(filter) == collection.size();
		}

		/**
		 * As an index entry can be 'flattened' to a String, we use the
		 * {@link #toString()} method and String {@link Comparable}
		 * implementation
		 */
		public int compareTo(ComponentIndexEntry cie) {
			return this.toString().compareTo(cie.toString());
		}

	}

	/**
	 * Build the index for all components. </p> Should walk the Metric Sources,
	 * retrieve the metrics and produce a branch of components and their
	 * children which are candidates for a mapping. Then it should for the
	 * MetricSource get the MappingColumn IdentifierDatakind's. It should then
	 * iterate over for each of the IdentifierDataKind's it should produce a
	 * descriptor holding the EStructuralFeature for the relevant property.
	 * 
	 * Then it should walk the component branches matching the Metric, and for
	 * each component entry create an index entry for each feature combination
	 * from the descriptors which occurs in the component.
	 * 
	 * It should also register as a listener to feature changes this could be
	 * updates on: {@link LibraryPackage.Literals.COMPONENT__METRIC_REFS
	 * Components Metric}
	 * 
	 */
	public abstract void buildIndex();
	
	
	/**
	 * Are we indexing. 
	 * @return
	 */
	public abstract boolean isIndexing();

	/**
	 * Return the component for these descriptors.
	 * 
	 * @param descriptors
	 * @return
	 */
	public abstract List<Component> componentsForIdentifiers(CDOView view, 
			List<IComponentLocator.IdentifierDescriptor> descriptors);
	
	/**
	 * Return the {@link ComponentIndexEntry entry} for the given component. 
	 * 
	 * @param c
	 * @return
	 */
	public abstract ComponentIndexEntry entryForComponent(Component c);

}
