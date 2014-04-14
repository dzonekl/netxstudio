package com.netxforge.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.netxforge.services.SmiGrammarAccess;
import com.netxforge.smi.ASN1_CHOICE;
import com.netxforge.smi.ASN1_CHOICE_ENTRY;
import com.netxforge.smi.ASN1_OCTET_STRING;
import com.netxforge.smi.ASN1_RANGE;
import com.netxforge.smi.ASN1_SIMPLE;
import com.netxforge.smi.ASN1_SUBTYPE;
import com.netxforge.smi.Assignment;
import com.netxforge.smi.MACRO_VALUE_CAP;
import com.netxforge.smi.MACRO_VALUE_TYPE;
import com.netxforge.smi.Macro;
import com.netxforge.smi.MacroValue;
import com.netxforge.smi.Module;
import com.netxforge.smi.ObjectIdentifier;
import com.netxforge.smi.ObjectIdentifierValue;
import com.netxforge.smi.ParamAssignment;
import com.netxforge.smi.Scope;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.TypeDefinition;
import com.netxforge.smi.TypeNotation;
import com.netxforge.smi.TypeReference;
import com.netxforge.smi.UpdateType;
import com.netxforge.smi.Value;
import com.netxforge.smi.ValueType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class SmiSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private SmiGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == SmiPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SmiPackage.ASN1_CHOICE:
				if(context == grammarAccess.getASN1_CHOICERule() ||
				   context == grammarAccess.getASN1_TYPERule()) {
					sequence_ASN1_CHOICE(context, (ASN1_CHOICE) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.ASN1_CHOICE_ENTRY:
				if(context == grammarAccess.getASN1_CHOICE_ENTRYRule()) {
					sequence_ASN1_CHOICE_ENTRY(context, (ASN1_CHOICE_ENTRY) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.ASN1_OCTET_STRING:
				if(context == grammarAccess.getASN1_OCTET_STRINGRule()) {
					sequence_ASN1_OCTET_STRING(context, (ASN1_OCTET_STRING) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getASN1_SIMPLERule() ||
				   context == grammarAccess.getASN1_TYPERule()) {
					sequence_ASN1_SIMPLE(context, (ASN1_OCTET_STRING) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.ASN1_RANGE:
				if(context == grammarAccess.getASN1_RANGERule()) {
					sequence_ASN1_RANGE(context, (ASN1_RANGE) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.ASN1_SIMPLE:
				if(context == grammarAccess.getASN1_INTEGERRule()) {
					sequence_ASN1_INTEGER(context, (ASN1_SIMPLE) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getASN1_SIMPLERule() ||
				   context == grammarAccess.getASN1_TYPERule()) {
					sequence_ASN1_INTEGER_ASN1_SIMPLE(context, (ASN1_SIMPLE) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.ASN1_SUBTYPE:
				if(context == grammarAccess.getASN1_SUBTYPERule()) {
					sequence_ASN1_SUBTYPE(context, (ASN1_SUBTYPE) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.ASSIGNMENT:
				if(context == grammarAccess.getAssignmentRule()) {
					sequence_Assignment(context, (Assignment) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.MACRO_VALUE_CAP:
				if(context == grammarAccess.getMACRO_VALUE_CAPRule()) {
					sequence_MACRO_VALUE_CAP(context, (MACRO_VALUE_CAP) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.MACRO_VALUE_TYPE:
				if(context == grammarAccess.getMACRO_VALUE_TYPERule()) {
					sequence_MACRO_VALUE_TYPE(context, (MACRO_VALUE_TYPE) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.MACRO:
				if(context == grammarAccess.getMacroRule()) {
					sequence_Macro(context, (Macro) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.MACRO_VALUE:
				if(context == grammarAccess.getMacroValueRule()) {
					sequence_MacroValue(context, (MacroValue) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.MODULE:
				if(context == grammarAccess.getModuleRule()) {
					sequence_Module(context, (Module) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.OBJECT_IDENTIFIER:
				if(context == grammarAccess.getObjectIdentifierRule()) {
					sequence_ObjectIdentifier(context, (ObjectIdentifier) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.OBJECT_IDENTIFIER_VALUE:
				if(context == grammarAccess.getObjectIdentifierValueRule()) {
					sequence_ObjectIdentifierValue(context, (ObjectIdentifierValue) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.PARAM_ASSIGNMENT:
				if(context == grammarAccess.getParamAssignmentRule() ||
				   context == grammarAccess.getTypeAssignmentRule()) {
					sequence_ParamAssignment(context, (ParamAssignment) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.SCOPE:
				if(context == grammarAccess.getScopeRule()) {
					sequence_Scope(context, (Scope) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.TYPE_DEFINITION:
				if(context == grammarAccess.getTypeDefinitionRule()) {
					sequence_TypeDefinition(context, (TypeDefinition) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.TYPE_NOTATION:
				if(context == grammarAccess.getTypeNotationRule()) {
					sequence_TypeNotation(context, (TypeNotation) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.TYPE_REFERENCE:
				if(context == grammarAccess.getTypeAssignmentRule() ||
				   context == grammarAccess.getTypeNotationRule() ||
				   context == grammarAccess.getTypeReferenceRule()) {
					sequence_TypeReference(context, (TypeReference) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeReferenceExtRule()) {
					sequence_TypeReference_TypeReferenceExt(context, (TypeReference) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.UPDATE_TYPE:
				if(context == grammarAccess.getUpdateTypeRule()) {
					sequence_UpdateType(context, (UpdateType) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.VALUE:
				if(context == grammarAccess.getValueRule()) {
					sequence_Value(context, (Value) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.VALUE_TYPE:
				if(context == grammarAccess.getValueTypeRule()) {
					sequence_ValueType(context, (ValueType) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (choices+=ASN1_CHOICE_ENTRY choices+=ASN1_CHOICE_ENTRY*)
	 */
	protected void sequence_ASN1_CHOICE(EObject context, ASN1_CHOICE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=ASN1_ID valueType=[ValueType|ID])
	 */
	protected void sequence_ASN1_CHOICE_ENTRY(EObject context, ASN1_CHOICE_ENTRY semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.ASN1_CHOICE_ENTRY__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.ASN1_CHOICE_ENTRY__ID));
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.ASN1_CHOICE_ENTRY__VALUE_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.ASN1_CHOICE_ENTRY__VALUE_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdASN1_IDTerminalRuleCall_0_0(), semanticObject.getId());
		feeder.accept(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueTypeIDTerminalRuleCall_1_0_1(), semanticObject.getValueType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     valuePairs+=ASN1_VALUEPAIR+
	 */
	protected void sequence_ASN1_INTEGER(EObject context, ASN1_SIMPLE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (valuePairs+=ASN1_VALUEPAIR+ constraint=ASN1_RANGE?)
	 */
	protected void sequence_ASN1_INTEGER_ASN1_SIMPLE(EObject context, ASN1_SIMPLE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ASN1_OCTET_STRING}
	 */
	protected void sequence_ASN1_OCTET_STRING(EObject context, ASN1_OCTET_STRING semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_ASN1_RANGE(EObject context, ASN1_RANGE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (constraint=ASN1_SUBTYPE?)
	 */
	protected void sequence_ASN1_SIMPLE(EObject context, ASN1_OCTET_STRING semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ranges+=ASN1_RANGE ranges+=ASN1_RANGE*)
	 */
	protected void sequence_ASN1_SUBTYPE(EObject context, ASN1_SUBTYPE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (identifier=ObjectIdentifier | type=TypeDefinition | macro=Macro)
	 */
	protected void sequence_Assignment(EObject context, Assignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value='VALUE' literal=VALUE_CAP_LITERALS)
	 */
	protected void sequence_MACRO_VALUE_CAP(EObject context, MACRO_VALUE_CAP semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.MACRO_VALUE_CAP__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.MACRO_VALUE_CAP__VALUE));
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.MACRO_VALUE_CAP__LITERAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.MACRO_VALUE_CAP__LITERAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMACRO_VALUE_CAPAccess().getValueVALUEKeyword_0_0(), semanticObject.getValue());
		feeder.accept(grammarAccess.getMACRO_VALUE_CAPAccess().getLiteralVALUE_CAP_LITERALSEnumRuleCall_1_0(), semanticObject.getLiteral());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (valLiteral=MACRO_VALUE_CAP | update=UpdateType)
	 */
	protected void sequence_MACRO_VALUE_TYPE(EObject context, MACRO_VALUE_TYPE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     type=MACRO_VALUE_TYPE
	 */
	protected void sequence_MacroValue(EObject context, MacroValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.MACRO_VALUE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.MACRO_VALUE__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMacroValueAccess().getTypeMACRO_VALUE_TYPEParserRuleCall_3_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=MODULE_ID typeNotations+=TypeAssignment+ valueNotation=MacroValue innerTypes+=TypeDefinition+)
	 */
	protected void sequence_Macro(EObject context, Macro semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=MODULE_ID assignments+=Assignment*)
	 */
	protected void sequence_Module(EObject context, Module semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (descriptorReference=[ObjectIdentifier|ID]? subIds+=INT subIds+=INT*)
	 */
	protected void sequence_ObjectIdentifierValue(EObject context, ObjectIdentifierValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ASN1_ID oidValue=ObjectIdentifierValue)
	 */
	protected void sequence_ObjectIdentifier(EObject context, ObjectIdentifier semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.OBJECT_IDENTIFIER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.OBJECT_IDENTIFIER__NAME));
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.OBJECT_IDENTIFIER__OID_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.OBJECT_IDENTIFIER__OID_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getObjectIdentifierAccess().getNameASN1_IDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_4_0(), semanticObject.getOidValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (param=PARAMETER right=TypeNotation)
	 */
	protected void sequence_ParamAssignment(EObject context, ParamAssignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.PARAM_ASSIGNMENT__PARAM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.PARAM_ASSIGNMENT__PARAM));
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.PARAM_ASSIGNMENT__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.PARAM_ASSIGNMENT__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParamAssignmentAccess().getParamPARAMETERTerminalRuleCall_0_0(), semanticObject.getParam());
		feeder.accept(grammarAccess.getParamAssignmentAccess().getRightTypeNotationParserRuleCall_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     scope=Value
	 */
	protected void sequence_Scope(EObject context, Scope semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.SCOPE__SCOPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.SCOPE__SCOPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getScopeAccess().getScopeValueParserRuleCall_0(), semanticObject.getScope());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=MODULE_ID scope=Scope)
	 */
	protected void sequence_TypeDefinition(EObject context, TypeDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.TYPE_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.TYPE_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.TYPE_DEFINITION__SCOPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.TYPE_DEFINITION__SCOPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTypeDefinitionAccess().getNameMODULE_IDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTypeDefinitionAccess().getScopeScopeParserRuleCall_2_0(), semanticObject.getScope());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=MacroValue
	 */
	protected void sequence_TypeNotation(EObject context, TypeNotation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.TYPE_NOTATION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.TYPE_NOTATION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTypeNotationAccess().getValueMacroValueParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     type=[TypeDefinition|MODULE_ID]
	 */
	protected void sequence_TypeReference(EObject context, TypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[TypeDefinition|MODULE_ID] right=TypeReference?)
	 */
	protected void sequence_TypeReference_TypeReferenceExt(EObject context, TypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     type=[TypeDefinition|MODULE_ID]
	 */
	protected void sequence_UpdateType(EObject context, UpdateType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.UPDATE_TYPE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.UPDATE_TYPE__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUpdateTypeAccess().getTypeTypeDefinitionMODULE_IDTerminalRuleCall_1_0_1(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=IA5STRING? (param=ParamAssignment | type=TypeReferenceExt | simpleType=ASN1_TYPE | macroValue=MacroValue | oi='OBJECT IDENTIFIER'))
	 */
	protected void sequence_ValueType(EObject context, ValueType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (valueTypes+=ValueType valueTypes+=ValueType*)
	 */
	protected void sequence_Value(EObject context, Value semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
