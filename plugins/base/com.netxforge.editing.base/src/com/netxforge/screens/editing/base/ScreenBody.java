/*******************************************************************************
 * Copyright (c) May 11, 2011 NetXForge.
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
package com.netxforge.screens.editing.base;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class ScreenBody extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	/**
	 * The container which fills the ViewPart. Clients should respect the
	 * installed layout.
	 * 
	 * @return
	 */
	private Composite screenContainer;

	/**
	 * The screen bar is a bar shown below the active screen. It can be toggled
	 * on / off. It shows a "Back" link to return to the previous screen.
	 */
	private Composite screenBar;

	/**
	 * The deck of screens which can be stacked in the body.
	 */
	private StackLayout screenDeck;

	private FormData fd_screenContainer;

	/**
	 * Place holder for the path walked by the user.
	 * 
	 */
	private Composite screenPath;

	private FormData fd_screenPath;

	private Composite clientScreenPath;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ScreenBody(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FormLayout());

		screenPath = toolkit.createComposite(this, SWT.BORDER);
		screenPath.setLayout(new FillLayout());
		fd_screenPath = new FormData();
		fd_screenPath.top = new FormAttachment(0);
		fd_screenPath.right = new FormAttachment(100);
		fd_screenPath.left = new FormAttachment(0);
		
		screenPath.setLayoutData(fd_screenPath);
		toolkit.paintBordersFor(screenPath);
		
		clearScreenPath();
		
		
//		hprlnkHome = toolkit.createHyperlink(screenPath, "Home", SWT.NONE);
//		toolkit.paintBordersFor(hprlnkHome);

		screenContainer = toolkit.createComposite(this, SWT.NONE);

		screenDeck = new StackLayout();
		screenContainer.setLayout(screenDeck);
		fd_screenContainer = new FormData();
		fd_screenContainer.bottom = new FormAttachment(100, -25);
		fd_screenContainer.right = new FormAttachment(100);
		fd_screenContainer.top = new FormAttachment(0, 25);
		fd_screenContainer.left = new FormAttachment(0);
		screenContainer.setLayoutData(fd_screenContainer);
		toolkit.paintBordersFor(screenContainer);

		fd_screenPath.bottom = new FormAttachment(screenContainer);
		
		
		screenBar = toolkit.createComposite(this, SWT.BORDER);
		screenBar.setLayout(new RowLayout(SWT.HORIZONTAL));
		FormData fd_screenBar = new FormData();
		fd_screenBar.top = new FormAttachment(screenContainer);
		fd_screenBar.bottom = new FormAttachment(100);
		fd_screenBar.left = new FormAttachment(0);
		fd_screenBar.right = new FormAttachment(100);
		screenBar.setLayoutData(fd_screenBar);
		toolkit.paintBordersFor(screenBar);
	}

	public Composite getScreenContainer() {
		return screenContainer;
	}

	public Composite getScreenBar() {
		return screenBar;
	}

	public void setScreenBarOn() {
		if (!screenBar.getVisible()) {
			screenBar.setVisible(true);
			// Enlarge the screenContainer.
			fd_screenContainer.bottom.offset = -25;
			this.layout(true);
		}
	}

	public void setScreenBarOff() {
		if (screenBar.getVisible()) {
			screenBar.setVisible(false);
			fd_screenContainer.bottom.offset = 0;
			this.layout(true);
		}
	}

	public void setScreenPathOn() {
		if (!screenPath.getVisible()) {
			screenPath.setVisible(true);
			// Enlarge the screenContainer.
			fd_screenContainer.top.offset = 25;
			this.layout(true);
		}
	}

	public void setScreenPathOff() {
		if (screenPath.getVisible()) {
			screenPath.setVisible(false);
			// Enlarge the screenContainer.
			fd_screenContainer.top.offset = 0;
			this.layout(true);
		}
	}

	public boolean isScreenPathOn() {
		return screenPath.getVisible();
	}

	public void clearScreenPath() {
		if(clientScreenPath  != null){
			clientScreenPath.dispose();
		}
		clientScreenPath = toolkit.createComposite(screenPath);
		clientScreenPath.setLayout(new RowLayout(SWT.HORIZONTAL));	
		screenPath.layout(true);
	}

	
	public Composite getScreenPath() {
		return clientScreenPath;
	}

	public StackLayout getScreenDeck() {
		return screenDeck;
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}
