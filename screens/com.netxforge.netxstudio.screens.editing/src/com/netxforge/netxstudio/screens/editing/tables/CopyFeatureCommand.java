package com.netxforge.netxstudio.screens.editing.tables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.StrictCompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * A command which copies a feature from a given object to given targets. The
 * targets can be updated while the command has not execute.
 * 
 * The copy gets a new Name if it's an Expression. TODO, very object specific
 * perhaps we should add an initialize strategy for the object.
 * 
 * @author Christophe
 */
public class CopyFeatureCommand extends StrictCompoundCommand {

	/**
	 * This creates a command that copies the given feature from the given
	 * object.
	 */

	// public static Command create(EditingDomain domain, Object owner,
	// EStructuralFeature feature) {
	// return domain.createCommand(CopyFeatureCommand.class,
	// new CommandParameter(owner, feature, new Helper()));
	// }

	// /**
	// * This creates a command that copies the given collection of objects. If
	// * the collection contains more than one object, then a compound command
	// * will be created containing individual copy commands for each object.
	// */
	// public static Command create(final EditingDomain domain,
	// final Collection<?> collection) {
	// if (collection == null || collection.isEmpty()) {
	// return UnexecutableCommand.INSTANCE;
	// }
	//
	// Helper copyHelper = new Helper();
	// CompoundCommand copyCommand = new CompoundCommand(
	// CompoundCommand.MERGE_COMMAND_ALL);
	// for (Object object : collection) {
	// copyCommand.append(domain.createCommand(CopyCommand.class,
	// new CommandParameter(object, null, copyHelper)));
	// }
	//
	// return copyCommand.unwrap();
	// }

	/**
	 * This caches the label.
	 */
	protected static final String LABEL = "Copy Down";

	/**
	 * This caches the description.
	 */
	protected static final String DESCRIPTION = EMFEditPlugin.INSTANCE
			.getString("_UI_CopyCommand_description");

	protected final static FeatureInitializer NULL_INITIALIZER = new FeatureInitializer();

	/**
	 * This keeps track of the domain in which this command is created.
	 */
	protected EditingDomain domain;

	/**
	 * This keeps track of the owner in the command parameter from the
	 * constructor.
	 */
	protected EObject owner;

	/**
	 * This is a map of objects to their copies
	 */
	protected Helper copyHelper;

	/*
	 * The feature to be copied.
	 */
	private EStructuralFeature feature;

	/*
	 * Our target objects which will receive the copy.
	 */
	private Collection<EObject> targets;

	/*
	 * Pass a copy of the object, through this initializer.
	 */
	private FeatureInitializer initializer;

	private Resource targetResource;

	public CopyFeatureCommand(EditingDomain domain, EObject owner,
			Collection<EObject> targets, EStructuralFeature feature,
			Helper copyHelper, Resource resource) {
		this(domain, owner, targets, feature, copyHelper, NULL_INITIALIZER,
				resource);
	}

	// /**
	// * This controls whether or not to optimize the canExecute (prepare)
	// */
	// protected boolean optimize;

	/**
	 * This creates and instance in the given domain and for the given owner
	 */
	public CopyFeatureCommand(EditingDomain domain, EObject owner,
			Collection<EObject> targets, EStructuralFeature feature,
			Helper copyHelper, FeatureInitializer initializer, Resource resource) {
		super(LABEL, DESCRIPTION);

		this.resultIndex = 0;
		this.domain = domain;
		this.owner = owner;
		this.feature = feature;
		this.copyHelper = copyHelper;
		this.targets = targets;
		this.initializer = initializer;
		this.targetResource = resource;
		// this.optimize = optimize;

		// CB decide what to do with this.
		// copyHelper.incrementDeferredInitializationCount();
	}

	@Override
	protected boolean prepare() {

		// targetResource could potentially be optional, if the feature we copy
		// is non EReference, and non Containment.
		if (owner == null || feature == null || targets == null
				|| targets.isEmpty() || targetResource == null) {
			return false;
		}

		// Create commands to create the copy object(s).
		//
		CompoundCommand createCommand = new CompoundCommand(0);
		addCreateCopyFeatureCommands(createCommand, owner, targets, feature);
		append(createCommand.unwrap());

		// CB migrate init, do we actually need this????
		// Create an initialize copy command for each of the created objects.
		//
		// if (copyHelper.decrementDeferredInitializationCount() == 0) {
		Command setFeatureCommand = new CompoundCommand() {
			@Override
			public boolean prepare() {
				for (Iterator<EObject> copiedObjects = copyHelper
						.copyIterator(); copiedObjects.hasNext();) {

					EObject target = copiedObjects.next();
					Object copy = copyHelper.getCopy(target);

					// For non-contained EReference features, we need a Resource
					// destination.
					if (feature instanceof EReference) {
						EReference eRef = (EReference) feature;
						if (!eRef.isContainment()) {
							AddCommand addCommand = new AddCommand(domain,
									targetResource.getContents(), copy);
							// Record the add command for execution.
							if (!this.appendIfCanExecute(addCommand)) {
								return false;
							}
						}
					}

					initializer.initialize(target, copy, feature);

					Command setCopy = SetCommand.create(domain, target,
							feature, copy);

					// Record it for execution.
					if (!this.appendIfCanExecute(setCopy)) {
						return false;
					}

					copiedObjects.remove();
				}

				return true;
			}
		};
		append(setFeatureCommand);
		// }

		// else if (!optimize) {
		// // This ensures that the CreateCopyCommand will be executed by
		// // StrictCompoundCommand.prepare().
		// //
		// append(IdentityCommand.INSTANCE);
		// }

		// This will execute the CreateCopyCommand's and then call canExecute on
		// the InitializeCopyCommand's.
		//
		boolean result = super.prepare();

		return result;
	}

	@Override
	public boolean canExecute() {
		boolean result;
		// if (optimize) {
		// // We'll assume that all the CreateCopyCommand's and
		// // InitializeCopyCommand's can execute.
		// //
		// result = true;
		// } else {
		// // This will call prepare() which will partially execute the
		// // command.
		// //

		result = super.canExecute();
		// }

		return result;
	}

	@Override
	public void execute() {
		// We need to check canExecute() in case optimize is true.
		//
		if (super.canExecute()) {
			super.execute();
		} else {
			// Thread.dumpStack();
		}
	}

	protected void addCreateCopyFeatureCommands(
			CompoundCommand compoundCommand, EObject object,
			Collection<EObject> targets, EStructuralFeature feature) {
		// Create a command to create a copy of the object.
		//
		Command createCopyCommand = new CreateFeatureCopyCommand(domain,
				object, targets, feature, copyHelper);
		compoundCommand.append(createCopyCommand);

		// CB disable closure aspects.
		// if (createCopyCommand instanceof ChildrenToCopyProvider
		// && createCopyCommand.canExecute()) {
		// for (Object child : ((ChildrenToCopyProvider) createCopyCommand)
		// .getChildrenToCopy()) {
		// addCreateCopyFeatureCommands(compoundCommand, (EObject) child);
		// }
		// } else {
		// // Create commands to create copies of the children.
		// //
		// for (EObject child : object.eContents()) {
		// addCreateCopyFeatureCommands(compoundCommand, child);
		// }
		// }
	}

	/**
	 * This gives an abbreviated name using this object's own class' name,
	 * without package qualification, followed by a space separated list of
	 * <tt>field:value</tt> pairs.
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (domain: " + domain + ")");
		result.append(" (owner: " + owner + ")");

		return result.toString();
	}

	public static class FeatureInitializer {

		public void initialize(Object owner, Object copy,
				EStructuralFeature feature) {
			// do nothing.
		}

	}

	/**
	 * This helper class is used to keep track of the feature to copy and the
	 * target objects and their associated copied features.
	 */
	public static class Helper extends HashMap<EObject, Object> {
		private static final long serialVersionUID = 1L;

		protected ArrayList<EObject> initializationList = new ArrayList<EObject>();

		// The master copy.
		protected Object masterCopy;

		// protected int deferredInitializationCount;
		//
		// /**
		// * Return the copy of the specified object if it has one.
		// */
		public Object getCopy(EObject object) {
			return get(object);
		}

		//
		// /**
		// * Return the copy of the specified object or the object itself if it
		// * has no copy.
		// */
		// public EObject getCopyTarget(EObject target, boolean copyRequired) {
		// EObject copied = getCopy(target);
		// if (copied == null) {
		// copied = copyRequired ? null : target;
		// }
		// return copied;
		// }
		//
		@Override
		public Object put(EObject key, Object value) {
			initializationList.add(key);
			return super.put(key, value);
		}

		//
		@Override
		public Object remove(Object key) {
			initializationList.remove(key);
			return super.remove(key);
		}

		//
		public Iterator<EObject> copyIterator() {
			return initializationList.iterator();
		}

		//
		// public void incrementDeferredInitializationCount() {
		// ++deferredInitializationCount;
		// }
		//
		// public int decrementDeferredInitializationCount() {
		// return --deferredInitializationCount;
		// }
		/**
		 * @return the masterCopy
		 */
		public Object getMasterCopy() {
			return masterCopy;
		}

		/**
		 * @param masterCopy
		 *            the masterCopy to set
		 */
		public void setMasterCopy(Object masterCopy) {
			this.masterCopy = masterCopy;
		}
	}
}
