package com.netxforge.netxstudio.screens.common;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.screens.common.tables.TableHelper;

public class ScreensModule extends AbstractModule {

	@Override
	protected void configure() {
//		this.bind(SearchFilter.class);

		// Binding util.
		this.bind(TableHelper.class);

		// Binding of components.
//		this.bind(EmbeddedLineExpression.class);
//		this.bind(PeriodComponent.class);
		
		// a better version. 
//		this.bind(ValueComponentII.class);
		
	}

}
