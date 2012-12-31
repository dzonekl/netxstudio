/*******************************************************************************
 * Copyright (c) 10 dec. 2012 NetXForge.
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
package com.netxforge.interpreter;

import static com.netxforge.interpreter.InterpreterTypeless.asCollection;
import static com.netxforge.interpreter.InterpreterTypeless.asNum;
import static com.netxforge.interpreter.InterpreterTypeless.assertCollection;
import static com.netxforge.interpreter.InterpreterTypeless.assertMatrix;
import static com.netxforge.interpreter.InterpreterTypeless.assertNumeric;
import static com.netxforge.interpreter.InterpreterTypeless.assertNumericCollection;
import static com.netxforge.interpreter.InterpreterTypeless.assertValue;
import static com.netxforge.interpreter.InterpreterTypeless.assertValueCollection;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.netxforge.internal.RuntimeActivator;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.Value;

/**
 * Prints evaluation to the tracing facility.
 * 
 * @author Christophe Bouhier
 * 
 */
public class PrettyLog implements IPrettyLog {

	Logger log = Logger.getLogger(PrettyLog.class);

	@Inject
	private ModelUtils modelUtils;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.interpreter.IPrettyLog#log(java.lang.Object)
	 */
	public void log(String header, Object... o) {
		RuntimeActivator.TRACE.trace(
				RuntimeActivator.TRACE_NETXSCRIPT_EXPRESSION_OPTION, "Evaluate: " + header );
		
		for (int i = 0; i < o.length; i++) {
			// log.warn("Eval " + header + " value=" + printEval(o[i]));
			RuntimeActivator.TRACE.trace(
					RuntimeActivator.TRACE_NETXSCRIPT_EXPRESSION_OPTION, " return=" + printEval(o[i]));
		}
	};

	/*
	 * Note: use static imports here.
	 */
	public String printEval(Object eval) {
		if (assertNumeric(eval)) {
			return asNum((BigDecimal) eval).toString();
		} else if (assertValue(eval)) {
			return ((Value) eval).toString();
		} else if (assertCollection(eval)) {
			List<?> evalCollection = asCollection((List<?>) eval);
			if (evalCollection.isEmpty()) {
				return buildCollectionString(evalCollection);
			} else if (assertMatrix(evalCollection)) {
				return "matrix, do not print";
			} else if (assertValueCollection(eval)) {
				return buildCollectionString(evalCollection);
			} else if (assertNumericCollection(eval)) {
				return buildCollectionString(evalCollection);
			}
		}
		return "evaluation type not recognized";

	}

	String buildCollectionString(List<?> collection) {
		StringBuilder builder = new StringBuilder();
		builder.append(" size= " + collection.size() + " {");
		for (Object o : (List<?>) collection) {
			if (o instanceof Value) {
				Value value = (Value) o;
				builder.append("(" + value.getValue() + ","
						+ modelUtils.dateAndTime(value.getTimeStamp()) + ")");
			} else if (o instanceof BigDecimal) {
				builder.append(asNum((BigDecimal) o).toString());
			}
			builder.append(',');
		}
		builder.append('}');
		return builder.toString();
	}
}
