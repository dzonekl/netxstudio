/*
 * SMIModuleComplianceMacro.java
 *
 * Created on 15 January 2005, 07:58
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  nigelss
 */
public class SMIModuleComplianceMacro extends ASNType {

    /* MIB access */
    public final static int NOTACCESSIBLE = 1;
    public final static int ACCESSIBLEFORNOTIFY = 2;
    public final static int READONLY = 3;
    public final static int READWRITE = 4;
    public final static int READCREATE = 5;

    /* PIB access */
    //public final static int NOTACCESSIBLE = 1;
    public final static int INSTALL = 2;
    public final static int NOTIFY = 3;
    public final static int INSTALLNOTIFY = 4;
    public final static int REPORTONLY = 5;

    /* Status */
    public final static int CURRENT = 1;  
    public final static int DEPRECATED = 2;
    public final static int OBSOLETE = 3;

    private int status;
    private String description;
    private String reference;
    private List modules;
    
    /** Creates a new instance of SMIModuleComplianceMacro */
    public SMIModuleComplianceMacro() {
        setType (SMIMODULECOMPLIANCEMACRO);
        
        /* Do collection */
        modules = new Vector ();
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
