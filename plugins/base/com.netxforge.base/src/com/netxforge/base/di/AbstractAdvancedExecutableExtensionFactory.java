package com.netxforge.base.di;

/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

import static org.eclipse.core.runtime.ContributorFactoryOSGi.resolve;

import java.lang.reflect.Constructor;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractAdvancedExecutableExtensionFactory implements
		IExecutableExtensionFactory, IExecutableExtension {
	public static final String GUICEKEY = "guicekey";
	protected String clazzName;
	protected IConfigurationElement config;

	private IContributor contributor;

	@SuppressWarnings({ "unchecked" })
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		if (data instanceof String) {
			clazzName = (String) data;
		} else if (data instanceof Map<?, ?>) {
			clazzName = ((Map<String, String>) data).get(GUICEKEY);
		}
		if (clazzName == null) {
			throw new IllegalArgumentException("couldn't handle passed data : "
					+ data);
		}

		this.config = config;
		this.contributor = config.getContributor();
	}

	public Object create() throws CoreException {

		Bundle bundle = resolve(contributor);

		try {
			final Class<?> clazz = bundle.loadClass(clazzName);
			final Injector injector = getInjector();
			Object result = null;
			if (hasZeroArgumentConstructor(clazz)) {
				result = injector.getInstance(clazz);
			}else {
				// Get Parameters...!
				
			}

			if (result instanceof IExecutableExtension)
				((IExecutableExtension) result).setInitializationData(config,
						null, null);
			return result;
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR,
					bundle.getSymbolicName(), e.getMessage()
							+ " ExtensionFactory: " + getClass().getName(), e));
		}
	}

	private boolean hasZeroArgumentConstructor(Class<?> clazz) {

		boolean hasZeroArgumentContstructor = false;

		for (Constructor<?> c : clazz.getConstructors()) {
			if (c.getParameterTypes().length == 0) {
				hasZeroArgumentContstructor = true;
				break;
			}
		}
		return hasZeroArgumentContstructor;
	}

	protected abstract Injector getInjector();

}
