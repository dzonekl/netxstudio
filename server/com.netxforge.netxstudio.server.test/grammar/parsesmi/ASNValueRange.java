/*
 * ASNValueRange.java
 *
 * Created on 15 January 2005, 11:58
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNValueRange {

    private ASNValue lowerValue;
    private ASNValue upperValue;
    private boolean minValue;
    private boolean maxValue;
    private boolean lessThan;
    
    /** Creates a new instance of ASNValueRange */
    public ASNValueRange() {
    }
    
    public void setLowerValue (ASNValue v)
    {
        lowerValue = v;
    }
    
    public ASNValue getLowerValue ()
    {
        return lowerValue;
    }
    
    public void setUpperValue (ASNValue v)
    {
        upperValue = v;
    }
    
    public ASNValue getUpperValue ()
    {
        return upperValue;
    }
    
    public void setMinValue (boolean m)
    {
        minValue = m;
    }
    
    public boolean isMinValue ()
    {
        return minValue;
    }
    
    public void setMaxValue (boolean m)
    {
        maxValue = m;
    }
    
    public boolean isMaxValue ()
    {
        return maxValue;
    }
    
    public void setLessThan (boolean l)
    {
        lessThan = l;
    }
    
    public boolean isLessThan ()
    {
        return lessThan;
    }
}
