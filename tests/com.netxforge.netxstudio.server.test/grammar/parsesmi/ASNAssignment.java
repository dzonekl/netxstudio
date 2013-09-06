/*
 * ASNAssignment.java
 *
 * Created on 14 January 2005, 11:02
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNAssignment {
    
    public static final int UNKNOWN = 1;
    public static final int TYPE = 2;
    public static final int VALUE = 3;
    public static final int MACRODEF = 4;
    
    private int type;
    private String name;
    
    /** Creates a new instance of ASNAssignment */
    public ASNAssignment() {
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
    
    public void setName (String n)
    {
        name = n;
    }
    
    public String getName ()
    {
        return name;
    }
    
}
