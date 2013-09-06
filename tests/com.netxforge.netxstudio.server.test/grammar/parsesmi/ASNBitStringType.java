/*
 * ASNBitStringType.java
 *
 * Created on 14 January 2005, 13:50
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNBitStringType extends ASNType {
    
    private List namedNumberList;
    private ASNConstraint constraint;
    
    /** Creates a new instance of ASNBitStringType */
    public ASNBitStringType() {
        setType (BITSTRING);
        
        /* Do Collections */
        namedNumberList = new Vector ();
    }
    
    public void setNamedNumberList (List l)
    {
        namedNumberList = l;
    }
    
    public List getNamedNumberList ()
    {
        return namedNumberList;
    }
    
    public void setConstraint (ASNConstraint c)
    {
        constraint = c;
    }
    
    public ASNConstraint getConstraint ()
    {
        return constraint;
    }
    
}
