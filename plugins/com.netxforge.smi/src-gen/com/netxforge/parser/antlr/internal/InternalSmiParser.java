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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:76:1: ruleModule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_imports_4_0= ruleImports ) )? ( ( (lv_objects_5_0= ruleObjectReferenceable ) ) | ( (lv_types_6_0= ruleReferenceable ) ) )+ (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= 'END' (this_NEWLINE_9= RULE_NEWLINE )* ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_NEWLINE_7=null;
        Token otherlv_8=null;
        Token this_NEWLINE_9=null;
        EObject lv_imports_4_0 = null;

        EObject lv_objects_5_0 = null;

        EObject lv_types_6_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:79:28: ( ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_imports_4_0= ruleImports ) )? ( ( (lv_objects_5_0= ruleObjectReferenceable ) ) | ( (lv_types_6_0= ruleReferenceable ) ) )+ (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= 'END' (this_NEWLINE_9= RULE_NEWLINE )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:1: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_imports_4_0= ruleImports ) )? ( ( (lv_objects_5_0= ruleObjectReferenceable ) ) | ( (lv_types_6_0= ruleReferenceable ) ) )+ (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= 'END' (this_NEWLINE_9= RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:1: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_imports_4_0= ruleImports ) )? ( ( (lv_objects_5_0= ruleObjectReferenceable ) ) | ( (lv_types_6_0= ruleReferenceable ) ) )+ (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= 'END' (this_NEWLINE_9= RULE_NEWLINE )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:2: ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' ( (lv_imports_4_0= ruleImports ) )? ( ( (lv_objects_5_0= ruleObjectReferenceable ) ) | ( (lv_types_6_0= ruleReferenceable ) ) )+ (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= 'END' (this_NEWLINE_9= RULE_NEWLINE )*
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:128:3: ( ( (lv_objects_5_0= ruleObjectReferenceable ) ) | ( (lv_types_6_0= ruleReferenceable ) ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=3;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:128:4: ( (lv_objects_5_0= ruleObjectReferenceable ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:128:4: ( (lv_objects_5_0= ruleObjectReferenceable ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:129:1: (lv_objects_5_0= ruleObjectReferenceable )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:129:1: (lv_objects_5_0= ruleObjectReferenceable )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:130:3: lv_objects_5_0= ruleObjectReferenceable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getObjectsObjectReferenceableParserRuleCall_5_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleObjectReferenceable_in_ruleModule212);
            	    lv_objects_5_0=ruleObjectReferenceable();

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
            	              		"ObjectReferenceable");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:147:6: ( (lv_types_6_0= ruleReferenceable ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:147:6: ( (lv_types_6_0= ruleReferenceable ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:148:1: (lv_types_6_0= ruleReferenceable )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:148:1: (lv_types_6_0= ruleReferenceable )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:149:3: lv_types_6_0= ruleReferenceable
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getTypesReferenceableParserRuleCall_5_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleReferenceable_in_ruleModule239);
            	    lv_types_6_0=ruleReferenceable();

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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:165:4: (this_NEWLINE_7= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:165:5: this_NEWLINE_7= RULE_NEWLINE
            	    {
            	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleModule253); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_7, grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_6()); 
            	          
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

            otherlv_8=(Token)match(input,19,FOLLOW_19_in_ruleModule266); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getModuleAccess().getENDKeyword_7());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:173:1: (this_NEWLINE_9= RULE_NEWLINE )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_NEWLINE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:173:2: this_NEWLINE_9= RULE_NEWLINE
            	    {
            	    this_NEWLINE_9=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleModule278); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_9, grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_8()); 
            	          
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:185:1: entryRuleImports returns [EObject current=null] : iv_ruleImports= ruleImports EOF ;
    public final EObject entryRuleImports() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImports = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:186:2: (iv_ruleImports= ruleImports EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:187:2: iv_ruleImports= ruleImports EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportsRule()); 
            }
            pushFollow(FOLLOW_ruleImports_in_entryRuleImports315);
            iv_ruleImports=ruleImports();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImports; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImports325); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:194:1: ruleImports returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ otherlv_1= 'IMPORTS' ( (lv_imports_2_0= ruleImportClosure ) )+ otherlv_3= ';' ) ;
    public final EObject ruleImports() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_imports_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:197:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ otherlv_1= 'IMPORTS' ( (lv_imports_2_0= ruleImportClosure ) )+ otherlv_3= ';' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:198:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ otherlv_1= 'IMPORTS' ( (lv_imports_2_0= ruleImportClosure ) )+ otherlv_3= ';' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:198:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ otherlv_1= 'IMPORTS' ( (lv_imports_2_0= ruleImportClosure ) )+ otherlv_3= ';' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:198:2: (this_NEWLINE_0= RULE_NEWLINE )+ otherlv_1= 'IMPORTS' ( (lv_imports_2_0= ruleImportClosure ) )+ otherlv_3= ';'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:198:2: (this_NEWLINE_0= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:198:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleImports362); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleImports375); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getImportsAccess().getIMPORTSKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:206:1: ( (lv_imports_2_0= ruleImportClosure ) )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:207:1: (lv_imports_2_0= ruleImportClosure )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:207:1: (lv_imports_2_0= ruleImportClosure )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:208:3: lv_imports_2_0= ruleImportClosure
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImportsAccess().getImportsImportClosureParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImportClosure_in_ruleImports396);
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

            otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleImports409); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:236:1: entryRuleImportClosure returns [EObject current=null] : iv_ruleImportClosure= ruleImportClosure EOF ;
    public final EObject entryRuleImportClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportClosure = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:237:2: (iv_ruleImportClosure= ruleImportClosure EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:238:2: iv_ruleImportClosure= ruleImportClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportClosureRule()); 
            }
            pushFollow(FOLLOW_ruleImportClosure_in_entryRuleImportClosure445);
            iv_ruleImportClosure=ruleImportClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportClosure; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportClosure455); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:245:1: ruleImportClosure returns [EObject current=null] : ( ( (lv_refs_0_0= ruleImportRefs ) ) (this_NEWLINE_1= RULE_NEWLINE )* otherlv_2= 'FROM' ( (lv_importURI_3_0= RULE_MODULE_ID ) ) ) ;
    public final EObject ruleImportClosure() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_1=null;
        Token otherlv_2=null;
        Token lv_importURI_3_0=null;
        EObject lv_refs_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:248:28: ( ( ( (lv_refs_0_0= ruleImportRefs ) ) (this_NEWLINE_1= RULE_NEWLINE )* otherlv_2= 'FROM' ( (lv_importURI_3_0= RULE_MODULE_ID ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:249:1: ( ( (lv_refs_0_0= ruleImportRefs ) ) (this_NEWLINE_1= RULE_NEWLINE )* otherlv_2= 'FROM' ( (lv_importURI_3_0= RULE_MODULE_ID ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:249:1: ( ( (lv_refs_0_0= ruleImportRefs ) ) (this_NEWLINE_1= RULE_NEWLINE )* otherlv_2= 'FROM' ( (lv_importURI_3_0= RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:249:2: ( (lv_refs_0_0= ruleImportRefs ) ) (this_NEWLINE_1= RULE_NEWLINE )* otherlv_2= 'FROM' ( (lv_importURI_3_0= RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:249:2: ( (lv_refs_0_0= ruleImportRefs ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:250:1: (lv_refs_0_0= ruleImportRefs )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:250:1: (lv_refs_0_0= ruleImportRefs )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:251:3: lv_refs_0_0= ruleImportRefs
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportClosureAccess().getRefsImportRefsParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleImportRefs_in_ruleImportClosure501);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:267:2: (this_NEWLINE_1= RULE_NEWLINE )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_NEWLINE) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:267:3: this_NEWLINE_1= RULE_NEWLINE
            	    {
            	    this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleImportClosure513); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_1, grammarAccess.getImportClosureAccess().getNEWLINETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleImportClosure526); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getImportClosureAccess().getFROMKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:275:1: ( (lv_importURI_3_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:276:1: (lv_importURI_3_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:276:1: (lv_importURI_3_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:277:3: lv_importURI_3_0= RULE_MODULE_ID
            {
            lv_importURI_3_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleImportClosure543); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:301:1: entryRuleImportRefs returns [EObject current=null] : iv_ruleImportRefs= ruleImportRefs EOF ;
    public final EObject entryRuleImportRefs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportRefs = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:302:2: (iv_ruleImportRefs= ruleImportRefs EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:303:2: iv_ruleImportRefs= ruleImportRefs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRefsRule()); 
            }
            pushFollow(FOLLOW_ruleImportRefs_in_entryRuleImportRefs584);
            iv_ruleImportRefs=ruleImportRefs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportRefs; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportRefs594); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:310:1: ruleImportRefs returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )* ( (lv_refs_1_0= ruleImportRef ) ) (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )* ) ;
    public final EObject ruleImportRefs() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token otherlv_2=null;
        Token this_NEWLINE_3=null;
        EObject lv_refs_1_0 = null;

        EObject lv_refs_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:313:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )* ( (lv_refs_1_0= ruleImportRef ) ) (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:314:1: ( (this_NEWLINE_0= RULE_NEWLINE )* ( (lv_refs_1_0= ruleImportRef ) ) (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:314:1: ( (this_NEWLINE_0= RULE_NEWLINE )* ( (lv_refs_1_0= ruleImportRef ) ) (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:314:2: (this_NEWLINE_0= RULE_NEWLINE )* ( (lv_refs_1_0= ruleImportRef ) ) (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:314:2: (this_NEWLINE_0= RULE_NEWLINE )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_NEWLINE) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:314:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleImportRefs631); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getImportRefsAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:318:3: ( (lv_refs_1_0= ruleImportRef ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:319:1: (lv_refs_1_0= ruleImportRef )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:319:1: (lv_refs_1_0= ruleImportRef )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:320:3: lv_refs_1_0= ruleImportRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportRefsAccess().getRefsImportRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleImportRef_in_ruleImportRefs653);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:336:2: (otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==23) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:336:4: otherlv_2= ',' (this_NEWLINE_3= RULE_NEWLINE )* ( (lv_refs_4_0= ruleImportRef ) )
            	    {
            	    otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleImportRefs666); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getImportRefsAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:340:1: (this_NEWLINE_3= RULE_NEWLINE )*
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==RULE_NEWLINE) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:340:2: this_NEWLINE_3= RULE_NEWLINE
            	    	    {
            	    	    this_NEWLINE_3=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleImportRefs678); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_NEWLINE_3, grammarAccess.getImportRefsAccess().getNEWLINETerminalRuleCall_2_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop9;
            	        }
            	    } while (true);

            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:344:3: ( (lv_refs_4_0= ruleImportRef ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:345:1: (lv_refs_4_0= ruleImportRef )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:345:1: (lv_refs_4_0= ruleImportRef )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:346:3: lv_refs_4_0= ruleImportRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getImportRefsAccess().getRefsImportRefParserRuleCall_2_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImportRef_in_ruleImportRefs700);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:370:1: entryRuleImportRef returns [EObject current=null] : iv_ruleImportRef= ruleImportRef EOF ;
    public final EObject entryRuleImportRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportRef = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:371:2: (iv_ruleImportRef= ruleImportRef EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:372:2: iv_ruleImportRef= ruleImportRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRefRule()); 
            }
            pushFollow(FOLLOW_ruleImportRef_in_entryRuleImportRef738);
            iv_ruleImportRef=ruleImportRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImportRef748); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:379:1: ruleImportRef returns [EObject current=null] : ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( (otherlv_1= RULE_MODULE_ID ) ) ) ;
    public final EObject ruleImportRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:382:28: ( ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( (otherlv_1= RULE_MODULE_ID ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:383:1: ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( (otherlv_1= RULE_MODULE_ID ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:383:1: ( ( (otherlv_0= RULE_ASN1_ID ) ) | ( (otherlv_1= RULE_MODULE_ID ) ) )
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:383:2: ( (otherlv_0= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:383:2: ( (otherlv_0= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:384:1: (otherlv_0= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:384:1: (otherlv_0= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:385:3: otherlv_0= RULE_ASN1_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getImportRefRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleImportRef793); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getImportRefAccess().getOiRefObjectReferenceableCrossReference_0_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:397:6: ( (otherlv_1= RULE_MODULE_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:397:6: ( (otherlv_1= RULE_MODULE_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:398:1: (otherlv_1= RULE_MODULE_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:398:1: (otherlv_1= RULE_MODULE_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:399:3: otherlv_1= RULE_MODULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getImportRefRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleImportRef819); if (state.failed) return current;
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


    // $ANTLR start "entryRuleObjectReferenceable"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:418:1: entryRuleObjectReferenceable returns [EObject current=null] : iv_ruleObjectReferenceable= ruleObjectReferenceable EOF ;
    public final EObject entryRuleObjectReferenceable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectReferenceable = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:419:2: (iv_ruleObjectReferenceable= ruleObjectReferenceable EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:420:2: iv_ruleObjectReferenceable= ruleObjectReferenceable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectReferenceableRule()); 
            }
            pushFollow(FOLLOW_ruleObjectReferenceable_in_entryRuleObjectReferenceable855);
            iv_ruleObjectReferenceable=ruleObjectReferenceable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectReferenceable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectReferenceable865); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectReferenceable"


    // $ANTLR start "ruleObjectReferenceable"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:427:1: ruleObjectReferenceable returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) (this_NEWLINE_2= RULE_NEWLINE )* (otherlv_3= 'OBJECT IDENTIFIER' | ( (lv_object_4_0= ruleObject ) ) ) (this_NEWLINE_5= RULE_NEWLINE )* otherlv_6= '::=' otherlv_7= '{' ( (lv_objectValue_8_0= ruleObjectReference ) ) otherlv_9= '}' ) ;
    public final EObject ruleObjectReferenceable() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token this_NEWLINE_2=null;
        Token otherlv_3=null;
        Token this_NEWLINE_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_object_4_0 = null;

        EObject lv_objectValue_8_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:430:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) (this_NEWLINE_2= RULE_NEWLINE )* (otherlv_3= 'OBJECT IDENTIFIER' | ( (lv_object_4_0= ruleObject ) ) ) (this_NEWLINE_5= RULE_NEWLINE )* otherlv_6= '::=' otherlv_7= '{' ( (lv_objectValue_8_0= ruleObjectReference ) ) otherlv_9= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:431:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) (this_NEWLINE_2= RULE_NEWLINE )* (otherlv_3= 'OBJECT IDENTIFIER' | ( (lv_object_4_0= ruleObject ) ) ) (this_NEWLINE_5= RULE_NEWLINE )* otherlv_6= '::=' otherlv_7= '{' ( (lv_objectValue_8_0= ruleObjectReference ) ) otherlv_9= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:431:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) (this_NEWLINE_2= RULE_NEWLINE )* (otherlv_3= 'OBJECT IDENTIFIER' | ( (lv_object_4_0= ruleObject ) ) ) (this_NEWLINE_5= RULE_NEWLINE )* otherlv_6= '::=' otherlv_7= '{' ( (lv_objectValue_8_0= ruleObjectReference ) ) otherlv_9= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:431:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_ASN1_ID ) ) (this_NEWLINE_2= RULE_NEWLINE )* (otherlv_3= 'OBJECT IDENTIFIER' | ( (lv_object_4_0= ruleObject ) ) ) (this_NEWLINE_5= RULE_NEWLINE )* otherlv_6= '::=' otherlv_7= '{' ( (lv_objectValue_8_0= ruleObjectReference ) ) otherlv_9= '}'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:431:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NEWLINE) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:431:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleObjectReferenceable902); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getObjectReferenceableAccess().getNEWLINETerminalRuleCall_0()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:435:3: ( (lv_name_1_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:436:1: (lv_name_1_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:436:1: (lv_name_1_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:437:3: lv_name_1_0= RULE_ASN1_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectReferenceable920); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getObjectReferenceableAccess().getNameASN1_IDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getObjectReferenceableRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ASN1_ID");
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:453:2: (this_NEWLINE_2= RULE_NEWLINE )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_NEWLINE) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:453:3: this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleObjectReferenceable937); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_2, grammarAccess.getObjectReferenceableAccess().getNEWLINETerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:457:3: (otherlv_3= 'OBJECT IDENTIFIER' | ( (lv_object_4_0= ruleObject ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==24) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_MODULE_ID) ) {
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:457:5: otherlv_3= 'OBJECT IDENTIFIER'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleObjectReferenceable951); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getObjectReferenceableAccess().getOBJECTIDENTIFIERKeyword_3_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:462:6: ( (lv_object_4_0= ruleObject ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:462:6: ( (lv_object_4_0= ruleObject ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:463:1: (lv_object_4_0= ruleObject )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:463:1: (lv_object_4_0= ruleObject )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:464:3: lv_object_4_0= ruleObject
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getObjectReferenceableAccess().getObjectObjectParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleObject_in_ruleObjectReferenceable978);
                    lv_object_4_0=ruleObject();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getObjectReferenceableRule());
                      	        }
                             		set(
                             			current, 
                             			"object",
                              		lv_object_4_0, 
                              		"Object");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:480:3: (this_NEWLINE_5= RULE_NEWLINE )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_NEWLINE) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:480:4: this_NEWLINE_5= RULE_NEWLINE
            	    {
            	    this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleObjectReferenceable991); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_5, grammarAccess.getObjectReferenceableAccess().getNEWLINETerminalRuleCall_4()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleObjectReferenceable1004); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getObjectReferenceableAccess().getColonColonEqualsSignKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,25,FOLLOW_25_in_ruleObjectReferenceable1016); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getObjectReferenceableAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:492:1: ( (lv_objectValue_8_0= ruleObjectReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:493:1: (lv_objectValue_8_0= ruleObjectReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:493:1: (lv_objectValue_8_0= ruleObjectReference )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:494:3: lv_objectValue_8_0= ruleObjectReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getObjectReferenceableAccess().getObjectValueObjectReferenceParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleObjectReference_in_ruleObjectReferenceable1037);
            lv_objectValue_8_0=ruleObjectReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getObjectReferenceableRule());
              	        }
                     		set(
                     			current, 
                     			"objectValue",
                      		lv_objectValue_8_0, 
                      		"ObjectReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_9=(Token)match(input,26,FOLLOW_26_in_ruleObjectReferenceable1049); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getObjectReferenceableAccess().getRightCurlyBracketKeyword_8());
                  
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
    // $ANTLR end "ruleObjectReferenceable"


    // $ANTLR start "entryRuleObject"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:522:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:523:2: (iv_ruleObject= ruleObject EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:524:2: iv_ruleObject= ruleObject EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectRule()); 
            }
            pushFollow(FOLLOW_ruleObject_in_entryRuleObject1085);
            iv_ruleObject=ruleObject();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObject; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObject1095); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:531:1: ruleObject returns [EObject current=null] : ( ( (otherlv_0= RULE_MODULE_ID ) ) ( (lv_attributes_1_0= ruleAttribute ) )+ ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_attributes_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:534:28: ( ( ( (otherlv_0= RULE_MODULE_ID ) ) ( (lv_attributes_1_0= ruleAttribute ) )+ ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:535:1: ( ( (otherlv_0= RULE_MODULE_ID ) ) ( (lv_attributes_1_0= ruleAttribute ) )+ )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:535:1: ( ( (otherlv_0= RULE_MODULE_ID ) ) ( (lv_attributes_1_0= ruleAttribute ) )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:535:2: ( (otherlv_0= RULE_MODULE_ID ) ) ( (lv_attributes_1_0= ruleAttribute ) )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:535:2: ( (otherlv_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:536:1: (otherlv_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:536:1: (otherlv_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:537:3: otherlv_0= RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getObjectRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleObject1140); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getObjectAccess().getMacroRefReferenceableCrossReference_0_0()); 
              	
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:548:2: ( (lv_attributes_1_0= ruleAttribute ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                alt16 = dfa16.predict(input);
                switch (alt16) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:549:1: (lv_attributes_1_0= ruleAttribute )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:549:1: (lv_attributes_1_0= ruleAttribute )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:550:3: lv_attributes_1_0= ruleAttribute
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getObjectAccess().getAttributesAttributeParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAttribute_in_ruleObject1161);
            	    lv_attributes_1_0=ruleAttribute();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getObjectRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"attributes",
            	              		lv_attributes_1_0, 
            	              		"Attribute");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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


    // $ANTLR start "entryRuleObjectReference"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:574:1: entryRuleObjectReference returns [EObject current=null] : iv_ruleObjectReference= ruleObjectReference EOF ;
    public final EObject entryRuleObjectReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectReference = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:575:2: (iv_ruleObjectReference= ruleObjectReference EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:576:2: iv_ruleObjectReference= ruleObjectReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleObjectReference_in_entryRuleObjectReference1198);
            iv_ruleObjectReference=ruleObjectReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectReference1208); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectReference"


    // $ANTLR start "ruleObjectReference"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:583:1: ruleObjectReference returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* ) ;
    public final EObject ruleObjectReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_subIds_2_0=null;
        Token lv_subIds_3_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:586:28: ( ( ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:587:1: ( ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:587:1: ( ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:587:2: ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_BIG_INTEGER ) ) ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:587:2: ( ( (lv_name_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )?
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ASN1_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (true) ) {
                    alt17=1;
                }
                else if ( (synpred1_InternalSmi()) ) {
                    alt17=2;
                }
            }
            switch (alt17) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:587:3: ( (lv_name_0_0= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:587:3: ( (lv_name_0_0= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:588:1: (lv_name_0_0= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:588:1: (lv_name_0_0= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:589:3: lv_name_0_0= RULE_ASN1_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectReference1251); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_0, grammarAccess.getObjectReferenceAccess().getNameASN1_IDTerminalRuleCall_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectReferenceRule());
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:606:6: ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:606:6: ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:606:7: ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:612:1: (otherlv_1= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:613:3: otherlv_1= RULE_ASN1_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectReferenceRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectReference1294); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getObjectReferenceAccess().getDescriptorRefObjectReferenceableCrossReference_0_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:624:4: ( (lv_subIds_2_0= RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:625:1: (lv_subIds_2_0= RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:625:1: (lv_subIds_2_0= RULE_BIG_INTEGER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:626:3: lv_subIds_2_0= RULE_BIG_INTEGER
            {
            lv_subIds_2_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleObjectReference1313); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_subIds_2_0, grammarAccess.getObjectReferenceAccess().getSubIdsBIG_INTEGERTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getObjectReferenceRule());
              	        }
                     		addWithLastConsumed(
                     			current, 
                     			"subIds",
                      		lv_subIds_2_0, 
                      		"BIG_INTEGER");
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:642:2: ( (lv_subIds_3_0= RULE_BIG_INTEGER ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_BIG_INTEGER) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:643:1: (lv_subIds_3_0= RULE_BIG_INTEGER )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:643:1: (lv_subIds_3_0= RULE_BIG_INTEGER )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:644:3: lv_subIds_3_0= RULE_BIG_INTEGER
            	    {
            	    lv_subIds_3_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleObjectReference1335); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_subIds_3_0, grammarAccess.getObjectReferenceAccess().getSubIdsBIG_INTEGERTerminalRuleCall_2_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getObjectReferenceRule());
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
            	    break loop18;
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
    // $ANTLR end "ruleObjectReference"


    // $ANTLR start "entryRuleAttribute"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:668:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:669:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:670:2: iv_ruleAttribute= ruleAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1377);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttribute; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1387); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:677:1: ruleAttribute returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (otherlv_1= RULE_MODULE_ID ) ) ( (lv_values_2_0= ruleAttributeValue ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token otherlv_1=null;
        EObject lv_values_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:680:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (otherlv_1= RULE_MODULE_ID ) ) ( (lv_values_2_0= ruleAttributeValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:681:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (otherlv_1= RULE_MODULE_ID ) ) ( (lv_values_2_0= ruleAttributeValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:681:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (otherlv_1= RULE_MODULE_ID ) ) ( (lv_values_2_0= ruleAttributeValue ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:681:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (otherlv_1= RULE_MODULE_ID ) ) ( (lv_values_2_0= ruleAttributeValue ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:681:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_NEWLINE) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:681:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleAttribute1424); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getAttributeAccess().getNEWLINETerminalRuleCall_0()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:685:3: ( (otherlv_1= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:686:1: (otherlv_1= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:686:1: (otherlv_1= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:687:3: otherlv_1= RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAttributeRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleAttribute1445); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getParamRefReferenceableCrossReference_1_0()); 
              	
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:698:2: ( (lv_values_2_0= ruleAttributeValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:699:1: (lv_values_2_0= ruleAttributeValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:699:1: (lv_values_2_0= ruleAttributeValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:700:3: lv_values_2_0= ruleAttributeValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAttributeAccess().getValuesAttributeValueParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAttributeValue_in_ruleAttribute1466);
            lv_values_2_0=ruleAttributeValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAttributeRule());
              	        }
                     		set(
                     			current, 
                     			"values",
                      		lv_values_2_0, 
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:724:1: entryRuleAttributeValue returns [EObject current=null] : iv_ruleAttributeValue= ruleAttributeValue EOF ;
    public final EObject entryRuleAttributeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:725:2: (iv_ruleAttributeValue= ruleAttributeValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:2: iv_ruleAttributeValue= ruleAttributeValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeValueRule()); 
            }
            pushFollow(FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue1502);
            iv_ruleAttributeValue=ruleAttributeValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttributeValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttributeValue1512); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:733:1: ruleAttributeValue returns [EObject current=null] : ( ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) ) | ( (lv_objectRef_5_0= ruleBracedObjectReference ) ) | ( (lv_integer_6_0= ruleASN1_INTEGER ) ) | ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) ) | ( () otherlv_9= 'OBJECT IDENTIFIER' ) ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:736:28: ( ( ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) ) | ( (lv_objectRef_5_0= ruleBracedObjectReference ) ) | ( (lv_integer_6_0= ruleASN1_INTEGER ) ) | ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) ) | ( () otherlv_9= 'OBJECT IDENTIFIER' ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:737:1: ( ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) ) | ( (lv_objectRef_5_0= ruleBracedObjectReference ) ) | ( (lv_integer_6_0= ruleASN1_INTEGER ) ) | ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) ) | ( () otherlv_9= 'OBJECT IDENTIFIER' ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:737:1: ( ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) ) | ( (lv_objectRef_5_0= ruleBracedObjectReference ) ) | ( (lv_integer_6_0= ruleASN1_INTEGER ) ) | ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) ) | ( () otherlv_9= 'OBJECT IDENTIFIER' ) )
            int alt23=5;
            switch ( input.LA(1) ) {
            case RULE_MODULE_ID:
            case RULE_NEWLINE:
            case RULE_ASN1_ID:
            case RULE_IA5STRING:
                {
                alt23=1;
                }
                break;
            case 25:
                {
                alt23=2;
                }
                break;
            case 45:
                {
                alt23=3;
                }
                break;
            case 49:
                {
                alt23=4;
                }
                break;
            case 24:
                {
                alt23=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:737:2: ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:737:2: ( (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:737:3: (this_NEWLINE_0= RULE_NEWLINE )* ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:737:3: (this_NEWLINE_0= RULE_NEWLINE )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_NEWLINE) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:737:4: this_NEWLINE_0= RULE_NEWLINE
                    	    {
                    	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleAttributeValue1550); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_NEWLINE_0, grammarAccess.getAttributeValueAccess().getNEWLINETerminalRuleCall_0_0()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:741:3: ( ( (lv_identifier_1_0= ruleIdentifier ) ) | ( (lv_text_2_0= RULE_IA5STRING ) ) | ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? ) )
                    int alt22=3;
                    switch ( input.LA(1) ) {
                    case RULE_ASN1_ID:
                        {
                        alt22=1;
                        }
                        break;
                    case RULE_IA5STRING:
                        {
                        alt22=2;
                        }
                        break;
                    case RULE_MODULE_ID:
                        {
                        alt22=3;
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
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:741:4: ( (lv_identifier_1_0= ruleIdentifier ) )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:741:4: ( (lv_identifier_1_0= ruleIdentifier ) )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:742:1: (lv_identifier_1_0= ruleIdentifier )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:742:1: (lv_identifier_1_0= ruleIdentifier )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:743:3: lv_identifier_1_0= ruleIdentifier
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getAttributeValueAccess().getIdentifierIdentifierParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleIdentifier_in_ruleAttributeValue1573);
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
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:760:6: ( (lv_text_2_0= RULE_IA5STRING ) )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:760:6: ( (lv_text_2_0= RULE_IA5STRING ) )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:761:1: (lv_text_2_0= RULE_IA5STRING )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:761:1: (lv_text_2_0= RULE_IA5STRING )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:762:3: lv_text_2_0= RULE_IA5STRING
                            {
                            lv_text_2_0=(Token)match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_ruleAttributeValue1596); if (state.failed) return current;
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
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:779:6: ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:779:6: ( ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )? )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:779:7: ( (otherlv_3= RULE_MODULE_ID ) ) ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )?
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:779:7: ( (otherlv_3= RULE_MODULE_ID ) )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:780:1: (otherlv_3= RULE_MODULE_ID )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:780:1: (otherlv_3= RULE_MODULE_ID )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:781:3: otherlv_3= RULE_MODULE_ID
                            {
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getAttributeValueRule());
                              	        }
                                      
                            }
                            otherlv_3=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleAttributeValue1628); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              		newLeafNode(otherlv_3, grammarAccess.getAttributeValueAccess().getTypeRefReferenceableCrossReference_0_1_2_0_0()); 
                              	
                            }

                            }


                            }

                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:792:2: ( (lv_subType_4_0= ruleASN1_SUBTYPE ) )?
                            int alt21=2;
                            int LA21_0 = input.LA(1);

                            if ( (LA21_0==38) ) {
                                alt21=1;
                            }
                            switch (alt21) {
                                case 1 :
                                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:793:1: (lv_subType_4_0= ruleASN1_SUBTYPE )
                                    {
                                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:793:1: (lv_subType_4_0= ruleASN1_SUBTYPE )
                                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:794:3: lv_subType_4_0= ruleASN1_SUBTYPE
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getAttributeValueAccess().getSubTypeASN1_SUBTYPEParserRuleCall_0_1_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_ruleAttributeValue1649);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:811:6: ( (lv_objectRef_5_0= ruleBracedObjectReference ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:811:6: ( (lv_objectRef_5_0= ruleBracedObjectReference ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:812:1: (lv_objectRef_5_0= ruleBracedObjectReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:812:1: (lv_objectRef_5_0= ruleBracedObjectReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:813:3: lv_objectRef_5_0= ruleBracedObjectReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAttributeValueAccess().getObjectRefBracedObjectReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBracedObjectReference_in_ruleAttributeValue1680);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:830:6: ( (lv_integer_6_0= ruleASN1_INTEGER ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:830:6: ( (lv_integer_6_0= ruleASN1_INTEGER ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:831:1: (lv_integer_6_0= ruleASN1_INTEGER )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:831:1: (lv_integer_6_0= ruleASN1_INTEGER )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:832:3: lv_integer_6_0= ruleASN1_INTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAttributeValueAccess().getIntegerASN1_INTEGERParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_INTEGER_in_ruleAttributeValue1707);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:849:6: ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:849:6: ( (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:850:1: (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:850:1: (lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:851:3: lv_sequenceOf_7_0= ruleASN1_SEQUENCE_OF
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getAttributeValueAccess().getSequenceOfASN1_SEQUENCE_OFParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_SEQUENCE_OF_in_ruleAttributeValue1734);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:868:6: ( () otherlv_9= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:868:6: ( () otherlv_9= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:868:7: () otherlv_9= 'OBJECT IDENTIFIER'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:868:7: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:869:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getAttributeValueAccess().getAttributeValueAction_4_0(),
                                  current);
                          
                    }

                    }

                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleAttributeValue1762); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:886:1: entryRuleIdentifier returns [EObject current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final EObject entryRuleIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentifier = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:887:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:888:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier1799);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier1809); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:895:1: ruleIdentifier returns [EObject current=null] : ( (lv_id_0_0= RULE_ASN1_ID ) ) ;
    public final EObject ruleIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:898:28: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:899:1: ( (lv_id_0_0= RULE_ASN1_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:899:1: ( (lv_id_0_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:900:1: (lv_id_0_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:900:1: (lv_id_0_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:901:3: lv_id_0_0= RULE_ASN1_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleIdentifier1850); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:925:1: entryRuleBracedObjectReference returns [EObject current=null] : iv_ruleBracedObjectReference= ruleBracedObjectReference EOF ;
    public final EObject entryRuleBracedObjectReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBracedObjectReference = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:926:2: (iv_ruleBracedObjectReference= ruleBracedObjectReference EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:927:2: iv_ruleBracedObjectReference= ruleBracedObjectReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBracedObjectReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleBracedObjectReference_in_entryRuleBracedObjectReference1890);
            iv_ruleBracedObjectReference=ruleBracedObjectReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBracedObjectReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBracedObjectReference1900); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:934:1: ruleBracedObjectReference returns [EObject current=null] : (otherlv_0= '{' ( (otherlv_1= RULE_ASN1_ID ) ) otherlv_2= '}' ) ;
    public final EObject ruleBracedObjectReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:937:28: ( (otherlv_0= '{' ( (otherlv_1= RULE_ASN1_ID ) ) otherlv_2= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:938:1: (otherlv_0= '{' ( (otherlv_1= RULE_ASN1_ID ) ) otherlv_2= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:938:1: (otherlv_0= '{' ( (otherlv_1= RULE_ASN1_ID ) ) otherlv_2= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:938:3: otherlv_0= '{' ( (otherlv_1= RULE_ASN1_ID ) ) otherlv_2= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleBracedObjectReference1937); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBracedObjectReferenceAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:942:1: ( (otherlv_1= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:943:1: (otherlv_1= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:943:1: (otherlv_1= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:944:3: otherlv_1= RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getBracedObjectReferenceRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleBracedObjectReference1957); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getBracedObjectReferenceAccess().getObjectRefObjectReferenceableCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleBracedObjectReference1969); if (state.failed) return current;
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


    // $ANTLR start "entryRuleReferenceable"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:967:1: entryRuleReferenceable returns [EObject current=null] : iv_ruleReferenceable= ruleReferenceable EOF ;
    public final EObject entryRuleReferenceable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceable = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:968:2: (iv_ruleReferenceable= ruleReferenceable EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:969:2: iv_ruleReferenceable= ruleReferenceable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceableRule()); 
            }
            pushFollow(FOLLOW_ruleReferenceable_in_entryRuleReferenceable2005);
            iv_ruleReferenceable=ruleReferenceable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceable2015); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:976:1: ruleReferenceable returns [EObject current=null] : (this_Macro_0= ruleMacro | this_TypeDefinition_1= ruleTypeDefinition ) ;
    public final EObject ruleReferenceable() throws RecognitionException {
        EObject current = null;

        EObject this_Macro_0 = null;

        EObject this_TypeDefinition_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:979:28: ( (this_Macro_0= ruleMacro | this_TypeDefinition_1= ruleTypeDefinition ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:980:1: (this_Macro_0= ruleMacro | this_TypeDefinition_1= ruleTypeDefinition )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:980:1: (this_Macro_0= ruleMacro | this_TypeDefinition_1= ruleTypeDefinition )
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:981:5: this_Macro_0= ruleMacro
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReferenceableAccess().getMacroParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMacro_in_ruleReferenceable2062);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:991:5: this_TypeDefinition_1= ruleTypeDefinition
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReferenceableAccess().getTypeDefinitionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleReferenceable2089);
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


    // $ANTLR start "entryRuleTypeDefinition"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1007:1: entryRuleTypeDefinition returns [EObject current=null] : iv_ruleTypeDefinition= ruleTypeDefinition EOF ;
    public final EObject entryRuleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinition = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1008:2: (iv_ruleTypeDefinition= ruleTypeDefinition EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1009:2: iv_ruleTypeDefinition= ruleTypeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition2124);
            iv_ruleTypeDefinition=ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDefinition2134); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1016:1: ruleTypeDefinition returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ ) ;
    public final EObject ruleTypeDefinition() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_values_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1019:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1020:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1020:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1020:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_values_3_0= ruleValue ) )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1020:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_NEWLINE) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1020:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTypeDefinition2171); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1024:3: ( (lv_name_1_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1025:1: (lv_name_1_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1025:1: (lv_name_1_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1026:3: lv_name_1_0= RULE_MODULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleTypeDefinition2189); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleTypeDefinition2206); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTypeDefinitionAccess().getColonColonEqualsSignKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1046:1: ( (lv_values_3_0= ruleValue ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                alt26 = dfa26.predict(input);
                switch (alt26) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1047:1: (lv_values_3_0= ruleValue )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1047:1: (lv_values_3_0= ruleValue )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1048:3: lv_values_3_0= ruleValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeDefinitionAccess().getValuesValueParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValue_in_ruleTypeDefinition2227);
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
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1072:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1073:2: (iv_ruleMacro= ruleMacro EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1074:2: iv_ruleMacro= ruleMacro EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroRule()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_entryRuleMacro2264);
            iv_ruleMacro=ruleMacro();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacro; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacro2274); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1081:1: ruleMacro returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1084:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1085:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1085:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1085:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' (this_NEWLINE_4= RULE_NEWLINE )+ otherlv_5= 'BEGIN' ( (lv_typeNotation_6_0= ruleTypeNotation ) ) ( (lv_valueNotation_7_0= ruleValueNotation ) ) ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+ (this_NEWLINE_9= RULE_NEWLINE )+ otherlv_10= 'END'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1085:2: (this_NEWLINE_0= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1085:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro2311); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1089:3: ( (lv_name_1_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1090:1: (lv_name_1_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1090:1: (lv_name_1_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1091:3: lv_name_1_0= RULE_MODULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleMacro2329); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleMacro2346); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMacroAccess().getMACROKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleMacro2358); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_3());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1115:1: (this_NEWLINE_4= RULE_NEWLINE )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_NEWLINE) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1115:2: this_NEWLINE_4= RULE_NEWLINE
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro2370); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_4, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_4()); 
            	          
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

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleMacro2383); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMacroAccess().getBEGINKeyword_5());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1123:1: ( (lv_typeNotation_6_0= ruleTypeNotation ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1124:1: (lv_typeNotation_6_0= ruleTypeNotation )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1124:1: (lv_typeNotation_6_0= ruleTypeNotation )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1125:3: lv_typeNotation_6_0= ruleTypeNotation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getTypeNotationTypeNotationParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_ruleMacro2404);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1141:2: ( (lv_valueNotation_7_0= ruleValueNotation ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1142:1: (lv_valueNotation_7_0= ruleValueNotation )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1142:1: (lv_valueNotation_7_0= ruleValueNotation )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1143:3: lv_valueNotation_7_0= ruleValueNotation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getValueNotationValueNotationParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValueNotation_in_ruleMacro2425);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1159:2: ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                alt29 = dfa29.predict(input);
                switch (alt29) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1160:1: (lv_innerTypes_8_0= ruleTypeDefinition )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1160:1: (lv_innerTypes_8_0= ruleTypeDefinition )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1161:3: lv_innerTypes_8_0= ruleTypeDefinition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleMacro2446);
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
            	    if ( cnt29 >= 1 ) break loop29;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1177:3: (this_NEWLINE_9= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1177:4: this_NEWLINE_9= RULE_NEWLINE
            	    {
            	    this_NEWLINE_9=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleMacro2459); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_9, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_9()); 
            	          
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

            otherlv_10=(Token)match(input,19,FOLLOW_19_in_ruleMacro2472); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1193:1: entryRuleTypeNotation returns [EObject current=null] : iv_ruleTypeNotation= ruleTypeNotation EOF ;
    public final EObject entryRuleTypeNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNotation = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1194:2: (iv_ruleTypeNotation= ruleTypeNotation EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1195:2: iv_ruleTypeNotation= ruleTypeNotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNotationRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation2508);
            iv_ruleTypeNotation=ruleTypeNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNotation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotation2518); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1202:1: ruleTypeNotation returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+ ) ;
    public final EObject ruleTypeNotation() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_typeNotations_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1205:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+ ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1206:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+ )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1206:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1206:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'TYPE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1206:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_NEWLINE) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1206:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTypeNotation2555); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getTypeNotationAccess().getNEWLINETerminalRuleCall_0()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1210:3: ( (lv_name_1_0= 'TYPE' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1211:1: (lv_name_1_0= 'TYPE' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1211:1: (lv_name_1_0= 'TYPE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1212:3: lv_name_1_0= 'TYPE'
            {
            lv_name_1_0=(Token)match(input,28,FOLLOW_28_in_ruleTypeNotation2574); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleTypeNotation2599); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTypeNotationAccess().getNOTATIONKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleTypeNotation2611); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTypeNotationAccess().getColonColonEqualsSignKeyword_3());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1233:1: ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                alt32 = dfa32.predict(input);
                switch (alt32) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1234:1: (lv_typeNotations_4_0= ruleTypeAssignment )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1234:1: (lv_typeNotations_4_0= ruleTypeAssignment )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1235:3: lv_typeNotations_4_0= ruleTypeAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTypeNotationAccess().getTypeNotationsTypeAssignmentParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeAssignment_in_ruleTypeNotation2632);
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
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1259:1: entryRuleValueNotation returns [EObject current=null] : iv_ruleValueNotation= ruleValueNotation EOF ;
    public final EObject entryRuleValueNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueNotation = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1260:2: (iv_ruleValueNotation= ruleValueNotation EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1261:2: iv_ruleValueNotation= ruleValueNotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueNotationRule()); 
            }
            pushFollow(FOLLOW_ruleValueNotation_in_entryRuleValueNotation2669);
            iv_ruleValueNotation=ruleValueNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueNotation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNotation2679); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1268:1: ruleValueNotation returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_valueNotations_4_0= ruleValueAssignment ) )+ ) ;
    public final EObject ruleValueNotation() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_valueNotations_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1271:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_valueNotations_4_0= ruleValueAssignment ) )+ ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1272:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_valueNotations_4_0= ruleValueAssignment ) )+ )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1272:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_valueNotations_4_0= ruleValueAssignment ) )+ )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1272:2: (this_NEWLINE_0= RULE_NEWLINE )+ ( (lv_name_1_0= 'VALUE' ) ) otherlv_2= 'NOTATION' otherlv_3= '::=' ( (lv_valueNotations_4_0= ruleValueAssignment ) )+
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1272:2: (this_NEWLINE_0= RULE_NEWLINE )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_NEWLINE) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1272:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValueNotation2716); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getValueNotationAccess().getNEWLINETerminalRuleCall_0()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1276:3: ( (lv_name_1_0= 'VALUE' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1277:1: (lv_name_1_0= 'VALUE' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1277:1: (lv_name_1_0= 'VALUE' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1278:3: lv_name_1_0= 'VALUE'
            {
            lv_name_1_0=(Token)match(input,30,FOLLOW_30_in_ruleValueNotation2735); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleValueNotation2760); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getValueNotationAccess().getNOTATIONKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleValueNotation2772); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getValueNotationAccess().getColonColonEqualsSignKeyword_3());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1299:1: ( (lv_valueNotations_4_0= ruleValueAssignment ) )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_NEWLINE) ) {
                    int LA34_1 = input.LA(2);

                    if ( (LA34_1==37) ) {
                        alt34=1;
                    }


                }
                else if ( (LA34_0==37) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1300:1: (lv_valueNotations_4_0= ruleValueAssignment )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1300:1: (lv_valueNotations_4_0= ruleValueAssignment )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1301:3: lv_valueNotations_4_0= ruleValueAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getValueNotationAccess().getValueNotationsValueAssignmentParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValueAssignment_in_ruleValueNotation2793);
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
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1325:1: entryRuleTypeAssignment returns [EObject current=null] : iv_ruleTypeAssignment= ruleTypeAssignment EOF ;
    public final EObject entryRuleTypeAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1326:2: (iv_ruleTypeAssignment= ruleTypeAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1327:2: iv_ruleTypeAssignment= ruleTypeAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment2830);
            iv_ruleTypeAssignment=ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAssignment2840); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1334:1: ruleTypeAssignment returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) ) ;
    public final EObject ruleTypeAssignment() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        EObject this_ParamAssignment_1 = null;

        EObject this_TypeReference_2 = null;

        EObject this_MacroValue_3 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1337:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1338:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1338:1: ( (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1338:2: (this_NEWLINE_0= RULE_NEWLINE )+ (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1338:2: (this_NEWLINE_0= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1338:3: this_NEWLINE_0= RULE_NEWLINE
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTypeAssignment2877); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_0, grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1342:3: (this_ParamAssignment_1= ruleParamAssignment | this_TypeReference_2= ruleTypeReference | this_MacroValue_3= ruleMacroValue )
            int alt36=3;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt36=1;
                }
                break;
            case RULE_MODULE_ID:
            case 31:
                {
                alt36=2;
                }
                break;
            case 37:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1343:5: this_ParamAssignment_1= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleTypeAssignment2901);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1353:5: this_TypeReference_2= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeAssignment2928);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1363:5: this_MacroValue_3= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getMacroValueParserRuleCall_1_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleTypeAssignment2955);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1379:1: entryRuleParamAssignment returns [EObject current=null] : iv_ruleParamAssignment= ruleParamAssignment EOF ;
    public final EObject entryRuleParamAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1380:2: (iv_ruleParamAssignment= ruleParamAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1381:2: iv_ruleParamAssignment= ruleParamAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment2991);
            iv_ruleParamAssignment=ruleParamAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamAssignment3001); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1388:1: ruleParamAssignment returns [EObject current=null] : ( ( (lv_name_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) ) ;
    public final EObject ruleParamAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1391:28: ( ( ( (lv_name_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1392:1: ( ( (lv_name_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1392:1: ( ( (lv_name_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1392:2: ( (lv_name_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotationRight ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1392:2: ( (lv_name_0_0= RULE_PARAMETER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1393:1: (lv_name_0_0= RULE_PARAMETER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1393:1: (lv_name_0_0= RULE_PARAMETER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1394:3: lv_name_0_0= RULE_PARAMETER
            {
            lv_name_0_0=(Token)match(input,RULE_PARAMETER,FOLLOW_RULE_PARAMETER_in_ruleParamAssignment3043); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1410:2: ( (lv_right_1_0= ruleTypeNotationRight ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1411:1: (lv_right_1_0= ruleTypeNotationRight )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1411:1: (lv_right_1_0= ruleTypeNotationRight )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1412:3: lv_right_1_0= ruleTypeNotationRight
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAssignmentAccess().getRightTypeNotationRightParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeNotationRight_in_ruleParamAssignment3069);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1436:1: entryRuleTypeNotationRight returns [EObject current=null] : iv_ruleTypeNotationRight= ruleTypeNotationRight EOF ;
    public final EObject entryRuleTypeNotationRight() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNotationRight = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1437:2: (iv_ruleTypeNotationRight= ruleTypeNotationRight EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1438:2: iv_ruleTypeNotationRight= ruleTypeNotationRight EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNotationRightRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotationRight_in_entryRuleTypeNotationRight3105);
            iv_ruleTypeNotationRight=ruleTypeNotationRight();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNotationRight; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotationRight3115); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1445:1: ruleTypeNotationRight returns [EObject current=null] : (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) ;
    public final EObject ruleTypeNotationRight() throws RecognitionException {
        EObject current = null;

        EObject this_TypeReference_0 = null;

        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1448:28: ( (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1449:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1449:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_MODULE_ID||LA37_0==31) ) {
                alt37=1;
            }
            else if ( (LA37_0==37) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1450:5: this_TypeReference_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeNotationRightAccess().getTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeNotationRight3162);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1459:6: ( (lv_value_1_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1459:6: ( (lv_value_1_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1460:1: (lv_value_1_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1460:1: (lv_value_1_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1461:3: lv_value_1_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNotationRightAccess().getValueMacroValueParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleTypeNotationRight3188);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1485:1: entryRuleTypeReferenceExt returns [EObject current=null] : iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF ;
    public final EObject entryRuleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReferenceExt = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1486:2: (iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1487:2: iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceExtRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt3224);
            iv_ruleTypeReferenceExt=ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReferenceExt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReferenceExt3234); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1494:1: ruleTypeReferenceExt returns [EObject current=null] : ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? ) ;
    public final EObject ruleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject lv_parentRef_0_0 = null;

        EObject lv_childRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1497:28: ( ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1498:1: ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1498:1: ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1498:2: ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1498:2: ( (lv_parentRef_0_0= ruleTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1499:1: (lv_parentRef_0_0= ruleTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1499:1: (lv_parentRef_0_0= ruleTypeReference )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1500:3: lv_parentRef_0_0= ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getParentRefTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt3280);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1516:2: ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?
            int alt38=2;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1516:3: ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1521:1: (lv_childRef_1_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1522:3: lv_childRef_1_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getChildRefTypeReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt3311);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1546:1: entryRuleTypeReference returns [EObject current=null] : iv_ruleTypeReference= ruleTypeReference EOF ;
    public final EObject entryRuleTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReference = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1547:2: (iv_ruleTypeReference= ruleTypeReference EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1548:2: iv_ruleTypeReference= ruleTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_entryRuleTypeReference3348);
            iv_ruleTypeReference=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReference3358); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1555:1: ruleTypeReference returns [EObject current=null] : ( ( (otherlv_0= RULE_MODULE_ID ) ) | this_BracedTypeReference_1= ruleBracedTypeReference ) ;
    public final EObject ruleTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_BracedTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1558:28: ( ( ( (otherlv_0= RULE_MODULE_ID ) ) | this_BracedTypeReference_1= ruleBracedTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1559:1: ( ( (otherlv_0= RULE_MODULE_ID ) ) | this_BracedTypeReference_1= ruleBracedTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1559:1: ( ( (otherlv_0= RULE_MODULE_ID ) ) | this_BracedTypeReference_1= ruleBracedTypeReference )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_MODULE_ID) ) {
                alt39=1;
            }
            else if ( (LA39_0==31) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1559:2: ( (otherlv_0= RULE_MODULE_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1559:2: ( (otherlv_0= RULE_MODULE_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1560:1: (otherlv_0= RULE_MODULE_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1560:1: (otherlv_0= RULE_MODULE_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1561:3: otherlv_0= RULE_MODULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getTypeReferenceRule());
                      	        }
                              
                    }
                    otherlv_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleTypeReference3403); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_0, grammarAccess.getTypeReferenceAccess().getTypeReferenceableCrossReference_0_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1574:5: this_BracedTypeReference_1= ruleBracedTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeReferenceAccess().getBracedTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBracedTypeReference_in_ruleTypeReference3431);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1590:1: entryRuleBracedTypeReference returns [EObject current=null] : iv_ruleBracedTypeReference= ruleBracedTypeReference EOF ;
    public final EObject entryRuleBracedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBracedTypeReference = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1591:2: (iv_ruleBracedTypeReference= ruleBracedTypeReference EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1592:2: iv_ruleBracedTypeReference= ruleBracedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBracedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleBracedTypeReference_in_entryRuleBracedTypeReference3466);
            iv_ruleBracedTypeReference=ruleBracedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBracedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBracedTypeReference3476); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1599:1: ruleBracedTypeReference returns [EObject current=null] : (otherlv_0= '\"{\"' this_TypeReference_1= ruleTypeReference otherlv_2= '\"}\"' ) ;
    public final EObject ruleBracedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_TypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1602:28: ( (otherlv_0= '\"{\"' this_TypeReference_1= ruleTypeReference otherlv_2= '\"}\"' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1603:1: (otherlv_0= '\"{\"' this_TypeReference_1= ruleTypeReference otherlv_2= '\"}\"' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1603:1: (otherlv_0= '\"{\"' this_TypeReference_1= ruleTypeReference otherlv_2= '\"}\"' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1603:3: otherlv_0= '\"{\"' this_TypeReference_1= ruleTypeReference otherlv_2= '\"}\"'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleBracedTypeReference3513); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getBracedTypeReferenceAccess().getQuotationMarkLeftCurlyBracketQuotationMarkKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBracedTypeReferenceAccess().getTypeReferenceParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleTypeReference_in_ruleBracedTypeReference3535);
            this_TypeReference_1=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeReference_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleBracedTypeReference3546); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1628:1: entryRuleValueAssignment returns [EObject current=null] : iv_ruleValueAssignment= ruleValueAssignment EOF ;
    public final EObject entryRuleValueAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1629:2: (iv_ruleValueAssignment= ruleValueAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1630:2: iv_ruleValueAssignment= ruleValueAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleValueAssignment_in_entryRuleValueAssignment3582);
            iv_ruleValueAssignment=ruleValueAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueAssignment3592); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1637:1: ruleValueAssignment returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueNotation_1_0= ruleMacroValue ) ) ) ;
    public final EObject ruleValueAssignment() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        EObject lv_valueNotation_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1640:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueNotation_1_0= ruleMacroValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1641:1: ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueNotation_1_0= ruleMacroValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1641:1: ( (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueNotation_1_0= ruleMacroValue ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1641:2: (this_NEWLINE_0= RULE_NEWLINE )? ( (lv_valueNotation_1_0= ruleMacroValue ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1641:2: (this_NEWLINE_0= RULE_NEWLINE )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_NEWLINE) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1641:3: this_NEWLINE_0= RULE_NEWLINE
                    {
                    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValueAssignment3629); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_0, grammarAccess.getValueAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1645:3: ( (lv_valueNotation_1_0= ruleMacroValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1646:1: (lv_valueNotation_1_0= ruleMacroValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1646:1: (lv_valueNotation_1_0= ruleMacroValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1647:3: lv_valueNotation_1_0= ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueAssignmentAccess().getValueNotationMacroValueParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMacroValue_in_ruleValueAssignment3651);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1671:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1672:2: (iv_ruleValue= ruleValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1673:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue3687);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue3697); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1680:1: ruleValue returns [EObject current=null] : ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1683:28: ( ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1684:1: ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1684:1: ( ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1684:2: ( (lv_tag_0_0= ruleTag ) )? (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_implicit_2_0= 'IMPLICIT' ) )? ( (lv_valueTypes_3_0= ruleValueType ) ) ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1684:2: ( (lv_tag_0_0= ruleTag ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_NEWLINE) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==35) ) {
                    alt41=1;
                }
            }
            else if ( (LA41_0==35) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1685:1: (lv_tag_0_0= ruleTag )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1685:1: (lv_tag_0_0= ruleTag )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1686:3: lv_tag_0_0= ruleTag
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueAccess().getTagTagParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTag_in_ruleValue3743);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1702:3: (this_NEWLINE_1= RULE_NEWLINE )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_NEWLINE) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1702:4: this_NEWLINE_1= RULE_NEWLINE
            	    {
            	    this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValue3756); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_1, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1706:3: ( (lv_implicit_2_0= 'IMPLICIT' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==33) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1707:1: (lv_implicit_2_0= 'IMPLICIT' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1707:1: (lv_implicit_2_0= 'IMPLICIT' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1708:3: lv_implicit_2_0= 'IMPLICIT'
                    {
                    lv_implicit_2_0=(Token)match(input,33,FOLLOW_33_in_ruleValue3775); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1721:3: ( (lv_valueTypes_3_0= ruleValueType ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1722:1: (lv_valueTypes_3_0= ruleValueType )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1722:1: (lv_valueTypes_3_0= ruleValueType )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1723:3: lv_valueTypes_3_0= ruleValueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValueType_in_ruleValue3810);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1739:2: ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )*
            loop45:
            do {
                int alt45=2;
                alt45 = dfa45.predict(input);
                switch (alt45) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1739:3: (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1739:3: (this_NEWLINE_4= RULE_NEWLINE )*
            	    loop44:
            	    do {
            	        int alt44=2;
            	        int LA44_0 = input.LA(1);

            	        if ( (LA44_0==RULE_NEWLINE) ) {
            	            alt44=1;
            	        }


            	        switch (alt44) {
            	    	case 1 :
            	    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1739:4: this_NEWLINE_4= RULE_NEWLINE
            	    	    {
            	    	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleValue3823); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_NEWLINE_4, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_4_0()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop44;
            	        }
            	    } while (true);

            	    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleValue3836); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getValueAccess().getVerticalLineKeyword_4_1());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1747:1: ( (lv_valueTypes_6_0= ruleValueType ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1748:1: (lv_valueTypes_6_0= ruleValueType )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1748:1: (lv_valueTypes_6_0= ruleValueType )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1749:3: lv_valueTypes_6_0= ruleValueType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_4_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValueType_in_ruleValue3857);
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
            	    break loop45;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1773:1: entryRuleTag returns [EObject current=null] : iv_ruleTag= ruleTag EOF ;
    public final EObject entryRuleTag() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTag = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1774:2: (iv_ruleTag= ruleTag EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1775:2: iv_ruleTag= ruleTag EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTagRule()); 
            }
            pushFollow(FOLLOW_ruleTag_in_entryRuleTag3895);
            iv_ruleTag=ruleTag();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTag; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTag3905); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1782:1: ruleTag returns [EObject current=null] : ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' ) ;
    public final EObject ruleTag() throws RecognitionException {
        EObject current = null;

        Token this_NEWLINE_0=null;
        Token otherlv_1=null;
        Token lv_tagValue_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1785:28: ( ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1786:1: ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1786:1: ( (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1786:2: (this_NEWLINE_0= RULE_NEWLINE )? otherlv_1= '[APPLICATION' ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) ) otherlv_3= ']'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1786:2: (this_NEWLINE_0= RULE_NEWLINE )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_NEWLINE) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1786:3: this_NEWLINE_0= RULE_NEWLINE
                    {
                    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleTag3942); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_0, grammarAccess.getTagAccess().getNEWLINETerminalRuleCall_0()); 
                          
                    }

                    }
                    break;

            }

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleTag3955); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTagAccess().getAPPLICATIONKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1794:1: ( (lv_tagValue_2_0= RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1795:1: (lv_tagValue_2_0= RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1795:1: (lv_tagValue_2_0= RULE_BIG_INTEGER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1796:3: lv_tagValue_2_0= RULE_BIG_INTEGER
            {
            lv_tagValue_2_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleTag3972); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,36,FOLLOW_36_in_ruleTag3989); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1824:1: entryRuleValueType returns [EObject current=null] : iv_ruleValueType= ruleValueType EOF ;
    public final EObject entryRuleValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1825:2: (iv_ruleValueType= ruleValueType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1826:2: iv_ruleValueType= ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType4025);
            iv_ruleValueType=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType4035); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1833:1: ruleValueType returns [EObject current=null] : ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_id_1_0= RULE_ASN1_ID ) ) | ( (lv_types_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( () otherlv_6= 'OBJECT IDENTIFIER' ) ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1836:28: ( ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_id_1_0= RULE_ASN1_ID ) ) | ( (lv_types_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( () otherlv_6= 'OBJECT IDENTIFIER' ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1837:1: ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_id_1_0= RULE_ASN1_ID ) ) | ( (lv_types_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( () otherlv_6= 'OBJECT IDENTIFIER' ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1837:1: ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_id_1_0= RULE_ASN1_ID ) ) | ( (lv_types_2_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_3_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_4_0= ruleMacroValue ) ) | ( () otherlv_6= 'OBJECT IDENTIFIER' ) )
            int alt47=6;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt47=1;
                }
                break;
            case RULE_ASN1_ID:
                {
                alt47=2;
                }
                break;
            case RULE_MODULE_ID:
            case 31:
                {
                alt47=3;
                }
                break;
            case RULE_IA5STRING:
            case 42:
            case 43:
            case 45:
            case 48:
            case 49:
                {
                alt47=4;
                }
                break;
            case 37:
                {
                alt47=5;
                }
                break;
            case 24:
                {
                alt47=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1837:2: ( (lv_param_0_0= ruleParamAssignment ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1837:2: ( (lv_param_0_0= ruleParamAssignment ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1838:1: (lv_param_0_0= ruleParamAssignment )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1838:1: (lv_param_0_0= ruleParamAssignment )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1839:3: lv_param_0_0= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleValueType4081);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1856:6: ( (lv_id_1_0= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1856:6: ( (lv_id_1_0= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1857:1: (lv_id_1_0= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1857:1: (lv_id_1_0= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1858:3: lv_id_1_0= RULE_ASN1_ID
                    {
                    lv_id_1_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleValueType4104); if (state.failed) return current;
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1875:6: ( (lv_types_2_0= ruleTypeReferenceExt ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1875:6: ( (lv_types_2_0= ruleTypeReferenceExt ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1876:1: (lv_types_2_0= ruleTypeReferenceExt )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1876:1: (lv_types_2_0= ruleTypeReferenceExt )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1877:3: lv_types_2_0= ruleTypeReferenceExt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getTypesTypeReferenceExtParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReferenceExt_in_ruleValueType4136);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1894:6: ( (lv_simpleType_3_0= ruleASN1_TYPE ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1894:6: ( (lv_simpleType_3_0= ruleASN1_TYPE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1895:1: (lv_simpleType_3_0= ruleASN1_TYPE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1895:1: (lv_simpleType_3_0= ruleASN1_TYPE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1896:3: lv_simpleType_3_0= ruleASN1_TYPE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_TYPE_in_ruleValueType4163);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1913:6: ( (lv_macroValue_4_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1913:6: ( (lv_macroValue_4_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1914:1: (lv_macroValue_4_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1914:1: (lv_macroValue_4_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1915:3: lv_macroValue_4_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleValueType4190);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1932:6: ( () otherlv_6= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1932:6: ( () otherlv_6= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1932:7: () otherlv_6= 'OBJECT IDENTIFIER'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1932:7: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1933:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getValueTypeAccess().getValueTypeAction_5_0(),
                                  current);
                          
                    }

                    }

                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleValueType4218); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1950:1: entryRuleMacroValue returns [EObject current=null] : iv_ruleMacroValue= ruleMacroValue EOF ;
    public final EObject entryRuleMacroValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacroValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1951:2: (iv_ruleMacroValue= ruleMacroValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1952:2: iv_ruleMacroValue= ruleMacroValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroValueRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue4255);
            iv_ruleMacroValue=ruleMacroValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacroValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue4265); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1959:1: ruleMacroValue returns [EObject current=null] : ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMacroValueType ) ) otherlv_4= ')' ) ;
    public final EObject ruleMacroValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_valueType_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1962:28: ( ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMacroValueType ) ) otherlv_4= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1963:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMacroValueType ) ) otherlv_4= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1963:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMacroValueType ) ) otherlv_4= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1963:2: () otherlv_1= 'value' otherlv_2= '(' ( (lv_valueType_3_0= ruleMacroValueType ) ) otherlv_4= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1963:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1964:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getMacroValueAccess().getMacroValueAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleMacroValue4311); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMacroValueAccess().getValueKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleMacroValue4323); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMacroValueAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1977:1: ( (lv_valueType_3_0= ruleMacroValueType ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1978:1: (lv_valueType_3_0= ruleMacroValueType )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1978:1: (lv_valueType_3_0= ruleMacroValueType )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1979:3: lv_valueType_3_0= ruleMacroValueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroValueAccess().getValueTypeMacroValueTypeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMacroValueType_in_ruleMacroValue4344);
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

            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleMacroValue4356); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2007:1: entryRuleMacroValueType returns [EObject current=null] : iv_ruleMacroValueType= ruleMacroValueType EOF ;
    public final EObject entryRuleMacroValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacroValueType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2008:2: (iv_ruleMacroValueType= ruleMacroValueType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2009:2: iv_ruleMacroValueType= ruleMacroValueType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValueType_in_entryRuleMacroValueType4392);
            iv_ruleMacroValueType=ruleMacroValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacroValueType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValueType4402); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2016:1: ruleMacroValueType returns [EObject current=null] : ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) ) ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) ) ) ;
    public final EObject ruleMacroValueType() throws RecognitionException {
        EObject current = null;

        Token lv_update_1_0=null;
        Token lv_valueCAP_2_0=null;
        Token lv_oi_4_0=null;
        Token lv_string_5_0=null;
        EObject lv_ref_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2019:28: ( ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) ) ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2020:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) ) ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2020:1: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) ) ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2020:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) ) ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2020:2: ( ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2022:1: ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2022:1: ( ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2023:2: ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* )
            {
            getUnorderedGroupHelper().enter(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0());
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2026:2: ( ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2027:3: ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2027:3: ( ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) ) )*
            loop48:
            do {
                int alt48=3;
                int LA48_0 = input.LA(1);

                if ( LA48_0 ==40 && getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 0) ) {
                    alt48=1;
                }
                else if ( LA48_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 1) ) {
                    alt48=2;
                }


                switch (alt48) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2029:4: ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2029:4: ({...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2030:5: {...}? => ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 0) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMacroValueType", "getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 0)");
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2030:111: ( ({...}? => ( (lv_update_1_0= 'Update' ) ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2031:6: ({...}? => ( (lv_update_1_0= 'Update' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 0);
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2034:6: ({...}? => ( (lv_update_1_0= 'Update' ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2034:7: {...}? => ( (lv_update_1_0= 'Update' ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMacroValueType", "true");
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2034:16: ( (lv_update_1_0= 'Update' ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2035:1: (lv_update_1_0= 'Update' )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2035:1: (lv_update_1_0= 'Update' )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2036:3: lv_update_1_0= 'Update'
            	    {
            	    lv_update_1_0=(Token)match(input,40,FOLLOW_40_in_ruleMacroValueType4490); if (state.failed) return current;
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2056:4: ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2056:4: ({...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2057:5: {...}? => ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 1) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMacroValueType", "getUnorderedGroupHelper().canSelect(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 1)");
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2057:111: ( ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2058:6: ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) )
            	    {
            	    getUnorderedGroupHelper().select(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0(), 1);
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2061:6: ({...}? => ( (lv_valueCAP_2_0= 'VALUE' ) ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2061:7: {...}? => ( (lv_valueCAP_2_0= 'VALUE' ) )
            	    {
            	    if ( !((true)) ) {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        throw new FailedPredicateException(input, "ruleMacroValueType", "true");
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2061:16: ( (lv_valueCAP_2_0= 'VALUE' ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2062:1: (lv_valueCAP_2_0= 'VALUE' )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2062:1: (lv_valueCAP_2_0= 'VALUE' )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2063:3: lv_valueCAP_2_0= 'VALUE'
            	    {
            	    lv_valueCAP_2_0=(Token)match(input,30,FOLLOW_30_in_ruleMacroValueType4575); if (state.failed) return current;
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
            	    break loop48;
                }
            } while (true);


            }


            }

            getUnorderedGroupHelper().leave(grammarAccess.getMacroValueTypeAccess().getUnorderedGroup_0());

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2090:2: ( ( (lv_ref_3_0= ruleTypeReference ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) | ( (lv_string_5_0= 'IA5String' ) ) )
            int alt49=3;
            switch ( input.LA(1) ) {
            case RULE_MODULE_ID:
            case 31:
                {
                alt49=1;
                }
                break;
            case 24:
                {
                alt49=2;
                }
                break;
            case 41:
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2090:3: ( (lv_ref_3_0= ruleTypeReference ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2090:3: ( (lv_ref_3_0= ruleTypeReference ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2091:1: (lv_ref_3_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2091:1: (lv_ref_3_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2092:3: lv_ref_3_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMacroValueTypeAccess().getRefTypeReferenceParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleMacroValueType4650);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2109:6: ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2109:6: ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2110:1: (lv_oi_4_0= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2110:1: (lv_oi_4_0= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2111:3: lv_oi_4_0= 'OBJECT IDENTIFIER'
                    {
                    lv_oi_4_0=(Token)match(input,24,FOLLOW_24_in_ruleMacroValueType4674); if (state.failed) return current;
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2125:6: ( (lv_string_5_0= 'IA5String' ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2125:6: ( (lv_string_5_0= 'IA5String' ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2126:1: (lv_string_5_0= 'IA5String' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2126:1: (lv_string_5_0= 'IA5String' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2127:3: lv_string_5_0= 'IA5String'
                    {
                    lv_string_5_0=(Token)match(input,41,FOLLOW_41_in_ruleMacroValueType4711); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2148:1: entryRuleASN1_TYPE returns [EObject current=null] : iv_ruleASN1_TYPE= ruleASN1_TYPE EOF ;
    public final EObject entryRuleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_TYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2149:2: (iv_ruleASN1_TYPE= ruleASN1_TYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2150:2: iv_ruleASN1_TYPE= ruleASN1_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE4761);
            iv_ruleASN1_TYPE=ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_TYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE4771); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2157:1: ruleASN1_TYPE returns [EObject current=null] : (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE | this_ASN1_SEQUENCE_2= ruleASN1_SEQUENCE ) ;
    public final EObject ruleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject this_ASN1_SIMPLE_0 = null;

        EObject this_ASN1_CHOICE_1 = null;

        EObject this_ASN1_SEQUENCE_2 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2160:28: ( (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE | this_ASN1_SEQUENCE_2= ruleASN1_SEQUENCE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2161:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE | this_ASN1_SEQUENCE_2= ruleASN1_SEQUENCE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2161:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE | this_ASN1_SEQUENCE_2= ruleASN1_SEQUENCE )
            int alt50=3;
            switch ( input.LA(1) ) {
            case RULE_IA5STRING:
            case 42:
            case 43:
            case 45:
                {
                alt50=1;
                }
                break;
            case 48:
                {
                alt50=2;
                }
                break;
            case 49:
                {
                alt50=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2162:5: this_ASN1_SIMPLE_0= ruleASN1_SIMPLE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE4818);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2172:5: this_ASN1_CHOICE_1= ruleASN1_CHOICE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE4845);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2182:5: this_ASN1_SEQUENCE_2= ruleASN1_SEQUENCE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_SEQUENCEParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_SEQUENCE_in_ruleASN1_TYPE4872);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2198:1: entryRuleASN1_SIMPLE returns [EObject current=null] : iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF ;
    public final EObject entryRuleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SIMPLE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2199:2: (iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2200:2: iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SIMPLERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE4907);
            iv_ruleASN1_SIMPLE=ruleASN1_SIMPLE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SIMPLE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE4917); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2207:1: ruleASN1_SIMPLE returns [EObject current=null] : ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER ) ;
    public final EObject ruleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_IA5STRING_3=null;
        EObject this_ASN1_OCTET_STRING_4 = null;

        EObject lv_constraint_5_0 = null;

        EObject this_ASN1_INTEGER_6 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2210:28: ( ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2211:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2211:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | this_ASN1_INTEGER_6= ruleASN1_INTEGER )
            int alt52=4;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt52=1;
                }
                break;
            case RULE_IA5STRING:
                {
                alt52=2;
                }
                break;
            case 43:
                {
                alt52=3;
                }
                break;
            case 45:
                {
                alt52=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2211:2: ( () otherlv_1= 'empty' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2211:2: ( () otherlv_1= 'empty' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2211:3: () otherlv_1= 'empty'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2211:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2212:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleASN1_SIMPLE4964); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2222:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2222:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2222:7: () this_IA5STRING_3= RULE_IA5STRING
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2222:7: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2223:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_1_0(),
                                  current);
                          
                    }

                    }

                    this_IA5STRING_3=(Token)match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE4992); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_IA5STRING_3, grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2233:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2233:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2234:5: this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE5021);
                    this_ASN1_OCTET_STRING_4=ruleASN1_OCTET_STRING();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_OCTET_STRING_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2242:1: ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==38) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2243:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2243:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2244:3: lv_constraint_5_0= ruleASN1_SUBTYPE
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE5041);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2262:5: this_ASN1_INTEGER_6= ruleASN1_INTEGER
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE5071);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2278:1: entryRuleASN1_OCTET_STRING returns [EObject current=null] : iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF ;
    public final EObject entryRuleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_OCTET_STRING = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2279:2: (iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2280:2: iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING5106);
            iv_ruleASN1_OCTET_STRING=ruleASN1_OCTET_STRING();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_OCTET_STRING; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING5116); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2287:1: ruleASN1_OCTET_STRING returns [EObject current=null] : ( () otherlv_1= 'OCTET' otherlv_2= 'STRING' ) ;
    public final EObject ruleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2290:28: ( ( () otherlv_1= 'OCTET' otherlv_2= 'STRING' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2291:1: ( () otherlv_1= 'OCTET' otherlv_2= 'STRING' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2291:1: ( () otherlv_1= 'OCTET' otherlv_2= 'STRING' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2291:2: () otherlv_1= 'OCTET' otherlv_2= 'STRING'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2291:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2292:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleASN1_OCTET_STRING5162); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_OCTET_STRINGAccess().getOCTETKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleASN1_OCTET_STRING5174); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2313:1: entryRuleASN1_INTEGER returns [EObject current=null] : iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF ;
    public final EObject entryRuleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_INTEGER = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2314:2: (iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2315:2: iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_INTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER5210);
            iv_ruleASN1_INTEGER=ruleASN1_INTEGER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_INTEGER; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER5220); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2322:1: ruleASN1_INTEGER returns [EObject current=null] : ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )? ) ;
    public final EObject ruleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_range_2_0 = null;

        EObject lv_refinement_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2325:28: ( ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )? ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2326:1: ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )? )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2326:1: ( ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )? )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2326:2: ( (lv_name_0_0= 'INTEGER' ) ) (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )? ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )?
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2326:2: ( (lv_name_0_0= 'INTEGER' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2327:1: (lv_name_0_0= 'INTEGER' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2327:1: (lv_name_0_0= 'INTEGER' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2328:3: lv_name_0_0= 'INTEGER'
            {
            lv_name_0_0=(Token)match(input,45,FOLLOW_45_in_ruleASN1_INTEGER5263); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2341:2: (otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==38) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2341:4: otherlv_1= '(' ( (lv_range_2_0= ruleASN1_RANGE ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleASN1_INTEGER5289); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getASN1_INTEGERAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2345:1: ( (lv_range_2_0= ruleASN1_RANGE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2346:1: (lv_range_2_0= ruleASN1_RANGE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2346:1: (lv_range_2_0= ruleASN1_RANGE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2347:3: lv_range_2_0= ruleASN1_RANGE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getASN1_INTEGERAccess().getRangeASN1_RANGEParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_INTEGER5310);
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

                    otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleASN1_INTEGER5322); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getASN1_INTEGERAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2367:3: ( (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==25) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2368:1: (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2368:1: (lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2369:3: lv_refinement_4_0= ruleASN1_INTEGER_REFINEMENT
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getASN1_INTEGERAccess().getRefinementASN1_INTEGER_REFINEMENTParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_INTEGER_REFINEMENT_in_ruleASN1_INTEGER5345);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2393:1: entryRuleASN1_INTEGER_REFINEMENT returns [EObject current=null] : iv_ruleASN1_INTEGER_REFINEMENT= ruleASN1_INTEGER_REFINEMENT EOF ;
    public final EObject entryRuleASN1_INTEGER_REFINEMENT() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_INTEGER_REFINEMENT = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2394:2: (iv_ruleASN1_INTEGER_REFINEMENT= ruleASN1_INTEGER_REFINEMENT EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2395:2: iv_ruleASN1_INTEGER_REFINEMENT= ruleASN1_INTEGER_REFINEMENT EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_INTEGER_REFINEMENTRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_REFINEMENT_in_entryRuleASN1_INTEGER_REFINEMENT5382);
            iv_ruleASN1_INTEGER_REFINEMENT=ruleASN1_INTEGER_REFINEMENT();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_INTEGER_REFINEMENT; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER_REFINEMENT5392); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2402:1: ruleASN1_INTEGER_REFINEMENT returns [EObject current=null] : (otherlv_0= '{' ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' ) (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )* (this_NEWLINE_12= RULE_NEWLINE )* otherlv_13= '}' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2405:28: ( (otherlv_0= '{' ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' ) (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )* (this_NEWLINE_12= RULE_NEWLINE )* otherlv_13= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2406:1: (otherlv_0= '{' ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' ) (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )* (this_NEWLINE_12= RULE_NEWLINE )* otherlv_13= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2406:1: (otherlv_0= '{' ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' ) (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )* (this_NEWLINE_12= RULE_NEWLINE )* otherlv_13= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2406:3: otherlv_0= '{' ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' ) (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )* (this_NEWLINE_12= RULE_NEWLINE )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleASN1_INTEGER_REFINEMENT5429); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getLeftCurlyBracketKeyword_0());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2410:1: ( (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2410:2: (this_NEWLINE_1= RULE_NEWLINE )* ( (lv_refinements_2_0= RULE_ASN1_ID ) ) otherlv_3= '(' ( (lv_ints_4_0= RULE_BIG_INTEGER ) ) otherlv_5= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2410:2: (this_NEWLINE_1= RULE_NEWLINE )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_NEWLINE) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2410:3: this_NEWLINE_1= RULE_NEWLINE
            	    {
            	    this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5442); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_1, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getNEWLINETerminalRuleCall_1_0()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2414:3: ( (lv_refinements_2_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2415:1: (lv_refinements_2_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2415:1: (lv_refinements_2_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2416:3: lv_refinements_2_0= RULE_ASN1_ID
            {
            lv_refinements_2_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_INTEGER_REFINEMENT5460); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,38,FOLLOW_38_in_ruleASN1_INTEGER_REFINEMENT5477); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getLeftParenthesisKeyword_1_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2436:1: ( (lv_ints_4_0= RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2437:1: (lv_ints_4_0= RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2437:1: (lv_ints_4_0= RULE_BIG_INTEGER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2438:3: lv_ints_4_0= RULE_BIG_INTEGER
            {
            lv_ints_4_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_INTEGER_REFINEMENT5494); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,39,FOLLOW_39_in_ruleASN1_INTEGER_REFINEMENT5511); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getRightParenthesisKeyword_1_4());
                  
            }

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2458:2: (otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')' )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==23) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2458:4: otherlv_6= ',' (this_NEWLINE_7= RULE_NEWLINE )* ( (lv_refinements_8_0= RULE_ASN1_ID ) ) otherlv_9= '(' ( (lv_ints_10_0= RULE_BIG_INTEGER ) ) otherlv_11= ')'
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleASN1_INTEGER_REFINEMENT5525); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2462:1: (this_NEWLINE_7= RULE_NEWLINE )*
            	    loop56:
            	    do {
            	        int alt56=2;
            	        int LA56_0 = input.LA(1);

            	        if ( (LA56_0==RULE_NEWLINE) ) {
            	            alt56=1;
            	        }


            	        switch (alt56) {
            	    	case 1 :
            	    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2462:2: this_NEWLINE_7= RULE_NEWLINE
            	    	    {
            	    	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5537); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_NEWLINE_7, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getNEWLINETerminalRuleCall_2_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop56;
            	        }
            	    } while (true);

            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2466:3: ( (lv_refinements_8_0= RULE_ASN1_ID ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2467:1: (lv_refinements_8_0= RULE_ASN1_ID )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2467:1: (lv_refinements_8_0= RULE_ASN1_ID )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2468:3: lv_refinements_8_0= RULE_ASN1_ID
            	    {
            	    lv_refinements_8_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_INTEGER_REFINEMENT5555); if (state.failed) return current;
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

            	    otherlv_9=(Token)match(input,38,FOLLOW_38_in_ruleASN1_INTEGER_REFINEMENT5572); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getLeftParenthesisKeyword_2_3());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2488:1: ( (lv_ints_10_0= RULE_BIG_INTEGER ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2489:1: (lv_ints_10_0= RULE_BIG_INTEGER )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2489:1: (lv_ints_10_0= RULE_BIG_INTEGER )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2490:3: lv_ints_10_0= RULE_BIG_INTEGER
            	    {
            	    lv_ints_10_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_INTEGER_REFINEMENT5589); if (state.failed) return current;
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

            	    otherlv_11=(Token)match(input,39,FOLLOW_39_in_ruleASN1_INTEGER_REFINEMENT5606); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_11, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getRightParenthesisKeyword_2_5());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2510:3: (this_NEWLINE_12= RULE_NEWLINE )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_NEWLINE) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2510:4: this_NEWLINE_12= RULE_NEWLINE
            	    {
            	    this_NEWLINE_12=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5620); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_12, grammarAccess.getASN1_INTEGER_REFINEMENTAccess().getNEWLINETerminalRuleCall_3()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            otherlv_13=(Token)match(input,26,FOLLOW_26_in_ruleASN1_INTEGER_REFINEMENT5633); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2526:1: entryRuleASN1_SUBTYPE returns [EObject current=null] : iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF ;
    public final EObject entryRuleASN1_SUBTYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SUBTYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2527:2: (iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2528:2: iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SUBTYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE5669);
            iv_ruleASN1_SUBTYPE=ruleASN1_SUBTYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SUBTYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE5679); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2535:1: ruleASN1_SUBTYPE returns [EObject current=null] : (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2538:28: ( (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2539:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2539:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2539:3: otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleASN1_SUBTYPE5716); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleASN1_SUBTYPE5728); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleASN1_SUBTYPE5740); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2551:1: ( (lv_ranges_3_0= ruleASN1_RANGE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2552:1: (lv_ranges_3_0= ruleASN1_RANGE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2552:1: (lv_ranges_3_0= ruleASN1_RANGE )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2553:3: lv_ranges_3_0= ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE5761);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2569:2: (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==34) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2569:4: otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    {
            	    otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleASN1_SUBTYPE5774); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getASN1_SUBTYPEAccess().getVerticalLineKeyword_4_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2573:1: ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2574:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2574:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2575:3: lv_ranges_5_0= ruleASN1_RANGE
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE5795);
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
            	    break loop59;
                }
            } while (true);

            otherlv_6=(Token)match(input,39,FOLLOW_39_in_ruleASN1_SUBTYPE5809); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,39,FOLLOW_39_in_ruleASN1_SUBTYPE5821); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2607:1: entryRuleASN1_RANGE returns [EObject current=null] : iv_ruleASN1_RANGE= ruleASN1_RANGE EOF ;
    public final EObject entryRuleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_RANGE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2608:2: (iv_ruleASN1_RANGE= ruleASN1_RANGE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2609:2: iv_ruleASN1_RANGE= ruleASN1_RANGE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_RANGERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE5857);
            iv_ruleASN1_RANGE=ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_RANGE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE5867); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2616:1: ruleASN1_RANGE returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) ) ;
    public final EObject ruleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_start_2_0=null;
        Token otherlv_3=null;
        Token lv_end_4_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2619:28: ( ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2620:1: ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2620:1: ( ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) ) | ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_BIG_INTEGER) ) {
                int LA60_1 = input.LA(2);

                if ( (LA60_1==47) ) {
                    alt60=2;
                }
                else if ( (LA60_1==EOF||LA60_1==34||LA60_1==39) ) {
                    alt60=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2620:2: ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2620:2: ( () ( (lv_value_1_0= RULE_BIG_INTEGER ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2620:3: () ( (lv_value_1_0= RULE_BIG_INTEGER ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2620:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2621:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2626:2: ( (lv_value_1_0= RULE_BIG_INTEGER ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2627:1: (lv_value_1_0= RULE_BIG_INTEGER )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2627:1: (lv_value_1_0= RULE_BIG_INTEGER )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2628:3: lv_value_1_0= RULE_BIG_INTEGER
                    {
                    lv_value_1_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE5919); if (state.failed) return current;
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2645:6: ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2645:6: ( ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2645:7: ( (lv_start_2_0= RULE_BIG_INTEGER ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_BIG_INTEGER ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2645:7: ( (lv_start_2_0= RULE_BIG_INTEGER ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2646:1: (lv_start_2_0= RULE_BIG_INTEGER )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2646:1: (lv_start_2_0= RULE_BIG_INTEGER )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2647:3: lv_start_2_0= RULE_BIG_INTEGER
                    {
                    lv_start_2_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE5949); if (state.failed) return current;
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

                    otherlv_3=(Token)match(input,47,FOLLOW_47_in_ruleASN1_RANGE5966); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_1_1());
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2667:1: ( (lv_end_4_0= RULE_BIG_INTEGER ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2668:1: (lv_end_4_0= RULE_BIG_INTEGER )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2668:1: (lv_end_4_0= RULE_BIG_INTEGER )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2669:3: lv_end_4_0= RULE_BIG_INTEGER
                    {
                    lv_end_4_0=(Token)match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE5983); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2693:1: entryRuleASN1_CHOICE returns [EObject current=null] : iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF ;
    public final EObject entryRuleASN1_CHOICE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2694:2: (iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2695:2: iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE6025);
            iv_ruleASN1_CHOICE=ruleASN1_CHOICE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE6035); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2702:1: ruleASN1_CHOICE returns [EObject current=null] : (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2705:28: ( (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2706:1: (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2706:1: (otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2706:3: otherlv_0= 'CHOICE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleASN1_CHOICE6072); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleASN1_CHOICE6084); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2714:1: (this_NEWLINE_2= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2714:2: this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6096); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_2, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_2()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2718:3: ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2719:1: (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2719:1: (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2720:3: lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE6118);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2736:2: (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==23) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2736:4: otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleASN1_CHOICE6131); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2740:1: (this_NEWLINE_5= RULE_NEWLINE )+
            	    int cnt62=0;
            	    loop62:
            	    do {
            	        int alt62=2;
            	        int LA62_0 = input.LA(1);

            	        if ( (LA62_0==RULE_NEWLINE) ) {
            	            alt62=1;
            	        }


            	        switch (alt62) {
            	    	case 1 :
            	    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2740:2: this_NEWLINE_5= RULE_NEWLINE
            	    	    {
            	    	    this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6143); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_NEWLINE_5, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_4_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt62 >= 1 ) break loop62;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(62, input);
            	                throw eee;
            	        }
            	        cnt62++;
            	    } while (true);

            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2744:3: ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2745:1: (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2745:1: (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2746:3: lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_4_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE6165);
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
            	    break loop63;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2762:4: (this_NEWLINE_7= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2762:5: this_NEWLINE_7= RULE_NEWLINE
            	    {
            	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6179); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_7, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_5()); 
            	          
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

            otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleASN1_CHOICE6192); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2778:1: entryRuleASN1_SEQUENCE returns [EObject current=null] : iv_ruleASN1_SEQUENCE= ruleASN1_SEQUENCE EOF ;
    public final EObject entryRuleASN1_SEQUENCE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SEQUENCE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2779:2: (iv_ruleASN1_SEQUENCE= ruleASN1_SEQUENCE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2780:2: iv_ruleASN1_SEQUENCE= ruleASN1_SEQUENCE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SEQUENCERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SEQUENCE_in_entryRuleASN1_SEQUENCE6228);
            iv_ruleASN1_SEQUENCE=ruleASN1_SEQUENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SEQUENCE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SEQUENCE6238); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2787:1: ruleASN1_SEQUENCE returns [EObject current=null] : (otherlv_0= 'SEQUENCE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2790:28: ( (otherlv_0= 'SEQUENCE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2791:1: (otherlv_0= 'SEQUENCE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2791:1: (otherlv_0= 'SEQUENCE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2791:3: otherlv_0= 'SEQUENCE' otherlv_1= '{' (this_NEWLINE_2= RULE_NEWLINE )+ ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )* (this_NEWLINE_7= RULE_NEWLINE )+ otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleASN1_SEQUENCE6275); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_SEQUENCEAccess().getSEQUENCEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleASN1_SEQUENCE6287); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_SEQUENCEAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2799:1: (this_NEWLINE_2= RULE_NEWLINE )+
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
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2799:2: this_NEWLINE_2= RULE_NEWLINE
            	    {
            	    this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6299); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_2, grammarAccess.getASN1_SEQUENCEAccess().getNEWLINETerminalRuleCall_2()); 
            	          
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2803:3: ( (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2804:1: (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2804:1: (lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2805:3: lv_choiceType_3_0= ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_SEQUENCEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_SEQUENCE6321);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2821:2: (otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==23) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2821:4: otherlv_4= ',' (this_NEWLINE_5= RULE_NEWLINE )+ ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleASN1_SEQUENCE6334); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getASN1_SEQUENCEAccess().getCommaKeyword_4_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2825:1: (this_NEWLINE_5= RULE_NEWLINE )+
            	    int cnt66=0;
            	    loop66:
            	    do {
            	        int alt66=2;
            	        int LA66_0 = input.LA(1);

            	        if ( (LA66_0==RULE_NEWLINE) ) {
            	            alt66=1;
            	        }


            	        switch (alt66) {
            	    	case 1 :
            	    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2825:2: this_NEWLINE_5= RULE_NEWLINE
            	    	    {
            	    	    this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6346); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {
            	    	       
            	    	          newLeafNode(this_NEWLINE_5, grammarAccess.getASN1_SEQUENCEAccess().getNEWLINETerminalRuleCall_4_1()); 
            	    	          
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt66 >= 1 ) break loop66;
            	    	    if (state.backtracking>0) {state.failed=true; return current;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(66, input);
            	                throw eee;
            	        }
            	        cnt66++;
            	    } while (true);

            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2829:3: ( (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2830:1: (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2830:1: (lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2831:3: lv_choiceType_6_0= ruleASN1_CHOICE_ENTRY
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_SEQUENCEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_4_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_SEQUENCE6368);
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
            	    break loop67;
                }
            } while (true);

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2847:4: (this_NEWLINE_7= RULE_NEWLINE )+
            int cnt68=0;
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==RULE_NEWLINE) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2847:5: this_NEWLINE_7= RULE_NEWLINE
            	    {
            	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6382); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_NEWLINE_7, grammarAccess.getASN1_SEQUENCEAccess().getNEWLINETerminalRuleCall_5()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt68 >= 1 ) break loop68;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(68, input);
                        throw eee;
                }
                cnt68++;
            } while (true);

            otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleASN1_SEQUENCE6395); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2863:1: entryRuleASN1_SEQUENCE_OF returns [EObject current=null] : iv_ruleASN1_SEQUENCE_OF= ruleASN1_SEQUENCE_OF EOF ;
    public final EObject entryRuleASN1_SEQUENCE_OF() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SEQUENCE_OF = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2864:2: (iv_ruleASN1_SEQUENCE_OF= ruleASN1_SEQUENCE_OF EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2865:2: iv_ruleASN1_SEQUENCE_OF= ruleASN1_SEQUENCE_OF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SEQUENCE_OFRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SEQUENCE_OF_in_entryRuleASN1_SEQUENCE_OF6431);
            iv_ruleASN1_SEQUENCE_OF=ruleASN1_SEQUENCE_OF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SEQUENCE_OF; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SEQUENCE_OF6441); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2872:1: ruleASN1_SEQUENCE_OF returns [EObject current=null] : (otherlv_0= 'SEQUENCE' otherlv_1= 'OF' ( (lv_ref_2_0= ruleTypeReference ) ) ) ;
    public final EObject ruleASN1_SEQUENCE_OF() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_ref_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2875:28: ( (otherlv_0= 'SEQUENCE' otherlv_1= 'OF' ( (lv_ref_2_0= ruleTypeReference ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2876:1: (otherlv_0= 'SEQUENCE' otherlv_1= 'OF' ( (lv_ref_2_0= ruleTypeReference ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2876:1: (otherlv_0= 'SEQUENCE' otherlv_1= 'OF' ( (lv_ref_2_0= ruleTypeReference ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2876:3: otherlv_0= 'SEQUENCE' otherlv_1= 'OF' ( (lv_ref_2_0= ruleTypeReference ) )
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleASN1_SEQUENCE_OF6478); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_SEQUENCE_OFAccess().getSEQUENCEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleASN1_SEQUENCE_OF6490); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_SEQUENCE_OFAccess().getOFKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2884:1: ( (lv_ref_2_0= ruleTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2885:1: (lv_ref_2_0= ruleTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2885:1: (lv_ref_2_0= ruleTypeReference )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2886:3: lv_ref_2_0= ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_SEQUENCE_OFAccess().getRefTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeReference_in_ruleASN1_SEQUENCE_OF6511);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2910:1: entryRuleASN1_CHOICE_ENTRY returns [EObject current=null] : iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF ;
    public final EObject entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE_ENTRY = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2911:2: (iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2912:2: iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY6547);
            iv_ruleASN1_CHOICE_ENTRY=ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE_ENTRY; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY6557); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2919:1: ruleASN1_CHOICE_ENTRY returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) ) ;
    public final EObject ruleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token this_NEWLINE_1=null;
        EObject lv_valueType_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2922:28: ( ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2923:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2923:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2923:2: ( (lv_id_0_0= RULE_ASN1_ID ) ) (this_NEWLINE_1= RULE_NEWLINE )? ( (lv_valueType_2_0= ruleChoiceType ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2923:2: ( (lv_id_0_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2924:1: (lv_id_0_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2924:1: (lv_id_0_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2925:3: lv_id_0_0= RULE_ASN1_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY6599); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2941:2: (this_NEWLINE_1= RULE_NEWLINE )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_NEWLINE) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2941:3: this_NEWLINE_1= RULE_NEWLINE
                    {
                    this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE_ENTRY6616); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_NEWLINE_1, grammarAccess.getASN1_CHOICE_ENTRYAccess().getNEWLINETerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2945:3: ( (lv_valueType_2_0= ruleChoiceType ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2946:1: (lv_valueType_2_0= ruleChoiceType )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2946:1: (lv_valueType_2_0= ruleChoiceType )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2947:3: lv_valueType_2_0= ruleChoiceType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeChoiceTypeParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleChoiceType_in_ruleASN1_CHOICE_ENTRY6638);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2971:1: entryRuleChoiceType returns [EObject current=null] : iv_ruleChoiceType= ruleChoiceType EOF ;
    public final EObject entryRuleChoiceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoiceType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2972:2: (iv_ruleChoiceType= ruleChoiceType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2973:2: iv_ruleChoiceType= ruleChoiceType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getChoiceTypeRule()); 
            }
            pushFollow(FOLLOW_ruleChoiceType_in_entryRuleChoiceType6674);
            iv_ruleChoiceType=ruleChoiceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleChoiceType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoiceType6684); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2980:1: ruleChoiceType returns [EObject current=null] : ( () ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' ) ) ;
    public final EObject ruleChoiceType() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_typeRef_1_0 = null;

        EObject lv_simpleType_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2983:28: ( ( () ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2984:1: ( () ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2984:1: ( () ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2984:2: () ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2984:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2985:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getChoiceTypeAccess().getChoiceTypeAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2990:2: ( ( (lv_typeRef_1_0= ruleTypeReference ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | otherlv_3= 'OBJECT IDENTIFIER' )
            int alt70=3;
            switch ( input.LA(1) ) {
            case RULE_MODULE_ID:
            case 31:
                {
                alt70=1;
                }
                break;
            case RULE_IA5STRING:
            case 42:
            case 43:
            case 45:
            case 48:
            case 49:
                {
                alt70=2;
                }
                break;
            case 24:
                {
                alt70=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2990:3: ( (lv_typeRef_1_0= ruleTypeReference ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2990:3: ( (lv_typeRef_1_0= ruleTypeReference ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2991:1: (lv_typeRef_1_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2991:1: (lv_typeRef_1_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:2992:3: lv_typeRef_1_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getChoiceTypeAccess().getTypeRefTypeReferenceParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleChoiceType6740);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3009:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3009:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3010:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3010:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3011:3: lv_simpleType_2_0= ruleASN1_TYPE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getChoiceTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_TYPE_in_ruleChoiceType6767);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:3028:7: otherlv_3= 'OBJECT IDENTIFIER'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleChoiceType6785); if (state.failed) return current;
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
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:606:7: ( ( RULE_ASN1_ID ) )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:607:1: ( RULE_ASN1_ID )
        {
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:607:1: ( RULE_ASN1_ID )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:608:2: RULE_ASN1_ID
        {
        match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_synpred1_InternalSmi1277); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalSmi

    // $ANTLR start synpred2_InternalSmi
    public final void synpred2_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1516:3: ( ( ruleTypeReference ) )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1517:1: ( ruleTypeReference )
        {
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1517:1: ( ruleTypeReference )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1518:1: ruleTypeReference
        {
        pushFollow(FOLLOW_ruleTypeReference_in_synpred2_InternalSmi3294);
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
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA45 dfa45 = new DFA45(this);
    static final String DFA1_eotS =
        "\4\uffff";
    static final String DFA1_eofS =
        "\4\uffff";
    static final String DFA1_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA1_maxS =
        "\1\5\1\24\2\uffff";
    static final String DFA1_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA1_specialS =
        "\4\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1",
            "\1\2\1\1\1\2\15\uffff\1\3",
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
        "\5\uffff";
    static final String DFA2_eofS =
        "\5\uffff";
    static final String DFA2_minS =
        "\1\5\1\4\3\uffff";
    static final String DFA2_maxS =
        "\1\5\1\23\3\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA2_specialS =
        "\5\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1",
            "\1\2\1\1\1\3\14\uffff\1\4",
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
            return "()+ loopback of 128:3: ( ( (lv_objects_5_0= ruleObjectReferenceable ) ) | ( (lv_types_6_0= ruleReferenceable ) ) )+";
        }
    }
    static final String DFA16_eotS =
        "\4\uffff";
    static final String DFA16_eofS =
        "\1\2\3\uffff";
    static final String DFA16_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA16_maxS =
        "\2\21\2\uffff";
    static final String DFA16_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA16_specialS =
        "\4\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\1\13\uffff\1\2",
            "\1\3\1\1\13\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "()+ loopback of 548:2: ( (lv_attributes_1_0= ruleAttribute ) )+";
        }
    }
    static final String DFA24_eotS =
        "\5\uffff";
    static final String DFA24_eofS =
        "\5\uffff";
    static final String DFA24_minS =
        "\1\5\1\4\1\21\2\uffff";
    static final String DFA24_maxS =
        "\2\5\1\33\2\uffff";
    static final String DFA24_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA24_specialS =
        "\5\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\1",
            "\1\2\1\1",
            "\1\3\11\uffff\1\4",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "980:1: (this_Macro_0= ruleMacro | this_TypeDefinition_1= ruleTypeDefinition )";
        }
    }
    static final String DFA26_eotS =
        "\74\uffff";
    static final String DFA26_eofS =
        "\1\2\3\uffff\2\3\2\uffff\3\3\4\uffff\1\3\2\uffff\4\3\1\uffff\3\3"+
        "\12\uffff\1\3\1\uffff\1\3\5\uffff\1\3\5\uffff\2\3\10\uffff";
    static final String DFA26_minS =
        "\2\4\2\uffff\22\4\1\31\5\4\1\7\1\5\3\4\1\47\1\5\1\46\3\4\2\7\1\4"+
        "\2\47\2\4\1\5\1\4\2\5\3\4\1\5\1\46\1\4\1\7\1\4\1\47\1\5";
    static final String DFA26_maxS =
        "\2\61\2\uffff\22\61\1\62\5\61\1\7\1\6\3\61\1\57\1\6\1\46\3\61\2"+
        "\7\1\61\2\47\2\61\1\32\1\61\1\6\1\32\3\61\1\6\1\46\1\61\1\7\1\61"+
        "\1\47\1\32";
    static final String DFA26_acceptS =
        "\2\uffff\1\2\1\1\70\uffff";
    static final String DFA26_specialS =
        "\74\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\3\1\1\1\3\1\uffff\2\3\16\uffff\1\3\6\uffff\1\3\1\uffff\1"+
            "\3\1\uffff\1\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2"+
            "\3",
            "\1\5\1\6\1\4\1\uffff\2\3\11\uffff\1\2\4\uffff\1\3\6\uffff\1"+
            "\3\1\uffff\1\3\1\uffff\1\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1"+
            "\3\2\uffff\2\3",
            "",
            "",
            "\1\11\1\7\1\3\1\uffff\2\3\16\uffff\1\10\6\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\3\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\2\uffff\1\2\3\uffff"+
            "\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\2\3",
            "\1\5\1\6\1\4\1\uffff\2\3\11\uffff\1\2\4\uffff\1\3\6\uffff\1"+
            "\3\1\uffff\1\3\3\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2"+
            "\3",
            "\1\12\1\13\1\3\1\uffff\2\3\11\uffff\1\3\4\uffff\1\10\6\uffff"+
            "\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\2\3",
            "\1\3\1\14\1\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\6\uffff\1"+
            "\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2"+
            "\3",
            "\1\3\1\15\1\3\1\uffff\2\3\16\uffff\1\3\6\uffff\1\3\1\uffff"+
            "\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\3\1\15\1\3\1\uffff\2\3\7\uffff\1\3\6\uffff\1\3\2\uffff\1"+
            "\3\3\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1"+
            "\3\2\uffff\2\3",
            "\1\12\1\13\1\3\1\uffff\2\3\11\uffff\1\3\4\uffff\1\10\6\uffff"+
            "\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\2\3",
            "\1\3\1\16\1\3\1\uffff\2\3\7\uffff\1\2\1\uffff\1\3\4\uffff\1"+
            "\3\6\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1"+
            "\3\2\uffff\2\3",
            "\1\17\1\20\1\3\1\uffff\2\3\11\uffff\1\3\4\uffff\1\3\6\uffff"+
            "\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\2\3",
            "\1\3\1\16\1\3\1\uffff\2\3\7\uffff\1\2\1\uffff\1\3\4\uffff\1"+
            "\3\6\uffff\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1\uffff\1"+
            "\3\2\uffff\2\3",
            "\1\24\1\21\1\22\1\uffff\1\23\1\3\7\uffff\1\3\6\uffff\1\27\1"+
            "\2\1\uffff\1\3\3\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2"+
            "\3\1\uffff\1\25\2\uffff\1\3\1\26",
            "\1\17\1\20\1\3\1\uffff\2\3\11\uffff\1\3\4\uffff\1\3\6\uffff"+
            "\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\2\3",
            "\1\31\1\32\1\30\1\uffff\1\23\1\3\11\uffff\1\3\4\uffff\1\3\6"+
            "\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2"+
            "\uffff\2\3",
            "\1\3\1\33\1\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\6\uffff\1"+
            "\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2"+
            "\3",
            "\1\3\1\33\1\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\6\uffff\1"+
            "\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2"+
            "\3",
            "\1\3\1\33\1\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\6\uffff\1"+
            "\3\1\uffff\3\3\1\uffff\1\3\1\2\3\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\2\3",
            "\1\3\1\33\1\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\1\35\5\uffff"+
            "\1\3\1\uffff\3\3\1\uffff\1\3\1\34\3\uffff\2\3\1\uffff\1\3\2"+
            "\uffff\2\3",
            "\1\3\30\uffff\1\2",
            "\1\3\1\33\1\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\6\uffff\1"+
            "\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2"+
            "\3",
            "\1\3\1\36\1\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\6\uffff\1"+
            "\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2"+
            "\3",
            "\1\3\1\33\1\3\1\uffff\2\3\7\uffff\1\37\6\uffff\1\3\2\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\3\3\1\uffff\1\3\1\2\3\uffff\2\3\1\uffff"+
            "\1\3\2\uffff\2\3",
            "\1\31\1\32\1\30\1\uffff\1\23\1\3\11\uffff\1\3\4\uffff\1\3\6"+
            "\uffff\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2"+
            "\uffff\2\3",
            "\1\17\1\40\1\3\1\uffff\2\3\7\uffff\1\2\1\uffff\1\3\4\uffff"+
            "\1\3\6\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff"+
            "\1\3\2\uffff\2\3",
            "\1\41",
            "\1\42\1\43",
            "\1\44\1\45\1\3\1\uffff\2\3\7\uffff\1\2\1\uffff\1\3\4\uffff"+
            "\1\3\6\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff"+
            "\1\3\2\uffff\2\3",
            "\3\3\1\uffff\2\3\16\uffff\1\3\1\2\5\uffff\1\3\1\uffff\1\3\1"+
            "\uffff\1\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2\3",
            "\1\17\1\40\1\3\1\uffff\2\3\7\uffff\1\2\1\uffff\1\3\4\uffff"+
            "\1\3\6\uffff\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1\uffff"+
            "\1\3\2\uffff\2\3",
            "\1\46\7\uffff\1\47",
            "\1\42\1\43",
            "\1\50",
            "\1\24\1\51\1\22\1\uffff\1\23\1\3\7\uffff\1\3\6\uffff\1\27\1"+
            "\2\1\uffff\1\3\3\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2"+
            "\3\1\uffff\1\25\2\uffff\1\3\1\26",
            "\1\44\1\45\1\3\1\uffff\2\3\7\uffff\1\2\1\uffff\1\3\4\uffff"+
            "\1\3\6\uffff\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1\uffff"+
            "\1\3\2\uffff\2\3",
            "\1\3\1\33\1\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\1\35\5\uffff"+
            "\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\2\3",
            "\1\52",
            "\1\53",
            "\1\54\1\55\1\30\1\uffff\1\23\1\3\11\uffff\1\3\4\uffff\1\3\6"+
            "\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2"+
            "\uffff\2\3",
            "\1\46",
            "\1\56",
            "\1\3\1\57\1\3\1\uffff\2\3\7\uffff\1\37\6\uffff\2\3\1\uffff"+
            "\1\3\3\uffff\1\3\1\uffff\3\3\1\uffff\1\3\1\2\3\uffff\2\3\1\uffff"+
            "\1\3\2\uffff\2\3",
            "\1\54\1\55\1\30\1\uffff\1\23\1\3\11\uffff\1\3\4\uffff\1\3\6"+
            "\uffff\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2"+
            "\uffff\2\3",
            "\1\61\21\uffff\1\60\2\uffff\1\62",
            "\1\63\1\64\1\3\1\uffff\2\3\7\uffff\1\2\1\uffff\1\3\4\uffff"+
            "\1\3\6\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff"+
            "\1\3\2\uffff\2\3",
            "\1\65\1\66",
            "\1\61\24\uffff\1\62",
            "\1\3\1\33\1\3\1\uffff\2\3\7\uffff\1\2\6\uffff\1\3\6\uffff\1"+
            "\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1\uffff\1\3\2\uffff\2"+
            "\3",
            "\1\24\1\67\1\22\1\uffff\1\23\1\3\7\uffff\1\3\6\uffff\1\27\1"+
            "\2\1\uffff\1\3\3\uffff\1\3\1\uffff\3\3\1\uffff\2\3\3\uffff\2"+
            "\3\1\uffff\1\25\2\uffff\1\3\1\26",
            "\1\63\1\64\1\3\1\uffff\2\3\7\uffff\1\2\1\uffff\1\3\4\uffff"+
            "\1\3\6\uffff\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1\uffff"+
            "\1\3\2\uffff\2\3",
            "\1\65\1\66",
            "\1\70",
            "\1\54\1\71\1\30\1\uffff\1\23\1\3\7\uffff\1\3\1\uffff\1\3\4"+
            "\uffff\1\3\6\uffff\1\3\1\uffff\3\3\1\uffff\1\3\4\uffff\2\3\1"+
            "\uffff\1\3\2\uffff\2\3",
            "\1\72",
            "\1\54\1\71\1\30\1\uffff\1\23\1\3\7\uffff\1\3\1\uffff\1\3\4"+
            "\uffff\1\3\6\uffff\1\3\1\uffff\2\3\2\uffff\1\3\4\uffff\2\3\1"+
            "\uffff\1\3\2\uffff\2\3",
            "\1\73",
            "\1\61\21\uffff\1\60\2\uffff\1\62"
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1046:1: ( (lv_values_3_0= ruleValue ) )+";
        }
    }
    static final String DFA29_eotS =
        "\4\uffff";
    static final String DFA29_eofS =
        "\4\uffff";
    static final String DFA29_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA29_maxS =
        "\1\5\1\23\2\uffff";
    static final String DFA29_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA29_specialS =
        "\4\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1",
            "\1\2\1\1\15\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1159:2: ( (lv_innerTypes_8_0= ruleTypeDefinition ) )+";
        }
    }
    static final String DFA32_eotS =
        "\4\uffff";
    static final String DFA32_eofS =
        "\1\2\3\uffff";
    static final String DFA32_minS =
        "\1\5\1\4\2\uffff";
    static final String DFA32_maxS =
        "\1\5\1\45\2\uffff";
    static final String DFA32_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA32_specialS =
        "\4\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\1",
            "\1\3\1\1\3\uffff\1\3\24\uffff\1\2\1\3\5\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "()+ loopback of 1233:1: ( (lv_typeNotations_4_0= ruleTypeAssignment ) )+";
        }
    }
    static final String DFA38_eotS =
        "\23\uffff";
    static final String DFA38_eofS =
        "\1\3\22\uffff";
    static final String DFA38_minS =
        "\1\4\2\0\20\uffff";
    static final String DFA38_maxS =
        "\1\61\2\0\20\uffff";
    static final String DFA38_acceptS =
        "\3\uffff\1\2\16\uffff\1\1";
    static final String DFA38_specialS =
        "\1\uffff\1\0\1\1\20\uffff}>";
    static final String[] DFA38_transitionS = {
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

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "1516:2: ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_1 = input.LA(1);

                         
                        int index38_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalSmi()) ) {s = 18;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index38_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_2 = input.LA(1);

                         
                        int index38_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalSmi()) ) {s = 18;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index38_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA45_eotS =
        "\5\uffff";
    static final String DFA45_eofS =
        "\1\2\4\uffff";
    static final String DFA45_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA45_maxS =
        "\2\61\2\uffff\1\61";
    static final String DFA45_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA45_specialS =
        "\5\uffff}>";
    static final String[] DFA45_transitionS = {
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

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "()* loopback of 1739:2: ( (this_NEWLINE_4= RULE_NEWLINE )* otherlv_5= '|' ( (lv_valueTypes_6_0= ruleValueType ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleModule127 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleModule144 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModule156 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleModule168 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleImports_in_ruleModule189 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleObjectReferenceable_in_ruleModule212 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleReferenceable_in_ruleModule239 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleModule253 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_19_in_ruleModule266 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleModule278 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleImports_in_entryRuleImports315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImports325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleImports362 = new BitSet(new long[]{0x0000000000100020L});
    public static final BitSet FOLLOW_20_in_ruleImports375 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_ruleImportClosure_in_ruleImports396 = new BitSet(new long[]{0x0000000000200070L});
    public static final BitSet FOLLOW_21_in_ruleImports409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportClosure_in_entryRuleImportClosure445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportClosure455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportRefs_in_ruleImportClosure501 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleImportClosure513 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_22_in_ruleImportClosure526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleImportClosure543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImportRefs_in_entryRuleImportRefs584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportRefs594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleImportRefs631 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_ruleImportRef_in_ruleImportRefs653 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleImportRefs666 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleImportRefs678 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_ruleImportRef_in_ruleImportRefs700 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleImportRef_in_entryRuleImportRef738 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImportRef748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleImportRef793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleImportRef819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectReferenceable_in_entryRuleObjectReferenceable855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectReferenceable865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleObjectReferenceable902 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectReferenceable920 = new BitSet(new long[]{0x0000000001000030L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleObjectReferenceable937 = new BitSet(new long[]{0x0000000001000030L});
    public static final BitSet FOLLOW_24_in_ruleObjectReferenceable951 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_ruleObject_in_ruleObjectReferenceable978 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleObjectReferenceable991 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_17_in_ruleObjectReferenceable1004 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleObjectReferenceable1016 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleObjectReference_in_ruleObjectReferenceable1037 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleObjectReferenceable1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_in_entryRuleObject1085 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObject1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleObject1140 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleObject1161 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleObjectReference_in_entryRuleObjectReference1198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectReference1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectReference1251 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectReference1294 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleObjectReference1313 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleObjectReference1335 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1377 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleAttribute1424 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleAttribute1445 = new BitSet(new long[]{0x0002200003000170L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_ruleAttribute1466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttributeValue_in_entryRuleAttributeValue1502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttributeValue1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleAttributeValue1550 = new BitSet(new long[]{0x0000000000000170L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleAttributeValue1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_ruleAttributeValue1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleAttributeValue1628 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_ruleAttributeValue1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracedObjectReference_in_ruleAttributeValue1680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_ruleAttributeValue1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SEQUENCE_OF_in_ruleAttributeValue1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleAttributeValue1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier1799 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleIdentifier1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracedObjectReference_in_entryRuleBracedObjectReference1890 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBracedObjectReference1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleBracedObjectReference1937 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleBracedObjectReference1957 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleBracedObjectReference1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceable_in_entryRuleReferenceable2005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceable2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_ruleReferenceable2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleReferenceable2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition2124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDefinition2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTypeDefinition2171 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeDefinition2189 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeDefinition2206 = new BitSet(new long[]{0x00032C2A81000370L});
    public static final BitSet FOLLOW_ruleValue_in_ruleTypeDefinition2227 = new BitSet(new long[]{0x00032C2A81000372L});
    public static final BitSet FOLLOW_ruleMacro_in_entryRuleMacro2264 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacro2274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro2311 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleMacro2329 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMacro2346 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMacro2358 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro2370 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_18_in_ruleMacro2383 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_ruleMacro2404 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueNotation_in_ruleMacro2425 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleMacro2446 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleMacro2459 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_19_in_ruleMacro2472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation2508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotation2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTypeNotation2555 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_28_in_ruleTypeNotation2574 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleTypeNotation2599 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeNotation2611 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_ruleTypeNotation2632 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleValueNotation_in_entryRuleValueNotation2669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNotation2679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValueNotation2716 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_30_in_ruleValueNotation2735 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleValueNotation2760 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleValueNotation2772 = new BitSet(new long[]{0x0000002000000020L});
    public static final BitSet FOLLOW_ruleValueAssignment_in_ruleValueNotation2793 = new BitSet(new long[]{0x0000002000000022L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment2830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAssignment2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTypeAssignment2877 = new BitSet(new long[]{0x0000002080000230L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleTypeAssignment2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeAssignment2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleTypeAssignment2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment2991 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamAssignment3001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PARAMETER_in_ruleParamAssignment3043 = new BitSet(new long[]{0x0000002080000010L});
    public static final BitSet FOLLOW_ruleTypeNotationRight_in_ruleParamAssignment3069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotationRight_in_entryRuleTypeNotationRight3105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotationRight3115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeNotationRight3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleTypeNotationRight3188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt3224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReferenceExt3234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt3280 = new BitSet(new long[]{0x0000000080000012L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt3311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_entryRuleTypeReference3348 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReference3358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeReference3403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracedTypeReference_in_ruleTypeReference3431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBracedTypeReference_in_entryRuleBracedTypeReference3466 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBracedTypeReference3476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleBracedTypeReference3513 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleBracedTypeReference3535 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleBracedTypeReference3546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueAssignment_in_entryRuleValueAssignment3582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueAssignment3592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValueAssignment3629 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleValueAssignment3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue3687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue3697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTag_in_ruleValue3743 = new BitSet(new long[]{0x00032C2A81000370L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValue3756 = new BitSet(new long[]{0x00032C2A81000370L});
    public static final BitSet FOLLOW_33_in_ruleValue3775 = new BitSet(new long[]{0x00032C2A81000370L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue3810 = new BitSet(new long[]{0x0000000400000022L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleValue3823 = new BitSet(new long[]{0x0000000400000020L});
    public static final BitSet FOLLOW_34_in_ruleValue3836 = new BitSet(new long[]{0x00032C2A81000370L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue3857 = new BitSet(new long[]{0x0000000400000022L});
    public static final BitSet FOLLOW_ruleTag_in_entryRuleTag3895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTag3905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleTag3942 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleTag3955 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleTag3972 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleTag3989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType4025 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType4035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleValueType4081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleValueType4104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_ruleValueType4136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_ruleValueType4163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleValueType4190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleValueType4218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue4255 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue4265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleMacroValue4311 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleMacroValue4323 = new BitSet(new long[]{0x00000300C1000010L});
    public static final BitSet FOLLOW_ruleMacroValueType_in_ruleMacroValue4344 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleMacroValue4356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValueType_in_entryRuleMacroValueType4392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValueType4402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleMacroValueType4490 = new BitSet(new long[]{0x00000300C1000010L});
    public static final BitSet FOLLOW_30_in_ruleMacroValueType4575 = new BitSet(new long[]{0x00000300C1000010L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleMacroValueType4650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleMacroValueType4674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleMacroValueType4711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE4761 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE4771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE4818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE4845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SEQUENCE_in_ruleASN1_TYPE4872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE4907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE4917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleASN1_SIMPLE4964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE4992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE5021 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE5041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE5071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING5106 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING5116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleASN1_OCTET_STRING5162 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleASN1_OCTET_STRING5174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER5210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER5220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleASN1_INTEGER5263 = new BitSet(new long[]{0x0000004002000002L});
    public static final BitSet FOLLOW_38_in_ruleASN1_INTEGER5289 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_INTEGER5310 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_INTEGER5322 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_REFINEMENT_in_ruleASN1_INTEGER5345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_REFINEMENT_in_entryRuleASN1_INTEGER_REFINEMENT5382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER_REFINEMENT5392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleASN1_INTEGER_REFINEMENT5429 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5442 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_INTEGER_REFINEMENT5460 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleASN1_INTEGER_REFINEMENT5477 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_INTEGER_REFINEMENT5494 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_INTEGER_REFINEMENT5511 = new BitSet(new long[]{0x0000000004800020L});
    public static final BitSet FOLLOW_23_in_ruleASN1_INTEGER_REFINEMENT5525 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5537 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_INTEGER_REFINEMENT5555 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleASN1_INTEGER_REFINEMENT5572 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_INTEGER_REFINEMENT5589 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_INTEGER_REFINEMENT5606 = new BitSet(new long[]{0x0000000004800020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_INTEGER_REFINEMENT5620 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_26_in_ruleASN1_INTEGER_REFINEMENT5633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE5669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE5679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleASN1_SUBTYPE5716 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleASN1_SUBTYPE5728 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleASN1_SUBTYPE5740 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE5761 = new BitSet(new long[]{0x0000008400000000L});
    public static final BitSet FOLLOW_34_in_ruleASN1_SUBTYPE5774 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE5795 = new BitSet(new long[]{0x0000008400000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_SUBTYPE5809 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_SUBTYPE5821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE5857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE5867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE5919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE5949 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleASN1_RANGE5966 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_ruleASN1_RANGE5983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE6025 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE6035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleASN1_CHOICE6072 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleASN1_CHOICE6084 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6096 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE6118 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_23_in_ruleASN1_CHOICE6131 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6143 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE6165 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE6179 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_26_in_ruleASN1_CHOICE6192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SEQUENCE_in_entryRuleASN1_SEQUENCE6228 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SEQUENCE6238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleASN1_SEQUENCE6275 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleASN1_SEQUENCE6287 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6299 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_SEQUENCE6321 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_23_in_ruleASN1_SEQUENCE6334 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6346 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_SEQUENCE6368 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_SEQUENCE6382 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_26_in_ruleASN1_SEQUENCE6395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SEQUENCE_OF_in_entryRuleASN1_SEQUENCE_OF6431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SEQUENCE_OF6441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleASN1_SEQUENCE_OF6478 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleASN1_SEQUENCE_OF6490 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleASN1_SEQUENCE_OF6511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY6547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY6557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY6599 = new BitSet(new long[]{0x00032C0081000130L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleASN1_CHOICE_ENTRY6616 = new BitSet(new long[]{0x00032C0081000130L});
    public static final BitSet FOLLOW_ruleChoiceType_in_ruleASN1_CHOICE_ENTRY6638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoiceType_in_entryRuleChoiceType6674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoiceType6684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleChoiceType6740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_ruleChoiceType6767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleChoiceType6785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_synpred1_InternalSmi1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_synpred2_InternalSmi3294 = new BitSet(new long[]{0x0000000000000002L});

}
