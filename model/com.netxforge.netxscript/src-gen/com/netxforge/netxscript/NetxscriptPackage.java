/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.netxforge.netxscript.NetxscriptFactory
 * @model kind="package"
 * @generated
 */
public interface NetxscriptPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "netxscript";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.netxforge.com/Netxscript";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "netxscript";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  NetxscriptPackage eINSTANCE = com.netxforge.netxscript.impl.NetxscriptPackageImpl.init();

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.ModImpl <em>Mod</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.ModImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getMod()
   * @generated
   */
  int MOD = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Functions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD__FUNCTIONS = 2;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD__STATEMENTS = 3;

  /**
   * The number of structural features of the '<em>Mod</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.ImportImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 1;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORT_URI = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.AbstractFunctionImpl <em>Abstract Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.AbstractFunctionImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getAbstractFunction()
   * @generated
   */
  int ABSTRACT_FUNCTION = 5;

  /**
   * The number of structural features of the '<em>Abstract Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_FUNCTION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.FunctionImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__NAME = ABSTRACT_FUNCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__ARGS = ABSTRACT_FUNCTION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__BLOCK = ABSTRACT_FUNCTION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = ABSTRACT_FUNCTION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.AbstractVarOrArgumentImpl <em>Abstract Var Or Argument</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.AbstractVarOrArgumentImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getAbstractVarOrArgument()
   * @generated
   */
  int ABSTRACT_VAR_OR_ARGUMENT = 4;

  /**
   * The number of structural features of the '<em>Abstract Var Or Argument</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_VAR_OR_ARGUMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.ArgumentImpl <em>Argument</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.ArgumentImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getArgument()
   * @generated
   */
  int ARGUMENT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__NAME = ABSTRACT_VAR_OR_ARGUMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Argument</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_FEATURE_COUNT = ABSTRACT_VAR_OR_ARGUMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.StatementImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 7;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = ABSTRACT_VAR_OR_ARGUMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.BlockImpl <em>Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.BlockImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getBlock()
   * @generated
   */
  int BLOCK = 6;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.ExpressionImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 8;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__INDEX = 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.RangeImpl <em>Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.RangeImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getRange()
   * @generated
   */
  int RANGE = 9;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__INDEX = EXPRESSION__INDEX;

  /**
   * The number of structural features of the '<em>Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.ReferenceImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 10;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__COMPONENT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Leaf Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__LEAF_REF = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.LeafReferenceImpl <em>Leaf Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.LeafReferenceImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getLeafReference()
   * @generated
   */
  int LEAF_REFERENCE = 11;

  /**
   * The number of structural features of the '<em>Leaf Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LEAF_REFERENCE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.RangeRefImpl <em>Range Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.RangeRefImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getRangeRef()
   * @generated
   */
  int RANGE_REF = 12;

  /**
   * The feature id for the '<em><b>Valuerange</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_REF__VALUERANGE = 0;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_REF__KIND = 1;

  /**
   * The feature id for the '<em><b>Interval</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_REF__INTERVAL = 2;

  /**
   * The number of structural features of the '<em>Range Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_REF_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.IntervalImpl <em>Interval</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.IntervalImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getInterval()
   * @generated
   */
  int INTERVAL = 13;

  /**
   * The feature id for the '<em><b>Interval</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__INTERVAL = 0;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL__KIND = 1;

  /**
   * The number of structural features of the '<em>Interval</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERVAL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.ReturnImpl <em>Return</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.ReturnImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getReturn()
   * @generated
   */
  int RETURN = 14;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Return</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.IfImpl <em>If</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.IfImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getIf()
   * @generated
   */
  int IF = 15;

  /**
   * The feature id for the '<em><b>If</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__IF = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__THEN = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF__ELSE = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.WhileImpl <em>While</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.WhileImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getWhile()
   * @generated
   */
  int WHILE = 16;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE__PREDICATE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE__BODY = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>While</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.VariableImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.AssignmentImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 18;

  /**
   * The feature id for the '<em><b>Var</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__VAR = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.PlusAssignmentImpl <em>Plus Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.PlusAssignmentImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getPlusAssignment()
   * @generated
   */
  int PLUS_ASSIGNMENT = 19;

  /**
   * The feature id for the '<em><b>Var</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_ASSIGNMENT__VAR = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_ASSIGNMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Plus Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_ASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.RefAssignmentImpl <em>Ref Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.RefAssignmentImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getRefAssignment()
   * @generated
   */
  int REF_ASSIGNMENT = 20;

  /**
   * The feature id for the '<em><b>Assignment Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_ASSIGNMENT__ASSIGNMENT_REF = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_ASSIGNMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Ref Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REF_ASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.AndImpl <em>And</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.AndImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getAnd()
   * @generated
   */
  int AND = 21;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>And</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.OrImpl <em>Or</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.OrImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getOr()
   * @generated
   */
  int OR = 22;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Or</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.EqualImpl <em>Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.EqualImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getEqual()
   * @generated
   */
  int EQUAL = 23;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.UnequalImpl <em>Unequal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.UnequalImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getUnequal()
   * @generated
   */
  int UNEQUAL = 24;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNEQUAL__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNEQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNEQUAL__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unequal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNEQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.LesserImpl <em>Lesser</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.LesserImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getLesser()
   * @generated
   */
  int LESSER = 25;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESSER__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESSER__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESSER__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Lesser</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESSER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.LesserEqualImpl <em>Lesser Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.LesserEqualImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getLesserEqual()
   * @generated
   */
  int LESSER_EQUAL = 26;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESSER_EQUAL__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESSER_EQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESSER_EQUAL__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Lesser Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESSER_EQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.GreaterImpl <em>Greater</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.GreaterImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getGreater()
   * @generated
   */
  int GREATER = 27;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Greater</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.GreaterEqualImpl <em>Greater Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.GreaterEqualImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getGreaterEqual()
   * @generated
   */
  int GREATER_EQUAL = 28;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_EQUAL__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_EQUAL__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_EQUAL__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Greater Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_EQUAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.PlusImpl <em>Plus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.PlusImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getPlus()
   * @generated
   */
  int PLUS = 29;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Plus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.MinusImpl <em>Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.MinusImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getMinus()
   * @generated
   */
  int MINUS = 30;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.MultiImpl <em>Multi</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.MultiImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getMulti()
   * @generated
   */
  int MULTI = 31;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Multi</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.DivImpl <em>Div</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.DivImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getDiv()
   * @generated
   */
  int DIV = 32;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIV__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIV__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIV__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Div</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIV_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.ModuloImpl <em>Modulo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.ModuloImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getModulo()
   * @generated
   */
  int MODULO = 33;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Modulo</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULO_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.NegationImpl <em>Negation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.NegationImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNegation()
   * @generated
   */
  int NEGATION = 34;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATION__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATION__OP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Negation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.UnaryPlusMinusImpl <em>Unary Plus Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.UnaryPlusMinusImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getUnaryPlusMinus()
   * @generated
   */
  int UNARY_PLUS_MINUS = 35;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_PLUS_MINUS__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_PLUS_MINUS__OP = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_PLUS_MINUS__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Plus Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_PLUS_MINUS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.BooleanLiteralImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 36;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL__CONDITION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.NumberLiteralImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNumberLiteral()
   * @generated
   */
  int NUMBER_LITERAL = 37;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Number Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.FunctionCallImpl <em>Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.FunctionCallImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getFunctionCall()
   * @generated
   */
  int FUNCTION_CALL = 38;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Func</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL__FUNC = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL__ARGS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.NativeExpressionImpl <em>Native Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.NativeExpressionImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNativeExpression()
   * @generated
   */
  int NATIVE_EXPRESSION = 39;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_EXPRESSION__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Range</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_EXPRESSION__RANGE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_EXPRESSION__REF = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_EXPRESSION__VAR = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Native Function</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_EXPRESSION__NATIVE_FUNCTION = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Native Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.VarOrArgumentCallImpl <em>Var Or Argument Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.VarOrArgumentCallImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getVarOrArgumentCall()
   * @generated
   */
  int VAR_OR_ARGUMENT_CALL = 40;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_OR_ARGUMENT_CALL__INDEX = EXPRESSION__INDEX;

  /**
   * The feature id for the '<em><b>Call</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_OR_ARGUMENT_CALL__CALL = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Var Or Argument Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_OR_ARGUMENT_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.RangeLiteralImpl <em>Range Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.RangeLiteralImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getRangeLiteral()
   * @generated
   */
  int RANGE_LITERAL = 41;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_LITERAL__INDEX = RANGE__INDEX;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_LITERAL__VALUES = RANGE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Range Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_LITERAL_FEATURE_COUNT = RANGE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.ParamRefImpl <em>Param Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.ParamRefImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getParamRef()
   * @generated
   */
  int PARAM_REF = 42;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_REF__INDEX = REFERENCE__INDEX;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_REF__COMPONENT = REFERENCE__COMPONENT;

  /**
   * The feature id for the '<em><b>Leaf Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_REF__LEAF_REF = REFERENCE__LEAF_REF;

  /**
   * The feature id for the '<em><b>Param</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_REF__PARAM = REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Param Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAM_REF_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.NodeTypeRefImpl <em>Node Type Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.NodeTypeRefImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNodeTypeRef()
   * @generated
   */
  int NODE_TYPE_REF = 43;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_TYPE_REF__INDEX = REFERENCE__INDEX;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_TYPE_REF__COMPONENT = REFERENCE__COMPONENT;

  /**
   * The feature id for the '<em><b>Leaf Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_TYPE_REF__LEAF_REF = REFERENCE__LEAF_REF;

  /**
   * The feature id for the '<em><b>Nodetype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_TYPE_REF__NODETYPE = REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Primary Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_TYPE_REF__PRIMARY_REF = REFERENCE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Node Type Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_TYPE_REF_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.NodeRefImpl <em>Node Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.NodeRefImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNodeRef()
   * @generated
   */
  int NODE_REF = 44;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_REF__INDEX = REFERENCE__INDEX;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_REF__COMPONENT = REFERENCE__COMPONENT;

  /**
   * The feature id for the '<em><b>Leaf Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_REF__LEAF_REF = REFERENCE__LEAF_REF;

  /**
   * The feature id for the '<em><b>Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_REF__NODE = REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Primary Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_REF__PRIMARY_REF = REFERENCE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Node Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_REF_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.ContextRefImpl <em>Context Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.ContextRefImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getContextRef()
   * @generated
   */
  int CONTEXT_REF = 45;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_REF__INDEX = REFERENCE__INDEX;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_REF__COMPONENT = REFERENCE__COMPONENT;

  /**
   * The feature id for the '<em><b>Leaf Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_REF__LEAF_REF = REFERENCE__LEAF_REF;

  /**
   * The feature id for the '<em><b>Primary Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_REF__PRIMARY_REF = REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Range Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_REF__RANGE_REF = REFERENCE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Context Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_REF_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.OperatorRefImpl <em>Operator Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.OperatorRefImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getOperatorRef()
   * @generated
   */
  int OPERATOR_REF = 46;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR_REF__INDEX = REFERENCE__INDEX;

  /**
   * The feature id for the '<em><b>Component</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR_REF__COMPONENT = REFERENCE__COMPONENT;

  /**
   * The feature id for the '<em><b>Leaf Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR_REF__LEAF_REF = REFERENCE__LEAF_REF;

  /**
   * The feature id for the '<em><b>Function</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR_REF__FUNCTION = REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Equipment</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR_REF__EQUIPMENT = REFERENCE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Operator Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR_REF_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.ResourceRefImpl <em>Resource Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.ResourceRefImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getResourceRef()
   * @generated
   */
  int RESOURCE_REF = 47;

  /**
   * The feature id for the '<em><b>Resource</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_REF__RESOURCE = LEAF_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_REF__ALL = LEAF_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Range Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_REF__RANGE_REF = LEAF_REFERENCE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Resource Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_REF_FEATURE_COUNT = LEAF_REFERENCE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.StatusRefImpl <em>Status Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.StatusRefImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getStatusRef()
   * @generated
   */
  int STATUS_REF = 48;

  /**
   * The feature id for the '<em><b>Tolerancelevel</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATUS_REF__TOLERANCELEVEL = LEAF_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Status Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATUS_REF_FEATURE_COUNT = LEAF_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.LinkRefImpl <em>Link Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.LinkRefImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getLinkRef()
   * @generated
   */
  int LINK_REF = 49;

  /**
   * The feature id for the '<em><b>Link</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_REF__LINK = LEAF_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Link Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_REF_FEATURE_COUNT = LEAF_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.NativeFunction <em>Native Function</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.NativeFunction
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNativeFunction()
   * @generated
   */
  int NATIVE_FUNCTION = 50;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.IntervalKind <em>Interval Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.IntervalKind
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getIntervalKind()
   * @generated
   */
  int INTERVAL_KIND = 51;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.ToleranceLevel <em>Tolerance Level</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.ToleranceLevel
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getToleranceLevel()
   * @generated
   */
  int TOLERANCE_LEVEL = 52;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.ValueRange <em>Value Range</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.ValueRange
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getValueRange()
   * @generated
   */
  int VALUE_RANGE = 53;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.ValueKind <em>Value Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.ValueKind
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getValueKind()
   * @generated
   */
  int VALUE_KIND = 54;


  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Mod <em>Mod</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mod</em>'.
   * @see com.netxforge.netxscript.Mod
   * @generated
   */
  EClass getMod();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.Mod#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.netxscript.Mod#getName()
   * @see #getMod()
   * @generated
   */
  EAttribute getMod_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.netxscript.Mod#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see com.netxforge.netxscript.Mod#getImports()
   * @see #getMod()
   * @generated
   */
  EReference getMod_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.netxscript.Mod#getFunctions <em>Functions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Functions</em>'.
   * @see com.netxforge.netxscript.Mod#getFunctions()
   * @see #getMod()
   * @generated
   */
  EReference getMod_Functions();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.netxscript.Mod#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see com.netxforge.netxscript.Mod#getStatements()
   * @see #getMod()
   * @generated
   */
  EReference getMod_Statements();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see com.netxforge.netxscript.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.Import#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see com.netxforge.netxscript.Import#getImportURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportURI();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see com.netxforge.netxscript.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.Function#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.netxscript.Function#getName()
   * @see #getFunction()
   * @generated
   */
  EAttribute getFunction_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.netxscript.Function#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.netxforge.netxscript.Function#getArgs()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Args();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Function#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see com.netxforge.netxscript.Function#getBlock()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Block();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Argument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument</em>'.
   * @see com.netxforge.netxscript.Argument
   * @generated
   */
  EClass getArgument();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.Argument#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.netxscript.Argument#getName()
   * @see #getArgument()
   * @generated
   */
  EAttribute getArgument_Name();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.AbstractVarOrArgument <em>Abstract Var Or Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Var Or Argument</em>'.
   * @see com.netxforge.netxscript.AbstractVarOrArgument
   * @generated
   */
  EClass getAbstractVarOrArgument();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.AbstractFunction <em>Abstract Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Function</em>'.
   * @see com.netxforge.netxscript.AbstractFunction
   * @generated
   */
  EClass getAbstractFunction();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block</em>'.
   * @see com.netxforge.netxscript.Block
   * @generated
   */
  EClass getBlock();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.netxscript.Block#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see com.netxforge.netxscript.Block#getStatements()
   * @see #getBlock()
   * @generated
   */
  EReference getBlock_Statements();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see com.netxforge.netxscript.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see com.netxforge.netxscript.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Expression#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Index</em>'.
   * @see com.netxforge.netxscript.Expression#getIndex()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Index();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range</em>'.
   * @see com.netxforge.netxscript.Range
   * @generated
   */
  EClass getRange();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see com.netxforge.netxscript.Reference
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Reference#getComponent <em>Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Component</em>'.
   * @see com.netxforge.netxscript.Reference#getComponent()
   * @see #getReference()
   * @generated
   */
  EReference getReference_Component();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Reference#getLeafRef <em>Leaf Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Leaf Ref</em>'.
   * @see com.netxforge.netxscript.Reference#getLeafRef()
   * @see #getReference()
   * @generated
   */
  EReference getReference_LeafRef();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.LeafReference <em>Leaf Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Leaf Reference</em>'.
   * @see com.netxforge.netxscript.LeafReference
   * @generated
   */
  EClass getLeafReference();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.RangeRef <em>Range Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range Ref</em>'.
   * @see com.netxforge.netxscript.RangeRef
   * @generated
   */
  EClass getRangeRef();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.RangeRef#getValuerange <em>Valuerange</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Valuerange</em>'.
   * @see com.netxforge.netxscript.RangeRef#getValuerange()
   * @see #getRangeRef()
   * @generated
   */
  EAttribute getRangeRef_Valuerange();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.RangeRef#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see com.netxforge.netxscript.RangeRef#getKind()
   * @see #getRangeRef()
   * @generated
   */
  EAttribute getRangeRef_Kind();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.RangeRef#getInterval <em>Interval</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Interval</em>'.
   * @see com.netxforge.netxscript.RangeRef#getInterval()
   * @see #getRangeRef()
   * @generated
   */
  EReference getRangeRef_Interval();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Interval <em>Interval</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interval</em>'.
   * @see com.netxforge.netxscript.Interval
   * @generated
   */
  EClass getInterval();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.Interval#getInterval <em>Interval</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Interval</em>'.
   * @see com.netxforge.netxscript.Interval#getInterval()
   * @see #getInterval()
   * @generated
   */
  EAttribute getInterval_Interval();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.Interval#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see com.netxforge.netxscript.Interval#getKind()
   * @see #getInterval()
   * @generated
   */
  EAttribute getInterval_Kind();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Return <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Return</em>'.
   * @see com.netxforge.netxscript.Return
   * @generated
   */
  EClass getReturn();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Return#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.netxforge.netxscript.Return#getExpression()
   * @see #getReturn()
   * @generated
   */
  EReference getReturn_Expression();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.If <em>If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If</em>'.
   * @see com.netxforge.netxscript.If
   * @generated
   */
  EClass getIf();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.If#getIf <em>If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If</em>'.
   * @see com.netxforge.netxscript.If#getIf()
   * @see #getIf()
   * @generated
   */
  EReference getIf_If();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.If#getThen <em>Then</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then</em>'.
   * @see com.netxforge.netxscript.If#getThen()
   * @see #getIf()
   * @generated
   */
  EReference getIf_Then();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.If#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see com.netxforge.netxscript.If#getElse()
   * @see #getIf()
   * @generated
   */
  EReference getIf_Else();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.While <em>While</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>While</em>'.
   * @see com.netxforge.netxscript.While
   * @generated
   */
  EClass getWhile();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.While#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Predicate</em>'.
   * @see com.netxforge.netxscript.While#getPredicate()
   * @see #getWhile()
   * @generated
   */
  EReference getWhile_Predicate();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.While#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.netxforge.netxscript.While#getBody()
   * @see #getWhile()
   * @generated
   */
  EReference getWhile_Body();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see com.netxforge.netxscript.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.netxforge.netxscript.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Variable#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.netxforge.netxscript.Variable#getExpression()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Expression();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see com.netxforge.netxscript.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.Assignment#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Var</em>'.
   * @see com.netxforge.netxscript.Assignment#getVar()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Var();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Assignment#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.netxforge.netxscript.Assignment#getExpression()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Expression();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.PlusAssignment <em>Plus Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plus Assignment</em>'.
   * @see com.netxforge.netxscript.PlusAssignment
   * @generated
   */
  EClass getPlusAssignment();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.PlusAssignment#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Var</em>'.
   * @see com.netxforge.netxscript.PlusAssignment#getVar()
   * @see #getPlusAssignment()
   * @generated
   */
  EReference getPlusAssignment_Var();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.PlusAssignment#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.netxforge.netxscript.PlusAssignment#getExpression()
   * @see #getPlusAssignment()
   * @generated
   */
  EReference getPlusAssignment_Expression();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.RefAssignment <em>Ref Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ref Assignment</em>'.
   * @see com.netxforge.netxscript.RefAssignment
   * @generated
   */
  EClass getRefAssignment();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.RefAssignment#getAssignmentRef <em>Assignment Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assignment Ref</em>'.
   * @see com.netxforge.netxscript.RefAssignment#getAssignmentRef()
   * @see #getRefAssignment()
   * @generated
   */
  EReference getRefAssignment_AssignmentRef();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.RefAssignment#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.netxforge.netxscript.RefAssignment#getExpression()
   * @see #getRefAssignment()
   * @generated
   */
  EReference getRefAssignment_Expression();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.And <em>And</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And</em>'.
   * @see com.netxforge.netxscript.And
   * @generated
   */
  EClass getAnd();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.And#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.And#getLeft()
   * @see #getAnd()
   * @generated
   */
  EReference getAnd_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.And#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.And#getRight()
   * @see #getAnd()
   * @generated
   */
  EReference getAnd_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Or <em>Or</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or</em>'.
   * @see com.netxforge.netxscript.Or
   * @generated
   */
  EClass getOr();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Or#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.Or#getLeft()
   * @see #getOr()
   * @generated
   */
  EReference getOr_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Or#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.Or#getRight()
   * @see #getOr()
   * @generated
   */
  EReference getOr_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Equal <em>Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equal</em>'.
   * @see com.netxforge.netxscript.Equal
   * @generated
   */
  EClass getEqual();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Equal#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.Equal#getLeft()
   * @see #getEqual()
   * @generated
   */
  EReference getEqual_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Equal#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.Equal#getRight()
   * @see #getEqual()
   * @generated
   */
  EReference getEqual_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Unequal <em>Unequal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unequal</em>'.
   * @see com.netxforge.netxscript.Unequal
   * @generated
   */
  EClass getUnequal();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Unequal#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.Unequal#getLeft()
   * @see #getUnequal()
   * @generated
   */
  EReference getUnequal_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Unequal#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.Unequal#getRight()
   * @see #getUnequal()
   * @generated
   */
  EReference getUnequal_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Lesser <em>Lesser</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lesser</em>'.
   * @see com.netxforge.netxscript.Lesser
   * @generated
   */
  EClass getLesser();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Lesser#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.Lesser#getLeft()
   * @see #getLesser()
   * @generated
   */
  EReference getLesser_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Lesser#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.Lesser#getRight()
   * @see #getLesser()
   * @generated
   */
  EReference getLesser_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.LesserEqual <em>Lesser Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lesser Equal</em>'.
   * @see com.netxforge.netxscript.LesserEqual
   * @generated
   */
  EClass getLesserEqual();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.LesserEqual#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.LesserEqual#getLeft()
   * @see #getLesserEqual()
   * @generated
   */
  EReference getLesserEqual_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.LesserEqual#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.LesserEqual#getRight()
   * @see #getLesserEqual()
   * @generated
   */
  EReference getLesserEqual_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Greater <em>Greater</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Greater</em>'.
   * @see com.netxforge.netxscript.Greater
   * @generated
   */
  EClass getGreater();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Greater#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.Greater#getLeft()
   * @see #getGreater()
   * @generated
   */
  EReference getGreater_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Greater#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.Greater#getRight()
   * @see #getGreater()
   * @generated
   */
  EReference getGreater_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.GreaterEqual <em>Greater Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Greater Equal</em>'.
   * @see com.netxforge.netxscript.GreaterEqual
   * @generated
   */
  EClass getGreaterEqual();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.GreaterEqual#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.GreaterEqual#getLeft()
   * @see #getGreaterEqual()
   * @generated
   */
  EReference getGreaterEqual_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.GreaterEqual#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.GreaterEqual#getRight()
   * @see #getGreaterEqual()
   * @generated
   */
  EReference getGreaterEqual_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Plus <em>Plus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plus</em>'.
   * @see com.netxforge.netxscript.Plus
   * @generated
   */
  EClass getPlus();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Plus#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.Plus#getLeft()
   * @see #getPlus()
   * @generated
   */
  EReference getPlus_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Plus#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.Plus#getRight()
   * @see #getPlus()
   * @generated
   */
  EReference getPlus_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Minus <em>Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Minus</em>'.
   * @see com.netxforge.netxscript.Minus
   * @generated
   */
  EClass getMinus();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Minus#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.Minus#getLeft()
   * @see #getMinus()
   * @generated
   */
  EReference getMinus_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Minus#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.Minus#getRight()
   * @see #getMinus()
   * @generated
   */
  EReference getMinus_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Multi <em>Multi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multi</em>'.
   * @see com.netxforge.netxscript.Multi
   * @generated
   */
  EClass getMulti();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Multi#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.Multi#getLeft()
   * @see #getMulti()
   * @generated
   */
  EReference getMulti_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Multi#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.Multi#getRight()
   * @see #getMulti()
   * @generated
   */
  EReference getMulti_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Div <em>Div</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Div</em>'.
   * @see com.netxforge.netxscript.Div
   * @generated
   */
  EClass getDiv();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Div#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.Div#getLeft()
   * @see #getDiv()
   * @generated
   */
  EReference getDiv_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Div#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.Div#getRight()
   * @see #getDiv()
   * @generated
   */
  EReference getDiv_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Modulo <em>Modulo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modulo</em>'.
   * @see com.netxforge.netxscript.Modulo
   * @generated
   */
  EClass getModulo();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Modulo#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.netxforge.netxscript.Modulo#getLeft()
   * @see #getModulo()
   * @generated
   */
  EReference getModulo_Left();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Modulo#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.Modulo#getRight()
   * @see #getModulo()
   * @generated
   */
  EReference getModulo_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.Negation <em>Negation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Negation</em>'.
   * @see com.netxforge.netxscript.Negation
   * @generated
   */
  EClass getNegation();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.Negation#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.netxforge.netxscript.Negation#getOp()
   * @see #getNegation()
   * @generated
   */
  EAttribute getNegation_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Negation#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.Negation#getRight()
   * @see #getNegation()
   * @generated
   */
  EReference getNegation_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.UnaryPlusMinus <em>Unary Plus Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Plus Minus</em>'.
   * @see com.netxforge.netxscript.UnaryPlusMinus
   * @generated
   */
  EClass getUnaryPlusMinus();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.UnaryPlusMinus#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.netxforge.netxscript.UnaryPlusMinus#getOp()
   * @see #getUnaryPlusMinus()
   * @generated
   */
  EAttribute getUnaryPlusMinus_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.UnaryPlusMinus#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.netxforge.netxscript.UnaryPlusMinus#getRight()
   * @see #getUnaryPlusMinus()
   * @generated
   */
  EReference getUnaryPlusMinus_Right();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see com.netxforge.netxscript.BooleanLiteral
   * @generated
   */
  EClass getBooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.BooleanLiteral#isCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Condition</em>'.
   * @see com.netxforge.netxscript.BooleanLiteral#isCondition()
   * @see #getBooleanLiteral()
   * @generated
   */
  EAttribute getBooleanLiteral_Condition();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.NumberLiteral <em>Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Literal</em>'.
   * @see com.netxforge.netxscript.NumberLiteral
   * @generated
   */
  EClass getNumberLiteral();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.NumberLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.netxforge.netxscript.NumberLiteral#getValue()
   * @see #getNumberLiteral()
   * @generated
   */
  EAttribute getNumberLiteral_Value();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Call</em>'.
   * @see com.netxforge.netxscript.FunctionCall
   * @generated
   */
  EClass getFunctionCall();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.FunctionCall#getFunc <em>Func</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Func</em>'.
   * @see com.netxforge.netxscript.FunctionCall#getFunc()
   * @see #getFunctionCall()
   * @generated
   */
  EReference getFunctionCall_Func();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.netxscript.FunctionCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.netxforge.netxscript.FunctionCall#getArgs()
   * @see #getFunctionCall()
   * @generated
   */
  EReference getFunctionCall_Args();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.NativeExpression <em>Native Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Native Expression</em>'.
   * @see com.netxforge.netxscript.NativeExpression
   * @generated
   */
  EClass getNativeExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.NativeExpression#getRange <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Range</em>'.
   * @see com.netxforge.netxscript.NativeExpression#getRange()
   * @see #getNativeExpression()
   * @generated
   */
  EReference getNativeExpression_Range();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.NativeExpression#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref</em>'.
   * @see com.netxforge.netxscript.NativeExpression#getRef()
   * @see #getNativeExpression()
   * @generated
   */
  EReference getNativeExpression_Ref();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.NativeExpression#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var</em>'.
   * @see com.netxforge.netxscript.NativeExpression#getVar()
   * @see #getNativeExpression()
   * @generated
   */
  EReference getNativeExpression_Var();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.NativeExpression#getNativeFunction <em>Native Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Native Function</em>'.
   * @see com.netxforge.netxscript.NativeExpression#getNativeFunction()
   * @see #getNativeExpression()
   * @generated
   */
  EAttribute getNativeExpression_NativeFunction();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.VarOrArgumentCall <em>Var Or Argument Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Or Argument Call</em>'.
   * @see com.netxforge.netxscript.VarOrArgumentCall
   * @generated
   */
  EClass getVarOrArgumentCall();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.VarOrArgumentCall#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Call</em>'.
   * @see com.netxforge.netxscript.VarOrArgumentCall#getCall()
   * @see #getVarOrArgumentCall()
   * @generated
   */
  EReference getVarOrArgumentCall_Call();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.RangeLiteral <em>Range Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range Literal</em>'.
   * @see com.netxforge.netxscript.RangeLiteral
   * @generated
   */
  EClass getRangeLiteral();

  /**
   * Returns the meta object for the attribute list '{@link com.netxforge.netxscript.RangeLiteral#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see com.netxforge.netxscript.RangeLiteral#getValues()
   * @see #getRangeLiteral()
   * @generated
   */
  EAttribute getRangeLiteral_Values();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.ParamRef <em>Param Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Param Ref</em>'.
   * @see com.netxforge.netxscript.ParamRef
   * @generated
   */
  EClass getParamRef();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.ParamRef#getParam <em>Param</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Param</em>'.
   * @see com.netxforge.netxscript.ParamRef#getParam()
   * @see #getParamRef()
   * @generated
   */
  EReference getParamRef_Param();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.NodeTypeRef <em>Node Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Type Ref</em>'.
   * @see com.netxforge.netxscript.NodeTypeRef
   * @generated
   */
  EClass getNodeTypeRef();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.NodeTypeRef#getNodetype <em>Nodetype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Nodetype</em>'.
   * @see com.netxforge.netxscript.NodeTypeRef#getNodetype()
   * @see #getNodeTypeRef()
   * @generated
   */
  EReference getNodeTypeRef_Nodetype();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.NodeTypeRef#getPrimaryRef <em>Primary Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Primary Ref</em>'.
   * @see com.netxforge.netxscript.NodeTypeRef#getPrimaryRef()
   * @see #getNodeTypeRef()
   * @generated
   */
  EReference getNodeTypeRef_PrimaryRef();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.NodeRef <em>Node Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Ref</em>'.
   * @see com.netxforge.netxscript.NodeRef
   * @generated
   */
  EClass getNodeRef();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.NodeRef#getNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Node</em>'.
   * @see com.netxforge.netxscript.NodeRef#getNode()
   * @see #getNodeRef()
   * @generated
   */
  EReference getNodeRef_Node();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.NodeRef#getPrimaryRef <em>Primary Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Primary Ref</em>'.
   * @see com.netxforge.netxscript.NodeRef#getPrimaryRef()
   * @see #getNodeRef()
   * @generated
   */
  EReference getNodeRef_PrimaryRef();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.ContextRef <em>Context Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Ref</em>'.
   * @see com.netxforge.netxscript.ContextRef
   * @generated
   */
  EClass getContextRef();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.ContextRef#getPrimaryRef <em>Primary Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Primary Ref</em>'.
   * @see com.netxforge.netxscript.ContextRef#getPrimaryRef()
   * @see #getContextRef()
   * @generated
   */
  EReference getContextRef_PrimaryRef();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.ContextRef#getRangeRef <em>Range Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Range Ref</em>'.
   * @see com.netxforge.netxscript.ContextRef#getRangeRef()
   * @see #getContextRef()
   * @generated
   */
  EReference getContextRef_RangeRef();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.OperatorRef <em>Operator Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operator Ref</em>'.
   * @see com.netxforge.netxscript.OperatorRef
   * @generated
   */
  EClass getOperatorRef();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.OperatorRef#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Function</em>'.
   * @see com.netxforge.netxscript.OperatorRef#getFunction()
   * @see #getOperatorRef()
   * @generated
   */
  EReference getOperatorRef_Function();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.OperatorRef#getEquipment <em>Equipment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Equipment</em>'.
   * @see com.netxforge.netxscript.OperatorRef#getEquipment()
   * @see #getOperatorRef()
   * @generated
   */
  EReference getOperatorRef_Equipment();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.ResourceRef <em>Resource Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Resource Ref</em>'.
   * @see com.netxforge.netxscript.ResourceRef
   * @generated
   */
  EClass getResourceRef();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.ResourceRef#getResource <em>Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Resource</em>'.
   * @see com.netxforge.netxscript.ResourceRef#getResource()
   * @see #getResourceRef()
   * @generated
   */
  EReference getResourceRef_Resource();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.ResourceRef#isAll <em>All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>All</em>'.
   * @see com.netxforge.netxscript.ResourceRef#isAll()
   * @see #getResourceRef()
   * @generated
   */
  EAttribute getResourceRef_All();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.ResourceRef#getRangeRef <em>Range Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Range Ref</em>'.
   * @see com.netxforge.netxscript.ResourceRef#getRangeRef()
   * @see #getResourceRef()
   * @generated
   */
  EReference getResourceRef_RangeRef();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.StatusRef <em>Status Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Status Ref</em>'.
   * @see com.netxforge.netxscript.StatusRef
   * @generated
   */
  EClass getStatusRef();

  /**
   * Returns the meta object for the attribute '{@link com.netxforge.netxscript.StatusRef#getTolerancelevel <em>Tolerancelevel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tolerancelevel</em>'.
   * @see com.netxforge.netxscript.StatusRef#getTolerancelevel()
   * @see #getStatusRef()
   * @generated
   */
  EAttribute getStatusRef_Tolerancelevel();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.LinkRef <em>Link Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Link Ref</em>'.
   * @see com.netxforge.netxscript.LinkRef
   * @generated
   */
  EClass getLinkRef();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.LinkRef#getLink <em>Link</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Link</em>'.
   * @see com.netxforge.netxscript.LinkRef#getLink()
   * @see #getLinkRef()
   * @generated
   */
  EReference getLinkRef_Link();

  /**
   * Returns the meta object for enum '{@link com.netxforge.netxscript.NativeFunction <em>Native Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Native Function</em>'.
   * @see com.netxforge.netxscript.NativeFunction
   * @generated
   */
  EEnum getNativeFunction();

  /**
   * Returns the meta object for enum '{@link com.netxforge.netxscript.IntervalKind <em>Interval Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Interval Kind</em>'.
   * @see com.netxforge.netxscript.IntervalKind
   * @generated
   */
  EEnum getIntervalKind();

  /**
   * Returns the meta object for enum '{@link com.netxforge.netxscript.ToleranceLevel <em>Tolerance Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Tolerance Level</em>'.
   * @see com.netxforge.netxscript.ToleranceLevel
   * @generated
   */
  EEnum getToleranceLevel();

  /**
   * Returns the meta object for enum '{@link com.netxforge.netxscript.ValueRange <em>Value Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Value Range</em>'.
   * @see com.netxforge.netxscript.ValueRange
   * @generated
   */
  EEnum getValueRange();

  /**
   * Returns the meta object for enum '{@link com.netxforge.netxscript.ValueKind <em>Value Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Value Kind</em>'.
   * @see com.netxforge.netxscript.ValueKind
   * @generated
   */
  EEnum getValueKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  NetxscriptFactory getNetxscriptFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.ModImpl <em>Mod</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.ModImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getMod()
     * @generated
     */
    EClass MOD = eINSTANCE.getMod();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MOD__NAME = eINSTANCE.getMod_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOD__IMPORTS = eINSTANCE.getMod_Imports();

    /**
     * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOD__FUNCTIONS = eINSTANCE.getMod_Functions();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MOD__STATEMENTS = eINSTANCE.getMod_Statements();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.ImportImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.FunctionImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__ARGS = eINSTANCE.getFunction_Args();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__BLOCK = eINSTANCE.getFunction_Block();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.ArgumentImpl <em>Argument</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.ArgumentImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getArgument()
     * @generated
     */
    EClass ARGUMENT = eINSTANCE.getArgument();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARGUMENT__NAME = eINSTANCE.getArgument_Name();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.AbstractVarOrArgumentImpl <em>Abstract Var Or Argument</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.AbstractVarOrArgumentImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getAbstractVarOrArgument()
     * @generated
     */
    EClass ABSTRACT_VAR_OR_ARGUMENT = eINSTANCE.getAbstractVarOrArgument();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.AbstractFunctionImpl <em>Abstract Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.AbstractFunctionImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getAbstractFunction()
     * @generated
     */
    EClass ABSTRACT_FUNCTION = eINSTANCE.getAbstractFunction();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.BlockImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getBlock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getBlock();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.StatementImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.ExpressionImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__INDEX = eINSTANCE.getExpression_Index();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.RangeImpl <em>Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.RangeImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getRange()
     * @generated
     */
    EClass RANGE = eINSTANCE.getRange();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.ReferenceImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = eINSTANCE.getReference();

    /**
     * The meta object literal for the '<em><b>Component</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__COMPONENT = eINSTANCE.getReference_Component();

    /**
     * The meta object literal for the '<em><b>Leaf Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__LEAF_REF = eINSTANCE.getReference_LeafRef();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.LeafReferenceImpl <em>Leaf Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.LeafReferenceImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getLeafReference()
     * @generated
     */
    EClass LEAF_REFERENCE = eINSTANCE.getLeafReference();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.RangeRefImpl <em>Range Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.RangeRefImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getRangeRef()
     * @generated
     */
    EClass RANGE_REF = eINSTANCE.getRangeRef();

    /**
     * The meta object literal for the '<em><b>Valuerange</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE_REF__VALUERANGE = eINSTANCE.getRangeRef_Valuerange();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE_REF__KIND = eINSTANCE.getRangeRef_Kind();

    /**
     * The meta object literal for the '<em><b>Interval</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANGE_REF__INTERVAL = eINSTANCE.getRangeRef_Interval();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.IntervalImpl <em>Interval</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.IntervalImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getInterval()
     * @generated
     */
    EClass INTERVAL = eINSTANCE.getInterval();

    /**
     * The meta object literal for the '<em><b>Interval</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERVAL__INTERVAL = eINSTANCE.getInterval_Interval();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERVAL__KIND = eINSTANCE.getInterval_Kind();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.ReturnImpl <em>Return</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.ReturnImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getReturn()
     * @generated
     */
    EClass RETURN = eINSTANCE.getReturn();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RETURN__EXPRESSION = eINSTANCE.getReturn_Expression();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.IfImpl <em>If</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.IfImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getIf()
     * @generated
     */
    EClass IF = eINSTANCE.getIf();

    /**
     * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF__IF = eINSTANCE.getIf_If();

    /**
     * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF__THEN = eINSTANCE.getIf_Then();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF__ELSE = eINSTANCE.getIf_Else();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.WhileImpl <em>While</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.WhileImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getWhile()
     * @generated
     */
    EClass WHILE = eINSTANCE.getWhile();

    /**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE__PREDICATE = eINSTANCE.getWhile_Predicate();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE__BODY = eINSTANCE.getWhile_Body();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.VariableImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__EXPRESSION = eINSTANCE.getVariable_Expression();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.AssignmentImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getAssignment()
     * @generated
     */
    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__VAR = eINSTANCE.getAssignment_Var();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__EXPRESSION = eINSTANCE.getAssignment_Expression();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.PlusAssignmentImpl <em>Plus Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.PlusAssignmentImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getPlusAssignment()
     * @generated
     */
    EClass PLUS_ASSIGNMENT = eINSTANCE.getPlusAssignment();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS_ASSIGNMENT__VAR = eINSTANCE.getPlusAssignment_Var();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS_ASSIGNMENT__EXPRESSION = eINSTANCE.getPlusAssignment_Expression();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.RefAssignmentImpl <em>Ref Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.RefAssignmentImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getRefAssignment()
     * @generated
     */
    EClass REF_ASSIGNMENT = eINSTANCE.getRefAssignment();

    /**
     * The meta object literal for the '<em><b>Assignment Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_ASSIGNMENT__ASSIGNMENT_REF = eINSTANCE.getRefAssignment_AssignmentRef();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REF_ASSIGNMENT__EXPRESSION = eINSTANCE.getRefAssignment_Expression();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.AndImpl <em>And</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.AndImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getAnd()
     * @generated
     */
    EClass AND = eINSTANCE.getAnd();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND__LEFT = eINSTANCE.getAnd_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND__RIGHT = eINSTANCE.getAnd_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.OrImpl <em>Or</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.OrImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getOr()
     * @generated
     */
    EClass OR = eINSTANCE.getOr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR__LEFT = eINSTANCE.getOr_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR__RIGHT = eINSTANCE.getOr_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.EqualImpl <em>Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.EqualImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getEqual()
     * @generated
     */
    EClass EQUAL = eINSTANCE.getEqual();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUAL__LEFT = eINSTANCE.getEqual_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUAL__RIGHT = eINSTANCE.getEqual_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.UnequalImpl <em>Unequal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.UnequalImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getUnequal()
     * @generated
     */
    EClass UNEQUAL = eINSTANCE.getUnequal();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNEQUAL__LEFT = eINSTANCE.getUnequal_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNEQUAL__RIGHT = eINSTANCE.getUnequal_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.LesserImpl <em>Lesser</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.LesserImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getLesser()
     * @generated
     */
    EClass LESSER = eINSTANCE.getLesser();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LESSER__LEFT = eINSTANCE.getLesser_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LESSER__RIGHT = eINSTANCE.getLesser_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.LesserEqualImpl <em>Lesser Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.LesserEqualImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getLesserEqual()
     * @generated
     */
    EClass LESSER_EQUAL = eINSTANCE.getLesserEqual();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LESSER_EQUAL__LEFT = eINSTANCE.getLesserEqual_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LESSER_EQUAL__RIGHT = eINSTANCE.getLesserEqual_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.GreaterImpl <em>Greater</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.GreaterImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getGreater()
     * @generated
     */
    EClass GREATER = eINSTANCE.getGreater();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREATER__LEFT = eINSTANCE.getGreater_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREATER__RIGHT = eINSTANCE.getGreater_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.GreaterEqualImpl <em>Greater Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.GreaterEqualImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getGreaterEqual()
     * @generated
     */
    EClass GREATER_EQUAL = eINSTANCE.getGreaterEqual();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREATER_EQUAL__LEFT = eINSTANCE.getGreaterEqual_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GREATER_EQUAL__RIGHT = eINSTANCE.getGreaterEqual_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.PlusImpl <em>Plus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.PlusImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getPlus()
     * @generated
     */
    EClass PLUS = eINSTANCE.getPlus();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS__LEFT = eINSTANCE.getPlus_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PLUS__RIGHT = eINSTANCE.getPlus_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.MinusImpl <em>Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.MinusImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getMinus()
     * @generated
     */
    EClass MINUS = eINSTANCE.getMinus();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MINUS__LEFT = eINSTANCE.getMinus_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MINUS__RIGHT = eINSTANCE.getMinus_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.MultiImpl <em>Multi</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.MultiImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getMulti()
     * @generated
     */
    EClass MULTI = eINSTANCE.getMulti();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI__LEFT = eINSTANCE.getMulti_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI__RIGHT = eINSTANCE.getMulti_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.DivImpl <em>Div</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.DivImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getDiv()
     * @generated
     */
    EClass DIV = eINSTANCE.getDiv();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIV__LEFT = eINSTANCE.getDiv_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DIV__RIGHT = eINSTANCE.getDiv_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.ModuloImpl <em>Modulo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.ModuloImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getModulo()
     * @generated
     */
    EClass MODULO = eINSTANCE.getModulo();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULO__LEFT = eINSTANCE.getModulo_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULO__RIGHT = eINSTANCE.getModulo_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.NegationImpl <em>Negation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.NegationImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNegation()
     * @generated
     */
    EClass NEGATION = eINSTANCE.getNegation();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NEGATION__OP = eINSTANCE.getNegation_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NEGATION__RIGHT = eINSTANCE.getNegation_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.UnaryPlusMinusImpl <em>Unary Plus Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.UnaryPlusMinusImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getUnaryPlusMinus()
     * @generated
     */
    EClass UNARY_PLUS_MINUS = eINSTANCE.getUnaryPlusMinus();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_PLUS_MINUS__OP = eINSTANCE.getUnaryPlusMinus_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_PLUS_MINUS__RIGHT = eINSTANCE.getUnaryPlusMinus_Right();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.BooleanLiteralImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getBooleanLiteral()
     * @generated
     */
    EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_LITERAL__CONDITION = eINSTANCE.getBooleanLiteral_Condition();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.NumberLiteralImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNumberLiteral()
     * @generated
     */
    EClass NUMBER_LITERAL = eINSTANCE.getNumberLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMBER_LITERAL__VALUE = eINSTANCE.getNumberLiteral_Value();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.FunctionCallImpl <em>Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.FunctionCallImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getFunctionCall()
     * @generated
     */
    EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();

    /**
     * The meta object literal for the '<em><b>Func</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_CALL__FUNC = eINSTANCE.getFunctionCall_Func();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_CALL__ARGS = eINSTANCE.getFunctionCall_Args();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.NativeExpressionImpl <em>Native Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.NativeExpressionImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNativeExpression()
     * @generated
     */
    EClass NATIVE_EXPRESSION = eINSTANCE.getNativeExpression();

    /**
     * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NATIVE_EXPRESSION__RANGE = eINSTANCE.getNativeExpression_Range();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NATIVE_EXPRESSION__REF = eINSTANCE.getNativeExpression_Ref();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NATIVE_EXPRESSION__VAR = eINSTANCE.getNativeExpression_Var();

    /**
     * The meta object literal for the '<em><b>Native Function</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NATIVE_EXPRESSION__NATIVE_FUNCTION = eINSTANCE.getNativeExpression_NativeFunction();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.VarOrArgumentCallImpl <em>Var Or Argument Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.VarOrArgumentCallImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getVarOrArgumentCall()
     * @generated
     */
    EClass VAR_OR_ARGUMENT_CALL = eINSTANCE.getVarOrArgumentCall();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_OR_ARGUMENT_CALL__CALL = eINSTANCE.getVarOrArgumentCall_Call();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.RangeLiteralImpl <em>Range Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.RangeLiteralImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getRangeLiteral()
     * @generated
     */
    EClass RANGE_LITERAL = eINSTANCE.getRangeLiteral();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RANGE_LITERAL__VALUES = eINSTANCE.getRangeLiteral_Values();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.ParamRefImpl <em>Param Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.ParamRefImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getParamRef()
     * @generated
     */
    EClass PARAM_REF = eINSTANCE.getParamRef();

    /**
     * The meta object literal for the '<em><b>Param</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAM_REF__PARAM = eINSTANCE.getParamRef_Param();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.NodeTypeRefImpl <em>Node Type Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.NodeTypeRefImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNodeTypeRef()
     * @generated
     */
    EClass NODE_TYPE_REF = eINSTANCE.getNodeTypeRef();

    /**
     * The meta object literal for the '<em><b>Nodetype</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_TYPE_REF__NODETYPE = eINSTANCE.getNodeTypeRef_Nodetype();

    /**
     * The meta object literal for the '<em><b>Primary Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_TYPE_REF__PRIMARY_REF = eINSTANCE.getNodeTypeRef_PrimaryRef();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.NodeRefImpl <em>Node Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.NodeRefImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNodeRef()
     * @generated
     */
    EClass NODE_REF = eINSTANCE.getNodeRef();

    /**
     * The meta object literal for the '<em><b>Node</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_REF__NODE = eINSTANCE.getNodeRef_Node();

    /**
     * The meta object literal for the '<em><b>Primary Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_REF__PRIMARY_REF = eINSTANCE.getNodeRef_PrimaryRef();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.ContextRefImpl <em>Context Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.ContextRefImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getContextRef()
     * @generated
     */
    EClass CONTEXT_REF = eINSTANCE.getContextRef();

    /**
     * The meta object literal for the '<em><b>Primary Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_REF__PRIMARY_REF = eINSTANCE.getContextRef_PrimaryRef();

    /**
     * The meta object literal for the '<em><b>Range Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_REF__RANGE_REF = eINSTANCE.getContextRef_RangeRef();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.OperatorRefImpl <em>Operator Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.OperatorRefImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getOperatorRef()
     * @generated
     */
    EClass OPERATOR_REF = eINSTANCE.getOperatorRef();

    /**
     * The meta object literal for the '<em><b>Function</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATOR_REF__FUNCTION = eINSTANCE.getOperatorRef_Function();

    /**
     * The meta object literal for the '<em><b>Equipment</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATOR_REF__EQUIPMENT = eINSTANCE.getOperatorRef_Equipment();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.ResourceRefImpl <em>Resource Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.ResourceRefImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getResourceRef()
     * @generated
     */
    EClass RESOURCE_REF = eINSTANCE.getResourceRef();

    /**
     * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESOURCE_REF__RESOURCE = eINSTANCE.getResourceRef_Resource();

    /**
     * The meta object literal for the '<em><b>All</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESOURCE_REF__ALL = eINSTANCE.getResourceRef_All();

    /**
     * The meta object literal for the '<em><b>Range Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESOURCE_REF__RANGE_REF = eINSTANCE.getResourceRef_RangeRef();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.StatusRefImpl <em>Status Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.StatusRefImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getStatusRef()
     * @generated
     */
    EClass STATUS_REF = eINSTANCE.getStatusRef();

    /**
     * The meta object literal for the '<em><b>Tolerancelevel</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATUS_REF__TOLERANCELEVEL = eINSTANCE.getStatusRef_Tolerancelevel();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.LinkRefImpl <em>Link Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.LinkRefImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getLinkRef()
     * @generated
     */
    EClass LINK_REF = eINSTANCE.getLinkRef();

    /**
     * The meta object literal for the '<em><b>Link</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINK_REF__LINK = eINSTANCE.getLinkRef_Link();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.NativeFunction <em>Native Function</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.NativeFunction
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNativeFunction()
     * @generated
     */
    EEnum NATIVE_FUNCTION = eINSTANCE.getNativeFunction();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.IntervalKind <em>Interval Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.IntervalKind
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getIntervalKind()
     * @generated
     */
    EEnum INTERVAL_KIND = eINSTANCE.getIntervalKind();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.ToleranceLevel <em>Tolerance Level</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.ToleranceLevel
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getToleranceLevel()
     * @generated
     */
    EEnum TOLERANCE_LEVEL = eINSTANCE.getToleranceLevel();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.ValueRange <em>Value Range</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.ValueRange
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getValueRange()
     * @generated
     */
    EEnum VALUE_RANGE = eINSTANCE.getValueRange();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.ValueKind <em>Value Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.ValueKind
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getValueKind()
     * @generated
     */
    EEnum VALUE_KIND = eINSTANCE.getValueKind();

  }

} //NetxscriptPackage
