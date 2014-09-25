/*******************************************************************************
 * Copyright (c) 25 sep. 2014 NetXForge.
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
package com.netxforge.screens.editing.base;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.netxforge.base.data.IDataObjectValidator;
import com.netxforge.screens.editing.base.filter.ISearchFilter;
import com.netxforge.screens.editing.base.util.IValidationService;

/**
 * Decoration for {@link IScreen}. {@link AbstractScreenImpl The base
 * implementation} will offer the decorator to IScreen, through some delegation
 * methods.
 * 
 * @author Christophe Bouhier
 * 
 */
@Component
public class ScreenDecorator {

	private ISearchFilter searchFilter;

	private IDataObjectValidator dataObjectValidator;

	private IValidationService validationService;

	@Reference
	void setSearchFilter(ISearchFilter searchFilter) {
		this.searchFilter = searchFilter;
	}

	@Reference
	void setObjectValidator(IDataObjectValidator objectValidator) {
		this.dataObjectValidator = objectValidator;
	}

	@Reference
	void setValidationService(IValidationService valService) {
		this.validationService = valService;
	}
	
	
	// Getters.
	
	public ISearchFilter getSearchFilter() {
		return searchFilter;
	}

	public IDataObjectValidator getDataObjectValidator() {
		return dataObjectValidator;
	}

	public IValidationService getValidationService() {
		return validationService;
	}
	
	
	
}
