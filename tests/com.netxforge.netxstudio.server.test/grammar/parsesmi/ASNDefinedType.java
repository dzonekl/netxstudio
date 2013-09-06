/*
 * ASNDefinedType.java
 *
 * Created on 14 January 2005, 13:28
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNDefinedType extends ASNType {
    
    private String moduleReference;
    private String typeReference;
    private ASNConstraint constraint;
    
    /** Creates a new instance of ASNDefinedType */
    public ASNDefinedType() {
        setType (DEFINED);
    }
    
    public void setTypeReference (String n)
    {
        typeReference = n;
    }
    
    public String getTypeReference ()
    {
        return typeReference;
    }
    
    public void setModuleReference (String m)
    {
        moduleReference = m;
    }
    
    public String getModuleReference ()
    {
        return moduleReference;
    }
    
    public void setConstraint (ASNConstraint c)
    {
        constraint = c;
    }
    
    public ASNConstraint getConstraint ()
    {
        return constraint;
    }
}
