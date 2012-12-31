/*
 * SMINamedBit.java
 *
 * Created on 14 January 2005, 21:32
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMINamedBit {
    
    private String name;
    private long number;
    
    private boolean minus;
    
    /** Creates a new instance of SMINamedBit */
    public SMINamedBit() {
    }
    
    public void setName (String n)
    {
        name = n;
    }
    
    public String getName ()
    {
        return name;
    }
    
    public void setNumber (long n)
    {
        if (minus)
        {
            number = -n;
            
        } else {
            number = n;
        }
    }
    
    public long getNumber ()
    {
        return number;
    }
    
    public void setMinus (boolean m)
    {
        minus = m;
    }
    
    public boolean isMinus ()
    {
        return minus;
    }
    
}
