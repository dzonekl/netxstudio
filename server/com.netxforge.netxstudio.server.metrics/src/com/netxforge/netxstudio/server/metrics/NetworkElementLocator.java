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
package com.netxforge.netxstudio.server.metrics;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.server.Server;

/**
 * Is responsible for finding a network element using a set of IdentifierValues.
 * 
 * @author Martin Taal
 */
public class NetworkElementLocator {

	@Inject
	@Server
	private IDataProvider dataProvider;

	public Component locateNetworkElement(Metric metric,
			List<IdentifierValue> identifiers) {

		final EReference sourceReference = LibraryPackage.eINSTANCE
				.getComponent_MetricRefs();

		// find the cross references to this metric
		final List<CDOObjectReference> results = dataProvider.getTransaction()
				.queryXRefs(metric, sourceReference);
		final List<Component> components = new ArrayList<Component>();
		for (final CDOObjectReference objectReference : results) {
			final CDOObject source = objectReference.getSourceObject();
			if (source instanceof Component && !components.contains(source)) {
				components.add((Component) source);
				addChildren((Component) source, components);
			}
		}
		for (final Component source : components) {
			boolean foundValidNode = false;
			for (final IdentifierValue identifierValue : identifiers) {
				if (identifierValue.getKind().getObjectKind() == ObjectKindType.NODE
						&& hasValidNode(source, identifierValue)) {
					foundValidNode = true;
					break;
				}
			}
			if (foundValidNode) {
				boolean allFeaturesValid = true;
				boolean atLeastOneFeatureChecked = false;
				for (final IdentifierValue identifierValue : identifiers) {
					if (identifierValue.getKind().getObjectKind() != ObjectKindType.NODE) {
						atLeastOneFeatureChecked = true;
						if (!isValidObject(source, identifierValue)) {
							allFeaturesValid = false;
							break;
						}
					}
				}
				if (atLeastOneFeatureChecked && allFeaturesValid) {
					return source;
				}
			}
		}

		return null;
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
					if (featureHasValue(r, identifierValue.getKind()
							.getObjectProperty(), idValue)) {
						return true;
					}
				}
			} else {
				for (final EquipmentRelationship r : ((Equipment) eObject)
						.getEquipmentRelationshipRefs()) {
					if (featureHasValue(r, identifierValue.getKind()
							.getObjectProperty(), idValue)) {
						return true;
					}
				}
			}
			return false;
		} else {
			return featureHasValue(eObject, identifierValue.getKind()
					.getObjectProperty(), idValue);
		}
	}

	private boolean featureHasValue(EObject eObject, String eFeatureName,
			String idValue) {
		EStructuralFeature eFeature = null;
		for (final EStructuralFeature feature : eObject.eClass().getEAllStructuralFeatures()) {
			if (feature.getName().compareToIgnoreCase(eFeatureName) == 0) {
				eFeature = feature;
				break;
			}
		}
		
		eObject.eClass()
				.getEStructuralFeature(eFeatureName);
		if (eFeature != null) {
			final Object value = eObject.eGet(eFeature);
			if (value instanceof String && value.equals(idValue)) {
				return true;
			}
		}
		// check if one of the parents has this one
		if (eObject.eContainer() != null) {
			return featureHasValue(eObject.eContainer(), eFeatureName, idValue);
		}
 		return false;
	}

	public static class IdentifierValue {
		private IdentifierDataKind kind;
		private String value;

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

	}

	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}
}
