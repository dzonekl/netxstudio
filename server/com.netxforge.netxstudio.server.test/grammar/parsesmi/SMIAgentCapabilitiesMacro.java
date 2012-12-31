/*
 * SMIAgentCapabilitiesMacro.java
 *
 * Created on 15 January 2005, 08:33
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMIAgentCapabilitiesMacro extends ASNType {
    
    /* Status */
    public final static int CURRENT = 1; 
    public final static int OBSOLETE = 2;
        
    /* Access types */
    public final static int NOTIMPLEMENTED = 1;
    public final static int ACCESSIBLEFORNOTIFY = 2;
    public final static int READONLY = 3;
    public final static int READWRITE = 4;
    public final static int READCREATE = 5;
    public final static int WRITEONLY = 6;

    
    private String productRelease;
    private int status;
    private String description;
    private String reference;
    private List modules;
    
    /** Creates a new instance of SMIAgentCapabilitiesMacro */
    public SMIAgentCapabilitiesMacro() {
        setType (SMIAGENTCAPABILITIESMACRO);
        
        /* Do collections */
        modules = new Vector ();
    }
    
    public void setProductRelease (String p)
    {
        productRelease = p;
    }
    
    public String getProductRelease ()
    {
        return productRelease;
    }
    
    public void setStatus (int s)
    {
        status = s;
    }
    
    public int getStatus ()
    {
        return status;
    }
    
    public void setDescription (String d)
    {
        description = d;
    }
    
    public String getDescription ()
    {
        return description;
    }
    
    public void setReference (String r)
    {
        reference = r;
    }
    
    public String getReference ()
    {
        return reference;
    }
    
    public void setModules (List m)
    {
        modules = m;
    }
    
    public List getModules ()
    {
        return modules;
    }
}
