package com.netxforge.netxstudio.models.workflow;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

public class Extension {

	public void print(EEnum num) {
		for (EEnumLiteral lit : num.getELiterals()) {
			System.out.println(lit.getLiteral());
		}
	}

	public List<String> literals(EEnum num) {

		List<String> literals = new ArrayList<String>();
		for (EEnumLiteral lit : num.getELiterals()) {
			literals.add(lit.getName());
		}
		return literals;
	}

	public String htmlEncode(String s) {
		s = StringEscapeUtils.unescapeHtml(s);
		s = StringEscapeUtils.escapeHtml(s);
		s = escapeSpecials(s);
		return s;
	}

	// StringEscapeUtils doesn't deal with CR, while excel will need this. 
	public String escapeSpecials(String s) {
		StringBuffer sb = new StringBuffer();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			switch(c){
			case '\n': sb.append("&#13;");break;
		 	default:  sb.append(c); break;
		}
		}
		return sb.toString();
	}

}
