package com.netxforge.netxstudio.edit;

import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

public class EditUtils {

	public static final EditUtils INSTANCE = new EditUtils();

	public String typeName(EditingDomain domain, EObject target,
			EClass targetType) {
		// We would need to use an itemprovider here.

		if (domain instanceof AdapterFactoryEditingDomain) {
			((AdapterFactoryEditingDomain) domain).getAdapterFactory();
			IEditingDomainItemProvider editingDomainItemProvider = (IEditingDomainItemProvider) ((AdapterFactoryEditingDomain) domain)
					.getAdapterFactory().adapt(target,
							IEditingDomainItemProvider.class);

			if (editingDomainItemProvider instanceof ItemProviderAdapter) {
				ItemProviderAdapter adapter = (ItemProviderAdapter) editingDomainItemProvider;
				return adapter.getString("_UI_" + targetType.getName()
						+ "_type");
			}

		}
		return targetType.getName();
	}

	/**
	 * Get a collection from a target object by collection feature., use the
	 * last occurrence in the collection, to get an attribute value. return the
	 * attribute value incremented by 1.
	 * <p>
	 * If this is the first occurence the name will be.
	 * 
	 * <pre>
	 * &ltnew [target Object name] 1&gt
	 * </pre>
	 * 
	 * </p>
	 * 
	 * 
	 * @param targetParentObject
	 * @param collectionFeature
	 * @param identityFeature
	 *            An identity attribute which should be of type String.
	 * @return A String incremented by 1.
	 */
	public String nextSequenceNumber(EditingDomain domain,
			EObject targetParentObject, EReference collectionFeature,
			EAttribute identityFeature) {
		int maxSequence = -1;
		String highestIdentity = null;
		if (collectionFeature.isMany()) {
			final List<?> collection = (List<?>) targetParentObject
					.eGet(collectionFeature);

			for (Object child : collection) {
				if (((EObject) child).eIsSet(identityFeature)) {
					final String currentIdentity = (String) ((EObject) child)
							.eGet(identityFeature);
					int currentSequence = currentSequenceNumber(currentIdentity);
					if (currentSequence > maxSequence) {
						maxSequence = currentSequence;
						highestIdentity = currentIdentity;
					}
				}
			}

			if (maxSequence != -1 && highestIdentity != null) {
				return nextIdentity(highestIdentity);

			} else {
				// Note if we can't get a sequence number from the collection,
				// get the last entry and use this...
				if (!collection.isEmpty()) {
					Object object = collection.get(collection.size() - 1);
					final String lastIdentityInSequence = (String) ((EObject) object)
							.eGet(identityFeature);
					return lastIdentityInSequence + " 1";
				}
			}
		}

		return "<new "
				+ typeName(domain, targetParentObject,
						collectionFeature.getEReferenceType()) + " 1>";
	}

	public int currentSequenceNumber(final String identity) {
		try {

			final Pattern MY_PATTERN = Pattern.compile("[0-9]*");
			final Matcher m = MY_PATTERN.matcher(identity);
			String lastDigits = null;
			while (m.find()) {
				final String match = m.group();
				if (!match.isEmpty())
					lastDigits = match;
			}
			if (lastDigits != null) {
				try {
					Integer ld = new Integer(lastDigits);
					return ld;
				} catch (final NumberFormatException nfe) {
					System.err
							.println("ModelUtils: Can't formart" + lastDigits);
				}
			}
		} catch (final PatternSyntaxException pse) {
			System.err.println("ModelUtils: Wrong syntax");
		}
		return -1;
	}

	public String nextIdentity(final String identity) {
		String newName = new String();
		// See if the last 2 chars are a digit.
		try {

			final Pattern MY_PATTERN = Pattern.compile("[0-9]*");
			final Matcher m = MY_PATTERN.matcher(identity);
			String lastDigits = null;
			while (m.find()) {
				final String match = m.group();
				if (!match.isEmpty())
					lastDigits = match;
			}
			if (lastDigits != null) {

				// also keep the post fix of the string.
				int indexOfLastDigits = identity.indexOf(lastDigits);
				final String preFix = identity.substring(0, indexOfLastDigits);
				final String postFix = identity.substring(indexOfLastDigits
						+ lastDigits.length(), identity.length());
				try {
					Integer ld = new Integer(lastDigits);
					ld++;
					// Perhaps format with 0...

					// Do a simple text format.
					final DecimalFormat format = new DecimalFormat();
					format.applyPattern("###");
					newName = preFix + format.format(ld) + postFix;

				} catch (final NumberFormatException nfe) {
					System.err
							.println("ModelUtils: Can't formart" + lastDigits);
				}
			}
		} catch (final PatternSyntaxException pse) {
			System.err.println("ModelUtils: Wrong syntax");
		}
		return newName;
	}

}
