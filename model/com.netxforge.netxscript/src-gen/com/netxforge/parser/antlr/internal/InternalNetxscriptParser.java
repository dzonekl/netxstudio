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
import com.netxforge.services.NetxscriptGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalNetxscriptParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NUMBER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mod'", "'import'", "'def'", "'('", "','", "')'", "'{'", "'}'", "';'", "'return'", "'if'", "'else'", "'while'", "'var'", "'='", "'&&'", "'||'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'true'", "'false'", "'['", "']'", "'.'", "'this'", "'->'", "'Res'", "'AllRes'", "'Link'", "'count()'", "'sum()'", "'min()'", "'max()'", "'mean()'", "'deviation()'", "'METRIC'", "'CAP'", "'FORECAST'", "'FORECAST_CAP'", "'TRENDED'", "'UTILIZATION'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int RULE_NUMBER=6;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=7;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalNetxscriptParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalNetxscriptParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalNetxscriptParser.tokenNames; }
    public String getGrammarFileName() { return "../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g"; }



     	private NetxscriptGrammarAccess grammarAccess;
     	
        public InternalNetxscriptParser(TokenStream input, NetxscriptGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Mod";	
       	}
       	
       	@Override
       	protected NetxscriptGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMod"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:68:1: entryRuleMod returns [EObject current=null] : iv_ruleMod= ruleMod EOF ;
    public final EObject entryRuleMod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMod = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:69:2: (iv_ruleMod= ruleMod EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:70:2: iv_ruleMod= ruleMod EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModRule()); 
            }
            pushFollow(FOLLOW_ruleMod_in_entryRuleMod75);
            iv_ruleMod=ruleMod();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMod; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMod85); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMod"


    // $ANTLR start "ruleMod"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:77:1: ruleMod returns [EObject current=null] : ( (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( ( (lv_functions_3_0= ruleFunction ) )+ | ( (lv_statements_4_0= ruleStatement ) )+ ) ) ;
    public final EObject ruleMod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_imports_2_0 = null;

        EObject lv_functions_3_0 = null;

        EObject lv_statements_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:80:28: ( ( (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( ( (lv_functions_3_0= ruleFunction ) )+ | ( (lv_statements_4_0= ruleStatement ) )+ ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:81:1: ( (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( ( (lv_functions_3_0= ruleFunction ) )+ | ( (lv_statements_4_0= ruleStatement ) )+ ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:81:1: ( (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( ( (lv_functions_3_0= ruleFunction ) )+ | ( (lv_statements_4_0= ruleStatement ) )+ ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:81:2: (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( ( (lv_functions_3_0= ruleFunction ) )+ | ( (lv_statements_4_0= ruleStatement ) )+ )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:81:2: (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:81:4: otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleMod123); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getModAccess().getModKeyword_0_0());
                          
                    }
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:85:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:86:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:86:1: (lv_name_1_0= RULE_ID )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:87:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMod140); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_1_0, grammarAccess.getModAccess().getNameIDTerminalRuleCall_0_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getModRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"ID");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:103:4: ( (lv_imports_2_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:104:1: (lv_imports_2_0= ruleImport )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:104:1: (lv_imports_2_0= ruleImport )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:105:3: lv_imports_2_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModAccess().getImportsImportParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleImport_in_ruleMod168);
            	    lv_imports_2_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_2_0, 
            	              		"Import");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:121:3: ( ( (lv_functions_3_0= ruleFunction ) )+ | ( (lv_statements_4_0= ruleStatement ) )+ )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID||LA5_0==RULE_NUMBER||LA5_0==15||LA5_0==18||(LA5_0>=21 && LA5_0<=22)||(LA5_0>=24 && LA5_0<=25)||(LA5_0>=35 && LA5_0<=36)||(LA5_0>=40 && LA5_0<=43)||LA5_0==46) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:121:4: ( (lv_functions_3_0= ruleFunction ) )+
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:121:4: ( (lv_functions_3_0= ruleFunction ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==14) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:122:1: (lv_functions_3_0= ruleFunction )
                    	    {
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:122:1: (lv_functions_3_0= ruleFunction )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:123:3: lv_functions_3_0= ruleFunction
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModAccess().getFunctionsFunctionParserRuleCall_2_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleFunction_in_ruleMod191);
                    	    lv_functions_3_0=ruleFunction();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"functions",
                    	              		lv_functions_3_0, 
                    	              		"Function");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

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


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:140:6: ( (lv_statements_4_0= ruleStatement ) )+
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:140:6: ( (lv_statements_4_0= ruleStatement ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID||LA4_0==RULE_NUMBER||LA4_0==15||LA4_0==18||(LA4_0>=21 && LA4_0<=22)||(LA4_0>=24 && LA4_0<=25)||(LA4_0>=35 && LA4_0<=36)||(LA4_0>=40 && LA4_0<=43)||LA4_0==46) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:141:1: (lv_statements_4_0= ruleStatement )
                    	    {
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:141:1: (lv_statements_4_0= ruleStatement )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:142:3: lv_statements_4_0= ruleStatement
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModAccess().getStatementsStatementParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleStatement_in_ruleMod219);
                    	    lv_statements_4_0=ruleStatement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"statements",
                    	              		lv_statements_4_0, 
                    	              		"Statement");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


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
    // $ANTLR end "ruleMod"


    // $ANTLR start "entryRuleImport"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:168:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:169:2: (iv_ruleImport= ruleImport EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:170:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport259);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport269); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:177:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:180:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:181:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:181:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:181:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleImport306); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:185:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:186:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:186:1: (lv_importURI_1_0= RULE_STRING )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:187:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport323); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getImportRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"importURI",
                      		lv_importURI_1_0, 
                      		"STRING");
              	    
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleFunction"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:211:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:212:2: (iv_ruleFunction= ruleFunction EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:213:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction364);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction374); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:220:1: ruleFunction returns [EObject current=null] : (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;

        EObject lv_block_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:223:28: ( (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:224:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:224:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:224:3: otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleFunction411); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getDefKeyword_0());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:228:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:229:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:229:1: (lv_name_1_0= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:230:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction428); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFunctionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleFunction445); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:250:1: ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:250:2: ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )*
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:250:2: ( (lv_args_3_0= ruleArgument ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:251:1: (lv_args_3_0= ruleArgument )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:251:1: (lv_args_3_0= ruleArgument )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:252:3: lv_args_3_0= ruleArgument
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleArgument_in_ruleFunction467);
                    lv_args_3_0=ruleArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                      	        }
                             		add(
                             			current, 
                             			"args",
                              		lv_args_3_0, 
                              		"Argument");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:268:2: (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==16) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:268:4: otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleFunction480); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:272:1: ( (lv_args_5_0= ruleArgument ) )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:273:1: (lv_args_5_0= ruleArgument )
                    	    {
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:273:1: (lv_args_5_0= ruleArgument )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:274:3: lv_args_5_0= ruleArgument
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleArgument_in_ruleFunction501);
                    	    lv_args_5_0=ruleArgument();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFunctionRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"args",
                    	              		lv_args_5_0, 
                    	              		"Argument");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleFunction517); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:294:1: ( (lv_block_7_0= ruleBlock ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:295:1: (lv_block_7_0= ruleBlock )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:295:1: (lv_block_7_0= ruleBlock )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:296:3: lv_block_7_0= ruleBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFunctionAccess().getBlockBlockParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBlock_in_ruleFunction538);
            lv_block_7_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFunctionRule());
              	        }
                     		set(
                     			current, 
                     			"block",
                      		lv_block_7_0, 
                      		"Block");
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
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleArgument"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:320:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:321:2: (iv_ruleArgument= ruleArgument EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:322:2: iv_ruleArgument= ruleArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentRule()); 
            }
            pushFollow(FOLLOW_ruleArgument_in_entryRuleArgument574);
            iv_ruleArgument=ruleArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgument; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgument584); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArgument"


    // $ANTLR start "ruleArgument"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:329:1: ruleArgument returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:332:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:333:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:333:1: ( (lv_name_0_0= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:334:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:334:1: (lv_name_0_0= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:335:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArgument625); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getArgumentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
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
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleBlock"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:363:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:364:2: (iv_ruleBlock= ruleBlock EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:365:2: iv_ruleBlock= ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockRule()); 
            }
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock669);
            iv_ruleBlock=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock679); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:372:1: ruleBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:375:28: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:376:1: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:376:1: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:376:2: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:376:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:377:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBlockAccess().getBlockAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleBlock725); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:386:1: ( (lv_statements_2_0= ruleStatement ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==RULE_NUMBER||LA8_0==15||LA8_0==18||(LA8_0>=21 && LA8_0<=22)||(LA8_0>=24 && LA8_0<=25)||(LA8_0>=35 && LA8_0<=36)||(LA8_0>=40 && LA8_0<=43)||LA8_0==46) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:387:1: (lv_statements_2_0= ruleStatement )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:387:1: (lv_statements_2_0= ruleStatement )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:388:3: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStatement_in_ruleBlock746);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBlockRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"statements",
            	              		lv_statements_2_0, 
            	              		"Statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleBlock759); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3());
                  
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
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:416:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:417:2: (iv_ruleStatement= ruleStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:418:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement795);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement805); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:425:1: ruleStatement returns [EObject current=null] : ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_5=null;
        EObject this_VariableStatement_0 = null;

        EObject this_AssignmentStatement_1 = null;

        EObject this_ReferenceAssignmentStatement_2 = null;

        EObject lv_expression_3_0 = null;

        EObject this_ReturnStatement_4 = null;

        EObject this_IfStatement_6 = null;

        EObject this_WhileStatement_7 = null;

        EObject this_Block_8 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:428:28: ( ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:429:1: ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:429:1: ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_NUMBER:
            case 15:
            case 21:
            case 25:
            case 35:
            case 36:
            case 40:
            case 41:
            case 42:
            case 43:
            case 46:
                {
                alt10=1;
                }
                break;
            case 22:
                {
                alt10=2;
                }
                break;
            case 24:
                {
                alt10=3;
                }
                break;
            case 18:
                {
                alt10=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:429:2: ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:429:2: ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:429:3: (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';'
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:429:3: (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement )
                    int alt9=5;
                    alt9 = dfa9.predict(input);
                    switch (alt9) {
                        case 1 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:430:5: this_VariableStatement_0= ruleVariableStatement
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getStatementAccess().getVariableStatementParserRuleCall_0_0_0()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleVariableStatement_in_ruleStatement854);
                            this_VariableStatement_0=ruleVariableStatement();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                      current = this_VariableStatement_0; 
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:440:5: this_AssignmentStatement_1= ruleAssignmentStatement
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getStatementAccess().getAssignmentStatementParserRuleCall_0_0_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleAssignmentStatement_in_ruleStatement881);
                            this_AssignmentStatement_1=ruleAssignmentStatement();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                      current = this_AssignmentStatement_1; 
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;
                        case 3 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:450:5: this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getStatementAccess().getReferenceAssignmentStatementParserRuleCall_0_0_2()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleReferenceAssignmentStatement_in_ruleStatement908);
                            this_ReferenceAssignmentStatement_2=ruleReferenceAssignmentStatement();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                      current = this_ReferenceAssignmentStatement_2; 
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;
                        case 4 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:459:6: ( (lv_expression_3_0= ruleExpression ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:459:6: ( (lv_expression_3_0= ruleExpression ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:460:1: (lv_expression_3_0= ruleExpression )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:460:1: (lv_expression_3_0= ruleExpression )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:461:3: lv_expression_3_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getStatementAccess().getExpressionExpressionParserRuleCall_0_0_3_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleExpression_in_ruleStatement934);
                            lv_expression_3_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getStatementRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"expression",
                                      		lv_expression_3_0, 
                                      		"Expression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 5 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:479:5: this_ReturnStatement_4= ruleReturnStatement
                            {
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_0_0_4()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleReturnStatement_in_ruleStatement962);
                            this_ReturnStatement_4=ruleReturnStatement();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                      current = this_ReturnStatement_4; 
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleStatement974); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:493:5: this_IfStatement_6= ruleIfStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIfStatement_in_ruleStatement1003);
                    this_IfStatement_6=ruleIfStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IfStatement_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:503:5: this_WhileStatement_7= ruleWhileStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleWhileStatement_in_ruleStatement1030);
                    this_WhileStatement_7=ruleWhileStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_WhileStatement_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:513:5: this_Block_8= ruleBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBlock_in_ruleStatement1057);
                    this_Block_8=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Block_8; 
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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleReturnStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:529:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:530:2: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:531:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReturnStatementRule()); 
            }
            pushFollow(FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement1092);
            iv_ruleReturnStatement=ruleReturnStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReturnStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReturnStatement1102); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReturnStatement"


    // $ANTLR start "ruleReturnStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:538:1: ruleReturnStatement returns [EObject current=null] : ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:541:28: ( ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:542:1: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:542:1: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:542:2: () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:542:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:543:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReturnStatementAccess().getReturnAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleReturnStatement1148); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReturnStatementAccess().getReturnKeyword_1());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:552:1: ( (lv_expression_2_0= ruleExpression ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==RULE_NUMBER||LA11_0==15||(LA11_0>=35 && LA11_0<=36)||(LA11_0>=40 && LA11_0<=43)||LA11_0==46) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:553:1: (lv_expression_2_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:553:1: (lv_expression_2_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:554:3: lv_expression_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleReturnStatement1169);
                    lv_expression_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getReturnStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_2_0, 
                              		"Expression");
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
    // $ANTLR end "ruleReturnStatement"


    // $ANTLR start "entryRuleIfStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:578:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:579:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:580:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfStatementRule()); 
            }
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement1206);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement1216); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:587:1: ruleIfStatement returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_if_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:590:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:591:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:591:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:591:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:591:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:592:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getIfStatementAccess().getIfAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleIfStatement1262); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getIfKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleIfStatement1274); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:605:1: ( (lv_if_3_0= ruleLogical ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:606:1: (lv_if_3_0= ruleLogical )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:606:1: (lv_if_3_0= ruleLogical )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:607:3: lv_if_3_0= ruleLogical
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfStatementAccess().getIfLogicalParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogical_in_ruleIfStatement1295);
            lv_if_3_0=ruleLogical();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
              	        }
                     		set(
                     			current, 
                     			"if",
                      		lv_if_3_0, 
                      		"Logical");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleIfStatement1307); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:627:1: ( (lv_then_5_0= ruleBlock ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:628:1: (lv_then_5_0= ruleBlock )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:628:1: (lv_then_5_0= ruleBlock )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:629:3: lv_then_5_0= ruleBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfStatementAccess().getThenBlockParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement1328);
            lv_then_5_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
              	        }
                     		set(
                     			current, 
                     			"then",
                      		lv_then_5_0, 
                      		"Block");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:645:2: (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:645:4: otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) )
                    {
                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleIfStatement1341); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getElseKeyword_6_0());
                          
                    }
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:649:1: ( (lv_else_7_0= ruleBlock ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:650:1: (lv_else_7_0= ruleBlock )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:650:1: (lv_else_7_0= ruleBlock )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:651:3: lv_else_7_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfStatementAccess().getElseBlockParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement1362);
                    lv_else_7_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"else",
                              		lv_else_7_0, 
                              		"Block");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleWhileStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:675:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:676:2: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:677:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhileStatementRule()); 
            }
            pushFollow(FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement1400);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhileStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileStatement1410); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhileStatement"


    // $ANTLR start "ruleWhileStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:684:1: ruleWhileStatement returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:687:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:688:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:688:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:688:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:688:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:689:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getWhileStatementAccess().getWhileAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleWhileStatement1456); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWhileStatementAccess().getWhileKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleWhileStatement1468); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:702:1: ( (lv_predicate_3_0= ruleLogical ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:703:1: (lv_predicate_3_0= ruleLogical )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:703:1: (lv_predicate_3_0= ruleLogical )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:704:3: lv_predicate_3_0= ruleLogical
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWhileStatementAccess().getPredicateLogicalParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLogical_in_ruleWhileStatement1489);
            lv_predicate_3_0=ruleLogical();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getWhileStatementRule());
              	        }
                     		set(
                     			current, 
                     			"predicate",
                      		lv_predicate_3_0, 
                      		"Logical");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleWhileStatement1501); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_4());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:724:1: ( (lv_body_5_0= ruleBlock ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:725:1: (lv_body_5_0= ruleBlock )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:725:1: (lv_body_5_0= ruleBlock )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:726:3: lv_body_5_0= ruleBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBlock_in_ruleWhileStatement1522);
            lv_body_5_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getWhileStatementRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_5_0, 
                      		"Block");
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
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleVariableStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:750:1: entryRuleVariableStatement returns [EObject current=null] : iv_ruleVariableStatement= ruleVariableStatement EOF ;
    public final EObject entryRuleVariableStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:751:2: (iv_ruleVariableStatement= ruleVariableStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:752:2: iv_ruleVariableStatement= ruleVariableStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableStatementRule()); 
            }
            pushFollow(FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement1558);
            iv_ruleVariableStatement=ruleVariableStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableStatement1568); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableStatement"


    // $ANTLR start "ruleVariableStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:759:1: ruleVariableStatement returns [EObject current=null] : ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:762:28: ( ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:763:1: ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:763:1: ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:763:2: () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:763:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:764:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVariableStatementAccess().getVariableAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleVariableStatement1614); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getVariableStatementAccess().getVarKeyword_1());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:773:1: ( (lv_name_2_0= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:774:1: (lv_name_2_0= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:774:1: (lv_name_2_0= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:775:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableStatement1631); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getVariableStatementAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVariableStatementRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:791:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:791:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleVariableStatement1649); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getVariableStatementAccess().getEqualsSignKeyword_3_0());
                          
                    }
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:795:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:796:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:796:1: (lv_expression_4_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:797:3: lv_expression_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableStatement1670);
                    lv_expression_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVariableStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_4_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleVariableStatement"


    // $ANTLR start "entryRuleAssignmentStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:821:1: entryRuleAssignmentStatement returns [EObject current=null] : iv_ruleAssignmentStatement= ruleAssignmentStatement EOF ;
    public final EObject entryRuleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:822:2: (iv_ruleAssignmentStatement= ruleAssignmentStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:823:2: iv_ruleAssignmentStatement= ruleAssignmentStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentStatementRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentStatement_in_entryRuleAssignmentStatement1708);
            iv_ruleAssignmentStatement=ruleAssignmentStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentStatement1718); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentStatement"


    // $ANTLR start "ruleAssignmentStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:830:1: ruleAssignmentStatement returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:833:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:834:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:834:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:834:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:834:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:835:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAssignmentStatementAccess().getAssignmentAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:840:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:841:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:841:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:842:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAssignmentStatementRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentStatement1772); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleAssignmentStatement1784); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getAssignmentStatementAccess().getEqualsSignKeyword_2());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:857:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:858:1: (lv_expression_3_0= ruleExpression )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:858:1: (lv_expression_3_0= ruleExpression )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:859:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAssignmentStatement1805);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentStatementRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"Expression");
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
    // $ANTLR end "ruleAssignmentStatement"


    // $ANTLR start "entryRuleReferenceAssignmentStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:883:1: entryRuleReferenceAssignmentStatement returns [EObject current=null] : iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF ;
    public final EObject entryRuleReferenceAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAssignmentStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:884:2: (iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:2: iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceAssignmentStatementRule()); 
            }
            pushFollow(FOLLOW_ruleReferenceAssignmentStatement_in_entryRuleReferenceAssignmentStatement1841);
            iv_ruleReferenceAssignmentStatement=ruleReferenceAssignmentStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceAssignmentStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceAssignmentStatement1851); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceAssignmentStatement"


    // $ANTLR start "ruleReferenceAssignmentStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:892:1: ruleReferenceAssignmentStatement returns [EObject current=null] : ( () ( (lv_ref_1_0= ruleContextRef ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleReferenceAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_ref_1_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:895:28: ( ( () ( (lv_ref_1_0= ruleContextRef ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:896:1: ( () ( (lv_ref_1_0= ruleContextRef ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:896:1: ( () ( (lv_ref_1_0= ruleContextRef ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:896:2: () ( (lv_ref_1_0= ruleContextRef ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:896:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:897:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignementAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:902:2: ( (lv_ref_1_0= ruleContextRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:903:1: (lv_ref_1_0= ruleContextRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:903:1: (lv_ref_1_0= ruleContextRef )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:904:3: lv_ref_1_0= ruleContextRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceAssignmentStatementAccess().getRefContextRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleContextRef_in_ruleReferenceAssignmentStatement1906);
            lv_ref_1_0=ruleContextRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReferenceAssignmentStatementRule());
              	        }
                     		set(
                     			current, 
                     			"ref",
                      		lv_ref_1_0, 
                      		"ContextRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleReferenceAssignmentStatement1918); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getReferenceAssignmentStatementAccess().getEqualsSignKeyword_2());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:924:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:925:1: (lv_expression_3_0= ruleExpression )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:925:1: (lv_expression_3_0= ruleExpression )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:926:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleReferenceAssignmentStatement1939);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getReferenceAssignmentStatementRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"Expression");
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
    // $ANTLR end "ruleReferenceAssignmentStatement"


    // $ANTLR start "entryRuleExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:950:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:951:2: (iv_ruleExpression= ruleExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:952:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression1975);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression1985); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:959:1: ruleExpression returns [EObject current=null] : this_Logical_0= ruleLogical ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Logical_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:962:28: (this_Logical_0= ruleLogical )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:964:5: this_Logical_0= ruleLogical
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getLogicalParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleLogical_in_ruleExpression2031);
            this_Logical_0=ruleLogical();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Logical_0; 
                      afterParserOrEnumRuleCall();
                  
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLogical"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:980:1: entryRuleLogical returns [EObject current=null] : iv_ruleLogical= ruleLogical EOF ;
    public final EObject entryRuleLogical() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogical = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:981:2: (iv_ruleLogical= ruleLogical EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:982:2: iv_ruleLogical= ruleLogical EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalRule()); 
            }
            pushFollow(FOLLOW_ruleLogical_in_entryRuleLogical2065);
            iv_ruleLogical=ruleLogical();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogical; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogical2075); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogical"


    // $ANTLR start "ruleLogical"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:989:1: ruleLogical returns [EObject current=null] : (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* ) ;
    public final EObject ruleLogical() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Equality_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:992:28: ( (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:993:1: (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:993:1: (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:994:5: this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalAccess().getEqualityParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleEquality_in_ruleLogical2122);
            this_Equality_0=ruleEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Equality_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1002:1: ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=27 && LA15_0<=28)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1002:2: ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1002:2: ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) )
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==27) ) {
            	        alt14=1;
            	    }
            	    else if ( (LA14_0==28) ) {
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
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1002:3: ( () otherlv_2= '&&' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1002:3: ( () otherlv_2= '&&' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1002:4: () otherlv_2= '&&'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1002:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1003:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleLogical2145); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getLogicalAccess().getAmpersandAmpersandKeyword_1_0_0_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1013:6: ( () otherlv_4= '||' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1013:6: ( () otherlv_4= '||' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1013:7: () otherlv_4= '||'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1013:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1014:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleLogical2174); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_4, grammarAccess.getLogicalAccess().getVerticalLineVerticalLineKeyword_1_0_1_1());
            	                  
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1023:3: ( (lv_right_5_0= ruleEquality ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1024:1: (lv_right_5_0= ruleEquality )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1024:1: (lv_right_5_0= ruleEquality )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1025:3: lv_right_5_0= ruleEquality
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalAccess().getRightEqualityParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEquality_in_ruleLogical2197);
            	    lv_right_5_0=ruleEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLogicalRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_5_0, 
            	              		"Equality");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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
    // $ANTLR end "ruleLogical"


    // $ANTLR start "entryRuleEquality"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1049:1: entryRuleEquality returns [EObject current=null] : iv_ruleEquality= ruleEquality EOF ;
    public final EObject entryRuleEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquality = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1050:2: (iv_ruleEquality= ruleEquality EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1051:2: iv_ruleEquality= ruleEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityRule()); 
            }
            pushFollow(FOLLOW_ruleEquality_in_entryRuleEquality2235);
            iv_ruleEquality=ruleEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEquality; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquality2245); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1058:1: ruleEquality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEquality() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1061:28: ( (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1062:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1062:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1063:5: this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleComparison_in_ruleEquality2292);
            this_Comparison_0=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Comparison_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:1: ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=29 && LA17_0<=30)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:2: ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:2: ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) )
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( (LA16_0==29) ) {
            	        alt16=1;
            	    }
            	    else if ( (LA16_0==30) ) {
            	        alt16=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:3: ( () otherlv_2= '==' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:3: ( () otherlv_2= '==' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:4: () otherlv_2= '=='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1072:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleEquality2315); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1082:6: ( () otherlv_4= '!=' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1082:6: ( () otherlv_4= '!=' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1082:7: () otherlv_4= '!='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1082:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1083:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleEquality2344); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_4, grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1());
            	                  
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1092:3: ( (lv_right_5_0= ruleComparison ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1093:1: (lv_right_5_0= ruleComparison )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1093:1: (lv_right_5_0= ruleComparison )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1094:3: lv_right_5_0= ruleComparison
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleComparison_in_ruleEquality2367);
            	    lv_right_5_0=ruleComparison();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEqualityRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_5_0, 
            	              		"Comparison");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleComparison"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1118:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1119:2: (iv_ruleComparison= ruleComparison EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1120:2: iv_ruleComparison= ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison2405);
            iv_ruleComparison=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparison; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison2415); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1127:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_Addition_0 = null;

        EObject lv_right_9_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1130:28: ( (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1131:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1131:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1132:5: this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAddition_in_ruleComparison2462);
            this_Addition_0=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Addition_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:1: ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=31 && LA19_0<=34)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:2: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:2: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) )
            	    int alt18=4;
            	    switch ( input.LA(1) ) {
            	    case 31:
            	        {
            	        alt18=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt18=2;
            	        }
            	        break;
            	    case 33:
            	        {
            	        alt18=3;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt18=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt18) {
            	        case 1 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:3: ( () otherlv_2= '<' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:3: ( () otherlv_2= '<' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:4: () otherlv_2= '<'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1141:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleComparison2485); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_0_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1151:6: ( () otherlv_4= '<=' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1151:6: ( () otherlv_4= '<=' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1151:7: () otherlv_4= '<='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1151:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1152:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleComparison2514); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_4, grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1162:6: ( () otherlv_6= '>' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1162:6: ( () otherlv_6= '>' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1162:7: () otherlv_6= '>'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1162:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1163:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleComparison2543); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_6, grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1173:6: ( () otherlv_8= '>=' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1173:6: ( () otherlv_8= '>=' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1173:7: () otherlv_8= '>='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1173:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1174:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleComparison2572); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_8, grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_3_1());
            	                  
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1183:3: ( (lv_right_9_0= ruleAddition ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1184:1: (lv_right_9_0= ruleAddition )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1184:1: (lv_right_9_0= ruleAddition )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1185:3: lv_right_9_0= ruleAddition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAddition_in_ruleComparison2595);
            	    lv_right_9_0=ruleAddition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getComparisonRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_9_0, 
            	              		"Addition");
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
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleAddition"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1209:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1210:2: (iv_ruleAddition= ruleAddition EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1211:2: iv_ruleAddition= ruleAddition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionRule()); 
            }
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition2633);
            iv_ruleAddition=ruleAddition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAddition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition2643); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1218:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1221:28: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1222:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1222:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1223:5: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition2690);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Multiplication_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:1: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=35 && LA21_0<=36)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==35) ) {
            	        alt20=1;
            	    }
            	    else if ( (LA20_0==36) ) {
            	        alt20=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:3: ( () otherlv_2= '+' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:3: ( () otherlv_2= '+' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:4: () otherlv_2= '+'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1232:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleAddition2713); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1242:6: ( () otherlv_4= '-' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1242:6: ( () otherlv_4= '-' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1242:7: () otherlv_4= '-'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1242:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1243:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_4=(Token)match(input,36,FOLLOW_36_in_ruleAddition2742); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	                  
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1252:3: ( (lv_right_5_0= ruleMultiplication ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1253:1: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1253:1: (lv_right_5_0= ruleMultiplication )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1254:3: lv_right_5_0= ruleMultiplication
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition2765);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_5_0, 
            	              		"Multiplication");
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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1278:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1279:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1280:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicationRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication2803);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplication; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication2813); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1287:1: ruleMultiplication returns [EObject current=null] : (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_Unary_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1290:28: ( (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1291:1: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1291:1: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1292:5: this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleUnary_in_ruleMultiplication2860);
            this_Unary_0=ruleUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Unary_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:1: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=37 && LA23_0<=39)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) )
            	    int alt22=3;
            	    switch ( input.LA(1) ) {
            	    case 37:
            	        {
            	        alt22=1;
            	        }
            	        break;
            	    case 38:
            	        {
            	        alt22=2;
            	        }
            	        break;
            	    case 39:
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
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:3: ( () otherlv_2= '*' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:3: ( () otherlv_2= '*' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:4: () otherlv_2= '*'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1301:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_2=(Token)match(input,37,FOLLOW_37_in_ruleMultiplication2883); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1311:6: ( () otherlv_4= '/' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1311:6: ( () otherlv_4= '/' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1311:7: () otherlv_4= '/'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1311:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1312:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_4=(Token)match(input,38,FOLLOW_38_in_ruleMultiplication2912); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	                  
            	            }

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1322:6: ( () otherlv_6= '%' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1322:6: ( () otherlv_6= '%' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1322:7: () otherlv_6= '%'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1322:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1323:5: 
            	            {
            	            if ( state.backtracking==0 ) {

            	                      current = forceCreateModelElementAndSet(
            	                          grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0(),
            	                          current);
            	                  
            	            }

            	            }

            	            otherlv_6=(Token)match(input,39,FOLLOW_39_in_ruleMultiplication2941); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_6, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1());
            	                  
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1332:3: ( (lv_right_7_0= ruleUnary ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1333:1: (lv_right_7_0= ruleUnary )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1333:1: (lv_right_7_0= ruleUnary )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1334:3: lv_right_7_0= ruleUnary
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnary_in_ruleMultiplication2964);
            	    lv_right_7_0=ruleUnary();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicationRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"right",
            	              		lv_right_7_0, 
            	              		"Unary");
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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleUnary"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1358:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1359:2: (iv_ruleUnary= ruleUnary EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1360:2: iv_ruleUnary= ruleUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleUnary_in_entryRuleUnary3002);
            iv_ruleUnary=ruleUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnary3012); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnary"


    // $ANTLR start "ruleUnary"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1367:1: ruleUnary returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_PrimaryExpression_0 = null;

        AntlrDatatypeRuleToken lv_op_4_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1370:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1371:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1371:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID||LA25_0==RULE_NUMBER||LA25_0==15||(LA25_0>=41 && LA25_0<=43)||LA25_0==46) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=35 && LA25_0<=36)||LA25_0==40) ) {
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1372:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryAccess().getPrimaryExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnary3059);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1381:6: ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1381:6: ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1381:7: ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1381:7: ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==40) ) {
                        alt24=1;
                    }
                    else if ( ((LA24_0>=35 && LA24_0<=36)) ) {
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
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1381:8: ( () ( (lv_op_2_0= '!' ) ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1381:8: ( () ( (lv_op_2_0= '!' ) ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1381:9: () ( (lv_op_2_0= '!' ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1381:9: ()
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1382:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElement(
                                          grammarAccess.getUnaryAccess().getNegationAction_1_0_0_0(),
                                          current);
                                  
                            }

                            }

                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1387:2: ( (lv_op_2_0= '!' ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1388:1: (lv_op_2_0= '!' )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1388:1: (lv_op_2_0= '!' )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1389:3: lv_op_2_0= '!'
                            {
                            lv_op_2_0=(Token)match(input,40,FOLLOW_40_in_ruleUnary3094); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_op_2_0, grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_0_0_1_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getUnaryRule());
                              	        }
                                     		setWithLastConsumed(current, "op", lv_op_2_0, "!");
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1403:6: ( () ( (lv_op_4_0= ruleUnaryOperator ) ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1403:6: ( () ( (lv_op_4_0= ruleUnaryOperator ) ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1403:7: () ( (lv_op_4_0= ruleUnaryOperator ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1403:7: ()
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1404:5: 
                            {
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElement(
                                          grammarAccess.getUnaryAccess().getUnaryPlusMinusAction_1_0_1_0(),
                                          current);
                                  
                            }

                            }

                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1409:2: ( (lv_op_4_0= ruleUnaryOperator ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1410:1: (lv_op_4_0= ruleUnaryOperator )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1410:1: (lv_op_4_0= ruleUnaryOperator )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1411:3: lv_op_4_0= ruleUnaryOperator
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getUnaryAccess().getOpUnaryOperatorParserRuleCall_1_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnary3145);
                            lv_op_4_0=ruleUnaryOperator();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getUnaryRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"op",
                                      		lv_op_4_0, 
                                      		"UnaryOperator");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;

                    }

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1427:4: ( (lv_right_5_0= ruleUnary ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1428:1: (lv_right_5_0= ruleUnary )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1428:1: (lv_right_5_0= ruleUnary )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1429:3: lv_right_5_0= ruleUnary
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUnaryAccess().getRightUnaryParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUnary_in_ruleUnary3168);
                    lv_right_5_0=ruleUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUnaryRule());
                      	        }
                             		set(
                             			current, 
                             			"right",
                              		lv_right_5_0, 
                              		"Unary");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "ruleUnary"


    // $ANTLR start "entryRuleUnaryOperator"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1453:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1454:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1455:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator3206);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator3217); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1462:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1465:28: ( (kw= '-' | kw= '+' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1466:1: (kw= '-' | kw= '+' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1466:1: (kw= '-' | kw= '+' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==36) ) {
                alt26=1;
            }
            else if ( (LA26_0==35) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1467:2: kw= '-'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleUnaryOperator3255); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1474:2: kw= '+'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleUnaryOperator3274); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getPlusSignKeyword_1()); 
                          
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
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1487:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1488:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1489:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3314);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression3324); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1496:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NativeExpression_2= ruleNativeExpression | this_Reference_3= ruleReference | this_FunctionCall_4= ruleFunctionCall | this_IndexedCall_5= ruleIndexedCall | this_ParenthesizedExpression_6= ruleParenthesizedExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_Range_1 = null;

        EObject this_NativeExpression_2 = null;

        EObject this_Reference_3 = null;

        EObject this_FunctionCall_4 = null;

        EObject this_IndexedCall_5 = null;

        EObject this_ParenthesizedExpression_6 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1499:28: ( (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NativeExpression_2= ruleNativeExpression | this_Reference_3= ruleReference | this_FunctionCall_4= ruleFunctionCall | this_IndexedCall_5= ruleIndexedCall | this_ParenthesizedExpression_6= ruleParenthesizedExpression ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1500:1: (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NativeExpression_2= ruleNativeExpression | this_Reference_3= ruleReference | this_FunctionCall_4= ruleFunctionCall | this_IndexedCall_5= ruleIndexedCall | this_ParenthesizedExpression_6= ruleParenthesizedExpression )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1500:1: (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NativeExpression_2= ruleNativeExpression | this_Reference_3= ruleReference | this_FunctionCall_4= ruleFunctionCall | this_IndexedCall_5= ruleIndexedCall | this_ParenthesizedExpression_6= ruleParenthesizedExpression )
            int alt27=7;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1501:5: this_Literal_0= ruleLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression3371);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Literal_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1511:5: this_Range_1= ruleRange
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRangeParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRange_in_rulePrimaryExpression3398);
                    this_Range_1=ruleRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Range_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1521:5: this_NativeExpression_2= ruleNativeExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNativeExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNativeExpression_in_rulePrimaryExpression3425);
                    this_NativeExpression_2=ruleNativeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NativeExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1531:5: this_Reference_3= ruleReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getReferenceParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleReference_in_rulePrimaryExpression3452);
                    this_Reference_3=ruleReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Reference_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1541:5: this_FunctionCall_4= ruleFunctionCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFunctionCall_in_rulePrimaryExpression3479);
                    this_FunctionCall_4=ruleFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FunctionCall_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1551:5: this_IndexedCall_5= ruleIndexedCall
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIndexedCallParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIndexedCall_in_rulePrimaryExpression3506);
                    this_IndexedCall_5=ruleIndexedCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IndexedCall_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1561:5: this_ParenthesizedExpression_6= ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3533);
                    this_ParenthesizedExpression_6=ruleParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ParenthesizedExpression_6; 
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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleLiteral"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1577:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1578:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1579:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3568);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3578); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1586:1: ruleLiteral returns [EObject current=null] : (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_condition_2_0=null;
        Token otherlv_3=null;
        EObject this_NumberLiteral_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1589:28: ( (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1590:1: (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1590:1: (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_NUMBER) ) {
                alt29=1;
            }
            else if ( ((LA29_0>=41 && LA29_0<=42)) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1591:5: this_NumberLiteral_0= ruleNumberLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral3625);
                    this_NumberLiteral_0=ruleNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NumberLiteral_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1600:6: ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1600:6: ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1600:7: () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1600:7: ()
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1601:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLiteralAccess().getBooleanLiteralAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1606:2: ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==41) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==42) ) {
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
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1606:3: ( (lv_condition_2_0= 'true' ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1606:3: ( (lv_condition_2_0= 'true' ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1607:1: (lv_condition_2_0= 'true' )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1607:1: (lv_condition_2_0= 'true' )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1608:3: lv_condition_2_0= 'true'
                            {
                            lv_condition_2_0=(Token)match(input,41,FOLLOW_41_in_ruleLiteral3659); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_condition_2_0, grammarAccess.getLiteralAccess().getConditionTrueKeyword_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getLiteralRule());
                              	        }
                                     		setWithLastConsumed(current, "condition", true, "true");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1622:7: otherlv_3= 'false'
                            {
                            otherlv_3=(Token)match(input,42,FOLLOW_42_in_ruleLiteral3690); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getLiteralAccess().getFalseKeyword_1_1_1());
                                  
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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleNumberLiteral"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1634:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1635:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1636:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral3728);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral3738); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1643:1: ruleNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1646:28: ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1647:1: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1647:1: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1647:2: () ( (lv_value_1_0= RULE_NUMBER ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1647:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1648:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNumberLiteralAccess().getNumberLiteralAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1653:2: ( (lv_value_1_0= RULE_NUMBER ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1654:1: (lv_value_1_0= RULE_NUMBER )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1654:1: (lv_value_1_0= RULE_NUMBER )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1655:3: lv_value_1_0= RULE_NUMBER
            {
            lv_value_1_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumberLiteral3789); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_1_0, grammarAccess.getNumberLiteralAccess().getValueNUMBERTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNumberLiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_1_0, 
                      		"NUMBER");
              	    
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
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1679:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1680:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1681:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression3830);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression3840); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1688:1: ruleParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1691:28: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1692:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1692:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1692:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleParenthesizedExpression3877); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression3899);
            this_Expression_1=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Expression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleParenthesizedExpression3910); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                  
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
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleFunctionCall"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1717:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1718:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1719:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionCallRule()); 
            }
            pushFollow(FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall3946);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionCall3956); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1726:1: ruleFunctionCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_args_3_0 = null;

        EObject lv_args_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1729:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1730:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1730:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1730:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1730:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1731:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getFunctionCallAccess().getFunctionCallAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1736:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1737:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1737:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1738:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFunctionCallRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionCall4010); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionCrossReference_1_0()); 
              	
            }

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleFunctionCall4022); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1753:1: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID||LA31_0==RULE_NUMBER||LA31_0==15||(LA31_0>=35 && LA31_0<=36)||(LA31_0>=40 && LA31_0<=43)||LA31_0==46) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1753:2: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1753:2: ( (lv_args_3_0= ruleExpression ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1754:1: (lv_args_3_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1754:1: (lv_args_3_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1755:3: lv_args_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionCall4044);
                    lv_args_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                      	        }
                             		add(
                             			current, 
                             			"args",
                              		lv_args_3_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1771:2: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==16) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1771:4: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleFunctionCall4057); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1775:1: ( (lv_args_5_0= ruleExpression ) )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1776:1: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1776:1: (lv_args_5_0= ruleExpression )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1777:3: lv_args_5_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionCall4078);
                    	    lv_args_5_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"args",
                    	              		lv_args_5_0, 
                    	              		"Expression");
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


                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleFunctionCall4094); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4());
                  
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
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleIndexedCall"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1805:1: entryRuleIndexedCall returns [EObject current=null] : iv_ruleIndexedCall= ruleIndexedCall EOF ;
    public final EObject entryRuleIndexedCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexedCall = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1806:2: (iv_ruleIndexedCall= ruleIndexedCall EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1807:2: iv_ruleIndexedCall= ruleIndexedCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndexedCallRule()); 
            }
            pushFollow(FOLLOW_ruleIndexedCall_in_entryRuleIndexedCall4130);
            iv_ruleIndexedCall=ruleIndexedCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndexedCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndexedCall4140); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndexedCall"


    // $ANTLR start "ruleIndexedCall"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1814:1: ruleIndexedCall returns [EObject current=null] : (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? ) ;
    public final EObject ruleIndexedCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_VarOrArgumentCall_0 = null;

        EObject lv_index_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1817:28: ( (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1818:1: (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1818:1: (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1819:5: this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIndexedCallAccess().getVarOrArgumentCallParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleVarOrArgumentCall_in_ruleIndexedCall4187);
            this_VarOrArgumentCall_0=ruleVarOrArgumentCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_VarOrArgumentCall_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1827:1: (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==43) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1827:3: otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleIndexedCall4199); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getIndexedCallAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1831:1: ( (lv_index_2_0= ruleExpression ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1832:1: (lv_index_2_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1832:1: (lv_index_2_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1833:3: lv_index_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIndexedCallAccess().getIndexExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleIndexedCall4220);
                    lv_index_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIndexedCallRule());
                      	        }
                             		set(
                             			current, 
                             			"index",
                              		lv_index_2_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleIndexedCall4232); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getIndexedCallAccess().getRightSquareBracketKeyword_1_2());
                          
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
    // $ANTLR end "ruleIndexedCall"


    // $ANTLR start "entryRuleVarOrArgumentCall"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1861:1: entryRuleVarOrArgumentCall returns [EObject current=null] : iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF ;
    public final EObject entryRuleVarOrArgumentCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarOrArgumentCall = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1862:2: (iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1863:2: iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarOrArgumentCallRule()); 
            }
            pushFollow(FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall4270);
            iv_ruleVarOrArgumentCall=ruleVarOrArgumentCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarOrArgumentCall; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarOrArgumentCall4280); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarOrArgumentCall"


    // $ANTLR start "ruleVarOrArgumentCall"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1870:1: ruleVarOrArgumentCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleVarOrArgumentCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1873:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1874:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1874:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1874:2: () ( (otherlv_1= RULE_ID ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1874:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1875:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVarOrArgumentCallAccess().getVarOrArgumentCallAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1880:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1881:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1881:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1882:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getVarOrArgumentCallRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarOrArgumentCall4334); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getVarOrArgumentCallAccess().getCallAbstractVarOrArgumentCrossReference_1_0()); 
              	
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
    // $ANTLR end "ruleVarOrArgumentCall"


    // $ANTLR start "entryRuleNativeExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1901:1: entryRuleNativeExpression returns [EObject current=null] : iv_ruleNativeExpression= ruleNativeExpression EOF ;
    public final EObject entryRuleNativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNativeExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1902:2: (iv_ruleNativeExpression= ruleNativeExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1903:2: iv_ruleNativeExpression= ruleNativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNativeExpression_in_entryRuleNativeExpression4370);
            iv_ruleNativeExpression=ruleNativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNativeExpression4380); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNativeExpression"


    // $ANTLR start "ruleNativeExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1910:1: ruleNativeExpression returns [EObject current=null] : ( () ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) ) otherlv_3= '.' ( (lv_nativeFunction_4_0= ruleNativeFunction ) ) ) ;
    public final EObject ruleNativeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_range_1_0 = null;

        EObject lv_ref_2_0 = null;

        Enumerator lv_nativeFunction_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1913:28: ( ( () ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) ) otherlv_3= '.' ( (lv_nativeFunction_4_0= ruleNativeFunction ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1914:1: ( () ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) ) otherlv_3= '.' ( (lv_nativeFunction_4_0= ruleNativeFunction ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1914:1: ( () ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) ) otherlv_3= '.' ( (lv_nativeFunction_4_0= ruleNativeFunction ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1914:2: () ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) ) otherlv_3= '.' ( (lv_nativeFunction_4_0= ruleNativeFunction ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1914:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1915:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNativeExpressionAccess().getNativeExpressionAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1920:2: ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==43) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_ID||LA33_0==46) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1920:3: ( (lv_range_1_0= ruleRangeLiteral ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1920:3: ( (lv_range_1_0= ruleRangeLiteral ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1921:1: (lv_range_1_0= ruleRangeLiteral )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1921:1: (lv_range_1_0= ruleRangeLiteral )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1922:3: lv_range_1_0= ruleRangeLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNativeExpressionAccess().getRangeRangeLiteralParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRangeLiteral_in_ruleNativeExpression4436);
                    lv_range_1_0=ruleRangeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNativeExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"range",
                              		lv_range_1_0, 
                              		"RangeLiteral");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1939:6: ( (lv_ref_2_0= ruleReference ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1939:6: ( (lv_ref_2_0= ruleReference ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1940:1: (lv_ref_2_0= ruleReference )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1940:1: (lv_ref_2_0= ruleReference )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1941:3: lv_ref_2_0= ruleReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNativeExpressionAccess().getRefReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleReference_in_ruleNativeExpression4463);
                    lv_ref_2_0=ruleReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNativeExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"ref",
                              		lv_ref_2_0, 
                              		"Reference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,45,FOLLOW_45_in_ruleNativeExpression4476); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getNativeExpressionAccess().getFullStopKeyword_2());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1961:1: ( (lv_nativeFunction_4_0= ruleNativeFunction ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1962:1: (lv_nativeFunction_4_0= ruleNativeFunction )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1962:1: (lv_nativeFunction_4_0= ruleNativeFunction )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1963:3: lv_nativeFunction_4_0= ruleNativeFunction
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNativeExpressionAccess().getNativeFunctionNativeFunctionEnumRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNativeFunction_in_ruleNativeExpression4497);
            lv_nativeFunction_4_0=ruleNativeFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNativeExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"nativeFunction",
                      		lv_nativeFunction_4_0, 
                      		"NativeFunction");
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
    // $ANTLR end "ruleNativeExpression"


    // $ANTLR start "entryRuleRange"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1987:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1988:2: (iv_ruleRange= ruleRange EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1989:2: iv_ruleRange= ruleRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRule()); 
            }
            pushFollow(FOLLOW_ruleRange_in_entryRuleRange4533);
            iv_ruleRange=ruleRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRange; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRange4543); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1996:1: ruleRange returns [EObject current=null] : this_RangeLiteral_0= ruleRangeLiteral ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        EObject this_RangeLiteral_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1999:28: (this_RangeLiteral_0= ruleRangeLiteral )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2001:5: this_RangeLiteral_0= ruleRangeLiteral
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRangeAccess().getRangeLiteralParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleRangeLiteral_in_ruleRange4589);
            this_RangeLiteral_0=ruleRangeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RangeLiteral_0; 
                      afterParserOrEnumRuleCall();
                  
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
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleRangeLiteral"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2017:1: entryRuleRangeLiteral returns [EObject current=null] : iv_ruleRangeLiteral= ruleRangeLiteral EOF ;
    public final EObject entryRuleRangeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeLiteral = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2018:2: (iv_ruleRangeLiteral= ruleRangeLiteral EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2019:2: iv_ruleRangeLiteral= ruleRangeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeLiteralRule()); 
            }
            pushFollow(FOLLOW_ruleRangeLiteral_in_entryRuleRangeLiteral4623);
            iv_ruleRangeLiteral=ruleRangeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeLiteral; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeLiteral4633); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeLiteral"


    // $ANTLR start "ruleRangeLiteral"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2026:1: ruleRangeLiteral returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleRangeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_values_2_0=null;
        Token otherlv_3=null;
        Token lv_values_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2029:28: ( ( () otherlv_1= '[' ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* otherlv_5= ']' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2030:1: ( () otherlv_1= '[' ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* otherlv_5= ']' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2030:1: ( () otherlv_1= '[' ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* otherlv_5= ']' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2030:2: () otherlv_1= '[' ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* otherlv_5= ']'
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2030:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2031:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRangeLiteralAccess().getRangeLiteralAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleRangeLiteral4679); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRangeLiteralAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2040:1: ( (lv_values_2_0= RULE_NUMBER ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2041:1: (lv_values_2_0= RULE_NUMBER )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2041:1: (lv_values_2_0= RULE_NUMBER )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2042:3: lv_values_2_0= RULE_NUMBER
            {
            lv_values_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4696); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_values_2_0, grammarAccess.getRangeLiteralAccess().getValuesNUMBERTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRangeLiteralRule());
              	        }
                     		addWithLastConsumed(
                     			current, 
                     			"values",
                      		lv_values_2_0, 
                      		"NUMBER");
              	    
            }

            }


            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2058:2: (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==16) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2058:4: otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) )
            	    {
            	    otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleRangeLiteral4714); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getRangeLiteralAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2062:1: ( (lv_values_4_0= RULE_NUMBER ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2063:1: (lv_values_4_0= RULE_NUMBER )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2063:1: (lv_values_4_0= RULE_NUMBER )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2064:3: lv_values_4_0= RULE_NUMBER
            	    {
            	    lv_values_4_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4731); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_values_4_0, grammarAccess.getRangeLiteralAccess().getValuesNUMBERTerminalRuleCall_3_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getRangeLiteralRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"values",
            	              		lv_values_4_0, 
            	              		"NUMBER");
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_5=(Token)match(input,44,FOLLOW_44_in_ruleRangeLiteral4750); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getRangeLiteralAccess().getRightSquareBracketKeyword_4());
                  
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
    // $ANTLR end "ruleRangeLiteral"


    // $ANTLR start "entryRuleReference"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2092:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2093:2: (iv_ruleReference= ruleReference EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2094:2: iv_ruleReference= ruleReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference4786);
            iv_ruleReference=ruleReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference4796); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2101:1: ruleReference returns [EObject current=null] : (this_ContextRef_0= ruleContextRef | this_AbsoluteRef_1= ruleAbsoluteRef ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        EObject this_ContextRef_0 = null;

        EObject this_AbsoluteRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2104:28: ( (this_ContextRef_0= ruleContextRef | this_AbsoluteRef_1= ruleAbsoluteRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2105:1: (this_ContextRef_0= ruleContextRef | this_AbsoluteRef_1= ruleAbsoluteRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2105:1: (this_ContextRef_0= ruleContextRef | this_AbsoluteRef_1= ruleAbsoluteRef )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==46) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_ID) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2106:5: this_ContextRef_0= ruleContextRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReferenceAccess().getContextRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleContextRef_in_ruleReference4843);
                    this_ContextRef_0=ruleContextRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ContextRef_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2116:5: this_AbsoluteRef_1= ruleAbsoluteRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReferenceAccess().getAbsoluteRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAbsoluteRef_in_ruleReference4870);
                    this_AbsoluteRef_1=ruleAbsoluteRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AbsoluteRef_1; 
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
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleAbsoluteRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2132:1: entryRuleAbsoluteRef returns [EObject current=null] : iv_ruleAbsoluteRef= ruleAbsoluteRef EOF ;
    public final EObject entryRuleAbsoluteRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbsoluteRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2133:2: (iv_ruleAbsoluteRef= ruleAbsoluteRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2134:2: iv_ruleAbsoluteRef= ruleAbsoluteRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbsoluteRefRule()); 
            }
            pushFollow(FOLLOW_ruleAbsoluteRef_in_entryRuleAbsoluteRef4905);
            iv_ruleAbsoluteRef=ruleAbsoluteRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbsoluteRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbsoluteRef4915); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbsoluteRef"


    // $ANTLR start "ruleAbsoluteRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2141:1: ruleAbsoluteRef returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_primaryRef_2_0= rulePrimaryRef ) ) ) ;
    public final EObject ruleAbsoluteRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_primaryRef_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2144:28: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_primaryRef_2_0= rulePrimaryRef ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2145:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_primaryRef_2_0= rulePrimaryRef ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2145:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_primaryRef_2_0= rulePrimaryRef ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2145:2: () ( (otherlv_1= RULE_ID ) ) ( (lv_primaryRef_2_0= rulePrimaryRef ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2145:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2146:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getAbsoluteRefAccess().getAbsoluteRefAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2151:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2152:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2152:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2153:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getAbsoluteRefRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAbsoluteRef4969); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getAbsoluteRefAccess().getNodetypeRefNodeTypeCrossReference_1_0()); 
              	
            }

            }


            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2164:2: ( (lv_primaryRef_2_0= rulePrimaryRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2165:1: (lv_primaryRef_2_0= rulePrimaryRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2165:1: (lv_primaryRef_2_0= rulePrimaryRef )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2166:3: lv_primaryRef_2_0= rulePrimaryRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAbsoluteRefAccess().getPrimaryRefPrimaryRefParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryRef_in_ruleAbsoluteRef4990);
            lv_primaryRef_2_0=rulePrimaryRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAbsoluteRefRule());
              	        }
                     		set(
                     			current, 
                     			"primaryRef",
                      		lv_primaryRef_2_0, 
                      		"PrimaryRef");
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
    // $ANTLR end "ruleAbsoluteRef"


    // $ANTLR start "entryRuleContextRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2190:1: entryRuleContextRef returns [EObject current=null] : iv_ruleContextRef= ruleContextRef EOF ;
    public final EObject entryRuleContextRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2191:2: (iv_ruleContextRef= ruleContextRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2192:2: iv_ruleContextRef= ruleContextRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContextRefRule()); 
            }
            pushFollow(FOLLOW_ruleContextRef_in_entryRuleContextRef5026);
            iv_ruleContextRef=ruleContextRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContextRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextRef5036); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContextRef"


    // $ANTLR start "ruleContextRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2199:1: ruleContextRef returns [EObject current=null] : ( () ( ( ( 'this' )=>otherlv_1= 'this' ) ( (lv_primaryRef_2_0= rulePrimaryRef ) ) ) ) ;
    public final EObject ruleContextRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_primaryRef_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2202:28: ( ( () ( ( ( 'this' )=>otherlv_1= 'this' ) ( (lv_primaryRef_2_0= rulePrimaryRef ) ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2203:1: ( () ( ( ( 'this' )=>otherlv_1= 'this' ) ( (lv_primaryRef_2_0= rulePrimaryRef ) ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2203:1: ( () ( ( ( 'this' )=>otherlv_1= 'this' ) ( (lv_primaryRef_2_0= rulePrimaryRef ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2203:2: () ( ( ( 'this' )=>otherlv_1= 'this' ) ( (lv_primaryRef_2_0= rulePrimaryRef ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2203:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2204:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getContextRefAccess().getContextRefAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2209:2: ( ( ( 'this' )=>otherlv_1= 'this' ) ( (lv_primaryRef_2_0= rulePrimaryRef ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2209:3: ( ( 'this' )=>otherlv_1= 'this' ) ( (lv_primaryRef_2_0= rulePrimaryRef ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2209:3: ( ( 'this' )=>otherlv_1= 'this' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2209:4: ( 'this' )=>otherlv_1= 'this'
            {
            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleContextRef5091); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getContextRefAccess().getThisKeyword_1_0());
                  
            }

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2214:2: ( (lv_primaryRef_2_0= rulePrimaryRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2215:1: (lv_primaryRef_2_0= rulePrimaryRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2215:1: (lv_primaryRef_2_0= rulePrimaryRef )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2216:3: lv_primaryRef_2_0= rulePrimaryRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getContextRefAccess().getPrimaryRefPrimaryRefParserRuleCall_1_1_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryRef_in_ruleContextRef5113);
            lv_primaryRef_2_0=rulePrimaryRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getContextRefRule());
              	        }
                     		set(
                     			current, 
                     			"primaryRef",
                      		lv_primaryRef_2_0, 
                      		"PrimaryRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

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
    // $ANTLR end "ruleContextRef"


    // $ANTLR start "entryRulePrimaryRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2240:1: entryRulePrimaryRef returns [EObject current=null] : iv_rulePrimaryRef= rulePrimaryRef EOF ;
    public final EObject entryRulePrimaryRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2241:2: (iv_rulePrimaryRef= rulePrimaryRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2242:2: iv_rulePrimaryRef= rulePrimaryRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRefRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryRef_in_entryRulePrimaryRef5150);
            iv_rulePrimaryRef=rulePrimaryRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryRef5160); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryRef"


    // $ANTLR start "rulePrimaryRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2249:1: rulePrimaryRef returns [EObject current=null] : ( ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+ (otherlv_1= '->' ( (lv_leaveRef_2_0= ruleLeafReference ) ) )? ) ;
    public final EObject rulePrimaryRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_nodes_0_0 = null;

        EObject lv_leaveRef_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2252:28: ( ( ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+ (otherlv_1= '->' ( (lv_leaveRef_2_0= ruleLeafReference ) ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2253:1: ( ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+ (otherlv_1= '->' ( (lv_leaveRef_2_0= ruleLeafReference ) ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2253:1: ( ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+ (otherlv_1= '->' ( (lv_leaveRef_2_0= ruleLeafReference ) ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2253:2: ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+ (otherlv_1= '->' ( (lv_leaveRef_2_0= ruleLeafReference ) ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2253:2: ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==45) ) {
                    int LA36_2 = input.LA(2);

                    if ( (LA36_2==RULE_ID) ) {
                        alt36=1;
                    }


                }


                switch (alt36) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2254:1: (lv_nodes_0_0= rulePrimaryNodeRef )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2254:1: (lv_nodes_0_0= rulePrimaryNodeRef )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2255:3: lv_nodes_0_0= rulePrimaryNodeRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrimaryRefAccess().getNodesPrimaryNodeRefParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePrimaryNodeRef_in_rulePrimaryRef5206);
            	    lv_nodes_0_0=rulePrimaryNodeRef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPrimaryRefRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"nodes",
            	              		lv_nodes_0_0, 
            	              		"PrimaryNodeRef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2271:3: (otherlv_1= '->' ( (lv_leaveRef_2_0= ruleLeafReference ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==47) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2271:5: otherlv_1= '->' ( (lv_leaveRef_2_0= ruleLeafReference ) )
                    {
                    otherlv_1=(Token)match(input,47,FOLLOW_47_in_rulePrimaryRef5220); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPrimaryRefAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                          
                    }
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2275:1: ( (lv_leaveRef_2_0= ruleLeafReference ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2276:1: (lv_leaveRef_2_0= ruleLeafReference )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2276:1: (lv_leaveRef_2_0= ruleLeafReference )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2277:3: lv_leaveRef_2_0= ruleLeafReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrimaryRefAccess().getLeaveRefLeafReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLeafReference_in_rulePrimaryRef5241);
                    lv_leaveRef_2_0=ruleLeafReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrimaryRefRule());
                      	        }
                             		set(
                             			current, 
                             			"leaveRef",
                              		lv_leaveRef_2_0, 
                              		"LeafReference");
                      	        afterParserOrEnumRuleCall();
                      	    
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
    // $ANTLR end "rulePrimaryRef"


    // $ANTLR start "entryRulePrimaryNodeRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2301:1: entryRulePrimaryNodeRef returns [EObject current=null] : iv_rulePrimaryNodeRef= rulePrimaryNodeRef EOF ;
    public final EObject entryRulePrimaryNodeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryNodeRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2302:2: (iv_rulePrimaryNodeRef= rulePrimaryNodeRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2303:2: iv_rulePrimaryNodeRef= rulePrimaryNodeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryNodeRefRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef5279);
            iv_rulePrimaryNodeRef=rulePrimaryNodeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryNodeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryNodeRef5289); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryNodeRef"


    // $ANTLR start "rulePrimaryNodeRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2310:1: rulePrimaryNodeRef returns [EObject current=null] : ( () otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject rulePrimaryNodeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2313:28: ( ( () otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2314:1: ( () otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2314:1: ( () otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2314:2: () otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2314:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2315:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPrimaryNodeRefAccess().getFunctionRefAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_rulePrimaryNodeRef5335); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPrimaryNodeRefAccess().getFullStopKeyword_1());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2324:1: ( (otherlv_2= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2325:1: (otherlv_2= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2325:1: (otherlv_2= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2326:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPrimaryNodeRefRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimaryNodeRef5355); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getPrimaryNodeRefAccess().getFunctionFunctionCrossReference_2_0()); 
              	
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
    // $ANTLR end "rulePrimaryNodeRef"


    // $ANTLR start "entryRuleLeafReference"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2345:1: entryRuleLeafReference returns [EObject current=null] : iv_ruleLeafReference= ruleLeafReference EOF ;
    public final EObject entryRuleLeafReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeafReference = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2346:2: (iv_ruleLeafReference= ruleLeafReference EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2347:2: iv_ruleLeafReference= ruleLeafReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLeafReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleLeafReference_in_entryRuleLeafReference5391);
            iv_ruleLeafReference=ruleLeafReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLeafReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLeafReference5401); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLeafReference"


    // $ANTLR start "ruleLeafReference"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2354:1: ruleLeafReference returns [EObject current=null] : (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef ) ;
    public final EObject ruleLeafReference() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceRef_0 = null;

        EObject this_LinkRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2357:28: ( (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2358:1: (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2358:1: (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=48 && LA38_0<=49)) ) {
                alt38=1;
            }
            else if ( (LA38_0==50) ) {
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2359:5: this_ResourceRef_0= ruleResourceRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLeafReferenceAccess().getResourceRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleResourceRef_in_ruleLeafReference5448);
                    this_ResourceRef_0=ruleResourceRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ResourceRef_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2369:5: this_LinkRef_1= ruleLinkRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLeafReferenceAccess().getLinkRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLinkRef_in_ruleLeafReference5475);
                    this_LinkRef_1=ruleLinkRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LinkRef_1; 
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
    // $ANTLR end "ruleLeafReference"


    // $ANTLR start "entryRuleResourceRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2385:1: entryRuleResourceRef returns [EObject current=null] : iv_ruleResourceRef= ruleResourceRef EOF ;
    public final EObject entryRuleResourceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2386:2: (iv_ruleResourceRef= ruleResourceRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2387:2: iv_ruleResourceRef= ruleResourceRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResourceRefRule()); 
            }
            pushFollow(FOLLOW_ruleResourceRef_in_entryRuleResourceRef5510);
            iv_ruleResourceRef=ruleResourceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResourceRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceRef5520); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResourceRef"


    // $ANTLR start "ruleResourceRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2394:1: ruleResourceRef returns [EObject current=null] : ( () ( (otherlv_1= 'Res' ( (otherlv_2= RULE_ID ) ) ) | otherlv_3= 'AllRes' ) ( (lv_valuerange_4_0= ruleValueRange ) ) ) ;
    public final EObject ruleResourceRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_valuerange_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2397:28: ( ( () ( (otherlv_1= 'Res' ( (otherlv_2= RULE_ID ) ) ) | otherlv_3= 'AllRes' ) ( (lv_valuerange_4_0= ruleValueRange ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2398:1: ( () ( (otherlv_1= 'Res' ( (otherlv_2= RULE_ID ) ) ) | otherlv_3= 'AllRes' ) ( (lv_valuerange_4_0= ruleValueRange ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2398:1: ( () ( (otherlv_1= 'Res' ( (otherlv_2= RULE_ID ) ) ) | otherlv_3= 'AllRes' ) ( (lv_valuerange_4_0= ruleValueRange ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2398:2: () ( (otherlv_1= 'Res' ( (otherlv_2= RULE_ID ) ) ) | otherlv_3= 'AllRes' ) ( (lv_valuerange_4_0= ruleValueRange ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2398:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2399:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getResourceRefAccess().getResourceRefAction_0(),
                          current);
                  
            }

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2404:2: ( (otherlv_1= 'Res' ( (otherlv_2= RULE_ID ) ) ) | otherlv_3= 'AllRes' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==48) ) {
                alt39=1;
            }
            else if ( (LA39_0==49) ) {
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2404:3: (otherlv_1= 'Res' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2404:3: (otherlv_1= 'Res' ( (otherlv_2= RULE_ID ) ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2404:5: otherlv_1= 'Res' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleResourceRef5568); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getResourceRefAccess().getResKeyword_1_0_0());
                          
                    }
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2408:1: ( (otherlv_2= RULE_ID ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2409:1: (otherlv_2= RULE_ID )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2409:1: (otherlv_2= RULE_ID )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2410:3: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getResourceRefRule());
                      	        }
                              
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResourceRef5588); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_2, grammarAccess.getResourceRefAccess().getResourceNetXResourceCrossReference_1_0_1_0()); 
                      	
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2422:7: otherlv_3= 'AllRes'
                    {
                    otherlv_3=(Token)match(input,49,FOLLOW_49_in_ruleResourceRef5607); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getResourceRefAccess().getAllResKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2426:2: ( (lv_valuerange_4_0= ruleValueRange ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2427:1: (lv_valuerange_4_0= ruleValueRange )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2427:1: (lv_valuerange_4_0= ruleValueRange )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2428:3: lv_valuerange_4_0= ruleValueRange
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getResourceRefAccess().getValuerangeValueRangeEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValueRange_in_ruleResourceRef5629);
            lv_valuerange_4_0=ruleValueRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getResourceRefRule());
              	        }
                     		set(
                     			current, 
                     			"valuerange",
                      		lv_valuerange_4_0, 
                      		"ValueRange");
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
    // $ANTLR end "ruleResourceRef"


    // $ANTLR start "entryRuleLinkRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2452:1: entryRuleLinkRef returns [EObject current=null] : iv_ruleLinkRef= ruleLinkRef EOF ;
    public final EObject entryRuleLinkRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinkRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2453:2: (iv_ruleLinkRef= ruleLinkRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2454:2: iv_ruleLinkRef= ruleLinkRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLinkRefRule()); 
            }
            pushFollow(FOLLOW_ruleLinkRef_in_entryRuleLinkRef5665);
            iv_ruleLinkRef=ruleLinkRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLinkRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLinkRef5675); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLinkRef"


    // $ANTLR start "ruleLinkRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2461:1: ruleLinkRef returns [EObject current=null] : ( () otherlv_1= 'Link' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleLinkRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2464:28: ( ( () otherlv_1= 'Link' ( (otherlv_2= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2465:1: ( () otherlv_1= 'Link' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2465:1: ( () otherlv_1= 'Link' ( (otherlv_2= RULE_ID ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2465:2: () otherlv_1= 'Link' ( (otherlv_2= RULE_ID ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2465:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2466:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getLinkRefAccess().getLinkRefAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleLinkRef5721); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLinkRefAccess().getLinkKeyword_1());
                  
            }
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2475:1: ( (otherlv_2= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2476:1: (otherlv_2= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2476:1: (otherlv_2= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2477:3: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLinkRefRule());
              	        }
                      
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLinkRef5741); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_2, grammarAccess.getLinkRefAccess().getLinkRelationshipCrossReference_2_0()); 
              	
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
    // $ANTLR end "ruleLinkRef"


    // $ANTLR start "ruleNativeFunction"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2496:1: ruleNativeFunction returns [Enumerator current=null] : ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) ) ;
    public final Enumerator ruleNativeFunction() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2498:28: ( ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2499:1: ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2499:1: ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) )
            int alt40=6;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt40=1;
                }
                break;
            case 52:
                {
                alt40=2;
                }
                break;
            case 53:
                {
                alt40=3;
                }
                break;
            case 54:
                {
                alt40=4;
                }
                break;
            case 55:
                {
                alt40=5;
                }
                break;
            case 56:
                {
                alt40=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2499:2: (enumLiteral_0= 'count()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2499:2: (enumLiteral_0= 'count()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2499:4: enumLiteral_0= 'count()'
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_51_in_ruleNativeFunction5791); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2505:6: (enumLiteral_1= 'sum()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2505:6: (enumLiteral_1= 'sum()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2505:8: enumLiteral_1= 'sum()'
                    {
                    enumLiteral_1=(Token)match(input,52,FOLLOW_52_in_ruleNativeFunction5808); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2511:6: (enumLiteral_2= 'min()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2511:6: (enumLiteral_2= 'min()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2511:8: enumLiteral_2= 'min()'
                    {
                    enumLiteral_2=(Token)match(input,53,FOLLOW_53_in_ruleNativeFunction5825); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2517:6: (enumLiteral_3= 'max()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2517:6: (enumLiteral_3= 'max()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2517:8: enumLiteral_3= 'max()'
                    {
                    enumLiteral_3=(Token)match(input,54,FOLLOW_54_in_ruleNativeFunction5842); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2523:6: (enumLiteral_4= 'mean()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2523:6: (enumLiteral_4= 'mean()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2523:8: enumLiteral_4= 'mean()'
                    {
                    enumLiteral_4=(Token)match(input,55,FOLLOW_55_in_ruleNativeFunction5859); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2529:6: (enumLiteral_5= 'deviation()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2529:6: (enumLiteral_5= 'deviation()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2529:8: enumLiteral_5= 'deviation()'
                    {
                    enumLiteral_5=(Token)match(input,56,FOLLOW_56_in_ruleNativeFunction5876); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5()); 
                          
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
    // $ANTLR end "ruleNativeFunction"


    // $ANTLR start "ruleValueRange"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2539:1: ruleValueRange returns [Enumerator current=null] : ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) ) ;
    public final Enumerator ruleValueRange() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2541:28: ( ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2542:1: ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2542:1: ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) )
            int alt41=6;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt41=1;
                }
                break;
            case 58:
                {
                alt41=2;
                }
                break;
            case 59:
                {
                alt41=3;
                }
                break;
            case 60:
                {
                alt41=4;
                }
                break;
            case 61:
                {
                alt41=5;
                }
                break;
            case 62:
                {
                alt41=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2542:2: (enumLiteral_0= 'METRIC' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2542:2: (enumLiteral_0= 'METRIC' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2542:4: enumLiteral_0= 'METRIC'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_57_in_ruleValueRange5921); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getValueRangeAccess().getMETRICEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getValueRangeAccess().getMETRICEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2548:6: (enumLiteral_1= 'CAP' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2548:6: (enumLiteral_1= 'CAP' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2548:8: enumLiteral_1= 'CAP'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_58_in_ruleValueRange5938); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getValueRangeAccess().getCAPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getValueRangeAccess().getCAPEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2554:6: (enumLiteral_2= 'FORECAST' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2554:6: (enumLiteral_2= 'FORECAST' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2554:8: enumLiteral_2= 'FORECAST'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_59_in_ruleValueRange5955); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getValueRangeAccess().getFORECASTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getValueRangeAccess().getFORECASTEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2560:6: (enumLiteral_3= 'FORECAST_CAP' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2560:6: (enumLiteral_3= 'FORECAST_CAP' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2560:8: enumLiteral_3= 'FORECAST_CAP'
                    {
                    enumLiteral_3=(Token)match(input,60,FOLLOW_60_in_ruleValueRange5972); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getValueRangeAccess().getFORECAST_CAPEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getValueRangeAccess().getFORECAST_CAPEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2566:6: (enumLiteral_4= 'TRENDED' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2566:6: (enumLiteral_4= 'TRENDED' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2566:8: enumLiteral_4= 'TRENDED'
                    {
                    enumLiteral_4=(Token)match(input,61,FOLLOW_61_in_ruleValueRange5989); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getValueRangeAccess().getTRENDEDEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getValueRangeAccess().getTRENDEDEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2572:6: (enumLiteral_5= 'UTILIZATION' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2572:6: (enumLiteral_5= 'UTILIZATION' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2572:8: enumLiteral_5= 'UTILIZATION'
                    {
                    enumLiteral_5=(Token)match(input,62,FOLLOW_62_in_ruleValueRange6006); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getValueRangeAccess().getUTILIZATIONEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getValueRangeAccess().getUTILIZATIONEnumLiteralDeclaration_5()); 
                          
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
    // $ANTLR end "ruleValueRange"

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA9_eotS =
        "\27\uffff";
    static final String DFA9_eofS =
        "\27\uffff";
    static final String DFA9_minS =
        "\1\4\1\uffff\1\17\1\55\3\uffff\1\4\1\24\1\60\1\4\1\uffff\1\4\1\71"+
        "\1\4\1\71\7\24";
    static final String DFA9_maxS =
        "\1\56\1\uffff\2\55\3\uffff\1\4\1\57\1\62\1\70\1\uffff\1\4\1\76\1"+
        "\4\1\76\7\55";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\2\4\uffff\1\3\13\uffff";
    static final String DFA9_specialS =
        "\27\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\uffff\1\4\10\uffff\1\4\5\uffff\1\5\3\uffff\1\1\11\uffff"+
            "\2\4\3\uffff\4\4\2\uffff\1\3",
            "",
            "\1\4\4\uffff\1\4\5\uffff\1\6\15\4\3\uffff\1\4\1\uffff\1\4",
            "\1\7",
            "",
            "",
            "",
            "\1\10",
            "\1\4\5\uffff\1\13\15\4\5\uffff\1\12\1\uffff\1\11",
            "\1\14\1\15\1\16",
            "\1\10\56\uffff\6\4",
            "",
            "\1\17",
            "\1\20\1\21\1\22\1\23\1\24\1\25",
            "\1\26",
            "\1\20\1\21\1\22\1\23\1\24\1\25",
            "\1\4\5\uffff\1\13\15\4\5\uffff\1\4",
            "\1\4\5\uffff\1\13\15\4\5\uffff\1\4",
            "\1\4\5\uffff\1\13\15\4\5\uffff\1\4",
            "\1\4\5\uffff\1\13\15\4\5\uffff\1\4",
            "\1\4\5\uffff\1\13\15\4\5\uffff\1\4",
            "\1\4\5\uffff\1\13\15\4\5\uffff\1\4",
            "\1\4\5\uffff\1\13\15\4\5\uffff\1\4"
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
            return "429:3: (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement )";
        }
    }
    static final String DFA27_eotS =
        "\55\uffff";
    static final String DFA27_eofS =
        "\4\uffff\1\11\7\uffff\1\21\2\24\17\uffff\7\24\1\uffff\7\24";
    static final String DFA27_minS =
        "\1\4\1\uffff\1\6\1\55\1\17\1\uffff\1\20\1\4\2\uffff\1\4\1\6\4\20"+
        "\2\uffff\1\60\1\4\1\uffff\1\60\2\4\1\71\2\4\1\71\1\4\1\71\7\20\1"+
        "\71\7\20";
    static final String DFA27_maxS =
        "\1\56\1\uffff\1\6\2\55\1\uffff\1\54\1\4\2\uffff\1\4\1\6\1\55\2\57"+
        "\1\54\2\uffff\1\62\1\70\1\uffff\1\62\1\70\1\4\1\76\2\4\1\76\1\4"+
        "\1\76\7\55\1\76\7\55";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\3\uffff\1\7\2\uffff\1\5\1\6\6\uffff\1\3\1\2\2\uffff"+
        "\1\4\30\uffff";
    static final String DFA27_specialS =
        "\55\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\4\1\uffff\1\1\10\uffff\1\5\31\uffff\2\1\1\2\2\uffff\1\3",
            "",
            "\1\6",
            "\1\7",
            "\1\10\2\11\2\uffff\1\11\6\uffff\15\11\3\uffff\2\11\1\12",
            "",
            "\1\13\33\uffff\1\14",
            "\1\15",
            "",
            "",
            "\1\16",
            "\1\17",
            "\2\21\2\uffff\1\21\6\uffff\15\21\4\uffff\1\21\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\23\1\uffff"+
            "\1\22",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\26\1\uffff"+
            "\1\25",
            "\1\13\33\uffff\1\14",
            "",
            "",
            "\1\27\1\30\1\31",
            "\1\15\56\uffff\6\20",
            "",
            "\1\32\1\33\1\34",
            "\1\16\56\uffff\6\20",
            "\1\35",
            "\1\36\1\37\1\40\1\41\1\42\1\43",
            "\1\44",
            "\1\45",
            "\1\46\1\47\1\50\1\51\1\52\1\53",
            "\1\54",
            "\1\36\1\37\1\40\1\41\1\42\1\43",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\1\46\1\47\1\50\1\51\1\52\1\53",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20",
            "\2\24\2\uffff\1\24\6\uffff\15\24\4\uffff\1\24\1\20"
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1500:1: (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NativeExpression_2= ruleNativeExpression | this_Reference_3= ruleReference | this_FunctionCall_4= ruleFunctionCall | this_IndexedCall_5= ruleIndexedCall | this_ParenthesizedExpression_6= ruleParenthesizedExpression )";
        }
    }
 

    public static final BitSet FOLLOW_ruleMod_in_entryRuleMod75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMod85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleMod123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMod140 = new BitSet(new long[]{0x00004F180364E050L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMod168 = new BitSet(new long[]{0x00004F180364E050L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleMod191 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleMod219 = new BitSet(new long[]{0x00004F180364E052L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleImport306 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleFunction411 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction428 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFunction445 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleFunction467 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleFunction480 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleFunction501 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleFunction517 = new BitSet(new long[]{0x00004F180364E050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleFunction538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_entryRuleArgument574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgument584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArgument625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleBlock725 = new BitSet(new long[]{0x00004F18036CE050L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleBlock746 = new BitSet(new long[]{0x00004F18036CE050L});
    public static final BitSet FOLLOW_19_in_ruleBlock759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_ruleStatement854 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_ruleStatement881 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_ruleStatement908 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleStatement934 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_ruleStatement962 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleStatement974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleStatement1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_ruleStatement1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleStatement1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement1092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReturnStatement1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleReturnStatement1148 = new BitSet(new long[]{0x00004F1800008052L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReturnStatement1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement1206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleIfStatement1262 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleIfStatement1274 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleIfStatement1295 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleIfStatement1307 = new BitSet(new long[]{0x00004F180364E050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement1328 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleIfStatement1341 = new BitSet(new long[]{0x00004F180364E050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement1400 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleWhileStatement1456 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleWhileStatement1468 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleWhileStatement1489 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleWhileStatement1501 = new BitSet(new long[]{0x00004F180364E050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleWhileStatement1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement1558 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableStatement1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVariableStatement1614 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableStatement1631 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleVariableStatement1649 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableStatement1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_entryRuleAssignmentStatement1708 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentStatement1718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentStatement1772 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAssignmentStatement1784 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssignmentStatement1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_entryRuleReferenceAssignmentStatement1841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAssignmentStatement1851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_ruleReferenceAssignmentStatement1906 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleReferenceAssignmentStatement1918 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReferenceAssignmentStatement1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression1975 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression1985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleExpression2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_entryRuleLogical2065 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogical2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_ruleLogical2122 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_27_in_ruleLogical2145 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_28_in_ruleLogical2174 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleEquality_in_ruleLogical2197 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleEquality_in_entryRuleEquality2235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquality2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleEquality2292 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_29_in_ruleEquality2315 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_30_in_ruleEquality2344 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleEquality2367 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison2405 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison2462 = new BitSet(new long[]{0x0000000780000002L});
    public static final BitSet FOLLOW_31_in_ruleComparison2485 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_32_in_ruleComparison2514 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_33_in_ruleComparison2543 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_34_in_ruleComparison2572 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison2595 = new BitSet(new long[]{0x0000000780000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition2633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition2643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition2690 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_35_in_ruleAddition2713 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_36_in_ruleAddition2742 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition2765 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication2803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication2813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiplication2860 = new BitSet(new long[]{0x000000E000000002L});
    public static final BitSet FOLLOW_37_in_ruleMultiplication2883 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_38_in_ruleMultiplication2912 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_39_in_ruleMultiplication2941 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiplication2964 = new BitSet(new long[]{0x000000E000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_entryRuleUnary3002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnary3012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnary3059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleUnary3094 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnary3145 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleUnary3168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator3206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator3217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUnaryOperator3255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleUnaryOperator3274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression3371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_rulePrimaryExpression3398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeExpression_in_rulePrimaryExpression3425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rulePrimaryExpression3452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_rulePrimaryExpression3479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexedCall_in_rulePrimaryExpression3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral3625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleLiteral3659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleLiteral3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral3728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumberLiteral3789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression3830 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression3840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedExpression3877 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression3899 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParenthesizedExpression3910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall3946 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall3956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionCall4010 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFunctionCall4022 = new BitSet(new long[]{0x00004F1800028050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall4044 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleFunctionCall4057 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall4078 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleFunctionCall4094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexedCall_in_entryRuleIndexedCall4130 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndexedCall4140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_ruleIndexedCall4187 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleIndexedCall4199 = new BitSet(new long[]{0x00004F1800008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIndexedCall4220 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleIndexedCall4232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall4270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarOrArgumentCall4280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarOrArgumentCall4334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeExpression_in_entryRuleNativeExpression4370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNativeExpression4380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_ruleNativeExpression4436 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleReference_in_ruleNativeExpression4463 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleNativeExpression4476 = new BitSet(new long[]{0x01F8000000000000L});
    public static final BitSet FOLLOW_ruleNativeFunction_in_ruleNativeExpression4497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_entryRuleRange4533 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRange4543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_ruleRange4589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_entryRuleRangeLiteral4623 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeLiteral4633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleRangeLiteral4679 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4696 = new BitSet(new long[]{0x0000100000010000L});
    public static final BitSet FOLLOW_16_in_ruleRangeLiteral4714 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4731 = new BitSet(new long[]{0x0000100000010000L});
    public static final BitSet FOLLOW_44_in_ruleRangeLiteral4750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference4786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference4796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_ruleReference4843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbsoluteRef_in_ruleReference4870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbsoluteRef_in_entryRuleAbsoluteRef4905 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbsoluteRef4915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAbsoluteRef4969 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rulePrimaryRef_in_ruleAbsoluteRef4990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_entryRuleContextRef5026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextRef5036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleContextRef5091 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rulePrimaryRef_in_ruleContextRef5113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryRef_in_entryRulePrimaryRef5150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryRef5160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_rulePrimaryRef5206 = new BitSet(new long[]{0x0000A00000000002L});
    public static final BitSet FOLLOW_47_in_rulePrimaryRef5220 = new BitSet(new long[]{0x0007000000000000L});
    public static final BitSet FOLLOW_ruleLeafReference_in_rulePrimaryRef5241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef5279 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryNodeRef5289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rulePrimaryNodeRef5335 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimaryNodeRef5355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLeafReference_in_entryRuleLeafReference5391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLeafReference5401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_ruleLeafReference5448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_ruleLeafReference5475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_entryRuleResourceRef5510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceRef5520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleResourceRef5568 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResourceRef5588 = new BitSet(new long[]{0x7E00000000000000L});
    public static final BitSet FOLLOW_49_in_ruleResourceRef5607 = new BitSet(new long[]{0x7E00000000000000L});
    public static final BitSet FOLLOW_ruleValueRange_in_ruleResourceRef5629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_entryRuleLinkRef5665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLinkRef5675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleLinkRef5721 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLinkRef5741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleNativeFunction5791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleNativeFunction5808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleNativeFunction5825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleNativeFunction5842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleNativeFunction5859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleNativeFunction5876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleValueRange5921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleValueRange5938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleValueRange5955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleValueRange5972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleValueRange5989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleValueRange6006 = new BitSet(new long[]{0x0000000000000002L});

}