package com.netxforge.interpreter;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Value;

/**
 * FIXME, Move to more appropriate utility plugin.
 * 
 * @author dzonekl
 * 
 */
public class PrettyLog implements IPrettyLog {

	Logger log = Logger.getLogger(PrettyLog.class);

	PrettyLog() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.interpreter.IPrettyLog#log(java.lang.Object)
	 */
	public void log(String header, Object... o) {
		for (int i = 0; i < o.length; i++) {
			if (o[i] instanceof EList<?>) {
				log.warn(getText((EList<?>) o[i]));
			} else {
				log.warn(o[i]);
			}
		}
	};

	String getText(EList<?> range) {
		StringBuilder builder = new StringBuilder();
		builder.append('{');
		for (Object o : (EList<?>) range) {
			if (o instanceof Value) {
				builder.append(((Value) o).getValue());
			}
			if (o instanceof BigDecimal) {
				builder.append(o);
			}
			builder.append(',');
		}
		builder.append('}');
		return builder.toString();
	}
}
