/*
 * SMINotificationTypeMacro.java
 *
 * Created on 14 January 2005, 23:06
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMINotificationTypeMacro extends ASNType {

    public static final int CURRENT = 1;  
    public static final int DEPRECATED = 2;
    public static final int OBSOLETE = 3;

    private List objects;
    private int status;
    private String description;
    private String reference;
    
    /** Creates a new instance of SMINotificationTypeMacro */
    public SMINotificationTypeMacro() {
        setType (SMINOTIFICATIONTYPEMACRO);
        
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
    
    public void setReference (String r)
    {
        reference = r;
    }
    
}
