/*
 * SMIType.java
 *
 * Created on 14 January 2005, 16:09
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  nigelss
 */
public class SMIType extends ASNType {
    
    public static final int SMI_BITS = 2;
    public static final int SMI_INTEGER = 3;
    public static final int SMI_OCTETSTRING = 4;
    public static final int SMI_OID = 5;
    public static final int SMI_SUBTYPE = 6;
    
    private int smiType;
    private String subtype;
    private List ranges;
    private boolean sizeConstraint;
    
    /** Creates a new instance of SMIType */
    public SMIType() {
        setType (SMITYPE);
        setSmiType (UNKNOWN);
        
        /* Do collections */
        ranges = new Vector ();
    }
    
    public SMIType (int t)
    {
        setType (SMITYPE);
        setSmiType (t);

        /* Do collections */
        ranges = new Vector ();
    }
    
    public SMIType (String t)
    {
        setType (SMITYPE);
        setSmiType (SMI_SUBTYPE);
        setSubtype (t);

        /* Do collections */
        ranges = new Vector ();
    }
    
    public void setSmiType (int t)
    {
        smiType = t;
    }
    
    public int getSmiType ()
    {
        return smiType;
    }
    
    public void setSubtype (String t)
    {
        subtype = t;
    }
    
    public String getSubtype ()
    {
        return subtype;
    }
    
    public void setRanges (List r)
    {
        ranges = r;
    }
    
    public List getRanges ()
    {
        return ranges;
    }
    
    public void setSizeConstraint (boolean s)
    {
        sizeConstraint = s;
    }
    
    public boolean isSizeConstraint ()
    {
        return sizeConstraint;
    }
}
