package com.netxforge.netxstudio.models.export;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.netxforge.netxstudio.models.export.impl.XpandLibraryToHtml;
import com.netxforge.netxstudio.models.export.impl.XpandLibraryToXls;
import com.netxforge.netxstudio.models.export.impl.XpandPackageImport;


/**
 * A template registry. 
 * 
 * @author dzonekl
 *
 */
public class XpandRegistryImpl {

	
	private Map<String, XpandTemplate> templates = new HashMap<String, XpandTemplate>();
	public static final XpandRegistryImpl INSTANCE = new XpandRegistryImpl();
	
	public XpandRegistryImpl(){
		templates.put(XpandLibraryToHtml.XPAND_LIB2HTML, new XpandLibraryToHtml());
		templates.put(XpandPackageImport.XPAND_IMPORT, new XpandPackageImport());
		templates.put(XpandLibraryToXls.XPAND_NETWORKS2XLS, new XpandLibraryToXls());
	}

	public Map<String, XpandTemplate> getTemplates() {
		return templates;
	};
	
	public XpandTemplate getTemplate(String description){
		for( XpandTemplate t : templates.values()){
			if(t.getTemplateDescription().equals(description)){
				return t;
			}
		}
		return null;
	}
	
	
	public String[] getTemplateNames() {
		return templates.keySet().toArray(new String[templates.size()]);
	};
	
	public String[] getTemplateDescriptions() {
		String[] descr = new String[templates.size()];
		List<String> descrList = new ArrayList<String>();
		for( XpandTemplate t : templates.values()){
			descrList.add(t.getTemplateDescription());
		}
		return descrList.toArray(descr);
	};
		
	//  Some way to inject on already registered variable, like the output file name. 
	//  TODO.
//	private static Map<String, Variable> copyGlobalVars(Map<String, Variable> map){
//		for( String key : map.keySet()){
//			Variable var = map.get(key);
//		}
//		return map;
//	}
}
