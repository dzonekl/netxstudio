package com.netxforge.netxstudio.screens.internal;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.netxforge.netxstudio.common.guice.IInjectorProxy;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.ch9.NetXScriptInjectorProxy;
import com.netxforge.netxstudio.screens.f1.support.PeriodSelectionPage;
import com.netxforge.netxstudio.screens.f1.support.ValueRangeSelectionPage;
import com.netxforge.netxstudio.screens.f2.ExpressionSupport;
import com.netxforge.netxstudio.screens.f2.PeriodComponent;
import com.netxforge.netxstudio.screens.f2.ValueComponentII;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedLineExpression;

public class ScreensModule extends AbstractModule {

	@Override
	protected void configure() {
		
		// Injector proxy for NetXScript binding. 
		this.bind(IInjectorProxy.class).annotatedWith(Names.named("Netxscript")).to(NetXScriptInjectorProxy.class);
		this.bind(IInjectorProxy.class).annotatedWith(Names.named("Screens")).to(ScreensInjectorProxy.class);
		
		this.bind(SearchFilter.class);
		
		this.bind(PeriodSelectionPage.class);
		
		this.bind(ValueRangeSelectionPage.class);
		
		// Binding util.
//		this.bind(TableHelper.class);

		// Binding of components.
//		this.bind(ValueComponent.class);
		
		// Move to xtext screens binding
		this.bind(EmbeddedLineExpression.class);
		
		this.bind(ExpressionSupport.class);
		
		this.bind(PeriodComponent.class);
		
		// a better version. 
		this.bind(ValueComponentII.class);
		
		
	}

}
