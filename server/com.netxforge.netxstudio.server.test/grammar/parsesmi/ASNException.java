/*
 * ASNException.java
 *
 * Created on 14 January 2005, 14:57
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNException {
    
    private ASNValue value;
    private ASNType type;
    
    /** Creates a new instance of ASNException */
    public ASNException() {
    }
    
    public void setValue (ASNValue v)
    {
        value = v;
    }
    
    public ASNValue getValue ()
    {
        return value;
    }
    
    public void setType (ASNType t)
    {
        type = t;
    }
    
    public ASNType getType ()
    {
        return type;
    }
}
