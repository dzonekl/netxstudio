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
import com.netxforge.smi.Macro;
import com.netxforge.smi.MacroValue;
import com.netxforge.smi.Module;
import com.netxforge.smi.ObjectIdentifier;
import com.netxforge.smi.ObjectIdentifierValue;
import com.netxforge.smi.Or;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.ValueAssignment;
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
				if(context == grammarAccess.getASN1_OCTET_STRINGRule() ||
				   context == grammarAccess.getASN1_SIMPLERule() ||
				   context == grammarAccess.getASN1_TYPERule()) {
					sequence_ASN1_OCTET_STRING(context, (ASN1_OCTET_STRING) semanticObject); 
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
				if(context == grammarAccess.getAssignmentRule() ||
				   context == grammarAccess.getObjectIdentifierRule()) {
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
			case SmiPackage.OR:
				if(context == grammarAccess.getOrRule() ||
				   context == grammarAccess.getOrAccess().getOrLeftAction_1_0_0()) {
					sequence_Or(context, (Or) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.VALUE_ASSIGNMENT:
				if(context == grammarAccess.getValueAssignmentRule()) {
					sequence_ValueAssignment(context, (ValueAssignment) semanticObject); 
					return; 
				}
				else break;
			case SmiPackage.VALUE_TYPE:
				if(context == grammarAccess.getOrRule() ||
				   context == grammarAccess.getOrAccess().getOrLeftAction_1_0_0() ||
				   context == grammarAccess.getValueTypeRule()) {
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
	 *     (valuePairs+=ASN1_VALUEPAIR+ constraint=ASN1_SUBTYPE?)
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
	 *     (start=INT end=INT)
	 */
	protected void sequence_ASN1_RANGE(EObject context, ASN1_RANGE semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.ASN1_RANGE__START) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.ASN1_RANGE__START));
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.ASN1_RANGE__END) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.ASN1_RANGE__END));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getASN1_RANGEAccess().getStartINTTerminalRuleCall_2_0_0(), semanticObject.getStart());
		feeder.accept(grammarAccess.getASN1_RANGEAccess().getEndINTTerminalRuleCall_2_2_0(), semanticObject.getEnd());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (range=ASN1_RANGE | value=INT)
	 */
	protected void sequence_ASN1_SUBTYPE(EObject context, ASN1_SUBTYPE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (macros=Macro | types+=ValueAssignment)
	 */
	protected void sequence_Assignment(EObject context, Assignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=MACRO_VALUE_TYPE?)
	 */
	protected void sequence_MacroValue(EObject context, MacroValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (descriptor=MacroDescriptor typeNotations+=[ValueAssignment|ID]+ valueNotation=MacroValue innerTypes+=ValueAssignment+)
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
	 *     (descriptorReference=[ObjectIdentifier|ASN1_ID]? subIds+=INT subIds+=INT*)
	 */
	protected void sequence_ObjectIdentifierValue(EObject context, ObjectIdentifierValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (descriptor=ASN1_ID oidValue=ObjectIdentifierValue)
	 */
	protected void sequence_ObjectIdentifier(EObject context, ObjectIdentifier semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Or_Or_1_0_0 right=ValueType)
	 */
	protected void sequence_Or(EObject context, Or semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.OR__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.OR__LEFT));
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.OR__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.OR__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOrAccess().getOrLeftAction_1_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getOrAccess().getRightValueTypeParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (typeReference=MODULE_ID value=Or)
	 */
	protected void sequence_ValueAssignment(EObject context, ValueAssignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.VALUE_ASSIGNMENT__TYPE_REFERENCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.VALUE_ASSIGNMENT__TYPE_REFERENCE));
			if(transientValues.isValueTransient(semanticObject, SmiPackage.Literals.VALUE_ASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SmiPackage.Literals.VALUE_ASSIGNMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getValueAssignmentAccess().getTypeReferenceMODULE_IDTerminalRuleCall_0_0(), semanticObject.getTypeReference());
		feeder.accept(grammarAccess.getValueAssignmentAccess().getValueOrParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=IA5STRING? (type=[ValueAssignment|ID] | simpleType=ASN1_TYPE))
	 */
	protected void sequence_ValueType(EObject context, ValueType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
