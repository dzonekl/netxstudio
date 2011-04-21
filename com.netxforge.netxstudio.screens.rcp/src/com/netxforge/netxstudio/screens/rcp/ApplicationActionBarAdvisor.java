package com.netxforge.netxstudio.screens.rcp;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.ActionFactory;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IAction quitAction;

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	{
    		quitAction = ActionFactory.QUIT.create(window);
    		register(quitAction);
    	}
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	
    	MenuManager menuManager = new MenuManager("File");
    	menuBar.add(menuManager);
    	menuManager.add(quitAction);
    }
    
}
