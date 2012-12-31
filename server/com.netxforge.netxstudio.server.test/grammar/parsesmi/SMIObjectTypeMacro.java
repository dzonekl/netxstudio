/*
 * SMIObjectTypeMacro.java
 *
 * Created on 14 January 2005, 17:18
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  nigelss
 */
public class SMIObjectTypeMacro extends ASNType {
    
    /* Access types */
    public static final int MAXACCESS = 1;
    public static final int ACCESS = 2;
    public static final int PIBACCESS = 3;

    /* MIB access */
    public static final int READONLY = 1; 
    public static final int READWRITE = 2;
    public static final int WRITEONLY = 3;
    public static final int READCREATE = 4;
    public static final int NOTACCESSIBLE = 5;
    public static final int ACCESSIBLEFORNOTIFY = 6;
    
    /* PIB access */
    public static final int INSTALL = 1;
    public static final int NOTIFY = 2;
    public static final int INSTALLNOTIFY = 3;
    public static final int REPORTONLY = 4;

    /* Status types */
    public static final int MANDATORY = 1;
    public static final int OPTIONAL = 2;
    public static final int OBSOLETE = 3;
    public static final int CURRENT = 4;
    public static final int DEPRECATED = 5;
    
    private ASNType syntax;
    private List namedBits;
    private String units;
    private int mibAccess;
    private int pibAccess;
    private ASNValue pibReferences;
    private ASNValue pibTag;
    private int accessType;
    private int status;
    private String description;
    private String reference;
    private List installErrors;
    private List mibIndex;
    private ASNValue mibAugments;
    private ASNValue pibIndex;
    private ASNValue pibExtends;
    private List uniquenessValues;
    private ASNValue defaultValue;
    private List defaultValueBits;
    
    /** Creates a new instance of SMIObjectTypeMacro */
    public SMIObjectTypeMacro() {
        setType (SMIOBJECTTYPEMACRO);
        
        /* Do collections */
        namedBits = new Vector ();
        installErrors = new Vector ();
        mibIndex = new Vector ();
        defaultValueBits = new Vector ();
        uniquenessValues = new Vector ();
    }
    
    public void setSyntax (ASNType s)
    {
        syntax = s;
    }
    
    public ASNType getSyntax ()
    {
        return syntax;
    }
    
    public void setNamedBits (List n)
    {
        namedBits = n;
    }
    
    public List getNamedBits ()
    {
        return namedBits;
    }
    
    public void setUnits (String u)
    {
        units = u;
    }
    
    public void setMibAccess (int t)
    {
        mibAccess = t;
    }
    
    public int getMibAccess ()
    {
        return mibAccess;
    }
    
    public void setPibAccess (int t)
    {
        pibAccess = t;
    }
    
    public int getPibAccess ()
    {
        return pibAccess;
    }
    
    public void setPibReferences (ASNValue v)
    {
        pibReferences = v;
    }
    
    public ASNValue getPibReferences ()
    {
        return pibReferences;
    }
    
    public void setPibTag (ASNValue p)
    {
        pibTag = p;
    }
    
    public ASNValue getPibTag ()
    {
        return pibTag;
    }
    
    public void setAccessType (int a)
    {
        accessType = a;
    }
    
    public int getAccessType ()
    {
        return accessType;
    }
    
    public void setStatus (int s)
    {
        status = s;
    }
    
    public int getStatus ()
    {
        return status;
    }
    
    public void setDescription (String d)
    {
        description = d;
    }
    
    public String getDescription ()
    {
        return description;
    }

    public void setInstallErrors (List i)
    {
        installErrors = i;
    }
    
    public List getInstallErrors ()
    {
        return installErrors;
    }
    
    public void setReference (String r)
    {
        reference = r;
    }
    
    public String getReference ()
    {
        return reference;
    }
    
    public void setMibIndex (List i)
    {
        mibIndex = i;
    }
    
    public List getMibIndex ()
    {
        return mibIndex;
    }
    
    public void setMibAugments (ASNValue a)
    {
        mibAugments = a;
    }
    
    public ASNValue getMibAugments ()
    {
        return mibAugments;
    }
    
    public void setPibIndex (ASNValue v)
    {
        pibIndex = v;
    }
    
    public ASNValue getPibIndex ()
    {
        return pibIndex;
    }
    
    public void setPibExtends (ASNValue v)
    {
        pibExtends = v;
    }
    
    public ASNValue getPibExtends ()
    {
        return pibExtends;
    }

    public void setUniquenessValues (List u)
    {
        uniquenessValues = u;
    }
    
    public List getUniquenessValues ()
    {
        return uniquenessValues;
    }
    
    public void setDefaultValue (ASNValue v)
    {
        defaultValue = v;
    }
    
    public ASNValue getDefaultValue ()
    {
        return defaultValue;
    }
    
    public void setDefaultValueBits (List b)
    {
        defaultValueBits = b;
    }
    
    public List getDefaultValueBits ()
    {
        return defaultValueBits;
    }
}
