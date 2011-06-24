/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript.impl;

import com.netxforge.netxscript.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NetxscriptFactoryImpl extends EFactoryImpl implements NetxscriptFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static NetxscriptFactory init()
  {
    try
    {
      NetxscriptFactory theNetxscriptFactory = (NetxscriptFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.netxforge.com/Netxscript"); 
      if (theNetxscriptFactory != null)
      {
        return theNetxscriptFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new NetxscriptFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NetxscriptFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case NetxscriptPackage.MOD: return createMod();
      case NetxscriptPackage.IMPORT: return createImport();
      case NetxscriptPackage.FUNCTION: return createFunction();
      case NetxscriptPackage.ARGUMENT: return createArgument();
      case NetxscriptPackage.ABSTRACT_VAR_OR_ARGUMENT: return createAbstractVarOrArgument();
      case NetxscriptPackage.ABSTRACT_FUNCTION: return createAbstractFunction();
      case NetxscriptPackage.BLOCK: return createBlock();
      case NetxscriptPackage.STATEMENT: return createStatement();
      case NetxscriptPackage.EXPRESSION: return createExpression();
      case NetxscriptPackage.RANGE: return createRange();
      case NetxscriptPackage.REFERENCE: return createReference();
      case NetxscriptPackage.LEAF_REFERENCE: return createLeafReference();
      case NetxscriptPackage.RETURN: return createReturn();
      case NetxscriptPackage.IF: return createIf();
      case NetxscriptPackage.WHILE: return createWhile();
      case NetxscriptPackage.VARIABLE: return createVariable();
      case NetxscriptPackage.ASSIGNMENT: return createAssignment();
      case NetxscriptPackage.PLUS_ASSIGNMENT: return createPlusAssignment();
      case NetxscriptPackage.REF_ASSIGNMENT: return createRefAssignment();
      case NetxscriptPackage.AND: return createAnd();
      case NetxscriptPackage.OR: return createOr();
      case NetxscriptPackage.EQUAL: return createEqual();
      case NetxscriptPackage.UNEQUAL: return createUnequal();
      case NetxscriptPackage.LESSER: return createLesser();
      case NetxscriptPackage.LESSER_EQUAL: return createLesserEqual();
      case NetxscriptPackage.GREATER: return createGreater();
      case NetxscriptPackage.GREATER_EQUAL: return createGreaterEqual();
      case NetxscriptPackage.PLUS: return createPlus();
      case NetxscriptPackage.MINUS: return createMinus();
      case NetxscriptPackage.MULTI: return createMulti();
      case NetxscriptPackage.DIV: return createDiv();
      case NetxscriptPackage.MODULO: return createModulo();
      case NetxscriptPackage.NEGATION: return createNegation();
      case NetxscriptPackage.UNARY_PLUS_MINUS: return createUnaryPlusMinus();
      case NetxscriptPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
      case NetxscriptPackage.NUMBER_LITERAL: return createNumberLiteral();
      case NetxscriptPackage.FUNCTION_CALL: return createFunctionCall();
      case NetxscriptPackage.NATIVE_EXPRESSION: return createNativeExpression();
      case NetxscriptPackage.VAR_OR_ARGUMENT_CALL: return createVarOrArgumentCall();
      case NetxscriptPackage.RANGE_LITERAL: return createRangeLiteral();
      case NetxscriptPackage.ABSOLUTE_REF: return createAbsoluteRef();
      case NetxscriptPackage.CONTEXT_REF: return createContextRef();
      case NetxscriptPackage.FUNCTION_REF: return createFunctionRef();
      case NetxscriptPackage.RESOURCE_REF: return createResourceRef();
      case NetxscriptPackage.LINK_REF: return createLinkRef();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case NetxscriptPackage.NATIVE_FUNCTION:
        return createNativeFunctionFromString(eDataType, initialValue);
      case NetxscriptPackage.VALUE_RANGE:
        return createValueRangeFromString(eDataType, initialValue);
      case NetxscriptPackage.VALUE_KIND:
        return createValueKindFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case NetxscriptPackage.NATIVE_FUNCTION:
        return convertNativeFunctionToString(eDataType, instanceValue);
      case NetxscriptPackage.VALUE_RANGE:
        return convertValueRangeToString(eDataType, instanceValue);
      case NetxscriptPackage.VALUE_KIND:
        return convertValueKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mod createMod()
  {
    ModImpl mod = new ModImpl();
    return mod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Argument createArgument()
  {
    ArgumentImpl argument = new ArgumentImpl();
    return argument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractVarOrArgument createAbstractVarOrArgument()
  {
    AbstractVarOrArgumentImpl abstractVarOrArgument = new AbstractVarOrArgumentImpl();
    return abstractVarOrArgument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractFunction createAbstractFunction()
  {
    AbstractFunctionImpl abstractFunction = new AbstractFunctionImpl();
    return abstractFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block createBlock()
  {
    BlockImpl block = new BlockImpl();
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Range createRange()
  {
    RangeImpl range = new RangeImpl();
    return range;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Reference createReference()
  {
    ReferenceImpl reference = new ReferenceImpl();
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LeafReference createLeafReference()
  {
    LeafReferenceImpl leafReference = new LeafReferenceImpl();
    return leafReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Return createReturn()
  {
    ReturnImpl return_ = new ReturnImpl();
    return return_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public If createIf()
  {
    IfImpl if_ = new IfImpl();
    return if_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public While createWhile()
  {
    WhileImpl while_ = new WhileImpl();
    return while_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignment createAssignment()
  {
    AssignmentImpl assignment = new AssignmentImpl();
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PlusAssignment createPlusAssignment()
  {
    PlusAssignmentImpl plusAssignment = new PlusAssignmentImpl();
    return plusAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefAssignment createRefAssignment()
  {
    RefAssignmentImpl refAssignment = new RefAssignmentImpl();
    return refAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public And createAnd()
  {
    AndImpl and = new AndImpl();
    return and;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Or createOr()
  {
    OrImpl or = new OrImpl();
    return or;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Equal createEqual()
  {
    EqualImpl equal = new EqualImpl();
    return equal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Unequal createUnequal()
  {
    UnequalImpl unequal = new UnequalImpl();
    return unequal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Lesser createLesser()
  {
    LesserImpl lesser = new LesserImpl();
    return lesser;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LesserEqual createLesserEqual()
  {
    LesserEqualImpl lesserEqual = new LesserEqualImpl();
    return lesserEqual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Greater createGreater()
  {
    GreaterImpl greater = new GreaterImpl();
    return greater;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreaterEqual createGreaterEqual()
  {
    GreaterEqualImpl greaterEqual = new GreaterEqualImpl();
    return greaterEqual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Plus createPlus()
  {
    PlusImpl plus = new PlusImpl();
    return plus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Minus createMinus()
  {
    MinusImpl minus = new MinusImpl();
    return minus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Multi createMulti()
  {
    MultiImpl multi = new MultiImpl();
    return multi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Div createDiv()
  {
    DivImpl div = new DivImpl();
    return div;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Modulo createModulo()
  {
    ModuloImpl modulo = new ModuloImpl();
    return modulo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Negation createNegation()
  {
    NegationImpl negation = new NegationImpl();
    return negation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryPlusMinus createUnaryPlusMinus()
  {
    UnaryPlusMinusImpl unaryPlusMinus = new UnaryPlusMinusImpl();
    return unaryPlusMinus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteral createBooleanLiteral()
  {
    BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
    return booleanLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumberLiteral createNumberLiteral()
  {
    NumberLiteralImpl numberLiteral = new NumberLiteralImpl();
    return numberLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionCall createFunctionCall()
  {
    FunctionCallImpl functionCall = new FunctionCallImpl();
    return functionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NativeExpression createNativeExpression()
  {
    NativeExpressionImpl nativeExpression = new NativeExpressionImpl();
    return nativeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarOrArgumentCall createVarOrArgumentCall()
  {
    VarOrArgumentCallImpl varOrArgumentCall = new VarOrArgumentCallImpl();
    return varOrArgumentCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RangeLiteral createRangeLiteral()
  {
    RangeLiteralImpl rangeLiteral = new RangeLiteralImpl();
    return rangeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbsoluteRef createAbsoluteRef()
  {
    AbsoluteRefImpl absoluteRef = new AbsoluteRefImpl();
    return absoluteRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextRef createContextRef()
  {
    ContextRefImpl contextRef = new ContextRefImpl();
    return contextRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionRef createFunctionRef()
  {
    FunctionRefImpl functionRef = new FunctionRefImpl();
    return functionRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResourceRef createResourceRef()
  {
    ResourceRefImpl resourceRef = new ResourceRefImpl();
    return resourceRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkRef createLinkRef()
  {
    LinkRefImpl linkRef = new LinkRefImpl();
    return linkRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NativeFunction createNativeFunctionFromString(EDataType eDataType, String initialValue)
  {
    NativeFunction result = NativeFunction.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertNativeFunctionToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueRange createValueRangeFromString(EDataType eDataType, String initialValue)
  {
    ValueRange result = ValueRange.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertValueRangeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueKind createValueKindFromString(EDataType eDataType, String initialValue)
  {
    ValueKind result = ValueKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertValueKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NetxscriptPackage getNetxscriptPackage()
  {
    return (NetxscriptPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static NetxscriptPackage getPackage()
  {
    return NetxscriptPackage.eINSTANCE;
  }

} //NetxscriptFactoryImpl
