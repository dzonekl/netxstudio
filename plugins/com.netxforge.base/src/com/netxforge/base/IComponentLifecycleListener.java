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

public interface IComponentLifecycleListener {

	public enum LIFE_EVENT {
		ACTIVATE, DEACTIVATE
	}

	/**
	 * A Lifecycle event
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public static class LifeEvent {

		private LIFE_EVENT event;

		/**
		 * The target requesting the event.
		 */
		private Object target;

		/**
		 * The source requesting the event.
		 */
		private Object source;

		public LifeEvent(LIFE_EVENT event, Object source, Object target) {
			this.event = event;
			this.source = source;
			this.target = target;
		}

		public LIFE_EVENT getEvent() {
			return event;
		}

		public void setEvent(LIFE_EVENT event) {
			this.event = event;
		}

		public Object getTarget() {
			return target;
		}

		public void setTarget(Object source) {
			this.target = source;
		}

		public Object getSource() {
			return source;
		}
	}

	public void lifeEvent(LifeEvent event);

}
