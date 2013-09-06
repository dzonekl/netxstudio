/*
 * SMIModuleIdentityMacro.java
 *
 * Created on 14 January 2005, 22:36
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMIModuleIdentityMacro extends ASNType {
    
    private SMICategories categories;
    private String lastUpdated;
    private String organization;
    private String contactInfo;
    private String description;
    private List revisions;
    
    /** Creates a new instance of SMIModuleIdentityMacro */
    public SMIModuleIdentityMacro() {
        setType (SMIMODULEIDENTITYMACRO);
        
        /* Do collections */
        revisions = new Vector ();
    }
    
    public void setCategories (SMICategories c)
    {
        categories = c;
    }
    
    public SMICategories getCategories ()
    {
        return categories;
    }
    
    public void setLastUpdated (String l)
    {
        lastUpdated = l;
    }
    
    public String getLastUpdated ()
    {
        return lastUpdated;
    }
    
    public void setOrganization (String o)
    {
        organization = o;
    }
    
    public String getOrganization ()
    {
        return organization;
    }
    
    public void setContactInfo (String c)
    {
        contactInfo = c;
    }
    
    public String getContactInfo ()
    {
        return contactInfo;
    }
    
    public void setDescription (String d)
    {
        description = d;
    }
    
    public String getDescription ()
    {
        return description;
    }
    
    public void setRevisions (List r)
    {
        revisions = r;
    }
    
    public List getRevisions ()
    {
        return revisions;
    }
    
}
