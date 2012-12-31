/*
 * ASNChoiceType.java
 *
 * Created on 14 January 2005, 14:06
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNChoiceType extends ASNType {
    
    private List elementTypeList;
    
    /** Creates a new instance of ASNChoiceType */
    public ASNChoiceType() {
        setType (CHOICE);
    }
    
    public void setElementTypeList (List e)
    {
        elementTypeList = e;
    }
    
    public List getElementTypeList ()
    {
        return elementTypeList;
    }
    
}
