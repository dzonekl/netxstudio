package com.netxforge.netxstudio.screens.editing.actions;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.operators.Node;

public class MoveToWarehouseAction extends Action {
	static String ACTION_TEXT = "Decommission";
	private IStructuredSelection selection;
	private Collection<EObject> destination;
	private EditingDomain domain;

	public MoveToWarehouseAction(Collection<EObject> warehouses, EditingDomain domain) {
		super(ACTION_TEXT);
		this.destination = warehouses;
		this.domain = domain;
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}

	public void setSelection(IStructuredSelection ss) {
		this.selection = ss;
	}

	@Override
	public void run() {
		if (selection != null && domain != null && destination != null) {
			Collection<Object> selectionList = this.getTarget();
			Collection<Object> toDecommission = Lists.newArrayList();
			for (Object o : selectionList) {
				if (o instanceof Equipment || o instanceof Node) {
					toDecommission.add(o);
				}
			}
			if (toDecommission.size() > 0) {
				EObject warehouse = destination.iterator().next();
				Command c = new AddCommand(domain, warehouse, null, toDecommission);
				domain.getCommandStack().execute(c);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private List<Object> getTarget() {
		return selection.toList();
	}
}
