/*
 * ASNCharacterStringType.java
 *
 * Created on 14 January 2005, 13:59
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNCharacterStringType extends ASNType {

    public final static int ANY = 1;
    public final static int BMP = 2;
    public final static int GENERALIZEDTIME = 3;
    public final static int GENERAL = 4;
    public final static int GRAPHIC = 5;
    public final static int IA5 = 6;
    public final static int ISO646 = 7;
    public final static int NUMERIC = 8;
    public final static int PRINTABLE = 9;
    public final static int TELETEX = 10;
    public final static int T61 = 11;
    public final static int UNIVERSAL = 12;
    public final static int UTF8 = 13;
    public final static int UTC_TIME = 14;
    public final static int VIDEOTEX = 15;
    public final static int VISIBLE = 16;
    
    private int characterSet;
    private ASNConstraint constraint;
    
    /** Creates a new instance of ASNCharacterStringType */
    public ASNCharacterStringType() 
    {
        setType (CHARACTERSTRING);
        setCharacterSet (ANY);
    }
    
    public void setCharacterSet (int c)
    {
        characterSet = c;
    }
    
    public int getCharacterSet ()
    {
        return characterSet;
    }
    
    public void setConstraint (ASNConstraint c)
    {
        constraint = c;
    }
    
    public ASNConstraint getConstraint ()
    {
        return constraint;
    }
    
}
