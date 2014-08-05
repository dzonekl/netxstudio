/*******************************************************************************
 * Copyright (c) 2000, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.ui.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.activities.WorkbenchActivityHelper;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.actions.NewWizardShortcutAction;
import org.eclipse.ui.internal.dialogs.WorkbenchWizardElement;
import org.eclipse.ui.internal.registry.WizardsRegistryReader;
import org.eclipse.ui.wizards.IWizardCategory;
import org.eclipse.ui.wizards.IWizardDescriptor;

/**
 * A <code>NewWizardMenu</code> augments <code>BaseNewWizardMenu</code> with IDE-specific
 * actions: New Project... (always shown) and New Example... (shown only if there are example wizards installed).
 * <p>
 * <strong>Note:</strong> Clients must dispose this menu when it is no longer required.
 * </p>
 */
public class NewWizardMenu extends BaseNewWizardMenu {

    private final IAction newExampleAction;
    private final IAction newProjectAction;

    private boolean enabled = true;

    /**
     * Creates a new wizard shortcut menu for the IDE.
     * <p>
     * <strong>Note:</strong> Clients must dispose this menu when it is no longer required.
     * </p>
     * 
     * @param window
     *            the window containing the menu
     */
    public NewWizardMenu(IWorkbenchWindow window) {
        this(window, null);
        
    }
    
    /**
     * Creates a new wizard shortcut menu for the IDE.
     * <p>
     * <strong>Note:</strong> Clients must dispose this menu when it is no longer required.
     * </p>
     * 
     * @param window
     *            the window containing the menu
     * @param id
     *            the identifier for this contribution item 
     */
    public NewWizardMenu(IWorkbenchWindow window, String id) {
        super(window, id);
        newExampleAction = new NewExampleAction(window);
        newProjectAction = new NewProjectAction(window);
    }

    /**
     * Create a new wizard shortcut menu.  
     * <p>
     * If the menu will appear on a semi-permanent basis, for instance within
     * a toolbar or menubar, the value passed for <code>register</code> should be true.
     * If set, the menu will listen to perspective activation and update itself
     * to suit.  In this case clients are expected to call <code>deregister</code> 
     * when the menu is no longer needed.  This will unhook any perspective
     * listeners.
     * </p>
     * <p>
     * <strong>Note:</strong> Clients must dispose this menu when it is no longer required.
     * </p>
     *
     * @param innerMgr the location for the shortcut menu contents
     * @param window the window containing the menu
     * @param register if <code>true</code> the menu listens to perspective changes in
     *      the window
     * @deprecated use NewWizardMenu(IWorkbenchWindow) instead
     */
    public NewWizardMenu(IMenuManager innerMgr, IWorkbenchWindow window,
            boolean register) {
        this(window, null);
        fillMenu(innerMgr);
        // Must be done after constructor to ensure field initialization.
    }
    
    /* (non-Javadoc)
     * Fills the menu with New Wizards.
     */
    private void fillMenu(IContributionManager innerMgr) {
        // Remove all.
        innerMgr.removeAll();

        IContributionItem[] items = getContributionItems();
        for (int i = 0; i < items.length; i++) {
            innerMgr.add(items[i]);
        }
    }

    /**
     * Removes all listeners from the containing workbench window.
     * <p>
     * This method should only be called if the shortcut menu is created with
     * <code>register = true</code>.
     * </p>
     * 
     * @deprecated has no effect
     */
    public void deregisterListeners() {
        // do nothing
    }

    /**
     * Return whether or not any examples are in the current install.
     * 
     * @return boolean
     */
	private boolean hasExamples() {
		boolean hasCategory = registryHasCategory(WizardsRegistryReader.FULL_EXAMPLES_WIZARD_CATEGORY);
		if (hasCategory) {
			IWizardCategory exampleCategory = WorkbenchPlugin
					.getDefault()
					.getNewWizardRegistry()
					.findCategory(
							WizardsRegistryReader.FULL_EXAMPLES_WIZARD_CATEGORY);
			return hasWizards(exampleCategory);
		}
		return false;
	}
	
	private boolean hasWizards(IWizardCategory category) {
		IWizardDescriptor[] wizards = category.getWizards();
		if (wizards.length>0) {
			for (int i = 0; i < wizards.length; i++) {
				if (!WorkbenchActivityHelper.filterItem(wizards[i])) {
					return true;
				}
			}
		}
		IWizardCategory[] categories = category.getCategories();
		for (int i = 0; i < categories.length; i++) {
			if (hasWizards(categories[i])) {
				return true;
			}
		}
		return false;
	}

    /* (non-Javadoc)
     * @see org.eclipse.ui.actions.BaseNewWizardMenu#addItems(org.eclipse.jface.action.IContributionManager)
     */
    protected void addItems(List list) {
    	ArrayList shortCuts= new ArrayList();
    	addShortcuts(shortCuts);
    	
    	for (Iterator iterator= shortCuts.iterator(); iterator.hasNext();) {
			Object curr= iterator.next();
			if (curr instanceof ActionContributionItem && isNewProjectWizardAction(((ActionContributionItem) curr).getAction())) {
				iterator.remove();
				list.add(curr);
			}
		}
		list.add(new ActionContributionItem(newProjectAction));
        list.add(new Separator());
        if (!shortCuts.isEmpty()) {
        	list.addAll(shortCuts);
        	list.add(new Separator());
        }
        if (hasExamples()) {
            list.add(new ActionContributionItem(newExampleAction));
            list.add(new Separator());
        }
        list.add(new ActionContributionItem(getShowDialogAction()));
    }

	private boolean isNewProjectWizardAction(IAction action) {
		if (action instanceof NewWizardShortcutAction) {
			IWizardDescriptor wizardDescriptor= ((NewWizardShortcutAction) action).getWizardDescriptor();
			String [] tags = wizardDescriptor.getTags();
			for (int i = 0; i < tags.length; i++) {
				if (WorkbenchWizardElement.TAG_PROJECT.equals(tags[i])) {
					return true;
				}
			}
		}
		return false;
	}
    
	/* (non-Javadoc)
	 * Method declared on IContributionItem.
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Sets the enabled state of the receiver.
	 * 
	 * @param enabledValue if <code>true</code> the menu is enabled; else
	 * 		it is disabled
	 */
	public void setEnabled(boolean enabledValue) {
		this.enabled = enabledValue;
	}
    
	/* (non-Javadoc)
	 * @see org.eclipse.ui.actions.BaseNewWizardMenu#getContributionItems()
	 */
	protected IContributionItem[] getContributionItems() {
		if (isEnabled()) {
			return super.getContributionItems();
		}
		return new IContributionItem[0];
	}
}
