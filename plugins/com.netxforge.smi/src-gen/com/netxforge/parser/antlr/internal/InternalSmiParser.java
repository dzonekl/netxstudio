package com.netxforge.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.netxforge.services.SmiGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSmiParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_MODULE_ID", "RULE_ID", "RULE_ANY_OTHER", "RULE_IA5STRING", "RULE_INT", "RULE_ASN1_ID", "RULE_NUMERIC", "RULE_ALPHA", "RULE_ALPHA_CAP", "RULE_SL_ASN1_COMMENT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'DEFINITIONS'", "'::='", "'BEGIN'", "'END'", "'MACRO'", "'TYPE NOTATION'", "'VALUE NOTATION'", "'value('", "')'", "'|'", "'('", "'OCTET STRING'", "'TODO defintions.'", "'INTEGER'", "'{'", "'}'", "'CHOICE'", "','", "'SIZE'", "'..'", "'OBJECT IDENTIFIER'", "'VALUE'", "'Update'"
    };
    public static final int RULE_ID=5;
    public static final int T__40=40;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_ALPHA_CAP=12;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int RULE_IA5STRING=7;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=6;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_ASN1_ID=9;
    public static final int RULE_ALPHA=11;
    public static final int RULE_SL_COMMENT=16;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=15;
    public static final int RULE_MODULE_ID=4;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=14;
    public static final int T__32=32;
    public static final int RULE_NUMERIC=10;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_INT=8;
    public static final int RULE_WS=17;
    public static final int RULE_SL_ASN1_COMMENT=13;

    // delegates
    // delegators


        public InternalSmiParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSmiParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSmiParser.tokenNames; }
    public String getGrammarFileName() { return "../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g"; }



     	private SmiGrammarAccess grammarAccess;
     	
        public InternalSmiParser(TokenStream input, SmiGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Module";	
       	}
       	
       	@Override
       	protected SmiGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModule"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:68:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:69:2: (iv_ruleModule= ruleModule EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:70:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule75);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:77:1: ruleModule returns [EObject current=null] : ( ( (lv_id_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_assignments_4_0= ruleAssignment ) )* otherlv_5= 'END' ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_assignments_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:28: ( ( ( (lv_id_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_assignments_4_0= ruleAssignment ) )* otherlv_5= 'END' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:81:1: ( ( (lv_id_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_assignments_4_0= ruleAssignment ) )* otherlv_5= 'END' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:81:1: ( ( (lv_id_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_assignments_4_0= ruleAssignment ) )* otherlv_5= 'END' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:81:2: ( (lv_id_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_assignments_4_0= ruleAssignment ) )* otherlv_5= 'END'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:81:2: ( (lv_id_0_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:82:1: (lv_id_0_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:82:1: (lv_id_0_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:83:3: lv_id_0_0= RULE_MODULE_ID
            {
            lv_id_0_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleModule127); 

            			newLeafNode(lv_id_0_0, grammarAccess.getModuleAccess().getIdMODULE_IDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"MODULE_ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleModule144); 

                	newLeafNode(otherlv_1, grammarAccess.getModuleAccess().getDEFINITIONSKeyword_1());
                
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleModule156); 

                	newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_2());
                
            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleModule168); 

                	newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getBEGINKeyword_3());
                
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:111:1: ( (lv_assignments_4_0= ruleAssignment ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_MODULE_ID||LA1_0==RULE_ASN1_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:112:1: (lv_assignments_4_0= ruleAssignment )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:112:1: (lv_assignments_4_0= ruleAssignment )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:113:3: lv_assignments_4_0= ruleAssignment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModuleAccess().getAssignmentsAssignmentParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssignment_in_ruleModule189);
            	    lv_assignments_4_0=ruleAssignment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"assignments",
            	            		lv_assignments_4_0, 
            	            		"Assignment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleModule202); 

                	newLeafNode(otherlv_5, grammarAccess.getModuleAccess().getENDKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:141:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:142:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:143:2: iv_ruleAssignment= ruleAssignment EOF
            {
             newCompositeNode(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment238);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment248); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:150:1: ruleAssignment returns [EObject current=null] : ( ( (lv_macros_0_0= ruleMacro ) ) | ( (lv_types_1_0= ruleValueAssignment ) ) | this_ObjectIdentifier_2= ruleObjectIdentifier ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_macros_0_0 = null;

        EObject lv_types_1_0 = null;

        EObject this_ObjectIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:153:28: ( ( ( (lv_macros_0_0= ruleMacro ) ) | ( (lv_types_1_0= ruleValueAssignment ) ) | this_ObjectIdentifier_2= ruleObjectIdentifier ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:154:1: ( ( (lv_macros_0_0= ruleMacro ) ) | ( (lv_types_1_0= ruleValueAssignment ) ) | this_ObjectIdentifier_2= ruleObjectIdentifier )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:154:1: ( ( (lv_macros_0_0= ruleMacro ) ) | ( (lv_types_1_0= ruleValueAssignment ) ) | this_ObjectIdentifier_2= ruleObjectIdentifier )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_MODULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==19) ) {
                    alt2=2;
                }
                else if ( (LA2_1==22) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==RULE_ASN1_ID) ) {
                alt2=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:154:2: ( (lv_macros_0_0= ruleMacro ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:154:2: ( (lv_macros_0_0= ruleMacro ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:155:1: (lv_macros_0_0= ruleMacro )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:155:1: (lv_macros_0_0= ruleMacro )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:156:3: lv_macros_0_0= ruleMacro
                    {
                     
                    	        newCompositeNode(grammarAccess.getAssignmentAccess().getMacrosMacroParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMacro_in_ruleAssignment294);
                    lv_macros_0_0=ruleMacro();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
                    	        }
                           		set(
                           			current, 
                           			"macros",
                            		lv_macros_0_0, 
                            		"Macro");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:173:6: ( (lv_types_1_0= ruleValueAssignment ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:173:6: ( (lv_types_1_0= ruleValueAssignment ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:174:1: (lv_types_1_0= ruleValueAssignment )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:174:1: (lv_types_1_0= ruleValueAssignment )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:175:3: lv_types_1_0= ruleValueAssignment
                    {
                     
                    	        newCompositeNode(grammarAccess.getAssignmentAccess().getTypesValueAssignmentParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueAssignment_in_ruleAssignment321);
                    lv_types_1_0=ruleValueAssignment();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
                    	        }
                           		add(
                           			current, 
                           			"types",
                            		lv_types_1_0, 
                            		"ValueAssignment");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:193:5: this_ObjectIdentifier_2= ruleObjectIdentifier
                    {
                     
                            newCompositeNode(grammarAccess.getAssignmentAccess().getObjectIdentifierParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleObjectIdentifier_in_ruleAssignment349);
                    this_ObjectIdentifier_2=ruleObjectIdentifier();

                    state._fsp--;

                     
                            current = this_ObjectIdentifier_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleMacro"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:209:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:210:2: (iv_ruleMacro= ruleMacro EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:211:2: iv_ruleMacro= ruleMacro EOF
            {
             newCompositeNode(grammarAccess.getMacroRule()); 
            pushFollow(FOLLOW_ruleMacro_in_entryRuleMacro384);
            iv_ruleMacro=ruleMacro();

            state._fsp--;

             current =iv_ruleMacro; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacro394); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMacro"


    // $ANTLR start "ruleMacro"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:218:1: ruleMacro returns [EObject current=null] : ( ( (lv_descriptor_0_0= ruleMacroDescriptor ) ) otherlv_1= 'MACRO' otherlv_2= '::=' otherlv_3= 'BEGIN' otherlv_4= 'TYPE NOTATION' ( (otherlv_5= RULE_ID ) )+ otherlv_6= 'VALUE NOTATION' ( (lv_valueNotation_7_0= ruleMacroValue ) ) ( (lv_innerTypes_8_0= ruleValueAssignment ) )+ otherlv_9= 'END' ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_descriptor_0_0 = null;

        EObject lv_valueNotation_7_0 = null;

        EObject lv_innerTypes_8_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:221:28: ( ( ( (lv_descriptor_0_0= ruleMacroDescriptor ) ) otherlv_1= 'MACRO' otherlv_2= '::=' otherlv_3= 'BEGIN' otherlv_4= 'TYPE NOTATION' ( (otherlv_5= RULE_ID ) )+ otherlv_6= 'VALUE NOTATION' ( (lv_valueNotation_7_0= ruleMacroValue ) ) ( (lv_innerTypes_8_0= ruleValueAssignment ) )+ otherlv_9= 'END' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:222:1: ( ( (lv_descriptor_0_0= ruleMacroDescriptor ) ) otherlv_1= 'MACRO' otherlv_2= '::=' otherlv_3= 'BEGIN' otherlv_4= 'TYPE NOTATION' ( (otherlv_5= RULE_ID ) )+ otherlv_6= 'VALUE NOTATION' ( (lv_valueNotation_7_0= ruleMacroValue ) ) ( (lv_innerTypes_8_0= ruleValueAssignment ) )+ otherlv_9= 'END' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:222:1: ( ( (lv_descriptor_0_0= ruleMacroDescriptor ) ) otherlv_1= 'MACRO' otherlv_2= '::=' otherlv_3= 'BEGIN' otherlv_4= 'TYPE NOTATION' ( (otherlv_5= RULE_ID ) )+ otherlv_6= 'VALUE NOTATION' ( (lv_valueNotation_7_0= ruleMacroValue ) ) ( (lv_innerTypes_8_0= ruleValueAssignment ) )+ otherlv_9= 'END' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:222:2: ( (lv_descriptor_0_0= ruleMacroDescriptor ) ) otherlv_1= 'MACRO' otherlv_2= '::=' otherlv_3= 'BEGIN' otherlv_4= 'TYPE NOTATION' ( (otherlv_5= RULE_ID ) )+ otherlv_6= 'VALUE NOTATION' ( (lv_valueNotation_7_0= ruleMacroValue ) ) ( (lv_innerTypes_8_0= ruleValueAssignment ) )+ otherlv_9= 'END'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:222:2: ( (lv_descriptor_0_0= ruleMacroDescriptor ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:223:1: (lv_descriptor_0_0= ruleMacroDescriptor )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:223:1: (lv_descriptor_0_0= ruleMacroDescriptor )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:224:3: lv_descriptor_0_0= ruleMacroDescriptor
            {
             
            	        newCompositeNode(grammarAccess.getMacroAccess().getDescriptorMacroDescriptorParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleMacroDescriptor_in_ruleMacro440);
            lv_descriptor_0_0=ruleMacroDescriptor();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMacroRule());
            	        }
                   		set(
                   			current, 
                   			"descriptor",
                    		lv_descriptor_0_0, 
                    		"MacroDescriptor");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleMacro452); 

                	newLeafNode(otherlv_1, grammarAccess.getMacroAccess().getMACROKeyword_1());
                
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleMacro464); 

                	newLeafNode(otherlv_2, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_2());
                
            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleMacro476); 

                	newLeafNode(otherlv_3, grammarAccess.getMacroAccess().getBEGINKeyword_3());
                
            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleMacro488); 

                	newLeafNode(otherlv_4, grammarAccess.getMacroAccess().getTYPENOTATIONKeyword_4());
                
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:256:1: ( (otherlv_5= RULE_ID ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:257:1: (otherlv_5= RULE_ID )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:257:1: (otherlv_5= RULE_ID )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:258:3: otherlv_5= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getMacroRule());
            	    	        }
            	            
            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMacro508); 

            	    		newLeafNode(otherlv_5, grammarAccess.getMacroAccess().getTypeNotationsValueAssignmentCrossReference_5_0()); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleMacro521); 

                	newLeafNode(otherlv_6, grammarAccess.getMacroAccess().getVALUENOTATIONKeyword_6());
                
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:273:1: ( (lv_valueNotation_7_0= ruleMacroValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:274:1: (lv_valueNotation_7_0= ruleMacroValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:274:1: (lv_valueNotation_7_0= ruleMacroValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:275:3: lv_valueNotation_7_0= ruleMacroValue
            {
             
            	        newCompositeNode(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleMacroValue_in_ruleMacro542);
            lv_valueNotation_7_0=ruleMacroValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMacroRule());
            	        }
                   		set(
                   			current, 
                   			"valueNotation",
                    		lv_valueNotation_7_0, 
                    		"MacroValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:291:2: ( (lv_innerTypes_8_0= ruleValueAssignment ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_MODULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:292:1: (lv_innerTypes_8_0= ruleValueAssignment )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:292:1: (lv_innerTypes_8_0= ruleValueAssignment )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:293:3: lv_innerTypes_8_0= ruleValueAssignment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMacroAccess().getInnerTypesValueAssignmentParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueAssignment_in_ruleMacro563);
            	    lv_innerTypes_8_0=ruleValueAssignment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMacroRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"innerTypes",
            	            		lv_innerTypes_8_0, 
            	            		"ValueAssignment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleMacro576); 

                	newLeafNode(otherlv_9, grammarAccess.getMacroAccess().getENDKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMacro"


    // $ANTLR start "entryRuleMacroDescriptor"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:321:1: entryRuleMacroDescriptor returns [String current=null] : iv_ruleMacroDescriptor= ruleMacroDescriptor EOF ;
    public final String entryRuleMacroDescriptor() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMacroDescriptor = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:322:2: (iv_ruleMacroDescriptor= ruleMacroDescriptor EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:323:2: iv_ruleMacroDescriptor= ruleMacroDescriptor EOF
            {
             newCompositeNode(grammarAccess.getMacroDescriptorRule()); 
            pushFollow(FOLLOW_ruleMacroDescriptor_in_entryRuleMacroDescriptor613);
            iv_ruleMacroDescriptor=ruleMacroDescriptor();

            state._fsp--;

             current =iv_ruleMacroDescriptor.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroDescriptor624); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMacroDescriptor"


    // $ANTLR start "ruleMacroDescriptor"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:330:1: ruleMacroDescriptor returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_MODULE_ID_0= RULE_MODULE_ID ;
    public final AntlrDatatypeRuleToken ruleMacroDescriptor() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_MODULE_ID_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:333:28: (this_MODULE_ID_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:334:5: this_MODULE_ID_0= RULE_MODULE_ID
            {
            this_MODULE_ID_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleMacroDescriptor663); 

            		current.merge(this_MODULE_ID_0);
                
             
                newLeafNode(this_MODULE_ID_0, grammarAccess.getMacroDescriptorAccess().getMODULE_IDTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMacroDescriptor"


    // $ANTLR start "entryRuleMacroValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:349:1: entryRuleMacroValue returns [EObject current=null] : iv_ruleMacroValue= ruleMacroValue EOF ;
    public final EObject entryRuleMacroValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacroValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:350:2: (iv_ruleMacroValue= ruleMacroValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:351:2: iv_ruleMacroValue= ruleMacroValue EOF
            {
             newCompositeNode(grammarAccess.getMacroValueRule()); 
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue707);
            iv_ruleMacroValue=ruleMacroValue();

            state._fsp--;

             current =iv_ruleMacroValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue717); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMacroValue"


    // $ANTLR start "ruleMacroValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:358:1: ruleMacroValue returns [EObject current=null] : ( () otherlv_1= 'value(' ( (lv_type_2_0= ruleMACRO_VALUE_TYPE ) )? this_ANY_OTHER_3= RULE_ANY_OTHER otherlv_4= ')' ) ;
    public final EObject ruleMacroValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_ANY_OTHER_3=null;
        Token otherlv_4=null;
        Enumerator lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:361:28: ( ( () otherlv_1= 'value(' ( (lv_type_2_0= ruleMACRO_VALUE_TYPE ) )? this_ANY_OTHER_3= RULE_ANY_OTHER otherlv_4= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:362:1: ( () otherlv_1= 'value(' ( (lv_type_2_0= ruleMACRO_VALUE_TYPE ) )? this_ANY_OTHER_3= RULE_ANY_OTHER otherlv_4= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:362:1: ( () otherlv_1= 'value(' ( (lv_type_2_0= ruleMACRO_VALUE_TYPE ) )? this_ANY_OTHER_3= RULE_ANY_OTHER otherlv_4= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:362:2: () otherlv_1= 'value(' ( (lv_type_2_0= ruleMACRO_VALUE_TYPE ) )? this_ANY_OTHER_3= RULE_ANY_OTHER otherlv_4= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:362:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:363:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getMacroValueAccess().getMacroValueAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleMacroValue763); 

                	newLeafNode(otherlv_1, grammarAccess.getMacroValueAccess().getValueKeyword_1());
                
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:372:1: ( (lv_type_2_0= ruleMACRO_VALUE_TYPE ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=39 && LA5_0<=40)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:373:1: (lv_type_2_0= ruleMACRO_VALUE_TYPE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:373:1: (lv_type_2_0= ruleMACRO_VALUE_TYPE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:374:3: lv_type_2_0= ruleMACRO_VALUE_TYPE
                    {
                     
                    	        newCompositeNode(grammarAccess.getMacroValueAccess().getTypeMACRO_VALUE_TYPEEnumRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_ruleMacroValue784);
                    lv_type_2_0=ruleMACRO_VALUE_TYPE();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMacroValueRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_2_0, 
                            		"MACRO_VALUE_TYPE");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            this_ANY_OTHER_3=(Token)match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_ruleMacroValue796); 
             
                newLeafNode(this_ANY_OTHER_3, grammarAccess.getMacroValueAccess().getANY_OTHERTerminalRuleCall_3()); 
                
            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleMacroValue807); 

                	newLeafNode(otherlv_4, grammarAccess.getMacroValueAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMacroValue"


    // $ANTLR start "entryRuleValueAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:406:1: entryRuleValueAssignment returns [EObject current=null] : iv_ruleValueAssignment= ruleValueAssignment EOF ;
    public final EObject entryRuleValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:407:2: (iv_ruleValueAssignment= ruleValueAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:408:2: iv_ruleValueAssignment= ruleValueAssignment EOF
            {
             newCompositeNode(grammarAccess.getValueAssignmentRule()); 
            pushFollow(FOLLOW_ruleValueAssignment_in_entryRuleValueAssignment843);
            iv_ruleValueAssignment=ruleValueAssignment();

            state._fsp--;

             current =iv_ruleValueAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueAssignment853); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueAssignment"


    // $ANTLR start "ruleValueAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:415:1: ruleValueAssignment returns [EObject current=null] : ( ( (lv_typeReference_0_0= RULE_MODULE_ID ) ) otherlv_1= '::=' ( (lv_value_2_0= ruleOr ) ) ) ;
    public final EObject ruleValueAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_typeReference_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:418:28: ( ( ( (lv_typeReference_0_0= RULE_MODULE_ID ) ) otherlv_1= '::=' ( (lv_value_2_0= ruleOr ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:419:1: ( ( (lv_typeReference_0_0= RULE_MODULE_ID ) ) otherlv_1= '::=' ( (lv_value_2_0= ruleOr ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:419:1: ( ( (lv_typeReference_0_0= RULE_MODULE_ID ) ) otherlv_1= '::=' ( (lv_value_2_0= ruleOr ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:419:2: ( (lv_typeReference_0_0= RULE_MODULE_ID ) ) otherlv_1= '::=' ( (lv_value_2_0= ruleOr ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:419:2: ( (lv_typeReference_0_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:420:1: (lv_typeReference_0_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:420:1: (lv_typeReference_0_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:421:3: lv_typeReference_0_0= RULE_MODULE_ID
            {
            lv_typeReference_0_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleValueAssignment895); 

            			newLeafNode(lv_typeReference_0_0, grammarAccess.getValueAssignmentAccess().getTypeReferenceMODULE_IDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getValueAssignmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"typeReference",
                    		lv_typeReference_0_0, 
                    		"MODULE_ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleValueAssignment912); 

                	newLeafNode(otherlv_1, grammarAccess.getValueAssignmentAccess().getColonColonEqualsSignKeyword_1());
                
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:441:1: ( (lv_value_2_0= ruleOr ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:442:1: (lv_value_2_0= ruleOr )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:442:1: (lv_value_2_0= ruleOr )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:443:3: lv_value_2_0= ruleOr
            {
             
            	        newCompositeNode(grammarAccess.getValueAssignmentAccess().getValueOrParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleOr_in_ruleValueAssignment933);
            lv_value_2_0=ruleOr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValueAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"Or");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueAssignment"


    // $ANTLR start "entryRuleOr"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:467:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:468:2: (iv_ruleOr= ruleOr EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:469:2: iv_ruleOr= ruleOr EOF
            {
             newCompositeNode(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_ruleOr_in_entryRuleOr969);
            iv_ruleOr=ruleOr();

            state._fsp--;

             current =iv_ruleOr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOr979); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:476:1: ruleOr returns [EObject current=null] : (this_ValueType_0= ruleValueType ( ( () otherlv_2= '|' ) ( (lv_right_3_0= ruleValueType ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ValueType_0 = null;

        EObject lv_right_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:479:28: ( (this_ValueType_0= ruleValueType ( ( () otherlv_2= '|' ) ( (lv_right_3_0= ruleValueType ) ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:480:1: (this_ValueType_0= ruleValueType ( ( () otherlv_2= '|' ) ( (lv_right_3_0= ruleValueType ) ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:480:1: (this_ValueType_0= ruleValueType ( ( () otherlv_2= '|' ) ( (lv_right_3_0= ruleValueType ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:481:5: this_ValueType_0= ruleValueType ( ( () otherlv_2= '|' ) ( (lv_right_3_0= ruleValueType ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getOrAccess().getValueTypeParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleValueType_in_ruleOr1026);
            this_ValueType_0=ruleValueType();

            state._fsp--;

             
                    current = this_ValueType_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:489:1: ( ( () otherlv_2= '|' ) ( (lv_right_3_0= ruleValueType ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==27) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:489:2: ( () otherlv_2= '|' ) ( (lv_right_3_0= ruleValueType ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:489:2: ( () otherlv_2= '|' )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:489:3: () otherlv_2= '|'
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:489:3: ()
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:490:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getOrAccess().getOrLeftAction_1_0_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleOr1048); 

            	        	newLeafNode(otherlv_2, grammarAccess.getOrAccess().getVerticalLineKeyword_1_0_1());
            	        

            	    }

            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:499:2: ( (lv_right_3_0= ruleValueType ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:500:1: (lv_right_3_0= ruleValueType )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:500:1: (lv_right_3_0= ruleValueType )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:501:3: lv_right_3_0= ruleValueType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOrAccess().getRightValueTypeParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueType_in_ruleOr1070);
            	    lv_right_3_0=ruleValueType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOrRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"ValueType");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleValueType"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:525:1: entryRuleValueType returns [EObject current=null] : iv_ruleValueType= ruleValueType EOF ;
    public final EObject entryRuleValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:526:2: (iv_ruleValueType= ruleValueType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:527:2: iv_ruleValueType= ruleValueType EOF
            {
             newCompositeNode(grammarAccess.getValueTypeRule()); 
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType1108);
            iv_ruleValueType=ruleValueType();

            state._fsp--;

             current =iv_ruleValueType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType1118); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueType"


    // $ANTLR start "ruleValueType"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:534:1: ruleValueType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_IA5STRING ) )? ( ( (otherlv_1= RULE_ID ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) ) ) ;
    public final EObject ruleValueType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_simpleType_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:537:28: ( ( ( (lv_name_0_0= RULE_IA5STRING ) )? ( ( (otherlv_1= RULE_ID ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:538:1: ( ( (lv_name_0_0= RULE_IA5STRING ) )? ( ( (otherlv_1= RULE_ID ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:538:1: ( ( (lv_name_0_0= RULE_IA5STRING ) )? ( ( (otherlv_1= RULE_ID ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:538:2: ( (lv_name_0_0= RULE_IA5STRING ) )? ( ( (otherlv_1= RULE_ID ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:538:2: ( (lv_name_0_0= RULE_IA5STRING ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_IA5STRING) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID||LA7_1==RULE_IA5STRING||LA7_1==29||LA7_1==31||LA7_1==34) ) {
                    alt7=1;
                }
            }
            switch (alt7) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:539:1: (lv_name_0_0= RULE_IA5STRING )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:539:1: (lv_name_0_0= RULE_IA5STRING )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:540:3: lv_name_0_0= RULE_IA5STRING
                    {
                    lv_name_0_0=(Token)match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_ruleValueType1160); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getValueTypeAccess().getNameIA5STRINGTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getValueTypeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"IA5STRING");
                    	    

                    }


                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:556:3: ( ( (otherlv_1= RULE_ID ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_IA5STRING||LA8_0==29||LA8_0==31||LA8_0==34) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:556:4: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:556:4: ( (otherlv_1= RULE_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:557:1: (otherlv_1= RULE_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:557:1: (otherlv_1= RULE_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:558:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getValueTypeRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValueType1187); 

                    		newLeafNode(otherlv_1, grammarAccess.getValueTypeAccess().getTypeValueAssignmentCrossReference_1_0_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:570:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:570:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:571:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:571:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:572:3: lv_simpleType_2_0= ruleASN1_TYPE
                    {
                     
                    	        newCompositeNode(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleASN1_TYPE_in_ruleValueType1214);
                    lv_simpleType_2_0=ruleASN1_TYPE();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"simpleType",
                            		lv_simpleType_2_0, 
                            		"ASN1_TYPE");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueType"


    // $ANTLR start "entryRuleASN1_TYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:596:1: entryRuleASN1_TYPE returns [EObject current=null] : iv_ruleASN1_TYPE= ruleASN1_TYPE EOF ;
    public final EObject entryRuleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_TYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:597:2: (iv_ruleASN1_TYPE= ruleASN1_TYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:598:2: iv_ruleASN1_TYPE= ruleASN1_TYPE EOF
            {
             newCompositeNode(grammarAccess.getASN1_TYPERule()); 
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE1251);
            iv_ruleASN1_TYPE=ruleASN1_TYPE();

            state._fsp--;

             current =iv_ruleASN1_TYPE; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE1261); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleASN1_TYPE"


    // $ANTLR start "ruleASN1_TYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:605:1: ruleASN1_TYPE returns [EObject current=null] : (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE ) ;
    public final EObject ruleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject this_ASN1_SIMPLE_0 = null;

        EObject this_ASN1_CHOICE_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:608:28: ( (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:609:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:609:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_IA5STRING||LA9_0==29||LA9_0==31) ) {
                alt9=1;
            }
            else if ( (LA9_0==34) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:610:5: this_ASN1_SIMPLE_0= ruleASN1_SIMPLE
                    {
                     
                            newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE1308);
                    this_ASN1_SIMPLE_0=ruleASN1_SIMPLE();

                    state._fsp--;

                     
                            current = this_ASN1_SIMPLE_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:620:5: this_ASN1_CHOICE_1= ruleASN1_CHOICE
                    {
                     
                            newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE1335);
                    this_ASN1_CHOICE_1=ruleASN1_CHOICE();

                    state._fsp--;

                     
                            current = this_ASN1_CHOICE_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleASN1_TYPE"


    // $ANTLR start "entryRuleASN1_SIMPLE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:636:1: entryRuleASN1_SIMPLE returns [EObject current=null] : iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF ;
    public final EObject entryRuleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SIMPLE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:637:2: (iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:638:2: iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF
            {
             newCompositeNode(grammarAccess.getASN1_SIMPLERule()); 
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE1370);
            iv_ruleASN1_SIMPLE=ruleASN1_SIMPLE();

            state._fsp--;

             current =iv_ruleASN1_SIMPLE; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE1380); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleASN1_SIMPLE"


    // $ANTLR start "ruleASN1_SIMPLE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:645:1: ruleASN1_SIMPLE returns [EObject current=null] : ( ( () this_IA5STRING_1= RULE_IA5STRING ) | this_ASN1_OCTET_STRING_2= ruleASN1_OCTET_STRING | (this_ASN1_INTEGER_3= ruleASN1_INTEGER (otherlv_4= '(' ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) ) otherlv_6= ')' )? ) ) ;
    public final EObject ruleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        Token this_IA5STRING_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_ASN1_OCTET_STRING_2 = null;

        EObject this_ASN1_INTEGER_3 = null;

        EObject lv_constraint_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:648:28: ( ( ( () this_IA5STRING_1= RULE_IA5STRING ) | this_ASN1_OCTET_STRING_2= ruleASN1_OCTET_STRING | (this_ASN1_INTEGER_3= ruleASN1_INTEGER (otherlv_4= '(' ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) ) otherlv_6= ')' )? ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:649:1: ( ( () this_IA5STRING_1= RULE_IA5STRING ) | this_ASN1_OCTET_STRING_2= ruleASN1_OCTET_STRING | (this_ASN1_INTEGER_3= ruleASN1_INTEGER (otherlv_4= '(' ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) ) otherlv_6= ')' )? ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:649:1: ( ( () this_IA5STRING_1= RULE_IA5STRING ) | this_ASN1_OCTET_STRING_2= ruleASN1_OCTET_STRING | (this_ASN1_INTEGER_3= ruleASN1_INTEGER (otherlv_4= '(' ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) ) otherlv_6= ')' )? ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case RULE_IA5STRING:
                {
                alt11=1;
                }
                break;
            case 29:
                {
                alt11=2;
                }
                break;
            case 31:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:649:2: ( () this_IA5STRING_1= RULE_IA5STRING )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:649:2: ( () this_IA5STRING_1= RULE_IA5STRING )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:649:3: () this_IA5STRING_1= RULE_IA5STRING
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:649:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:650:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0(),
                                current);
                        

                    }

                    this_IA5STRING_1=(Token)match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE1426); 
                     
                        newLeafNode(this_IA5STRING_1, grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:661:5: this_ASN1_OCTET_STRING_2= ruleASN1_OCTET_STRING
                    {
                     
                            newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE1454);
                    this_ASN1_OCTET_STRING_2=ruleASN1_OCTET_STRING();

                    state._fsp--;

                     
                            current = this_ASN1_OCTET_STRING_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:670:6: (this_ASN1_INTEGER_3= ruleASN1_INTEGER (otherlv_4= '(' ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) ) otherlv_6= ')' )? )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:670:6: (this_ASN1_INTEGER_3= ruleASN1_INTEGER (otherlv_4= '(' ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) ) otherlv_6= ')' )? )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:671:5: this_ASN1_INTEGER_3= ruleASN1_INTEGER (otherlv_4= '(' ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) ) otherlv_6= ')' )?
                    {
                     
                            newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_2_0()); 
                        
                    pushFollow(FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE1482);
                    this_ASN1_INTEGER_3=ruleASN1_INTEGER();

                    state._fsp--;

                     
                            current = this_ASN1_INTEGER_3; 
                            afterParserOrEnumRuleCall();
                        
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:679:1: (otherlv_4= '(' ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) ) otherlv_6= ')' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==28) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:679:3: otherlv_4= '(' ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) ) otherlv_6= ')'
                            {
                            otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleASN1_SIMPLE1494); 

                                	newLeafNode(otherlv_4, grammarAccess.getASN1_SIMPLEAccess().getLeftParenthesisKeyword_2_1_0());
                                
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:683:1: ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:684:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:684:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:685:3: lv_constraint_5_0= ruleASN1_SUBTYPE
                            {
                             
                            	        newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE1515);
                            lv_constraint_5_0=ruleASN1_SUBTYPE();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getASN1_SIMPLERule());
                            	        }
                                   		set(
                                   			current, 
                                   			"constraint",
                                    		lv_constraint_5_0, 
                                    		"ASN1_SUBTYPE");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleASN1_SIMPLE1527); 

                                	newLeafNode(otherlv_6, grammarAccess.getASN1_SIMPLEAccess().getRightParenthesisKeyword_2_1_2());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleASN1_SIMPLE"


    // $ANTLR start "entryRuleASN1_OCTET_STRING"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:713:1: entryRuleASN1_OCTET_STRING returns [EObject current=null] : iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF ;
    public final EObject entryRuleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_OCTET_STRING = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:714:2: (iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:715:2: iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF
            {
             newCompositeNode(grammarAccess.getASN1_OCTET_STRINGRule()); 
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING1566);
            iv_ruleASN1_OCTET_STRING=ruleASN1_OCTET_STRING();

            state._fsp--;

             current =iv_ruleASN1_OCTET_STRING; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING1576); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleASN1_OCTET_STRING"


    // $ANTLR start "ruleASN1_OCTET_STRING"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:722:1: ruleASN1_OCTET_STRING returns [EObject current=null] : ( () otherlv_1= 'OCTET STRING' otherlv_2= 'TODO defintions.' ) ;
    public final EObject ruleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:725:28: ( ( () otherlv_1= 'OCTET STRING' otherlv_2= 'TODO defintions.' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:1: ( () otherlv_1= 'OCTET STRING' otherlv_2= 'TODO defintions.' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:1: ( () otherlv_1= 'OCTET STRING' otherlv_2= 'TODO defintions.' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:2: () otherlv_1= 'OCTET STRING' otherlv_2= 'TODO defintions.'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:727:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleASN1_OCTET_STRING1622); 

                	newLeafNode(otherlv_1, grammarAccess.getASN1_OCTET_STRINGAccess().getOCTETSTRINGKeyword_1());
                
            otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleASN1_OCTET_STRING1634); 

                	newLeafNode(otherlv_2, grammarAccess.getASN1_OCTET_STRINGAccess().getTODODefintionsKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleASN1_OCTET_STRING"


    // $ANTLR start "entryRuleASN1_INTEGER"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:748:1: entryRuleASN1_INTEGER returns [EObject current=null] : iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF ;
    public final EObject entryRuleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_INTEGER = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:749:2: (iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:750:2: iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF
            {
             newCompositeNode(grammarAccess.getASN1_INTEGERRule()); 
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER1670);
            iv_ruleASN1_INTEGER=ruleASN1_INTEGER();

            state._fsp--;

             current =iv_ruleASN1_INTEGER; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER1680); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleASN1_INTEGER"


    // $ANTLR start "ruleASN1_INTEGER"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:757:1: ruleASN1_INTEGER returns [EObject current=null] : (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' ) ;
    public final EObject ruleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_valuePairs_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:760:28: ( (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:761:1: (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:761:1: (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:761:3: otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleASN1_INTEGER1717); 

                	newLeafNode(otherlv_0, grammarAccess.getASN1_INTEGERAccess().getINTEGERKeyword_0());
                
            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleASN1_INTEGER1729); 

                	newLeafNode(otherlv_1, grammarAccess.getASN1_INTEGERAccess().getLeftCurlyBracketKeyword_1());
                
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:769:1: ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID||LA12_0==28) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:770:1: (lv_valuePairs_2_0= ruleASN1_VALUEPAIR )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:770:1: (lv_valuePairs_2_0= ruleASN1_VALUEPAIR )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:771:3: lv_valuePairs_2_0= ruleASN1_VALUEPAIR
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getASN1_INTEGERAccess().getValuePairsASN1_VALUEPAIRParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_ruleASN1_INTEGER1750);
            	    lv_valuePairs_2_0=ruleASN1_VALUEPAIR();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getASN1_INTEGERRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"valuePairs",
            	            		lv_valuePairs_2_0, 
            	            		"ASN1_VALUEPAIR");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleASN1_INTEGER1763); 

                	newLeafNode(otherlv_3, grammarAccess.getASN1_INTEGERAccess().getRightCurlyBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleASN1_INTEGER"


    // $ANTLR start "entryRuleASN1_VALUEPAIR"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:799:1: entryRuleASN1_VALUEPAIR returns [String current=null] : iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF ;
    public final String entryRuleASN1_VALUEPAIR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleASN1_VALUEPAIR = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:800:2: (iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:801:2: iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF
            {
             newCompositeNode(grammarAccess.getASN1_VALUEPAIRRule()); 
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR1800);
            iv_ruleASN1_VALUEPAIR=ruleASN1_VALUEPAIR();

            state._fsp--;

             current =iv_ruleASN1_VALUEPAIR.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR1811); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleASN1_VALUEPAIR"


    // $ANTLR start "ruleASN1_VALUEPAIR"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:808:1: ruleASN1_VALUEPAIR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleASN1_VALUEPAIR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:811:28: ( ( (this_ID_0= RULE_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:812:1: ( (this_ID_0= RULE_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:812:1: ( (this_ID_0= RULE_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:812:2: (this_ID_0= RULE_ID )? kw= '(' this_INT_2= RULE_INT kw= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:812:2: (this_ID_0= RULE_ID )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:812:7: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleASN1_VALUEPAIR1852); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getASN1_VALUEPAIRAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,28,FOLLOW_28_in_ruleASN1_VALUEPAIR1872); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getASN1_VALUEPAIRAccess().getLeftParenthesisKeyword_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_VALUEPAIR1887); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getASN1_VALUEPAIRAccess().getINTTerminalRuleCall_2()); 
                
            kw=(Token)match(input,26,FOLLOW_26_in_ruleASN1_VALUEPAIR1905); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getASN1_VALUEPAIRAccess().getRightParenthesisKeyword_3()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleASN1_VALUEPAIR"


    // $ANTLR start "entryRuleASN1_CHOICE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:846:1: entryRuleASN1_CHOICE returns [EObject current=null] : iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF ;
    public final EObject entryRuleASN1_CHOICE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:847:2: (iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:848:2: iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF
            {
             newCompositeNode(grammarAccess.getASN1_CHOICERule()); 
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE1945);
            iv_ruleASN1_CHOICE=ruleASN1_CHOICE();

            state._fsp--;

             current =iv_ruleASN1_CHOICE; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE1955); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleASN1_CHOICE"


    // $ANTLR start "ruleASN1_CHOICE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:855:1: ruleASN1_CHOICE returns [EObject current=null] : (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleASN1_CHOICE() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_choices_2_0 = null;

        EObject lv_choices_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:858:28: ( (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:859:1: (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:859:1: (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:859:3: otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleASN1_CHOICE1992); 

                	newLeafNode(otherlv_0, grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0());
                
            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleASN1_CHOICE2004); 

                	newLeafNode(otherlv_1, grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1());
                
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:867:1: ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:868:1: (lv_choices_2_0= ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:868:1: (lv_choices_2_0= ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:869:3: lv_choices_2_0= ruleASN1_CHOICE_ENTRY
            {
             
            	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE2025);
            lv_choices_2_0=ruleASN1_CHOICE_ENTRY();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getASN1_CHOICERule());
            	        }
                   		add(
                   			current, 
                   			"choices",
                    		lv_choices_2_0, 
                    		"ASN1_CHOICE_ENTRY");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:885:2: (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==35) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:885:4: otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) )
            	    {
            	    otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleASN1_CHOICE2038); 

            	        	newLeafNode(otherlv_3, grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_3_0());
            	        
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:889:1: ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:890:1: (lv_choices_4_0= ruleASN1_CHOICE_ENTRY )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:890:1: (lv_choices_4_0= ruleASN1_CHOICE_ENTRY )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:891:3: lv_choices_4_0= ruleASN1_CHOICE_ENTRY
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE2059);
            	    lv_choices_4_0=ruleASN1_CHOICE_ENTRY();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getASN1_CHOICERule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"choices",
            	            		lv_choices_4_0, 
            	            		"ASN1_CHOICE_ENTRY");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleASN1_CHOICE2073); 

                	newLeafNode(otherlv_5, grammarAccess.getASN1_CHOICEAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleASN1_CHOICE"


    // $ANTLR start "entryRuleASN1_CHOICE_ENTRY"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:919:1: entryRuleASN1_CHOICE_ENTRY returns [EObject current=null] : iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF ;
    public final EObject entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE_ENTRY = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:920:2: (iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:921:2: iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF
            {
             newCompositeNode(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY2109);
            iv_ruleASN1_CHOICE_ENTRY=ruleASN1_CHOICE_ENTRY();

            state._fsp--;

             current =iv_ruleASN1_CHOICE_ENTRY; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY2119); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleASN1_CHOICE_ENTRY"


    // $ANTLR start "ruleASN1_CHOICE_ENTRY"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:928:1: ruleASN1_CHOICE_ENTRY returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:931:28: ( ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:932:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:932:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:932:2: ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:932:2: ( (lv_id_0_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:933:1: (lv_id_0_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:933:1: (lv_id_0_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:934:3: lv_id_0_0= RULE_ASN1_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY2161); 

            			newLeafNode(lv_id_0_0, grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdASN1_IDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getASN1_CHOICE_ENTRYRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_0_0, 
                    		"ASN1_ID");
            	    

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:950:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:951:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:951:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:952:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getASN1_CHOICE_ENTRYRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleASN1_CHOICE_ENTRY2186); 

            		newLeafNode(otherlv_1, grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueTypeCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleASN1_CHOICE_ENTRY"


    // $ANTLR start "entryRuleASN1_SUBTYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:971:1: entryRuleASN1_SUBTYPE returns [EObject current=null] : iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF ;
    public final EObject entryRuleASN1_SUBTYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SUBTYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:972:2: (iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:973:2: iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF
            {
             newCompositeNode(grammarAccess.getASN1_SUBTYPERule()); 
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE2222);
            iv_ruleASN1_SUBTYPE=ruleASN1_SUBTYPE();

            state._fsp--;

             current =iv_ruleASN1_SUBTYPE; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE2232); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleASN1_SUBTYPE"


    // $ANTLR start "ruleASN1_SUBTYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:980:1: ruleASN1_SUBTYPE returns [EObject current=null] : ( (otherlv_0= 'SIZE' ( (lv_range_1_0= ruleASN1_RANGE ) ) ) | ( (lv_value_2_0= RULE_INT ) ) ) ;
    public final EObject ruleASN1_SUBTYPE() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_2_0=null;
        EObject lv_range_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:983:28: ( ( (otherlv_0= 'SIZE' ( (lv_range_1_0= ruleASN1_RANGE ) ) ) | ( (lv_value_2_0= RULE_INT ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:984:1: ( (otherlv_0= 'SIZE' ( (lv_range_1_0= ruleASN1_RANGE ) ) ) | ( (lv_value_2_0= RULE_INT ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:984:1: ( (otherlv_0= 'SIZE' ( (lv_range_1_0= ruleASN1_RANGE ) ) ) | ( (lv_value_2_0= RULE_INT ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==36) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_INT) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:984:2: (otherlv_0= 'SIZE' ( (lv_range_1_0= ruleASN1_RANGE ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:984:2: (otherlv_0= 'SIZE' ( (lv_range_1_0= ruleASN1_RANGE ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:984:4: otherlv_0= 'SIZE' ( (lv_range_1_0= ruleASN1_RANGE ) )
                    {
                    otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleASN1_SUBTYPE2270); 

                        	newLeafNode(otherlv_0, grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_0_0());
                        
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:988:1: ( (lv_range_1_0= ruleASN1_RANGE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:989:1: (lv_range_1_0= ruleASN1_RANGE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:989:1: (lv_range_1_0= ruleASN1_RANGE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:990:3: lv_range_1_0= ruleASN1_RANGE
                    {
                     
                    	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangeASN1_RANGEParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE2291);
                    lv_range_1_0=ruleASN1_RANGE();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getASN1_SUBTYPERule());
                    	        }
                           		set(
                           			current, 
                           			"range",
                            		lv_range_1_0, 
                            		"ASN1_RANGE");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1007:6: ( (lv_value_2_0= RULE_INT ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1007:6: ( (lv_value_2_0= RULE_INT ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1008:1: (lv_value_2_0= RULE_INT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1008:1: (lv_value_2_0= RULE_INT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1009:3: lv_value_2_0= RULE_INT
                    {
                    lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_SUBTYPE2315); 

                    			newLeafNode(lv_value_2_0, grammarAccess.getASN1_SUBTYPEAccess().getValueINTTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getASN1_SUBTYPERule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_2_0, 
                            		"INT");
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleASN1_SUBTYPE"


    // $ANTLR start "entryRuleASN1_RANGE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1033:1: entryRuleASN1_RANGE returns [EObject current=null] : iv_ruleASN1_RANGE= ruleASN1_RANGE EOF ;
    public final EObject entryRuleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_RANGE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1034:2: (iv_ruleASN1_RANGE= ruleASN1_RANGE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1035:2: iv_ruleASN1_RANGE= ruleASN1_RANGE EOF
            {
             newCompositeNode(grammarAccess.getASN1_RANGERule()); 
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE2356);
            iv_ruleASN1_RANGE=ruleASN1_RANGE();

            state._fsp--;

             current =iv_ruleASN1_RANGE; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE2366); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleASN1_RANGE"


    // $ANTLR start "ruleASN1_RANGE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1042:1: ruleASN1_RANGE returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) otherlv_5= ')' ) ;
    public final EObject ruleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_start_2_0=null;
        Token otherlv_3=null;
        Token lv_end_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1045:28: ( ( () otherlv_1= '(' ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) otherlv_5= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1046:1: ( () otherlv_1= '(' ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) otherlv_5= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1046:1: ( () otherlv_1= '(' ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) otherlv_5= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1046:2: () otherlv_1= '(' ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) otherlv_5= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1046:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1047:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleASN1_RANGE2412); 

                	newLeafNode(otherlv_1, grammarAccess.getASN1_RANGEAccess().getLeftParenthesisKeyword_1());
                
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1056:1: ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1056:2: ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1056:2: ( (lv_start_2_0= RULE_INT ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1057:1: (lv_start_2_0= RULE_INT )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1057:1: (lv_start_2_0= RULE_INT )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1058:3: lv_start_2_0= RULE_INT
            {
            lv_start_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_RANGE2430); 

            			newLeafNode(lv_start_2_0, grammarAccess.getASN1_RANGEAccess().getStartINTTerminalRuleCall_2_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getASN1_RANGERule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"start",
                    		lv_start_2_0, 
                    		"INT");
            	    

            }


            }

            otherlv_3=(Token)match(input,37,FOLLOW_37_in_ruleASN1_RANGE2447); 

                	newLeafNode(otherlv_3, grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_2_1());
                
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1078:1: ( (lv_end_4_0= RULE_INT ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1079:1: (lv_end_4_0= RULE_INT )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1079:1: (lv_end_4_0= RULE_INT )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1080:3: lv_end_4_0= RULE_INT
            {
            lv_end_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_RANGE2464); 

            			newLeafNode(lv_end_4_0, grammarAccess.getASN1_RANGEAccess().getEndINTTerminalRuleCall_2_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getASN1_RANGERule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"end",
                    		lv_end_4_0, 
                    		"INT");
            	    

            }


            }


            }

            otherlv_5=(Token)match(input,26,FOLLOW_26_in_ruleASN1_RANGE2482); 

                	newLeafNode(otherlv_5, grammarAccess.getASN1_RANGEAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleASN1_RANGE"


    // $ANTLR start "entryRuleObjectIdentifier"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1108:1: entryRuleObjectIdentifier returns [EObject current=null] : iv_ruleObjectIdentifier= ruleObjectIdentifier EOF ;
    public final EObject entryRuleObjectIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectIdentifier = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1109:2: (iv_ruleObjectIdentifier= ruleObjectIdentifier EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1110:2: iv_ruleObjectIdentifier= ruleObjectIdentifier EOF
            {
             newCompositeNode(grammarAccess.getObjectIdentifierRule()); 
            pushFollow(FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier2518);
            iv_ruleObjectIdentifier=ruleObjectIdentifier();

            state._fsp--;

             current =iv_ruleObjectIdentifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifier2528); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectIdentifier"


    // $ANTLR start "ruleObjectIdentifier"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1117:1: ruleObjectIdentifier returns [EObject current=null] : ( ( (lv_descriptor_0_0= RULE_ASN1_ID ) ) otherlv_1= 'OBJECT IDENTIFIER' otherlv_2= '::=' otherlv_3= '{' ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) ) otherlv_5= '}' ) ;
    public final EObject ruleObjectIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_descriptor_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_oidValue_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1120:28: ( ( ( (lv_descriptor_0_0= RULE_ASN1_ID ) ) otherlv_1= 'OBJECT IDENTIFIER' otherlv_2= '::=' otherlv_3= '{' ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) ) otherlv_5= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1121:1: ( ( (lv_descriptor_0_0= RULE_ASN1_ID ) ) otherlv_1= 'OBJECT IDENTIFIER' otherlv_2= '::=' otherlv_3= '{' ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) ) otherlv_5= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1121:1: ( ( (lv_descriptor_0_0= RULE_ASN1_ID ) ) otherlv_1= 'OBJECT IDENTIFIER' otherlv_2= '::=' otherlv_3= '{' ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) ) otherlv_5= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1121:2: ( (lv_descriptor_0_0= RULE_ASN1_ID ) ) otherlv_1= 'OBJECT IDENTIFIER' otherlv_2= '::=' otherlv_3= '{' ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) ) otherlv_5= '}'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1121:2: ( (lv_descriptor_0_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1122:1: (lv_descriptor_0_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1122:1: (lv_descriptor_0_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1123:3: lv_descriptor_0_0= RULE_ASN1_ID
            {
            lv_descriptor_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifier2570); 

            			newLeafNode(lv_descriptor_0_0, grammarAccess.getObjectIdentifierAccess().getDescriptorASN1_IDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectIdentifierRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"descriptor",
                    		lv_descriptor_0_0, 
                    		"ASN1_ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleObjectIdentifier2587); 

                	newLeafNode(otherlv_1, grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_1());
                
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleObjectIdentifier2599); 

                	newLeafNode(otherlv_2, grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_2());
                
            otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleObjectIdentifier2611); 

                	newLeafNode(otherlv_3, grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_3());
                
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1151:1: ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1152:1: (lv_oidValue_4_0= ruleObjectIdentifierValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1152:1: (lv_oidValue_4_0= ruleObjectIdentifierValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1153:3: lv_oidValue_4_0= ruleObjectIdentifierValue
            {
             
            	        newCompositeNode(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_ruleObjectIdentifier2632);
            lv_oidValue_4_0=ruleObjectIdentifierValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getObjectIdentifierRule());
            	        }
                   		set(
                   			current, 
                   			"oidValue",
                    		lv_oidValue_4_0, 
                    		"ObjectIdentifierValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleObjectIdentifier2644); 

                	newLeafNode(otherlv_5, grammarAccess.getObjectIdentifierAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectIdentifier"


    // $ANTLR start "entryRuleObjectIdentifierValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1181:1: entryRuleObjectIdentifierValue returns [EObject current=null] : iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF ;
    public final EObject entryRuleObjectIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectIdentifierValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1182:2: (iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1183:2: iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF
            {
             newCompositeNode(grammarAccess.getObjectIdentifierValueRule()); 
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue2680);
            iv_ruleObjectIdentifierValue=ruleObjectIdentifierValue();

            state._fsp--;

             current =iv_ruleObjectIdentifierValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifierValue2690); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectIdentifierValue"


    // $ANTLR start "ruleObjectIdentifierValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1190:1: ruleObjectIdentifierValue returns [EObject current=null] : ( ( (otherlv_0= RULE_ASN1_ID ) )? ( (lv_subIds_1_0= RULE_INT ) ) ( (lv_subIds_2_0= RULE_INT ) )* ) ;
    public final EObject ruleObjectIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_subIds_1_0=null;
        Token lv_subIds_2_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1193:28: ( ( ( (otherlv_0= RULE_ASN1_ID ) )? ( (lv_subIds_1_0= RULE_INT ) ) ( (lv_subIds_2_0= RULE_INT ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1194:1: ( ( (otherlv_0= RULE_ASN1_ID ) )? ( (lv_subIds_1_0= RULE_INT ) ) ( (lv_subIds_2_0= RULE_INT ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1194:1: ( ( (otherlv_0= RULE_ASN1_ID ) )? ( (lv_subIds_1_0= RULE_INT ) ) ( (lv_subIds_2_0= RULE_INT ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1194:2: ( (otherlv_0= RULE_ASN1_ID ) )? ( (lv_subIds_1_0= RULE_INT ) ) ( (lv_subIds_2_0= RULE_INT ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1194:2: ( (otherlv_0= RULE_ASN1_ID ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ASN1_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1195:1: (otherlv_0= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1195:1: (otherlv_0= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1196:3: otherlv_0= RULE_ASN1_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue2735); 

                    		newLeafNode(otherlv_0, grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_0()); 
                    	

                    }


                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1207:3: ( (lv_subIds_1_0= RULE_INT ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1208:1: (lv_subIds_1_0= RULE_INT )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1208:1: (lv_subIds_1_0= RULE_INT )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1209:3: lv_subIds_1_0= RULE_INT
            {
            lv_subIds_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleObjectIdentifierValue2753); 

            			newLeafNode(lv_subIds_1_0, grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"subIds",
                    		lv_subIds_1_0, 
                    		"INT");
            	    

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1225:2: ( (lv_subIds_2_0= RULE_INT ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_INT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1226:1: (lv_subIds_2_0= RULE_INT )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1226:1: (lv_subIds_2_0= RULE_INT )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1227:3: lv_subIds_2_0= RULE_INT
            	    {
            	    lv_subIds_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleObjectIdentifierValue2775); 

            	    			newLeafNode(lv_subIds_2_0, grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"subIds",
            	            		lv_subIds_2_0, 
            	            		"INT");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectIdentifierValue"


    // $ANTLR start "ruleMACRO_VALUE_TYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1251:1: ruleMACRO_VALUE_TYPE returns [Enumerator current=null] : ( (enumLiteral_0= 'VALUE' ) | (enumLiteral_1= 'Update' ) ) ;
    public final Enumerator ruleMACRO_VALUE_TYPE() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1253:28: ( ( (enumLiteral_0= 'VALUE' ) | (enumLiteral_1= 'Update' ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1254:1: ( (enumLiteral_0= 'VALUE' ) | (enumLiteral_1= 'Update' ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1254:1: ( (enumLiteral_0= 'VALUE' ) | (enumLiteral_1= 'Update' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==39) ) {
                alt18=1;
            }
            else if ( (LA18_0==40) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1254:2: (enumLiteral_0= 'VALUE' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1254:2: (enumLiteral_0= 'VALUE' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1254:4: enumLiteral_0= 'VALUE'
                    {
                    enumLiteral_0=(Token)match(input,39,FOLLOW_39_in_ruleMACRO_VALUE_TYPE2831); 

                            current = grammarAccess.getMACRO_VALUE_TYPEAccess().getVALUEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getMACRO_VALUE_TYPEAccess().getVALUEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1260:6: (enumLiteral_1= 'Update' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1260:6: (enumLiteral_1= 'Update' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1260:8: enumLiteral_1= 'Update'
                    {
                    enumLiteral_1=(Token)match(input,40,FOLLOW_40_in_ruleMACRO_VALUE_TYPE2848); 

                            current = grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMACRO_VALUE_TYPE"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleModule127 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleModule144 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleModule156 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleModule168 = new BitSet(new long[]{0x0000000000200210L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleModule189 = new BitSet(new long[]{0x0000000000200210L});
    public static final BitSet FOLLOW_21_in_ruleModule202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment238 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_ruleAssignment294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueAssignment_in_ruleAssignment321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_ruleAssignment349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_entryRuleMacro384 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacro394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroDescriptor_in_ruleMacro440 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleMacro452 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleMacro464 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleMacro476 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleMacro488 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMacro508 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_24_in_ruleMacro521 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleMacro542 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValueAssignment_in_ruleMacro563 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_21_in_ruleMacro576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroDescriptor_in_entryRuleMacroDescriptor613 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroDescriptor624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleMacroDescriptor663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleMacroValue763 = new BitSet(new long[]{0x0000018000000040L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_ruleMacroValue784 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_ruleMacroValue796 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleMacroValue807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueAssignment_in_entryRuleValueAssignment843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueAssignment853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleValueAssignment895 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleValueAssignment912 = new BitSet(new long[]{0x00000004A00000A0L});
    public static final BitSet FOLLOW_ruleOr_in_ruleValueAssignment933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOr_in_entryRuleOr969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOr979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleOr1026 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleOr1048 = new BitSet(new long[]{0x00000004A00000A0L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleOr1070 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType1108 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_ruleValueType1160 = new BitSet(new long[]{0x00000004A00000A0L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValueType1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_ruleValueType1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE1251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE1370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE1482 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_ruleASN1_SIMPLE1494 = new BitSet(new long[]{0x0000001000000100L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE1515 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleASN1_SIMPLE1527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING1566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleASN1_OCTET_STRING1622 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleASN1_OCTET_STRING1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER1670 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER1680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleASN1_INTEGER1717 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleASN1_INTEGER1729 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_ruleASN1_INTEGER1750 = new BitSet(new long[]{0x0000000210000020L});
    public static final BitSet FOLLOW_33_in_ruleASN1_INTEGER1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR1800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleASN1_VALUEPAIR1852 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleASN1_VALUEPAIR1872 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_VALUEPAIR1887 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleASN1_VALUEPAIR1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE1945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleASN1_CHOICE1992 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleASN1_CHOICE2004 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE2025 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_35_in_ruleASN1_CHOICE2038 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE2059 = new BitSet(new long[]{0x0000000A00000000L});
    public static final BitSet FOLLOW_33_in_ruleASN1_CHOICE2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY2109 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY2161 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleASN1_CHOICE_ENTRY2186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE2222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE2232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleASN1_SUBTYPE2270 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_SUBTYPE2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE2356 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleASN1_RANGE2412 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_RANGE2430 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleASN1_RANGE2447 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_RANGE2464 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleASN1_RANGE2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier2518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifier2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifier2570 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleObjectIdentifier2587 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleObjectIdentifier2599 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleObjectIdentifier2611 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_ruleObjectIdentifier2632 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleObjectIdentifier2644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue2680 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifierValue2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue2735 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleObjectIdentifierValue2753 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleObjectIdentifierValue2775 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_39_in_ruleMACRO_VALUE_TYPE2831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleMACRO_VALUE_TYPE2848 = new BitSet(new long[]{0x0000000000000002L});

}