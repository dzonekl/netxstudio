/*
 * ASNTypeOrValue.java
 *
 * Created on 14 January 2005, 15:55
 */

package parsesmi;

/**
 *
 * @author  nigelss
 */
public class ASNTypeOrValue {
    
    private ASNType type;
    private ASNValue value;
    
    /** Creates a new instance of ASNTypeOrValue */
    public ASNTypeOrValue() {
    }
    
    public void setType (ASNType t)
    {
        type = t;
    }
    
    public ASNType getType ()
    {
        return type;
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
