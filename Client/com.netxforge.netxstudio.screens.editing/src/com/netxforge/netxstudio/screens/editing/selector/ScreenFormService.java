/*******************************************************************************
 * Copyright (c) May 9, 2011 NetXForge.
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
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.editing.selector;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.cdo.IFixtures;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.screens.editing.IEditingService;

/**
 * This service is capable to place a composite in a dedicated section (The
 * container), of a layout structure. The layout is a Selector pane, a Container
 * pane and a Toolbar pane.
 * 
 * </p>The container can be updated by placing selectors calling
 * <code>addScreenSelector(...)</code>. When the active screen in the container
 * is replaced by another screen, the previous screen is remembered and can be
 * retrieved by calling: <code>restorePreviousScreen()</code>
 * 
 * The screen (Which should be a form composite) should have a constructor with
 * arguments for <code>IEditingService</code> and
 * <code>IScreenFormService</code>. </p>The service also automatically shows a
 * toolbar with Hyperlinks to navigate and invoke actions, between the screens,
 * depending on the implemented interfaces: <uL <li>{@link IScreen}, for New,
 * Edit and Table type screens</li> <li>{@link IDataServiceInjection}, for
 * screens which get their data injected from {@link IDataService}</li> <li>
 * {@link IDataScreenInjection}, for screens which get their data injected from
 * another screen, will show the <b>Save</b> action</li> </ul>
 * 
 * First time users of the service should call <code>initialize()</code> to set
 * the parent composite. Also it's a good idea to call
 * <code>setEditingService</code>.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
@Singleton
public class ScreenFormService implements IScreenFormService {

	private SashForm sashForm;
	private Form selectorForm;

	private ScreenBody screenBody;

	private Composite activeScreen = null;
//	private Composite previousScreen = null;
	
	private Stack<Composite> screenStack = new Stack<Composite>(); 
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#getActiveScreen
	 * ()
	 */
	public Composite getActiveScreen() {
		return activeScreen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.IScreenFormService#hasActiveScreen
	 * ()
	 */
	public boolean hasActiveScreen() {
		return activeScreen != null;
	}

//	public boolean hasPreviousScreen() {
//		return previousScreen != null;
//	}
	
	private void pushScreen(Composite screen){
		
		if (activeScreen != null) {
			activeScreen.setVisible(false);
			screenStack.push(activeScreen);
		}
		
		// We need a copy of the composite, so it can work.
		activeScreen = screen;
		formToolkit.adapt(activeScreen);
		formToolkit.paintBordersFor(activeScreen);
		screenBody.getScreenDeck().topControl = activeScreen;
		getScreenContainer().layout(true);

		this.updateScreenBarActions(activeScreen);

		screenBody.setScreenBarOn();

		// All our screens must implement IScreen.
		fireScreenChanged((IScreen) activeScreen);

	}
	
	
	private void popScreen(){
		
		if(!screenStack.empty()){
			if (activeScreen != null) {
				activeScreen.dispose();
				activeScreen = null;
			}
			activeScreen = screenStack.pop();
			activeScreen.setVisible(true);
			screenBody.getScreenDeck().topControl = activeScreen;
			getScreenContainer().layout(true);
			updateScreenBarActions(activeScreen);

			// We need to refresh the viewer in case objects have been
			// invalidated and need to be updated.
			Viewer v = ((IScreen) activeScreen).getViewer();
			if (v != null) {
				v.refresh();
			}

			fireScreenChanged((IScreen) activeScreen);

		}else{
			// Nothing to pop.
			screenBody.setScreenBarOff();
		}
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#isActiveScreen
	 * (java.lang.Class)
	 */
	public boolean isActiveScreen(Class<?> proposedScreen) {
		return hasActiveScreen()
				&& activeScreen.getClass().equals(proposedScreen);
	}

//	public boolean isPreviousScreen(Class<?> proposedScreen) {
//		return hasPreviousScreen()
//				&& previousScreen.getClass().equals(proposedScreen);
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#initalize(
	 * org.eclipse.swt.widgets.Composite)
	 */
	public void initalize(Composite parent) {

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			sashForm = new SashForm(container, SWT.SMOOTH);
			sashForm.setSashWidth(1);
			{
				Composite composite = formToolkit.createComposite(sashForm,
						SWT.BORDER);
				formToolkit.paintBordersFor(composite);
				composite.setLayout(new FillLayout(SWT.HORIZONTAL));
				{
					selectorForm = formToolkit.createForm(composite);
					selectorForm.setSeparatorVisible(true);
					formToolkit.paintBordersFor(selectorForm);
					selectorForm.setText("M");
					selectorForm.getBody().setLayout(new FormLayout());
				}
			}
			{
				screenBody = new ScreenBody(sashForm, SWT.NONE);

				// Install all the links on the screen bar.
				this.createBackLink(screenBody.getScreenBar());
				this.createSaveLink(screenBody.getScreenBar());
				screenBody.setScreenBarOff();
			}
			sashForm.setWeights(new int[] { 100, 491 });
		}
	}

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());

	public Composite addScreenSelector(String name, String iconPath,
			Class<?> screen, int position, int operation) {
		return addScreenSelector(null, name, iconPath, screen, position,
				operation);
	}

	public Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen, int operation) {
		return addScreenSelector(above, name, iconPath, screen, -1, operation);
	}

	public Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen, int position, int operation) {

		assert position >= 1 || above != null;

		try {

			// We look for a constructor supporting the selector service.
			// Screens, will be able to use the selector to place themselves on
			// the
			// service container, calling updateComposite();
			Constructor<?> screenConstructor = null;
			try {
				screenConstructor = screen.getConstructor(Composite.class,
						int.class);
			} catch (NoSuchMethodException e2) {
				System.out
						.println("TODO, Implement correct screen signature on :"
								+ screen.getClass().getSimpleName());
			}

			// We need some finals, to invoke in the listener.
			final Constructor<?> finalScreenConstructor = screenConstructor;
			final Class<?> finalScreen = screen;

			// We operride the operation, depending on the user role.
			Role r = editingService.getDataService().getQueryService()
					.getCurrentRole();
			if (r.getName().equals(IFixtures.ROLE_READONLY)) {
				operation = Screens.OPERATION_READ_ONLY;
			}

			final int finalOperation = operation;
			ImageHyperlink lnk = formToolkit.createImageHyperlink(
					getSelectorForm().getBody(), SWT.NONE);
			lnk.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					
					
					if (isActiveScreen(finalScreen)) {
						return; // Ignore we are there already.
					}
					// We might be cached, if a child is currently active, 
					// but it's better to dispose the complete list and restart. 
					
					while(!screenStack.empty()){
						Composite screen = screenStack.pop();
						screen.dispose();
					}
					
//					if (isPreviousScreen(finalScreen)) {
//						restorePreviousScreen(); // We are still cached restore.
//						return;
//					}
					
					// We are a new screen, instantiate and set active.
					try {
						
						Composite target = (Composite) finalScreenConstructor
								.newInstance(getScreenContainer(), SWT.NONE
										| finalOperation);
						
						setActiveScreen(target);
					} catch (IllegalArgumentException e1) {
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						e1.printStackTrace();
					}
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});

			lnk.setImage(ResourceManager.getPluginImage(ICON_PATH, iconPath));
			FormData lnkFD = new FormData();

			if (position >= 1) {
				lnkFD.top = new FormAttachment(0, position * 12);
			}
			if (above != null) {
				lnkFD.top = new FormAttachment(above, 6);
			}

			lnkFD.left = new FormAttachment(0, 12);
			lnk.setLayoutData(lnkFD);
			formToolkit.paintBordersFor(lnk);
			lnk.setText(name);
			return lnk;

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#updateComposite
	 * (org.eclipse.swt.widgets.Composite)
	 */
	public void setActiveScreen(Composite control) {
		this.pushScreen(control);
//		if (activeScreen != null) {
//			
//			if (previousScreen != null) {
//				previousScreen.dispose();
//			}
//			previousScreen = activeScreen;
//			previousScreen.setVisible(false);
//			
//			pushChildScreen(activeScreen);
//			
//		}

//		activeScreen = control;
//		formToolkit.adapt(activeScreen);
//		formToolkit.paintBordersFor(activeScreen);
//		screenBody.getScreenDeck().topControl = activeScreen;
//		getScreenContainer().layout(true);
//
//		this.updateScreenBarActions(activeScreen);
//
//		screenBody.setScreenBarOn();
//
//		// All our screens must implement IScreen.
//		fireScreenChanged((IScreen) activeScreen);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#getSelectorForm
	 * ()
	 */
	public Form getSelectorForm() {
		return selectorForm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#getScreenContainer
	 * ()
	 */
	public Composite getScreenContainer() {
		return this.screenBody.getScreenContainer();
	}

	/**
	 * Restores the previously shown screened, if any, this is for  multi(two)-step
	 * UI data entry.  
	 */
	private void restorePreviousScreen() {
		
		this.popScreen();
		
//		if (activeScreen != null) {
//			activeScreen.dispose();
//			activeScreen = null;
//		}
//		if (previousScreen != null) {
//			activeScreen = previousScreen;
//			previousScreen = null;
//			activeScreen.setVisible(true);
//			
//			screenBody.getScreenDeck().topControl = activeScreen;
//			getScreenContainer().layout(true);
//			updateScreenBarActions(activeScreen);
//
//			// We need to refresh the viewer in case objects have been
//			// invalidated and need to be updated.
//			Viewer v = ((IScreen) activeScreen).getViewer();
//			if (v != null) {
//				v.refresh();
//			}
//
//			fireScreenChanged((IScreen) activeScreen);
//		} else {
//			screenBody.setScreenBarOff();
//		}
	}

	/**
	 * Activation of actions, is depending on various flags maintained by
	 * interfaces implemented by the Screen.
	 * <ul>
	 * <li>IDataScreenInjection</li>
	 * <li>IDataServiceInjection</li>
	 * <li>IScreen</li>
	 * </ul>
	 * 
	 * @param activeScreen
	 */
	private void updateScreenBarActions(Composite activeScreen) {

		// Show the back link when then screen is triggered by another screen,
		// and should
		// have a return option.
		if (activeScreen instanceof IDataScreenInjection) {
			bckLnk.setVisible(true);
			IScreen screen = (IScreen) activeScreen;
			if (!Screens.isReadOnlyOperation(screen.getOperation())) {
				saveLnk.setVisible(true);
			}
		}
		if (activeScreen instanceof IDataServiceInjection) {
			bckLnk.setVisible(false);
			saveLnk.setVisible(false);
		}
	}

	// The screen bar links are exposed, to turn them on and off.
	private Hyperlink bckLnk;
	private Hyperlink saveLnk;

	private void createBackLink(Composite parent) {
		bckLnk = formToolkit.createHyperlink(parent, "Back", SWT.NONE);
		formToolkit.adapt(bckLnk);
		bckLnk.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				restorePreviousScreen();
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
	}

	private void createSaveLink(Composite parent) {
		saveLnk = formToolkit.createHyperlink(parent, "Save", SWT.NONE);
		formToolkit.adapt(saveLnk);
		saveLnk.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// Get the injected object and pass add it to the injector.
				if (getActiveScreen() instanceof IDataScreenInjection) {
					if (((IScreen) getActiveScreen()).isValid()) {
						((IDataScreenInjection) getActiveScreen()).addData();
						restorePreviousScreen();
					} else {

					}
				} else {
					// Should not occure as the save lnk is not show, for
					// these types of screens.
					throw new java.lang.IllegalStateException(
							"Save link should not be presented");
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
	}

	@Inject
	IEditingService editingService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.selector.IScreenFormService#
	 * getSelectionViewer()
	 */
	public Viewer getSelectionViewer() {
		if (getActiveScreen() instanceof IScreen) {
			if (((IScreen) getActiveScreen()).getOperation() == Screens.OPERATION_READ_ONLY) {
				// This one has a Viewer, get the
			}
		}

		return null;
	}

	// Notification of screen changing.

	List<ScreenChangeListener> screenChangedListeners = new ArrayList<ScreenChangeListener>();

	public void addScreenChangeListener(
			ScreenChangeListener screenChangedListener) {
		if (!screenChangedListeners.contains(screenChangedListener)) {
			screenChangedListeners.add(screenChangedListener);
		}
	}

	public void removeScreenChangeListener(
			ScreenChangeListener screenChangedListener) {
		if (screenChangedListeners.contains(screenChangedListener)) {
			screenChangedListeners.remove(screenChangedListener);
		}
	}

	private void fireScreenChanged(IScreen screen) {
		for (ScreenChangeListener l : screenChangedListeners) {
			l.screenChanged(screen);
		}
	}

	/**
	 * Delegate to the screen body composite.
	 */
	public Composite getScreenActionBar() {
		return this.screenBody.getScreenBar();
	}

}
