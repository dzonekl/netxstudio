/*
 * ASNNamedNumber.java
 *
 * Created on 14 January 2005, 15:15
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNNamedNumber {
    
    private String name;
    private ASNValue value;
    
    /** Creates a new instance of ASNNamedNumber */
    public ASNNamedNumber() {
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
