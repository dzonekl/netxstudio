/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.editing.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.observable.IDecoratingObservable;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.MultiValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.jface.databinding.swt.ISWTObservable;
import org.eclipse.jface.databinding.viewers.IViewerObservable;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.IMessageManager;

import com.google.common.collect.Maps;
import com.netxforge.netxstudio.screens.editing.internal.EditingActivator;

/**
 * Can register a binding context for which validation will be converted to
 * {@link IMessage}, one for each {@link ValidationStatusProvider} in the
 * {@link BindingContext} The {@link MessageFromStatus} implementation holds all
 * required information for a {@link IMessageManager} to add and remove
 * messages.
 * 
 * </p>Can register a listener {@link IValidationListener} notified on value
 * changes. </p>
 * 
 * Note: Future use: Can register a decorator on controls, which will be
 * notified when matching the observable controls of the binding context.
 * 
 * Supports a custom {@link MultiValidator} implementation, which can help in
 * resolving the corresponding {@link Control} needed for the .
 * 
 * To use, add an {@link IValidator } to {@link EMFUpdateValueStrategy}, and set
 * in a Binding context.
 * 
 * 
 * Then register the binding context with
 * {@link #registerBindingContext(DataBindingContext)}
 * 
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class ValidationService implements IValidationService {

	/*
	 * A Factory for producing strategies.
	 */
	private static final ValueStrategyFactory strategyFactory = new ValueStrategyFactory();

	/**
	 * Get a factory which produces prefabricated strategies.
	 * 
	 * @return
	 */
	public static ValueStrategyFactory getStrategyfactory() {
		return strategyFactory;
	}

	/**
	 * Implements {@link IMessage} but wraps around an IStatus of the Binding
	 * Framework.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class MessageFromStatus implements IMessage {

		private int msgType = -1; // Cache the msg type.
		private final Control control;
		private final IStatus newStatus;
		private final IStatus oldStatus;

		private MessageFromStatus(Control control, IStatus oldStatus,
				IStatus newStatus) {
			this.control = control;
			this.newStatus = newStatus;
			this.oldStatus = oldStatus;
		}

		public IStatus getNewStatus() {
			return newStatus;
		}

		public IStatus getOldStatus() {
			return oldStatus;
		}

		public Control getControl() {
			return control;
		}

		public Object getData() {
			return null;
		}

		public Object getKey() {
			return null;
		}

		public String getPrefix() {
			return null;
		}

		/**
		 * Resolves the message from {@link IStatus}
		 */
		public String getMessage() {
			return newStatus.getMessage();
		}

		/**
		 * Resolves the the message type from {@link IStatus}
		 */
		public int getMessageType() {
			if (msgType == -1)
				msgType = convertType(newStatus.getSeverity());
			return msgType;
		}
	}

	/**
	 * A manager for observable within an instance of this validation service.
	 */
	// private ObservablesManager observablesMgr = new ObservablesManager();

	private DataBindingContext ctx = null; // Only one can exist.

	protected final Map<ValidationStatusProvider, IValueChangeListener> valueChangeListeners = Maps
			.newHashMap();

	public ValidationService() {

	}

	/**
	 * A custom {@link MultiValidator} which is initialized with an array of
	 * observables. Typical use, is to feed with the targets of validated bound
	 * {@link WritableValue} observable.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public static abstract class ValidationWithTargetStatusProvider extends
			MultiValidator {

		private final IObservableList targets = new WritableList();

		public void revalidateExternal() {
			super.revalidate();
		}

		/**
		 * The target {@link IObservableList} which can be adapted to resolve a
		 * {@link Control} object.
		 */
		public IObservableList getTargets() {
			IObservableList superTargets = super.getTargets();
			targets.addAll(superTargets); // It's ok to add a collection as a
											// our results content, the
											// downstream methods now how to
											// deal.
			return targets;
		}

		public ValidationWithTargetStatusProvider(IObservable... targets) {
			for (IObservable iObservable : targets) {
				this.targets.add(iObservable);
			}
		}
	}

	/**
	 * Initialize with a {@link ValidationStatusProvider
	 * validationStatusProvider}, any call is delegated to
	 * {@link ValidationService#getMessages(IObservableList, ValueChangeEvent)}
	 * with the provider's targets as argument. (Effectively asking to resolve
	 * {@link Control} from the targets in the {@link ValidationStatusProvider}.
	 * 
	 * @author Christophe Bouhier
	 */
	public class ValueChangeListener implements IValueChangeListener {

		private ValidationStatusProvider provider;

		public ValueChangeListener(ValidationStatusProvider provider) {
			this.provider = provider;
		}

		public void handleValueChange(ValueChangeEvent event) {
			List<IMessage> messages = getMessages(provider.getTargets(), event);
			fireFormValidationEvent(messages);
		}
	};

	/**
	 * Listen to changes in ValidationStatusProviders being added.
	 */
	protected final IListChangeListener listChangeListener = new IListChangeListener() {
		public void handleListChange(ListChangeEvent event) {
			event.diff.accept(new ListDiffVisitor() {
				@Override
				public void handleRemove(int index, Object element) {
					if (element instanceof ValidationStatusProvider) {
						final ValidationStatusProvider observable = (ValidationStatusProvider) element;
						removeValueChangeListener(observable);
					}
				}

				@Override
				public void handleAdd(int index, Object element) {
					if (element instanceof ValidationStatusProvider) {
						final ValidationStatusProvider observable = (ValidationStatusProvider) element;
						addValueChangeListener(observable);
					}
				}
			});
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.observables.IValidationService
	 * #registerBindingContext(org.eclipse.core.databinding.DataBindingContext)
	 */
	public void registerBindingContext(final DataBindingContext ctx) {

		if (this.ctx == null) {
			this.ctx = ctx;
		} else {
			return;
		}

		// Changes to the status providers, are noticed, so we catch any
		// immediate validation.
		ctx.getValidationStatusProviders().addListChangeListener(
				listChangeListener);

		// Listen to changes to any existing ValidationStatusProviders
		for (Object element : ctx.getValidationStatusProviders()) {
			final ValidationStatusProvider observable = (ValidationStatusProvider) element;
			addValueChangeListener(observable);
		}
	}

	protected void removeValueChangeListener(ValidationStatusProvider observable) {
		final IValueChangeListener valueChangeListener = valueChangeListeners
				.get(observable);

		final IObservableValue value = observable.getValidationStatus();
		// value.removeDisposeListener(observableDisposeListener);
		if (valueChangeListener != null) {
			value.removeValueChangeListener(valueChangeListener);
		}

		valueChangeListeners.remove(observable);
	}

	private void addValueChangeListener(ValidationStatusProvider observable) {
		final IObservableValue value = observable.getValidationStatus();
		// value.addDisposeListener(observableDisposeListener);
		ValueChangeListener valueChangeListener = new ValueChangeListener(
				observable);
		value.addValueChangeListener(valueChangeListener);
		valueChangeListeners.put(observable, valueChangeListener);
	}

	public void dispose() {
		if (ctx != null) {
			// Remove notifications of changes to the values
			for (Object element : ctx.getValidationStatusProviders()) {
				final ValidationStatusProvider observable = (ValidationStatusProvider) element;
				removeValueChangeListener(observable);
			}
		}
	}

	/**
	 * Prefabricated strategies.
	 * 
	 * client should consider the impact of installing such a strategy on a
	 * {@link BindingContext}, A before set, on a modelToTarget will not allow
	 * setting the model, if validation not met.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public static class ValueStrategyFactory {

		/**
		 * Get a simple Update value strategy, which will set a status to
		 * warning with the provided message, when the value is an empty
		 * {@link String}, before setting the value.
		 * 
		 * @param validationMessage
		 * @return
		 */
		public EMFUpdateValueStrategy strategyBeforeSetStringNotEmpty(
				final String validationMessage) {
			EMFUpdateValueStrategy strat = new EMFUpdateValueStrategy();
			strat.setBeforeSetValidator(new IValidator() {
				public IStatus validate(Object value) {

					boolean isInvalid = false;
					if (value == null) {
						isInvalid = true;
					} else {
						if (value instanceof String) {
							if (((String) value).length() == 0) {
								isInvalid = true;
							}
						}
					}
					if (isInvalid) {
						return new Status(IStatus.WARNING,
								EditingActivator.PLUGIN_ID,
								validationMessage);
					}
					return Status.OK_STATUS;
				}
			});
			return strat;
		}

		/**
		 * Get an update value strategy, with a custom validator, after getting
		 * the value
		 * 
		 * @param validator
		 * @return
		 */
		public EMFUpdateValueStrategy strategyAfterGet(IValidator validator) {
			EMFUpdateValueStrategy strat = new EMFUpdateValueStrategy();
			strat.setAfterGetValidator(validator);
			return strat;
		}
	}

	/**
	 * Convert from IStatus to IMessage
	 * 
	 * @param sev
	 * @return
	 */
	protected int convertType(int sev) {
		switch (sev) {
		case IStatus.INFO:
			return IMessage.INFORMATION;
		case IStatus.WARNING:
			return IMessage.WARNING;
		case IStatus.ERROR:
			return IMessage.ERROR;
		case IStatus.CANCEL:
			return IMessage.NONE;
		case IStatus.OK:
			return IMessage.NONE;
		}
		return -1;
	}

	/**
	 * Creates {@link IMessage}s from a {@link ValueChangeEvent }. The
	 * {@link Control} is derived from the passed {@link IObservableList }.
	 * </br></br> It could be the control can't be resolved from the provided
	 * observables list, then the {@link IMessageManager} will not be able to a
	 * 
	 * The {@link IMessage} implementation is a {@link MessageFromStatus}, which
	 * wraps the {@link IStatus} from the the event.
	 * 
	 * @param iObservableList
	 * 
	 * @param event
	 * @return a collection of {@link IMessage}.
	 */
	protected List<IMessage> getMessages(IObservableList iObservableList,
			ValueChangeEvent event) {

		List<IMessage> iMessages = new ArrayList<IMessage>();
		Control control = findControl(iObservableList);
		final IStatus newStatus = (IStatus) event.diff.getNewValue();
		final IStatus oldStatus = (IStatus) event.diff.getOldValue();
		iMessages.add(new MessageFromStatus(control, oldStatus, newStatus));
		return iMessages;
	}

	/**
	 * Find a {@link Control} for the target {@link IObservable}. This method is
	 * invoked recursively when the observable is an {@link IObservableList}.
	 * </br></br> Currently supported observables.
	 * <ul>
	 * <li>{@link ISWTObservable}</li>
	 * <li>{@link IViewerObservable}</li>
	 * <li>{@link DateChooserComboObservableValue}</li>
	 * <li>{@link IDecoratingObservable}</li>
	 * <li>{@link IObserving}</li>
	 * </ul>
	 * 
	 * @param target
	 * @return
	 */
	protected Control findControl(IObservable target) {
		if (target instanceof IObservableList) {
			IObservableList list = (IObservableList) target;
			for (int i = 0; i < list.size(); i++) {
				Control control = findControl((IObservable) list.get(i));
				if (control != null)
					return control;
			}
		}

		if (target instanceof ISWTObservable) {
			Widget widget = ((ISWTObservable) target).getWidget();
			if (widget instanceof Control)
				return (Control) widget;
		} else if (target instanceof IViewerObservable) {
			Viewer viewer = ((IViewerObservable) target).getViewer();
			return viewer.getControl();
		} else if (target instanceof DateChooserComboObservableValue) {

			DateChooserComboObservableValue observable = (DateChooserComboObservableValue) target;
			return observable.getDateChooserCombo();
		} else if (target instanceof IDecoratingObservable) {
			IObservable decorated = ((IDecoratingObservable) target)
					.getDecorated();
			Control control = findControl(decorated);
			if (control != null)
				return control;
		} else if (target instanceof IObserving) {
			Object observed = ((IObserving) target).getObserved();
			if (observed instanceof IObservable)
				return findControl((IObservable) observed);
		}

		return null;
	}

	// IValidationListener
	private List<IValidationListener> validationListeners = new ArrayList<IValidationListener>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.observables.IValidationService
	 * #addValidationListener
	 * (com.netxforge.netxstudio.screens.editing.observables
	 * .IValidationListener)
	 */
	public void addValidationListener(IValidationListener listener) {
		if (!validationListeners.contains(listener)) {
			validationListeners.add(listener);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.observables.IValidationService
	 * #removeValidationListener
	 * (com.netxforge.netxstudio.screens.editing.observables
	 * .IValidationListener)
	 */
	public void removeValidationListener(IValidationListener listener) {
		if (validationListeners.contains(listener)) {
			validationListeners.remove(listener);
		}
	}

	protected void fireFormValidationEvent(List<IMessage> messages) {
		for (IValidationListener vl : validationListeners) {
			FormValidationEvent event = new FormValidationEvent(this, messages);
			vl.handleValidationStateChange(event);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.observables.IValidationService
	 * #isValid()
	 */
	public boolean isValid() {
		if (ctx == null)
			return true;

		boolean valid = true;

		for (Object o : ctx.getBindings()) {
			Binding binding = (Binding) o;
			IStatus status = (IStatus) binding.getValidationStatus().getValue();
			if (status.getMessage().length() > 0) {
				if (!status.isOK()) {
					valid = false;
					break;
				}
			}
		}
		return valid;
	}

}
