package com.netxforge.netxstudio.emf.teneo;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.operators.Operator;

public class ModelUtil {

	public static Library getFirstLibrary(ResourceSet set) {
		TreeIterator<Notifier> allContents = set.getAllContents();
		while (allContents.hasNext()) {
			Notifier next = allContents.next();
			if (next instanceof Library)
				return (Library) next;
		}
		// We should always have a Library!
		return null;
	}

	public static Operator getFirstOperator(ResourceSet set) {
		TreeIterator<Notifier> allContents = set.getAllContents();
		while (allContents.hasNext()) {
			Notifier next = allContents.next();
			if (next instanceof Operator)
				return (Operator) next;
		}
		// We should always have a Library!
		return null;
	}
	
	
	/**
	 * Returns a parent of the provided target conforming to the the specified type. 
	 * If none is found, the target itself is returned. 
	 * 
	 * @param target
	 * @return
	 */
	public static EObject getRootObject(EObject target, EClassifier type) {

		if (target.eContainer() != null && !(target.eClass().equals(type))) {
			return getRootObject(target.eContainer(), type);
		} else {
			return target;
		}
	}

	/**
	 * Get a sequence number for an arbitrary object.
	 * 
	 * @param target
	 * @return
	 */
	public static int nextSequenceNumber(EObject target) {
		if (target instanceof Equipment) {
			Equipment eq = (Equipment) target;
			int index = eq.getEquipments().size();
			if (index > 0) {
				Equipment lastChild = eq.getEquipments().get(index - 1);
				if (lastChild.getPosition() != null) {
					try {
						Integer i = new Integer(lastChild.getPosition());
						return i.intValue() + 1;
					} catch (NumberFormatException e) {
					}
				}
			}
		}
		return 0;
	}

	/**
	 * Returns a naked copy of the eObject. (Only attributes, no references,
	 * cross references, proxy URI.
	 * 
	 * @param eObject
	 *            the object to copy.
	 * @return the copy.
	 * @see Copier
	 */
	public static <T extends EObject> T nakedCopy(T eObject) {
		NakedCopier copier = new NakedCopier();
		EObject result = copier.copy(eObject);

		// copier.copyReferences();

		@SuppressWarnings("unchecked")
		T t = (T) result;
		return t;
	}
	
	
	
	
	/*
	 * Custom copier.
	 */
	public static class NakedCopier extends EcoreUtil.Copier {

		private static final long serialVersionUID = 1L;

		@Override
		public EObject copy(EObject eObject) {
			if (eObject == null) {
				return null;
			} else {
				EObject copyEObject = createCopy(eObject);
				put(eObject, copyEObject);
				EClass eClass = eObject.eClass();
				for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
					EStructuralFeature eStructuralFeature = eClass
							.getEStructuralFeature(i);
					if (eStructuralFeature.isChangeable()
							&& !eStructuralFeature.isDerived()) {
						if (eStructuralFeature instanceof EAttribute) {
							copyAttribute((EAttribute) eStructuralFeature,
									eObject, copyEObject);
						}
						// DON'T COPY REFERENCES.
						// else {
						// EReference eReference = (EReference)
						// eStructuralFeature;
						// if (eReference.isContainment()) {
						// copyContainment(eReference, eObject,
						// copyEObject);
						// }
						// }
					}
				}

				// DON'T COPY the proxy URI (As a new one will be set inshallah
				// copyProxyURI(eObject, copyEObject);

				return copyEObject;
			}
		}

	}

	// public static MetricLibrary getFirstMetricLibrary(ResourceSet set){
	//
	// for( Resource res : set.getResources()){
	// for(EObject root : res.getContents()){
	// if (root instanceof MetricLibrary)
	// return (MetricLibrary)root;
	//
	// }
	// }
	// // We should always have a Metriclibrary!
	// return null;
	// }

	public static Library getFirstLibrary(Resource res) {
		TreeIterator<EObject> allContents = res.getAllContents();
		while (allContents.hasNext()) {
			Notifier next = allContents.next();
			if (next instanceof Library)
				return (Library) next;
		}
		return null;
	}

	// Ensure that the resource at least contains a Library.
	public static void initializeLibrary(Resource res) {
		boolean addLibrary = true;
		// Check the contents for existing.
		Library lib = null;
		for (Object o : res.getContents()) {
			if (o instanceof Library) {
				addLibrary = false;
				lib = (Library) o;
			}
		}
		if (addLibrary) {
			lib = LibraryFactory.eINSTANCE.createLibrary();
			lib.setName("NetXLib");
//			lib.setDescription("netxstudio library");
//			lib.setVersion(new Double(0.01).doubleValue());
			res.getContents().add(lib);

		}
	}
	// public static void initializeMetricLibrary(Resource res) {
	// boolean addLibrary = true;
	// // Check the contents for existing.
	// MetricLibrary metricLib = null;
	// for (Object o : res.getContents()) {
	// if (o instanceof MetricLibrary) {
	// addLibrary = false;
	// metricLib = (MetricLibrary) o;
	// }
	// }
	// if (addLibrary) {
	// metricLib = MetricsFactory.eINSTANCE.createMetricLibrary();
	// metricLib.setName("NetXMetricLib");
	// res.getContents().add(metricLib);
	// }
	// }

}
