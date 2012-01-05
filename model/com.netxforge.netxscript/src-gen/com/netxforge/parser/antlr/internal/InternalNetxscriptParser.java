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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NUMBER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mod'", "'import'", "'def'", "'('", "','", "')'", "'{'", "'}'", "';'", "'return'", "'if'", "'else'", "'while'", "'var'", "'='", "'+='", "'&&'", "'||'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'true'", "'false'", "'['", "']'", "'.'", "'PARAM'", "'NETYPE'", "'NE'", "'this'", "'->'", "'FUNCTION'", "'EQUIPMENT'", "'PROFILE'", "'STATUS'", "'RESOURCE'", "'ALL'", "'LINK'", "'::'", "'count()'", "'sum()'", "'min()'", "'max()'", "'mean()'", "'deviation()'", "'erlangB()'", "'clear()'", "'MONTH'", "'WEEK'", "'DAY'", "'HOUR'", "'RED'", "'AMBER'", "'GREEN'", "'YELLOW'", "'METRIC'", "'CAP'", "'FORECAST'", "'FORECAST_CAP'", "'TRENDED'", "'UTILIZATION'", "'TOLERANCE'", "'DERIVED'", "'AVG'", "'BH'"
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
            else if ( (LA5_0==RULE_ID||LA5_0==RULE_NUMBER||LA5_0==15||LA5_0==18||(LA5_0>=21 && LA5_0<=22)||(LA5_0>=24 && LA5_0<=25)||(LA5_0>=36 && LA5_0<=37)||(LA5_0>=41 && LA5_0<=44)||(LA5_0>=47 && LA5_0<=50)) ) {
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

                        if ( (LA4_0==RULE_ID||LA4_0==RULE_NUMBER||LA4_0==15||LA4_0==18||(LA4_0>=21 && LA4_0<=22)||(LA4_0>=24 && LA4_0<=25)||(LA4_0>=36 && LA4_0<=37)||(LA4_0>=41 && LA4_0<=44)||(LA4_0>=47 && LA4_0<=50)) ) {
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

                if ( (LA8_0==RULE_ID||LA8_0==RULE_NUMBER||LA8_0==15||LA8_0==18||(LA8_0>=21 && LA8_0<=22)||(LA8_0>=24 && LA8_0<=25)||(LA8_0>=36 && LA8_0<=37)||(LA8_0>=41 && LA8_0<=44)||(LA8_0>=47 && LA8_0<=50)) ) {
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:423:1: ruleStatement returns [EObject current=null] : ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | ( (lv_expression_4_0= ruleExpression ) ) | this_ReturnStatement_5= ruleReturnStatement ) otherlv_6= ';' ) | this_IfStatement_7= ruleIfStatement | this_WhileStatement_8= ruleWhileStatement | this_Block_9= ruleBlock ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_6=null;
        EObject this_VariableStatement_0 = null;

        EObject this_AssignmentStatement_1 = null;

        EObject this_PlusAssignmentStatement_2 = null;

        EObject this_ReferenceAssignmentStatement_3 = null;

        EObject lv_expression_4_0 = null;

        EObject this_ReturnStatement_5 = null;

        EObject this_IfStatement_7 = null;

        EObject this_WhileStatement_8 = null;

        EObject this_Block_9 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:426:28: ( ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | ( (lv_expression_4_0= ruleExpression ) ) | this_ReturnStatement_5= ruleReturnStatement ) otherlv_6= ';' ) | this_IfStatement_7= ruleIfStatement | this_WhileStatement_8= ruleWhileStatement | this_Block_9= ruleBlock ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:1: ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | ( (lv_expression_4_0= ruleExpression ) ) | this_ReturnStatement_5= ruleReturnStatement ) otherlv_6= ';' ) | this_IfStatement_7= ruleIfStatement | this_WhileStatement_8= ruleWhileStatement | this_Block_9= ruleBlock )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:1: ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | ( (lv_expression_4_0= ruleExpression ) ) | this_ReturnStatement_5= ruleReturnStatement ) otherlv_6= ';' ) | this_IfStatement_7= ruleIfStatement | this_WhileStatement_8= ruleWhileStatement | this_Block_9= ruleBlock )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_NUMBER:
            case 15:
            case 21:
            case 25:
            case 36:
            case 37:
            case 41:
            case 42:
            case 43:
            case 44:
            case 47:
            case 48:
            case 49:
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:2: ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | ( (lv_expression_4_0= ruleExpression ) ) | this_ReturnStatement_5= ruleReturnStatement ) otherlv_6= ';' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:2: ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | ( (lv_expression_4_0= ruleExpression ) ) | this_ReturnStatement_5= ruleReturnStatement ) otherlv_6= ';' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:3: (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | ( (lv_expression_4_0= ruleExpression ) ) | this_ReturnStatement_5= ruleReturnStatement ) otherlv_6= ';'
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:3: (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | ( (lv_expression_4_0= ruleExpression ) ) | this_ReturnStatement_5= ruleReturnStatement )
                    int alt9=6;
                    alt9 = dfa9.predict(input);
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
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:467:6: ( (lv_expression_4_0= ruleExpression ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:467:6: ( (lv_expression_4_0= ruleExpression ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:468:1: (lv_expression_4_0= ruleExpression )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:468:1: (lv_expression_4_0= ruleExpression )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:469:3: lv_expression_4_0= ruleExpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getStatementAccess().getExpressionExpressionParserRuleCall_0_0_4_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleStatement959);
                            lv_expression_4_0=ruleExpression();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getStatementRule());
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
                        case 6 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:487:5: this_ReturnStatement_5= ruleReturnStatement
                            {
                             
                                    newCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_0_0_5()); 
                                
                            pushFollow(FOLLOW_ruleReturnStatement_in_ruleStatement987);
                            this_ReturnStatement_5=ruleReturnStatement();

                            state._fsp--;

                             
                                    current = this_ReturnStatement_5; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleStatement999); 

                        	newLeafNode(otherlv_6, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:501:5: this_IfStatement_7= ruleIfStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIfStatement_in_ruleStatement1028);
                    this_IfStatement_7=ruleIfStatement();

                    state._fsp--;

                     
                            current = this_IfStatement_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:511:5: this_WhileStatement_8= ruleWhileStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleWhileStatement_in_ruleStatement1055);
                    this_WhileStatement_8=ruleWhileStatement();

                    state._fsp--;

                     
                            current = this_WhileStatement_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:521:5: this_Block_9= ruleBlock
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleBlock_in_ruleStatement1082);
                    this_Block_9=ruleBlock();

                    state._fsp--;

                     
                            current = this_Block_9; 
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:537:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:538:2: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:539:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
             newCompositeNode(grammarAccess.getReturnStatementRule()); 
            pushFollow(FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement1117);
            iv_ruleReturnStatement=ruleReturnStatement();

            state._fsp--;

             current =iv_ruleReturnStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReturnStatement1127); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:546:1: ruleReturnStatement returns [EObject current=null] : ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:549:28: ( ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:550:1: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:550:1: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:550:2: () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:550:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:551:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReturnStatementAccess().getReturnAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleReturnStatement1173); 

                	newLeafNode(otherlv_1, grammarAccess.getReturnStatementAccess().getReturnKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:560:1: ( (lv_expression_2_0= ruleExpression ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==RULE_NUMBER||LA11_0==15||(LA11_0>=36 && LA11_0<=37)||(LA11_0>=41 && LA11_0<=44)||(LA11_0>=47 && LA11_0<=50)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:561:1: (lv_expression_2_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:561:1: (lv_expression_2_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:562:3: lv_expression_2_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleReturnStatement1194);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:586:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:587:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:588:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             newCompositeNode(grammarAccess.getIfStatementRule()); 
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement1231);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement1241); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:595:1: ruleIfStatement returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? ) ;
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
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:598:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:599:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:599:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:599:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:599:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:600:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIfStatementAccess().getIfAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleIfStatement1287); 

                	newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getIfKeyword_1());
                
            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleIfStatement1299); 

                	newLeafNode(otherlv_2, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:613:1: ( (lv_if_3_0= ruleLogical ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:614:1: (lv_if_3_0= ruleLogical )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:614:1: (lv_if_3_0= ruleLogical )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:615:3: lv_if_3_0= ruleLogical
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getIfLogicalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLogical_in_ruleIfStatement1320);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleIfStatement1332); 

                	newLeafNode(otherlv_4, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_4());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:635:1: ( (lv_then_5_0= ruleBlock ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:636:1: (lv_then_5_0= ruleBlock )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:636:1: (lv_then_5_0= ruleBlock )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:637:3: lv_then_5_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getThenBlockParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement1353);
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

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:653:2: (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:653:4: otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) )
                    {
                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleIfStatement1366); 

                        	newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getElseKeyword_6_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:657:1: ( (lv_else_7_0= ruleBlock ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:658:1: (lv_else_7_0= ruleBlock )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:658:1: (lv_else_7_0= ruleBlock )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:659:3: lv_else_7_0= ruleBlock
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfStatementAccess().getElseBlockParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement1387);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:683:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:684:2: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:685:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
             newCompositeNode(grammarAccess.getWhileStatementRule()); 
            pushFollow(FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement1425);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;

             current =iv_ruleWhileStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileStatement1435); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:692:1: ruleWhileStatement returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:695:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:696:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:696:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:696:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:696:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:697:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWhileStatementAccess().getWhileAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleWhileStatement1481); 

                	newLeafNode(otherlv_1, grammarAccess.getWhileStatementAccess().getWhileKeyword_1());
                
            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleWhileStatement1493); 

                	newLeafNode(otherlv_2, grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:710:1: ( (lv_predicate_3_0= ruleLogical ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:711:1: (lv_predicate_3_0= ruleLogical )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:711:1: (lv_predicate_3_0= ruleLogical )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:712:3: lv_predicate_3_0= ruleLogical
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getPredicateLogicalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLogical_in_ruleWhileStatement1514);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleWhileStatement1526); 

                	newLeafNode(otherlv_4, grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_4());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:732:1: ( (lv_body_5_0= ruleBlock ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:733:1: (lv_body_5_0= ruleBlock )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:733:1: (lv_body_5_0= ruleBlock )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:734:3: lv_body_5_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleWhileStatement1547);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:758:1: entryRuleVariableStatement returns [EObject current=null] : iv_ruleVariableStatement= ruleVariableStatement EOF ;
    public final EObject entryRuleVariableStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:759:2: (iv_ruleVariableStatement= ruleVariableStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:760:2: iv_ruleVariableStatement= ruleVariableStatement EOF
            {
             newCompositeNode(grammarAccess.getVariableStatementRule()); 
            pushFollow(FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement1583);
            iv_ruleVariableStatement=ruleVariableStatement();

            state._fsp--;

             current =iv_ruleVariableStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableStatement1593); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:767:1: ruleVariableStatement returns [EObject current=null] : ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:770:28: ( ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:771:1: ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:771:1: ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:771:2: () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:771:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:772:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVariableStatementAccess().getVariableAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleVariableStatement1639); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableStatementAccess().getVarKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:781:1: ( (lv_name_2_0= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:782:1: (lv_name_2_0= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:782:1: (lv_name_2_0= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:783:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableStatement1656); 

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

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:799:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:799:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleVariableStatement1674); 

                        	newLeafNode(otherlv_3, grammarAccess.getVariableStatementAccess().getEqualsSignKeyword_3_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:803:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:804:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:804:1: (lv_expression_4_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:805:3: lv_expression_4_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableStatement1695);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:829:1: entryRuleAssignmentStatement returns [EObject current=null] : iv_ruleAssignmentStatement= ruleAssignmentStatement EOF ;
    public final EObject entryRuleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:830:2: (iv_ruleAssignmentStatement= ruleAssignmentStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:831:2: iv_ruleAssignmentStatement= ruleAssignmentStatement EOF
            {
             newCompositeNode(grammarAccess.getAssignmentStatementRule()); 
            pushFollow(FOLLOW_ruleAssignmentStatement_in_entryRuleAssignmentStatement1733);
            iv_ruleAssignmentStatement=ruleAssignmentStatement();

            state._fsp--;

             current =iv_ruleAssignmentStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentStatement1743); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:838:1: ruleAssignmentStatement returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:841:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:842:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:842:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:842:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:842:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:843:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAssignmentStatementAccess().getAssignmentAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:848:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:849:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:849:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:850:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssignmentStatementRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentStatement1797); 

            		newLeafNode(otherlv_1, grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleAssignmentStatement1809); 

                	newLeafNode(otherlv_2, grammarAccess.getAssignmentStatementAccess().getEqualsSignKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:865:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:866:1: (lv_expression_3_0= ruleExpression )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:866:1: (lv_expression_3_0= ruleExpression )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:867:3: lv_expression_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleAssignmentStatement1830);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:891:1: entryRulePlusAssignmentStatement returns [EObject current=null] : iv_rulePlusAssignmentStatement= rulePlusAssignmentStatement EOF ;
    public final EObject entryRulePlusAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusAssignmentStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:892:2: (iv_rulePlusAssignmentStatement= rulePlusAssignmentStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:893:2: iv_rulePlusAssignmentStatement= rulePlusAssignmentStatement EOF
            {
             newCompositeNode(grammarAccess.getPlusAssignmentStatementRule()); 
            pushFollow(FOLLOW_rulePlusAssignmentStatement_in_entryRulePlusAssignmentStatement1866);
            iv_rulePlusAssignmentStatement=rulePlusAssignmentStatement();

            state._fsp--;

             current =iv_rulePlusAssignmentStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlusAssignmentStatement1876); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:900:1: rulePlusAssignmentStatement returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '+=' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject rulePlusAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:903:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '+=' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:904:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '+=' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:904:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '+=' ( (lv_expression_3_0= ruleExpression ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:904:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '+=' ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:904:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:905:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPlusAssignmentStatementAccess().getPlusAssignmentAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:910:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:911:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:911:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:912:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPlusAssignmentStatementRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePlusAssignmentStatement1930); 

            		newLeafNode(otherlv_1, grammarAccess.getPlusAssignmentStatementAccess().getVarAbstractVarOrArgumentCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,27,FOLLOW_27_in_rulePlusAssignmentStatement1942); 

                	newLeafNode(otherlv_2, grammarAccess.getPlusAssignmentStatementAccess().getPlusSignEqualsSignKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:927:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:928:1: (lv_expression_3_0= ruleExpression )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:928:1: (lv_expression_3_0= ruleExpression )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:929:3: lv_expression_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getPlusAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_rulePlusAssignmentStatement1963);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:953:1: entryRuleReferenceAssignmentStatement returns [EObject current=null] : iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF ;
    public final EObject entryRuleReferenceAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAssignmentStatement = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:954:2: (iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:955:2: iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF
            {
             newCompositeNode(grammarAccess.getReferenceAssignmentStatementRule()); 
            pushFollow(FOLLOW_ruleReferenceAssignmentStatement_in_entryRuleReferenceAssignmentStatement1999);
            iv_ruleReferenceAssignmentStatement=ruleReferenceAssignmentStatement();

            state._fsp--;

             current =iv_ruleReferenceAssignmentStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceAssignmentStatement2009); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:962:1: ruleReferenceAssignmentStatement returns [EObject current=null] : ( () ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleReferenceAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_assignmentRef_1_1 = null;

        EObject lv_assignmentRef_1_2 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:965:28: ( ( () ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:1: ( () ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:1: ( () ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:2: () ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:967:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignmentAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:972:2: ( ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:973:1: ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:973:1: ( (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:974:1: (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:974:1: (lv_assignmentRef_1_1= ruleContextRef | lv_assignmentRef_1_2= ruleNodeTypeRef )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:975:3: lv_assignmentRef_1_1= ruleContextRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceAssignmentStatementAccess().getAssignmentRefContextRefParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleContextRef_in_ruleReferenceAssignmentStatement2066);
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:990:8: lv_assignmentRef_1_2= ruleNodeTypeRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceAssignmentStatementAccess().getAssignmentRefNodeTypeRefParserRuleCall_1_0_1()); 
                    	    
                    pushFollow(FOLLOW_ruleNodeTypeRef_in_ruleReferenceAssignmentStatement2085);
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

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleReferenceAssignmentStatement2100); 

                	newLeafNode(otherlv_2, grammarAccess.getReferenceAssignmentStatementAccess().getEqualsSignKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1012:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1013:1: (lv_expression_3_0= ruleExpression )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1013:1: (lv_expression_3_0= ruleExpression )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1014:3: lv_expression_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleReferenceAssignmentStatement2121);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1038:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1039:2: (iv_ruleExpression= ruleExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1040:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression2157);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression2167); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1047:1: ruleExpression returns [EObject current=null] : this_Logical_0= ruleLogical ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Logical_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1050:28: (this_Logical_0= ruleLogical )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1052:5: this_Logical_0= ruleLogical
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getLogicalParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleLogical_in_ruleExpression2213);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1068:1: entryRuleLogical returns [EObject current=null] : iv_ruleLogical= ruleLogical EOF ;
    public final EObject entryRuleLogical() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogical = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1069:2: (iv_ruleLogical= ruleLogical EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1070:2: iv_ruleLogical= ruleLogical EOF
            {
             newCompositeNode(grammarAccess.getLogicalRule()); 
            pushFollow(FOLLOW_ruleLogical_in_entryRuleLogical2247);
            iv_ruleLogical=ruleLogical();

            state._fsp--;

             current =iv_ruleLogical; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogical2257); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1077:1: ruleLogical returns [EObject current=null] : (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* ) ;
    public final EObject ruleLogical() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Equality_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1080:28: ( (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1081:1: (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1081:1: (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1082:5: this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getLogicalAccess().getEqualityParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleEquality_in_ruleLogical2304);
            this_Equality_0=ruleEquality();

            state._fsp--;

             
                    current = this_Equality_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1090:1: ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=28 && LA16_0<=29)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1090:2: ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1090:2: ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) )
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
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1090:3: ( () otherlv_2= '&&' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1090:3: ( () otherlv_2= '&&' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1090:4: () otherlv_2= '&&'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1090:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1091:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleLogical2327); 

            	                	newLeafNode(otherlv_2, grammarAccess.getLogicalAccess().getAmpersandAmpersandKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1101:6: ( () otherlv_4= '||' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1101:6: ( () otherlv_4= '||' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1101:7: () otherlv_4= '||'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1101:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1102:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleLogical2356); 

            	                	newLeafNode(otherlv_4, grammarAccess.getLogicalAccess().getVerticalLineVerticalLineKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1111:3: ( (lv_right_5_0= ruleEquality ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1112:1: (lv_right_5_0= ruleEquality )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1112:1: (lv_right_5_0= ruleEquality )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1113:3: lv_right_5_0= ruleEquality
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalAccess().getRightEqualityParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEquality_in_ruleLogical2379);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1137:1: entryRuleEquality returns [EObject current=null] : iv_ruleEquality= ruleEquality EOF ;
    public final EObject entryRuleEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquality = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1138:2: (iv_ruleEquality= ruleEquality EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1139:2: iv_ruleEquality= ruleEquality EOF
            {
             newCompositeNode(grammarAccess.getEqualityRule()); 
            pushFollow(FOLLOW_ruleEquality_in_entryRuleEquality2417);
            iv_ruleEquality=ruleEquality();

            state._fsp--;

             current =iv_ruleEquality; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquality2427); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1146:1: ruleEquality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEquality() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1149:28: ( (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1150:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1150:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1151:5: this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleComparison_in_ruleEquality2474);
            this_Comparison_0=ruleComparison();

            state._fsp--;

             
                    current = this_Comparison_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1159:1: ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=30 && LA18_0<=31)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1159:2: ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1159:2: ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) )
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
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1159:3: ( () otherlv_2= '==' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1159:3: ( () otherlv_2= '==' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1159:4: () otherlv_2= '=='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1159:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1160:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleEquality2497); 

            	                	newLeafNode(otherlv_2, grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1170:6: ( () otherlv_4= '!=' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1170:6: ( () otherlv_4= '!=' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1170:7: () otherlv_4= '!='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1170:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1171:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleEquality2526); 

            	                	newLeafNode(otherlv_4, grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1180:3: ( (lv_right_5_0= ruleComparison ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1181:1: (lv_right_5_0= ruleComparison )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1181:1: (lv_right_5_0= ruleComparison )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1182:3: lv_right_5_0= ruleComparison
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComparison_in_ruleEquality2549);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1206:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1207:2: (iv_ruleComparison= ruleComparison EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1208:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison2587);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison2597); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1215:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* ) ;
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
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1218:28: ( (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1219:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1219:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1220:5: this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleComparison2644);
            this_Addition_0=ruleAddition();

            state._fsp--;

             
                    current = this_Addition_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1228:1: ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=32 && LA20_0<=35)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1228:2: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1228:2: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) )
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
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1228:3: ( () otherlv_2= '<' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1228:3: ( () otherlv_2= '<' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1228:4: () otherlv_2= '<'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1228:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1229:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleComparison2667); 

            	                	newLeafNode(otherlv_2, grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1239:6: ( () otherlv_4= '<=' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1239:6: ( () otherlv_4= '<=' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1239:7: () otherlv_4= '<='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1239:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1240:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleComparison2696); 

            	                	newLeafNode(otherlv_4, grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1250:6: ( () otherlv_6= '>' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1250:6: ( () otherlv_6= '>' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1250:7: () otherlv_6= '>'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1250:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1251:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0(),
            	                        current);
            	                

            	            }

            	            otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleComparison2725); 

            	                	newLeafNode(otherlv_6, grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1());
            	                

            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1261:6: ( () otherlv_8= '>=' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1261:6: ( () otherlv_8= '>=' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1261:7: () otherlv_8= '>='
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1261:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1262:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0(),
            	                        current);
            	                

            	            }

            	            otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleComparison2754); 

            	                	newLeafNode(otherlv_8, grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_3_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1271:3: ( (lv_right_9_0= ruleAddition ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1272:1: (lv_right_9_0= ruleAddition )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1272:1: (lv_right_9_0= ruleAddition )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1273:3: lv_right_9_0= ruleAddition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAddition_in_ruleComparison2777);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1297:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1298:2: (iv_ruleAddition= ruleAddition EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1299:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition2815);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition2825); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1306:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1309:28: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1310:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1310:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1311:5: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition2872);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;

             
                    current = this_Multiplication_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1319:1: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=36 && LA22_0<=37)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1319:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1319:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
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
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1319:3: ( () otherlv_2= '+' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1319:3: ( () otherlv_2= '+' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1319:4: () otherlv_2= '+'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1319:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1320:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,36,FOLLOW_36_in_ruleAddition2895); 

            	                	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1330:6: ( () otherlv_4= '-' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1330:6: ( () otherlv_4= '-' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1330:7: () otherlv_4= '-'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1330:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1331:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,37,FOLLOW_37_in_ruleAddition2924); 

            	                	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1340:3: ( (lv_right_5_0= ruleMultiplication ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1341:1: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1341:1: (lv_right_5_0= ruleMultiplication )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1342:3: lv_right_5_0= ruleMultiplication
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition2947);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1366:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1367:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1368:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication2985);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication2995); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1375:1: ruleMultiplication returns [EObject current=null] : (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_Unary_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1378:28: ( (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1379:1: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1379:1: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:5: this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleUnary_in_ruleMultiplication3042);
            this_Unary_0=ruleUnary();

            state._fsp--;

             
                    current = this_Unary_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1388:1: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=38 && LA24_0<=40)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1388:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1388:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) )
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
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1388:3: ( () otherlv_2= '*' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1388:3: ( () otherlv_2= '*' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1388:4: () otherlv_2= '*'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1388:4: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1389:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleMultiplication3065); 

            	                	newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1399:6: ( () otherlv_4= '/' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1399:6: ( () otherlv_4= '/' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1399:7: () otherlv_4= '/'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1399:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1400:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleMultiplication3094); 

            	                	newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1410:6: ( () otherlv_6= '%' )
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1410:6: ( () otherlv_6= '%' )
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1410:7: () otherlv_6= '%'
            	            {
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1410:7: ()
            	            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1411:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0(),
            	                        current);
            	                

            	            }

            	            otherlv_6=(Token)match(input,40,FOLLOW_40_in_ruleMultiplication3123); 

            	                	newLeafNode(otherlv_6, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1420:3: ( (lv_right_7_0= ruleUnary ) )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1421:1: (lv_right_7_0= ruleUnary )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1421:1: (lv_right_7_0= ruleUnary )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1422:3: lv_right_7_0= ruleUnary
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnary_in_ruleMultiplication3146);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1446:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1447:2: (iv_ruleUnary= ruleUnary EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1448:2: iv_ruleUnary= ruleUnary EOF
            {
             newCompositeNode(grammarAccess.getUnaryRule()); 
            pushFollow(FOLLOW_ruleUnary_in_entryRuleUnary3184);
            iv_ruleUnary=ruleUnary();

            state._fsp--;

             current =iv_ruleUnary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnary3194); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1455:1: ruleUnary returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_PrimaryExpression_0 = null;

        AntlrDatatypeRuleToken lv_op_4_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1458:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1459:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1459:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID||LA26_0==RULE_NUMBER||LA26_0==15||(LA26_0>=42 && LA26_0<=44)||(LA26_0>=47 && LA26_0<=50)) ) {
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1460:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            newCompositeNode(grammarAccess.getUnaryAccess().getPrimaryExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnary3241);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1469:6: ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1469:6: ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1469:7: ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1469:7: ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) )
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
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1469:8: ( () ( (lv_op_2_0= '!' ) ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1469:8: ( () ( (lv_op_2_0= '!' ) ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1469:9: () ( (lv_op_2_0= '!' ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1469:9: ()
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1470:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getUnaryAccess().getNegationAction_1_0_0_0(),
                                        current);
                                

                            }

                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1475:2: ( (lv_op_2_0= '!' ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1476:1: (lv_op_2_0= '!' )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1476:1: (lv_op_2_0= '!' )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1477:3: lv_op_2_0= '!'
                            {
                            lv_op_2_0=(Token)match(input,41,FOLLOW_41_in_ruleUnary3276); 

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
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1491:6: ( () ( (lv_op_4_0= ruleUnaryOperator ) ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1491:6: ( () ( (lv_op_4_0= ruleUnaryOperator ) ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1491:7: () ( (lv_op_4_0= ruleUnaryOperator ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1491:7: ()
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1492:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getUnaryAccess().getUnaryPlusMinusAction_1_0_1_0(),
                                        current);
                                

                            }

                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1497:2: ( (lv_op_4_0= ruleUnaryOperator ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1498:1: (lv_op_4_0= ruleUnaryOperator )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1498:1: (lv_op_4_0= ruleUnaryOperator )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1499:3: lv_op_4_0= ruleUnaryOperator
                            {
                             
                            	        newCompositeNode(grammarAccess.getUnaryAccess().getOpUnaryOperatorParserRuleCall_1_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnary3327);
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

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1515:4: ( (lv_right_5_0= ruleUnary ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1516:1: (lv_right_5_0= ruleUnary )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1516:1: (lv_right_5_0= ruleUnary )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1517:3: lv_right_5_0= ruleUnary
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryAccess().getRightUnaryParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnary_in_ruleUnary3350);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1541:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1542:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1543:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
             newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator3388);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;

             current =iv_ruleUnaryOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator3399); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1550:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1553:28: ( (kw= '-' | kw= '+' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1554:1: (kw= '-' | kw= '+' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1554:1: (kw= '-' | kw= '+' )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1555:2: kw= '-'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleUnaryOperator3437); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1562:2: kw= '+'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleUnaryOperator3456); 

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


    // $ANTLR start "entryRulePrimaryExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1575:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1576:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1577:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3496);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression3506); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1584:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NativeExpression_2= ruleNativeExpression | this_Reference_3= ruleReference | this_FunctionCall_4= ruleFunctionCall | this_IndexedCall_5= ruleIndexedCall | this_ParenthesizedExpression_6= ruleParenthesizedExpression ) ;
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
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1587:28: ( (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NativeExpression_2= ruleNativeExpression | this_Reference_3= ruleReference | this_FunctionCall_4= ruleFunctionCall | this_IndexedCall_5= ruleIndexedCall | this_ParenthesizedExpression_6= ruleParenthesizedExpression ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1588:1: (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NativeExpression_2= ruleNativeExpression | this_Reference_3= ruleReference | this_FunctionCall_4= ruleFunctionCall | this_IndexedCall_5= ruleIndexedCall | this_ParenthesizedExpression_6= ruleParenthesizedExpression )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1588:1: (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NativeExpression_2= ruleNativeExpression | this_Reference_3= ruleReference | this_FunctionCall_4= ruleFunctionCall | this_IndexedCall_5= ruleIndexedCall | this_ParenthesizedExpression_6= ruleParenthesizedExpression )
            int alt28=7;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1589:5: this_Literal_0= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression3553);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1599:5: this_Range_1= ruleRange
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRangeParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRange_in_rulePrimaryExpression3580);
                    this_Range_1=ruleRange();

                    state._fsp--;

                     
                            current = this_Range_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1609:5: this_NativeExpression_2= ruleNativeExpression
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNativeExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleNativeExpression_in_rulePrimaryExpression3607);
                    this_NativeExpression_2=ruleNativeExpression();

                    state._fsp--;

                     
                            current = this_NativeExpression_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1619:5: this_Reference_3= ruleReference
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getReferenceParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleReference_in_rulePrimaryExpression3634);
                    this_Reference_3=ruleReference();

                    state._fsp--;

                     
                            current = this_Reference_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1629:5: this_FunctionCall_4= ruleFunctionCall
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleFunctionCall_in_rulePrimaryExpression3661);
                    this_FunctionCall_4=ruleFunctionCall();

                    state._fsp--;

                     
                            current = this_FunctionCall_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1639:5: this_IndexedCall_5= ruleIndexedCall
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIndexedCallParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleIndexedCall_in_rulePrimaryExpression3688);
                    this_IndexedCall_5=ruleIndexedCall();

                    state._fsp--;

                     
                            current = this_IndexedCall_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1649:5: this_ParenthesizedExpression_6= ruleParenthesizedExpression
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3715);
                    this_ParenthesizedExpression_6=ruleParenthesizedExpression();

                    state._fsp--;

                     
                            current = this_ParenthesizedExpression_6; 
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1665:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1666:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1667:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3750);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3760); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1674:1: ruleLiteral returns [EObject current=null] : (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_condition_2_0=null;
        Token otherlv_3=null;
        EObject this_NumberLiteral_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1677:28: ( (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1678:1: (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1678:1: (this_NumberLiteral_0= ruleNumberLiteral | ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_NUMBER) ) {
                alt30=1;
            }
            else if ( ((LA30_0>=42 && LA30_0<=43)) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1679:5: this_NumberLiteral_0= ruleNumberLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumberLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteral_in_ruleLiteral3807);
                    this_NumberLiteral_0=ruleNumberLiteral();

                    state._fsp--;

                     
                            current = this_NumberLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1688:6: ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1688:6: ( () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1688:7: () ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1688:7: ()
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1689:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getLiteralAccess().getBooleanLiteralAction_1_0(),
                                current);
                        

                    }

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1694:2: ( ( (lv_condition_2_0= 'true' ) ) | otherlv_3= 'false' )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==42) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==43) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1694:3: ( (lv_condition_2_0= 'true' ) )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1694:3: ( (lv_condition_2_0= 'true' ) )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1695:1: (lv_condition_2_0= 'true' )
                            {
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1695:1: (lv_condition_2_0= 'true' )
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1696:3: lv_condition_2_0= 'true'
                            {
                            lv_condition_2_0=(Token)match(input,42,FOLLOW_42_in_ruleLiteral3841); 

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
                            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1710:7: otherlv_3= 'false'
                            {
                            otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleLiteral3872); 

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1722:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1723:2: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1724:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            pushFollow(FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral3910);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;

             current =iv_ruleNumberLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteral3920); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1731:1: ruleNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1734:28: ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1735:1: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1735:1: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1735:2: () ( (lv_value_1_0= RULE_NUMBER ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1735:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1736:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNumberLiteralAccess().getNumberLiteralAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1741:2: ( (lv_value_1_0= RULE_NUMBER ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1742:1: (lv_value_1_0= RULE_NUMBER )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1742:1: (lv_value_1_0= RULE_NUMBER )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1743:3: lv_value_1_0= RULE_NUMBER
            {
            lv_value_1_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleNumberLiteral3971); 

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


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1767:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1768:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1769:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression4012);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression4022); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1776:1: ruleParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1779:28: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1780:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1780:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1780:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleParenthesizedExpression4059); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression4081);
            this_Expression_1=ruleExpression();

            state._fsp--;

             
                    current = this_Expression_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleParenthesizedExpression4092); 

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


    // $ANTLR start "entryRuleFunctionCall"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1805:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1806:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1807:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall4128);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionCall4138); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1814:1: ruleFunctionCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
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
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1817:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1818:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1818:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1818:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1818:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1819:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionCallAccess().getFunctionCallAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1824:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1825:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1825:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1826:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionCall4192); 

            		newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleFunctionCall4204); 

                	newLeafNode(otherlv_2, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1841:1: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID||LA32_0==RULE_NUMBER||LA32_0==15||(LA32_0>=36 && LA32_0<=37)||(LA32_0>=41 && LA32_0<=44)||(LA32_0>=47 && LA32_0<=50)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1841:2: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1841:2: ( (lv_args_3_0= ruleExpression ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1842:1: (lv_args_3_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1842:1: (lv_args_3_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1843:3: lv_args_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionCall4226);
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

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1859:2: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==16) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1859:4: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleFunctionCall4239); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1863:1: ( (lv_args_5_0= ruleExpression ) )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1864:1: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1864:1: (lv_args_5_0= ruleExpression )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1865:3: lv_args_5_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionCall4260);
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
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleFunctionCall4276); 

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1893:1: entryRuleIndexedCall returns [EObject current=null] : iv_ruleIndexedCall= ruleIndexedCall EOF ;
    public final EObject entryRuleIndexedCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexedCall = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1894:2: (iv_ruleIndexedCall= ruleIndexedCall EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1895:2: iv_ruleIndexedCall= ruleIndexedCall EOF
            {
             newCompositeNode(grammarAccess.getIndexedCallRule()); 
            pushFollow(FOLLOW_ruleIndexedCall_in_entryRuleIndexedCall4312);
            iv_ruleIndexedCall=ruleIndexedCall();

            state._fsp--;

             current =iv_ruleIndexedCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndexedCall4322); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1902:1: ruleIndexedCall returns [EObject current=null] : (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? ) ;
    public final EObject ruleIndexedCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_VarOrArgumentCall_0 = null;

        EObject lv_index_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1905:28: ( (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1906:1: (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1906:1: (this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1907:5: this_VarOrArgumentCall_0= ruleVarOrArgumentCall (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )?
            {
             
                    newCompositeNode(grammarAccess.getIndexedCallAccess().getVarOrArgumentCallParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleVarOrArgumentCall_in_ruleIndexedCall4369);
            this_VarOrArgumentCall_0=ruleVarOrArgumentCall();

            state._fsp--;

             
                    current = this_VarOrArgumentCall_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1915:1: (otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==44) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1915:3: otherlv_1= '[' ( (lv_index_2_0= ruleExpression ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleIndexedCall4381); 

                        	newLeafNode(otherlv_1, grammarAccess.getIndexedCallAccess().getLeftSquareBracketKeyword_1_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1919:1: ( (lv_index_2_0= ruleExpression ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1920:1: (lv_index_2_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1920:1: (lv_index_2_0= ruleExpression )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1921:3: lv_index_2_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getIndexedCallAccess().getIndexExpressionParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleIndexedCall4402);
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

                    otherlv_3=(Token)match(input,45,FOLLOW_45_in_ruleIndexedCall4414); 

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


    // $ANTLR start "entryRuleNativeExpression"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1949:1: entryRuleNativeExpression returns [EObject current=null] : iv_ruleNativeExpression= ruleNativeExpression EOF ;
    public final EObject entryRuleNativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNativeExpression = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1950:2: (iv_ruleNativeExpression= ruleNativeExpression EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1951:2: iv_ruleNativeExpression= ruleNativeExpression EOF
            {
             newCompositeNode(grammarAccess.getNativeExpressionRule()); 
            pushFollow(FOLLOW_ruleNativeExpression_in_entryRuleNativeExpression4452);
            iv_ruleNativeExpression=ruleNativeExpression();

            state._fsp--;

             current =iv_ruleNativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNativeExpression4462); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1958:1: ruleNativeExpression returns [EObject current=null] : ( () ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) | ( (lv_var_3_0= ruleVarOrArgumentCall ) ) ) otherlv_4= '.' ( (lv_nativeFunction_5_0= ruleNativeFunction ) ) ) ;
    public final EObject ruleNativeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        EObject lv_range_1_0 = null;

        EObject lv_ref_2_0 = null;

        EObject lv_var_3_0 = null;

        Enumerator lv_nativeFunction_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1961:28: ( ( () ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) | ( (lv_var_3_0= ruleVarOrArgumentCall ) ) ) otherlv_4= '.' ( (lv_nativeFunction_5_0= ruleNativeFunction ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1962:1: ( () ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) | ( (lv_var_3_0= ruleVarOrArgumentCall ) ) ) otherlv_4= '.' ( (lv_nativeFunction_5_0= ruleNativeFunction ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1962:1: ( () ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) | ( (lv_var_3_0= ruleVarOrArgumentCall ) ) ) otherlv_4= '.' ( (lv_nativeFunction_5_0= ruleNativeFunction ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1962:2: () ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) | ( (lv_var_3_0= ruleVarOrArgumentCall ) ) ) otherlv_4= '.' ( (lv_nativeFunction_5_0= ruleNativeFunction ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1962:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1963:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNativeExpressionAccess().getNativeExpressionAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1968:2: ( ( (lv_range_1_0= ruleRangeLiteral ) ) | ( (lv_ref_2_0= ruleReference ) ) | ( (lv_var_3_0= ruleVarOrArgumentCall ) ) )
            int alt34=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt34=1;
                }
                break;
            case 47:
            case 48:
            case 49:
            case 50:
                {
                alt34=2;
                }
                break;
            case RULE_ID:
                {
                alt34=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1968:3: ( (lv_range_1_0= ruleRangeLiteral ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1968:3: ( (lv_range_1_0= ruleRangeLiteral ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1969:1: (lv_range_1_0= ruleRangeLiteral )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1969:1: (lv_range_1_0= ruleRangeLiteral )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1970:3: lv_range_1_0= ruleRangeLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getNativeExpressionAccess().getRangeRangeLiteralParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRangeLiteral_in_ruleNativeExpression4518);
                    lv_range_1_0=ruleRangeLiteral();

                    state._fsp--;


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
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1987:6: ( (lv_ref_2_0= ruleReference ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1987:6: ( (lv_ref_2_0= ruleReference ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1988:1: (lv_ref_2_0= ruleReference )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1988:1: (lv_ref_2_0= ruleReference )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1989:3: lv_ref_2_0= ruleReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getNativeExpressionAccess().getRefReferenceParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleReference_in_ruleNativeExpression4545);
                    lv_ref_2_0=ruleReference();

                    state._fsp--;


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
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2006:6: ( (lv_var_3_0= ruleVarOrArgumentCall ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2006:6: ( (lv_var_3_0= ruleVarOrArgumentCall ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2007:1: (lv_var_3_0= ruleVarOrArgumentCall )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2007:1: (lv_var_3_0= ruleVarOrArgumentCall )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2008:3: lv_var_3_0= ruleVarOrArgumentCall
                    {
                     
                    	        newCompositeNode(grammarAccess.getNativeExpressionAccess().getVarVarOrArgumentCallParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVarOrArgumentCall_in_ruleNativeExpression4572);
                    lv_var_3_0=ruleVarOrArgumentCall();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNativeExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"var",
                            		lv_var_3_0, 
                            		"VarOrArgumentCall");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleNativeExpression4585); 

                	newLeafNode(otherlv_4, grammarAccess.getNativeExpressionAccess().getFullStopKeyword_2());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2028:1: ( (lv_nativeFunction_5_0= ruleNativeFunction ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2029:1: (lv_nativeFunction_5_0= ruleNativeFunction )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2029:1: (lv_nativeFunction_5_0= ruleNativeFunction )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2030:3: lv_nativeFunction_5_0= ruleNativeFunction
            {
             
            	        newCompositeNode(grammarAccess.getNativeExpressionAccess().getNativeFunctionNativeFunctionEnumRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleNativeFunction_in_ruleNativeExpression4606);
            lv_nativeFunction_5_0=ruleNativeFunction();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNativeExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"nativeFunction",
                    		lv_nativeFunction_5_0, 
                    		"NativeFunction");
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
    // $ANTLR end "ruleNativeExpression"


    // $ANTLR start "entryRuleVarOrArgumentCall"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2054:1: entryRuleVarOrArgumentCall returns [EObject current=null] : iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF ;
    public final EObject entryRuleVarOrArgumentCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarOrArgumentCall = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2055:2: (iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2056:2: iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF
            {
             newCompositeNode(grammarAccess.getVarOrArgumentCallRule()); 
            pushFollow(FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall4642);
            iv_ruleVarOrArgumentCall=ruleVarOrArgumentCall();

            state._fsp--;

             current =iv_ruleVarOrArgumentCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarOrArgumentCall4652); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2063:1: ruleVarOrArgumentCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleVarOrArgumentCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2066:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2067:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2067:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2067:2: () ( (otherlv_1= RULE_ID ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2067:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2068:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVarOrArgumentCallAccess().getVarOrArgumentCallAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2073:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2074:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2074:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2075:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVarOrArgumentCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarOrArgumentCall4706); 

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


    // $ANTLR start "entryRuleRange"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2094:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2095:2: (iv_ruleRange= ruleRange EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2096:2: iv_ruleRange= ruleRange EOF
            {
             newCompositeNode(grammarAccess.getRangeRule()); 
            pushFollow(FOLLOW_ruleRange_in_entryRuleRange4742);
            iv_ruleRange=ruleRange();

            state._fsp--;

             current =iv_ruleRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRange4752); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2103:1: ruleRange returns [EObject current=null] : this_RangeLiteral_0= ruleRangeLiteral ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        EObject this_RangeLiteral_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2106:28: (this_RangeLiteral_0= ruleRangeLiteral )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2108:5: this_RangeLiteral_0= ruleRangeLiteral
            {
             
                    newCompositeNode(grammarAccess.getRangeAccess().getRangeLiteralParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleRangeLiteral_in_ruleRange4798);
            this_RangeLiteral_0=ruleRangeLiteral();

            state._fsp--;

             
                    current = this_RangeLiteral_0; 
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
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleRangeLiteral"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2124:1: entryRuleRangeLiteral returns [EObject current=null] : iv_ruleRangeLiteral= ruleRangeLiteral EOF ;
    public final EObject entryRuleRangeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeLiteral = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2125:2: (iv_ruleRangeLiteral= ruleRangeLiteral EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2126:2: iv_ruleRangeLiteral= ruleRangeLiteral EOF
            {
             newCompositeNode(grammarAccess.getRangeLiteralRule()); 
            pushFollow(FOLLOW_ruleRangeLiteral_in_entryRuleRangeLiteral4832);
            iv_ruleRangeLiteral=ruleRangeLiteral();

            state._fsp--;

             current =iv_ruleRangeLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeLiteral4842); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2133:1: ruleRangeLiteral returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleRangeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_values_2_0=null;
        Token otherlv_3=null;
        Token lv_values_4_0=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2136:28: ( ( () otherlv_1= '[' ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )? otherlv_5= ']' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2137:1: ( () otherlv_1= '[' ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )? otherlv_5= ']' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2137:1: ( () otherlv_1= '[' ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )? otherlv_5= ']' )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2137:2: () otherlv_1= '[' ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )? otherlv_5= ']'
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2137:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2138:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRangeLiteralAccess().getRangeLiteralAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,44,FOLLOW_44_in_ruleRangeLiteral4888); 

                	newLeafNode(otherlv_1, grammarAccess.getRangeLiteralAccess().getLeftSquareBracketKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2147:1: ( ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_NUMBER) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2147:2: ( (lv_values_2_0= RULE_NUMBER ) ) (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )*
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2147:2: ( (lv_values_2_0= RULE_NUMBER ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2148:1: (lv_values_2_0= RULE_NUMBER )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2148:1: (lv_values_2_0= RULE_NUMBER )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2149:3: lv_values_2_0= RULE_NUMBER
                    {
                    lv_values_2_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4906); 

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

                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2165:2: (otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==16) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2165:4: otherlv_3= ',' ( (lv_values_4_0= RULE_NUMBER ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleRangeLiteral4924); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getRangeLiteralAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2169:1: ( (lv_values_4_0= RULE_NUMBER ) )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2170:1: (lv_values_4_0= RULE_NUMBER )
                    	    {
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2170:1: (lv_values_4_0= RULE_NUMBER )
                    	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2171:3: lv_values_4_0= RULE_NUMBER
                    	    {
                    	    lv_values_4_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4941); 

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
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,45,FOLLOW_45_in_ruleRangeLiteral4962); 

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


    // $ANTLR start "entryRuleReference"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2199:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2200:2: (iv_ruleReference= ruleReference EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2201:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference4998);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference5008); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2208:1: ruleReference returns [EObject current=null] : (this_ContextRef_0= ruleContextRef | this_NodeTypeRef_1= ruleNodeTypeRef | this_NodeRef_2= ruleNodeRef | this_ParamRef_3= ruleParamRef ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        EObject this_ContextRef_0 = null;

        EObject this_NodeTypeRef_1 = null;

        EObject this_NodeRef_2 = null;

        EObject this_ParamRef_3 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2211:28: ( (this_ContextRef_0= ruleContextRef | this_NodeTypeRef_1= ruleNodeTypeRef | this_NodeRef_2= ruleNodeRef | this_ParamRef_3= ruleParamRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2212:1: (this_ContextRef_0= ruleContextRef | this_NodeTypeRef_1= ruleNodeTypeRef | this_NodeRef_2= ruleNodeRef | this_ParamRef_3= ruleParamRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2212:1: (this_ContextRef_0= ruleContextRef | this_NodeTypeRef_1= ruleNodeTypeRef | this_NodeRef_2= ruleNodeRef | this_ParamRef_3= ruleParamRef )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2213:5: this_ContextRef_0= ruleContextRef
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceAccess().getContextRefParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleContextRef_in_ruleReference5055);
                    this_ContextRef_0=ruleContextRef();

                    state._fsp--;

                     
                            current = this_ContextRef_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2223:5: this_NodeTypeRef_1= ruleNodeTypeRef
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceAccess().getNodeTypeRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNodeTypeRef_in_ruleReference5082);
                    this_NodeTypeRef_1=ruleNodeTypeRef();

                    state._fsp--;

                     
                            current = this_NodeTypeRef_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2233:5: this_NodeRef_2= ruleNodeRef
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceAccess().getNodeRefParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleNodeRef_in_ruleReference5109);
                    this_NodeRef_2=ruleNodeRef();

                    state._fsp--;

                     
                            current = this_NodeRef_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2243:5: this_ParamRef_3= ruleParamRef
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceAccess().getParamRefParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleParamRef_in_ruleReference5136);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2259:1: entryRuleParamRef returns [EObject current=null] : iv_ruleParamRef= ruleParamRef EOF ;
    public final EObject entryRuleParamRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2260:2: (iv_ruleParamRef= ruleParamRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2261:2: iv_ruleParamRef= ruleParamRef EOF
            {
             newCompositeNode(grammarAccess.getParamRefRule()); 
            pushFollow(FOLLOW_ruleParamRef_in_entryRuleParamRef5171);
            iv_ruleParamRef=ruleParamRef();

            state._fsp--;

             current =iv_ruleParamRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamRef5181); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2268:1: ruleParamRef returns [EObject current=null] : ( () otherlv_1= 'PARAM' ( ( ruleFQN ) ) ) ;
    public final EObject ruleParamRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2271:28: ( ( () otherlv_1= 'PARAM' ( ( ruleFQN ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2272:1: ( () otherlv_1= 'PARAM' ( ( ruleFQN ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2272:1: ( () otherlv_1= 'PARAM' ( ( ruleFQN ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2272:2: () otherlv_1= 'PARAM' ( ( ruleFQN ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2272:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2273:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getParamRefAccess().getParamRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleParamRef5227); 

                	newLeafNode(otherlv_1, grammarAccess.getParamRefAccess().getPARAMKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2282:1: ( ( ruleFQN ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2283:1: ( ruleFQN )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2283:1: ( ruleFQN )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2284:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getParamRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getParamRefAccess().getParamParameterCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleParamRef5250);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2305:1: entryRuleNodeTypeRef returns [EObject current=null] : iv_ruleNodeTypeRef= ruleNodeTypeRef EOF ;
    public final EObject entryRuleNodeTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeTypeRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2306:2: (iv_ruleNodeTypeRef= ruleNodeTypeRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2307:2: iv_ruleNodeTypeRef= ruleNodeTypeRef EOF
            {
             newCompositeNode(grammarAccess.getNodeTypeRefRule()); 
            pushFollow(FOLLOW_ruleNodeTypeRef_in_entryRuleNodeTypeRef5286);
            iv_ruleNodeTypeRef=ruleNodeTypeRef();

            state._fsp--;

             current =iv_ruleNodeTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeTypeRef5296); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2314:1: ruleNodeTypeRef returns [EObject current=null] : ( () otherlv_1= 'NETYPE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) ) ;
    public final EObject ruleNodeTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_primaryRef_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2317:28: ( ( () otherlv_1= 'NETYPE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2318:1: ( () otherlv_1= 'NETYPE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2318:1: ( () otherlv_1= 'NETYPE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2318:2: () otherlv_1= 'NETYPE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2318:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2319:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNodeTypeRefAccess().getNodeTypeRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,48,FOLLOW_48_in_ruleNodeTypeRef5342); 

                	newLeafNode(otherlv_1, grammarAccess.getNodeTypeRefAccess().getNETYPEKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2328:1: ( (otherlv_2= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2329:1: (otherlv_2= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2329:1: (otherlv_2= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2330:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeTypeRefRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNodeTypeRef5362); 

            		newLeafNode(otherlv_2, grammarAccess.getNodeTypeRefAccess().getNodetypeNodeTypeCrossReference_2_0()); 
            	

            }


            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2341:2: ( (lv_primaryRef_3_0= rulePrimaryRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2342:1: (lv_primaryRef_3_0= rulePrimaryRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2342:1: (lv_primaryRef_3_0= rulePrimaryRef )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2343:3: lv_primaryRef_3_0= rulePrimaryRef
            {
             
            	        newCompositeNode(grammarAccess.getNodeTypeRefAccess().getPrimaryRefPrimaryRefParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_rulePrimaryRef_in_ruleNodeTypeRef5383);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2367:1: entryRuleNodeRef returns [EObject current=null] : iv_ruleNodeRef= ruleNodeRef EOF ;
    public final EObject entryRuleNodeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2368:2: (iv_ruleNodeRef= ruleNodeRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2369:2: iv_ruleNodeRef= ruleNodeRef EOF
            {
             newCompositeNode(grammarAccess.getNodeRefRule()); 
            pushFollow(FOLLOW_ruleNodeRef_in_entryRuleNodeRef5419);
            iv_ruleNodeRef=ruleNodeRef();

            state._fsp--;

             current =iv_ruleNodeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeRef5429); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2376:1: ruleNodeRef returns [EObject current=null] : ( () otherlv_1= 'NE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) ) ;
    public final EObject ruleNodeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_primaryRef_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2379:28: ( ( () otherlv_1= 'NE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2380:1: ( () otherlv_1= 'NE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2380:1: ( () otherlv_1= 'NE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2380:2: () otherlv_1= 'NE' ( (otherlv_2= RULE_ID ) ) ( (lv_primaryRef_3_0= rulePrimaryRef ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2380:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2381:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNodeRefAccess().getNodeRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,49,FOLLOW_49_in_ruleNodeRef5475); 

                	newLeafNode(otherlv_1, grammarAccess.getNodeRefAccess().getNEKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2390:1: ( (otherlv_2= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2391:1: (otherlv_2= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2391:1: (otherlv_2= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2392:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeRefRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNodeRef5495); 

            		newLeafNode(otherlv_2, grammarAccess.getNodeRefAccess().getNodeNodeCrossReference_2_0()); 
            	

            }


            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2403:2: ( (lv_primaryRef_3_0= rulePrimaryRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2404:1: (lv_primaryRef_3_0= rulePrimaryRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2404:1: (lv_primaryRef_3_0= rulePrimaryRef )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2405:3: lv_primaryRef_3_0= rulePrimaryRef
            {
             
            	        newCompositeNode(grammarAccess.getNodeRefAccess().getPrimaryRefPrimaryRefParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_rulePrimaryRef_in_ruleNodeRef5516);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2429:1: entryRuleContextRef returns [EObject current=null] : iv_ruleContextRef= ruleContextRef EOF ;
    public final EObject entryRuleContextRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2430:2: (iv_ruleContextRef= ruleContextRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2431:2: iv_ruleContextRef= ruleContextRef EOF
            {
             newCompositeNode(grammarAccess.getContextRefRule()); 
            pushFollow(FOLLOW_ruleContextRef_in_entryRuleContextRef5552);
            iv_ruleContextRef=ruleContextRef();

            state._fsp--;

             current =iv_ruleContextRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextRef5562); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2438:1: ruleContextRef returns [EObject current=null] : ( () otherlv_1= 'this' ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) ) ) ;
    public final EObject ruleContextRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_primaryRef_2_0 = null;

        EObject lv_rangeRef_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2441:28: ( ( () otherlv_1= 'this' ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2442:1: ( () otherlv_1= 'this' ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2442:1: ( () otherlv_1= 'this' ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2442:2: () otherlv_1= 'this' ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2442:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2443:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getContextRefAccess().getContextRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleContextRef5608); 

                	newLeafNode(otherlv_1, grammarAccess.getContextRefAccess().getThisKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2452:1: ( ( (lv_primaryRef_2_0= rulePrimaryRef ) ) | ( (lv_rangeRef_3_0= ruleRangeRef ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==39) ) {
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2452:2: ( (lv_primaryRef_2_0= rulePrimaryRef ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2452:2: ( (lv_primaryRef_2_0= rulePrimaryRef ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2453:1: (lv_primaryRef_2_0= rulePrimaryRef )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2453:1: (lv_primaryRef_2_0= rulePrimaryRef )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2454:3: lv_primaryRef_2_0= rulePrimaryRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getContextRefAccess().getPrimaryRefPrimaryRefParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryRef_in_ruleContextRef5630);
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2471:6: ( (lv_rangeRef_3_0= ruleRangeRef ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2471:6: ( (lv_rangeRef_3_0= ruleRangeRef ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2472:1: (lv_rangeRef_3_0= ruleRangeRef )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2472:1: (lv_rangeRef_3_0= ruleRangeRef )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2473:3: lv_rangeRef_3_0= ruleRangeRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getContextRefAccess().getRangeRefRangeRefParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRangeRef_in_ruleContextRef5657);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2497:1: entryRulePrimaryRef returns [EObject current=null] : iv_rulePrimaryRef= rulePrimaryRef EOF ;
    public final EObject entryRulePrimaryRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2498:2: (iv_rulePrimaryRef= rulePrimaryRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2499:2: iv_rulePrimaryRef= rulePrimaryRef EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRefRule()); 
            pushFollow(FOLLOW_rulePrimaryRef_in_entryRulePrimaryRef5694);
            iv_rulePrimaryRef=rulePrimaryRef();

            state._fsp--;

             current =iv_rulePrimaryRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryRef5704); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2506:1: rulePrimaryRef returns [EObject current=null] : ( ( (lv_components_0_0= ruleOperatorRef ) )+ (otherlv_1= '->' ( (lv_leafRef_2_0= ruleLeafReference ) ) )? ) ;
    public final EObject rulePrimaryRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_components_0_0 = null;

        EObject lv_leafRef_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2509:28: ( ( ( (lv_components_0_0= ruleOperatorRef ) )+ (otherlv_1= '->' ( (lv_leafRef_2_0= ruleLeafReference ) ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2510:1: ( ( (lv_components_0_0= ruleOperatorRef ) )+ (otherlv_1= '->' ( (lv_leafRef_2_0= ruleLeafReference ) ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2510:1: ( ( (lv_components_0_0= ruleOperatorRef ) )+ (otherlv_1= '->' ( (lv_leafRef_2_0= ruleLeafReference ) ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2510:2: ( (lv_components_0_0= ruleOperatorRef ) )+ (otherlv_1= '->' ( (lv_leafRef_2_0= ruleLeafReference ) ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2510:2: ( (lv_components_0_0= ruleOperatorRef ) )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==39) ) {
                    int LA39_2 = input.LA(2);

                    if ( ((LA39_2>=52 && LA39_2<=55)) ) {
                        alt39=1;
                    }


                }


                switch (alt39) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2511:1: (lv_components_0_0= ruleOperatorRef )
            	    {
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2511:1: (lv_components_0_0= ruleOperatorRef )
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2512:3: lv_components_0_0= ruleOperatorRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPrimaryRefAccess().getComponentsOperatorRefParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOperatorRef_in_rulePrimaryRef5750);
            	    lv_components_0_0=ruleOperatorRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPrimaryRefRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"components",
            	            		lv_components_0_0, 
            	            		"OperatorRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2528:3: (otherlv_1= '->' ( (lv_leafRef_2_0= ruleLeafReference ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==51) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2528:5: otherlv_1= '->' ( (lv_leafRef_2_0= ruleLeafReference ) )
                    {
                    otherlv_1=(Token)match(input,51,FOLLOW_51_in_rulePrimaryRef5764); 

                        	newLeafNode(otherlv_1, grammarAccess.getPrimaryRefAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2532:1: ( (lv_leafRef_2_0= ruleLeafReference ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2533:1: (lv_leafRef_2_0= ruleLeafReference )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2533:1: (lv_leafRef_2_0= ruleLeafReference )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2534:3: lv_leafRef_2_0= ruleLeafReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimaryRefAccess().getLeafRefLeafReferenceParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLeafReference_in_rulePrimaryRef5785);
                    lv_leafRef_2_0=ruleLeafReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimaryRefRule());
                    	        }
                           		set(
                           			current, 
                           			"leafRef",
                            		lv_leafRef_2_0, 
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


    // $ANTLR start "entryRuleOperatorRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2558:1: entryRuleOperatorRef returns [EObject current=null] : iv_ruleOperatorRef= ruleOperatorRef EOF ;
    public final EObject entryRuleOperatorRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperatorRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2559:2: (iv_ruleOperatorRef= ruleOperatorRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2560:2: iv_ruleOperatorRef= ruleOperatorRef EOF
            {
             newCompositeNode(grammarAccess.getOperatorRefRule()); 
            pushFollow(FOLLOW_ruleOperatorRef_in_entryRuleOperatorRef5823);
            iv_ruleOperatorRef=ruleOperatorRef();

            state._fsp--;

             current =iv_ruleOperatorRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperatorRef5833); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperatorRef"


    // $ANTLR start "ruleOperatorRef"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2567:1: ruleOperatorRef returns [EObject current=null] : ( () otherlv_1= '/' ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' ) ) ;
    public final EObject ruleOperatorRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2570:28: ( ( () otherlv_1= '/' ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2571:1: ( () otherlv_1= '/' ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2571:1: ( () otherlv_1= '/' ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2571:2: () otherlv_1= '/' ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2571:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2572:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOperatorRefAccess().getOperatorRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleOperatorRef5879); 

                	newLeafNode(otherlv_1, grammarAccess.getOperatorRefAccess().getSolidusKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2581:1: ( (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) ) | (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) ) | otherlv_6= 'PROFILE' | otherlv_7= 'STATUS' )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2581:2: (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2581:2: (otherlv_2= 'FUNCTION' ( ( ruleFQN ) ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2581:4: otherlv_2= 'FUNCTION' ( ( ruleFQN ) )
                    {
                    otherlv_2=(Token)match(input,52,FOLLOW_52_in_ruleOperatorRef5893); 

                        	newLeafNode(otherlv_2, grammarAccess.getOperatorRefAccess().getFUNCTIONKeyword_2_0_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2585:1: ( ( ruleFQN ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2586:1: ( ruleFQN )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2586:1: ( ruleFQN )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2587:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOperatorRefRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getOperatorRefAccess().getFunctionFunctionCrossReference_2_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleOperatorRef5916);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2601:6: (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2601:6: (otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2601:8: otherlv_4= 'EQUIPMENT' ( ( ruleFQN ) )
                    {
                    otherlv_4=(Token)match(input,53,FOLLOW_53_in_ruleOperatorRef5936); 

                        	newLeafNode(otherlv_4, grammarAccess.getOperatorRefAccess().getEQUIPMENTKeyword_2_1_0());
                        
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2605:1: ( ( ruleFQN ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2606:1: ( ruleFQN )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2606:1: ( ruleFQN )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2607:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOperatorRefRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getOperatorRefAccess().getEquipmentEquipmentCrossReference_2_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleOperatorRef5959);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2621:7: otherlv_6= 'PROFILE'
                    {
                    otherlv_6=(Token)match(input,54,FOLLOW_54_in_ruleOperatorRef5978); 

                        	newLeafNode(otherlv_6, grammarAccess.getOperatorRefAccess().getPROFILEKeyword_2_2());
                        

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2626:7: otherlv_7= 'STATUS'
                    {
                    otherlv_7=(Token)match(input,55,FOLLOW_55_in_ruleOperatorRef5996); 

                        	newLeafNode(otherlv_7, grammarAccess.getOperatorRefAccess().getSTATUSKeyword_2_3());
                        

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
    // $ANTLR end "ruleOperatorRef"


    // $ANTLR start "entryRuleLeafReference"
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2638:1: entryRuleLeafReference returns [EObject current=null] : iv_ruleLeafReference= ruleLeafReference EOF ;
    public final EObject entryRuleLeafReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeafReference = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2639:2: (iv_ruleLeafReference= ruleLeafReference EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2640:2: iv_ruleLeafReference= ruleLeafReference EOF
            {
             newCompositeNode(grammarAccess.getLeafReferenceRule()); 
            pushFollow(FOLLOW_ruleLeafReference_in_entryRuleLeafReference6033);
            iv_ruleLeafReference=ruleLeafReference();

            state._fsp--;

             current =iv_ruleLeafReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLeafReference6043); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2647:1: ruleLeafReference returns [EObject current=null] : (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef | this_StatusRef_2= ruleStatusRef ) ;
    public final EObject ruleLeafReference() throws RecognitionException {
        EObject current = null;

        EObject this_ResourceRef_0 = null;

        EObject this_LinkRef_1 = null;

        EObject this_StatusRef_2 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2650:28: ( (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef | this_StatusRef_2= ruleStatusRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2651:1: (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef | this_StatusRef_2= ruleStatusRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2651:1: (this_ResourceRef_0= ruleResourceRef | this_LinkRef_1= ruleLinkRef | this_StatusRef_2= ruleStatusRef )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2652:5: this_ResourceRef_0= ruleResourceRef
                    {
                     
                            newCompositeNode(grammarAccess.getLeafReferenceAccess().getResourceRefParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleResourceRef_in_ruleLeafReference6090);
                    this_ResourceRef_0=ruleResourceRef();

                    state._fsp--;

                     
                            current = this_ResourceRef_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2662:5: this_LinkRef_1= ruleLinkRef
                    {
                     
                            newCompositeNode(grammarAccess.getLeafReferenceAccess().getLinkRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleLinkRef_in_ruleLeafReference6117);
                    this_LinkRef_1=ruleLinkRef();

                    state._fsp--;

                     
                            current = this_LinkRef_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2672:5: this_StatusRef_2= ruleStatusRef
                    {
                     
                            newCompositeNode(grammarAccess.getLeafReferenceAccess().getStatusRefParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStatusRef_in_ruleLeafReference6144);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2688:1: entryRuleResourceRef returns [EObject current=null] : iv_ruleResourceRef= ruleResourceRef EOF ;
    public final EObject entryRuleResourceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2689:2: (iv_ruleResourceRef= ruleResourceRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2690:2: iv_ruleResourceRef= ruleResourceRef EOF
            {
             newCompositeNode(grammarAccess.getResourceRefRule()); 
            pushFollow(FOLLOW_ruleResourceRef_in_entryRuleResourceRef6179);
            iv_ruleResourceRef=ruleResourceRef();

            state._fsp--;

             current =iv_ruleResourceRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceRef6189); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2697:1: ruleResourceRef returns [EObject current=null] : ( () otherlv_1= 'RESOURCE' ( ( ( ruleFQN ) ) | ( (lv_all_3_0= 'ALL' ) ) ) ( (lv_rangeRef_4_0= ruleRangeRef ) ) ) ;
    public final EObject ruleResourceRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_all_3_0=null;
        EObject lv_rangeRef_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2700:28: ( ( () otherlv_1= 'RESOURCE' ( ( ( ruleFQN ) ) | ( (lv_all_3_0= 'ALL' ) ) ) ( (lv_rangeRef_4_0= ruleRangeRef ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2701:1: ( () otherlv_1= 'RESOURCE' ( ( ( ruleFQN ) ) | ( (lv_all_3_0= 'ALL' ) ) ) ( (lv_rangeRef_4_0= ruleRangeRef ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2701:1: ( () otherlv_1= 'RESOURCE' ( ( ( ruleFQN ) ) | ( (lv_all_3_0= 'ALL' ) ) ) ( (lv_rangeRef_4_0= ruleRangeRef ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2701:2: () otherlv_1= 'RESOURCE' ( ( ( ruleFQN ) ) | ( (lv_all_3_0= 'ALL' ) ) ) ( (lv_rangeRef_4_0= ruleRangeRef ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2701:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2702:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getResourceRefAccess().getResourceRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleResourceRef6235); 

                	newLeafNode(otherlv_1, grammarAccess.getResourceRefAccess().getRESOURCEKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2711:1: ( ( ( ruleFQN ) ) | ( (lv_all_3_0= 'ALL' ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID||LA43_0==RULE_NUMBER) ) {
                alt43=1;
            }
            else if ( (LA43_0==57) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2711:2: ( ( ruleFQN ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2711:2: ( ( ruleFQN ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2712:1: ( ruleFQN )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2712:1: ( ruleFQN )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2713:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getResourceRefRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getResourceRefAccess().getResourceBaseResourceCrossReference_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFQN_in_ruleResourceRef6259);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2727:6: ( (lv_all_3_0= 'ALL' ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2727:6: ( (lv_all_3_0= 'ALL' ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2728:1: (lv_all_3_0= 'ALL' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2728:1: (lv_all_3_0= 'ALL' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2729:3: lv_all_3_0= 'ALL'
                    {
                    lv_all_3_0=(Token)match(input,57,FOLLOW_57_in_ruleResourceRef6283); 

                            newLeafNode(lv_all_3_0, grammarAccess.getResourceRefAccess().getAllALLKeyword_2_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResourceRefRule());
                    	        }
                           		setWithLastConsumed(current, "all", true, "ALL");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2742:3: ( (lv_rangeRef_4_0= ruleRangeRef ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2743:1: (lv_rangeRef_4_0= ruleRangeRef )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2743:1: (lv_rangeRef_4_0= ruleRangeRef )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2744:3: lv_rangeRef_4_0= ruleRangeRef
            {
             
            	        newCompositeNode(grammarAccess.getResourceRefAccess().getRangeRefRangeRefParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleRangeRef_in_ruleResourceRef6318);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2768:1: entryRuleStatusRef returns [EObject current=null] : iv_ruleStatusRef= ruleStatusRef EOF ;
    public final EObject entryRuleStatusRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatusRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2769:2: (iv_ruleStatusRef= ruleStatusRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2770:2: iv_ruleStatusRef= ruleStatusRef EOF
            {
             newCompositeNode(grammarAccess.getStatusRefRule()); 
            pushFollow(FOLLOW_ruleStatusRef_in_entryRuleStatusRef6354);
            iv_ruleStatusRef=ruleStatusRef();

            state._fsp--;

             current =iv_ruleStatusRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatusRef6364); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2777:1: ruleStatusRef returns [EObject current=null] : ( () ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) ) ) ;
    public final EObject ruleStatusRef() throws RecognitionException {
        EObject current = null;

        Enumerator lv_tolerancelevel_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2780:28: ( ( () ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2781:1: ( () ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2781:1: ( () ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2781:2: () ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2781:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2782:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStatusRefAccess().getStatusRefAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2787:2: ( (lv_tolerancelevel_1_0= ruleToleranceLevel ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2788:1: (lv_tolerancelevel_1_0= ruleToleranceLevel )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2788:1: (lv_tolerancelevel_1_0= ruleToleranceLevel )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2789:3: lv_tolerancelevel_1_0= ruleToleranceLevel
            {
             
            	        newCompositeNode(grammarAccess.getStatusRefAccess().getTolerancelevelToleranceLevelEnumRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleToleranceLevel_in_ruleStatusRef6419);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2813:1: entryRuleRangeRef returns [EObject current=null] : iv_ruleRangeRef= ruleRangeRef EOF ;
    public final EObject entryRuleRangeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2814:2: (iv_ruleRangeRef= ruleRangeRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2815:2: iv_ruleRangeRef= ruleRangeRef EOF
            {
             newCompositeNode(grammarAccess.getRangeRefRule()); 
            pushFollow(FOLLOW_ruleRangeRef_in_entryRuleRangeRef6455);
            iv_ruleRangeRef=ruleRangeRef();

            state._fsp--;

             current =iv_ruleRangeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeRef6465); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2822:1: ruleRangeRef returns [EObject current=null] : ( ( (lv_valuerange_0_0= ruleValueRange ) ) ( (lv_kind_1_0= ruleValueKind ) )? ( (lv_interval_2_0= ruleInterval ) )? ) ;
    public final EObject ruleRangeRef() throws RecognitionException {
        EObject current = null;

        Enumerator lv_valuerange_0_0 = null;

        Enumerator lv_kind_1_0 = null;

        EObject lv_interval_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2825:28: ( ( ( (lv_valuerange_0_0= ruleValueRange ) ) ( (lv_kind_1_0= ruleValueKind ) )? ( (lv_interval_2_0= ruleInterval ) )? ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2826:1: ( ( (lv_valuerange_0_0= ruleValueRange ) ) ( (lv_kind_1_0= ruleValueKind ) )? ( (lv_interval_2_0= ruleInterval ) )? )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2826:1: ( ( (lv_valuerange_0_0= ruleValueRange ) ) ( (lv_kind_1_0= ruleValueKind ) )? ( (lv_interval_2_0= ruleInterval ) )? )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2826:2: ( (lv_valuerange_0_0= ruleValueRange ) ) ( (lv_kind_1_0= ruleValueKind ) )? ( (lv_interval_2_0= ruleInterval ) )?
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2826:2: ( (lv_valuerange_0_0= ruleValueRange ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2827:1: (lv_valuerange_0_0= ruleValueRange )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2827:1: (lv_valuerange_0_0= ruleValueRange )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2828:3: lv_valuerange_0_0= ruleValueRange
            {
             
            	        newCompositeNode(grammarAccess.getRangeRefAccess().getValuerangeValueRangeEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleValueRange_in_ruleRangeRef6511);
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

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2844:2: ( (lv_kind_1_0= ruleValueKind ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=84 && LA44_0<=85)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2845:1: (lv_kind_1_0= ruleValueKind )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2845:1: (lv_kind_1_0= ruleValueKind )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2846:3: lv_kind_1_0= ruleValueKind
                    {
                     
                    	        newCompositeNode(grammarAccess.getRangeRefAccess().getKindValueKindEnumRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueKind_in_ruleRangeRef6532);
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

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2862:3: ( (lv_interval_2_0= ruleInterval ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_NUMBER||(LA45_0>=68 && LA45_0<=71)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2863:1: (lv_interval_2_0= ruleInterval )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2863:1: (lv_interval_2_0= ruleInterval )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2864:3: lv_interval_2_0= ruleInterval
                    {
                     
                    	        newCompositeNode(grammarAccess.getRangeRefAccess().getIntervalIntervalParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInterval_in_ruleRangeRef6554);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2888:1: entryRuleInterval returns [EObject current=null] : iv_ruleInterval= ruleInterval EOF ;
    public final EObject entryRuleInterval() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterval = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2889:2: (iv_ruleInterval= ruleInterval EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2890:2: iv_ruleInterval= ruleInterval EOF
            {
             newCompositeNode(grammarAccess.getIntervalRule()); 
            pushFollow(FOLLOW_ruleInterval_in_entryRuleInterval6591);
            iv_ruleInterval=ruleInterval();

            state._fsp--;

             current =iv_ruleInterval; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInterval6601); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2897:1: ruleInterval returns [EObject current=null] : ( ( (lv_interval_0_0= RULE_NUMBER ) ) | ( (lv_kind_1_0= ruleIntervalKind ) ) ) ;
    public final EObject ruleInterval() throws RecognitionException {
        EObject current = null;

        Token lv_interval_0_0=null;
        Enumerator lv_kind_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2900:28: ( ( ( (lv_interval_0_0= RULE_NUMBER ) ) | ( (lv_kind_1_0= ruleIntervalKind ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2901:1: ( ( (lv_interval_0_0= RULE_NUMBER ) ) | ( (lv_kind_1_0= ruleIntervalKind ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2901:1: ( ( (lv_interval_0_0= RULE_NUMBER ) ) | ( (lv_kind_1_0= ruleIntervalKind ) ) )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2901:2: ( (lv_interval_0_0= RULE_NUMBER ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2901:2: ( (lv_interval_0_0= RULE_NUMBER ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2902:1: (lv_interval_0_0= RULE_NUMBER )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2902:1: (lv_interval_0_0= RULE_NUMBER )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2903:3: lv_interval_0_0= RULE_NUMBER
                    {
                    lv_interval_0_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleInterval6643); 

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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2920:6: ( (lv_kind_1_0= ruleIntervalKind ) )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2920:6: ( (lv_kind_1_0= ruleIntervalKind ) )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2921:1: (lv_kind_1_0= ruleIntervalKind )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2921:1: (lv_kind_1_0= ruleIntervalKind )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2922:3: lv_kind_1_0= ruleIntervalKind
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntervalAccess().getKindIntervalKindEnumRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIntervalKind_in_ruleInterval6675);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2946:1: entryRuleLinkRef returns [EObject current=null] : iv_ruleLinkRef= ruleLinkRef EOF ;
    public final EObject entryRuleLinkRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinkRef = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2947:2: (iv_ruleLinkRef= ruleLinkRef EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2948:2: iv_ruleLinkRef= ruleLinkRef EOF
            {
             newCompositeNode(grammarAccess.getLinkRefRule()); 
            pushFollow(FOLLOW_ruleLinkRef_in_entryRuleLinkRef6711);
            iv_ruleLinkRef=ruleLinkRef();

            state._fsp--;

             current =iv_ruleLinkRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLinkRef6721); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2955:1: ruleLinkRef returns [EObject current=null] : ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleLinkRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2958:28: ( ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2959:1: ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2959:1: ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2959:2: () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2959:2: ()
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2960:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLinkRefAccess().getLinkRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleLinkRef6767); 

                	newLeafNode(otherlv_1, grammarAccess.getLinkRefAccess().getLINKKeyword_1());
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2969:1: ( (otherlv_2= RULE_ID ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2970:1: (otherlv_2= RULE_ID )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2970:1: (otherlv_2= RULE_ID )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2971:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLinkRefRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLinkRef6787); 

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2990:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2991:2: (iv_ruleFQN= ruleFQN EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2992:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN6824);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN6835); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2999:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SPACED_ID_0= ruleSPACED_ID (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_SPACED_ID_0 = null;

        AntlrDatatypeRuleToken this_SPACED_ID_2 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3002:28: ( (this_SPACED_ID_0= ruleSPACED_ID (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3003:1: (this_SPACED_ID_0= ruleSPACED_ID (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3003:1: (this_SPACED_ID_0= ruleSPACED_ID (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3004:5: this_SPACED_ID_0= ruleSPACED_ID (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )*
            {
             
                    newCompositeNode(grammarAccess.getFQNAccess().getSPACED_IDParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleSPACED_ID_in_ruleFQN6882);
            this_SPACED_ID_0=ruleSPACED_ID();

            state._fsp--;


            		current.merge(this_SPACED_ID_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3014:1: (kw= '::' this_SPACED_ID_2= ruleSPACED_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==59) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3015:2: kw= '::' this_SPACED_ID_2= ruleSPACED_ID
            	    {
            	    kw=(Token)match(input,59,FOLLOW_59_in_ruleFQN6901); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getColonColonKeyword_1_0()); 
            	        
            	     
            	            newCompositeNode(grammarAccess.getFQNAccess().getSPACED_IDParserRuleCall_1_1()); 
            	        
            	    pushFollow(FOLLOW_ruleSPACED_ID_in_ruleFQN6923);
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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3039:1: entryRuleSPACED_ID returns [String current=null] : iv_ruleSPACED_ID= ruleSPACED_ID EOF ;
    public final String entryRuleSPACED_ID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSPACED_ID = null;


        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3040:2: (iv_ruleSPACED_ID= ruleSPACED_ID EOF )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3041:2: iv_ruleSPACED_ID= ruleSPACED_ID EOF
            {
             newCompositeNode(grammarAccess.getSPACED_IDRule()); 
            pushFollow(FOLLOW_ruleSPACED_ID_in_entryRuleSPACED_ID6971);
            iv_ruleSPACED_ID=ruleSPACED_ID();

            state._fsp--;

             current =iv_ruleSPACED_ID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSPACED_ID6982); 

            }

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3048:1: ruleSPACED_ID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )* ) ;
    public final AntlrDatatypeRuleToken ruleSPACED_ID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_NUMBER_1=null;
        Token this_ID_2=null;
        Token this_NUMBER_3=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3051:28: ( ( (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )* ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3052:1: ( (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )* )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3052:1: ( (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )* )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3052:2: (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER ) (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )*
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3052:2: (this_ID_0= RULE_ID | this_NUMBER_1= RULE_NUMBER )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3052:7: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPACED_ID7023); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getSPACED_IDAccess().getIDTerminalRuleCall_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3060:10: this_NUMBER_1= RULE_NUMBER
                    {
                    this_NUMBER_1=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleSPACED_ID7049); 

                    		current.merge(this_NUMBER_1);
                        
                     
                        newLeafNode(this_NUMBER_1, grammarAccess.getSPACED_IDAccess().getNUMBERTerminalRuleCall_0_1()); 
                        

                    }
                    break;

            }

            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3067:2: (this_ID_2= RULE_ID | this_NUMBER_3= RULE_NUMBER )*
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
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3067:7: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSPACED_ID7071); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getSPACED_IDAccess().getIDTerminalRuleCall_1_0()); 
            	        

            	    }
            	    break;
            	case 2 :
            	    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3075:10: this_NUMBER_3= RULE_NUMBER
            	    {
            	    this_NUMBER_3=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleSPACED_ID7097); 

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3090:1: ruleNativeFunction returns [Enumerator current=null] : ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) | (enumLiteral_6= 'erlangB()' ) | (enumLiteral_7= 'clear()' ) ) ;
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
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3092:28: ( ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) | (enumLiteral_6= 'erlangB()' ) | (enumLiteral_7= 'clear()' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3093:1: ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) | (enumLiteral_6= 'erlangB()' ) | (enumLiteral_7= 'clear()' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3093:1: ( (enumLiteral_0= 'count()' ) | (enumLiteral_1= 'sum()' ) | (enumLiteral_2= 'min()' ) | (enumLiteral_3= 'max()' ) | (enumLiteral_4= 'mean()' ) | (enumLiteral_5= 'deviation()' ) | (enumLiteral_6= 'erlangB()' ) | (enumLiteral_7= 'clear()' ) )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3093:2: (enumLiteral_0= 'count()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3093:2: (enumLiteral_0= 'count()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3093:4: enumLiteral_0= 'count()'
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_60_in_ruleNativeFunction7158); 

                            current = grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3099:6: (enumLiteral_1= 'sum()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3099:6: (enumLiteral_1= 'sum()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3099:8: enumLiteral_1= 'sum()'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_61_in_ruleNativeFunction7175); 

                            current = grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3105:6: (enumLiteral_2= 'min()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3105:6: (enumLiteral_2= 'min()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3105:8: enumLiteral_2= 'min()'
                    {
                    enumLiteral_2=(Token)match(input,62,FOLLOW_62_in_ruleNativeFunction7192); 

                            current = grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3111:6: (enumLiteral_3= 'max()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3111:6: (enumLiteral_3= 'max()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3111:8: enumLiteral_3= 'max()'
                    {
                    enumLiteral_3=(Token)match(input,63,FOLLOW_63_in_ruleNativeFunction7209); 

                            current = grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3117:6: (enumLiteral_4= 'mean()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3117:6: (enumLiteral_4= 'mean()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3117:8: enumLiteral_4= 'mean()'
                    {
                    enumLiteral_4=(Token)match(input,64,FOLLOW_64_in_ruleNativeFunction7226); 

                            current = grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3123:6: (enumLiteral_5= 'deviation()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3123:6: (enumLiteral_5= 'deviation()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3123:8: enumLiteral_5= 'deviation()'
                    {
                    enumLiteral_5=(Token)match(input,65,FOLLOW_65_in_ruleNativeFunction7243); 

                            current = grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3129:6: (enumLiteral_6= 'erlangB()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3129:6: (enumLiteral_6= 'erlangB()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3129:8: enumLiteral_6= 'erlangB()'
                    {
                    enumLiteral_6=(Token)match(input,66,FOLLOW_66_in_ruleNativeFunction7260); 

                            current = grammarAccess.getNativeFunctionAccess().getERLANGBEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getNativeFunctionAccess().getERLANGBEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3135:6: (enumLiteral_7= 'clear()' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3135:6: (enumLiteral_7= 'clear()' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3135:8: enumLiteral_7= 'clear()'
                    {
                    enumLiteral_7=(Token)match(input,67,FOLLOW_67_in_ruleNativeFunction7277); 

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3145:1: ruleIntervalKind returns [Enumerator current=null] : ( (enumLiteral_0= 'MONTH' ) | (enumLiteral_1= 'WEEK' ) | (enumLiteral_2= 'DAY' ) | (enumLiteral_3= 'HOUR' ) ) ;
    public final Enumerator ruleIntervalKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3147:28: ( ( (enumLiteral_0= 'MONTH' ) | (enumLiteral_1= 'WEEK' ) | (enumLiteral_2= 'DAY' ) | (enumLiteral_3= 'HOUR' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3148:1: ( (enumLiteral_0= 'MONTH' ) | (enumLiteral_1= 'WEEK' ) | (enumLiteral_2= 'DAY' ) | (enumLiteral_3= 'HOUR' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3148:1: ( (enumLiteral_0= 'MONTH' ) | (enumLiteral_1= 'WEEK' ) | (enumLiteral_2= 'DAY' ) | (enumLiteral_3= 'HOUR' ) )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3148:2: (enumLiteral_0= 'MONTH' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3148:2: (enumLiteral_0= 'MONTH' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3148:4: enumLiteral_0= 'MONTH'
                    {
                    enumLiteral_0=(Token)match(input,68,FOLLOW_68_in_ruleIntervalKind7322); 

                            current = grammarAccess.getIntervalKindAccess().getMONTHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getIntervalKindAccess().getMONTHEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3154:6: (enumLiteral_1= 'WEEK' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3154:6: (enumLiteral_1= 'WEEK' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3154:8: enumLiteral_1= 'WEEK'
                    {
                    enumLiteral_1=(Token)match(input,69,FOLLOW_69_in_ruleIntervalKind7339); 

                            current = grammarAccess.getIntervalKindAccess().getWEEKEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getIntervalKindAccess().getWEEKEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3160:6: (enumLiteral_2= 'DAY' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3160:6: (enumLiteral_2= 'DAY' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3160:8: enumLiteral_2= 'DAY'
                    {
                    enumLiteral_2=(Token)match(input,70,FOLLOW_70_in_ruleIntervalKind7356); 

                            current = grammarAccess.getIntervalKindAccess().getDAYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getIntervalKindAccess().getDAYEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3166:6: (enumLiteral_3= 'HOUR' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3166:6: (enumLiteral_3= 'HOUR' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3166:8: enumLiteral_3= 'HOUR'
                    {
                    enumLiteral_3=(Token)match(input,71,FOLLOW_71_in_ruleIntervalKind7373); 

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3176:1: ruleToleranceLevel returns [Enumerator current=null] : ( (enumLiteral_0= 'RED' ) | (enumLiteral_1= 'AMBER' ) | (enumLiteral_2= 'GREEN' ) | (enumLiteral_3= 'YELLOW' ) ) ;
    public final Enumerator ruleToleranceLevel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3178:28: ( ( (enumLiteral_0= 'RED' ) | (enumLiteral_1= 'AMBER' ) | (enumLiteral_2= 'GREEN' ) | (enumLiteral_3= 'YELLOW' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3179:1: ( (enumLiteral_0= 'RED' ) | (enumLiteral_1= 'AMBER' ) | (enumLiteral_2= 'GREEN' ) | (enumLiteral_3= 'YELLOW' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3179:1: ( (enumLiteral_0= 'RED' ) | (enumLiteral_1= 'AMBER' ) | (enumLiteral_2= 'GREEN' ) | (enumLiteral_3= 'YELLOW' ) )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3179:2: (enumLiteral_0= 'RED' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3179:2: (enumLiteral_0= 'RED' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3179:4: enumLiteral_0= 'RED'
                    {
                    enumLiteral_0=(Token)match(input,72,FOLLOW_72_in_ruleToleranceLevel7418); 

                            current = grammarAccess.getToleranceLevelAccess().getREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getToleranceLevelAccess().getREDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3185:6: (enumLiteral_1= 'AMBER' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3185:6: (enumLiteral_1= 'AMBER' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3185:8: enumLiteral_1= 'AMBER'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_73_in_ruleToleranceLevel7435); 

                            current = grammarAccess.getToleranceLevelAccess().getAMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getToleranceLevelAccess().getAMBEREnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3191:6: (enumLiteral_2= 'GREEN' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3191:6: (enumLiteral_2= 'GREEN' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3191:8: enumLiteral_2= 'GREEN'
                    {
                    enumLiteral_2=(Token)match(input,74,FOLLOW_74_in_ruleToleranceLevel7452); 

                            current = grammarAccess.getToleranceLevelAccess().getGREENEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getToleranceLevelAccess().getGREENEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3197:6: (enumLiteral_3= 'YELLOW' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3197:6: (enumLiteral_3= 'YELLOW' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3197:8: enumLiteral_3= 'YELLOW'
                    {
                    enumLiteral_3=(Token)match(input,75,FOLLOW_75_in_ruleToleranceLevel7469); 

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3207:1: ruleValueRange returns [Enumerator current=null] : ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) | (enumLiteral_6= 'TOLERANCE' ) | (enumLiteral_7= 'DERIVED' ) ) ;
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
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3209:28: ( ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) | (enumLiteral_6= 'TOLERANCE' ) | (enumLiteral_7= 'DERIVED' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3210:1: ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) | (enumLiteral_6= 'TOLERANCE' ) | (enumLiteral_7= 'DERIVED' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3210:1: ( (enumLiteral_0= 'METRIC' ) | (enumLiteral_1= 'CAP' ) | (enumLiteral_2= 'FORECAST' ) | (enumLiteral_3= 'FORECAST_CAP' ) | (enumLiteral_4= 'TRENDED' ) | (enumLiteral_5= 'UTILIZATION' ) | (enumLiteral_6= 'TOLERANCE' ) | (enumLiteral_7= 'DERIVED' ) )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3210:2: (enumLiteral_0= 'METRIC' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3210:2: (enumLiteral_0= 'METRIC' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3210:4: enumLiteral_0= 'METRIC'
                    {
                    enumLiteral_0=(Token)match(input,76,FOLLOW_76_in_ruleValueRange7514); 

                            current = grammarAccess.getValueRangeAccess().getMETRICEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getValueRangeAccess().getMETRICEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3216:6: (enumLiteral_1= 'CAP' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3216:6: (enumLiteral_1= 'CAP' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3216:8: enumLiteral_1= 'CAP'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_77_in_ruleValueRange7531); 

                            current = grammarAccess.getValueRangeAccess().getCAPEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getValueRangeAccess().getCAPEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3222:6: (enumLiteral_2= 'FORECAST' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3222:6: (enumLiteral_2= 'FORECAST' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3222:8: enumLiteral_2= 'FORECAST'
                    {
                    enumLiteral_2=(Token)match(input,78,FOLLOW_78_in_ruleValueRange7548); 

                            current = grammarAccess.getValueRangeAccess().getFORECASTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getValueRangeAccess().getFORECASTEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3228:6: (enumLiteral_3= 'FORECAST_CAP' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3228:6: (enumLiteral_3= 'FORECAST_CAP' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3228:8: enumLiteral_3= 'FORECAST_CAP'
                    {
                    enumLiteral_3=(Token)match(input,79,FOLLOW_79_in_ruleValueRange7565); 

                            current = grammarAccess.getValueRangeAccess().getFORECAST_CAPEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getValueRangeAccess().getFORECAST_CAPEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3234:6: (enumLiteral_4= 'TRENDED' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3234:6: (enumLiteral_4= 'TRENDED' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3234:8: enumLiteral_4= 'TRENDED'
                    {
                    enumLiteral_4=(Token)match(input,80,FOLLOW_80_in_ruleValueRange7582); 

                            current = grammarAccess.getValueRangeAccess().getTRENDEDEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getValueRangeAccess().getTRENDEDEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3240:6: (enumLiteral_5= 'UTILIZATION' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3240:6: (enumLiteral_5= 'UTILIZATION' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3240:8: enumLiteral_5= 'UTILIZATION'
                    {
                    enumLiteral_5=(Token)match(input,81,FOLLOW_81_in_ruleValueRange7599); 

                            current = grammarAccess.getValueRangeAccess().getUTILIZATIONEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getValueRangeAccess().getUTILIZATIONEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3246:6: (enumLiteral_6= 'TOLERANCE' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3246:6: (enumLiteral_6= 'TOLERANCE' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3246:8: enumLiteral_6= 'TOLERANCE'
                    {
                    enumLiteral_6=(Token)match(input,82,FOLLOW_82_in_ruleValueRange7616); 

                            current = grammarAccess.getValueRangeAccess().getTOLERANCEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getValueRangeAccess().getTOLERANCEEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3252:6: (enumLiteral_7= 'DERIVED' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3252:6: (enumLiteral_7= 'DERIVED' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3252:8: enumLiteral_7= 'DERIVED'
                    {
                    enumLiteral_7=(Token)match(input,83,FOLLOW_83_in_ruleValueRange7633); 

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
    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3262:1: ruleValueKind returns [Enumerator current=null] : ( (enumLiteral_0= 'AVG' ) | (enumLiteral_1= 'BH' ) ) ;
    public final Enumerator ruleValueKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3264:28: ( ( (enumLiteral_0= 'AVG' ) | (enumLiteral_1= 'BH' ) ) )
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3265:1: ( (enumLiteral_0= 'AVG' ) | (enumLiteral_1= 'BH' ) )
            {
            // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3265:1: ( (enumLiteral_0= 'AVG' ) | (enumLiteral_1= 'BH' ) )
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
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3265:2: (enumLiteral_0= 'AVG' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3265:2: (enumLiteral_0= 'AVG' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3265:4: enumLiteral_0= 'AVG'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_84_in_ruleValueKind7678); 

                            current = grammarAccess.getValueKindAccess().getAVGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getValueKindAccess().getAVGEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3271:6: (enumLiteral_1= 'BH' )
                    {
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3271:6: (enumLiteral_1= 'BH' )
                    // ../com.netxforge.netxscript/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:3271:8: enumLiteral_1= 'BH'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_85_in_ruleValueKind7695); 

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


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA9_eotS =
        "\u008c\uffff";
    static final String DFA9_eofS =
        "\u008c\uffff";
    static final String DFA9_minS =
        "\1\4\1\uffff\1\17\1\47\1\4\4\uffff\1\64\10\6\1\47\2\4\2\24\2\6\5"+
        "\24\1\uffff\1\64\4\4\1\70\3\4\2\24\10\4\4\24\4\4\1\70\7\4\1\114"+
        "\1\24\10\4\4\24\7\4\10\6\6\4\1\114\1\24\2\4\2\6\5\24\7\4\10\6\4"+
        "\4\2\6\5\24\2\4";
    static final String DFA9_maxS =
        "\1\62\1\uffff\1\56\1\123\1\4\4\uffff\1\67\10\125\1\47\2\6\2\63\2"+
        "\107\5\56\1\uffff\1\67\4\73\1\113\1\67\2\6\2\63\2\73\1\6\2\73\1"+
        "\6\1\71\1\4\4\56\4\73\1\113\1\67\4\73\3\123\1\56\2\73\1\6\2\73\1"+
        "\6\1\71\1\4\4\56\4\73\2\123\1\6\10\125\4\73\3\123\1\56\2\123\2\107"+
        "\5\56\4\73\2\123\1\6\10\125\4\123\2\107\5\56\2\123";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\3\uffff\1\5\1\6\1\2\1\3\25\uffff\1\4\155\uffff";
    static final String DFA9_specialS =
        "\u008c\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\uffff\1\5\10\uffff\1\5\5\uffff\1\6\3\uffff\1\1\12\uffff"+
            "\2\5\3\uffff\4\5\2\uffff\1\5\1\4\1\5\1\3",
            "",
            "\1\5\4\uffff\1\5\5\uffff\1\7\1\10\15\5\3\uffff\1\5\1\uffff"+
            "\1\5",
            "\1\11\44\uffff\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21",
            "\1\22",
            "",
            "",
            "",
            "",
            "\1\23\1\24\1\25\1\26",
            "\1\31\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\32\1\33\1\34\1\35\14\uffff\1\27\1\30",
            "\1\31\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\32\1\33\1\34\1\35\14\uffff\1\27\1\30",
            "\1\31\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\32\1\33\1\34\1\35\14\uffff\1\27\1\30",
            "\1\31\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\32\1\33\1\34\1\35\14\uffff\1\27\1\30",
            "\1\31\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\32\1\33\1\34\1\35\14\uffff\1\27\1\30",
            "\1\31\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\32\1\33\1\34\1\35\14\uffff\1\27\1\30",
            "\1\31\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\32\1\33\1\34\1\35\14\uffff\1\27\1\30",
            "\1\31\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\32\1\33\1\34\1\35\14\uffff\1\27\1\30",
            "\1\37",
            "\1\40\1\uffff\1\41",
            "\1\42\1\uffff\1\43",
            "\1\5\5\uffff\1\36\1\uffff\13\5\1\45\1\5\5\uffff\1\5\4\uffff"+
            "\1\44",
            "\1\5\5\uffff\1\36\1\uffff\13\5\1\45\1\5\5\uffff\1\5\4\uffff"+
            "\1\44",
            "\1\31\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\32\1\33\1\34\1\35",
            "\1\31\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\32\1\33\1\34\1\35",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "",
            "\1\46\1\47\1\50\1\51",
            "\1\52\1\uffff\1\53\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5\1"+
            "\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\54",
            "\1\52\1\uffff\1\53\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5\1"+
            "\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\54",
            "\1\55\1\uffff\1\56\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5\1"+
            "\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\57",
            "\1\55\1\uffff\1\56\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5\1"+
            "\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\57",
            "\1\60\1\uffff\1\61\15\uffff\1\62\1\63\1\64\1\65",
            "\1\5\1\uffff\1\5\10\uffff\1\5\24\uffff\2\5\3\uffff\4\5\2\uffff"+
            "\4\5\1\uffff\1\23\1\24\1\25\1\26",
            "\1\66\1\uffff\1\67",
            "\1\70\1\uffff\1\71",
            "\1\5\5\uffff\1\36\1\uffff\13\5\1\73\1\5\5\uffff\1\5\4\uffff"+
            "\1\72",
            "\1\5\5\uffff\1\36\1\uffff\13\5\1\73\1\5\5\uffff\1\5\4\uffff"+
            "\1\72",
            "\1\52\1\uffff\1\53\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5\1"+
            "\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\54",
            "\1\52\1\uffff\1\53\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5\1"+
            "\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\54",
            "\1\74\1\uffff\1\75",
            "\1\55\1\uffff\1\56\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5\1"+
            "\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\57",
            "\1\55\1\uffff\1\56\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5\1"+
            "\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\57",
            "\1\76\1\uffff\1\77",
            "\1\100\1\uffff\1\101\62\uffff\1\102",
            "\1\103",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\104\1\uffff\1\105\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\106",
            "\1\104\1\uffff\1\105\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\106",
            "\1\107\1\uffff\1\110\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\111",
            "\1\107\1\uffff\1\110\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\111",
            "\1\112\1\uffff\1\113\15\uffff\1\114\1\115\1\116\1\117",
            "\1\5\1\uffff\1\5\10\uffff\1\5\24\uffff\2\5\3\uffff\4\5\2\uffff"+
            "\4\5\1\uffff\1\46\1\47\1\50\1\51",
            "\1\120\1\uffff\1\121\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\54",
            "\1\120\1\uffff\1\121\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\54",
            "\1\122\1\uffff\1\123\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\57",
            "\1\122\1\uffff\1\123\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\57",
            "\1\124\1\uffff\1\125\64\uffff\1\126\20\uffff\1\127\1\130\1"+
            "\131\1\132\1\133\1\134\1\135\1\136",
            "\1\124\1\uffff\1\125\64\uffff\1\126\20\uffff\1\127\1\130\1"+
            "\131\1\132\1\133\1\134\1\135\1\136",
            "\1\127\1\130\1\131\1\132\1\133\1\134\1\135\1\136",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\104\1\uffff\1\105\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\106",
            "\1\104\1\uffff\1\105\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\106",
            "\1\137\1\uffff\1\140",
            "\1\107\1\uffff\1\110\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\111",
            "\1\107\1\uffff\1\110\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\111",
            "\1\141\1\uffff\1\142",
            "\1\143\1\uffff\1\144\62\uffff\1\145",
            "\1\146",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\120\1\uffff\1\121\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\54",
            "\1\120\1\uffff\1\121\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\54",
            "\1\122\1\uffff\1\123\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\57",
            "\1\122\1\uffff\1\123\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\45\1\5\5\uffff\1\5\4\uffff\1\44\7\uffff\1\57",
            "\1\124\1\uffff\1\125\64\uffff\1\126\20\uffff\1\127\1\130\1"+
            "\131\1\132\1\133\1\134\1\135\1\136",
            "\1\124\1\uffff\1\125\64\uffff\1\126\20\uffff\1\127\1\130\1"+
            "\131\1\132\1\133\1\134\1\135\1\136",
            "\1\147\1\uffff\1\150",
            "\1\153\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\154\1\155\1\156\1\157\14\uffff\1\151\1\152",
            "\1\153\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\154\1\155\1\156\1\157\14\uffff\1\151\1\152",
            "\1\153\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\154\1\155\1\156\1\157\14\uffff\1\151\1\152",
            "\1\153\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\154\1\155\1\156\1\157\14\uffff\1\151\1\152",
            "\1\153\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\154\1\155\1\156\1\157\14\uffff\1\151\1\152",
            "\1\153\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\154\1\155\1\156\1\157\14\uffff\1\151\1\152",
            "\1\153\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\154\1\155\1\156\1\157\14\uffff\1\151\1\152",
            "\1\153\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\154\1\155\1\156\1\157\14\uffff\1\151\1\152",
            "\1\160\1\uffff\1\161\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\106",
            "\1\160\1\uffff\1\161\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\106",
            "\1\162\1\uffff\1\163\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\111",
            "\1\162\1\uffff\1\163\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\111",
            "\1\164\1\uffff\1\165\64\uffff\1\166\20\uffff\1\167\1\170\1"+
            "\171\1\172\1\173\1\174\1\175\1\176",
            "\1\164\1\uffff\1\165\64\uffff\1\166\20\uffff\1\167\1\170\1"+
            "\171\1\172\1\173\1\174\1\175\1\176",
            "\1\167\1\170\1\171\1\172\1\173\1\174\1\175\1\176",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\177\1\uffff\1\u0080\64\uffff\1\126\20\uffff\1\127\1\130"+
            "\1\131\1\132\1\133\1\134\1\135\1\136",
            "\1\177\1\uffff\1\u0080\64\uffff\1\126\20\uffff\1\127\1\130"+
            "\1\131\1\132\1\133\1\134\1\135\1\136",
            "\1\153\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\154\1\155\1\156\1\157",
            "\1\153\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5\25"+
            "\uffff\1\154\1\155\1\156\1\157",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\160\1\uffff\1\161\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\106",
            "\1\160\1\uffff\1\161\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\106",
            "\1\162\1\uffff\1\163\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\111",
            "\1\162\1\uffff\1\163\15\uffff\1\5\5\uffff\1\36\1\uffff\13\5"+
            "\1\73\1\5\5\uffff\1\5\4\uffff\1\72\7\uffff\1\111",
            "\1\164\1\uffff\1\165\64\uffff\1\166\20\uffff\1\167\1\170\1"+
            "\171\1\172\1\173\1\174\1\175\1\176",
            "\1\164\1\uffff\1\165\64\uffff\1\166\20\uffff\1\167\1\170\1"+
            "\171\1\172\1\173\1\174\1\175\1\176",
            "\1\u0081\1\uffff\1\u0082",
            "\1\u0085\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5"+
            "\25\uffff\1\u0086\1\u0087\1\u0088\1\u0089\14\uffff\1\u0083\1"+
            "\u0084",
            "\1\u0085\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5"+
            "\25\uffff\1\u0086\1\u0087\1\u0088\1\u0089\14\uffff\1\u0083\1"+
            "\u0084",
            "\1\u0085\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5"+
            "\25\uffff\1\u0086\1\u0087\1\u0088\1\u0089\14\uffff\1\u0083\1"+
            "\u0084",
            "\1\u0085\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5"+
            "\25\uffff\1\u0086\1\u0087\1\u0088\1\u0089\14\uffff\1\u0083\1"+
            "\u0084",
            "\1\u0085\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5"+
            "\25\uffff\1\u0086\1\u0087\1\u0088\1\u0089\14\uffff\1\u0083\1"+
            "\u0084",
            "\1\u0085\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5"+
            "\25\uffff\1\u0086\1\u0087\1\u0088\1\u0089\14\uffff\1\u0083\1"+
            "\u0084",
            "\1\u0085\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5"+
            "\25\uffff\1\u0086\1\u0087\1\u0088\1\u0089\14\uffff\1\u0083\1"+
            "\u0084",
            "\1\u0085\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5"+
            "\25\uffff\1\u0086\1\u0087\1\u0088\1\u0089\14\uffff\1\u0083\1"+
            "\u0084",
            "\1\177\1\uffff\1\u0080\64\uffff\1\126\20\uffff\1\127\1\130"+
            "\1\131\1\132\1\133\1\134\1\135\1\136",
            "\1\177\1\uffff\1\u0080\64\uffff\1\126\20\uffff\1\127\1\130"+
            "\1\131\1\132\1\133\1\134\1\135\1\136",
            "\1\u008a\1\uffff\1\u008b\64\uffff\1\166\20\uffff\1\167\1\170"+
            "\1\171\1\172\1\173\1\174\1\175\1\176",
            "\1\u008a\1\uffff\1\u008b\64\uffff\1\166\20\uffff\1\167\1\170"+
            "\1\171\1\172\1\173\1\174\1\175\1\176",
            "\1\u0085\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5"+
            "\25\uffff\1\u0086\1\u0087\1\u0088\1\u0089",
            "\1\u0085\15\uffff\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5"+
            "\25\uffff\1\u0086\1\u0087\1\u0088\1\u0089",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\5\5\uffff\1\36\1\uffff\15\5\5\uffff\1\5",
            "\1\u008a\1\uffff\1\u008b\64\uffff\1\166\20\uffff\1\167\1\170"+
            "\1\171\1\172\1\173\1\174\1\175\1\176",
            "\1\u008a\1\uffff\1\u008b\64\uffff\1\166\20\uffff\1\167\1\170"+
            "\1\171\1\172\1\173\1\174\1\175\1\176"
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
            return "427:3: (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_PlusAssignmentStatement_2= rulePlusAssignmentStatement | this_ReferenceAssignmentStatement_3= ruleReferenceAssignmentStatement | ( (lv_expression_4_0= ruleExpression ) ) | this_ReturnStatement_5= ruleReturnStatement )";
        }
    }
    static final String DFA28_eotS =
        "\u00d7\uffff";
    static final String DFA28_eofS =
        "\7\uffff\1\30\2\uffff\1\34\1\uffff\10\50\2\uffff\2\50\7\uffff\11"+
        "\50\3\uffff\2\50\2\uffff\4\50\4\uffff\2\50\2\uffff\6\50\1\uffff"+
        "\2\50\3\uffff\10\50\2\uffff\4\50\2\uffff\6\50\3\uffff\3\50\1\uffff"+
        "\2\50\3\uffff\6\50\1\uffff\2\50\3\uffff\10\50\3\uffff\14\50\3\uffff"+
        "\5\50\3\uffff\1\50\2\uffff\13\50\3\uffff\14\50\3\uffff\10\50\4\uffff"+
        "\7\50\2\uffff\7\50\4\uffff";
    static final String DFA28_minS =
        "\1\4\1\uffff\1\6\1\47\3\4\1\17\1\uffff\2\20\1\64\10\6\2\47\2\4\3"+
        "\uffff\1\6\1\uffff\2\4\2\20\2\6\5\20\1\uffff\2\64\3\4\1\20\4\4\1"+
        "\70\3\4\2\20\2\4\2\20\12\4\4\20\4\4\1\70\5\4\1\70\11\4\1\114\1\20"+
        "\10\4\4\20\10\4\4\20\7\4\10\6\6\4\1\114\1\20\6\4\1\114\1\20\2\4"+
        "\2\6\5\20\7\4\10\6\7\4\10\6\4\4\2\6\5\20\2\4\2\6\5\20\4\4";
    static final String DFA28_maxS =
        "\1\62\1\uffff\1\55\1\123\2\4\1\6\1\56\1\uffff\1\55\1\56\1\67\10"+
        "\125\2\47\2\73\3\uffff\1\6\1\uffff\2\6\2\63\2\107\5\56\1\uffff\2"+
        "\67\2\73\1\6\1\55\4\73\1\113\1\67\2\6\2\63\2\6\2\63\4\73\1\6\2\73"+
        "\1\6\1\71\1\4\4\56\4\73\1\113\1\67\4\73\1\113\1\67\6\73\3\123\1"+
        "\56\2\73\1\6\2\73\1\6\1\71\1\4\4\56\2\73\1\6\2\73\1\6\1\71\1\4\4"+
        "\56\4\73\2\123\1\6\10\125\4\73\3\123\1\56\4\73\3\123\1\56\2\123"+
        "\2\107\5\56\4\73\2\123\1\6\10\125\4\73\2\123\1\6\10\125\4\123\2"+
        "\107\5\56\2\123\2\107\5\56\4\123";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\6\uffff\1\7\17\uffff\1\6\1\3\1\5\1\uffff\1\2\13\uffff"+
        "\1\4\u00ae\uffff";
    static final String DFA28_specialS =
        "\u00d7\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\7\1\uffff\1\1\10\uffff\1\10\32\uffff\2\1\1\2\2\uffff\1\6"+
            "\1\4\1\5\1\3",
            "",
            "\1\11\46\uffff\1\12",
            "\1\13\44\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23",
            "\1\24",
            "\1\25",
            "\1\26\1\uffff\1\27",
            "\1\32\2\30\2\uffff\1\30\7\uffff\15\30\3\uffff\2\30\1\31",
            "",
            "\1\33\34\uffff\1\12",
            "\2\34\2\uffff\1\34\7\uffff\15\34\4\uffff\1\34\1\31",
            "\1\35\1\36\1\37\1\40",
            "\1\43\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50"+
            "\1\31\25\uffff\1\44\1\45\1\46\1\47\14\uffff\1\41\1\42",
            "\1\43\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50"+
            "\1\31\25\uffff\1\44\1\45\1\46\1\47\14\uffff\1\41\1\42",
            "\1\43\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50"+
            "\1\31\25\uffff\1\44\1\45\1\46\1\47\14\uffff\1\41\1\42",
            "\1\43\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50"+
            "\1\31\25\uffff\1\44\1\45\1\46\1\47\14\uffff\1\41\1\42",
            "\1\43\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50"+
            "\1\31\25\uffff\1\44\1\45\1\46\1\47\14\uffff\1\41\1\42",
            "\1\43\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50"+
            "\1\31\25\uffff\1\44\1\45\1\46\1\47\14\uffff\1\41\1\42",
            "\1\43\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50"+
            "\1\31\25\uffff\1\44\1\45\1\46\1\47\14\uffff\1\41\1\42",
            "\1\43\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50"+
            "\1\31\25\uffff\1\44\1\45\1\46\1\47\14\uffff\1\41\1\42",
            "\1\51",
            "\1\52",
            "\1\53\1\uffff\1\54\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50"+
            "\4\uffff\1\50\1\31\14\uffff\1\55",
            "\1\53\1\uffff\1\54\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50"+
            "\4\uffff\1\50\1\31\14\uffff\1\55",
            "",
            "",
            "",
            "\1\56",
            "",
            "\1\57\1\uffff\1\60",
            "\1\61\1\uffff\1\62",
            "\2\50\2\uffff\1\50\7\uffff\13\50\1\64\1\50\4\uffff\1\50\1\31"+
            "\4\uffff\1\63",
            "\2\50\2\uffff\1\50\7\uffff\13\50\1\64\1\50\4\uffff\1\50\1\31"+
            "\4\uffff\1\63",
            "\1\43\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50"+
            "\1\31\25\uffff\1\44\1\45\1\46\1\47",
            "\1\43\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50"+
            "\1\31\25\uffff\1\44\1\45\1\46\1\47",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "",
            "\1\65\1\66\1\67\1\70",
            "\1\71\1\72\1\73\1\74",
            "\1\53\1\uffff\1\54\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50"+
            "\4\uffff\1\50\1\31\14\uffff\1\55",
            "\1\53\1\uffff\1\54\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50"+
            "\4\uffff\1\50\1\31\14\uffff\1\55",
            "\1\75\1\uffff\1\76",
            "\1\33\34\uffff\1\12",
            "\1\77\1\uffff\1\100\11\uffff\2\50\2\uffff\1\50\7\uffff\13\50"+
            "\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\101",
            "\1\77\1\uffff\1\100\11\uffff\2\50\2\uffff\1\50\7\uffff\13\50"+
            "\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\101",
            "\1\102\1\uffff\1\103\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\104",
            "\1\102\1\uffff\1\103\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\104",
            "\1\105\1\uffff\1\106\15\uffff\1\107\1\110\1\111\1\112",
            "\1\50\1\uffff\1\50\10\uffff\1\50\24\uffff\2\50\3\uffff\4\50"+
            "\2\uffff\4\50\1\uffff\1\35\1\36\1\37\1\40",
            "\1\113\1\uffff\1\114",
            "\1\115\1\uffff\1\116",
            "\2\50\2\uffff\1\50\7\uffff\13\50\1\120\1\50\4\uffff\1\50\1"+
            "\31\4\uffff\1\117",
            "\2\50\2\uffff\1\50\7\uffff\13\50\1\120\1\50\4\uffff\1\50\1"+
            "\31\4\uffff\1\117",
            "\1\121\1\uffff\1\122",
            "\1\123\1\uffff\1\124",
            "\2\50\2\uffff\1\50\7\uffff\13\50\1\126\1\50\4\uffff\1\50\1"+
            "\31\4\uffff\1\125",
            "\2\50\2\uffff\1\50\7\uffff\13\50\1\126\1\50\4\uffff\1\50\1"+
            "\31\4\uffff\1\125",
            "\1\127\1\uffff\1\130\11\uffff\2\50\2\uffff\1\50\7\uffff\15"+
            "\50\4\uffff\1\50\1\31\14\uffff\1\55",
            "\1\127\1\uffff\1\130\11\uffff\2\50\2\uffff\1\50\7\uffff\15"+
            "\50\4\uffff\1\50\1\31\14\uffff\1\55",
            "\1\77\1\uffff\1\100\11\uffff\2\50\2\uffff\1\50\7\uffff\13\50"+
            "\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\101",
            "\1\77\1\uffff\1\100\11\uffff\2\50\2\uffff\1\50\7\uffff\13\50"+
            "\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\101",
            "\1\131\1\uffff\1\132",
            "\1\102\1\uffff\1\103\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\104",
            "\1\102\1\uffff\1\103\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\104",
            "\1\133\1\uffff\1\134",
            "\1\135\1\uffff\1\136\62\uffff\1\137",
            "\1\140",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\1\141\1\uffff\1\142\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1\143",
            "\1\141\1\uffff\1\142\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1\143",
            "\1\144\1\uffff\1\145\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1\146",
            "\1\144\1\uffff\1\145\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1\146",
            "\1\147\1\uffff\1\150\15\uffff\1\151\1\152\1\153\1\154",
            "\1\50\1\uffff\1\50\10\uffff\1\50\24\uffff\2\50\3\uffff\4\50"+
            "\2\uffff\4\50\1\uffff\1\65\1\66\1\67\1\70",
            "\1\155\1\uffff\1\156\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1\157",
            "\1\155\1\uffff\1\156\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1\157",
            "\1\160\1\uffff\1\161\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1\162",
            "\1\160\1\uffff\1\161\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1\162",
            "\1\163\1\uffff\1\164\15\uffff\1\165\1\166\1\167\1\170",
            "\1\50\1\uffff\1\50\10\uffff\1\50\24\uffff\2\50\3\uffff\4\50"+
            "\2\uffff\4\50\1\uffff\1\71\1\72\1\73\1\74",
            "\1\127\1\uffff\1\130\11\uffff\2\50\2\uffff\1\50\7\uffff\15"+
            "\50\4\uffff\1\50\1\31\14\uffff\1\55",
            "\1\127\1\uffff\1\130\11\uffff\2\50\2\uffff\1\50\7\uffff\15"+
            "\50\4\uffff\1\50\1\31\14\uffff\1\55",
            "\1\171\1\uffff\1\172\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\101",
            "\1\171\1\uffff\1\172\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\101",
            "\1\173\1\uffff\1\174\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\104",
            "\1\173\1\uffff\1\174\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\104",
            "\1\175\1\uffff\1\176\64\uffff\1\177\20\uffff\1\u0080\1\u0081"+
            "\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087",
            "\1\175\1\uffff\1\176\64\uffff\1\177\20\uffff\1\u0080\1\u0081"+
            "\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087",
            "\1\u0080\1\u0081\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1"+
            "\u0087",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\1\141\1\uffff\1\142\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1\143",
            "\1\141\1\uffff\1\142\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1\143",
            "\1\u0088\1\uffff\1\u0089",
            "\1\144\1\uffff\1\145\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1\146",
            "\1\144\1\uffff\1\145\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1\146",
            "\1\u008a\1\uffff\1\u008b",
            "\1\u008c\1\uffff\1\u008d\62\uffff\1\u008e",
            "\1\u008f",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\1\155\1\uffff\1\156\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1\157",
            "\1\155\1\uffff\1\156\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1\157",
            "\1\u0090\1\uffff\1\u0091",
            "\1\160\1\uffff\1\161\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1\162",
            "\1\160\1\uffff\1\161\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1\162",
            "\1\u0092\1\uffff\1\u0093",
            "\1\u0094\1\uffff\1\u0095\62\uffff\1\u0096",
            "\1\u0097",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\1\171\1\uffff\1\172\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\101",
            "\1\171\1\uffff\1\172\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\101",
            "\1\173\1\uffff\1\174\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\104",
            "\1\173\1\uffff\1\174\11\uffff\2\50\2\uffff\1\50\7\uffff\13"+
            "\50\1\64\1\50\4\uffff\1\50\1\31\4\uffff\1\63\7\uffff\1\104",
            "\1\175\1\uffff\1\176\64\uffff\1\177\20\uffff\1\u0080\1\u0081"+
            "\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087",
            "\1\175\1\uffff\1\176\64\uffff\1\177\20\uffff\1\u0080\1\u0081"+
            "\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087",
            "\1\u0098\1\uffff\1\u0099",
            "\1\u009c\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u009d\1\u009e\1\u009f\1\u00a0\14\uffff\1"+
            "\u009a\1\u009b",
            "\1\u009c\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u009d\1\u009e\1\u009f\1\u00a0\14\uffff\1"+
            "\u009a\1\u009b",
            "\1\u009c\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u009d\1\u009e\1\u009f\1\u00a0\14\uffff\1"+
            "\u009a\1\u009b",
            "\1\u009c\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u009d\1\u009e\1\u009f\1\u00a0\14\uffff\1"+
            "\u009a\1\u009b",
            "\1\u009c\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u009d\1\u009e\1\u009f\1\u00a0\14\uffff\1"+
            "\u009a\1\u009b",
            "\1\u009c\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u009d\1\u009e\1\u009f\1\u00a0\14\uffff\1"+
            "\u009a\1\u009b",
            "\1\u009c\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u009d\1\u009e\1\u009f\1\u00a0\14\uffff\1"+
            "\u009a\1\u009b",
            "\1\u009c\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u009d\1\u009e\1\u009f\1\u00a0\14\uffff\1"+
            "\u009a\1\u009b",
            "\1\u00a1\1\uffff\1\u00a2\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1"+
            "\143",
            "\1\u00a1\1\uffff\1\u00a2\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1"+
            "\143",
            "\1\u00a3\1\uffff\1\u00a4\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1"+
            "\146",
            "\1\u00a3\1\uffff\1\u00a4\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1"+
            "\146",
            "\1\u00a5\1\uffff\1\u00a6\64\uffff\1\u00a7\20\uffff\1\u00a8"+
            "\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af",
            "\1\u00a5\1\uffff\1\u00a6\64\uffff\1\u00a7\20\uffff\1\u00a8"+
            "\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af",
            "\1\u00a8\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1"+
            "\u00af",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\1\u00b0\1\uffff\1\u00b1\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1"+
            "\157",
            "\1\u00b0\1\uffff\1\u00b1\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1"+
            "\157",
            "\1\u00b2\1\uffff\1\u00b3\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1"+
            "\162",
            "\1\u00b2\1\uffff\1\u00b3\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1"+
            "\162",
            "\1\u00b4\1\uffff\1\u00b5\64\uffff\1\u00b6\20\uffff\1\u00b7"+
            "\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1\u00be",
            "\1\u00b4\1\uffff\1\u00b5\64\uffff\1\u00b6\20\uffff\1\u00b7"+
            "\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1\u00be",
            "\1\u00b7\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1"+
            "\u00be",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\1\u00bf\1\uffff\1\u00c0\64\uffff\1\177\20\uffff\1\u0080\1"+
            "\u0081\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087",
            "\1\u00bf\1\uffff\1\u00c0\64\uffff\1\177\20\uffff\1\u0080\1"+
            "\u0081\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087",
            "\1\u009c\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u009d\1\u009e\1\u009f\1\u00a0",
            "\1\u009c\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u009d\1\u009e\1\u009f\1\u00a0",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\1\u00a1\1\uffff\1\u00a2\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1"+
            "\143",
            "\1\u00a1\1\uffff\1\u00a2\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1"+
            "\143",
            "\1\u00a3\1\uffff\1\u00a4\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1"+
            "\146",
            "\1\u00a3\1\uffff\1\u00a4\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\120\1\50\4\uffff\1\50\1\31\4\uffff\1\117\7\uffff\1"+
            "\146",
            "\1\u00a5\1\uffff\1\u00a6\64\uffff\1\u00a7\20\uffff\1\u00a8"+
            "\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af",
            "\1\u00a5\1\uffff\1\u00a6\64\uffff\1\u00a7\20\uffff\1\u00a8"+
            "\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af",
            "\1\u00c1\1\uffff\1\u00c2",
            "\1\u00c5\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00c6\1\u00c7\1\u00c8\1\u00c9\14\uffff\1"+
            "\u00c3\1\u00c4",
            "\1\u00c5\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00c6\1\u00c7\1\u00c8\1\u00c9\14\uffff\1"+
            "\u00c3\1\u00c4",
            "\1\u00c5\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00c6\1\u00c7\1\u00c8\1\u00c9\14\uffff\1"+
            "\u00c3\1\u00c4",
            "\1\u00c5\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00c6\1\u00c7\1\u00c8\1\u00c9\14\uffff\1"+
            "\u00c3\1\u00c4",
            "\1\u00c5\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00c6\1\u00c7\1\u00c8\1\u00c9\14\uffff\1"+
            "\u00c3\1\u00c4",
            "\1\u00c5\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00c6\1\u00c7\1\u00c8\1\u00c9\14\uffff\1"+
            "\u00c3\1\u00c4",
            "\1\u00c5\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00c6\1\u00c7\1\u00c8\1\u00c9\14\uffff\1"+
            "\u00c3\1\u00c4",
            "\1\u00c5\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00c6\1\u00c7\1\u00c8\1\u00c9\14\uffff\1"+
            "\u00c3\1\u00c4",
            "\1\u00b0\1\uffff\1\u00b1\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1"+
            "\157",
            "\1\u00b0\1\uffff\1\u00b1\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1"+
            "\157",
            "\1\u00b2\1\uffff\1\u00b3\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1"+
            "\162",
            "\1\u00b2\1\uffff\1\u00b3\11\uffff\2\50\2\uffff\1\50\7\uffff"+
            "\13\50\1\126\1\50\4\uffff\1\50\1\31\4\uffff\1\125\7\uffff\1"+
            "\162",
            "\1\u00b4\1\uffff\1\u00b5\64\uffff\1\u00b6\20\uffff\1\u00b7"+
            "\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1\u00be",
            "\1\u00b4\1\uffff\1\u00b5\64\uffff\1\u00b6\20\uffff\1\u00b7"+
            "\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1\u00be",
            "\1\u00ca\1\uffff\1\u00cb",
            "\1\u00ce\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00cf\1\u00d0\1\u00d1\1\u00d2\14\uffff\1"+
            "\u00cc\1\u00cd",
            "\1\u00ce\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00cf\1\u00d0\1\u00d1\1\u00d2\14\uffff\1"+
            "\u00cc\1\u00cd",
            "\1\u00ce\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00cf\1\u00d0\1\u00d1\1\u00d2\14\uffff\1"+
            "\u00cc\1\u00cd",
            "\1\u00ce\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00cf\1\u00d0\1\u00d1\1\u00d2\14\uffff\1"+
            "\u00cc\1\u00cd",
            "\1\u00ce\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00cf\1\u00d0\1\u00d1\1\u00d2\14\uffff\1"+
            "\u00cc\1\u00cd",
            "\1\u00ce\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00cf\1\u00d0\1\u00d1\1\u00d2\14\uffff\1"+
            "\u00cc\1\u00cd",
            "\1\u00ce\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00cf\1\u00d0\1\u00d1\1\u00d2\14\uffff\1"+
            "\u00cc\1\u00cd",
            "\1\u00ce\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00cf\1\u00d0\1\u00d1\1\u00d2\14\uffff\1"+
            "\u00cc\1\u00cd",
            "\1\u00bf\1\uffff\1\u00c0\64\uffff\1\177\20\uffff\1\u0080\1"+
            "\u0081\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087",
            "\1\u00bf\1\uffff\1\u00c0\64\uffff\1\177\20\uffff\1\u0080\1"+
            "\u0081\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087",
            "\1\u00d3\1\uffff\1\u00d4\64\uffff\1\u00a7\20\uffff\1\u00a8"+
            "\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af",
            "\1\u00d3\1\uffff\1\u00d4\64\uffff\1\u00a7\20\uffff\1\u00a8"+
            "\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af",
            "\1\u00c5\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00c6\1\u00c7\1\u00c8\1\u00c9",
            "\1\u00c5\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00c6\1\u00c7\1\u00c8\1\u00c9",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\1\u00d5\1\uffff\1\u00d6\64\uffff\1\u00b6\20\uffff\1\u00b7"+
            "\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1\u00be",
            "\1\u00d5\1\uffff\1\u00d6\64\uffff\1\u00b6\20\uffff\1\u00b7"+
            "\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1\u00be",
            "\1\u00ce\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00cf\1\u00d0\1\u00d1\1\u00d2",
            "\1\u00ce\11\uffff\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1"+
            "\50\1\31\25\uffff\1\u00cf\1\u00d0\1\u00d1\1\u00d2",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\2\50\2\uffff\1\50\7\uffff\15\50\4\uffff\1\50\1\31",
            "\1\u00d3\1\uffff\1\u00d4\64\uffff\1\u00a7\20\uffff\1\u00a8"+
            "\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af",
            "\1\u00d3\1\uffff\1\u00d4\64\uffff\1\u00a7\20\uffff\1\u00a8"+
            "\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af",
            "\1\u00d5\1\uffff\1\u00d6\64\uffff\1\u00b6\20\uffff\1\u00b7"+
            "\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1\u00be",
            "\1\u00d5\1\uffff\1\u00d6\64\uffff\1\u00b6\20\uffff\1\u00b7"+
            "\1\u00b8\1\u00b9\1\u00ba\1\u00bb\1\u00bc\1\u00bd\1\u00be"
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
            return "1588:1: (this_Literal_0= ruleLiteral | this_Range_1= ruleRange | this_NativeExpression_2= ruleNativeExpression | this_Reference_3= ruleReference | this_FunctionCall_4= ruleFunctionCall | this_IndexedCall_5= ruleIndexedCall | this_ParenthesizedExpression_6= ruleParenthesizedExpression )";
        }
    }
 

    public static final BitSet FOLLOW_ruleMod_in_entryRuleMod75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMod85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleMod123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMod140 = new BitSet(new long[]{0x00079E300364E050L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMod168 = new BitSet(new long[]{0x00079E300364E050L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleMod191 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleMod219 = new BitSet(new long[]{0x00079E300364E052L});
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
    public static final BitSet FOLLOW_17_in_ruleFunction515 = new BitSet(new long[]{0x00079E300364E050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleFunction536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_entryRuleArgument572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgument582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArgument623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleBlock723 = new BitSet(new long[]{0x00079E30036CE050L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleBlock744 = new BitSet(new long[]{0x00079E30036CE050L});
    public static final BitSet FOLLOW_19_in_ruleBlock757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_ruleStatement852 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_ruleStatement879 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rulePlusAssignmentStatement_in_ruleStatement906 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_ruleStatement933 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleStatement959 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_ruleStatement987 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleStatement999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleStatement1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_ruleStatement1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleStatement1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement1117 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReturnStatement1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleReturnStatement1173 = new BitSet(new long[]{0x00079E3000008052L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReturnStatement1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement1231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleIfStatement1287 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleIfStatement1299 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleIfStatement1320 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleIfStatement1332 = new BitSet(new long[]{0x00079E300364E050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement1353 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleIfStatement1366 = new BitSet(new long[]{0x00079E300364E050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement1425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleWhileStatement1481 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleWhileStatement1493 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleWhileStatement1514 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleWhileStatement1526 = new BitSet(new long[]{0x00079E300364E050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleWhileStatement1547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement1583 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableStatement1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVariableStatement1639 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableStatement1656 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleVariableStatement1674 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableStatement1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_entryRuleAssignmentStatement1733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentStatement1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentStatement1797 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAssignmentStatement1809 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssignmentStatement1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusAssignmentStatement_in_entryRulePlusAssignmentStatement1866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlusAssignmentStatement1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePlusAssignmentStatement1930 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rulePlusAssignmentStatement1942 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePlusAssignmentStatement1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_entryRuleReferenceAssignmentStatement1999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAssignmentStatement2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_ruleReferenceAssignmentStatement2066 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_ruleNodeTypeRef_in_ruleReferenceAssignmentStatement2085 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleReferenceAssignmentStatement2100 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReferenceAssignmentStatement2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression2157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression2167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleExpression2213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_entryRuleLogical2247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogical2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_ruleLogical2304 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_28_in_ruleLogical2327 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_29_in_ruleLogical2356 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleEquality_in_ruleLogical2379 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_ruleEquality_in_entryRuleEquality2417 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquality2427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleEquality2474 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_30_in_ruleEquality2497 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_31_in_ruleEquality2526 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleEquality2549 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison2587 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison2597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison2644 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_32_in_ruleComparison2667 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_33_in_ruleComparison2696 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_34_in_ruleComparison2725 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_35_in_ruleComparison2754 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison2777 = new BitSet(new long[]{0x0000000F00000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition2815 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition2825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition2872 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_36_in_ruleAddition2895 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_37_in_ruleAddition2924 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition2947 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication2985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiplication3042 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_38_in_ruleMultiplication3065 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_39_in_ruleMultiplication3094 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_40_in_ruleMultiplication3123 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiplication3146 = new BitSet(new long[]{0x000001C000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_entryRuleUnary3184 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnary3194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnary3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleUnary3276 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnary3327 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleUnary3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator3388 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator3399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleUnaryOperator3437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUnaryOperator3456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_rulePrimaryExpression3580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeExpression_in_rulePrimaryExpression3607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rulePrimaryExpression3634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_rulePrimaryExpression3661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexedCall_in_rulePrimaryExpression3688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_ruleLiteral3807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleLiteral3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleLiteral3872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteral_in_entryRuleNumberLiteral3910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteral3920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleNumberLiteral3971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression4012 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression4022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedExpression4059 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression4081 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParenthesizedExpression4092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall4128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall4138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionCall4192 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFunctionCall4204 = new BitSet(new long[]{0x00079E3000028050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall4226 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleFunctionCall4239 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall4260 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleFunctionCall4276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndexedCall_in_entryRuleIndexedCall4312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndexedCall4322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_ruleIndexedCall4369 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleIndexedCall4381 = new BitSet(new long[]{0x00079E3000008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIndexedCall4402 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleIndexedCall4414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeExpression_in_entryRuleNativeExpression4452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNativeExpression4462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_ruleNativeExpression4518 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleReference_in_ruleNativeExpression4545 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_ruleNativeExpression4572 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleNativeExpression4585 = new BitSet(new long[]{0xF000000000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleNativeFunction_in_ruleNativeExpression4606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall4642 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarOrArgumentCall4652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarOrArgumentCall4706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_entryRuleRange4742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRange4752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_ruleRange4798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_entryRuleRangeLiteral4832 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeLiteral4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleRangeLiteral4888 = new BitSet(new long[]{0x0000200000000040L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4906 = new BitSet(new long[]{0x0000200000010000L});
    public static final BitSet FOLLOW_16_in_ruleRangeLiteral4924 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleRangeLiteral4941 = new BitSet(new long[]{0x0000200000010000L});
    public static final BitSet FOLLOW_45_in_ruleRangeLiteral4962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference4998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference5008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_ruleReference5055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeTypeRef_in_ruleReference5082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_ruleReference5109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamRef_in_ruleReference5136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamRef_in_entryRuleParamRef5171 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamRef5181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleParamRef5227 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleParamRef5250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeTypeRef_in_entryRuleNodeTypeRef5286 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeTypeRef5296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleNodeTypeRef5342 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNodeTypeRef5362 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rulePrimaryRef_in_ruleNodeTypeRef5383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_entryRuleNodeRef5419 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeRef5429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleNodeRef5475 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNodeRef5495 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rulePrimaryRef_in_ruleNodeRef5516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_entryRuleContextRef5552 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextRef5562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleContextRef5608 = new BitSet(new long[]{0x0000008000000000L,0x00000000000FF000L});
    public static final BitSet FOLLOW_rulePrimaryRef_in_ruleContextRef5630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeRef_in_ruleContextRef5657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryRef_in_entryRulePrimaryRef5694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryRef5704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperatorRef_in_rulePrimaryRef5750 = new BitSet(new long[]{0x0008008000000002L});
    public static final BitSet FOLLOW_51_in_rulePrimaryRef5764 = new BitSet(new long[]{0x0500000000000000L,0x0000000000000F00L});
    public static final BitSet FOLLOW_ruleLeafReference_in_rulePrimaryRef5785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperatorRef_in_entryRuleOperatorRef5823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperatorRef5833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleOperatorRef5879 = new BitSet(new long[]{0x00F0000000000000L});
    public static final BitSet FOLLOW_52_in_ruleOperatorRef5893 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleOperatorRef5916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleOperatorRef5936 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleOperatorRef5959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleOperatorRef5978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleOperatorRef5996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLeafReference_in_entryRuleLeafReference6033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLeafReference6043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_ruleLeafReference6090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_ruleLeafReference6117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatusRef_in_ruleLeafReference6144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_entryRuleResourceRef6179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceRef6189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleResourceRef6235 = new BitSet(new long[]{0x0200000000000050L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleResourceRef6259 = new BitSet(new long[]{0x0000008000000000L,0x00000000000FF000L});
    public static final BitSet FOLLOW_57_in_ruleResourceRef6283 = new BitSet(new long[]{0x0000008000000000L,0x00000000000FF000L});
    public static final BitSet FOLLOW_ruleRangeRef_in_ruleResourceRef6318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatusRef_in_entryRuleStatusRef6354 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatusRef6364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleToleranceLevel_in_ruleStatusRef6419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeRef_in_entryRuleRangeRef6455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeRef6465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueRange_in_ruleRangeRef6511 = new BitSet(new long[]{0x0000000000000042L,0x00000000003000F0L});
    public static final BitSet FOLLOW_ruleValueKind_in_ruleRangeRef6532 = new BitSet(new long[]{0x0000000000000042L,0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleInterval_in_ruleRangeRef6554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInterval_in_entryRuleInterval6591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInterval6601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleInterval6643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntervalKind_in_ruleInterval6675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_entryRuleLinkRef6711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLinkRef6721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleLinkRef6767 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLinkRef6787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN6824 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN6835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSPACED_ID_in_ruleFQN6882 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleFQN6901 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleSPACED_ID_in_ruleFQN6923 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ruleSPACED_ID_in_entryRuleSPACED_ID6971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSPACED_ID6982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPACED_ID7023 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleSPACED_ID7049 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSPACED_ID7071 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleSPACED_ID7097 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_60_in_ruleNativeFunction7158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleNativeFunction7175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleNativeFunction7192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleNativeFunction7209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleNativeFunction7226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleNativeFunction7243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleNativeFunction7260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleNativeFunction7277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleIntervalKind7322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleIntervalKind7339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleIntervalKind7356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleIntervalKind7373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleToleranceLevel7418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleToleranceLevel7435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleToleranceLevel7452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleToleranceLevel7469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleValueRange7514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleValueRange7531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleValueRange7548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleValueRange7565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleValueRange7582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleValueRange7599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleValueRange7616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleValueRange7633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleValueKind7678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleValueKind7695 = new BitSet(new long[]{0x0000000000000002L});

}