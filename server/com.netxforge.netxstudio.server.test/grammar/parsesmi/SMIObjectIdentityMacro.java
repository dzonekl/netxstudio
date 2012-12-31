/*
 * SMIObjectIdentityMacro.java
 *
 * Created on 14 January 2005, 23:00
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMIObjectIdentityMacro extends ASNType {
    
    /* Status types */
    public static final int CURRENT = 1; 
    public static final int DEPRECATED = 2; 
    public static final int OBSOLETE = 3; 
        
    private int status;
    private String description;
    private String reference;
    
    /** Creates a new instance of SMIObjectIdentityMacro */
    public SMIObjectIdentityMacro() {
        setType (SMIOBJECTIDENTITYMACRO);
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
    
}
