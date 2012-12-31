/*
 * SMITrapTypeMacro.java
 *
 * Created on 15 January 2005, 09:56
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  nigelss
 */
public class SMITrapTypeMacro extends ASNType {
    
    private ASNValue enterprise;
    private List variables;
    private ASNValue description;
    private ASNValue reference;
    
    /** Creates a new instance of SMITrapTypeMacro */
    public SMITrapTypeMacro() {
        setType (SMITRAPTYPEMACRO);
        
        /* Do collections */
        variables = new Vector ();
    }
    
    public void setEnterprise (ASNValue v)
    {
        enterprise = v;
    }
    
    public ASNValue getEnterprise ()
    {
        return enterprise;
    }
    
    public void setVariables (List v)
    {
        variables = v;
    }
    
    public List getVariables ()
    {
        return variables;
    }
    
    public void setDescription (ASNValue v)
    {
        description = v;
    }
    
    public ASNValue getDescription ()
    {
        return description;
    }
    
    public void setReference (ASNValue v)
    {
        reference = v;
    }
    
    public ASNValue getReference ()
    {
        return reference;
    }
    
}
