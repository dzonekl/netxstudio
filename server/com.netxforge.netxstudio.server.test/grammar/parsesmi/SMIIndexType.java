/*
 * SMIIndexType.java
 *
 * Created on 14 January 2005, 21:26
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMIIndexType {
    
    private boolean implied;
    private ASNValue value;
    
    /** Creates a new instance of SMIIndexType */
    public SMIIndexType() {
    }
    
    public void setImplied (boolean i)
    {
        implied = i;
    }
    
    public boolean isImplied ()
    {
        return implied;
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
