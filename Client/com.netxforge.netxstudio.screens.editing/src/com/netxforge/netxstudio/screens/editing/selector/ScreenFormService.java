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

import com.netxforge.netxstudio.data.IDataScreenInjection;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.IDataServiceInjection;
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
 * depending on the implemented interfaces: <uL <li>{@link IScreen},
 * for New, Edit and Table type screens</li> <li>{@link IDataServiceInjection},
 * for screens which get their data injected from {@link IDataService}</li> <li>
 * {@link IDataScreenInjection}, for screens which get their data injected from
 * another screen, will show the <b>Apply</b> action</li> </ul>
 * 
 * First time users of the service should call <code>initialize()</code> to set
 * the parent composite. Also it's a good idea to call
 * <code>setEditingService</code>.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class ScreenFormService implements IScreenFormService {

	private SashForm sashForm;
	private Form selectorForm;

	private ScreenBody screenBody;

	private Composite activeScreen = null;
	private Composite previousScreen = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#getActiveScreen
	 * ()
	 */
	@Override
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
	@Override
	public boolean hasActiveScreen() {
		return activeScreen != null;
	}

	@Override
	public boolean hasPreviousScreen() {
		return previousScreen != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#isActiveScreen
	 * (java.lang.Class)
	 */
	@Override
	public boolean isActiveScreen(Class<?> proposedScreen) {
		return hasActiveScreen()
				&& activeScreen.getClass().equals(proposedScreen);
	}

	@Override
	public boolean isPreviousScreen(Class<?> proposedScreen) {
		return hasPreviousScreen()
				&& previousScreen.getClass().equals(proposedScreen);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#initalize(
	 * org.eclipse.swt.widgets.Composite)
	 */
	@Override
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

	@Override
	public Composite addScreenSelector(String name, String iconPath,
			Class<?> screen, int position, int operation) {
		return addScreenSelector(null, name, iconPath, screen, position,
				operation);
	}

	@Override
	public Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen, int operation) {
		return addScreenSelector(above, name, iconPath, screen, -1, operation);
	}

	@Override
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
						int.class, IScreenFormService.class,
						IEditingService.class);
			} catch (NoSuchMethodException e2) {
				System.out
						.println("TODO, Implement correct screen signature on :"
								+ screen.getClass().getName());
				System.out.println("TODO, should implement:"
						+ IScreenFormService.class.getName() + ","
						+ IEditingService.class.getName());
				try {
					screenConstructor = screen.getConstructor(Composite.class,
							int.class);
				} catch (NoSuchMethodException e3) {
					e3.printStackTrace();
				}
			}

			// We need some finals, to invoke in the listener.
			final Constructor<?> finalScreenConstructor = screenConstructor;
			final Class<?> finalScreen = screen;
			final int finalOperation = operation;
			ImageHyperlink lnk = formToolkit.createImageHyperlink(
					getSelectorForm().getBody(), SWT.NONE);
			lnk.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					
					if (isActiveScreen(finalScreen)) {
						return; // Ignore we are there already. 
					}
					if (isPreviousScreen(finalScreen)) {
						restorePreviousScreen(); // We are still cached restore. 
						return;
					}
					// We are a new screen, instantiate and set active. 
					try {
						Composite target;
						if (finalScreenConstructor.getParameterTypes().length == 4) {
							target = (Composite) finalScreenConstructor
									.newInstance(getScreenContainer(), SWT.NONE
											| finalOperation,
											ScreenFormService.this,
											editingService);
						} else {
							// Services not set.
							target = (Composite) finalScreenConstructor
									.newInstance(getScreenContainer(), SWT.NONE
											| finalOperation);
						}
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
	@Override
	public void setActiveScreen(Composite control) {

		if (activeScreen != null) {
			// We only remember the last screen.
			if (previousScreen != null) {
				previousScreen.dispose();
			}
			previousScreen = activeScreen;
			previousScreen.setVisible(false);
		}

		activeScreen = control;
		formToolkit.adapt(activeScreen);
		formToolkit.paintBordersFor(activeScreen);
		screenBody.getScreenDeck().topControl = activeScreen;
		getScreenContainer().layout(true);

		this.updateScreenBarActions(activeScreen);

		screenBody.setScreenBarOn();
		
		// All our screens must implement IScreen. 
		fireScreenChanged((IScreen) activeScreen);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#getSelectorForm
	 * ()
	 */
	@Override
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
	@Override
	public Composite getScreenContainer() {
		return this.screenBody.getScreenContainer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.selector.ISelectorService#
	 * restorePreviousScreen()
	 */
	@Override
	public void restorePreviousScreen() {
		if (activeScreen != null) {
			activeScreen.dispose();
			activeScreen = null;
		}
		if (previousScreen != null) {
			activeScreen = previousScreen;
			previousScreen = null;
			activeScreen.setVisible(true);
			// We might need to do something on the previous Screen.
			screenBody.getScreenDeck().topControl = activeScreen;
			getScreenContainer().layout(true);
			updateScreenBarActions(activeScreen);
			fireScreenChanged((IScreen) activeScreen);
		} else {
			screenBody.setScreenBarOff();
		}
	}

	public void updateScreenBarActions(Composite activeScreen) {

		// Show the back link when then screen is triggered by another screen,
		// and should
		// have a return option.
		if (activeScreen instanceof IDataScreenInjection) {
			bckLnk.setVisible(true);
		}
		if (activeScreen instanceof IDataServiceInjection) {
			bckLnk.setVisible(false);
		}

		// Show the apply link depending on, if the screen is supposed to
		// provide a new object.
		if (activeScreen instanceof IScreen) {
			if (!Screens.isNewOperation(((IScreen) activeScreen)
					.getOperation())) {
				applyLnk.setVisible(false);
			} else {
				applyLnk.setVisible(true);
			}
		} else {
			applyLnk.setVisible(false);
		}
	}

	// The screen bar links are exposed, to turn them on and off.
	private Hyperlink bckLnk;

	private Hyperlink applyLnk;

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
		applyLnk = formToolkit.createHyperlink(parent, "Apply", SWT.NONE);
		formToolkit.adapt(applyLnk);
		applyLnk.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// Get the injected object and pass add it to the injector.
				if (getActiveScreen() instanceof IDataScreenInjection) {
					((IDataScreenInjection) getActiveScreen()).addData();
					restorePreviousScreen();
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
	}

	IEditingService editingService;

	public void setEditingService(IEditingService eServ) {
		editingService = eServ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.selector.IScreenFormService#
	 * getSelectionViewer()
	 */
	@Override
	public Viewer getSelectionViewer() {
		// TODO Auto-generated method stub
		if (getActiveScreen() instanceof IScreen) {
			if (((IScreen) getActiveScreen()).getOperation() == Screens.OPERATION_VIEWER) {
				// This one has a Viewer, get the
			}
		}

		return null;
	}
	
	
	// Notification of screen changing. 
	
	List<ScreenChangeListener> screenChangedListeners = new ArrayList<ScreenChangeListener>();
	
	public void addScreenChangeListener(ScreenChangeListener screenChangedListener){
		if(!screenChangedListeners.contains(screenChangedListener)){
			screenChangedListeners.add(screenChangedListener);
		}
	}
	
	public void removeScreenChangeListener(ScreenChangeListener screenChangedListener){
		if(screenChangedListeners.contains(screenChangedListener)){
			screenChangedListeners.remove(screenChangedListener);
		}
	}
	
	private void fireScreenChanged(IScreen screen){
		for (ScreenChangeListener l : screenChangedListeners) {
			l.screenChanged(screen);
		}
	}

}
