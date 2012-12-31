/*
 * ASNAnyType.java
 *
 * Created on 14 January 2005, 13:43
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNAnyType extends ASNType {
    
    private String definedByIdentifier;
    
    /** Creates a new instance of ASNAnyType */
    public ASNAnyType() {
        setType (ANY);
    }
    
    public void setDefinedByIdentifier (String i)
    {
        definedByIdentifier = i;
    }
    
    public String getDefinedByIdentifier ()
    {
        return definedByIdentifier;
    }
    
}
