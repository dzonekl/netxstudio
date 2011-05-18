/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.validation;

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Company;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.Vendor;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.scheduling.Job;

/**
 * A sample validator interface for {@link com.netxforge.netxstudio.Netxstudio}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface NetxstudioValidator {
	boolean validate();

	boolean validateOperators(EList<Operator> value);
	boolean validateLibraries(EList<Library> value);
	boolean validateCompanies(EList<Company> value);
	boolean validateVendors(EList<Vendor> value);
	boolean validateUsers(EList<Person> value);
	boolean validateRoles(EList<Role> value);

	boolean validateCountries(EList<Country> value);
	boolean validateJobs(EList<Job> value);
}
