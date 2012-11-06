/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.xtext.builder.impl.ToBeBuiltComputer;
import org.eclipse.xtext.builder.impl.javasupport.JavaChangeQueueFiller;
import org.eclipse.xtext.builder.impl.javasupport.ProjectClasspathChangeListener;
import org.eclipse.xtext.builder.impl.javasupport.JdtToBeBuiltComputer;
import org.eclipse.xtext.common.types.ui.notification.TypeResourceUnloader;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.AbstractModule;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SharedModuleWithJdt extends AbstractModule {

	@Override
	protected void configure() {
		bind(ToBeBuiltComputer.class).to(JdtToBeBuiltComputer.class);
		bind(ProjectClasspathChangeListener.class).asEagerSingleton();
		bind(IStorage2UriMapper.class).to(Storage2UriMapperJavaImpl.class);
		bind(IResourceSetProvider.class).to(XtextResourceSetProvider.class);
		bind(TypeResourceUnloader.class).asEagerSingleton();
		bind(JavaChangeQueueFiller.class).asEagerSingleton();
	}

}