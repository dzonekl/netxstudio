/*
 * SMIAgentCapabilitiesModule.java
 *
 * Created on 15 January 2005, 08:41
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMIAgentCapabilitiesModule {
    
    private String moduleName;
    private ASNValue value;
    private List includes;
    private List variations;
    
    /** Creates a new instance of SMIAgentCapabilitiesModule */
    public SMIAgentCapabilitiesModule() {
        /* Do collections */
        includes = new Vector ();
        variations = new Vector ();
    }
    
    public void setModuleName (String m)
    {
        moduleName = m;
    }
    
    public String getModuleName ()
    {
        return moduleName;
    }
        
    public void setValue (ASNValue v)
    {
        value = v;
    }
    
    public ASNValue getValue ()
    {
        return value;
    }
    
    public void setIncludes (List i)
    {
        includes = i;
    }
    
    public List getIncludes ()
    {
        return includes;
    }
    
    public void setVariations (List v)
    {
        variations = v;
    }
    
    public List getVariations ()
    {
        return variations;
    }
    
}
