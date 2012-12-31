/*
 * ASNOidComponent.java
 *
 * Created on 14 January 2005, 10:10
 */

package parsesmi;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNOidComponent {
    
    private long number;
    private String name;
    
    /** Creates a new instance of ASNOidComponent */
    public ASNOidComponent() {
    }
    
    public void setNumber (long n)
    {
        number = n;
    }
    
    public long getNumber ()
    {
        return number;
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
