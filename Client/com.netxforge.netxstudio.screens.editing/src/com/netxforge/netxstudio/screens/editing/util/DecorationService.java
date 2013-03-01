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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.jface.databinding.swt.ISWTObservable;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IMessage;

import com.netxforge.netxstudio.screens.common.internal.ScreensCommonActivator;
import com.netxforge.netxstudio.screens.editing.util.IDecorationService;

/**
 * Can register a
 * decorator on controls, which will be notified when matching the observable
 * controls of the binding context.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class DecorationService implements IDecorationService {

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
		private final IStatus status;

		private MessageFromStatus(Control control, IStatus status) {
			this.control = control;
			this.status = status;
		}

		public Control getControl() {
			return control;
		}

		public Object getData() {
			return null;
		}

		public Object getKey() {
			return new Integer(this.hashCode());
		}

		public String getPrefix() {
			return null;
		}

		/**
		 * Resolves the message from {@link IStatus}
		 */
		public String getMessage() {
			return status.getMessage();
		}

		/**
		 * Resolves the the message type from {@link IStatus}
		 */
		public int getMessageType() {
			if (msgType == -1)
				msgType = convertType(status.getSeverity());
			return msgType;
		}
	}

	/**
	 * A manager for observable within an instance of this validation service.
	 */
	private ObservablesManager observablesMgr = new ObservablesManager();
	private DataBindingContext ctx = null; // Only one can exist.

	public DecorationService() {
		// this.observablesMgr = observablesMgr;
	}

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

		AggregateValidationStatus aggregateStatus = new AggregateValidationStatus(
				ctx.getValidationStatusProviders(),
				AggregateValidationStatus.MAX_SEVERITY);

		aggregateStatus.addValueChangeListener(new IValueChangeListener() {
			public void handleValueChange(ValueChangeEvent event) {
				// Get the severity type, converted for the new status.
				List<IMessage> messages = getMessages(event);
				fireFormValidationEvent(messages);
			}
		});

		// Deprecated, use the MessageManager to do the decoration, do not use
		// our own
		// control registry! See the Validation
		aggregateStatus.addChangeListener(new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				// Loop through the bindings.
				for (Object o : ctx.getBindings()) {
					Binding binding = (Binding) o;
					IStatus status = (IStatus) binding.getValidationStatus()
							.getValue();
					Control control = null;

					// Note updating targets for writables, will not work here.
					if (binding.getTarget() instanceof ISWTObservable) {
						ISWTObservable swtObservable = (ISWTObservable) binding
								.getTarget();
						control = (Control) swtObservable.getWidget();
					}
					if (binding.getTarget() instanceof WritableValue) {
						// FIXME We can't determine control for writables.
					}
					ControlDecoration decoration = getDecoration(control);
					if (decoration != null) {
						if (status.isOK()) {
							decoration.hide();
						} else {
							decoration.setDescriptionText(status.getMessage());
							decoration.show();
						}
					} else {
						System.out
								.println("Error: Decorator not set for control:"
										+ control);
					}
				}
			}

		});

		observablesMgr.addObservable(aggregateStatus);
	}

	public void dispose() {
		// Should remove observabled, otherwise will still fire.
		observablesMgr.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.observables.IValidationService
	 * #getAttributeStrategy(java.lang.String)
	 */
	public EMFUpdateValueStrategy getUpdateValueStrategyBeforeSet(
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
							ScreensCommonActivator.PLUGIN_ID, validationMessage);
				}
				return Status.OK_STATUS;
			}
		});
		return strat;
	}

	public EMFUpdateValueStrategy getUpdateValueStrategyAfterGet(
			IValidator validator) {
		EMFUpdateValueStrategy strat = new EMFUpdateValueStrategy();
		strat.setAfterGetValidator(validator);
		return strat;
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
	 * Get all IMessages for this context.
	 * 
	 * @deprecated
	 * @param ctx
	 * @return
	 */
	protected List<IMessage> getMessages(DataBindingContext ctx) {

		// Iterate over the messages.
		List<IMessage> iMessages = new ArrayList<IMessage>();

		for (Object o : ctx.getBindings()) {
			Binding binding = (Binding) o;
			final IStatus status = (IStatus) binding.getValidationStatus()
					.getValue();

			Control control = null;
			if (binding.getTarget() instanceof ISWTObservable) {
				ISWTObservable swtObservable = (ISWTObservable) binding
						.getTarget();
				control = (Control) swtObservable.getWidget();
			} else {
				if (binding.getTarget() instanceof DateChooserComboObservableValue) {
					DateChooserComboObservableValue dcObverable = (DateChooserComboObservableValue) binding
							.getTarget();
					control = dcObverable.combo;
				}
				System.out.println(binding.getTarget().toString());

			}
			// if (!status.isOK()) {
			System.out.println("Creating message" + status.toString());
			iMessages.add(new MessageFromStatus(control, status));
			// CB Let MessageManager do the deoration.
			// ControlDecoration decoration
			// = decoratorMap.get(control);
			// if (decoration != null) {
			// if (status.isOK()) {
			// decoration.hide();
			// } else {
			// decoration
			// .setDescriptionText(status.getMessage());
			// decoration.show();
			// }
			// }
			// }
		}
		// Iterator<?> it = ctx.getValidationStatusProviders().iterator();
		// while (it.hasNext()) {
		// ValidationStatusProvider validationStatusProvider =
		// (ValidationStatusProvider) it
		// .next();
		// final IStatus status = (IStatus) validationStatusProvider
		// .getValidationStatus().getValue();
		//
		// if (!status.isOK()) {
		// iMessages.add(new IMessage() {
		// public Control getControl() {
		// return null;
		// }
		//
		// public Object getData() {
		// return null;
		// }
		//
		// public Object getKey() {
		// return null;
		// }
		//
		// public String getPrefix() {
		// return null;
		// }
		//
		// public String getMessage() {
		// return status.getMessage();
		// }
		//
		// public int getMessageType() {
		// return convertType(status.getSeverity());
		// }
		// });
		// }
		// }
		return iMessages;
	}

	/**
	 * Creates {@link IMessage}s from a {@link ValueChangeEvent }. The
	 * {@link Control} is derived from the the {@link IObservableValue } which is
	 * part of the event. </br></br> Currently supported observables:
	 * <ul>
	 * <li>{@link ISWTObservable}</li>
	 * <li>{@link DateChooserComboObservableValue}</li>
	 * </ul>
	 * The {@link IMessage} implementation is a {@link MessageFromStatus}, which
	 * wraps the {@link IStatus} from the the event.
	 * 
	 * @param event
	 * @return a collection of {@link IMessage}.
	 */
	protected List<IMessage> getMessages(ValueChangeEvent event) {
		// Iterate over the messages.
		List<IMessage> iMessages = new ArrayList<IMessage>();

		if (event.diff.getNewValue() instanceof IStatus) {
			IStatus status = (IStatus) event.diff.getNewValue();

			IObservableValue observableValue = event.getObservableValue();

			Control control = null;
			if (observableValue instanceof ISWTObservable) {
				ISWTObservable swtObservable = (ISWTObservable) observableValue;
				control = (Control) swtObservable.getWidget();
			} else {
				if (observableValue instanceof DateChooserComboObservableValue) {
					DateChooserComboObservableValue dcObverable = (DateChooserComboObservableValue) observableValue;
					control = dcObverable.combo;
				}
			}
			iMessages.add(new MessageFromStatus(control, status));
		}
		return iMessages;
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

	public ControlDecoration getErrorDecoration(Control control) {
		ControlDecoration deco = new ControlDecoration(control, SWT.LEFT
				| SWT.CENTER);
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
		deco.setImage(fieldDecoration.getImage());
		deco.hide();
		return deco;
	}

	public ControlDecoration getWarningDecoration(Control control) {
		ControlDecoration deco = new ControlDecoration(control, SWT.LEFT
				| SWT.CENTER);
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_WARNING);
		deco.setImage(fieldDecoration.getImage());
		deco.hide();
		return deco;
	}

	public ControlDecoration getRequiredDecoration(Control control) {
		ControlDecoration deco = new ControlDecoration(control, SWT.LEFT
				| SWT.CENTER);
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED);
		deco.setImage(fieldDecoration.getImage());
		deco.hide();
		return deco;
	}

	Map<Control, ControlDecoration> errorDecorationMap = new HashMap<Control, ControlDecoration>();
	Map<Control, ControlDecoration> warningDecorationMap = new HashMap<Control, ControlDecoration>();
	Map<Control, ControlDecoration> requiredDecorationMap = new HashMap<Control, ControlDecoration>();

	public void registerErrorDecorator(Control targetControl,
			Control decoratorControl) {
		errorDecorationMap.put(targetControl,
				getErrorDecoration(decoratorControl));
	}

	public void registerWarningDecorator(Control targetControl,
			Control decoratorControl) {
		warningDecorationMap.put(targetControl,
				getWarningDecoration(decoratorControl));
	}

	public void registerRequiredDecorator(Control targetControl,
			Control decoratorControl) {
		requiredDecorationMap.put(targetControl,
				getRequiredDecoration(decoratorControl));
	}

	// TODO implement for all maps.
	private ControlDecoration getDecoration(Control control) {
		return requiredDecorationMap.get(control);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.observables.IValidationService
	 * #registerAllDecorators(org.eclipse.swt.widgets.Control,
	 * org.eclipse.swt.widgets.Control)
	 */
	public void registerAllDecorators(Control control, Control decoratorControl) {
		this.registerRequiredDecorator(control, decoratorControl);
		this.registerWarningDecorator(control, decoratorControl);
		this.registerErrorDecorator(control, decoratorControl);
	}

	public boolean canProceed() {
		return false;
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
