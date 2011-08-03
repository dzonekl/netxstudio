package com.netxforge.netxstudio.screens.editing;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import com.netxforge.netxstudio.edit.CreateChildFromPoolCommand;
import com.netxforge.netxstudio.screens.editing.actions.WarningDeleteCommand;

/**
 * 
 * Customized version of the standard af editing domain. The principle use case,
 * is for creating commands.
 * 
 * 
 * @author dzonekl
 * 
 */
public class ScreensAdapterFactoryEditingDomain extends
		AdapterFactoryEditingDomain {

	public ScreensAdapterFactoryEditingDomain(AdapterFactory adapterFactory,
			CommandStack commandStack) {
		super(adapterFactory, commandStack);
	}

	@Override
	public Command createCommand(Class<? extends Command> commandClass,
			CommandParameter commandParameter) {
		
		
		Object owner = commandParameter.getOwner();
		
		// For the paste command, we like to paste into the parent resource.
		// FIXME, The ugly thing is that the selection is still the copied
		// object buh...
		if (commandClass == PasteFromClipboardCommand.class) {
			if (commandParameter.getOwner() instanceof CDOObject) {
				CDOObject oOwner = (CDOObject) commandParameter.getOwner();
				if (oOwner.eContainer() != null) {
					// Is it contained, we shoudn't touch this creation.
				}
				if (oOwner.eResource() != null) {
					return new PasteFromClipboardCommand(this,
							oOwner.eResource(), commandParameter.getFeature(),
							commandParameter.getIndex(), getOptimizeCopy());
				}
			}
		}
		else if (commandClass == WarningDeleteCommand.class) {
			return new WarningDeleteCommand(this, commandParameter.getCollection());
		} 
//		
		// A customized create from pool command class. 
		else if (owner != null && commandClass == CreateChildFromPoolCommand.class)
	    {
		      // If there is an adapter of the correct type...
		      //
		      IEditingDomainItemProvider editingDomainItemProvider = 
		        (IEditingDomainItemProvider)
		          adapterFactory.adapt(owner, IEditingDomainItemProvider.class);

		      return
		        editingDomainItemProvider != null ?
		          editingDomainItemProvider.createCommand(owner, this, commandClass, commandParameter) :
		        new ItemProviderAdapter(null).createCommand(owner, this, commandClass, commandParameter);
		 }

		Command nativeCommand = super.createCommand(commandClass,
				commandParameter);
		return nativeCommand;
	}

}
