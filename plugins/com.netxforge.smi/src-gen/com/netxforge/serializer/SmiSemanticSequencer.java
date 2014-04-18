package com.netxforge.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.netxforge.services.SmiGrammarAccess;
import com.netxforge.smi.ASN1_CHOICE;
import com.netxforge.smi.ASN1_CHOICE_ENTRY;
import com.netxforge.smi.ASN1_OCTET_STRING;
import com.netxforge.smi.ASN1_RANGE;
import com.netxforge.smi.ASN1_SIMPLE;
import com.netxforge.smi.ChoiceType;
import com.netxforge.smi.MACRO_VALUE_CAP;
import com.netxforge.smi.MACRO_VALUE_TYPE;
import com.netxforge.smi.Macro;
import com.netxforge.smi.MacroValue;
import com.netxforge.smi.Module;
import com.netxforge.smi.ObjectIdentifier;
import com.netxforge.smi.ObjectIdentifierValue;
import com.netxforge.smi.ParamAssignment;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.Tag;
import com.netxforge.smi.TypeAssignment;
import com.netxforge.smi.TypeDefinition;
import com.netxforge.smi.TypeNotation;
import com.netxforge.smi.TypeNotationRight;
import com.netxforge.smi.UpdateType;
import com.netxforge.smi.Value;
import com.netxforge.smi.ValueNotation;
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
					sequence_ASN1_OCTET_STRING_ASN1_SIMPLE(context, (ASN1_OCTET_STRING) semanticObject); 
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
				if(context == grammarAccess.getASN1_INTEGERRule() ||
				   context == grammarAccess.getASN1_SIMPLERule() ||
				   context == grammarAccess.getASN1_TYPERule()) {
					sequence_ASN1_INTEGER(context, (ASN1_SIMPLE) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getASN1_SUBTYPERule()) {
					sequence_ASN1_SUBTYPE(context, (ASN1_SIMPLE) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.CHOICE_TYPE:
				if(context == grammarAccess.getChoiceTypeRule()) {
					sequence_ChoiceType(context, (ChoiceType) semanticObject); 
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
				if(context == grammarAccess.getMacroValueRule() ||
				   context == grammarAccess.getTypeAssignmentRule()) {
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
			case SmiPackage.TAG:
				if(context == grammarAccess.getTagRule()) {
					sequence_Tag(context, (Tag) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.TYPE_ASSIGNMENT:
				if(context == grammarAccess.getTypeReferenceExtRule()) {
					sequence_TypeReferenceExt(context, (TypeAssignment) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeAssignmentRule() ||
				   context == grammarAccess.getTypeNotationRightRule() ||
				   context == grammarAccess.getTypeReferenceRule()) {
					sequence_TypeReference(context, (TypeAssignment) semanticObject); 
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
			case SmiPackage.TYPE_NOTATION_RIGHT:
				if(context == grammarAccess.getTypeNotationRightRule()) {
					sequence_TypeNotationRight(context, (TypeNotationRight) semanticObject); 
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
			case SmiPackage.VALUE_NOTATION:
				if(context == grammarAccess.getValueNotationRule()) {
					sequence_ValueNotation(context, (ValueNotation) semanticObject); 
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
	 *     (choiceType+=ASN1_CHOICE_ENTRY choiceType+=ASN1_CHOICE_ENTRY*)
	 */
	protected void sequence_ASN1_CHOICE(EObject context, ASN1_CHOICE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=ASN1_ID valueType=ChoiceType)
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
		feeder.accept(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeChoiceTypeParserRuleCall_2_0(), semanticObject.getValueType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name='INTEGER' range=ASN1_RANGE?)
	 */
	protected void sequence_ASN1_INTEGER(EObject context, ASN1_SIMPLE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name='OCTET STRING'
	 */
	protected void sequence_ASN1_OCTET_STRING(EObject context, ASN1_OCTET_STRING semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='OCTET STRING' constraint=ASN1_SUBTYPE?)
	 */
	protected void sequence_ASN1_OCTET_STRING_ASN1_SIMPLE(EObject context, ASN1_OCTET_STRING semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=BIG_INTEGER
	 */
	protected void sequence_ASN1_RANGE(EObject context, ASN1_RANGE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ranges+=ASN1_RANGE ranges+=ASN1_RANGE*)
	 */
	protected void sequence_ASN1_SUBTYPE(EObject context, ASN1_SIMPLE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (typeRef=TypeReference | simpleType=ASN1_TYPE | oi='OBJECT IDENTIFIER')
	 */
	protected void sequence_ChoiceType(EObject context, ChoiceType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {MACRO_VALUE_CAP}
	 */
	protected void sequence_MACRO_VALUE_CAP(EObject context, MACRO_VALUE_CAP semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (update=UpdateType | literal=MACRO_VALUE_CAP | string='IA5String')
	 */
	protected void sequence_MACRO_VALUE_TYPE(EObject context, MACRO_VALUE_TYPE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     valueType=MACRO_VALUE_TYPE
	 */
	protected void sequence_MacroValue(EObject context, MacroValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=MODULE_ID typeNotation=TypeNotation valueNotation=ValueNotation innerTypes+=TypeDefinition+)
	 */
	protected void sequence_Macro(EObject context, Macro semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=MODULE_ID (identifiers+=ObjectIdentifier | types+=TypeDefinition | macros+=Macro)+)
	 */
	protected void sequence_Module(EObject context, Module semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=ASN1_ID | descriptorReference=[ObjectIdentifier|ASN1_ID])? subIds+=BIG_INTEGER subIds+=BIG_INTEGER*)
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
		feeder.accept(grammarAccess.getObjectIdentifierAccess().getNameASN1_IDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_5_0(), semanticObject.getOidValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (param=PARAMETER right=TypeNotationRight)
	 */
	protected void sequence_ParamAssignment(EObject context, ParamAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     tagValue=BIG_INTEGER
	 */
	protected void sequence_Tag(EObject context, Tag semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.TAG__TAG_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.TAG__TAG_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTagAccess().getTagValueBIG_INTEGERTerminalRuleCall_2_0(), semanticObject.getTagValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=MODULE_ID values+=Value+)
	 */
	protected void sequence_TypeDefinition(EObject context, TypeDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=MacroValue
	 */
	protected void sequence_TypeNotationRight(EObject context, TypeNotationRight semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.TYPE_NOTATION_RIGHT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.TYPE_NOTATION_RIGHT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTypeNotationRightAccess().getValueMacroValueParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name='TYPE NOTATION' typeNotations+=TypeAssignment+)
	 */
	protected void sequence_TypeNotation(EObject context, TypeNotation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (parentRef=TypeReference childRef=TypeReference?)
	 */
	protected void sequence_TypeReferenceExt(EObject context, TypeAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     type=[TypeDefinition|MODULE_ID]
	 */
	protected void sequence_TypeReference(EObject context, TypeAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ref=TypeReference
	 */
	protected void sequence_UpdateType(EObject context, UpdateType semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.UPDATE_TYPE__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.UPDATE_TYPE__REF));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUpdateTypeAccess().getRefTypeReferenceParserRuleCall_1_0(), semanticObject.getRef());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name='VALUE NOTATION' valueNotation=MacroValue)
	 */
	protected void sequence_ValueNotation(EObject context, ValueNotation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.VALUE_NOTATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.VALUE_NOTATION__NAME));
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.VALUE_NOTATION__VALUE_NOTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.VALUE_NOTATION__VALUE_NOTATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getValueNotationAccess().getNameVALUENOTATIONKeyword_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getValueNotationAccess().getValueNotationMacroValueParserRuleCall_4_0(), semanticObject.getValueNotation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (param=ParamAssignment | types=TypeReferenceExt | simpleType=ASN1_TYPE | macroValue=MacroValue | oi='OBJECT IDENTIFIER')
	 */
	protected void sequence_ValueType(EObject context, ValueType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (tag=Tag? implicit?='IMPLICIT'? valueTypes+=ValueType valueTypes+=ValueType*)
	 */
	protected void sequence_Value(EObject context, Value semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
