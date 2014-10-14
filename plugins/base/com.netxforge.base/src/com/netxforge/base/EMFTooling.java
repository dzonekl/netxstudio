/*******************************************************************************
 * Copyright (c) 10 okt. 2014 NetXForge.
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
package com.netxforge.base;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

public class EMFTooling {

	public static EPackage packageFor(String nsURI) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
		return ePackage;
	}

	/**
	 * Gets all {@link EPackage} from the {@link EPackage.Registry package
	 * registry}.
	 * 
	 * @return
	 */
	public static List<EPackage> globalPackages() {

		Collection<Object> values = EPackage.Registry.INSTANCE.values();
		Iterator<EPackage> transform = Iterators.transform(values.iterator(),
				new Function<Object, EPackage>() {

					public EPackage apply(Object input) {

						if (input instanceof EPackage) {
							return (EPackage) input;
						} else if (input instanceof EPackage.Descriptor) {
							EPackage.Descriptor ePackageDescriptor = (EPackage.Descriptor) input;
							return ePackageDescriptor.getEPackage();
						}
						return null;
					}

				});
		return Lists.newArrayList(transform);
	}

	public static EPackage packageForIndex(int intValue) {
		Collection<Object> values = EPackage.Registry.INSTANCE.values();
		Object object = Lists.newArrayList(values).get(intValue);
		if (object instanceof EPackage) {
			return (EPackage) object;
		}else if (object instanceof EPackage.Descriptor) {
			EPackage.Descriptor ePackageDescriptor = (EPackage.Descriptor) object;
			return ePackageDescriptor.getEPackage();
		}
		return null;
	}

}
