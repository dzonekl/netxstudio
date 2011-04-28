package com.netxforge.netxstudio.console;

import java.io.PrintStream;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

/**
 * Gets the platform console plugin, adds a custom console
 * which handles std.err and std.out.  
 * 
 * @author dzonekl
 *
 */
public class ConsoleService {
	
		public static ConsoleService INSTANCE = new ConsoleService();
		
		public ConsoleService(){
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