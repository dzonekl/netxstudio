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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_MODULE_ID", "RULE_NEWLINE", "RULE_ASN1_ID", "RULE_BIG_INTEGER", "RULE_IA5STRING", "RULE_PARAMETER", "RULE_ALPHA_CAP", "RULE_ALPHA", "RULE_NUMERIC", "RULE_SL_ASN1_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'DEFINITIONS'", "'::='", "'BEGIN'", "'END'", "'IMPORTS'", "';'", "'FROM'", "','", "'OBJECT IDENTIFIER'", "'{'", "'}'", "'MACRO'", "'TYPE'", "'NOTATION'", "'VALUE'", "'\"{\"'", "'\"}\"'", "'IMPLICIT'", "'|'", "'[APPLICATION'", "']'", "'value'", "'('", "')'", "'Update'", "'IA5String'", "'empty'", "'OCTET'", "'STRING'", "'INTEGER'", "'SIZE'", "'..'", "'CHOICE'", "'SEQUENCE'", "'OF'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_ALPHA_CAP=10;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int RULE_IA5STRING=8;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__50=50;
    public static final int RULE_PARAMETER=9;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int RULE_NEWLINE=5;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_ASN1_ID=6;
    public static final int RULE_ALPHA=11;
    public static final int RULE_MODULE_ID=4;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_BIG_INTEGER=7;
    public static final int RULE_NUMERIC=12;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=14;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:76:1: ruleModule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_imports_4_0= ruleImports ) )? ( ( (lv_objects_5_0= ruleObject ) ) | ( (lv_identifiers_6_0= ruleObjectIdentifier ) ) | ( (lv_types_7_0= ruleReferenceable ) ) )+ (this_NEWLINE_8= RULE_NEWLINE )+ otherlv_9= 'END' (this_NEWLINE_10= RULE_NEWLINE )* ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_NEWLINE_8=null;
        Token otherlv_9=null;
        Token this_NEWLINE_10=null;
        EObject lv_imports_4_0 = null;

        EObject lv_objects_5_0 = null;

        EObject lv_identifiers_6_0 = null;

        EObject lv_types_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:79:28: ( ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_imports_4_0= ruleImports ) )? ( ( (lv_objects_5_0= ruleObject ) ) | ( (lv_identifiers_6_0= ruleObjectIdentifier ) ) | ( (lv_types_7_0= ruleReferenceable ) ) )+ (this_NEWLINE_8= RULE_NEWLINE )+ otherlv_9= 'END' (this_NEWLINE_10= RULE_NEWLINE )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:1: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_imports_4_0= ruleImports ) )? ( ( (lv_objects_5_0= ruleObject ) ) | ( (lv_identifiers_6_0= ruleObjectIdentifier ) ) | ( (lv_types_7_0= ruleReferenceable ) ) )+ (this_NEWLINE_8= RULE_NEWLINE )+ otherlv_9= 'END' (this_NEWLINE_10= RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:1: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_imports_4_0= ruleImports ) )? ( ( (lv_objects_5_0= ruleObject ) ) | ( (lv_identifiers_6_0= ruleObjectIdentifier ) ) | ( (lv_types_7_0= ruleReferenceable ) ) )+ (this_NEWLINE_8= RULE_NEWLINE )+ otherlv_9= 'END' (this_NEWLINE_10= RULE_NEWLINE )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:2: ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_imports_4_0= ruleImports ) )? ( ( (lv_objects_5_0= ruleObject ) ) | ( (lv_identifiers_6_0= ruleObjectIdentifier ) ) | ( (lv_types_7_0= ruleReferenceable ) ) )+ (this_NEWLINE_8= RULE_NEWLINE )+ otherlv_9= 'END' (this_NEWLINE_10= RULE_NEWLINE )*
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:110:1: ( (lv_imports_4_0= ruleImports ) )?
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:111:1: (lv_imports_4_0= ruleImports )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:111:1: (lv_imports_4_0= ruleImports )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:112:3: lv_imports_4_0= ruleImports
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleAccess().getImportsImportsParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleImports_in_ruleModule189);
                    lv_imports_4_0=ruleImports();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModuleRule());
                      	        }
                             		set(
                             			current, 
                             			"imports",
                              		lv_imports_4_0, 
                              		"Imports");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:128:3: ( ( (lv_objects_5_0= ruleObject ) ) | ( (lv_identifiers_6_0= ruleObjectIdentifier ) ) | ( (lv_types_7_0= ruleReferenceable ) ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=4;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:128:4: ( (lv_objects_5_0= ruleObject ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:128:4: ( (lv_objects_5_0= ruleObject ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:129:1: (lv_objects_5_0= ruleObject )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:129:1: (lv_objects_5_0= ruleObject )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:130:3: lv_objects_5_0= ruleObject
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getObjectsObjectParserRuleCall_5_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleObject_in_ruleModule212);
            	    lv_objects_5_0=ruleObject();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"objects",
            	              		lv_objects_5_0, 
            	              		"Object");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:147:6: ( (lv_identifiers_6_0= ruleObjectIdentifier ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:147:6: ( (lv_identifiers_6_0= ruleObjectIdentifier ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:148:1: (lv_identifiers_6_0= ruleObjectIdentifier )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:148:1: (lv_identifiers_6_0= ruleObjectIdentifier )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:149:3: lv_identifiers_6_0= ruleObjectIdentifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getIdentifiersObjectIdentifierParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleObjectIdentifier_in_ruleModule239);
            	    lv_identifiers_6_0=ruleObjectIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"identifiers",
            	              		lv_identifiers_6_0, 
            	              		"ObjectIdentifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:166:6: ( (lv_types_7_0= ruleReferenceable ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:166:6: ( (lv_types_7_0= ruleReferenceable ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:167:1: (lv_types_7_0= ruleReferenceable )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:167:1: (lv_types_7_0= ruleReferenceable )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:168:3: lv_types_7_0= ruleReferenceable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getTypesReferenceableParserRuleCall_5_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleReferenceable_in_ruleModule266);
            	    lv_types_7_0=ruleReferenceable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"types",
            	              		lv_types_7_0, 
            	              		"Referenceable");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:184:4: (this_NEWLINE_8= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:184:5: this_NEWLINE_8= RULE_NEWLINE
            	    {
            	    this_NEWLINE_8=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleModule280); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_8, grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_6()); 
            	          
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

            otherlv_9=(Token)match(input,19,FOLLOW_19_in_ruleModule293); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getModuleAccess().getENDKeyword_7());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:192:1: (this_NEWLINE_10= RULE_NEWLINE )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_NEWLINE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:192:2: this_NEWLINE_10= RULE_NEWLINE
            	    {
            	    this_NEWLINE_10=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleModule305); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_10, grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_8()); 
            	          
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
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleImports"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:204:1: entryRuleImports returns [EObject current=null] : iv_ruleImports= ruleImports EOF ;
    public final EObject entryRuleImports() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImports = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:205:2: (iv_ruleImports= ruleImports EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:206:2: iv_ruleImports= ruleImports EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportsRule()); 
            }
            pushFollow(FOLLOW_ruleImports_in_entryRuleImports342);
            iv_ruleImports=ruleImports();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImports; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImports352); if (state.failed) return current;

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
    // $ANTLR end "entryRuleImports"


    // $ANTLR start "ruleImports"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:213:1: ruleImports returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ otherlv_1= 'IMPORTS' ( (lv_imports_2_0= ruleImportClosure ) )+ otherlv_3= ';' ) ;
    public final EObject ruleImports() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_imports_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:216:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ otherlv_1= 'IMPORTS' ( (lv_imports_2_0= ruleImportClosure ) )+ otherlv_3= ';' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:217:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ otherlv_1= 'IMPORTS' ( (lv_imports_2_0= ruleImportClosure ) )+ otherlv_3= ';' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:217:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ otherlv_1= 'IMPORTS' ( (lv_imports_2_0= ruleImportClosure ) )+ otherlv_3= ';' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:217:2: (this_NEWLINE_0= RULE_NEWLINE )+ otherlv_1= 'IMPORTS' ( (lv_imports_2_0= ruleImportClosure ) )+ otherlv_3= ';'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:217:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_NEWLINE) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:217:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleImports389); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getImportsAccess().getNEWLINETerminalRuleCall_0()); 
            	          
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

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleImports402); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getImportsAccess().getIMPORTSKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:225:1: ( (lv_imports_2_0= ruleImportClosure ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=RULE_MODULE_ID && LA6_0<=RULE_ASN1_ID)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:226:1: (lv_imports_2_0= ruleImportClosure )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:226:1: (lv_imports_2_0= ruleImportClosure )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:227:3: lv_imports_2_0= ruleImportClosure
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImportsAccess().getImportsImportClosureParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImportClosure_in_ruleImports423);
            	    lv_imports_2_0=ruleImportClosure();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getImportsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_2_0, 
            	              		"ImportClosure");
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

            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleImports436); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getImportsAccess().getSemicolonKeyword_3());
                  
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
    // $ANTLR end "ruleImports"


    // $ANTLR start "entryRuleImportClosure"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:255:1: entryRuleImportClosure returns [EObject current=null] : iv_ruleImportClosure= ruleImportClosure EOF ;
    public final EObject entryRuleImportClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportClosure = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:256:2: (iv_ruleImportClosure= ruleImportClosure EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:257:2: iv_ruleImportClosure= ruleImportClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportClosureRule()); 
            }
            pushFollow(FOLLOW_ruleImportClosure_in_entryRuleImportClosure472);
            iv_ruleImportClosure=ruleImportClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportClosure482); if (state.failed) return current;

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
    // $ANTLR end "entryRuleImportClosure"


    // $ANTLR start "ruleImportClosure"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:264:1: ruleImportClosure returns [EObject current=null] : ( ( (lv_refs_0_0= ruleImportRefs ) ) (this_NEWLINE_1= RULE_NEWLINE )* otherlv_2= 'FROM' ( (lv_importURI_3_0= RULE_MODULE_ID ) ) ) ;
    public final EObject ruleImportClosure() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_1=null;
        Token otherlv_2=null;
        Token lv_importURI_3_0=null;
        EObject lv_refs_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:267:28: ( ( ( (lv_refs_0_0= ruleImportRefs ) ) (this_NEWLINE_1= RULE_NEWLINE )* otherlv_2= 'FROM' ( (lv_importURI_3_0= RULE_MODULE_ID ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:268:1: ( ( (lv_refs_0_0= ruleImportRefs ) ) (this_NEWLINE_1= RULE_NEWLINE )* otherlv_2= 'FROM' ( (lv_importURI_3_0= RULE_MODULE_ID ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:268:1: ( ( (lv_refs_0_0= ruleImportRefs ) ) (this_NEWLINE_1= RULE_NEWLINE )* otherlv_2= 'FROM' ( (lv_importURI_3_0= RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:268:2: ( (lv_refs_0_0= ruleImportRefs ) ) (this_NEWLINE_1= RULE_NEWLINE )* otherlv_2= 'FROM' ( (lv_importURI_3_0= RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:268:2: ( (lv_refs_0_0= ruleImportRefs ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:269:1: (lv_refs_0_0= ruleImportRefs )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:269:1: (lv_refs_0_0= ruleImportRefs )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:270:3: lv_refs_0_0= ruleImportRefs
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportClosureAccess().getRefsImportRefsParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleImportRefs_in_ruleImportClosure528);
            lv_refs_0_0=ruleImportRefs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportClosureRule());
              	        }
                     		set(
                     			current, 
                     			"refs",
                      		lv_refs_0_0, 
                      		"ImportRefs");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:286:2: (this_NEWLINE_1= RULE_NEWLINE )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_NEWLINE) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:286:3: this_NEWLINE_1= RULE_NEWLINE
            	    {
            	    this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleImportClosure540); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_1, grammarAccess.getImportClosureAccess().getNEWLINETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleImportClosure553); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getImportClosureAccess().getFROMKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:294:1: ( (lv_importURI_3_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:295:1: (lv_importURI_3_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:295:1: (lv_importURI_3_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:296:3: lv_importURI_3_0= RULE_MODULE_ID
            {
            lv_importURI_3_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleImportClosure570); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_importURI_3_0, grammarAccess.getImportClosureAccess().getImportURIMODULE_IDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getImportClosureRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"importURI",
                      		lv_importURI_3_0, 
                      		"MODULE_ID");
              	    
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
    // $ANTLR end "ruleImportClosure"


    // $ANTLR start "entryRuleImportRefs"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:320:1: entryRuleImportRefs returns [EObject current=null] : iv_ruleImportRefs= ruleImportRefs EOF ;
    public final EObject entryRuleImportRefs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportRefs = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:321:2: (iv_ruleImportRefs= ruleImportRefs EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:322:2: iv_ruleImportRefs= ruleImportRefs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRefsRule()); 
            }
            pushFollow(FOLLOW_ruleImportRefs_in_entryRuleImportRefs611);
            iv_ruleImportRefs=ruleImportRefs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportRefs; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportRefs621); if (state.failed) return current;

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
    // $ANTLR end "entryRuleImportRefs"


    // $ANTLR start "ruleImportRefs"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:329:1: ruleImportRefs returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )* ( (lv_refs_1_0= ruleImportRef ) ) (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )* ) ;
    public final EObject ruleImportRefs() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token otherlv_2=null;
        Token this_NEWLINE_3=null;
        EObject lv_refs_1_0 = null;

        EObject lv_refs_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:332:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )* ( (lv_refs_1_0= ruleImportRef ) ) (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:333:1: ( (this_NEWLINE_0= RULE_NEWLINE )* ( (lv_refs_1_0= ruleImportRef ) ) (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:333:1: ( (this_NEWLINE_0= RULE_NEWLINE )* ( (lv_refs_1_0= ruleImportRef ) ) (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:333:2: (this_NEWLINE_0= RULE_NEWLINE )* ( (lv_refs_1_0= ruleImportRef ) ) (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:333:2: (this_NEWLINE_0= RULE_NEWLINE )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_NEWLINE) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:333:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleImportRefs658); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getImportRefsAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:337:3: ( (lv_refs_1_0= ruleImportRef ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:338:1: (lv_refs_1_0= ruleImportRef )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:338:1: (lv_refs_1_0= ruleImportRef )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:339:3: lv_refs_1_0= ruleImportRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportRefsAccess().getRefsImportRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleImportRef_in_ruleImportRefs680);
            lv_refs_1_0=ruleImportRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportRefsRule());
              	        }
                     		add(
                     			current, 
                     			"refs",
                      		lv_refs_1_0, 
                      		"ImportRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:355:2: (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==23) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:355:4: otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) )
            	    {
            	    otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleImportRefs693); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getImportRefsAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:359:1: (this_NEWLINE_3= RULE_NEWLINE )*
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==RULE_NEWLINE) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:359:2: this_NEWLINE_3= RULE_NEWLINE
            	    	    {
            	    	    this_NEWLINE_3=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleImportRefs705); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_NEWLINE_3, grammarAccess.getImportRefsAccess().getNEWLINETerminalRuleCall_2_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop9;
            	        }
            	    } while (true);

            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:363:3: ( (lv_refs_4_0= ruleImportRef ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:364:1: (lv_refs_4_0= ruleImportRef )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:364:1: (lv_refs_4_0= ruleImportRef )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:365:3: lv_refs_4_0= ruleImportRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImportRefsAccess().getRefsImportRefParserRuleCall_2_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImportRef_in_ruleImportRefs727);
            	    lv_refs_4_0=ruleImportRef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getImportRefsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"refs",
            	              		lv_refs_4_0, 
            	              		"ImportRef");
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
    // $ANTLR end "ruleImportRefs"


    // $ANTLR start "entryRuleImportRef"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:389:1: entryRuleImportRef returns [EObject current=null] : iv_ruleImportRef= ruleImportRef EOF ;
    public final EObject entryRuleImportRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportRef = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:390:2: (iv_ruleImportRef= ruleImportRef EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:391:2: iv_ruleImportRef= ruleImportRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRefRule()); 
            }
            pushFollow(FOLLOW_ruleImportRef_in_entryRuleImportRef765);
            iv_ruleImportRef=ruleImportRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportRef775); if (state.failed) return current;

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
    // $ANTLR end "entryRuleImportRef"


    // $ANTLR start "ruleImportRef"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:398:1: ruleImportRef returns [EObject current=null] : ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( (otherlv_1= RULE_MODULE_ID ) ) ) ;
    public final EObject ruleImportRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:401:28: ( ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( (otherlv_1= RULE_MODULE_ID ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:402:1: ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( (otherlv_1= RULE_MODULE_ID ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:402:1: ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( (otherlv_1= RULE_MODULE_ID ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ASN1_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_MODULE_ID) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:402:2: ( (otherlv_0= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:402:2: ( (otherlv_0= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:403:1: (otherlv_0= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:403:1: (otherlv_0= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:404:3: otherlv_0= RULE_ASN1_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getImportRefRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleImportRef820); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getImportRefAccess().getOiRefObjectReferenceableCrossReference_0_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:416:6: ( (otherlv_1= RULE_MODULE_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:416:6: ( (otherlv_1= RULE_MODULE_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:417:1: (otherlv_1= RULE_MODULE_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:417:1: (otherlv_1= RULE_MODULE_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:418:3: otherlv_1= RULE_MODULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getImportRefRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleImportRef846); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getImportRefAccess().getTypeRefReferenceableCrossReference_1_0()); 
                      	
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
    // $ANTLR end "ruleImportRef"


    // $ANTLR start "entryRuleReferenceable"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:437:1: entryRuleReferenceable returns [EObject current=null] : iv_ruleReferenceable= ruleReferenceable EOF ;
    public final EObject entryRuleReferenceable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceable = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:438:2: (iv_ruleReferenceable= ruleReferenceable EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:439:2: iv_ruleReferenceable= ruleReferenceable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceableRule()); 
            }
            pushFollow(FOLLOW_ruleReferenceable_in_entryRuleReferenceable882);
            iv_ruleReferenceable=ruleReferenceable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceable892); if (state.failed) return current;

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
    // $ANTLR end "entryRuleReferenceable"


    // $ANTLR start "ruleReferenceable"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:446:1: ruleReferenceable returns [EObject current=null] : (this_Macro_0= ruleMacro | this_TypeDefinition_1= ruleTypeDefinition ) ;
    public final EObject ruleReferenceable() throws RecognitionException {
        EObject current = null;

        EObject this_Macro_0 = null;

        EObject this_TypeDefinition_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:449:28: ( (this_Macro_0= ruleMacro | this_TypeDefinition_1= ruleTypeDefinition ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:450:1: (this_Macro_0= ruleMacro | this_TypeDefinition_1= ruleTypeDefinition )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:450:1: (this_Macro_0= ruleMacro | this_TypeDefinition_1= ruleTypeDefinition )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:451:5: this_Macro_0= ruleMacro
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReferenceableAccess().getMacroParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMacro_in_ruleReferenceable939);
                    this_Macro_0=ruleMacro();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Macro_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:461:5: this_TypeDefinition_1= ruleTypeDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReferenceableAccess().getTypeDefinitionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleReferenceable966);
                    this_TypeDefinition_1=ruleTypeDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeDefinition_1; 
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
    // $ANTLR end "ruleReferenceable"


    // $ANTLR start "entryRuleObjectIdentifier"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:477:1: entryRuleObjectIdentifier returns [EObject current=null] : iv_ruleObjectIdentifier= ruleObjectIdentifier EOF ;
    public final EObject entryRuleObjectIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectIdentifier = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:478:2: (iv_ruleObjectIdentifier= ruleObjectIdentifier EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:479:2: iv_ruleObjectIdentifier= ruleObjectIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier1001);
            iv_ruleObjectIdentifier=ruleObjectIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectIdentifier; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifier1011); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:486:1: ruleObjectIdentifier returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' ) ;
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
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:489:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:490:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:490:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:490:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:490:2: (this_NEWLINE_0= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:490:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleObjectIdentifier1048); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getObjectIdentifierAccess().getNEWLINETerminalRuleCall_0()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:494:3: ( (lv_name_1_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:495:1: (lv_name_1_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:495:1: (lv_name_1_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:496:3: lv_name_1_0= RULE_ASN1_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifier1066); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleObjectIdentifier1083); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleObjectIdentifier1095); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleObjectIdentifier1107); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:524:1: ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:525:1: (lv_oidValue_5_0= ruleObjectIdentifierValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:525:1: (lv_oidValue_5_0= ruleObjectIdentifierValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:526:3: lv_oidValue_5_0= ruleObjectIdentifierValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_ruleObjectIdentifier1128);
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

            otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleObjectIdentifier1140); if (state.failed) return current;
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
        }
        return current;
    }
    // $ANTLR end "ruleObjectIdentifier"


    // $ANTLR start "entryRuleObjectIdentifierValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:554:1: entryRuleObjectIdentifierValue returns [EObject current=null] : iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF ;
    public final EObject entryRuleObjectIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectIdentifierValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:555:2: (iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:556:2: iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectIdentifierValueRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue1176);
            iv_ruleObjectIdentifierValue=ruleObjectIdentifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectIdentifierValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifierValue1186); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:563:1: ruleObjectIdentifierValue returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (lv_name_1_0= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* ) ;
    public final EObject ruleObjectIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_subIds_2_0=null;
        Token lv_subIds_3_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:566:28: ( ( ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (lv_name_1_0= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:567:1: ( ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (lv_name_1_0= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:567:1: ( ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (lv_name_1_0= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:567:2: ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (lv_name_1_0= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:567:2: ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (lv_name_1_0= RULE_ASN1_ID ) ) )?
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ASN1_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (true) ) {
                    alt14=1;
                }
                else if ( (synpred1_InternalSmi()) ) {
                    alt14=2;
                }
            }
            switch (alt14) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:567:3: ( (otherlv_0= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:567:3: ( (otherlv_0= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:568:1: (otherlv_0= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:568:1: (otherlv_0= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:569:3: otherlv_0= RULE_ASN1_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue1232); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getObjectIdentifierValueAccess().getDescriptorRefObjectReferenceableCrossReference_0_0_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:581:6: ( ( ( RULE_ASN1_ID ) )=> (lv_name_1_0= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:581:6: ( ( ( RULE_ASN1_ID ) )=> (lv_name_1_0= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:581:7: ( ( RULE_ASN1_ID ) )=> (lv_name_1_0= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:587:1: (lv_name_1_0= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:588:3: lv_name_1_0= RULE_ASN1_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue1266); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getObjectIdentifierValueAccess().getNameASN1_IDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"ASN1_ID");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:604:4: ( (lv_subIds_2_0= RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:605:1: (lv_subIds_2_0= RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:605:1: (lv_subIds_2_0= RULE_BIG_INTEGER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:606:3: lv_subIds_2_0= RULE_BIG_INTEGER
            {
            lv_subIds_2_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleObjectIdentifierValue1290); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:622:2: ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_BIG_INTEGER) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:623:1: (lv_subIds_3_0= RULE_BIG_INTEGER )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:623:1: (lv_subIds_3_0= RULE_BIG_INTEGER )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:624:3: lv_subIds_3_0= RULE_BIG_INTEGER
            	    {
            	    lv_subIds_3_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleObjectIdentifierValue1312); if (state.failed) return current;
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
            	    break loop15;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:648:1: entryRuleTypeDefinition returns [EObject current=null] : iv_ruleTypeDefinition= ruleTypeDefinition EOF ;
    public final EObject entryRuleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinition = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:649:2: (iv_ruleTypeDefinition= ruleTypeDefinition EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:650:2: iv_ruleTypeDefinition= ruleTypeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition1354);
            iv_ruleTypeDefinition=ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDefinition1364); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:657:1: ruleTypeDefinition returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ ) ;
    public final EObject ruleTypeDefinition() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_values_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:660:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:661:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:661:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:661:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:661:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_NEWLINE) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:661:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTypeDefinition1401); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:665:3: ( (lv_name_1_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:666:1: (lv_name_1_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:666:1: (lv_name_1_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:667:3: lv_name_1_0= RULE_MODULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleTypeDefinition1419); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleTypeDefinition1436); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTypeDefinitionAccess().getColonColonEqualsSignKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:687:1: ( (lv_values_3_0= ruleValue ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                alt17 = dfa17.predict(input);
                switch (alt17) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:688:1: (lv_values_3_0= ruleValue )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:688:1: (lv_values_3_0= ruleValue )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:689:3: lv_values_3_0= ruleValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeDefinitionAccess().getValuesValueParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValue_in_ruleTypeDefinition1457);
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
            	    if ( cnt17 >= 1 ) break loop17;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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


    // $ANTLR start "entryRuleObject"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:713:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:714:2: (iv_ruleObject= ruleObject EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:715:2: iv_ruleObject= ruleObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectRule()); 
            }
            pushFollow(FOLLOW_ruleObject_in_entryRuleObject1494);
            iv_ruleObject=ruleObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObject; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObject1504); if (state.failed) return current;

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
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:722:1: ruleObject returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) ( (otherlv_2= RULE_MODULE_ID ) ) ( (lv_attributes_3_0= ruleAttribute ) )+ (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= '::=' ( (lv_objectValue_6_0= ruleObjectValue ) ) ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token this_NEWLINE_4=null;
        Token otherlv_5=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_objectValue_6_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:725:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) ( (otherlv_2= RULE_MODULE_ID ) ) ( (lv_attributes_3_0= ruleAttribute ) )+ (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= '::=' ( (lv_objectValue_6_0= ruleObjectValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) ( (otherlv_2= RULE_MODULE_ID ) ) ( (lv_attributes_3_0= ruleAttribute ) )+ (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= '::=' ( (lv_objectValue_6_0= ruleObjectValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) ( (otherlv_2= RULE_MODULE_ID ) ) ( (lv_attributes_3_0= ruleAttribute ) )+ (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= '::=' ( (lv_objectValue_6_0= ruleObjectValue ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) ( (otherlv_2= RULE_MODULE_ID ) ) ( (lv_attributes_3_0= ruleAttribute ) )+ (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= '::=' ( (lv_objectValue_6_0= ruleObjectValue ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_NEWLINE) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleObject1541); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getObjectAccess().getNEWLINETerminalRuleCall_0()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:730:3: ( (lv_name_1_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:731:1: (lv_name_1_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:731:1: (lv_name_1_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:732:3: lv_name_1_0= RULE_ASN1_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObject1559); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getObjectAccess().getNameASN1_IDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getObjectRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ASN1_ID");
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:748:2: ( (otherlv_2= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:749:1: (otherlv_2= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:749:1: (otherlv_2= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:750:3: otherlv_2= RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getObjectRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleObject1584); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getObjectAccess().getMacroRefReferenceableCrossReference_2_0()); 
              	
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:761:2: ( (lv_attributes_3_0= ruleAttribute ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                alt19 = dfa19.predict(input);
                switch (alt19) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:762:1: (lv_attributes_3_0= ruleAttribute )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:762:1: (lv_attributes_3_0= ruleAttribute )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:763:3: lv_attributes_3_0= ruleAttribute
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getObjectAccess().getAttributesAttributeParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttribute_in_ruleObject1605);
            	    lv_attributes_3_0=ruleAttribute();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getObjectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"attributes",
            	              		lv_attributes_3_0, 
            	              		"Attribute");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:779:3: (this_NEWLINE_4= RULE_NEWLINE )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_NEWLINE) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:779:4: this_NEWLINE_4= RULE_NEWLINE
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleObject1618); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_4, grammarAccess.getObjectAccess().getNEWLINETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleObject1631); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getObjectAccess().getColonColonEqualsSignKeyword_5());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:787:1: ( (lv_objectValue_6_0= ruleObjectValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:788:1: (lv_objectValue_6_0= ruleObjectValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:788:1: (lv_objectValue_6_0= ruleObjectValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:789:3: lv_objectValue_6_0= ruleObjectValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getObjectAccess().getObjectValueObjectValueParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleObjectValue_in_ruleObject1652);
            lv_objectValue_6_0=ruleObjectValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getObjectRule());
              	        }
                     		set(
                     			current, 
                     			"objectValue",
                      		lv_objectValue_6_0, 
                      		"ObjectValue");
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
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleAttribute"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:813:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:814:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:815:2: iv_ruleAttribute= ruleAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1688);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttribute; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1698); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:822:1: ruleAttribute returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (otherlv_1= RULE_MODULE_ID ) ) ( (lv_value_2_0= ruleAttributeValue ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:825:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (otherlv_1= RULE_MODULE_ID ) ) ( (lv_value_2_0= ruleAttributeValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:826:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (otherlv_1= RULE_MODULE_ID ) ) ( (lv_value_2_0= ruleAttributeValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:826:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (otherlv_1= RULE_MODULE_ID ) ) ( (lv_value_2_0= ruleAttributeValue ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:826:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (otherlv_1= RULE_MODULE_ID ) ) ( (lv_value_2_0= ruleAttributeValue ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:826:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_NEWLINE) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:826:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleAttribute1735); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getAttributeAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:830:3: ( (otherlv_1= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:831:1: (otherlv_1= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:831:1: (otherlv_1= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:832:3: otherlv_1= RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAttributeRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleAttribute1756); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getParamRefReferenceableCrossReference_1_0()); 
              	
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:843:2: ( (lv_value_2_0= ruleAttributeValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:844:1: (lv_value_2_0= ruleAttributeValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:844:1: (lv_value_2_0= ruleAttributeValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:845:3: lv_value_2_0= ruleAttributeValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttributeAccess().getValueAttributeValueParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAttributeValue_in_ruleAttribute1777);
            lv_value_2_0=ruleAttributeValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttributeRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"AttributeValue");
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleAttributeValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:869:1: entryRuleAttributeValue returns [EObject current=null] : iv_ruleAttributeValue= ruleAttributeValue EOF ;
    public final EObject entryRuleAttributeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:870:2: (iv_ruleAttributeValue= ruleAttributeValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:871:2: iv_ruleAttributeValue= ruleAttributeValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeValueRule()); 
            }
            pushFollow(FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue1813);
            iv_ruleAttributeValue=ruleAttributeValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttributeValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeValue1823); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAttributeValue"


    // $ANTLR start "ruleAttributeValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:878:1: ruleAttributeValue returns [EObject current=null] : ( ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) ) | ( (lv_objectRef_5_0= ruleBracedObjectReference ) ) | ( (lv_integer_6_0= ruleASN1_INTEGER ) ) | ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) ) | ( () otherlv_9= 'OBJECT IDENTIFIER' ) ) ;
    public final EObject ruleAttributeValue() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_text_2_0=null;
        Token otherlv_3=null;
        Token otherlv_9=null;
        EObject lv_identifier_1_0 = null;

        EObject lv_subType_4_0 = null;

        EObject lv_objectRef_5_0 = null;

        EObject lv_integer_6_0 = null;

        EObject lv_sequenceOf_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:881:28: ( ( ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) ) | ( (lv_objectRef_5_0= ruleBracedObjectReference ) ) | ( (lv_integer_6_0= ruleASN1_INTEGER ) ) | ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) ) | ( () otherlv_9= 'OBJECT IDENTIFIER' ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:882:1: ( ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) ) | ( (lv_objectRef_5_0= ruleBracedObjectReference ) ) | ( (lv_integer_6_0= ruleASN1_INTEGER ) ) | ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) ) | ( () otherlv_9= 'OBJECT IDENTIFIER' ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:882:1: ( ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) ) | ( (lv_objectRef_5_0= ruleBracedObjectReference ) ) | ( (lv_integer_6_0= ruleASN1_INTEGER ) ) | ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) ) | ( () otherlv_9= 'OBJECT IDENTIFIER' ) )
            int alt25=5;
            switch ( input.LA(1) ) {
            case RULE_MODULE_ID:
            case RULE_NEWLINE:
            case RULE_ASN1_ID:
            case RULE_IA5STRING:
                {
                alt25=1;
                }
                break;
            case 25:
                {
                alt25=2;
                }
                break;
            case 45:
                {
                alt25=3;
                }
                break;
            case 49:
                {
                alt25=4;
                }
                break;
            case 24:
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:882:2: ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:882:2: ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:882:3: (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:882:3: (this_NEWLINE_0= RULE_NEWLINE )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_NEWLINE) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:882:4: this_NEWLINE_0= RULE_NEWLINE
                    	    {
                    	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleAttributeValue1861); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_NEWLINE_0, grammarAccess.getAttributeValueAccess().getNEWLINETerminalRuleCall_0_0()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:886:3: ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) )
                    int alt24=3;
                    switch ( input.LA(1) ) {
                    case RULE_ASN1_ID:
                        {
                        alt24=1;
                        }
                        break;
                    case RULE_IA5STRING:
                        {
                        alt24=2;
                        }
                        break;
                    case RULE_MODULE_ID:
                        {
                        alt24=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }

                    switch (alt24) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:886:4: ( (lv_identifier_1_0= ruleIdentifier ) )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:886:4: ( (lv_identifier_1_0= ruleIdentifier ) )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:887:1: (lv_identifier_1_0= ruleIdentifier )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:887:1: (lv_identifier_1_0= ruleIdentifier )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:888:3: lv_identifier_1_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAttributeValueAccess().getIdentifierIdentifierParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleIdentifier_in_ruleAttributeValue1884);
                            lv_identifier_1_0=ruleIdentifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getAttributeValueRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"identifier",
                                      		lv_identifier_1_0, 
                                      		"Identifier");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:905:6: ( (lv_text_2_0= RULE_IA5STRING ) )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:905:6: ( (lv_text_2_0= RULE_IA5STRING ) )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:906:1: (lv_text_2_0= RULE_IA5STRING )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:906:1: (lv_text_2_0= RULE_IA5STRING )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:907:3: lv_text_2_0= RULE_IA5STRING
                            {
                            lv_text_2_0=(Token)match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_ruleAttributeValue1907); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_text_2_0, grammarAccess.getAttributeValueAccess().getTextIA5STRINGTerminalRuleCall_0_1_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAttributeValueRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"text",
                                      		lv_text_2_0, 
                                      		"IA5STRING");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 3 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:924:6: ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:924:6: ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:924:7: ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )?
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:924:7: ( (otherlv_3= RULE_MODULE_ID ) )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:925:1: (otherlv_3= RULE_MODULE_ID )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:925:1: (otherlv_3= RULE_MODULE_ID )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:926:3: otherlv_3= RULE_MODULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getAttributeValueRule());
                              	        }
                                      
                            }
                            otherlv_3=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleAttributeValue1939); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_3, grammarAccess.getAttributeValueAccess().getTypeRefReferenceableCrossReference_0_1_2_0_0()); 
                              	
                            }

                            }


                            }

                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:937:2: ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )?
                            int alt23=2;
                            int LA23_0 = input.LA(1);

                            if ( (LA23_0==38) ) {
                                alt23=1;
                            }
                            switch (alt23) {
                                case 1 :
                                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:938:1: (lv_subType_4_0= ruleASN1_SUBTYPE )
                                    {
                                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:938:1: (lv_subType_4_0= ruleASN1_SUBTYPE )
                                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:939:3: lv_subType_4_0= ruleASN1_SUBTYPE
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getAttributeValueAccess().getSubTypeASN1_SUBTYPEParserRuleCall_0_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_ruleAttributeValue1960);
                                    lv_subType_4_0=ruleASN1_SUBTYPE();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getAttributeValueRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"subType",
                                              		lv_subType_4_0, 
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

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:956:6: ( (lv_objectRef_5_0= ruleBracedObjectReference ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:956:6: ( (lv_objectRef_5_0= ruleBracedObjectReference ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:957:1: (lv_objectRef_5_0= ruleBracedObjectReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:957:1: (lv_objectRef_5_0= ruleBracedObjectReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:958:3: lv_objectRef_5_0= ruleBracedObjectReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAttributeValueAccess().getObjectRefBracedObjectReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBracedObjectReference_in_ruleAttributeValue1991);
                    lv_objectRef_5_0=ruleBracedObjectReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAttributeValueRule());
                      	        }
                             		set(
                             			current, 
                             			"objectRef",
                              		lv_objectRef_5_0, 
                              		"BracedObjectReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:975:6: ( (lv_integer_6_0= ruleASN1_INTEGER ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:975:6: ( (lv_integer_6_0= ruleASN1_INTEGER ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:976:1: (lv_integer_6_0= ruleASN1_INTEGER )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:976:1: (lv_integer_6_0= ruleASN1_INTEGER )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:977:3: lv_integer_6_0= ruleASN1_INTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAttributeValueAccess().getIntegerASN1_INTEGERParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_INTEGER_in_ruleAttributeValue2018);
                    lv_integer_6_0=ruleASN1_INTEGER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAttributeValueRule());
                      	        }
                             		set(
                             			current, 
                             			"integer",
                              		lv_integer_6_0, 
                              		"ASN1_INTEGER");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:994:6: ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:994:6: ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:995:1: (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:995:1: (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:996:3: lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAttributeValueAccess().getSequenceOfASN1_SEQUENCE_OFParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_SEQUENCE_OF_in_ruleAttributeValue2045);
                    lv_sequenceOf_7_0=ruleASN1_SEQUENCE_OF();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getAttributeValueRule());
                      	        }
                             		set(
                             			current, 
                             			"sequenceOf",
                              		lv_sequenceOf_7_0, 
                              		"ASN1_SEQUENCE_OF");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1013:6: ( () otherlv_9= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1013:6: ( () otherlv_9= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1013:7: () otherlv_9= 'OBJECT IDENTIFIER'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1013:7: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1014:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAttributeValueAccess().getAttributeValueAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleAttributeValue2073); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getAttributeValueAccess().getOBJECTIDENTIFIERKeyword_4_1());
                          
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
    // $ANTLR end "ruleAttributeValue"


    // $ANTLR start "entryRuleIdentifier"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1031:1: entryRuleIdentifier returns [EObject current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final EObject entryRuleIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifier = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1032:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1033:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier2110);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier2120); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1040:1: ruleIdentifier returns [EObject current=null] : ( (lv_id_0_0= RULE_ASN1_ID ) ) ;
    public final EObject ruleIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1043:28: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1044:1: ( (lv_id_0_0= RULE_ASN1_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1044:1: ( (lv_id_0_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1045:1: (lv_id_0_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1045:1: (lv_id_0_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1046:3: lv_id_0_0= RULE_ASN1_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleIdentifier2161); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_id_0_0, grammarAccess.getIdentifierAccess().getIdASN1_IDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIdentifierRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"id",
                      		lv_id_0_0, 
                      		"ASN1_ID");
              	    
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
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleBracedObjectReference"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1070:1: entryRuleBracedObjectReference returns [EObject current=null] : iv_ruleBracedObjectReference= ruleBracedObjectReference EOF ;
    public final EObject entryRuleBracedObjectReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBracedObjectReference = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1071:2: (iv_ruleBracedObjectReference= ruleBracedObjectReference EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1072:2: iv_ruleBracedObjectReference= ruleBracedObjectReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBracedObjectReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleBracedObjectReference_in_entryRuleBracedObjectReference2201);
            iv_ruleBracedObjectReference=ruleBracedObjectReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBracedObjectReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBracedObjectReference2211); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBracedObjectReference"


    // $ANTLR start "ruleBracedObjectReference"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1079:1: ruleBracedObjectReference returns [EObject current=null] : (otherlv_0= '{' ( (otherlv_1= RULE_ASN1_ID ) ) otherlv_2= '}' ) ;
    public final EObject ruleBracedObjectReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1082:28: ( (otherlv_0= '{' ( (otherlv_1= RULE_ASN1_ID ) ) otherlv_2= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1083:1: (otherlv_0= '{' ( (otherlv_1= RULE_ASN1_ID ) ) otherlv_2= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1083:1: (otherlv_0= '{' ( (otherlv_1= RULE_ASN1_ID ) ) otherlv_2= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1083:3: otherlv_0= '{' ( (otherlv_1= RULE_ASN1_ID ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleBracedObjectReference2248); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBracedObjectReferenceAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1087:1: ( (otherlv_1= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1088:1: (otherlv_1= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1088:1: (otherlv_1= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1089:3: otherlv_1= RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getBracedObjectReferenceRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleBracedObjectReference2268); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getBracedObjectReferenceAccess().getObjectRefObjectReferenceableCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleBracedObjectReference2280); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getBracedObjectReferenceAccess().getRightCurlyBracketKeyword_2());
                  
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
    // $ANTLR end "ruleBracedObjectReference"


    // $ANTLR start "entryRuleObjectValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1112:1: entryRuleObjectValue returns [EObject current=null] : iv_ruleObjectValue= ruleObjectValue EOF ;
    public final EObject entryRuleObjectValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1113:2: (iv_ruleObjectValue= ruleObjectValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1114:2: iv_ruleObjectValue= ruleObjectValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectValueRule()); 
            }
            pushFollow(FOLLOW_ruleObjectValue_in_entryRuleObjectValue2316);
            iv_ruleObjectValue=ruleObjectValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectValue2326); if (state.failed) return current;

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
    // $ANTLR end "entryRuleObjectValue"


    // $ANTLR start "ruleObjectValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1121:1: ruleObjectValue returns [EObject current=null] : (otherlv_0= '{' this_ObjectIdentifierValue_1= ruleObjectIdentifierValue otherlv_2= '}' ) ;
    public final EObject ruleObjectValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_ObjectIdentifierValue_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1124:28: ( (otherlv_0= '{' this_ObjectIdentifierValue_1= ruleObjectIdentifierValue otherlv_2= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1125:1: (otherlv_0= '{' this_ObjectIdentifierValue_1= ruleObjectIdentifierValue otherlv_2= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1125:1: (otherlv_0= '{' this_ObjectIdentifierValue_1= ruleObjectIdentifierValue otherlv_2= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1125:3: otherlv_0= '{' this_ObjectIdentifierValue_1= ruleObjectIdentifierValue otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleObjectValue2363); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getObjectValueAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getObjectValueAccess().getObjectIdentifierValueParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_ruleObjectValue2385);
            this_ObjectIdentifierValue_1=ruleObjectIdentifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ObjectIdentifierValue_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleObjectValue2396); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getObjectValueAccess().getRightCurlyBracketKeyword_2());
                  
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
    // $ANTLR end "ruleObjectValue"


    // $ANTLR start "entryRuleMacro"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1150:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1151:2: (iv_ruleMacro= ruleMacro EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1152:2: iv_ruleMacro= ruleMacro EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroRule()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_entryRuleMacro2432);
            iv_ruleMacro=ruleMacro();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacro; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacro2442); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1159:1: ruleMacro returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1162:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1163:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1163:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1163:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1163:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_NEWLINE) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1163:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro2479); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1167:3: ( (lv_name_1_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1168:1: (lv_name_1_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1168:1: (lv_name_1_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1169:3: lv_name_1_0= RULE_MODULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleMacro2497); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleMacro2514); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMacroAccess().getMACROKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleMacro2526); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_3());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1193:1: (this_NEWLINE_4= RULE_NEWLINE )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_NEWLINE) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1193:2: this_NEWLINE_4= RULE_NEWLINE
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro2538); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_4, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleMacro2551); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMacroAccess().getBEGINKeyword_5());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1201:1: ( (lv_typeNotation_6_0= ruleTypeNotation ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1202:1: (lv_typeNotation_6_0= ruleTypeNotation )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1202:1: (lv_typeNotation_6_0= ruleTypeNotation )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1203:3: lv_typeNotation_6_0= ruleTypeNotation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getTypeNotationTypeNotationParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_ruleMacro2572);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1219:2: ( (lv_valueNotation_7_0= ruleValueNotation ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1220:1: (lv_valueNotation_7_0= ruleValueNotation )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1220:1: (lv_valueNotation_7_0= ruleValueNotation )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1221:3: lv_valueNotation_7_0= ruleValueNotation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getValueNotationValueNotationParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValueNotation_in_ruleMacro2593);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1237:2: ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1238:1: (lv_innerTypes_8_0= ruleTypeDefinition )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1238:1: (lv_innerTypes_8_0= ruleTypeDefinition )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1239:3: lv_innerTypes_8_0= ruleTypeDefinition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleMacro2614);
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
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1255:3: (this_NEWLINE_9= RULE_NEWLINE )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_NEWLINE) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1255:4: this_NEWLINE_9= RULE_NEWLINE
            	    {
            	    this_NEWLINE_9=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro2627); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_9, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_9()); 
            	          
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

            otherlv_10=(Token)match(input,19,FOLLOW_19_in_ruleMacro2640); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1271:1: entryRuleTypeNotation returns [EObject current=null] : iv_ruleTypeNotation= ruleTypeNotation EOF ;
    public final EObject entryRuleTypeNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNotation = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1272:2: (iv_ruleTypeNotation= ruleTypeNotation EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1273:2: iv_ruleTypeNotation= ruleTypeNotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNotationRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation2676);
            iv_ruleTypeNotation=ruleTypeNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNotation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotation2686); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1280:1: ruleTypeNotation returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+ ) ;
    public final EObject ruleTypeNotation() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_typeNotations_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1283:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+ ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1284:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+ )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1284:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1284:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1284:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_NEWLINE) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1284:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTypeNotation2723); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getTypeNotationAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1288:3: ( (lv_name_1_0= 'TYPE' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1289:1: (lv_name_1_0= 'TYPE' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1289:1: (lv_name_1_0= 'TYPE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1290:3: lv_name_1_0= 'TYPE'
            {
            lv_name_1_0=(Token)match(input,28,FOLLOW_28_in_ruleTypeNotation2742); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_1_0, grammarAccess.getTypeNotationAccess().getNameTYPEKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeNotationRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_1_0, "TYPE");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleTypeNotation2767); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTypeNotationAccess().getNOTATIONKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleTypeNotation2779); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTypeNotationAccess().getColonColonEqualsSignKeyword_3());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1311:1: ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                alt31 = dfa31.predict(input);
                switch (alt31) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1312:1: (lv_typeNotations_4_0= ruleTypeAssignment )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1312:1: (lv_typeNotations_4_0= ruleTypeAssignment )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1313:3: lv_typeNotations_4_0= ruleTypeAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeNotationAccess().getTypeNotationsTypeAssignmentParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeAssignment_in_ruleTypeNotation2800);
            	    lv_typeNotations_4_0=ruleTypeAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTypeNotationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"typeNotations",
            	              		lv_typeNotations_4_0, 
            	              		"TypeAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1337:1: entryRuleValueNotation returns [EObject current=null] : iv_ruleValueNotation= ruleValueNotation EOF ;
    public final EObject entryRuleValueNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueNotation = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1338:2: (iv_ruleValueNotation= ruleValueNotation EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1339:2: iv_ruleValueNotation= ruleValueNotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueNotationRule()); 
            }
            pushFollow(FOLLOW_ruleValueNotation_in_entryRuleValueNotation2837);
            iv_ruleValueNotation=ruleValueNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueNotation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNotation2847); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1346:1: ruleValueNotation returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_valueNotations_4_0= ruleValueAssignment ) )+ ) ;
    public final EObject ruleValueNotation() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_valueNotations_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1349:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_valueNotations_4_0= ruleValueAssignment ) )+ ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1350:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_valueNotations_4_0= ruleValueAssignment ) )+ )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1350:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_valueNotations_4_0= ruleValueAssignment ) )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1350:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_valueNotations_4_0= ruleValueAssignment ) )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1350:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_NEWLINE) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1350:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValueNotation2884); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getValueNotationAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1354:3: ( (lv_name_1_0= 'VALUE' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1355:1: (lv_name_1_0= 'VALUE' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1355:1: (lv_name_1_0= 'VALUE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1356:3: lv_name_1_0= 'VALUE'
            {
            lv_name_1_0=(Token)match(input,30,FOLLOW_30_in_ruleValueNotation2903); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_1_0, grammarAccess.getValueNotationAccess().getNameVALUEKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getValueNotationRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_1_0, "VALUE");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleValueNotation2928); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getValueNotationAccess().getNOTATIONKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleValueNotation2940); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getValueNotationAccess().getColonColonEqualsSignKeyword_3());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1377:1: ( (lv_valueNotations_4_0= ruleValueAssignment ) )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_NEWLINE) ) {
                    int LA33_1 = input.LA(2);

                    if ( (LA33_1==37) ) {
                        alt33=1;
                    }


                }
                else if ( (LA33_0==37) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1378:1: (lv_valueNotations_4_0= ruleValueAssignment )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1378:1: (lv_valueNotations_4_0= ruleValueAssignment )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1379:3: lv_valueNotations_4_0= ruleValueAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getValueNotationAccess().getValueNotationsValueAssignmentParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValueAssignment_in_ruleValueNotation2961);
            	    lv_valueNotations_4_0=ruleValueAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getValueNotationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"valueNotations",
            	              		lv_valueNotations_4_0, 
            	              		"ValueAssignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
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
    // $ANTLR end "ruleValueNotation"


    // $ANTLR start "entryRuleTypeAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1403:1: entryRuleTypeAssignment returns [EObject current=null] : iv_ruleTypeAssignment= ruleTypeAssignment EOF ;
    public final EObject entryRuleTypeAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1404:2: (iv_ruleTypeAssignment= ruleTypeAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1405:2: iv_ruleTypeAssignment= ruleTypeAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment2998);
            iv_ruleTypeAssignment=ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAssignment3008); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1412:1: ruleTypeAssignment returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) ) ;
    public final EObject ruleTypeAssignment() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        EObject this_ParamAssignment_1 = null;

        EObject this_TypeReference_2 = null;

        EObject this_MacroValue_3 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1415:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1416:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1416:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1416:2: (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1416:2: (this_NEWLINE_0= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1416:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTypeAssignment3045); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1420:3: (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue )
            int alt35=3;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt35=1;
                }
                break;
            case RULE_MODULE_ID:
            case 31:
                {
                alt35=2;
                }
                break;
            case 37:
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1421:5: this_ParamAssignment_1= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleTypeAssignment3069);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1431:5: this_TypeReference_2= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeAssignment3096);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1441:5: this_MacroValue_3= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getMacroValueParserRuleCall_1_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleTypeAssignment3123);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1457:1: entryRuleParamAssignment returns [EObject current=null] : iv_ruleParamAssignment= ruleParamAssignment EOF ;
    public final EObject entryRuleParamAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1458:2: (iv_ruleParamAssignment= ruleParamAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1459:2: iv_ruleParamAssignment= ruleParamAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment3159);
            iv_ruleParamAssignment=ruleParamAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamAssignment3169); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1466:1: ruleParamAssignment returns [EObject current=null] : ( ( (lv_name_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) ) ;
    public final EObject ruleParamAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1469:28: ( ( ( (lv_name_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1470:1: ( ( (lv_name_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1470:1: ( ( (lv_name_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1470:2: ( (lv_name_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1470:2: ( (lv_name_0_0= RULE_PARAMETER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1471:1: (lv_name_0_0= RULE_PARAMETER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1471:1: (lv_name_0_0= RULE_PARAMETER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1472:3: lv_name_0_0= RULE_PARAMETER
            {
            lv_name_0_0=(Token)match(input,RULE_PARAMETER,FOLLOW_RULE_PARAMETER_in_ruleParamAssignment3211); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getParamAssignmentAccess().getNamePARAMETERTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getParamAssignmentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"PARAMETER");
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1488:2: ( (lv_right_1_0= ruleTypeNotationRight ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1489:1: (lv_right_1_0= ruleTypeNotationRight )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1489:1: (lv_right_1_0= ruleTypeNotationRight )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1490:3: lv_right_1_0= ruleTypeNotationRight
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAssignmentAccess().getRightTypeNotationRightParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeNotationRight_in_ruleParamAssignment3237);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1514:1: entryRuleTypeNotationRight returns [EObject current=null] : iv_ruleTypeNotationRight= ruleTypeNotationRight EOF ;
    public final EObject entryRuleTypeNotationRight() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNotationRight = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1515:2: (iv_ruleTypeNotationRight= ruleTypeNotationRight EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1516:2: iv_ruleTypeNotationRight= ruleTypeNotationRight EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNotationRightRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotationRight_in_entryRuleTypeNotationRight3273);
            iv_ruleTypeNotationRight=ruleTypeNotationRight();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNotationRight; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotationRight3283); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1523:1: ruleTypeNotationRight returns [EObject current=null] : (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) ;
    public final EObject ruleTypeNotationRight() throws RecognitionException {
        EObject current = null;

        EObject this_TypeReference_0 = null;

        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1526:28: ( (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1527:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1527:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_MODULE_ID||LA36_0==31) ) {
                alt36=1;
            }
            else if ( (LA36_0==37) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1528:5: this_TypeReference_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeNotationRightAccess().getTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeNotationRight3330);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1537:6: ( (lv_value_1_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1537:6: ( (lv_value_1_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1538:1: (lv_value_1_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1538:1: (lv_value_1_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1539:3: lv_value_1_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNotationRightAccess().getValueMacroValueParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleTypeNotationRight3356);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1563:1: entryRuleTypeReferenceExt returns [EObject current=null] : iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF ;
    public final EObject entryRuleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReferenceExt = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1564:2: (iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1565:2: iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceExtRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt3392);
            iv_ruleTypeReferenceExt=ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReferenceExt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReferenceExt3402); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1572:1: ruleTypeReferenceExt returns [EObject current=null] : ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? ) ;
    public final EObject ruleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject lv_parentRef_0_0 = null;

        EObject lv_childRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1575:28: ( ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1576:1: ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1576:1: ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1576:2: ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1576:2: ( (lv_parentRef_0_0= ruleTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1577:1: (lv_parentRef_0_0= ruleTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1577:1: (lv_parentRef_0_0= ruleTypeReference )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1578:3: lv_parentRef_0_0= ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getParentRefTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt3448);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1594:2: ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1594:3: ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1599:1: (lv_childRef_1_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1600:3: lv_childRef_1_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getChildRefTypeReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt3479);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1624:1: entryRuleTypeReference returns [EObject current=null] : iv_ruleTypeReference= ruleTypeReference EOF ;
    public final EObject entryRuleTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReference = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1625:2: (iv_ruleTypeReference= ruleTypeReference EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1626:2: iv_ruleTypeReference= ruleTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_entryRuleTypeReference3516);
            iv_ruleTypeReference=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReference3526); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1633:1: ruleTypeReference returns [EObject current=null] : ( ( (otherlv_0= RULE_MODULE_ID ) ) | this_BracedTypeReference_1= ruleBracedTypeReference ) ;
    public final EObject ruleTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_BracedTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1636:28: ( ( ( (otherlv_0= RULE_MODULE_ID ) ) | this_BracedTypeReference_1= ruleBracedTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1637:1: ( ( (otherlv_0= RULE_MODULE_ID ) ) | this_BracedTypeReference_1= ruleBracedTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1637:1: ( ( (otherlv_0= RULE_MODULE_ID ) ) | this_BracedTypeReference_1= ruleBracedTypeReference )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_MODULE_ID) ) {
                alt38=1;
            }
            else if ( (LA38_0==31) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1637:2: ( (otherlv_0= RULE_MODULE_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1637:2: ( (otherlv_0= RULE_MODULE_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1638:1: (otherlv_0= RULE_MODULE_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1638:1: (otherlv_0= RULE_MODULE_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1639:3: otherlv_0= RULE_MODULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeReferenceRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleTypeReference3571); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getTypeReferenceAccess().getTypeReferenceableCrossReference_0_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1652:5: this_BracedTypeReference_1= ruleBracedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeReferenceAccess().getBracedTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBracedTypeReference_in_ruleTypeReference3599);
                    this_BracedTypeReference_1=ruleBracedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BracedTypeReference_1; 
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
    // $ANTLR end "ruleTypeReference"


    // $ANTLR start "entryRuleBracedTypeReference"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1668:1: entryRuleBracedTypeReference returns [EObject current=null] : iv_ruleBracedTypeReference= ruleBracedTypeReference EOF ;
    public final EObject entryRuleBracedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBracedTypeReference = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1669:2: (iv_ruleBracedTypeReference= ruleBracedTypeReference EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1670:2: iv_ruleBracedTypeReference= ruleBracedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBracedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleBracedTypeReference_in_entryRuleBracedTypeReference3634);
            iv_ruleBracedTypeReference=ruleBracedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBracedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBracedTypeReference3644); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBracedTypeReference"


    // $ANTLR start "ruleBracedTypeReference"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1677:1: ruleBracedTypeReference returns [EObject current=null] : (otherlv_0= '\"{\"' this_TypeReference_1= ruleTypeReference otherlv_2= '\"}\"' ) ;
    public final EObject ruleBracedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_TypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1680:28: ( (otherlv_0= '\"{\"' this_TypeReference_1= ruleTypeReference otherlv_2= '\"}\"' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1681:1: (otherlv_0= '\"{\"' this_TypeReference_1= ruleTypeReference otherlv_2= '\"}\"' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1681:1: (otherlv_0= '\"{\"' this_TypeReference_1= ruleTypeReference otherlv_2= '\"}\"' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1681:3: otherlv_0= '\"{\"' this_TypeReference_1= ruleTypeReference otherlv_2= '\"}\"'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleBracedTypeReference3681); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBracedTypeReferenceAccess().getQuotationMarkLeftCurlyBracketQuotationMarkKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBracedTypeReferenceAccess().getTypeReferenceParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleTypeReference_in_ruleBracedTypeReference3703);
            this_TypeReference_1=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeReference_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleBracedTypeReference3714); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getBracedTypeReferenceAccess().getQuotationMarkRightCurlyBracketQuotationMarkKeyword_2());
                  
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
    // $ANTLR end "ruleBracedTypeReference"


    // $ANTLR start "entryRuleValueAssignment"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1706:1: entryRuleValueAssignment returns [EObject current=null] : iv_ruleValueAssignment= ruleValueAssignment EOF ;
    public final EObject entryRuleValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1707:2: (iv_ruleValueAssignment= ruleValueAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1708:2: iv_ruleValueAssignment= ruleValueAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleValueAssignment_in_entryRuleValueAssignment3750);
            iv_ruleValueAssignment=ruleValueAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueAssignment3760); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1715:1: ruleValueAssignment returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueNotation_1_0= ruleMacroValue ) ) ) ;
    public final EObject ruleValueAssignment() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        EObject lv_valueNotation_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1718:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueNotation_1_0= ruleMacroValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1719:1: ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueNotation_1_0= ruleMacroValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1719:1: ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueNotation_1_0= ruleMacroValue ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1719:2: (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueNotation_1_0= ruleMacroValue ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1719:2: (this_NEWLINE_0= RULE_NEWLINE )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_NEWLINE) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1719:3: this_NEWLINE_0= RULE_NEWLINE
                    {
                    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValueAssignment3797); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_0, grammarAccess.getValueAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1723:3: ( (lv_valueNotation_1_0= ruleMacroValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1724:1: (lv_valueNotation_1_0= ruleMacroValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1724:1: (lv_valueNotation_1_0= ruleMacroValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1725:3: lv_valueNotation_1_0= ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueAssignmentAccess().getValueNotationMacroValueParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMacroValue_in_ruleValueAssignment3819);
            lv_valueNotation_1_0=ruleMacroValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueAssignmentRule());
              	        }
                     		set(
                     			current, 
                     			"valueNotation",
                      		lv_valueNotation_1_0, 
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
    // $ANTLR end "ruleValueAssignment"


    // $ANTLR start "entryRuleValue"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1749:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1750:2: (iv_ruleValue= ruleValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1751:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue3855);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue3865); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1758:1: ruleValue returns [EObject current=null] : ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1761:28: ( ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1762:1: ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1762:1: ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1762:2: ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1762:2: ( (lv_tag_0_0= ruleTag ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_NEWLINE) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==35) ) {
                    alt40=1;
                }
            }
            else if ( (LA40_0==35) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1763:1: (lv_tag_0_0= ruleTag )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1763:1: (lv_tag_0_0= ruleTag )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1764:3: lv_tag_0_0= ruleTag
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getTagTagParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTag_in_ruleValue3911);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1780:3: (this_NEWLINE_1= RULE_NEWLINE )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_NEWLINE) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1780:4: this_NEWLINE_1= RULE_NEWLINE
            	    {
            	    this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValue3924); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_1, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1784:3: ( (lv_implicit_2_0= 'IMPLICIT' ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==33) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1785:1: (lv_implicit_2_0= 'IMPLICIT' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1785:1: (lv_implicit_2_0= 'IMPLICIT' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1786:3: lv_implicit_2_0= 'IMPLICIT'
                    {
                    lv_implicit_2_0=(Token)match(input,33,FOLLOW_33_in_ruleValue3943); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1799:3: ( (lv_valueTypes_3_0= ruleValueType ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1800:1: (lv_valueTypes_3_0= ruleValueType )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1800:1: (lv_valueTypes_3_0= ruleValueType )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1801:3: lv_valueTypes_3_0= ruleValueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValueType_in_ruleValue3978);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1817:2: ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )*
            loop44:
            do {
                int alt44=2;
                alt44 = dfa44.predict(input);
                switch (alt44) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1817:3: (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1817:3: (this_NEWLINE_4= RULE_NEWLINE )*
            	    loop43:
            	    do {
            	        int alt43=2;
            	        int LA43_0 = input.LA(1);

            	        if ( (LA43_0==RULE_NEWLINE) ) {
            	            alt43=1;
            	        }


            	        switch (alt43) {
            	    	case 1 :
            	    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1817:4: this_NEWLINE_4= RULE_NEWLINE
            	    	    {
            	    	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValue3991); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_NEWLINE_4, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_4_0()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop43;
            	        }
            	    } while (true);

            	    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleValue4004); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getValueAccess().getVerticalLineKeyword_4_1());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1825:1: ( (lv_valueTypes_6_0= ruleValueType ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1826:1: (lv_valueTypes_6_0= ruleValueType )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1826:1: (lv_valueTypes_6_0= ruleValueType )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1827:3: lv_valueTypes_6_0= ruleValueType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_4_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValueType_in_ruleValue4025);
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
            	    break loop44;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1851:1: entryRuleTag returns [EObject current=null] : iv_ruleTag= ruleTag EOF ;
    public final EObject entryRuleTag() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTag = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1852:2: (iv_ruleTag= ruleTag EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1853:2: iv_ruleTag= ruleTag EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTagRule()); 
            }
            pushFollow(FOLLOW_ruleTag_in_entryRuleTag4063);
            iv_ruleTag=ruleTag();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTag; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTag4073); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1860:1: ruleTag returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' ) ;
    public final EObject ruleTag() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token otherlv_1=null;
        Token lv_tagValue_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1863:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1864:1: ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1864:1: ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1864:2: (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1864:2: (this_NEWLINE_0= RULE_NEWLINE )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_NEWLINE) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1864:3: this_NEWLINE_0= RULE_NEWLINE
                    {
                    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTag4110); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_0, grammarAccess.getTagAccess().getNEWLINETerminalRuleCall_0()); 
                          
                    }

                    }
                    break;

            }

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleTag4123); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTagAccess().getAPPLICATIONKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1872:1: ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1873:1: (lv_tagValue_2_0= RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1873:1: (lv_tagValue_2_0= RULE_BIG_INTEGER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1874:3: lv_tagValue_2_0= RULE_BIG_INTEGER
            {
            lv_tagValue_2_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleTag4140); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,36,FOLLOW_36_in_ruleTag4157); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1902:1: entryRuleValueType returns [EObject current=null] : iv_ruleValueType= ruleValueType EOF ;
    public final EObject entryRuleValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1903:2: (iv_ruleValueType= ruleValueType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1904:2: iv_ruleValueType= ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType4193);
            iv_ruleValueType=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType4203); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1911:1: ruleValueType returns [EObject current=null] : ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_id_1_0= RULE_ASN1_ID ) ) | ( (lv_types_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( () otherlv_6= 'OBJECT IDENTIFIER' ) ) ;
    public final EObject ruleValueType() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;
        Token otherlv_6=null;
        EObject lv_param_0_0 = null;

        EObject lv_types_2_0 = null;

        EObject lv_simpleType_3_0 = null;

        EObject lv_macroValue_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1914:28: ( ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_id_1_0= RULE_ASN1_ID ) ) | ( (lv_types_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( () otherlv_6= 'OBJECT IDENTIFIER' ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1915:1: ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_id_1_0= RULE_ASN1_ID ) ) | ( (lv_types_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( () otherlv_6= 'OBJECT IDENTIFIER' ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1915:1: ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_id_1_0= RULE_ASN1_ID ) ) | ( (lv_types_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( () otherlv_6= 'OBJECT IDENTIFIER' ) )
            int alt46=6;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt46=1;
                }
                break;
            case RULE_ASN1_ID:
                {
                alt46=2;
                }
                break;
            case RULE_MODULE_ID:
            case 31:
                {
                alt46=3;
                }
                break;
            case RULE_IA5STRING:
            case 42:
            case 43:
            case 45:
            case 48:
            case 49:
                {
                alt46=4;
                }
                break;
            case 37:
                {
                alt46=5;
                }
                break;
            case 24:
                {
                alt46=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1915:2: ( (lv_param_0_0= ruleParamAssignment ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1915:2: ( (lv_param_0_0= ruleParamAssignment ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1916:1: (lv_param_0_0= ruleParamAssignment )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1916:1: (lv_param_0_0= ruleParamAssignment )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1917:3: lv_param_0_0= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleValueType4249);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1934:6: ( (lv_id_1_0= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1934:6: ( (lv_id_1_0= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1935:1: (lv_id_1_0= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1935:1: (lv_id_1_0= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1936:3: lv_id_1_0= RULE_ASN1_ID
                    {
                    lv_id_1_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleValueType4272); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_id_1_0, grammarAccess.getValueTypeAccess().getIdASN1_IDTerminalRuleCall_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getValueTypeRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"id",
                              		lv_id_1_0, 
                              		"ASN1_ID");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1953:6: ( (lv_types_2_0= ruleTypeReferenceExt ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1953:6: ( (lv_types_2_0= ruleTypeReferenceExt ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1954:1: (lv_types_2_0= ruleTypeReferenceExt )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1954:1: (lv_types_2_0= ruleTypeReferenceExt )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1955:3: lv_types_2_0= ruleTypeReferenceExt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getTypesTypeReferenceExtParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReferenceExt_in_ruleValueType4304);
                    lv_types_2_0=ruleTypeReferenceExt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"types",
                              		lv_types_2_0, 
                              		"TypeReferenceExt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1972:6: ( (lv_simpleType_3_0= ruleASN1_TYPE ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1972:6: ( (lv_simpleType_3_0= ruleASN1_TYPE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1973:1: (lv_simpleType_3_0= ruleASN1_TYPE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1973:1: (lv_simpleType_3_0= ruleASN1_TYPE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1974:3: lv_simpleType_3_0= ruleASN1_TYPE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_TYPE_in_ruleValueType4331);
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
                case 5 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1991:6: ( (lv_macroValue_4_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1991:6: ( (lv_macroValue_4_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1992:1: (lv_macroValue_4_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1992:1: (lv_macroValue_4_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1993:3: lv_macroValue_4_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleValueType4358);
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
                case 6 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2010:6: ( () otherlv_6= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2010:6: ( () otherlv_6= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2010:7: () otherlv_6= 'OBJECT IDENTIFIER'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2010:7: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2011:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getValueTypeAccess().getValueTypeAction_5_0(),
                                  current);
                          
                    }

                    }

                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleValueType4386); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getValueTypeAccess().getOBJECTIDENTIFIERKeyword_5_1());
                          
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2028:1: entryRuleMacroValue returns [EObject current=null] : iv_ruleMacroValue= ruleMacroValue EOF ;
    public final EObject entryRuleMacroValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacroValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2029:2: (iv_ruleMacroValue= ruleMacroValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2030:2: iv_ruleMacroValue= ruleMacroValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroValueRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue4423);
            iv_ruleMacroValue=ruleMacroValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacroValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue4433); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2037:1: ruleMacroValue returns [EObject current=null] : ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMacroValueType ) ) otherlv_4= ')' ) ;
    public final EObject ruleMacroValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_valueType_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2040:28: ( ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMacroValueType ) ) otherlv_4= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2041:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMacroValueType ) ) otherlv_4= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2041:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMacroValueType ) ) otherlv_4= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2041:2: () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMacroValueType ) ) otherlv_4= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2041:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2042:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getMacroValueAccess().getMacroValueAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleMacroValue4479); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMacroValueAccess().getValueKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleMacroValue4491); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMacroValueAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2055:1: ( (lv_valueType_3_0= ruleMacroValueType ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2056:1: (lv_valueType_3_0= ruleMacroValueType )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2056:1: (lv_valueType_3_0= ruleMacroValueType )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2057:3: lv_valueType_3_0= ruleMacroValueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroValueAccess().getValueTypeMacroValueTypeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMacroValueType_in_ruleMacroValue4512);
            lv_valueType_3_0=ruleMacroValueType();

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
                      		"MacroValueType");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleMacroValue4524); if (state.failed) return current;
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


    // $ANTLR start "entryRuleMacroValueType"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2085:1: entryRuleMacroValueType returns [EObject current=null] : iv_ruleMacroValueType= ruleMacroValueType EOF ;
    public final EObject entryRuleMacroValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacroValueType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2086:2: (iv_ruleMacroValueType= ruleMacroValueType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2087:2: iv_ruleMacroValueType= ruleMacroValueType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValueType_in_entryRuleMacroValueType4560);
            iv_ruleMacroValueType=ruleMacroValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacroValueType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValueType4570); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMacroValueType"


    // $ANTLR start "ruleMacroValueType"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2094:1: ruleMacroValueType returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) ) ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) ) ) ;
    public final EObject ruleMacroValueType() throws RecognitionException {
        EObject current = null;

        Token lv_update_1_0=null;
        Token lv_valueCAP_2_0=null;
        Token lv_oi_4_0=null;
        Token lv_string_5_0=null;
        EObject lv_ref_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2097:28: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) ) ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2098:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) ) ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2098:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) ) ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2098:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) ) ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2098:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2100:1: ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2100:1: ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2101:2: ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0());
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2104:2: ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2105:3: ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2105:3: ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )*
            loop47:
            do {
                int alt47=3;
                int LA47_0 = input.LA(1);

                if ( LA47_0 ==40 && getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 0) ) {
                    alt47=1;
                }
                else if ( LA47_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 1) ) {
                    alt47=2;
                }


                switch (alt47) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2107:4: ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2107:4: ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2108:5: {...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMacroValueType", "getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2108:111: ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2109:6: ({...}? => ( (lv_update_1_0= 'Update' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 0);
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2112:6: ({...}? => ( (lv_update_1_0= 'Update' ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2112:7: {...}? => ( (lv_update_1_0= 'Update' ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMacroValueType", "true");
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2112:16: ( (lv_update_1_0= 'Update' ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2113:1: (lv_update_1_0= 'Update' )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2113:1: (lv_update_1_0= 'Update' )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2114:3: lv_update_1_0= 'Update'
            	    {
            	    lv_update_1_0=(Token)match(input,40,FOLLOW_40_in_ruleMacroValueType4658); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_update_1_0, grammarAccess.getMacroValueTypeAccess().getUpdateUpdateKeyword_0_0_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getMacroValueTypeRule());
            	      	        }
            	             		setWithLastConsumed(current, "update", true, "Update");
            	      	    
            	    }

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2134:4: ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2134:4: ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2135:5: {...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMacroValueType", "getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2135:111: ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2136:6: ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 1);
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2139:6: ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2139:7: {...}? => ( (lv_valueCAP_2_0= 'VALUE' ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMacroValueType", "true");
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2139:16: ( (lv_valueCAP_2_0= 'VALUE' ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2140:1: (lv_valueCAP_2_0= 'VALUE' )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2140:1: (lv_valueCAP_2_0= 'VALUE' )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2141:3: lv_valueCAP_2_0= 'VALUE'
            	    {
            	    lv_valueCAP_2_0=(Token)match(input,30,FOLLOW_30_in_ruleMacroValueType4743); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_valueCAP_2_0, grammarAccess.getMacroValueTypeAccess().getValueCAPVALUEKeyword_0_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getMacroValueTypeRule());
            	      	        }
            	             		setWithLastConsumed(current, "valueCAP", true, "VALUE");
            	      	    
            	    }

            	    }


            	    }


            	    }

            	    getUnorderedGroupHelper().returnFromSelection(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0());

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0());

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2168:2: ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) )
            int alt48=3;
            switch ( input.LA(1) ) {
            case RULE_MODULE_ID:
            case 31:
                {
                alt48=1;
                }
                break;
            case 24:
                {
                alt48=2;
                }
                break;
            case 41:
                {
                alt48=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2168:3: ( (lv_ref_3_0= ruleTypeReference ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2168:3: ( (lv_ref_3_0= ruleTypeReference ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2169:1: (lv_ref_3_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2169:1: (lv_ref_3_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2170:3: lv_ref_3_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMacroValueTypeAccess().getRefTypeReferenceParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleMacroValueType4818);
                    lv_ref_3_0=ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMacroValueTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"ref",
                              		lv_ref_3_0, 
                              		"TypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2187:6: ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2187:6: ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2188:1: (lv_oi_4_0= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2188:1: (lv_oi_4_0= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2189:3: lv_oi_4_0= 'OBJECT IDENTIFIER'
                    {
                    lv_oi_4_0=(Token)match(input,24,FOLLOW_24_in_ruleMacroValueType4842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_oi_4_0, grammarAccess.getMacroValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_1_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMacroValueTypeRule());
                      	        }
                             		setWithLastConsumed(current, "oi", lv_oi_4_0, "OBJECT IDENTIFIER");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2203:6: ( (lv_string_5_0= 'IA5String' ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2203:6: ( (lv_string_5_0= 'IA5String' ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2204:1: (lv_string_5_0= 'IA5String' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2204:1: (lv_string_5_0= 'IA5String' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2205:3: lv_string_5_0= 'IA5String'
                    {
                    lv_string_5_0=(Token)match(input,41,FOLLOW_41_in_ruleMacroValueType4879); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_string_5_0, grammarAccess.getMacroValueTypeAccess().getStringIA5StringKeyword_1_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMacroValueTypeRule());
                      	        }
                             		setWithLastConsumed(current, "string", lv_string_5_0, "IA5String");
                      	    
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
    // $ANTLR end "ruleMacroValueType"


    // $ANTLR start "entryRuleASN1_TYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2226:1: entryRuleASN1_TYPE returns [EObject current=null] : iv_ruleASN1_TYPE= ruleASN1_TYPE EOF ;
    public final EObject entryRuleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_TYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2227:2: (iv_ruleASN1_TYPE= ruleASN1_TYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2228:2: iv_ruleASN1_TYPE= ruleASN1_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE4929);
            iv_ruleASN1_TYPE=ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_TYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE4939); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2235:1: ruleASN1_TYPE returns [EObject current=null] : (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE | this_ASN1_SEQUENCE_2= ruleASN1_SEQUENCE ) ;
    public final EObject ruleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject this_ASN1_SIMPLE_0 = null;

        EObject this_ASN1_CHOICE_1 = null;

        EObject this_ASN1_SEQUENCE_2 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2238:28: ( (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE | this_ASN1_SEQUENCE_2= ruleASN1_SEQUENCE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2239:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE | this_ASN1_SEQUENCE_2= ruleASN1_SEQUENCE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2239:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE | this_ASN1_SEQUENCE_2= ruleASN1_SEQUENCE )
            int alt49=3;
            switch ( input.LA(1) ) {
            case RULE_IA5STRING:
            case 42:
            case 43:
            case 45:
                {
                alt49=1;
                }
                break;
            case 48:
                {
                alt49=2;
                }
                break;
            case 49:
                {
                alt49=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2240:5: this_ASN1_SIMPLE_0= ruleASN1_SIMPLE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE4986);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2250:5: this_ASN1_CHOICE_1= ruleASN1_CHOICE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE5013);
                    this_ASN1_CHOICE_1=ruleASN1_CHOICE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_CHOICE_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2260:5: this_ASN1_SEQUENCE_2= ruleASN1_SEQUENCE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_SEQUENCEParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_SEQUENCE_in_ruleASN1_TYPE5040);
                    this_ASN1_SEQUENCE_2=ruleASN1_SEQUENCE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_SEQUENCE_2; 
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2276:1: entryRuleASN1_SIMPLE returns [EObject current=null] : iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF ;
    public final EObject entryRuleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SIMPLE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2277:2: (iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2278:2: iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SIMPLERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE5075);
            iv_ruleASN1_SIMPLE=ruleASN1_SIMPLE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SIMPLE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE5085); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2285:1: ruleASN1_SIMPLE returns [EObject current=null] : ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER ) ;
    public final EObject ruleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_IA5STRING_3=null;
        EObject this_ASN1_OCTET_STRING_4 = null;

        EObject lv_constraint_5_0 = null;

        EObject this_ASN1_INTEGER_6 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2288:28: ( ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2289:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2289:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER )
            int alt51=4;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt51=1;
                }
                break;
            case RULE_IA5STRING:
                {
                alt51=2;
                }
                break;
            case 43:
                {
                alt51=3;
                }
                break;
            case 45:
                {
                alt51=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2289:2: ( () otherlv_1= 'empty' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2289:2: ( () otherlv_1= 'empty' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2289:3: () otherlv_1= 'empty'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2289:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2290:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleASN1_SIMPLE5132); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2300:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2300:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2300:7: () this_IA5STRING_3= RULE_IA5STRING
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2300:7: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2301:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_1_0(),
                                  current);
                          
                    }

                    }

                    this_IA5STRING_3=(Token)match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE5160); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_IA5STRING_3, grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2311:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2311:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2312:5: this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE5189);
                    this_ASN1_OCTET_STRING_4=ruleASN1_OCTET_STRING();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_OCTET_STRING_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2320:1: ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==38) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2321:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2321:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2322:3: lv_constraint_5_0= ruleASN1_SUBTYPE
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE5209);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2340:5: this_ASN1_INTEGER_6= ruleASN1_INTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE5239);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2356:1: entryRuleASN1_OCTET_STRING returns [EObject current=null] : iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF ;
    public final EObject entryRuleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_OCTET_STRING = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2357:2: (iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2358:2: iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING5274);
            iv_ruleASN1_OCTET_STRING=ruleASN1_OCTET_STRING();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_OCTET_STRING; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING5284); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2365:1: ruleASN1_OCTET_STRING returns [EObject current=null] : ( () otherlv_1= 'OCTET' otherlv_2= 'STRING' ) ;
    public final EObject ruleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2368:28: ( ( () otherlv_1= 'OCTET' otherlv_2= 'STRING' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2369:1: ( () otherlv_1= 'OCTET' otherlv_2= 'STRING' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2369:1: ( () otherlv_1= 'OCTET' otherlv_2= 'STRING' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2369:2: () otherlv_1= 'OCTET' otherlv_2= 'STRING'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2369:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2370:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleASN1_OCTET_STRING5330); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_OCTET_STRINGAccess().getOCTETKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleASN1_OCTET_STRING5342); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getASN1_OCTET_STRINGAccess().getSTRINGKeyword_2());
                  
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2391:1: entryRuleASN1_INTEGER returns [EObject current=null] : iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF ;
    public final EObject entryRuleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_INTEGER = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2392:2: (iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2393:2: iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_INTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER5378);
            iv_ruleASN1_INTEGER=ruleASN1_INTEGER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_INTEGER; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER5388); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2400:1: ruleASN1_INTEGER returns [EObject current=null] : ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )? ) ;
    public final EObject ruleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_range_2_0 = null;

        EObject lv_refinement_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2403:28: ( ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )? ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2404:1: ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )? )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2404:1: ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )? )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2404:2: ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )?
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2404:2: ( (lv_name_0_0= 'INTEGER' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2405:1: (lv_name_0_0= 'INTEGER' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2405:1: (lv_name_0_0= 'INTEGER' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2406:3: lv_name_0_0= 'INTEGER'
            {
            lv_name_0_0=(Token)match(input,45,FOLLOW_45_in_ruleASN1_INTEGER5431); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2419:2: (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==38) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2419:4: otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleASN1_INTEGER5457); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getASN1_INTEGERAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2423:1: ( (lv_range_2_0= ruleASN1_RANGE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2424:1: (lv_range_2_0= ruleASN1_RANGE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2424:1: (lv_range_2_0= ruleASN1_RANGE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2425:3: lv_range_2_0= ruleASN1_RANGE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getASN1_INTEGERAccess().getRangeASN1_RANGEParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_INTEGER5478);
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

                    otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleASN1_INTEGER5490); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getASN1_INTEGERAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2445:3: ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==25) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2446:1: (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2446:1: (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2447:3: lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getASN1_INTEGERAccess().getRefinementASN1_INTEGER_REFINEMENTParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_INTEGER_REFINEMENT_in_ruleASN1_INTEGER5513);
                    lv_refinement_4_0=ruleASN1_INTEGER_REFINEMENT();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getASN1_INTEGERRule());
                      	        }
                             		set(
                             			current, 
                             			"refinement",
                              		lv_refinement_4_0, 
                              		"ASN1_INTEGER_REFINEMENT");
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
    // $ANTLR end "ruleASN1_INTEGER"


    // $ANTLR start "entryRuleASN1_INTEGER_REFINEMENT"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2471:1: entryRuleASN1_INTEGER_REFINEMENT returns [EObject current=null] : iv_ruleASN1_INTEGER_REFINEMENT= ruleASN1_INTEGER_REFINEMENT EOF ;
    public final EObject entryRuleASN1_INTEGER_REFINEMENT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_INTEGER_REFINEMENT = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2472:2: (iv_ruleASN1_INTEGER_REFINEMENT= ruleASN1_INTEGER_REFINEMENT EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2473:2: iv_ruleASN1_INTEGER_REFINEMENT= ruleASN1_INTEGER_REFINEMENT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_INTEGER_REFINEMENTRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_REFINEMENT_in_entryRuleASN1_INTEGER_REFINEMENT5550);
            iv_ruleASN1_INTEGER_REFINEMENT=ruleASN1_INTEGER_REFINEMENT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_INTEGER_REFINEMENT; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER_REFINEMENT5560); if (state.failed) return current;

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
    // $ANTLR end "entryRuleASN1_INTEGER_REFINEMENT"


    // $ANTLR start "ruleASN1_INTEGER_REFINEMENT"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2480:1: ruleASN1_INTEGER_REFINEMENT returns [EObject current=null] : (otherlv_0= '{' ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' ) (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )* (this_NEWLINE_12= RULE_NEWLINE )* otherlv_13= '}' ) ;
    public final EObject ruleASN1_INTEGER_REFINEMENT() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NEWLINE_1=null;
        Token lv_refinements_2_0=null;
        Token otherlv_3=null;
        Token lv_ints_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token this_NEWLINE_7=null;
        Token lv_refinements_8_0=null;
        Token otherlv_9=null;
        Token lv_ints_10_0=null;
        Token otherlv_11=null;
        Token this_NEWLINE_12=null;
        Token otherlv_13=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2483:28: ( (otherlv_0= '{' ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' ) (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )* (this_NEWLINE_12= RULE_NEWLINE )* otherlv_13= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2484:1: (otherlv_0= '{' ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' ) (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )* (this_NEWLINE_12= RULE_NEWLINE )* otherlv_13= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2484:1: (otherlv_0= '{' ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' ) (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )* (this_NEWLINE_12= RULE_NEWLINE )* otherlv_13= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2484:3: otherlv_0= '{' ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' ) (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )* (this_NEWLINE_12= RULE_NEWLINE )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleASN1_INTEGER_REFINEMENT5597); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2488:1: ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2488:2: (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2488:2: (this_NEWLINE_1= RULE_NEWLINE )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_NEWLINE) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2488:3: this_NEWLINE_1= RULE_NEWLINE
            	    {
            	    this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5610); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_1, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getNEWLINETerminalRuleCall_1_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2492:3: ( (lv_refinements_2_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2493:1: (lv_refinements_2_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2493:1: (lv_refinements_2_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2494:3: lv_refinements_2_0= RULE_ASN1_ID
            {
            lv_refinements_2_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_INTEGER_REFINEMENT5628); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_refinements_2_0, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getRefinementsASN1_IDTerminalRuleCall_1_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getASN1_INTEGER_REFINEMENTRule());
              	        }
                     		addWithLastConsumed(
                     			current, 
                     			"refinements",
                      		lv_refinements_2_0, 
                      		"ASN1_ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,38,FOLLOW_38_in_ruleASN1_INTEGER_REFINEMENT5645); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getLeftParenthesisKeyword_1_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2514:1: ( (lv_ints_4_0= RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2515:1: (lv_ints_4_0= RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2515:1: (lv_ints_4_0= RULE_BIG_INTEGER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2516:3: lv_ints_4_0= RULE_BIG_INTEGER
            {
            lv_ints_4_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_INTEGER_REFINEMENT5662); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_ints_4_0, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getIntsBIG_INTEGERTerminalRuleCall_1_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getASN1_INTEGER_REFINEMENTRule());
              	        }
                     		addWithLastConsumed(
                     			current, 
                     			"ints",
                      		lv_ints_4_0, 
                      		"BIG_INTEGER");
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_39_in_ruleASN1_INTEGER_REFINEMENT5679); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getRightParenthesisKeyword_1_4());
                  
            }

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2536:2: (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==23) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2536:4: otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')'
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleASN1_INTEGER_REFINEMENT5693); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2540:1: (this_NEWLINE_7= RULE_NEWLINE )*
            	    loop55:
            	    do {
            	        int alt55=2;
            	        int LA55_0 = input.LA(1);

            	        if ( (LA55_0==RULE_NEWLINE) ) {
            	            alt55=1;
            	        }


            	        switch (alt55) {
            	    	case 1 :
            	    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2540:2: this_NEWLINE_7= RULE_NEWLINE
            	    	    {
            	    	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5705); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_NEWLINE_7, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getNEWLINETerminalRuleCall_2_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop55;
            	        }
            	    } while (true);

            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2544:3: ( (lv_refinements_8_0= RULE_ASN1_ID ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2545:1: (lv_refinements_8_0= RULE_ASN1_ID )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2545:1: (lv_refinements_8_0= RULE_ASN1_ID )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2546:3: lv_refinements_8_0= RULE_ASN1_ID
            	    {
            	    lv_refinements_8_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_INTEGER_REFINEMENT5723); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_refinements_8_0, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getRefinementsASN1_IDTerminalRuleCall_2_2_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getASN1_INTEGER_REFINEMENTRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"refinements",
            	              		lv_refinements_8_0, 
            	              		"ASN1_ID");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_9=(Token)match(input,38,FOLLOW_38_in_ruleASN1_INTEGER_REFINEMENT5740); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getLeftParenthesisKeyword_2_3());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2566:1: ( (lv_ints_10_0= RULE_BIG_INTEGER ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2567:1: (lv_ints_10_0= RULE_BIG_INTEGER )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2567:1: (lv_ints_10_0= RULE_BIG_INTEGER )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2568:3: lv_ints_10_0= RULE_BIG_INTEGER
            	    {
            	    lv_ints_10_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_INTEGER_REFINEMENT5757); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_ints_10_0, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getIntsBIG_INTEGERTerminalRuleCall_2_4_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getASN1_INTEGER_REFINEMENTRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"ints",
            	              		lv_ints_10_0, 
            	              		"BIG_INTEGER");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_11=(Token)match(input,39,FOLLOW_39_in_ruleASN1_INTEGER_REFINEMENT5774); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_11, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getRightParenthesisKeyword_2_5());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2588:3: (this_NEWLINE_12= RULE_NEWLINE )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_NEWLINE) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2588:4: this_NEWLINE_12= RULE_NEWLINE
            	    {
            	    this_NEWLINE_12=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5788); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_12, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getNEWLINETerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            otherlv_13=(Token)match(input,26,FOLLOW_26_in_ruleASN1_INTEGER_REFINEMENT5801); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getRightCurlyBracketKeyword_4());
                  
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
    // $ANTLR end "ruleASN1_INTEGER_REFINEMENT"


    // $ANTLR start "entryRuleASN1_SUBTYPE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2604:1: entryRuleASN1_SUBTYPE returns [EObject current=null] : iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF ;
    public final EObject entryRuleASN1_SUBTYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SUBTYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2605:2: (iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2606:2: iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SUBTYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE5837);
            iv_ruleASN1_SUBTYPE=ruleASN1_SUBTYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SUBTYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE5847); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2613:1: ruleASN1_SUBTYPE returns [EObject current=null] : (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2616:28: ( (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2617:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2617:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2617:3: otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleASN1_SUBTYPE5884); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleASN1_SUBTYPE5896); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleASN1_SUBTYPE5908); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2629:1: ( (lv_ranges_3_0= ruleASN1_RANGE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2630:1: (lv_ranges_3_0= ruleASN1_RANGE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2630:1: (lv_ranges_3_0= ruleASN1_RANGE )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2631:3: lv_ranges_3_0= ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE5929);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2647:2: (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==34) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2647:4: otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    {
            	    otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleASN1_SUBTYPE5942); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getASN1_SUBTYPEAccess().getVerticalLineKeyword_4_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2651:1: ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2652:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2652:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2653:3: lv_ranges_5_0= ruleASN1_RANGE
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE5963);
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
            	    break loop58;
                }
            } while (true);

            otherlv_6=(Token)match(input,39,FOLLOW_39_in_ruleASN1_SUBTYPE5977); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,39,FOLLOW_39_in_ruleASN1_SUBTYPE5989); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2685:1: entryRuleASN1_RANGE returns [EObject current=null] : iv_ruleASN1_RANGE= ruleASN1_RANGE EOF ;
    public final EObject entryRuleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_RANGE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2686:2: (iv_ruleASN1_RANGE= ruleASN1_RANGE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2687:2: iv_ruleASN1_RANGE= ruleASN1_RANGE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_RANGERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE6025);
            iv_ruleASN1_RANGE=ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_RANGE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE6035); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2694:1: ruleASN1_RANGE returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) ) ;
    public final EObject ruleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_start_2_0=null;
        Token otherlv_3=null;
        Token lv_end_4_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2697:28: ( ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2698:1: ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2698:1: ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_BIG_INTEGER) ) {
                int LA59_1 = input.LA(2);

                if ( (LA59_1==47) ) {
                    alt59=2;
                }
                else if ( (LA59_1==EOF||LA59_1==34||LA59_1==39) ) {
                    alt59=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2698:2: ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2698:2: ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2698:3: () ( (lv_value_1_0= RULE_BIG_INTEGER ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2698:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2699:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2704:2: ( (lv_value_1_0= RULE_BIG_INTEGER ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2705:1: (lv_value_1_0= RULE_BIG_INTEGER )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2705:1: (lv_value_1_0= RULE_BIG_INTEGER )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2706:3: lv_value_1_0= RULE_BIG_INTEGER
                    {
                    lv_value_1_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE6087); if (state.failed) return current;
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2723:6: ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2723:6: ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2723:7: ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2723:7: ( (lv_start_2_0= RULE_BIG_INTEGER ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2724:1: (lv_start_2_0= RULE_BIG_INTEGER )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2724:1: (lv_start_2_0= RULE_BIG_INTEGER )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2725:3: lv_start_2_0= RULE_BIG_INTEGER
                    {
                    lv_start_2_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE6117); if (state.failed) return current;
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

                    otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleASN1_RANGE6134); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_1_1());
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2745:1: ( (lv_end_4_0= RULE_BIG_INTEGER ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2746:1: (lv_end_4_0= RULE_BIG_INTEGER )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2746:1: (lv_end_4_0= RULE_BIG_INTEGER )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2747:3: lv_end_4_0= RULE_BIG_INTEGER
                    {
                    lv_end_4_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE6151); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2771:1: entryRuleASN1_CHOICE returns [EObject current=null] : iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF ;
    public final EObject entryRuleASN1_CHOICE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2772:2: (iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2773:2: iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE6193);
            iv_ruleASN1_CHOICE=ruleASN1_CHOICE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE6203); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2780:1: ruleASN1_CHOICE returns [EObject current=null] : (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2783:28: ( (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2784:1: (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2784:1: (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2784:3: otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleASN1_CHOICE6240); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleASN1_CHOICE6252); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2792:1: (this_NEWLINE_2= RULE_NEWLINE )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_NEWLINE) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2792:2: this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6264); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_2, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2796:3: ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2797:1: (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2797:1: (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2798:3: lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE6286);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2814:2: (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==23) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2814:4: otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleASN1_CHOICE6299); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2818:1: (this_NEWLINE_5= RULE_NEWLINE )+
            	    int cnt61=0;
            	    loop61:
            	    do {
            	        int alt61=2;
            	        int LA61_0 = input.LA(1);

            	        if ( (LA61_0==RULE_NEWLINE) ) {
            	            alt61=1;
            	        }


            	        switch (alt61) {
            	    	case 1 :
            	    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2818:2: this_NEWLINE_5= RULE_NEWLINE
            	    	    {
            	    	    this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6311); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_NEWLINE_5, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_4_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt61 >= 1 ) break loop61;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(61, input);
            	                throw eee;
            	        }
            	        cnt61++;
            	    } while (true);

            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2822:3: ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2823:1: (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2823:1: (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2824:3: lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_4_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE6333);
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
            	    break loop62;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2840:4: (this_NEWLINE_7= RULE_NEWLINE )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_NEWLINE) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2840:5: this_NEWLINE_7= RULE_NEWLINE
            	    {
            	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6347); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_7, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt63 >= 1 ) break loop63;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
            } while (true);

            otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleASN1_CHOICE6360); if (state.failed) return current;
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


    // $ANTLR start "entryRuleASN1_SEQUENCE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2856:1: entryRuleASN1_SEQUENCE returns [EObject current=null] : iv_ruleASN1_SEQUENCE= ruleASN1_SEQUENCE EOF ;
    public final EObject entryRuleASN1_SEQUENCE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SEQUENCE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2857:2: (iv_ruleASN1_SEQUENCE= ruleASN1_SEQUENCE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2858:2: iv_ruleASN1_SEQUENCE= ruleASN1_SEQUENCE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SEQUENCERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SEQUENCE_in_entryRuleASN1_SEQUENCE6396);
            iv_ruleASN1_SEQUENCE=ruleASN1_SEQUENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SEQUENCE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SEQUENCE6406); if (state.failed) return current;

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
    // $ANTLR end "entryRuleASN1_SEQUENCE"


    // $ANTLR start "ruleASN1_SEQUENCE"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2865:1: ruleASN1_SEQUENCE returns [EObject current=null] : (otherlv_0= 'SEQUENCE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' ) ;
    public final EObject ruleASN1_SEQUENCE() throws RecognitionException {
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2868:28: ( (otherlv_0= 'SEQUENCE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2869:1: (otherlv_0= 'SEQUENCE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2869:1: (otherlv_0= 'SEQUENCE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2869:3: otherlv_0= 'SEQUENCE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleASN1_SEQUENCE6443); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_SEQUENCEAccess().getSEQUENCEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleASN1_SEQUENCE6455); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_SEQUENCEAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2877:1: (this_NEWLINE_2= RULE_NEWLINE )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_NEWLINE) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2877:2: this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6467); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_2, grammarAccess.getASN1_SEQUENCEAccess().getNEWLINETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2881:3: ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2882:1: (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2882:1: (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2883:3: lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_SEQUENCEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_SEQUENCE6489);
            lv_choiceType_3_0=ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getASN1_SEQUENCERule());
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2899:2: (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==23) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2899:4: otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleASN1_SEQUENCE6502); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getASN1_SEQUENCEAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2903:1: (this_NEWLINE_5= RULE_NEWLINE )+
            	    int cnt65=0;
            	    loop65:
            	    do {
            	        int alt65=2;
            	        int LA65_0 = input.LA(1);

            	        if ( (LA65_0==RULE_NEWLINE) ) {
            	            alt65=1;
            	        }


            	        switch (alt65) {
            	    	case 1 :
            	    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2903:2: this_NEWLINE_5= RULE_NEWLINE
            	    	    {
            	    	    this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6514); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_NEWLINE_5, grammarAccess.getASN1_SEQUENCEAccess().getNEWLINETerminalRuleCall_4_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt65 >= 1 ) break loop65;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(65, input);
            	                throw eee;
            	        }
            	        cnt65++;
            	    } while (true);

            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2907:3: ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2908:1: (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2908:1: (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2909:3: lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_SEQUENCEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_4_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_SEQUENCE6536);
            	    lv_choiceType_6_0=ruleASN1_CHOICE_ENTRY();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getASN1_SEQUENCERule());
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
            	    break loop66;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2925:4: (this_NEWLINE_7= RULE_NEWLINE )+
            int cnt67=0;
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==RULE_NEWLINE) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2925:5: this_NEWLINE_7= RULE_NEWLINE
            	    {
            	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6550); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_7, grammarAccess.getASN1_SEQUENCEAccess().getNEWLINETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt67 >= 1 ) break loop67;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(67, input);
                        throw eee;
                }
                cnt67++;
            } while (true);

            otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleASN1_SEQUENCE6563); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getASN1_SEQUENCEAccess().getRightCurlyBracketKeyword_6());
                  
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
    // $ANTLR end "ruleASN1_SEQUENCE"


    // $ANTLR start "entryRuleASN1_SEQUENCE_OF"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2941:1: entryRuleASN1_SEQUENCE_OF returns [EObject current=null] : iv_ruleASN1_SEQUENCE_OF= ruleASN1_SEQUENCE_OF EOF ;
    public final EObject entryRuleASN1_SEQUENCE_OF() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SEQUENCE_OF = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2942:2: (iv_ruleASN1_SEQUENCE_OF= ruleASN1_SEQUENCE_OF EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2943:2: iv_ruleASN1_SEQUENCE_OF= ruleASN1_SEQUENCE_OF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SEQUENCE_OFRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SEQUENCE_OF_in_entryRuleASN1_SEQUENCE_OF6599);
            iv_ruleASN1_SEQUENCE_OF=ruleASN1_SEQUENCE_OF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SEQUENCE_OF; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SEQUENCE_OF6609); if (state.failed) return current;

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
    // $ANTLR end "entryRuleASN1_SEQUENCE_OF"


    // $ANTLR start "ruleASN1_SEQUENCE_OF"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2950:1: ruleASN1_SEQUENCE_OF returns [EObject current=null] : (otherlv_0= 'SEQUENCE' otherlv_1= 'OF' ( (lv_ref_2_0= ruleTypeReference ) ) ) ;
    public final EObject ruleASN1_SEQUENCE_OF() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_ref_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2953:28: ( (otherlv_0= 'SEQUENCE' otherlv_1= 'OF' ( (lv_ref_2_0= ruleTypeReference ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2954:1: (otherlv_0= 'SEQUENCE' otherlv_1= 'OF' ( (lv_ref_2_0= ruleTypeReference ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2954:1: (otherlv_0= 'SEQUENCE' otherlv_1= 'OF' ( (lv_ref_2_0= ruleTypeReference ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2954:3: otherlv_0= 'SEQUENCE' otherlv_1= 'OF' ( (lv_ref_2_0= ruleTypeReference ) )
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleASN1_SEQUENCE_OF6646); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_SEQUENCE_OFAccess().getSEQUENCEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleASN1_SEQUENCE_OF6658); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_SEQUENCE_OFAccess().getOFKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2962:1: ( (lv_ref_2_0= ruleTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2963:1: (lv_ref_2_0= ruleTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2963:1: (lv_ref_2_0= ruleTypeReference )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2964:3: lv_ref_2_0= ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_SEQUENCE_OFAccess().getRefTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeReference_in_ruleASN1_SEQUENCE_OF6679);
            lv_ref_2_0=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getASN1_SEQUENCE_OFRule());
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
    // $ANTLR end "ruleASN1_SEQUENCE_OF"


    // $ANTLR start "entryRuleASN1_CHOICE_ENTRY"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2988:1: entryRuleASN1_CHOICE_ENTRY returns [EObject current=null] : iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF ;
    public final EObject entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE_ENTRY = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2989:2: (iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2990:2: iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY6715);
            iv_ruleASN1_CHOICE_ENTRY=ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE_ENTRY; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY6725); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2997:1: ruleASN1_CHOICE_ENTRY returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) ) ;
    public final EObject ruleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token this_NEWLINE_1=null;
        EObject lv_valueType_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3000:28: ( ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3001:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3001:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3001:2: ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3001:2: ( (lv_id_0_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3002:1: (lv_id_0_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3002:1: (lv_id_0_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3003:3: lv_id_0_0= RULE_ASN1_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY6767); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3019:2: (this_NEWLINE_1= RULE_NEWLINE )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_NEWLINE) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3019:3: this_NEWLINE_1= RULE_NEWLINE
                    {
                    this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE_ENTRY6784); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_1, grammarAccess.getASN1_CHOICE_ENTRYAccess().getNEWLINETerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3023:3: ( (lv_valueType_2_0= ruleChoiceType ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3024:1: (lv_valueType_2_0= ruleChoiceType )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3024:1: (lv_valueType_2_0= ruleChoiceType )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3025:3: lv_valueType_2_0= ruleChoiceType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeChoiceTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleChoiceType_in_ruleASN1_CHOICE_ENTRY6806);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3049:1: entryRuleChoiceType returns [EObject current=null] : iv_ruleChoiceType= ruleChoiceType EOF ;
    public final EObject entryRuleChoiceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoiceType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3050:2: (iv_ruleChoiceType= ruleChoiceType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3051:2: iv_ruleChoiceType= ruleChoiceType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getChoiceTypeRule()); 
            }
            pushFollow(FOLLOW_ruleChoiceType_in_entryRuleChoiceType6842);
            iv_ruleChoiceType=ruleChoiceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleChoiceType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoiceType6852); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3058:1: ruleChoiceType returns [EObject current=null] : ( () ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' ) ) ;
    public final EObject ruleChoiceType() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_typeRef_1_0 = null;

        EObject lv_simpleType_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3061:28: ( ( () ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3062:1: ( () ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3062:1: ( () ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3062:2: () ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3062:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3063:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getChoiceTypeAccess().getChoiceTypeAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3068:2: ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' )
            int alt69=3;
            switch ( input.LA(1) ) {
            case RULE_MODULE_ID:
            case 31:
                {
                alt69=1;
                }
                break;
            case RULE_IA5STRING:
            case 42:
            case 43:
            case 45:
            case 48:
            case 49:
                {
                alt69=2;
                }
                break;
            case 24:
                {
                alt69=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3068:3: ( (lv_typeRef_1_0= ruleTypeReference ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3068:3: ( (lv_typeRef_1_0= ruleTypeReference ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3069:1: (lv_typeRef_1_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3069:1: (lv_typeRef_1_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3070:3: lv_typeRef_1_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getChoiceTypeAccess().getTypeRefTypeReferenceParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleChoiceType6908);
                    lv_typeRef_1_0=ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getChoiceTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"typeRef",
                              		lv_typeRef_1_0, 
                              		"TypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3087:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3087:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3088:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3088:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3089:3: lv_simpleType_2_0= ruleASN1_TYPE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getChoiceTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_TYPE_in_ruleChoiceType6935);
                    lv_simpleType_2_0=ruleASN1_TYPE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getChoiceTypeRule());
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
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3106:7: otherlv_3= 'OBJECT IDENTIFIER'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleChoiceType6953); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getChoiceTypeAccess().getOBJECTIDENTIFIERKeyword_1_2());
                          
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
    // $ANTLR end "ruleChoiceType"

    // $ANTLR start synpred1_InternalSmi
    public final void synpred1_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:581:7: ( ( RULE_ASN1_ID ) )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:582:1: ( RULE_ASN1_ID )
        {
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:582:1: ( RULE_ASN1_ID )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:583:1: RULE_ASN1_ID
        {
        match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_synpred1_InternalSmi1252); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalSmi

    // $ANTLR start synpred2_InternalSmi
    public final void synpred2_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1594:3: ( ( ruleTypeReference ) )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1595:1: ( ruleTypeReference )
        {
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1595:1: ( ruleTypeReference )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1596:1: ruleTypeReference
        {
        pushFollow(FOLLOW_ruleTypeReference_in_synpred2_InternalSmi3462);
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
    protected DFA2 dfa2 = new DFA2(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA44 dfa44 = new DFA44(this);
    static final String DFA1_eotS =
        "\4\uffff";
    static final String DFA1_eofS =
        "\4\uffff";
    static final String DFA1_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA1_maxS =
        "\1\5\1\24\2\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA1_specialS =
        "\4\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1",
            "\1\3\1\1\1\3\15\uffff\1\2",
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
            return "110:1: ( (lv_imports_4_0= ruleImports ) )?";
        }
    }
    static final String DFA2_eotS =
        "\7\uffff";
    static final String DFA2_eofS =
        "\7\uffff";
    static final String DFA2_minS =
        "\1\5\2\4\4\uffff";
    static final String DFA2_maxS =
        "\1\5\1\23\1\30\4\uffff";
    static final String DFA2_acceptS =
        "\3\uffff\1\3\1\4\1\1\1\2";
    static final String DFA2_specialS =
        "\7\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1",
            "\1\3\1\1\1\2\14\uffff\1\4",
            "\1\5\23\uffff\1\6",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()+ loopback of 128:3: ( ( (lv_objects_5_0= ruleObject ) ) | ( (lv_identifiers_6_0= ruleObjectIdentifier ) ) | ( (lv_types_7_0= ruleReferenceable ) ) )+";
        }
    }
    static final String DFA12_eotS =
        "\5\uffff";
    static final String DFA12_eofS =
        "\5\uffff";
    static final String DFA12_minS =
        "\1\5\1\4\1\21\2\uffff";
    static final String DFA12_maxS =
        "\2\5\1\33\2\uffff";
    static final String DFA12_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA12_specialS =
        "\5\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\1",
            "\1\2\1\1",
            "\1\4\11\uffff\1\3",
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
            return "450:1: (this_Macro_0= ruleMacro | this_TypeDefinition_1= ruleTypeDefinition )";
        }
    }
    static final String DFA17_eotS =
        "\53\uffff";
    static final String DFA17_eofS =
        "\1\2\4\uffff\4\3\1\uffff\1\3\1\uffff\1\3\1\uffff\3\3\1\uffff\1\3"+
        "\2\uffff\2\3\7\uffff\1\3\6\uffff\1\3\5\uffff";
    static final String DFA17_minS =
        "\2\4\2\uffff\15\4\1\31\5\4\1\7\1\5\1\4\1\47\1\5\1\46\1\7\1\4\1\7"+
        "\2\47\3\5\1\4\1\5\1\46\1\7\1\47\1\5";
    static final String DFA17_maxS =
        "\2\61\2\uffff\15\61\1\62\5\61\1\7\1\6\1\61\1\57\1\6\1\46\1\7\1\61"+
        "\1\7\2\47\1\32\1\6\1\32\1\61\1\6\1\46\1\7\1\47\1\32";
    static final String DFA17_acceptS =
        "\2\uffff\1\2\1\1\47\uffff";
    static final String DFA17_specialS =
        "\53\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\3\1\1\1\3\1\uffff\2\3\16\uffff\1\3\6\uffff\1\3\1\uffff\1"+
            "\3\1\uffff\1\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2"+
            "\3",
            "\1\5\1\4\1\6\1\uffff\2\3\11\uffff\1\2\4\uffff\1\3\6\uffff\1"+
            "\3\1\uffff\1\3\1\uffff\1\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1"+
            "\3\2\uffff\2\3",
            "",
            "",
            "\1\5\1\4\1\6\1\uffff\2\3\11\uffff\1\2\4\uffff\1\3\6\uffff\1"+
            "\3\1\uffff\1\3\3\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2"+
            "\3",
            "\3\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\2\uffff\1\2\3\uffff"+
            "\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\2\3",
            "\1\7\2\3\1\uffff\2\3\16\uffff\1\10\6\uffff\1\3\1\uffff\3\3"+
            "\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\3\1\11\1\3\1\uffff\2\3\16\uffff\1\3\6\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\3\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\6\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\12\1\13\1\3\1\uffff\2\3\11\uffff\1\3\4\uffff\1\3\6\uffff"+
            "\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\2\3",
            "\1\14\1\15\1\16\1\uffff\1\17\1\3\7\uffff\1\3\6\uffff\1\22\1"+
            "\2\1\uffff\1\3\3\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2"+
            "\3\1\uffff\1\20\2\uffff\1\3\1\21",
            "\1\12\1\13\1\3\1\uffff\2\3\11\uffff\1\3\4\uffff\1\3\6\uffff"+
            "\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\2\3",
            "\1\3\1\23\1\3\1\uffff\2\3\16\uffff\1\3\6\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\1\2\3\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\26\1\24\1\25\1\uffff\1\17\1\3\11\uffff\1\3\4\uffff\1\3\6"+
            "\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2"+
            "\uffff\2\3",
            "\1\3\1\23\1\3\1\uffff\2\3\16\uffff\1\3\6\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\3\1\23\1\3\1\uffff\2\3\16\uffff\1\3\6\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\3\1\23\1\3\1\uffff\2\3\16\uffff\1\3\1\30\5\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\1\27\3\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\3\30\uffff\1\2",
            "\1\3\1\23\1\3\1\uffff\2\3\16\uffff\1\3\6\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\12\1\31\1\3\1\uffff\2\3\7\uffff\1\2\1\uffff\1\3\4\uffff"+
            "\1\3\6\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff"+
            "\1\3\2\uffff\2\3",
            "\1\26\1\24\1\25\1\uffff\1\17\1\3\11\uffff\1\3\4\uffff\1\3\6"+
            "\uffff\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2"+
            "\uffff\2\3",
            "\1\3\1\23\1\3\1\uffff\2\3\16\uffff\1\3\6\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\3\1\23\1\3\1\uffff\2\3\7\uffff\1\3\6\uffff\1\3\2\uffff\1"+
            "\3\3\uffff\1\3\1\uffff\3\3\1\uffff\1\3\1\2\3\uffff\2\3\1\uffff"+
            "\1\3\2\uffff\2\3",
            "\1\32",
            "\1\33\1\34",
            "\1\12\1\31\1\3\1\uffff\2\3\7\uffff\1\2\1\uffff\1\3\4\uffff"+
            "\1\3\6\uffff\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1\uffff"+
            "\1\3\2\uffff\2\3",
            "\1\36\7\uffff\1\35",
            "\1\33\1\34",
            "\1\37",
            "\1\40",
            "\1\3\1\23\1\3\1\uffff\2\3\16\uffff\1\3\1\30\5\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\41",
            "\1\36",
            "\1\42",
            "\1\44\21\uffff\1\43\2\uffff\1\45",
            "\1\46\1\47",
            "\1\44\24\uffff\1\45",
            "\1\3\1\23\1\3\1\uffff\2\3\16\uffff\1\3\6\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\46\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\44\21\uffff\1\43\2\uffff\1\45"
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "()+ loopback of 687:1: ( (lv_values_3_0= ruleValue ) )+";
        }
    }
    static final String DFA19_eotS =
        "\4\uffff";
    static final String DFA19_eofS =
        "\4\uffff";
    static final String DFA19_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA19_maxS =
        "\1\5\1\21\2\uffff";
    static final String DFA19_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA19_specialS =
        "\4\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1",
            "\1\2\1\1\13\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "()+ loopback of 761:2: ( (lv_attributes_3_0= ruleAttribute ) )+";
        }
    }
    static final String DFA28_eotS =
        "\4\uffff";
    static final String DFA28_eofS =
        "\4\uffff";
    static final String DFA28_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA28_maxS =
        "\1\5\1\23\2\uffff";
    static final String DFA28_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA28_specialS =
        "\4\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\1",
            "\1\3\1\1\15\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1237:2: ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+";
        }
    }
    static final String DFA31_eotS =
        "\4\uffff";
    static final String DFA31_eofS =
        "\1\2\3\uffff";
    static final String DFA31_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA31_maxS =
        "\1\5\1\45\2\uffff";
    static final String DFA31_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA31_specialS =
        "\4\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\1",
            "\1\3\1\1\3\uffff\1\3\24\uffff\1\2\1\3\5\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1311:1: ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+";
        }
    }
    static final String DFA37_eotS =
        "\23\uffff";
    static final String DFA37_eofS =
        "\1\3\22\uffff";
    static final String DFA37_minS =
        "\1\4\2\0\20\uffff";
    static final String DFA37_maxS =
        "\1\61\2\0\20\uffff";
    static final String DFA37_acceptS =
        "\3\uffff\1\2\16\uffff\1\1";
    static final String DFA37_specialS =
        "\1\uffff\1\0\1\1\20\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\1\2\3\1\uffff\2\3\16\uffff\1\3\6\uffff\1\2\1\uffff\3\3\1"+
            "\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "1594:2: ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_1 = input.LA(1);

                         
                        int index37_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalSmi()) ) {s = 18;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_2 = input.LA(1);

                         
                        int index37_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalSmi()) ) {s = 18;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index37_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA44_eotS =
        "\5\uffff";
    static final String DFA44_eofS =
        "\1\2\4\uffff";
    static final String DFA44_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA44_maxS =
        "\2\61\2\uffff\1\61";
    static final String DFA44_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA44_specialS =
        "\5\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\2\1\1\1\2\1\uffff\2\2\16\uffff\1\2\6\uffff\1\2\1\uffff\1"+
            "\2\1\3\1\2\1\uffff\1\2\4\uffff\2\2\1\uffff\1\2\2\uffff\2\2",
            "\1\2\1\4\1\2\1\uffff\2\2\11\uffff\1\2\4\uffff\1\2\6\uffff\1"+
            "\2\1\uffff\1\2\1\3\1\2\1\uffff\1\2\4\uffff\2\2\1\uffff\1\2\2"+
            "\uffff\2\2",
            "",
            "",
            "\1\2\1\4\1\2\1\uffff\2\2\11\uffff\1\2\4\uffff\1\2\6\uffff\1"+
            "\2\1\uffff\1\2\1\3\2\uffff\1\2\4\uffff\2\2\1\uffff\1\2\2\uffff"+
            "\2\2"
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "()* loopback of 1817:2: ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleModule127 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleModule144 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModule156 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleModule168 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleImports_in_ruleModule189 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleObject_in_ruleModule212 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_ruleModule239 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleReferenceable_in_ruleModule266 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleModule280 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_19_in_ruleModule293 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleModule305 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleImports_in_entryRuleImports342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImports352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleImports389 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_20_in_ruleImports402 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_ruleImportClosure_in_ruleImports423 = new BitSet(new long[]{0x0000000000200070L});
    public static final BitSet FOLLOW_21_in_ruleImports436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportClosure_in_entryRuleImportClosure472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportClosure482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportRefs_in_ruleImportClosure528 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleImportClosure540 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_22_in_ruleImportClosure553 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleImportClosure570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportRefs_in_entryRuleImportRefs611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportRefs621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleImportRefs658 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_ruleImportRef_in_ruleImportRefs680 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleImportRefs693 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleImportRefs705 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_ruleImportRef_in_ruleImportRefs727 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleImportRef_in_entryRuleImportRef765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportRef775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleImportRef820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleImportRef846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceable_in_entryRuleReferenceable882 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceable892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_ruleReferenceable939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleReferenceable966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier1001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifier1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleObjectIdentifier1048 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifier1066 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleObjectIdentifier1083 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleObjectIdentifier1095 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleObjectIdentifier1107 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_ruleObjectIdentifier1128 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleObjectIdentifier1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue1176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifierValue1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue1232 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue1266 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleObjectIdentifierValue1290 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleObjectIdentifierValue1312 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition1354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDefinition1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTypeDefinition1401 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeDefinition1419 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeDefinition1436 = new BitSet(new long[]{0x00032C2A81000370L});
    public static final BitSet FOLLOW_ruleValue_in_ruleTypeDefinition1457 = new BitSet(new long[]{0x00032C2A81000372L});
    public static final BitSet FOLLOW_ruleObject_in_entryRuleObject1494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObject1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleObject1541 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObject1559 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleObject1584 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleObject1605 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleObject1618 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_17_in_ruleObject1631 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ruleObjectValue_in_ruleObject1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleAttribute1735 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleAttribute1756 = new BitSet(new long[]{0x00022C0003000170L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_ruleAttribute1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue1813 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeValue1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleAttributeValue1861 = new BitSet(new long[]{0x0000000000000170L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAttributeValue1884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_ruleAttributeValue1907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleAttributeValue1939 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_ruleAttributeValue1960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracedObjectReference_in_ruleAttributeValue1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_ruleAttributeValue2018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SEQUENCE_OF_in_ruleAttributeValue2045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleAttributeValue2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier2110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier2120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleIdentifier2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracedObjectReference_in_entryRuleBracedObjectReference2201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBracedObjectReference2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleBracedObjectReference2248 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleBracedObjectReference2268 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleBracedObjectReference2280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectValue_in_entryRuleObjectValue2316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectValue2326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleObjectValue2363 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_ruleObjectValue2385 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleObjectValue2396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_entryRuleMacro2432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacro2442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro2479 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleMacro2497 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMacro2514 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMacro2526 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro2538 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_18_in_ruleMacro2551 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_ruleMacro2572 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueNotation_in_ruleMacro2593 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleMacro2614 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro2627 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_19_in_ruleMacro2640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation2676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotation2686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTypeNotation2723 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_28_in_ruleTypeNotation2742 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleTypeNotation2767 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeNotation2779 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_ruleTypeNotation2800 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleValueNotation_in_entryRuleValueNotation2837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNotation2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValueNotation2884 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_30_in_ruleValueNotation2903 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleValueNotation2928 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleValueNotation2940 = new BitSet(new long[]{0x0000002000000020L});
    public static final BitSet FOLLOW_ruleValueAssignment_in_ruleValueNotation2961 = new BitSet(new long[]{0x0000002000000022L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment2998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAssignment3008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTypeAssignment3045 = new BitSet(new long[]{0x0000002080000230L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleTypeAssignment3069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeAssignment3096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleTypeAssignment3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment3159 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamAssignment3169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PARAMETER_in_ruleParamAssignment3211 = new BitSet(new long[]{0x0000002080000010L});
    public static final BitSet FOLLOW_ruleTypeNotationRight_in_ruleParamAssignment3237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotationRight_in_entryRuleTypeNotationRight3273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotationRight3283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeNotationRight3330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleTypeNotationRight3356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt3392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReferenceExt3402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt3448 = new BitSet(new long[]{0x0000000080000012L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt3479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_entryRuleTypeReference3516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReference3526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeReference3571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracedTypeReference_in_ruleTypeReference3599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracedTypeReference_in_entryRuleBracedTypeReference3634 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBracedTypeReference3644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleBracedTypeReference3681 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleBracedTypeReference3703 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleBracedTypeReference3714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueAssignment_in_entryRuleValueAssignment3750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueAssignment3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValueAssignment3797 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleValueAssignment3819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue3855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTag_in_ruleValue3911 = new BitSet(new long[]{0x00032C2A81000370L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValue3924 = new BitSet(new long[]{0x00032C2A81000370L});
    public static final BitSet FOLLOW_33_in_ruleValue3943 = new BitSet(new long[]{0x00032C2A81000370L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue3978 = new BitSet(new long[]{0x0000000400000022L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValue3991 = new BitSet(new long[]{0x0000000400000020L});
    public static final BitSet FOLLOW_34_in_ruleValue4004 = new BitSet(new long[]{0x00032C2A81000370L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue4025 = new BitSet(new long[]{0x0000000400000022L});
    public static final BitSet FOLLOW_ruleTag_in_entryRuleTag4063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTag4073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTag4110 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleTag4123 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleTag4140 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleTag4157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType4193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType4203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleValueType4249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleValueType4272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_ruleValueType4304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_ruleValueType4331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleValueType4358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleValueType4386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue4423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue4433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleMacroValue4479 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleMacroValue4491 = new BitSet(new long[]{0x00000300C1000010L});
    public static final BitSet FOLLOW_ruleMacroValueType_in_ruleMacroValue4512 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleMacroValue4524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValueType_in_entryRuleMacroValueType4560 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValueType4570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleMacroValueType4658 = new BitSet(new long[]{0x00000300C1000010L});
    public static final BitSet FOLLOW_30_in_ruleMacroValueType4743 = new BitSet(new long[]{0x00000300C1000010L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleMacroValueType4818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleMacroValueType4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleMacroValueType4879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE4929 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE4939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE4986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE5013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SEQUENCE_in_ruleASN1_TYPE5040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE5075 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE5085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleASN1_SIMPLE5132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE5160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE5189 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE5209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE5239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING5274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING5284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleASN1_OCTET_STRING5330 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleASN1_OCTET_STRING5342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER5378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER5388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleASN1_INTEGER5431 = new BitSet(new long[]{0x0000004002000002L});
    public static final BitSet FOLLOW_38_in_ruleASN1_INTEGER5457 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_INTEGER5478 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_INTEGER5490 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_REFINEMENT_in_ruleASN1_INTEGER5513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_REFINEMENT_in_entryRuleASN1_INTEGER_REFINEMENT5550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER_REFINEMENT5560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleASN1_INTEGER_REFINEMENT5597 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5610 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_INTEGER_REFINEMENT5628 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleASN1_INTEGER_REFINEMENT5645 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_INTEGER_REFINEMENT5662 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_INTEGER_REFINEMENT5679 = new BitSet(new long[]{0x0000000004800020L});
    public static final BitSet FOLLOW_23_in_ruleASN1_INTEGER_REFINEMENT5693 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5705 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_INTEGER_REFINEMENT5723 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleASN1_INTEGER_REFINEMENT5740 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_INTEGER_REFINEMENT5757 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_INTEGER_REFINEMENT5774 = new BitSet(new long[]{0x0000000004800020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5788 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_26_in_ruleASN1_INTEGER_REFINEMENT5801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE5837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE5847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleASN1_SUBTYPE5884 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleASN1_SUBTYPE5896 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleASN1_SUBTYPE5908 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE5929 = new BitSet(new long[]{0x0000008400000000L});
    public static final BitSet FOLLOW_34_in_ruleASN1_SUBTYPE5942 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE5963 = new BitSet(new long[]{0x0000008400000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_SUBTYPE5977 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_SUBTYPE5989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE6025 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE6035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE6087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE6117 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleASN1_RANGE6134 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE6151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE6193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE6203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleASN1_CHOICE6240 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleASN1_CHOICE6252 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6264 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE6286 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_23_in_ruleASN1_CHOICE6299 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6311 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE6333 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6347 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_26_in_ruleASN1_CHOICE6360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SEQUENCE_in_entryRuleASN1_SEQUENCE6396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SEQUENCE6406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleASN1_SEQUENCE6443 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleASN1_SEQUENCE6455 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6467 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_SEQUENCE6489 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_23_in_ruleASN1_SEQUENCE6502 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6514 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_SEQUENCE6536 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6550 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_26_in_ruleASN1_SEQUENCE6563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SEQUENCE_OF_in_entryRuleASN1_SEQUENCE_OF6599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SEQUENCE_OF6609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleASN1_SEQUENCE_OF6646 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleASN1_SEQUENCE_OF6658 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleASN1_SEQUENCE_OF6679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY6715 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY6725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY6767 = new BitSet(new long[]{0x00032C0081000130L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE_ENTRY6784 = new BitSet(new long[]{0x00032C0081000130L});
    public static final BitSet FOLLOW_ruleChoiceType_in_ruleASN1_CHOICE_ENTRY6806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoiceType_in_entryRuleChoiceType6842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoiceType6852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleChoiceType6908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_ruleChoiceType6935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleChoiceType6953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_synpred1_InternalSmi1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_synpred2_InternalSmi3462 = new BitSet(new long[]{0x0000000000000002L});

}
