/*
 * ASNErrorsMacro.java
 *
 * Created on 14 January 2005, 16:03
 */

package parsesmi;

/**
 *
 * @author  nigelss
 */
public class ASNErrorsMacro extends ASNType {
    
    private String identifier;
    private ASNType subtype;
    
    /** Creates a new instance of ASNErrorsMacro */
    public ASNErrorsMacro() {
        setType (ERRORSMACRO);
    }
    
    public void setIdentifier (String i)
    {
        identifier = i;
    }
    
    public String getIdentifier ()
    {
        return identifier;
    }
    
    public void setSubtype (ASNType t)
    {
        subtype = t;
    }
    
    public ASNType getSubtype ()
    {
        return subtype;
    }
    
}
