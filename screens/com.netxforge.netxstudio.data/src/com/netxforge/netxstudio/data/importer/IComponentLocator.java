/*******************************************************************************
 * Copyright (c) 1 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.data.importer;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.Maps;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.operators.OperatorsPackage;

/**
 * An interface for locating {@link Component} objects based on an
 * <code>EReference</code>
 * {@link LibraryPackage.Literals#COMPONENT__METRIC_REFS} and a collection of
 * {@link IComponentLocator.IdentifierDescriptor descriptors}. </p>
 * <code>Components</code> can be nested with the features
 * {@link LibraryPackage#EQUIPMENT__EQUIPMENTS} and
 * {@link LibraryPackage#FUNCTION__FUNCTIONS}. </p>When nested
 * <code>Components</code> make up an hierarchical structure underr a root
 * {@link NodeType} object and have multiple attributes and references which
 * make one unique.</p> Implementors of a locator have several options for
 * locating a unique component</br>
 * <ul>
 * <li>Walk the component hierarchy, evaluating each Component for all criteria.
 * </li>
 * <li>Execute a query for the criteria</code>
 * </ul>
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public interface IComponentLocator {

	/**
	 * Describes the actual value of an {@link IndentifierDataKind Mapping
	 * Identifier}.
	 * 
	 * @author Christophe Bouhier
	 */
	public static class IdentifierDescriptor {

		private IdentifierDataKind kind;

		private int column;

		/** The corresponding {@link EStructuralFeature feature} */
		private EStructuralFeature propertyFeature;

		/** The property String */
		private String objectProperty;

		public String getObjectProperty() {
			return objectProperty;
		}

		/** The property value */
		private String value;

		private static final Map<String, EStructuralFeature> featuresForNode;
		private static final Map<String, EStructuralFeature> featuresForFunction;
		private static final Map<String, EStructuralFeature> featuresForEquipment;
		private static final Map<String, EStructuralFeature> featuresForRelationship;

		/** Possible EStructuralFeatures for the Object. */
		static {
			{
				featuresForNode = Maps.newHashMap();
				for (String featureName : ModelUtils.MAPPING_NODE_ATTRIBUTES) {
					if (featureName.equals(ModelUtils.NETWORK_ELEMENT_ID)) {
						featureName = ModelUtils.NODE_ID;
					}
					EStructuralFeature feature = featureForName(
							OperatorsPackage.Literals.NODE, featureName);
					featuresForNode.put(featureName, feature);
				}
			}
			{
				featuresForEquipment = Maps.newHashMap();
				for (String featureName : ModelUtils.MAPPING_EQUIPMENT_ATTRIBUTES) {
					EStructuralFeature feature = featureForName(
							LibraryPackage.Literals.EQUIPMENT, featureName);
					featuresForEquipment.put(featureName, feature);
				}
			}
			{
				featuresForFunction = Maps.newHashMap();
				for (String featureName : ModelUtils.MAPPING_FUNCTION_ATTRIBUTES) {
					EStructuralFeature feature = featureForName(
							LibraryPackage.Literals.FUNCTION, featureName);
					featuresForFunction.put(featureName, feature);
				}
			}
			{
				featuresForRelationship = Maps.newHashMap();
				for (String featureName : ModelUtils.MAPPING_REL_ATTRIBUTES) {
					EStructuralFeature feature = featureForName(
							OperatorsPackage.Literals.RELATIONSHIP, featureName);
					featuresForRelationship.put(featureName, feature);
				}
			}
		}

		IdentifierDescriptor(IdentifierDataKind kind, String value, int column) {
			this.kind = kind;
			this.value = value;
			this.column = column;

			// Pre-create the feature, based on the identifier info.
			ObjectKindType objectKind = kind.getObjectKind();

			this.objectProperty = kind.getObjectProperty();

			switch (objectKind.getValue()) {
			case ObjectKindType.EQUIPMENT_VALUE: {
				this.propertyFeature = featuresForEquipment.get(objectProperty);
			}
				break;
			case ObjectKindType.FUNCTION_VALUE: {
				this.propertyFeature = featuresForFunction.get(objectProperty);
			}
				break;
			case ObjectKindType.NODE_VALUE: {
				this.propertyFeature = featuresForNode.get(objectProperty);
			}
				break;

			case ObjectKindType.RELATIONSHIP_VALUE: {
				this.propertyFeature = featuresForRelationship
						.get(objectProperty);
			}
				break;
			}

		}

		public static Map<String, EStructuralFeature> getFeaturesfornode() {
			return featuresForNode;
		}

		public static Map<String, EStructuralFeature> getFeaturesforfunction() {
			return featuresForFunction;
		}

		public static Map<String, EStructuralFeature> getFeaturesforequipment() {
			return featuresForEquipment;
		}

		public static Map<String, EStructuralFeature> getFeaturesforrelationship() {
			return featuresForRelationship;
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

		/**
		 * Get an {@link EStructuralFeature feature} for the target
		 * {@link EClass} and a target name.
		 * 
		 * @param clazz
		 * @param eFeatureName
		 * @return
		 */
		private static EStructuralFeature featureForName(EClass clazz,
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

		@Override
		public String toString() {
			return "ID: prop: " + objectProperty + "= " + value + " col: " + column;
		}

	}

	/**
	 * Locate a {@link Component}
	 * 
	 * @param metric
	 * @param descriptors
	 * @return
	 */
	public abstract Component locateComponent(Metric metric,
			List<IComponentLocator.IdentifierDescriptor> descriptors);

	/**
	 * Locate a potential list of {@link Component components}.
	 * 
	 * @param metric
	 * @param descriptors
	 * @return
	 */
	public abstract List<Component> locateComponents(Metric metric,
			List<IComponentLocator.IdentifierDescriptor> descriptors);

	/**
	 * Locate a potential list of {@link Component components} using the
	 * provided {@link CDOView}.
	 * 
	 * @param view
	 * @param descriptors
	 * @return
	 */
	public abstract List<Component> locateComponents(CDOView view,
			List<IComponentLocator.IdentifierDescriptor> descriptors);

	/**
	 * Get a collection of {@link IComponentLocator.IdentifierDescriptor
	 * descriptors} which were not resolved by the locator.
	 * 
	 * @deprecated
	 * @return
	 */
	public List<IComponentLocator.IdentifierDescriptor> getFailedIdentifiers();

	/**
	 * Get the {@link IdentifierDescriptor descriptor} which lasts successfully
	 * matched.
	 * 
	 * 
	 * @deprecated
	 * @return
	 */
	public IComponentLocator.IdentifierDescriptor getLastMatchingIdentifier();

	/**
	 * Set the {@link IDataProvider} for the Locator to access data.
	 * 
	 * @param provider
	 */
	public void setDataProvider(IDataProvider provider);

	/**
	 * Allow the locator to prepare itself.
	 */
	public void initialize();

	/**
	 * Let's us know if the Locator is ready for service.
	 * 
	 * @return
	 */
	public boolean isInitialized();

}