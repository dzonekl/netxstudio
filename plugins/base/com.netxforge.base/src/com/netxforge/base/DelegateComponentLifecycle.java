/*******************************************************************************
 * Copyright (c) 11 mrt. 2014 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
/*******************************************************************************
 * Copyright (c) 11 mrt. 2014 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.base;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.netxforge.base.IComponentLifecycleListener.LIFE_EVENT;
import com.netxforge.base.IComponentLifecycleListener.LifeEvent;

public class DelegateComponentLifecycle implements IComponentLifecycle,
		IDelegateComponentLifecycle {

	/**
	 * We are not active as default.
	 */
	protected LIFE_EVENT state = LIFE_EVENT.DEACTIVATE;

	/**
	 * Our collection of listeners.
	 */
	protected final List<IComponentLifecycleListener> listeners = Lists
			.newArrayList();

	public void activate(Object source, Object target) {
		if (state == LIFE_EVENT.DEACTIVATE) {
			System.out.println("Activating\n" + target + "\nby:\n"
					+ source);
			state = LIFE_EVENT.ACTIVATE;
			notifyListeners(LIFE_EVENT.ACTIVATE, source, target);
		} else {
			throw new IllegalStateException("Attempt to activate a component "
					+ target + "which is already activated");
		}
	}

	public void deactivate(Object source, Object target) {

		if (state == LIFE_EVENT.ACTIVATE) {
			System.out.println("Deactivating\n:" + target + "\nby:\n"
					+ source);
			state = LIFE_EVENT.DEACTIVATE;
			notifyListeners(LIFE_EVENT.DEACTIVATE, source, target);
		} else {
			throw new IllegalStateException(
					"Attempt to de-activate a component " + target
							+ "which is not active");
		}
	}

	public void activate(Object source) {
		throw new UnsupportedOperationException(
				"Use activate(src,target) instead");
	}

	public void deactivate(Object source) {
		throw new UnsupportedOperationException(
				"Use activate(src,target) instead");
	}

	private void notifyListeners(LIFE_EVENT event, Object source, Object target) {

		// Avoid concurrentmod, by creating a copy.

		ImmutableList<IComponentLifecycleListener> copyOf = ImmutableList
				.copyOf(listeners);

		for (IComponentLifecycleListener l : copyOf) {
			l.lifeEvent(eventFor(event, source, target));
		}
	}

	public void register(Object source) {
		assert source instanceof IComponentLifecycleListener;
		if (!listeners.contains(source)) {
			listeners.add((IComponentLifecycleListener) source);
		}
	}

	public void deregister(Object source) {
		assert source instanceof IComponentLifecycleListener;

		if (listeners.contains(source)) {
			listeners.remove((IComponentLifecycleListener) source);
		}
	}

	public static LifeEvent eventFor(LIFE_EVENT event, Object source,
			Object target) {
		return new LifeEvent(event, source, target);
	}

	public LIFE_EVENT getState() {
		return state;
	}

}
