/*******************************************************************************
 * Copyright (c) 19 nov. 2012 NetXForge.
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
 *******************************************************************************/
package com.netxforge.netxstudio.screens.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

/*
 * A clock wrapped in a contribution item. Can be placed on status line or
 * coolbar.
 */
public class Clock extends WorkbenchWindowControlContribution {

	// private final ApplicationActionBarAdvisor applicationActionBarAdvisor;

	private static CLabel label;
	private static ScheduledExecutorService exec = Executors
			.newSingleThreadScheduledExecutor();
	static final SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
	static {
		exec.scheduleAtFixedRate(new Runnable() {
			public void run() {

				// abc.getWindowConfigurer().getWindow().getShell()
				// .getDisplay()
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						String format = df.format(new Date(System
								.currentTimeMillis()));
						if (label != null && !label.isDisposed()) {
							label.setText(format);
							label.pack();
						}
					}
				});
			}
		}, 5, 1, TimeUnit.SECONDS);

	}

	public Clock() {

	}

	public Clock(String ID) {
		super(ID);

		// this.applicationActionBarAdvisor = applicationActionBarAdvisor;
		// final IActionBarConfigurer abc =
		// this.applicationActionBarAdvisor.getActionBarConfigurer();
	}

	// private String generateString(Random rng, String characters, int length)
	// {
	// char[] text = new char[length];
	// for (int i = 0; i < length; i++) {
	// text[i] = characters.charAt(rng.nextInt(characters.length()));
	// }
	// return new String(text);
	// }

	// public void fill(Composite parent) {
	// final IActionBarConfigurer abc = getActionBarConfigurer();
	// Color systemColor = abc.getWindowConfigurer().getWindow()
	// .getShell().getDisplay().getSystemColor(SWT.COLOR_WHITE);
	// label = new CLabel(parent, SWT.SHADOW_ETCHED_OUT | SWT.BORDER |
	// SWT.CENTER);
	// label.setText("               ");
	// label.setBackground(systemColor);
	// }

	@Override
	protected Control createControl(Composite parent) {
		// final IActionBarConfigurer abc =
		// this.applicationActionBarAdvisor.getActionBarConfigurer();
		// Color whiteColor = abc.getWindowConfigurer().getWindow()
		// .getShell().getDisplay().getSystemColor(SWT.COLOR_WHITE);

		final Color whiteColor = Display.getCurrent().getSystemColor(
				SWT.COLOR_WHITE);
		
		label = new CLabel(parent, SWT.SHADOW_ETCHED_OUT | SWT.BORDER
				| SWT.CENTER);
		label.setText("               ");
		label.setBackground(whiteColor);
		return label;
	}

	@Override
	protected int computeWidth(Control control) {
		return 300;
	}

}