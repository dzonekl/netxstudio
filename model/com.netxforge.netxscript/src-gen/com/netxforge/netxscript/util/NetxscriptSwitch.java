/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.util;

import com.netxforge.netxscript.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxscript.NetxscriptPackage
 * @generated
 */
public class NetxscriptSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static NetxscriptPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NetxscriptSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = NetxscriptPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case NetxscriptPackage.MOD:
      {
        Mod mod = (Mod)theEObject;
        T result = caseMod(mod);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.FUNCTION:
      {
        Function function = (Function)theEObject;
        T result = caseFunction(function);
        if (result == null) result = caseAbstractFunction(function);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.ARGUMENT:
      {
        Argument argument = (Argument)theEObject;
        T result = caseArgument(argument);
        if (result == null) result = caseAbstractVarOrArgument(argument);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.ABSTRACT_VAR_OR_ARGUMENT:
      {
        AbstractVarOrArgument abstractVarOrArgument = (AbstractVarOrArgument)theEObject;
        T result = caseAbstractVarOrArgument(abstractVarOrArgument);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.ABSTRACT_FUNCTION:
      {
        AbstractFunction abstractFunction = (AbstractFunction)theEObject;
        T result = caseAbstractFunction(abstractFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.BLOCK:
      {
        Block block = (Block)theEObject;
        T result = caseBlock(block);
        if (result == null) result = caseStatement(block);
        if (result == null) result = caseAbstractVarOrArgument(block);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.STATEMENT:
      {
        Statement statement = (Statement)theEObject;
        T result = caseStatement(statement);
        if (result == null) result = caseAbstractVarOrArgument(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.RANGE:
      {
        Range range = (Range)theEObject;
        T result = caseRange(range);
        if (result == null) result = caseExpression(range);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.REFERENCE:
      {
        Reference reference = (Reference)theEObject;
        T result = caseReference(reference);
        if (result == null) result = caseExpression(reference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.LEAF_REFERENCE:
      {
        LeafReference leafReference = (LeafReference)theEObject;
        T result = caseLeafReference(leafReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.RANGE_REF:
      {
        RangeRef rangeRef = (RangeRef)theEObject;
        T result = caseRangeRef(rangeRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.INTERVAL:
      {
        Interval interval = (Interval)theEObject;
        T result = caseInterval(interval);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.RETURN:
      {
        Return return_ = (Return)theEObject;
        T result = caseReturn(return_);
        if (result == null) result = caseStatement(return_);
        if (result == null) result = caseAbstractVarOrArgument(return_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.IF:
      {
        If if_ = (If)theEObject;
        T result = caseIf(if_);
        if (result == null) result = caseStatement(if_);
        if (result == null) result = caseAbstractVarOrArgument(if_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.WHILE:
      {
        While while_ = (While)theEObject;
        T result = caseWhile(while_);
        if (result == null) result = caseStatement(while_);
        if (result == null) result = caseAbstractVarOrArgument(while_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.VARIABLE:
      {
        Variable variable = (Variable)theEObject;
        T result = caseVariable(variable);
        if (result == null) result = caseStatement(variable);
        if (result == null) result = caseAbstractVarOrArgument(variable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.ASSIGNMENT:
      {
        Assignment assignment = (Assignment)theEObject;
        T result = caseAssignment(assignment);
        if (result == null) result = caseStatement(assignment);
        if (result == null) result = caseAbstractVarOrArgument(assignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.PLUS_ASSIGNMENT:
      {
        PlusAssignment plusAssignment = (PlusAssignment)theEObject;
        T result = casePlusAssignment(plusAssignment);
        if (result == null) result = caseStatement(plusAssignment);
        if (result == null) result = caseAbstractVarOrArgument(plusAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.REF_ASSIGNMENT:
      {
        RefAssignment refAssignment = (RefAssignment)theEObject;
        T result = caseRefAssignment(refAssignment);
        if (result == null) result = caseStatement(refAssignment);
        if (result == null) result = caseAbstractVarOrArgument(refAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.AND:
      {
        And and = (And)theEObject;
        T result = caseAnd(and);
        if (result == null) result = caseExpression(and);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.OR:
      {
        Or or = (Or)theEObject;
        T result = caseOr(or);
        if (result == null) result = caseExpression(or);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.EQUAL:
      {
        Equal equal = (Equal)theEObject;
        T result = caseEqual(equal);
        if (result == null) result = caseExpression(equal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.UNEQUAL:
      {
        Unequal unequal = (Unequal)theEObject;
        T result = caseUnequal(unequal);
        if (result == null) result = caseExpression(unequal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.LESSER:
      {
        Lesser lesser = (Lesser)theEObject;
        T result = caseLesser(lesser);
        if (result == null) result = caseExpression(lesser);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.LESSER_EQUAL:
      {
        LesserEqual lesserEqual = (LesserEqual)theEObject;
        T result = caseLesserEqual(lesserEqual);
        if (result == null) result = caseExpression(lesserEqual);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.GREATER:
      {
        Greater greater = (Greater)theEObject;
        T result = caseGreater(greater);
        if (result == null) result = caseExpression(greater);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.GREATER_EQUAL:
      {
        GreaterEqual greaterEqual = (GreaterEqual)theEObject;
        T result = caseGreaterEqual(greaterEqual);
        if (result == null) result = caseExpression(greaterEqual);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.PLUS:
      {
        Plus plus = (Plus)theEObject;
        T result = casePlus(plus);
        if (result == null) result = caseExpression(plus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.MINUS:
      {
        Minus minus = (Minus)theEObject;
        T result = caseMinus(minus);
        if (result == null) result = caseExpression(minus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.MULTI:
      {
        Multi multi = (Multi)theEObject;
        T result = caseMulti(multi);
        if (result == null) result = caseExpression(multi);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.DIV:
      {
        Div div = (Div)theEObject;
        T result = caseDiv(div);
        if (result == null) result = caseExpression(div);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.MODULO:
      {
        Modulo modulo = (Modulo)theEObject;
        T result = caseModulo(modulo);
        if (result == null) result = caseExpression(modulo);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.NEGATION:
      {
        Negation negation = (Negation)theEObject;
        T result = caseNegation(negation);
        if (result == null) result = caseExpression(negation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.UNARY_PLUS_MINUS:
      {
        UnaryPlusMinus unaryPlusMinus = (UnaryPlusMinus)theEObject;
        T result = caseUnaryPlusMinus(unaryPlusMinus);
        if (result == null) result = caseExpression(unaryPlusMinus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.BOOLEAN_LITERAL:
      {
        BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
        T result = caseBooleanLiteral(booleanLiteral);
        if (result == null) result = caseExpression(booleanLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.NUMBER_LITERAL:
      {
        NumberLiteral numberLiteral = (NumberLiteral)theEObject;
        T result = caseNumberLiteral(numberLiteral);
        if (result == null) result = caseExpression(numberLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.FUNCTION_CALL:
      {
        FunctionCall functionCall = (FunctionCall)theEObject;
        T result = caseFunctionCall(functionCall);
        if (result == null) result = caseExpression(functionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.NATIVE_EXPRESSION:
      {
        NativeExpression nativeExpression = (NativeExpression)theEObject;
        T result = caseNativeExpression(nativeExpression);
        if (result == null) result = caseExpression(nativeExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.VAR_OR_ARGUMENT_CALL:
      {
        VarOrArgumentCall varOrArgumentCall = (VarOrArgumentCall)theEObject;
        T result = caseVarOrArgumentCall(varOrArgumentCall);
        if (result == null) result = caseExpression(varOrArgumentCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.RANGE_LITERAL:
      {
        RangeLiteral rangeLiteral = (RangeLiteral)theEObject;
        T result = caseRangeLiteral(rangeLiteral);
        if (result == null) result = caseRange(rangeLiteral);
        if (result == null) result = caseExpression(rangeLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.NODE_TYPE_REF:
      {
        NodeTypeRef nodeTypeRef = (NodeTypeRef)theEObject;
        T result = caseNodeTypeRef(nodeTypeRef);
        if (result == null) result = caseReference(nodeTypeRef);
        if (result == null) result = caseExpression(nodeTypeRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.CONTEXT_REF:
      {
        ContextRef contextRef = (ContextRef)theEObject;
        T result = caseContextRef(contextRef);
        if (result == null) result = caseReference(contextRef);
        if (result == null) result = caseExpression(contextRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.COMPONENT_REF:
      {
        ComponentRef componentRef = (ComponentRef)theEObject;
        T result = caseComponentRef(componentRef);
        if (result == null) result = caseReference(componentRef);
        if (result == null) result = caseExpression(componentRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.RESOURCE_REF:
      {
        ResourceRef resourceRef = (ResourceRef)theEObject;
        T result = caseResourceRef(resourceRef);
        if (result == null) result = caseLeafReference(resourceRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.STATUS_REF:
      {
        StatusRef statusRef = (StatusRef)theEObject;
        T result = caseStatusRef(statusRef);
        if (result == null) result = caseLeafReference(statusRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case NetxscriptPackage.LINK_REF:
      {
        LinkRef linkRef = (LinkRef)theEObject;
        T result = caseLinkRef(linkRef);
        if (result == null) result = caseLeafReference(linkRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mod</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mod</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMod(Mod object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunction(Function object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Argument</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Argument</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArgument(Argument object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Var Or Argument</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Var Or Argument</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractVarOrArgument(AbstractVarOrArgument object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractFunction(AbstractFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlock(Block object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatement(Statement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRange(Range object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReference(Reference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Leaf Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Leaf Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLeafReference(LeafReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRangeRef(RangeRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Interval</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Interval</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInterval(Interval object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Return</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Return</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReturn(Return object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIf(If object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>While</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>While</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhile(While object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariable(Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignment(Assignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Plus Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Plus Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePlusAssignment(PlusAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ref Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ref Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRefAssignment(RefAssignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnd(And object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOr(Or object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqual(Equal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unequal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unequal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnequal(Unequal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lesser</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lesser</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLesser(Lesser object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lesser Equal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lesser Equal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLesserEqual(LesserEqual object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Greater</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Greater</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGreater(Greater object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Greater Equal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Greater Equal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGreaterEqual(GreaterEqual object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Plus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Plus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePlus(Plus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Minus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Minus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMinus(Minus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multi</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multi</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMulti(Multi object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Div</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Div</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDiv(Div object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Modulo</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Modulo</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModulo(Modulo object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Negation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Negation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNegation(Negation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Plus Minus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Plus Minus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryPlusMinus(UnaryPlusMinus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanLiteral(BooleanLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberLiteral(NumberLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionCall(FunctionCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Native Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Native Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNativeExpression(NativeExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Var Or Argument Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Var Or Argument Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVarOrArgumentCall(VarOrArgumentCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRangeLiteral(RangeLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node Type Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Type Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNodeTypeRef(NodeTypeRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextRef(ContextRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentRef(ComponentRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Resource Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Resource Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResourceRef(ResourceRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Status Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Status Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatusRef(StatusRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Link Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Link Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLinkRef(LinkRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //NetxscriptSwitch
