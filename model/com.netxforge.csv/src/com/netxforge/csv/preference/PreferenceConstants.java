package com.netxforge.csv.preference;

import org.supercsv.prefs.CsvPreference;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {

	public static final String P_DELIMETER = "DELIMITER";
	
	public static final String EXCEL_NORTH_EUROPE_PREFERENCE = "EXCEL_NORTH_EUROPE_PREFERENCE";
	public static final String STANDARD_PREFERENCE = "STANDARD_PREFERENCE";
	public static final String EXCEL_PREFERENCE = "EXCEL_PREFERENCE";
	public static final String NO_COMMENT_PREFERENCE = "NO_COMMENT_PREFERENCE";
	
	public static CsvPreference getPreference(String pref){
		assert pref != null;
		
		if(pref.equals(STANDARD_PREFERENCE)){
			return CsvPreference.STANDARD_PREFERENCE;
		}
		if(pref.equals(EXCEL_PREFERENCE)){
			return CsvPreference.EXCEL_PREFERENCE;
		}
		if(pref.equals(PreferenceConstants.NO_COMMENT_PREFERENCE)){
			return CsvPreference.NO_COMMENT_PREFERENCE;
		}
		if(pref.equals(PreferenceConstants.EXCEL_NORTH_EUROPE_PREFERENCE)){
			return CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE;
		}
		return null;
	}
	
	
}
