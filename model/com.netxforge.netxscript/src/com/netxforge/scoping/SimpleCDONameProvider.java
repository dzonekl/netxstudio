package com.netxforge.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.naming.SimpleNameProvider;

import com.google.inject.Inject;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;

public class SimpleCDONameProvider extends SimpleNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		
		String name = null;

		// TODO, a Nodetype should be identifiable by it's first function name.
		if (obj instanceof Equipment) {
				name = ((Equipment)obj).getEquipmentCode();
		}

		if (obj instanceof NodeType) {
			final NodeType nt = (NodeType) obj;
			if (nt.getFunctions().size() > 0) {
				name = nt.getFunctions().get(0).getName();
			}
		}

		if (obj instanceof NetXResource) {
			final NetXResource r = (NetXResource) obj;
			name = r.getExpressionName();
		}

		if (name != null) {
			return qualifiedNameConverter.toQualifiedName(name);
		}
		
		final QualifiedName qName = super.getFullyQualifiedName(obj);
		if (qName != null) {
			return qName;
		}
		
		return null;
	}

}
