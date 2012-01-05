package com.netxforge.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Names as they will appear in the editor.
 * 
 * @author dzonekl
 * 
 */
public class QualifiedDynamixCDONameProvider extends
		IQualifiedNameProvider.AbstractImpl {
	
	
	public static final String NAMED_QUALIFIED_DYNAMIX_CDO_NAME_PROVIDER = "com.netxforge.scoping.NAMED_QUALIFIED_DYNAMIX_CDO_NAME_PROVIDER";
	
	@Inject
	private IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();

	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;

	private Function<EObject, String> resolver = NetxscriptNameResolver
			.newResolver(String.class, "name");

	protected Function<EObject, String> getResolver() {
		return resolver;
	}

	public QualifiedName getFullyQualifiedName(final EObject obj) {
		return cache.get(Tuples.pair(obj, "fqn"), obj.eResource(),
				new Provider<QualifiedName>() {

					public QualifiedName get() {
						EObject temp = obj;

						String name = getResolver().apply(temp);
						if (Strings.isEmpty(name))
							return null;
						QualifiedName qualifiedNameFromConverter = converter
								.toQualifiedName(name);
						while (temp.eContainer() != null) {
							temp = temp.eContainer();
							QualifiedName parentsQualifiedName = getFullyQualifiedName(temp);
							if (parentsQualifiedName != null)
								return parentsQualifiedName
										.append(qualifiedNameFromConverter);
						}
						return qualifiedNameFromConverter;
					}
				});
	}

}
