/*
 * SMIVariation.java
 *
 * Created on 15 January 2005, 09:37
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class SMIVariation {
    
    private ASNValue variationValue;
    private SMISyntax syntax;
    private SMISyntax writeSyntax;
    private int access;
    private List creationRequires;
    private ASNValue defaultValue;
    private List defaultValueIdentifiers;
    private String description; 
    
    /** Creates a new instance of SMIVariation */
    public SMIVariation() {
        /* Do collections */
        creationRequires = new Vector ();
        defaultValueIdentifiers = new Vector ();
    }
    
    public void setVariationValue (ASNValue v)
    {
        variationValue = v;
    }
    
    public ASNValue getVariationValue ()
    {
        return variationValue;
    }
    
    public void setSyntax (SMISyntax s)
    {
        syntax = s;
    }
    
    public SMISyntax getSyntax ()
    {
        return syntax;
    }
    
    public void setWriteSyntax (SMISyntax s)
    {
        writeSyntax = s;
    }
    
    public SMISyntax getWriteSyntax ()
    {
        return writeSyntax;
    }
    
    public void setAccess (int a)
    {
        access = a;
    }
    
    public int getAccess ()
    {
        return access;
    }
    
    public void setCreationRequires (List c)
    {
        creationRequires = c;
    }
    
    public List getCreationRequires ()
    {
        return creationRequires;
    }
    
    public void setDefaultValue (ASNValue v)
    {
        defaultValue = v;
    }
    
    public ASNValue getDefaultValue ()
    {
        return defaultValue;
    }
    
    public void setDefaultValueIdentifiers (List i)
    {
        defaultValueIdentifiers = i;
    }
    
    public List getDefaultValueIdentifiers ()
    {
        return defaultValueIdentifiers;
    }
    
    public void setDescription (String d)
    {
        description = d;
    }
    
    public String getDescription ()
    {
        return description;
    }
}
