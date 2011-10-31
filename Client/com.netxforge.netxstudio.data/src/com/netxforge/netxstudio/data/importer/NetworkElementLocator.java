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
package com.netxforge.netxstudio.data.importer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.Node;

/**
 * Is responsible for finding a network element using a set of IdentifierValues.
 * When the most deep component or relationship is not found, and the metric is
 * actually on the parent, we create the component.
 * 
 * 
 * @author Martin Taal
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class NetworkElementLocator {

	// @Inject
	// @Server
	private IDataProvider dataProvider;

	// cache the components by metric and node identifier.
	private Map<String, List<Component>> cachedComponentsForNodeIDAndMetric = Maps.newHashMap();
	private Map<String, List<Component>> cachedMetricComponentsForNodeIDAndMetric = Maps
			.newHashMap();

	// keeps track of the most successfull identifiers, can be used to provide
	// more
	// information to the user on which columns failed
	private List<IdentifierValue> successFullIdentifiers = Lists.newArrayList();

	private List<IdentifierValue> failedIdentifiers = Lists.newArrayList();

	private List<Component> successFullComponents = Lists.newArrayList();

	public Component locateComponent(Metric metric,
			List<IdentifierValue> identifiers) {
		successFullIdentifiers.clear();
		failedIdentifiers.clear();
		successFullComponents.clear();

		final EReference sourceReference = LibraryPackage.eINSTANCE
				.getComponent_MetricRefs();

		boolean searchingForEquipment = false;
		for (final IdentifierValue idValue : identifiers) {
			if (idValue.getKind().getObjectKind() == ObjectKindType.EQUIPMENT) {
				searchingForEquipment = true;
				break;
			}
		}

		// find the node identifier otherwise bail out.
		IdentifierValue nodeIdentifier = null;
		for (final IdentifierValue identifierValue : identifiers) {
			if (identifierValue.getKind().getObjectKind() == ObjectKindType.NODE) {
				nodeIdentifier = identifierValue;
				break;
			}
		}

		if (nodeIdentifier == null) {
			failedIdentifiers.add(nodeIdentifier);
			return null;
		}

		// The list of resolved components, as a cross reference could
		// have multiple.
		List<Component> allComponents = new ArrayList<Component>();
		// A subset, not containing the children.
		List<Component> componentsMatchingMetric = Lists.newArrayList();

		final String key = getKey(nodeIdentifier, metric);
		if (cachedComponentsForNodeIDAndMetric.containsKey(key)) {
			allComponents = cachedComponentsForNodeIDAndMetric.get(key);
			componentsMatchingMetric = cachedMetricComponentsForNodeIDAndMetric
					.get(key);
		} else {
			// find the cross references to this metric
			final List<CDOObjectReference> results = dataProvider
					.getTransaction().queryXRefs(metric, sourceReference);
			for (final CDOObjectReference objectReference : results) {
				final CDOObject source = objectReference.getSourceObject();
				if (source instanceof Function && searchingForEquipment) {
					continue;
				}
				if (source instanceof Equipment && !searchingForEquipment) {
					continue;
				}
				// walk up the node hierarchy and end up with a Node object
				// which should be equal
				// to the node identifier, otherwise skip this component.
				if (!hasValidNode(source, nodeIdentifier)) {
					continue;
				}
				// also add the children of the component referencing the
				// Metric.
				// .. creating a flat list of a node-metric-
				if (source instanceof Component
						&& !allComponents.contains(source)) {
					componentsMatchingMetric.add((Component) source);
					allComponents.add((Component) source);
					addChildren((Component) source, allComponents);
				}
			}
			cachedMetricComponentsForNodeIDAndMetric.put(key,
					componentsMatchingMetric);
			cachedComponentsForNodeIDAndMetric.put(key, allComponents);
		}

		// Iterate through components and subiterate through the identifiers,
		// having a full match of identifiers
		// and components.
		for (final Component source : allComponents) {

			// All identifiers are valid (Excluding the Node identifier).
			boolean allIdentifiersValid = true;

			// At least one identifier has been verified.
			boolean atLeastOneIdentifierChecked = false;

			// Identifiers which have matched, The Node Identifier = 1.
			final List<IdentifierValue> localSuccessFullIdentifiers = Lists
					.newArrayList();
			localSuccessFullIdentifiers.add(nodeIdentifier);

			final List<Component> localSucssFullComponents = Lists
					.newArrayList();

			for (final IdentifierValue identifierValue : identifiers) {
				// Skip the Node identifier.
				if (identifierValue.getKind().getObjectKind() != ObjectKindType.NODE) {
					atLeastOneIdentifierChecked = true;
					// Check if the identifier matches the component name.
					if (!isValidObject(source, identifierValue)) {
						allIdentifiersValid = false;
						// The Component doesn't match the identifier.
						break;
					} else {
						System.out.println("Matching identifier!:"
								+ identifierValue.getValue());
						localSucssFullComponents.add(source);
						localSuccessFullIdentifiers.add(identifierValue);
					}
				}
			}
			if (localSuccessFullIdentifiers.size() > successFullIdentifiers
					.size()) {
				successFullIdentifiers = localSuccessFullIdentifiers;
				successFullComponents = localSucssFullComponents;
			}
			if (atLeastOneIdentifierChecked && allIdentifiersValid) {
				return source;
			}

			// A component, with the correct node, correct metric but no
			// identifier , return the first one
			if (atLeastOneIdentifierChecked == false) {
				return source;
			}

		}

		// All components checked, and we have identifiers pointing, so create a
		// Component with the identifier name.
		// TODO, if we have multiple sub-identifiers, we won't know which one to
		// use.
		// Consider using the successFullIdentifiers as a base, We will also
		// need to know which Component succesfully matched.

		// FIXME, Already created components won't be resolved with xref likely.
		// Add these components to the cache, so we don't need to xref.

		Component autoCreateComponent = null;
		if (successFullComponents.size() > 0) {

			autoCreateComponent = componentIdentifiers(successFullComponents,
					successFullIdentifiers);
		} else {
			autoCreateComponent = componentIdentifiers(
					componentsMatchingMetric, identifiers);

		}

		if (autoCreateComponent != null) {
			allComponents.add(autoCreateComponent);
			System.out.println("Adding auto create component: "
					+ autoCreateComponent.getName() + " cache = "
					+ allComponents.size() + " for key: " + key);
			this.cachedComponentsForNodeIDAndMetric.put(key, allComponents);
			return autoCreateComponent;
		} else {
			System.out.println("Auto created failed");
		}

		// report the failed ID's.
		for (final IdentifierValue idValue : identifiers) {
			if (!successFullIdentifiers.contains(idValue)) {
				failedIdentifiers.add(idValue);
			}
		}

		return null;
	}

	private Component componentIdentifiers(List<Component> targetComponents,
			List<IdentifierValue> identifiers) {

		// The ultimate result.
		Component newChildComponent = null;

		List<IdentifierValue> componentIdentifiers = Lists.newArrayList();
		for (IdentifierValue iv : identifiers) {
			ObjectKindType objectKind = iv.getKind().getObjectKind();
			if (objectKind == ObjectKindType.EQUIPMENT
					|| objectKind == ObjectKindType.FUNCTION
					|| objectKind == ObjectKindType.RELATIONSHIP) {
				componentIdentifiers.add(iv);
			}
		}

		if (componentIdentifiers.size() > 0) {
			IdentifierValue identifierValue = componentIdentifiers
					.get(componentIdentifiers.size() - 1);

			String value = identifierValue.getValue();
			identifierValue.getKind().getPattern();

			// We can only auto-create on a single component in the Node, so get
			// the
			// first matching one.
			if (targetComponents.size() > 0) {
				Component target = targetComponents
						.get(targetComponents.size() - 1);

				if (identifierValue.getKind().getObjectKind() == ObjectKindType.FUNCTION) {
					newChildComponent = LibraryFactory.eINSTANCE
							.createFunction();
					((Function) target).getFunctions().add(
							(Function) newChildComponent);
				} else if (identifierValue.getKind().getObjectKind() == ObjectKindType.EQUIPMENT) {
					newChildComponent = LibraryFactory.eINSTANCE
							.createEquipment();
					((Equipment) target).getEquipments().add(
							(Equipment) newChildComponent);
				} else if (identifierValue.getKind().getObjectKind() == ObjectKindType.RELATIONSHIP) {
					if (target instanceof Function) {
						newChildComponent = LibraryFactory.eINSTANCE
								.createFunction();
						((Function) target).getFunctions().add(
								(Function) newChildComponent);
					} else if (target instanceof Equipment) {
						newChildComponent = LibraryFactory.eINSTANCE
								.createEquipment();
						((Equipment) target).getEquipments().add(
								(Equipment) newChildComponent);
					}
				}
				if (newChildComponent != null) {
					newChildComponent.setName(value);
					// TODO, Also potentially add the relationship.
				}
			}
		}

		return newChildComponent;
	}

	private void addChildren(Component component, List<Component> components) {
		if (component instanceof Equipment) {
			addChildren((Equipment) component, components);
		} else {
			addChildren((Function) component, components);
		}
	}

	private void addChildren(Equipment equipment, List<Component> components) {
		for (final Equipment childEquipment : equipment.getEquipments()) {
			if (!components.contains(childEquipment)) {
				components.add(childEquipment);
			}
			addChildren(childEquipment, components);
		}
	}

	private void addChildren(Function Function, List<Component> components) {
		for (final Function childFunction : Function.getFunctions()) {
			if (!components.contains(childFunction)) {
				components.add(childFunction);
			}
			addChildren(childFunction, components);
		}
	}

	private boolean hasValidNode(EObject eObject,
			IdentifierValue identifierValue) {
		if (eObject == null) {
			return false;
		}
		if (eObject instanceof Node && isValidObject(eObject, identifierValue)) {
			return true;
		}
		return hasValidNode(eObject.eContainer(), identifierValue);
	}

	private boolean isValidObject(EObject eObject,
			IdentifierValue identifierValue) {
		final String idValue = identifierValue.getValue() != null ? identifierValue
				.getValue().trim() : null;
		if (identifierValue.getKind().getObjectKind() == ObjectKindType.RELATIONSHIP) {
			if (eObject instanceof Function) {
				for (final FunctionRelationship r : ((Function) eObject)
						.getFunctionRelationshipRefs()) {
					if (featureMatchesValue(r, identifierValue.getKind()
							.getObjectProperty(), idValue, identifierValue
							.getKind().getPattern())) {
						return true;
					}
				}
			} else {
				for (final EquipmentRelationship r : ((Equipment) eObject)
						.getEquipmentRelationshipRefs()) {
					if (featureMatchesValue(r, identifierValue.getKind()
							.getObjectProperty(), idValue, identifierValue
							.getKind().getPattern())) {
						return true;
					}
				}
			}
			return false;
		} else {
			return featureMatchesValue(eObject, identifierValue.getKind()
					.getObjectProperty(), idValue, identifierValue.getKind()
					.getPattern());
		}
	}

	private boolean featureMatchesValue(EObject eObject, String eFeatureName,
			String idValue, String extractionPattern) {
		EStructuralFeature eFeature = null;
		for (final EStructuralFeature feature : eObject.eClass()
				.getEAllStructuralFeatures()) {
			if (feature.getName().compareToIgnoreCase(eFeatureName) == 0) {
				eFeature = feature;
				break;
			}
		}

		// CB IS THIS A BUG?????
		eObject.eClass().getEStructuralFeature(eFeatureName);
		if (eFeature != null) {
			final Object componentFeatureValue = eObject.eGet(eFeature);

			// TODO, Matching using the pattern.
			if (componentFeatureValue instanceof String
					&& matches(idValue, (String) componentFeatureValue,
							extractionPattern)) {
				return true;
			}
		}
		// check if one of the parents has this one
		if (eObject.eContainer() != null) {
			return featureMatchesValue(eObject.eContainer(), eFeatureName,
					idValue, extractionPattern);
		}
		return false;
	}

	private boolean matches(String dataValue, String componentValue,
			String extractionPattern) {
		// PATTERN: if extractionPattern != null then use it to extract the
		// to-compare value
		// from the componentValue or the dataValue, the dataValue is read from
		// the excel
		if (extractionPattern != null && extractionPattern.length() > 0) {
			// TODO Implement.
			return dataValue.equals(componentValue);
		} else {
			return dataValue.equals(componentValue);
		}
	}

	public static class IdentifierValue {
		private IdentifierDataKind kind;
		private String value;
		private int column;

		public IdentifierDataKind getKind() {
			return kind;
		}

		public void setKind(IdentifierDataKind kind) {
			this.kind = kind;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public int getColumn() {
			return column;
		}

		public void setColumn(int column) {
			this.column = column;
		}

	}

	// Never used.
	// public IDataProvider getDataProvider() {
	// return dataProvider;
	// }

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	private String getKey(IdentifierValue nodeValue, Metric metric) {
		return nodeValue.getKind().getObjectProperty() + "_"
				+ nodeValue.getValue() + "_" + metric.cdoID().toString();
	}

	public List<IdentifierValue> getSuccessFullIdentifiers() {
		return successFullIdentifiers;
	}

	public List<IdentifierValue> getFailedIdentifiers() {
		return failedIdentifiers;
	}
}
