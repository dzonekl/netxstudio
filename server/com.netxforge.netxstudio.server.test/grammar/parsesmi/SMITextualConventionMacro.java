/*
 * SMITextualConventionMacro.java
 *
 * Created on 14 January 2005, 23:19
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMITextualConventionMacro extends ASNType {
    
    public final static int CURRENT = 1; 
    public final static int DEPRECATED = 2;
    public final static int OBSOLETE = 3;
    
    private String displayHint;
    private int status;
    private String description;
    private String reference;
    private ASNType syntax;
    private List syntaxNamedBits;
    
    /** Creates a new instance of SMITextualConventionMacro */
    public SMITextualConventionMacro() {
        setType (SMITEXTUALCONVENTIONMACRO);
        
        /* Do collections */
        syntaxNamedBits = new Vector ();
    }
    
    public void setDisplayHint (String d)
    {
        displayHint = d;
    }
    
    public String getDisplayHint ()
    {
        return displayHint;
    }
    
    public void setStatus (int s)
    {
        status = s;
    }
    
    public int getStatus ()
    {
        return status;
    }
    
    public void setDescription (String d)
    {
        description = d;
    }
    
    public String getDescription ()
    {
        return description;
    }
    
    public void setReference (String r)
    {
        reference = r;
    }
    
    public String getReference ()
    {
        return reference;
    }
    
    public void setSyntax (ASNType s)
    {
        syntax = s;
    }
    
    public ASNType getSyntax ()
    {
        return syntax;
    }
    
    public void setSyntaxNamedBits (List n)
    {
        syntaxNamedBits = n;
    }
    
    public List getSyntaxNamedBits ()
    {
        return syntaxNamedBits;
    }
    
}
