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

@SuppressWarnings("all")
public class InternalNetxscriptParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NUMBER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mod'", "'import'", "'def'", "'('", "','", "')'", "'{'", "'}'", "';'", "'return'", "'if'", "'else'", "'while'", "'var'", "'='", "'+='", "'&&'", "'||'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'.'", "'true'", "'false'", "'['", "']'", "'PARAM'", "'NETYPE'", "'NE'", "'this'", "'->'", "'FUNCTION'", "'EQUIPMENT'", "'PROFILE'", "'STATUS'", "'RESOURCE'", "'ALL'", "'LINK'", "'::'", "'count()'", "'sum()'", "'min()'", "'max()'", "'mean()'", "'deviation()'", "'erlangB()'", "'clear()'", "'MONTH'", "'WEEK'", "'DAY'", "'HOUR'", "'RED'", "'AMBER'", "'GREEN'", "'YELLOW'", "'METRIC'", "'CAP'", "'FORECAST'", "'FORECAST_CAP'", "'TRENDED'", "'UTILIZATION'", "'TOLERANCE'", "'DERIVED'", "'AVG'", "'BH'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=4;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
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
    public static final int T__80=80;
    public static final int T__46=46;
    public static final int T__81=81;
    public static final int T__47=47;
    public static final int T__82=82;
    public static final int T__44=44;
    public static final int T__83=83;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__85=85;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__84=84;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

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
             newCompositeNode(grammarAccess.getModRule()); 
            pushFollow(FOLLOW_ruleMod_in_entryRuleMod75);
            iv_ruleMod=ruleMod();

            state._fsp--;

             current =iv_ruleMod; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMod85); 

            }

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
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleMod123); 

                        	newLeafNode(otherlv_0, grammarAccess.getModAccess().getModKeyword_0_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:85:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:86:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:86:1: (lv_name_1_0= RULE_ID )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:87:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMod140); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getModAccess().getNameIDTerminalRuleCall_0_1_0()); 
                    		

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
            	     
            	    	        newCompositeNode(grammarAccess.getModAccess().getImportsImportParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleMod168);
            	    lv_imports_2_0=ruleImport();

            	    state._fsp--;


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
            else if ( (LA5_0==RULE_ID||LA5_0==18||(LA5_0>=21 && LA5_0<=22)||(LA5_0>=24 && LA5_0<=25)||LA5_0==48||LA5_0==50) ) {
                alt5=2;
            }
            else {
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
                    	     
                    	    	        newCompositeNode(grammarAccess.getModAccess().getFunctionsFunctionParserRuleCall_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFunction_in_ruleMod191);
                    	    lv_functions_3_0=ruleFunction();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
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

                        if ( (LA4_0==RULE_ID||LA4_0==18||(LA4_0>=21 && LA4_0<=22)||(LA4_0>=24 && LA4_0<=25)||LA4_0==48||LA4_0==50) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:141:1: (lv_statements_4_0= ruleStatement )
                    	    {
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:141:1: (lv_statements_4_0= ruleStatement )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:142:3: lv_statements_4_0= ruleStatement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModAccess().getStatementsStatementParserRuleCall_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleStatement_in_ruleMod219);
                    	    lv_statements_4_0=ruleStatement();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
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
    // $ANTLR end "ruleMod"


    // $ANTLR start "entryRuleImport"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:166:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:167:2: (iv_ruleImport= ruleImport EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:168:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport257);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport267); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:175:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:178:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:179:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:179:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:179:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleImport304); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:183:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:184:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:184:1: (lv_importURI_1_0= RULE_STRING )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:185:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport321); 

            			newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            		

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleFunction"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:209:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:210:2: (iv_ruleFunction= ruleFunction EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:211:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction362);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction372); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:218:1: ruleFunction returns [EObject current=null] : (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) ) ;
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
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:221:28: ( (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:222:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:222:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:222:3: otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleFunction409); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getDefKeyword_0());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:226:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:227:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:227:1: (lv_name_1_0= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:228:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction426); 

            			newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleFunction443); 

                	newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:248:1: ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:248:2: ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )*
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:248:2: ( (lv_args_3_0= ruleArgument ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:249:1: (lv_args_3_0= ruleArgument )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:249:1: (lv_args_3_0= ruleArgument )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:250:3: lv_args_3_0= ruleArgument
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArgument_in_ruleFunction465);
                    lv_args_3_0=ruleArgument();

                    state._fsp--;


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

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:266:2: (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==16) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:266:4: otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleFunction478); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:270:1: ( (lv_args_5_0= ruleArgument ) )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:271:1: (lv_args_5_0= ruleArgument )
                    	    {
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:271:1: (lv_args_5_0= ruleArgument )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:272:3: lv_args_5_0= ruleArgument
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArgument_in_ruleFunction499);
                    	    lv_args_5_0=ruleArgument();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleFunction515); 

                	newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_4());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:292:1: ( (lv_block_7_0= ruleBlock ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:293:1: (lv_block_7_0= ruleBlock )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:293:1: (lv_block_7_0= ruleBlock )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:294:3: lv_block_7_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getFunctionAccess().getBlockBlockParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleFunction536);
            lv_block_7_0=ruleBlock();

            state._fsp--;


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
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleArgument"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:318:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:319:2: (iv_ruleArgument= ruleArgument EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:320:2: iv_ruleArgument= ruleArgument EOF
            {
             newCompositeNode(grammarAccess.getArgumentRule()); 
            pushFollow(FOLLOW_ruleArgument_in_entryRuleArgument572);
            iv_ruleArgument=ruleArgument();

            state._fsp--;

             current =iv_ruleArgument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgument582); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:327:1: ruleArgument returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:330:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:331:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:331:1: ( (lv_name_0_0= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:332:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:332:1: (lv_name_0_0= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:333:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArgument623); 

            			newLeafNode(lv_name_0_0, grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_0()); 
            		

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
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleBlock"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:361:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:362:2: (iv_ruleBlock= ruleBlock EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:363:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock667);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock677); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:370:1: ruleBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:373:28: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:374:1: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:374:1: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:374:2: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:374:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:375:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBlockAccess().getBlockAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleBlock723); 

                	newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:384:1: ( (lv_statements_2_0= ruleStatement ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==18||(LA8_0>=21 && LA8_0<=22)||(LA8_0>=24 && LA8_0<=25)||LA8_0==48||LA8_0==50) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:385:1: (lv_statements_2_0= ruleStatement )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:385:1: (lv_statements_2_0= ruleStatement )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:386:3: lv_statements_2_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleBlock744);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleBlock757); 

                	newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:414:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:415:2: (iv_ruleStatement= ruleStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:416:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement793);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement803); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:423:1: ruleStatement returns [EObject current=null] : ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_5=null;
        EObject this_VariableStatement_0 = null;

        EObject this_AssignmentStatement_1 = null;

        EObject this_PlusAssignmentStatement_2 = null;

        EObject this_ReferenceAssignmentStatement_3 = null;

        EObject this_ReturnStatement_4 = null;

        EObject this_IfStatement_6 = null;

        EObject this_WhileStatement_7 = null;

        EObject this_Block_8 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:426:28: ( ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:1: ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:1: ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 21:
            case 25:
            case 48:
            case 50:
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
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:2: ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:2: ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:3: (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';'
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:3: (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | this_ReturnStatement_4= ruleReturnStatement )
                    int alt9=5;
                    switch ( input.LA(1) ) {
                    case 25:
                        {
                        alt9=1;
                        }
                        break;
                    case RULE_ID:
                        {
                        int LA9_2 = input.LA(2);

                        if ( (LA9_2==26) ) {
                            alt9=2;
                        }
                        else if ( (LA9_2==27) ) {
                            alt9=3;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 48:
                    case 50:
                        {
                        alt9=4;
                        }
                        break;
                    case 21:
                        {
                        alt9=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }

                    switch (alt9) {
                        case 1 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:428:5: this_VariableStatement_0= ruleVariableStatement
                            {
                             
                                    newCompositeNode(grammarAccess.getStatementAccess().getVariableStatementParserRuleCall_0_0_0()); 
                                
                            pushFollow(FOLLOW_ruleVariableStatement_in_ruleStatement852);
                            this_VariableStatement_0=ruleVariableStatement();

                            state._fsp--;

                             
                                    current = this_VariableStatement_0; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;
                        case 2 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:438:5: this_AssignmentStatement_1= ruleAssignmentStatement
                            {
                             
                                    newCompositeNode(grammarAccess.getStatementAccess().getAssignmentStatementParserRuleCall_0_0_1()); 
                                
                            pushFollow(FOLLOW_ruleAssignmentStatement_in_ruleStatement879);
                            this_AssignmentStatement_1=ruleAssignmentStatement();

                            state._fsp--;

                             
                                    current = this_AssignmentStatement_1; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;
                        case 3 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:448:5: this_PlusAssignmentStatement_2= rulePlusAssignmentStatement
                            {
                             
                                    newCompositeNode(grammarAccess.getStatementAccess().getPlusAssignmentStatementParserRuleCall_0_0_2()); 
                                
                            pushFollow(FOLLOW_rulePlusAssignmentStatement_in_ruleStatement906);
                            this_PlusAssignmentStatement_2=rulePlusAssignmentStatement();

                            state._fsp--;

                             
                                    current = this_PlusAssignmentStatement_2; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;
                        case 4 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:458:5: this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement
                            {
                             
                                    newCompositeNode(grammarAccess.getStatementAccess().getReferenceAssignmentStatementParserRuleCall_0_0_3()); 
                                
                            pushFollow(FOLLOW_ruleReferenceAssignmentStatement_in_ruleStatement933);
                            this_ReferenceAssignmentStatement_3=ruleReferenceAssignmentStatement();

                            state._fsp--;

                             
                                    current = this_ReferenceAssignmentStatement_3; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;
                        case 5 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:468:5: this_ReturnStatement_4= ruleReturnStatement
                            {
                             
                                    newCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_0_0_4()); 
                                
                            pushFollow(FOLLOW_ruleReturnStatement_in_ruleStatement960);
                            this_ReturnStatement_4=ruleReturnStatement();

                            state._fsp--;

                             
                                    current = this_ReturnStatement_4; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleStatement972); 

                        	newLeafNode(otherlv_5, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:482:5: this_IfStatement_6= ruleIfStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIfStatement_in_ruleStatement1001);
                    this_IfStatement_6=ruleIfStatement();

                    state._fsp--;

                     
                            current = this_IfStatement_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:492:5: this_WhileStatement_7= ruleWhileStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleWhileStatement_in_ruleStatement1028);
                    this_WhileStatement_7=ruleWhileStatement();

                    state._fsp--;

                     
                            current = this_WhileStatement_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:502:5: this_Block_8= ruleBlock
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleBlock_in_ruleStatement1055);
                    this_Block_8=ruleBlock();

                    state._fsp--;

                     
                            current = this_Block_8; 
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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleReturnStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:518:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:519:2: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:520:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
             newCompositeNode(grammarAccess.getReturnStatementRule()); 
            pushFollow(FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement1090);
            iv_ruleReturnStatement=ruleReturnStatement();

            state._fsp--;

             current =iv_ruleReturnStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReturnStatement1100); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:527:1: ruleReturnStatement returns [EObject current=null] : ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:530:28: ( ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:531:1: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:531:1: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:531:2: () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:531:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:532:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReturnStatementAccess().getReturnAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleReturnStatement1146); 

                	newLeafNode(otherlv_1, grammarAccess.getReturnStatementAccess().getReturnKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:541:1: ( (lv_expression_2_0= ruleExpression ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==RULE_NUMBER||LA11_0==15||(LA11_0>=36 && LA11_0<=37)||LA11_0==41||(LA11_0>=43 && LA11_0<=45)||(LA11_0>=47 && LA11_0<=50)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:542:1: (lv_expression_2_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:542:1: (lv_expression_2_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:543:3: lv_expression_2_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleReturnStatement1167);
                    lv_expression_2_0=ruleExpression();

                    state._fsp--;


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
    // $ANTLR end "ruleReturnStatement"


    // $ANTLR start "entryRuleIfStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:567:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:568:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:569:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             newCompositeNode(grammarAccess.getIfStatementRule()); 
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement1204);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement1214); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:576:1: ruleIfStatement returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? ) ;
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
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:579:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:580:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:580:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:580:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:580:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:581:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIfStatementAccess().getIfAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleIfStatement1260); 

                	newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getIfKeyword_1());
                
            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleIfStatement1272); 

                	newLeafNode(otherlv_2, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:594:1: ( (lv_if_3_0= ruleLogical ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:595:1: (lv_if_3_0= ruleLogical )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:595:1: (lv_if_3_0= ruleLogical )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:596:3: lv_if_3_0= ruleLogical
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getIfLogicalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLogical_in_ruleIfStatement1293);
            lv_if_3_0=ruleLogical();

            state._fsp--;


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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleIfStatement1305); 

                	newLeafNode(otherlv_4, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_4());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:616:1: ( (lv_then_5_0= ruleBlock ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:617:1: (lv_then_5_0= ruleBlock )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:617:1: (lv_then_5_0= ruleBlock )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:618:3: lv_then_5_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getThenBlockParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement1326);
            lv_then_5_0=ruleBlock();

            state._fsp--;


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

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:634:2: (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:634:4: otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) )
                    {
                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleIfStatement1339); 

                        	newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getElseKeyword_6_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:638:1: ( (lv_else_7_0= ruleBlock ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:639:1: (lv_else_7_0= ruleBlock )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:639:1: (lv_else_7_0= ruleBlock )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:640:3: lv_else_7_0= ruleBlock
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfStatementAccess().getElseBlockParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement1360);
                    lv_else_7_0=ruleBlock();

                    state._fsp--;


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
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleWhileStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:664:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:665:2: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:666:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
             newCompositeNode(grammarAccess.getWhileStatementRule()); 
            pushFollow(FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement1398);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;

             current =iv_ruleWhileStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileStatement1408); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:673:1: ruleWhileStatement returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:676:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:677:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:677:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:677:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:677:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:678:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWhileStatementAccess().getWhileAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleWhileStatement1454); 

                	newLeafNode(otherlv_1, grammarAccess.getWhileStatementAccess().getWhileKeyword_1());
                
            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleWhileStatement1466); 

                	newLeafNode(otherlv_2, grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:691:1: ( (lv_predicate_3_0= ruleLogical ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:692:1: (lv_predicate_3_0= ruleLogical )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:692:1: (lv_predicate_3_0= ruleLogical )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:693:3: lv_predicate_3_0= ruleLogical
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getPredicateLogicalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLogical_in_ruleWhileStatement1487);
            lv_predicate_3_0=ruleLogical();

            state._fsp--;


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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleWhileStatement1499); 

                	newLeafNode(otherlv_4, grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_4());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:713:1: ( (lv_body_5_0= ruleBlock ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:714:1: (lv_body_5_0= ruleBlock )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:714:1: (lv_body_5_0= ruleBlock )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:715:3: lv_body_5_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleWhileStatement1520);
            lv_body_5_0=ruleBlock();

            state._fsp--;


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
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleVariableStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:739:1: entryRuleVariableStatement returns [EObject current=null] : iv_ruleVariableStatement= ruleVariableStatement EOF ;
    public final EObject entryRuleVariableStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:740:2: (iv_ruleVariableStatement= ruleVariableStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:741:2: iv_ruleVariableStatement= ruleVariableStatement EOF
            {
             newCompositeNode(grammarAccess.getVariableStatementRule()); 
            pushFollow(FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement1556);
            iv_ruleVariableStatement=ruleVariableStatement();

            state._fsp--;

             current =iv_ruleVariableStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableStatement1566); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:748:1: ruleVariableStatement returns [EObject current=null] : ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:751:28: ( ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:752:1: ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:752:1: ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:752:2: () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:752:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:753:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVariableStatementAccess().getVariableAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleVariableStatement1612); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableStatementAccess().getVarKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:762:1: ( (lv_name_2_0= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:763:1: (lv_name_2_0= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:763:1: (lv_name_2_0= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:764:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableStatement1629); 

            			newLeafNode(lv_name_2_0, grammarAccess.getVariableStatementAccess().getNameIDTerminalRuleCall_2_0()); 
            		

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

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:780:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:780:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleVariableStatement1647); 

                        	newLeafNode(otherlv_3, grammarAccess.getVariableStatementAccess().getEqualsSignKeyword_3_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:784:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:785:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:785:1: (lv_expression_4_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:786:3: lv_expression_4_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableStatement1668);
                    lv_expression_4_0=ruleExpression();

                    state._fsp--;


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
    // $ANTLR end "ruleVariableStatement"


    // $ANTLR start "entryRuleAssignmentStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:810:1: entryRuleAssignmentStatement returns [EObject current=null] : iv_ruleAssignmentStatement= ruleAssignmentStatement EOF ;
    public final EObject entryRuleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:811:2: (iv_ruleAssignmentStatement= ruleAssignmentStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:812:2: iv_ruleAssignmentStatement= ruleAssignmentStatement EOF
            {
             newCompositeNode(grammarAccess.getAssignmentStatementRule()); 
            pushFollow(FOLLOW_ruleAssignmentStatement_in_entryRuleAssignmentStatement1706);
            iv_ruleAssignmentStatement=ruleAssignmentStatement();

            state._fsp--;

             current =iv_ruleAssignmentStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentStatement1716); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:819:1: ruleAssignmentStatement returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:822:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:823:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:823:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:823:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:823:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:824:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAssignmentStatementAccess().getAssignmentAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:829:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:830:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:830:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:831:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssignmentStatementRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentStatement1770); 

            		newLeafNode(otherlv_1, grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleAssignmentStatement1782); 

                	newLeafNode(otherlv_2, grammarAccess.getAssignmentStatementAccess().getEqualsSignKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:846:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:847:1: (lv_expression_3_0= ruleExpression )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:847:1: (lv_expression_3_0= ruleExpression )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:848:3: lv_expression_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleAssignmentStatement1803);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


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
    // $ANTLR end "ruleAssignmentStatement"


    // $ANTLR start "entryRulePlusAssignmentStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:872:1: entryRulePlusAssignmentStatement returns [EObject current=null] : iv_rulePlusAssignmentStatement= rulePlusAssignmentStatement EOF ;
    public final EObject entryRulePlusAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusAssignmentStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:873:2: (iv_rulePlusAssignmentStatement= rulePlusAssignmentStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:874:2: iv_rulePlusAssignmentStatement= rulePlusAssignmentStatement EOF
            {
             newCompositeNode(grammarAccess.getPlusAssignmentStatementRule()); 
            pushFollow(FOLLOW_rulePlusAssignmentStatement_in_entryRulePlusAssignmentStatement1839);
            iv_rulePlusAssignmentStatement=rulePlusAssignmentStatement();

            state._fsp--;

             current =iv_rulePlusAssignmentStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlusAssignmentStatement1849); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusAssignmentStatement"


    // $ANTLR start "rulePlusAssignmentStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:881:1: rulePlusAssignmentStatement returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '+=' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject rulePlusAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:884:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '+=' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '+=' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '+=' ( (lv_expression_3_0= ruleExpression ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '+=' ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:886:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPlusAssignmentStatementAccess().getPlusAssignmentAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:891:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:892:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:892:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:893:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPlusAssignmentStatementRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePlusAssignmentStatement1903); 

            		newLeafNode(otherlv_1, grammarAccess.getPlusAssignmentStatementAccess().getVarAbstractVarOrArgumentCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_27_in_rulePlusAssignmentStatement1915); 

                	newLeafNode(otherlv_2, grammarAccess.getPlusAssignmentStatementAccess().getPlusSignEqualsSignKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:908:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:909:1: (lv_expression_3_0= ruleExpression )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:909:1: (lv_expression_3_0= ruleExpression )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:910:3: lv_expression_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getPlusAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_rulePlusAssignmentStatement1936);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPlusAssignmentStatementRule());
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
    // $ANTLR end "rulePlusAssignmentStatement"


    // $ANTLR start "entryRuleReferenceAssignmentStatement"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:934:1: entryRuleReferenceAssignmentStatement returns [EObject current=null] : iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF ;
    public final EObject entryRuleReferenceAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAssignmentStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:935:2: (iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:936:2: iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF
            {
             newCompositeNode(grammarAccess.getReferenceAssignmentStatementRule()); 
            pushFollow(FOLLOW_ruleReferenceAssignmentStatement_in_entryRuleReferenceAssignmentStatement1972);
            iv_ruleReferenceAssignmentStatement=ruleReferenceAssignmentStatement();

            state._fsp--;

             current =iv_ruleReferenceAssignmentStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceAssignmentStatement1982); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:943:1: ruleReferenceAssignmentStatement returns [EObject current=null] : ( () ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleReferenceAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_assignmentRef_1_1 = null;

        EObject lv_assignmentRef_1_2 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:946:28: ( ( () ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:947:1: ( () ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:947:1: ( () ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:947:2: () ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:947:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:948:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignmentAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:953:2: ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:954:1: ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:954:1: ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:955:1: (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:955:1: (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==50) ) {
                alt14=1;
            }
            else if ( (LA14_0==48) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:956:3: lv_assignmentRef_1_1= ruleContextRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceAssignmentStatementAccess().getAssignmentRefContextRefParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleContextRef_in_ruleReferenceAssignmentStatement2039);
                    lv_assignmentRef_1_1=ruleContextRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceAssignmentStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"assignmentRef",
                            		lv_assignmentRef_1_1, 
                            		"ContextRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:971:8: lv_assignmentRef_1_2= ruleNodeTypeRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceAssignmentStatementAccess().getAssignmentRefNodeTypeRefParserRuleCall_1_0_1()); 
                    	    
                    pushFollow(FOLLOW_ruleNodeTypeRef_in_ruleReferenceAssignmentStatement2058);
                    lv_assignmentRef_1_2=ruleNodeTypeRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceAssignmentStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"assignmentRef",
                            		lv_assignmentRef_1_2, 
                            		"NodeTypeRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleReferenceAssignmentStatement2073); 

                	newLeafNode(otherlv_2, grammarAccess.getReferenceAssignmentStatementAccess().getEqualsSignKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:993:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:994:1: (lv_expression_3_0= ruleExpression )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:994:1: (lv_expression_3_0= ruleExpression )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:995:3: lv_expression_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleReferenceAssignmentStatement2094);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


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
    // $ANTLR end "ruleReferenceAssignmentStatement"


    // $ANTLR start "entryRuleExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1019:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1020:2: (iv_ruleExpression= ruleExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1021:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression2130);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression2140); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1028:1: ruleExpression returns [EObject current=null] : this_Logical_0= ruleLogical ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Logical_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1031:28: (this_Logical_0= ruleLogical )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1033:5: this_Logical_0= ruleLogical
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getLogicalParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleLogical_in_ruleExpression2186);
            this_Logical_0=ruleLogical();

            state._fsp--;

             
                    current = this_Logical_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLogical"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1049:1: entryRuleLogical returns [EObject current=null] : iv_ruleLogical= ruleLogical EOF ;
    public final EObject entryRuleLogical() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogical = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1050:2: (iv_ruleLogical= ruleLogical EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1051:2: iv_ruleLogical= ruleLogical EOF
            {
             newCompositeNode(grammarAccess.getLogicalRule()); 
            pushFollow(FOLLOW_ruleLogical_in_entryRuleLogical2220);
            iv_ruleLogical=ruleLogical();

            state._fsp--;

             current =iv_ruleLogical; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogical2230); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1058:1: ruleLogical returns [EObject current=null] : (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* ) ;
    public final EObject ruleLogical() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Equality_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1061:28: ( (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1062:1: (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1062:1: (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1063:5: this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getLogicalAccess().getEqualityParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleEquality_in_ruleLogical2277);
            this_Equality_0=ruleEquality();

            state._fsp--;

             
                    current = this_Equality_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:1: ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=28 && LA16_0<=29)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:2: ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:2: ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) )
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==28) ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0==29) ) {
            	        alt15=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 15, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:3: ( () otherlv_2= '&&' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:3: ( () otherlv_2= '&&' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:4: () otherlv_2= '&&'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1072:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleLogical2300); 

            	                	newLeafNode(otherlv_2, grammarAccess.getLogicalAccess().getAmpersandAmpersandKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1082:6: ( () otherlv_4= '||' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1082:6: ( () otherlv_4= '||' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1082:7: () otherlv_4= '||'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1082:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1083:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleLogical2329); 

            	                	newLeafNode(otherlv_4, grammarAccess.getLogicalAccess().getVerticalLineVerticalLineKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1092:3: ( (lv_right_5_0= ruleEquality ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1093:1: (lv_right_5_0= ruleEquality )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1093:1: (lv_right_5_0= ruleEquality )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1094:3: lv_right_5_0= ruleEquality
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalAccess().getRightEqualityParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEquality_in_ruleLogical2352);
            	    lv_right_5_0=ruleEquality();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop16;
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
    // $ANTLR end "ruleLogical"


    // $ANTLR start "entryRuleEquality"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1118:1: entryRuleEquality returns [EObject current=null] : iv_ruleEquality= ruleEquality EOF ;
    public final EObject entryRuleEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquality = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1119:2: (iv_ruleEquality= ruleEquality EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1120:2: iv_ruleEquality= ruleEquality EOF
            {
             newCompositeNode(grammarAccess.getEqualityRule()); 
            pushFollow(FOLLOW_ruleEquality_in_entryRuleEquality2390);
            iv_ruleEquality=ruleEquality();

            state._fsp--;

             current =iv_ruleEquality; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquality2400); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1127:1: ruleEquality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEquality() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1130:28: ( (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1131:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1131:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1132:5: this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleComparison_in_ruleEquality2447);
            this_Comparison_0=ruleComparison();

            state._fsp--;

             
                    current = this_Comparison_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:1: ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=30 && LA18_0<=31)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:2: ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:2: ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) )
            	    int alt17=2;
            	    int LA17_0 = input.LA(1);

            	    if ( (LA17_0==30) ) {
            	        alt17=1;
            	    }
            	    else if ( (LA17_0==31) ) {
            	        alt17=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 17, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt17) {
            	        case 1 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:3: ( () otherlv_2= '==' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:3: ( () otherlv_2= '==' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:4: () otherlv_2= '=='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1141:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleEquality2470); 

            	                	newLeafNode(otherlv_2, grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1151:6: ( () otherlv_4= '!=' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1151:6: ( () otherlv_4= '!=' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1151:7: () otherlv_4= '!='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1151:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1152:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleEquality2499); 

            	                	newLeafNode(otherlv_4, grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1161:3: ( (lv_right_5_0= ruleComparison ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1162:1: (lv_right_5_0= ruleComparison )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1162:1: (lv_right_5_0= ruleComparison )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1163:3: lv_right_5_0= ruleComparison
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComparison_in_ruleEquality2522);
            	    lv_right_5_0=ruleComparison();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop18;
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
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleComparison"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1187:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1188:2: (iv_ruleComparison= ruleComparison EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1189:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison2560);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison2570); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1196:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* ) ;
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
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1199:28: ( (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1200:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1200:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1201:5: this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleComparison2617);
            this_Addition_0=ruleAddition();

            state._fsp--;

             
                    current = this_Addition_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1209:1: ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=32 && LA20_0<=35)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1209:2: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1209:2: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) )
            	    int alt19=4;
            	    switch ( input.LA(1) ) {
            	    case 32:
            	        {
            	        alt19=1;
            	        }
            	        break;
            	    case 33:
            	        {
            	        alt19=2;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt19=3;
            	        }
            	        break;
            	    case 35:
            	        {
            	        alt19=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt19) {
            	        case 1 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1209:3: ( () otherlv_2= '<' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1209:3: ( () otherlv_2= '<' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1209:4: () otherlv_2= '<'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1209:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1210:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleComparison2640); 

            	                	newLeafNode(otherlv_2, grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1220:6: ( () otherlv_4= '<=' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1220:6: ( () otherlv_4= '<=' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1220:7: () otherlv_4= '<='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1220:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1221:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleComparison2669); 

            	                	newLeafNode(otherlv_4, grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:6: ( () otherlv_6= '>' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:6: ( () otherlv_6= '>' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:7: () otherlv_6= '>'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1232:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0(),
            	                        current);
            	                

            	            }

            	            otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleComparison2698); 

            	                	newLeafNode(otherlv_6, grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1());
            	                

            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1242:6: ( () otherlv_8= '>=' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1242:6: ( () otherlv_8= '>=' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1242:7: () otherlv_8= '>='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1242:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1243:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0(),
            	                        current);
            	                

            	            }

            	            otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleComparison2727); 

            	                	newLeafNode(otherlv_8, grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_3_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1252:3: ( (lv_right_9_0= ruleAddition ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1253:1: (lv_right_9_0= ruleAddition )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1253:1: (lv_right_9_0= ruleAddition )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1254:3: lv_right_9_0= ruleAddition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAddition_in_ruleComparison2750);
            	    lv_right_9_0=ruleAddition();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop20;
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
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleAddition"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1278:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1279:2: (iv_ruleAddition= ruleAddition EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1280:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition2788);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition2798); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1287:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1290:28: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1291:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1291:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1292:5: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition2845);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;

             
                    current = this_Multiplication_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:1: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=36 && LA22_0<=37)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt21=2;
            	    int LA21_0 = input.LA(1);

            	    if ( (LA21_0==36) ) {
            	        alt21=1;
            	    }
            	    else if ( (LA21_0==37) ) {
            	        alt21=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 21, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt21) {
            	        case 1 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:3: ( () otherlv_2= '+' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:3: ( () otherlv_2= '+' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:4: () otherlv_2= '+'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1301:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,36,FOLLOW_36_in_ruleAddition2868); 

            	                	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1311:6: ( () otherlv_4= '-' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1311:6: ( () otherlv_4= '-' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1311:7: () otherlv_4= '-'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1311:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1312:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,37,FOLLOW_37_in_ruleAddition2897); 

            	                	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1321:3: ( (lv_right_5_0= ruleMultiplication ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1322:1: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1322:1: (lv_right_5_0= ruleMultiplication )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1323:3: lv_right_5_0= ruleMultiplication
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition2920);
            	    lv_right_5_0=ruleMultiplication();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop22;
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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1347:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1348:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1349:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication2958);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication2968); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1356:1: ruleMultiplication returns [EObject current=null] : (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_Unary_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1359:28: ( (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1360:1: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1360:1: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1361:5: this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleUnary_in_ruleMultiplication3015);
            this_Unary_0=ruleUnary();

            state._fsp--;

             
                    current = this_Unary_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1369:1: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=38 && LA24_0<=40)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1369:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1369:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) )
            	    int alt23=3;
            	    switch ( input.LA(1) ) {
            	    case 38:
            	        {
            	        alt23=1;
            	        }
            	        break;
            	    case 39:
            	        {
            	        alt23=2;
            	        }
            	        break;
            	    case 40:
            	        {
            	        alt23=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 23, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt23) {
            	        case 1 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1369:3: ( () otherlv_2= '*' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1369:3: ( () otherlv_2= '*' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1369:4: () otherlv_2= '*'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1369:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1370:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleMultiplication3038); 

            	                	newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:6: ( () otherlv_4= '/' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:6: ( () otherlv_4= '/' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:7: () otherlv_4= '/'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1381:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleMultiplication3067); 

            	                	newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1391:6: ( () otherlv_6= '%' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1391:6: ( () otherlv_6= '%' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1391:7: () otherlv_6= '%'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1391:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1392:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0(),
            	                        current);
            	                

            	            }

            	            otherlv_6=(Token)match(input,40,FOLLOW_40_in_ruleMultiplication3096); 

            	                	newLeafNode(otherlv_6, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1401:3: ( (lv_right_7_0= ruleUnary ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1402:1: (lv_right_7_0= ruleUnary )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1402:1: (lv_right_7_0= ruleUnary )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1403:3: lv_right_7_0= ruleUnary
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnary_in_ruleMultiplication3119);
            	    lv_right_7_0=ruleUnary();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop24;
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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleUnary"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1427:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1428:2: (iv_ruleUnary= ruleUnary EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1429:2: iv_ruleUnary= ruleUnary EOF
            {
             newCompositeNode(grammarAccess.getUnaryRule()); 
            pushFollow(FOLLOW_ruleUnary_in_entryRuleUnary3157);
            iv_ruleUnary=ruleUnary();

            state._fsp--;

             current =iv_ruleUnary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnary3167); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1436:1: ruleUnary returns [EObject current=null] : (this_NativeExpression_0= ruleNativeExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_NativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_op_4_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1439:28: ( (this_NativeExpression_0= ruleNativeExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1440:1: (this_NativeExpression_0= ruleNativeExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1440:1: (this_NativeExpression_0= ruleNativeExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID||LA26_0==RULE_NUMBER||LA26_0==15||(LA26_0>=43 && LA26_0<=45)||(LA26_0>=47 && LA26_0<=50)) ) {
                alt26=1;
            }
            else if ( ((LA26_0>=36 && LA26_0<=37)||LA26_0==41) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1441:5: this_NativeExpression_0= ruleNativeExpression
                    {
                     
                            newCompositeNode(grammarAccess.getUnaryAccess().getNativeExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNativeExpression_in_ruleUnary3214);
                    this_NativeExpression_0=ruleNativeExpression();

                    state._fsp--;

                     
                            current = this_NativeExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1450:6: ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1450:6: ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1450:7: ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1450:7: ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==41) ) {
                        alt25=1;
                    }
                    else if ( ((LA25_0>=36 && LA25_0<=37)) ) {
                        alt25=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1450:8: ( () ( (lv_op_2_0= '!' ) ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1450:8: ( () ( (lv_op_2_0= '!' ) ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1450:9: () ( (lv_op_2_0= '!' ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1450:9: ()
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1451:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getUnaryAccess().getNegationAction_1_0_0_0(),
                                        current);
                                

                            }

                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1456:2: ( (lv_op_2_0= '!' ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1457:1: (lv_op_2_0= '!' )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1457:1: (lv_op_2_0= '!' )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1458:3: lv_op_2_0= '!'
                            {
                            lv_op_2_0=(Token)match(input,41,FOLLOW_41_in_ruleUnary3249); 

                                    newLeafNode(lv_op_2_0, grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_0_0_1_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getUnaryRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_2_0, "!");
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1472:6: ( () ( (lv_op_4_0= ruleUnaryOperator ) ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1472:6: ( () ( (lv_op_4_0= ruleUnaryOperator ) ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1472:7: () ( (lv_op_4_0= ruleUnaryOperator ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1472:7: ()
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1473:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getUnaryAccess().getUnaryPlusMinusAction_1_0_1_0(),
                                        current);
                                

                            }

                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1478:2: ( (lv_op_4_0= ruleUnaryOperator ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1479:1: (lv_op_4_0= ruleUnaryOperator )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1479:1: (lv_op_4_0= ruleUnaryOperator )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1480:3: lv_op_4_0= ruleUnaryOperator
                            {
                             
                            	        newCompositeNode(grammarAccess.getUnaryAccess().getOpUnaryOperatorParserRuleCall_1_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnary3300);
                            lv_op_4_0=ruleUnaryOperator();

                            state._fsp--;


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
                            break;

                    }

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1496:4: ( (lv_right_5_0= ruleUnary ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1497:1: (lv_right_5_0= ruleUnary )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1497:1: (lv_right_5_0= ruleUnary )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1498:3: lv_right_5_0= ruleUnary
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryAccess().getRightUnaryParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnary_in_ruleUnary3323);
                    lv_right_5_0=ruleUnary();

                    state._fsp--;


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
    // $ANTLR end "ruleUnary"


    // $ANTLR start "entryRuleUnaryOperator"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1522:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1523:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1524:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
             newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator3361);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;

             current =iv_ruleUnaryOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator3372); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1531:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1534:28: ( (kw= '-' | kw= '+' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1535:1: (kw= '-' | kw= '+' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1535:1: (kw= '-' | kw= '+' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==37) ) {
                alt27=1;
            }
            else if ( (LA27_0==36) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1536:2: kw= '-'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleUnaryOperator3410); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1543:2: kw= '+'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleUnaryOperator3429); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getPlusSignKeyword_1()); 
                        

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
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRuleNativeExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1556:1: entryRuleNativeExpression returns [EObject current=null] : iv_ruleNativeExpression= ruleNativeExpression EOF ;
    public final EObject entryRuleNativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNativeExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1557:2: (iv_ruleNativeExpression= ruleNativeExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1558:2: iv_ruleNativeExpression= ruleNativeExpression EOF
            {
             newCompositeNode(grammarAccess.getNativeExpressionRule()); 
            pushFollow(FOLLOW_ruleNativeExpression_in_entryRuleNativeExpression3469);
            iv_ruleNativeExpression=ruleNativeExpression();

            state._fsp--;

             current =iv_ruleNativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNativeExpression3479); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1565:1: ruleNativeExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '.' ( (lv_nativeFunction_3_0= ruleNativeFunction ) ) )* ) ;
    public final EObject ruleNativeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_nativeFunction_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1568:28: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '.' ( (lv_nativeFunction_3_0= ruleNativeFunction ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1569:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '.' ( (lv_nativeFunction_3_0= ruleNativeFunction ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1569:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '.' ( (lv_nativeFunction_3_0= ruleNativeFunction ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1570:5: this_PrimaryExpression_0= rulePrimaryExpression ( () otherlv_2= '.' ( (lv_nativeFunction_3_0= ruleNativeFunction ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getNativeExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNativeExpression3526);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;

             
                    current = this_PrimaryExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1578:1: ( () otherlv_2= '.' ( (lv_nativeFunction_3_0= ruleNativeFunction ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==42) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1578:2: () otherlv_2= '.' ( (lv_nativeFunction_3_0= ruleNativeFunction ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1578:2: ()
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1579:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getNativeExpressionAccess().getNativeExpressionLeftAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,42,FOLLOW_42_in_ruleNativeExpression3547); 

            	        	newLeafNode(otherlv_2, grammarAccess.getNativeExpressionAccess().getFullStopKeyword_1_1());
            	        
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1588:1: ( (lv_nativeFunction_3_0= ruleNativeFunction ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1589:1: (lv_nativeFunction_3_0= ruleNativeFunction )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1589:1: (lv_nativeFunction_3_0= ruleNativeFunction )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1590:3: lv_nativeFunction_3_0= ruleNativeFunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNativeExpressionAccess().getNativeFunctionNativeFunctionEnumRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNativeFunction_in_ruleNativeExpression3568);
            	    lv_nativeFunction_3_0=ruleNativeFunction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNativeExpressionRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"nativeFunction",
            	            		lv_nativeFunction_3_0, 
            	            		"NativeFunction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // $ANTLR end "ruleNativeExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1614:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1615:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1616:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3606);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression3616); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1623:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_RangeLiteral_1= ruleRangeLiteral | this_Reference_2= ruleReference | this_FunctionCall_3= ruleFunctionCall | this_IndexedCall_4= ruleIndexedCall | this_ParenthesizedExpression_5= ruleParenthesizedExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_RangeLiteral_1 = null;

        EObject this_Reference_2 = null;

        EObject this_FunctionCall_3 = null;

        EObject this_IndexedCall_4 = null;

        EObject this_ParenthesizedExpression_5 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1626:28: ( (this_Literal_0= ruleLiteral | this_RangeLiteral_1= ruleRangeLiteral | this_Reference_2= ruleReference | this_FunctionCall_3= ruleFunctionCall | this_IndexedCall_4= ruleIndexedCall | this_ParenthesizedExpression_5= ruleParenthesizedExpression ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1627:1: (this_Literal_0= ruleLiteral | this_RangeLiteral_1= ruleRangeLiteral | this_Reference_2= ruleReference | this_FunctionCall_3= ruleFunctionCall | this_IndexedCall_4= ruleIndexedCall | this_ParenthesizedExpression_5= ruleParenthesizedExpression )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1627:1: (this_Literal_0= ruleLiteral | this_RangeLiteral_1= ruleRangeLiteral | this_Reference_2= ruleReference | this_FunctionCall_3= ruleFunctionCall | this_IndexedCall_4= ruleIndexedCall | this_ParenthesizedExpression_5= ruleParenthesizedExpression )
            int alt29=6;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
            case 43:
            case 44:
                {
                alt29=1;
                }
                break;
            case 45:
                {
                alt29=2;
                }
                break;
            case 47:
            case 48:
            case 49:
            case 50:
                {
                alt29=3;
                }
                break;
            case RULE_ID:
                {
                int LA29_4 = input.LA(2);

                if ( (LA29_4==EOF||(LA29_4>=16 && LA29_4<=17)||LA29_4==20||(LA29_4>=28 && LA29_4<=40)||LA29_4==42||(LA29_4>=45 && LA29_4<=46)) ) {
                    alt29=5;
                }
                else if ( (LA29_4==15) ) {
                    alt29=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 4, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                alt29=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1628:5: this_Literal_0= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression3663);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1638:5: this_RangeLiteral_1= ruleRangeLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRangeLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRangeLiteral_in_rulePrimaryExpression3690);
                    this_RangeLiteral_1=ruleRangeLiteral();

                    state._fsp--;

                     
                            current = this_RangeLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1648:5: this_Reference_2= ruleReference
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getReferenceParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleReference_in_rulePrimaryExpression3717);
                    this_Reference_2=ruleReference();

                    state._fsp--;

                     
                            current = this_Reference_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1658:5: this_FunctionCall_3= ruleFunctionCall
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleFunctionCall_in_rulePrimaryExpression3744);
                    this_FunctionCall_3=ruleFunctionCall();

                    state._fsp--;

                     
                            current = this_FunctionCall_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1668:5: this_IndexedCall_4= ruleIndexedCall
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIndexedCallParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleIndexedCall_in_rulePrimaryExpression3771);
                    this_IndexedCall_4=ruleIndexedCall();

                    state._fsp--;

                     
                            current = this_IndexedCall_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1678:5: this_ParenthesizedExpression_5= ruleParenthesizedExpression
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3798);
                    this_ParenthesizedExpression_5=ruleParenthesizedExpression();

                    state._fsp--;

                     
                            current = this_ParenthesizedExpression_5; 
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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleLiteral"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1694:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1695:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1696:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3833);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3843); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1703:1: ruleLiteral returns [EObject current=null] : (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_condition_2_0=null;
        Token otherlv_3=null;
        EObject this_NumberLiteral_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1706:28: ( (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1707:1: (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1707:1: (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_NUMBER) ) {
                alt31=1;
            }
            else if ( ((LA31_0>=43 && LA31_0<=44)) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1708:5: this_NumberLiteral_0= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral3890);
                    this_NumberLiteral_0=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1717:6: ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1717:6: ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1717:7: () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1717:7: ()
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1718:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getLiteralAccess().getBooleanLiteralAction_1_0(),
                                current);
                        

                    }

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1723:2: ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==43) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==44) ) {
                        alt30=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1723:3: ( (lv_condition_2_0= 'true' ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1723:3: ( (lv_condition_2_0= 'true' ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1724:1: (lv_condition_2_0= 'true' )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1724:1: (lv_condition_2_0= 'true' )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1725:3: lv_condition_2_0= 'true'
                            {
                            lv_condition_2_0=(Token)match(input,43,FOLLOW_43_in_ruleLiteral3924); 

                                    newLeafNode(lv_condition_2_0, grammarAccess.getLiteralAccess().getConditionTrueKeyword_1_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getLiteralRule());
                            	        }
                                   		setWithLastConsumed(current, "condition", true, "true");
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1739:7: otherlv_3= 'false'
                            {
                            otherlv_3=(Token)match(input,44,FOLLOW_44_in_ruleLiteral3955); 

                                	newLeafNode(otherlv_3, grammarAccess.getLiteralAccess().getFalseKeyword_1_1_1());
                                

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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleNumberLiteral"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1751:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1752:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1753:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral3993);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral4003); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1760:1: ruleNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1763:28: ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1764:1: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1764:1: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1764:2: () ( (lv_value_1_0= RULE_NUMBER ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1764:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1765:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNumberLiteralAccess().getNumberLiteralAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1770:2: ( (lv_value_1_0= RULE_NUMBER ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1771:1: (lv_value_1_0= RULE_NUMBER )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1771:1: (lv_value_1_0= RULE_NUMBER )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1772:3: lv_value_1_0= RULE_NUMBER
            {
            lv_value_1_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumberLiteral4054); 

            			newLeafNode(lv_value_1_0, grammarAccess.getNumberLiteralAccess().getValueNUMBERTerminalRuleCall_1_0()); 
            		

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
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleRangeLiteral"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1796:1: entryRuleRangeLiteral returns [EObject current=null] : iv_ruleRangeLiteral= ruleRangeLiteral EOF ;
    public final EObject entryRuleRangeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeLiteral = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1797:2: (iv_ruleRangeLiteral= ruleRangeLiteral EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1798:2: iv_ruleRangeLiteral= ruleRangeLiteral EOF
            {
             newCompositeNode(grammarAccess.getRangeLiteralRule()); 
            pushFollow(FOLLOW_ruleRangeLiteral_in_entryRuleRangeLiteral4095);
            iv_ruleRangeLiteral=ruleRangeLiteral();

            state._fsp--;

             current =iv_ruleRangeLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeLiteral4105); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1805:1: ruleRangeLiteral returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleRangeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_values_2_0=null;
        Token otherlv_3=null;
        Token lv_values_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1808:28: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )? otherlv_5= ']' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1809:1: ( () otherlv_1= '[' ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )? otherlv_5= ']' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1809:1: ( () otherlv_1= '[' ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )? otherlv_5= ']' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1809:2: () otherlv_1= '[' ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )? otherlv_5= ']'
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1809:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1810:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRangeLiteralAccess().getRangeLiteralAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleRangeLiteral4151); 

                	newLeafNode(otherlv_1, grammarAccess.getRangeLiteralAccess().getLeftSquareBracketKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1819:1: ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_NUMBER) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1819:2: ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )*
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1819:2: ( (lv_values_2_0= RULE_NUMBER ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1820:1: (lv_values_2_0= RULE_NUMBER )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1820:1: (lv_values_2_0= RULE_NUMBER )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1821:3: lv_values_2_0= RULE_NUMBER
                    {
                    lv_values_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4169); 

                    			newLeafNode(lv_values_2_0, grammarAccess.getRangeLiteralAccess().getValuesNUMBERTerminalRuleCall_2_0_0()); 
                    		

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

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1837:2: (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==16) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1837:4: otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleRangeLiteral4187); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getRangeLiteralAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1841:1: ( (lv_values_4_0= RULE_NUMBER ) )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1842:1: (lv_values_4_0= RULE_NUMBER )
                    	    {
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1842:1: (lv_values_4_0= RULE_NUMBER )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1843:3: lv_values_4_0= RULE_NUMBER
                    	    {
                    	    lv_values_4_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4204); 

                    	    			newLeafNode(lv_values_4_0, grammarAccess.getRangeLiteralAccess().getValuesNUMBERTerminalRuleCall_2_1_1_0()); 
                    	    		

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
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,46,FOLLOW_46_in_ruleRangeLiteral4225); 

                	newLeafNode(otherlv_5, grammarAccess.getRangeLiteralAccess().getRightSquareBracketKeyword_3());
                

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
    // $ANTLR end "ruleRangeLiteral"


    // $ANTLR start "entryRuleFunctionCall"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1871:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1872:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1873:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall4261);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionCall4271); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1880:1: ruleFunctionCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
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
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1883:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1884:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1884:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1884:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1884:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1885:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionCallAccess().getFunctionCallAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1890:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1891:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1891:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1892:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionCall4325); 

            		newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleFunctionCall4337); 

                	newLeafNode(otherlv_2, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1907:1: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID||LA35_0==RULE_NUMBER||LA35_0==15||(LA35_0>=36 && LA35_0<=37)||LA35_0==41||(LA35_0>=43 && LA35_0<=45)||(LA35_0>=47 && LA35_0<=50)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1907:2: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1907:2: ( (lv_args_3_0= ruleExpression ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1908:1: (lv_args_3_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1908:1: (lv_args_3_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1909:3: lv_args_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionCall4359);
                    lv_args_3_0=ruleExpression();

                    state._fsp--;


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

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1925:2: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==16) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1925:4: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleFunctionCall4372); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1929:1: ( (lv_args_5_0= ruleExpression ) )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1930:1: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1930:1: (lv_args_5_0= ruleExpression )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1931:3: lv_args_5_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionCall4393);
                    	    lv_args_5_0=ruleExpression();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleFunctionCall4409); 

                	newLeafNode(otherlv_6, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4());
                

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
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleIndexedCall"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1959:1: entryRuleIndexedCall returns [EObject current=null] : iv_ruleIndexedCall= ruleIndexedCall EOF ;
    public final EObject entryRuleIndexedCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexedCall = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1960:2: (iv_ruleIndexedCall= ruleIndexedCall EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1961:2: iv_ruleIndexedCall= ruleIndexedCall EOF
            {
             newCompositeNode(grammarAccess.getIndexedCallRule()); 
            pushFollow(FOLLOW_ruleIndexedCall_in_entryRuleIndexedCall4445);
            iv_ruleIndexedCall=ruleIndexedCall();

            state._fsp--;

             current =iv_ruleIndexedCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndexedCall4455); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1968:1: ruleIndexedCall returns [EObject current=null] : (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? ) ;
    public final EObject ruleIndexedCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_VarOrArgumentCall_0 = null;

        EObject lv_index_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1971:28: ( (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1972:1: (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1972:1: (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1973:5: this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )?
            {
             
                    newCompositeNode(grammarAccess.getIndexedCallAccess().getVarOrArgumentCallParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleVarOrArgumentCall_in_ruleIndexedCall4502);
            this_VarOrArgumentCall_0=ruleVarOrArgumentCall();

            state._fsp--;

             
                    current = this_VarOrArgumentCall_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1981:1: (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==45) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1981:3: otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleIndexedCall4514); 

                        	newLeafNode(otherlv_1, grammarAccess.getIndexedCallAccess().getLeftSquareBracketKeyword_1_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1985:1: ( (lv_index_2_0= ruleExpression ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1986:1: (lv_index_2_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1986:1: (lv_index_2_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1987:3: lv_index_2_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getIndexedCallAccess().getIndexExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleIndexedCall4535);
                    lv_index_2_0=ruleExpression();

                    state._fsp--;


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

                    otherlv_3=(Token)match(input,46,FOLLOW_46_in_ruleIndexedCall4547); 

                        	newLeafNode(otherlv_3, grammarAccess.getIndexedCallAccess().getRightSquareBracketKeyword_1_2());
                        

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
    // $ANTLR end "ruleIndexedCall"


    // $ANTLR start "entryRuleVarOrArgumentCall"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2015:1: entryRuleVarOrArgumentCall returns [EObject current=null] : iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF ;
    public final EObject entryRuleVarOrArgumentCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarOrArgumentCall = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2016:2: (iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2017:2: iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF
            {
             newCompositeNode(grammarAccess.getVarOrArgumentCallRule()); 
            pushFollow(FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall4585);
            iv_ruleVarOrArgumentCall=ruleVarOrArgumentCall();

            state._fsp--;

             current =iv_ruleVarOrArgumentCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarOrArgumentCall4595); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2024:1: ruleVarOrArgumentCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleVarOrArgumentCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2027:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2028:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2028:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2028:2: () ( (otherlv_1= RULE_ID ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2028:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2029:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVarOrArgumentCallAccess().getVarOrArgumentCallAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2034:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2035:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2035:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2036:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVarOrArgumentCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarOrArgumentCall4649); 

            		newLeafNode(otherlv_1, grammarAccess.getVarOrArgumentCallAccess().getCallAbstractVarOrArgumentCrossReference_1_0()); 
            	

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
    // $ANTLR end "ruleVarOrArgumentCall"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2055:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2056:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2057:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression4685);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression4695); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2064:1: ruleParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2067:28: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2068:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2068:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2068:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleParenthesizedExpression4732); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression4754);
            this_Expression_1=ruleExpression();

            state._fsp--;

             
                    current = this_Expression_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleParenthesizedExpression4765); 

                	newLeafNode(otherlv_2, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                

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
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleReference"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2093:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2094:2: (iv_ruleReference= ruleReference EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2095:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference4801);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference4811); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2102:1: ruleReference returns [EObject current=null] : (this_ContextRef_0= ruleContextRef | this_NodeTypeRef_1= ruleNodeTypeRef | this_NodeRef_2= ruleNodeRef | this_ParamRef_3= ruleParamRef ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        EObject this_ContextRef_0 = null;

        EObject this_NodeTypeRef_1 = null;

        EObject this_NodeRef_2 = null;

        EObject this_ParamRef_3 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2105:28: ( (this_ContextRef_0= ruleContextRef | this_NodeTypeRef_1= ruleNodeTypeRef | this_NodeRef_2= ruleNodeRef | this_ParamRef_3= ruleParamRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2106:1: (this_ContextRef_0= ruleContextRef | this_NodeTypeRef_1= ruleNodeTypeRef | this_NodeRef_2= ruleNodeRef | this_ParamRef_3= ruleParamRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2106:1: (this_ContextRef_0= ruleContextRef | this_NodeTypeRef_1= ruleNodeTypeRef | this_NodeRef_2= ruleNodeRef | this_ParamRef_3= ruleParamRef )
            int alt37=4;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt37=1;
                }
                break;
            case 48:
                {
                alt37=2;
                }
                break;
            case 49:
                {
                alt37=3;
                }
                break;
            case 47:
                {
                alt37=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2107:5: this_ContextRef_0= ruleContextRef
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceAccess().getContextRefParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleContextRef_in_ruleReference4858);
                    this_ContextRef_0=ruleContextRef();

                    state._fsp--;

                     
                            current = this_ContextRef_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2117:5: this_NodeTypeRef_1= ruleNodeTypeRef
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceAccess().getNodeTypeRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNodeTypeRef_in_ruleReference4885);
                    this_NodeTypeRef_1=ruleNodeTypeRef();

                    state._fsp--;

                     
                            current = this_NodeTypeRef_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2127:5: this_NodeRef_2= ruleNodeRef
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceAccess().getNodeRefParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleNodeRef_in_ruleReference4912);
                    this_NodeRef_2=ruleNodeRef();

                    state._fsp--;

                     
                            current = this_NodeRef_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2137:5: this_ParamRef_3= ruleParamRef
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceAccess().getParamRefParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleParamRef_in_ruleReference4939);
                    this_ParamRef_3=ruleParamRef();

                    state._fsp--;

                     
                            current = this_ParamRef_3; 
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
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleParamRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2153:1: entryRuleParamRef returns [EObject current=null] : iv_ruleParamRef= ruleParamRef EOF ;
    public final EObject entryRuleParamRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2154:2: (iv_ruleParamRef= ruleParamRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2155:2: iv_ruleParamRef= ruleParamRef EOF
            {
             newCompositeNode(grammarAccess.getParamRefRule()); 
            pushFollow(FOLLOW_ruleParamRef_in_entryRuleParamRef4974);
            iv_ruleParamRef=ruleParamRef();

            state._fsp--;

             current =iv_ruleParamRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamRef4984); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParamRef"


    // $ANTLR start "ruleParamRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2162:1: ruleParamRef returns [EObject current=null] : ( () otherlv_1= 'PARAM' ( ( ruleFQN ) ) ) ;
    public final EObject ruleParamRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2165:28: ( ( () otherlv_1= 'PARAM' ( ( ruleFQN ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2166:1: ( () otherlv_1= 'PARAM' ( ( ruleFQN ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2166:1: ( () otherlv_1= 'PARAM' ( ( ruleFQN ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2166:2: () otherlv_1= 'PARAM' ( ( ruleFQN ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2166:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2167:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParamRefAccess().getParamRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleParamRef5030); 

                	newLeafNode(otherlv_1, grammarAccess.getParamRefAccess().getPARAMKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2176:1: ( ( ruleFQN ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2177:1: ( ruleFQN )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2177:1: ( ruleFQN )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2178:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getParamRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getParamRefAccess().getParamParameterCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleParamRef5053);
            ruleFQN();

            state._fsp--;

             
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
    // $ANTLR end "ruleParamRef"


    // $ANTLR start "entryRuleNodeTypeRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2199:1: entryRuleNodeTypeRef returns [EObject current=null] : iv_ruleNodeTypeRef= ruleNodeTypeRef EOF ;
    public final EObject entryRuleNodeTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeTypeRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2200:2: (iv_ruleNodeTypeRef= ruleNodeTypeRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2201:2: iv_ruleNodeTypeRef= ruleNodeTypeRef EOF
            {
             newCompositeNode(grammarAccess.getNodeTypeRefRule()); 
            pushFollow(FOLLOW_ruleNodeTypeRef_in_entryRuleNodeTypeRef5089);
            iv_ruleNodeTypeRef=ruleNodeTypeRef();

            state._fsp--;

             current =iv_ruleNodeTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeTypeRef5099); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNodeTypeRef"


    // $ANTLR start "ruleNodeTypeRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2208:1: ruleNodeTypeRef returns [EObject current=null] : ( () otherlv_1= 'NETYPE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) ) ;
    public final EObject ruleNodeTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_primaryRef_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2211:28: ( ( () otherlv_1= 'NETYPE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2212:1: ( () otherlv_1= 'NETYPE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2212:1: ( () otherlv_1= 'NETYPE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2212:2: () otherlv_1= 'NETYPE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2212:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2213:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNodeTypeRefAccess().getNodeTypeRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleNodeTypeRef5145); 

                	newLeafNode(otherlv_1, grammarAccess.getNodeTypeRefAccess().getNETYPEKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2222:1: ( (otherlv_2= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2223:1: (otherlv_2= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2223:1: (otherlv_2= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2224:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeTypeRefRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNodeTypeRef5165); 

            		newLeafNode(otherlv_2, grammarAccess.getNodeTypeRefAccess().getNodetypeNodeTypeCrossReference_2_0()); 
            	

            }


            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2235:2: ( (lv_primaryRef_3_0= rulePrimaryRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2236:1: (lv_primaryRef_3_0= rulePrimaryRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2236:1: (lv_primaryRef_3_0= rulePrimaryRef )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2237:3: lv_primaryRef_3_0= rulePrimaryRef
            {
             
            	        newCompositeNode(grammarAccess.getNodeTypeRefAccess().getPrimaryRefPrimaryRefParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_rulePrimaryRef_in_ruleNodeTypeRef5186);
            lv_primaryRef_3_0=rulePrimaryRef();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNodeTypeRefRule());
            	        }
                   		set(
                   			current, 
                   			"primaryRef",
                    		lv_primaryRef_3_0, 
                    		"PrimaryRef");
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
    // $ANTLR end "ruleNodeTypeRef"


    // $ANTLR start "entryRuleNodeRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2261:1: entryRuleNodeRef returns [EObject current=null] : iv_ruleNodeRef= ruleNodeRef EOF ;
    public final EObject entryRuleNodeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2262:2: (iv_ruleNodeRef= ruleNodeRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2263:2: iv_ruleNodeRef= ruleNodeRef EOF
            {
             newCompositeNode(grammarAccess.getNodeRefRule()); 
            pushFollow(FOLLOW_ruleNodeRef_in_entryRuleNodeRef5222);
            iv_ruleNodeRef=ruleNodeRef();

            state._fsp--;

             current =iv_ruleNodeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeRef5232); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNodeRef"


    // $ANTLR start "ruleNodeRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2270:1: ruleNodeRef returns [EObject current=null] : ( () otherlv_1= 'NE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) ) ;
    public final EObject ruleNodeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_primaryRef_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2273:28: ( ( () otherlv_1= 'NE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2274:1: ( () otherlv_1= 'NE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2274:1: ( () otherlv_1= 'NE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2274:2: () otherlv_1= 'NE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2274:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2275:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNodeRefAccess().getNodeRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleNodeRef5278); 

                	newLeafNode(otherlv_1, grammarAccess.getNodeRefAccess().getNEKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2284:1: ( (otherlv_2= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2285:1: (otherlv_2= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2285:1: (otherlv_2= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2286:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRefRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNodeRef5298); 

            		newLeafNode(otherlv_2, grammarAccess.getNodeRefAccess().getNodeNodeCrossReference_2_0()); 
            	

            }


            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2297:2: ( (lv_primaryRef_3_0= rulePrimaryRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2298:1: (lv_primaryRef_3_0= rulePrimaryRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2298:1: (lv_primaryRef_3_0= rulePrimaryRef )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2299:3: lv_primaryRef_3_0= rulePrimaryRef
            {
             
            	        newCompositeNode(grammarAccess.getNodeRefAccess().getPrimaryRefPrimaryRefParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_rulePrimaryRef_in_ruleNodeRef5319);
            lv_primaryRef_3_0=rulePrimaryRef();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNodeRefRule());
            	        }
                   		set(
                   			current, 
                   			"primaryRef",
                    		lv_primaryRef_3_0, 
                    		"PrimaryRef");
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
    // $ANTLR end "ruleNodeRef"


    // $ANTLR start "entryRuleContextRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2323:1: entryRuleContextRef returns [EObject current=null] : iv_ruleContextRef= ruleContextRef EOF ;
    public final EObject entryRuleContextRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2324:2: (iv_ruleContextRef= ruleContextRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2325:2: iv_ruleContextRef= ruleContextRef EOF
            {
             newCompositeNode(grammarAccess.getContextRefRule()); 
            pushFollow(FOLLOW_ruleContextRef_in_entryRuleContextRef5355);
            iv_ruleContextRef=ruleContextRef();

            state._fsp--;

             current =iv_ruleContextRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextRef5365); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2332:1: ruleContextRef returns [EObject current=null] : ( () otherlv_1= 'this' ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) ) ) ;
    public final EObject ruleContextRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_primaryRef_2_0 = null;

        EObject lv_rangeRef_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2335:28: ( ( () otherlv_1= 'this' ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2336:1: ( () otherlv_1= 'this' ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2336:1: ( () otherlv_1= 'this' ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2336:2: () otherlv_1= 'this' ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2336:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2337:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getContextRefAccess().getContextRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleContextRef5411); 

                	newLeafNode(otherlv_1, grammarAccess.getContextRefAccess().getThisKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2346:1: ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==EOF||(LA38_0>=16 && LA38_0<=17)||LA38_0==20||LA38_0==26||(LA38_0>=28 && LA38_0<=40)||LA38_0==42||LA38_0==46||LA38_0==51) ) {
                alt38=1;
            }
            else if ( ((LA38_0>=76 && LA38_0<=83)) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2346:2: ( (lv_primaryRef_2_0= rulePrimaryRef ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2346:2: ( (lv_primaryRef_2_0= rulePrimaryRef ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2347:1: (lv_primaryRef_2_0= rulePrimaryRef )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2347:1: (lv_primaryRef_2_0= rulePrimaryRef )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2348:3: lv_primaryRef_2_0= rulePrimaryRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getContextRefAccess().getPrimaryRefPrimaryRefParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryRef_in_ruleContextRef5433);
                    lv_primaryRef_2_0=rulePrimaryRef();

                    state._fsp--;


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
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2365:6: ( (lv_rangeRef_3_0= ruleRangeRef ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2365:6: ( (lv_rangeRef_3_0= ruleRangeRef ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2366:1: (lv_rangeRef_3_0= ruleRangeRef )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2366:1: (lv_rangeRef_3_0= ruleRangeRef )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2367:3: lv_rangeRef_3_0= ruleRangeRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getContextRefAccess().getRangeRefRangeRefParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRangeRef_in_ruleContextRef5460);
                    lv_rangeRef_3_0=ruleRangeRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContextRefRule());
                    	        }
                           		set(
                           			current, 
                           			"rangeRef",
                            		lv_rangeRef_3_0, 
                            		"RangeRef");
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
    // $ANTLR end "ruleContextRef"


    // $ANTLR start "entryRulePrimaryRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2391:1: entryRulePrimaryRef returns [EObject current=null] : iv_rulePrimaryRef= rulePrimaryRef EOF ;
    public final EObject entryRulePrimaryRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2392:2: (iv_rulePrimaryRef= rulePrimaryRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2393:2: iv_rulePrimaryRef= rulePrimaryRef EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRefRule()); 
            pushFollow(FOLLOW_rulePrimaryRef_in_entryRulePrimaryRef5497);
            iv_rulePrimaryRef=rulePrimaryRef();

            state._fsp--;

             current =iv_rulePrimaryRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryRef5507); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2400:1: rulePrimaryRef returns [EObject current=null] : ( () ( (lv_navigation_1_0= ruleNavigation ) )? (otherlv_2= '->' ( (lv_leafRef_3_0= ruleLeafReference ) ) )? ) ;
    public final EObject rulePrimaryRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_navigation_1_0 = null;

        EObject lv_leafRef_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2403:28: ( ( () ( (lv_navigation_1_0= ruleNavigation ) )? (otherlv_2= '->' ( (lv_leafRef_3_0= ruleLeafReference ) ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2404:1: ( () ( (lv_navigation_1_0= ruleNavigation ) )? (otherlv_2= '->' ( (lv_leafRef_3_0= ruleLeafReference ) ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2404:1: ( () ( (lv_navigation_1_0= ruleNavigation ) )? (otherlv_2= '->' ( (lv_leafRef_3_0= ruleLeafReference ) ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2404:2: () ( (lv_navigation_1_0= ruleNavigation ) )? (otherlv_2= '->' ( (lv_leafRef_3_0= ruleLeafReference ) ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2404:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2405:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPrimaryRefAccess().getPrimaryRefAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2410:2: ( (lv_navigation_1_0= ruleNavigation ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==42) ) {
                int LA39_1 = input.LA(2);

                if ( ((LA39_1>=52 && LA39_1<=55)) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2411:1: (lv_navigation_1_0= ruleNavigation )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2411:1: (lv_navigation_1_0= ruleNavigation )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2412:3: lv_navigation_1_0= ruleNavigation
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimaryRefAccess().getNavigationNavigationParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNavigation_in_rulePrimaryRef5562);
                    lv_navigation_1_0=ruleNavigation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimaryRefRule());
                    	        }
                           		set(
                           			current, 
                           			"navigation",
                            		lv_navigation_1_0, 
                            		"Navigation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2428:3: (otherlv_2= '->' ( (lv_leafRef_3_0= ruleLeafReference ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==51) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2428:5: otherlv_2= '->' ( (lv_leafRef_3_0= ruleLeafReference ) )
                    {
                    otherlv_2=(Token)match(input,51,FOLLOW_51_in_rulePrimaryRef5576); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrimaryRefAccess().getHyphenMinusGreaterThanSignKeyword_2_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2432:1: ( (lv_leafRef_3_0= ruleLeafReference ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2433:1: (lv_leafRef_3_0= ruleLeafReference )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2433:1: (lv_leafRef_3_0= ruleLeafReference )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2434:3: lv_leafRef_3_0= ruleLeafReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimaryRefAccess().getLeafRefLeafReferenceParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLeafReference_in_rulePrimaryRef5597);
                    lv_leafRef_3_0=ruleLeafReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimaryRefRule());
                    	        }
                           		set(
                           			current, 
                           			"leafRef",
                            		lv_leafRef_3_0, 
                            		"LeafReference");
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
    // $ANTLR end "rulePrimaryRef"


    // $ANTLR start "entryRuleNavigation"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2458:1: entryRuleNavigation returns [EObject current=null] : iv_ruleNavigation= ruleNavigation EOF ;
    public final EObject entryRuleNavigation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigation = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2459:2: (iv_ruleNavigation= ruleNavigation EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2460:2: iv_ruleNavigation= ruleNavigation EOF
            {
             newCompositeNode(grammarAccess.getNavigationRule()); 
            pushFollow(FOLLOW_ruleNavigation_in_entryRuleNavigation5635);
            iv_ruleNavigation=ruleNavigation();

            state._fsp--;

             current =iv_ruleNavigation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNavigation5645); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigation"


    // $ANTLR start "ruleNavigation"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2467:1: ruleNavigation returns [EObject current=null] : ( () otherlv_1= '.' ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' ) ) ;
    public final EObject ruleNavigation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2470:28: ( ( () otherlv_1= '.' ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2471:1: ( () otherlv_1= '.' ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2471:1: ( () otherlv_1= '.' ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2471:2: () otherlv_1= '.' ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2471:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2472:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNavigationAccess().getNavigationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleNavigation5691); 

                	newLeafNode(otherlv_1, grammarAccess.getNavigationAccess().getFullStopKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2481:1: ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' )
            int alt41=4;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt41=1;
                }
                break;
            case 53:
                {
                alt41=2;
                }
                break;
            case 54:
                {
                alt41=3;
                }
                break;
            case 55:
                {
                alt41=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2481:2: (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2481:2: (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2481:4: otherlv_2= 'FUNCTION' ( ( ruleFQN ) )
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleNavigation5705); 

                        	newLeafNode(otherlv_2, grammarAccess.getNavigationAccess().getFUNCTIONKeyword_2_0_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2485:1: ( ( ruleFQN ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2486:1: ( ruleFQN )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2486:1: ( ruleFQN )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2487:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getNavigationRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getNavigationAccess().getFunctionFunctionCrossReference_2_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleNavigation5728);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2501:6: (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2501:6: (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2501:8: otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,53,FOLLOW_53_in_ruleNavigation5748); 

                        	newLeafNode(otherlv_4, grammarAccess.getNavigationAccess().getEQUIPMENTKeyword_2_1_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2505:1: ( ( ruleFQN ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2506:1: ( ruleFQN )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2506:1: ( ruleFQN )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2507:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getNavigationRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getNavigationAccess().getEquipmentEquipmentCrossReference_2_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleNavigation5771);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2521:7: otherlv_6= 'PROFILE'
                    {
                    otherlv_6=(Token)match(input,54,FOLLOW_54_in_ruleNavigation5790); 

                        	newLeafNode(otherlv_6, grammarAccess.getNavigationAccess().getPROFILEKeyword_2_2());
                        

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2526:7: otherlv_7= 'STATUS'
                    {
                    otherlv_7=(Token)match(input,55,FOLLOW_55_in_ruleNavigation5808); 

                        	newLeafNode(otherlv_7, grammarAccess.getNavigationAccess().getSTATUSKeyword_2_3());
                        

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
    // $ANTLR end "ruleNavigation"


    // $ANTLR start "entryRuleLeafReference"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2538:1: entryRuleLeafReference returns [EObject current=null] : iv_ruleLeafReference= ruleLeafReference EOF ;
    public final EObject entryRuleLeafReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeafReference = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2539:2: (iv_ruleLeafReference= ruleLeafReference EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2540:2: iv_ruleLeafReference= ruleLeafReference EOF
            {
             newCompositeNode(grammarAccess.getLeafReferenceRule()); 
            pushFollow(FOLLOW_ruleLeafReference_in_entryRuleLeafReference5845);
            iv_ruleLeafReference=ruleLeafReference();

            state._fsp--;

             current =iv_ruleLeafReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLeafReference5855); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2547:1: ruleLeafReference returns [EObject current=null] : (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef | this_StatusRef_2= ruleStatusRef ) ;
    public final EObject ruleLeafReference() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceRef_0 = null;

        EObject this_LinkRef_1 = null;

        EObject this_StatusRef_2 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2550:28: ( (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef | this_StatusRef_2= ruleStatusRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2551:1: (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef | this_StatusRef_2= ruleStatusRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2551:1: (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef | this_StatusRef_2= ruleStatusRef )
            int alt42=3;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt42=1;
                }
                break;
            case 58:
                {
                alt42=2;
                }
                break;
            case 72:
            case 73:
            case 74:
            case 75:
                {
                alt42=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2552:5: this_ResourceRef_0= ruleResourceRef
                    {
                     
                            newCompositeNode(grammarAccess.getLeafReferenceAccess().getResourceRefParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleResourceRef_in_ruleLeafReference5902);
                    this_ResourceRef_0=ruleResourceRef();

                    state._fsp--;

                     
                            current = this_ResourceRef_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2562:5: this_LinkRef_1= ruleLinkRef
                    {
                     
                            newCompositeNode(grammarAccess.getLeafReferenceAccess().getLinkRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleLinkRef_in_ruleLeafReference5929);
                    this_LinkRef_1=ruleLinkRef();

                    state._fsp--;

                     
                            current = this_LinkRef_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2572:5: this_StatusRef_2= ruleStatusRef
                    {
                     
                            newCompositeNode(grammarAccess.getLeafReferenceAccess().getStatusRefParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStatusRef_in_ruleLeafReference5956);
                    this_StatusRef_2=ruleStatusRef();

                    state._fsp--;

                     
                            current = this_StatusRef_2; 
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
    // $ANTLR end "ruleLeafReference"


    // $ANTLR start "entryRuleResourceRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2588:1: entryRuleResourceRef returns [EObject current=null] : iv_ruleResourceRef= ruleResourceRef EOF ;
    public final EObject entryRuleResourceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2589:2: (iv_ruleResourceRef= ruleResourceRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2590:2: iv_ruleResourceRef= ruleResourceRef EOF
            {
             newCompositeNode(grammarAccess.getResourceRefRule()); 
            pushFollow(FOLLOW_ruleResourceRef_in_entryRuleResourceRef5991);
            iv_ruleResourceRef=ruleResourceRef();

            state._fsp--;

             current =iv_ruleResourceRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceRef6001); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2597:1: ruleResourceRef returns [EObject current=null] : ( () otherlv_1= 'RESOURCE' ( ( ruleFQN ) ) ( (lv_all_3_0= 'ALL' ) )? ( (lv_rangeRef_4_0= ruleRangeRef ) ) ) ;
    public final EObject ruleResourceRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_all_3_0=null;
        EObject lv_rangeRef_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2600:28: ( ( () otherlv_1= 'RESOURCE' ( ( ruleFQN ) ) ( (lv_all_3_0= 'ALL' ) )? ( (lv_rangeRef_4_0= ruleRangeRef ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2601:1: ( () otherlv_1= 'RESOURCE' ( ( ruleFQN ) ) ( (lv_all_3_0= 'ALL' ) )? ( (lv_rangeRef_4_0= ruleRangeRef ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2601:1: ( () otherlv_1= 'RESOURCE' ( ( ruleFQN ) ) ( (lv_all_3_0= 'ALL' ) )? ( (lv_rangeRef_4_0= ruleRangeRef ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2601:2: () otherlv_1= 'RESOURCE' ( ( ruleFQN ) ) ( (lv_all_3_0= 'ALL' ) )? ( (lv_rangeRef_4_0= ruleRangeRef ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2601:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2602:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getResourceRefAccess().getResourceRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleResourceRef6047); 

                	newLeafNode(otherlv_1, grammarAccess.getResourceRefAccess().getRESOURCEKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2611:1: ( ( ruleFQN ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2612:1: ( ruleFQN )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2612:1: ( ruleFQN )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2613:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getResourceRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getResourceRefAccess().getResourceBaseResourceCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleResourceRef6070);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2626:2: ( (lv_all_3_0= 'ALL' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==57) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2627:1: (lv_all_3_0= 'ALL' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2627:1: (lv_all_3_0= 'ALL' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2628:3: lv_all_3_0= 'ALL'
                    {
                    lv_all_3_0=(Token)match(input,57,FOLLOW_57_in_ruleResourceRef6088); 

                            newLeafNode(lv_all_3_0, grammarAccess.getResourceRefAccess().getAllALLKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResourceRefRule());
                    	        }
                           		setWithLastConsumed(current, "all", true, "ALL");
                    	    

                    }


                    }
                    break;

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2641:3: ( (lv_rangeRef_4_0= ruleRangeRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2642:1: (lv_rangeRef_4_0= ruleRangeRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2642:1: (lv_rangeRef_4_0= ruleRangeRef )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2643:3: lv_rangeRef_4_0= ruleRangeRef
            {
             
            	        newCompositeNode(grammarAccess.getResourceRefAccess().getRangeRefRangeRefParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleRangeRef_in_ruleResourceRef6123);
            lv_rangeRef_4_0=ruleRangeRef();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getResourceRefRule());
            	        }
                   		set(
                   			current, 
                   			"rangeRef",
                    		lv_rangeRef_4_0, 
                    		"RangeRef");
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
    // $ANTLR end "ruleResourceRef"


    // $ANTLR start "entryRuleStatusRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2667:1: entryRuleStatusRef returns [EObject current=null] : iv_ruleStatusRef= ruleStatusRef EOF ;
    public final EObject entryRuleStatusRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatusRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2668:2: (iv_ruleStatusRef= ruleStatusRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2669:2: iv_ruleStatusRef= ruleStatusRef EOF
            {
             newCompositeNode(grammarAccess.getStatusRefRule()); 
            pushFollow(FOLLOW_ruleStatusRef_in_entryRuleStatusRef6159);
            iv_ruleStatusRef=ruleStatusRef();

            state._fsp--;

             current =iv_ruleStatusRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatusRef6169); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatusRef"


    // $ANTLR start "ruleStatusRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2676:1: ruleStatusRef returns [EObject current=null] : ( () ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) ) ) ;
    public final EObject ruleStatusRef() throws RecognitionException {
        EObject current = null;

        Enumerator lv_tolerancelevel_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2679:28: ( ( () ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2680:1: ( () ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2680:1: ( () ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2680:2: () ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2680:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2681:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStatusRefAccess().getStatusRefAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2686:2: ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2687:1: (lv_tolerancelevel_1_0= ruleToleranceLevel )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2687:1: (lv_tolerancelevel_1_0= ruleToleranceLevel )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2688:3: lv_tolerancelevel_1_0= ruleToleranceLevel
            {
             
            	        newCompositeNode(grammarAccess.getStatusRefAccess().getTolerancelevelToleranceLevelEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleToleranceLevel_in_ruleStatusRef6224);
            lv_tolerancelevel_1_0=ruleToleranceLevel();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStatusRefRule());
            	        }
                   		set(
                   			current, 
                   			"tolerancelevel",
                    		lv_tolerancelevel_1_0, 
                    		"ToleranceLevel");
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
    // $ANTLR end "ruleStatusRef"


    // $ANTLR start "entryRuleRangeRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2712:1: entryRuleRangeRef returns [EObject current=null] : iv_ruleRangeRef= ruleRangeRef EOF ;
    public final EObject entryRuleRangeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2713:2: (iv_ruleRangeRef= ruleRangeRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2714:2: iv_ruleRangeRef= ruleRangeRef EOF
            {
             newCompositeNode(grammarAccess.getRangeRefRule()); 
            pushFollow(FOLLOW_ruleRangeRef_in_entryRuleRangeRef6260);
            iv_ruleRangeRef=ruleRangeRef();

            state._fsp--;

             current =iv_ruleRangeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeRef6270); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeRef"


    // $ANTLR start "ruleRangeRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2721:1: ruleRangeRef returns [EObject current=null] : ( ( (lv_valuerange_0_0= ruleValueRange ) ) ( (lv_kind_1_0= ruleValueKind ) )? ( (lv_interval_2_0= ruleInterval ) )? ) ;
    public final EObject ruleRangeRef() throws RecognitionException {
        EObject current = null;

        Enumerator lv_valuerange_0_0 = null;

        Enumerator lv_kind_1_0 = null;

        EObject lv_interval_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2724:28: ( ( ( (lv_valuerange_0_0= ruleValueRange ) ) ( (lv_kind_1_0= ruleValueKind ) )? ( (lv_interval_2_0= ruleInterval ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2725:1: ( ( (lv_valuerange_0_0= ruleValueRange ) ) ( (lv_kind_1_0= ruleValueKind ) )? ( (lv_interval_2_0= ruleInterval ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2725:1: ( ( (lv_valuerange_0_0= ruleValueRange ) ) ( (lv_kind_1_0= ruleValueKind ) )? ( (lv_interval_2_0= ruleInterval ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2725:2: ( (lv_valuerange_0_0= ruleValueRange ) ) ( (lv_kind_1_0= ruleValueKind ) )? ( (lv_interval_2_0= ruleInterval ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2725:2: ( (lv_valuerange_0_0= ruleValueRange ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2726:1: (lv_valuerange_0_0= ruleValueRange )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2726:1: (lv_valuerange_0_0= ruleValueRange )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2727:3: lv_valuerange_0_0= ruleValueRange
            {
             
            	        newCompositeNode(grammarAccess.getRangeRefAccess().getValuerangeValueRangeEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleValueRange_in_ruleRangeRef6316);
            lv_valuerange_0_0=ruleValueRange();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRangeRefRule());
            	        }
                   		set(
                   			current, 
                   			"valuerange",
                    		lv_valuerange_0_0, 
                    		"ValueRange");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2743:2: ( (lv_kind_1_0= ruleValueKind ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=84 && LA44_0<=85)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2744:1: (lv_kind_1_0= ruleValueKind )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2744:1: (lv_kind_1_0= ruleValueKind )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2745:3: lv_kind_1_0= ruleValueKind
                    {
                     
                    	        newCompositeNode(grammarAccess.getRangeRefAccess().getKindValueKindEnumRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueKind_in_ruleRangeRef6337);
                    lv_kind_1_0=ruleValueKind();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRangeRefRule());
                    	        }
                           		set(
                           			current, 
                           			"kind",
                            		lv_kind_1_0, 
                            		"ValueKind");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2761:3: ( (lv_interval_2_0= ruleInterval ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_NUMBER||(LA45_0>=68 && LA45_0<=71)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2762:1: (lv_interval_2_0= ruleInterval )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2762:1: (lv_interval_2_0= ruleInterval )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2763:3: lv_interval_2_0= ruleInterval
                    {
                     
                    	        newCompositeNode(grammarAccess.getRangeRefAccess().getIntervalIntervalParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInterval_in_ruleRangeRef6359);
                    lv_interval_2_0=ruleInterval();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRangeRefRule());
                    	        }
                           		set(
                           			current, 
                           			"interval",
                            		lv_interval_2_0, 
                            		"Interval");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleRangeRef"


    // $ANTLR start "entryRuleInterval"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2787:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2788:2: (iv_ruleInterval= ruleInterval EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2789:2: iv_ruleInterval= ruleInterval EOF
            {
             newCompositeNode(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval6396);
            iv_ruleInterval=ruleInterval();

            state._fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval6406); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterval"


    // $ANTLR start "ruleInterval"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2796:1: ruleInterval returns [EObject current=null] : ( ( (lv_interval_0_0= RULE_NUMBER ) ) | ( (lv_kind_1_0= ruleIntervalKind ) ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token lv_interval_0_0=null;
        Enumerator lv_kind_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2799:28: ( ( ( (lv_interval_0_0= RULE_NUMBER ) ) | ( (lv_kind_1_0= ruleIntervalKind ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2800:1: ( ( (lv_interval_0_0= RULE_NUMBER ) ) | ( (lv_kind_1_0= ruleIntervalKind ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2800:1: ( ( (lv_interval_0_0= RULE_NUMBER ) ) | ( (lv_kind_1_0= ruleIntervalKind ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_NUMBER) ) {
                alt46=1;
            }
            else if ( ((LA46_0>=68 && LA46_0<=71)) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2800:2: ( (lv_interval_0_0= RULE_NUMBER ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2800:2: ( (lv_interval_0_0= RULE_NUMBER ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2801:1: (lv_interval_0_0= RULE_NUMBER )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2801:1: (lv_interval_0_0= RULE_NUMBER )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2802:3: lv_interval_0_0= RULE_NUMBER
                    {
                    lv_interval_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleInterval6448); 

                    			newLeafNode(lv_interval_0_0, grammarAccess.getIntervalAccess().getIntervalNUMBERTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntervalRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"interval",
                            		lv_interval_0_0, 
                            		"NUMBER");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2819:6: ( (lv_kind_1_0= ruleIntervalKind ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2819:6: ( (lv_kind_1_0= ruleIntervalKind ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2820:1: (lv_kind_1_0= ruleIntervalKind )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2820:1: (lv_kind_1_0= ruleIntervalKind )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2821:3: lv_kind_1_0= ruleIntervalKind
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntervalAccess().getKindIntervalKindEnumRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIntervalKind_in_ruleInterval6480);
                    lv_kind_1_0=ruleIntervalKind();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIntervalRule());
                    	        }
                           		set(
                           			current, 
                           			"kind",
                            		lv_kind_1_0, 
                            		"IntervalKind");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleInterval"


    // $ANTLR start "entryRuleLinkRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2845:1: entryRuleLinkRef returns [EObject current=null] : iv_ruleLinkRef= ruleLinkRef EOF ;
    public final EObject entryRuleLinkRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinkRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2846:2: (iv_ruleLinkRef= ruleLinkRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2847:2: iv_ruleLinkRef= ruleLinkRef EOF
            {
             newCompositeNode(grammarAccess.getLinkRefRule()); 
            pushFollow(FOLLOW_ruleLinkRef_in_entryRuleLinkRef6516);
            iv_ruleLinkRef=ruleLinkRef();

            state._fsp--;

             current =iv_ruleLinkRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLinkRef6526); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2854:1: ruleLinkRef returns [EObject current=null] : ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleLinkRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2857:28: ( ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2858:1: ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2858:1: ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2858:2: () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2858:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2859:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLinkRefAccess().getLinkRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleLinkRef6572); 

                	newLeafNode(otherlv_1, grammarAccess.getLinkRefAccess().getLINKKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2868:1: ( (otherlv_2= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2869:1: (otherlv_2= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2869:1: (otherlv_2= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2870:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLinkRefRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLinkRef6592); 

            		newLeafNode(otherlv_2, grammarAccess.getLinkRefAccess().getLinkRelationshipCrossReference_2_0()); 
            	

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
    // $ANTLR end "ruleLinkRef"


    // $ANTLR start "entryRuleFQN"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2889:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2890:2: (iv_ruleFQN= ruleFQN EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2891:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN6629);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN6640); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2898:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SPACED_ID_0= ruleSPACED_ID (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_SPACED_ID_0 = null;

        AntlrDatatypeRuleToken this_SPACED_ID_2 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2901:28: ( (this_SPACED_ID_0= ruleSPACED_ID (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2902:1: (this_SPACED_ID_0= ruleSPACED_ID (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2902:1: (this_SPACED_ID_0= ruleSPACED_ID (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2903:5: this_SPACED_ID_0= ruleSPACED_ID (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )*
            {
             
                    newCompositeNode(grammarAccess.getFQNAccess().getSPACED_IDParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleSPACED_ID_in_ruleFQN6687);
            this_SPACED_ID_0=ruleSPACED_ID();

            state._fsp--;


            		current.merge(this_SPACED_ID_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2913:1: (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==59) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2914:2: kw= '::' this_SPACED_ID_2= ruleSPACED_ID
            	    {
            	    kw=(Token)match(input,59,FOLLOW_59_in_ruleFQN6706); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getColonColonKeyword_1_0()); 
            	        
            	     
            	            newCompositeNode(grammarAccess.getFQNAccess().getSPACED_IDParserRuleCall_1_1()); 
            	        
            	    pushFollow(FOLLOW_ruleSPACED_ID_in_ruleFQN6728);
            	    this_SPACED_ID_2=ruleSPACED_ID();

            	    state._fsp--;


            	    		current.merge(this_SPACED_ID_2);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop47;
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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleSPACED_ID"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2938:1: entryRuleSPACED_ID returns [String current=null] : iv_ruleSPACED_ID= ruleSPACED_ID EOF ;
    public final String entryRuleSPACED_ID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSPACED_ID = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2939:2: (iv_ruleSPACED_ID= ruleSPACED_ID EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2940:2: iv_ruleSPACED_ID= ruleSPACED_ID EOF
            {
             newCompositeNode(grammarAccess.getSPACED_IDRule()); 
            pushFollow(FOLLOW_ruleSPACED_ID_in_entryRuleSPACED_ID6776);
            iv_ruleSPACED_ID=ruleSPACED_ID();

            state._fsp--;

             current =iv_ruleSPACED_ID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPACED_ID6787); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSPACED_ID"


    // $ANTLR start "ruleSPACED_ID"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2947:1: ruleSPACED_ID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )* ) ;
    public final AntlrDatatypeRuleToken ruleSPACED_ID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_NUMBER_1=null;
        Token this_ID_2=null;
        Token this_NUMBER_3=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2950:28: ( ( (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2951:1: ( (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2951:1: ( (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2951:2: (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )*
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2951:2: (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                alt48=1;
            }
            else if ( (LA48_0==RULE_NUMBER) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2951:7: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPACED_ID6828); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getSPACED_IDAccess().getIDTerminalRuleCall_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2959:10: this_NUMBER_1= RULE_NUMBER
                    {
                    this_NUMBER_1=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleSPACED_ID6854); 

                    		current.merge(this_NUMBER_1);
                        
                     
                        newLeafNode(this_NUMBER_1, grammarAccess.getSPACED_IDAccess().getNUMBERTerminalRuleCall_0_1()); 
                        

                    }
                    break;

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2966:2: (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )*
            loop49:
            do {
                int alt49=3;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_ID) ) {
                    alt49=1;
                }
                else if ( (LA49_0==RULE_NUMBER) ) {
                    alt49=2;
                }


                switch (alt49) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2966:7: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPACED_ID6876); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getSPACED_IDAccess().getIDTerminalRuleCall_1_0()); 
            	        

            	    }
            	    break;
            	case 2 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2974:10: this_NUMBER_3= RULE_NUMBER
            	    {
            	    this_NUMBER_3=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleSPACED_ID6902); 

            	    		current.merge(this_NUMBER_3);
            	        
            	     
            	        newLeafNode(this_NUMBER_3, grammarAccess.getSPACED_IDAccess().getNUMBERTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop49;
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
    // $ANTLR end "ruleSPACED_ID"


    // $ANTLR start "ruleNativeFunction"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2989:1: ruleNativeFunction returns [Enumerator current=null] : ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) | (enumLiteral_6= 'erlangB()' ) | (enumLiteral_7= 'clear()' ) ) ;
    public final Enumerator ruleNativeFunction() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;

         enterRule(); 
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2991:28: ( ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) | (enumLiteral_6= 'erlangB()' ) | (enumLiteral_7= 'clear()' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2992:1: ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) | (enumLiteral_6= 'erlangB()' ) | (enumLiteral_7= 'clear()' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2992:1: ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) | (enumLiteral_6= 'erlangB()' ) | (enumLiteral_7= 'clear()' ) )
            int alt50=8;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt50=1;
                }
                break;
            case 61:
                {
                alt50=2;
                }
                break;
            case 62:
                {
                alt50=3;
                }
                break;
            case 63:
                {
                alt50=4;
                }
                break;
            case 64:
                {
                alt50=5;
                }
                break;
            case 65:
                {
                alt50=6;
                }
                break;
            case 66:
                {
                alt50=7;
                }
                break;
            case 67:
                {
                alt50=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2992:2: (enumLiteral_0= 'count()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2992:2: (enumLiteral_0= 'count()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2992:4: enumLiteral_0= 'count()'
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_60_in_ruleNativeFunction6963); 

                            current = grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2998:6: (enumLiteral_1= 'sum()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2998:6: (enumLiteral_1= 'sum()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2998:8: enumLiteral_1= 'sum()'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_61_in_ruleNativeFunction6980); 

                            current = grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3004:6: (enumLiteral_2= 'min()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3004:6: (enumLiteral_2= 'min()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3004:8: enumLiteral_2= 'min()'
                    {
                    enumLiteral_2=(Token)match(input,62,FOLLOW_62_in_ruleNativeFunction6997); 

                            current = grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3010:6: (enumLiteral_3= 'max()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3010:6: (enumLiteral_3= 'max()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3010:8: enumLiteral_3= 'max()'
                    {
                    enumLiteral_3=(Token)match(input,63,FOLLOW_63_in_ruleNativeFunction7014); 

                            current = grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3016:6: (enumLiteral_4= 'mean()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3016:6: (enumLiteral_4= 'mean()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3016:8: enumLiteral_4= 'mean()'
                    {
                    enumLiteral_4=(Token)match(input,64,FOLLOW_64_in_ruleNativeFunction7031); 

                            current = grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3022:6: (enumLiteral_5= 'deviation()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3022:6: (enumLiteral_5= 'deviation()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3022:8: enumLiteral_5= 'deviation()'
                    {
                    enumLiteral_5=(Token)match(input,65,FOLLOW_65_in_ruleNativeFunction7048); 

                            current = grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3028:6: (enumLiteral_6= 'erlangB()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3028:6: (enumLiteral_6= 'erlangB()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3028:8: enumLiteral_6= 'erlangB()'
                    {
                    enumLiteral_6=(Token)match(input,66,FOLLOW_66_in_ruleNativeFunction7065); 

                            current = grammarAccess.getNativeFunctionAccess().getERLANGBEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getNativeFunctionAccess().getERLANGBEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3034:6: (enumLiteral_7= 'clear()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3034:6: (enumLiteral_7= 'clear()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3034:8: enumLiteral_7= 'clear()'
                    {
                    enumLiteral_7=(Token)match(input,67,FOLLOW_67_in_ruleNativeFunction7082); 

                            current = grammarAccess.getNativeFunctionAccess().getCLEAREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getNativeFunctionAccess().getCLEAREnumLiteralDeclaration_7()); 
                        

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
    // $ANTLR end "ruleNativeFunction"


    // $ANTLR start "ruleIntervalKind"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3044:1: ruleIntervalKind returns [Enumerator current=null] : ( (enumLiteral_0= 'MONTH' ) | (enumLiteral_1= 'WEEK' ) | (enumLiteral_2= 'DAY' ) | (enumLiteral_3= 'HOUR' ) ) ;
    public final Enumerator ruleIntervalKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3046:28: ( ( (enumLiteral_0= 'MONTH' ) | (enumLiteral_1= 'WEEK' ) | (enumLiteral_2= 'DAY' ) | (enumLiteral_3= 'HOUR' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3047:1: ( (enumLiteral_0= 'MONTH' ) | (enumLiteral_1= 'WEEK' ) | (enumLiteral_2= 'DAY' ) | (enumLiteral_3= 'HOUR' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3047:1: ( (enumLiteral_0= 'MONTH' ) | (enumLiteral_1= 'WEEK' ) | (enumLiteral_2= 'DAY' ) | (enumLiteral_3= 'HOUR' ) )
            int alt51=4;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt51=1;
                }
                break;
            case 69:
                {
                alt51=2;
                }
                break;
            case 70:
                {
                alt51=3;
                }
                break;
            case 71:
                {
                alt51=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3047:2: (enumLiteral_0= 'MONTH' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3047:2: (enumLiteral_0= 'MONTH' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3047:4: enumLiteral_0= 'MONTH'
                    {
                    enumLiteral_0=(Token)match(input,68,FOLLOW_68_in_ruleIntervalKind7127); 

                            current = grammarAccess.getIntervalKindAccess().getMONTHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getIntervalKindAccess().getMONTHEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3053:6: (enumLiteral_1= 'WEEK' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3053:6: (enumLiteral_1= 'WEEK' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3053:8: enumLiteral_1= 'WEEK'
                    {
                    enumLiteral_1=(Token)match(input,69,FOLLOW_69_in_ruleIntervalKind7144); 

                            current = grammarAccess.getIntervalKindAccess().getWEEKEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getIntervalKindAccess().getWEEKEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3059:6: (enumLiteral_2= 'DAY' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3059:6: (enumLiteral_2= 'DAY' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3059:8: enumLiteral_2= 'DAY'
                    {
                    enumLiteral_2=(Token)match(input,70,FOLLOW_70_in_ruleIntervalKind7161); 

                            current = grammarAccess.getIntervalKindAccess().getDAYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getIntervalKindAccess().getDAYEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3065:6: (enumLiteral_3= 'HOUR' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3065:6: (enumLiteral_3= 'HOUR' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3065:8: enumLiteral_3= 'HOUR'
                    {
                    enumLiteral_3=(Token)match(input,71,FOLLOW_71_in_ruleIntervalKind7178); 

                            current = grammarAccess.getIntervalKindAccess().getHOUREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getIntervalKindAccess().getHOUREnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleIntervalKind"


    // $ANTLR start "ruleToleranceLevel"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3075:1: ruleToleranceLevel returns [Enumerator current=null] : ( (enumLiteral_0= 'RED' ) | (enumLiteral_1= 'AMBER' ) | (enumLiteral_2= 'GREEN' ) | (enumLiteral_3= 'YELLOW' ) ) ;
    public final Enumerator ruleToleranceLevel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3077:28: ( ( (enumLiteral_0= 'RED' ) | (enumLiteral_1= 'AMBER' ) | (enumLiteral_2= 'GREEN' ) | (enumLiteral_3= 'YELLOW' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3078:1: ( (enumLiteral_0= 'RED' ) | (enumLiteral_1= 'AMBER' ) | (enumLiteral_2= 'GREEN' ) | (enumLiteral_3= 'YELLOW' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3078:1: ( (enumLiteral_0= 'RED' ) | (enumLiteral_1= 'AMBER' ) | (enumLiteral_2= 'GREEN' ) | (enumLiteral_3= 'YELLOW' ) )
            int alt52=4;
            switch ( input.LA(1) ) {
            case 72:
                {
                alt52=1;
                }
                break;
            case 73:
                {
                alt52=2;
                }
                break;
            case 74:
                {
                alt52=3;
                }
                break;
            case 75:
                {
                alt52=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3078:2: (enumLiteral_0= 'RED' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3078:2: (enumLiteral_0= 'RED' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3078:4: enumLiteral_0= 'RED'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_72_in_ruleToleranceLevel7223); 

                            current = grammarAccess.getToleranceLevelAccess().getREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getToleranceLevelAccess().getREDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3084:6: (enumLiteral_1= 'AMBER' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3084:6: (enumLiteral_1= 'AMBER' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3084:8: enumLiteral_1= 'AMBER'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_73_in_ruleToleranceLevel7240); 

                            current = grammarAccess.getToleranceLevelAccess().getAMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getToleranceLevelAccess().getAMBEREnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3090:6: (enumLiteral_2= 'GREEN' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3090:6: (enumLiteral_2= 'GREEN' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3090:8: enumLiteral_2= 'GREEN'
                    {
                    enumLiteral_2=(Token)match(input,74,FOLLOW_74_in_ruleToleranceLevel7257); 

                            current = grammarAccess.getToleranceLevelAccess().getGREENEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getToleranceLevelAccess().getGREENEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3096:6: (enumLiteral_3= 'YELLOW' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3096:6: (enumLiteral_3= 'YELLOW' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3096:8: enumLiteral_3= 'YELLOW'
                    {
                    enumLiteral_3=(Token)match(input,75,FOLLOW_75_in_ruleToleranceLevel7274); 

                            current = grammarAccess.getToleranceLevelAccess().getYELLOWEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getToleranceLevelAccess().getYELLOWEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleToleranceLevel"


    // $ANTLR start "ruleValueRange"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3106:1: ruleValueRange returns [Enumerator current=null] : ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) | (enumLiteral_6= 'TOLERANCE' ) | (enumLiteral_7= 'DERIVED' ) ) ;
    public final Enumerator ruleValueRange() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;

         enterRule(); 
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3108:28: ( ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) | (enumLiteral_6= 'TOLERANCE' ) | (enumLiteral_7= 'DERIVED' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3109:1: ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) | (enumLiteral_6= 'TOLERANCE' ) | (enumLiteral_7= 'DERIVED' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3109:1: ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) | (enumLiteral_6= 'TOLERANCE' ) | (enumLiteral_7= 'DERIVED' ) )
            int alt53=8;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt53=1;
                }
                break;
            case 77:
                {
                alt53=2;
                }
                break;
            case 78:
                {
                alt53=3;
                }
                break;
            case 79:
                {
                alt53=4;
                }
                break;
            case 80:
                {
                alt53=5;
                }
                break;
            case 81:
                {
                alt53=6;
                }
                break;
            case 82:
                {
                alt53=7;
                }
                break;
            case 83:
                {
                alt53=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3109:2: (enumLiteral_0= 'METRIC' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3109:2: (enumLiteral_0= 'METRIC' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3109:4: enumLiteral_0= 'METRIC'
                    {
                    enumLiteral_0=(Token)match(input,76,FOLLOW_76_in_ruleValueRange7319); 

                            current = grammarAccess.getValueRangeAccess().getMETRICEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getValueRangeAccess().getMETRICEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3115:6: (enumLiteral_1= 'CAP' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3115:6: (enumLiteral_1= 'CAP' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3115:8: enumLiteral_1= 'CAP'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_77_in_ruleValueRange7336); 

                            current = grammarAccess.getValueRangeAccess().getCAPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getValueRangeAccess().getCAPEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3121:6: (enumLiteral_2= 'FORECAST' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3121:6: (enumLiteral_2= 'FORECAST' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3121:8: enumLiteral_2= 'FORECAST'
                    {
                    enumLiteral_2=(Token)match(input,78,FOLLOW_78_in_ruleValueRange7353); 

                            current = grammarAccess.getValueRangeAccess().getFORECASTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getValueRangeAccess().getFORECASTEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3127:6: (enumLiteral_3= 'FORECAST_CAP' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3127:6: (enumLiteral_3= 'FORECAST_CAP' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3127:8: enumLiteral_3= 'FORECAST_CAP'
                    {
                    enumLiteral_3=(Token)match(input,79,FOLLOW_79_in_ruleValueRange7370); 

                            current = grammarAccess.getValueRangeAccess().getFORECAST_CAPEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getValueRangeAccess().getFORECAST_CAPEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3133:6: (enumLiteral_4= 'TRENDED' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3133:6: (enumLiteral_4= 'TRENDED' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3133:8: enumLiteral_4= 'TRENDED'
                    {
                    enumLiteral_4=(Token)match(input,80,FOLLOW_80_in_ruleValueRange7387); 

                            current = grammarAccess.getValueRangeAccess().getTRENDEDEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getValueRangeAccess().getTRENDEDEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3139:6: (enumLiteral_5= 'UTILIZATION' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3139:6: (enumLiteral_5= 'UTILIZATION' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3139:8: enumLiteral_5= 'UTILIZATION'
                    {
                    enumLiteral_5=(Token)match(input,81,FOLLOW_81_in_ruleValueRange7404); 

                            current = grammarAccess.getValueRangeAccess().getUTILIZATIONEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getValueRangeAccess().getUTILIZATIONEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3145:6: (enumLiteral_6= 'TOLERANCE' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3145:6: (enumLiteral_6= 'TOLERANCE' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3145:8: enumLiteral_6= 'TOLERANCE'
                    {
                    enumLiteral_6=(Token)match(input,82,FOLLOW_82_in_ruleValueRange7421); 

                            current = grammarAccess.getValueRangeAccess().getTOLERANCEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getValueRangeAccess().getTOLERANCEEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3151:6: (enumLiteral_7= 'DERIVED' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3151:6: (enumLiteral_7= 'DERIVED' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3151:8: enumLiteral_7= 'DERIVED'
                    {
                    enumLiteral_7=(Token)match(input,83,FOLLOW_83_in_ruleValueRange7438); 

                            current = grammarAccess.getValueRangeAccess().getDERIVEDEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getValueRangeAccess().getDERIVEDEnumLiteralDeclaration_7()); 
                        

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
    // $ANTLR end "ruleValueRange"


    // $ANTLR start "ruleValueKind"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3161:1: ruleValueKind returns [Enumerator current=null] : ( (enumLiteral_0= 'AVG' ) | (enumLiteral_1= 'BH' ) ) ;
    public final Enumerator ruleValueKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3163:28: ( ( (enumLiteral_0= 'AVG' ) | (enumLiteral_1= 'BH' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3164:1: ( (enumLiteral_0= 'AVG' ) | (enumLiteral_1= 'BH' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3164:1: ( (enumLiteral_0= 'AVG' ) | (enumLiteral_1= 'BH' ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==84) ) {
                alt54=1;
            }
            else if ( (LA54_0==85) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3164:2: (enumLiteral_0= 'AVG' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3164:2: (enumLiteral_0= 'AVG' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3164:4: enumLiteral_0= 'AVG'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_84_in_ruleValueKind7483); 

                            current = grammarAccess.getValueKindAccess().getAVGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getValueKindAccess().getAVGEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3170:6: (enumLiteral_1= 'BH' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3170:6: (enumLiteral_1= 'BH' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3170:8: enumLiteral_1= 'BH'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_85_in_ruleValueKind7500); 

                            current = grammarAccess.getValueKindAccess().getBHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getValueKindAccess().getBHEnumLiteralDeclaration_1()); 
                        

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
    // $ANTLR end "ruleValueKind"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleMod_in_entryRuleMod75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMod85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleMod123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMod140 = new BitSet(new long[]{0x0005000003646010L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMod168 = new BitSet(new long[]{0x0005000003646010L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleMod191 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleMod219 = new BitSet(new long[]{0x0005000003646012L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleImport304 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleFunction409 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction426 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFunction443 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleFunction465 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleFunction478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleFunction499 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleFunction515 = new BitSet(new long[]{0x0005000003646010L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleFunction536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_entryRuleArgument572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgument582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArgument623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleBlock723 = new BitSet(new long[]{0x00050000036C6010L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleBlock744 = new BitSet(new long[]{0x00050000036C6010L});
    public static final BitSet FOLLOW_19_in_ruleBlock757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_ruleStatement852 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_ruleStatement879 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rulePlusAssignmentStatement_in_ruleStatement906 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_ruleStatement933 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_ruleStatement960 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleStatement972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleStatement1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_ruleStatement1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleStatement1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement1090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReturnStatement1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleReturnStatement1146 = new BitSet(new long[]{0x0007BA3000008052L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReturnStatement1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement1204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleIfStatement1260 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleIfStatement1272 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleIfStatement1293 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleIfStatement1305 = new BitSet(new long[]{0x0005000003646010L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement1326 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleIfStatement1339 = new BitSet(new long[]{0x0005000003646010L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement1398 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleWhileStatement1454 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleWhileStatement1466 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleWhileStatement1487 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleWhileStatement1499 = new BitSet(new long[]{0x0005000003646010L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleWhileStatement1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement1556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableStatement1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVariableStatement1612 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableStatement1629 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleVariableStatement1647 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableStatement1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_entryRuleAssignmentStatement1706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentStatement1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentStatement1770 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAssignmentStatement1782 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssignmentStatement1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusAssignmentStatement_in_entryRulePlusAssignmentStatement1839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlusAssignmentStatement1849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePlusAssignmentStatement1903 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rulePlusAssignmentStatement1915 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePlusAssignmentStatement1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_entryRuleReferenceAssignmentStatement1972 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAssignmentStatement1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_ruleReferenceAssignmentStatement2039 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_ruleNodeTypeRef_in_ruleReferenceAssignmentStatement2058 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleReferenceAssignmentStatement2073 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReferenceAssignmentStatement2094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression2130 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleExpression2186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_entryRuleLogical2220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogical2230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_ruleLogical2277 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_28_in_ruleLogical2300 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_29_in_ruleLogical2329 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleEquality_in_ruleLogical2352 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_ruleEquality_in_entryRuleEquality2390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquality2400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleEquality2447 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_30_in_ruleEquality2470 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_31_in_ruleEquality2499 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleEquality2522 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison2560 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison2570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison2617 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_32_in_ruleComparison2640 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_33_in_ruleComparison2669 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_34_in_ruleComparison2698 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_35_in_ruleComparison2727 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison2750 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition2788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition2798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition2845 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_36_in_ruleAddition2868 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_37_in_ruleAddition2897 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition2920 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication2958 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiplication3015 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_38_in_ruleMultiplication3038 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_39_in_ruleMultiplication3067 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_40_in_ruleMultiplication3096 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiplication3119 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_entryRuleUnary3157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnary3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeExpression_in_ruleUnary3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleUnary3249 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnary3300 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleUnary3323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator3361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleUnaryOperator3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUnaryOperator3429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeExpression_in_entryRuleNativeExpression3469 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNativeExpression3479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNativeExpression3526 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleNativeExpression3547 = new BitSet(new long[]{0xF000000000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleNativeFunction_in_ruleNativeExpression3568 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression3616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression3663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_rulePrimaryExpression3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rulePrimaryExpression3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_rulePrimaryExpression3744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexedCall_in_rulePrimaryExpression3771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleLiteral3924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleLiteral3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral3993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral4003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumberLiteral4054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_entryRuleRangeLiteral4095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeLiteral4105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleRangeLiteral4151 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4169 = new BitSet(new long[]{0x0000400000010000L});
    public static final BitSet FOLLOW_16_in_ruleRangeLiteral4187 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4204 = new BitSet(new long[]{0x0000400000010000L});
    public static final BitSet FOLLOW_46_in_ruleRangeLiteral4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall4261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall4271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionCall4325 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFunctionCall4337 = new BitSet(new long[]{0x0007BA3000028050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall4359 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleFunctionCall4372 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall4393 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleFunctionCall4409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexedCall_in_entryRuleIndexedCall4445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndexedCall4455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_ruleIndexedCall4502 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleIndexedCall4514 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIndexedCall4535 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleIndexedCall4547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall4585 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarOrArgumentCall4595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarOrArgumentCall4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression4685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression4695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedExpression4732 = new BitSet(new long[]{0x0007BA3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression4754 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParenthesizedExpression4765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference4801 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference4811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_ruleReference4858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeTypeRef_in_ruleReference4885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_ruleReference4912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamRef_in_ruleReference4939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamRef_in_entryRuleParamRef4974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamRef4984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleParamRef5030 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleParamRef5053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeTypeRef_in_entryRuleNodeTypeRef5089 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeTypeRef5099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleNodeTypeRef5145 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNodeTypeRef5165 = new BitSet(new long[]{0x0008040000000000L});
    public static final BitSet FOLLOW_rulePrimaryRef_in_ruleNodeTypeRef5186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_entryRuleNodeRef5222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeRef5232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleNodeRef5278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNodeRef5298 = new BitSet(new long[]{0x0008040000000000L});
    public static final BitSet FOLLOW_rulePrimaryRef_in_ruleNodeRef5319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_entryRuleContextRef5355 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextRef5365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleContextRef5411 = new BitSet(new long[]{0x0008040000000000L,0x00000000000FF000L});
    public static final BitSet FOLLOW_rulePrimaryRef_in_ruleContextRef5433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeRef_in_ruleContextRef5460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryRef_in_entryRulePrimaryRef5497 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryRef5507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNavigation_in_rulePrimaryRef5562 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_rulePrimaryRef5576 = new BitSet(new long[]{0x0500000000000000L,0x0000000000000F00L});
    public static final BitSet FOLLOW_ruleLeafReference_in_rulePrimaryRef5597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNavigation_in_entryRuleNavigation5635 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNavigation5645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleNavigation5691 = new BitSet(new long[]{0x00F0000000000000L});
    public static final BitSet FOLLOW_52_in_ruleNavigation5705 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleNavigation5728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleNavigation5748 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleNavigation5771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleNavigation5790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleNavigation5808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLeafReference_in_entryRuleLeafReference5845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLeafReference5855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_ruleLeafReference5902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_ruleLeafReference5929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatusRef_in_ruleLeafReference5956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_entryRuleResourceRef5991 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceRef6001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleResourceRef6047 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleResourceRef6070 = new BitSet(new long[]{0x0208040000000000L,0x00000000000FF000L});
    public static final BitSet FOLLOW_57_in_ruleResourceRef6088 = new BitSet(new long[]{0x0008040000000000L,0x00000000000FF000L});
    public static final BitSet FOLLOW_ruleRangeRef_in_ruleResourceRef6123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatusRef_in_entryRuleStatusRef6159 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatusRef6169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToleranceLevel_in_ruleStatusRef6224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeRef_in_entryRuleRangeRef6260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeRef6270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueRange_in_ruleRangeRef6316 = new BitSet(new long[]{0x0000000000000042L,0x00000000003000F0L});
    public static final BitSet FOLLOW_ruleValueKind_in_ruleRangeRef6337 = new BitSet(new long[]{0x0000000000000042L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleInterval_in_ruleRangeRef6359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval6396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval6406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleInterval6448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntervalKind_in_ruleInterval6480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_entryRuleLinkRef6516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLinkRef6526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleLinkRef6572 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLinkRef6592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN6629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN6640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPACED_ID_in_ruleFQN6687 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleFQN6706 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleSPACED_ID_in_ruleFQN6728 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ruleSPACED_ID_in_entryRuleSPACED_ID6776 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPACED_ID6787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPACED_ID6828 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleSPACED_ID6854 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPACED_ID6876 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleSPACED_ID6902 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_60_in_ruleNativeFunction6963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleNativeFunction6980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleNativeFunction6997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleNativeFunction7014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleNativeFunction7031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleNativeFunction7048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleNativeFunction7065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleNativeFunction7082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleIntervalKind7127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleIntervalKind7144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleIntervalKind7161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleIntervalKind7178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleToleranceLevel7223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleToleranceLevel7240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleToleranceLevel7257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleToleranceLevel7274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleValueRange7319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleValueRange7336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleValueRange7353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleValueRange7370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleValueRange7387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleValueRange7404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleValueRange7421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleValueRange7438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleValueKind7483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleValueKind7500 = new BitSet(new long[]{0x0000000000000002L});

}