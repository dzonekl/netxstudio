package com.netxforge.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.naming.SimpleNameProvider;

import com.google.inject.Inject;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.NodeType;

public class SimpleCDONameProvider extends SimpleNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		
		String name = null;

		if (obj instanceof Equipment) {
				name = ((Equipment)obj).getEquipmentCode();
		}

		if (obj instanceof NodeType) {
			final NodeType nt = (NodeType) obj;
			name = nt.getName();
		}

		if (obj instanceof BaseResource) {
			final BaseResource r = (BaseResource) obj;
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
