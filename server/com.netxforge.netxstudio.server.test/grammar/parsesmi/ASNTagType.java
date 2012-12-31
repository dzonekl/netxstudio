/*
 * ASNTagType.java
 *
 * Created on 14 January 2005, 14:39
 */

package parsesmi;

/**
 *
 * @author  nigelss
 */
public class ASNTagType extends ASNType {
    
    private ASNTag tag;
    private int tagDefault;
    private boolean implicit;
    private ASNType subtype;
    
    /** Creates a new instance of ASNTagType */
    public ASNTagType() {
        setType (TAG);
    }
    
    public void setTag (ASNTag t)
    {
        tag = t;
    }
    
    public ASNTag getTag ()
    {
        return tag;
    }
    
    public void setTagDefault (int d)
    {
        tagDefault = d;
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
}
