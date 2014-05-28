/*
* generated by Xtext
*/
package com.netxforge.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import com.netxforge.services.SmiGrammarAccess;

public class SmiParser extends AbstractContentAssistParser {
	
	@Inject
	private SmiGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected com.netxforge.ui.contentassist.antlr.internal.InternalSmiParser createParser() {
		com.netxforge.ui.contentassist.antlr.internal.InternalSmiParser result = new com.netxforge.ui.contentassist.antlr.internal.InternalSmiParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getModuleAccess().getAlternatives_5(), "rule__Module__Alternatives_5");
					put(grammarAccess.getImportRefAccess().getAlternatives(), "rule__ImportRef__Alternatives");
					put(grammarAccess.getObjectReferenceableAccess().getAlternatives_3(), "rule__ObjectReferenceable__Alternatives_3");
					put(grammarAccess.getObjectReferenceAccess().getAlternatives_0(), "rule__ObjectReference__Alternatives_0");
					put(grammarAccess.getAttributeValueAccess().getAlternatives(), "rule__AttributeValue__Alternatives");
					put(grammarAccess.getAttributeValueAccess().getAlternatives_0_1(), "rule__AttributeValue__Alternatives_0_1");
					put(grammarAccess.getReferenceableAccess().getAlternatives(), "rule__Referenceable__Alternatives");
					put(grammarAccess.getTypeAssignmentAccess().getAlternatives_1(), "rule__TypeAssignment__Alternatives_1");
					put(grammarAccess.getTypeNotationRightAccess().getAlternatives(), "rule__TypeNotationRight__Alternatives");
					put(grammarAccess.getTypeReferenceAccess().getAlternatives(), "rule__TypeReference__Alternatives");
					put(grammarAccess.getValueTypeAccess().getAlternatives(), "rule__ValueType__Alternatives");
					put(grammarAccess.getMacroValueTypeAccess().getAlternatives_1(), "rule__MacroValueType__Alternatives_1");
					put(grammarAccess.getASN1_TYPEAccess().getAlternatives(), "rule__ASN1_TYPE__Alternatives");
					put(grammarAccess.getASN1_SIMPLEAccess().getAlternatives(), "rule__ASN1_SIMPLE__Alternatives");
					put(grammarAccess.getASN1_RANGEAccess().getAlternatives(), "rule__ASN1_RANGE__Alternatives");
					put(grammarAccess.getChoiceTypeAccess().getAlternatives_1(), "rule__ChoiceType__Alternatives_1");
					put(grammarAccess.getModuleAccess().getGroup(), "rule__Module__Group__0");
					put(grammarAccess.getImportsAccess().getGroup(), "rule__Imports__Group__0");
					put(grammarAccess.getImportClosureAccess().getGroup(), "rule__ImportClosure__Group__0");
					put(grammarAccess.getImportRefsAccess().getGroup(), "rule__ImportRefs__Group__0");
					put(grammarAccess.getImportRefsAccess().getGroup_2(), "rule__ImportRefs__Group_2__0");
					put(grammarAccess.getObjectReferenceableAccess().getGroup(), "rule__ObjectReferenceable__Group__0");
					put(grammarAccess.getObjectAccess().getGroup(), "rule__Object__Group__0");
					put(grammarAccess.getObjectReferenceAccess().getGroup(), "rule__ObjectReference__Group__0");
					put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
					put(grammarAccess.getAttributeValueAccess().getGroup_0(), "rule__AttributeValue__Group_0__0");
					put(grammarAccess.getAttributeValueAccess().getGroup_0_1_2(), "rule__AttributeValue__Group_0_1_2__0");
					put(grammarAccess.getAttributeValueAccess().getGroup_4(), "rule__AttributeValue__Group_4__0");
					put(grammarAccess.getBracedObjectReferenceAccess().getGroup(), "rule__BracedObjectReference__Group__0");
					put(grammarAccess.getTypeDefinitionAccess().getGroup(), "rule__TypeDefinition__Group__0");
					put(grammarAccess.getMacroAccess().getGroup(), "rule__Macro__Group__0");
					put(grammarAccess.getTypeNotationAccess().getGroup(), "rule__TypeNotation__Group__0");
					put(grammarAccess.getValueNotationAccess().getGroup(), "rule__ValueNotation__Group__0");
					put(grammarAccess.getTypeAssignmentAccess().getGroup(), "rule__TypeAssignment__Group__0");
					put(grammarAccess.getParamAssignmentAccess().getGroup(), "rule__ParamAssignment__Group__0");
					put(grammarAccess.getTypeReferenceExtAccess().getGroup(), "rule__TypeReferenceExt__Group__0");
					put(grammarAccess.getBracedTypeReferenceAccess().getGroup(), "rule__BracedTypeReference__Group__0");
					put(grammarAccess.getValueAssignmentAccess().getGroup(), "rule__ValueAssignment__Group__0");
					put(grammarAccess.getValueAccess().getGroup(), "rule__Value__Group__0");
					put(grammarAccess.getValueAccess().getGroup_4(), "rule__Value__Group_4__0");
					put(grammarAccess.getTagAccess().getGroup(), "rule__Tag__Group__0");
					put(grammarAccess.getValueTypeAccess().getGroup_5(), "rule__ValueType__Group_5__0");
					put(grammarAccess.getMacroValueAccess().getGroup(), "rule__MacroValue__Group__0");
					put(grammarAccess.getMacroValueTypeAccess().getGroup(), "rule__MacroValueType__Group__0");
					put(grammarAccess.getASN1_SIMPLEAccess().getGroup_0(), "rule__ASN1_SIMPLE__Group_0__0");
					put(grammarAccess.getASN1_SIMPLEAccess().getGroup_1(), "rule__ASN1_SIMPLE__Group_1__0");
					put(grammarAccess.getASN1_SIMPLEAccess().getGroup_2(), "rule__ASN1_SIMPLE__Group_2__0");
					put(grammarAccess.getASN1_OCTET_STRINGAccess().getGroup(), "rule__ASN1_OCTET_STRING__Group__0");
					put(grammarAccess.getASN1_INTEGERAccess().getGroup(), "rule__ASN1_INTEGER__Group__0");
					put(grammarAccess.getASN1_INTEGERAccess().getGroup_1(), "rule__ASN1_INTEGER__Group_1__0");
					put(grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getGroup(), "rule__ASN1_INTEGER_REFINEMENT__Group__0");
					put(grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getGroup_1(), "rule__ASN1_INTEGER_REFINEMENT__Group_1__0");
					put(grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getGroup_2(), "rule__ASN1_INTEGER_REFINEMENT__Group_2__0");
					put(grammarAccess.getASN1_SUBTYPEAccess().getGroup(), "rule__ASN1_SUBTYPE__Group__0");
					put(grammarAccess.getASN1_SUBTYPEAccess().getGroup_4(), "rule__ASN1_SUBTYPE__Group_4__0");
					put(grammarAccess.getASN1_RANGEAccess().getGroup_0(), "rule__ASN1_RANGE__Group_0__0");
					put(grammarAccess.getASN1_RANGEAccess().getGroup_1(), "rule__ASN1_RANGE__Group_1__0");
					put(grammarAccess.getASN1_CHOICEAccess().getGroup(), "rule__ASN1_CHOICE__Group__0");
					put(grammarAccess.getASN1_CHOICEAccess().getGroup_4(), "rule__ASN1_CHOICE__Group_4__0");
					put(grammarAccess.getASN1_SEQUENCEAccess().getGroup(), "rule__ASN1_SEQUENCE__Group__0");
					put(grammarAccess.getASN1_SEQUENCEAccess().getGroup_4(), "rule__ASN1_SEQUENCE__Group_4__0");
					put(grammarAccess.getASN1_SEQUENCE_OFAccess().getGroup(), "rule__ASN1_SEQUENCE_OF__Group__0");
					put(grammarAccess.getASN1_CHOICE_ENTRYAccess().getGroup(), "rule__ASN1_CHOICE_ENTRY__Group__0");
					put(grammarAccess.getChoiceTypeAccess().getGroup(), "rule__ChoiceType__Group__0");
					put(grammarAccess.getModuleAccess().getNameAssignment_0(), "rule__Module__NameAssignment_0");
					put(grammarAccess.getModuleAccess().getImportsAssignment_4(), "rule__Module__ImportsAssignment_4");
					put(grammarAccess.getModuleAccess().getObjectsAssignment_5_0(), "rule__Module__ObjectsAssignment_5_0");
					put(grammarAccess.getModuleAccess().getTypesAssignment_5_1(), "rule__Module__TypesAssignment_5_1");
					put(grammarAccess.getImportsAccess().getImportsAssignment_2(), "rule__Imports__ImportsAssignment_2");
					put(grammarAccess.getImportClosureAccess().getRefsAssignment_0(), "rule__ImportClosure__RefsAssignment_0");
					put(grammarAccess.getImportClosureAccess().getImportURIAssignment_3(), "rule__ImportClosure__ImportURIAssignment_3");
					put(grammarAccess.getImportRefsAccess().getRefsAssignment_1(), "rule__ImportRefs__RefsAssignment_1");
					put(grammarAccess.getImportRefsAccess().getRefsAssignment_2_2(), "rule__ImportRefs__RefsAssignment_2_2");
					put(grammarAccess.getImportRefAccess().getOiRefAssignment_0(), "rule__ImportRef__OiRefAssignment_0");
					put(grammarAccess.getImportRefAccess().getTypeRefAssignment_1(), "rule__ImportRef__TypeRefAssignment_1");
					put(grammarAccess.getObjectReferenceableAccess().getNameAssignment_1(), "rule__ObjectReferenceable__NameAssignment_1");
					put(grammarAccess.getObjectReferenceableAccess().getObjectAssignment_3_1(), "rule__ObjectReferenceable__ObjectAssignment_3_1");
					put(grammarAccess.getObjectReferenceableAccess().getObjectValueAssignment_7(), "rule__ObjectReferenceable__ObjectValueAssignment_7");
					put(grammarAccess.getObjectAccess().getMacroRefAssignment_0(), "rule__Object__MacroRefAssignment_0");
					put(grammarAccess.getObjectAccess().getAttributesAssignment_1(), "rule__Object__AttributesAssignment_1");
					put(grammarAccess.getObjectReferenceAccess().getNameAssignment_0_0(), "rule__ObjectReference__NameAssignment_0_0");
					put(grammarAccess.getObjectReferenceAccess().getDescriptorRefAssignment_0_1(), "rule__ObjectReference__DescriptorRefAssignment_0_1");
					put(grammarAccess.getObjectReferenceAccess().getSubIdsAssignment_1(), "rule__ObjectReference__SubIdsAssignment_1");
					put(grammarAccess.getObjectReferenceAccess().getSubIdsAssignment_2(), "rule__ObjectReference__SubIdsAssignment_2");
					put(grammarAccess.getAttributeAccess().getParamRefAssignment_1(), "rule__Attribute__ParamRefAssignment_1");
					put(grammarAccess.getAttributeAccess().getValuesAssignment_2(), "rule__Attribute__ValuesAssignment_2");
					put(grammarAccess.getAttributeValueAccess().getIdentifierAssignment_0_1_0(), "rule__AttributeValue__IdentifierAssignment_0_1_0");
					put(grammarAccess.getAttributeValueAccess().getTextAssignment_0_1_1(), "rule__AttributeValue__TextAssignment_0_1_1");
					put(grammarAccess.getAttributeValueAccess().getTypeRefAssignment_0_1_2_0(), "rule__AttributeValue__TypeRefAssignment_0_1_2_0");
					put(grammarAccess.getAttributeValueAccess().getSubTypeAssignment_0_1_2_1(), "rule__AttributeValue__SubTypeAssignment_0_1_2_1");
					put(grammarAccess.getAttributeValueAccess().getObjectRefAssignment_1(), "rule__AttributeValue__ObjectRefAssignment_1");
					put(grammarAccess.getAttributeValueAccess().getIntegerAssignment_2(), "rule__AttributeValue__IntegerAssignment_2");
					put(grammarAccess.getAttributeValueAccess().getSequenceOfAssignment_3(), "rule__AttributeValue__SequenceOfAssignment_3");
					put(grammarAccess.getIdentifierAccess().getIdAssignment(), "rule__Identifier__IdAssignment");
					put(grammarAccess.getBracedObjectReferenceAccess().getObjectRefAssignment_1(), "rule__BracedObjectReference__ObjectRefAssignment_1");
					put(grammarAccess.getTypeDefinitionAccess().getNameAssignment_1(), "rule__TypeDefinition__NameAssignment_1");
					put(grammarAccess.getTypeDefinitionAccess().getValuesAssignment_3(), "rule__TypeDefinition__ValuesAssignment_3");
					put(grammarAccess.getMacroAccess().getNameAssignment_1(), "rule__Macro__NameAssignment_1");
					put(grammarAccess.getMacroAccess().getTypeNotationAssignment_6(), "rule__Macro__TypeNotationAssignment_6");
					put(grammarAccess.getMacroAccess().getValueNotationAssignment_7(), "rule__Macro__ValueNotationAssignment_7");
					put(grammarAccess.getMacroAccess().getInnerTypesAssignment_8(), "rule__Macro__InnerTypesAssignment_8");
					put(grammarAccess.getTypeNotationAccess().getNameAssignment_1(), "rule__TypeNotation__NameAssignment_1");
					put(grammarAccess.getTypeNotationAccess().getTypeNotationsAssignment_4(), "rule__TypeNotation__TypeNotationsAssignment_4");
					put(grammarAccess.getValueNotationAccess().getNameAssignment_1(), "rule__ValueNotation__NameAssignment_1");
					put(grammarAccess.getValueNotationAccess().getValueNotationsAssignment_4(), "rule__ValueNotation__ValueNotationsAssignment_4");
					put(grammarAccess.getParamAssignmentAccess().getNameAssignment_0(), "rule__ParamAssignment__NameAssignment_0");
					put(grammarAccess.getParamAssignmentAccess().getRightAssignment_1(), "rule__ParamAssignment__RightAssignment_1");
					put(grammarAccess.getTypeNotationRightAccess().getValueAssignment_1(), "rule__TypeNotationRight__ValueAssignment_1");
					put(grammarAccess.getTypeReferenceExtAccess().getParentRefAssignment_0(), "rule__TypeReferenceExt__ParentRefAssignment_0");
					put(grammarAccess.getTypeReferenceExtAccess().getChildRefAssignment_1(), "rule__TypeReferenceExt__ChildRefAssignment_1");
					put(grammarAccess.getTypeReferenceAccess().getTypeAssignment_0(), "rule__TypeReference__TypeAssignment_0");
					put(grammarAccess.getValueAssignmentAccess().getValueNotationAssignment_1(), "rule__ValueAssignment__ValueNotationAssignment_1");
					put(grammarAccess.getValueAccess().getTagAssignment_0(), "rule__Value__TagAssignment_0");
					put(grammarAccess.getValueAccess().getImplicitAssignment_2(), "rule__Value__ImplicitAssignment_2");
					put(grammarAccess.getValueAccess().getValueTypesAssignment_3(), "rule__Value__ValueTypesAssignment_3");
					put(grammarAccess.getValueAccess().getValueTypesAssignment_4_2(), "rule__Value__ValueTypesAssignment_4_2");
					put(grammarAccess.getTagAccess().getTagValueAssignment_2(), "rule__Tag__TagValueAssignment_2");
					put(grammarAccess.getValueTypeAccess().getParamAssignment_0(), "rule__ValueType__ParamAssignment_0");
					put(grammarAccess.getValueTypeAccess().getIdAssignment_1(), "rule__ValueType__IdAssignment_1");
					put(grammarAccess.getValueTypeAccess().getTypesAssignment_2(), "rule__ValueType__TypesAssignment_2");
					put(grammarAccess.getValueTypeAccess().getSimpleTypeAssignment_3(), "rule__ValueType__SimpleTypeAssignment_3");
					put(grammarAccess.getValueTypeAccess().getMacroValueAssignment_4(), "rule__ValueType__MacroValueAssignment_4");
					put(grammarAccess.getMacroValueAccess().getValueTypeAssignment_3(), "rule__MacroValue__ValueTypeAssignment_3");
					put(grammarAccess.getMacroValueTypeAccess().getUpdateAssignment_0_0(), "rule__MacroValueType__UpdateAssignment_0_0");
					put(grammarAccess.getMacroValueTypeAccess().getValueCAPAssignment_0_1(), "rule__MacroValueType__ValueCAPAssignment_0_1");
					put(grammarAccess.getMacroValueTypeAccess().getRefAssignment_1_0(), "rule__MacroValueType__RefAssignment_1_0");
					put(grammarAccess.getMacroValueTypeAccess().getOiAssignment_1_1(), "rule__MacroValueType__OiAssignment_1_1");
					put(grammarAccess.getMacroValueTypeAccess().getStringAssignment_1_2(), "rule__MacroValueType__StringAssignment_1_2");
					put(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_2_1(), "rule__ASN1_SIMPLE__ConstraintAssignment_2_1");
					put(grammarAccess.getASN1_INTEGERAccess().getNameAssignment_0(), "rule__ASN1_INTEGER__NameAssignment_0");
					put(grammarAccess.getASN1_INTEGERAccess().getRangeAssignment_1_1(), "rule__ASN1_INTEGER__RangeAssignment_1_1");
					put(grammarAccess.getASN1_INTEGERAccess().getRefinementAssignment_2(), "rule__ASN1_INTEGER__RefinementAssignment_2");
					put(grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getRefinementsAssignment_1_1(), "rule__ASN1_INTEGER_REFINEMENT__RefinementsAssignment_1_1");
					put(grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getIntsAssignment_1_3(), "rule__ASN1_INTEGER_REFINEMENT__IntsAssignment_1_3");
					put(grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getRefinementsAssignment_2_2(), "rule__ASN1_INTEGER_REFINEMENT__RefinementsAssignment_2_2");
					put(grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getIntsAssignment_2_4(), "rule__ASN1_INTEGER_REFINEMENT__IntsAssignment_2_4");
					put(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_3(), "rule__ASN1_SUBTYPE__RangesAssignment_3");
					put(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_4_1(), "rule__ASN1_SUBTYPE__RangesAssignment_4_1");
					put(grammarAccess.getASN1_RANGEAccess().getValueAssignment_0_1(), "rule__ASN1_RANGE__ValueAssignment_0_1");
					put(grammarAccess.getASN1_RANGEAccess().getStartAssignment_1_0(), "rule__ASN1_RANGE__StartAssignment_1_0");
					put(grammarAccess.getASN1_RANGEAccess().getEndAssignment_1_2(), "rule__ASN1_RANGE__EndAssignment_1_2");
					put(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeAssignment_3(), "rule__ASN1_CHOICE__ChoiceTypeAssignment_3");
					put(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeAssignment_4_2(), "rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2");
					put(grammarAccess.getASN1_SEQUENCEAccess().getChoiceTypeAssignment_3(), "rule__ASN1_SEQUENCE__ChoiceTypeAssignment_3");
					put(grammarAccess.getASN1_SEQUENCEAccess().getChoiceTypeAssignment_4_2(), "rule__ASN1_SEQUENCE__ChoiceTypeAssignment_4_2");
					put(grammarAccess.getASN1_SEQUENCE_OFAccess().getRefAssignment_2(), "rule__ASN1_SEQUENCE_OF__RefAssignment_2");
					put(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdAssignment_0(), "rule__ASN1_CHOICE_ENTRY__IdAssignment_0");
					put(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeAssignment_2(), "rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2");
					put(grammarAccess.getChoiceTypeAccess().getTypeRefAssignment_1_0(), "rule__ChoiceType__TypeRefAssignment_1_0");
					put(grammarAccess.getChoiceTypeAccess().getSimpleTypeAssignment_1_1(), "rule__ChoiceType__SimpleTypeAssignment_1_1");
					put(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), "rule__MacroValueType__UnorderedGroup_0");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			com.netxforge.ui.contentassist.antlr.internal.InternalSmiParser typedParser = (com.netxforge.ui.contentassist.antlr.internal.InternalSmiParser) parser;
			typedParser.entryRuleModule();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_SL_ASN1_COMMENT" };
	}
	
	public SmiGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(SmiGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}