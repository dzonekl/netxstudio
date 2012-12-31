/*
 * ASNImports.java
 *
 * Created on 14 January 2005, 11:42
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNImports {
    
    private String name;
    private List symbols;
    private ASNOidComponentList assignedIdentifierOid;
    private ASNDefinedValue assignedIdentifierDefined;
    
    /** Creates a new instance of ASNImports */
    public ASNImports() {
        /* Do collections */
        symbols = new Vector ();
    }
    
    public void setModuleName (String n)
    {
        name = n;
    }
    
    public String getModuleName ()
    {
        return name;
    }
    
    public void setSymbols (List s)
    {
        symbols = s;
    }
    
    public List getSymbols ()
    {
        return symbols;
    }
    
    public void setAssignedIdentifierOid (ASNOidComponentList o)
    {
        assignedIdentifierOid = o;
    }
    
    public ASNOidComponentList getAssignedIdentifierOid ()
    {
        return assignedIdentifierOid;
    }
    
    public void setAssignedIdentifierDefined (ASNDefinedValue d)
    {
        assignedIdentifierDefined = d;
    }
    
    public ASNDefinedValue getAssignedIdentifierDefined ()
    {
        return assignedIdentifierDefined;
    }
    
}
