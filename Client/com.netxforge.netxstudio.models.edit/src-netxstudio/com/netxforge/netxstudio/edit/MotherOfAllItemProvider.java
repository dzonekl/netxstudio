package com.netxforge.netxstudio.edit;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CopyCommand.Helper;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.services.RFSService;

/**
 * Generic ItemProvider which applies to all objects.
 * 
 * 
 * @author dzonekl
 * 
 */
public class MotherOfAllItemProvider extends ItemProviderAdapter {

	public MotherOfAllItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getCreateChildImage(Object owner, Object feature,
			Object child, Collection<?> selection) {

		if (feature instanceof EReference) {
			if (!shouldComposeCreationImage()) {
				String name = "full/ctool16/";
				if (child instanceof RFSService) {
					name += "Service_E.png";
				} else if (child instanceof EObject) {
					name += ((EObject) child).eClass().getName() + "_E.png";
				}

				try {
					return getResourceLocator().getImage(name);
				} catch (Exception exception) {
					// Ignore the exception and compose an image.
				}
			}
		}
		Object result = super.getCreateChildImage(owner, feature, child,
				selection);
		return result;
	}

	@Override
	public String getCreateChildText(Object owner, Object feature,
			Object child, Collection<?> selection) {
		StringBuffer buf = new StringBuffer();
		buf.append(super.getCreateChildText(owner, feature, child, selection));
		if (child instanceof Equipment
				&& ((Equipment) child)
						.eIsSet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_CODE)) {
			Equipment eq = (Equipment) child;
			if (eq.getEquipmentCode() != null) {
				buf.append(" : " + eq.getEquipmentCode());
			}
		} else if (child instanceof Function
				&& ((EObject) child)
						.eIsSet(LibraryPackage.Literals.COMPONENT__NAME)) {

			Function fc = (Function) child;
			buf.append(" : " + fc.getName());
		}

		return buf.toString();
	}

	/**
	 * We initialize our copy in a specialized way for an RFSService. We don't
	 * copy all containments. (Filter the ServiceMonitor objects).
	 * 
	 */
	@Override
	protected Command createInitializeCopyCommand(EditingDomain domain,
			EObject owner, Helper helper) {
		NameSequenceInitializeCopyCommand nscc = new NameSequenceInitializeCopyCommand(
				domain, owner, helper);
		return nscc;
	}

}
