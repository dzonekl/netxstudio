/*
 * SMIValue.java
 *
 * Created on 14 January 2005, 16:28
 */

package parsesmi;

import antlr.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMIRangeValue {
    
    private long number;
        
    private boolean minus;
    
    /** Creates a new instance of SMIValue */
    public SMIRangeValue() {
    }
    
    public void setMinus (boolean m)
    {
        minus = m;
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
    
    public void setBinaryString (String b) throws SemanticException
    {
        /* Check the length first */
        if (b.length() <= 3)
        {
            return;
        }
        /* Delete the first character and the last two */
        StringBuffer buf = new StringBuffer (b);
        buf.deleteCharAt (0);
        buf.deleteCharAt (buf.length()-1);
        buf.deleteCharAt (buf.length()-1);
        
        /* Convert from binary number to integer */
        try 
        {
            number = Long.parseLong (buf.toString(), 2);
            
        } catch (NumberFormatException e) {
            throw new SemanticException ("Binary string value must be in radix 2 format");
        }
    }
    
    public void setHexString (String h) throws SemanticException
    {
        /* Check the length first */
        if (h.length() <= 3)
        {
            return;
        }
        
        /* Delete the first character and the last two */
        StringBuffer buf = new StringBuffer (h);
        buf.deleteCharAt (0);
        buf.deleteCharAt (buf.length()-1);
        buf.deleteCharAt (buf.length()-1);
        
        /* Convert from hex number to integer */
        try 
        {
            number = Long.parseLong (buf.toString(), 16);
            
        } catch (NumberFormatException e) {
            throw new SemanticException ("Hexadecimal string value must be in radix 16 format");
        }
    }
}
