/*
 * ASNMacroDefinition.java
 *
 * Created on 14 January 2005, 13:03
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNMacroDefinition extends ASNAssignment {
    
    private List tokens;
    
    /** Creates a new instance of ASNMacroDefinition */
    public ASNMacroDefinition() {
        setType (MACRODEF);
        
        /* Do collections */
        tokens = new Vector ();
    }
    
    public void setTokens (List t)
    {
        tokens = t;
    }
    
    public List getTokens ()
    {
        return tokens;
    }
    
}
