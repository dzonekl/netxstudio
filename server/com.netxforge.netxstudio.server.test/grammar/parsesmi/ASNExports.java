/*
 * ASNExports.java
 *
 * Created on 14 January 2005, 10:45
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNExports {
    
    private boolean allExported;
    private List exports;
    
    /** Creates a new instance of ASNExports */
    public ASNExports() {
    }
    
    public void setAllExported (boolean a)
    {
        allExported = a;
    }
    
    public boolean isAllExported ()
    {
        return allExported;
    }
    
    public void setExports (List e)
    {
        exports = e;
    }
    
    public List getExports ()
    {
        return exports;
    }
    
}
