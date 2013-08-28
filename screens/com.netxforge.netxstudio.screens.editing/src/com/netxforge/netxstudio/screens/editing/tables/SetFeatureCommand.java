package com.netxforge.netxstudio.screens.editing.tables;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.StrictCompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
public class SetFeatureCommand extends StrictCompoundCommand {

	/**
	 * This caches the label.
	 */
	protected static final String LABEL = "Set Down";

	/**
	 * This caches the description.
	 */
	protected static final String DESCRIPTION = "Set feature down";

	/**
	 * This keeps track of the domain in which this command is created.
	 */
	protected EditingDomain domain;

	/**
	 * This keeps track of the owner in the command parameter from the
	 * constructor.
	 */
	protected EObject owner;

	/*
	 * The feature to be copied.
	 */
	private EStructuralFeature feature;

	/*
	 * Our target objects which will receive the copy.
	 */
	private Collection<EObject> targets;

	/**
	 * This creates and instance in the given domain and for the given owner
	 */
	public SetFeatureCommand(EditingDomain domain, EObject owner,
			Collection<EObject> targets, EStructuralFeature feature) {
		super(LABEL, DESCRIPTION);

		this.resultIndex = 0;
		this.domain = domain;
		this.owner = owner;
		this.feature = feature;
		this.targets = targets;
	}

	@Override
	protected boolean prepare() {

		// targetResource could potentially be optional, if the feature we copy
		// is non EReference, and non Containment.
		if (owner == null || feature == null || targets == null
				|| targets.isEmpty()) {
			return false;
		}
		
		boolean allTargetsSupported = true;
		for (EObject target : targets) {
			// valid feature exists for this target.
			if (!target.eClass().getEAllStructuralFeatures().contains(feature)) {
				allTargetsSupported = false;
			}
		}
		
		final Object reference = owner.eGet(feature);

		boolean result = owner != null && feature != null && reference != null
				&& reference instanceof EObject && allTargetsSupported;
		
		// bail if we have a feature issue. 
		if(!result) return false;
		
		Command setFeatureCommand = new CompoundCommand() {
			@Override
			public boolean prepare() {
				for (EObject target : targets) {

					Command setCopy = SetCommand.create(domain, target,
							feature, reference);

					// Record it for execution.
					if (!this.appendIfCanExecute(setCopy)) {
						return false;
					}

				}

				return true;
			}
		};
		append(setFeatureCommand);
		
		result = super.prepare();

		return result;
	}

	@Override
	public boolean canExecute() {
		boolean result;
		result = super.canExecute();
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
}
