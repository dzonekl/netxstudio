/*
 * ASNCharacterDefinition.java
 *
 * Created on 15 January 2005, 13:48
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNCharacterDefinition {
    
    public static final int STRING = 1;
    public static final int TUPLEQUAD = 2;
    public static final int DEFINEDVALUE = 3;
    
    private int type;
    private String stringValue;
    private ASNTupleQuadValue tupleQuad;
    private ASNDefinedValue definedValue;
    
    /** Creates a new instance of ASNCharacterDefinition */
    public ASNCharacterDefinition() {
    }
    
    public void setType (int t)
    {
        type = t;
    }
    
    public int getType ()
    {
        return type;
    }
    
    public void setString (String s)
    {
        stringValue = s;
    }
    
    public String getString ()
    {
        return stringValue;
    }
    
    public void setTupleOrQuad (ASNTupleQuadValue t)
    {
        tupleQuad = t;
    }
    
    public ASNTupleQuadValue getTupleOrQuad ()
    {
        return tupleQuad;
    }
    
    public void setDefinedValue (ASNDefinedValue d)
    {
        definedValue = d;
    }
    
    public ASNDefinedValue getDefinedValue ()
    {
        return definedValue;
    }
    
}
