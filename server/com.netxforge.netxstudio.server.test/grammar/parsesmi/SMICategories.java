/*
 * SMICategories.java
 *
 * Created on 14 January 2005, 22:46
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMICategories {
    
    private boolean allCategories;
    private List categories;
    
    /** Creates a new instance of SMICategories */
    public SMICategories() {
        /* Do collections */
        categories = new Vector ();
    }
    
    public void setAllCategories (boolean a)
    {
        allCategories = a;
    }
    
    public boolean isAllCategories ()
    {
        return allCategories;
    }
    
    public void setCategories (List c)
    {
        categories = c;
    }
    
    public List getCategories ()
    {
        return categories;
    }
    
}
