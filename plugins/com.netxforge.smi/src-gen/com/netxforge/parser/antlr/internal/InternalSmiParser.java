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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_MODULE_ID", "RULE_NEWLINE", "RULE_ASN1_ID", "RULE_INT", "RULE_PARAMETER", "RULE_IA5STRING", "RULE_ALPHA_CAP", "RULE_ALPHA", "RULE_NUMERIC", "RULE_SL_ASN1_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'DEFINITIONS'", "'::='", "'BEGIN'", "'END'", "'OBJECT IDENTIFIER'", "'{'", "'}'", "'MACRO'", "'TYPE NOTATION'", "'VALUE NOTATION'", "'|'", "'value'", "'('", "')'", "'Update'", "'VALUE OBJECT IDENTIFIER'", "'IA5String'", "'empty'", "'OCTET STRING'", "'INTEGER'", "'SIZE'", "'..'", "'CHOICE'", "','"
    };
    public static final int RULE_NEWLINE=5;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:286:1: ruleObjectIdentifierValue returns [EObject current=null] : ( ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* ) ;
    public final EObject ruleObjectIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_root_0_0=null;
        Token otherlv_1=null;
        Token lv_subIds_2_0=null;
        Token lv_subIds_3_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:289:28: ( ( ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:1: ( ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:1: ( ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:2: ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:2: ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )?
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:3: ( (lv_root_0_0= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:290:3: ( (lv_root_0_0= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:291:1: (lv_root_0_0= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:291:1: (lv_root_0_0= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:292:3: lv_root_0_0= RULE_ASN1_ID
                    {
                    lv_root_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_root_0_0, grammarAccess.getObjectIdentifierValueAccess().getRootASN1_IDTerminalRuleCall_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"root",
                              		lv_root_0_0, 
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:327:4: ( (lv_subIds_2_0= RULE_INT ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:328:1: (lv_subIds_2_0= RULE_INT )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:328:1: (lv_subIds_2_0= RULE_INT )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:329:3: lv_subIds_2_0= RULE_INT
            {
            lv_subIds_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleObjectIdentifierValue631); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:345:2: ( (lv_subIds_3_0= RULE_INT ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_INT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:346:1: (lv_subIds_3_0= RULE_INT )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:346:1: (lv_subIds_3_0= RULE_INT )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:347:3: lv_subIds_3_0= RULE_INT
            	    {
            	    lv_subIds_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleObjectIdentifierValue653); if (state.failed) return current;
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

                        if ( (LA7_4==EOF||(LA7_4>=RULE_MODULE_ID && LA7_4<=RULE_NEWLINE)||(LA7_4>=RULE_PARAMETER && LA7_4<=RULE_IA5STRING)||LA7_4==20||(LA7_4>=26 && LA7_4<=27)||(LA7_4>=33 && LA7_4<=35)||LA7_4==38) ) {
                            alt7=1;
                        }


                    }
                    else if ( ((LA7_1>=RULE_PARAMETER && LA7_1<=RULE_IA5STRING)||LA7_1==20||LA7_1==27||(LA7_1>=33 && LA7_1<=35)||LA7_1==38) ) {
                        alt7=1;
                    }


                }
                else if ( (LA7_0==RULE_MODULE_ID||(LA7_0>=RULE_PARAMETER && LA7_0<=RULE_IA5STRING)||LA7_0==20||LA7_0==27||(LA7_0>=33 && LA7_0<=35)||LA7_0==38) ) {
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:445:1: ruleMacro returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_NEWLINE_4= RULE_NEWLINE otherlv_5= 'BEGIN' (this_NEWLINE_6= RULE_NEWLINE )+ otherlv_7= 'TYPE NOTATION' otherlv_8= '::=' ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+ (this_NEWLINE_10= RULE_NEWLINE )+ otherlv_11= 'VALUE NOTATION' otherlv_12= '::=' (this_NEWLINE_13= RULE_NEWLINE )? ( (lv_valueNotation_14_0= ruleMacroValue ) ) ( (lv_innerTypes_15_0= ruleTypeDefinition ) )+ (this_NEWLINE_16= RULE_NEWLINE )+ otherlv_17= 'END' ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_NEWLINE_4=null;
        Token otherlv_5=null;
        Token this_NEWLINE_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token this_NEWLINE_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token this_NEWLINE_13=null;
        Token this_NEWLINE_16=null;
        Token otherlv_17=null;
        EObject lv_typeNotations_9_0 = null;

        EObject lv_valueNotation_14_0 = null;

        EObject lv_innerTypes_15_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:448:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_NEWLINE_4= RULE_NEWLINE otherlv_5= 'BEGIN' (this_NEWLINE_6= RULE_NEWLINE )+ otherlv_7= 'TYPE NOTATION' otherlv_8= '::=' ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+ (this_NEWLINE_10= RULE_NEWLINE )+ otherlv_11= 'VALUE NOTATION' otherlv_12= '::=' (this_NEWLINE_13= RULE_NEWLINE )? ( (lv_valueNotation_14_0= ruleMacroValue ) ) ( (lv_innerTypes_15_0= ruleTypeDefinition ) )+ (this_NEWLINE_16= RULE_NEWLINE )+ otherlv_17= 'END' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:449:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_NEWLINE_4= RULE_NEWLINE otherlv_5= 'BEGIN' (this_NEWLINE_6= RULE_NEWLINE )+ otherlv_7= 'TYPE NOTATION' otherlv_8= '::=' ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+ (this_NEWLINE_10= RULE_NEWLINE )+ otherlv_11= 'VALUE NOTATION' otherlv_12= '::=' (this_NEWLINE_13= RULE_NEWLINE )? ( (lv_valueNotation_14_0= ruleMacroValue ) ) ( (lv_innerTypes_15_0= ruleTypeDefinition ) )+ (this_NEWLINE_16= RULE_NEWLINE )+ otherlv_17= 'END' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:449:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_NEWLINE_4= RULE_NEWLINE otherlv_5= 'BEGIN' (this_NEWLINE_6= RULE_NEWLINE )+ otherlv_7= 'TYPE NOTATION' otherlv_8= '::=' ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+ (this_NEWLINE_10= RULE_NEWLINE )+ otherlv_11= 'VALUE NOTATION' otherlv_12= '::=' (this_NEWLINE_13= RULE_NEWLINE )? ( (lv_valueNotation_14_0= ruleMacroValue ) ) ( (lv_innerTypes_15_0= ruleTypeDefinition ) )+ (this_NEWLINE_16= RULE_NEWLINE )+ otherlv_17= 'END' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:449:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_NEWLINE_4= RULE_NEWLINE otherlv_5= 'BEGIN' (this_NEWLINE_6= RULE_NEWLINE )+ otherlv_7= 'TYPE NOTATION' otherlv_8= '::=' ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+ (this_NEWLINE_10= RULE_NEWLINE )+ otherlv_11= 'VALUE NOTATION' otherlv_12= '::=' (this_NEWLINE_13= RULE_NEWLINE )? ( (lv_valueNotation_14_0= ruleMacroValue ) ) ( (lv_innerTypes_15_0= ruleTypeDefinition ) )+ (this_NEWLINE_16= RULE_NEWLINE )+ otherlv_17= 'END'
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:487:1: (this_NEWLINE_6= RULE_NEWLINE )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_NEWLINE) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:487:2: this_NEWLINE_6= RULE_NEWLINE
            	    {
            	    this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro963); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_6, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_6()); 
            	          
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

            otherlv_7=(Token)match(input,24,FOLLOW_24_in_ruleMacro976); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMacroAccess().getTYPENOTATIONKeyword_7());
                  
            }
            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleMacro988); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_8());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:499:1: ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:500:1: (lv_typeNotations_9_0= ruleTypeAssignment )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:500:1: (lv_typeNotations_9_0= ruleTypeAssignment )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:501:3: lv_typeNotations_9_0= ruleTypeAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMacroAccess().getTypeNotationsTypeAssignmentParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeAssignment_in_ruleMacro1009);
            	    lv_typeNotations_9_0=ruleTypeAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMacroRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"typeNotations",
            	              		lv_typeNotations_9_0, 
            	              		"TypeAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:517:3: (this_NEWLINE_10= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:517:4: this_NEWLINE_10= RULE_NEWLINE
            	    {
            	    this_NEWLINE_10=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro1022); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_10, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_10()); 
            	          
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

            otherlv_11=(Token)match(input,25,FOLLOW_25_in_ruleMacro1035); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getMacroAccess().getVALUENOTATIONKeyword_11());
                  
            }
            otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleMacro1047); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_12());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:529:1: (this_NEWLINE_13= RULE_NEWLINE )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_NEWLINE) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:529:2: this_NEWLINE_13= RULE_NEWLINE
                    {
                    this_NEWLINE_13=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro1059); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_13, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_13()); 
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:533:3: ( (lv_valueNotation_14_0= ruleMacroValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:534:1: (lv_valueNotation_14_0= ruleMacroValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:534:1: (lv_valueNotation_14_0= ruleMacroValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:535:3: lv_valueNotation_14_0= ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_14_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMacroValue_in_ruleMacro1081);
            lv_valueNotation_14_0=ruleMacroValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMacroRule());
              	        }
                     		set(
                     			current, 
                     			"valueNotation",
                      		lv_valueNotation_14_0, 
                      		"MacroValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:551:2: ( (lv_innerTypes_15_0= ruleTypeDefinition ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                alt13 = dfa13.predict(input);
                switch (alt13) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:552:1: (lv_innerTypes_15_0= ruleTypeDefinition )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:552:1: (lv_innerTypes_15_0= ruleTypeDefinition )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:553:3: lv_innerTypes_15_0= ruleTypeDefinition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_15_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleMacro1102);
            	    lv_innerTypes_15_0=ruleTypeDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMacroRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"innerTypes",
            	              		lv_innerTypes_15_0, 
            	              		"TypeDefinition");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:569:3: (this_NEWLINE_16= RULE_NEWLINE )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_NEWLINE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:569:4: this_NEWLINE_16= RULE_NEWLINE
            	    {
            	    this_NEWLINE_16=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro1115); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_16, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_16()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            otherlv_17=(Token)match(input,19,FOLLOW_19_in_ruleMacro1128); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_17, grammarAccess.getMacroAccess().getENDKeyword_17());
                  
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:585:1: entryRuleTypeAssignment returns [EObject current=null] : iv_ruleTypeAssignment= ruleTypeAssignment EOF ;
    public final EObject entryRuleTypeAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:586:2: (iv_ruleTypeAssignment= ruleTypeAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:587:2: iv_ruleTypeAssignment= ruleTypeAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment1164);
            iv_ruleTypeAssignment=ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAssignment1174); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:594:1: ruleTypeAssignment returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) ) ;
    public final EObject ruleTypeAssignment() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        EObject this_ParamAssignment_1 = null;

        EObject this_TypeReference_2 = null;

        EObject this_MacroValue_3 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:597:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:598:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:598:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:598:2: (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:598:2: (this_NEWLINE_0= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:598:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTypeAssignment1211); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:602:3: (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue )
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
            case 27:
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:603:5: this_ParamAssignment_1= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleTypeAssignment1235);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:613:5: this_TypeReference_2= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeAssignment1262);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:623:5: this_MacroValue_3= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getMacroValueParserRuleCall_1_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleTypeAssignment1289);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:639:1: entryRuleParamAssignment returns [EObject current=null] : iv_ruleParamAssignment= ruleParamAssignment EOF ;
    public final EObject entryRuleParamAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:640:2: (iv_ruleParamAssignment= ruleParamAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:641:2: iv_ruleParamAssignment= ruleParamAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment1325);
            iv_ruleParamAssignment=ruleParamAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamAssignment1335); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:648:1: ruleParamAssignment returns [EObject current=null] : ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotation ) ) ) ;
    public final EObject ruleParamAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_param_0_0=null;
        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:651:28: ( ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotation ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:652:1: ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotation ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:652:1: ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotation ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:652:2: ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotation ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:652:2: ( (lv_param_0_0= RULE_PARAMETER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:653:1: (lv_param_0_0= RULE_PARAMETER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:653:1: (lv_param_0_0= RULE_PARAMETER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:654:3: lv_param_0_0= RULE_PARAMETER
            {
            lv_param_0_0=(Token)match(input,RULE_PARAMETER,FOLLOW_RULE_PARAMETER_in_ruleParamAssignment1377); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:670:2: ( (lv_right_1_0= ruleTypeNotation ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:671:1: (lv_right_1_0= ruleTypeNotation )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:671:1: (lv_right_1_0= ruleTypeNotation )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:672:3: lv_right_1_0= ruleTypeNotation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAssignmentAccess().getRightTypeNotationParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_ruleParamAssignment1403);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:696:1: entryRuleTypeNotation returns [EObject current=null] : iv_ruleTypeNotation= ruleTypeNotation EOF ;
    public final EObject entryRuleTypeNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNotation = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:697:2: (iv_ruleTypeNotation= ruleTypeNotation EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:698:2: iv_ruleTypeNotation= ruleTypeNotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNotationRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation1439);
            iv_ruleTypeNotation=ruleTypeNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNotation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotation1449); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:705:1: ruleTypeNotation returns [EObject current=null] : (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) ;
    public final EObject ruleTypeNotation() throws RecognitionException {
        EObject current = null;

        EObject this_TypeReference_0 = null;

        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:708:28: ( (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:709:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:709:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_MODULE_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==27) ) {
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:710:5: this_TypeReference_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeNotationAccess().getTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeNotation1496);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:719:6: ( (lv_value_1_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:719:6: ( (lv_value_1_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:720:1: (lv_value_1_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:720:1: (lv_value_1_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:721:3: lv_value_1_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNotationAccess().getValueMacroValueParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleTypeNotation1522);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:745:1: entryRuleTypeReferenceExt returns [EObject current=null] : iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF ;
    public final EObject entryRuleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReferenceExt = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:746:2: (iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:747:2: iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceExtRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt1558);
            iv_ruleTypeReferenceExt=ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReferenceExt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReferenceExt1568); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:754:1: ruleTypeReferenceExt returns [EObject current=null] : ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? ) ;
    public final EObject ruleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject lv_parentRef_0_0 = null;

        EObject lv_childRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:757:28: ( ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:758:1: ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:758:1: ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:758:2: ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:758:2: ( (lv_parentRef_0_0= ruleTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:759:1: (lv_parentRef_0_0= ruleTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:759:1: (lv_parentRef_0_0= ruleTypeReference )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:760:3: lv_parentRef_0_0= ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getParentRefTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1614);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:776:2: ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:776:3: ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:781:1: (lv_childRef_1_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:782:3: lv_childRef_1_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getChildRefTypeReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1645);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:806:1: entryRuleTypeReference returns [EObject current=null] : iv_ruleTypeReference= ruleTypeReference EOF ;
    public final EObject entryRuleTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReference = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:807:2: (iv_ruleTypeReference= ruleTypeReference EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:808:2: iv_ruleTypeReference= ruleTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_entryRuleTypeReference1682);
            iv_ruleTypeReference=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReference1692); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:815:1: ruleTypeReference returns [EObject current=null] : ( (otherlv_0= RULE_MODULE_ID ) ) ;
    public final EObject ruleTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:818:28: ( ( (otherlv_0= RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:819:1: ( (otherlv_0= RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:819:1: ( (otherlv_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:820:1: (otherlv_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:820:1: (otherlv_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:821:3: otherlv_0= RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeReferenceRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleTypeReference1736); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:840:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:841:2: (iv_ruleValue= ruleValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:842:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue1771);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue1781); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:849:1: ruleValue returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueTypes_1_0= ruleValueType ) ) ( (this_NEWLINE_2= RULE_NEWLINE )? otherlv_3= '|' ( (lv_valueTypes_4_0= ruleValueType ) ) )* ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token this_NEWLINE_2=null;
        Token otherlv_3=null;
        EObject lv_valueTypes_1_0 = null;

        EObject lv_valueTypes_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:852:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueTypes_1_0= ruleValueType ) ) ( (this_NEWLINE_2= RULE_NEWLINE )? otherlv_3= '|' ( (lv_valueTypes_4_0= ruleValueType ) ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:853:1: ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueTypes_1_0= ruleValueType ) ) ( (this_NEWLINE_2= RULE_NEWLINE )? otherlv_3= '|' ( (lv_valueTypes_4_0= ruleValueType ) ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:853:1: ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueTypes_1_0= ruleValueType ) ) ( (this_NEWLINE_2= RULE_NEWLINE )? otherlv_3= '|' ( (lv_valueTypes_4_0= ruleValueType ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:853:2: (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueTypes_1_0= ruleValueType ) ) ( (this_NEWLINE_2= RULE_NEWLINE )? otherlv_3= '|' ( (lv_valueTypes_4_0= ruleValueType ) ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:853:2: (this_NEWLINE_0= RULE_NEWLINE )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_NEWLINE) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:853:3: this_NEWLINE_0= RULE_NEWLINE
                    {
                    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValue1818); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_0, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_0()); 
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:857:3: ( (lv_valueTypes_1_0= ruleValueType ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:858:1: (lv_valueTypes_1_0= ruleValueType )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:858:1: (lv_valueTypes_1_0= ruleValueType )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:859:3: lv_valueTypes_1_0= ruleValueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValueType_in_ruleValue1840);
            lv_valueTypes_1_0=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueRule());
              	        }
                     		add(
                     			current, 
                     			"valueTypes",
                      		lv_valueTypes_1_0, 
                      		"ValueType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:875:2: ( (this_NEWLINE_2= RULE_NEWLINE )? otherlv_3= '|' ( (lv_valueTypes_4_0= ruleValueType ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_NEWLINE) ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1==26) ) {
                        alt21=1;
                    }


                }
                else if ( (LA21_0==26) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:875:3: (this_NEWLINE_2= RULE_NEWLINE )? otherlv_3= '|' ( (lv_valueTypes_4_0= ruleValueType ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:875:3: (this_NEWLINE_2= RULE_NEWLINE )?
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==RULE_NEWLINE) ) {
            	        alt20=1;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:875:4: this_NEWLINE_2= RULE_NEWLINE
            	            {
            	            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValue1853); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {
            	               
            	                  newLeafNode(this_NEWLINE_2, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_2_0()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleValue1866); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getValueAccess().getVerticalLineKeyword_2_1());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:883:1: ( (lv_valueTypes_4_0= ruleValueType ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:884:1: (lv_valueTypes_4_0= ruleValueType )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:884:1: (lv_valueTypes_4_0= ruleValueType )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:885:3: lv_valueTypes_4_0= ruleValueType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_2_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValueType_in_ruleValue1887);
            	    lv_valueTypes_4_0=ruleValueType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getValueRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"valueTypes",
            	              		lv_valueTypes_4_0, 
            	              		"ValueType");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:909:1: entryRuleValueType returns [EObject current=null] : iv_ruleValueType= ruleValueType EOF ;
    public final EObject entryRuleValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:910:2: (iv_ruleValueType= ruleValueType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:911:2: iv_ruleValueType= ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType1925);
            iv_ruleValueType=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType1935); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:918:1: ruleValueType returns [EObject current=null] : ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_types_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) ) ;
    public final EObject ruleValueType() throws RecognitionException {
        EObject current = null;

        Token lv_oi_4_0=null;
        EObject lv_param_0_0 = null;

        EObject lv_types_1_0 = null;

        EObject lv_simpleType_2_0 = null;

        EObject lv_macroValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:921:28: ( ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_types_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:922:1: ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_types_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:922:1: ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_types_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) )
            int alt22=5;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt22=1;
                }
                break;
            case RULE_MODULE_ID:
                {
                alt22=2;
                }
                break;
            case RULE_IA5STRING:
            case 33:
            case 34:
            case 35:
            case 38:
                {
                alt22=3;
                }
                break;
            case 27:
                {
                alt22=4;
                }
                break;
            case 20:
                {
                alt22=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:922:2: ( (lv_param_0_0= ruleParamAssignment ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:922:2: ( (lv_param_0_0= ruleParamAssignment ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:923:1: (lv_param_0_0= ruleParamAssignment )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:923:1: (lv_param_0_0= ruleParamAssignment )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:924:3: lv_param_0_0= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleValueType1981);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:941:6: ( (lv_types_1_0= ruleTypeReferenceExt ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:941:6: ( (lv_types_1_0= ruleTypeReferenceExt ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:942:1: (lv_types_1_0= ruleTypeReferenceExt )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:942:1: (lv_types_1_0= ruleTypeReferenceExt )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:943:3: lv_types_1_0= ruleTypeReferenceExt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getTypesTypeReferenceExtParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReferenceExt_in_ruleValueType2008);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:960:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:960:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:961:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:961:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:962:3: lv_simpleType_2_0= ruleASN1_TYPE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_TYPE_in_ruleValueType2035);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:979:6: ( (lv_macroValue_3_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:979:6: ( (lv_macroValue_3_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:980:1: (lv_macroValue_3_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:980:1: (lv_macroValue_3_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:981:3: lv_macroValue_3_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleValueType2062);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:998:6: ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:998:6: ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:999:1: (lv_oi_4_0= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:999:1: (lv_oi_4_0= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1000:3: lv_oi_4_0= 'OBJECT IDENTIFIER'
                    {
                    lv_oi_4_0=(Token)match(input,20,FOLLOW_20_in_ruleValueType2086); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1021:1: entryRuleMacroValue returns [EObject current=null] : iv_ruleMacroValue= ruleMacroValue EOF ;
    public final EObject entryRuleMacroValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacroValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1022:2: (iv_ruleMacroValue= ruleMacroValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1023:2: iv_ruleMacroValue= ruleMacroValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroValueRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue2135);
            iv_ruleMacroValue=ruleMacroValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacroValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue2145); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1030:1: ruleMacroValue returns [EObject current=null] : ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' ) ;
    public final EObject ruleMacroValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_valueType_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1033:28: ( ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1034:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1034:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1034:2: () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1034:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1035:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getMacroValueAccess().getMacroValueAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleMacroValue2191); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMacroValueAccess().getValueKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleMacroValue2203); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMacroValueAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1048:1: ( (lv_valueType_3_0= ruleMACRO_VALUE_TYPE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1049:1: (lv_valueType_3_0= ruleMACRO_VALUE_TYPE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1049:1: (lv_valueType_3_0= ruleMACRO_VALUE_TYPE )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1050:3: lv_valueType_3_0= ruleMACRO_VALUE_TYPE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroValueAccess().getValueTypeMACRO_VALUE_TYPEParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_ruleMacroValue2224);
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

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleMacroValue2236); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1078:1: entryRuleMACRO_VALUE_TYPE returns [EObject current=null] : iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF ;
    public final EObject entryRuleMACRO_VALUE_TYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMACRO_VALUE_TYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1079:2: (iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1080:2: iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE2272);
            iv_ruleMACRO_VALUE_TYPE=ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMACRO_VALUE_TYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE2282); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1087:1: ruleMACRO_VALUE_TYPE returns [EObject current=null] : ( ( (lv_update_0_0= ruleUpdateType ) ) | ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) ) ) ;
    public final EObject ruleMACRO_VALUE_TYPE() throws RecognitionException {
        EObject current = null;

        EObject lv_update_0_0 = null;

        AntlrDatatypeRuleToken lv_literal_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1090:28: ( ( ( (lv_update_0_0= ruleUpdateType ) ) | ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1091:1: ( ( (lv_update_0_0= ruleUpdateType ) ) | ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1091:1: ( ( (lv_update_0_0= ruleUpdateType ) ) | ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                alt23=1;
            }
            else if ( ((LA23_0>=31 && LA23_0<=32)) ) {
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1091:2: ( (lv_update_0_0= ruleUpdateType ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1091:2: ( (lv_update_0_0= ruleUpdateType ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1092:1: (lv_update_0_0= ruleUpdateType )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1092:1: (lv_update_0_0= ruleUpdateType )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1093:3: lv_update_0_0= ruleUpdateType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateUpdateTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUpdateType_in_ruleMACRO_VALUE_TYPE2328);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1110:6: ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1110:6: ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1111:1: (lv_literal_1_0= ruleMACRO_VALUE_CAP )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1111:1: (lv_literal_1_0= ruleMACRO_VALUE_CAP )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1112:3: lv_literal_1_0= ruleMACRO_VALUE_CAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralMACRO_VALUE_CAPParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_ruleMACRO_VALUE_TYPE2355);
                    lv_literal_1_0=ruleMACRO_VALUE_CAP();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMACRO_VALUE_TYPERule());
                      	        }
                             		set(
                             			current, 
                             			"literal",
                              		lv_literal_1_0, 
                              		"MACRO_VALUE_CAP");
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1136:1: entryRuleUpdateType returns [EObject current=null] : iv_ruleUpdateType= ruleUpdateType EOF ;
    public final EObject entryRuleUpdateType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdateType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1137:2: (iv_ruleUpdateType= ruleUpdateType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1138:2: iv_ruleUpdateType= ruleUpdateType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUpdateTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_entryRuleUpdateType2391);
            iv_ruleUpdateType=ruleUpdateType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUpdateType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpdateType2401); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1145:1: ruleUpdateType returns [EObject current=null] : (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) ) ;
    public final EObject ruleUpdateType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1148:28: ( (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1149:1: (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1149:1: (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1149:3: otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleUpdateType2438); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getUpdateTypeAccess().getUpdateKeyword_0());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1153:1: ( (otherlv_1= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1154:1: (otherlv_1= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1154:1: (otherlv_1= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1155:3: otherlv_1= RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getUpdateTypeRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleUpdateType2458); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1174:1: entryRuleMACRO_VALUE_CAP returns [String current=null] : iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF ;
    public final String entryRuleMACRO_VALUE_CAP() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMACRO_VALUE_CAP = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1175:2: (iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1176:2: iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP2495);
            iv_ruleMACRO_VALUE_CAP=ruleMACRO_VALUE_CAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMACRO_VALUE_CAP.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP2506); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1183:1: ruleMACRO_VALUE_CAP returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'VALUE OBJECT IDENTIFIER' | kw= 'IA5String' ) ;
    public final AntlrDatatypeRuleToken ruleMACRO_VALUE_CAP() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1186:28: ( (kw= 'VALUE OBJECT IDENTIFIER' | kw= 'IA5String' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1187:1: (kw= 'VALUE OBJECT IDENTIFIER' | kw= 'IA5String' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1187:1: (kw= 'VALUE OBJECT IDENTIFIER' | kw= 'IA5String' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==31) ) {
                alt24=1;
            }
            else if ( (LA24_0==32) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1188:2: kw= 'VALUE OBJECT IDENTIFIER'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleMACRO_VALUE_CAP2544); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMACRO_VALUE_CAPAccess().getVALUEOBJECTIDENTIFIERKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1195:2: kw= 'IA5String'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleMACRO_VALUE_CAP2563); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMACRO_VALUE_CAPAccess().getIA5StringKeyword_1()); 
                          
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1208:1: entryRuleASN1_TYPE returns [EObject current=null] : iv_ruleASN1_TYPE= ruleASN1_TYPE EOF ;
    public final EObject entryRuleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_TYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1209:2: (iv_ruleASN1_TYPE= ruleASN1_TYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1210:2: iv_ruleASN1_TYPE= ruleASN1_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE2603);
            iv_ruleASN1_TYPE=ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_TYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE2613); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1217:1: ruleASN1_TYPE returns [EObject current=null] : (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE ) ;
    public final EObject ruleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject this_ASN1_SIMPLE_0 = null;

        EObject this_ASN1_CHOICE_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1220:28: ( (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1221:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1221:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_IA5STRING||(LA25_0>=33 && LA25_0<=35)) ) {
                alt25=1;
            }
            else if ( (LA25_0==38) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1222:5: this_ASN1_SIMPLE_0= ruleASN1_SIMPLE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE2660);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1232:5: this_ASN1_CHOICE_1= ruleASN1_CHOICE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE2687);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1248:1: entryRuleASN1_SIMPLE returns [EObject current=null] : iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF ;
    public final EObject entryRuleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SIMPLE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1249:2: (iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1250:2: iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SIMPLERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE2722);
            iv_ruleASN1_SIMPLE=ruleASN1_SIMPLE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SIMPLE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE2732); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1257:1: ruleASN1_SIMPLE returns [EObject current=null] : ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1260:28: ( ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1261:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1261:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) )
            int alt28=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt28=1;
                }
                break;
            case RULE_IA5STRING:
                {
                alt28=2;
                }
                break;
            case 34:
                {
                alt28=3;
                }
                break;
            case 35:
                {
                alt28=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1261:2: ( () otherlv_1= 'empty' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1261:2: ( () otherlv_1= 'empty' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1261:3: () otherlv_1= 'empty'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1261:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1262:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleASN1_SIMPLE2779); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1272:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1272:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1272:7: () this_IA5STRING_3= RULE_IA5STRING
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1272:7: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1273:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_1_0(),
                                  current);
                          
                    }

                    }

                    this_IA5STRING_3=(Token)match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE2807); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_IA5STRING_3, grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1283:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1283:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1284:5: this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE2836);
                    this_ASN1_OCTET_STRING_4=ruleASN1_OCTET_STRING();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_OCTET_STRING_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1292:1: ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==28) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1293:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1293:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1294:3: lv_constraint_5_0= ruleASN1_SUBTYPE
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE2856);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1311:6: (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1311:6: (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1312:5: this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE2887);
                    this_ASN1_INTEGER_6=ruleASN1_INTEGER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_INTEGER_6; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1320:1: ( (lv_constraint_7_0= ruleASN1_RANGE ) )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==RULE_INT) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1321:1: (lv_constraint_7_0= ruleASN1_RANGE )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1321:1: (lv_constraint_7_0= ruleASN1_RANGE )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1322:3: lv_constraint_7_0= ruleASN1_RANGE
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_RANGEParserRuleCall_3_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SIMPLE2907);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1346:1: entryRuleASN1_OCTET_STRING returns [EObject current=null] : iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF ;
    public final EObject entryRuleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_OCTET_STRING = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1347:2: (iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1348:2: iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING2945);
            iv_ruleASN1_OCTET_STRING=ruleASN1_OCTET_STRING();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_OCTET_STRING; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING2955); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1355:1: ruleASN1_OCTET_STRING returns [EObject current=null] : ( () ( (lv_name_1_0= 'OCTET STRING' ) ) ) ;
    public final EObject ruleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1358:28: ( ( () ( (lv_name_1_0= 'OCTET STRING' ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1359:1: ( () ( (lv_name_1_0= 'OCTET STRING' ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1359:1: ( () ( (lv_name_1_0= 'OCTET STRING' ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1359:2: () ( (lv_name_1_0= 'OCTET STRING' ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1359:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1360:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1365:2: ( (lv_name_1_0= 'OCTET STRING' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1366:1: (lv_name_1_0= 'OCTET STRING' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1366:1: (lv_name_1_0= 'OCTET STRING' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1367:3: lv_name_1_0= 'OCTET STRING'
            {
            lv_name_1_0=(Token)match(input,34,FOLLOW_34_in_ruleASN1_OCTET_STRING3007); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1388:1: entryRuleASN1_INTEGER returns [EObject current=null] : iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF ;
    public final EObject entryRuleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_INTEGER = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1389:2: (iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1390:2: iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_INTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER3056);
            iv_ruleASN1_INTEGER=ruleASN1_INTEGER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_INTEGER; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER3066); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1397:1: ruleASN1_INTEGER returns [EObject current=null] : ( ( (lv_name_0_0= 'INTEGER' ) ) otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' ) ;
    public final EObject ruleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_valuePairs_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1400:28: ( ( ( (lv_name_0_0= 'INTEGER' ) ) otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1401:1: ( ( (lv_name_0_0= 'INTEGER' ) ) otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1401:1: ( ( (lv_name_0_0= 'INTEGER' ) ) otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1401:2: ( (lv_name_0_0= 'INTEGER' ) ) otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1401:2: ( (lv_name_0_0= 'INTEGER' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1402:1: (lv_name_0_0= 'INTEGER' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1402:1: (lv_name_0_0= 'INTEGER' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1403:3: lv_name_0_0= 'INTEGER'
            {
            lv_name_0_0=(Token)match(input,35,FOLLOW_35_in_ruleASN1_INTEGER3109); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleASN1_INTEGER3134); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_INTEGERAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1420:1: ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ASN1_ID||LA29_0==28) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1421:1: (lv_valuePairs_2_0= ruleASN1_VALUEPAIR )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1421:1: (lv_valuePairs_2_0= ruleASN1_VALUEPAIR )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1422:3: lv_valuePairs_2_0= ruleASN1_VALUEPAIR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_INTEGERAccess().getValuePairsASN1_VALUEPAIRParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_ruleASN1_INTEGER3155);
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
            	    if ( cnt29 >= 1 ) break loop29;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleASN1_INTEGER3168); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1450:1: entryRuleASN1_SUBTYPE returns [EObject current=null] : iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF ;
    public final EObject entryRuleASN1_SUBTYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SUBTYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1451:2: (iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1452:2: iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SUBTYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE3204);
            iv_ruleASN1_SUBTYPE=ruleASN1_SUBTYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SUBTYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE3214); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1459:1: ruleASN1_SUBTYPE returns [EObject current=null] : (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1462:28: ( (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1463:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1463:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1463:3: otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleASN1_SUBTYPE3251); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleASN1_SUBTYPE3263); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleASN1_SUBTYPE3275); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1475:1: ( (lv_ranges_3_0= ruleASN1_RANGE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1476:1: (lv_ranges_3_0= ruleASN1_RANGE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1476:1: (lv_ranges_3_0= ruleASN1_RANGE )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1477:3: lv_ranges_3_0= ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3296);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1493:2: (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==26) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1493:4: otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    {
            	    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleASN1_SUBTYPE3309); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getASN1_SUBTYPEAccess().getVerticalLineKeyword_4_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1497:1: ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1498:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1498:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1499:3: lv_ranges_5_0= ruleASN1_RANGE
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3330);
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
            	    break loop30;
                }
            } while (true);

            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleASN1_SUBTYPE3344); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,29,FOLLOW_29_in_ruleASN1_SUBTYPE3356); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1531:1: entryRuleASN1_RANGE returns [EObject current=null] : iv_ruleASN1_RANGE= ruleASN1_RANGE EOF ;
    public final EObject entryRuleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_RANGE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1532:2: (iv_ruleASN1_RANGE= ruleASN1_RANGE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1533:2: iv_ruleASN1_RANGE= ruleASN1_RANGE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_RANGERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE3392);
            iv_ruleASN1_RANGE=ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_RANGE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE3402); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1540:1: ruleASN1_RANGE returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) ) ;
    public final EObject ruleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_start_2_0=null;
        Token otherlv_3=null;
        Token lv_end_4_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1543:28: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1544:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1544:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_INT) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==EOF||(LA31_1>=RULE_MODULE_ID && LA31_1<=RULE_NEWLINE)||(LA31_1>=RULE_PARAMETER && LA31_1<=RULE_IA5STRING)||LA31_1==20||(LA31_1>=26 && LA31_1<=27)||LA31_1==29||(LA31_1>=33 && LA31_1<=35)||LA31_1==38) ) {
                    alt31=1;
                }
                else if ( (LA31_1==37) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1544:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1544:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1544:3: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1544:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1545:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1550:2: ( (lv_value_1_0= RULE_INT ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1551:1: (lv_value_1_0= RULE_INT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1551:1: (lv_value_1_0= RULE_INT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1552:3: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_RANGE3454); if (state.failed) return current;
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1569:6: ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1569:6: ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1569:7: ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1569:7: ( (lv_start_2_0= RULE_INT ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1570:1: (lv_start_2_0= RULE_INT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1570:1: (lv_start_2_0= RULE_INT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1571:3: lv_start_2_0= RULE_INT
                    {
                    lv_start_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_RANGE3484); if (state.failed) return current;
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

                    otherlv_3=(Token)match(input,37,FOLLOW_37_in_ruleASN1_RANGE3501); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_1_1());
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1591:1: ( (lv_end_4_0= RULE_INT ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1592:1: (lv_end_4_0= RULE_INT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1592:1: (lv_end_4_0= RULE_INT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1593:3: lv_end_4_0= RULE_INT
                    {
                    lv_end_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_RANGE3518); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1617:1: entryRuleASN1_VALUEPAIR returns [String current=null] : iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF ;
    public final String entryRuleASN1_VALUEPAIR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleASN1_VALUEPAIR = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1618:2: (iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1619:2: iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_VALUEPAIRRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR3561);
            iv_ruleASN1_VALUEPAIR=ruleASN1_VALUEPAIR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_VALUEPAIR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR3572); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1626:1: ruleASN1_VALUEPAIR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ASN1_ID_0= RULE_ASN1_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleASN1_VALUEPAIR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ASN1_ID_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1629:28: ( ( (this_ASN1_ID_0= RULE_ASN1_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1630:1: ( (this_ASN1_ID_0= RULE_ASN1_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1630:1: ( (this_ASN1_ID_0= RULE_ASN1_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1630:2: (this_ASN1_ID_0= RULE_ASN1_ID )? kw= '(' this_INT_2= RULE_INT kw= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1630:2: (this_ASN1_ID_0= RULE_ASN1_ID )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ASN1_ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1630:7: this_ASN1_ID_0= RULE_ASN1_ID
                    {
                    this_ASN1_ID_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_VALUEPAIR3613); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ASN1_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ASN1_ID_0, grammarAccess.getASN1_VALUEPAIRAccess().getASN1_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;

            }

            kw=(Token)match(input,28,FOLLOW_28_in_ruleASN1_VALUEPAIR3633); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getASN1_VALUEPAIRAccess().getLeftParenthesisKeyword_1()); 
                  
            }
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_VALUEPAIR3648); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_2, grammarAccess.getASN1_VALUEPAIRAccess().getINTTerminalRuleCall_2()); 
                  
            }
            kw=(Token)match(input,29,FOLLOW_29_in_ruleASN1_VALUEPAIR3666); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1664:1: entryRuleASN1_CHOICE returns [EObject current=null] : iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF ;
    public final EObject entryRuleASN1_CHOICE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1665:2: (iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1666:2: iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE3706);
            iv_ruleASN1_CHOICE=ruleASN1_CHOICE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE3716); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1673:1: ruleASN1_CHOICE returns [EObject current=null] : (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1676:28: ( (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1677:1: (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1677:1: (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1677:3: otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleASN1_CHOICE3753); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleASN1_CHOICE3765); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1685:1: ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1686:1: (lv_choices_2_0= ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1686:1: (lv_choices_2_0= ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1687:3: lv_choices_2_0= ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3786);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1703:2: (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==39) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1703:4: otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) )
            	    {
            	    otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleASN1_CHOICE3799); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1707:1: ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1708:1: (lv_choices_4_0= ruleASN1_CHOICE_ENTRY )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1708:1: (lv_choices_4_0= ruleASN1_CHOICE_ENTRY )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1709:3: lv_choices_4_0= ruleASN1_CHOICE_ENTRY
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3820);
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
            	    break loop33;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleASN1_CHOICE3834); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1737:1: entryRuleASN1_CHOICE_ENTRY returns [EObject current=null] : iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF ;
    public final EObject entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE_ENTRY = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1738:2: (iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1739:2: iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY3870);
            iv_ruleASN1_CHOICE_ENTRY=ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE_ENTRY; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY3880); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1746:1: ruleASN1_CHOICE_ENTRY returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ASN1_ID ) ) ) ;
    public final EObject ruleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1749:28: ( ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ASN1_ID ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1750:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ASN1_ID ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1750:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ASN1_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1750:2: ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ASN1_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1750:2: ( (lv_id_0_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1751:1: (lv_id_0_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1751:1: (lv_id_0_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1752:3: lv_id_0_0= RULE_ASN1_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY3922); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1768:2: ( (otherlv_1= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1769:1: (otherlv_1= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1769:1: (otherlv_1= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1770:3: otherlv_1= RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getASN1_CHOICE_ENTRYRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY3947); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueCrossReference_1_0()); 
              	
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
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:776:3: ( ( ruleTypeReference ) )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:777:1: ( ruleTypeReference )
        {
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:777:1: ( ruleTypeReference )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:778:1: ruleTypeReference
        {
        pushFollow(FOLLOW_ruleTypeReference_in_synpred2_InternalSmi1628);
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
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA1_eotS =
        "\10\uffff";
    static final String DFA1_eofS =
        "\10\uffff";
    static final String DFA1_minS =
        "\1\5\1\4\2\uffff\1\4\1\21\2\uffff";
    static final String DFA1_maxS =
        "\1\5\1\23\2\uffff\1\6\1\27\2\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\4\1\1\2\uffff\1\3\1\2";
    static final String DFA1_specialS =
        "\10\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1",
            "\1\5\1\4\1\3\14\uffff\1\2",
            "",
            "",
            "\1\5\1\4\1\3",
            "\1\7\5\uffff\1\6",
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
    static final String DFA10_eotS =
        "\4\uffff";
    static final String DFA10_eofS =
        "\4\uffff";
    static final String DFA10_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA10_maxS =
        "\1\5\1\33\2\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA10_specialS =
        "\4\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1",
            "\1\2\1\1\2\uffff\1\2\20\uffff\1\3\1\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "()+ loopback of 499:1: ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+";
        }
    }
    static final String DFA13_eotS =
        "\4\uffff";
    static final String DFA13_eofS =
        "\4\uffff";
    static final String DFA13_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA13_maxS =
        "\1\5\1\23\2\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA13_specialS =
        "\4\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\1",
            "\1\2\1\1\15\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "()+ loopback of 551:2: ( (lv_innerTypes_15_0= ruleTypeDefinition ) )+";
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
    public static final BitSet FOLLOW_RULE_INT_in_ruleObjectIdentifierValue631 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleObjectIdentifierValue653 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition695 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDefinition705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTypeDefinition742 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeDefinition760 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeDefinition777 = new BitSet(new long[]{0x0000004E08100330L});
    public static final BitSet FOLLOW_ruleValue_in_ruleTypeDefinition798 = new BitSet(new long[]{0x0000004E08100332L});
    public static final BitSet FOLLOW_ruleMacro_in_entryRuleMacro835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacro845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro882 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleMacro900 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleMacro917 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMacro929 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro940 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleMacro951 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro963 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_24_in_ruleMacro976 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMacro988 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_ruleMacro1009 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro1022 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_25_in_ruleMacro1035 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMacro1047 = new BitSet(new long[]{0x0000000008000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro1059 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleMacro1081 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleMacro1102 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro1115 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_19_in_ruleMacro1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment1164 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAssignment1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTypeAssignment1211 = new BitSet(new long[]{0x0000000008000130L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleTypeAssignment1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeAssignment1262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleTypeAssignment1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment1325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamAssignment1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PARAMETER_in_ruleParamAssignment1377 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_ruleParamAssignment1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation1439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotation1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeNotation1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleTypeNotation1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt1558 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReferenceExt1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1614 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_entryRuleTypeReference1682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReference1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeReference1736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1771 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValue1818 = new BitSet(new long[]{0x0000004E08100330L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue1840 = new BitSet(new long[]{0x0000000004000022L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValue1853 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleValue1866 = new BitSet(new long[]{0x0000004E08100330L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue1887 = new BitSet(new long[]{0x0000000004000022L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType1925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleValueType1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_ruleValueType2008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_ruleValueType2035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleValueType2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleValueType2086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue2135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue2145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleMacroValue2191 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleMacroValue2203 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_ruleMacroValue2224 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleMacroValue2236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE2272 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE2282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_ruleMACRO_VALUE_TYPE2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_ruleMACRO_VALUE_TYPE2355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_entryRuleUpdateType2391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpdateType2401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleUpdateType2438 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleUpdateType2458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP2495 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleMACRO_VALUE_CAP2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleMACRO_VALUE_CAP2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE2603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE2613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE2660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE2687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE2722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE2732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleASN1_SIMPLE2779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE2807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE2836 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE2856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE2887 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SIMPLE2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING2945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleASN1_OCTET_STRING3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER3056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER3066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleASN1_INTEGER3109 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleASN1_INTEGER3134 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_ruleASN1_INTEGER3155 = new BitSet(new long[]{0x0000000010400040L});
    public static final BitSet FOLLOW_22_in_ruleASN1_INTEGER3168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE3204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleASN1_SUBTYPE3251 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleASN1_SUBTYPE3263 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleASN1_SUBTYPE3275 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3296 = new BitSet(new long[]{0x0000000024000000L});
    public static final BitSet FOLLOW_26_in_ruleASN1_SUBTYPE3309 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3330 = new BitSet(new long[]{0x0000000024000000L});
    public static final BitSet FOLLOW_29_in_ruleASN1_SUBTYPE3344 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleASN1_SUBTYPE3356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE3392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE3402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_RANGE3454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_RANGE3484 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleASN1_RANGE3501 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_RANGE3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR3561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_VALUEPAIR3613 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleASN1_VALUEPAIR3633 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_VALUEPAIR3648 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleASN1_VALUEPAIR3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE3706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE3716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleASN1_CHOICE3753 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleASN1_CHOICE3765 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3786 = new BitSet(new long[]{0x0000008000400000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_CHOICE3799 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3820 = new BitSet(new long[]{0x0000008000400000L});
    public static final BitSet FOLLOW_22_in_ruleASN1_CHOICE3834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY3870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY3880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY3922 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY3947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_synpred1_InternalSmi595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_synpred2_InternalSmi1628 = new BitSet(new long[]{0x0000000000000002L});

}