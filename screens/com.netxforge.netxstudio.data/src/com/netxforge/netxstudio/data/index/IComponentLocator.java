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
package com.netxforge.netxstudio.data.index;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.Maps;
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.metrics.ValueDataKind;
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
	 * Describes the metric
	 * 
	 * @author Christophe Bouhier
	 */
	public static class MetricDescriptor {

		/** The column in the data matrix holding the metric value **/
		private int column;
		
		/** The metric object **/
		private Metric metric;
		
		/** The value data kind **/
		private ValueDataKind valueDataKind;

		public MetricDescriptor(ValueDataKind valueDataKind, Metric metric,
				int column) {
			this.valueDataKind = valueDataKind;
			this.column = column;
			this.metric = metric;
		}

		public static MetricDescriptor valueFor(ValueDataKind valueDataKind,
				Metric metricRef, int column) {

			// The pattern is optional.
			if (valueDataKind == null || column < 0) {
				throw new IllegalArgumentException(
						"can't create descriptor for kind=" + valueDataKind
								+ " metric=" + metricRef + " col=" + column);
			}
			return new MetricDescriptor(valueDataKind, metricRef, column);
		}
		
		
		public int getColumn() {
			return column;
		}

		public Metric getMetric() {
			return metric;
		}

		public ValueDataKind getValueDataKind() {
			return valueDataKind;
		}

	}

	/**
	 * Describes the actual value of an {@link IndentifierDataKind Mapping
	 * Identifier}.
	 * 
	 * @author Christophe Bouhier
	 */
	public static class IdentifierDescriptor {

		private IdentifierDataKind kind;

		/** An optional pattern to be applied when processing a column value **/
		private Pattern pattern;

		/** The column in the data matrix holding the value **/
		private int column;

		/** The corresponding {@link EStructuralFeature feature} */
		private EStructuralFeature propertyFeature;

		/** The property String */
		private String objectProperty;

		/**
		 * The property value which is already processed if a pattern is
		 * available.
		 */
		private String identifier;

		private static final Map<String, EStructuralFeature> featuresForNode;
		private static final Map<String, EStructuralFeature> featuresForFunction;
		private static final Map<String, EStructuralFeature> featuresForEquipment;
		private static final Map<String, EStructuralFeature> featuresForRelationship;

		/** Possible EStructuralFeatures for the Object. */
		static {
			{
				featuresForNode = Maps.newHashMap();
				for (String featureName : StudioUtils.MAPPING_NODE_ATTRIBUTES) {
					if (featureName.equals(StudioUtils.NETWORK_ELEMENT_ID)) {
						featureName = StudioUtils.NODE_ID;
					}
					EStructuralFeature feature = featureForName(
							OperatorsPackage.Literals.NODE, featureName);
					featuresForNode.put(featureName, feature);
				}
			}
			{
				featuresForEquipment = Maps.newHashMap();
				for (String featureName : StudioUtils.MAPPING_EQUIPMENT_ATTRIBUTES) {
					EStructuralFeature feature = featureForName(
							LibraryPackage.Literals.EQUIPMENT, featureName);
					featuresForEquipment.put(featureName, feature);
				}
			}
			{
				featuresForFunction = Maps.newHashMap();
				for (String featureName : StudioUtils.MAPPING_FUNCTION_ATTRIBUTES) {
					EStructuralFeature feature = featureForName(
							LibraryPackage.Literals.FUNCTION, featureName);
					featuresForFunction.put(featureName, feature);
				}
			}
			{
				featuresForRelationship = Maps.newHashMap();
				for (String featureName : StudioUtils.MAPPING_REL_ATTRIBUTES) {
					EStructuralFeature feature = featureForName(
							OperatorsPackage.Literals.RELATIONSHIP, featureName);
					featuresForRelationship.put(featureName, feature);
				}
			}
		}

		IdentifierDescriptor(IdentifierDataKind kind, Pattern pattern,
				int column) {

			this.column = column;
			this.pattern = pattern;
			this.kind = kind;
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

		public String getObjectProperty() {
			return objectProperty;
		}

		public IdentifierDataKind getKind() {
			return kind;
		}

		public Pattern getPattern() {
			return pattern;
		}

		public void setIdentifier(String identifier) {

			// Apply the regexp pattern if any specified.
			if (pattern != null) {

				Matcher matcher = pattern.matcher(identifier);
				String extract = null;
				if (matcher.find()) {
					int gc = matcher.groupCount();
					// Check for a single match, the pattern should
					// extract a
					// single value
					// which is not the 0 group, but the first one.
					if (gc == 1) {
						extract = matcher.group(1);
					}
				}
				if (extract != null) {
					this.identifier = extract;
				} else {
					// There is no result with this pattern, the mapping will
					// fail, we use this to
					// skip a complete row.
					// The value is set to null.
					this.identifier = null;
				}
			} else {
				this.identifier = identifier;
			}
		}

		public String getIdentifier() {
			return identifier;
		}

		public int getColumn() {
			return column;
		}

		public EStructuralFeature getPropertyFeature() {
			return propertyFeature;
		}

		public static IdentifierDescriptor valueFor(IdentifierDataKind kind,
				Pattern pattern, int column) {

			// The pattern is optional.
			if (kind == null || column < 0) {
				throw new IllegalArgumentException(
						"can't create descriptor for kind=" + kind
								+ " pattern=" + pattern + " col=" + column);
			}
			return new IdentifierDescriptor(kind, pattern, column);
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
			return "ID prop: " + objectProperty + "= " + identifier + " col: "
					+ column;
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
	 * Set the {@link ICDOData} for the Locator to access data.
	 * 
	 * @param provider
	 */
	public void setDataProvider(ICDOData provider);

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