/*
 * ASNType.java
 *
 * Created on 14 January 2005, 11:53
 */

package parsesmi;

/**
 *
 * @author  nigelss
 */
public class ASNType {
    
    public final static int UNKNOWN = 1;
    public final static int DEFINED = 2;
    public final static int SELECTION = 3;
    public final static int ANY = 4;
    public final static int BOOLEAN = 5;
    public final static int EMBEDDED = 6;
    public final static int BITSTRING = 7;
    public final static int CHARACTERSTRING = 8;
    public final static int CHOICE = 9;
    public final static int ENUM = 10;
    public final static int EXTERNAL = 11;
    public final static int INTEGER = 12;
    public final static int NULL = 13;
    public final static int OBJECTIDENTIFIER = 14;
    public final static int OCTETSTRING = 15;
    public final static int REAL = 16;
    public final static int RELATIVEOID = 17;
    public final static int SEQUENCE = 18;
    public final static int SET = 19;
    public final static int SEQUENCEOF = 20;
    public final static int SETOF = 21;
    public final static int TAG = 22;
    public final static int OPERATIONMACRO = 23;
    public final static int ERRORSMACRO = 24;
    public final static int SMITYPE = 25;
    public final static int SMIOBJECTTYPEMACRO = 26;
    public final static int SMIMODULEIDENTITYMACRO = 27;
    public final static int SMIOBJECTIDENTITYMACRO = 28;
    public final static int SMINOTIFICATIONTYPEMACRO = 29;
    public final static int SMITEXTUALCONVENTIONMACRO = 30;
    public final static int SMIOBJECTGROUPMACRO = 31;
    public final static int SMINOTIFICATIONGROUPMACRO = 32;
    public final static int SMIMODULECOMPLIANCEMACRO = 33;
    public final static int SMIAGENTCAPABILITIESMACRO = 34;
    public final static int SMITRAPTYPEMACRO = 35;
    
    private int type;
    
    /** Creates a new instance of ASNType */
    public ASNType() {
        setType (UNKNOWN);
    }
    
    public ASNType (int t)
    {
        setType (t);
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
