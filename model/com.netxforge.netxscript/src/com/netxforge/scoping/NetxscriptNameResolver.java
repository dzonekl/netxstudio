package com.netxforge.scoping;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.SimpleCache;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Name provider, which considers the feature of an object which should provide
 * the name. Both features providing names and the actual value themselves are
 * cached. Changing the name or the vale
 * 
 * 
 * @author Christophe Bouhier
 * 
 * @param <K>
 * @param <T>
 */
public class NetxscriptNameResolver<K extends EObject, T> implements
		Function<K, T> {

	// The name attribute is a fallback, but we will actually inspect the type
	// of the target EClass,
	// to get the correct feature.
	public final static NetxscriptNameResolver<EObject, String> NAME_RESOLVER = newResolver(
			String.class, "name");

	private final SimpleCache<EClass, EAttribute> attributeCache;

	private final SimpleCache<EObject, T> valueCache;

	private final String attributeName;

	private final Adapter discardingAdapter;

	public static <K extends EObject, T> NetxscriptNameResolver<K, T> newResolver(
			final Class<T> type, final String attributeName) {
		return new NetxscriptNameResolver<K, T>(type, attributeName);
	}

	public EAttribute getAttribute(final EObject object) {
		return attributeCache.get(object.eClass());
	}

	protected NetxscriptNameResolver(final Class<T> type,
			final String attributeName) {
		this.attributeName = attributeName;

		// TODO, not sure this would work for remote invalidations by CDO.
		this.discardingAdapter = new DiscardingAdapter();
		attributeCache = new SimpleCache<EClass, EAttribute>(
				new Function<EClass, EAttribute>() {
					public EAttribute apply(EClass param) {
						EStructuralFeature structuralFeature = feature(param);
						if (structuralFeature != null
								&& structuralFeature instanceof EAttribute
								&& !structuralFeature.isMany()) {
							if (type.isAssignableFrom(structuralFeature
									.getEType().getInstanceClass())) {
								return (EAttribute) structuralFeature;
							}
						}
						return null;
					}
				});
		valueCache = new SimpleCache<EObject, T>(new Function<EObject, T>() {
			@SuppressWarnings("unchecked")
			public T apply(EObject param) {
				final EStructuralFeature feature = attributeCache.get(param
						.eClass());
				if (feature != null) {
					param.eAdapters().add(discardingAdapter);
				}
				return feature != null ? ((T) param.eGet(feature)) : null;
			}
		});
	}

	public T getValue(final K object) {
		return valueCache.get(object);
	}

	public Iterable<K> getMatches(final Iterable<K> candidates, final T value) {
		return Iterables.filter(candidates, new Predicate<K>() {
			public boolean apply(K param) {
				final T candidateValue = getValue(param);
				return value.equals(candidateValue);
			}
		});
	}

	private class DiscardingAdapter implements Adapter {

		public Notifier getTarget() {
			return null;
		}

		public boolean isAdapterForType(final Object type) {
			return type instanceof EObject;
		}

		public void notifyChanged(final Notification notification) {
			if (!notification.isTouch()
					&& Notification.SET == notification.getEventType()) {
				final Object feature = notification.getFeature();

				if (feature != null) {
					EAttribute attribute = getAttribute((EObject) notification
							.getNotifier());
					if (attribute.equals(((ENamedElement) feature).getName())) {
						valueCache
								.discard((EObject) notification.getNotifier());
						((EObject) notification.getNotifier()).eAdapters()
								.remove(this);
					}
				}

			}
		}

		public void setTarget(final Notifier newTarget) {
			// nothing to do
		}
	}

	public T apply(final K from) {
		return getValue(from);
	}

	/*
	 * Add types here for references which occure in NetXScript.
	 * 
	 * @param c
	 * 
	 * @return
	 */
	private EStructuralFeature feature(EClass c) {

		if (c == LibraryPackage.Literals.EQUIPMENT) {
			return LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_CODE;
		} else if (c == LibraryPackage.Literals.PARAMETER) {
			return LibraryPackage.Literals.PARAMETER__EXPRESSION_NAME;
		} else if (c == OperatorsPackage.Literals.NODE) {
			return OperatorsPackage.Literals.NODE__NODE_ID;
		} else if (c == LibraryPackage.Literals.BASE_RESOURCE
				|| c == LibraryPackage.Literals.NET_XRESOURCE
				|| c == ServicesPackage.Literals.DERIVED_RESOURCE) {
			return LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME;
		}
		final EStructuralFeature structuralFeature = c
				.getEStructuralFeature(attributeName);
		return structuralFeature;
	}

}
