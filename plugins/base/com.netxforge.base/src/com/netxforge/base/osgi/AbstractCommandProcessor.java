/*******************************************************************************
 * Copyright (c) 8 okt. 2014 NetXForge.
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
package com.netxforge.base.osgi;

import java.lang.reflect.Method;

import org.eclipse.osgi.framework.console.CommandInterpreter;

/**
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class AbstractCommandProcessor {

	public void processCommands(CommandInterpreter intp) {
		boolean goon = true;

		@SuppressWarnings("unused")
		int argCount = 0;

		while (goon) {
			String nextArgument = intp.nextArgument();
			if (nextArgument != null) {
				argCount++;
				if (nextArgument.startsWith("-")) {
					char charAt = nextArgument.charAt(1);
					// We expect the option text here.
					nextArgument = intp.nextArgument();
					argCount++;

					try {
						Method method = this.getClass().getMethod(
								"_option_" + charAt, String.class);
						method.setAccessible(true);
						method.invoke(this, nextArgument);
					} catch (Exception e) {
						continue;
					}
				} else {
					try {
						Method method = this.getClass().getMethod(
								"_argument_" + nextArgument, String.class);
						method.setAccessible(true);
						method.invoke(this, nextArgument);
					} catch (Exception e) {
						_argument_default(nextArgument);
						continue;
					}
				}

			} else {
				goon = false;
				break;
			}
		}
	}

	protected void _argument_default(String defaultArgument){
		// Do Nothing 
	}

}
