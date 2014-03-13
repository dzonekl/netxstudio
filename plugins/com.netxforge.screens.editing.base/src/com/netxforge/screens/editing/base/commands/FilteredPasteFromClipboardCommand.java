/*******************************************************************************
 * Copyright (c) Oct 3, 2011 NetXForge.
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
 *******************************************************************************/ package com.netxforge.screens.editing.base.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.StrictCompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Specialized Paste from clipboard. 
 * @author Christophe Bouhier
 *
 */
public class FilteredPasteFromClipboardCommand extends PasteFromClipboardCommand {

	public FilteredPasteFromClipboardCommand(EditingDomain domain,
			Object owner, Object feature, int index) {
		super(domain, owner, feature, index);
	}

	public FilteredPasteFromClipboardCommand(EditingDomain domain,
			Object owner, Object feature, int index, boolean optimize) {
		super(domain, owner, feature, index, optimize);
	}

	@Override
	protected boolean prepare() {
		// Create a strict compound command to do a copy and then add the result
	    //
	    command = new StrictCompoundCommand();

	    // Create a command to copy the clipboard.
	    //
	    final Command copyCommand = CopyCommand.create(domain, domain.getClipboard());
	    command.append(copyCommand);

	    // Create a proxy that will create an add command.
	    //
	    command.append
	      (new CommandWrapper()
	       {
	         protected Collection<Object> original;
	         protected Collection<Object> copy;

	         @Override
	         protected Command createCommand()
	         {
	           original = domain.getClipboard();
	           copy = new ArrayList<Object>(copyCommand.getResult());

	           // Use the original to do the add, but only if it's of the same type as the copy.
	           // This ensures that if there is conversion being done as part of the copy,
	           // as would be the case for a cross domain copy in the mapping framework,
	           // that we do actually use the converted instance.
	           //
	           if (original.size() == copy.size())
	           {
	             for (Iterator<Object> i = original.iterator(), j = copy.iterator(); i.hasNext(); )
	             {
	               Object originalObject = i.next();
	               Object copyObject = j.next();
	               if (originalObject.getClass() != copyObject.getClass())
	               {
	                 original = null;
	                 break;
	               }
	             }
	           }
	           
	           Command addCommand = AddCommand.create(domain, owner, feature, original == null ? copy : original, index);
	           return addCommand;
	         }

	         @Override
	         public void execute()
	         {
	           if (original != null)
	           {
	             domain.setClipboard(copy);
	           }
	           super.execute();
	         }

	         @Override
	         public void undo()
	         {
	           super.undo();
	           if (original != null)
	           {
	             domain.setClipboard(original);
	           }
	         }

	         @Override
	         public void redo()
	         {
	           if (original != null)
	           {
	             domain.setClipboard(copy);
	           }
	           super.redo();
	         }
	       });

	    boolean result;
	    if (optimize)
	    {
	      // This will determine canExecute as efficiently as possible.
	      //
	      result = optimizedCanExecute();
	    }
	    else
	    {
	      // This will actually execute the copy command in order to check if the add can execute.
	      //
	      result = command.canExecute();
	    }

	    return result;
	}
	
}
