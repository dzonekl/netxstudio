/*******************************************************************************
 * Copyright (c) 2005 - 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.mwe.internal.core.debug.processing.handlers;

import java.io.IOException;
import java.util.Stack;

import org.eclipse.emf.mwe.core.debug.model.SyntaxElement;
import org.eclipse.emf.mwe.core.debug.processing.ElementAdapter;
import org.eclipse.emf.mwe.core.debug.processing.EventHandler;
import org.eclipse.emf.mwe.internal.core.debug.communication.Connection;
import org.eclipse.emf.mwe.internal.core.debug.communication.packages.ConfirmationPackage;
import org.eclipse.emf.mwe.internal.core.debug.communication.packages.EventPackage;
import org.eclipse.emf.mwe.internal.core.debug.communication.packages.EventPackageWithFrames;
import org.eclipse.emf.mwe.internal.core.debug.processing.DebugMonitor;
import org.eclipse.emf.mwe.internal.core.debug.processing.RuntimeHandler;

/**
 * This class handles the communication of debug events on the runtime side.<br>
 * It sends them out (together with addition syntax element information, if
 * required).
 */
public class EventRuntimeHandler implements RuntimeHandler, EventHandler {
	public static final int STARTED = 1;

	public static final int SUSPENDED = 2;

	public static final int RESUMED = 3;

	public static final int TERMINATED = 4;

	private Connection connection;

	private DebugMonitor monitor;

	private final Stack<Frame> stackFrames = new Stack<Frame>();

	private int cleanStackLevel = 0;

	// -------------------------------------------------------------------------

	/**
	 * @see org.eclipse.emf.mwe.internal.core.debug.processing.RuntimeHandler#init(org.eclipse.emf.mwe.internal.core.debug.processing.DebugMonitor,
	 *      org.eclipse.emf.mwe.internal.core.debug.communication.Connection)
	 */
	public void init(final DebugMonitor monitor, final Connection connection) {
		this.monitor = monitor;
		this.connection = connection;
		monitor.addEventHandler(this);
	}

	/**
	 * no need to listen
	 * 
	 * @see org.eclipse.emf.mwe.internal.core.debug.processing.RuntimeHandler#startListener()
	 */
	public void startListener() {
	}

	// -------------------------------------------------------------------------

	/**
	 * Send STARTED event to the debug server
	 * 
	 * @see org.eclipse.emf.mwe.internal.core.debug.processing.EventHandler#started()
	 */
	public void started() throws IOException {
		sendEvent(STARTED);
	}

	/**
	 * Push the element onto the stack
	 * 
	 * @see org.eclipse.emf.mwe.internal.core.debug.processing.EventHandler#preTask(java.lang.Object,
	 *      int)
	 */
	public void preTask(final Object element, final Object context, final int state) {
		stackFrames.push(new Frame(element, context, state));
	}

	/**
	 * Pop the element from the stack, adjust the cleanStackLevel value if
	 * required
	 * 
	 * @see org.eclipse.emf.mwe.internal.core.debug.processing.EventHandler#postTask()
	 */
	public void postTask(final Object context) {
		if (cleanStackLevel >= stackFrames.size()) {
			cleanStackLevel--;
		}
		stackFrames.pop();
	}

	/**
	 * Send SUSPENDED event to the debug server together with the number of
	 * stack elements that are still the same (cleanStackLevel) since the last
	 * suspend and all new SyntaxElements.<br>
	 * Wait for a confirmation. In the meantime other threads could handle for
	 * instance variable requests.
	 * 
	 * @see org.eclipse.emf.mwe.internal.core.debug.processing.EventHandler#suspended()
	 */
	public void suspended() throws IOException {
		EventPackageWithFrames event = new EventPackageWithFrames(SUSPENDED);
		event.cleanStackLevel = cleanStackLevel;

		for (int i = cleanStackLevel; i < stackFrames.size(); i++) {
			Frame frame = stackFrames.get(i);
			SyntaxElement to;
			ElementAdapter adapter = monitor.getAdapter(frame.element);
			adapter.setContext(frame.context);
			if (frame.state == NORMAL_FRAME) {
				to = adapter.createElement(frame.element);
			}
			else {
				to = adapter.createEndElementTO(frame.element);
			}
			to.type = adapter.getAdapterType();
			to.frameId = i;
			event.frames.add(to);

		}

		sendAndConfirm(event);
		cleanStackLevel = stackFrames.size();
	}

	/**
	 * Send RESUMED event to the debug server
	 * 
	 * @see org.eclipse.emf.mwe.internal.core.debug.processing.EventHandler#resumed()
	 */
	public void resumed() throws IOException {
		sendEvent(RESUMED);
	}

	/**
	 * Send TERMINATED event to the debug server
	 * 
	 * @see org.eclipse.emf.mwe.internal.core.debug.processing.EventHandler#terminated()
	 */
	public void terminated() throws IOException {
		sendEvent(TERMINATED);
	}

	// -------------------------------------------------------------------------

	private void sendEvent(final int type) throws IOException {
		EventPackage event = new EventPackage(type);
		sendAndConfirm(event);
	}

	private void sendAndConfirm(final EventPackage event) throws IOException {
		int refId = connection.sendPackage(event);
		connection.listenForPackage(ConfirmationPackage.class, refId);
	}

	// -------------------------------------------------------------------------
	private class Frame {
		final Object element;

		final int state;

		final Object context;

		private Frame(final Object element, final Object context, final int state) {
			this.element = element;
			this.context = context;
			this.state = state;
		}
	}

}
