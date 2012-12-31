/*
 * ASNElementType.java
 *
 * Created on 14 January 2005, 15:46
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNElementType {
    
    /* Element types */
    public static final int UNKNOWN = 1;
    public static final int TAGGEDTYPEVALUE = 2;
    public static final int COMPONENTSOF = 3;

    private int type;
    private String identifier;
    private ASNTag tag;
    private int tagDefault;
    private ASNType subtype;
    private boolean optional;
    private boolean defaultFlag;
    private ASNValue defaultValue;
   
    /** Creates a new instance of ASNElementType */
    public ASNElementType() {
        setType (UNKNOWN);
    }
    
    public void setType (int t)
    {
        type = t;
    }
    
    public int getType ()
    {
        return type;
    }
    
    public void setIdentifier (String i)
    {
        identifier = i;
    }
    
    public String getIdentifier ()
    {
        return identifier;
    }
    
    public void setTag (ASNTag t)
    {
        tag = t;
    }
    
    public ASNTag getTag ()
    {
        return tag;
    }
    
    public void setTagDefault (int t)
    {
        tagDefault = t;
    }
    
    public int getTagDefault ()
    {
        return tagDefault;
    }
    
    public void setSubtype (ASNType t)
    {
        subtype = t;
    }
    
    public ASNType getSubtype ()
    {
        return subtype;
    }
    
    public void setOptional (boolean o)
    {
        optional = o;
    }
    
    public boolean isOptional ()
    {
        return optional;
    }
    
    public void setDefault (boolean d)
    {
        defaultFlag = d;
    }
    
    public boolean isDefault ()
    {
        return defaultFlag;
    }
    
    public void setDefaultValue (ASNValue v)
    {
        defaultValue = v;
    }
    
    public ASNValue getDefaultValue ()
    {
        return defaultValue;
    }
}
