package com.netxforge.interpreter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.base.Predicate;

public class PrintingPolymorphicDispatcher<RT> extends
		PolymorphicDispatcher<RT> {

	private IPrettyLog pLog;

	public PrintingPolymorphicDispatcher(final String methodName,
			final List<? extends Object> targets) {
		super(methodName, 1, 1, targets);
	}

	public PrintingPolymorphicDispatcher(final String methodName,
			final int minParams, final int maxParams,
			final List<? extends Object> targets) {
		super(methodName, minParams, maxParams, targets,
				new DefaultErrorHandler<RT>());
	}

	public PrintingPolymorphicDispatcher(final String methodName,
			final int minParams, final int maxParams,
			final List<? extends Object> targets, ErrorHandler<RT> handler) {
		super(targets, new MethodNameFilter(methodName, minParams, maxParams),
				handler);
	}

	public PrintingPolymorphicDispatcher(final List<? extends Object> targets,
			Predicate<Method> methodFilter) {
		super(targets, methodFilter, new DefaultErrorHandler<RT>());
	}

	public static <T> PrintingPolymorphicDispatcher<T> createForSingleTarget(
			final String methodName, final Object singleTarget) {
		return new PrintingPolymorphicDispatcher<T>(methodName,
				Collections.singletonList(singleTarget));
	}

	public static <T> PrintingPolymorphicDispatcher<T> createForSingleTarget(
			final String methodName, int min, int max, final Object singleTarget) {
		return new PrintingPolymorphicDispatcher<T>(methodName, min, max,
				Collections.singletonList(singleTarget));
	}

	public static <T> PrintingPolymorphicDispatcher<T> createForSingleTarget(
			Predicate<Method> methodFilter, Object singleTarget) {
		return new PrintingPolymorphicDispatcher<T>(
				Collections.singletonList(singleTarget), methodFilter);
	}

	public static <T> PrintingPolymorphicDispatcher<T> createForVarTarget(
			final String methodName, final Object... targets) {
		return new PrintingPolymorphicDispatcher<T>(methodName,
				Arrays.asList(targets));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.util.PolymorphicDispatcher#invoke(java.lang.Object[])
	 */
	@Override
	public RT invoke(Object... params) {
		RT eval = super.invoke(params);
		String header = "unknown method call";
		// params [0] is the class
		if (params.length == 2) {

			if (params[0] instanceof EObject) {
				EObject rule = (EObject) params[0];
				// TODO Arguments.
				header = rule.getClass().getSimpleName(); 
			}
		} 
		pLog.log(header , eval);
		return eval;
	}

	public void setPrettyLog(IPrettyLog pLog) {
		this.pLog = pLog;
	}

}
