/*
 * ASNModule.java
 *
 * Created on 13 January 2005, 17:48
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNModule {
    
    private int type;
    private boolean explicitTags;
    private boolean implicitTags;
    private boolean automaticTags;
    private boolean extensibilityImplied;
    private String moduleName;
    private ASNOidComponentList definitiveIdentifier;
    private ASNExports exports;
    private List imports, assignments;
    
    public static final int ASN1 = 1;
    public static final int SMIv1 = 2;
    public static final int SMIv2 = 3;
    public static final int SPPI = 4;
    
    /** Creates a new instance of ASNModule */
    public ASNModule() 
    {
        /* Set the default type to a generic ASN.1 file */
        setType (ASN1);
        
        /* Do collections */
        imports = new Vector ();
        assignments = new Vector ();
    }
    
    public void setType (int t)
    {
        type = t;
    }
    
    public int getType ()
    {
        return type;
    }
    
    public void setExplicitTags (boolean t)
    {
        explicitTags = t;
    }
    
    public boolean getExplicitTags ()
    {
        return explicitTags;
    }

    public void setImplicitTags (boolean t)
    {
        implicitTags = t;
    }
    
    public boolean getImplicitTags ()
    {
        return implicitTags;
    }

    public void setAutomaticTags (boolean t)
    {
        automaticTags = t;
    }
    
    public boolean getAutomaticTags ()
    {
        return automaticTags;
    }
    
    public void setExtensibilityImplied (boolean e)
    {
        extensibilityImplied = e;
    }

    public boolean getExtensibilityImplied ()
    {
        return extensibilityImplied;
    }
    
    public void setModuleName (String i)
    {
        moduleName = i;
    }
    
    public String getModuleName ()
    {
        return moduleName;
    }
    
    public void setDefinitiveIdentifier (ASNOidComponentList l)
    {
        definitiveIdentifier = l;
    }
    
    public ASNOidComponentList getDefinitiveIdentifier ()
    {
        return definitiveIdentifier;
    }
    
    public void setExports (ASNExports e)
    {
        exports = e;
    }
    
    public ASNExports getExports ()
    {
        return exports;
    }
    
    public void setImports (List i)
    {
        imports = i;
    }
    
    public List getImports ()
    {
        return imports;
    }
    
    public void setAssignments (List a)
    {
        assignments = a;
    }
    
    public List getAssignments ()
    {
        return assignments;
    }
}
