/*
 * ASNDefinedValue.java
 *
 * Created on 14 January 2005, 10:05
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNDefinedValue extends ASNValue {
    
    private String externalModule;
    private String valueReference;
    
    /** Creates a new instance of ASNDefinedValue */
    public ASNDefinedValue() {
        setType (DEFINEDVALUE);
    }
    
    public void setExternalModule (String m)
    {
        externalModule = m;
    }
    
    public String getExternalModule ()
    {
        return externalModule;
    }
    
    public void setValueReference (String v)
    {
        valueReference = v;
    }
    
    public String getValueReference ()
    {
        return valueReference;
    }
    
}
