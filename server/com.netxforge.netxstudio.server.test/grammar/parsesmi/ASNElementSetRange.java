/*
 * ASNElementSetRange.java
 *
 * Created on 15 January 2005, 10:32
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNElementSetRange {
    
    public ASNConstraintElement leftElement;
    public ASNConstraintElement rightElement;
    public boolean ellipsis;
    
    /** Creates a new instance of ASNElementSetRange */
    public ASNElementSetRange() {
    }
    
    public void setLeftElement (ASNConstraintElement e)
    {
        leftElement = e;
    }
    
    public ASNConstraintElement getLeftElement ()
    {
        return leftElement;
    }
    
    public void setRightElement (ASNConstraintElement e)
    {
        rightElement = e;
    }
    
    public ASNConstraintElement getRightElement ()
    {
        return rightElement;
    }
    
    public void setEllipsis (boolean e)
    {
        ellipsis = e;
    }
    
    public boolean getEllipsis ()
    {
        return ellipsis;
    }
    
}
