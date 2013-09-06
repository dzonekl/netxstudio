/*
 * ASNCharDefinitionListValue.java
 *
 * Created on 15 January 2005, 13:46
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNCharDefinitionListValue extends ASNValue {
    
    private List characterDefinitions;
    
    /** Creates a new instance of ASNCharDefinitionListValue */
    public ASNCharDefinitionListValue() {
        setType (CHARDEFINITIONVALUE);
        
        /* Do collections */
        characterDefinitions = new Vector ();
    }
    
    public void setCharacterDefinitions (List c)
    {
        characterDefinitions = c;
    }
    
    public List getCharacterDefinitions ()
    {
        return characterDefinitions;
    }
    
}
