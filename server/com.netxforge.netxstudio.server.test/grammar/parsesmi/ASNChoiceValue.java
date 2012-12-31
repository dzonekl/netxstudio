/*
 * ASNChoiceValue.java
 *
 * Created on 15 January 2005, 13:14
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNChoiceValue extends ASNValue {
    
    private String identifier;
    private ASNValue value;
    private boolean colon;
    
    /** Creates a new instance of ASNChoiceValue */
    public ASNChoiceValue() {
        setType (CHOICEVALUE);
    }
    
    public void setIdentifier (String i)
    {
        identifier = i;
    }
    
    public String getIdentifier ()
    {
        return identifier;
    }
    
    public void setValue (ASNValue v)
    {
        value = v;
    }
    
    public ASNValue getValue ()
    {
        return value;
    }
    
    public void setColon (boolean c)
    {
        colon = c;
    }
    
    public boolean isColon ()
    {
        return colon;
    }
    
}
