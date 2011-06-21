/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.util;

import com.netxforge.netxscript.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxscript.NetxscriptPackage
 * @generated
 */
public class NetxscriptAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static NetxscriptPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NetxscriptAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = NetxscriptPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NetxscriptSwitch<Adapter> modelSwitch =
    new NetxscriptSwitch<Adapter>()
    {
      @Override
      public Adapter caseMod(Mod object)
      {
        return createModAdapter();
      }
      @Override
      public Adapter caseContext(Context object)
      {
        return createContextAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseFunction(Function object)
      {
        return createFunctionAdapter();
      }
      @Override
      public Adapter caseArgument(Argument object)
      {
        return createArgumentAdapter();
      }
      @Override
      public Adapter caseAbstractVarOrArgument(AbstractVarOrArgument object)
      {
        return createAbstractVarOrArgumentAdapter();
      }
      @Override
      public Adapter caseAbstractFunction(AbstractFunction object)
      {
        return createAbstractFunctionAdapter();
      }
      @Override
      public Adapter caseBlock(Block object)
      {
        return createBlockAdapter();
      }
      @Override
      public Adapter caseStatement(Statement object)
      {
        return createStatementAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseRange(Range object)
      {
        return createRangeAdapter();
      }
      @Override
      public Adapter caseReference(Reference object)
      {
        return createReferenceAdapter();
      }
      @Override
      public Adapter caseLeafReference(LeafReference object)
      {
        return createLeafReferenceAdapter();
      }
      @Override
      public Adapter caseReturn(Return object)
      {
        return createReturnAdapter();
      }
      @Override
      public Adapter caseIf(If object)
      {
        return createIfAdapter();
      }
      @Override
      public Adapter caseWhile(While object)
      {
        return createWhileAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseAssignment(Assignment object)
      {
        return createAssignmentAdapter();
      }
      @Override
      public Adapter caseRefAssignement(RefAssignement object)
      {
        return createRefAssignementAdapter();
      }
      @Override
      public Adapter caseAnd(And object)
      {
        return createAndAdapter();
      }
      @Override
      public Adapter caseOr(Or object)
      {
        return createOrAdapter();
      }
      @Override
      public Adapter caseEqual(Equal object)
      {
        return createEqualAdapter();
      }
      @Override
      public Adapter caseUnequal(Unequal object)
      {
        return createUnequalAdapter();
      }
      @Override
      public Adapter caseLesser(Lesser object)
      {
        return createLesserAdapter();
      }
      @Override
      public Adapter caseLesserEqual(LesserEqual object)
      {
        return createLesserEqualAdapter();
      }
      @Override
      public Adapter caseGreater(Greater object)
      {
        return createGreaterAdapter();
      }
      @Override
      public Adapter caseGreaterEqual(GreaterEqual object)
      {
        return createGreaterEqualAdapter();
      }
      @Override
      public Adapter casePlus(Plus object)
      {
        return createPlusAdapter();
      }
      @Override
      public Adapter caseMinus(Minus object)
      {
        return createMinusAdapter();
      }
      @Override
      public Adapter caseMulti(Multi object)
      {
        return createMultiAdapter();
      }
      @Override
      public Adapter caseDiv(Div object)
      {
        return createDivAdapter();
      }
      @Override
      public Adapter caseModulo(Modulo object)
      {
        return createModuloAdapter();
      }
      @Override
      public Adapter caseNegation(Negation object)
      {
        return createNegationAdapter();
      }
      @Override
      public Adapter caseUnaryPlusMinus(UnaryPlusMinus object)
      {
        return createUnaryPlusMinusAdapter();
      }
      @Override
      public Adapter caseBooleanLiteral(BooleanLiteral object)
      {
        return createBooleanLiteralAdapter();
      }
      @Override
      public Adapter caseNumberLiteral(NumberLiteral object)
      {
        return createNumberLiteralAdapter();
      }
      @Override
      public Adapter caseFunctionCall(FunctionCall object)
      {
        return createFunctionCallAdapter();
      }
      @Override
      public Adapter caseVarOrArgumentCall(VarOrArgumentCall object)
      {
        return createVarOrArgumentCallAdapter();
      }
      @Override
      public Adapter caseNativeExpression(NativeExpression object)
      {
        return createNativeExpressionAdapter();
      }
      @Override
      public Adapter caseRangeLiteral(RangeLiteral object)
      {
        return createRangeLiteralAdapter();
      }
      @Override
      public Adapter caseAbsoluteRef(AbsoluteRef object)
      {
        return createAbsoluteRefAdapter();
      }
      @Override
      public Adapter caseContextRef(ContextRef object)
      {
        return createContextRefAdapter();
      }
      @Override
      public Adapter caseFunctionRef(FunctionRef object)
      {
        return createFunctionRefAdapter();
      }
      @Override
      public Adapter caseResourceRef(ResourceRef object)
      {
        return createResourceRefAdapter();
      }
      @Override
      public Adapter caseLinkRef(LinkRef object)
      {
        return createLinkRefAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Mod <em>Mod</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Mod
   * @generated
   */
  public Adapter createModAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Context <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Context
   * @generated
   */
  public Adapter createContextAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Function
   * @generated
   */
  public Adapter createFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Argument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Argument
   * @generated
   */
  public Adapter createArgumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.AbstractVarOrArgument <em>Abstract Var Or Argument</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.AbstractVarOrArgument
   * @generated
   */
  public Adapter createAbstractVarOrArgumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.AbstractFunction <em>Abstract Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.AbstractFunction
   * @generated
   */
  public Adapter createAbstractFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Block
   * @generated
   */
  public Adapter createBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Statement
   * @generated
   */
  public Adapter createStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Range
   * @generated
   */
  public Adapter createRangeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Reference
   * @generated
   */
  public Adapter createReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.LeafReference <em>Leaf Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.LeafReference
   * @generated
   */
  public Adapter createLeafReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Return <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Return
   * @generated
   */
  public Adapter createReturnAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.If <em>If</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.If
   * @generated
   */
  public Adapter createIfAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.While <em>While</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.While
   * @generated
   */
  public Adapter createWhileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Assignment
   * @generated
   */
  public Adapter createAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.RefAssignement <em>Ref Assignement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.RefAssignement
   * @generated
   */
  public Adapter createRefAssignementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.And <em>And</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.And
   * @generated
   */
  public Adapter createAndAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Or <em>Or</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Or
   * @generated
   */
  public Adapter createOrAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Equal <em>Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Equal
   * @generated
   */
  public Adapter createEqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Unequal <em>Unequal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Unequal
   * @generated
   */
  public Adapter createUnequalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Lesser <em>Lesser</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Lesser
   * @generated
   */
  public Adapter createLesserAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.LesserEqual <em>Lesser Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.LesserEqual
   * @generated
   */
  public Adapter createLesserEqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Greater <em>Greater</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Greater
   * @generated
   */
  public Adapter createGreaterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.GreaterEqual <em>Greater Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.GreaterEqual
   * @generated
   */
  public Adapter createGreaterEqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Plus <em>Plus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Plus
   * @generated
   */
  public Adapter createPlusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Minus <em>Minus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Minus
   * @generated
   */
  public Adapter createMinusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Multi <em>Multi</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Multi
   * @generated
   */
  public Adapter createMultiAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Div <em>Div</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Div
   * @generated
   */
  public Adapter createDivAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Modulo <em>Modulo</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Modulo
   * @generated
   */
  public Adapter createModuloAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.Negation <em>Negation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.Negation
   * @generated
   */
  public Adapter createNegationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.UnaryPlusMinus <em>Unary Plus Minus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.UnaryPlusMinus
   * @generated
   */
  public Adapter createUnaryPlusMinusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.BooleanLiteral
   * @generated
   */
  public Adapter createBooleanLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.NumberLiteral <em>Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.NumberLiteral
   * @generated
   */
  public Adapter createNumberLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.FunctionCall
   * @generated
   */
  public Adapter createFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.VarOrArgumentCall <em>Var Or Argument Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.VarOrArgumentCall
   * @generated
   */
  public Adapter createVarOrArgumentCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.NativeExpression <em>Native Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.NativeExpression
   * @generated
   */
  public Adapter createNativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.RangeLiteral <em>Range Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.RangeLiteral
   * @generated
   */
  public Adapter createRangeLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.AbsoluteRef <em>Absolute Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.AbsoluteRef
   * @generated
   */
  public Adapter createAbsoluteRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.ContextRef <em>Context Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.ContextRef
   * @generated
   */
  public Adapter createContextRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.FunctionRef <em>Function Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.FunctionRef
   * @generated
   */
  public Adapter createFunctionRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.ResourceRef <em>Resource Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.ResourceRef
   * @generated
   */
  public Adapter createResourceRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.netxforge.netxscript.LinkRef <em>Link Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.netxforge.netxscript.LinkRef
   * @generated
   */
  public Adapter createLinkRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //NetxscriptAdapterFactory
