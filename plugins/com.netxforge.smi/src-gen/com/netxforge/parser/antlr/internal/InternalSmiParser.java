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
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSmiParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_MODULE_ID", "RULE_ASN1_ID", "RULE_ID", "RULE_INT", "RULE_PARAMETER", "RULE_IA5STRING", "RULE_ALPHA_CAP", "RULE_ALPHA", "RULE_NUMERIC", "RULE_SL_ASN1_COMMENT", "RULE_WS", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'DEFINITIONS'", "'::='", "'BEGIN'", "'END'", "'OBJECT IDENTIFIER'", "'{'", "'}'", "'MACRO'", "'TYPE NOTATION'", "'VALUE NOTATION'", "'|'", "'value'", "'('", "')'", "'Update'", "'VALUE'", "'empty'", "'OCTET STRING'", "'INTEGER'", "'SIZE'", "'..'", "'CHOICE'", "','", "'IA5String'"
    };
    public static final int T__42=42;
    public static final int RULE_ID=6;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_ALPHA_CAP=10;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int RULE_IA5STRING=9;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=18;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_ASN1_ID=5;
    public static final int RULE_ALPHA=11;
    public static final int RULE_SL_COMMENT=17;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=16;
    public static final int RULE_MODULE_ID=4;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=15;
    public static final int T__32=32;
    public static final int RULE_NUMERIC=12;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_INT=7;
    public static final int RULE_WS=14;
    public static final int RULE_SL_ASN1_COMMENT=13;
    public static final int RULE_PARAMETER=8;

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
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleRule()); 
            }
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule75);
            iv_ruleModule=ruleModule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule85); if (state.failed) return current;

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
            lv_id_0_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleModule127); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_id_0_0, grammarAccess.getModuleAccess().getIdMODULE_IDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

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


            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleModule144); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getModuleAccess().getDEFINITIONSKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleModule156); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleModule168); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getBEGINKeyword_3());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:111:1: ( (lv_assignments_4_0= ruleAssignment ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_MODULE_ID && LA1_0<=RULE_ASN1_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:112:1: (lv_assignments_4_0= ruleAssignment )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:112:1: (lv_assignments_4_0= ruleAssignment )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:113:3: lv_assignments_4_0= ruleAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getAssignmentsAssignmentParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAssignment_in_ruleModule189);
            	    lv_assignments_4_0=ruleAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleModule202); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getModuleAccess().getENDKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment238);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment248); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:150:1: ruleAssignment returns [EObject current=null] : ( ( (lv_identifier_0_0= ruleObjectIdentifier ) ) | ( (lv_type_1_0= ruleTypeDefinition ) ) | ( (lv_macro_2_0= ruleMacro ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_identifier_0_0 = null;

        EObject lv_type_1_0 = null;

        EObject lv_macro_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:153:28: ( ( ( (lv_identifier_0_0= ruleObjectIdentifier ) ) | ( (lv_type_1_0= ruleTypeDefinition ) ) | ( (lv_macro_2_0= ruleMacro ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:154:1: ( ( (lv_identifier_0_0= ruleObjectIdentifier ) ) | ( (lv_type_1_0= ruleTypeDefinition ) ) | ( (lv_macro_2_0= ruleMacro ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:154:1: ( ( (lv_identifier_0_0= ruleObjectIdentifier ) ) | ( (lv_type_1_0= ruleTypeDefinition ) ) | ( (lv_macro_2_0= ruleMacro ) ) )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ASN1_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_MODULE_ID) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==26) ) {
                    alt2=3;
                }
                else if ( (LA2_2==20) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:154:2: ( (lv_identifier_0_0= ruleObjectIdentifier ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:154:2: ( (lv_identifier_0_0= ruleObjectIdentifier ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:155:1: (lv_identifier_0_0= ruleObjectIdentifier )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:155:1: (lv_identifier_0_0= ruleObjectIdentifier )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:156:3: lv_identifier_0_0= ruleObjectIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentAccess().getIdentifierObjectIdentifierParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleObjectIdentifier_in_ruleAssignment294);
                    lv_identifier_0_0=ruleObjectIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      	        }
                             		set(
                             			current, 
                             			"identifier",
                              		lv_identifier_0_0, 
                              		"ObjectIdentifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:173:6: ( (lv_type_1_0= ruleTypeDefinition ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:173:6: ( (lv_type_1_0= ruleTypeDefinition ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:174:1: (lv_type_1_0= ruleTypeDefinition )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:174:1: (lv_type_1_0= ruleTypeDefinition )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:175:3: lv_type_1_0= ruleTypeDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentAccess().getTypeTypeDefinitionParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleAssignment321);
                    lv_type_1_0=ruleTypeDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_1_0, 
                              		"TypeDefinition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:192:6: ( (lv_macro_2_0= ruleMacro ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:192:6: ( (lv_macro_2_0= ruleMacro ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:193:1: (lv_macro_2_0= ruleMacro )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:193:1: (lv_macro_2_0= ruleMacro )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:194:3: lv_macro_2_0= ruleMacro
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAssignmentAccess().getMacroMacroParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacro_in_ruleAssignment348);
                    lv_macro_2_0=ruleMacro();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      	        }
                             		set(
                             			current, 
                             			"macro",
                              		lv_macro_2_0, 
                              		"Macro");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleObjectIdentifier"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:218:1: entryRuleObjectIdentifier returns [EObject current=null] : iv_ruleObjectIdentifier= ruleObjectIdentifier EOF ;
    public final EObject entryRuleObjectIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectIdentifier = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:219:2: (iv_ruleObjectIdentifier= ruleObjectIdentifier EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:220:2: iv_ruleObjectIdentifier= ruleObjectIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier384);
            iv_ruleObjectIdentifier=ruleObjectIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectIdentifier; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifier394); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:227:1: ruleObjectIdentifier returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ASN1_ID ) ) otherlv_1= 'OBJECT IDENTIFIER' otherlv_2= '::=' otherlv_3= '{' ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) ) otherlv_5= '}' ) ;
    public final EObject ruleObjectIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_oidValue_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:230:28: ( ( ( (lv_name_0_0= RULE_ASN1_ID ) ) otherlv_1= 'OBJECT IDENTIFIER' otherlv_2= '::=' otherlv_3= '{' ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) ) otherlv_5= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:231:1: ( ( (lv_name_0_0= RULE_ASN1_ID ) ) otherlv_1= 'OBJECT IDENTIFIER' otherlv_2= '::=' otherlv_3= '{' ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) ) otherlv_5= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:231:1: ( ( (lv_name_0_0= RULE_ASN1_ID ) ) otherlv_1= 'OBJECT IDENTIFIER' otherlv_2= '::=' otherlv_3= '{' ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) ) otherlv_5= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:231:2: ( (lv_name_0_0= RULE_ASN1_ID ) ) otherlv_1= 'OBJECT IDENTIFIER' otherlv_2= '::=' otherlv_3= '{' ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) ) otherlv_5= '}'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:231:2: ( (lv_name_0_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:232:1: (lv_name_0_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:232:1: (lv_name_0_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:233:3: lv_name_0_0= RULE_ASN1_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifier436); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getObjectIdentifierAccess().getNameASN1_IDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getObjectIdentifierRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ASN1_ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleObjectIdentifier453); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleObjectIdentifier465); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleObjectIdentifier477); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:261:1: ( (lv_oidValue_4_0= ruleObjectIdentifierValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:262:1: (lv_oidValue_4_0= ruleObjectIdentifierValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:262:1: (lv_oidValue_4_0= ruleObjectIdentifierValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:263:3: lv_oidValue_4_0= ruleObjectIdentifierValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_ruleObjectIdentifier498);
            lv_oidValue_4_0=ruleObjectIdentifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleObjectIdentifier510); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getObjectIdentifierAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleObjectIdentifier"


    // $ANTLR start "entryRuleObjectIdentifierValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:291:1: entryRuleObjectIdentifierValue returns [EObject current=null] : iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF ;
    public final EObject entryRuleObjectIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectIdentifierValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:292:2: (iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:293:2: iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectIdentifierValueRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue546);
            iv_ruleObjectIdentifierValue=ruleObjectIdentifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectIdentifierValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifierValue556); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:300:1: ruleObjectIdentifierValue returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) | this_ASN1_ID_1= RULE_ASN1_ID )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* ) ;
    public final EObject ruleObjectIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ASN1_ID_1=null;
        Token lv_subIds_2_0=null;
        Token lv_subIds_3_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:303:28: ( ( ( ( (otherlv_0= RULE_ID ) ) | this_ASN1_ID_1= RULE_ASN1_ID )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:304:1: ( ( ( (otherlv_0= RULE_ID ) ) | this_ASN1_ID_1= RULE_ASN1_ID )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:304:1: ( ( ( (otherlv_0= RULE_ID ) ) | this_ASN1_ID_1= RULE_ASN1_ID )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:304:2: ( ( (otherlv_0= RULE_ID ) ) | this_ASN1_ID_1= RULE_ASN1_ID )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:304:2: ( ( (otherlv_0= RULE_ID ) ) | this_ASN1_ID_1= RULE_ASN1_ID )?
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ASN1_ID) ) {
                alt3=2;
            }
            switch (alt3) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:304:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:304:3: ( (otherlv_0= RULE_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:305:1: (otherlv_0= RULE_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:305:1: (otherlv_0= RULE_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:306:3: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjectIdentifierValue602); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_0_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:318:6: this_ASN1_ID_1= RULE_ASN1_ID
                    {
                    this_ASN1_ID_1=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue619); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ASN1_ID_1, grammarAccess.getObjectIdentifierValueAccess().getASN1_IDTerminalRuleCall_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:322:3: ( (lv_subIds_2_0= RULE_INT ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:323:1: (lv_subIds_2_0= RULE_INT )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:323:1: (lv_subIds_2_0= RULE_INT )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:324:3: lv_subIds_2_0= RULE_INT
            {
            lv_subIds_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleObjectIdentifierValue637); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_subIds_2_0, grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

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


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:340:2: ( (lv_subIds_3_0= RULE_INT ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_INT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:341:1: (lv_subIds_3_0= RULE_INT )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:341:1: (lv_subIds_3_0= RULE_INT )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:342:3: lv_subIds_3_0= RULE_INT
            	    {
            	    lv_subIds_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleObjectIdentifierValue659); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_subIds_3_0, grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_2_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"subIds",
            	              		lv_subIds_3_0, 
            	              		"INT");
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleObjectIdentifierValue"


    // $ANTLR start "entryRuleTypeDefinition"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:366:1: entryRuleTypeDefinition returns [EObject current=null] : iv_ruleTypeDefinition= ruleTypeDefinition EOF ;
    public final EObject entryRuleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinition = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:367:2: (iv_ruleTypeDefinition= ruleTypeDefinition EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:368:2: iv_ruleTypeDefinition= ruleTypeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition701);
            iv_ruleTypeDefinition=ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDefinition711); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeDefinition"


    // $ANTLR start "ruleTypeDefinition"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:375:1: ruleTypeDefinition returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= '::=' ( (lv_scope_2_0= ruleScope ) ) ) ;
    public final EObject ruleTypeDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_scope_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:378:28: ( ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= '::=' ( (lv_scope_2_0= ruleScope ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:379:1: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= '::=' ( (lv_scope_2_0= ruleScope ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:379:1: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= '::=' ( (lv_scope_2_0= ruleScope ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:379:2: ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= '::=' ( (lv_scope_2_0= ruleScope ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:379:2: ( (lv_name_0_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:380:1: (lv_name_0_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:380:1: (lv_name_0_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:381:3: lv_name_0_0= RULE_MODULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleTypeDefinition753); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getTypeDefinitionAccess().getNameMODULE_IDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"MODULE_ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleTypeDefinition770); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTypeDefinitionAccess().getColonColonEqualsSignKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:401:1: ( (lv_scope_2_0= ruleScope ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:402:1: (lv_scope_2_0= ruleScope )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:402:1: (lv_scope_2_0= ruleScope )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:403:3: lv_scope_2_0= ruleScope
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDefinitionAccess().getScopeScopeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleScope_in_ruleTypeDefinition791);
            lv_scope_2_0=ruleScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"scope",
                      		lv_scope_2_0, 
                      		"Scope");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleTypeDefinition"


    // $ANTLR start "entryRuleMacro"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:427:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:428:2: (iv_ruleMacro= ruleMacro EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:429:2: iv_ruleMacro= ruleMacro EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroRule()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_entryRuleMacro827);
            iv_ruleMacro=ruleMacro();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacro; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacro837); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:436:1: ruleMacro returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'MACRO' otherlv_2= '::=' otherlv_3= 'BEGIN' otherlv_4= 'TYPE NOTATION' otherlv_5= '::=' ( (lv_typeNotations_6_0= ruleTypeAssignment ) )+ otherlv_7= 'VALUE NOTATION' otherlv_8= '::=' ( (lv_valueNotation_9_0= ruleMacroValue ) ) ( (lv_innerTypes_10_0= ruleTypeDefinition ) )+ otherlv_11= 'END' ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        EObject lv_typeNotations_6_0 = null;

        EObject lv_valueNotation_9_0 = null;

        EObject lv_innerTypes_10_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:439:28: ( ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'MACRO' otherlv_2= '::=' otherlv_3= 'BEGIN' otherlv_4= 'TYPE NOTATION' otherlv_5= '::=' ( (lv_typeNotations_6_0= ruleTypeAssignment ) )+ otherlv_7= 'VALUE NOTATION' otherlv_8= '::=' ( (lv_valueNotation_9_0= ruleMacroValue ) ) ( (lv_innerTypes_10_0= ruleTypeDefinition ) )+ otherlv_11= 'END' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:440:1: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'MACRO' otherlv_2= '::=' otherlv_3= 'BEGIN' otherlv_4= 'TYPE NOTATION' otherlv_5= '::=' ( (lv_typeNotations_6_0= ruleTypeAssignment ) )+ otherlv_7= 'VALUE NOTATION' otherlv_8= '::=' ( (lv_valueNotation_9_0= ruleMacroValue ) ) ( (lv_innerTypes_10_0= ruleTypeDefinition ) )+ otherlv_11= 'END' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:440:1: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'MACRO' otherlv_2= '::=' otherlv_3= 'BEGIN' otherlv_4= 'TYPE NOTATION' otherlv_5= '::=' ( (lv_typeNotations_6_0= ruleTypeAssignment ) )+ otherlv_7= 'VALUE NOTATION' otherlv_8= '::=' ( (lv_valueNotation_9_0= ruleMacroValue ) ) ( (lv_innerTypes_10_0= ruleTypeDefinition ) )+ otherlv_11= 'END' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:440:2: ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'MACRO' otherlv_2= '::=' otherlv_3= 'BEGIN' otherlv_4= 'TYPE NOTATION' otherlv_5= '::=' ( (lv_typeNotations_6_0= ruleTypeAssignment ) )+ otherlv_7= 'VALUE NOTATION' otherlv_8= '::=' ( (lv_valueNotation_9_0= ruleMacroValue ) ) ( (lv_innerTypes_10_0= ruleTypeDefinition ) )+ otherlv_11= 'END'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:440:2: ( (lv_name_0_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:441:1: (lv_name_0_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:441:1: (lv_name_0_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:442:3: lv_name_0_0= RULE_MODULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleMacro879); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getMacroAccess().getNameMODULE_IDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMacroRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"MODULE_ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleMacro896); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMacroAccess().getMACROKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleMacro908); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleMacro920); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMacroAccess().getBEGINKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleMacro932); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getMacroAccess().getTYPENOTATIONKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleMacro944); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_5());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:478:1: ( (lv_typeNotations_6_0= ruleTypeAssignment ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_MODULE_ID||LA5_0==RULE_PARAMETER) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:479:1: (lv_typeNotations_6_0= ruleTypeAssignment )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:479:1: (lv_typeNotations_6_0= ruleTypeAssignment )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:480:3: lv_typeNotations_6_0= ruleTypeAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMacroAccess().getTypeNotationsTypeAssignmentParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeAssignment_in_ruleMacro965);
            	    lv_typeNotations_6_0=ruleTypeAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMacroRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"typeNotations",
            	              		lv_typeNotations_6_0, 
            	              		"TypeAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            otherlv_7=(Token)match(input,28,FOLLOW_28_in_ruleMacro978); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMacroAccess().getVALUENOTATIONKeyword_7());
                  
            }
            otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleMacro990); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_8());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:504:1: ( (lv_valueNotation_9_0= ruleMacroValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:505:1: (lv_valueNotation_9_0= ruleMacroValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:505:1: (lv_valueNotation_9_0= ruleMacroValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:506:3: lv_valueNotation_9_0= ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_9_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMacroValue_in_ruleMacro1011);
            lv_valueNotation_9_0=ruleMacroValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMacroRule());
              	        }
                     		set(
                     			current, 
                     			"valueNotation",
                      		lv_valueNotation_9_0, 
                      		"MacroValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:522:2: ( (lv_innerTypes_10_0= ruleTypeDefinition ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_MODULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:523:1: (lv_innerTypes_10_0= ruleTypeDefinition )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:523:1: (lv_innerTypes_10_0= ruleTypeDefinition )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:524:3: lv_innerTypes_10_0= ruleTypeDefinition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_10_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleMacro1032);
            	    lv_innerTypes_10_0=ruleTypeDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMacroRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"innerTypes",
            	              		lv_innerTypes_10_0, 
            	              		"TypeDefinition");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            otherlv_11=(Token)match(input,22,FOLLOW_22_in_ruleMacro1045); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getMacroAccess().getENDKeyword_11());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleMacro"


    // $ANTLR start "entryRuleTypeAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:552:1: entryRuleTypeAssignment returns [EObject current=null] : iv_ruleTypeAssignment= ruleTypeAssignment EOF ;
    public final EObject entryRuleTypeAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:553:2: (iv_ruleTypeAssignment= ruleTypeAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:554:2: iv_ruleTypeAssignment= ruleTypeAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment1081);
            iv_ruleTypeAssignment=ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAssignment1091); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeAssignment"


    // $ANTLR start "ruleTypeAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:561:1: ruleTypeAssignment returns [EObject current=null] : (this_ParamAssignment_0= ruleParamAssignment | this_TypeReference_1= ruleTypeReference ) ;
    public final EObject ruleTypeAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_ParamAssignment_0 = null;

        EObject this_TypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:564:28: ( (this_ParamAssignment_0= ruleParamAssignment | this_TypeReference_1= ruleTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:565:1: (this_ParamAssignment_0= ruleParamAssignment | this_TypeReference_1= ruleTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:565:1: (this_ParamAssignment_0= ruleParamAssignment | this_TypeReference_1= ruleTypeReference )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_PARAMETER) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_MODULE_ID) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:566:5: this_ParamAssignment_0= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleTypeAssignment1138);
                    this_ParamAssignment_0=ruleParamAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ParamAssignment_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:576:5: this_TypeReference_1= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeAssignment1165);
                    this_TypeReference_1=ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeReference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleTypeAssignment"


    // $ANTLR start "entryRuleParamAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:592:1: entryRuleParamAssignment returns [EObject current=null] : iv_ruleParamAssignment= ruleParamAssignment EOF ;
    public final EObject entryRuleParamAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:593:2: (iv_ruleParamAssignment= ruleParamAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:594:2: iv_ruleParamAssignment= ruleParamAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment1200);
            iv_ruleParamAssignment=ruleParamAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamAssignment1210); if (state.failed) return current;

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
    // $ANTLR end "entryRuleParamAssignment"


    // $ANTLR start "ruleParamAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:601:1: ruleParamAssignment returns [EObject current=null] : ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( ( ( ruleTypeNotation ) )=> (lv_right_1_0= ruleTypeNotation ) ) ) ;
    public final EObject ruleParamAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_param_0_0=null;
        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:604:28: ( ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( ( ( ruleTypeNotation ) )=> (lv_right_1_0= ruleTypeNotation ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:605:1: ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( ( ( ruleTypeNotation ) )=> (lv_right_1_0= ruleTypeNotation ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:605:1: ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( ( ( ruleTypeNotation ) )=> (lv_right_1_0= ruleTypeNotation ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:605:2: ( (lv_param_0_0= RULE_PARAMETER ) ) ( ( ( ruleTypeNotation ) )=> (lv_right_1_0= ruleTypeNotation ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:605:2: ( (lv_param_0_0= RULE_PARAMETER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:606:1: (lv_param_0_0= RULE_PARAMETER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:606:1: (lv_param_0_0= RULE_PARAMETER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:607:3: lv_param_0_0= RULE_PARAMETER
            {
            lv_param_0_0=(Token)match(input,RULE_PARAMETER,FOLLOW_RULE_PARAMETER_in_ruleParamAssignment1252); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_param_0_0, grammarAccess.getParamAssignmentAccess().getParamPARAMETERTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getParamAssignmentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"param",
                      		lv_param_0_0, 
                      		"PARAMETER");
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:623:2: ( ( ( ruleTypeNotation ) )=> (lv_right_1_0= ruleTypeNotation ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:623:3: ( ( ruleTypeNotation ) )=> (lv_right_1_0= ruleTypeNotation )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:628:1: (lv_right_1_0= ruleTypeNotation )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:629:3: lv_right_1_0= ruleTypeNotation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAssignmentAccess().getRightTypeNotationParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_ruleParamAssignment1288);
            lv_right_1_0=ruleTypeNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParamAssignmentRule());
              	        }
                     		set(
                     			current, 
                     			"right",
                      		lv_right_1_0, 
                      		"TypeNotation");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleParamAssignment"


    // $ANTLR start "entryRuleTypeNotation"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:653:1: entryRuleTypeNotation returns [EObject current=null] : iv_ruleTypeNotation= ruleTypeNotation EOF ;
    public final EObject entryRuleTypeNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNotation = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:654:2: (iv_ruleTypeNotation= ruleTypeNotation EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:655:2: iv_ruleTypeNotation= ruleTypeNotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNotationRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation1324);
            iv_ruleTypeNotation=ruleTypeNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNotation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotation1334); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeNotation"


    // $ANTLR start "ruleTypeNotation"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:662:1: ruleTypeNotation returns [EObject current=null] : (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) ;
    public final EObject ruleTypeNotation() throws RecognitionException {
        EObject current = null;

        EObject this_TypeReference_0 = null;

        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:665:28: ( (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:666:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:666:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_MODULE_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==30) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:667:5: this_TypeReference_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeNotationAccess().getTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeNotation1381);
                    this_TypeReference_0=ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:676:6: ( (lv_value_1_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:676:6: ( (lv_value_1_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:677:1: (lv_value_1_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:677:1: (lv_value_1_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:678:3: lv_value_1_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNotationAccess().getValueMacroValueParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleTypeNotation1407);
                    lv_value_1_0=ruleMacroValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeNotationRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_1_0, 
                              		"MacroValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleTypeNotation"


    // $ANTLR start "entryRuleTypeReferenceExt"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:702:1: entryRuleTypeReferenceExt returns [EObject current=null] : iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF ;
    public final EObject entryRuleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReferenceExt = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:703:2: (iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:704:2: iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceExtRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt1443);
            iv_ruleTypeReferenceExt=ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReferenceExt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReferenceExt1453); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeReferenceExt"


    // $ANTLR start "ruleTypeReferenceExt"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:711:1: ruleTypeReferenceExt returns [EObject current=null] : (this_TypeReference_0= ruleTypeReference ( ( ( ruleTypeReference ) )=> (lv_right_1_0= ruleTypeReference ) )? ) ;
    public final EObject ruleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject this_TypeReference_0 = null;

        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:714:28: ( (this_TypeReference_0= ruleTypeReference ( ( ( ruleTypeReference ) )=> (lv_right_1_0= ruleTypeReference ) )? ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:715:1: (this_TypeReference_0= ruleTypeReference ( ( ( ruleTypeReference ) )=> (lv_right_1_0= ruleTypeReference ) )? )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:715:1: (this_TypeReference_0= ruleTypeReference ( ( ( ruleTypeReference ) )=> (lv_right_1_0= ruleTypeReference ) )? )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:716:5: this_TypeReference_0= ruleTypeReference ( ( ( ruleTypeReference ) )=> (lv_right_1_0= ruleTypeReference ) )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getTypeReferenceParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1500);
            this_TypeReference_0=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeReference_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:724:1: ( ( ( ruleTypeReference ) )=> (lv_right_1_0= ruleTypeReference ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_MODULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==EOF) && (synpred2_InternalSmi())) {
                    alt9=1;
                }
                else if ( (LA9_1==29) && (synpred2_InternalSmi())) {
                    alt9=1;
                }
                else if ( (LA9_1==22) && (synpred2_InternalSmi())) {
                    alt9=1;
                }
                else if ( (LA9_1==RULE_ASN1_ID) && (synpred2_InternalSmi())) {
                    alt9=1;
                }
                else if ( (LA9_1==RULE_MODULE_ID) && (synpred2_InternalSmi())) {
                    alt9=1;
                }
            }
            switch (alt9) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:724:2: ( ( ruleTypeReference ) )=> (lv_right_1_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:729:1: (lv_right_1_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:730:3: lv_right_1_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getRightTypeReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1530);
                    lv_right_1_0=ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeReferenceExtRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_1_0, 
                              		"TypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleTypeReferenceExt"


    // $ANTLR start "entryRuleTypeReference"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:754:1: entryRuleTypeReference returns [EObject current=null] : iv_ruleTypeReference= ruleTypeReference EOF ;
    public final EObject entryRuleTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReference = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:755:2: (iv_ruleTypeReference= ruleTypeReference EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:756:2: iv_ruleTypeReference= ruleTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_entryRuleTypeReference1567);
            iv_ruleTypeReference=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReference1577); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeReference"


    // $ANTLR start "ruleTypeReference"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:763:1: ruleTypeReference returns [EObject current=null] : ( (otherlv_0= RULE_MODULE_ID ) ) ;
    public final EObject ruleTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:766:28: ( ( (otherlv_0= RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:767:1: ( (otherlv_0= RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:767:1: ( (otherlv_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:768:1: (otherlv_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:768:1: (otherlv_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:769:3: otherlv_0= RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeReferenceRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleTypeReference1621); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getTypeReferenceAccess().getTypeTypeDefinitionCrossReference_0()); 
              	
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleTypeReference"


    // $ANTLR start "entryRuleScope"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:788:1: entryRuleScope returns [EObject current=null] : iv_ruleScope= ruleScope EOF ;
    public final EObject entryRuleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScope = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:789:2: (iv_ruleScope= ruleScope EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:790:2: iv_ruleScope= ruleScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScopeRule()); 
            }
            pushFollow(FOLLOW_ruleScope_in_entryRuleScope1656);
            iv_ruleScope=ruleScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScope1666); if (state.failed) return current;

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
    // $ANTLR end "entryRuleScope"


    // $ANTLR start "ruleScope"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:797:1: ruleScope returns [EObject current=null] : ( (lv_scope_0_0= ruleValue ) ) ;
    public final EObject ruleScope() throws RecognitionException {
        EObject current = null;

        EObject lv_scope_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:800:28: ( ( (lv_scope_0_0= ruleValue ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:801:1: ( (lv_scope_0_0= ruleValue ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:801:1: ( (lv_scope_0_0= ruleValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:802:1: (lv_scope_0_0= ruleValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:802:1: (lv_scope_0_0= ruleValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:803:3: lv_scope_0_0= ruleValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getScopeAccess().getScopeValueParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValue_in_ruleScope1711);
            lv_scope_0_0=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getScopeRule());
              	        }
                     		set(
                     			current, 
                     			"scope",
                      		lv_scope_0_0, 
                      		"Value");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleScope"


    // $ANTLR start "entryRuleValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:827:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:828:2: (iv_ruleValue= ruleValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:829:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue1746);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue1756); if (state.failed) return current;

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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:836:1: ruleValue returns [EObject current=null] : ( ( (lv_valueTypes_0_0= ruleValueType ) ) (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )* ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_valueTypes_0_0 = null;

        EObject lv_valueTypes_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:839:28: ( ( ( (lv_valueTypes_0_0= ruleValueType ) ) (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:840:1: ( ( (lv_valueTypes_0_0= ruleValueType ) ) (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:840:1: ( ( (lv_valueTypes_0_0= ruleValueType ) ) (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:840:2: ( (lv_valueTypes_0_0= ruleValueType ) ) (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:840:2: ( (lv_valueTypes_0_0= ruleValueType ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:841:1: (lv_valueTypes_0_0= ruleValueType )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:841:1: (lv_valueTypes_0_0= ruleValueType )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:842:3: lv_valueTypes_0_0= ruleValueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValueType_in_ruleValue1802);
            lv_valueTypes_0_0=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueRule());
              	        }
                     		add(
                     			current, 
                     			"valueTypes",
                      		lv_valueTypes_0_0, 
                      		"ValueType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:858:2: (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==29) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:858:4: otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) )
            	    {
            	    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleValue1815); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getValueAccess().getVerticalLineKeyword_1_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:862:1: ( (lv_valueTypes_2_0= ruleValueType ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:863:1: (lv_valueTypes_2_0= ruleValueType )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:863:1: (lv_valueTypes_2_0= ruleValueType )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:864:3: lv_valueTypes_2_0= ruleValueType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValueType_in_ruleValue1836);
            	    lv_valueTypes_2_0=ruleValueType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getValueRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"valueTypes",
            	              		lv_valueTypes_2_0, 
            	              		"ValueType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleValueType"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:888:1: entryRuleValueType returns [EObject current=null] : iv_ruleValueType= ruleValueType EOF ;
    public final EObject entryRuleValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:889:2: (iv_ruleValueType= ruleValueType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:890:2: iv_ruleValueType= ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType1874);
            iv_ruleValueType=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType1884); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:897:1: ruleValueType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_IA5STRING ) )? ( ( (lv_param_1_0= ruleParamAssignment ) ) | ( (lv_type_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( (lv_oi_5_0= 'OBJECT IDENTIFIER' ) ) ) ) ;
    public final EObject ruleValueType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_oi_5_0=null;
        EObject lv_param_1_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_simpleType_3_0 = null;

        EObject lv_macroValue_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:900:28: ( ( ( (lv_name_0_0= RULE_IA5STRING ) )? ( ( (lv_param_1_0= ruleParamAssignment ) ) | ( (lv_type_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( (lv_oi_5_0= 'OBJECT IDENTIFIER' ) ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:901:1: ( ( (lv_name_0_0= RULE_IA5STRING ) )? ( ( (lv_param_1_0= ruleParamAssignment ) ) | ( (lv_type_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( (lv_oi_5_0= 'OBJECT IDENTIFIER' ) ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:901:1: ( ( (lv_name_0_0= RULE_IA5STRING ) )? ( ( (lv_param_1_0= ruleParamAssignment ) ) | ( (lv_type_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( (lv_oi_5_0= 'OBJECT IDENTIFIER' ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:901:2: ( (lv_name_0_0= RULE_IA5STRING ) )? ( ( (lv_param_1_0= ruleParamAssignment ) ) | ( (lv_type_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( (lv_oi_5_0= 'OBJECT IDENTIFIER' ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:901:2: ( (lv_name_0_0= RULE_IA5STRING ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_IA5STRING) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==RULE_MODULE_ID) ) {
                    int LA11_3 = input.LA(3);

                    if ( (LA11_3==EOF||(LA11_3>=RULE_MODULE_ID && LA11_3<=RULE_ASN1_ID)||LA11_3==22||LA11_3==29) ) {
                        alt11=1;
                    }
                }
                else if ( ((LA11_1>=RULE_PARAMETER && LA11_1<=RULE_IA5STRING)||LA11_1==23||LA11_1==30||(LA11_1>=35 && LA11_1<=37)||LA11_1==40) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:902:1: (lv_name_0_0= RULE_IA5STRING )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:902:1: (lv_name_0_0= RULE_IA5STRING )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:903:3: lv_name_0_0= RULE_IA5STRING
                    {
                    lv_name_0_0=(Token)match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_ruleValueType1926); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_0, grammarAccess.getValueTypeAccess().getNameIA5STRINGTerminalRuleCall_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

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


                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:919:3: ( ( (lv_param_1_0= ruleParamAssignment ) ) | ( (lv_type_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( (lv_oi_5_0= 'OBJECT IDENTIFIER' ) ) )
            int alt12=5;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt12=1;
                }
                break;
            case RULE_MODULE_ID:
                {
                alt12=2;
                }
                break;
            case RULE_IA5STRING:
            case 35:
            case 36:
            case 37:
            case 40:
                {
                alt12=3;
                }
                break;
            case 30:
                {
                alt12=4;
                }
                break;
            case 23:
                {
                alt12=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:919:4: ( (lv_param_1_0= ruleParamAssignment ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:919:4: ( (lv_param_1_0= ruleParamAssignment ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:920:1: (lv_param_1_0= ruleParamAssignment )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:920:1: (lv_param_1_0= ruleParamAssignment )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:921:3: lv_param_1_0= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleValueType1954);
                    lv_param_1_0=ruleParamAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_1_0, 
                              		"ParamAssignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:938:6: ( (lv_type_2_0= ruleTypeReferenceExt ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:938:6: ( (lv_type_2_0= ruleTypeReferenceExt ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:939:1: (lv_type_2_0= ruleTypeReferenceExt )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:939:1: (lv_type_2_0= ruleTypeReferenceExt )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:940:3: lv_type_2_0= ruleTypeReferenceExt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getTypeTypeReferenceExtParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReferenceExt_in_ruleValueType1981);
                    lv_type_2_0=ruleTypeReferenceExt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_2_0, 
                              		"TypeReferenceExt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:957:6: ( (lv_simpleType_3_0= ruleASN1_TYPE ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:957:6: ( (lv_simpleType_3_0= ruleASN1_TYPE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:958:1: (lv_simpleType_3_0= ruleASN1_TYPE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:958:1: (lv_simpleType_3_0= ruleASN1_TYPE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:959:3: lv_simpleType_3_0= ruleASN1_TYPE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_TYPE_in_ruleValueType2008);
                    lv_simpleType_3_0=ruleASN1_TYPE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"simpleType",
                              		lv_simpleType_3_0, 
                              		"ASN1_TYPE");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:976:6: ( (lv_macroValue_4_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:976:6: ( (lv_macroValue_4_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:977:1: (lv_macroValue_4_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:977:1: (lv_macroValue_4_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:978:3: lv_macroValue_4_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleValueType2035);
                    lv_macroValue_4_0=ruleMacroValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"macroValue",
                              		lv_macroValue_4_0, 
                              		"MacroValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:995:6: ( (lv_oi_5_0= 'OBJECT IDENTIFIER' ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:995:6: ( (lv_oi_5_0= 'OBJECT IDENTIFIER' ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:996:1: (lv_oi_5_0= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:996:1: (lv_oi_5_0= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:997:3: lv_oi_5_0= 'OBJECT IDENTIFIER'
                    {
                    lv_oi_5_0=(Token)match(input,23,FOLLOW_23_in_ruleValueType2059); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_oi_5_0, grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_1_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                      	        }
                             		setWithLastConsumed(current, "oi", lv_oi_5_0, "OBJECT IDENTIFIER");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleValueType"


    // $ANTLR start "entryRuleMacroValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1018:1: entryRuleMacroValue returns [EObject current=null] : iv_ruleMacroValue= ruleMacroValue EOF ;
    public final EObject entryRuleMacroValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacroValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1019:2: (iv_ruleMacroValue= ruleMacroValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1020:2: iv_ruleMacroValue= ruleMacroValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroValueRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue2109);
            iv_ruleMacroValue=ruleMacroValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacroValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue2119); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1027:1: ruleMacroValue returns [EObject current=null] : ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' ) ;
    public final EObject ruleMacroValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1030:28: ( ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1031:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1031:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1031:2: () otherlv_1= 'value' otherlv_2= '(' ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1031:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1032:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getMacroValueAccess().getMacroValueAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleMacroValue2165); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMacroValueAccess().getValueKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleMacroValue2177); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMacroValueAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1045:1: ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1046:1: (lv_type_3_0= ruleMACRO_VALUE_TYPE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1046:1: (lv_type_3_0= ruleMACRO_VALUE_TYPE )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1047:3: lv_type_3_0= ruleMACRO_VALUE_TYPE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroValueAccess().getTypeMACRO_VALUE_TYPEParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_ruleMacroValue2198);
            lv_type_3_0=ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMacroValueRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_3_0, 
                      		"MACRO_VALUE_TYPE");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleMacroValue2210); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getMacroValueAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleMacroValue"


    // $ANTLR start "entryRuleMACRO_VALUE_TYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1075:1: entryRuleMACRO_VALUE_TYPE returns [EObject current=null] : iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF ;
    public final EObject entryRuleMACRO_VALUE_TYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMACRO_VALUE_TYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1076:2: (iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1077:2: iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE2246);
            iv_ruleMACRO_VALUE_TYPE=ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMACRO_VALUE_TYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE2256); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMACRO_VALUE_TYPE"


    // $ANTLR start "ruleMACRO_VALUE_TYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1084:1: ruleMACRO_VALUE_TYPE returns [EObject current=null] : ( ( (lv_valLiteral_0_0= ruleMACRO_VALUE_CAP ) ) | ( (lv_update_1_0= ruleUpdateType ) ) ) ;
    public final EObject ruleMACRO_VALUE_TYPE() throws RecognitionException {
        EObject current = null;

        EObject lv_valLiteral_0_0 = null;

        EObject lv_update_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1087:28: ( ( ( (lv_valLiteral_0_0= ruleMACRO_VALUE_CAP ) ) | ( (lv_update_1_0= ruleUpdateType ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1088:1: ( ( (lv_valLiteral_0_0= ruleMACRO_VALUE_CAP ) ) | ( (lv_update_1_0= ruleUpdateType ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1088:1: ( ( (lv_valLiteral_0_0= ruleMACRO_VALUE_CAP ) ) | ( (lv_update_1_0= ruleUpdateType ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==34) ) {
                alt13=1;
            }
            else if ( (LA13_0==33) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1088:2: ( (lv_valLiteral_0_0= ruleMACRO_VALUE_CAP ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1088:2: ( (lv_valLiteral_0_0= ruleMACRO_VALUE_CAP ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1089:1: (lv_valLiteral_0_0= ruleMACRO_VALUE_CAP )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1089:1: (lv_valLiteral_0_0= ruleMACRO_VALUE_CAP )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1090:3: lv_valLiteral_0_0= ruleMACRO_VALUE_CAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMACRO_VALUE_TYPEAccess().getValLiteralMACRO_VALUE_CAPParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_ruleMACRO_VALUE_TYPE2302);
                    lv_valLiteral_0_0=ruleMACRO_VALUE_CAP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMACRO_VALUE_TYPERule());
                      	        }
                             		set(
                             			current, 
                             			"valLiteral",
                              		lv_valLiteral_0_0, 
                              		"MACRO_VALUE_CAP");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1107:6: ( (lv_update_1_0= ruleUpdateType ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1107:6: ( (lv_update_1_0= ruleUpdateType ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1108:1: (lv_update_1_0= ruleUpdateType )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1108:1: (lv_update_1_0= ruleUpdateType )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1109:3: lv_update_1_0= ruleUpdateType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateUpdateTypeParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUpdateType_in_ruleMACRO_VALUE_TYPE2329);
                    lv_update_1_0=ruleUpdateType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMACRO_VALUE_TYPERule());
                      	        }
                             		set(
                             			current, 
                             			"update",
                              		lv_update_1_0, 
                              		"UpdateType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleMACRO_VALUE_TYPE"


    // $ANTLR start "entryRuleUpdateType"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1133:1: entryRuleUpdateType returns [EObject current=null] : iv_ruleUpdateType= ruleUpdateType EOF ;
    public final EObject entryRuleUpdateType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdateType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1134:2: (iv_ruleUpdateType= ruleUpdateType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1135:2: iv_ruleUpdateType= ruleUpdateType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUpdateTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_entryRuleUpdateType2365);
            iv_ruleUpdateType=ruleUpdateType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUpdateType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpdateType2375); if (state.failed) return current;

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
    // $ANTLR end "entryRuleUpdateType"


    // $ANTLR start "ruleUpdateType"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1142:1: ruleUpdateType returns [EObject current=null] : (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) ) ;
    public final EObject ruleUpdateType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1145:28: ( (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1146:1: (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1146:1: (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1146:3: otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleUpdateType2412); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getUpdateTypeAccess().getUpdateKeyword_0());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1150:1: ( (otherlv_1= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1151:1: (otherlv_1= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1151:1: (otherlv_1= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1152:3: otherlv_1= RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getUpdateTypeRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleUpdateType2432); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getUpdateTypeAccess().getTypeTypeDefinitionCrossReference_1_0()); 
              	
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleUpdateType"


    // $ANTLR start "entryRuleMACRO_VALUE_CAP"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1171:1: entryRuleMACRO_VALUE_CAP returns [EObject current=null] : iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF ;
    public final EObject entryRuleMACRO_VALUE_CAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMACRO_VALUE_CAP = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1172:2: (iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1173:2: iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP2468);
            iv_ruleMACRO_VALUE_CAP=ruleMACRO_VALUE_CAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMACRO_VALUE_CAP; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP2478); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMACRO_VALUE_CAP"


    // $ANTLR start "ruleMACRO_VALUE_CAP"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1180:1: ruleMACRO_VALUE_CAP returns [EObject current=null] : ( ( (lv_value_0_0= 'VALUE' ) ) ( (lv_literal_1_0= ruleVALUE_CAP_LITERALS ) ) ) ;
    public final EObject ruleMACRO_VALUE_CAP() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Enumerator lv_literal_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1183:28: ( ( ( (lv_value_0_0= 'VALUE' ) ) ( (lv_literal_1_0= ruleVALUE_CAP_LITERALS ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1184:1: ( ( (lv_value_0_0= 'VALUE' ) ) ( (lv_literal_1_0= ruleVALUE_CAP_LITERALS ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1184:1: ( ( (lv_value_0_0= 'VALUE' ) ) ( (lv_literal_1_0= ruleVALUE_CAP_LITERALS ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1184:2: ( (lv_value_0_0= 'VALUE' ) ) ( (lv_literal_1_0= ruleVALUE_CAP_LITERALS ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1184:2: ( (lv_value_0_0= 'VALUE' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1185:1: (lv_value_0_0= 'VALUE' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1185:1: (lv_value_0_0= 'VALUE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1186:3: lv_value_0_0= 'VALUE'
            {
            lv_value_0_0=(Token)match(input,34,FOLLOW_34_in_ruleMACRO_VALUE_CAP2521); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_value_0_0, grammarAccess.getMACRO_VALUE_CAPAccess().getValueVALUEKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMACRO_VALUE_CAPRule());
              	        }
                     		setWithLastConsumed(current, "value", lv_value_0_0, "VALUE");
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1199:2: ( (lv_literal_1_0= ruleVALUE_CAP_LITERALS ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1200:1: (lv_literal_1_0= ruleVALUE_CAP_LITERALS )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1200:1: (lv_literal_1_0= ruleVALUE_CAP_LITERALS )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1201:3: lv_literal_1_0= ruleVALUE_CAP_LITERALS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMACRO_VALUE_CAPAccess().getLiteralVALUE_CAP_LITERALSEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVALUE_CAP_LITERALS_in_ruleMACRO_VALUE_CAP2555);
            lv_literal_1_0=ruleVALUE_CAP_LITERALS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMACRO_VALUE_CAPRule());
              	        }
                     		set(
                     			current, 
                     			"literal",
                      		lv_literal_1_0, 
                      		"VALUE_CAP_LITERALS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleMACRO_VALUE_CAP"


    // $ANTLR start "entryRuleASN1_TYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1225:1: entryRuleASN1_TYPE returns [EObject current=null] : iv_ruleASN1_TYPE= ruleASN1_TYPE EOF ;
    public final EObject entryRuleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_TYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1226:2: (iv_ruleASN1_TYPE= ruleASN1_TYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1227:2: iv_ruleASN1_TYPE= ruleASN1_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE2591);
            iv_ruleASN1_TYPE=ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_TYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE2601); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1234:1: ruleASN1_TYPE returns [EObject current=null] : (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE ) ;
    public final EObject ruleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject this_ASN1_SIMPLE_0 = null;

        EObject this_ASN1_CHOICE_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1237:28: ( (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1238:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1238:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_IA5STRING||(LA14_0>=35 && LA14_0<=37)) ) {
                alt14=1;
            }
            else if ( (LA14_0==40) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1239:5: this_ASN1_SIMPLE_0= ruleASN1_SIMPLE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE2648);
                    this_ASN1_SIMPLE_0=ruleASN1_SIMPLE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_SIMPLE_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1249:5: this_ASN1_CHOICE_1= ruleASN1_CHOICE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE2675);
                    this_ASN1_CHOICE_1=ruleASN1_CHOICE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_CHOICE_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleASN1_TYPE"


    // $ANTLR start "entryRuleASN1_SIMPLE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1265:1: entryRuleASN1_SIMPLE returns [EObject current=null] : iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF ;
    public final EObject entryRuleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SIMPLE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1266:2: (iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1267:2: iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SIMPLERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE2710);
            iv_ruleASN1_SIMPLE=ruleASN1_SIMPLE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SIMPLE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE2720); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1274:1: ruleASN1_SIMPLE returns [EObject current=null] : ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) ) ;
    public final EObject ruleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_IA5STRING_3=null;
        EObject this_ASN1_OCTET_STRING_4 = null;

        EObject lv_constraint_5_0 = null;

        EObject this_ASN1_INTEGER_6 = null;

        EObject lv_constraint_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1277:28: ( ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1278:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1278:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt17=1;
                }
                break;
            case RULE_IA5STRING:
                {
                alt17=2;
                }
                break;
            case 36:
                {
                alt17=3;
                }
                break;
            case 37:
                {
                alt17=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1278:2: ( () otherlv_1= 'empty' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1278:2: ( () otherlv_1= 'empty' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1278:3: () otherlv_1= 'empty'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1278:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1279:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleASN1_SIMPLE2767); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1289:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1289:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1289:7: () this_IA5STRING_3= RULE_IA5STRING
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1289:7: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1290:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_1_0(),
                                  current);
                          
                    }

                    }

                    this_IA5STRING_3=(Token)match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE2795); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_IA5STRING_3, grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1300:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1300:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1301:5: this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE2824);
                    this_ASN1_OCTET_STRING_4=ruleASN1_OCTET_STRING();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_OCTET_STRING_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1309:1: ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==31) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1310:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1310:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1311:3: lv_constraint_5_0= ruleASN1_SUBTYPE
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE2844);
                            lv_constraint_5_0=ruleASN1_SUBTYPE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

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


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1328:6: (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1328:6: (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1329:5: this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE2875);
                    this_ASN1_INTEGER_6=ruleASN1_INTEGER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_INTEGER_6; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1337:1: ( (lv_constraint_7_0= ruleASN1_RANGE ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_INT) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1338:1: (lv_constraint_7_0= ruleASN1_RANGE )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1338:1: (lv_constraint_7_0= ruleASN1_RANGE )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1339:3: lv_constraint_7_0= ruleASN1_RANGE
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_RANGEParserRuleCall_3_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SIMPLE2895);
                            lv_constraint_7_0=ruleASN1_RANGE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getASN1_SIMPLERule());
                              	        }
                                     		set(
                                     			current, 
                                     			"constraint",
                                      		lv_constraint_7_0, 
                                      		"ASN1_RANGE");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleASN1_SIMPLE"


    // $ANTLR start "entryRuleASN1_OCTET_STRING"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1363:1: entryRuleASN1_OCTET_STRING returns [EObject current=null] : iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF ;
    public final EObject entryRuleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_OCTET_STRING = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1364:2: (iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1365:2: iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING2933);
            iv_ruleASN1_OCTET_STRING=ruleASN1_OCTET_STRING();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_OCTET_STRING; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING2943); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1372:1: ruleASN1_OCTET_STRING returns [EObject current=null] : ( () otherlv_1= 'OCTET STRING' ) ;
    public final EObject ruleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1375:28: ( ( () otherlv_1= 'OCTET STRING' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1376:1: ( () otherlv_1= 'OCTET STRING' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1376:1: ( () otherlv_1= 'OCTET STRING' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1376:2: () otherlv_1= 'OCTET STRING'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1376:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1377:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleASN1_OCTET_STRING2989); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_OCTET_STRINGAccess().getOCTETSTRINGKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleASN1_OCTET_STRING"


    // $ANTLR start "entryRuleASN1_INTEGER"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1394:1: entryRuleASN1_INTEGER returns [EObject current=null] : iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF ;
    public final EObject entryRuleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_INTEGER = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1395:2: (iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1396:2: iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_INTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER3025);
            iv_ruleASN1_INTEGER=ruleASN1_INTEGER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_INTEGER; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER3035); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1403:1: ruleASN1_INTEGER returns [EObject current=null] : (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' ) ;
    public final EObject ruleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_valuePairs_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1406:28: ( (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1407:1: (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1407:1: (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1407:3: otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleASN1_INTEGER3072); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_INTEGERAccess().getINTEGERKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleASN1_INTEGER3084); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_INTEGERAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1415:1: ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID||LA18_0==31) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1416:1: (lv_valuePairs_2_0= ruleASN1_VALUEPAIR )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1416:1: (lv_valuePairs_2_0= ruleASN1_VALUEPAIR )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1417:3: lv_valuePairs_2_0= ruleASN1_VALUEPAIR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_INTEGERAccess().getValuePairsASN1_VALUEPAIRParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_ruleASN1_INTEGER3105);
            	    lv_valuePairs_2_0=ruleASN1_VALUEPAIR();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);

            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleASN1_INTEGER3118); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getASN1_INTEGERAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleASN1_INTEGER"


    // $ANTLR start "entryRuleASN1_SUBTYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1445:1: entryRuleASN1_SUBTYPE returns [EObject current=null] : iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF ;
    public final EObject entryRuleASN1_SUBTYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SUBTYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1446:2: (iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1447:2: iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SUBTYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE3154);
            iv_ruleASN1_SUBTYPE=ruleASN1_SUBTYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SUBTYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE3164); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1454:1: ruleASN1_SUBTYPE returns [EObject current=null] : (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) ;
    public final EObject ruleASN1_SUBTYPE() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_ranges_3_0 = null;

        EObject lv_ranges_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1457:28: ( (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1458:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1458:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1458:3: otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleASN1_SUBTYPE3201); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleASN1_SUBTYPE3213); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleASN1_SUBTYPE3225); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1470:1: ( (lv_ranges_3_0= ruleASN1_RANGE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1471:1: (lv_ranges_3_0= ruleASN1_RANGE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1471:1: (lv_ranges_3_0= ruleASN1_RANGE )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1472:3: lv_ranges_3_0= ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3246);
            lv_ranges_3_0=ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getASN1_SUBTYPERule());
              	        }
                     		add(
                     			current, 
                     			"ranges",
                      		lv_ranges_3_0, 
                      		"ASN1_RANGE");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1488:2: (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1488:4: otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    {
            	    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleASN1_SUBTYPE3259); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getASN1_SUBTYPEAccess().getVerticalLineKeyword_4_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1492:1: ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1493:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1493:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1494:3: lv_ranges_5_0= ruleASN1_RANGE
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3280);
            	    lv_ranges_5_0=ruleASN1_RANGE();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getASN1_SUBTYPERule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ranges",
            	              		lv_ranges_5_0, 
            	              		"ASN1_RANGE");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleASN1_SUBTYPE3294); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,32,FOLLOW_32_in_ruleASN1_SUBTYPE3306); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleASN1_SUBTYPE"


    // $ANTLR start "entryRuleASN1_RANGE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1526:1: entryRuleASN1_RANGE returns [EObject current=null] : iv_ruleASN1_RANGE= ruleASN1_RANGE EOF ;
    public final EObject entryRuleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_RANGE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1527:2: (iv_ruleASN1_RANGE= ruleASN1_RANGE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1528:2: iv_ruleASN1_RANGE= ruleASN1_RANGE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_RANGERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE3342);
            iv_ruleASN1_RANGE=ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_RANGE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE3352); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1535:1: ruleASN1_RANGE returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) ) ;
    public final EObject ruleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_start_2_0=null;
        Token otherlv_3=null;
        Token lv_end_4_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1538:28: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1539:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1539:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==EOF||(LA20_1>=RULE_MODULE_ID && LA20_1<=RULE_ASN1_ID)||LA20_1==22||LA20_1==29||LA20_1==32) ) {
                    alt20=1;
                }
                else if ( (LA20_1==39) ) {
                    alt20=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1539:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1539:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1539:3: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1539:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1540:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1545:2: ( (lv_value_1_0= RULE_INT ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1546:1: (lv_value_1_0= RULE_INT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1546:1: (lv_value_1_0= RULE_INT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1547:3: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_RANGE3404); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_1_0, grammarAccess.getASN1_RANGEAccess().getValueINTTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getASN1_RANGERule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_1_0, 
                              		"INT");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1564:6: ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1564:6: ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1564:7: ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1564:7: ( (lv_start_2_0= RULE_INT ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1565:1: (lv_start_2_0= RULE_INT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1565:1: (lv_start_2_0= RULE_INT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1566:3: lv_start_2_0= RULE_INT
                    {
                    lv_start_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_RANGE3434); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_start_2_0, grammarAccess.getASN1_RANGEAccess().getStartINTTerminalRuleCall_1_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

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


                    }

                    otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleASN1_RANGE3451); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_1_1());
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1586:1: ( (lv_end_4_0= RULE_INT ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1587:1: (lv_end_4_0= RULE_INT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1587:1: (lv_end_4_0= RULE_INT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1588:3: lv_end_4_0= RULE_INT
                    {
                    lv_end_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_RANGE3468); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_end_4_0, grammarAccess.getASN1_RANGEAccess().getEndINTTerminalRuleCall_1_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

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


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleASN1_RANGE"


    // $ANTLR start "entryRuleASN1_VALUEPAIR"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1612:1: entryRuleASN1_VALUEPAIR returns [String current=null] : iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF ;
    public final String entryRuleASN1_VALUEPAIR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleASN1_VALUEPAIR = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1613:2: (iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1614:2: iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_VALUEPAIRRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR3511);
            iv_ruleASN1_VALUEPAIR=ruleASN1_VALUEPAIR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_VALUEPAIR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR3522); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1621:1: ruleASN1_VALUEPAIR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleASN1_VALUEPAIR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1624:28: ( ( (this_ID_0= RULE_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1625:1: ( (this_ID_0= RULE_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1625:1: ( (this_ID_0= RULE_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1625:2: (this_ID_0= RULE_ID )? kw= '(' this_INT_2= RULE_INT kw= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1625:2: (this_ID_0= RULE_ID )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1625:7: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleASN1_VALUEPAIR3563); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getASN1_VALUEPAIRAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;

            }

            kw=(Token)match(input,31,FOLLOW_31_in_ruleASN1_VALUEPAIR3583); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getASN1_VALUEPAIRAccess().getLeftParenthesisKeyword_1()); 
                  
            }
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_VALUEPAIR3598); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_2, grammarAccess.getASN1_VALUEPAIRAccess().getINTTerminalRuleCall_2()); 
                  
            }
            kw=(Token)match(input,32,FOLLOW_32_in_ruleASN1_VALUEPAIR3616); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getASN1_VALUEPAIRAccess().getRightParenthesisKeyword_3()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleASN1_VALUEPAIR"


    // $ANTLR start "entryRuleASN1_CHOICE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1659:1: entryRuleASN1_CHOICE returns [EObject current=null] : iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF ;
    public final EObject entryRuleASN1_CHOICE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1660:2: (iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1661:2: iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE3656);
            iv_ruleASN1_CHOICE=ruleASN1_CHOICE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE3666); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1668:1: ruleASN1_CHOICE returns [EObject current=null] : (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1671:28: ( (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1672:1: (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1672:1: (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1672:3: otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleASN1_CHOICE3703); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleASN1_CHOICE3715); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1680:1: ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1681:1: (lv_choices_2_0= ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1681:1: (lv_choices_2_0= ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1682:3: lv_choices_2_0= ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3736);
            lv_choices_2_0=ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

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


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1698:2: (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==41) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1698:4: otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) )
            	    {
            	    otherlv_3=(Token)match(input,41,FOLLOW_41_in_ruleASN1_CHOICE3749); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1702:1: ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1703:1: (lv_choices_4_0= ruleASN1_CHOICE_ENTRY )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1703:1: (lv_choices_4_0= ruleASN1_CHOICE_ENTRY )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1704:3: lv_choices_4_0= ruleASN1_CHOICE_ENTRY
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3770);
            	    lv_choices_4_0=ruleASN1_CHOICE_ENTRY();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleASN1_CHOICE3784); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getASN1_CHOICEAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleASN1_CHOICE"


    // $ANTLR start "entryRuleASN1_CHOICE_ENTRY"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1732:1: entryRuleASN1_CHOICE_ENTRY returns [EObject current=null] : iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF ;
    public final EObject entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE_ENTRY = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1733:2: (iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1734:2: iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY3820);
            iv_ruleASN1_CHOICE_ENTRY=ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE_ENTRY; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY3830); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1741:1: ruleASN1_CHOICE_ENTRY returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1744:28: ( ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1745:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1745:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1745:2: ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1745:2: ( (lv_id_0_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1746:1: (lv_id_0_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1746:1: (lv_id_0_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1747:3: lv_id_0_0= RULE_ASN1_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY3872); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_id_0_0, grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdASN1_IDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

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


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1763:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1764:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1764:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1765:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getASN1_CHOICE_ENTRYRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleASN1_CHOICE_ENTRY3897); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueTypeCrossReference_1_0()); 
              	
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleASN1_CHOICE_ENTRY"


    // $ANTLR start "ruleVALUE_CAP_LITERALS"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1784:1: ruleVALUE_CAP_LITERALS returns [Enumerator current=null] : ( (enumLiteral_0= 'OBJECT IDENTIFIER' ) | (enumLiteral_1= 'IA5String' ) ) ;
    public final Enumerator ruleVALUE_CAP_LITERALS() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1786:28: ( ( (enumLiteral_0= 'OBJECT IDENTIFIER' ) | (enumLiteral_1= 'IA5String' ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1787:1: ( (enumLiteral_0= 'OBJECT IDENTIFIER' ) | (enumLiteral_1= 'IA5String' ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1787:1: ( (enumLiteral_0= 'OBJECT IDENTIFIER' ) | (enumLiteral_1= 'IA5String' ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==23) ) {
                alt23=1;
            }
            else if ( (LA23_0==42) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1787:2: (enumLiteral_0= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1787:2: (enumLiteral_0= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1787:4: enumLiteral_0= 'OBJECT IDENTIFIER'
                    {
                    enumLiteral_0=(Token)match(input,23,FOLLOW_23_in_ruleVALUE_CAP_LITERALS3947); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVALUE_CAP_LITERALSAccess().getOiLiteralEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getVALUE_CAP_LITERALSAccess().getOiLiteralEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1793:6: (enumLiteral_1= 'IA5String' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1793:6: (enumLiteral_1= 'IA5String' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1793:8: enumLiteral_1= 'IA5String'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_42_in_ruleVALUE_CAP_LITERALS3964); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getVALUE_CAP_LITERALSAccess().getIa5StringLiteralEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getVALUE_CAP_LITERALSAccess().getIa5StringLiteralEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleVALUE_CAP_LITERALS"

    // $ANTLR start synpred2_InternalSmi
    public final void synpred2_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:724:2: ( ( ruleTypeReference ) )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:725:1: ( ruleTypeReference )
        {
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:725:1: ( ruleTypeReference )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:1: ruleTypeReference
        {
        pushFollow(FOLLOW_ruleTypeReference_in_synpred2_InternalSmi1513);
        ruleTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalSmi

    // Delegated rules

    public final boolean synpred2_InternalSmi() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalSmi_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleModule127 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleModule144 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleModule156 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleModule168 = new BitSet(new long[]{0x0000000000400030L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleModule189 = new BitSet(new long[]{0x0000000000400030L});
    public static final BitSet FOLLOW_22_in_ruleModule202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment238 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_ruleAssignment294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleAssignment321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_ruleAssignment348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier384 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifier394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifier436 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleObjectIdentifier453 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleObjectIdentifier465 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleObjectIdentifier477 = new BitSet(new long[]{0x00000000000000E0L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_ruleObjectIdentifier498 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleObjectIdentifier510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifierValue556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjectIdentifierValue602 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue619 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleObjectIdentifierValue637 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleObjectIdentifierValue659 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition701 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDefinition711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeDefinition753 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTypeDefinition770 = new BitSet(new long[]{0x0000013840800310L});
    public static final BitSet FOLLOW_ruleScope_in_ruleTypeDefinition791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_entryRuleMacro827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacro837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleMacro879 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleMacro896 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleMacro908 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleMacro920 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMacro932 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleMacro944 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_ruleMacro965 = new BitSet(new long[]{0x0000000010000110L});
    public static final BitSet FOLLOW_28_in_ruleMacro978 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleMacro990 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleMacro1011 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleMacro1032 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_22_in_ruleMacro1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAssignment1091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleTypeAssignment1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeAssignment1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment1200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamAssignment1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PARAMETER_in_ruleParamAssignment1252 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_ruleParamAssignment1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation1324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotation1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeNotation1381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleTypeNotation1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt1443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReferenceExt1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1500 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_entryRuleTypeReference1567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReference1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeReference1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScope_in_entryRuleScope1656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScope1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleScope1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue1802 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleValue1815 = new BitSet(new long[]{0x0000013840800310L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue1836 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType1874 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType1884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_ruleValueType1926 = new BitSet(new long[]{0x0000013840800310L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleValueType1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_ruleValueType1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_ruleValueType2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleValueType2035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleValueType2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue2109 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue2119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleMacroValue2165 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleMacroValue2177 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_ruleMacroValue2198 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleMacroValue2210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE2246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_ruleMACRO_VALUE_TYPE2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_ruleMACRO_VALUE_TYPE2329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_entryRuleUpdateType2365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpdateType2375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleUpdateType2412 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleUpdateType2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP2468 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleMACRO_VALUE_CAP2521 = new BitSet(new long[]{0x0000040000800000L});
    public static final BitSet FOLLOW_ruleVALUE_CAP_LITERALS_in_ruleMACRO_VALUE_CAP2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE2591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE2648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE2710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE2720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleASN1_SIMPLE2767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE2795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE2824 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE2844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE2875 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SIMPLE2895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING2933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING2943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleASN1_OCTET_STRING2989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER3025 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleASN1_INTEGER3072 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleASN1_INTEGER3084 = new BitSet(new long[]{0x0000000080000040L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_ruleASN1_INTEGER3105 = new BitSet(new long[]{0x0000000082000040L});
    public static final BitSet FOLLOW_25_in_ruleASN1_INTEGER3118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE3154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE3164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleASN1_SUBTYPE3201 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleASN1_SUBTYPE3213 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleASN1_SUBTYPE3225 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3246 = new BitSet(new long[]{0x0000000120000000L});
    public static final BitSet FOLLOW_29_in_ruleASN1_SUBTYPE3259 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3280 = new BitSet(new long[]{0x0000000120000000L});
    public static final BitSet FOLLOW_32_in_ruleASN1_SUBTYPE3294 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleASN1_SUBTYPE3306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE3342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE3352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_RANGE3404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_RANGE3434 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_RANGE3451 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_RANGE3468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR3511 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR3522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleASN1_VALUEPAIR3563 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleASN1_VALUEPAIR3583 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_VALUEPAIR3598 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleASN1_VALUEPAIR3616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE3656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleASN1_CHOICE3703 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleASN1_CHOICE3715 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3736 = new BitSet(new long[]{0x0000020002000000L});
    public static final BitSet FOLLOW_41_in_ruleASN1_CHOICE3749 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3770 = new BitSet(new long[]{0x0000020002000000L});
    public static final BitSet FOLLOW_25_in_ruleASN1_CHOICE3784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY3820 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY3830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY3872 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleASN1_CHOICE_ENTRY3897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleVALUE_CAP_LITERALS3947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleVALUE_CAP_LITERALS3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_synpred2_InternalSmi1513 = new BitSet(new long[]{0x0000000000000002L});

}