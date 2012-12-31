/*
 * SMICompliance.java
 *
 * Created on 15 January 2005, 08:06
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMICompliance {
    
    public final static int GROUP = 1;
    public final static int OBJECT = 2;
    
    private int complianceType;
    private ASNValue group;
    private ASNValue object;
    private String description;
    private SMISyntax syntax;
    private SMISyntax writeSyntax;
    private int mibMinAccess;
    private int pibMinAccess;
    
    /** Creates a new instance of SMICompliance */
    public SMICompliance() {
    }
    
    public void setComplianceType (int t)
    {
        complianceType = t;
    }
    
    public int getComplianceType ()
    {
        return complianceType;
    }
    
    public void setGroup (ASNValue v)
    {
        group = v;
    }
    
    public ASNValue getGroup ()
    {
        return group;
    }
    
    public void setObject (ASNValue v)
    {
        object = v;
    }
    
    public ASNValue getObject ()
    {
        return object;
    }
    
    public void setDescription (String d)
    {
        description = d;
    }
    
    public String getDescription ()
    {
        return description;
    }
    
    public void setSyntax (SMISyntax s)
    {
        syntax = s;
    }
    
    public SMISyntax getSyntax ()
    {
        return syntax;
    }
    
    public void setWriteSyntax (SMISyntax s)
    {
        writeSyntax = s;
    }
    
    public SMISyntax getWriteSyntax ()
    {
        return writeSyntax;
    }
    
    public void setMinAccess (int a)
    {
        mibMinAccess = a;
    }
    
    public int getMinAccess ()
    {
        return mibMinAccess;
    }
        
    public void setPibMinAccess (int a)
    {
        pibMinAccess = a;
    }
    
    public int getPibMinAccess ()
    {
        return pibMinAccess;
    }
}
