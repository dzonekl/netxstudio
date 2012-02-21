package com.netxforge.netxstudio.screens;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.screens.ch9.EmbeddedLineExpression;
import com.netxforge.netxstudio.screens.f2.PeriodComponent;
import com.netxforge.netxstudio.screens.f2.ValueComponent;
import com.netxforge.netxstudio.screens.f2.ValueComponentII;
import com.netxforge.netxstudio.screens.tables.TableHelper;

public class ScreensModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(SearchFilter.class);

		// Binding util.
		this.bind(TableHelper.class);

		// Binding of components.
		this.bind(ValueComponent.class);
		this.bind(EmbeddedLineExpression.class);
		this.bind(PeriodComponent.class);
		
		// a better version. 
		this.bind(ValueComponentII.class);
		
	}

}
