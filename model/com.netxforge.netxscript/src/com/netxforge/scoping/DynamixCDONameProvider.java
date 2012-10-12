package com.netxforge.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.naming.SimpleNameProvider;

import com.google.inject.Inject;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Parameter;


/**
 * Names as they will appear in the editor. 
 * @author Christophe Bouhier
 *
 */
public class DynamixCDONameProvider extends SimpleNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {

		String name = null;

		if (obj instanceof Equipment) {
			// Name as presented is equal to the presentation (label) in the tree view.
			Equipment eq = (Equipment) obj; 
			name = eq.getEquipmentCode();
			if( eq.eIsSet(LibraryPackage.Literals.COMPONENT__NAME)){
				name += "__" + eq.getName();
			}
		}

		if (obj instanceof Parameter) {
			name = ((Parameter) obj).getExpressionName();
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
