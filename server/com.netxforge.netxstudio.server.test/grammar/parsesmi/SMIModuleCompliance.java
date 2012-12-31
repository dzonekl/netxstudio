/*
 * SMIModuleCompliance.java
 *
 * Created on 15 January 2005, 08:02
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMIModuleCompliance {

    private String moduleName;
    private ASNValue value;
    private List mandatoryGroups;
    private List compliances;
    
    /** Creates a new instance of SMIModuleCompliance */
    public SMIModuleCompliance() {
        /* Do collections */
        mandatoryGroups = new Vector ();
        compliances = new Vector ();
    }
    
    public void setModuleName (String n)
    {
        moduleName = n;
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
    
    public void setMandatoryGroups (List m)
    {
        mandatoryGroups = m;
    }
    
    public List getMandatoryGroups ()
    {
        return mandatoryGroups;
    }
    
    public void setCompliances (List c)
    {
        compliances = c;
    }
    
    public List getCompliances ()
    {
        return compliances;
    }
    
}
