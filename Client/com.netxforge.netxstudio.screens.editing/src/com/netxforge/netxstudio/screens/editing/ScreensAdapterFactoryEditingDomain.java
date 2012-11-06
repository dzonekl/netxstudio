package com.netxforge.netxstudio.screens.editing;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import com.netxforge.netxstudio.edit.CreateChildFromPoolCommand;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.editing.actions.WarningDeleteCommand;
import com.netxforge.netxstudio.screens.editing.actions.WarningNWBDeleteCommand;

/**
 * Customized version of the standard af editing domain. The principle use case,
 * is for creating commands.
 * 
 * Also understands the ScreensCommandStack, which can make a copy of the object
 * for revision tracking.
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

		// SPECIALIZED WARNING COMMAND.
		if (commandClass == WarningDeleteCommand.class) {
			return new WarningDeleteCommand(this,
					commandParameter.getCollection());
		}
		// SPECIALIZED WARNING DELETE WITH NO UNDO, DOMAIN is DISCARDED IN THIS COMMAND. 
		if (commandClass == WarningNWBDeleteCommand.class) {
			return new WarningNWBDeleteCommand(commandParameter.getCollection());
		}

		// SPECIALIED POOL COMMAND. (NOT USED).
		else if (owner != null
				&& commandClass == CreateChildFromPoolCommand.class) {
			// If there is an adapter of the correct type...
			//
			IEditingDomainItemProvider editingDomainItemProvider = (IEditingDomainItemProvider) adapterFactory
					.adapt(owner, IEditingDomainItemProvider.class);

			return editingDomainItemProvider != null ? editingDomainItemProvider
					.createCommand(owner, this, commandClass, commandParameter)
					: new ItemProviderAdapter(null).createCommand(owner, this,
							commandClass, commandParameter);
		}
		// SPECIALIZED CREATION OF EQUIPMENT UNDER A NODE WHICH IS ADDED TO A
		// NODETYPE.
		else if (owner != null && owner instanceof Node
				&& commandClass == CreateChildCommand.class) {

			Node n = (Node) owner;

			// A creation command for Node, should be faked as for Node Type.
			if (n.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {
				NodeType nt = n.getNodeType();

				IEditingDomainItemProvider editingDomainItemProvider = (IEditingDomainItemProvider) adapterFactory
						.adapt(nt, IEditingDomainItemProvider.class);
				commandParameter.setOwner(nt);
				return editingDomainItemProvider != null ? editingDomainItemProvider
						.createCommand(nt, this, commandClass, commandParameter)
						: new ItemProviderAdapter(null).createCommand(nt, this,
								commandClass, commandParameter);
			}

		}

		Command nativeCommand = super.createCommand(commandClass,
				commandParameter);

		// SPECIALED PASTE COMMAND TO PASTE INTO TABLES.
		// For the paste command, we like to paste into the parent resource for
		// flat views
		// like tables.
		// FIXME, The ugly thing is that the selection is still the copied
		// object buh...
		if (!nativeCommand.canExecute()
				&& commandClass == PasteFromClipboardCommand.class) {
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

		return nativeCommand;
	}
}
