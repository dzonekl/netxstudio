/*******************************************************************************
 * Copyright (c) 18 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.internal;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.netxforge.netxstudio.common.guice.IInjectorProxy;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.ch9.NetXScriptInjectorProxy;
import com.netxforge.netxstudio.screens.f1.ServiceSummaryComponent;
import com.netxforge.netxstudio.screens.f1.support.PeriodSelectionPage;
import com.netxforge.netxstudio.screens.f1.support.ValueRangeSelectionPage;
import com.netxforge.netxstudio.screens.f2.ExpressionSupport;
import com.netxforge.netxstudio.screens.f2.LazyResourcesComponent;
import com.netxforge.netxstudio.screens.f2.support.NodeTypeTreeLabelProvider;
import com.netxforge.netxstudio.screens.f3.PeriodComponent;
import com.netxforge.netxstudio.screens.f3.ResourcesComponent;
import com.netxforge.netxstudio.screens.f3.SmartValueComponent;
import com.netxforge.netxstudio.screens.f3.ValueComponentII;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedLineExpression;

/**
 * 
 * @author Christophe Bouhier
 * 
 */
public class ScreensModule extends AbstractModule {

	@Override
	protected void configure() {

		// Injector proxys
		this.bind(IInjectorProxy.class)
				.annotatedWith(Names.named("Netxscript"))
				.to(NetXScriptInjectorProxy.class);

		this.bind(IInjectorProxy.class).annotatedWith(Names.named("Screens"))
				.to(ScreensInjectorProxy.class);

		this.bind(SearchFilter.class);

		this.bind(PeriodSelectionPage.class);

		this.bind(ValueRangeSelectionPage.class);

		// Move to xtext screens binding
		this.bind(EmbeddedLineExpression.class);

		this.bind(ExpressionSupport.class);

		// Bind Components
		this.bind(PeriodComponent.class);

		this.bind(ValueComponentII.class);

		this.bind(SmartValueComponent.class);

		this.bind(ResourcesComponent.class);

		this.bind(LazyResourcesComponent.class);

		this.bind(ServiceSummaryComponent.class);

		// Bind Label Providers
		this.bind(NodeTypeTreeLabelProvider.class);

	}

}
