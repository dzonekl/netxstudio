/*
 * ASNTupleQuadValue.java
 *
 * Created on 15 January 2005, 13:54
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNTupleQuadValue extends ASNValue {

    public static final int EXPLICIT = 1; 
    public static final int IMPLICIT = 2; 
    public static final int AUTOMATIC = 3;

    
    private ASNValue number1;
    private ASNValue number2;
    private ASNValue number3;
    private ASNValue number4;
    private boolean quad;
    
    /** Creates a new instance of ASNTupleQuadValue */
    public ASNTupleQuadValue() {
        setType (TUPLEQUADVALUE);
    }
    
    public void setNumber1 (ASNValue n)
    {
        number1 = n;
    }
    
    public ASNValue getNumber1 ()
    {
        return number1;
    }
    
    public void setNumber2 (ASNValue n)
    {
        number2 = n;
    }
    
    public ASNValue getNumber2 ()
    {
        return number2;
    }
    
    public void setNumber3 (ASNValue n)
    {
        number3 = n;
    }
    
    public ASNValue getNumber3 ()
    {
        return number3;
    }
    
    public void setNumber4 (ASNValue n)
    {
        number4 = n;
    }
    
    public ASNValue getNumber4 ()
    {
        return number4;
    }
    
    public void setQuad (boolean q)
    {
        quad = q;
    }
    
    public boolean isQuad ()
    {
        return quad;
    }
}
