/*
 * ASNValue.java
 *
 * Created on 14 January 2005, 11:54
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNValue {
    
    public final static int UNKNOWN = 1;
    public final static int LITERAL = 2;
    public final static int DEFINEDVALUE = 3;
    public final static int OIDCOMPONENTLIST = 4;
    public final static int CHOICEVALUE = 5;
    public final static int SEQUENCEVALUE = 6;
    public final static int SEQUENCEOFVALUES = 7;
    public final static int IDENTIFIERLISTVALUE = 8;
    public final static int CHARDEFINITIONVALUE = 9;
    public final static int TUPLEQUADVALUE = 10;
    
    private int type;
    
    /** Creates a new instance of ASNValue */
    public ASNValue() {
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
    
}
