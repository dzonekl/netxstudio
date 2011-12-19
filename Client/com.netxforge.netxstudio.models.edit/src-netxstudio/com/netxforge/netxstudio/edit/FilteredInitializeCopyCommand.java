
package com.netxforge.netxstudio.edit;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CopyCommand.Helper;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.collect.Lists;


/**
 * 
 * @author Christophe Bouhier
 */
public class FilteredInitializeCopyCommand extends NameSequenceInitializeCopyCommand {

	private EStructuralFeature[] filtered = null;

	public FilteredInitializeCopyCommand(EditingDomain domain, EObject owner,
			Helper copyHelper) {
		super(domain, owner, copyHelper);
	}

	public void setFilteredFeatures(EStructuralFeature... filtered) {
		this.filtered = filtered;

	}

	/**
	 * This method will iterate over the references of the owner object and sets
	 * them. accordingly in the copy.
	 */
	protected void copyReferences() {
		for (EReference reference : getReferencesToCopy()) {
			
			
			// Continue on our filtered references. 
			if(this.shouldFilter(reference)){
				continue;
			}
			if (!reference.isChangeable() || reference.isDerived()
					|| !owner.eIsSet(reference)) {
				continue;
			}
			
			
			EReference reverseReference = reference.getEOpposite();

			Object value = owner.eGet(reference);
			if (value == null) {
				// It must be an unsettable feature to be null and considered
				// set.
				//
				copy.eSet(reference, null);
				continue;
			}

			boolean copiedTargetRequired = reverseReference != null
					|| reference.isContainment();
			if (reference.isMany()) {
				@SuppressWarnings("unchecked")
				List<EObject> valueList = (List<EObject>) value;
				@SuppressWarnings("unchecked")
				EList<EObject> copyList = (EList<EObject>) copy.eGet(reference);
				if (valueList.isEmpty()) {
					// It must be an unsettable feature to be empty and
					// considered set.
					//
					copyList.clear();
				} else {
					int index = 0;
					for (EObject item : valueList) {
						EObject target = copyHelper.getCopyTarget(item,
								copiedTargetRequired);
						if (target == null)
							break; // if one is null, they'll all be null
						if (reverseReference != null) {
							int position = copyList.indexOf(target);
							if (position == -1) {
								copyList.add(index, target);
							} else {
								copyList.move(index, target);
							}
						} else {
							copyList.add(target);
						}
						++index;
					}
				}
			} else {
				EObject target = copyHelper.getCopyTarget((EObject) value,
						copiedTargetRequired);
				if (target != null) {
					copy.eSet(reference, target);
				}
			}
		}
	}
	
	
	protected boolean shouldFilter(EReference eRef){
		
		if(filtered == null){
			return false;
		}
		
		List<EStructuralFeature> filteredList = Lists.newArrayList(filtered);
		if(filteredList.contains(eRef)){
			return true;
		}
		
		return false;
	}

}
