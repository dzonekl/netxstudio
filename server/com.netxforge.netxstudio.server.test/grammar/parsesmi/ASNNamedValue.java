/*
 * ASNNamedValue.java
 *
 * Created on 15 January 2005, 14:06
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNNamedValue extends ASNValue {
    
    private String name;
    private ASNValue value;
    
    /** Creates a new instance of ASNNamedValue */
    public ASNNamedValue() {
    }
    
    public void setName (String n)
    {
        name = n;
    }
    
    public String getName ()
    {
        return name;
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
