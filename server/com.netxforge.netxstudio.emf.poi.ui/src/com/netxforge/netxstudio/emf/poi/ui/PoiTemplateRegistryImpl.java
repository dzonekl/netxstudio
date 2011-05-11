package com.netxforge.netxstudio.emf.poi.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A template registry. 
 * 
 * @author dzonekl
 *
 */
public class PoiTemplateRegistryImpl {

	
	private Map<String, PoiTemplate> templates = new HashMap<String, PoiTemplate>();
	public static final PoiTemplateRegistryImpl INSTANCE = new PoiTemplateRegistryImpl();
	
	public PoiTemplateRegistryImpl(){
		templates.put(Messages.PoiTemplateRegistryImpl_0, new PoiTemplate(){

			@Override
			public String getTemplateDescription() {
				return Messages.PoiTemplateRegistryImpl_1;
			}
			
		});
	}

	public Map<String, PoiTemplate> getTemplates() {
		return templates;
	};
	
	public PoiTemplate getTemplate(String description){
		for( PoiTemplate t : templates.values()){
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
		for( PoiTemplate t : templates.values()){
			descrList.add(t.getTemplateDescription());
		}
		return descrList.toArray(descr);
	};
}
