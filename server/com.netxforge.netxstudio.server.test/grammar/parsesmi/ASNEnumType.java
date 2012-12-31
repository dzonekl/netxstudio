/*
 * ASNEnumType.java
 *
 * Created on 14 January 2005, 14:10
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  nigelss
 */
public class ASNEnumType extends ASNType {
    
    private List namedNumberList;
    
    /** Creates a new instance of ASNEnumType */
    public ASNEnumType() {
        setType (ENUM);
        
        /* Do collections */
        namedNumberList = new Vector ();
    }
    
    public void setNamedNumberList (List l)
    {
        namedNumberList = l;
    }
    
    public List getNamedNumberList ()
    {
        return namedNumberList;
    }
    
    
}
