/*
 * SMIObjectGroupMacro.java
 *
 * Created on 15 January 2005, 07:13
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMIObjectGroupMacro extends ASNType {
    
    public static final int CURRENT = 1;
    public static final int DEPRECATED = 2;
    public static final int OBSOLETE = 3;
    
    
    private List objects;
    private int status;
    private String description;
    private String reference;
    
    /** Creates a new instance of SMIObjectGroupMacro */
    public SMIObjectGroupMacro() {
        setType (SMIOBJECTGROUPMACRO);
        
        /* Do collections */
        objects = new Vector ();
    }
    
    public void setObjects (List o)
    {
        objects = o;
    }
    
    public List getObjects ()
    {
        return objects;
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
