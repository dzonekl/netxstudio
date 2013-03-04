/*******************************************************************************
 * Copyright (c) 4 mrt. 2013 NetXForge.
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
package com.netxforge.netxstudio.console;

import java.io.PrintStream;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

/**
 * Gets the platform console plugin, adds a custom console which handles std.err
 * and std.out.
 * 
 * @author Christophe Bouhier
 * 
 */
public class ConsoleService {

	public static ConsoleService INSTANCE = new ConsoleService();

	public ConsoleService() {
	}

	public MessageConsole addConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conManager = plugin.getConsoleManager();
		IConsole[] existing = conManager.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if (name.equals(existing[i].getName())) {
				return (MessageConsole) existing[i];
			}
		}
		MessageConsole console = new MessageConsole(name, null);
		MessageConsoleStream stream = console.newMessageStream();
		System.setOut(new PrintStream(stream));
		System.setErr(new PrintStream(stream));
		System.out.println(Messages.ConsoleService_0);
		conManager.addConsoles(new IConsole[] { console });
		return console;

	}
}