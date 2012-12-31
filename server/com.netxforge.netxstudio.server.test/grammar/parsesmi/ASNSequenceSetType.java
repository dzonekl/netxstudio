/*
 * ASNSequenceSetType.java
 *
 * Created on 14 January 2005, 14:25
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  nigelss
 */
public class ASNSequenceSetType extends ASNType {
    
    public List elementTypeList;
    
    /** Creates a new instance of ASNSequenceSetType */
    public ASNSequenceSetType() {
        setType (UNKNOWN);
    }
    
    public ASNSequenceSetType(int t) {
        setType (t);
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
