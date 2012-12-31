/*
 * SMISyntax.java
 *
 * Created on 15 January 2005, 08:14
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  nigelss
 */
public class SMISyntax {
    
    private ASNType subtype;
    private List namedBits;
    
    /** Creates a new instance of SMISyntax */
    public SMISyntax() {
        /* Do collections */
        namedBits = new Vector ();
    }
    
    public void setSubtype (ASNType s)
    {
        subtype = s;
    }
    
    public ASNType getSubtype ()
    {
        return subtype;
    }
    
    public void setSubtypeNamedBits (List n)
    {
        namedBits = n;
    }
    
    public List getSubtypeNamedBits ()
    {
        return namedBits;
    }
}
