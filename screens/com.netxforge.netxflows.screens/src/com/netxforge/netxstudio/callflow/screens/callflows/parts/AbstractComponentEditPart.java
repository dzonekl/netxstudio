/*******************************************************************************
 * Copyright (c) 24 apr. 2013 NetXForge.
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
package com.netxforge.netxstudio.callflow.screens.callflows.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.callflow.screens.callflows.model.ComponentToComponent;
import com.netxforge.netxstudio.callflow.screens.callflows.model.NodeTypeToServiceRelationships;
import com.netxforge.netxstudio.library.Component;

/**
 * Base connection EditPart for connecting components.
 * 
 * @author Christophe Bouhier
 */
public abstract class AbstractComponentEditPart extends AbstractLibraryEditPart {

	public AbstractComponentEditPart() {
		super();
	}

	public Component getComponent() {
		return (Component) getModel();
	}

	@Override
	protected IFigure createFigure() {
		return null;
	}

	@Override
	protected void createEditPolicies() {

	}

	private final List<NodeTypeToServiceRelationships> modelTargetConnections = Lists
			.newArrayList();

	List<ComponentToComponent> modelSourceComponentConnections;

	private final List<ComponentToComponent> modelTargetComponentConnections = Lists
			.newArrayList();

	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelTargetConnections() {
		return modelTargetConnections;
	}

	public boolean addNodeTypeToComponentTargetConnection(
			NodeTypeToComponentEditPart part) {
		NodeTypeToServiceRelationships nttc = part.getNodeTypeToComponent();
		if (!nttc.getTarget().equals(this.getComponent())) {
			return false;
		}
		this.modelTargetConnections.add(nttc);
		this.addTargetConnection(part, 0);
		return true;
	}

	public boolean removeNodeTypeToComponentTargetConnection(
			NodeTypeToComponentEditPart part) {
		if (!modelTargetConnections.remove(part.getModel())) {
			return false;
		}
		this.removeTargetConnection(part);
		return true;
	}

	public boolean addComponentToComponentTargetConnection(
			ComponentToComponentEditPart part) {
		ComponentToComponent ctc = part.getComponentToComponent();
		if (!ctc.getTarget().equals(this.getComponent())) {
			return false;
		}
		this.modelTargetComponentConnections.add(ctc);
		this.addTargetConnection(part, 0);
		return true;
	}

	public boolean removeComponentToComponentTargetConnection(
			ComponentToComponentEditPart part) {
		if (!modelTargetComponentConnections.remove(part.getModel())) {
			return false;
		}
		this.removeTargetConnection(part);
		return true;
	}

	public void populateConnectionModel() {
		modelSourceComponentConnections = Lists.newArrayList();
		Component c = this.getComponent();

		List<EObject> it = c.eContents();
		for (EObject o : it) {
			if (o instanceof Component) {
				modelSourceComponentConnections.add(new ComponentToComponent(c,
						(Component) o));
			}
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected List getModelSourceConnections() {
		return modelSourceComponentConnections;
	}

}
