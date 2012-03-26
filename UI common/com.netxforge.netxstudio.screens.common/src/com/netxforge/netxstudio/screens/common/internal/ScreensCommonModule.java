package com.netxforge.netxstudio.screens.common.internal;

import com.google.inject.AbstractModule;
import com.netxforge.netxstudio.screens.common.tables.TableHelper;


/**
 * 
 * Gradually move binding for these types here. 
 * @author Christophe
 *
 */
public class ScreensCommonModule extends AbstractModule {

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
