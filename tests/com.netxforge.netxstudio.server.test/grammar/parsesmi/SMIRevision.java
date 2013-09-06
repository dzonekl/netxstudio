/*
 * SMIRevision.java
 *
 * Created on 14 January 2005, 22:54
 */

package parsesmi;

/**
 *
 * @author  nigelss
 */
public class SMIRevision {
    
    private String revision;
    private String description;
    
    /** Creates a new instance of SMIRevision */
    public SMIRevision() {
    }
    
    public void setRevision (String r)
    {
        revision = r;
    }
    
    public String getRevision ()
    {
        return revision;
    }
    
    public void setDescription (String d)
    {
        description = d;
    }
    
    public String getDescription ()
    {
        return description;
    }
    
}
