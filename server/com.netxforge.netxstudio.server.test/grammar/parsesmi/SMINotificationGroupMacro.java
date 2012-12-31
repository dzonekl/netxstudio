/*
 * SMINotificationGroupMacro.java
 *
 * Created on 15 January 2005, 07:25
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMINotificationGroupMacro extends ASNType {
    
    public final static int CURRENT = 1; 
    public final static int DEPRECATED = 2;
    public final static int OBSOLETE = 3;
        
    private List notifications;
    private int status;
    private String description;
    private String reference;
    
    /** Creates a new instance of SMINotificationGroupMacro */
    public SMINotificationGroupMacro() {
        setType (SMINOTIFICATIONGROUPMACRO);
        
        /* Do collections */
        notifications = new Vector ();
    }
    
    public void setNotifications (List n)
    {
        notifications = n;
    }
    
    public List getNotifications ()
    {
        return notifications;
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
