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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_MODULE_ID", "RULE_CRNL", "RULE_ASN1_ID", "RULE_INT", "RULE_PARAMETER", "RULE_IA5STRING", "RULE_ALPHA_CAP", "RULE_ALPHA", "RULE_NUMERIC", "RULE_SL_ASN1_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'DEFINITIONS'", "'::='", "'BEGIN'", "'END'", "'OBJECT IDENTIFIER'", "'{'", "'}'", "'MACRO'", "'TYPE NOTATION'", "'VALUE NOTATION'", "'|'", "'value'", "'('", "')'", "'Update'", "'VALUE OBJECT IDENTIFIER'", "'IA5String'", "'empty'", "'OCTET STRING'", "'INTEGER'", "'SIZE'", "'..'", "'CHOICE'", "','"
    };
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
    public static final int RULE_CRNL=5;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:76:1: ruleModule returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_CRNL_4= RULE_CRNL ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+ ) | ( () (this_CRNL_9= RULE_CRNL )* otherlv_10= 'END' ) ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_CRNL_4=null;
        Token this_CRNL_9=null;
        Token otherlv_10=null;
        EObject lv_identifiers_5_0 = null;

        EObject lv_types_6_0 = null;

        EObject lv_macros_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:79:28: ( ( ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_CRNL_4= RULE_CRNL ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+ ) | ( () (this_CRNL_9= RULE_CRNL )* otherlv_10= 'END' ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:1: ( ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_CRNL_4= RULE_CRNL ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+ ) | ( () (this_CRNL_9= RULE_CRNL )* otherlv_10= 'END' ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:1: ( ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_CRNL_4= RULE_CRNL ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+ ) | ( () (this_CRNL_9= RULE_CRNL )* otherlv_10= 'END' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_MODULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_CRNL||LA3_0==19) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:2: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_CRNL_4= RULE_CRNL ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+ )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:2: ( ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_CRNL_4= RULE_CRNL ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+ )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:3: ( (lv_name_0_0= RULE_MODULE_ID ) ) otherlv_1= 'DEFINITIONS' otherlv_2= '::=' otherlv_3= 'BEGIN' this_CRNL_4= RULE_CRNL ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:80:3: ( (lv_name_0_0= RULE_MODULE_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:81:1: (lv_name_0_0= RULE_MODULE_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:81:1: (lv_name_0_0= RULE_MODULE_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:82:3: lv_name_0_0= RULE_MODULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleModule128); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_0, grammarAccess.getModuleAccess().getNameMODULE_IDTerminalRuleCall_0_0_0()); 
                      		
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

                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleModule145); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getModuleAccess().getDEFINITIONSKeyword_0_1());
                          
                    }
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleModule157); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_0_2());
                          
                    }
                    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleModule169); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getBEGINKeyword_0_3());
                          
                    }
                    this_CRNL_4=(Token)match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_ruleModule180); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_CRNL_4, grammarAccess.getModuleAccess().getCRNLTerminalRuleCall_0_4()); 
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:114:1: ( ( (lv_identifiers_5_0= ruleObjectIdentifier ) ) | ( (lv_types_6_0= ruleTypeDefinition ) ) | ( (lv_macros_7_0= ruleMacro ) ) )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=4;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_CRNL) ) {
                            int LA1_2 = input.LA(2);

                            if ( (LA1_2==RULE_MODULE_ID) ) {
                                int LA1_3 = input.LA(3);

                                if ( (LA1_3==17) ) {
                                    alt1=2;
                                }
                                else if ( (LA1_3==23) ) {
                                    alt1=3;
                                }


                            }
                            else if ( (LA1_2==RULE_ASN1_ID) ) {
                                alt1=1;
                            }


                        }


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
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleAccess().getIdentifiersObjectIdentifierParserRuleCall_0_5_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleObjectIdentifier_in_ruleModule201);
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleAccess().getTypesTypeDefinitionParserRuleCall_0_5_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleModule228);
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleAccess().getMacrosMacroParserRuleCall_0_5_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleMacro_in_ruleModule255);
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


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:171:6: ( () (this_CRNL_9= RULE_CRNL )* otherlv_10= 'END' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:171:6: ( () (this_CRNL_9= RULE_CRNL )* otherlv_10= 'END' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:171:7: () (this_CRNL_9= RULE_CRNL )* otherlv_10= 'END'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:171:7: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:172:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getModuleAccess().getModuleAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:177:2: (this_CRNL_9= RULE_CRNL )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_CRNL) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:177:3: this_CRNL_9= RULE_CRNL
                    	    {
                    	    this_CRNL_9=(Token)match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_ruleModule286); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_CRNL_9, grammarAccess.getModuleAccess().getCRNLTerminalRuleCall_1_1()); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,19,FOLLOW_19_in_ruleModule299); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getModuleAccess().getENDKeyword_1_2());
                          
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
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleObjectIdentifier"
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:193:1: entryRuleObjectIdentifier returns [EObject current=null] : iv_ruleObjectIdentifier= ruleObjectIdentifier EOF ;
    public final EObject entryRuleObjectIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectIdentifier = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_ASN1_COMMENT");
        	
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:197:2: (iv_ruleObjectIdentifier= ruleObjectIdentifier EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:198:2: iv_ruleObjectIdentifier= ruleObjectIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier342);
            iv_ruleObjectIdentifier=ruleObjectIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectIdentifier; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifier352); if (state.failed) return current;

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:208:1: ruleObjectIdentifier returns [EObject current=null] : (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' ) ;
    public final EObject ruleObjectIdentifier() throws RecognitionException {
        EObject current = null;

        Token this_CRNL_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_oidValue_5_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_ASN1_COMMENT");
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:212:28: ( (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:213:1: (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:213:1: (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:213:2: this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_ASN1_ID ) ) otherlv_2= 'OBJECT IDENTIFIER' otherlv_3= '::=' otherlv_4= '{' ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) ) otherlv_6= '}'
            {
            this_CRNL_0=(Token)match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_ruleObjectIdentifier392); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_CRNL_0, grammarAccess.getObjectIdentifierAccess().getCRNLTerminalRuleCall_0()); 
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:217:1: ( (lv_name_1_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:218:1: (lv_name_1_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:218:1: (lv_name_1_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:219:3: lv_name_1_0= RULE_ASN1_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifier408); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleObjectIdentifier425); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleObjectIdentifier437); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,21,FOLLOW_21_in_ruleObjectIdentifier449); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:247:1: ( (lv_oidValue_5_0= ruleObjectIdentifierValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:248:1: (lv_oidValue_5_0= ruleObjectIdentifierValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:248:1: (lv_oidValue_5_0= ruleObjectIdentifierValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:249:3: lv_oidValue_5_0= ruleObjectIdentifierValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_ruleObjectIdentifier470);
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

            otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleObjectIdentifier482); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:280:1: entryRuleObjectIdentifierValue returns [EObject current=null] : iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF ;
    public final EObject entryRuleObjectIdentifierValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectIdentifierValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:281:2: (iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:282:2: iv_ruleObjectIdentifierValue= ruleObjectIdentifierValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectIdentifierValueRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue522);
            iv_ruleObjectIdentifierValue=ruleObjectIdentifierValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjectIdentifierValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifierValue532); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:289:1: ruleObjectIdentifierValue returns [EObject current=null] : ( ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* ) ;
    public final EObject ruleObjectIdentifierValue() throws RecognitionException {
        EObject current = null;

        Token lv_root_0_0=null;
        Token otherlv_1=null;
        Token lv_subIds_2_0=null;
        Token lv_subIds_3_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:292:28: ( ( ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:293:1: ( ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:293:1: ( ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:293:2: ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )? ( (lv_subIds_2_0= RULE_INT ) ) ( (lv_subIds_3_0= RULE_INT ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:293:2: ( ( (lv_root_0_0= RULE_ASN1_ID ) ) | ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) ) )?
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:293:3: ( (lv_root_0_0= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:293:3: ( (lv_root_0_0= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:294:1: (lv_root_0_0= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:294:1: (lv_root_0_0= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:295:3: lv_root_0_0= RULE_ASN1_ID
                    {
                    lv_root_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue575); if (state.failed) return current;
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:312:6: ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:312:6: ( ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:312:7: ( ( RULE_ASN1_ID ) )=> (otherlv_1= RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:318:1: (otherlv_1= RULE_ASN1_ID )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:319:3: otherlv_1= RULE_ASN1_ID
                    {
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getObjectIdentifierValueRule());
                      	        }
                              
                    }
                    otherlv_1=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue618); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		newLeafNode(otherlv_1, grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_1_0()); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:330:4: ( (lv_subIds_2_0= RULE_INT ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:331:1: (lv_subIds_2_0= RULE_INT )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:331:1: (lv_subIds_2_0= RULE_INT )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:332:3: lv_subIds_2_0= RULE_INT
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:348:2: ( (lv_subIds_3_0= RULE_INT ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_INT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:349:1: (lv_subIds_3_0= RULE_INT )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:349:1: (lv_subIds_3_0= RULE_INT )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:350:3: lv_subIds_3_0= RULE_INT
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:374:1: entryRuleTypeDefinition returns [EObject current=null] : iv_ruleTypeDefinition= ruleTypeDefinition EOF ;
    public final EObject entryRuleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinition = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:375:2: (iv_ruleTypeDefinition= ruleTypeDefinition EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:376:2: iv_ruleTypeDefinition= ruleTypeDefinition EOF
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:383:1: ruleTypeDefinition returns [EObject current=null] : (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_scope_3_0= ruleScope ) ) ) ;
    public final EObject ruleTypeDefinition() throws RecognitionException {
        EObject current = null;

        Token this_CRNL_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_scope_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:386:28: ( (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_scope_3_0= ruleScope ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:387:1: (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_scope_3_0= ruleScope ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:387:1: (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_scope_3_0= ruleScope ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:387:2: this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= '::=' ( (lv_scope_3_0= ruleScope ) )
            {
            this_CRNL_0=(Token)match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_ruleTypeDefinition747); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_CRNL_0, grammarAccess.getTypeDefinitionAccess().getCRNLTerminalRuleCall_0()); 
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:391:1: ( (lv_name_1_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:392:1: (lv_name_1_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:392:1: (lv_name_1_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:393:3: lv_name_1_0= RULE_MODULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleTypeDefinition763); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleTypeDefinition780); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTypeDefinitionAccess().getColonColonEqualsSignKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:413:1: ( (lv_scope_3_0= ruleScope ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:414:1: (lv_scope_3_0= ruleScope )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:414:1: (lv_scope_3_0= ruleScope )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:415:3: lv_scope_3_0= ruleScope
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDefinitionAccess().getScopeScopeParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleScope_in_ruleTypeDefinition801);
            lv_scope_3_0=ruleScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"scope",
                      		lv_scope_3_0, 
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:439:1: entryRuleMacro returns [EObject current=null] : iv_ruleMacro= ruleMacro EOF ;
    public final EObject entryRuleMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacro = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:440:2: (iv_ruleMacro= ruleMacro EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:441:2: iv_ruleMacro= ruleMacro EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroRule()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_entryRuleMacro837);
            iv_ruleMacro=ruleMacro();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacro; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacro847); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:448:1: ruleMacro returns [EObject current=null] : (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_CRNL_4= RULE_CRNL otherlv_5= 'BEGIN' this_CRNL_6= RULE_CRNL otherlv_7= 'TYPE NOTATION' otherlv_8= '::=' ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+ this_CRNL_10= RULE_CRNL otherlv_11= 'VALUE NOTATION' otherlv_12= '::=' ( (lv_valueNotation_13_0= ruleMacroValue ) ) ( (lv_innerTypes_14_0= ruleTypeDefinition ) )+ otherlv_15= 'END' ) ;
    public final EObject ruleMacro() throws RecognitionException {
        EObject current = null;

        Token this_CRNL_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_CRNL_4=null;
        Token otherlv_5=null;
        Token this_CRNL_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token this_CRNL_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        EObject lv_typeNotations_9_0 = null;

        EObject lv_valueNotation_13_0 = null;

        EObject lv_innerTypes_14_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:451:28: ( (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_CRNL_4= RULE_CRNL otherlv_5= 'BEGIN' this_CRNL_6= RULE_CRNL otherlv_7= 'TYPE NOTATION' otherlv_8= '::=' ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+ this_CRNL_10= RULE_CRNL otherlv_11= 'VALUE NOTATION' otherlv_12= '::=' ( (lv_valueNotation_13_0= ruleMacroValue ) ) ( (lv_innerTypes_14_0= ruleTypeDefinition ) )+ otherlv_15= 'END' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:452:1: (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_CRNL_4= RULE_CRNL otherlv_5= 'BEGIN' this_CRNL_6= RULE_CRNL otherlv_7= 'TYPE NOTATION' otherlv_8= '::=' ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+ this_CRNL_10= RULE_CRNL otherlv_11= 'VALUE NOTATION' otherlv_12= '::=' ( (lv_valueNotation_13_0= ruleMacroValue ) ) ( (lv_innerTypes_14_0= ruleTypeDefinition ) )+ otherlv_15= 'END' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:452:1: (this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_CRNL_4= RULE_CRNL otherlv_5= 'BEGIN' this_CRNL_6= RULE_CRNL otherlv_7= 'TYPE NOTATION' otherlv_8= '::=' ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+ this_CRNL_10= RULE_CRNL otherlv_11= 'VALUE NOTATION' otherlv_12= '::=' ( (lv_valueNotation_13_0= ruleMacroValue ) ) ( (lv_innerTypes_14_0= ruleTypeDefinition ) )+ otherlv_15= 'END' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:452:2: this_CRNL_0= RULE_CRNL ( (lv_name_1_0= RULE_MODULE_ID ) ) otherlv_2= 'MACRO' otherlv_3= '::=' this_CRNL_4= RULE_CRNL otherlv_5= 'BEGIN' this_CRNL_6= RULE_CRNL otherlv_7= 'TYPE NOTATION' otherlv_8= '::=' ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+ this_CRNL_10= RULE_CRNL otherlv_11= 'VALUE NOTATION' otherlv_12= '::=' ( (lv_valueNotation_13_0= ruleMacroValue ) ) ( (lv_innerTypes_14_0= ruleTypeDefinition ) )+ otherlv_15= 'END'
            {
            this_CRNL_0=(Token)match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_ruleMacro883); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_CRNL_0, grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_0()); 
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:456:1: ( (lv_name_1_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:457:1: (lv_name_1_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:457:1: (lv_name_1_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:458:3: lv_name_1_0= RULE_MODULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleMacro899); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleMacro916); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMacroAccess().getMACROKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleMacro928); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_3());
                  
            }
            this_CRNL_4=(Token)match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_ruleMacro939); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_CRNL_4, grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_4()); 
                  
            }
            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleMacro950); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMacroAccess().getBEGINKeyword_5());
                  
            }
            this_CRNL_6=(Token)match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_ruleMacro961); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_CRNL_6, grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_6()); 
                  
            }
            otherlv_7=(Token)match(input,24,FOLLOW_24_in_ruleMacro972); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getMacroAccess().getTYPENOTATIONKeyword_7());
                  
            }
            otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleMacro984); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_8());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:502:1: ( (lv_typeNotations_9_0= ruleTypeAssignment ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_MODULE_ID||LA6_0==RULE_PARAMETER) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:503:1: (lv_typeNotations_9_0= ruleTypeAssignment )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:503:1: (lv_typeNotations_9_0= ruleTypeAssignment )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:504:3: lv_typeNotations_9_0= ruleTypeAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMacroAccess().getTypeNotationsTypeAssignmentParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeAssignment_in_ruleMacro1005);
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
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            this_CRNL_10=(Token)match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_ruleMacro1017); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_CRNL_10, grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_10()); 
                  
            }
            otherlv_11=(Token)match(input,25,FOLLOW_25_in_ruleMacro1028); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getMacroAccess().getVALUENOTATIONKeyword_11());
                  
            }
            otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleMacro1040); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_12());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:532:1: ( (lv_valueNotation_13_0= ruleMacroValue ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:533:1: (lv_valueNotation_13_0= ruleMacroValue )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:533:1: (lv_valueNotation_13_0= ruleMacroValue )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:534:3: lv_valueNotation_13_0= ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_13_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMacroValue_in_ruleMacro1061);
            lv_valueNotation_13_0=ruleMacroValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMacroRule());
              	        }
                     		set(
                     			current, 
                     			"valueNotation",
                      		lv_valueNotation_13_0, 
                      		"MacroValue");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:550:2: ( (lv_innerTypes_14_0= ruleTypeDefinition ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_CRNL) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:551:1: (lv_innerTypes_14_0= ruleTypeDefinition )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:551:1: (lv_innerTypes_14_0= ruleTypeDefinition )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:552:3: lv_innerTypes_14_0= ruleTypeDefinition
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_14_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleMacro1082);
            	    lv_innerTypes_14_0=ruleTypeDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMacroRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"innerTypes",
            	              		lv_innerTypes_14_0, 
            	              		"TypeDefinition");
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

            otherlv_15=(Token)match(input,19,FOLLOW_19_in_ruleMacro1095); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_15, grammarAccess.getMacroAccess().getENDKeyword_15());
                  
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:580:1: entryRuleTypeAssignment returns [EObject current=null] : iv_ruleTypeAssignment= ruleTypeAssignment EOF ;
    public final EObject entryRuleTypeAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:581:2: (iv_ruleTypeAssignment= ruleTypeAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:582:2: iv_ruleTypeAssignment= ruleTypeAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment1131);
            iv_ruleTypeAssignment=ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAssignment1141); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:589:1: ruleTypeAssignment returns [EObject current=null] : (this_ParamAssignment_0= ruleParamAssignment | this_TypeReference_1= ruleTypeReference ) ;
    public final EObject ruleTypeAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_ParamAssignment_0 = null;

        EObject this_TypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:592:28: ( (this_ParamAssignment_0= ruleParamAssignment | this_TypeReference_1= ruleTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:593:1: (this_ParamAssignment_0= ruleParamAssignment | this_TypeReference_1= ruleTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:593:1: (this_ParamAssignment_0= ruleParamAssignment | this_TypeReference_1= ruleTypeReference )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_PARAMETER) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_MODULE_ID) ) {
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:594:5: this_ParamAssignment_0= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleTypeAssignment1188);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:604:5: this_TypeReference_1= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeAssignment1215);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:620:1: entryRuleParamAssignment returns [EObject current=null] : iv_ruleParamAssignment= ruleParamAssignment EOF ;
    public final EObject entryRuleParamAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamAssignment = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:621:2: (iv_ruleParamAssignment= ruleParamAssignment EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:622:2: iv_ruleParamAssignment= ruleParamAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParamAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment1250);
            iv_ruleParamAssignment=ruleParamAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParamAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamAssignment1260); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:629:1: ruleParamAssignment returns [EObject current=null] : ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotation ) ) ) ;
    public final EObject ruleParamAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_param_0_0=null;
        EObject lv_right_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:632:28: ( ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotation ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:633:1: ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotation ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:633:1: ( ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotation ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:633:2: ( (lv_param_0_0= RULE_PARAMETER ) ) ( (lv_right_1_0= ruleTypeNotation ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:633:2: ( (lv_param_0_0= RULE_PARAMETER ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:634:1: (lv_param_0_0= RULE_PARAMETER )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:634:1: (lv_param_0_0= RULE_PARAMETER )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:635:3: lv_param_0_0= RULE_PARAMETER
            {
            lv_param_0_0=(Token)match(input,RULE_PARAMETER,FOLLOW_RULE_PARAMETER_in_ruleParamAssignment1302); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:651:2: ( (lv_right_1_0= ruleTypeNotation ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:652:1: (lv_right_1_0= ruleTypeNotation )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:652:1: (lv_right_1_0= ruleTypeNotation )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:653:3: lv_right_1_0= ruleTypeNotation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParamAssignmentAccess().getRightTypeNotationParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_ruleParamAssignment1328);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:677:1: entryRuleTypeNotation returns [EObject current=null] : iv_ruleTypeNotation= ruleTypeNotation EOF ;
    public final EObject entryRuleTypeNotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNotation = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:678:2: (iv_ruleTypeNotation= ruleTypeNotation EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:679:2: iv_ruleTypeNotation= ruleTypeNotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNotationRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation1364);
            iv_ruleTypeNotation=ruleTypeNotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNotation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotation1374); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:686:1: ruleTypeNotation returns [EObject current=null] : (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) ;
    public final EObject ruleTypeNotation() throws RecognitionException {
        EObject current = null;

        EObject this_TypeReference_0 = null;

        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:689:28: ( (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:690:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:690:1: (this_TypeReference_0= ruleTypeReference | ( (lv_value_1_0= ruleMacroValue ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_MODULE_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==27) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:691:5: this_TypeReference_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeNotationAccess().getTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeNotation1421);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:700:6: ( (lv_value_1_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:700:6: ( (lv_value_1_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:701:1: (lv_value_1_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:701:1: (lv_value_1_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:702:3: lv_value_1_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNotationAccess().getValueMacroValueParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleTypeNotation1447);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:726:1: entryRuleTypeReferenceExt returns [EObject current=null] : iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF ;
    public final EObject entryRuleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReferenceExt = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:727:2: (iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:728:2: iv_ruleTypeReferenceExt= ruleTypeReferenceExt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceExtRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt1483);
            iv_ruleTypeReferenceExt=ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReferenceExt; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReferenceExt1493); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:735:1: ruleTypeReferenceExt returns [EObject current=null] : ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? ) ;
    public final EObject ruleTypeReferenceExt() throws RecognitionException {
        EObject current = null;

        EObject lv_parentRef_0_0 = null;

        EObject lv_childRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:738:28: ( ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:739:1: ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:739:1: ( ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )? )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:739:2: ( (lv_parentRef_0_0= ruleTypeReference ) ) ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:739:2: ( (lv_parentRef_0_0= ruleTypeReference ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:740:1: (lv_parentRef_0_0= ruleTypeReference )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:740:1: (lv_parentRef_0_0= ruleTypeReference )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:741:3: lv_parentRef_0_0= ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getParentRefTypeReferenceParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1539);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:757:2: ( ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_MODULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (synpred2_InternalSmi()) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:757:3: ( ( ruleTypeReference ) )=> (lv_childRef_1_0= ruleTypeReference )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:762:1: (lv_childRef_1_0= ruleTypeReference )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:763:3: lv_childRef_1_0= ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeReferenceExtAccess().getChildRefTypeReferenceParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1570);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:787:1: entryRuleTypeReference returns [EObject current=null] : iv_ruleTypeReference= ruleTypeReference EOF ;
    public final EObject entryRuleTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReference = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:788:2: (iv_ruleTypeReference= ruleTypeReference EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:789:2: iv_ruleTypeReference= ruleTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_entryRuleTypeReference1607);
            iv_ruleTypeReference=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReference1617); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:796:1: ruleTypeReference returns [EObject current=null] : ( (otherlv_0= RULE_MODULE_ID ) ) ;
    public final EObject ruleTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:799:28: ( ( (otherlv_0= RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:800:1: ( (otherlv_0= RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:800:1: ( (otherlv_0= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:801:1: (otherlv_0= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:801:1: (otherlv_0= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:802:3: otherlv_0= RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeReferenceRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleTypeReference1661); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:821:1: entryRuleScope returns [EObject current=null] : iv_ruleScope= ruleScope EOF ;
    public final EObject entryRuleScope() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScope = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:822:2: (iv_ruleScope= ruleScope EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:823:2: iv_ruleScope= ruleScope EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getScopeRule()); 
            }
            pushFollow(FOLLOW_ruleScope_in_entryRuleScope1696);
            iv_ruleScope=ruleScope();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleScope; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScope1706); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:830:1: ruleScope returns [EObject current=null] : ( ( (lv_values_0_0= ruleValue ) )+ this_CRNL_1= RULE_CRNL ) ;
    public final EObject ruleScope() throws RecognitionException {
        EObject current = null;

        Token this_CRNL_1=null;
        EObject lv_values_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:833:28: ( ( ( (lv_values_0_0= ruleValue ) )+ this_CRNL_1= RULE_CRNL ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:834:1: ( ( (lv_values_0_0= ruleValue ) )+ this_CRNL_1= RULE_CRNL )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:834:1: ( ( (lv_values_0_0= ruleValue ) )+ this_CRNL_1= RULE_CRNL )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:834:2: ( (lv_values_0_0= ruleValue ) )+ this_CRNL_1= RULE_CRNL
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:834:2: ( (lv_values_0_0= ruleValue ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_MODULE_ID||(LA11_0>=RULE_PARAMETER && LA11_0<=RULE_IA5STRING)||LA11_0==20||LA11_0==27||(LA11_0>=33 && LA11_0<=35)||LA11_0==38) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:835:1: (lv_values_0_0= ruleValue )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:835:1: (lv_values_0_0= ruleValue )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:836:3: lv_values_0_0= ruleValue
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getScopeAccess().getValuesValueParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValue_in_ruleScope1752);
            	    lv_values_0_0=ruleValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getScopeRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"values",
            	              		lv_values_0_0, 
            	              		"Value");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

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

            this_CRNL_1=(Token)match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_ruleScope1764); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_CRNL_1, grammarAccess.getScopeAccess().getCRNLTerminalRuleCall_1()); 
                  
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:864:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:865:2: (iv_ruleValue= ruleValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:866:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue1799);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue1809); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:873:1: ruleValue returns [EObject current=null] : ( ( (lv_valueTypes_0_0= ruleValueType ) ) (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )* ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_valueTypes_0_0 = null;

        EObject lv_valueTypes_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:876:28: ( ( ( (lv_valueTypes_0_0= ruleValueType ) ) (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )* ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:877:1: ( ( (lv_valueTypes_0_0= ruleValueType ) ) (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )* )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:877:1: ( ( (lv_valueTypes_0_0= ruleValueType ) ) (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )* )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:877:2: ( (lv_valueTypes_0_0= ruleValueType ) ) (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )*
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:877:2: ( (lv_valueTypes_0_0= ruleValueType ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:878:1: (lv_valueTypes_0_0= ruleValueType )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:878:1: (lv_valueTypes_0_0= ruleValueType )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:879:3: lv_valueTypes_0_0= ruleValueType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValueType_in_ruleValue1855);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:895:2: (otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==26) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:895:4: otherlv_1= '|' ( (lv_valueTypes_2_0= ruleValueType ) )
            	    {
            	    otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleValue1868); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getValueAccess().getVerticalLineKeyword_1_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:899:1: ( (lv_valueTypes_2_0= ruleValueType ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:900:1: (lv_valueTypes_2_0= ruleValueType )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:900:1: (lv_valueTypes_2_0= ruleValueType )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:901:3: lv_valueTypes_2_0= ruleValueType
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleValueType_in_ruleValue1889);
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
            	    break loop12;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:925:1: entryRuleValueType returns [EObject current=null] : iv_ruleValueType= ruleValueType EOF ;
    public final EObject entryRuleValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:926:2: (iv_ruleValueType= ruleValueType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:927:2: iv_ruleValueType= ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType1927);
            iv_ruleValueType=ruleValueType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType1937); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:934:1: ruleValueType returns [EObject current=null] : ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_type_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) ) ;
    public final EObject ruleValueType() throws RecognitionException {
        EObject current = null;

        Token lv_oi_4_0=null;
        EObject lv_param_0_0 = null;

        EObject lv_type_1_0 = null;

        EObject lv_simpleType_2_0 = null;

        EObject lv_macroValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:937:28: ( ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_type_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:938:1: ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_type_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:938:1: ( ( (lv_param_0_0= ruleParamAssignment ) ) | ( (lv_type_1_0= ruleTypeReferenceExt ) ) | ( (lv_simpleType_2_0= ruleASN1_TYPE ) ) | ( (lv_macroValue_3_0= ruleMacroValue ) ) | ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt13=1;
                }
                break;
            case RULE_MODULE_ID:
                {
                alt13=2;
                }
                break;
            case RULE_IA5STRING:
            case 33:
            case 34:
            case 35:
            case 38:
                {
                alt13=3;
                }
                break;
            case 27:
                {
                alt13=4;
                }
                break;
            case 20:
                {
                alt13=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:938:2: ( (lv_param_0_0= ruleParamAssignment ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:938:2: ( (lv_param_0_0= ruleParamAssignment ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:939:1: (lv_param_0_0= ruleParamAssignment )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:939:1: (lv_param_0_0= ruleParamAssignment )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:940:3: lv_param_0_0= ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_ruleValueType1983);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:957:6: ( (lv_type_1_0= ruleTypeReferenceExt ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:957:6: ( (lv_type_1_0= ruleTypeReferenceExt ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:958:1: (lv_type_1_0= ruleTypeReferenceExt )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:958:1: (lv_type_1_0= ruleTypeReferenceExt )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:959:3: lv_type_1_0= ruleTypeReferenceExt
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getTypeTypeReferenceExtParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeReferenceExt_in_ruleValueType2010);
                    lv_type_1_0=ruleTypeReferenceExt();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getValueTypeRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_1_0, 
                              		"TypeReferenceExt");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:976:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:976:6: ( (lv_simpleType_2_0= ruleASN1_TYPE ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:977:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:977:1: (lv_simpleType_2_0= ruleASN1_TYPE )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:978:3: lv_simpleType_2_0= ruleASN1_TYPE
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleASN1_TYPE_in_ruleValueType2037);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:995:6: ( (lv_macroValue_3_0= ruleMacroValue ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:995:6: ( (lv_macroValue_3_0= ruleMacroValue ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:996:1: (lv_macroValue_3_0= ruleMacroValue )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:996:1: (lv_macroValue_3_0= ruleMacroValue )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:997:3: lv_macroValue_3_0= ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_ruleValueType2064);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1014:6: ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1014:6: ( (lv_oi_4_0= 'OBJECT IDENTIFIER' ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1015:1: (lv_oi_4_0= 'OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1015:1: (lv_oi_4_0= 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1016:3: lv_oi_4_0= 'OBJECT IDENTIFIER'
                    {
                    lv_oi_4_0=(Token)match(input,20,FOLLOW_20_in_ruleValueType2088); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1037:1: entryRuleMacroValue returns [EObject current=null] : iv_ruleMacroValue= ruleMacroValue EOF ;
    public final EObject entryRuleMacroValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMacroValue = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1038:2: (iv_ruleMacroValue= ruleMacroValue EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1039:2: iv_ruleMacroValue= ruleMacroValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMacroValueRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue2137);
            iv_ruleMacroValue=ruleMacroValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMacroValue; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue2147); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1046:1: ruleMacroValue returns [EObject current=null] : ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' ) ;
    public final EObject ruleMacroValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1049:28: ( ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1050:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1050:1: ( () otherlv_1= 'value' otherlv_2= '(' ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1050:2: () otherlv_1= 'value' otherlv_2= '(' ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) ) otherlv_4= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1050:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1051:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getMacroValueAccess().getMacroValueAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleMacroValue2193); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMacroValueAccess().getValueKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleMacroValue2205); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getMacroValueAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1064:1: ( (lv_type_3_0= ruleMACRO_VALUE_TYPE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1065:1: (lv_type_3_0= ruleMACRO_VALUE_TYPE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1065:1: (lv_type_3_0= ruleMACRO_VALUE_TYPE )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1066:3: lv_type_3_0= ruleMACRO_VALUE_TYPE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMacroValueAccess().getTypeMACRO_VALUE_TYPEParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_ruleMacroValue2226);
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

            otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleMacroValue2238); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1094:1: entryRuleMACRO_VALUE_TYPE returns [EObject current=null] : iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF ;
    public final EObject entryRuleMACRO_VALUE_TYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMACRO_VALUE_TYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1095:2: (iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1096:2: iv_ruleMACRO_VALUE_TYPE= ruleMACRO_VALUE_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE2274);
            iv_ruleMACRO_VALUE_TYPE=ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMACRO_VALUE_TYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE2284); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1103:1: ruleMACRO_VALUE_TYPE returns [EObject current=null] : ( ( (lv_update_0_0= ruleUpdateType ) ) | ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) ) ) ;
    public final EObject ruleMACRO_VALUE_TYPE() throws RecognitionException {
        EObject current = null;

        EObject lv_update_0_0 = null;

        AntlrDatatypeRuleToken lv_literal_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1106:28: ( ( ( (lv_update_0_0= ruleUpdateType ) ) | ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1107:1: ( ( (lv_update_0_0= ruleUpdateType ) ) | ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1107:1: ( ( (lv_update_0_0= ruleUpdateType ) ) | ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==30) ) {
                alt14=1;
            }
            else if ( ((LA14_0>=31 && LA14_0<=32)) ) {
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1107:2: ( (lv_update_0_0= ruleUpdateType ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1107:2: ( (lv_update_0_0= ruleUpdateType ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1108:1: (lv_update_0_0= ruleUpdateType )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1108:1: (lv_update_0_0= ruleUpdateType )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1109:3: lv_update_0_0= ruleUpdateType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateUpdateTypeParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUpdateType_in_ruleMACRO_VALUE_TYPE2330);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1126:6: ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1126:6: ( (lv_literal_1_0= ruleMACRO_VALUE_CAP ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1127:1: (lv_literal_1_0= ruleMACRO_VALUE_CAP )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1127:1: (lv_literal_1_0= ruleMACRO_VALUE_CAP )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1128:3: lv_literal_1_0= ruleMACRO_VALUE_CAP
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralMACRO_VALUE_CAPParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_ruleMACRO_VALUE_TYPE2357);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1152:1: entryRuleUpdateType returns [EObject current=null] : iv_ruleUpdateType= ruleUpdateType EOF ;
    public final EObject entryRuleUpdateType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpdateType = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1153:2: (iv_ruleUpdateType= ruleUpdateType EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1154:2: iv_ruleUpdateType= ruleUpdateType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUpdateTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_entryRuleUpdateType2393);
            iv_ruleUpdateType=ruleUpdateType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUpdateType; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpdateType2403); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1161:1: ruleUpdateType returns [EObject current=null] : (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) ) ;
    public final EObject ruleUpdateType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1164:28: ( (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1165:1: (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1165:1: (otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1165:3: otherlv_0= 'Update' ( (otherlv_1= RULE_MODULE_ID ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleUpdateType2440); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getUpdateTypeAccess().getUpdateKeyword_0());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1169:1: ( (otherlv_1= RULE_MODULE_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1170:1: (otherlv_1= RULE_MODULE_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1170:1: (otherlv_1= RULE_MODULE_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1171:3: otherlv_1= RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getUpdateTypeRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleUpdateType2460); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1190:1: entryRuleMACRO_VALUE_CAP returns [String current=null] : iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF ;
    public final String entryRuleMACRO_VALUE_CAP() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMACRO_VALUE_CAP = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1191:2: (iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1192:2: iv_ruleMACRO_VALUE_CAP= ruleMACRO_VALUE_CAP EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP2497);
            iv_ruleMACRO_VALUE_CAP=ruleMACRO_VALUE_CAP();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMACRO_VALUE_CAP.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP2508); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1199:1: ruleMACRO_VALUE_CAP returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'VALUE OBJECT IDENTIFIER' | kw= 'IA5String' ) ;
    public final AntlrDatatypeRuleToken ruleMACRO_VALUE_CAP() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1202:28: ( (kw= 'VALUE OBJECT IDENTIFIER' | kw= 'IA5String' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1203:1: (kw= 'VALUE OBJECT IDENTIFIER' | kw= 'IA5String' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1203:1: (kw= 'VALUE OBJECT IDENTIFIER' | kw= 'IA5String' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==31) ) {
                alt15=1;
            }
            else if ( (LA15_0==32) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1204:2: kw= 'VALUE OBJECT IDENTIFIER'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleMACRO_VALUE_CAP2546); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMACRO_VALUE_CAPAccess().getVALUEOBJECTIDENTIFIERKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1211:2: kw= 'IA5String'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleMACRO_VALUE_CAP2565); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1224:1: entryRuleASN1_TYPE returns [EObject current=null] : iv_ruleASN1_TYPE= ruleASN1_TYPE EOF ;
    public final EObject entryRuleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_TYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1225:2: (iv_ruleASN1_TYPE= ruleASN1_TYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1226:2: iv_ruleASN1_TYPE= ruleASN1_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE2605);
            iv_ruleASN1_TYPE=ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_TYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE2615); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1233:1: ruleASN1_TYPE returns [EObject current=null] : (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE ) ;
    public final EObject ruleASN1_TYPE() throws RecognitionException {
        EObject current = null;

        EObject this_ASN1_SIMPLE_0 = null;

        EObject this_ASN1_CHOICE_1 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1236:28: ( (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1237:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1237:1: (this_ASN1_SIMPLE_0= ruleASN1_SIMPLE | this_ASN1_CHOICE_1= ruleASN1_CHOICE )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_IA5STRING||(LA16_0>=33 && LA16_0<=35)) ) {
                alt16=1;
            }
            else if ( (LA16_0==38) ) {
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1238:5: this_ASN1_SIMPLE_0= ruleASN1_SIMPLE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE2662);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1248:5: this_ASN1_CHOICE_1= ruleASN1_CHOICE
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE2689);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1264:1: entryRuleASN1_SIMPLE returns [EObject current=null] : iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF ;
    public final EObject entryRuleASN1_SIMPLE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SIMPLE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1265:2: (iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1266:2: iv_ruleASN1_SIMPLE= ruleASN1_SIMPLE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SIMPLERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE2724);
            iv_ruleASN1_SIMPLE=ruleASN1_SIMPLE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SIMPLE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE2734); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1273:1: ruleASN1_SIMPLE returns [EObject current=null] : ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1276:28: ( ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1277:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1277:1: ( ( () otherlv_1= 'empty' ) | ( () this_IA5STRING_3= RULE_IA5STRING ) | (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? ) | (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? ) )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt19=1;
                }
                break;
            case RULE_IA5STRING:
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
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1277:2: ( () otherlv_1= 'empty' )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1277:2: ( () otherlv_1= 'empty' )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1277:3: () otherlv_1= 'empty'
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1277:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1278:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleASN1_SIMPLE2781); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1288:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1288:6: ( () this_IA5STRING_3= RULE_IA5STRING )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1288:7: () this_IA5STRING_3= RULE_IA5STRING
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1288:7: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1289:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_1_0(),
                                  current);
                          
                    }

                    }

                    this_IA5STRING_3=(Token)match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE2809); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_IA5STRING_3, grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1299:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1299:6: (this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )? )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1300:5: this_ASN1_OCTET_STRING_4= ruleASN1_OCTET_STRING ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_2_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE2838);
                    this_ASN1_OCTET_STRING_4=ruleASN1_OCTET_STRING();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_OCTET_STRING_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1308:1: ( (lv_constraint_5_0= ruleASN1_SUBTYPE ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==28) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1309:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1309:1: (lv_constraint_5_0= ruleASN1_SUBTYPE )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1310:3: lv_constraint_5_0= ruleASN1_SUBTYPE
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE2858);
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1327:6: (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1327:6: (this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )? )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1328:5: this_ASN1_INTEGER_6= ruleASN1_INTEGER ( (lv_constraint_7_0= ruleASN1_RANGE ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE2889);
                    this_ASN1_INTEGER_6=ruleASN1_INTEGER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ASN1_INTEGER_6; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1336:1: ( (lv_constraint_7_0= ruleASN1_RANGE ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_INT) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1337:1: (lv_constraint_7_0= ruleASN1_RANGE )
                            {
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1337:1: (lv_constraint_7_0= ruleASN1_RANGE )
                            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1338:3: lv_constraint_7_0= ruleASN1_RANGE
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_RANGEParserRuleCall_3_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SIMPLE2909);
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1362:1: entryRuleASN1_OCTET_STRING returns [EObject current=null] : iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF ;
    public final EObject entryRuleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_OCTET_STRING = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1363:2: (iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1364:2: iv_ruleASN1_OCTET_STRING= ruleASN1_OCTET_STRING EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING2947);
            iv_ruleASN1_OCTET_STRING=ruleASN1_OCTET_STRING();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_OCTET_STRING; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING2957); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1371:1: ruleASN1_OCTET_STRING returns [EObject current=null] : ( () otherlv_1= 'OCTET STRING' ) ;
    public final EObject ruleASN1_OCTET_STRING() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1374:28: ( ( () otherlv_1= 'OCTET STRING' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1375:1: ( () otherlv_1= 'OCTET STRING' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1375:1: ( () otherlv_1= 'OCTET STRING' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1375:2: () otherlv_1= 'OCTET STRING'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1375:2: ()
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1376:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleASN1_OCTET_STRING3003); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1393:1: entryRuleASN1_INTEGER returns [EObject current=null] : iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF ;
    public final EObject entryRuleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_INTEGER = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1394:2: (iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1395:2: iv_ruleASN1_INTEGER= ruleASN1_INTEGER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_INTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER3039);
            iv_ruleASN1_INTEGER=ruleASN1_INTEGER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_INTEGER; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER3049); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1402:1: ruleASN1_INTEGER returns [EObject current=null] : (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' ) ;
    public final EObject ruleASN1_INTEGER() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_valuePairs_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1405:28: ( (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1406:1: (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1406:1: (otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1406:3: otherlv_0= 'INTEGER' otherlv_1= '{' ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleASN1_INTEGER3086); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_INTEGERAccess().getINTEGERKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleASN1_INTEGER3098); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_INTEGERAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1414:1: ( (lv_valuePairs_2_0= ruleASN1_VALUEPAIR ) )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ASN1_ID||LA20_0==28) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1415:1: (lv_valuePairs_2_0= ruleASN1_VALUEPAIR )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1415:1: (lv_valuePairs_2_0= ruleASN1_VALUEPAIR )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1416:3: lv_valuePairs_2_0= ruleASN1_VALUEPAIR
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_INTEGERAccess().getValuePairsASN1_VALUEPAIRParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_ruleASN1_INTEGER3119);
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
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleASN1_INTEGER3132); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1444:1: entryRuleASN1_SUBTYPE returns [EObject current=null] : iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF ;
    public final EObject entryRuleASN1_SUBTYPE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_SUBTYPE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1445:2: (iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1446:2: iv_ruleASN1_SUBTYPE= ruleASN1_SUBTYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_SUBTYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE3168);
            iv_ruleASN1_SUBTYPE=ruleASN1_SUBTYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_SUBTYPE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE3178); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1453:1: ruleASN1_SUBTYPE returns [EObject current=null] : (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1456:28: ( (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1457:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1457:1: (otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1457:3: otherlv_0= '(' otherlv_1= 'SIZE' otherlv_2= '(' ( (lv_ranges_3_0= ruleASN1_RANGE ) ) (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )* otherlv_6= ')' otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleASN1_SUBTYPE3215); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleASN1_SUBTYPE3227); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleASN1_SUBTYPE3239); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_2());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1469:1: ( (lv_ranges_3_0= ruleASN1_RANGE ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1470:1: (lv_ranges_3_0= ruleASN1_RANGE )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1470:1: (lv_ranges_3_0= ruleASN1_RANGE )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1471:3: lv_ranges_3_0= ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3260);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1487:2: (otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==26) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1487:4: otherlv_4= '|' ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    {
            	    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleASN1_SUBTYPE3273); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getASN1_SUBTYPEAccess().getVerticalLineKeyword_4_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1491:1: ( (lv_ranges_5_0= ruleASN1_RANGE ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1492:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1492:1: (lv_ranges_5_0= ruleASN1_RANGE )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1493:3: lv_ranges_5_0= ruleASN1_RANGE
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_4_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3294);
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
            	    break loop21;
                }
            } while (true);

            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleASN1_SUBTYPE3308); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_7=(Token)match(input,29,FOLLOW_29_in_ruleASN1_SUBTYPE3320); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1525:1: entryRuleASN1_RANGE returns [EObject current=null] : iv_ruleASN1_RANGE= ruleASN1_RANGE EOF ;
    public final EObject entryRuleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_RANGE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1526:2: (iv_ruleASN1_RANGE= ruleASN1_RANGE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1527:2: iv_ruleASN1_RANGE= ruleASN1_RANGE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_RANGERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE3356);
            iv_ruleASN1_RANGE=ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_RANGE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE3366); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1534:1: ruleASN1_RANGE returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) ) ;
    public final EObject ruleASN1_RANGE() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_start_2_0=null;
        Token otherlv_3=null;
        Token lv_end_4_0=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1537:28: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1538:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1538:1: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_INT) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==37) ) {
                    alt22=2;
                }
                else if ( (LA22_1==EOF||(LA22_1>=RULE_MODULE_ID && LA22_1<=RULE_CRNL)||(LA22_1>=RULE_PARAMETER && LA22_1<=RULE_IA5STRING)||LA22_1==20||(LA22_1>=26 && LA22_1<=27)||LA22_1==29||(LA22_1>=33 && LA22_1<=35)||LA22_1==38) ) {
                    alt22=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1538:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1538:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1538:3: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1538:3: ()
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1539:5: 
                    {
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1544:2: ( (lv_value_1_0= RULE_INT ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1545:1: (lv_value_1_0= RULE_INT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1545:1: (lv_value_1_0= RULE_INT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1546:3: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_RANGE3418); if (state.failed) return current;
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
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1563:6: ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1563:6: ( ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1563:7: ( (lv_start_2_0= RULE_INT ) ) otherlv_3= '..' ( (lv_end_4_0= RULE_INT ) )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1563:7: ( (lv_start_2_0= RULE_INT ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1564:1: (lv_start_2_0= RULE_INT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1564:1: (lv_start_2_0= RULE_INT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1565:3: lv_start_2_0= RULE_INT
                    {
                    lv_start_2_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_RANGE3448); if (state.failed) return current;
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

                    otherlv_3=(Token)match(input,37,FOLLOW_37_in_ruleASN1_RANGE3465); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_1_1());
                          
                    }
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1585:1: ( (lv_end_4_0= RULE_INT ) )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1586:1: (lv_end_4_0= RULE_INT )
                    {
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1586:1: (lv_end_4_0= RULE_INT )
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1587:3: lv_end_4_0= RULE_INT
                    {
                    lv_end_4_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_RANGE3482); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1611:1: entryRuleASN1_VALUEPAIR returns [String current=null] : iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF ;
    public final String entryRuleASN1_VALUEPAIR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleASN1_VALUEPAIR = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1612:2: (iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1613:2: iv_ruleASN1_VALUEPAIR= ruleASN1_VALUEPAIR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_VALUEPAIRRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR3525);
            iv_ruleASN1_VALUEPAIR=ruleASN1_VALUEPAIR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_VALUEPAIR.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR3536); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1620:1: ruleASN1_VALUEPAIR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ASN1_ID_0= RULE_ASN1_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleASN1_VALUEPAIR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ASN1_ID_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1623:28: ( ( (this_ASN1_ID_0= RULE_ASN1_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1624:1: ( (this_ASN1_ID_0= RULE_ASN1_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1624:1: ( (this_ASN1_ID_0= RULE_ASN1_ID )? kw= '(' this_INT_2= RULE_INT kw= ')' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1624:2: (this_ASN1_ID_0= RULE_ASN1_ID )? kw= '(' this_INT_2= RULE_INT kw= ')'
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1624:2: (this_ASN1_ID_0= RULE_ASN1_ID )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ASN1_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1624:7: this_ASN1_ID_0= RULE_ASN1_ID
                    {
                    this_ASN1_ID_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_VALUEPAIR3577); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ASN1_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ASN1_ID_0, grammarAccess.getASN1_VALUEPAIRAccess().getASN1_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;

            }

            kw=(Token)match(input,28,FOLLOW_28_in_ruleASN1_VALUEPAIR3597); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getASN1_VALUEPAIRAccess().getLeftParenthesisKeyword_1()); 
                  
            }
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleASN1_VALUEPAIR3612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_2, grammarAccess.getASN1_VALUEPAIRAccess().getINTTerminalRuleCall_2()); 
                  
            }
            kw=(Token)match(input,29,FOLLOW_29_in_ruleASN1_VALUEPAIR3630); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1658:1: entryRuleASN1_CHOICE returns [EObject current=null] : iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF ;
    public final EObject entryRuleASN1_CHOICE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1659:2: (iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1660:2: iv_ruleASN1_CHOICE= ruleASN1_CHOICE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE3670);
            iv_ruleASN1_CHOICE=ruleASN1_CHOICE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE3680); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1667:1: ruleASN1_CHOICE returns [EObject current=null] : (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' ) ;
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
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1670:28: ( (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1671:1: (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1671:1: (otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}' )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1671:3: otherlv_0= 'CHOICE' otherlv_1= '{' ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) ) (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleASN1_CHOICE3717); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleASN1_CHOICE3729); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1679:1: ( (lv_choices_2_0= ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1680:1: (lv_choices_2_0= ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1680:1: (lv_choices_2_0= ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1681:3: lv_choices_2_0= ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3750);
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1697:2: (otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==39) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1697:4: otherlv_3= ',' ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) )
            	    {
            	    otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleASN1_CHOICE3763); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1701:1: ( (lv_choices_4_0= ruleASN1_CHOICE_ENTRY ) )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1702:1: (lv_choices_4_0= ruleASN1_CHOICE_ENTRY )
            	    {
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1702:1: (lv_choices_4_0= ruleASN1_CHOICE_ENTRY )
            	    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1703:3: lv_choices_4_0= ruleASN1_CHOICE_ENTRY
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3784);
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
            	    break loop24;
                }
            } while (true);

            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleASN1_CHOICE3798); if (state.failed) return current;
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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1731:1: entryRuleASN1_CHOICE_ENTRY returns [EObject current=null] : iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF ;
    public final EObject entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASN1_CHOICE_ENTRY = null;


        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1732:2: (iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1733:2: iv_ruleASN1_CHOICE_ENTRY= ruleASN1_CHOICE_ENTRY EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY3834);
            iv_ruleASN1_CHOICE_ENTRY=ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleASN1_CHOICE_ENTRY; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY3844); if (state.failed) return current;

            }

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
    // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1740:1: ruleASN1_CHOICE_ENTRY returns [EObject current=null] : ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ASN1_ID ) ) ) ;
    public final EObject ruleASN1_CHOICE_ENTRY() throws RecognitionException {
        EObject current = null;

        Token lv_id_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1743:28: ( ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ASN1_ID ) ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1744:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ASN1_ID ) ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1744:1: ( ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ASN1_ID ) ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1744:2: ( (lv_id_0_0= RULE_ASN1_ID ) ) ( (otherlv_1= RULE_ASN1_ID ) )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1744:2: ( (lv_id_0_0= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1745:1: (lv_id_0_0= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1745:1: (lv_id_0_0= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1746:3: lv_id_0_0= RULE_ASN1_ID
            {
            lv_id_0_0=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY3886); if (state.failed) return current;
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

            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1762:2: ( (otherlv_1= RULE_ASN1_ID ) )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1763:1: (otherlv_1= RULE_ASN1_ID )
            {
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1763:1: (otherlv_1= RULE_ASN1_ID )
            // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:1764:3: otherlv_1= RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getASN1_CHOICE_ENTRYRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY3911); if (state.failed) return current;
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
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:312:7: ( ( RULE_ASN1_ID ) )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:313:1: ( RULE_ASN1_ID )
        {
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:313:1: ( RULE_ASN1_ID )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:314:2: RULE_ASN1_ID
        {
        match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_synpred1_InternalSmi601); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalSmi

    // $ANTLR start synpred2_InternalSmi
    public final void synpred2_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:757:3: ( ( ruleTypeReference ) )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:758:1: ( ruleTypeReference )
        {
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:758:1: ( ruleTypeReference )
        // ../com.netxforge.smi/src-gen/com/netxforge/parser/antlr/internal/InternalSmi.g:759:1: ruleTypeReference
        {
        pushFollow(FOLLOW_ruleTypeReference_in_synpred2_InternalSmi1553);
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


 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleModule128 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleModule145 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModule157 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleModule169 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_CRNL_in_ruleModule180 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_ruleModule201 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleModule228 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleMacro_in_ruleModule255 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_CRNL_in_ruleModule286 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_19_in_ruleModule299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifier352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_ruleObjectIdentifier392 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifier408 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleObjectIdentifier425 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleObjectIdentifier437 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleObjectIdentifier449 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_ruleObjectIdentifier470 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleObjectIdentifier482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifierValue532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue575 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleObjectIdentifierValue618 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleObjectIdentifierValue637 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleObjectIdentifierValue659 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition701 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDefinition711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_ruleTypeDefinition747 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeDefinition763 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeDefinition780 = new BitSet(new long[]{0x0000004E08100310L});
    public static final BitSet FOLLOW_ruleScope_in_ruleTypeDefinition801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_entryRuleMacro837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacro847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_ruleMacro883 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleMacro899 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleMacro916 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMacro928 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_CRNL_in_ruleMacro939 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleMacro950 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_CRNL_in_ruleMacro961 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleMacro972 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMacro984 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_ruleMacro1005 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_RULE_CRNL_in_ruleMacro1017 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleMacro1028 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleMacro1040 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleMacro1061 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleMacro1082 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_19_in_ruleMacro1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment1131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAssignment1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleTypeAssignment1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeAssignment1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment1250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamAssignment1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PARAMETER_in_ruleParamAssignment1302 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_ruleParamAssignment1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation1364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotation1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeNotation1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleTypeNotation1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt1483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReferenceExt1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1539 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleTypeReference_in_ruleTypeReferenceExt1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_entryRuleTypeReference1607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReference1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleTypeReference1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScope_in_entryRuleScope1696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScope1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleScope1752 = new BitSet(new long[]{0x0000004E08100330L});
    public static final BitSet FOLLOW_RULE_CRNL_in_ruleScope1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1799 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue1855 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleValue1868 = new BitSet(new long[]{0x0000004E08100310L});
    public static final BitSet FOLLOW_ruleValueType_in_ruleValue1889 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType1927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_ruleValueType1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_ruleValueType2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_ruleValueType2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_ruleValueType2064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleValueType2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue2137 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleMacroValue2193 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleMacroValue2205 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_ruleMacroValue2226 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleMacroValue2238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE2274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_ruleMACRO_VALUE_TYPE2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_ruleMACRO_VALUE_TYPE2357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_entryRuleUpdateType2393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpdateType2403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleUpdateType2440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleUpdateType2460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP2497 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP2508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleMACRO_VALUE_CAP2546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleMACRO_VALUE_CAP2565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE2605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_ruleASN1_TYPE2662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_ruleASN1_TYPE2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE2724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleASN1_SIMPLE2781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_ruleASN1_SIMPLE2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_ruleASN1_SIMPLE2838 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_ruleASN1_SIMPLE2858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_ruleASN1_SIMPLE2889 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SIMPLE2909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING2947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING2957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleASN1_OCTET_STRING3003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER3039 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER3049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleASN1_INTEGER3086 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleASN1_INTEGER3098 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_ruleASN1_INTEGER3119 = new BitSet(new long[]{0x0000000010400040L});
    public static final BitSet FOLLOW_22_in_ruleASN1_INTEGER3132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE3168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleASN1_SUBTYPE3215 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleASN1_SUBTYPE3227 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleASN1_SUBTYPE3239 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3260 = new BitSet(new long[]{0x0000000024000000L});
    public static final BitSet FOLLOW_26_in_ruleASN1_SUBTYPE3273 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_ruleASN1_SUBTYPE3294 = new BitSet(new long[]{0x0000000024000000L});
    public static final BitSet FOLLOW_29_in_ruleASN1_SUBTYPE3308 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleASN1_SUBTYPE3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE3356 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE3366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_RANGE3418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_RANGE3448 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleASN1_RANGE3465 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_RANGE3482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR3525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR3536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_VALUEPAIR3577 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleASN1_VALUEPAIR3597 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleASN1_VALUEPAIR3612 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleASN1_VALUEPAIR3630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE3670 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE3680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleASN1_CHOICE3717 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleASN1_CHOICE3729 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3750 = new BitSet(new long[]{0x0000008000400000L});
    public static final BitSet FOLLOW_39_in_ruleASN1_CHOICE3763 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_ruleASN1_CHOICE3784 = new BitSet(new long[]{0x0000008000400000L});
    public static final BitSet FOLLOW_22_in_ruleASN1_CHOICE3798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY3834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY3844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY3886 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_ruleASN1_CHOICE_ENTRY3911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_synpred1_InternalSmi601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_synpred2_InternalSmi1553 = new BitSet(new long[]{0x0000000000000002L});

}