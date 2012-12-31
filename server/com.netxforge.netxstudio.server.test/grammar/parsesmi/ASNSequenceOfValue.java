/*
 * ASNSequenceOfValue.java
 *
 * Created on 15 January 2005, 13:22
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNSequenceOfValue extends ASNValue {
    
    private List values;
    
    /** Creates a new instance of ASNSequenceOfValue */
    public ASNSequenceOfValue() {
        setType (SEQUENCEOFVALUES);
        
        /* Do collections */
        values = new Vector ();
    }
    
    public void setValues (List v)
    {
        values = v;
    }
    
    public List getValues ()
    {
        return values;
    }
    
}
