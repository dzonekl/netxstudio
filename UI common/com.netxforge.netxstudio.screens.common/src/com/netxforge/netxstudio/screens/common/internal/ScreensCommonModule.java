package com.netxforge.netxstudio.screens.common.internal;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.screens.common.tables.TableHelper;
import com.netxforge.netxstudio.screens.common.util.MementoUtil;


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
		
		this.bind(MementoUtil.class).in(Singleton.class);
		
		// Binding of components.
//		this.bind(EmbeddedLineExpression.class);
//		this.bind(PeriodComponent.class);
		
		// a better version. 
//		this.bind(ValueComponentII.class);
		
	}

}
