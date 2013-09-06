/*
 * ASNIdentifierListValue.java
 *
 * Created on 15 January 2005, 13:39
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNIdentifierListValue extends ASNValue {

    private List identifiers;
    
    /** Creates a new instance of ASNIdentifierListValue */
    public ASNIdentifierListValue() {
        setType (IDENTIFIERLISTVALUE);
        
        /* Do collections */
        identifiers = new Vector ();
    }
    
    public void setIdentifiers (List i)
    {
        identifiers = i;
    }
    
    public List getIdentifiers ()
    {
        return identifiers;
    }
}
