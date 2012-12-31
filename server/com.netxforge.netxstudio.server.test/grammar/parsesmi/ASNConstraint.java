/*
 * ASNConstraint.java
 *
 * Created on 14 January 2005, 13:32
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNConstraint {
    
    private ASNElementSetRange elementSetSpecs;
    private ASNException exceptionSpec;
    
    /** Creates a new instance of ASNConstraint */
    public ASNConstraint() 
    {
    }
    
    public void setElementSetSpecs (ASNElementSetRange e)
    {
        elementSetSpecs = e;
    }
    
    public ASNElementSetRange getElementSetSpecs ()
    {
        return elementSetSpecs;
    }
    
    public void setExceptionSpec (ASNException e)
    {
        exceptionSpec = e;
    }
    
    public ASNException getExceptionSpec ()
    {
        return exceptionSpec;
    }
}
