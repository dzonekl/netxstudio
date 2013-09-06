/*
 * ASNLiteralValue.java
 *
 * Created on 14 January 2005, 13:17
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNLiteralValue extends ASNValue {
    
    public final static int TRUE = 2;
    public final static int FALSE = 3;
    public final static int NULL = 4;
    public final static int STRING = 5;
    public final static int PLUS_INFINITY = 6;
    public final static int MINUS_INFINITY = 7;
    public final static int NUMBER = 8;
    public final static int BSTRING = 9;
    public final static int HSTRING = 10;
    
    private int literalType;
    private String stringValue;
    private long numberValue;
    
    private boolean minus;
    
    /** Creates a new instance of ASNLiteralValue */
    public ASNLiteralValue() {
        setType (LITERAL);
        setLiteralType (UNKNOWN);
    }
    
    public ASNLiteralValue (int _type)
    {
        setType (LITERAL);
        literalType = _type;
    }
    
    public ASNLiteralValue (String s)
    {
        setType (LITERAL);
        setLiteralType (STRING);
        stringValue = s;
    }
    
    public ASNLiteralValue (int t, String s)
    {
        setType (LITERAL);
        setLiteralType (t);
        setStringValue (s);
    }
    
    public void setLiteralType (int t)
    {
        literalType = t;
    }
    
    public int getLiteralType ()
    {
        return literalType;
    }
    
    public void setStringValue (String s)
    {
        stringValue = s;
    }
    
    public String getStringValue ()
    {
        return stringValue;
    }
    
    public void setNumberValue (long n)
    {
        if (minus)
        {
            numberValue = -n;
            
        } else {
            numberValue = n;
        }
    }
    
    public long getNumberValue ()
    {
        return numberValue;
    }
    
    public void setMinus (boolean m)
    {
        minus = m;
    }
    
    public boolean isMinus ()
    {
        return minus;
    }
}
