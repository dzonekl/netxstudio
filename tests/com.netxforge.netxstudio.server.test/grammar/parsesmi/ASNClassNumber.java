/*
 * ASNClassNumber.java
 *
 * Created on 14 January 2005, 15:34
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNClassNumber {
    
    private long number;
    private ASNDefinedValue definedValue;
    
    /** Creates a new instance of ASNClassNumber */
    public ASNClassNumber() {
    }
    
    public void setNumber (long n)
    {
        number = n;
    }
    
    public long getNumber ()
    {
        return number;
    }
    
    public void setDefinedValue (ASNDefinedValue v)
    {
        definedValue = v;
    }
    
    public ASNDefinedValue getDefinedValue ()
    {
        return definedValue;
    }
    
}
