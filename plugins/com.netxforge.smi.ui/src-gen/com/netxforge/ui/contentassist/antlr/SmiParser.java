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
					put(grammarAccess.getObjectIdentifierValueAccess().getAlternatives_0(), "rule__ObjectIdentifierValue__Alternatives_0");
					put(grammarAccess.getTypeAssignmentAccess().getAlternatives_1(), "rule__TypeAssignment__Alternatives_1");
					put(grammarAccess.getTypeNotationAccess().getAlternatives(), "rule__TypeNotation__Alternatives");
					put(grammarAccess.getValueTypeAccess().getAlternatives(), "rule__ValueType__Alternatives");
					put(grammarAccess.getMACRO_VALUE_TYPEAccess().getAlternatives(), "rule__MACRO_VALUE_TYPE__Alternatives");
					put(grammarAccess.getMACRO_VALUE_CAPAccess().getAlternatives(), "rule__MACRO_VALUE_CAP__Alternatives");
					put(grammarAccess.getASN1_TYPEAccess().getAlternatives(), "rule__ASN1_TYPE__Alternatives");
					put(grammarAccess.getASN1_SIMPLEAccess().getAlternatives(), "rule__ASN1_SIMPLE__Alternatives");
					put(grammarAccess.getASN1_RANGEAccess().getAlternatives(), "rule__ASN1_RANGE__Alternatives");
					put(grammarAccess.getModuleAccess().getGroup(), "rule__Module__Group__0");
					put(grammarAccess.getObjectIdentifierAccess().getGroup(), "rule__ObjectIdentifier__Group__0");
					put(grammarAccess.getObjectIdentifierValueAccess().getGroup(), "rule__ObjectIdentifierValue__Group__0");
					put(grammarAccess.getTypeDefinitionAccess().getGroup(), "rule__TypeDefinition__Group__0");
					put(grammarAccess.getMacroAccess().getGroup(), "rule__Macro__Group__0");
					put(grammarAccess.getTypeAssignmentAccess().getGroup(), "rule__TypeAssignment__Group__0");
					put(grammarAccess.getParamAssignmentAccess().getGroup(), "rule__ParamAssignment__Group__0");
					put(grammarAccess.getTypeReferenceExtAccess().getGroup(), "rule__TypeReferenceExt__Group__0");
					put(grammarAccess.getValueAccess().getGroup(), "rule__Value__Group__0");
					put(grammarAccess.getValueAccess().getGroup_2(), "rule__Value__Group_2__0");
					put(grammarAccess.getMacroValueAccess().getGroup(), "rule__MacroValue__Group__0");
					put(grammarAccess.getUpdateTypeAccess().getGroup(), "rule__UpdateType__Group__0");
					put(grammarAccess.getASN1_SIMPLEAccess().getGroup_0(), "rule__ASN1_SIMPLE__Group_0__0");
					put(grammarAccess.getASN1_SIMPLEAccess().getGroup_1(), "rule__ASN1_SIMPLE__Group_1__0");
					put(grammarAccess.getASN1_SIMPLEAccess().getGroup_2(), "rule__ASN1_SIMPLE__Group_2__0");
					put(grammarAccess.getASN1_SIMPLEAccess().getGroup_3(), "rule__ASN1_SIMPLE__Group_3__0");
					put(grammarAccess.getASN1_OCTET_STRINGAccess().getGroup(), "rule__ASN1_OCTET_STRING__Group__0");
					put(grammarAccess.getASN1_INTEGERAccess().getGroup(), "rule__ASN1_INTEGER__Group__0");
					put(grammarAccess.getASN1_SUBTYPEAccess().getGroup(), "rule__ASN1_SUBTYPE__Group__0");
					put(grammarAccess.getASN1_SUBTYPEAccess().getGroup_4(), "rule__ASN1_SUBTYPE__Group_4__0");
					put(grammarAccess.getASN1_RANGEAccess().getGroup_0(), "rule__ASN1_RANGE__Group_0__0");
					put(grammarAccess.getASN1_RANGEAccess().getGroup_1(), "rule__ASN1_RANGE__Group_1__0");
					put(grammarAccess.getASN1_VALUEPAIRAccess().getGroup(), "rule__ASN1_VALUEPAIR__Group__0");
					put(grammarAccess.getASN1_CHOICEAccess().getGroup(), "rule__ASN1_CHOICE__Group__0");
					put(grammarAccess.getASN1_CHOICEAccess().getGroup_3(), "rule__ASN1_CHOICE__Group_3__0");
					put(grammarAccess.getASN1_CHOICE_ENTRYAccess().getGroup(), "rule__ASN1_CHOICE_ENTRY__Group__0");
					put(grammarAccess.getModuleAccess().getNameAssignment_0(), "rule__Module__NameAssignment_0");
					put(grammarAccess.getModuleAccess().getIdentifiersAssignment_5_0(), "rule__Module__IdentifiersAssignment_5_0");
					put(grammarAccess.getModuleAccess().getTypesAssignment_5_1(), "rule__Module__TypesAssignment_5_1");
					put(grammarAccess.getModuleAccess().getMacrosAssignment_5_2(), "rule__Module__MacrosAssignment_5_2");
					put(grammarAccess.getObjectIdentifierAccess().getNameAssignment_1(), "rule__ObjectIdentifier__NameAssignment_1");
					put(grammarAccess.getObjectIdentifierAccess().getOidValueAssignment_5(), "rule__ObjectIdentifier__OidValueAssignment_5");
					put(grammarAccess.getObjectIdentifierValueAccess().getRootAssignment_0_0(), "rule__ObjectIdentifierValue__RootAssignment_0_0");
					put(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceAssignment_0_1(), "rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1");
					put(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_1(), "rule__ObjectIdentifierValue__SubIdsAssignment_1");
					put(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_2(), "rule__ObjectIdentifierValue__SubIdsAssignment_2");
					put(grammarAccess.getTypeDefinitionAccess().getNameAssignment_1(), "rule__TypeDefinition__NameAssignment_1");
					put(grammarAccess.getTypeDefinitionAccess().getValuesAssignment_3(), "rule__TypeDefinition__ValuesAssignment_3");
					put(grammarAccess.getMacroAccess().getNameAssignment_1(), "rule__Macro__NameAssignment_1");
					put(grammarAccess.getMacroAccess().getTypeNotationsAssignment_9(), "rule__Macro__TypeNotationsAssignment_9");
					put(grammarAccess.getMacroAccess().getValueNotationAssignment_14(), "rule__Macro__ValueNotationAssignment_14");
					put(grammarAccess.getMacroAccess().getInnerTypesAssignment_15(), "rule__Macro__InnerTypesAssignment_15");
					put(grammarAccess.getParamAssignmentAccess().getParamAssignment_0(), "rule__ParamAssignment__ParamAssignment_0");
					put(grammarAccess.getParamAssignmentAccess().getRightAssignment_1(), "rule__ParamAssignment__RightAssignment_1");
					put(grammarAccess.getTypeNotationAccess().getValueAssignment_1(), "rule__TypeNotation__ValueAssignment_1");
					put(grammarAccess.getTypeReferenceExtAccess().getParentRefAssignment_0(), "rule__TypeReferenceExt__ParentRefAssignment_0");
					put(grammarAccess.getTypeReferenceExtAccess().getChildRefAssignment_1(), "rule__TypeReferenceExt__ChildRefAssignment_1");
					put(grammarAccess.getTypeReferenceAccess().getTypeAssignment(), "rule__TypeReference__TypeAssignment");
					put(grammarAccess.getValueAccess().getValueTypesAssignment_1(), "rule__Value__ValueTypesAssignment_1");
					put(grammarAccess.getValueAccess().getValueTypesAssignment_2_2(), "rule__Value__ValueTypesAssignment_2_2");
					put(grammarAccess.getValueTypeAccess().getParamAssignment_0(), "rule__ValueType__ParamAssignment_0");
					put(grammarAccess.getValueTypeAccess().getTypesAssignment_1(), "rule__ValueType__TypesAssignment_1");
					put(grammarAccess.getValueTypeAccess().getSimpleTypeAssignment_2(), "rule__ValueType__SimpleTypeAssignment_2");
					put(grammarAccess.getValueTypeAccess().getMacroValueAssignment_3(), "rule__ValueType__MacroValueAssignment_3");
					put(grammarAccess.getValueTypeAccess().getOiAssignment_4(), "rule__ValueType__OiAssignment_4");
					put(grammarAccess.getMacroValueAccess().getValueTypeAssignment_3(), "rule__MacroValue__ValueTypeAssignment_3");
					put(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateAssignment_0(), "rule__MACRO_VALUE_TYPE__UpdateAssignment_0");
					put(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralAssignment_1(), "rule__MACRO_VALUE_TYPE__LiteralAssignment_1");
					put(grammarAccess.getUpdateTypeAccess().getTypeAssignment_1(), "rule__UpdateType__TypeAssignment_1");
					put(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_2_1(), "rule__ASN1_SIMPLE__ConstraintAssignment_2_1");
					put(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_3_1(), "rule__ASN1_SIMPLE__ConstraintAssignment_3_1");
					put(grammarAccess.getASN1_OCTET_STRINGAccess().getNameAssignment_1(), "rule__ASN1_OCTET_STRING__NameAssignment_1");
					put(grammarAccess.getASN1_INTEGERAccess().getNameAssignment_0(), "rule__ASN1_INTEGER__NameAssignment_0");
					put(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2(), "rule__ASN1_INTEGER__ValuePairsAssignment_2");
					put(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_3(), "rule__ASN1_SUBTYPE__RangesAssignment_3");
					put(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_4_1(), "rule__ASN1_SUBTYPE__RangesAssignment_4_1");
					put(grammarAccess.getASN1_RANGEAccess().getValueAssignment_0_1(), "rule__ASN1_RANGE__ValueAssignment_0_1");
					put(grammarAccess.getASN1_RANGEAccess().getStartAssignment_1_0(), "rule__ASN1_RANGE__StartAssignment_1_0");
					put(grammarAccess.getASN1_RANGEAccess().getEndAssignment_1_2(), "rule__ASN1_RANGE__EndAssignment_1_2");
					put(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_2(), "rule__ASN1_CHOICE__ChoicesAssignment_2");
					put(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_3_1(), "rule__ASN1_CHOICE__ChoicesAssignment_3_1");
					put(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdAssignment_0(), "rule__ASN1_CHOICE_ENTRY__IdAssignment_0");
					put(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeAssignment_1(), "rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1");
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
