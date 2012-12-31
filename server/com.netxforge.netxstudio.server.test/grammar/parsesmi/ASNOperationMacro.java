/*
 * ASNOperationMacro.java
 *
 * Created on 14 January 2005, 15:37
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNOperationMacro extends ASNType {
    
    private String argumentIdentifier;
    private ASNType argumentType;
    private String resultIdentifier;
    private ASNType resultType;
    private List errorList;
    private List linkedOperationList;

    /** Creates a new instance of ASNOperationMacro */
    public ASNOperationMacro() {
        setType (OPERATIONMACRO);
        
        /* Do collections */
        errorList = new Vector ();
        linkedOperationList = new Vector ();
    }
    
    public void setArgumentIdentifier (String a)
    {
        argumentIdentifier = a;
    }
    
    public String getArgumentIdentifier ()
    {
        return argumentIdentifier;
    }
        
    public void setArgumentType (ASNType t)
    {
        argumentType = t;
    }
    
    public ASNType getArgumentType ()
    {
        return argumentType;
    }
    
    public void setResultIdentifier (String r)
    {
        resultIdentifier = r;
    }
    
    public String getResultIdentifier ()
    {
        return resultIdentifier;
    }
    
    public void setResultType (ASNType r)
    {
        resultType = r;
    }
    
    public ASNType getResultType ()
    {
        return resultType;
    }
    
    public void setErrorList (List e)
    {
        errorList = e;
    }
    
    public List getErrorList ()
    {
        return errorList;
    }
    
    public void setLinkedOperationList (List l)
    {
        linkedOperationList = l;
    }
    
    public List getLinkedOperationList ()
    {
        return linkedOperationList;
    }
    
}
