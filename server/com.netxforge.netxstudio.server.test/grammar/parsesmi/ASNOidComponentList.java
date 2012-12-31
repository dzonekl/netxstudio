/*
 * ASNOidComponentList.java
 *
 * Created on 13 January 2005, 18:23
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNOidComponentList extends ASNValue {
    
    private ASNDefinedValue definedValue;
    private List oidComponents;
    
    /** Creates a new instance of ASNOidComponentList */
    public ASNOidComponentList() {
        setType (OIDCOMPONENTLIST);
        
        /* Do collections */
        oidComponents = new Vector ();
    }
    
    public void setDefinedValue (ASNDefinedValue d)
    {
        definedValue = d;
    }
    
    public ASNDefinedValue getDefinedValue ()
    {
        return definedValue;
    }
    
    public void setOidComponents (List o)
    {
        oidComponents = o;
    }
    
    public List getOidComponents ()
    {
        return oidComponents;
    }
}
