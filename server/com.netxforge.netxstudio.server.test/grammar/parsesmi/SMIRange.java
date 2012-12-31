/*
 * SMIRange.java
 *
 * Created on 14 January 2005, 16:25
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMIRange {
    
    private SMIRangeValue lowerValue;
    private SMIRangeValue upperValue;
        
    /** Creates a new instance of SMIRange */
    public SMIRange() {
    }
    
    public void setUpperValue (SMIRangeValue v)
    {
        upperValue = v;
    }
    
    public SMIRangeValue getUpperValue ()
    {
        return upperValue;
    }
    
    public void setLowerValue (SMIRangeValue v)
    {
        lowerValue = v;
    }
    
    public SMIRangeValue getLowerValue ()
    {
        return lowerValue;
    }
    
}
