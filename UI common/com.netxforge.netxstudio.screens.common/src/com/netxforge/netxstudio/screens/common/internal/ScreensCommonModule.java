package com.netxforge.netxstudio.screens.common.internal;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.screens.common.tables.TableHelper;
import com.netxforge.netxstudio.screens.common.util.MementoUtil;
import com.netxforge.netxstudio.screens.common.util.ValidationService;


/**
 * 
 * Gradually move binding for these types here. 
 * @author Christophe Bouhier
 *
 */
public class ScreensCommonModule extends AbstractModule {

	@Override
	protected void configure() {

		// Binding util.
		this.bind(TableHelper.class);
		this.bind(MementoUtil.class).in(Singleton.class);
		this.bind(ValidationService.class);
		
	}

}
