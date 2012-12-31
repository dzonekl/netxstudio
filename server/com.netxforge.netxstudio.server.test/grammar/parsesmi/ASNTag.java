/*
 * ASNTag.java
 *
 * Created on 14 January 2005, 14:56
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNTag {
    
    public final static int EXPLICIT = 1;
    public final static int IMPLICIT = 2;
    public final static int AUTOMATIC = 3;
    
    private String tagType;
    private ASNClassNumber tagNumber;
    
    /** Creates a new instance of ASNTag */
    public ASNTag() {
    }
    
    public void setTagType (String t)
    {
        tagType = t;
    }
    
    public String getTagType ()
    {
        return tagType;
    }
    
    public void setTagNumber (ASNClassNumber c)
    {
        tagNumber = c;
    }
    
    public ASNClassNumber getTagNumber ()
    {
        return tagNumber;
    }
    
}
