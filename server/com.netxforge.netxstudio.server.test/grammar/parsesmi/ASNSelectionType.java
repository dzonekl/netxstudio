/*
 * ASNSelectionType.java
 *
 * Created on 14 January 2005, 13:37
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNSelectionType extends ASNType {
    
    private String identifier;
    private ASNType selectionType;
    
    /** Creates a new instance of ASNSelectionType */
    public ASNSelectionType() {
        setType (SELECTION);
    }
    
    public void setIdentifier (String i)
    {
        identifier = i;
    }
    
    public String getIdentifier ()
    {
        return identifier;
    }
    
    public void setSelectionType (ASNType t)
    {
        selectionType = t;
    }
    
    public ASNType getSelectionType ()
    {
        return selectionType;
    }
    
}
