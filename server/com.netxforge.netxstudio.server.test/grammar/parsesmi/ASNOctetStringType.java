/*
 * ASNOctetString.java
 *
 * Created on 14 January 2005, 14:18
 */

package parsesmi;

/**
 *
 * @author  nigelss
 */
public class ASNOctetStringType extends ASNType {
    
    private ASNConstraint constraint;
    
    /** Creates a new instance of ASNOctetString */
    public ASNOctetStringType() 
    {
        setType (OCTETSTRING);
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
