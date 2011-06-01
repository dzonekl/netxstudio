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
import com.netxforge.services.NetxscriptGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalNetxscriptParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NUMBER", "RULE_BOOLEAN", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'mod'", "'import'", "'def'", "'('", "','", "')'", "'{'", "'}'", "';'", "'='", "'&&'", "'||'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'NODE.'", "'.'"
    };
    public static final int RULE_BOOLEAN=7;
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int RULE_NUMBER=6;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=8;
    public static final int RULE_WS=11;

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:67:1: entryRuleMod returns [EObject current=null] : iv_ruleMod= ruleMod EOF ;
    public final EObject entryRuleMod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMod = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:68:2: (iv_ruleMod= ruleMod EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:69:2: iv_ruleMod= ruleMod EOF
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:76:1: ruleMod returns [EObject current=null] : (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_functions_3_0= ruleFunction ) )+ ) ;
    public final EObject ruleMod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_imports_2_0 = null;

        EObject lv_functions_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:79:28: ( (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_functions_3_0= ruleFunction ) )+ ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:80:1: (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_functions_3_0= ruleFunction ) )+ )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:80:1: (otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_functions_3_0= ruleFunction ) )+ )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:80:3: otherlv_0= 'mod' ( (lv_name_1_0= RULE_ID ) ) ( (lv_imports_2_0= ruleImport ) )* ( (lv_functions_3_0= ruleFunction ) )+
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleMod122); 

                	newLeafNode(otherlv_0, grammarAccess.getModAccess().getModKeyword_0());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:85:1: (lv_name_1_0= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMod139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getModAccess().getNameIDTerminalRuleCall_1_0()); 
            		

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

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:102:2: ( (lv_imports_2_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:103:1: (lv_imports_2_0= ruleImport )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:103:1: (lv_imports_2_0= ruleImport )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:104:3: lv_imports_2_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModAccess().getImportsImportParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleMod165);
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
            	    break loop1;
                }
            } while (true);

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:120:3: ( (lv_functions_3_0= ruleFunction ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:121:1: (lv_functions_3_0= ruleFunction )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:121:1: (lv_functions_3_0= ruleFunction )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:122:3: lv_functions_3_0= ruleFunction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModAccess().getFunctionsFunctionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFunction_in_ruleMod187);
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:146:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:147:2: (iv_ruleImport= ruleImport EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:148:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport224);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport234); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:155:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:158:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:159:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:159:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:159:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleImport271); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:163:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:164:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:164:1: (lv_importURI_1_0= RULE_STRING )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:165:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport288); 

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:189:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:190:2: (iv_ruleFunction= ruleFunction EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:191:2: iv_ruleFunction= ruleFunction EOF
            {
             newCompositeNode(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction329);
            iv_ruleFunction=ruleFunction();

            state._fsp--;

             current =iv_ruleFunction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction339); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:198:1: ruleFunction returns [EObject current=null] : (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) ) ;
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
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:201:28: ( (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:202:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:202:1: (otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:202:3: otherlv_0= 'def' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ( (lv_block_7_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleFunction376); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getDefKeyword_0());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:206:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:207:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:207:1: (lv_name_1_0= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:208:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunction393); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleFunction410); 

                	newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:228:1: ( ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:228:2: ( (lv_args_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )*
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:228:2: ( (lv_args_3_0= ruleArgument ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:229:1: (lv_args_3_0= ruleArgument )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:229:1: (lv_args_3_0= ruleArgument )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:230:3: lv_args_3_0= ruleArgument
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArgument_in_ruleFunction432);
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

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:246:2: (otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==17) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:246:4: otherlv_4= ',' ( (lv_args_5_0= ruleArgument ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleFunction445); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:250:1: ( (lv_args_5_0= ruleArgument ) )
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:251:1: (lv_args_5_0= ruleArgument )
                    	    {
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:251:1: (lv_args_5_0= ruleArgument )
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:252:3: lv_args_5_0= ruleArgument
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArgument_in_ruleFunction466);
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
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleFunction482); 

                	newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_4());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:272:1: ( (lv_block_7_0= ruleBlock ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:273:1: (lv_block_7_0= ruleBlock )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:273:1: (lv_block_7_0= ruleBlock )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:274:3: lv_block_7_0= ruleBlock
            {
             
            	        newCompositeNode(grammarAccess.getFunctionAccess().getBlockBlockParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleBlock_in_ruleFunction503);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:298:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:299:2: (iv_ruleArgument= ruleArgument EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:300:2: iv_ruleArgument= ruleArgument EOF
            {
             newCompositeNode(grammarAccess.getArgumentRule()); 
            pushFollow(FOLLOW_ruleArgument_in_entryRuleArgument539);
            iv_ruleArgument=ruleArgument();

            state._fsp--;

             current =iv_ruleArgument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgument549); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:307:1: ruleArgument returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:310:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:311:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:311:1: ( (lv_name_0_0= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:312:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:312:1: (lv_name_0_0= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:313:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArgument590); 

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:341:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:342:2: (iv_ruleBlock= ruleBlock EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:343:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock634);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock644); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:350:1: ruleBlock returns [EObject current=null] : (otherlv_0= '{' () ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:353:28: ( (otherlv_0= '{' () ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:354:1: (otherlv_0= '{' () ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:354:1: (otherlv_0= '{' () ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:354:3: otherlv_0= '{' () ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleBlock681); 

                	newLeafNode(otherlv_0, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:358:1: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:359:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBlockAccess().getBlockAction_1(),
                        current);
                

            }

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:364:2: ( (lv_statements_2_0= ruleStatement ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID||(LA5_0>=RULE_NUMBER && LA5_0<=RULE_BOOLEAN)||LA5_0==16||LA5_0==19||LA5_0==21||(LA5_0>=31 && LA5_0<=32)||(LA5_0>=36 && LA5_0<=37)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:365:1: (lv_statements_2_0= ruleStatement )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:365:1: (lv_statements_2_0= ruleStatement )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:366:3: lv_statements_2_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleBlock711);
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
            	    break loop5;
                }
            } while (true);

            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleBlock724); 

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:394:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:395:2: (iv_ruleStatement= ruleStatement EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:396:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement760);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement770); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:403:1: ruleStatement returns [EObject current=null] : ( ( () otherlv_1= ';' ) | (this_VariableStatement_2= ruleVariableStatement otherlv_3= ';' ) | this_Block_4= ruleBlock ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_VariableStatement_2 = null;

        EObject this_Block_4 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:406:28: ( ( ( () otherlv_1= ';' ) | (this_VariableStatement_2= ruleVariableStatement otherlv_3= ';' ) | this_Block_4= ruleBlock ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:407:1: ( ( () otherlv_1= ';' ) | (this_VariableStatement_2= ruleVariableStatement otherlv_3= ';' ) | this_Block_4= ruleBlock )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:407:1: ( ( () otherlv_1= ';' ) | (this_VariableStatement_2= ruleVariableStatement otherlv_3= ';' ) | this_Block_4= ruleBlock )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt6=1;
                }
                break;
            case RULE_ID:
            case RULE_NUMBER:
            case RULE_BOOLEAN:
            case 16:
            case 31:
            case 32:
            case 36:
            case 37:
                {
                alt6=2;
                }
                break;
            case 19:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:407:2: ( () otherlv_1= ';' )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:407:2: ( () otherlv_1= ';' )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:407:3: () otherlv_1= ';'
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:407:3: ()
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:408:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getStatementAccess().getBlankStatementAction_0_0(),
                                current);
                        

                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleStatement817); 

                        	newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:418:6: (this_VariableStatement_2= ruleVariableStatement otherlv_3= ';' )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:418:6: (this_VariableStatement_2= ruleVariableStatement otherlv_3= ';' )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:419:5: this_VariableStatement_2= ruleVariableStatement otherlv_3= ';'
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getVariableStatementParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleVariableStatement_in_ruleStatement847);
                    this_VariableStatement_2=ruleVariableStatement();

                    state._fsp--;

                     
                            current = this_VariableStatement_2; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_3=(Token)match(input,21,FOLLOW_21_in_ruleStatement858); 

                        	newLeafNode(otherlv_3, grammarAccess.getStatementAccess().getSemicolonKeyword_1_1());
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:433:5: this_Block_4= ruleBlock
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBlock_in_ruleStatement887);
                    this_Block_4=ruleBlock();

                    state._fsp--;

                     
                            current = this_Block_4; 
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


    // $ANTLR start "entryRuleVariableStatement"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:449:1: entryRuleVariableStatement returns [EObject current=null] : iv_ruleVariableStatement= ruleVariableStatement EOF ;
    public final EObject entryRuleVariableStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableStatement = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:450:2: (iv_ruleVariableStatement= ruleVariableStatement EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:451:2: iv_ruleVariableStatement= ruleVariableStatement EOF
            {
             newCompositeNode(grammarAccess.getVariableStatementRule()); 
            pushFollow(FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement922);
            iv_ruleVariableStatement=ruleVariableStatement();

            state._fsp--;

             current =iv_ruleVariableStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableStatement932); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:458:1: ruleVariableStatement returns [EObject current=null] : ( ( (lv_expression_0_0= ruleExpression ) ) | ( () ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) ) ) ;
    public final EObject ruleVariableStatement() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_expression_0_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:461:28: ( ( ( (lv_expression_0_0= ruleExpression ) ) | ( () ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:462:1: ( ( (lv_expression_0_0= ruleExpression ) ) | ( () ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:462:1: ( ( (lv_expression_0_0= ruleExpression ) ) | ( () ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_NUMBER && LA7_0<=RULE_BOOLEAN)||LA7_0==16||(LA7_0>=31 && LA7_0<=32)||(LA7_0>=36 && LA7_0<=37)) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==EOF||LA7_2==16||LA7_2==21||(LA7_2>=23 && LA7_2<=35)) ) {
                    alt7=1;
                }
                else if ( (LA7_2==22) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:462:2: ( (lv_expression_0_0= ruleExpression ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:462:2: ( (lv_expression_0_0= ruleExpression ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:463:1: (lv_expression_0_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:463:1: (lv_expression_0_0= ruleExpression )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:464:3: lv_expression_0_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableStatement978);
                    lv_expression_0_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableStatementRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_0_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:481:6: ( () ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:481:6: ( () ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:481:7: () ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_expression_4_0= ruleExpression ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:481:7: ()
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:482:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getVariableStatementAccess().getVariableAction_1_0(),
                                current);
                        

                    }

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:487:2: ( (lv_name_2_0= RULE_ID ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:488:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:488:1: (lv_name_2_0= RULE_ID )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:489:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVariableStatement1011); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getVariableStatementAccess().getNameIDTerminalRuleCall_1_1_0()); 
                    		

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

                    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleVariableStatement1028); 

                        	newLeafNode(otherlv_3, grammarAccess.getVariableStatementAccess().getEqualsSignKeyword_1_2());
                        
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:509:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:510:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:510:1: (lv_expression_4_0= ruleExpression )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:511:3: lv_expression_4_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleVariableStatement1049);
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
    // $ANTLR end "ruleVariableStatement"


    // $ANTLR start "entryRuleExpression"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:535:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:536:2: (iv_ruleExpression= ruleExpression EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:537:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression1086);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression1096); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:544:1: ruleExpression returns [EObject current=null] : this_Logical_0= ruleLogical ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Logical_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:547:28: (this_Logical_0= ruleLogical )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:549:5: this_Logical_0= ruleLogical
            {
             
                    newCompositeNode(grammarAccess.getExpressionAccess().getLogicalParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleLogical_in_ruleExpression1142);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:565:1: entryRuleLogical returns [EObject current=null] : iv_ruleLogical= ruleLogical EOF ;
    public final EObject entryRuleLogical() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogical = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:566:2: (iv_ruleLogical= ruleLogical EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:567:2: iv_ruleLogical= ruleLogical EOF
            {
             newCompositeNode(grammarAccess.getLogicalRule()); 
            pushFollow(FOLLOW_ruleLogical_in_entryRuleLogical1176);
            iv_ruleLogical=ruleLogical();

            state._fsp--;

             current =iv_ruleLogical; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogical1186); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:574:1: ruleLogical returns [EObject current=null] : (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* ) ;
    public final EObject ruleLogical() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Equality_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:577:28: ( (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:578:1: (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:578:1: (this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )* )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:579:5: this_Equality_0= ruleEquality ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getLogicalAccess().getEqualityParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleEquality_in_ruleLogical1233);
            this_Equality_0=ruleEquality();

            state._fsp--;

             
                    current = this_Equality_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:587:1: ( ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=23 && LA9_0<=24)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:587:2: ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) ) ( (lv_right_5_0= ruleEquality ) )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:587:2: ( ( () otherlv_2= '&&' ) | ( () otherlv_4= '||' ) )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==23) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==24) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:587:3: ( () otherlv_2= '&&' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:587:3: ( () otherlv_2= '&&' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:587:4: () otherlv_2= '&&'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:587:4: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:588:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleLogical1256); 

            	                	newLeafNode(otherlv_2, grammarAccess.getLogicalAccess().getAmpersandAmpersandKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:598:6: ( () otherlv_4= '||' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:598:6: ( () otherlv_4= '||' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:598:7: () otherlv_4= '||'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:598:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:599:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleLogical1285); 

            	                	newLeafNode(otherlv_4, grammarAccess.getLogicalAccess().getVerticalLineVerticalLineKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:608:3: ( (lv_right_5_0= ruleEquality ) )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:609:1: (lv_right_5_0= ruleEquality )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:609:1: (lv_right_5_0= ruleEquality )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:610:3: lv_right_5_0= ruleEquality
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLogicalAccess().getRightEqualityParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEquality_in_ruleLogical1308);
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
            	    break loop9;
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:634:1: entryRuleEquality returns [EObject current=null] : iv_ruleEquality= ruleEquality EOF ;
    public final EObject entryRuleEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquality = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:635:2: (iv_ruleEquality= ruleEquality EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:636:2: iv_ruleEquality= ruleEquality EOF
            {
             newCompositeNode(grammarAccess.getEqualityRule()); 
            pushFollow(FOLLOW_ruleEquality_in_entryRuleEquality1346);
            iv_ruleEquality=ruleEquality();

            state._fsp--;

             current =iv_ruleEquality; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquality1356); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:643:1: ruleEquality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEquality() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:646:28: ( (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:647:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:647:1: (this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )* )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:648:5: this_Comparison_0= ruleComparison ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleComparison_in_ruleEquality1403);
            this_Comparison_0=ruleComparison();

            state._fsp--;

             
                    current = this_Comparison_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:656:1: ( ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=25 && LA11_0<=26)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:656:2: ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) ) ( (lv_right_5_0= ruleComparison ) )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:656:2: ( ( () otherlv_2= '==' ) | ( () otherlv_4= '!=' ) )
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==25) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==26) ) {
            	        alt10=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:656:3: ( () otherlv_2= '==' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:656:3: ( () otherlv_2= '==' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:656:4: () otherlv_2= '=='
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:656:4: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:657:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleEquality1426); 

            	                	newLeafNode(otherlv_2, grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:667:6: ( () otherlv_4= '!=' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:667:6: ( () otherlv_4= '!=' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:667:7: () otherlv_4= '!='
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:667:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:668:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleEquality1455); 

            	                	newLeafNode(otherlv_4, grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:677:3: ( (lv_right_5_0= ruleComparison ) )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:678:1: (lv_right_5_0= ruleComparison )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:678:1: (lv_right_5_0= ruleComparison )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:679:3: lv_right_5_0= ruleComparison
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComparison_in_ruleEquality1478);
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
            	    break loop11;
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:703:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:704:2: (iv_ruleComparison= ruleComparison EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:705:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison1516);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison1526); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:712:1: ruleComparison returns [EObject current=null] : (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* ) ;
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
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:715:28: ( (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:716:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:716:1: (this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )* )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:717:5: this_Addition_0= ruleAddition ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAddition_in_ruleComparison1573);
            this_Addition_0=ruleAddition();

            state._fsp--;

             
                    current = this_Addition_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:725:1: ( ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=27 && LA13_0<=30)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:725:2: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) ) ( (lv_right_9_0= ruleAddition ) )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:725:2: ( ( () otherlv_2= '<' ) | ( () otherlv_4= '<=' ) | ( () otherlv_6= '>' ) | ( () otherlv_8= '>=' ) )
            	    int alt12=4;
            	    switch ( input.LA(1) ) {
            	    case 27:
            	        {
            	        alt12=1;
            	        }
            	        break;
            	    case 28:
            	        {
            	        alt12=2;
            	        }
            	        break;
            	    case 29:
            	        {
            	        alt12=3;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt12=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt12) {
            	        case 1 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:725:3: ( () otherlv_2= '<' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:725:3: ( () otherlv_2= '<' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:725:4: () otherlv_2= '<'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:725:4: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:726:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleComparison1596); 

            	                	newLeafNode(otherlv_2, grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:736:6: ( () otherlv_4= '<=' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:736:6: ( () otherlv_4= '<=' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:736:7: () otherlv_4= '<='
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:736:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:737:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleComparison1625); 

            	                	newLeafNode(otherlv_4, grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:747:6: ( () otherlv_6= '>' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:747:6: ( () otherlv_6= '>' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:747:7: () otherlv_6= '>'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:747:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:748:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0(),
            	                        current);
            	                

            	            }

            	            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleComparison1654); 

            	                	newLeafNode(otherlv_6, grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1());
            	                

            	            }


            	            }
            	            break;
            	        case 4 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:758:6: ( () otherlv_8= '>=' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:758:6: ( () otherlv_8= '>=' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:758:7: () otherlv_8= '>='
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:758:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:759:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0(),
            	                        current);
            	                

            	            }

            	            otherlv_8=(Token)match(input,30,FOLLOW_30_in_ruleComparison1683); 

            	                	newLeafNode(otherlv_8, grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_3_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:768:3: ( (lv_right_9_0= ruleAddition ) )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:769:1: (lv_right_9_0= ruleAddition )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:769:1: (lv_right_9_0= ruleAddition )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:770:3: lv_right_9_0= ruleAddition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAddition_in_ruleComparison1706);
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
            	    break loop13;
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:794:1: entryRuleAddition returns [EObject current=null] : iv_ruleAddition= ruleAddition EOF ;
    public final EObject entryRuleAddition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddition = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:795:2: (iv_ruleAddition= ruleAddition EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:796:2: iv_ruleAddition= ruleAddition EOF
            {
             newCompositeNode(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition1744);
            iv_ruleAddition=ruleAddition();

            state._fsp--;

             current =iv_ruleAddition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition1754); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:803:1: ruleAddition returns [EObject current=null] : (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) ;
    public final EObject ruleAddition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Multiplication_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:806:28: ( (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:807:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:807:1: (this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )* )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:808:5: this_Multiplication_0= ruleMultiplication ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition1801);
            this_Multiplication_0=ruleMultiplication();

            state._fsp--;

             
                    current = this_Multiplication_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:816:1: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=31 && LA15_0<=32)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:816:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMultiplication ) )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:816:2: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==31) ) {
            	        alt14=1;
            	    }
            	    else if ( (LA14_0==32) ) {
            	        alt14=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:816:3: ( () otherlv_2= '+' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:816:3: ( () otherlv_2= '+' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:816:4: () otherlv_2= '+'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:816:4: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:817:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleAddition1824); 

            	                	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:827:6: ( () otherlv_4= '-' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:827:6: ( () otherlv_4= '-' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:827:7: () otherlv_4= '-'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:827:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:828:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleAddition1853); 

            	                	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:837:3: ( (lv_right_5_0= ruleMultiplication ) )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:838:1: (lv_right_5_0= ruleMultiplication )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:838:1: (lv_right_5_0= ruleMultiplication )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:839:3: lv_right_5_0= ruleMultiplication
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiplication_in_ruleAddition1876);
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
            	    break loop15;
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:863:1: entryRuleMultiplication returns [EObject current=null] : iv_ruleMultiplication= ruleMultiplication EOF ;
    public final EObject entryRuleMultiplication() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplication = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:864:2: (iv_ruleMultiplication= ruleMultiplication EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:865:2: iv_ruleMultiplication= ruleMultiplication EOF
            {
             newCompositeNode(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication1914);
            iv_ruleMultiplication=ruleMultiplication();

            state._fsp--;

             current =iv_ruleMultiplication; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication1924); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:872:1: ruleMultiplication returns [EObject current=null] : (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) ;
    public final EObject ruleMultiplication() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_Unary_0 = null;

        EObject lv_right_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:875:28: ( (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:876:1: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:876:1: (this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )* )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:877:5: this_Unary_0= ruleUnary ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleUnary_in_ruleMultiplication1971);
            this_Unary_0=ruleUnary();

            state._fsp--;

             
                    current = this_Unary_0; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:1: ( ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=33 && LA17_0<=35)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) ) ( (lv_right_7_0= ruleUnary ) )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:2: ( ( () otherlv_2= '*' ) | ( () otherlv_4= '/' ) | ( () otherlv_6= '%' ) )
            	    int alt16=3;
            	    switch ( input.LA(1) ) {
            	    case 33:
            	        {
            	        alt16=1;
            	        }
            	        break;
            	    case 34:
            	        {
            	        alt16=2;
            	        }
            	        break;
            	    case 35:
            	        {
            	        alt16=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt16) {
            	        case 1 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:3: ( () otherlv_2= '*' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:3: ( () otherlv_2= '*' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:4: () otherlv_2= '*'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:885:4: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:886:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(),
            	                        current);
            	                

            	            }

            	            otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleMultiplication1994); 

            	                	newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
            	                

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:896:6: ( () otherlv_4= '/' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:896:6: ( () otherlv_4= '/' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:896:7: () otherlv_4= '/'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:896:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:897:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(),
            	                        current);
            	                

            	            }

            	            otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleMultiplication2023); 

            	                	newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
            	                

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:907:6: ( () otherlv_6= '%' )
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:907:6: ( () otherlv_6= '%' )
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:907:7: () otherlv_6= '%'
            	            {
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:907:7: ()
            	            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:908:5: 
            	            {

            	                    current = forceCreateModelElementAndSet(
            	                        grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0(),
            	                        current);
            	                

            	            }

            	            otherlv_6=(Token)match(input,35,FOLLOW_35_in_ruleMultiplication2052); 

            	                	newLeafNode(otherlv_6, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1());
            	                

            	            }


            	            }
            	            break;

            	    }

            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:917:3: ( (lv_right_7_0= ruleUnary ) )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:918:1: (lv_right_7_0= ruleUnary )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:918:1: (lv_right_7_0= ruleUnary )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:919:3: lv_right_7_0= ruleUnary
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUnary_in_ruleMultiplication2075);
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
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleUnary"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:943:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:944:2: (iv_ruleUnary= ruleUnary EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:945:2: iv_ruleUnary= ruleUnary EOF
            {
             newCompositeNode(grammarAccess.getUnaryRule()); 
            pushFollow(FOLLOW_ruleUnary_in_entryRuleUnary2113);
            iv_ruleUnary=ruleUnary();

            state._fsp--;

             current =iv_ruleUnary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnary2123); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:952:1: ruleUnary returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_PrimaryExpression_0 = null;

        AntlrDatatypeRuleToken lv_op_4_0 = null;

        EObject lv_right_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:955:28: ( (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:956:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:956:1: (this_PrimaryExpression_0= rulePrimaryExpression | ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID||(LA19_0>=RULE_NUMBER && LA19_0<=RULE_BOOLEAN)||LA19_0==16||LA19_0==37) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=31 && LA19_0<=32)||LA19_0==36) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:957:5: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                     
                            newCompositeNode(grammarAccess.getUnaryAccess().getPrimaryExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleUnary2170);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:6: ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:6: ( ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:7: ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) ) ( (lv_right_5_0= ruleUnary ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:7: ( ( () ( (lv_op_2_0= '!' ) ) ) | ( () ( (lv_op_4_0= ruleUnaryOperator ) ) ) )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==36) ) {
                        alt18=1;
                    }
                    else if ( ((LA18_0>=31 && LA18_0<=32)) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:8: ( () ( (lv_op_2_0= '!' ) ) )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:8: ( () ( (lv_op_2_0= '!' ) ) )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:9: () ( (lv_op_2_0= '!' ) )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:966:9: ()
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:967:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getUnaryAccess().getNegationAction_1_0_0_0(),
                                        current);
                                

                            }

                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:972:2: ( (lv_op_2_0= '!' ) )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:973:1: (lv_op_2_0= '!' )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:973:1: (lv_op_2_0= '!' )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:974:3: lv_op_2_0= '!'
                            {
                            lv_op_2_0=(Token)match(input,36,FOLLOW_36_in_ruleUnary2205); 

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
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:988:6: ( () ( (lv_op_4_0= ruleUnaryOperator ) ) )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:988:6: ( () ( (lv_op_4_0= ruleUnaryOperator ) ) )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:988:7: () ( (lv_op_4_0= ruleUnaryOperator ) )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:988:7: ()
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:989:5: 
                            {

                                    current = forceCreateModelElement(
                                        grammarAccess.getUnaryAccess().getUnaryPlusMinusAction_1_0_1_0(),
                                        current);
                                

                            }

                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:994:2: ( (lv_op_4_0= ruleUnaryOperator ) )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:995:1: (lv_op_4_0= ruleUnaryOperator )
                            {
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:995:1: (lv_op_4_0= ruleUnaryOperator )
                            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:996:3: lv_op_4_0= ruleUnaryOperator
                            {
                             
                            	        newCompositeNode(grammarAccess.getUnaryAccess().getOpUnaryOperatorParserRuleCall_1_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnary2256);
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

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1012:4: ( (lv_right_5_0= ruleUnary ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1013:1: (lv_right_5_0= ruleUnary )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1013:1: (lv_right_5_0= ruleUnary )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1014:3: lv_right_5_0= ruleUnary
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryAccess().getRightUnaryParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnary_in_ruleUnary2279);
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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1038:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1039:2: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1040:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
             newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator2317);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;

             current =iv_ruleUnaryOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator2328); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1047:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1050:28: ( (kw= '-' | kw= '+' ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1051:1: (kw= '-' | kw= '+' )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1051:1: (kw= '-' | kw= '+' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==32) ) {
                alt20=1;
            }
            else if ( (LA20_0==31) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1052:2: kw= '-'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleUnaryOperator2366); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1059:2: kw= '+'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleUnaryOperator2385); 

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1072:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1073:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1074:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2425);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression2435); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1081:1: rulePrimaryExpression returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (lv_condition_6_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_node_8_0= ruleNodeDepth ) ) ) | this_FunctionCall_9= ruleFunctionCall | this_VarOrArgumentCall_10= ruleVarOrArgumentCall ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_value_4_0=null;
        Token lv_condition_6_0=null;
        EObject this_Expression_1 = null;

        EObject lv_node_8_0 = null;

        EObject this_FunctionCall_9 = null;

        EObject this_VarOrArgumentCall_10 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1084:28: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (lv_condition_6_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_node_8_0= ruleNodeDepth ) ) ) | this_FunctionCall_9= ruleFunctionCall | this_VarOrArgumentCall_10= ruleVarOrArgumentCall ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1085:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (lv_condition_6_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_node_8_0= ruleNodeDepth ) ) ) | this_FunctionCall_9= ruleFunctionCall | this_VarOrArgumentCall_10= ruleVarOrArgumentCall )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1085:1: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () ( (lv_value_4_0= RULE_NUMBER ) ) ) | ( () ( (lv_condition_6_0= RULE_BOOLEAN ) ) ) | ( () ( (lv_node_8_0= ruleNodeDepth ) ) ) | this_FunctionCall_9= ruleFunctionCall | this_VarOrArgumentCall_10= ruleVarOrArgumentCall )
            int alt21=6;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt21=1;
                }
                break;
            case RULE_NUMBER:
                {
                alt21=2;
                }
                break;
            case RULE_BOOLEAN:
                {
                alt21=3;
                }
                break;
            case 37:
                {
                alt21=4;
                }
                break;
            case RULE_ID:
                {
                int LA21_5 = input.LA(2);

                if ( (LA21_5==16) ) {
                    alt21=5;
                }
                else if ( (LA21_5==EOF||(LA21_5>=17 && LA21_5<=18)||LA21_5==21||(LA21_5>=23 && LA21_5<=35)) ) {
                    alt21=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1085:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1085:2: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1085:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,16,FOLLOW_16_in_rulePrimaryExpression2473); 

                        	newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleExpression_in_rulePrimaryExpression2495);
                    this_Expression_1=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_1; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_rulePrimaryExpression2506); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1103:6: ( () ( (lv_value_4_0= RULE_NUMBER ) ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1103:6: ( () ( (lv_value_4_0= RULE_NUMBER ) ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1103:7: () ( (lv_value_4_0= RULE_NUMBER ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1103:7: ()
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1104:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0(),
                                current);
                        

                    }

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1109:2: ( (lv_value_4_0= RULE_NUMBER ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1110:1: (lv_value_4_0= RULE_NUMBER )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1110:1: (lv_value_4_0= RULE_NUMBER )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1111:3: lv_value_4_0= RULE_NUMBER
                    {
                    lv_value_4_0=(Token)match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rulePrimaryExpression2540); 

                    			newLeafNode(lv_value_4_0, grammarAccess.getPrimaryExpressionAccess().getValueNUMBERTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_4_0, 
                            		"NUMBER");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1128:6: ( () ( (lv_condition_6_0= RULE_BOOLEAN ) ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1128:6: ( () ( (lv_condition_6_0= RULE_BOOLEAN ) ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1128:7: () ( (lv_condition_6_0= RULE_BOOLEAN ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1128:7: ()
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1129:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimaryExpressionAccess().getBooleanLiteralAction_2_0(),
                                current);
                        

                    }

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1134:2: ( (lv_condition_6_0= RULE_BOOLEAN ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1135:1: (lv_condition_6_0= RULE_BOOLEAN )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1135:1: (lv_condition_6_0= RULE_BOOLEAN )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1136:3: lv_condition_6_0= RULE_BOOLEAN
                    {
                    lv_condition_6_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_RULE_BOOLEAN_in_rulePrimaryExpression2579); 

                    			newLeafNode(lv_condition_6_0, grammarAccess.getPrimaryExpressionAccess().getConditionBOOLEANTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"condition",
                            		true, 
                            		"BOOLEAN");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1153:6: ( () ( (lv_node_8_0= ruleNodeDepth ) ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1153:6: ( () ( (lv_node_8_0= ruleNodeDepth ) ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1153:7: () ( (lv_node_8_0= ruleNodeDepth ) )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1153:7: ()
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1154:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrimaryExpressionAccess().getModelReferenceAction_3_0(),
                                current);
                        

                    }

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1159:2: ( (lv_node_8_0= ruleNodeDepth ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1160:1: (lv_node_8_0= ruleNodeDepth )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1160:1: (lv_node_8_0= ruleNodeDepth )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1161:3: lv_node_8_0= ruleNodeDepth
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNodeNodeDepthParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNodeDepth_in_rulePrimaryExpression2622);
                    lv_node_8_0=ruleNodeDepth();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"node",
                            		lv_node_8_0, 
                            		"NodeDepth");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1179:5: this_FunctionCall_9= ruleFunctionCall
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleFunctionCall_in_rulePrimaryExpression2651);
                    this_FunctionCall_9=ruleFunctionCall();

                    state._fsp--;

                     
                            current = this_FunctionCall_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1189:5: this_VarOrArgumentCall_10= ruleVarOrArgumentCall
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getVarOrArgumentCallParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleVarOrArgumentCall_in_rulePrimaryExpression2678);
                    this_VarOrArgumentCall_10=ruleVarOrArgumentCall();

                    state._fsp--;

                     
                            current = this_VarOrArgumentCall_10; 
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


    // $ANTLR start "entryRuleFunctionCall"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1205:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1206:2: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1207:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall2713);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionCall2723); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1214:1: ruleFunctionCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
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
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1217:28: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1218:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1218:1: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1218:2: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '(' ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1218:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1219:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFunctionCallAccess().getFunctionCallAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1224:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1225:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1225:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1226:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionCall2777); 

            		newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleFunctionCall2789); 

                	newLeafNode(otherlv_2, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1241:1: ( ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID||(LA23_0>=RULE_NUMBER && LA23_0<=RULE_BOOLEAN)||LA23_0==16||(LA23_0>=31 && LA23_0<=32)||(LA23_0>=36 && LA23_0<=37)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1241:2: ( (lv_args_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1241:2: ( (lv_args_3_0= ruleExpression ) )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1242:1: (lv_args_3_0= ruleExpression )
                    {
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1242:1: (lv_args_3_0= ruleExpression )
                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1243:3: lv_args_3_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionCall2811);
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

                    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1259:2: (otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==17) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1259:4: otherlv_4= ',' ( (lv_args_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleFunctionCall2824); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1263:1: ( (lv_args_5_0= ruleExpression ) )
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1264:1: (lv_args_5_0= ruleExpression )
                    	    {
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1264:1: (lv_args_5_0= ruleExpression )
                    	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1265:3: lv_args_5_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionCall2845);
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
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleFunctionCall2861); 

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1293:1: entryRuleVarOrArgumentCall returns [EObject current=null] : iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF ;
    public final EObject entryRuleVarOrArgumentCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarOrArgumentCall = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1294:2: (iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1295:2: iv_ruleVarOrArgumentCall= ruleVarOrArgumentCall EOF
            {
             newCompositeNode(grammarAccess.getVarOrArgumentCallRule()); 
            pushFollow(FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall2897);
            iv_ruleVarOrArgumentCall=ruleVarOrArgumentCall();

            state._fsp--;

             current =iv_ruleVarOrArgumentCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarOrArgumentCall2907); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1302:1: ruleVarOrArgumentCall returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleVarOrArgumentCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1305:28: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1306:1: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1306:1: ( () ( (otherlv_1= RULE_ID ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1306:2: () ( (otherlv_1= RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1306:2: ()
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1307:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getVarOrArgumentCallAccess().getVarOrArgumentCallAction_0(),
                        current);
                

            }

            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1312:2: ( (otherlv_1= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1313:1: (otherlv_1= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1313:1: (otherlv_1= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1314:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVarOrArgumentCallRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarOrArgumentCall2961); 

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


    // $ANTLR start "entryRuleNodeDepth"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1333:1: entryRuleNodeDepth returns [EObject current=null] : iv_ruleNodeDepth= ruleNodeDepth EOF ;
    public final EObject entryRuleNodeDepth() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeDepth = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1334:2: (iv_ruleNodeDepth= ruleNodeDepth EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1335:2: iv_ruleNodeDepth= ruleNodeDepth EOF
            {
             newCompositeNode(grammarAccess.getNodeDepthRule()); 
            pushFollow(FOLLOW_ruleNodeDepth_in_entryRuleNodeDepth2997);
            iv_ruleNodeDepth=ruleNodeDepth();

            state._fsp--;

             current =iv_ruleNodeDepth; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeDepth3007); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNodeDepth"


    // $ANTLR start "ruleNodeDepth"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1342:1: ruleNodeDepth returns [EObject current=null] : (otherlv_0= 'NODE.' this_PrimaryNodeRef_1= rulePrimaryNodeRef (otherlv_2= '.' ( (lv_depth_3_0= rulePrimaryNodeRef ) ) )* otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) ) ;
    public final EObject ruleNodeDepth() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject this_PrimaryNodeRef_1 = null;

        EObject lv_depth_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1345:28: ( (otherlv_0= 'NODE.' this_PrimaryNodeRef_1= rulePrimaryNodeRef (otherlv_2= '.' ( (lv_depth_3_0= rulePrimaryNodeRef ) ) )* otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1346:1: (otherlv_0= 'NODE.' this_PrimaryNodeRef_1= rulePrimaryNodeRef (otherlv_2= '.' ( (lv_depth_3_0= rulePrimaryNodeRef ) ) )* otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1346:1: (otherlv_0= 'NODE.' this_PrimaryNodeRef_1= rulePrimaryNodeRef (otherlv_2= '.' ( (lv_depth_3_0= rulePrimaryNodeRef ) ) )* otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1346:3: otherlv_0= 'NODE.' this_PrimaryNodeRef_1= rulePrimaryNodeRef (otherlv_2= '.' ( (lv_depth_3_0= rulePrimaryNodeRef ) ) )* otherlv_4= '.' ( (otherlv_5= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleNodeDepth3044); 

                	newLeafNode(otherlv_0, grammarAccess.getNodeDepthAccess().getNODEKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getNodeDepthAccess().getPrimaryNodeRefParserRuleCall_1()); 
                
            pushFollow(FOLLOW_rulePrimaryNodeRef_in_ruleNodeDepth3066);
            this_PrimaryNodeRef_1=rulePrimaryNodeRef();

            state._fsp--;

             
                    current = this_PrimaryNodeRef_1; 
                    afterParserOrEnumRuleCall();
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1359:1: (otherlv_2= '.' ( (lv_depth_3_0= rulePrimaryNodeRef ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==38) ) {
                    int LA24_1 = input.LA(2);

                    if ( (LA24_1==RULE_ID) ) {
                        int LA24_2 = input.LA(3);

                        if ( (LA24_2==38) ) {
                            alt24=1;
                        }


                    }


                }


                switch (alt24) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1359:3: otherlv_2= '.' ( (lv_depth_3_0= rulePrimaryNodeRef ) )
            	    {
            	    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleNodeDepth3078); 

            	        	newLeafNode(otherlv_2, grammarAccess.getNodeDepthAccess().getFullStopKeyword_2_0());
            	        
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1363:1: ( (lv_depth_3_0= rulePrimaryNodeRef ) )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1364:1: (lv_depth_3_0= rulePrimaryNodeRef )
            	    {
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1364:1: (lv_depth_3_0= rulePrimaryNodeRef )
            	    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1365:3: lv_depth_3_0= rulePrimaryNodeRef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeDepthAccess().getDepthPrimaryNodeRefParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePrimaryNodeRef_in_ruleNodeDepth3099);
            	    lv_depth_3_0=rulePrimaryNodeRef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeDepthRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"depth",
            	            		lv_depth_3_0, 
            	            		"PrimaryNodeRef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_4=(Token)match(input,38,FOLLOW_38_in_ruleNodeDepth3113); 

                	newLeafNode(otherlv_4, grammarAccess.getNodeDepthAccess().getFullStopKeyword_3());
                
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1385:1: ( (otherlv_5= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1386:1: (otherlv_5= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1386:1: (otherlv_5= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1387:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNodeDepthRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNodeDepth3133); 

            		newLeafNode(otherlv_5, grammarAccess.getNodeDepthAccess().getResRefResourceCrossReference_4_0()); 
            	

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
    // $ANTLR end "ruleNodeDepth"


    // $ANTLR start "entryRulePrimaryNodeRef"
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1406:1: entryRulePrimaryNodeRef returns [EObject current=null] : iv_rulePrimaryNodeRef= rulePrimaryNodeRef EOF ;
    public final EObject entryRulePrimaryNodeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryNodeRef = null;


        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1407:2: (iv_rulePrimaryNodeRef= rulePrimaryNodeRef EOF )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1408:2: iv_rulePrimaryNodeRef= rulePrimaryNodeRef EOF
            {
             newCompositeNode(grammarAccess.getPrimaryNodeRefRule()); 
            pushFollow(FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef3169);
            iv_rulePrimaryNodeRef=rulePrimaryNodeRef();

            state._fsp--;

             current =iv_rulePrimaryNodeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryNodeRef3179); 

            }

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
    // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1415:1: rulePrimaryNodeRef returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject rulePrimaryNodeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1418:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1419:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1419:1: ( (otherlv_0= RULE_ID ) )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1420:1: (otherlv_0= RULE_ID )
            {
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1420:1: (otherlv_0= RULE_ID )
            // ../com.netxforge.netxscript.a/src-gen/com/netxforge/parser/antlr/internal/InternalNetxscript.g:1421:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPrimaryNodeRefRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePrimaryNodeRef3223); 

            		newLeafNode(otherlv_0, grammarAccess.getPrimaryNodeRefAccess().getNodeRefNodeCrossReference_0()); 
            	

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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleMod_in_entryRuleMod75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMod85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleMod122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMod139 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMod165 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleMod187 = new BitSet(new long[]{0x000000000000C002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleImport271 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleFunction376 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunction393 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFunction410 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleFunction432 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFunction445 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleArgument_in_ruleFunction466 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleFunction482 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleFunction503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_entryRuleArgument539 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgument549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArgument590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock634 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleBlock681 = new BitSet(new long[]{0x00000031803900D0L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleBlock711 = new BitSet(new long[]{0x00000031803900D0L});
    public static final BitSet FOLLOW_20_in_ruleBlock724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleStatement817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_ruleStatement847 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleStatement858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleStatement887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableStatement932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableStatement978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVariableStatement1011 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleVariableStatement1028 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleVariableStatement1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression1086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleExpression1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_entryRuleLogical1176 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogical1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_ruleLogical1233 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_23_in_ruleLogical1256 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_24_in_ruleLogical1285 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_ruleEquality_in_ruleLogical1308 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_ruleEquality_in_entryRuleEquality1346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquality1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleEquality1403 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_25_in_ruleEquality1426 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_26_in_ruleEquality1455 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_ruleComparison_in_ruleEquality1478 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison1516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison1526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison1573 = new BitSet(new long[]{0x0000000078000002L});
    public static final BitSet FOLLOW_27_in_ruleComparison1596 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_28_in_ruleComparison1625 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_29_in_ruleComparison1654 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_30_in_ruleComparison1683 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_ruleAddition_in_ruleComparison1706 = new BitSet(new long[]{0x0000000078000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition1744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition1801 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_31_in_ruleAddition1824 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_32_in_ruleAddition1853 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_ruleMultiplication_in_ruleAddition1876 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication1914 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication1924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiplication1971 = new BitSet(new long[]{0x0000000E00000002L});
    public static final BitSet FOLLOW_33_in_ruleMultiplication1994 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_34_in_ruleMultiplication2023 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_35_in_ruleMultiplication2052 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiplication2075 = new BitSet(new long[]{0x0000000E00000002L});
    public static final BitSet FOLLOW_ruleUnary_in_entryRuleUnary2113 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnary2123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleUnary2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleUnary2205 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnary2256 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleUnary2279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator2317 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleUnaryOperator2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleUnaryOperator2385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression2425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression2435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rulePrimaryExpression2473 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePrimaryExpression2495 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulePrimaryExpression2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rulePrimaryExpression2540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_in_rulePrimaryExpression2579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeDepth_in_rulePrimaryExpression2622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_rulePrimaryExpression2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_rulePrimaryExpression2678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall2713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall2723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionCall2777 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFunctionCall2789 = new BitSet(new long[]{0x00000031800500D0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall2811 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFunctionCall2824 = new BitSet(new long[]{0x00000031800100D0L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionCall2845 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleFunctionCall2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall2897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarOrArgumentCall2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarOrArgumentCall2961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeDepth_in_entryRuleNodeDepth2997 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeDepth3007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleNodeDepth3044 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_ruleNodeDepth3066 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleNodeDepth3078 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_ruleNodeDepth3099 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleNodeDepth3113 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNodeDepth3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef3169 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryNodeRef3179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePrimaryNodeRef3223 = new BitSet(new long[]{0x0000000000000002L});

}