/*
 * ASNSequenceValue.java
 *
 * Created on 15 January 2005, 13:19
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNSequenceValue extends ASNValue {
    
    private List namedValues;
    
    /** Creates a new instance of ASNSequenceValue */
    public ASNSequenceValue() {
        setType (SEQUENCEVALUE);
        
        /* Do collections */
        namedValues = new Vector ();
    }
    
    public void setNamedValues (List n)
    {
        namedValues = n;
    }
    
    public List getNamedValues ()
    {
        return namedValues;
    }
}
