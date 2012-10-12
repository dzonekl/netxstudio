package com.netxforge.interpreter;

import static com.netxforge.interpreter.InterpreterTypeless.asCollection;
import static com.netxforge.interpreter.InterpreterTypeless.asNum;
import static com.netxforge.interpreter.InterpreterTypeless.assertCollection;
import static com.netxforge.interpreter.InterpreterTypeless.assertNumeric;
import static com.netxforge.interpreter.InterpreterTypeless.assertNumericCollection;
import static com.netxforge.interpreter.InterpreterTypeless.assertValue;
import static com.netxforge.interpreter.InterpreterTypeless.assertValueCollection;
import static com.netxforge.interpreter.InterpreterTypeless.assertMatrix;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.Value;

/**
 * FIXME, Move to more appropriate utility plugin.
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
		for (int i = 0; i < o.length; i++) {
			// log.warn("Eval " + header + " value=" + printEval(o[i]));
			System.out.println("Eval " + header + " value=" + printEval(o[i]));
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
			if (assertMatrix(evalCollection)) {
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
