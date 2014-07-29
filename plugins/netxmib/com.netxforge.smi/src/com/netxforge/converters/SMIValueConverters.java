/*******************************************************************************
 * Copyright (c) 17 apr. 2014 NetXForge.
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
package com.netxforge.converters;

import java.math.BigInteger;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Inject;

public class SMIValueConverters extends DefaultTerminalConverters {

	@Inject
	private BigIntegerValueConverter bigIntegerValueConverter;

	@Inject
	private ParameterValueConverter paramValueConverter;

	@ValueConverter(rule = "BIG_INTEGER")
	public IValueConverter<BigInteger> BIG_INTEGER() {
		return bigIntegerValueConverter;
	}

	@ValueConverter(rule = "PARAMETER")
	public IValueConverter<String> PARAMETER() {
		return paramValueConverter;
	}

	private static class BigIntegerValueConverter extends
			AbstractLexerBasedConverter<BigInteger> {

		public BigInteger toValue(String string, INode node)
				throws ValueConverterException {
			try {
				return new BigInteger(string);
			} catch (NumberFormatException e) {
				throw new ValueConverterException("Is not a Big Integer", node,
						e);
			}
		}

	}

	private static class ParameterValueConverter extends
			AbstractLexerBasedConverter<String> {

		public String toValue(String string, INode node)
				throws ValueConverterException {
			if (string.length() >= 2 && string.startsWith("\"")
					&& string.endsWith("\"")) {
				return string.substring(1, string.length() - 1);
			}
			// else{
			// throw new ValueConverterException("Not a quoted parameter",
			// node, null);
			// }
			return string;
		}

	}
}
