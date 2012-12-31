/*
 * ASNTypeAssignment.java
 *
 * Created on 14 January 2005, 11:49
 */

package parsesmi;

/**
 *
 * @author  nigelss
 */
public class ASNTypeAssignment extends ASNAssignment {
    
    private ASNType entityType;
    
    /** Creates a new instance of ASNTypeAssignment */
    public ASNTypeAssignment() {
        setType (TYPE);
    }
    
    public void setEntityType (ASNType t)
    {
        entityType = t;
    }
    
    public ASNType getEntityType ()
    {
        return entityType;
    }
    
}
