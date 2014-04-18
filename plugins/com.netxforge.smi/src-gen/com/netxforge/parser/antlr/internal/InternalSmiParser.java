package com.netxforge.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_MODULE_ID", "RULE_NEWLINE", "RULE_ASN1_ID", "RULE_BIG_INTEGER", "RULE_PARAMETER", "RULE_IA5STRING", "RULE_ALPHA_CAP", "RULE_ALPHA", "RULE_NUMERIC", "RULE_SL_ASN1_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'DEFINITIONS'", "'::='", "'BEGIN'", "'END'", "'OBJECT IDENTIFIER'", "'{'", "'}'", "'MACRO'", "'TYPE NOTATION'", "'VALUE NOTATION'", "'IMPLICIT'", "'|'", "'[APPLICATION'", "']'", "'value'", "'('", "')'", "'VALUE'", "'IA5String'", "'Update'", "'empty'", "'OCTET STRING'", "'INTEGER'", "'SIZE'", "'..'", "'CHOICE'", "','"
    };
    public static final int T__42=42;
    public static final int T__40=40;
    public static final int RULE_NEWLINE=5;
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
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_ASN1_ID=6;
    public static final int RULE_ALPHA=11;
    public static final int EOF=-1;
    public static final int RULE_MODULE_ID=4;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_BIG_INTEGER=7;
    public static final int T__32=32;
    public static final int RULE_NUMERIC=12;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:67:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:68:2: (iv_ruleModule= ruleModule EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:69:2: iv_ruleModule= ruleModule EOF
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:76:1: ruleModule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_NEWLINE_4= RULE_NEWLINE ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+ this_NEWLINE_8= RULE_NEWLINE otherlv_9= 'END' (this_NEWLINE_10= RULE_NEWLINE )* ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_NEWLINE_4=null;
        Token this_NEWLINE_8=null;
        Token otherlv_9=null;
        Token this_NEWLINE_10=null;
        EObject lv_identifiers_5_0 = null;

        EObject lv_types_6_0 = null;

        EObject lv_macros_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:79:28: ( ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_NEWLINE_4= RULE_NEWLINE ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+ this_NEWLINE_8= RULE_NEWLINE otherlv_9= 'END' (this_NEWLINE_10= RULE_NEWLINE )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:1: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_NEWLINE_4= RULE_NEWLINE ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+ this_NEWLINE_8= RULE_NEWLINE otherlv_9= 'END' (this_NEWLINE_10= RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:1: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_NEWLINE_4= RULE_NEWLINE ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+ this_NEWLINE_8= RULE_NEWLINE otherlv_9= 'END' (this_NEWLINE_10= RULE_NEWLINE )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:2: ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_NEWLINE_4= RULE_NEWLINE ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+ this_NEWLINE_8= RULE_NEWLINE otherlv_9= 'END' (this_NEWLINE_10= RULE_NEWLINE )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:2: ( (lv_name_0_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:81:1: (lv_name_0_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:81:1: (lv_name_0_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:82:3: lv_name_0_0= RULE_MODULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleModule127); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getModuleAccess().getNameMODULE_IDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getModuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"MODULE_ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleModule144); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getModuleAccess().getDEFINITIONSKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleModule156); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleModule168); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getBEGINKeyword_3());
                  
            }
            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleModule179); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:114:1: ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=4;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:114:2: ( (lv_identifiers_5_0= ruleObjectIdentifier ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:114:2: ( (lv_identifiers_5_0= ruleObjectIdentifier ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:115:1: (lv_identifiers_5_0= ruleObjectIdentifier )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:115:1: (lv_identifiers_5_0= ruleObjectIdentifier )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:116:3: lv_identifiers_5_0= ruleObjectIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getIdentifiersObjectIdentifierParserRuleCall_5_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleObjectIdentifier_in_ruleModule200);
            	    lv_identifiers_5_0=ruleObjectIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"identifiers",
            	              		lv_identifiers_5_0, 
            	              		"ObjectIdentifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:133:6: ( (lv_types_6_0= ruleTypeDefinition ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:133:6: ( (lv_types_6_0= ruleTypeDefinition ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:134:1: (lv_types_6_0= ruleTypeDefinition )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:134:1: (lv_types_6_0= ruleTypeDefinition )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:135:3: lv_types_6_0= ruleTypeDefinition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getTypesTypeDefinitionParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleModule227);
            	    lv_types_6_0=ruleTypeDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"types",
            	              		lv_types_6_0, 
            	              		"TypeDefinition");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:152:6: ( (lv_macros_7_0= ruleMacro ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:152:6: ( (lv_macros_7_0= ruleMacro ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:153:1: (lv_macros_7_0= ruleMacro )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:153:1: (lv_macros_7_0= ruleMacro )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:154:3: lv_macros_7_0= ruleMacro
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getMacrosMacroParserRuleCall_5_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMacro_in_ruleModule254);
            	    lv_macros_7_0=ruleMacro();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"macros",
            	              		lv_macros_7_0, 
            	              		"Macro");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            this_NEWLINE_8=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleModule267); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_8, grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_6()); 
                  
            }
            otherlv_9=(Token)match(input,19,FOLLOW_19_in_ruleModule278); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getModuleAccess().getENDKeyword_7());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:178:1: (this_NEWLINE_10= RULE_NEWLINE )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_NEWLINE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:178:2: this_NEWLINE_10= RULE_NEWLINE
            	    {
            	    this_NEWLINE_10=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleModule290); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_10, grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_8()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleObjectIdentifier"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:190:1: entryRuleObjectIdentifier returns [EObject current=null] : iv_ruleObjectIdentifier= ruleObjectIdentifier EOF ;
    public final EObject entryRuleObjectIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectIdentifier = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_ASN1_COMMENT");
        	
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:194:2: (iv_ruleObjectIdentifier= ruleObjectIdentifier EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:195:2: iv_ruleObjectIdentifier= ruleObjectIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier333);
            iv_ruleObjectIdentifier=ruleObjectIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectIdentifier; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifier343); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleObjectIdentifier"


    // $ANTLR start "ruleObjectIdentifier"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:205:1: ruleObjectIdentifier returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' ) ;
    public final EObject ruleObjectIdentifier() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_oidValue_5_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_ASN1_COMMENT");
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:209:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:210:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:210:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:210:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:210:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_NEWLINE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:210:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleObjectIdentifier384); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getObjectIdentifierAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:214:3: ( (lv_name_1_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:215:1: (lv_name_1_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:215:1: (lv_name_1_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:216:3: lv_name_1_0= RULE_ASN1_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifier402); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getObjectIdentifierAccess().getNameASN1_IDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getObjectIdentifierRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ASN1_ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleObjectIdentifier419); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleObjectIdentifier431); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleObjectIdentifier443); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:244:1: ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:245:1: (lv_oidValue_5_0= ruleObjectIdentifierValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:245:1: (lv_oidValue_5_0= ruleObjectIdentifierValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:246:3: lv_oidValue_5_0= ruleObjectIdentifierValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_ruleObjectIdentifier464);
            lv_oidValue_5_0=ruleObjectIdentifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getObjectIdentifierRule());
              	        }
                     		set(
                     			current, 
                     			"oidValue",
                      		lv_oidValue_5_0, 
                      		"ObjectIdentifierValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleObjectIdentifier476); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getObjectIdentifierAccess().getRightCurlyBracketKeyword_6());
                  
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleObjectIdentifier"


    // $ANTLR start "entryRuleObjectIdentifierValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:277:1: entryRuleObjectIdentifierValue returns [EObject current=null] : iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF ;
    public final EObject entryRuleObjectIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectIdentifierValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:278:2: (iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:279:2: iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectIdentifierValueRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue516);
            iv_ruleObjectIdentifierValue=ruleObjectIdentifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectIdentifierValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifierValue526); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:286:1: ruleObjectIdentifierValue returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* ) ;
    public final EObject ruleObjectIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_subIds_2_0=null;
        Token lv_subIds_3_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:289:28: ( ( ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:1: ( ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:1: ( ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:2: ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:2: ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )?
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ASN1_ID) ) {
                int LA4_1 = input.LA(2);

                if ( (true) ) {
                    alt4=1;
                }
                else if ( (synpred1_InternalSmi()) ) {
                    alt4=2;
                }
            }
            switch (alt4) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:3: ( (lv_name_0_0= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:3: ( (lv_name_0_0= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:291:1: (lv_name_0_0= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:291:1: (lv_name_0_0= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:292:3: lv_name_0_0= RULE_ASN1_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_0, grammarAccess.getObjectIdentifierValueAccess().getNameASN1_IDTerminalRuleCall_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"ASN1_ID");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:309:6: ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:309:6: ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:309:7: ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:315:1: (otherlv_1= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:316:3: otherlv_1= RULE_ASN1_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue612); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:327:4: ( (lv_subIds_2_0= RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:328:1: (lv_subIds_2_0= RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:328:1: (lv_subIds_2_0= RULE_BIG_INTEGER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:329:3: lv_subIds_2_0= RULE_BIG_INTEGER
            {
            lv_subIds_2_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleObjectIdentifierValue631); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_subIds_2_0, grammarAccess.getObjectIdentifierValueAccess().getSubIdsBIG_INTEGERTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
              	        }
                     		addWithLastConsumed(
                     			current, 
                     			"subIds",
                      		lv_subIds_2_0, 
                      		"BIG_INTEGER");
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:345:2: ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_BIG_INTEGER) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:346:1: (lv_subIds_3_0= RULE_BIG_INTEGER )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:346:1: (lv_subIds_3_0= RULE_BIG_INTEGER )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:347:3: lv_subIds_3_0= RULE_BIG_INTEGER
            	    {
            	    lv_subIds_3_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleObjectIdentifierValue653); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_subIds_3_0, grammarAccess.getObjectIdentifierValueAccess().getSubIdsBIG_INTEGERTerminalRuleCall_2_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"subIds",
            	              		lv_subIds_3_0, 
            	              		"BIG_INTEGER");
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:371:1: entryRuleTypeDefinition returns [EObject current=null] : iv_ruleTypeDefinition= ruleTypeDefinition EOF ;
    public final EObject entryRuleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinition = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:372:2: (iv_ruleTypeDefinition= ruleTypeDefinition EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:373:2: iv_ruleTypeDefinition= ruleTypeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition695);
            iv_ruleTypeDefinition=ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDefinition705); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:380:1: ruleTypeDefinition returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ ) ;
    public final EObject ruleTypeDefinition() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_values_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:383:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:384:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:384:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:384:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:384:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_NEWLINE) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:384:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTypeDefinition742); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:388:3: ( (lv_name_1_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:389:1: (lv_name_1_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:389:1: (lv_name_1_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:390:3: lv_name_1_0= RULE_MODULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleTypeDefinition760); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getTypeDefinitionAccess().getNameMODULE_IDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeDefinitionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"MODULE_ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleTypeDefinition777); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTypeDefinitionAccess().getColonColonEqualsSignKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:410:1: ( (lv_values_3_0= ruleValue ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_NEWLINE) ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1==RULE_MODULE_ID) ) {
                        int LA7_4 = input.LA(3);

                        if ( (LA7_4==EOF||(LA7_4>=RULE_MODULE_ID && LA7_4<=RULE_NEWLINE)||(LA7_4>=RULE_PARAMETER && LA7_4<=RULE_IA5STRING)||LA7_4==20||(LA7_4>=26 && LA7_4<=28)||LA7_4==30||(LA7_4>=36 && LA7_4<=38)||LA7_4==41) ) {
                            alt7=1;
                        }


                    }
                    else if ( ((LA7_1>=RULE_PARAMETER && LA7_1<=RULE_IA5STRING)||LA7_1==20||LA7_1==26||LA7_1==28||LA7_1==30||(LA7_1>=36 && LA7_1<=38)||LA7_1==41) ) {
                        alt7=1;
                    }


                }
                else if ( (LA7_0==RULE_MODULE_ID||(LA7_0>=RULE_PARAMETER && LA7_0<=RULE_IA5STRING)||LA7_0==20||LA7_0==26||LA7_0==28||LA7_0==30||(LA7_0>=36 && LA7_0<=38)||LA7_0==41) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:411:1: (lv_values_3_0= ruleValue )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:411:1: (lv_values_3_0= ruleValue )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:412:3: lv_values_3_0= ruleValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeDefinitionAccess().getValuesValueParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValue_in_ruleTypeDefinition798);
            	    lv_values_3_0=ruleValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypeDefinitionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"values",
            	              		lv_values_3_0, 
            	              		"Value");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
    // $ANTLR end "ruleTypeDefinition"


    // $ANTLR start "entryRuleMacro"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:436:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:437:2: (iv_ruleMacro= ruleMacro EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:438:2: iv_ruleMacro= ruleMacro EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroRule()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_entryRuleMacro835);
            iv_ruleMacro=ruleMacro();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacro; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacro845); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:445:1: ruleMacro returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_NEWLINE_4= RULE_NEWLINE otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_NEWLINE_4=null;
        Token otherlv_5=null;
        Token this_NEWLINE_9=null;
        Token otherlv_10=null;
        EObject lv_typeNotation_6_0 = null;

        EObject lv_valueNotation_7_0 = null;

        EObject lv_innerTypes_8_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:448:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_NEWLINE_4= RULE_NEWLINE otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:449:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_NEWLINE_4= RULE_NEWLINE otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:449:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_NEWLINE_4= RULE_NEWLINE otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:449:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_NEWLINE_4= RULE_NEWLINE otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:449:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_NEWLINE) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:449:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro882); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:453:3: ( (lv_name_1_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:454:1: (lv_name_1_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:454:1: (lv_name_1_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:455:3: lv_name_1_0= RULE_MODULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleMacro900); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getMacroAccess().getNameMODULE_IDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMacroRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"MODULE_ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleMacro917); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMacroAccess().getMACROKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleMacro929); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_3());
                  
            }
            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro940); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEWLINE_4, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_4()); 
                  
            }
            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleMacro951); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMacroAccess().getBEGINKeyword_5());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:487:1: ( (lv_typeNotation_6_0= ruleTypeNotation ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:488:1: (lv_typeNotation_6_0= ruleTypeNotation )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:488:1: (lv_typeNotation_6_0= ruleTypeNotation )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:489:3: lv_typeNotation_6_0= ruleTypeNotation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getTypeNotationTypeNotationParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_ruleMacro972);
            lv_typeNotation_6_0=ruleTypeNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMacroRule());
              	        }
                     		set(
                     			current, 
                     			"typeNotation",
                      		lv_typeNotation_6_0, 
                      		"TypeNotation");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:505:2: ( (lv_valueNotation_7_0= ruleValueNotation ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:506:1: (lv_valueNotation_7_0= ruleValueNotation )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:506:1: (lv_valueNotation_7_0= ruleValueNotation )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:507:3: lv_valueNotation_7_0= ruleValueNotation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getValueNotationValueNotationParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValueNotation_in_ruleMacro993);
            lv_valueNotation_7_0=ruleValueNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMacroRule());
              	        }
                     		set(
                     			current, 
                     			"valueNotation",
                      		lv_valueNotation_7_0, 
                      		"ValueNotation");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:523:2: ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:524:1: (lv_innerTypes_8_0= ruleTypeDefinition )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:524:1: (lv_innerTypes_8_0= ruleTypeDefinition )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:525:3: lv_innerTypes_8_0= ruleTypeDefinition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleMacro1014);
            	    lv_innerTypes_8_0=ruleTypeDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMacroRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"innerTypes",
            	              		lv_innerTypes_8_0, 
            	              		"TypeDefinition");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:541:3: (this_NEWLINE_9= RULE_NEWLINE )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_NEWLINE) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:541:4: this_NEWLINE_9= RULE_NEWLINE
            	    {
            	    this_NEWLINE_9=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro1027); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_9, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_9()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_10=(Token)match(input,19,FOLLOW_19_in_ruleMacro1040); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getMacroAccess().getENDKeyword_10());
                  
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


    // $ANTLR start "entryRuleTypeNotation"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:557:1: entryRuleTypeNotation returns [EObject current=null] : iv_ruleTypeNotation= ruleTypeNotation EOF ;
    public final EObject entryRuleTypeNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNotation = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:558:2: (iv_ruleTypeNotation= ruleTypeNotation EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:559:2: iv_ruleTypeNotation= ruleTypeNotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNotationRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation1076);
            iv_ruleTypeNotation=ruleTypeNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNotation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotation1086); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:566:1: ruleTypeNotation returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE NOTATION' ) ) otherlv_2= '::=' ( (lv_typeNotations_3_0= ruleTypeAssignment ) )+ ) ;
    public final EObject ruleTypeNotation() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_typeNotations_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:569:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE NOTATION' ) ) otherlv_2= '::=' ( (lv_typeNotations_3_0= ruleTypeAssignment ) )+ ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:570:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE NOTATION' ) ) otherlv_2= '::=' ( (lv_typeNotations_3_0= ruleTypeAssignment ) )+ )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:570:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE NOTATION' ) ) otherlv_2= '::=' ( (lv_typeNotations_3_0= ruleTypeAssignment ) )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:570:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE NOTATION' ) ) otherlv_2= '::=' ( (lv_typeNotations_3_0= ruleTypeAssignment ) )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:570:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_NEWLINE) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:570:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTypeNotation1123); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getTypeNotationAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:574:3: ( (lv_name_1_0= 'TYPE NOTATION' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:575:1: (lv_name_1_0= 'TYPE NOTATION' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:575:1: (lv_name_1_0= 'TYPE NOTATION' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:576:3: lv_name_1_0= 'TYPE NOTATION'
            {
            lv_name_1_0=(Token)match(input,24,FOLLOW_24_in_ruleTypeNotation1142); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_1_0, grammarAccess.getTypeNotationAccess().getNameTYPENOTATIONKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeNotationRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_1_0, "TYPE NOTATION");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleTypeNotation1167); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTypeNotationAccess().getColonColonEqualsSignKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:593:1: ( (lv_typeNotations_3_0= ruleTypeAssignment ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                alt12 = dfa12.predict(input);
                switch (alt12) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:594:1: (lv_typeNotations_3_0= ruleTypeAssignment )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:594:1: (lv_typeNotations_3_0= ruleTypeAssignment )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:595:3: lv_typeNotations_3_0= ruleTypeAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeNotationAccess().getTypeNotationsTypeAssignmentParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeAssignment_in_ruleTypeNotation1188);
            	    lv_typeNotations_3_0=ruleTypeAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypeNotationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"typeNotations",
            	              		lv_typeNotations_3_0, 
            	              		"TypeAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
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
    // $ANTLR end "ruleTypeNotation"


    // $ANTLR start "entryRuleValueNotation"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:619:1: entryRuleValueNotation returns [EObject current=null] : iv_ruleValueNotation= ruleValueNotation EOF ;
    public final EObject entryRuleValueNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueNotation = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:620:2: (iv_ruleValueNotation= ruleValueNotation EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:621:2: iv_ruleValueNotation= ruleValueNotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueNotationRule()); 
            }
            pushFollow(FOLLOW_ruleValueNotation_in_entryRuleValueNotation1225);
            iv_ruleValueNotation=ruleValueNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueNotation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNotation1235); if (state.failed) return current;

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
    // $ANTLR end "entryRuleValueNotation"


    // $ANTLR start "ruleValueNotation"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:628:1: ruleValueNotation returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE NOTATION' ) ) otherlv_2= '::=' (this_NEWLINE_3= RULE_NEWLINE )? ( (lv_valueNotation_4_0= ruleMacroValue ) ) ) ;
    public final EObject ruleValueNotation() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token this_NEWLINE_3=null;
        EObject lv_valueNotation_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:631:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE NOTATION' ) ) otherlv_2= '::=' (this_NEWLINE_3= RULE_NEWLINE )? ( (lv_valueNotation_4_0= ruleMacroValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:632:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE NOTATION' ) ) otherlv_2= '::=' (this_NEWLINE_3= RULE_NEWLINE )? ( (lv_valueNotation_4_0= ruleMacroValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:632:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE NOTATION' ) ) otherlv_2= '::=' (this_NEWLINE_3= RULE_NEWLINE )? ( (lv_valueNotation_4_0= ruleMacroValue ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:632:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE NOTATION' ) ) otherlv_2= '::=' (this_NEWLINE_3= RULE_NEWLINE )? ( (lv_valueNotation_4_0= ruleMacroValue ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:632:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_NEWLINE) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:632:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValueNotation1272); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getValueNotationAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:636:3: ( (lv_name_1_0= 'VALUE NOTATION' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:637:1: (lv_name_1_0= 'VALUE NOTATION' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:637:1: (lv_name_1_0= 'VALUE NOTATION' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:638:3: lv_name_1_0= 'VALUE NOTATION'
            {
            lv_name_1_0=(Token)match(input,25,FOLLOW_25_in_ruleValueNotation1291); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_1_0, grammarAccess.getValueNotationAccess().getNameVALUENOTATIONKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getValueNotationRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_1_0, "VALUE NOTATION");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleValueNotation1316); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getValueNotationAccess().getColonColonEqualsSignKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:655:1: (this_NEWLINE_3= RULE_NEWLINE )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_NEWLINE) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:655:2: this_NEWLINE_3= RULE_NEWLINE
                    {
                    this_NEWLINE_3=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValueNotation1328); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_3, grammarAccess.getValueNotationAccess().getNEWLINETerminalRuleCall_3()); 
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:659:3: ( (lv_valueNotation_4_0= ruleMacroValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:660:1: (lv_valueNotation_4_0= ruleMacroValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:660:1: (lv_valueNotation_4_0= ruleMacroValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:661:3: lv_valueNotation_4_0= ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueNotationAccess().getValueNotationMacroValueParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMacroValue_in_ruleValueNotation1350);
            lv_valueNotation_4_0=ruleMacroValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueNotationRule());
              	        }
                     		set(
                     			current, 
                     			"valueNotation",
                      		lv_valueNotation_4_0, 
                      		"MacroValue");
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
    // $ANTLR end "ruleValueNotation"


    // $ANTLR start "entryRuleTypeAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:685:1: entryRuleTypeAssignment returns [EObject current=null] : iv_ruleTypeAssignment= ruleTypeAssignment EOF ;
    public final EObject entryRuleTypeAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:686:2: (iv_ruleTypeAssignment= ruleTypeAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:687:2: iv_ruleTypeAssignment= ruleTypeAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment1386);
            iv_ruleTypeAssignment=ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAssignment1396); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:694:1: ruleTypeAssignment returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) ) ;
    public final EObject ruleTypeAssignment() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        EObject this_ParamAssignment_1 = null;

        EObject this_TypeReference_2 = null;

        EObject this_MacroValue_3 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:697:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:698:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:698:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:698:2: (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:698:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_NEWLINE) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:698:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTypeAssignment1433); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:702:3: (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue )
            int alt16=3;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt16=1;
                }
                break;
            case RULE_MODULE_ID:
                {
                alt16=2;
                }
                break;
            case 30:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:703:5: this_ParamAssignment_1= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleTypeAssignment1457);
                    this_ParamAssignment_1=ruleParamAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ParamAssignment_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:713:5: this_TypeReference_2= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeAssignment1484);
                    this_TypeReference_2=ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeReference_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:723:5: this_MacroValue_3= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getMacroValueParserRuleCall_1_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleTypeAssignment1511);
                    this_MacroValue_3=ruleMacroValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MacroValue_3; 
                              afterParserOrEnumRuleCall();
                          
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
    // $ANTLR end "ruleTypeAssignment"


    // $ANTLR start "entryRuleParamAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:739:1: entryRuleParamAssignment returns [EObject current=null] : iv_ruleParamAssignment= ruleParamAssignment EOF ;
    public final EObject entryRuleParamAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:740:2: (iv_ruleParamAssignment= ruleParamAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:741:2: iv_ruleParamAssignment= ruleParamAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment1547);
            iv_ruleParamAssignment=ruleParamAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamAssignment1557); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:748:1: ruleParamAssignment returns [EObject current=null] : ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) ) ;
    public final EObject ruleParamAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_param_0_0=null;
        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:751:28: ( ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:752:1: ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:752:1: ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:752:2: ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:752:2: ( (lv_param_0_0= RULE_PARAMETER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:753:1: (lv_param_0_0= RULE_PARAMETER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:753:1: (lv_param_0_0= RULE_PARAMETER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:754:3: lv_param_0_0= RULE_PARAMETER
            {
            lv_param_0_0=(Token)match(input,RULE_PARAMETER,FOLLOW_RULE_PARAMETER_in_ruleParamAssignment1599); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:770:2: ( (lv_right_1_0= ruleTypeNotationRight ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:771:1: (lv_right_1_0= ruleTypeNotationRight )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:771:1: (lv_right_1_0= ruleTypeNotationRight )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:772:3: lv_right_1_0= ruleTypeNotationRight
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAssignmentAccess().getRightTypeNotationRightParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeNotationRight_in_ruleParamAssignment1625);
            lv_right_1_0=ruleTypeNotationRight();

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
                      		"TypeNotationRight");
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


    // $ANTLR start "entryRuleTypeNotationRight"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:796:1: entryRuleTypeNotationRight returns [EObject current=null] : iv_ruleTypeNotationRight= ruleTypeNotationRight EOF ;
    public final EObject entryRuleTypeNotationRight() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNotationRight = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:797:2: (iv_ruleTypeNotationRight= ruleTypeNotationRight EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:798:2: iv_ruleTypeNotationRight= ruleTypeNotationRight EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNotationRightRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotationRight_in_entryRuleTypeNotationRight1661);
            iv_ruleTypeNotationRight=ruleTypeNotationRight();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNotationRight; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotationRight1671); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeNotationRight"


    // $ANTLR start "ruleTypeNotationRight"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:805:1: ruleTypeNotationRight returns [EObject current=null] : (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) ;
    public final EObject ruleTypeNotationRight() throws RecognitionException {
        EObject current = null;

        EObject this_TypeReference_0 = null;

        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:808:28: ( (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:809:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:809:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_MODULE_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==30) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:810:5: this_TypeReference_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeNotationRightAccess().getTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeNotationRight1718);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:819:6: ( (lv_value_1_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:819:6: ( (lv_value_1_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:820:1: (lv_value_1_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:820:1: (lv_value_1_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:821:3: lv_value_1_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNotationRightAccess().getValueMacroValueParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleTypeNotationRight1744);
                    lv_value_1_0=ruleMacroValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeNotationRightRule());
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
    // $ANTLR end "ruleTypeNotationRight"


    // $ANTLR start "entryRuleTypeReferenceExt"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:845:1: entryRuleTypeReferenceExt returns [EObject current=null] : iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF ;
    public final EObject entryRuleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReferenceExt = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:846:2: (iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:847:2: iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceExtRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt1780);
            iv_ruleTypeReferenceExt=ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReferenceExt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReferenceExt1790); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:854:1: ruleTypeReferenceExt returns [EObject current=null] : ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? ) ;
    public final EObject ruleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject lv_parentRef_0_0 = null;

        EObject lv_childRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:857:28: ( ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:858:1: ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:858:1: ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:858:2: ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:858:2: ( (lv_parentRef_0_0= ruleTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:859:1: (lv_parentRef_0_0= ruleTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:859:1: (lv_parentRef_0_0= ruleTypeReference )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:860:3: lv_parentRef_0_0= ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getParentRefTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1836);
            lv_parentRef_0_0=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeReferenceExtRule());
              	        }
                     		set(
                     			current, 
                     			"parentRef",
                      		lv_parentRef_0_0, 
                      		"TypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:876:2: ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_MODULE_ID) ) {
                int LA18_1 = input.LA(2);

                if ( (synpred2_InternalSmi()) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:876:3: ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:881:1: (lv_childRef_1_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:882:3: lv_childRef_1_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getChildRefTypeReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1867);
                    lv_childRef_1_0=ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeReferenceExtRule());
                      	        }
                             		set(
                             			current, 
                             			"childRef",
                              		lv_childRef_1_0, 
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:906:1: entryRuleTypeReference returns [EObject current=null] : iv_ruleTypeReference= ruleTypeReference EOF ;
    public final EObject entryRuleTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReference = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:907:2: (iv_ruleTypeReference= ruleTypeReference EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:908:2: iv_ruleTypeReference= ruleTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_entryRuleTypeReference1904);
            iv_ruleTypeReference=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReference1914); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:915:1: ruleTypeReference returns [EObject current=null] : ( (otherlv_0= RULE_MODULE_ID ) ) ;
    public final EObject ruleTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:918:28: ( ( (otherlv_0= RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:919:1: ( (otherlv_0= RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:919:1: ( (otherlv_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:920:1: (otherlv_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:920:1: (otherlv_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:921:3: otherlv_0= RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeReferenceRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleTypeReference1958); if (state.failed) return current;
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


    // $ANTLR start "entryRuleValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:940:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:941:2: (iv_ruleValue= ruleValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:942:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue1993);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue2003); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:949:1: ruleValue returns [EObject current=null] : ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )? otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_1=null;
        Token lv_implicit_2_0=null;
        Token this_NEWLINE_4=null;
        Token otherlv_5=null;
        EObject lv_tag_0_0 = null;

        EObject lv_valueTypes_3_0 = null;

        EObject lv_valueTypes_6_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:952:28: ( ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )? otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:953:1: ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )? otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:953:1: ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )? otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:953:2: ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )? otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:953:2: ( (lv_tag_0_0= ruleTag ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_NEWLINE) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==28) ) {
                    alt19=1;
                }
            }
            else if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:954:1: (lv_tag_0_0= ruleTag )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:954:1: (lv_tag_0_0= ruleTag )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:955:3: lv_tag_0_0= ruleTag
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getTagTagParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTag_in_ruleValue2049);
                    lv_tag_0_0=ruleTag();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueRule());
                      	        }
                             		set(
                             			current, 
                             			"tag",
                              		lv_tag_0_0, 
                              		"Tag");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:971:3: (this_NEWLINE_1= RULE_NEWLINE )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_NEWLINE) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:971:4: this_NEWLINE_1= RULE_NEWLINE
                    {
                    this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValue2062); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_1, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:975:3: ( (lv_implicit_2_0= 'IMPLICIT' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==26) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:976:1: (lv_implicit_2_0= 'IMPLICIT' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:976:1: (lv_implicit_2_0= 'IMPLICIT' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:977:3: lv_implicit_2_0= 'IMPLICIT'
                    {
                    lv_implicit_2_0=(Token)match(input,26,FOLLOW_26_in_ruleValue2081); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_implicit_2_0, grammarAccess.getValueAccess().getImplicitIMPLICITKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueRule());
                      	        }
                             		setWithLastConsumed(current, "implicit", true, "IMPLICIT");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:990:3: ( (lv_valueTypes_3_0= ruleValueType ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:991:1: (lv_valueTypes_3_0= ruleValueType )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:991:1: (lv_valueTypes_3_0= ruleValueType )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:992:3: lv_valueTypes_3_0= ruleValueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValueType_in_ruleValue2116);
            lv_valueTypes_3_0=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueRule());
              	        }
                     		add(
                     			current, 
                     			"valueTypes",
                      		lv_valueTypes_3_0, 
                      		"ValueType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1008:2: ( (this_NEWLINE_4= RULE_NEWLINE )? otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_NEWLINE) ) {
                    int LA23_1 = input.LA(2);

                    if ( (LA23_1==27) ) {
                        alt23=1;
                    }


                }
                else if ( (LA23_0==27) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1008:3: (this_NEWLINE_4= RULE_NEWLINE )? otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1008:3: (this_NEWLINE_4= RULE_NEWLINE )?
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( (LA22_0==RULE_NEWLINE) ) {
            	        alt22=1;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1008:4: this_NEWLINE_4= RULE_NEWLINE
            	            {
            	            this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValue2129); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {
            	               
            	                  newLeafNode(this_NEWLINE_4, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_4_0()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    otherlv_5=(Token)match(input,27,FOLLOW_27_in_ruleValue2142); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getValueAccess().getVerticalLineKeyword_4_1());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1016:1: ( (lv_valueTypes_6_0= ruleValueType ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1017:1: (lv_valueTypes_6_0= ruleValueType )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1017:1: (lv_valueTypes_6_0= ruleValueType )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1018:3: lv_valueTypes_6_0= ruleValueType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_4_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValueType_in_ruleValue2163);
            	    lv_valueTypes_6_0=ruleValueType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getValueRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"valueTypes",
            	              		lv_valueTypes_6_0, 
            	              		"ValueType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
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


    // $ANTLR start "entryRuleTag"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1042:1: entryRuleTag returns [EObject current=null] : iv_ruleTag= ruleTag EOF ;
    public final EObject entryRuleTag() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTag = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1043:2: (iv_ruleTag= ruleTag EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1044:2: iv_ruleTag= ruleTag EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTagRule()); 
            }
            pushFollow(FOLLOW_ruleTag_in_entryRuleTag2201);
            iv_ruleTag=ruleTag();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTag; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTag2211); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTag"


    // $ANTLR start "ruleTag"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1051:1: ruleTag returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' ) ;
    public final EObject ruleTag() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token otherlv_1=null;
        Token lv_tagValue_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1054:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1055:1: ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1055:1: ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1055:2: (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1055:2: (this_NEWLINE_0= RULE_NEWLINE )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_NEWLINE) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1055:3: this_NEWLINE_0= RULE_NEWLINE
                    {
                    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTag2248); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_0, grammarAccess.getTagAccess().getNEWLINETerminalRuleCall_0()); 
                          
                    }

                    }
                    break;

            }

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleTag2261); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTagAccess().getAPPLICATIONKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1063:1: ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1064:1: (lv_tagValue_2_0= RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1064:1: (lv_tagValue_2_0= RULE_BIG_INTEGER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1065:3: lv_tagValue_2_0= RULE_BIG_INTEGER
            {
            lv_tagValue_2_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleTag2278); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_tagValue_2_0, grammarAccess.getTagAccess().getTagValueBIG_INTEGERTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTagRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"tagValue",
                      		lv_tagValue_2_0, 
                      		"BIG_INTEGER");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleTag2295); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTagAccess().getRightSquareBracketKeyword_3());
                  
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
    // $ANTLR end "ruleTag"


    // $ANTLR start "entryRuleValueType"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1093:1: entryRuleValueType returns [EObject current=null] : iv_ruleValueType= ruleValueType EOF ;
    public final EObject entryRuleValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1094:2: (iv_ruleValueType= ruleValueType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1095:2: iv_ruleValueType= ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType2331);
            iv_ruleValueType=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType2341); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1102:1: ruleValueType returns [EObject current=null] : ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_types_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) ) ;
    public final EObject ruleValueType() throws RecognitionException {
        EObject current = null;

        Token lv_oi_4_0=null;
        EObject lv_param_0_0 = null;

        EObject lv_types_1_0 = null;

        EObject lv_simpleType_2_0 = null;

        EObject lv_macroValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1105:28: ( ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_types_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1106:1: ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_types_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1106:1: ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_types_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) )
            int alt25=5;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt25=1;
                }
                break;
            case RULE_MODULE_ID:
                {
                alt25=2;
                }
                break;
            case RULE_IA5STRING:
            case 36:
            case 37:
            case 38:
            case 41:
                {
                alt25=3;
                }
                break;
            case 30:
                {
                alt25=4;
                }
                break;
            case 20:
                {
                alt25=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1106:2: ( (lv_param_0_0= ruleParamAssignment ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1106:2: ( (lv_param_0_0= ruleParamAssignment ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1107:1: (lv_param_0_0= ruleParamAssignment )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1107:1: (lv_param_0_0= ruleParamAssignment )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1108:3: lv_param_0_0= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleValueType2387);
                    lv_param_0_0=ruleParamAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"param",
                              		lv_param_0_0, 
                              		"ParamAssignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1125:6: ( (lv_types_1_0= ruleTypeReferenceExt ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1125:6: ( (lv_types_1_0= ruleTypeReferenceExt ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1126:1: (lv_types_1_0= ruleTypeReferenceExt )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1126:1: (lv_types_1_0= ruleTypeReferenceExt )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1127:3: lv_types_1_0= ruleTypeReferenceExt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getTypesTypeReferenceExtParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReferenceExt_in_ruleValueType2414);
                    lv_types_1_0=ruleTypeReferenceExt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"types",
                              		lv_types_1_0, 
                              		"TypeReferenceExt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1144:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1144:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1145:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1145:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1146:3: lv_simpleType_2_0= ruleASN1_TYPE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_TYPE_in_ruleValueType2441);
                    lv_simpleType_2_0=ruleASN1_TYPE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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


                    }
                    break;
                case 4 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1163:6: ( (lv_macroValue_3_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1163:6: ( (lv_macroValue_3_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1164:1: (lv_macroValue_3_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1164:1: (lv_macroValue_3_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1165:3: lv_macroValue_3_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleValueType2468);
                    lv_macroValue_3_0=ruleMacroValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"macroValue",
                              		lv_macroValue_3_0, 
                              		"MacroValue");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1182:6: ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1182:6: ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1183:1: (lv_oi_4_0= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1183:1: (lv_oi_4_0= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1184:3: lv_oi_4_0= 'OBJECT IDENTIFIER'
                    {
                    lv_oi_4_0=(Token)match(input,20,FOLLOW_20_in_ruleValueType2492); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_oi_4_0, grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_4_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                      	        }
                             		setWithLastConsumed(current, "oi", lv_oi_4_0, "OBJECT IDENTIFIER");
                      	    
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
    // $ANTLR end "ruleValueType"


    // $ANTLR start "entryRuleMacroValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1205:1: entryRuleMacroValue returns [EObject current=null] : iv_ruleMacroValue= ruleMacroValue EOF ;
    public final EObject entryRuleMacroValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacroValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1206:2: (iv_ruleMacroValue= ruleMacroValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1207:2: iv_ruleMacroValue= ruleMacroValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroValueRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue2541);
            iv_ruleMacroValue=ruleMacroValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacroValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue2551); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1214:1: ruleMacroValue returns [EObject current=null] : ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' ) ;
    public final EObject ruleMacroValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_valueType_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1217:28: ( ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1218:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1218:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1218:2: () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1218:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1219:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getMacroValueAccess().getMacroValueAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,30,FOLLOW_30_in_ruleMacroValue2597); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMacroValueAccess().getValueKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleMacroValue2609); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMacroValueAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1232:1: ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1233:1: (lv_valueType_3_0= ruleMACRO_VALUE_TYPE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1233:1: (lv_valueType_3_0= ruleMACRO_VALUE_TYPE )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1234:3: lv_valueType_3_0= ruleMACRO_VALUE_TYPE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroValueAccess().getValueTypeMACRO_VALUE_TYPEParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_ruleMacroValue2630);
            lv_valueType_3_0=ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMacroValueRule());
              	        }
                     		set(
                     			current, 
                     			"valueType",
                      		lv_valueType_3_0, 
                      		"MACRO_VALUE_TYPE");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleMacroValue2642); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1262:1: entryRuleMACRO_VALUE_TYPE returns [EObject current=null] : iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF ;
    public final EObject entryRuleMACRO_VALUE_TYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMACRO_VALUE_TYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1263:2: (iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1264:2: iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE2678);
            iv_ruleMACRO_VALUE_TYPE=ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMACRO_VALUE_TYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE2688); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1271:1: ruleMACRO_VALUE_TYPE returns [EObject current=null] : ( ( (lv_update_0_0= ruleUpdateType ) ) | (otherlv_1= 'VALUE' ( (lv_literal_2_0= ruleMACRO_VALUE_CAP ) ) ) | ( (lv_string_3_0= 'IA5String' ) ) ) ;
    public final EObject ruleMACRO_VALUE_TYPE() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_string_3_0=null;
        EObject lv_update_0_0 = null;

        EObject lv_literal_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1274:28: ( ( ( (lv_update_0_0= ruleUpdateType ) ) | (otherlv_1= 'VALUE' ( (lv_literal_2_0= ruleMACRO_VALUE_CAP ) ) ) | ( (lv_string_3_0= 'IA5String' ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1275:1: ( ( (lv_update_0_0= ruleUpdateType ) ) | (otherlv_1= 'VALUE' ( (lv_literal_2_0= ruleMACRO_VALUE_CAP ) ) ) | ( (lv_string_3_0= 'IA5String' ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1275:1: ( ( (lv_update_0_0= ruleUpdateType ) ) | (otherlv_1= 'VALUE' ( (lv_literal_2_0= ruleMACRO_VALUE_CAP ) ) ) | ( (lv_string_3_0= 'IA5String' ) ) )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt26=1;
                }
                break;
            case 33:
                {
                alt26=2;
                }
                break;
            case 34:
                {
                alt26=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1275:2: ( (lv_update_0_0= ruleUpdateType ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1275:2: ( (lv_update_0_0= ruleUpdateType ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1276:1: (lv_update_0_0= ruleUpdateType )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1276:1: (lv_update_0_0= ruleUpdateType )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1277:3: lv_update_0_0= ruleUpdateType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateUpdateTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUpdateType_in_ruleMACRO_VALUE_TYPE2734);
                    lv_update_0_0=ruleUpdateType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMACRO_VALUE_TYPERule());
                      	        }
                             		set(
                             			current, 
                             			"update",
                              		lv_update_0_0, 
                              		"UpdateType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1294:6: (otherlv_1= 'VALUE' ( (lv_literal_2_0= ruleMACRO_VALUE_CAP ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1294:6: (otherlv_1= 'VALUE' ( (lv_literal_2_0= ruleMACRO_VALUE_CAP ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1294:8: otherlv_1= 'VALUE' ( (lv_literal_2_0= ruleMACRO_VALUE_CAP ) )
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleMACRO_VALUE_TYPE2753); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMACRO_VALUE_TYPEAccess().getVALUEKeyword_1_0());
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1298:1: ( (lv_literal_2_0= ruleMACRO_VALUE_CAP ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1299:1: (lv_literal_2_0= ruleMACRO_VALUE_CAP )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1299:1: (lv_literal_2_0= ruleMACRO_VALUE_CAP )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1300:3: lv_literal_2_0= ruleMACRO_VALUE_CAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralMACRO_VALUE_CAPParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_ruleMACRO_VALUE_TYPE2774);
                    lv_literal_2_0=ruleMACRO_VALUE_CAP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMACRO_VALUE_TYPERule());
                      	        }
                             		set(
                             			current, 
                             			"literal",
                              		lv_literal_2_0, 
                              		"MACRO_VALUE_CAP");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1317:6: ( (lv_string_3_0= 'IA5String' ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1317:6: ( (lv_string_3_0= 'IA5String' ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1318:1: (lv_string_3_0= 'IA5String' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1318:1: (lv_string_3_0= 'IA5String' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1319:3: lv_string_3_0= 'IA5String'
                    {
                    lv_string_3_0=(Token)match(input,34,FOLLOW_34_in_ruleMACRO_VALUE_TYPE2799); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_string_3_0, grammarAccess.getMACRO_VALUE_TYPEAccess().getStringIA5StringKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMACRO_VALUE_TYPERule());
                      	        }
                             		setWithLastConsumed(current, "string", lv_string_3_0, "IA5String");
                      	    
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1340:1: entryRuleUpdateType returns [EObject current=null] : iv_ruleUpdateType= ruleUpdateType EOF ;
    public final EObject entryRuleUpdateType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdateType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1341:2: (iv_ruleUpdateType= ruleUpdateType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1342:2: iv_ruleUpdateType= ruleUpdateType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUpdateTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_entryRuleUpdateType2848);
            iv_ruleUpdateType=ruleUpdateType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUpdateType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpdateType2858); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1349:1: ruleUpdateType returns [EObject current=null] : (otherlv_0= 'Update' ( (lv_ref_1_0= ruleTypeReference ) ) ) ;
    public final EObject ruleUpdateType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_ref_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1352:28: ( (otherlv_0= 'Update' ( (lv_ref_1_0= ruleTypeReference ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1353:1: (otherlv_0= 'Update' ( (lv_ref_1_0= ruleTypeReference ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1353:1: (otherlv_0= 'Update' ( (lv_ref_1_0= ruleTypeReference ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1353:3: otherlv_0= 'Update' ( (lv_ref_1_0= ruleTypeReference ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleUpdateType2895); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getUpdateTypeAccess().getUpdateKeyword_0());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1357:1: ( (lv_ref_1_0= ruleTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1358:1: (lv_ref_1_0= ruleTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1358:1: (lv_ref_1_0= ruleTypeReference )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1359:3: lv_ref_1_0= ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUpdateTypeAccess().getRefTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeReference_in_ruleUpdateType2916);
            lv_ref_1_0=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUpdateTypeRule());
              	        }
                     		set(
                     			current, 
                     			"ref",
                      		lv_ref_1_0, 
                      		"TypeReference");
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
    // $ANTLR end "ruleUpdateType"


    // $ANTLR start "entryRuleMACRO_VALUE_CAP"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1383:1: entryRuleMACRO_VALUE_CAP returns [EObject current=null] : iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF ;
    public final EObject entryRuleMACRO_VALUE_CAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMACRO_VALUE_CAP = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1384:2: (iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1385:2: iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP2952);
            iv_ruleMACRO_VALUE_CAP=ruleMACRO_VALUE_CAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMACRO_VALUE_CAP; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP2962); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1392:1: ruleMACRO_VALUE_CAP returns [EObject current=null] : ( ( () otherlv_1= 'OBJECT IDENTIFIER' ) | ( (lv_ref_2_0= ruleTypeReference ) ) ) ;
    public final EObject ruleMACRO_VALUE_CAP() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ref_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1395:28: ( ( ( () otherlv_1= 'OBJECT IDENTIFIER' ) | ( (lv_ref_2_0= ruleTypeReference ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1396:1: ( ( () otherlv_1= 'OBJECT IDENTIFIER' ) | ( (lv_ref_2_0= ruleTypeReference ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1396:1: ( ( () otherlv_1= 'OBJECT IDENTIFIER' ) | ( (lv_ref_2_0= ruleTypeReference ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==20) ) {
                alt27=1;
            }
            else if ( (LA27_0==RULE_MODULE_ID) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1396:2: ( () otherlv_1= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1396:2: ( () otherlv_1= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1396:3: () otherlv_1= 'OBJECT IDENTIFIER'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1396:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1397:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getMACRO_VALUE_CAPAccess().getMACRO_VALUE_CAPAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleMACRO_VALUE_CAP3009); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMACRO_VALUE_CAPAccess().getOBJECTIDENTIFIERKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1407:6: ( (lv_ref_2_0= ruleTypeReference ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1407:6: ( (lv_ref_2_0= ruleTypeReference ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1408:1: (lv_ref_2_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1408:1: (lv_ref_2_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1409:3: lv_ref_2_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMACRO_VALUE_CAPAccess().getRefTypeReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleMACRO_VALUE_CAP3037);
                    lv_ref_2_0=ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMACRO_VALUE_CAPRule());
                      	        }
                             		set(
                             			current, 
                             			"ref",
                              		lv_ref_2_0, 
                              		"TypeReference");
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
    // $ANTLR end "ruleMACRO_VALUE_CAP"


    // $ANTLR start "entryRuleASN1_TYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1433:1: entryRuleASN1_TYPE returns [EObject current=null] : iv_ruleASN1_TYPE= ruleASN1_TYPE EOF ;
    public final EObject entryRuleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_TYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1434:2: (iv_ruleASN1_TYPE= ruleASN1_TYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1435:2: iv_ruleASN1_TYPE= ruleASN1_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE3073);
            iv_ruleASN1_TYPE=ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_TYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE3083); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1442:1: ruleASN1_TYPE returns [EObject current=null] : (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE ) ;
    public final EObject ruleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject this_ASN1_SIMPLE_0 = null;

        EObject this_ASN1_CHOICE_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1445:28: ( (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1446:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1446:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_IA5STRING||(LA28_0>=36 && LA28_0<=38)) ) {
                alt28=1;
            }
            else if ( (LA28_0==41) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1447:5: this_ASN1_SIMPLE_0= ruleASN1_SIMPLE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE3130);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1457:5: this_ASN1_CHOICE_1= ruleASN1_CHOICE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE3157);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1473:1: entryRuleASN1_SIMPLE returns [EObject current=null] : iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF ;
    public final EObject entryRuleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SIMPLE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1474:2: (iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1475:2: iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SIMPLERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE3192);
            iv_ruleASN1_SIMPLE=ruleASN1_SIMPLE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SIMPLE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE3202); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1482:1: ruleASN1_SIMPLE returns [EObject current=null] : ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER ) ;
    public final EObject ruleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_IA5STRING_3=null;
        EObject this_ASN1_OCTET_STRING_4 = null;

        EObject lv_constraint_5_0 = null;

        EObject this_ASN1_INTEGER_6 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1485:28: ( ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1486:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1486:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt30=1;
                }
                break;
            case RULE_IA5STRING:
                {
                alt30=2;
                }
                break;
            case 37:
                {
                alt30=3;
                }
                break;
            case 38:
                {
                alt30=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1486:2: ( () otherlv_1= 'empty' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1486:2: ( () otherlv_1= 'empty' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1486:3: () otherlv_1= 'empty'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1486:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1487:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleASN1_SIMPLE3249); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1497:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1497:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1497:7: () this_IA5STRING_3= RULE_IA5STRING
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1497:7: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1498:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_1_0(),
                                  current);
                          
                    }

                    }

                    this_IA5STRING_3=(Token)match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE3277); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_IA5STRING_3, grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1508:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1508:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1509:5: this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE3306);
                    this_ASN1_OCTET_STRING_4=ruleASN1_OCTET_STRING();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_OCTET_STRING_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1517:1: ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==31) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1518:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1518:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1519:3: lv_constraint_5_0= ruleASN1_SUBTYPE
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE3326);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1537:5: this_ASN1_INTEGER_6= ruleASN1_INTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE3356);
                    this_ASN1_INTEGER_6=ruleASN1_INTEGER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_INTEGER_6; 
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
    // $ANTLR end "ruleASN1_SIMPLE"


    // $ANTLR start "entryRuleASN1_OCTET_STRING"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1553:1: entryRuleASN1_OCTET_STRING returns [EObject current=null] : iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF ;
    public final EObject entryRuleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_OCTET_STRING = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1554:2: (iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1555:2: iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING3391);
            iv_ruleASN1_OCTET_STRING=ruleASN1_OCTET_STRING();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_OCTET_STRING; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING3401); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1562:1: ruleASN1_OCTET_STRING returns [EObject current=null] : ( () ( (lv_name_1_0= 'OCTET STRING' ) ) ) ;
    public final EObject ruleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1565:28: ( ( () ( (lv_name_1_0= 'OCTET STRING' ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1566:1: ( () ( (lv_name_1_0= 'OCTET STRING' ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1566:1: ( () ( (lv_name_1_0= 'OCTET STRING' ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1566:2: () ( (lv_name_1_0= 'OCTET STRING' ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1566:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1567:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1572:2: ( (lv_name_1_0= 'OCTET STRING' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1573:1: (lv_name_1_0= 'OCTET STRING' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1573:1: (lv_name_1_0= 'OCTET STRING' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1574:3: lv_name_1_0= 'OCTET STRING'
            {
            lv_name_1_0=(Token)match(input,37,FOLLOW_37_in_ruleASN1_OCTET_STRING3453); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_1_0, grammarAccess.getASN1_OCTET_STRINGAccess().getNameOCTETSTRINGKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getASN1_OCTET_STRINGRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_1_0, "OCTET STRING");
              	    
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
    // $ANTLR end "ruleASN1_OCTET_STRING"


    // $ANTLR start "entryRuleASN1_INTEGER"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1595:1: entryRuleASN1_INTEGER returns [EObject current=null] : iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF ;
    public final EObject entryRuleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_INTEGER = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1596:2: (iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1597:2: iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_INTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER3502);
            iv_ruleASN1_INTEGER=ruleASN1_INTEGER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_INTEGER; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER3512); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1604:1: ruleASN1_INTEGER returns [EObject current=null] : ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_range_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1607:28: ( ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1608:1: ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1608:1: ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1608:2: ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )?
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1608:2: ( (lv_name_0_0= 'INTEGER' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1609:1: (lv_name_0_0= 'INTEGER' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1609:1: (lv_name_0_0= 'INTEGER' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1610:3: lv_name_0_0= 'INTEGER'
            {
            lv_name_0_0=(Token)match(input,38,FOLLOW_38_in_ruleASN1_INTEGER3555); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getASN1_INTEGERAccess().getNameINTEGERKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getASN1_INTEGERRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "INTEGER");
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1623:2: (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==31) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1623:4: otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleASN1_INTEGER3581); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getASN1_INTEGERAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1627:1: ( (lv_range_2_0= ruleASN1_RANGE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1628:1: (lv_range_2_0= ruleASN1_RANGE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1628:1: (lv_range_2_0= ruleASN1_RANGE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1629:3: lv_range_2_0= ruleASN1_RANGE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getASN1_INTEGERAccess().getRangeASN1_RANGEParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_INTEGER3602);
                    lv_range_2_0=ruleASN1_RANGE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getASN1_INTEGERRule());
                      	        }
                             		set(
                             			current, 
                             			"range",
                              		lv_range_2_0, 
                              		"ASN1_RANGE");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleASN1_INTEGER3614); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getASN1_INTEGERAccess().getRightParenthesisKeyword_1_2());
                          
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
    // $ANTLR end "ruleASN1_INTEGER"


    // $ANTLR start "entryRuleASN1_SUBTYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1657:1: entryRuleASN1_SUBTYPE returns [EObject current=null] : iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF ;
    public final EObject entryRuleASN1_SUBTYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SUBTYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1658:2: (iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1659:2: iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SUBTYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE3652);
            iv_ruleASN1_SUBTYPE=ruleASN1_SUBTYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SUBTYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE3662); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1666:1: ruleASN1_SUBTYPE returns [EObject current=null] : (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1669:28: ( (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1670:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1670:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1670:3: otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleASN1_SUBTYPE3699); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleASN1_SUBTYPE3711); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleASN1_SUBTYPE3723); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1682:1: ( (lv_ranges_3_0= ruleASN1_RANGE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1683:1: (lv_ranges_3_0= ruleASN1_RANGE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1683:1: (lv_ranges_3_0= ruleASN1_RANGE )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1684:3: lv_ranges_3_0= ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3744);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1700:2: (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==27) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1700:4: otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    {
            	    otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleASN1_SUBTYPE3757); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getASN1_SUBTYPEAccess().getVerticalLineKeyword_4_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1704:1: ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1705:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1705:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1706:3: lv_ranges_5_0= ruleASN1_RANGE
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3778);
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
            	    break loop32;
                }
            } while (true);

            otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleASN1_SUBTYPE3792); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,32,FOLLOW_32_in_ruleASN1_SUBTYPE3804); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1738:1: entryRuleASN1_RANGE returns [EObject current=null] : iv_ruleASN1_RANGE= ruleASN1_RANGE EOF ;
    public final EObject entryRuleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_RANGE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1739:2: (iv_ruleASN1_RANGE= ruleASN1_RANGE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1740:2: iv_ruleASN1_RANGE= ruleASN1_RANGE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_RANGERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE3840);
            iv_ruleASN1_RANGE=ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_RANGE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE3850); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1747:1: ruleASN1_RANGE returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) ) ;
    public final EObject ruleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_start_2_0=null;
        Token otherlv_3=null;
        Token lv_end_4_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1750:28: ( ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1751:1: ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1751:1: ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_BIG_INTEGER) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==40) ) {
                    alt33=2;
                }
                else if ( (LA33_1==EOF||LA33_1==27||LA33_1==32) ) {
                    alt33=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1751:2: ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1751:2: ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1751:3: () ( (lv_value_1_0= RULE_BIG_INTEGER ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1751:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1752:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1757:2: ( (lv_value_1_0= RULE_BIG_INTEGER ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1758:1: (lv_value_1_0= RULE_BIG_INTEGER )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1758:1: (lv_value_1_0= RULE_BIG_INTEGER )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1759:3: lv_value_1_0= RULE_BIG_INTEGER
                    {
                    lv_value_1_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE3902); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_value_1_0, grammarAccess.getASN1_RANGEAccess().getValueBIG_INTEGERTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getASN1_RANGERule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"value",
                              		lv_value_1_0, 
                              		"BIG_INTEGER");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1776:6: ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1776:6: ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1776:7: ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1776:7: ( (lv_start_2_0= RULE_BIG_INTEGER ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1777:1: (lv_start_2_0= RULE_BIG_INTEGER )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1777:1: (lv_start_2_0= RULE_BIG_INTEGER )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1778:3: lv_start_2_0= RULE_BIG_INTEGER
                    {
                    lv_start_2_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE3932); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_start_2_0, grammarAccess.getASN1_RANGEAccess().getStartBIG_INTEGERTerminalRuleCall_1_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getASN1_RANGERule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"start",
                              		lv_start_2_0, 
                              		"BIG_INTEGER");
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,40,FOLLOW_40_in_ruleASN1_RANGE3949); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_1_1());
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1798:1: ( (lv_end_4_0= RULE_BIG_INTEGER ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1799:1: (lv_end_4_0= RULE_BIG_INTEGER )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1799:1: (lv_end_4_0= RULE_BIG_INTEGER )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1800:3: lv_end_4_0= RULE_BIG_INTEGER
                    {
                    lv_end_4_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE3966); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_end_4_0, grammarAccess.getASN1_RANGEAccess().getEndBIG_INTEGERTerminalRuleCall_1_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getASN1_RANGERule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"end",
                              		lv_end_4_0, 
                              		"BIG_INTEGER");
                      	    
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


    // $ANTLR start "entryRuleASN1_CHOICE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1826:1: entryRuleASN1_CHOICE returns [EObject current=null] : iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF ;
    public final EObject entryRuleASN1_CHOICE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1827:2: (iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1828:2: iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE4010);
            iv_ruleASN1_CHOICE=ruleASN1_CHOICE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE4020); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1835:1: ruleASN1_CHOICE returns [EObject current=null] : (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' ) ;
    public final EObject ruleASN1_CHOICE() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_NEWLINE_2=null;
        Token otherlv_4=null;
        Token this_NEWLINE_5=null;
        Token this_NEWLINE_7=null;
        Token otherlv_8=null;
        EObject lv_choiceType_3_0 = null;

        EObject lv_choiceType_6_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1838:28: ( (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1839:1: (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1839:1: (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1839:3: otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleASN1_CHOICE4057); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleASN1_CHOICE4069); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1847:1: (this_NEWLINE_2= RULE_NEWLINE )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_NEWLINE) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1847:2: this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE4081); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_2, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1851:3: ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1852:1: (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1852:1: (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1853:3: lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE4103);
            lv_choiceType_3_0=ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getASN1_CHOICERule());
              	        }
                     		add(
                     			current, 
                     			"choiceType",
                      		lv_choiceType_3_0, 
                      		"ASN1_CHOICE_ENTRY");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1869:2: (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==42) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1869:4: otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) )
            	    {
            	    otherlv_4=(Token)match(input,42,FOLLOW_42_in_ruleASN1_CHOICE4116); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1873:1: (this_NEWLINE_5= RULE_NEWLINE )+
            	    int cnt35=0;
            	    loop35:
            	    do {
            	        int alt35=2;
            	        int LA35_0 = input.LA(1);

            	        if ( (LA35_0==RULE_NEWLINE) ) {
            	            alt35=1;
            	        }


            	        switch (alt35) {
            	    	case 1 :
            	    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1873:2: this_NEWLINE_5= RULE_NEWLINE
            	    	    {
            	    	    this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE4128); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_NEWLINE_5, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_4_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt35 >= 1 ) break loop35;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(35, input);
            	                throw eee;
            	        }
            	        cnt35++;
            	    } while (true);

            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1877:3: ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1878:1: (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1878:1: (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1879:3: lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_4_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE4150);
            	    lv_choiceType_6_0=ruleASN1_CHOICE_ENTRY();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getASN1_CHOICERule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"choiceType",
            	              		lv_choiceType_6_0, 
            	              		"ASN1_CHOICE_ENTRY");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1895:4: (this_NEWLINE_7= RULE_NEWLINE )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_NEWLINE) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1895:5: this_NEWLINE_7= RULE_NEWLINE
            	    {
            	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE4164); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_7, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);

            otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleASN1_CHOICE4177); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getASN1_CHOICEAccess().getRightCurlyBracketKeyword_6());
                  
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1911:1: entryRuleASN1_CHOICE_ENTRY returns [EObject current=null] : iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF ;
    public final EObject entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE_ENTRY = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1912:2: (iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1913:2: iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY4213);
            iv_ruleASN1_CHOICE_ENTRY=ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE_ENTRY; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY4223); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1920:1: ruleASN1_CHOICE_ENTRY returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) ) ;
    public final EObject ruleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token this_NEWLINE_1=null;
        EObject lv_valueType_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1923:28: ( ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1924:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1924:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1924:2: ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1924:2: ( (lv_id_0_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1925:1: (lv_id_0_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1925:1: (lv_id_0_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1926:3: lv_id_0_0= RULE_ASN1_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY4265); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1942:2: (this_NEWLINE_1= RULE_NEWLINE )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_NEWLINE) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1942:3: this_NEWLINE_1= RULE_NEWLINE
                    {
                    this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE_ENTRY4282); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_1, grammarAccess.getASN1_CHOICE_ENTRYAccess().getNEWLINETerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1946:3: ( (lv_valueType_2_0= ruleChoiceType ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1947:1: (lv_valueType_2_0= ruleChoiceType )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1947:1: (lv_valueType_2_0= ruleChoiceType )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1948:3: lv_valueType_2_0= ruleChoiceType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeChoiceTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleChoiceType_in_ruleASN1_CHOICE_ENTRY4304);
            lv_valueType_2_0=ruleChoiceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getASN1_CHOICE_ENTRYRule());
              	        }
                     		set(
                     			current, 
                     			"valueType",
                      		lv_valueType_2_0, 
                      		"ChoiceType");
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
    // $ANTLR end "ruleASN1_CHOICE_ENTRY"


    // $ANTLR start "entryRuleChoiceType"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1972:1: entryRuleChoiceType returns [EObject current=null] : iv_ruleChoiceType= ruleChoiceType EOF ;
    public final EObject entryRuleChoiceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoiceType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1973:2: (iv_ruleChoiceType= ruleChoiceType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1974:2: iv_ruleChoiceType= ruleChoiceType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getChoiceTypeRule()); 
            }
            pushFollow(FOLLOW_ruleChoiceType_in_entryRuleChoiceType4340);
            iv_ruleChoiceType=ruleChoiceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleChoiceType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoiceType4350); if (state.failed) return current;

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
    // $ANTLR end "entryRuleChoiceType"


    // $ANTLR start "ruleChoiceType"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1981:1: ruleChoiceType returns [EObject current=null] : ( ( (lv_typeRef_0_0= ruleTypeReference ) ) | ( (lv_simpleType_1_0= ruleASN1_TYPE ) ) | ( (lv_oi_2_0= 'OBJECT IDENTIFIER' ) ) ) ;
    public final EObject ruleChoiceType() throws RecognitionException {
        EObject current = null;

        Token lv_oi_2_0=null;
        EObject lv_typeRef_0_0 = null;

        EObject lv_simpleType_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1984:28: ( ( ( (lv_typeRef_0_0= ruleTypeReference ) ) | ( (lv_simpleType_1_0= ruleASN1_TYPE ) ) | ( (lv_oi_2_0= 'OBJECT IDENTIFIER' ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1985:1: ( ( (lv_typeRef_0_0= ruleTypeReference ) ) | ( (lv_simpleType_1_0= ruleASN1_TYPE ) ) | ( (lv_oi_2_0= 'OBJECT IDENTIFIER' ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1985:1: ( ( (lv_typeRef_0_0= ruleTypeReference ) ) | ( (lv_simpleType_1_0= ruleASN1_TYPE ) ) | ( (lv_oi_2_0= 'OBJECT IDENTIFIER' ) ) )
            int alt39=3;
            switch ( input.LA(1) ) {
            case RULE_MODULE_ID:
                {
                alt39=1;
                }
                break;
            case RULE_IA5STRING:
            case 36:
            case 37:
            case 38:
            case 41:
                {
                alt39=2;
                }
                break;
            case 20:
                {
                alt39=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1985:2: ( (lv_typeRef_0_0= ruleTypeReference ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1985:2: ( (lv_typeRef_0_0= ruleTypeReference ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1986:1: (lv_typeRef_0_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1986:1: (lv_typeRef_0_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1987:3: lv_typeRef_0_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getChoiceTypeAccess().getTypeRefTypeReferenceParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleChoiceType4396);
                    lv_typeRef_0_0=ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getChoiceTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"typeRef",
                              		lv_typeRef_0_0, 
                              		"TypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2004:6: ( (lv_simpleType_1_0= ruleASN1_TYPE ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2004:6: ( (lv_simpleType_1_0= ruleASN1_TYPE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2005:1: (lv_simpleType_1_0= ruleASN1_TYPE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2005:1: (lv_simpleType_1_0= ruleASN1_TYPE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2006:3: lv_simpleType_1_0= ruleASN1_TYPE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getChoiceTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_TYPE_in_ruleChoiceType4423);
                    lv_simpleType_1_0=ruleASN1_TYPE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getChoiceTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"simpleType",
                              		lv_simpleType_1_0, 
                              		"ASN1_TYPE");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2023:6: ( (lv_oi_2_0= 'OBJECT IDENTIFIER' ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2023:6: ( (lv_oi_2_0= 'OBJECT IDENTIFIER' ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2024:1: (lv_oi_2_0= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2024:1: (lv_oi_2_0= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2025:3: lv_oi_2_0= 'OBJECT IDENTIFIER'
                    {
                    lv_oi_2_0=(Token)match(input,20,FOLLOW_20_in_ruleChoiceType4447); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_oi_2_0, grammarAccess.getChoiceTypeAccess().getOiOBJECTIDENTIFIERKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getChoiceTypeRule());
                      	        }
                             		setWithLastConsumed(current, "oi", lv_oi_2_0, "OBJECT IDENTIFIER");
                      	    
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
    // $ANTLR end "ruleChoiceType"

    // $ANTLR start synpred1_InternalSmi
    public final void synpred1_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:309:7: ( ( RULE_ASN1_ID ) )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:310:1: ( RULE_ASN1_ID )
        {
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:310:1: ( RULE_ASN1_ID )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:311:2: RULE_ASN1_ID
        {
        match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_synpred1_InternalSmi595); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalSmi

    // $ANTLR start synpred2_InternalSmi
    public final void synpred2_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:876:3: ( ( ruleTypeReference ) )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:877:1: ( ruleTypeReference )
        {
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:877:1: ( ruleTypeReference )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:878:1: ruleTypeReference
        {
        pushFollow(FOLLOW_ruleTypeReference_in_synpred2_InternalSmi1850);
        ruleTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalSmi

    // Delegated rules

    public final boolean synpred1_InternalSmi() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalSmi_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
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


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA1_eotS =
        "\10\uffff";
    static final String DFA1_eofS =
        "\10\uffff";
    static final String DFA1_minS =
        "\1\5\1\4\2\uffff\1\4\1\21\2\uffff";
    static final String DFA1_maxS =
        "\1\5\1\23\2\uffff\1\6\1\27\2\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\4\1\1\2\uffff\1\2\1\3";
    static final String DFA1_specialS =
        "\10\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1",
            "\1\5\1\4\1\3\14\uffff\1\2",
            "",
            "",
            "\1\5\1\4\1\3",
            "\1\6\5\uffff\1\7",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()+ loopback of 114:1: ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+";
        }
    }
    static final String DFA9_eotS =
        "\4\uffff";
    static final String DFA9_eofS =
        "\4\uffff";
    static final String DFA9_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA9_maxS =
        "\1\5\1\23\2\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA9_specialS =
        "\4\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1",
            "\1\2\1\1\15\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "()+ loopback of 523:2: ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+";
        }
    }
    static final String DFA12_eotS =
        "\4\uffff";
    static final String DFA12_eofS =
        "\1\2\3\uffff";
    static final String DFA12_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA12_maxS =
        "\1\5\1\36\2\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA12_specialS =
        "\4\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1",
            "\1\3\1\1\2\uffff\1\3\20\uffff\1\2\4\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "()+ loopback of 593:1: ( (lv_typeNotations_3_0= ruleTypeAssignment ) )+";
        }
    }
 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleModule127 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleModule144 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModule156 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleModule168 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleModule179 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_ruleModule200 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleModule227 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleMacro_in_ruleModule254 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleModule267 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleModule278 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleModule290 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier333 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifier343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleObjectIdentifier384 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifier402 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleObjectIdentifier419 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleObjectIdentifier431 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleObjectIdentifier443 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_ruleObjectIdentifier464 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleObjectIdentifier476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifierValue526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue569 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue612 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleObjectIdentifierValue631 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleObjectIdentifierValue653 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition695 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDefinition705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTypeDefinition742 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeDefinition760 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeDefinition777 = new BitSet(new long[]{0x0000027054100330L});
    public static final BitSet FOLLOW_ruleValue_in_ruleTypeDefinition798 = new BitSet(new long[]{0x0000027054100332L});
    public static final BitSet FOLLOW_ruleMacro_in_entryRuleMacro835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacro845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro882 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleMacro900 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleMacro917 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMacro929 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro940 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleMacro951 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_ruleMacro972 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueNotation_in_ruleMacro993 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleMacro1014 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro1027 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_19_in_ruleMacro1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation1076 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotation1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTypeNotation1123 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_24_in_ruleTypeNotation1142 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeNotation1167 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_ruleTypeNotation1188 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleValueNotation_in_entryRuleValueNotation1225 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNotation1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValueNotation1272 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_25_in_ruleValueNotation1291 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleValueNotation1316 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValueNotation1328 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleValueNotation1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment1386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAssignment1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTypeAssignment1433 = new BitSet(new long[]{0x0000000040000130L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleTypeAssignment1457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeAssignment1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleTypeAssignment1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment1547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamAssignment1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PARAMETER_in_ruleParamAssignment1599 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_ruleTypeNotationRight_in_ruleParamAssignment1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotationRight_in_entryRuleTypeNotationRight1661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotationRight1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeNotationRight1718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleTypeNotationRight1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt1780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReferenceExt1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1836 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_entryRuleTypeReference1904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReference1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeReference1958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTag_in_ruleValue2049 = new BitSet(new long[]{0x0000027054100330L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValue2062 = new BitSet(new long[]{0x0000027054100330L});
    public static final BitSet FOLLOW_26_in_ruleValue2081 = new BitSet(new long[]{0x0000027054100330L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue2116 = new BitSet(new long[]{0x0000000008000022L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValue2129 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleValue2142 = new BitSet(new long[]{0x0000027054100330L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue2163 = new BitSet(new long[]{0x0000000008000022L});
    public static final BitSet FOLLOW_ruleTag_in_entryRuleTag2201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTag2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTag2248 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTag2261 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleTag2278 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleTag2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType2331 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType2341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleValueType2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_ruleValueType2414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_ruleValueType2441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleValueType2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleValueType2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue2541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleMacroValue2597 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleMacroValue2609 = new BitSet(new long[]{0x0000000E00000000L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_ruleMacroValue2630 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleMacroValue2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE2678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE2688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_ruleMACRO_VALUE_TYPE2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleMACRO_VALUE_TYPE2753 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_ruleMACRO_VALUE_TYPE2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleMACRO_VALUE_TYPE2799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_entryRuleUpdateType2848 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpdateType2858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleUpdateType2895 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleUpdateType2916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP2952 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleMACRO_VALUE_CAP3009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleMACRO_VALUE_CAP3037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE3073 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE3083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE3130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE3192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleASN1_SIMPLE3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE3306 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE3326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE3356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING3391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING3401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleASN1_OCTET_STRING3453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER3502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleASN1_INTEGER3555 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_ruleASN1_INTEGER3581 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_INTEGER3602 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleASN1_INTEGER3614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE3652 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE3662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleASN1_SUBTYPE3699 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_SUBTYPE3711 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleASN1_SUBTYPE3723 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3744 = new BitSet(new long[]{0x0000000108000000L});
    public static final BitSet FOLLOW_27_in_ruleASN1_SUBTYPE3757 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3778 = new BitSet(new long[]{0x0000000108000000L});
    public static final BitSet FOLLOW_32_in_ruleASN1_SUBTYPE3792 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleASN1_SUBTYPE3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE3840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE3850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE3932 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleASN1_RANGE3949 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE3966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE4010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE4020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleASN1_CHOICE4057 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleASN1_CHOICE4069 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE4081 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE4103 = new BitSet(new long[]{0x0000040000000020L});
    public static final BitSet FOLLOW_42_in_ruleASN1_CHOICE4116 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE4128 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE4150 = new BitSet(new long[]{0x0000040000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE4164 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_22_in_ruleASN1_CHOICE4177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY4213 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY4265 = new BitSet(new long[]{0x0000027000100230L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE_ENTRY4282 = new BitSet(new long[]{0x0000027000100230L});
    public static final BitSet FOLLOW_ruleChoiceType_in_ruleASN1_CHOICE_ENTRY4304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoiceType_in_entryRuleChoiceType4340 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoiceType4350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleChoiceType4396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_ruleChoiceType4423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleChoiceType4447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_synpred1_InternalSmi595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_synpred2_InternalSmi1850 = new BitSet(new long[]{0x0000000000000002L});

}