/*
 * ASNSequenceSetType.java
 *
 * Created on 14 January 2005, 14:25
 */

package parsesmi;

/**
 *
 * @author  nigelss
 */
public class ASNSequenceSetOfType extends ASNType {
    
    public ASNConstraint sizeConstraint;
    public ASNType subtype;
    
    /** Creates a new instance of ASNSequenceSetType */
    public ASNSequenceSetOfType() {
        setType (UNKNOWN);
    }
    
    public ASNSequenceSetOfType(int t) {
        setType (t);
    }
    
    public void setSizeConstraint (ASNConstraint c)
    {
        sizeConstraint = c;
    }
    
    public ASNConstraint getSizeConstraint ()
    {
        return sizeConstraint;
    }
    
    public void setSubtype (ASNType t)
    {
        subtype = t;
    }
    
    public ASNType getSubtype ()
    {
        return subtype;
    }
}
