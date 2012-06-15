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

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.AllPurposeCache;
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
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Warehouse;

/**
 * Is responsible for finding a position in a the Network Hierarchy using a set
 * of IdentifierValues. The Node Identifier value is mandatory.
 * 
 * 
 * @author Martin Taal
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class ComponentLocator {

	// @Inject
	// @Server
	private IDataProvider dataProvider;

	@Inject
	private ModelUtils modelUtils;

	// the key format is:
	private AllPurposeCache<String, List<Component>> componentsCache;
	private AllPurposeCache<String, List<Component>> allComponentsCache;

	// keeps track of the most successfull identifiers, can be used to provide
	// more
	// information to the user on which columns failed
	private List<IdentifierDescriptor> successFullIdentifiers = Lists
			.newArrayList();

	private List<IdentifierDescriptor> failedIdentifiers = Lists.newArrayList();

	private List<Component> successFullComponents = Lists.newArrayList();

	private IdentifierDescriptor lastMatchingIdentifier = null;

	private ParameterizedFunction cacheFunction;

	private ParameterizedFunction allComponentsCacheFunction;

	public IdentifierDescriptor getLastMatchingIdentifier() {
		return lastMatchingIdentifier;
	}

	public void setLastMatchingIdentifier(
			IdentifierDescriptor lastMatchingIdentifier) {
		this.lastMatchingIdentifier = lastMatchingIdentifier;
	}

	/*
	 * A specialized function, which accepts some parameters needed when
	 * applying the function.
	 */
	class ParameterizedFunction implements
			com.google.common.base.Function<String, List<Component>> {

		private Metric metric;
		private List<IdentifierDescriptor> descriptors;
		private IdentifierDescriptor nodeDescriptor;

		public void setParameters(Metric metric,
				List<IdentifierDescriptor> descriptors,
				IdentifierDescriptor nodeDescriptor) {
			this.metric = metric;
			this.descriptors = descriptors;
			this.nodeDescriptor = nodeDescriptor;
		}

		public List<Component> apply(String from) {

			if (metric == null || descriptors == null) {
				return null;
			}
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
						"-- calling xref for key=" + from);
			}

			// Result set.
			List<Component> matchingComponents = Lists.newArrayList();

			// /////////////////////////////////////////////////////
			// SEARCH SCOPE
			// /////////////////////////////////////////////////////
			/*
			 * flag for limiting the search scope and bail on references which
			 * are not in the identifier scope. When no scope is defined, all
			 * matching references will be evaluated.
			 */
			boolean searchingForAll = true;
			boolean searchingForEquipment = false;
			boolean searchingForFunction = false;
			for (final IdentifierDescriptor idValue : descriptors) {
				if (idValue.getKind().getObjectKind() == ObjectKindType.EQUIPMENT) {
					searchingForEquipment = true;
					searchingForAll = false;
					break;
				} else if (idValue.getKind().getObjectKind() == ObjectKindType.FUNCTION) {
					searchingForFunction = true;
					searchingForAll = false;
				}
			}

			// /////////////////////////////////////////////////////
			// CALL REFERENCER ON COMPONENT_METRIC FEATURE
			// /////////////////////////////////////////////////////

			// find the cross references to this metric, Note this could be a
			// component which is a NodeType Component.
			final List<CDOObjectReference> results = dataProvider
					.getView().queryXRefs(metric,
							LibraryPackage.eINSTANCE.getComponent_MetricRefs());

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
						"-- References for: "
								+ LibraryPackage.eINSTANCE
										.getComponent_MetricRefs().getName()
								+ " =" + results.size());
			}
			for (final CDOObjectReference objectReference : results) {
				final CDOObject referingObject = objectReference
						.getSourceObject();
				if (DataActivator.DEBUG) {
					if (referingObject instanceof Component) {
						DataActivator.TRACE
								.trace(DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
										"-- ref: component="
												+ ((Component) referingObject)
														.getName()
												+ " cdo res path="
												+ modelUtils
														.cdoResourcePath(referingObject));
					}
				}

				// walk up the node hierarchy and end up with a Node object
				// which should be equal
				// to the node identifier, otherwise skip this component.
				if (!hasValidNode(referingObject, nodeDescriptor)) {
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
						&& !matchingComponents.contains(referingObject)) {
					matchingComponents.add((Component) referingObject);
					// addChildren((Component) referingObject, allComponents);
				}
			}

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
						"-- components for: "
								+ LibraryPackage.eINSTANCE
										.getComponent_MetricRefs().getName()
								+ " =" + matchingComponents.size());
			}
			return matchingComponents;
		}

	}

	public ComponentLocator() {
		// init the cache.
		this.initialize();
	}

	/**
	 * Should be called to initialize the cache.
	 */
	public void initialize() {

		// cache key is calculated from the metric & the node identifier
		// descriptor. (Should always be present).
		if (componentsCache == null) {
			cacheFunction = new ParameterizedFunction();
			componentsCache = new AllPurposeCache<String, List<Component>>(
					cacheFunction) {
			};
		}

		if (allComponentsCache == null) {
			allComponentsCacheFunction = new ParameterizedFunction() {

				@Override
				public List<Component> apply(String from) {
					List<Component> components = componentsCache.get(from);
					// add the children.
					// The list of resolved components, as a cross reference
					// could
					// have multiple.
					List<Component> allComponentsMatchingMetrics = Lists
							.newArrayList();

					// add the parent components and their children.
					allComponentsMatchingMetrics.addAll(components);
					int childrenCount = allComponentsMatchingMetrics.size();
					for (Component c : components) {
						addChildren(c, allComponentsMatchingMetrics);
					}

					childrenCount = allComponentsMatchingMetrics.size()
							- childrenCount;
					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
								"-- children components for: "
										+ LibraryPackage.eINSTANCE
												.getComponent_MetricRefs()
												.getName() + " ="
										+ childrenCount);
					}

					return allComponentsMatchingMetrics;
				}
			};
			allComponentsCache = new AllPurposeCache<String, List<Component>>(
					allComponentsCacheFunction);
		}

	}

	public Component locateComponent(Metric metric,
			List<IdentifierDescriptor> descriptors) {

		successFullIdentifiers.clear();
		failedIdentifiers.clear();
		successFullComponents.clear();

		setLastMatchingIdentifier(null);

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
					"Start locator , metric=" + metric.getName()
							+ " # idenfifiers =" + descriptors.size()
							+ " id's are: ");
			for (IdentifierDescriptor iv : descriptors) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_LOCATOR_OPTION, "-- ID col="
								+ iv.getColumn() + " ,value=" + iv.getValue());
			}
		}

		IdentifierDescriptor nodeDescriptor = getNodeIdentifier(descriptors);
		if (nodeDescriptor == null) {
			failedIdentifiers.add(nodeDescriptor);
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
						"-- no network element identifier=" + nodeDescriptor
								+ " , abort component locator");
			}

			return null;
		}
		final String key = getKey(nodeDescriptor, metric);
		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_IMPORT_LOCATOR_OPTION, "-- key=" + key);
		}

		// CB MOVED TO A FUNCTIONAL CACHE, 16-12-2012.
		// A subset, not containing the children.
		cacheFunction.setParameters(metric, descriptors, nodeDescriptor);
		List<Component> allComponentsMatchingMetric = allComponentsCache
				.get(key);
		if (allComponentsMatchingMetric == null) {
			return null;
		}

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
					"-- start matching components");
		}

		// make a copy, ommitting the node descriptor to reduce the list.
		// List<IdentifierDescriptor> lookupList =
		// Lists.newArrayListWithCapacity(descriptors.size());
		// int indexOfNodeDescriptor = descriptors.indexOf(nodeDescriptor);
		// Collections.copy(lookupList, descriptors);
		// lookupList.remove(indexOfNodeDescriptor);

		Component result = matchIdentifiers(descriptors, nodeDescriptor,
				allComponentsMatchingMetric);

		if (result != null) {
			return result;
		}

		// /////////////////////////////////////////////////////
		// SEARCH FAILED
		// /////////////////////////////////////////////////////

		// report the failed ID's.
		for (final IdentifierDescriptor idValue : descriptors) {
			if (!successFullIdentifiers.contains(idValue)) {
				failedIdentifiers.add(idValue);
			}
		}

		// CB AUTO CREATION DISABLED.
		// All components checked, and we have identifiers pointing, so create a
		// Component with the identifier name. Note: This can't be turned off
		// for now.
		// if (DataActivator.DEBUG) {
		// System.out
		// .println("IMPORTER:LOCATOR  end matching component, no result, proceed to auto-create");
		// }
		// result = createComponent(key, allComponentsMatchingMetrics,
		// componentsMatchingMetric);

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
					"-- no result component");
		}

		return null;
	}

	/*
	 * DON'T USE THIS FOR NOW. FIXME Review how created components are added to
	 * the cache.
	 */
	@SuppressWarnings("unused")
	private Component createComponent(final String key,
			List<Component> allComponentsMatchingMetrics,
			List<Component> componentsMatchingMetric) {

		List<Component> resultComponents = null;
		Component resultComponent = null;

		// Disable auto creation.
		if (failedIdentifiers.size() > 0) {
			Component createOnComponent = null;
			if (successFullComponents.size() > 0) {
				createOnComponent = successFullComponents
						.get(successFullComponents.size() - 1);
			} else if (componentsMatchingMetric.size() > 0) {
				createOnComponent = componentsMatchingMetric
						.get(componentsMatchingMetric.size() - 1);
			}
			if (createOnComponent != null) {
				resultComponents = createForIdentifiers(failedIdentifiers,
						createOnComponent);
			}
		}

		if (resultComponents != null && !resultComponents.isEmpty()) {
			for (Component c : resultComponents) {

				if (!allComponentsMatchingMetrics.contains(resultComponent)) {
					allComponentsMatchingMetrics.add(c);
					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
								"-- auto created component name=" + c.getName()
										+ " # components in cache  = "
										+ allComponentsMatchingMetrics.size()
										+ " for key: " + key);
					}

				}
			}

			resultComponent = resultComponents.get(resultComponents.size() - 1);
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
						"-- decision return component name="
								+ resultComponent.getName()
								+ " # components in cache  = "
								+ allComponentsMatchingMetrics.size()
								+ " for key: " + key);
			}
			return resultComponent;
		}
		return null;
	}

	// Iterate through components and sub iterate through the identifiers,
	// having a full match of identifiers
	// and components.
	private Component matchIdentifiers(List<IdentifierDescriptor> identifiers,
			IdentifierDescriptor nodeIdentifier,
			List<Component> allComponentsMatchingMetrics) {

		for (final Component componentToVerify : allComponentsMatchingMetrics) {

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
						"-- verify component name="
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

			// If we are here, we already know the Node Identifier matches,
			// so do not test again.
			for (final IdentifierDescriptor idDescriptor : identifiers) {

				// Skip the Node identifier.
				if (idDescriptor.getKind().getObjectKind() != ObjectKindType.NODE) {
					atLeastOneIdentifierChecked = true;

					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
								"-- try matching identifier:"
										+ idDescriptor.getValue()
										+ " , for component name="
										+ componentToVerify.getName());
					}
					// Check if the identifier matches the component name.
					if (!isMatching(componentToVerify, idDescriptor, true)) {
						if (DataActivator.DEBUG) {
							DataActivator.TRACE.trace(
									DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
									"-- matching failed:"
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
							DataActivator.TRACE.trace(
									DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
									"-- matching succeeded:"
											+ idDescriptor.getValue()
											+ " , for component name="
											+ componentToVerify.getName());
						}
					}
				}
			}

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
						"-- matching identifiers #="
								+ localSuccessFullIdentifiers.size());
			}
			if (localSuccessFullIdentifiers.size() > successFullIdentifiers
					.size()) {
				successFullIdentifiers = localSuccessFullIdentifiers;
				successFullComponents = localSucssFullComponents;
			}
			if (atLeastOneIdentifierChecked && allIdentifiersValid) {
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
							"-- decision, all identifiers are valid, result component name="
									+ componentToVerify.getName());
				}
				return componentToVerify;
			}

			// A component, with the correct node, correct metric but no
			// identifier , return the first one
			if (atLeastOneIdentifierChecked == false) {
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
							"-- decision, no identifiers found, result component name="
									+ componentToVerify.getName());
				}
				return componentToVerify;
			}
		}
		return null;
	}

	// DO NOT USE, DOESN"T WORK.
	@SuppressWarnings("unused")
	private Component matchIdentifiersAdvanced(
			List<IdentifierDescriptor> identifiers,
			IdentifierDescriptor nodeIdentifier,
			List<Component> allComponentsMatchingMetrics) {

		// Identifiers which have matched, The Node Identifier = 1.
		final List<IdentifierDescriptor> localSuccessFullIdentifiers = Lists
				.newArrayList();
		localSuccessFullIdentifiers.add(nodeIdentifier);

		// All identifiers are valid (Excluding the Node identifier).
		boolean allIdentifiersValid = true;

		// At least one identifier has been verified.
		boolean atLeastOneIdentifierChecked = false;

		final List<Component> localSucssFullComponents = Lists.newArrayList();

		for (final IdentifierDescriptor idDescriptor : identifiers) {
			atLeastOneIdentifierChecked = true;

			if (idDescriptor.getKind().getObjectKind() == ObjectKindType.NODE) {
				// If no other identifiers, this should still work.
				continue; // skip node descriptor
			} else if (idDescriptor.getKind().getObjectKind() == ObjectKindType.RELATIONSHIP) {
				// TODO, predicate for relationships.
				continue;
			} else {
				// match a component Identifier.
				Component c = Iterators.find(
						allComponentsMatchingMetrics.iterator(),
						new MatchComponentPredicate(idDescriptor));
				if (c != null) {
					if (!localSucssFullComponents.contains(c)) {
						localSucssFullComponents.add(c);
					}
					localSuccessFullIdentifiers.add(idDescriptor);
					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
								"-- matching succeeded:"
										+ idDescriptor.getValue()
										+ " , for component name="
										+ c.getName());
					}
				} else {
					allIdentifiersValid = false;
					if (DataActivator.DEBUG) {
						DataActivator.TRACE
								.trace(DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
										"-- matching failed:"
												+ idDescriptor.getValue());
					}
				}
			}
		}

		// update the global state.
		if (localSuccessFullIdentifiers.size() > successFullIdentifiers.size()) {
			successFullIdentifiers = localSuccessFullIdentifiers;
			successFullComponents = localSucssFullComponents;
		}

		Component result = null;

		// We checked at least one, and all are actually valid so get the first
		// matching entry. (There could be more).
		if (atLeastOneIdentifierChecked && allIdentifiersValid) {
			if (localSucssFullComponents.size() > 0) {
				result = localSucssFullComponents.get(0);
			}
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
						"-- decision, all identifiers are valid from a set of "
								+ localSucssFullComponents.size());
				if (result != null) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
							"-- result component name=" + result.getName());
				}
			}
		}

		return result;
	}

	private IdentifierDescriptor getNodeIdentifier(
			List<IdentifierDescriptor> identifiers) {
		// find the node identifier otherwise bail out.
		IdentifierDescriptor nodeIdentifier = null;
		for (final IdentifierDescriptor identifierValue : identifiers) {
			if (identifierValue.getKind().getObjectKind() == ObjectKindType.NODE) {
				nodeIdentifier = identifierValue;
				break;
			}
		}

		return nodeIdentifier;
	}

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
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
						"-- from identifiers size="
								+ componentIdentifiers.size()
								+ ", create for id object="
								+ lastMatchingIdentifier.getKind()
										.getObjectKind().getName()
								+ " , property="
								+ lastMatchingIdentifier.getKind()
										.getObjectProperty() + " name="
								+ lastMatchingIdentifier.getValue());
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
				// EStructuralFeature eFeature = this.featureForName(target,
				// identifierDescriptor.getKind().getObjectProperty());
				if (identifierDescriptor.getPropertyFeature() != null) {
					target.eSet(identifierDescriptor.getPropertyFeature(),
							value);
				}

			} else if (identifierDescriptor.getKind().getObjectKind() == ObjectKindType.EQUIPMENT) {
				resultComponent = LibraryFactory.eINSTANCE.createEquipment();
				((Equipment) target).getEquipments().add(
						(Equipment) resultComponent);

				// Set the attribute based on the identifier, note that a
				// Component should always have a name.
				resultComponent.setName(value);

				// EStructuralFeature eFeature = this.featureForName(target,
				// identifierDescriptor.getKind().getObjectProperty());
				if (identifierDescriptor.getPropertyFeature() != null) {
					target.eSet(identifierDescriptor.getPropertyFeature(),
							value);
				}

			} else if (identifierDescriptor.getKind().getObjectKind() == ObjectKindType.RELATIONSHIP) {

				// Create a relationship, add it to the parent Network of
				// the Node,
				// set the Node and Component as one side, and leave the
				// rest dangling.

				if (target instanceof Function) {

					Function function = (Function) target;

					if (modelUtils != null) {
						Node node = modelUtils.nodeFor(function);
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
						Node node = modelUtils.nodeFor(equipment);
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
		if (eObject instanceof Node
				&& isMatching(eObject, identifierValue, false)) {
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
	private boolean isMatching(EObject eObject,
			IdentifierDescriptor identifierDescriptor,
			boolean shouldMatchParents) {

		// A null identifier should not be created!
		final String idValue = identifierDescriptor.getValue() != null ? identifierDescriptor
				.getValue() : null;

		if (identifierDescriptor.getKind().getObjectKind() == ObjectKindType.RELATIONSHIP) {
			if (eObject instanceof Function) {
				for (final FunctionRelationship r : ((Function) eObject)
						.getFunctionRelationshipRefs()) {
					if (objectFeatureMatchesValue(r,
							identifierDescriptor.getPropertyFeature(), idValue,
							shouldMatchParents)) {
						return true;
					}
				}
			} else {
				for (final EquipmentRelationship r : ((Equipment) eObject)
						.getEquipmentRelationshipRefs()) {
					if (objectFeatureMatchesValue(r,
							identifierDescriptor.getPropertyFeature(), idValue,
							shouldMatchParents)) {
						return true;
					}
				}
			}
			return false;
		} else {
			return objectFeatureMatchesValue(eObject,
					identifierDescriptor.getPropertyFeature(), idValue,
					shouldMatchParents);
		}
	}

	/*
	 * Potentially walks up the containment hierarchy to find this value. Can be
	 * disabled for certain cases.
	 */
	private boolean objectFeatureMatchesValue(EObject eObject,
			EStructuralFeature eFeature, String idValue,
			boolean shouldMatchParents) {

		// CB, feature is already produced with the descriptor.
		// EStructuralFeature eFeature = featureForName(eObject, eFeatureName);
		if (eFeature == null) {
			throw new IllegalStateException(
					"ComponentLocator, feature must be set");
		}

		if (eFeature != null && eObject.eClass().getFeatureID(eFeature) != -1) {
			final Object componentFeatureValue = eObject.eGet(eFeature);
			if (componentFeatureValue instanceof String
					&& matches(idValue, (String) componentFeatureValue)) {
				return true;
			}
		}

		if (eObject.eContainer() != null) {
			return objectFeatureMatchesValue(eObject.eContainer(), eFeature,
					idValue, shouldMatchParents);
		}
		return false;
	}

	// private EStructuralFeature featureForName(EObject eObject,
	// String eFeatureName) {
	// EStructuralFeature eFeature = null;
	// for (final EStructuralFeature feature : eObject.eClass()
	// .getEAllStructuralFeatures()) {
	// if (feature.getName().compareToIgnoreCase(eFeatureName) == 0) {
	// eFeature = feature;
	// break;
	// }
	// }
	// return eFeature;
	// }

	private boolean matches(String dataValue, String componentValue) {

		return dataValue.equals(componentValue.trim());
	}

	public class MatchComponentPredicate implements Predicate<Component> {
		private final IdentifierDescriptor identifierDescriptor;

		public MatchComponentPredicate(final IdentifierDescriptor descriptor) {
			this.identifierDescriptor = descriptor;
		}

		public boolean apply(final Component c) {
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_LOCATOR_OPTION,
						"-- try matching identifier:"
								+ identifierDescriptor.getValue()
								+ " , for component name=" + c.getName());
			}

			// A null identifier should not be created!
			final String idValue = identifierDescriptor.getValue() != null ? identifierDescriptor
					.getValue() : null;
			return objectFeatureMatchesValue(c,
					identifierDescriptor.getPropertyFeature(), idValue, true);
		}
	}

	public static class IdentifierDescriptor {
		private IdentifierDataKind kind;
		private String value;
		private int column;
		private EStructuralFeature propertyFeature;

		IdentifierDescriptor(IdentifierDataKind kind, String value, int column) {
			this.kind = kind;
			this.value = value;
			this.column = column;

			// Pre-create the feature, based on the identifier info.
			ObjectKindType objectKind = kind.getObjectKind();

			// We have some legacty configurations, which have the

			switch (objectKind.getValue()) {
			case ObjectKindType.EQUIPMENT_VALUE: {
				this.propertyFeature = featureForName(
						LibraryPackage.Literals.EQUIPMENT,
						kind.getObjectProperty());
			}
				break;
			case ObjectKindType.FUNCTION_VALUE: {
				this.propertyFeature = featureForName(
						LibraryPackage.Literals.FUNCTION,
						kind.getObjectProperty());
			}
				break;
			case ObjectKindType.NODE_VALUE: {
				this.propertyFeature = featureForName(
						OperatorsPackage.Literals.NODE,
						kind.getObjectProperty());
			}
				break;

			case ObjectKindType.RELATIONSHIP_VALUE: {
				this.propertyFeature = featureForName(
						OperatorsPackage.Literals.RELATIONSHIP,
						kind.getObjectProperty());
			}
				break;
			}

		}

		public IdentifierDataKind getKind() {
			return kind;
		}

		public String getValue() {
			return value;
		}

		public int getColumn() {
			return column;
		}

		public EStructuralFeature getPropertyFeature() {
			return propertyFeature;
		}

		public static IdentifierDescriptor valueFor(IdentifierDataKind kind,
				String value, int column) {
			if (kind == null || value == null || column < 0) {
				throw new IllegalArgumentException(
						"can't create descriptor for kind=" + kind + " value="
								+ value + " col=" + column);
			}
			return new IdentifierDescriptor(kind, value, column);
		}

		private EStructuralFeature featureForName(EClass clazz,
				String eFeatureName) {
			EStructuralFeature eFeature = null;
			for (final EStructuralFeature feature : clazz
					.getEAllStructuralFeatures()) {
				if (feature.getName().compareToIgnoreCase(eFeatureName) == 0) {
					eFeature = feature;
					break;
				}
			}
			return eFeature;
		}
	}

	// Never used.
	// public IDataProvider getDataProvider() {
	// return dataProvider;
	// }

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	/*
	 * Produces a key for the cache, extract the identifier value, applying a
	 * potential pattern fist. The key format is [objectProperty]_[Computed
	 * Identifier]_CDOID of metric.
	 */
	private String getKey(IdentifierDescriptor identifierDescriptor,
			Metric metric) {

		String value = null;
		if (identifierDescriptor.getKind().eIsSet(
				MetricsPackage.Literals.IDENTIFIER_DATA_KIND__PATTERN)) {
			String extractionPattern = identifierDescriptor.getKind()
					.getPattern();
			if (extractionPattern != null && extractionPattern.length() > 0) {

				try {
					Pattern pattern = Pattern.compile(extractionPattern);
					Matcher matcher = pattern.matcher(identifierDescriptor
							.getValue());
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
			value = identifierDescriptor.getValue();
		}
		return identifierDescriptor.getKind().getObjectProperty() + "_" + value
				+ "_" + metric.cdoID().toString();
	}

	public List<IdentifierDescriptor> getSuccessFullIdentifiers() {
		return successFullIdentifiers;
	}

	public List<IdentifierDescriptor> getFailedIdentifiers() {
		return failedIdentifiers;
	}

}
