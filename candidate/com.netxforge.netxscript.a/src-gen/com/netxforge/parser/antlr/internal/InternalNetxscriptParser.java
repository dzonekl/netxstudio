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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NUMBER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mod'", "'import'", "'def'", "'('", "','", "')'", "'{'", "'}'", "';'", "'return'", "'if'", "'else'", "'while'", "'var'", "'='", "'&&'", "'||'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'true'", "'false'", "'.'", "'this'", "'->'", "'RES'", "'LINK'", "'COUNT'", "'SUM'", "'MIN'", "'MAX'", "'MEAN'", "'DEVIATION'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_NUMBER=6;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
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
    public String getGrammarFileName() { return "../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g"; }



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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:68:1: entryRuleMod returns [EObject current=null] : iv_ruleMod= ruleMod EOF ;
    public final EObject entryRuleMod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMod = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:69:2: (iv_ruleMod= ruleMod EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:70:2: iv_ruleMod= ruleMod EOF
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:77:1: ruleMod returns [EObject current=null] : ( (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_functions_3_0= ruleFunction ) )* ( (lv_statements_4_0= ruleStatement ) )* ) ;
    public final EObject ruleMod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_imports_2_0 = null;

        EObject lv_functions_3_0 = null;

        EObject lv_statements_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:80:28: ( ( (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_functions_3_0= ruleFunction ) )* ( (lv_statements_4_0= ruleStatement ) )* ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:81:1: ( (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_functions_3_0= ruleFunction ) )* ( (lv_statements_4_0= ruleStatement ) )* )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:81:1: ( (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_functions_3_0= ruleFunction ) )* ( (lv_statements_4_0= ruleStatement ) )* )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:81:2: (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )? ( (lv_imports_2_0= ruleImport ) )* ( (lv_functions_3_0= ruleFunction ) )* ( (lv_statements_4_0= ruleStatement ) )*
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:81:2: (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:81:4: otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleMod123); 

                        	newLeafNode(otherlv_0, grammarAccess.getModAccess().getModKeyword_0_0());
                        
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:85:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:86:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:86:1: (lv_name_1_0= RULE_ID )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:87:3: lv_name_1_0= RULE_ID
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

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:103:4: ( (lv_imports_2_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:104:1: (lv_imports_2_0= ruleImport )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:104:1: (lv_imports_2_0= ruleImport )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:105:3: lv_imports_2_0= ruleImport
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

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:121:3: ( (lv_functions_3_0= ruleFunction ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:122:1: (lv_functions_3_0= ruleFunction )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:122:1: (lv_functions_3_0= ruleFunction )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:123:3: lv_functions_3_0= ruleFunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModAccess().getFunctionsFunctionParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFunction_in_ruleMod190);
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
            	    break loop3;
                }
            } while (true);

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:139:3: ( (lv_statements_4_0= ruleStatement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID||LA4_0==RULE_NUMBER||LA4_0==15||LA4_0==18||(LA4_0>=21 && LA4_0<=22)||(LA4_0>=24 && LA4_0<=25)||(LA4_0>=35 && LA4_0<=36)||(LA4_0>=40 && LA4_0<=42)||LA4_0==44) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:140:1: (lv_statements_4_0= ruleStatement )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:140:1: (lv_statements_4_0= ruleStatement )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:141:3: lv_statements_4_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModAccess().getStatementsStatementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleMod212);
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
            	    break loop4;
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
    // $ANTLR end "ruleMod"


    // $ANTLR start "entryRuleImport"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:167:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:168:2: (iv_ruleImport= ruleImport EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:169:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport251);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport261); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:176:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:179:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:180:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:180:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:180:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleImport298); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:184:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:185:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:185:1: (lv_importURI_1_0= RULE_STRING )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:186:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport315); 

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:210:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:211:2: (iv_ruleFunction= ruleFunction EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:212:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction356);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction366); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:219:1: ruleFunction returns [EObject current=null] : (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) ) ;
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
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:222:28: ( (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:223:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:223:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:223:3: otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleFunction403); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getDefKeyword_0());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:227:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:228:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:228:1: (lv_name_1_0= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:229:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction420); 

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

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleFunction437); 

                	newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:249:1: ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:249:2: ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )*
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:249:2: ( (lv_args_3_0= ruleArgument ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:250:1: (lv_args_3_0= ruleArgument )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:250:1: (lv_args_3_0= ruleArgument )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:251:3: lv_args_3_0= ruleArgument
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArgument_in_ruleFunction459);
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

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:267:2: (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:267:4: otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleFunction472); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:271:1: ( (lv_args_5_0= ruleArgument ) )
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:272:1: (lv_args_5_0= ruleArgument )
                    	    {
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:272:1: (lv_args_5_0= ruleArgument )
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:273:3: lv_args_5_0= ruleArgument
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArgument_in_ruleFunction493);
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
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleFunction509); 

                	newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_4());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:293:1: ( (lv_block_7_0= ruleBlock ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:294:1: (lv_block_7_0= ruleBlock )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:294:1: (lv_block_7_0= ruleBlock )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:295:3: lv_block_7_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getFunctionAccess().getBlockBlockParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleFunction530);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:319:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:320:2: (iv_ruleArgument= ruleArgument EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:321:2: iv_ruleArgument= ruleArgument EOF
            {
             newCompositeNode(grammarAccess.getArgumentRule()); 
            pushFollow(FOLLOW_ruleArgument_in_entryRuleArgument566);
            iv_ruleArgument=ruleArgument();

            state._fsp--;

             current =iv_ruleArgument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgument576); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:328:1: ruleArgument returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:331:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:332:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:332:1: ( (lv_name_0_0= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:333:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:333:1: (lv_name_0_0= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:334:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArgument617); 

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:362:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:363:2: (iv_ruleBlock= ruleBlock EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:364:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock661);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock671); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:371:1: ruleBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:374:28: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:375:1: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:375:1: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:375:2: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:375:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:376:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBlockAccess().getBlockAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleBlock717); 

                	newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:385:1: ( (lv_statements_2_0= ruleStatement ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==RULE_NUMBER||LA7_0==15||LA7_0==18||(LA7_0>=21 && LA7_0<=22)||(LA7_0>=24 && LA7_0<=25)||(LA7_0>=35 && LA7_0<=36)||(LA7_0>=40 && LA7_0<=42)||LA7_0==44) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:386:1: (lv_statements_2_0= ruleStatement )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:386:1: (lv_statements_2_0= ruleStatement )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:387:3: lv_statements_2_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleBlock738);
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
            	    break loop7;
                }
            } while (true);

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleBlock751); 

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:415:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:416:2: (iv_ruleStatement= ruleStatement EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:417:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement787);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement797); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:424:1: ruleStatement returns [EObject current=null] : ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock ) ;
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
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:427:28: ( ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:428:1: ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:428:1: ( ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' ) | this_IfStatement_6= ruleIfStatement | this_WhileStatement_7= ruleWhileStatement | this_Block_8= ruleBlock )
            int alt9=4;
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
            case 44:
                {
                alt9=1;
                }
                break;
            case 22:
                {
                alt9=2;
                }
                break;
            case 24:
                {
                alt9=3;
                }
                break;
            case 18:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:428:2: ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:428:2: ( (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';' )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:428:3: (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement ) otherlv_5= ';'
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:428:3: (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement )
                    int alt8=5;
                    alt8 = dfa8.predict(input);
                    switch (alt8) {
                        case 1 :
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:429:5: this_VariableStatement_0= ruleVariableStatement
                            {
                             
                                    newCompositeNode(grammarAccess.getStatementAccess().getVariableStatementParserRuleCall_0_0_0()); 
                                
                            pushFollow(FOLLOW_ruleVariableStatement_in_ruleStatement846);
                            this_VariableStatement_0=ruleVariableStatement();

                            state._fsp--;

                             
                                    current = this_VariableStatement_0; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;
                        case 2 :
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:439:5: this_AssignmentStatement_1= ruleAssignmentStatement
                            {
                             
                                    newCompositeNode(grammarAccess.getStatementAccess().getAssignmentStatementParserRuleCall_0_0_1()); 
                                
                            pushFollow(FOLLOW_ruleAssignmentStatement_in_ruleStatement873);
                            this_AssignmentStatement_1=ruleAssignmentStatement();

                            state._fsp--;

                             
                                    current = this_AssignmentStatement_1; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;
                        case 3 :
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:449:5: this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement
                            {
                             
                                    newCompositeNode(grammarAccess.getStatementAccess().getReferenceAssignmentStatementParserRuleCall_0_0_2()); 
                                
                            pushFollow(FOLLOW_ruleReferenceAssignmentStatement_in_ruleStatement900);
                            this_ReferenceAssignmentStatement_2=ruleReferenceAssignmentStatement();

                            state._fsp--;

                             
                                    current = this_ReferenceAssignmentStatement_2; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;
                        case 4 :
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:458:6: ( (lv_expression_3_0= ruleExpression ) )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:458:6: ( (lv_expression_3_0= ruleExpression ) )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:459:1: (lv_expression_3_0= ruleExpression )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:459:1: (lv_expression_3_0= ruleExpression )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:460:3: lv_expression_3_0= ruleExpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getStatementAccess().getExpressionExpressionParserRuleCall_0_0_3_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpression_in_ruleStatement926);
                            lv_expression_3_0=ruleExpression();

                            state._fsp--;


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
                            break;
                        case 5 :
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:478:5: this_ReturnStatement_4= ruleReturnStatement
                            {
                             
                                    newCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_0_0_4()); 
                                
                            pushFollow(FOLLOW_ruleReturnStatement_in_ruleStatement954);
                            this_ReturnStatement_4=ruleReturnStatement();

                            state._fsp--;

                             
                                    current = this_ReturnStatement_4; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleStatement966); 

                        	newLeafNode(otherlv_5, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:492:5: this_IfStatement_6= ruleIfStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIfStatement_in_ruleStatement995);
                    this_IfStatement_6=ruleIfStatement();

                    state._fsp--;

                     
                            current = this_IfStatement_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:502:5: this_WhileStatement_7= ruleWhileStatement
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleWhileStatement_in_ruleStatement1022);
                    this_WhileStatement_7=ruleWhileStatement();

                    state._fsp--;

                     
                            current = this_WhileStatement_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:512:5: this_Block_8= ruleBlock
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleBlock_in_ruleStatement1049);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:528:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:529:2: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:530:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
             newCompositeNode(grammarAccess.getReturnStatementRule()); 
            pushFollow(FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement1084);
            iv_ruleReturnStatement=ruleReturnStatement();

            state._fsp--;

             current =iv_ruleReturnStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReturnStatement1094); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:537:1: ruleReturnStatement returns [EObject current=null] : ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:540:28: ( ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:541:1: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:541:1: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:541:2: () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )?
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:541:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:542:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReturnStatementAccess().getReturnAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleReturnStatement1140); 

                	newLeafNode(otherlv_1, grammarAccess.getReturnStatementAccess().getReturnKeyword_1());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:551:1: ( (lv_expression_2_0= ruleExpression ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||LA10_0==RULE_NUMBER||LA10_0==15||(LA10_0>=35 && LA10_0<=36)||(LA10_0>=40 && LA10_0<=42)||LA10_0==44) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:552:1: (lv_expression_2_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:552:1: (lv_expression_2_0= ruleExpression )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:553:3: lv_expression_2_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleReturnStatement1161);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:577:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:578:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:579:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
             newCompositeNode(grammarAccess.getIfStatementRule()); 
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement1198);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;

             current =iv_ruleIfStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement1208); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:586:1: ruleIfStatement returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? ) ;
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
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:589:28: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:590:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:590:1: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )? )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:590:2: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_then_5_0= ruleBlock ) ) (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )?
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:590:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:591:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIfStatementAccess().getIfAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleIfStatement1254); 

                	newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getIfKeyword_1());
                
            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleIfStatement1266); 

                	newLeafNode(otherlv_2, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:604:1: ( (lv_if_3_0= ruleLogical ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:605:1: (lv_if_3_0= ruleLogical )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:605:1: (lv_if_3_0= ruleLogical )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:606:3: lv_if_3_0= ruleLogical
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getIfLogicalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLogical_in_ruleIfStatement1287);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleIfStatement1299); 

                	newLeafNode(otherlv_4, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_4());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:626:1: ( (lv_then_5_0= ruleBlock ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:627:1: (lv_then_5_0= ruleBlock )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:627:1: (lv_then_5_0= ruleBlock )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:628:3: lv_then_5_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getIfStatementAccess().getThenBlockParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement1320);
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

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:644:2: (otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:644:4: otherlv_6= 'else' ( (lv_else_7_0= ruleBlock ) )
                    {
                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleIfStatement1333); 

                        	newLeafNode(otherlv_6, grammarAccess.getIfStatementAccess().getElseKeyword_6_0());
                        
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:648:1: ( (lv_else_7_0= ruleBlock ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:649:1: (lv_else_7_0= ruleBlock )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:649:1: (lv_else_7_0= ruleBlock )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:650:3: lv_else_7_0= ruleBlock
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfStatementAccess().getElseBlockParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement1354);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:674:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:675:2: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:676:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
             newCompositeNode(grammarAccess.getWhileStatementRule()); 
            pushFollow(FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement1392);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;

             current =iv_ruleWhileStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileStatement1402); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:683:1: ruleWhileStatement returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:686:28: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:687:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:687:1: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:687:2: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleLogical ) ) otherlv_4= ')' ( (lv_body_5_0= ruleBlock ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:687:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:688:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getWhileStatementAccess().getWhileAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleWhileStatement1448); 

                	newLeafNode(otherlv_1, grammarAccess.getWhileStatementAccess().getWhileKeyword_1());
                
            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleWhileStatement1460); 

                	newLeafNode(otherlv_2, grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:701:1: ( (lv_predicate_3_0= ruleLogical ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:702:1: (lv_predicate_3_0= ruleLogical )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:702:1: (lv_predicate_3_0= ruleLogical )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:703:3: lv_predicate_3_0= ruleLogical
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getPredicateLogicalParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLogical_in_ruleWhileStatement1481);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleWhileStatement1493); 

                	newLeafNode(otherlv_4, grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_4());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:723:1: ( (lv_body_5_0= ruleBlock ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:724:1: (lv_body_5_0= ruleBlock )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:724:1: (lv_body_5_0= ruleBlock )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:725:3: lv_body_5_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleWhileStatement1514);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:749:1: entryRuleVariableStatement returns [EObject current=null] : iv_ruleVariableStatement= ruleVariableStatement EOF ;
    public final EObject entryRuleVariableStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableStatement = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:750:2: (iv_ruleVariableStatement= ruleVariableStatement EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:751:2: iv_ruleVariableStatement= ruleVariableStatement EOF
            {
             newCompositeNode(grammarAccess.getVariableStatementRule()); 
            pushFollow(FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement1550);
            iv_ruleVariableStatement=ruleVariableStatement();

            state._fsp--;

             current =iv_ruleVariableStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableStatement1560); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:758:1: ruleVariableStatement returns [EObject current=null] : ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:761:28: ( ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:762:1: ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:762:1: ( () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )? )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:762:2: () otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:762:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:763:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVariableStatementAccess().getVariableAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleVariableStatement1606); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableStatementAccess().getVarKeyword_1());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:772:1: ( (lv_name_2_0= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:773:1: (lv_name_2_0= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:773:1: (lv_name_2_0= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:774:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableStatement1623); 

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

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:790:2: (otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==26) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:790:4: otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleVariableStatement1641); 

                        	newLeafNode(otherlv_3, grammarAccess.getVariableStatementAccess().getEqualsSignKeyword_3_0());
                        
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:794:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:795:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:795:1: (lv_expression_4_0= ruleExpression )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:796:3: lv_expression_4_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableStatement1662);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:820:1: entryRuleAssignmentStatement returns [EObject current=null] : iv_ruleAssignmentStatement= ruleAssignmentStatement EOF ;
    public final EObject entryRuleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentStatement = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:821:2: (iv_ruleAssignmentStatement= ruleAssignmentStatement EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:822:2: iv_ruleAssignmentStatement= ruleAssignmentStatement EOF
            {
             newCompositeNode(grammarAccess.getAssignmentStatementRule()); 
            pushFollow(FOLLOW_ruleAssignmentStatement_in_entryRuleAssignmentStatement1700);
            iv_ruleAssignmentStatement=ruleAssignmentStatement();

            state._fsp--;

             current =iv_ruleAssignmentStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentStatement1710); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:829:1: ruleAssignmentStatement returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:832:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:833:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:833:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:833:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:833:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:834:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAssignmentStatementAccess().getAssignmentAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:839:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:840:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:840:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:841:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAssignmentStatementRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignmentStatement1764); 

            		newLeafNode(otherlv_1, grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleAssignmentStatement1776); 

                	newLeafNode(otherlv_2, grammarAccess.getAssignmentStatementAccess().getEqualsSignKeyword_2());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:856:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:857:1: (lv_expression_3_0= ruleExpression )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:857:1: (lv_expression_3_0= ruleExpression )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:858:3: lv_expression_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleAssignmentStatement1797);
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


    // $ANTLR start "entryRuleReferenceAssignmentStatement"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:882:1: entryRuleReferenceAssignmentStatement returns [EObject current=null] : iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF ;
    public final EObject entryRuleReferenceAssignmentStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAssignmentStatement = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:883:2: (iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:884:2: iv_ruleReferenceAssignmentStatement= ruleReferenceAssignmentStatement EOF
            {
             newCompositeNode(grammarAccess.getReferenceAssignmentStatementRule()); 
            pushFollow(FOLLOW_ruleReferenceAssignmentStatement_in_entryRuleReferenceAssignmentStatement1833);
            iv_ruleReferenceAssignmentStatement=ruleReferenceAssignmentStatement();

            state._fsp--;

             current =iv_ruleReferenceAssignmentStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceAssignmentStatement1843); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:891:1: ruleReferenceAssignmentStatement returns [EObject current=null] : ( () ( (lv_ref_1_0= ruleContextRef ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleReferenceAssignmentStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_ref_1_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:894:28: ( ( () ( (lv_ref_1_0= ruleContextRef ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:895:1: ( () ( (lv_ref_1_0= ruleContextRef ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:895:1: ( () ( (lv_ref_1_0= ruleContextRef ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:895:2: () ( (lv_ref_1_0= ruleContextRef ) ) otherlv_2= '=' ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:895:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:896:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignementAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:901:2: ( (lv_ref_1_0= ruleContextRef ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:902:1: (lv_ref_1_0= ruleContextRef )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:902:1: (lv_ref_1_0= ruleContextRef )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:903:3: lv_ref_1_0= ruleContextRef
            {
             
            	        newCompositeNode(grammarAccess.getReferenceAssignmentStatementAccess().getRefContextRefParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleContextRef_in_ruleReferenceAssignmentStatement1898);
            lv_ref_1_0=ruleContextRef();

            state._fsp--;


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

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleReferenceAssignmentStatement1910); 

                	newLeafNode(otherlv_2, grammarAccess.getReferenceAssignmentStatementAccess().getEqualsSignKeyword_2());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:923:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:924:1: (lv_expression_3_0= ruleExpression )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:924:1: (lv_expression_3_0= ruleExpression )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:925:3: lv_expression_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleReferenceAssignmentStatement1931);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:949:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:950:2: (iv_ruleExpression= ruleExpression EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:951:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression1967);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression1977); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:958:1: ruleExpression returns [EObject current=null] : this_Logical_0= ruleLogical ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Logical_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:961:28: (this_Logical_0= ruleLogical )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:963:5: this_Logical_0= ruleLogical
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getLogicalParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleLogical_in_ruleExpression2023);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:979:1: entryRuleLogical returns [EObject current=null] : iv_ruleLogical= ruleLogical EOF ;
    public final EObject entryRuleLogical() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogical = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:980:2: (iv_ruleLogical= ruleLogical EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:981:2: iv_ruleLogical= ruleLogical EOF
            {
             newCompositeNode(grammarAccess.getLogicalRule()); 
            pushFollow(FOLLOW_ruleLogical_in_entryRuleLogical2057);
            iv_ruleLogical=ruleLogical();

            state._fsp--;

             current =iv_ruleLogical; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogical2067); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:988:1: ruleLogical returns [EObject current=null] : (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* ) ;
    public final EObject ruleLogical() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Equality_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:991:28: ( (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:992:1: (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:992:1: (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:993:5: this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getLogicalAccess().getEqualityParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleEquality_in_ruleLogical2114);
            this_Equality_0=ruleEquality();

            state._fsp--;

             
                    current = this_Equality_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1001:1: ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=27 && LA14_0<=28)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1001:2: ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1001:2: ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) )
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==27) ) {
            	        alt13=1;
            	    }
            	    else if ( (LA13_0==28) ) {
            	        alt13=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 13, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1001:3: ( () otherlv_2= '&&' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1001:3: ( () otherlv_2= '&&' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1001:4: () otherlv_2= '&&'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1001:4: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1002:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleLogical2137); 

            	                	newLeafNode(otherlv_2, grammarAccess.getLogicalAccess().getAmpersandAmpersandKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1012:6: ( () otherlv_4= '||' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1012:6: ( () otherlv_4= '||' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1012:7: () otherlv_4= '||'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1012:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1013:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleLogical2166); 

            	                	newLeafNode(otherlv_4, grammarAccess.getLogicalAccess().getVerticalLineVerticalLineKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1022:3: ( (lv_right_5_0= ruleEquality ) )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1023:1: (lv_right_5_0= ruleEquality )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1023:1: (lv_right_5_0= ruleEquality )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1024:3: lv_right_5_0= ruleEquality
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalAccess().getRightEqualityParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEquality_in_ruleLogical2189);
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
            	    break loop14;
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1048:1: entryRuleEquality returns [EObject current=null] : iv_ruleEquality= ruleEquality EOF ;
    public final EObject entryRuleEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquality = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1049:2: (iv_ruleEquality= ruleEquality EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1050:2: iv_ruleEquality= ruleEquality EOF
            {
             newCompositeNode(grammarAccess.getEqualityRule()); 
            pushFollow(FOLLOW_ruleEquality_in_entryRuleEquality2227);
            iv_ruleEquality=ruleEquality();

            state._fsp--;

             current =iv_ruleEquality; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquality2237); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1057:1: ruleEquality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEquality() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1060:28: ( (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1061:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1061:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1062:5: this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleComparison_in_ruleEquality2284);
            this_Comparison_0=ruleComparison();

            state._fsp--;

             
                    current = this_Comparison_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1070:1: ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=29 && LA16_0<=30)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1070:2: ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1070:2: ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) )
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==29) ) {
            	        alt15=1;
            	    }
            	    else if ( (LA15_0==30) ) {
            	        alt15=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 15, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1070:3: ( () otherlv_2= '==' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1070:3: ( () otherlv_2= '==' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1070:4: () otherlv_2= '=='
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1070:4: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1071:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleEquality2307); 

            	                	newLeafNode(otherlv_2, grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1081:6: ( () otherlv_4= '!=' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1081:6: ( () otherlv_4= '!=' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1081:7: () otherlv_4= '!='
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1081:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1082:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleEquality2336); 

            	                	newLeafNode(otherlv_4, grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1091:3: ( (lv_right_5_0= ruleComparison ) )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1092:1: (lv_right_5_0= ruleComparison )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1092:1: (lv_right_5_0= ruleComparison )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1093:3: lv_right_5_0= ruleComparison
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComparison_in_ruleEquality2359);
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
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleComparison"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1117:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1118:2: (iv_ruleComparison= ruleComparison EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1119:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison2397);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison2407); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1126:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* ) ;
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
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1129:28: ( (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1130:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1130:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1131:5: this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleComparison2454);
            this_Addition_0=ruleAddition();

            state._fsp--;

             
                    current = this_Addition_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1139:1: ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=31 && LA18_0<=34)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1139:2: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1139:2: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) )
            	    int alt17=4;
            	    switch ( input.LA(1) ) {
            	    case 31:
            	        {
            	        alt17=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt17=2;
            	        }
            	        break;
            	    case 33:
            	        {
            	        alt17=3;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt17=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 17, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt17) {
            	        case 1 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1139:3: ( () otherlv_2= '<' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1139:3: ( () otherlv_2= '<' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1139:4: () otherlv_2= '<'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1139:4: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1140:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleComparison2477); 

            	                	newLeafNode(otherlv_2, grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1150:6: ( () otherlv_4= '<=' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1150:6: ( () otherlv_4= '<=' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1150:7: () otherlv_4= '<='
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1150:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1151:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleComparison2506); 

            	                	newLeafNode(otherlv_4, grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1161:6: ( () otherlv_6= '>' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1161:6: ( () otherlv_6= '>' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1161:7: () otherlv_6= '>'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1161:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1162:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0(),
            	                        current);
            	                

            	            }

            	            otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleComparison2535); 

            	                	newLeafNode(otherlv_6, grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1());
            	                

            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1172:6: ( () otherlv_8= '>=' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1172:6: ( () otherlv_8= '>=' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1172:7: () otherlv_8= '>='
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1172:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1173:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0(),
            	                        current);
            	                

            	            }

            	            otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleComparison2564); 

            	                	newLeafNode(otherlv_8, grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_3_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1182:3: ( (lv_right_9_0= ruleAddition ) )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1183:1: (lv_right_9_0= ruleAddition )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1183:1: (lv_right_9_0= ruleAddition )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1184:3: lv_right_9_0= ruleAddition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAddition_in_ruleComparison2587);
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
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleAddition"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1208:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1209:2: (iv_ruleAddition= ruleAddition EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1210:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition2625);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition2635); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1217:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1220:28: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1221:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1221:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1222:5: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition2682);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;

             
                    current = this_Multiplication_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1230:1: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=35 && LA20_0<=36)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1230:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1230:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==35) ) {
            	        alt19=1;
            	    }
            	    else if ( (LA19_0==36) ) {
            	        alt19=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1230:3: ( () otherlv_2= '+' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1230:3: ( () otherlv_2= '+' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1230:4: () otherlv_2= '+'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1230:4: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1231:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleAddition2705); 

            	                	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1241:6: ( () otherlv_4= '-' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1241:6: ( () otherlv_4= '-' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1241:7: () otherlv_4= '-'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1241:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1242:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,36,FOLLOW_36_in_ruleAddition2734); 

            	                	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1251:3: ( (lv_right_5_0= ruleMultiplication ) )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1252:1: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1252:1: (lv_right_5_0= ruleMultiplication )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1253:3: lv_right_5_0= ruleMultiplication
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition2757);
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
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1277:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1278:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1279:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication2795);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication2805); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1286:1: ruleMultiplication returns [EObject current=null] : (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_Unary_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1289:28: ( (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1290:1: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1290:1: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1291:5: this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleUnary_in_ruleMultiplication2852);
            this_Unary_0=ruleUnary();

            state._fsp--;

             
                    current = this_Unary_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1299:1: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=37 && LA22_0<=39)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1299:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1299:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) )
            	    int alt21=3;
            	    switch ( input.LA(1) ) {
            	    case 37:
            	        {
            	        alt21=1;
            	        }
            	        break;
            	    case 38:
            	        {
            	        alt21=2;
            	        }
            	        break;
            	    case 39:
            	        {
            	        alt21=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 21, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt21) {
            	        case 1 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1299:3: ( () otherlv_2= '*' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1299:3: ( () otherlv_2= '*' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1299:4: () otherlv_2= '*'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1299:4: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1300:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,37,FOLLOW_37_in_ruleMultiplication2875); 

            	                	newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1310:6: ( () otherlv_4= '/' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1310:6: ( () otherlv_4= '/' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1310:7: () otherlv_4= '/'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1310:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1311:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,38,FOLLOW_38_in_ruleMultiplication2904); 

            	                	newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1321:6: ( () otherlv_6= '%' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1321:6: ( () otherlv_6= '%' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1321:7: () otherlv_6= '%'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1321:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1322:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0(),
            	                        current);
            	                

            	            }

            	            otherlv_6=(Token)match(input,39,FOLLOW_39_in_ruleMultiplication2933); 

            	                	newLeafNode(otherlv_6, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1331:3: ( (lv_right_7_0= ruleUnary ) )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1332:1: (lv_right_7_0= ruleUnary )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1332:1: (lv_right_7_0= ruleUnary )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1333:3: lv_right_7_0= ruleUnary
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnary_in_ruleMultiplication2956);
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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleUnary"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1357:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1358:2: (iv_ruleUnary= ruleUnary EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1359:2: iv_ruleUnary= ruleUnary EOF
            {
             newCompositeNode(grammarAccess.getUnaryRule()); 
            pushFollow(FOLLOW_ruleUnary_in_entryRuleUnary2994);
            iv_ruleUnary=ruleUnary();

            state._fsp--;

             current =iv_ruleUnary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnary3004); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1366:1: ruleUnary returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_PrimaryExpression_0 = null;

        AntlrDatatypeRuleToken lv_op_4_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1369:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1370:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1370:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID||LA24_0==RULE_NUMBER||LA24_0==15||(LA24_0>=41 && LA24_0<=42)||LA24_0==44) ) {
                alt24=1;
            }
            else if ( ((LA24_0>=35 && LA24_0<=36)||LA24_0==40) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1371:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            newCompositeNode(grammarAccess.getUnaryAccess().getPrimaryExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnary3051);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:6: ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:6: ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:7: ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:7: ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==40) ) {
                        alt23=1;
                    }
                    else if ( ((LA23_0>=35 && LA23_0<=36)) ) {
                        alt23=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:8: ( () ( (lv_op_2_0= '!' ) ) )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:8: ( () ( (lv_op_2_0= '!' ) ) )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:9: () ( (lv_op_2_0= '!' ) )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1380:9: ()
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1381:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getUnaryAccess().getNegationAction_1_0_0_0(),
                                        current);
                                

                            }

                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1386:2: ( (lv_op_2_0= '!' ) )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1387:1: (lv_op_2_0= '!' )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1387:1: (lv_op_2_0= '!' )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1388:3: lv_op_2_0= '!'
                            {
                            lv_op_2_0=(Token)match(input,40,FOLLOW_40_in_ruleUnary3086); 

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
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1402:6: ( () ( (lv_op_4_0= ruleUnaryOperator ) ) )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1402:6: ( () ( (lv_op_4_0= ruleUnaryOperator ) ) )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1402:7: () ( (lv_op_4_0= ruleUnaryOperator ) )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1402:7: ()
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1403:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getUnaryAccess().getUnaryPlusMinusAction_1_0_1_0(),
                                        current);
                                

                            }

                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1408:2: ( (lv_op_4_0= ruleUnaryOperator ) )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1409:1: (lv_op_4_0= ruleUnaryOperator )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1409:1: (lv_op_4_0= ruleUnaryOperator )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1410:3: lv_op_4_0= ruleUnaryOperator
                            {
                             
                            	        newCompositeNode(grammarAccess.getUnaryAccess().getOpUnaryOperatorParserRuleCall_1_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnary3137);
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

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1426:4: ( (lv_right_5_0= ruleUnary ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1427:1: (lv_right_5_0= ruleUnary )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1427:1: (lv_right_5_0= ruleUnary )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1428:3: lv_right_5_0= ruleUnary
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryAccess().getRightUnaryParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnary_in_ruleUnary3160);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1452:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1453:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1454:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
             newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator3198);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;

             current =iv_ruleUnaryOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator3209); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1461:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1464:28: ( (kw= '-' | kw= '+' ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1465:1: (kw= '-' | kw= '+' )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1465:1: (kw= '-' | kw= '+' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==36) ) {
                alt25=1;
            }
            else if ( (LA25_0==35) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1466:2: kw= '-'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleUnaryOperator3247); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1473:2: kw= '+'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleUnaryOperator3266); 

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1486:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1487:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1488:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3306);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression3316); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1495:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_Reference_1= ruleReference | this_FunctionCall_2= ruleFunctionCall | this_VarOrArgumentCall_3= ruleVarOrArgumentCall | this_ParenthesizedExpression_4= ruleParenthesizedExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_Reference_1 = null;

        EObject this_FunctionCall_2 = null;

        EObject this_VarOrArgumentCall_3 = null;

        EObject this_ParenthesizedExpression_4 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1498:28: ( (this_Literal_0= ruleLiteral | this_Reference_1= ruleReference | this_FunctionCall_2= ruleFunctionCall | this_VarOrArgumentCall_3= ruleVarOrArgumentCall | this_ParenthesizedExpression_4= ruleParenthesizedExpression ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1499:1: (this_Literal_0= ruleLiteral | this_Reference_1= ruleReference | this_FunctionCall_2= ruleFunctionCall | this_VarOrArgumentCall_3= ruleVarOrArgumentCall | this_ParenthesizedExpression_4= ruleParenthesizedExpression )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1499:1: (this_Literal_0= ruleLiteral | this_Reference_1= ruleReference | this_FunctionCall_2= ruleFunctionCall | this_VarOrArgumentCall_3= ruleVarOrArgumentCall | this_ParenthesizedExpression_4= ruleParenthesizedExpression )
            int alt26=5;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
            case 41:
            case 42:
                {
                alt26=1;
                }
                break;
            case 44:
                {
                alt26=2;
                }
                break;
            case RULE_ID:
                {
                int LA26_3 = input.LA(2);

                if ( (LA26_3==EOF||(LA26_3>=16 && LA26_3<=17)||LA26_3==20||(LA26_3>=27 && LA26_3<=39)) ) {
                    alt26=4;
                }
                else if ( (LA26_3==15) ) {
                    alt26=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 3, input);

                    throw nvae;
                }
                }
                break;
            case 15:
                {
                alt26=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1500:5: this_Literal_0= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression3363);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1510:5: this_Reference_1= ruleReference
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getReferenceParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleReference_in_rulePrimaryExpression3390);
                    this_Reference_1=ruleReference();

                    state._fsp--;

                     
                            current = this_Reference_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1520:5: this_FunctionCall_2= ruleFunctionCall
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleFunctionCall_in_rulePrimaryExpression3417);
                    this_FunctionCall_2=ruleFunctionCall();

                    state._fsp--;

                     
                            current = this_FunctionCall_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1530:5: this_VarOrArgumentCall_3= ruleVarOrArgumentCall
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getVarOrArgumentCallParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVarOrArgumentCall_in_rulePrimaryExpression3444);
                    this_VarOrArgumentCall_3=ruleVarOrArgumentCall();

                    state._fsp--;

                     
                            current = this_VarOrArgumentCall_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1540:5: this_ParenthesizedExpression_4= ruleParenthesizedExpression
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3471);
                    this_ParenthesizedExpression_4=ruleParenthesizedExpression();

                    state._fsp--;

                     
                            current = this_ParenthesizedExpression_4; 
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1556:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1557:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1558:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral3506);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral3516); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1565:1: ruleLiteral returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) | ( () ( ( (lv_condition_3_0= 'true' ) ) | otherlv_4= 'false' ) ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_condition_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1568:28: ( ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) | ( () ( ( (lv_condition_3_0= 'true' ) ) | otherlv_4= 'false' ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1569:1: ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) | ( () ( ( (lv_condition_3_0= 'true' ) ) | otherlv_4= 'false' ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1569:1: ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) | ( () ( ( (lv_condition_3_0= 'true' ) ) | otherlv_4= 'false' ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_NUMBER) ) {
                alt28=1;
            }
            else if ( ((LA28_0>=41 && LA28_0<=42)) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1569:2: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1569:2: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1569:3: () ( (lv_value_1_0= RULE_NUMBER ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1569:3: ()
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1570:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getLiteralAccess().getNumberLiteralAction_0_0(),
                                current);
                        

                    }

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1575:2: ( (lv_value_1_0= RULE_NUMBER ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1576:1: (lv_value_1_0= RULE_NUMBER )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1576:1: (lv_value_1_0= RULE_NUMBER )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1577:3: lv_value_1_0= RULE_NUMBER
                    {
                    lv_value_1_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_ruleLiteral3568); 

                    			newLeafNode(lv_value_1_0, grammarAccess.getLiteralAccess().getValueNUMBERTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLiteralRule());
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
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1594:6: ( () ( ( (lv_condition_3_0= 'true' ) ) | otherlv_4= 'false' ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1594:6: ( () ( ( (lv_condition_3_0= 'true' ) ) | otherlv_4= 'false' ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1594:7: () ( ( (lv_condition_3_0= 'true' ) ) | otherlv_4= 'false' )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1594:7: ()
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1595:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getLiteralAccess().getBooleanLiteralAction_1_0(),
                                current);
                        

                    }

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1600:2: ( ( (lv_condition_3_0= 'true' ) ) | otherlv_4= 'false' )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==41) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==42) ) {
                        alt27=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1600:3: ( (lv_condition_3_0= 'true' ) )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1600:3: ( (lv_condition_3_0= 'true' ) )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1601:1: (lv_condition_3_0= 'true' )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1601:1: (lv_condition_3_0= 'true' )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1602:3: lv_condition_3_0= 'true'
                            {
                            lv_condition_3_0=(Token)match(input,41,FOLLOW_41_in_ruleLiteral3609); 

                                    newLeafNode(lv_condition_3_0, grammarAccess.getLiteralAccess().getConditionTrueKeyword_1_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getLiteralRule());
                            	        }
                                   		setWithLastConsumed(current, "condition", true, "true");
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1616:7: otherlv_4= 'false'
                            {
                            otherlv_4=(Token)match(input,42,FOLLOW_42_in_ruleLiteral3640); 

                                	newLeafNode(otherlv_4, grammarAccess.getLiteralAccess().getFalseKeyword_1_1_1());
                                

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


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1628:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1629:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1630:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression3678);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression3688); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1637:1: ruleParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1640:28: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1641:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1641:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1641:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleParenthesizedExpression3725); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression3747);
            this_Expression_1=ruleExpression();

            state._fsp--;

             
                    current = this_Expression_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleParenthesizedExpression3758); 

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1666:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1667:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1668:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall3794);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionCall3804); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1675:1: ruleFunctionCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
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
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1678:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1679:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1679:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1679:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1679:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1680:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionCallAccess().getFunctionCallAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1685:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1686:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1686:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1687:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionCall3858); 

            		newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleFunctionCall3870); 

                	newLeafNode(otherlv_2, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1702:1: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID||LA30_0==RULE_NUMBER||LA30_0==15||(LA30_0>=35 && LA30_0<=36)||(LA30_0>=40 && LA30_0<=42)||LA30_0==44) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1702:2: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1702:2: ( (lv_args_3_0= ruleExpression ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1703:1: (lv_args_3_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1703:1: (lv_args_3_0= ruleExpression )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1704:3: lv_args_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionCall3892);
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

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1720:2: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==16) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1720:4: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleFunctionCall3905); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1724:1: ( (lv_args_5_0= ruleExpression ) )
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1725:1: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1725:1: (lv_args_5_0= ruleExpression )
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1726:3: lv_args_5_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionCall3926);
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
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleFunctionCall3942); 

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


    // $ANTLR start "entryRuleVarOrArgumentCall"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1754:1: entryRuleVarOrArgumentCall returns [EObject current=null] : iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF ;
    public final EObject entryRuleVarOrArgumentCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarOrArgumentCall = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1755:2: (iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1756:2: iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF
            {
             newCompositeNode(grammarAccess.getVarOrArgumentCallRule()); 
            pushFollow(FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall3978);
            iv_ruleVarOrArgumentCall=ruleVarOrArgumentCall();

            state._fsp--;

             current =iv_ruleVarOrArgumentCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarOrArgumentCall3988); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1763:1: ruleVarOrArgumentCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleVarOrArgumentCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1766:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1767:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1767:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1767:2: () ( (otherlv_1= RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1767:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1768:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVarOrArgumentCallAccess().getVarOrArgumentCallAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1773:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1774:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1774:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1775:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVarOrArgumentCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarOrArgumentCall4042); 

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


    // $ANTLR start "entryRuleReference"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1794:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1795:2: (iv_ruleReference= ruleReference EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1796:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference4078);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference4088); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1803:1: ruleReference returns [EObject current=null] : (this_ContextRef_0= ruleContextRef (otherlv_1= '.' ( (lv_nativeFunction_2_0= ruleNativeFunction ) ) )? ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_ContextRef_0 = null;

        Enumerator lv_nativeFunction_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1806:28: ( (this_ContextRef_0= ruleContextRef (otherlv_1= '.' ( (lv_nativeFunction_2_0= ruleNativeFunction ) ) )? ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1807:1: (this_ContextRef_0= ruleContextRef (otherlv_1= '.' ( (lv_nativeFunction_2_0= ruleNativeFunction ) ) )? )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1807:1: (this_ContextRef_0= ruleContextRef (otherlv_1= '.' ( (lv_nativeFunction_2_0= ruleNativeFunction ) ) )? )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1808:5: this_ContextRef_0= ruleContextRef (otherlv_1= '.' ( (lv_nativeFunction_2_0= ruleNativeFunction ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getReferenceAccess().getContextRefParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleContextRef_in_ruleReference4135);
            this_ContextRef_0=ruleContextRef();

            state._fsp--;

             
                    current = this_ContextRef_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1816:1: (otherlv_1= '.' ( (lv_nativeFunction_2_0= ruleNativeFunction ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==43) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1816:3: otherlv_1= '.' ( (lv_nativeFunction_2_0= ruleNativeFunction ) )
                    {
                    otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleReference4147); 

                        	newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getFullStopKeyword_1_0());
                        
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1820:1: ( (lv_nativeFunction_2_0= ruleNativeFunction ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1821:1: (lv_nativeFunction_2_0= ruleNativeFunction )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1821:1: (lv_nativeFunction_2_0= ruleNativeFunction )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1822:3: lv_nativeFunction_2_0= ruleNativeFunction
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceAccess().getNativeFunctionNativeFunctionEnumRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNativeFunction_in_ruleReference4168);
                    lv_nativeFunction_2_0=ruleNativeFunction();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceRule());
                    	        }
                           		set(
                           			current, 
                           			"nativeFunction",
                            		lv_nativeFunction_2_0, 
                            		"NativeFunction");
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
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleContextRef"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1846:1: entryRuleContextRef returns [EObject current=null] : iv_ruleContextRef= ruleContextRef EOF ;
    public final EObject entryRuleContextRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextRef = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1847:2: (iv_ruleContextRef= ruleContextRef EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1848:2: iv_ruleContextRef= ruleContextRef EOF
            {
             newCompositeNode(grammarAccess.getContextRefRule()); 
            pushFollow(FOLLOW_ruleContextRef_in_entryRuleContextRef4206);
            iv_ruleContextRef=ruleContextRef();

            state._fsp--;

             current =iv_ruleContextRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextRef4216); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1855:1: ruleContextRef returns [EObject current=null] : (otherlv_0= 'this' this_NodeRef_1= ruleNodeRef ) ;
    public final EObject ruleContextRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_NodeRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1858:28: ( (otherlv_0= 'this' this_NodeRef_1= ruleNodeRef ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1859:1: (otherlv_0= 'this' this_NodeRef_1= ruleNodeRef )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1859:1: (otherlv_0= 'this' this_NodeRef_1= ruleNodeRef )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1859:3: otherlv_0= 'this' this_NodeRef_1= ruleNodeRef
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleContextRef4253); 

                	newLeafNode(otherlv_0, grammarAccess.getContextRefAccess().getThisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getContextRefAccess().getNodeRefParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNodeRef_in_ruleContextRef4275);
            this_NodeRef_1=ruleNodeRef();

            state._fsp--;

             
                    current = this_NodeRef_1; 
                    afterParserOrEnumRuleCall();
                

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


    // $ANTLR start "entryRuleNodeRef"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1880:1: entryRuleNodeRef returns [EObject current=null] : iv_ruleNodeRef= ruleNodeRef EOF ;
    public final EObject entryRuleNodeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeRef = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1881:2: (iv_ruleNodeRef= ruleNodeRef EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1882:2: iv_ruleNodeRef= ruleNodeRef EOF
            {
             newCompositeNode(grammarAccess.getNodeRefRule()); 
            pushFollow(FOLLOW_ruleNodeRef_in_entryRuleNodeRef4310);
            iv_ruleNodeRef=ruleNodeRef();

            state._fsp--;

             current =iv_ruleNodeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeRef4320); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1889:1: ruleNodeRef returns [EObject current=null] : ( ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+ (otherlv_1= '->' ( ( (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef ) ) ) )? ) ;
    public final EObject ruleNodeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_nodes_0_0 = null;

        EObject lv_ref_2_1 = null;

        EObject lv_ref_2_2 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1892:28: ( ( ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+ (otherlv_1= '->' ( ( (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef ) ) ) )? ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1893:1: ( ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+ (otherlv_1= '->' ( ( (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef ) ) ) )? )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1893:1: ( ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+ (otherlv_1= '->' ( ( (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef ) ) ) )? )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1893:2: ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+ (otherlv_1= '->' ( ( (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef ) ) ) )?
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1893:2: ( (lv_nodes_0_0= rulePrimaryNodeRef ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==45) ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==RULE_ID) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1894:1: (lv_nodes_0_0= rulePrimaryNodeRef )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1894:1: (lv_nodes_0_0= rulePrimaryNodeRef )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1895:3: lv_nodes_0_0= rulePrimaryNodeRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeRefAccess().getNodesPrimaryNodeRefParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePrimaryNodeRef_in_ruleNodeRef4366);
            	    lv_nodes_0_0=rulePrimaryNodeRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeRefRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"nodes",
            	            		lv_nodes_0_0, 
            	            		"PrimaryNodeRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1911:3: (otherlv_1= '->' ( ( (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef ) ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==45) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1911:5: otherlv_1= '->' ( ( (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef ) ) )
                    {
                    otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleNodeRef4380); 

                        	newLeafNode(otherlv_1, grammarAccess.getNodeRefAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                        
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1915:1: ( ( (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef ) ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1916:1: ( (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1916:1: ( (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1917:1: (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1917:1: (lv_ref_2_1= ruleResourceRef | lv_ref_2_2= ruleLinkRef )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==46) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==47) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1918:3: lv_ref_2_1= ruleResourceRef
                            {
                             
                            	        newCompositeNode(grammarAccess.getNodeRefAccess().getRefResourceRefParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleResourceRef_in_ruleNodeRef4403);
                            lv_ref_2_1=ruleResourceRef();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNodeRefRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"ref",
                                    		lv_ref_2_1, 
                                    		"ResourceRef");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;
                        case 2 :
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1933:8: lv_ref_2_2= ruleLinkRef
                            {
                             
                            	        newCompositeNode(grammarAccess.getNodeRefAccess().getRefLinkRefParserRuleCall_1_1_0_1()); 
                            	    
                            pushFollow(FOLLOW_ruleLinkRef_in_ruleNodeRef4422);
                            lv_ref_2_2=ruleLinkRef();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNodeRefRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"ref",
                                    		lv_ref_2_2, 
                                    		"LinkRef");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }
                            break;

                    }


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
    // $ANTLR end "ruleNodeRef"


    // $ANTLR start "entryRulePrimaryNodeRef"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1959:1: entryRulePrimaryNodeRef returns [EObject current=null] : iv_rulePrimaryNodeRef= rulePrimaryNodeRef EOF ;
    public final EObject entryRulePrimaryNodeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryNodeRef = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1960:2: (iv_rulePrimaryNodeRef= rulePrimaryNodeRef EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1961:2: iv_rulePrimaryNodeRef= rulePrimaryNodeRef EOF
            {
             newCompositeNode(grammarAccess.getPrimaryNodeRefRule()); 
            pushFollow(FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef4463);
            iv_rulePrimaryNodeRef=rulePrimaryNodeRef();

            state._fsp--;

             current =iv_rulePrimaryNodeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryNodeRef4473); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1968:1: rulePrimaryNodeRef returns [EObject current=null] : ( () otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject rulePrimaryNodeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1971:28: ( ( () otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1972:1: ( () otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1972:1: ( () otherlv_1= '->' ( (otherlv_2= RULE_ID ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1972:2: () otherlv_1= '->' ( (otherlv_2= RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1972:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1973:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPrimaryNodeRefAccess().getNodeRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_rulePrimaryNodeRef4519); 

                	newLeafNode(otherlv_1, grammarAccess.getPrimaryNodeRefAccess().getHyphenMinusGreaterThanSignKeyword_1());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1982:1: ( (otherlv_2= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1983:1: (otherlv_2= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1983:1: (otherlv_2= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1984:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPrimaryNodeRefRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimaryNodeRef4539); 

            		newLeafNode(otherlv_2, grammarAccess.getPrimaryNodeRefAccess().getNodeNodeCrossReference_2_0()); 
            	

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
    // $ANTLR end "rulePrimaryNodeRef"


    // $ANTLR start "entryRuleResourceRef"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2003:1: entryRuleResourceRef returns [EObject current=null] : iv_ruleResourceRef= ruleResourceRef EOF ;
    public final EObject entryRuleResourceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResourceRef = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2004:2: (iv_ruleResourceRef= ruleResourceRef EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2005:2: iv_ruleResourceRef= ruleResourceRef EOF
            {
             newCompositeNode(grammarAccess.getResourceRefRule()); 
            pushFollow(FOLLOW_ruleResourceRef_in_entryRuleResourceRef4575);
            iv_ruleResourceRef=ruleResourceRef();

            state._fsp--;

             current =iv_ruleResourceRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceRef4585); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2012:1: ruleResourceRef returns [EObject current=null] : ( () otherlv_1= 'RES' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleResourceRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2015:28: ( ( () otherlv_1= 'RES' ( (otherlv_2= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2016:1: ( () otherlv_1= 'RES' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2016:1: ( () otherlv_1= 'RES' ( (otherlv_2= RULE_ID ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2016:2: () otherlv_1= 'RES' ( (otherlv_2= RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2016:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2017:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getResourceRefAccess().getResourceRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleResourceRef4631); 

                	newLeafNode(otherlv_1, grammarAccess.getResourceRefAccess().getRESKeyword_1());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2026:1: ( (otherlv_2= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2027:1: (otherlv_2= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2027:1: (otherlv_2= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2028:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getResourceRefRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResourceRef4651); 

            		newLeafNode(otherlv_2, grammarAccess.getResourceRefAccess().getResourceResourceCrossReference_2_0()); 
            	

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


    // $ANTLR start "entryRuleLinkRef"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2047:1: entryRuleLinkRef returns [EObject current=null] : iv_ruleLinkRef= ruleLinkRef EOF ;
    public final EObject entryRuleLinkRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinkRef = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2048:2: (iv_ruleLinkRef= ruleLinkRef EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2049:2: iv_ruleLinkRef= ruleLinkRef EOF
            {
             newCompositeNode(grammarAccess.getLinkRefRule()); 
            pushFollow(FOLLOW_ruleLinkRef_in_entryRuleLinkRef4687);
            iv_ruleLinkRef=ruleLinkRef();

            state._fsp--;

             current =iv_ruleLinkRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLinkRef4697); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2056:1: ruleLinkRef returns [EObject current=null] : ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleLinkRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2059:28: ( ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2060:1: ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2060:1: ( () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2060:2: () otherlv_1= 'LINK' ( (otherlv_2= RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2060:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2061:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLinkRefAccess().getLinkRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleLinkRef4743); 

                	newLeafNode(otherlv_1, grammarAccess.getLinkRefAccess().getLINKKeyword_1());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2070:1: ( (otherlv_2= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2071:1: (otherlv_2= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2071:1: (otherlv_2= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2072:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLinkRefRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLinkRef4763); 

            		newLeafNode(otherlv_2, grammarAccess.getLinkRefAccess().getLinkLinkCrossReference_2_0()); 
            	

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


    // $ANTLR start "ruleNativeFunction"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2091:1: ruleNativeFunction returns [Enumerator current=null] : ( (enumLiteral_0= 'COUNT' ) | (enumLiteral_1= 'SUM' ) | (enumLiteral_2= 'MIN' ) | (enumLiteral_3= 'MAX' ) | (enumLiteral_4= 'MEAN' ) | (enumLiteral_5= 'DEVIATION' ) ) ;
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
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2093:28: ( ( (enumLiteral_0= 'COUNT' ) | (enumLiteral_1= 'SUM' ) | (enumLiteral_2= 'MIN' ) | (enumLiteral_3= 'MAX' ) | (enumLiteral_4= 'MEAN' ) | (enumLiteral_5= 'DEVIATION' ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2094:1: ( (enumLiteral_0= 'COUNT' ) | (enumLiteral_1= 'SUM' ) | (enumLiteral_2= 'MIN' ) | (enumLiteral_3= 'MAX' ) | (enumLiteral_4= 'MEAN' ) | (enumLiteral_5= 'DEVIATION' ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2094:1: ( (enumLiteral_0= 'COUNT' ) | (enumLiteral_1= 'SUM' ) | (enumLiteral_2= 'MIN' ) | (enumLiteral_3= 'MAX' ) | (enumLiteral_4= 'MEAN' ) | (enumLiteral_5= 'DEVIATION' ) )
            int alt35=6;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt35=1;
                }
                break;
            case 49:
                {
                alt35=2;
                }
                break;
            case 50:
                {
                alt35=3;
                }
                break;
            case 51:
                {
                alt35=4;
                }
                break;
            case 52:
                {
                alt35=5;
                }
                break;
            case 53:
                {
                alt35=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2094:2: (enumLiteral_0= 'COUNT' )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2094:2: (enumLiteral_0= 'COUNT' )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2094:4: enumLiteral_0= 'COUNT'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_48_in_ruleNativeFunction4813); 

                            current = grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2100:6: (enumLiteral_1= 'SUM' )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2100:6: (enumLiteral_1= 'SUM' )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2100:8: enumLiteral_1= 'SUM'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_49_in_ruleNativeFunction4830); 

                            current = grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2106:6: (enumLiteral_2= 'MIN' )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2106:6: (enumLiteral_2= 'MIN' )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2106:8: enumLiteral_2= 'MIN'
                    {
                    enumLiteral_2=(Token)match(input,50,FOLLOW_50_in_ruleNativeFunction4847); 

                            current = grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2112:6: (enumLiteral_3= 'MAX' )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2112:6: (enumLiteral_3= 'MAX' )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2112:8: enumLiteral_3= 'MAX'
                    {
                    enumLiteral_3=(Token)match(input,51,FOLLOW_51_in_ruleNativeFunction4864); 

                            current = grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2118:6: (enumLiteral_4= 'MEAN' )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2118:6: (enumLiteral_4= 'MEAN' )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2118:8: enumLiteral_4= 'MEAN'
                    {
                    enumLiteral_4=(Token)match(input,52,FOLLOW_52_in_ruleNativeFunction4881); 

                            current = grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2124:6: (enumLiteral_5= 'DEVIATION' )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2124:6: (enumLiteral_5= 'DEVIATION' )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:2124:8: enumLiteral_5= 'DEVIATION'
                    {
                    enumLiteral_5=(Token)match(input,53,FOLLOW_53_in_ruleNativeFunction4898); 

                            current = grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5()); 
                        

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

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\17\uffff";
    static final String DFA8_eofS =
        "\17\uffff";
    static final String DFA8_minS =
        "\1\4\1\uffff\1\17\1\55\3\uffff\1\4\1\24\1\4\1\uffff\2\4\2\24";
    static final String DFA8_maxS =
        "\1\54\1\uffff\1\47\1\55\3\uffff\1\4\1\55\1\57\1\uffff\2\4\2\53";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\2\3\uffff\1\3\4\uffff";
    static final String DFA8_specialS =
        "\17\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\2\1\uffff\1\4\10\uffff\1\4\5\uffff\1\5\3\uffff\1\1\11\uffff"+
            "\2\4\3\uffff\3\4\1\uffff\1\3",
            "",
            "\1\4\4\uffff\1\4\5\uffff\1\6\15\4",
            "\1\7",
            "",
            "",
            "",
            "\1\10",
            "\1\4\5\uffff\1\12\15\4\3\uffff\1\4\1\uffff\1\11",
            "\1\10\51\uffff\1\13\1\14",
            "",
            "\1\15",
            "\1\16",
            "\1\4\5\uffff\1\12\15\4\3\uffff\1\4",
            "\1\4\5\uffff\1\12\15\4\3\uffff\1\4"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "428:3: (this_VariableStatement_0= ruleVariableStatement | this_AssignmentStatement_1= ruleAssignmentStatement | this_ReferenceAssignmentStatement_2= ruleReferenceAssignmentStatement | ( (lv_expression_3_0= ruleExpression ) ) | this_ReturnStatement_4= ruleReturnStatement )";
        }
    }
 

    public static final BitSet FOLLOW_ruleMod_in_entryRuleMod75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMod85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleMod123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMod140 = new BitSet(new long[]{0x000017180364E052L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMod168 = new BitSet(new long[]{0x000017180364E052L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleMod190 = new BitSet(new long[]{0x000017180364C052L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleMod212 = new BitSet(new long[]{0x0000171803648052L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleImport298 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction356 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleFunction403 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction420 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFunction437 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleFunction459 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleFunction472 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleFunction493 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleFunction509 = new BitSet(new long[]{0x0000171803648050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleFunction530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_entryRuleArgument566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgument576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArgument617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleBlock717 = new BitSet(new long[]{0x00001718036C8050L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleBlock738 = new BitSet(new long[]{0x00001718036C8050L});
    public static final BitSet FOLLOW_19_in_ruleBlock751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_ruleStatement846 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_ruleStatement873 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_ruleStatement900 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleStatement926 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_ruleStatement954 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleStatement966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleStatement995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_ruleStatement1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleStatement1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement1084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReturnStatement1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleReturnStatement1140 = new BitSet(new long[]{0x0000171800008052L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReturnStatement1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement1198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleIfStatement1254 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleIfStatement1266 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleIfStatement1287 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleIfStatement1299 = new BitSet(new long[]{0x0000171803648050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement1320 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleIfStatement1333 = new BitSet(new long[]{0x0000171803648050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement1392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleWhileStatement1448 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleWhileStatement1460 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleWhileStatement1481 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleWhileStatement1493 = new BitSet(new long[]{0x0000171803648050L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleWhileStatement1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement1550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableStatement1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVariableStatement1606 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableStatement1623 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleVariableStatement1641 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableStatement1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_entryRuleAssignmentStatement1700 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentStatement1710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentStatement1764 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleAssignmentStatement1776 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssignmentStatement1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_entryRuleReferenceAssignmentStatement1833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAssignmentStatement1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_ruleReferenceAssignmentStatement1898 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleReferenceAssignmentStatement1910 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReferenceAssignmentStatement1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression1967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleExpression2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_entryRuleLogical2057 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogical2067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_ruleLogical2114 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_27_in_ruleLogical2137 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_28_in_ruleLogical2166 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleEquality_in_ruleLogical2189 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_ruleEquality_in_entryRuleEquality2227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquality2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleEquality2284 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_29_in_ruleEquality2307 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_30_in_ruleEquality2336 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleEquality2359 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison2397 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison2407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison2454 = new BitSet(new long[]{0x0000000780000002L});
    public static final BitSet FOLLOW_31_in_ruleComparison2477 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_32_in_ruleComparison2506 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_33_in_ruleComparison2535 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_34_in_ruleComparison2564 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison2587 = new BitSet(new long[]{0x0000000780000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition2625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition2635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition2682 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_35_in_ruleAddition2705 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_36_in_ruleAddition2734 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition2757 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication2795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication2805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiplication2852 = new BitSet(new long[]{0x000000E000000002L});
    public static final BitSet FOLLOW_37_in_ruleMultiplication2875 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_38_in_ruleMultiplication2904 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_39_in_ruleMultiplication2933 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiplication2956 = new BitSet(new long[]{0x000000E000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_entryRuleUnary2994 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnary3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnary3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleUnary3086 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnary3137 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleUnary3160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator3198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUnaryOperator3247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleUnaryOperator3266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression3306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression3363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rulePrimaryExpression3390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_rulePrimaryExpression3417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_rulePrimaryExpression3444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rulePrimaryExpression3471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral3506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_ruleLiteral3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleLiteral3609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleLiteral3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression3678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression3688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleParenthesizedExpression3725 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression3747 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParenthesizedExpression3758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall3794 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionCall3858 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFunctionCall3870 = new BitSet(new long[]{0x0000171800028050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall3892 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleFunctionCall3905 = new BitSet(new long[]{0x0000171800008050L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall3926 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_ruleFunctionCall3942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall3978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarOrArgumentCall3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarOrArgumentCall4042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference4078 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference4088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_ruleReference4135 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleReference4147 = new BitSet(new long[]{0x003F000000000000L});
    public static final BitSet FOLLOW_ruleNativeFunction_in_ruleReference4168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_entryRuleContextRef4206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextRef4216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleContextRef4253 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleNodeRef_in_ruleContextRef4275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_entryRuleNodeRef4310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeRef4320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_ruleNodeRef4366 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleNodeRef4380 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_ruleResourceRef_in_ruleNodeRef4403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_ruleNodeRef4422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef4463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryNodeRef4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rulePrimaryNodeRef4519 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimaryNodeRef4539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_entryRuleResourceRef4575 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceRef4585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleResourceRef4631 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResourceRef4651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_entryRuleLinkRef4687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLinkRef4697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleLinkRef4743 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLinkRef4763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleNativeFunction4813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleNativeFunction4830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleNativeFunction4847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleNativeFunction4864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleNativeFunction4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleNativeFunction4898 = new BitSet(new long[]{0x0000000000000002L});

}