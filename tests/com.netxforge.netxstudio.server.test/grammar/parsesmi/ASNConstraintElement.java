/*
 * ASNConstraintElement.java
 *
 * Created on 15 January 2005, 10:27
 */

package parsesmi;

import java.util.*;

/**
 *
 * @author  Nigel Sheridan-Smith
 */
public class ASNConstraintElement {
    
    /* Types */
    public static final int UNKNOWN = 1;
    public static final int OPERATION = 2;
    public static final int VALUE = 3;
    public static final int VALUERANGE = 4;
    public static final int SIZECONSTRAINT = 5;
    public static final int FROMCONSTRAINT = 6;
    public static final int ELEMENTSET = 7;
    public static final int INCLUDETYPE = 8;
    public static final int PATTERN = 9;
    public static final int WITHCOMPONENT = 10;
    public static final int WITHCOMPONENTS = 11;
    public static final int NAMEDCONSTRAINT = 12;
    
    /* Operators */
    public static final int UNION = 1;
    public static final int INTERSECTION = 2;
    
    private int type;
    private int operator;
    private ASNConstraintElement operand;
    private List operations;
    private boolean allExceptConstraint;
    private ASNConstraint constraint;
    private ASNConstraintElement constraintElement;
    private ASNValue value;
    private ASNValueRange valueRange;
    private ASNConstraintElement elementSet;
    private boolean includes;
    private ASNType constraintType;
    private boolean ellipsis;
    private List typeConstraintList;
    private String constraintName;
    private boolean present;
    private boolean absent;
    private boolean optional;
    
    /** Creates a new instance of ASNConstraintElement */
    public ASNConstraintElement() {
        setType (UNKNOWN);
        
        /* Do collections */
        operations = new Vector ();
        typeConstraintList = new Vector ();
    }
    
    public ASNConstraintElement (int t)
    {
        setType (t);
        
        /* Do collections */
        operations = new Vector ();
    }
    
    public void setType (int t)
    {
        type = t;
    }
    
    public int getType ()
    {
        return type;
    }
    
    public void setOperand (ASNConstraintElement o)
    {
        operand = o;
    }
    
    public ASNConstraintElement getOperand ()
    {
        return operand;
    }
    
    public void setOperator (int o)
    {
        operator = o;
    }
    
    public void setOperations (List o)
    {
        operations = o;
    }
    
    public List getOperations ()
    {
        return operations;
    }
    
    public void setAllExceptConstraint (boolean a)
    {
        allExceptConstraint = a;
    }
    
    public boolean isAllExceptConstraint ()
    {
        return allExceptConstraint;
    }
    
    public void setConstraintElement (ASNConstraintElement c)
    {
        constraintElement = c;
    }
    
    public ASNConstraintElement getConstraintElement ()
    {
        return constraintElement;
    }
    
    public void setConstraint (ASNConstraint c)
    {
        constraint = c;
    }
    
    public ASNConstraint getConstraint ()
    {
        return constraint;
    }

    public void setValue (ASNValue v)
    {
        value = v;
    }
    
    public ASNValue getValue ()
    {
        return value;
    }
    
    public void setValueRange (ASNValueRange r)
    {
        valueRange = r;
    }
    
    public ASNValueRange getValueRange ()
    {
        return valueRange;
    }

    public void setElementSet (ASNConstraintElement e)
    {
        elementSet = e;
    }
    
    public ASNConstraintElement getElementSet ()
    {
        return elementSet;
    }

    public void setIncludes (boolean i)
    {
        includes = i;
    }
    
    public boolean isIncludes ()
    {
        return includes;
    }
    
    public void setConstraintType (ASNType t)
    {
        constraintType = t;
    }
    
    public ASNType getConstraintType ()
    {
        return constraintType;
    }

    public void setEllipsis (boolean e)
    {
        ellipsis = e;
    }
    
    public boolean isEllipsis ()
    {
        return ellipsis;
    }
    
    public void setTypeConstraintList (List l)
    {
        typeConstraintList = l;
    }     
    
    public List getTypeConstraintList ()
    {
        return typeConstraintList;
    }
    
    public void setConstraintName (String name)
    {
        constraintName = name;
    }
    
    public String getConstraintName ()
    {
        return constraintName;
    }
    
    public void setPresent (boolean p)
    {
        present = p;
    }
    
    public boolean isPresent ()
    {
        return present;
    }
    
    public void setAbsent (boolean a)
    {
        absent = a;
    }
    
    public boolean isAbsent ()
    {
        return absent;
    }
    
    public void setOptional (boolean o)
    {
        optional = o;
    }
    
    public boolean isOptional ()
    {
        return optional;
    }
}
