/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
   * The number of structural features of the '<em>Mod</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOD_FEATURE_COUNT = 3;

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
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__EXPRESSION = ABSTRACT_VAR_OR_ARGUMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = ABSTRACT_VAR_OR_ARGUMENT_FEATURE_COUNT + 1;

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
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__EXPRESSION = STATEMENT__EXPRESSION;

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
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.NodeDepthImpl <em>Node Depth</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.NodeDepthImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNodeDepth()
   * @generated
   */
  int NODE_DEPTH = 9;

  /**
   * The number of structural features of the '<em>Node Depth</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_DEPTH_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.PrimaryNodeRefImpl <em>Primary Node Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.PrimaryNodeRefImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getPrimaryNodeRef()
   * @generated
   */
  int PRIMARY_NODE_REF = 10;

  /**
   * The feature id for the '<em><b>Depth</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_NODE_REF__DEPTH = NODE_DEPTH_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Res Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_NODE_REF__RES_REF = NODE_DEPTH_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Node Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_NODE_REF__NODE_REF = NODE_DEPTH_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Primary Node Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_NODE_REF_FEATURE_COUNT = NODE_DEPTH_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.BlankStatementImpl <em>Blank Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.BlankStatementImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getBlankStatement()
   * @generated
   */
  int BLANK_STATEMENT = 11;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLANK_STATEMENT__EXPRESSION = STATEMENT__EXPRESSION;

  /**
   * The number of structural features of the '<em>Blank Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLANK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.VariableImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 12;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__EXPRESSION = STATEMENT__EXPRESSION;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.AndImpl <em>And</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.AndImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getAnd()
   * @generated
   */
  int AND = 13;

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
  int OR = 14;

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
  int EQUAL = 15;

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
  int UNEQUAL = 16;

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
  int LESSER = 17;

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
  int LESSER_EQUAL = 18;

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
  int GREATER = 19;

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
  int GREATER_EQUAL = 20;

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
  int PLUS = 21;

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
  int MINUS = 22;

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
  int MULTI = 23;

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
  int DIV = 24;

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
  int MODULO = 25;

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
  int NEGATION = 26;

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
  int UNARY_PLUS_MINUS = 27;

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
   * The meta object id for the '{@link com.netxforge.netxscript.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.NumberLiteralImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNumberLiteral()
   * @generated
   */
  int NUMBER_LITERAL = 28;

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
   * The meta object id for the '{@link com.netxforge.netxscript.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.BooleanLiteralImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 29;

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
   * The meta object id for the '{@link com.netxforge.netxscript.impl.ModelReferenceImpl <em>Model Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.ModelReferenceImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getModelReference()
   * @generated
   */
  int MODEL_REFERENCE = 30;

  /**
   * The feature id for the '<em><b>Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_REFERENCE__NODE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Model Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.netxforge.netxscript.impl.FunctionCallImpl <em>Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.FunctionCallImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getFunctionCall()
   * @generated
   */
  int FUNCTION_CALL = 31;

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
   * The meta object id for the '{@link com.netxforge.netxscript.impl.VarOrArgumentCallImpl <em>Var Or Argument Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.netxforge.netxscript.impl.VarOrArgumentCallImpl
   * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getVarOrArgumentCall()
   * @generated
   */
  int VAR_OR_ARGUMENT_CALL = 32;

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
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.Statement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.netxforge.netxscript.Statement#getExpression()
   * @see #getStatement()
   * @generated
   */
  EReference getStatement_Expression();

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
   * Returns the meta object for class '{@link com.netxforge.netxscript.NodeDepth <em>Node Depth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Depth</em>'.
   * @see com.netxforge.netxscript.NodeDepth
   * @generated
   */
  EClass getNodeDepth();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.PrimaryNodeRef <em>Primary Node Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Node Ref</em>'.
   * @see com.netxforge.netxscript.PrimaryNodeRef
   * @generated
   */
  EClass getPrimaryNodeRef();

  /**
   * Returns the meta object for the containment reference list '{@link com.netxforge.netxscript.PrimaryNodeRef#getDepth <em>Depth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Depth</em>'.
   * @see com.netxforge.netxscript.PrimaryNodeRef#getDepth()
   * @see #getPrimaryNodeRef()
   * @generated
   */
  EReference getPrimaryNodeRef_Depth();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.PrimaryNodeRef#getResRef <em>Res Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Res Ref</em>'.
   * @see com.netxforge.netxscript.PrimaryNodeRef#getResRef()
   * @see #getPrimaryNodeRef()
   * @generated
   */
  EReference getPrimaryNodeRef_ResRef();

  /**
   * Returns the meta object for the reference '{@link com.netxforge.netxscript.PrimaryNodeRef#getNodeRef <em>Node Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Node Ref</em>'.
   * @see com.netxforge.netxscript.PrimaryNodeRef#getNodeRef()
   * @see #getPrimaryNodeRef()
   * @generated
   */
  EReference getPrimaryNodeRef_NodeRef();

  /**
   * Returns the meta object for class '{@link com.netxforge.netxscript.BlankStatement <em>Blank Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Blank Statement</em>'.
   * @see com.netxforge.netxscript.BlankStatement
   * @generated
   */
  EClass getBlankStatement();

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
   * Returns the meta object for class '{@link com.netxforge.netxscript.ModelReference <em>Model Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Reference</em>'.
   * @see com.netxforge.netxscript.ModelReference
   * @generated
   */
  EClass getModelReference();

  /**
   * Returns the meta object for the containment reference '{@link com.netxforge.netxscript.ModelReference#getNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Node</em>'.
   * @see com.netxforge.netxscript.ModelReference#getNode()
   * @see #getModelReference()
   * @generated
   */
  EReference getModelReference_Node();

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
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__EXPRESSION = eINSTANCE.getStatement_Expression();

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
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.NodeDepthImpl <em>Node Depth</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.NodeDepthImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getNodeDepth()
     * @generated
     */
    EClass NODE_DEPTH = eINSTANCE.getNodeDepth();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.PrimaryNodeRefImpl <em>Primary Node Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.PrimaryNodeRefImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getPrimaryNodeRef()
     * @generated
     */
    EClass PRIMARY_NODE_REF = eINSTANCE.getPrimaryNodeRef();

    /**
     * The meta object literal for the '<em><b>Depth</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_NODE_REF__DEPTH = eINSTANCE.getPrimaryNodeRef_Depth();

    /**
     * The meta object literal for the '<em><b>Res Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_NODE_REF__RES_REF = eINSTANCE.getPrimaryNodeRef_ResRef();

    /**
     * The meta object literal for the '<em><b>Node Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMARY_NODE_REF__NODE_REF = eINSTANCE.getPrimaryNodeRef_NodeRef();

    /**
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.BlankStatementImpl <em>Blank Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.BlankStatementImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getBlankStatement()
     * @generated
     */
    EClass BLANK_STATEMENT = eINSTANCE.getBlankStatement();

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
     * The meta object literal for the '{@link com.netxforge.netxscript.impl.ModelReferenceImpl <em>Model Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.netxforge.netxscript.impl.ModelReferenceImpl
     * @see com.netxforge.netxscript.impl.NetxscriptPackageImpl#getModelReference()
     * @generated
     */
    EClass MODEL_REFERENCE = eINSTANCE.getModelReference();

    /**
     * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_REFERENCE__NODE = eINSTANCE.getModelReference_Node();

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

  }

} //NetxscriptPackage
