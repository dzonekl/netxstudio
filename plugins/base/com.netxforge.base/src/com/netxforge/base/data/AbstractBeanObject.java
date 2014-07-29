/*******************************************************************************
 * Copyright (c) 7 mrt. 2014 NetXForge.
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
package com.netxforge.base.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractBeanObject implements IBeanObject {

	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(
			this);

	/* (non-Javadoc)
	 * @see com.netxforge.base.data.IBeanObject#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	/* (non-Javadoc)
	 * @see com.netxforge.base.data.IBeanObject#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	/* (non-Javadoc)
	 * @see com.netxforge.base.data.IBeanObject#addPropertyChangeListener(java.lang.String, java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(propertyName, listener);
	}

	/* (non-Javadoc)
	 * @see com.netxforge.base.data.IBeanObject#removePropertyChangeListener(java.lang.String, java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(propertyName, listener);
	}

	protected void firePropertyChange(String propertyName, Object oldValue,
			Object newValue) {
		changeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}
}
