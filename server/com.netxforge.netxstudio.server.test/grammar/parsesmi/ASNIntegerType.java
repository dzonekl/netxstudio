/*
 * ASNIntegerType.java
 *
 * Created on 14 January 2005, 14:14
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNIntegerType extends ASNType {
    
    private List namedNumberList;
    private ASNConstraint constraint;
    
    /** Creates a new instance of ASNIntegerType */
    public ASNIntegerType() {
        setType (INTEGER);
    }
    
    public void setNamedNumberList (List n)
    {
        namedNumberList = n;
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
