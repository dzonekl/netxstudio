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
package com.netxforge.nextstudio.server.metrics;

import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.operators.Node;

/**
 * Is responsible for finding a network element using a set of IdentifierValues.
 * 
 * @author Martin Taal
 */
public class NetworkElementLocator {

	@Inject
	private IDataService dataService;
	
	public NetworkElementLocator() {
		DataActivator.getInjector().injectMembers(this);
	}
	
	public CDOObject locateNetworkElement(Metric metric, List<IdentifierValue> identifiers) {
	
		EReference sourceReference = LibraryPackage.eINSTANCE.getFunction_FunctionMetricRefs();
		for (final IdentifierValue idValue : identifiers) {
			if (idValue.getKind().getObjectKind() == ObjectKindType.EQUIPMENT) {
				sourceReference = LibraryPackage.eINSTANCE.getEquipment_EquipmentMetricRefs();
				break;
			}
		}
		
		// find the cross references to this metric
	    final List<CDOObjectReference> results = dataService.getProvider().getTransaction().queryXRefs(metric, sourceReference);
	    for (final CDOObjectReference objectReference : results) {
	    	final CDOObject source = objectReference.getSourceObject();
	    	boolean foundValidNode = false;
	    	for (final IdentifierValue identifierValue : identifiers) {
	    		if (identifierValue.getKind().getObjectKind() == ObjectKindType.NODE &&
	    				hasValidNode(source, identifierValue)) {
	    			foundValidNode = true;
	    			break;
	    		}
	    	}
	    	if (foundValidNode) {
	    		boolean allFeaturesValid = true;
	    		boolean atLeastOnFeatureChecked = false;
		    	for (final IdentifierValue identifierValue : identifiers) {
		    		if (identifierValue.getKind().getObjectKind() != ObjectKindType.NODE) {
		    			atLeastOnFeatureChecked = true;
		    			if (!isValidObject(source, identifierValue)) {
		    				allFeaturesValid = false;
		    				break;
		    			}
		    		}
		    	}
		    	if (atLeastOnFeatureChecked && allFeaturesValid) {
		    		return source;
		    	}
	    	}
	    }
		
		return null;
	}
	
	private boolean hasValidNode(EObject eObject, IdentifierValue identifierValue) {
		if (eObject == null) {
			return false;
		}
		if (eObject instanceof Node && isValidObject(eObject, identifierValue)) {
		    return true;
		}
		return hasValidNode(eObject.eContainer(), identifierValue);
	}
	
	private boolean isValidObject(EObject eObject, IdentifierValue identifierValue) {
		final EStructuralFeature eFeature = eObject.eClass().getEStructuralFeature(identifierValue.getKind().getObjectProperty());
		if (eFeature == null) {
			return false;
		}
		final Object value = eObject.eGet(eFeature);
		if (value instanceof String && value.equals(identifierValue.getValue())) {
			return true;
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
}
