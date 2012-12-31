/*
 * ASNValueAssignment.java
 *
 * Created on 14 January 2005, 11:50
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNValueAssignment extends ASNAssignment {
    
    private ASNType entityType;
    private ASNValue value;

    /** Creates a new instance of ASNValueAssignment */
    public ASNValueAssignment() {
        setType (VALUE);
    }
    
    public void setEntityType (ASNType t)
    {
        entityType = t;
    }
    
    public ASNType getEntityType ()
    {
        return entityType;
    }
    
    public void setValue (ASNValue v)
    {
        value = v;
    }
    
    public ASNValue getValue ()
    {
        return value;
    }
    
}
