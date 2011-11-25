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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.Warehouse;

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

	@Inject
	private ModelUtils modelUtils;

	// cache the components which reference the metric for the target Node
	// identifier. Does not include the children.
	private Map<String, List<Component>> cachedAllComponentsForNodeIDAndMetric = Maps
			.newHashMap();

	// cache the components which reference the metric for the target Node
	// identifier. Does not include the children.
	private Map<String, List<Component>> cachedComponentsForNodeIDAndMetric = Maps
			.newHashMap();

	// keeps track of the most successfull identifiers, can be used to provide
	// more
	// information to the user on which columns failed
	private List<IdentifierDescriptor> successFullIdentifiers = Lists
			.newArrayList();

	private List<IdentifierDescriptor> failedIdentifiers = Lists.newArrayList();

	private List<Component> successFullComponents = Lists.newArrayList();

	private IdentifierDescriptor lastMatchingIdentifier = null;

	public IdentifierDescriptor getLastMatchingIdentifier() {
		return lastMatchingIdentifier;
	}

	public void setLastMatchingIdentifier(
			IdentifierDescriptor lastMatchingIdentifier) {
		this.lastMatchingIdentifier = lastMatchingIdentifier;
	}

	@SuppressWarnings("unused")
	public Component locateComponent(Metric metric,
			List<IdentifierDescriptor> identifiers) {
		successFullIdentifiers.clear();
		failedIdentifiers.clear();
		successFullComponents.clear();
		setLastMatchingIdentifier(null);

		if (DataActivator.DEBUG) {
			System.out.println("IMPORTER:LOCATOR Start locator , metric="
					+ metric.getName() + " # idenfifiers ="
					+ identifiers.size() + " id's are: ");
			for (IdentifierDescriptor iv : identifiers) {
				System.out.println("ID col=" + iv.getColumn() + " ,value="
						+ iv.getValue());
			}
		}


		///////////////////////////////////////////////////////
		//SEARCH SCOPE
		///////////////////////////////////////////////////////
		/*
		 * flag for limiting the search scope and bail on references which are
		 * not in the identifier scope. When no scope is defined, all matching
		 * references will be evaluated.
		 */
		boolean searchingForAll = true;
		boolean searchingForEquipment = false;
		boolean searchingForFunction = false;
		for (final IdentifierDescriptor idValue : identifiers) {
			if (idValue.getKind().getObjectKind() == ObjectKindType.EQUIPMENT) {
				searchingForEquipment = true;
				searchingForAll = false;
				break;
			} else if (idValue.getKind().getObjectKind() == ObjectKindType.FUNCTION) {
				searchingForFunction = true;
				searchingForAll = false;
			}
		}

		// find the node identifier otherwise bail out.
		IdentifierDescriptor nodeIdentifier = null;
		for (final IdentifierDescriptor identifierValue : identifiers) {
			if (identifierValue.getKind().getObjectKind() == ObjectKindType.NODE) {
				nodeIdentifier = identifierValue;
				break;
			}
		}

		if (nodeIdentifier == null) {
			failedIdentifiers.add(nodeIdentifier);
			if (DataActivator.DEBUG) {
				System.out
						.println("IMPORTER:LOCATOR No Network Element Identifier="
								+ nodeIdentifier + " , abort component locator");
			}

			return null;
		}

		// The list of resolved components, as a cross reference could
		// have multiple.
		List<Component> allComponents = new ArrayList<Component>();
		// A subset, not containing the children.
		List<Component> componentsMatchingMetric = Lists.newArrayList();

		final String key = getKey(nodeIdentifier, metric);
		if (DataActivator.DEBUG) {
			System.out.println("IMPORTER:LOCATOR key=" + key);
		}
		if (cachedAllComponentsForNodeIDAndMetric.containsKey(key)) {
			allComponents = cachedAllComponentsForNodeIDAndMetric.get(key);
			componentsMatchingMetric = cachedComponentsForNodeIDAndMetric
					.get(key);
			if (DataActivator.DEBUG) {
				System.out.println("IMPORTER:LOCATOR key exists for node="
						+ nodeIdentifier.getValue() + " , with metric="
						+ metric.getName()
						+ " , locate from cache # of components="
						+ allComponents.size());
			}
		} else {
			
			///////////////////////////////////////////////////////
			// CALL REFERENCER ON COMPONENT_METRIC FEATURE
			///////////////////////////////////////////////////////
			
			// find the cross references to this metric, Note this could be a
			// component which is a NodeType Component.
			final List<CDOObjectReference> results = dataProvider
					.getTransaction().queryXRefs(metric,
							LibraryPackage.eINSTANCE.getComponent_MetricRefs());

			if (DataActivator.DEBUG) {
				System.out.println("IMPORTER:LOCATOR References for: "
						+ LibraryPackage.eINSTANCE.getComponent_MetricRefs()
								.getName() + " =" + results.size());
			}
			for (final CDOObjectReference objectReference : results) {
				final CDOObject referingObject = objectReference
						.getSourceObject();
				if (DataActivator.DEBUG) {
					if (referingObject instanceof Component) {
						System.out.println("-- ref: "
								+ ((Component) referingObject).getName()
								+ " cdo res path="
								+ modelUtils.cdoResourcePath(referingObject));
					}
				}

				// walk up the node hierarchy and end up with a Node object
				// which should be equal
				// to the node identifier, otherwise skip this component.
				if (!hasValidNode(referingObject, nodeIdentifier)) {
					continue;
				}

				if (!searchingForAll) {
					if (referingObject instanceof Function
							&& !searchingForFunction) {
						continue;
					}
					if (referingObject instanceof Equipment
							&& !searchingForEquipment) {
						continue;
					}
				}

				// also add the children of the component referencing the
				// Metric.
				// .. creating a flat list of a node-metric-
				if (referingObject instanceof Component
						&& !allComponents.contains(referingObject)) {
					componentsMatchingMetric.add((Component) referingObject);
					allComponents.add((Component) referingObject);
					addChildren((Component) referingObject, allComponents);
				}
			}
			cachedComponentsForNodeIDAndMetric.put(key,
					componentsMatchingMetric);
			cachedAllComponentsForNodeIDAndMetric.put(key, allComponents);

			if (DataActivator.DEBUG) {
				System.out
						.println("IMPORTER:LOCATOR populate cache for for node="
								+ nodeIdentifier.value
								+ " , with metric="
								+ metric.getName()
								+ " new cache size="
								+ cachedAllComponentsForNodeIDAndMetric
										.get(key).size());
			}
		}

		if (DataActivator.DEBUG) {
			System.out.println("IMPORTER:LOCATOR start matching components");
		}

		
		///////////////////////////////////////////////////////
		//SEARCH
		///////////////////////////////////////////////////////
		
		// Iterate through components and sub iterate through the identifiers,
		// having a full match of identifiers
		// and components.
		for (final Component componentToVerify : allComponents) {

			if (DataActivator.DEBUG) {
				System.out.println("-- verify component name="
						+ componentToVerify.getName());
			}

			// All identifiers are valid (Excluding the Node identifier).
			boolean allIdentifiersValid = true;

			// At least one identifier has been verified.
			boolean atLeastOneIdentifierChecked = false;

			// Identifiers which have matched, The Node Identifier = 1.
			final List<IdentifierDescriptor> localSuccessFullIdentifiers = Lists
					.newArrayList();
			localSuccessFullIdentifiers.add(nodeIdentifier);

			final List<Component> localSucssFullComponents = Lists
					.newArrayList();

			for (final IdentifierDescriptor idDescriptor : identifiers) {
				// Skip the Node identifier.
				if (idDescriptor.getKind().getObjectKind() != ObjectKindType.NODE) {
					atLeastOneIdentifierChecked = true;

					if (DataActivator.DEBUG) {
						System.out.println("-- try matching identifier:"
								+ idDescriptor.getValue()
								+ " , for component name="
								+ componentToVerify.getName());
					}
					// Check if the identifier matches the component name.
					if (!isValidObject(componentToVerify, idDescriptor)) {
						if (DataActivator.DEBUG) {
							System.out.println("-- matching failed:"
									+ idDescriptor.getValue()
									+ " , for component name="
									+ componentToVerify.getName());
						}
						allIdentifiersValid = false;
						// The Component doesn't match the identifier.
						break;
					} else {
						localSucssFullComponents.add(componentToVerify);
						localSuccessFullIdentifiers.add(idDescriptor);
						if (DataActivator.DEBUG) {
							System.out.println("-- matching succeeded:"
									+ idDescriptor.getValue()
									+ " , for component name="
									+ componentToVerify.getName());
						}
					}
				}
			}

			if (DataActivator.DEBUG) {
				System.out.println("-- matching identifiers #="
						+ localSuccessFullIdentifiers.size());
			}
			if (localSuccessFullIdentifiers.size() > successFullIdentifiers
					.size()) {
				successFullIdentifiers = localSuccessFullIdentifiers;
				successFullComponents = localSucssFullComponents;
			}
			if (atLeastOneIdentifierChecked && allIdentifiersValid) {
				if (DataActivator.DEBUG) {
					System.out
							.println("-- decision, all identifiers are valid, result component name="
									+ componentToVerify.getName());
				}
				return componentToVerify;
			}

			// A component, with the correct node, correct metric but no
			// identifier , return the first one
			if (atLeastOneIdentifierChecked == false) {
				if (DataActivator.DEBUG) {
					System.out
							.println("-- decision, no identifiers found, result component name="
									+ componentToVerify.getName());
				}
				return componentToVerify;
			}
		}

		
		///////////////////////////////////////////////////////
		//SEARCH FAILED 
		///////////////////////////////////////////////////////

		
		if (DataActivator.DEBUG) {
			System.out
					.println("IMPORTER:LOCATOR  end matching component, no result, proceed to auto-create");
		}

		// All components checked, and we have identifiers pointing, so create a
		// Component with the identifier name. Note: This can't be turned off
		// for now.

		// report the failed ID's.
		for (final IdentifierDescriptor idValue : identifiers) {
			if (!successFullIdentifiers.contains(idValue)) {
				failedIdentifiers.add(idValue);
			}
		}

		List<Component> resultComponents = null;
		
		
		// Disable auto creation. 
//		if (failedIdentifiers.size() > 0) {
//			Component createOnComponent = null;
//			if (successFullComponents.size() > 0) {
//				createOnComponent = successFullComponents
//						.get(successFullComponents.size() - 1);
//			} else if (componentsMatchingMetric.size() > 0) {
//				createOnComponent = componentsMatchingMetric
//						.get(componentsMatchingMetric.size() - 1);
//			}
//			if (createOnComponent != null) {
//				resultComponents = createForIdentifiers(failedIdentifiers,
//						createOnComponent);
//			}
//		}

		if (resultComponents != null && !resultComponents.isEmpty()) {
			for (Component resultComponent : resultComponents) {

				if (!cachedAllComponentsForNodeIDAndMetric.get(key).contains(
						resultComponent)) {
					allComponents.add(resultComponent);
					this.cachedAllComponentsForNodeIDAndMetric.put(key,
							allComponents);
					if (DataActivator.DEBUG) {
						System.out
								.println("IMPORTER:LOCATOR Auto created component name="
										+ resultComponent.getName()
										+ " # components in cache  = "
										+ allComponents.size()
										+ " for key: "
										+ key);
					}

				}
			}

			Component resultComponent = resultComponents.get(resultComponents
					.size() - 1);
			if (DataActivator.DEBUG) {
				System.out
						.println("IMPORTER:LOCATOR Decision return component name="
								+ resultComponent.getName()
								+ " # components in cache  = "
								+ allComponents.size() + " for key: " + key);
			}
			return resultComponent;
		}
		if (DataActivator.DEBUG) {
			System.out.println("IMPORTER:LOCATOR No result component");
		}

		return null;
	}

	@SuppressWarnings("unused")
	private List<Component> createForIdentifiers(
			List<IdentifierDescriptor> targetIdentifiers,
			Component targetComponent) {

		List<Component> resultComponents = Lists.newArrayList(targetComponent);

		List<IdentifierDescriptor> componentIdentifiers = Lists.newArrayList();
		componentIdentifiers.clear();
		for (IdentifierDescriptor iv : targetIdentifiers) {
			ObjectKindType objectKind = iv.getKind().getObjectKind();
			if (objectKind == ObjectKindType.EQUIPMENT
					|| objectKind == ObjectKindType.FUNCTION
					|| objectKind == ObjectKindType.RELATIONSHIP) {
				componentIdentifiers.add(iv);
			}
		}

		Component createOnComponent = targetComponent;
		for (IdentifierDescriptor descriptor : componentIdentifiers) {

			lastMatchingIdentifier = descriptor;
			if (DataActivator.DEBUG) {
				System.out.println("IMPORTER:CREATOR from identifiers size="
						+ componentIdentifiers.size()
						+ ", create for id object="
						+ lastMatchingIdentifier.getKind().getObjectKind()
								.getName() + " , property="
						+ lastMatchingIdentifier.getKind().getObjectProperty()
						+ " name=" + lastMatchingIdentifier.getValue());
			}
			Component result = createIdentified(createOnComponent,
					lastMatchingIdentifier);
			if (result != createOnComponent) {
				createOnComponent = result;
				resultComponents.add(result);
			}
		}
		return resultComponents;
	}

	private Component createIdentified(Component target,
			IdentifierDescriptor identifierDescriptor) {

		// The ultimate result, either a created component or the component
		// holding a relationship.
		Component resultComponent = null;

		if (identifierDescriptor != null) {

			String value = identifierDescriptor.getValue();

			if (identifierDescriptor.getKind().getObjectKind() == ObjectKindType.FUNCTION) {
				resultComponent = LibraryFactory.eINSTANCE.createFunction();
				((Function) target).getFunctions().add(
						(Function) resultComponent);
				resultComponent.setName(value);
				EStructuralFeature eFeature = this.featureForName(target,
						identifierDescriptor.getKind().getObjectProperty());
				if (eFeature != null) {
					target.eSet(eFeature, value);
				}

			} else if (identifierDescriptor.getKind().getObjectKind() == ObjectKindType.EQUIPMENT) {
				resultComponent = LibraryFactory.eINSTANCE.createEquipment();
				((Equipment) target).getEquipments().add(
						(Equipment) resultComponent);

				// Set the attribute based on the identifier, note that a
				// Component should always have a name.
				resultComponent.setName(value);

				EStructuralFeature eFeature = this.featureForName(target,
						identifierDescriptor.getKind().getObjectProperty());
				if (eFeature != null) {
					target.eSet(eFeature, value);
				}

			} else if (identifierDescriptor.getKind().getObjectKind() == ObjectKindType.RELATIONSHIP) {

				// Create a relationship, add it to the parent Network of
				// the Node,
				// set the Node and Component as one side, and leave the
				// rest dangling.

				if (target instanceof Function) {

					Function function = (Function) target;

					if (modelUtils != null) {
						Node node = modelUtils.resolveParentNode(function);
						if (node != null && node.eContainer() != null
								&& node.eContainer() instanceof Network) {

							Network net = (Network) node.eContainer();
							FunctionRelationship link = OperatorsFactory.eINSTANCE
									.createFunctionRelationship();

							// CB 02-11-2011 Model could use a bidi here

							link.setFunction1Ref(function);
							link.setName(value);
							link.setNodeID1Ref(node);
							function.getFunctionRelationshipRefs().add(link);
							net.getFunctionRelationships().add(link);
						}
					}

					// CB, not a component, but a relationship.
					// newChildComponent = LibraryFactory.eINSTANCE
					// .createFunction();
					// ((Function) target).getFunctions().add(
					// (Function) newChildComponent);

				} else if (target instanceof Equipment) {
					Equipment equipment = (Equipment) target;
					if (modelUtils != null) {
						Node node = modelUtils.resolveParentNode(equipment);
						if (node != null && node.eContainer() != null
								&& node.eContainer() instanceof Network) {

							Network net = (Network) node.eContainer();
							EquipmentRelationship link = OperatorsFactory.eINSTANCE
									.createEquipmentRelationship();
							link.setEquipment1Ref(equipment);
							link.setName(value);
							link.setNodeID1Ref(node);
							equipment.getEquipmentRelationshipRefs().add(link);
							net.getEquipmentRelationships().add(link);
						}
					}

					// CB, not a component, but a relationship.
					// newChildComponent = LibraryFactory.eINSTANCE
					// .createEquipment();
					// ((Equipment) target).getEquipments().add(
					// (Equipment) newChildComponent);
				}
				// We have not created a component, but a relationship.
				resultComponent = target;
			}
		}

		return resultComponent;
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
			IdentifierDescriptor identifierValue) {
		if (eObject == null) {
			return false;
		}
		if (eObject instanceof Node && isValidObject(eObject, identifierValue)) {
			// Bug Should not add metrics to a Network Element in the Warehouse.
			Node n = (Node) eObject;
			if (n.eContainer() != null && n.eContainer() instanceof Warehouse) {
				return false;
			}
			// valid parents are of eClass Network.
			return true;
		}
		return hasValidNode(eObject.eContainer(), identifierValue);
	}

	/*
	 * Match the identifier for the target eObject. If the identifier is a
	 * Relationship, the target eObject is expected to be a Component (Function
	 * or Equipment), which has a relationship matching the identifier value
	 * (For the target row).
	 */
	private boolean isValidObject(EObject eObject,
			IdentifierDescriptor identifierValue) {
		final String idValue = identifierValue.getValue() != null ? identifierValue
				.getValue().trim() : null;
		if (identifierValue.getKind().getObjectKind() == ObjectKindType.RELATIONSHIP) {
			if (eObject instanceof Function) {
				for (final FunctionRelationship r : ((Function) eObject)
						.getFunctionRelationshipRefs()) {
					if (featureMatchesValue(r, identifierValue.getKind()
							.getObjectProperty(), idValue)) {
						return true;
					}
				}
			} else {
				for (final EquipmentRelationship r : ((Equipment) eObject)
						.getEquipmentRelationshipRefs()) {
					if (featureMatchesValue(r, identifierValue.getKind()
							.getObjectProperty(), idValue)) {
						return true;
					}
				}
			}
			return false;
		} else {
			return featureMatchesValue(eObject, identifierValue.getKind()
					.getObjectProperty(), idValue);
		}
	}

	private boolean featureMatchesValue(EObject eObject, String eFeatureName,
			String idValue) {

		EStructuralFeature eFeature = featureForName(eObject, eFeatureName);

		if (eFeature != null) {
			final Object componentFeatureValue = eObject.eGet(eFeature);
			if (componentFeatureValue instanceof String
					&& matches(idValue, (String) componentFeatureValue)) {
				return true;
			}
		}
		// check if one of the parents has this one
		if (eObject.eContainer() != null) {
			return featureMatchesValue(eObject.eContainer(), eFeatureName,
					idValue);
		}
		return false;
	}

	private EStructuralFeature featureForName(EObject eObject,
			String eFeatureName) {
		EStructuralFeature eFeature = null;
		for (final EStructuralFeature feature : eObject.eClass()
				.getEAllStructuralFeatures()) {
			if (feature.getName().compareToIgnoreCase(eFeatureName) == 0) {
				eFeature = feature;
				break;
			}
		}
		return eFeature;
	}

	private boolean matches(String dataValue, String componentValue) {
		return dataValue.trim().equals(componentValue.trim());
	}

	public static class IdentifierDescriptor {
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

	private String getKey(IdentifierDescriptor nodeValue, Metric metric) {

		String value = null;
		if (nodeValue.getKind().eIsSet(
				MetricsPackage.Literals.IDENTIFIER_DATA_KIND__PATTERN)) {
			String extractionPattern = nodeValue.getKind().getPattern();
			if (extractionPattern != null && extractionPattern.length() > 0) {

				try {
					Pattern pattern = Pattern.compile(extractionPattern);
					Matcher matcher = pattern.matcher(nodeValue.getValue());
					String extract = null;
					if (matcher.lookingAt()) {
						int gc = matcher.groupCount();
						// Check for a single match, the pattern should extract
						// a
						// single value
						// which is not the 0 group, but the first one.
						if (gc == 1) {
							extract = matcher.group(1);
						}
					}
					if (extract != null) {
						value = extract;
					}

				} catch (PatternSyntaxException pse) {
					// ignore the pattern, value will be picked up later on.
				}
			}
		}

		if (value == null) {
			value = nodeValue.getValue();
		}
		return nodeValue.getKind().getObjectProperty() + "_" + value + "_"
				+ metric.cdoID().toString();
	}

	public List<IdentifierDescriptor> getSuccessFullIdentifiers() {
		return successFullIdentifiers;
	}

	public List<IdentifierDescriptor> getFailedIdentifiers() {
		return failedIdentifiers;
	}

	// FIXME Predicate not working!
	// public class NotNodeIdentifier implements
	// Predicate<NetworkElementLocator.IdentifierDescriptor> {
	//
	// public NotNodeIdentifier() {
	//
	// }
	//
	// public boolean apply(NetworkElementLocator.IdentifierDescriptor input) {
	// if (input.getKind().getObjectKind().equals(ObjectKindType.NODE)) {
	// return false;
	// } else {
	// return true;
	// }
	// }
	// }
	//
	// private NotNodeIdentifier notNodeIdentifier() {
	// return new NotNodeIdentifier();
	// }

}
