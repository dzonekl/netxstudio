package com.netxforge.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import com.netxforge.services.SmiGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSmiParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_MODULE_ID", "RULE_ANY_OTHER", "RULE_IA5STRING", "RULE_ID", "RULE_INT", "RULE_ASN1_ID", "RULE_NUMERIC", "RULE_ALPHA", "RULE_ALPHA_CAP", "RULE_SL_ASN1_COMMENT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'VALUE'", "'Update'", "'DEFINITIONS'", "'::='", "'BEGIN'", "'END'", "'MACRO'", "'TYPE NOTATION'", "'VALUE NOTATION'", "'value('", "')'", "'|'", "'('", "'OCTET STRING'", "'TODO defintions.'", "'INTEGER'", "'{'", "'}'", "'CHOICE'", "','", "'SIZE'", "'..'", "'OBJECT IDENTIFIER'"
    };
    public static final int RULE_ID=7;
    public static final int T__40=40;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_ALPHA_CAP=12;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int RULE_IA5STRING=6;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=5;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_ASN1_ID=9;
    public static final int RULE_ALPHA=11;
    public static final int RULE_SL_COMMENT=16;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=15;
    public static final int RULE_MODULE_ID=4;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=14;
    public static final int T__32=32;
    public static final int RULE_NUMERIC=10;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_INT=8;
    public static final int RULE_WS=17;
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
    public String getGrammarFileName() { return "../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g"; }


     
     	private SmiGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(SmiGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModule"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:60:1: entryRuleModule : ruleModule EOF ;
    public final void entryRuleModule() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:61:1: ( ruleModule EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:62:1: ruleModule EOF
            {
             before(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule61);
            ruleModule();

            state._fsp--;

             after(grammarAccess.getModuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:69:1: ruleModule : ( ( rule__Module__Group__0 ) ) ;
    public final void ruleModule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:73:2: ( ( ( rule__Module__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:74:1: ( ( rule__Module__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:74:1: ( ( rule__Module__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:75:1: ( rule__Module__Group__0 )
            {
             before(grammarAccess.getModuleAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:76:1: ( rule__Module__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:76:2: rule__Module__Group__0
            {
            pushFollow(FOLLOW_rule__Module__Group__0_in_ruleModule94);
            rule__Module__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:88:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:89:1: ( ruleAssignment EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:90:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment121);
            ruleAssignment();

            state._fsp--;

             after(grammarAccess.getAssignmentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:97:1: ruleAssignment : ( ( rule__Assignment__Alternatives ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:101:2: ( ( ( rule__Assignment__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:102:1: ( ( rule__Assignment__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:102:1: ( ( rule__Assignment__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:103:1: ( rule__Assignment__Alternatives )
            {
             before(grammarAccess.getAssignmentAccess().getAlternatives()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:104:1: ( rule__Assignment__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:104:2: rule__Assignment__Alternatives
            {
            pushFollow(FOLLOW_rule__Assignment__Alternatives_in_ruleAssignment154);
            rule__Assignment__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleMacro"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:116:1: entryRuleMacro : ruleMacro EOF ;
    public final void entryRuleMacro() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:117:1: ( ruleMacro EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:118:1: ruleMacro EOF
            {
             before(grammarAccess.getMacroRule()); 
            pushFollow(FOLLOW_ruleMacro_in_entryRuleMacro181);
            ruleMacro();

            state._fsp--;

             after(grammarAccess.getMacroRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacro188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMacro"


    // $ANTLR start "ruleMacro"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:125:1: ruleMacro : ( ( rule__Macro__Group__0 ) ) ;
    public final void ruleMacro() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:129:2: ( ( ( rule__Macro__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:130:1: ( ( rule__Macro__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:130:1: ( ( rule__Macro__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:131:1: ( rule__Macro__Group__0 )
            {
             before(grammarAccess.getMacroAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:132:1: ( rule__Macro__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:132:2: rule__Macro__Group__0
            {
            pushFollow(FOLLOW_rule__Macro__Group__0_in_ruleMacro214);
            rule__Macro__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMacroAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMacro"


    // $ANTLR start "entryRuleMacroDescriptor"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:144:1: entryRuleMacroDescriptor : ruleMacroDescriptor EOF ;
    public final void entryRuleMacroDescriptor() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:145:1: ( ruleMacroDescriptor EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:146:1: ruleMacroDescriptor EOF
            {
             before(grammarAccess.getMacroDescriptorRule()); 
            pushFollow(FOLLOW_ruleMacroDescriptor_in_entryRuleMacroDescriptor241);
            ruleMacroDescriptor();

            state._fsp--;

             after(grammarAccess.getMacroDescriptorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroDescriptor248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMacroDescriptor"


    // $ANTLR start "ruleMacroDescriptor"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:153:1: ruleMacroDescriptor : ( RULE_MODULE_ID ) ;
    public final void ruleMacroDescriptor() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:157:2: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:158:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:158:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:159:1: RULE_MODULE_ID
            {
             before(grammarAccess.getMacroDescriptorAccess().getMODULE_IDTerminalRuleCall()); 
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_ruleMacroDescriptor274); 
             after(grammarAccess.getMacroDescriptorAccess().getMODULE_IDTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMacroDescriptor"


    // $ANTLR start "entryRuleMacroValue"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:172:1: entryRuleMacroValue : ruleMacroValue EOF ;
    public final void entryRuleMacroValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:173:1: ( ruleMacroValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:174:1: ruleMacroValue EOF
            {
             before(grammarAccess.getMacroValueRule()); 
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue300);
            ruleMacroValue();

            state._fsp--;

             after(grammarAccess.getMacroValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue307); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMacroValue"


    // $ANTLR start "ruleMacroValue"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:181:1: ruleMacroValue : ( ( rule__MacroValue__Group__0 ) ) ;
    public final void ruleMacroValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:185:2: ( ( ( rule__MacroValue__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:186:1: ( ( rule__MacroValue__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:186:1: ( ( rule__MacroValue__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:187:1: ( rule__MacroValue__Group__0 )
            {
             before(grammarAccess.getMacroValueAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:188:1: ( rule__MacroValue__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:188:2: rule__MacroValue__Group__0
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__0_in_ruleMacroValue333);
            rule__MacroValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMacroValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMacroValue"


    // $ANTLR start "entryRuleValueAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:200:1: entryRuleValueAssignment : ruleValueAssignment EOF ;
    public final void entryRuleValueAssignment() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:201:1: ( ruleValueAssignment EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:202:1: ruleValueAssignment EOF
            {
             before(grammarAccess.getValueAssignmentRule()); 
            pushFollow(FOLLOW_ruleValueAssignment_in_entryRuleValueAssignment360);
            ruleValueAssignment();

            state._fsp--;

             after(grammarAccess.getValueAssignmentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueAssignment367); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValueAssignment"


    // $ANTLR start "ruleValueAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:209:1: ruleValueAssignment : ( ( rule__ValueAssignment__Group__0 ) ) ;
    public final void ruleValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:213:2: ( ( ( rule__ValueAssignment__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:214:1: ( ( rule__ValueAssignment__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:214:1: ( ( rule__ValueAssignment__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:215:1: ( rule__ValueAssignment__Group__0 )
            {
             before(grammarAccess.getValueAssignmentAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:216:1: ( rule__ValueAssignment__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:216:2: rule__ValueAssignment__Group__0
            {
            pushFollow(FOLLOW_rule__ValueAssignment__Group__0_in_ruleValueAssignment393);
            rule__ValueAssignment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValueAssignmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueAssignment"


    // $ANTLR start "entryRuleOr"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:228:1: entryRuleOr : ruleOr EOF ;
    public final void entryRuleOr() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:229:1: ( ruleOr EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:230:1: ruleOr EOF
            {
             before(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_ruleOr_in_entryRuleOr420);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getOrRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOr427); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:237:1: ruleOr : ( ( rule__Or__Group__0 ) ) ;
    public final void ruleOr() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:241:2: ( ( ( rule__Or__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:242:1: ( ( rule__Or__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:242:1: ( ( rule__Or__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:243:1: ( rule__Or__Group__0 )
            {
             before(grammarAccess.getOrAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:244:1: ( rule__Or__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:244:2: rule__Or__Group__0
            {
            pushFollow(FOLLOW_rule__Or__Group__0_in_ruleOr453);
            rule__Or__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleValueType"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:256:1: entryRuleValueType : ruleValueType EOF ;
    public final void entryRuleValueType() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:257:1: ( ruleValueType EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:258:1: ruleValueType EOF
            {
             before(grammarAccess.getValueTypeRule()); 
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType480);
            ruleValueType();

            state._fsp--;

             after(grammarAccess.getValueTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType487); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValueType"


    // $ANTLR start "ruleValueType"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:265:1: ruleValueType : ( ( rule__ValueType__Group__0 ) ) ;
    public final void ruleValueType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:269:2: ( ( ( rule__ValueType__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:270:1: ( ( rule__ValueType__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:270:1: ( ( rule__ValueType__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:271:1: ( rule__ValueType__Group__0 )
            {
             before(grammarAccess.getValueTypeAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:272:1: ( rule__ValueType__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:272:2: rule__ValueType__Group__0
            {
            pushFollow(FOLLOW_rule__ValueType__Group__0_in_ruleValueType513);
            rule__ValueType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValueTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueType"


    // $ANTLR start "entryRuleASN1_TYPE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:284:1: entryRuleASN1_TYPE : ruleASN1_TYPE EOF ;
    public final void entryRuleASN1_TYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:285:1: ( ruleASN1_TYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:286:1: ruleASN1_TYPE EOF
            {
             before(grammarAccess.getASN1_TYPERule()); 
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE540);
            ruleASN1_TYPE();

            state._fsp--;

             after(grammarAccess.getASN1_TYPERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE547); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleASN1_TYPE"


    // $ANTLR start "ruleASN1_TYPE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:293:1: ruleASN1_TYPE : ( ( rule__ASN1_TYPE__Alternatives ) ) ;
    public final void ruleASN1_TYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:297:2: ( ( ( rule__ASN1_TYPE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:298:1: ( ( rule__ASN1_TYPE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:298:1: ( ( rule__ASN1_TYPE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:299:1: ( rule__ASN1_TYPE__Alternatives )
            {
             before(grammarAccess.getASN1_TYPEAccess().getAlternatives()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:300:1: ( rule__ASN1_TYPE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:300:2: rule__ASN1_TYPE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_TYPE__Alternatives_in_ruleASN1_TYPE573);
            rule__ASN1_TYPE__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getASN1_TYPEAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleASN1_TYPE"


    // $ANTLR start "entryRuleASN1_SIMPLE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:312:1: entryRuleASN1_SIMPLE : ruleASN1_SIMPLE EOF ;
    public final void entryRuleASN1_SIMPLE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:313:1: ( ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:314:1: ruleASN1_SIMPLE EOF
            {
             before(grammarAccess.getASN1_SIMPLERule()); 
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE600);
            ruleASN1_SIMPLE();

            state._fsp--;

             after(grammarAccess.getASN1_SIMPLERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE607); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleASN1_SIMPLE"


    // $ANTLR start "ruleASN1_SIMPLE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:321:1: ruleASN1_SIMPLE : ( ( rule__ASN1_SIMPLE__Alternatives ) ) ;
    public final void ruleASN1_SIMPLE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:325:2: ( ( ( rule__ASN1_SIMPLE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:326:1: ( ( rule__ASN1_SIMPLE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:326:1: ( ( rule__ASN1_SIMPLE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:327:1: ( rule__ASN1_SIMPLE__Alternatives )
            {
             before(grammarAccess.getASN1_SIMPLEAccess().getAlternatives()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:328:1: ( rule__ASN1_SIMPLE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:328:2: rule__ASN1_SIMPLE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Alternatives_in_ruleASN1_SIMPLE633);
            rule__ASN1_SIMPLE__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getASN1_SIMPLEAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleASN1_SIMPLE"


    // $ANTLR start "entryRuleASN1_OCTET_STRING"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:340:1: entryRuleASN1_OCTET_STRING : ruleASN1_OCTET_STRING EOF ;
    public final void entryRuleASN1_OCTET_STRING() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:341:1: ( ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:342:1: ruleASN1_OCTET_STRING EOF
            {
             before(grammarAccess.getASN1_OCTET_STRINGRule()); 
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING660);
            ruleASN1_OCTET_STRING();

            state._fsp--;

             after(grammarAccess.getASN1_OCTET_STRINGRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING667); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleASN1_OCTET_STRING"


    // $ANTLR start "ruleASN1_OCTET_STRING"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:349:1: ruleASN1_OCTET_STRING : ( ( rule__ASN1_OCTET_STRING__Group__0 ) ) ;
    public final void ruleASN1_OCTET_STRING() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:353:2: ( ( ( rule__ASN1_OCTET_STRING__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:354:1: ( ( rule__ASN1_OCTET_STRING__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:354:1: ( ( rule__ASN1_OCTET_STRING__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:355:1: ( rule__ASN1_OCTET_STRING__Group__0 )
            {
             before(grammarAccess.getASN1_OCTET_STRINGAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:356:1: ( rule__ASN1_OCTET_STRING__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:356:2: rule__ASN1_OCTET_STRING__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__0_in_ruleASN1_OCTET_STRING693);
            rule__ASN1_OCTET_STRING__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getASN1_OCTET_STRINGAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleASN1_OCTET_STRING"


    // $ANTLR start "entryRuleASN1_INTEGER"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:368:1: entryRuleASN1_INTEGER : ruleASN1_INTEGER EOF ;
    public final void entryRuleASN1_INTEGER() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:369:1: ( ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:370:1: ruleASN1_INTEGER EOF
            {
             before(grammarAccess.getASN1_INTEGERRule()); 
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER720);
            ruleASN1_INTEGER();

            state._fsp--;

             after(grammarAccess.getASN1_INTEGERRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER727); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleASN1_INTEGER"


    // $ANTLR start "ruleASN1_INTEGER"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:377:1: ruleASN1_INTEGER : ( ( rule__ASN1_INTEGER__Group__0 ) ) ;
    public final void ruleASN1_INTEGER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:381:2: ( ( ( rule__ASN1_INTEGER__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:382:1: ( ( rule__ASN1_INTEGER__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:382:1: ( ( rule__ASN1_INTEGER__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:383:1: ( rule__ASN1_INTEGER__Group__0 )
            {
             before(grammarAccess.getASN1_INTEGERAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:384:1: ( rule__ASN1_INTEGER__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:384:2: rule__ASN1_INTEGER__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__0_in_ruleASN1_INTEGER753);
            rule__ASN1_INTEGER__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getASN1_INTEGERAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleASN1_INTEGER"


    // $ANTLR start "entryRuleASN1_VALUEPAIR"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:396:1: entryRuleASN1_VALUEPAIR : ruleASN1_VALUEPAIR EOF ;
    public final void entryRuleASN1_VALUEPAIR() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:397:1: ( ruleASN1_VALUEPAIR EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:398:1: ruleASN1_VALUEPAIR EOF
            {
             before(grammarAccess.getASN1_VALUEPAIRRule()); 
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR780);
            ruleASN1_VALUEPAIR();

            state._fsp--;

             after(grammarAccess.getASN1_VALUEPAIRRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR787); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleASN1_VALUEPAIR"


    // $ANTLR start "ruleASN1_VALUEPAIR"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:405:1: ruleASN1_VALUEPAIR : ( ( rule__ASN1_VALUEPAIR__Group__0 ) ) ;
    public final void ruleASN1_VALUEPAIR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:409:2: ( ( ( rule__ASN1_VALUEPAIR__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:410:1: ( ( rule__ASN1_VALUEPAIR__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:410:1: ( ( rule__ASN1_VALUEPAIR__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:411:1: ( rule__ASN1_VALUEPAIR__Group__0 )
            {
             before(grammarAccess.getASN1_VALUEPAIRAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:412:1: ( rule__ASN1_VALUEPAIR__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:412:2: rule__ASN1_VALUEPAIR__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__0_in_ruleASN1_VALUEPAIR813);
            rule__ASN1_VALUEPAIR__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getASN1_VALUEPAIRAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleASN1_VALUEPAIR"


    // $ANTLR start "entryRuleASN1_CHOICE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:424:1: entryRuleASN1_CHOICE : ruleASN1_CHOICE EOF ;
    public final void entryRuleASN1_CHOICE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:425:1: ( ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:426:1: ruleASN1_CHOICE EOF
            {
             before(grammarAccess.getASN1_CHOICERule()); 
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE840);
            ruleASN1_CHOICE();

            state._fsp--;

             after(grammarAccess.getASN1_CHOICERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE847); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleASN1_CHOICE"


    // $ANTLR start "ruleASN1_CHOICE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:433:1: ruleASN1_CHOICE : ( ( rule__ASN1_CHOICE__Group__0 ) ) ;
    public final void ruleASN1_CHOICE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:437:2: ( ( ( rule__ASN1_CHOICE__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:438:1: ( ( rule__ASN1_CHOICE__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:438:1: ( ( rule__ASN1_CHOICE__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:439:1: ( rule__ASN1_CHOICE__Group__0 )
            {
             before(grammarAccess.getASN1_CHOICEAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:440:1: ( rule__ASN1_CHOICE__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:440:2: rule__ASN1_CHOICE__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__0_in_ruleASN1_CHOICE873);
            rule__ASN1_CHOICE__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getASN1_CHOICEAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleASN1_CHOICE"


    // $ANTLR start "entryRuleASN1_CHOICE_ENTRY"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:452:1: entryRuleASN1_CHOICE_ENTRY : ruleASN1_CHOICE_ENTRY EOF ;
    public final void entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:453:1: ( ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:454:1: ruleASN1_CHOICE_ENTRY EOF
            {
             before(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY900);
            ruleASN1_CHOICE_ENTRY();

            state._fsp--;

             after(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY907); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleASN1_CHOICE_ENTRY"


    // $ANTLR start "ruleASN1_CHOICE_ENTRY"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:461:1: ruleASN1_CHOICE_ENTRY : ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) ) ;
    public final void ruleASN1_CHOICE_ENTRY() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:465:2: ( ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:466:1: ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:466:1: ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:467:1: ( rule__ASN1_CHOICE_ENTRY__Group__0 )
            {
             before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:468:1: ( rule__ASN1_CHOICE_ENTRY__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:468:2: rule__ASN1_CHOICE_ENTRY__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0_in_ruleASN1_CHOICE_ENTRY933);
            rule__ASN1_CHOICE_ENTRY__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleASN1_CHOICE_ENTRY"


    // $ANTLR start "entryRuleASN1_SUBTYPE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:480:1: entryRuleASN1_SUBTYPE : ruleASN1_SUBTYPE EOF ;
    public final void entryRuleASN1_SUBTYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:481:1: ( ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:482:1: ruleASN1_SUBTYPE EOF
            {
             before(grammarAccess.getASN1_SUBTYPERule()); 
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE960);
            ruleASN1_SUBTYPE();

            state._fsp--;

             after(grammarAccess.getASN1_SUBTYPERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE967); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleASN1_SUBTYPE"


    // $ANTLR start "ruleASN1_SUBTYPE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:489:1: ruleASN1_SUBTYPE : ( ( rule__ASN1_SUBTYPE__Alternatives ) ) ;
    public final void ruleASN1_SUBTYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:493:2: ( ( ( rule__ASN1_SUBTYPE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:494:1: ( ( rule__ASN1_SUBTYPE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:494:1: ( ( rule__ASN1_SUBTYPE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:495:1: ( rule__ASN1_SUBTYPE__Alternatives )
            {
             before(grammarAccess.getASN1_SUBTYPEAccess().getAlternatives()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:496:1: ( rule__ASN1_SUBTYPE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:496:2: rule__ASN1_SUBTYPE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Alternatives_in_ruleASN1_SUBTYPE993);
            rule__ASN1_SUBTYPE__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getASN1_SUBTYPEAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleASN1_SUBTYPE"


    // $ANTLR start "entryRuleASN1_RANGE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:508:1: entryRuleASN1_RANGE : ruleASN1_RANGE EOF ;
    public final void entryRuleASN1_RANGE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:509:1: ( ruleASN1_RANGE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:510:1: ruleASN1_RANGE EOF
            {
             before(grammarAccess.getASN1_RANGERule()); 
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE1020);
            ruleASN1_RANGE();

            state._fsp--;

             after(grammarAccess.getASN1_RANGERule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE1027); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleASN1_RANGE"


    // $ANTLR start "ruleASN1_RANGE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:517:1: ruleASN1_RANGE : ( ( rule__ASN1_RANGE__Group__0 ) ) ;
    public final void ruleASN1_RANGE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:521:2: ( ( ( rule__ASN1_RANGE__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:522:1: ( ( rule__ASN1_RANGE__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:522:1: ( ( rule__ASN1_RANGE__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:523:1: ( rule__ASN1_RANGE__Group__0 )
            {
             before(grammarAccess.getASN1_RANGEAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:524:1: ( rule__ASN1_RANGE__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:524:2: rule__ASN1_RANGE__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group__0_in_ruleASN1_RANGE1053);
            rule__ASN1_RANGE__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getASN1_RANGEAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleASN1_RANGE"


    // $ANTLR start "entryRuleObjectIdentifier"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:536:1: entryRuleObjectIdentifier : ruleObjectIdentifier EOF ;
    public final void entryRuleObjectIdentifier() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:537:1: ( ruleObjectIdentifier EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:538:1: ruleObjectIdentifier EOF
            {
             before(grammarAccess.getObjectIdentifierRule()); 
            pushFollow(FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier1080);
            ruleObjectIdentifier();

            state._fsp--;

             after(grammarAccess.getObjectIdentifierRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifier1087); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObjectIdentifier"


    // $ANTLR start "ruleObjectIdentifier"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:545:1: ruleObjectIdentifier : ( ( rule__ObjectIdentifier__Group__0 ) ) ;
    public final void ruleObjectIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:549:2: ( ( ( rule__ObjectIdentifier__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:550:1: ( ( rule__ObjectIdentifier__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:550:1: ( ( rule__ObjectIdentifier__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:551:1: ( rule__ObjectIdentifier__Group__0 )
            {
             before(grammarAccess.getObjectIdentifierAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:552:1: ( rule__ObjectIdentifier__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:552:2: rule__ObjectIdentifier__Group__0
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__0_in_ruleObjectIdentifier1113);
            rule__ObjectIdentifier__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObjectIdentifierAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjectIdentifier"


    // $ANTLR start "entryRuleObjectIdentifierValue"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:564:1: entryRuleObjectIdentifierValue : ruleObjectIdentifierValue EOF ;
    public final void entryRuleObjectIdentifierValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:565:1: ( ruleObjectIdentifierValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:566:1: ruleObjectIdentifierValue EOF
            {
             before(grammarAccess.getObjectIdentifierValueRule()); 
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue1140);
            ruleObjectIdentifierValue();

            state._fsp--;

             after(grammarAccess.getObjectIdentifierValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifierValue1147); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObjectIdentifierValue"


    // $ANTLR start "ruleObjectIdentifierValue"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:573:1: ruleObjectIdentifierValue : ( ( rule__ObjectIdentifierValue__Group__0 ) ) ;
    public final void ruleObjectIdentifierValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:577:2: ( ( ( rule__ObjectIdentifierValue__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:578:1: ( ( rule__ObjectIdentifierValue__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:578:1: ( ( rule__ObjectIdentifierValue__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:579:1: ( rule__ObjectIdentifierValue__Group__0 )
            {
             before(grammarAccess.getObjectIdentifierValueAccess().getGroup()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:580:1: ( rule__ObjectIdentifierValue__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:580:2: rule__ObjectIdentifierValue__Group__0
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__0_in_ruleObjectIdentifierValue1173);
            rule__ObjectIdentifierValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObjectIdentifierValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjectIdentifierValue"


    // $ANTLR start "ruleMACRO_VALUE_TYPE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:593:1: ruleMACRO_VALUE_TYPE : ( ( rule__MACRO_VALUE_TYPE__Alternatives ) ) ;
    public final void ruleMACRO_VALUE_TYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:597:1: ( ( ( rule__MACRO_VALUE_TYPE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:598:1: ( ( rule__MACRO_VALUE_TYPE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:598:1: ( ( rule__MACRO_VALUE_TYPE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:599:1: ( rule__MACRO_VALUE_TYPE__Alternatives )
            {
             before(grammarAccess.getMACRO_VALUE_TYPEAccess().getAlternatives()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:600:1: ( rule__MACRO_VALUE_TYPE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:600:2: rule__MACRO_VALUE_TYPE__Alternatives
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__Alternatives_in_ruleMACRO_VALUE_TYPE1210);
            rule__MACRO_VALUE_TYPE__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMACRO_VALUE_TYPEAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMACRO_VALUE_TYPE"


    // $ANTLR start "rule__Assignment__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:613:1: rule__Assignment__Alternatives : ( ( ( rule__Assignment__MacrosAssignment_0 ) ) | ( ( rule__Assignment__TypesAssignment_1 ) ) | ( ruleObjectIdentifier ) );
    public final void rule__Assignment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:617:1: ( ( ( rule__Assignment__MacrosAssignment_0 ) ) | ( ( rule__Assignment__TypesAssignment_1 ) ) | ( ruleObjectIdentifier ) )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_MODULE_ID) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==21) ) {
                    alt1=2;
                }
                else if ( (LA1_1==24) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA1_0==RULE_ASN1_ID) ) {
                alt1=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:618:1: ( ( rule__Assignment__MacrosAssignment_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:618:1: ( ( rule__Assignment__MacrosAssignment_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:619:1: ( rule__Assignment__MacrosAssignment_0 )
                    {
                     before(grammarAccess.getAssignmentAccess().getMacrosAssignment_0()); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:620:1: ( rule__Assignment__MacrosAssignment_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:620:2: rule__Assignment__MacrosAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Assignment__MacrosAssignment_0_in_rule__Assignment__Alternatives1247);
                    rule__Assignment__MacrosAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAssignmentAccess().getMacrosAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:624:6: ( ( rule__Assignment__TypesAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:624:6: ( ( rule__Assignment__TypesAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:625:1: ( rule__Assignment__TypesAssignment_1 )
                    {
                     before(grammarAccess.getAssignmentAccess().getTypesAssignment_1()); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:626:1: ( rule__Assignment__TypesAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:626:2: rule__Assignment__TypesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Assignment__TypesAssignment_1_in_rule__Assignment__Alternatives1265);
                    rule__Assignment__TypesAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getAssignmentAccess().getTypesAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:630:6: ( ruleObjectIdentifier )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:630:6: ( ruleObjectIdentifier )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:631:1: ruleObjectIdentifier
                    {
                     before(grammarAccess.getAssignmentAccess().getObjectIdentifierParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleObjectIdentifier_in_rule__Assignment__Alternatives1283);
                    ruleObjectIdentifier();

                    state._fsp--;

                     after(grammarAccess.getAssignmentAccess().getObjectIdentifierParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Alternatives"


    // $ANTLR start "rule__ValueType__Alternatives_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:641:1: rule__ValueType__Alternatives_1 : ( ( ( rule__ValueType__TypeAssignment_1_0 ) ) | ( ( rule__ValueType__SimpleTypeAssignment_1_1 ) ) );
    public final void rule__ValueType__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:645:1: ( ( ( rule__ValueType__TypeAssignment_1_0 ) ) | ( ( rule__ValueType__SimpleTypeAssignment_1_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_IA5STRING||LA2_0==31||LA2_0==33||LA2_0==36) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:646:1: ( ( rule__ValueType__TypeAssignment_1_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:646:1: ( ( rule__ValueType__TypeAssignment_1_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:647:1: ( rule__ValueType__TypeAssignment_1_0 )
                    {
                     before(grammarAccess.getValueTypeAccess().getTypeAssignment_1_0()); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:648:1: ( rule__ValueType__TypeAssignment_1_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:648:2: rule__ValueType__TypeAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__ValueType__TypeAssignment_1_0_in_rule__ValueType__Alternatives_11315);
                    rule__ValueType__TypeAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueTypeAccess().getTypeAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:652:6: ( ( rule__ValueType__SimpleTypeAssignment_1_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:652:6: ( ( rule__ValueType__SimpleTypeAssignment_1_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:653:1: ( rule__ValueType__SimpleTypeAssignment_1_1 )
                    {
                     before(grammarAccess.getValueTypeAccess().getSimpleTypeAssignment_1_1()); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:654:1: ( rule__ValueType__SimpleTypeAssignment_1_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:654:2: rule__ValueType__SimpleTypeAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__ValueType__SimpleTypeAssignment_1_1_in_rule__ValueType__Alternatives_11333);
                    rule__ValueType__SimpleTypeAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getValueTypeAccess().getSimpleTypeAssignment_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Alternatives_1"


    // $ANTLR start "rule__ASN1_TYPE__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:663:1: rule__ASN1_TYPE__Alternatives : ( ( ruleASN1_SIMPLE ) | ( ruleASN1_CHOICE ) );
    public final void rule__ASN1_TYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:667:1: ( ( ruleASN1_SIMPLE ) | ( ruleASN1_CHOICE ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_IA5STRING||LA3_0==31||LA3_0==33) ) {
                alt3=1;
            }
            else if ( (LA3_0==36) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:668:1: ( ruleASN1_SIMPLE )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:668:1: ( ruleASN1_SIMPLE )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:669:1: ruleASN1_SIMPLE
                    {
                     before(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_rule__ASN1_TYPE__Alternatives1366);
                    ruleASN1_SIMPLE();

                    state._fsp--;

                     after(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:674:6: ( ruleASN1_CHOICE )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:674:6: ( ruleASN1_CHOICE )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:675:1: ruleASN1_CHOICE
                    {
                     before(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_rule__ASN1_TYPE__Alternatives1383);
                    ruleASN1_CHOICE();

                    state._fsp--;

                     after(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_TYPE__Alternatives"


    // $ANTLR start "rule__ASN1_SIMPLE__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:685:1: rule__ASN1_SIMPLE__Alternatives : ( ( ( rule__ASN1_SIMPLE__Group_0__0 ) ) | ( ruleASN1_OCTET_STRING ) | ( ( rule__ASN1_SIMPLE__Group_2__0 ) ) );
    public final void rule__ASN1_SIMPLE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:689:1: ( ( ( rule__ASN1_SIMPLE__Group_0__0 ) ) | ( ruleASN1_OCTET_STRING ) | ( ( rule__ASN1_SIMPLE__Group_2__0 ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case RULE_IA5STRING:
                {
                alt4=1;
                }
                break;
            case 31:
                {
                alt4=2;
                }
                break;
            case 33:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:690:1: ( ( rule__ASN1_SIMPLE__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:690:1: ( ( rule__ASN1_SIMPLE__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:691:1: ( rule__ASN1_SIMPLE__Group_0__0 )
                    {
                     before(grammarAccess.getASN1_SIMPLEAccess().getGroup_0()); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:692:1: ( rule__ASN1_SIMPLE__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:692:2: rule__ASN1_SIMPLE__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__0_in_rule__ASN1_SIMPLE__Alternatives1415);
                    rule__ASN1_SIMPLE__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getASN1_SIMPLEAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:696:6: ( ruleASN1_OCTET_STRING )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:696:6: ( ruleASN1_OCTET_STRING )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:697:1: ruleASN1_OCTET_STRING
                    {
                     before(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_rule__ASN1_SIMPLE__Alternatives1433);
                    ruleASN1_OCTET_STRING();

                    state._fsp--;

                     after(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:702:6: ( ( rule__ASN1_SIMPLE__Group_2__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:702:6: ( ( rule__ASN1_SIMPLE__Group_2__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:703:1: ( rule__ASN1_SIMPLE__Group_2__0 )
                    {
                     before(grammarAccess.getASN1_SIMPLEAccess().getGroup_2()); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:704:1: ( rule__ASN1_SIMPLE__Group_2__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:704:2: rule__ASN1_SIMPLE__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__0_in_rule__ASN1_SIMPLE__Alternatives1450);
                    rule__ASN1_SIMPLE__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getASN1_SIMPLEAccess().getGroup_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Alternatives"


    // $ANTLR start "rule__ASN1_SUBTYPE__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:713:1: rule__ASN1_SUBTYPE__Alternatives : ( ( ( rule__ASN1_SUBTYPE__Group_0__0 ) ) | ( ( rule__ASN1_SUBTYPE__ValueAssignment_1 ) ) );
    public final void rule__ASN1_SUBTYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:717:1: ( ( ( rule__ASN1_SUBTYPE__Group_0__0 ) ) | ( ( rule__ASN1_SUBTYPE__ValueAssignment_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==38) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_INT) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:718:1: ( ( rule__ASN1_SUBTYPE__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:718:1: ( ( rule__ASN1_SUBTYPE__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:719:1: ( rule__ASN1_SUBTYPE__Group_0__0 )
                    {
                     before(grammarAccess.getASN1_SUBTYPEAccess().getGroup_0()); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:720:1: ( rule__ASN1_SUBTYPE__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:720:2: rule__ASN1_SUBTYPE__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_0__0_in_rule__ASN1_SUBTYPE__Alternatives1483);
                    rule__ASN1_SUBTYPE__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getASN1_SUBTYPEAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:724:6: ( ( rule__ASN1_SUBTYPE__ValueAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:724:6: ( ( rule__ASN1_SUBTYPE__ValueAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:725:1: ( rule__ASN1_SUBTYPE__ValueAssignment_1 )
                    {
                     before(grammarAccess.getASN1_SUBTYPEAccess().getValueAssignment_1()); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:726:1: ( rule__ASN1_SUBTYPE__ValueAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:726:2: rule__ASN1_SUBTYPE__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ASN1_SUBTYPE__ValueAssignment_1_in_rule__ASN1_SUBTYPE__Alternatives1501);
                    rule__ASN1_SUBTYPE__ValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getASN1_SUBTYPEAccess().getValueAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SUBTYPE__Alternatives"


    // $ANTLR start "rule__MACRO_VALUE_TYPE__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:735:1: rule__MACRO_VALUE_TYPE__Alternatives : ( ( ( 'VALUE' ) ) | ( ( 'Update' ) ) );
    public final void rule__MACRO_VALUE_TYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:739:1: ( ( ( 'VALUE' ) ) | ( ( 'Update' ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            else if ( (LA6_0==19) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:740:1: ( ( 'VALUE' ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:740:1: ( ( 'VALUE' ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:741:1: ( 'VALUE' )
                    {
                     before(grammarAccess.getMACRO_VALUE_TYPEAccess().getVALUEEnumLiteralDeclaration_0()); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:742:1: ( 'VALUE' )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:742:3: 'VALUE'
                    {
                    match(input,18,FOLLOW_18_in_rule__MACRO_VALUE_TYPE__Alternatives1535); 

                    }

                     after(grammarAccess.getMACRO_VALUE_TYPEAccess().getVALUEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:747:6: ( ( 'Update' ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:747:6: ( ( 'Update' ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:748:1: ( 'Update' )
                    {
                     before(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateEnumLiteralDeclaration_1()); 
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:749:1: ( 'Update' )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:749:3: 'Update'
                    {
                    match(input,19,FOLLOW_19_in_rule__MACRO_VALUE_TYPE__Alternatives1556); 

                    }

                     after(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MACRO_VALUE_TYPE__Alternatives"


    // $ANTLR start "rule__Module__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:762:1: rule__Module__Group__0 : rule__Module__Group__0__Impl rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:766:1: ( rule__Module__Group__0__Impl rule__Module__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:767:2: rule__Module__Group__0__Impl rule__Module__Group__1
            {
            pushFollow(FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__01590);
            rule__Module__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group__1_in_rule__Module__Group__01593);
            rule__Module__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__0"


    // $ANTLR start "rule__Module__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:774:1: rule__Module__Group__0__Impl : ( ( rule__Module__IdAssignment_0 ) ) ;
    public final void rule__Module__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:778:1: ( ( ( rule__Module__IdAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:779:1: ( ( rule__Module__IdAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:779:1: ( ( rule__Module__IdAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:780:1: ( rule__Module__IdAssignment_0 )
            {
             before(grammarAccess.getModuleAccess().getIdAssignment_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:781:1: ( rule__Module__IdAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:781:2: rule__Module__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__Module__IdAssignment_0_in_rule__Module__Group__0__Impl1620);
            rule__Module__IdAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getIdAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__0__Impl"


    // $ANTLR start "rule__Module__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:791:1: rule__Module__Group__1 : rule__Module__Group__1__Impl rule__Module__Group__2 ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:795:1: ( rule__Module__Group__1__Impl rule__Module__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:796:2: rule__Module__Group__1__Impl rule__Module__Group__2
            {
            pushFollow(FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__11650);
            rule__Module__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group__2_in_rule__Module__Group__11653);
            rule__Module__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__1"


    // $ANTLR start "rule__Module__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:803:1: rule__Module__Group__1__Impl : ( 'DEFINITIONS' ) ;
    public final void rule__Module__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:807:1: ( ( 'DEFINITIONS' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:808:1: ( 'DEFINITIONS' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:808:1: ( 'DEFINITIONS' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:809:1: 'DEFINITIONS'
            {
             before(grammarAccess.getModuleAccess().getDEFINITIONSKeyword_1()); 
            match(input,20,FOLLOW_20_in_rule__Module__Group__1__Impl1681); 
             after(grammarAccess.getModuleAccess().getDEFINITIONSKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__1__Impl"


    // $ANTLR start "rule__Module__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:822:1: rule__Module__Group__2 : rule__Module__Group__2__Impl rule__Module__Group__3 ;
    public final void rule__Module__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:826:1: ( rule__Module__Group__2__Impl rule__Module__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:827:2: rule__Module__Group__2__Impl rule__Module__Group__3
            {
            pushFollow(FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__21712);
            rule__Module__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group__3_in_rule__Module__Group__21715);
            rule__Module__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__2"


    // $ANTLR start "rule__Module__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:834:1: rule__Module__Group__2__Impl : ( '::=' ) ;
    public final void rule__Module__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:838:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:839:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:839:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:840:1: '::='
            {
             before(grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__Module__Group__2__Impl1743); 
             after(grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__2__Impl"


    // $ANTLR start "rule__Module__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:853:1: rule__Module__Group__3 : rule__Module__Group__3__Impl rule__Module__Group__4 ;
    public final void rule__Module__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:857:1: ( rule__Module__Group__3__Impl rule__Module__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:858:2: rule__Module__Group__3__Impl rule__Module__Group__4
            {
            pushFollow(FOLLOW_rule__Module__Group__3__Impl_in_rule__Module__Group__31774);
            rule__Module__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group__4_in_rule__Module__Group__31777);
            rule__Module__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__3"


    // $ANTLR start "rule__Module__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:865:1: rule__Module__Group__3__Impl : ( 'BEGIN' ) ;
    public final void rule__Module__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:869:1: ( ( 'BEGIN' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:870:1: ( 'BEGIN' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:870:1: ( 'BEGIN' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:871:1: 'BEGIN'
            {
             before(grammarAccess.getModuleAccess().getBEGINKeyword_3()); 
            match(input,22,FOLLOW_22_in_rule__Module__Group__3__Impl1805); 
             after(grammarAccess.getModuleAccess().getBEGINKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__3__Impl"


    // $ANTLR start "rule__Module__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:884:1: rule__Module__Group__4 : rule__Module__Group__4__Impl rule__Module__Group__5 ;
    public final void rule__Module__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:888:1: ( rule__Module__Group__4__Impl rule__Module__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:889:2: rule__Module__Group__4__Impl rule__Module__Group__5
            {
            pushFollow(FOLLOW_rule__Module__Group__4__Impl_in_rule__Module__Group__41836);
            rule__Module__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group__5_in_rule__Module__Group__41839);
            rule__Module__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__4"


    // $ANTLR start "rule__Module__Group__4__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:896:1: rule__Module__Group__4__Impl : ( ( rule__Module__AssignmentsAssignment_4 )* ) ;
    public final void rule__Module__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:900:1: ( ( ( rule__Module__AssignmentsAssignment_4 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:901:1: ( ( rule__Module__AssignmentsAssignment_4 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:901:1: ( ( rule__Module__AssignmentsAssignment_4 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:902:1: ( rule__Module__AssignmentsAssignment_4 )*
            {
             before(grammarAccess.getModuleAccess().getAssignmentsAssignment_4()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:903:1: ( rule__Module__AssignmentsAssignment_4 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_MODULE_ID||LA7_0==RULE_ASN1_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:903:2: rule__Module__AssignmentsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Module__AssignmentsAssignment_4_in_rule__Module__Group__4__Impl1866);
            	    rule__Module__AssignmentsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getModuleAccess().getAssignmentsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__4__Impl"


    // $ANTLR start "rule__Module__Group__5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:913:1: rule__Module__Group__5 : rule__Module__Group__5__Impl ;
    public final void rule__Module__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:917:1: ( rule__Module__Group__5__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:918:2: rule__Module__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group__5__Impl_in_rule__Module__Group__51897);
            rule__Module__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__5"


    // $ANTLR start "rule__Module__Group__5__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:924:1: rule__Module__Group__5__Impl : ( 'END' ) ;
    public final void rule__Module__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:928:1: ( ( 'END' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:929:1: ( 'END' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:929:1: ( 'END' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:930:1: 'END'
            {
             before(grammarAccess.getModuleAccess().getENDKeyword_5()); 
            match(input,23,FOLLOW_23_in_rule__Module__Group__5__Impl1925); 
             after(grammarAccess.getModuleAccess().getENDKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__5__Impl"


    // $ANTLR start "rule__Macro__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:955:1: rule__Macro__Group__0 : rule__Macro__Group__0__Impl rule__Macro__Group__1 ;
    public final void rule__Macro__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:959:1: ( rule__Macro__Group__0__Impl rule__Macro__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:960:2: rule__Macro__Group__0__Impl rule__Macro__Group__1
            {
            pushFollow(FOLLOW_rule__Macro__Group__0__Impl_in_rule__Macro__Group__01968);
            rule__Macro__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Macro__Group__1_in_rule__Macro__Group__01971);
            rule__Macro__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__0"


    // $ANTLR start "rule__Macro__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:967:1: rule__Macro__Group__0__Impl : ( ( rule__Macro__DescriptorAssignment_0 ) ) ;
    public final void rule__Macro__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:971:1: ( ( ( rule__Macro__DescriptorAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:972:1: ( ( rule__Macro__DescriptorAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:972:1: ( ( rule__Macro__DescriptorAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:973:1: ( rule__Macro__DescriptorAssignment_0 )
            {
             before(grammarAccess.getMacroAccess().getDescriptorAssignment_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:974:1: ( rule__Macro__DescriptorAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:974:2: rule__Macro__DescriptorAssignment_0
            {
            pushFollow(FOLLOW_rule__Macro__DescriptorAssignment_0_in_rule__Macro__Group__0__Impl1998);
            rule__Macro__DescriptorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMacroAccess().getDescriptorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__0__Impl"


    // $ANTLR start "rule__Macro__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:984:1: rule__Macro__Group__1 : rule__Macro__Group__1__Impl rule__Macro__Group__2 ;
    public final void rule__Macro__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:988:1: ( rule__Macro__Group__1__Impl rule__Macro__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:989:2: rule__Macro__Group__1__Impl rule__Macro__Group__2
            {
            pushFollow(FOLLOW_rule__Macro__Group__1__Impl_in_rule__Macro__Group__12028);
            rule__Macro__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Macro__Group__2_in_rule__Macro__Group__12031);
            rule__Macro__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__1"


    // $ANTLR start "rule__Macro__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:996:1: rule__Macro__Group__1__Impl : ( 'MACRO' ) ;
    public final void rule__Macro__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1000:1: ( ( 'MACRO' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1001:1: ( 'MACRO' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1001:1: ( 'MACRO' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1002:1: 'MACRO'
            {
             before(grammarAccess.getMacroAccess().getMACROKeyword_1()); 
            match(input,24,FOLLOW_24_in_rule__Macro__Group__1__Impl2059); 
             after(grammarAccess.getMacroAccess().getMACROKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__1__Impl"


    // $ANTLR start "rule__Macro__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1015:1: rule__Macro__Group__2 : rule__Macro__Group__2__Impl rule__Macro__Group__3 ;
    public final void rule__Macro__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1019:1: ( rule__Macro__Group__2__Impl rule__Macro__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1020:2: rule__Macro__Group__2__Impl rule__Macro__Group__3
            {
            pushFollow(FOLLOW_rule__Macro__Group__2__Impl_in_rule__Macro__Group__22090);
            rule__Macro__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Macro__Group__3_in_rule__Macro__Group__22093);
            rule__Macro__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__2"


    // $ANTLR start "rule__Macro__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1027:1: rule__Macro__Group__2__Impl : ( '::=' ) ;
    public final void rule__Macro__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1031:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1032:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1032:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1033:1: '::='
            {
             before(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__Macro__Group__2__Impl2121); 
             after(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__2__Impl"


    // $ANTLR start "rule__Macro__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1046:1: rule__Macro__Group__3 : rule__Macro__Group__3__Impl rule__Macro__Group__4 ;
    public final void rule__Macro__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1050:1: ( rule__Macro__Group__3__Impl rule__Macro__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1051:2: rule__Macro__Group__3__Impl rule__Macro__Group__4
            {
            pushFollow(FOLLOW_rule__Macro__Group__3__Impl_in_rule__Macro__Group__32152);
            rule__Macro__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Macro__Group__4_in_rule__Macro__Group__32155);
            rule__Macro__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__3"


    // $ANTLR start "rule__Macro__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1058:1: rule__Macro__Group__3__Impl : ( 'BEGIN' ) ;
    public final void rule__Macro__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1062:1: ( ( 'BEGIN' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1063:1: ( 'BEGIN' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1063:1: ( 'BEGIN' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1064:1: 'BEGIN'
            {
             before(grammarAccess.getMacroAccess().getBEGINKeyword_3()); 
            match(input,22,FOLLOW_22_in_rule__Macro__Group__3__Impl2183); 
             after(grammarAccess.getMacroAccess().getBEGINKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__3__Impl"


    // $ANTLR start "rule__Macro__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1077:1: rule__Macro__Group__4 : rule__Macro__Group__4__Impl rule__Macro__Group__5 ;
    public final void rule__Macro__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1081:1: ( rule__Macro__Group__4__Impl rule__Macro__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1082:2: rule__Macro__Group__4__Impl rule__Macro__Group__5
            {
            pushFollow(FOLLOW_rule__Macro__Group__4__Impl_in_rule__Macro__Group__42214);
            rule__Macro__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Macro__Group__5_in_rule__Macro__Group__42217);
            rule__Macro__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__4"


    // $ANTLR start "rule__Macro__Group__4__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1089:1: rule__Macro__Group__4__Impl : ( 'TYPE NOTATION' ) ;
    public final void rule__Macro__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1093:1: ( ( 'TYPE NOTATION' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1094:1: ( 'TYPE NOTATION' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1094:1: ( 'TYPE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1095:1: 'TYPE NOTATION'
            {
             before(grammarAccess.getMacroAccess().getTYPENOTATIONKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__Macro__Group__4__Impl2245); 
             after(grammarAccess.getMacroAccess().getTYPENOTATIONKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__4__Impl"


    // $ANTLR start "rule__Macro__Group__5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1108:1: rule__Macro__Group__5 : rule__Macro__Group__5__Impl rule__Macro__Group__6 ;
    public final void rule__Macro__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1112:1: ( rule__Macro__Group__5__Impl rule__Macro__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1113:2: rule__Macro__Group__5__Impl rule__Macro__Group__6
            {
            pushFollow(FOLLOW_rule__Macro__Group__5__Impl_in_rule__Macro__Group__52276);
            rule__Macro__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Macro__Group__6_in_rule__Macro__Group__52279);
            rule__Macro__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__5"


    // $ANTLR start "rule__Macro__Group__5__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1120:1: rule__Macro__Group__5__Impl : ( ( ( rule__Macro__TypeNotationsAssignment_5 ) ) ( ( rule__Macro__TypeNotationsAssignment_5 )* ) ) ;
    public final void rule__Macro__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1124:1: ( ( ( ( rule__Macro__TypeNotationsAssignment_5 ) ) ( ( rule__Macro__TypeNotationsAssignment_5 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1125:1: ( ( ( rule__Macro__TypeNotationsAssignment_5 ) ) ( ( rule__Macro__TypeNotationsAssignment_5 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1125:1: ( ( ( rule__Macro__TypeNotationsAssignment_5 ) ) ( ( rule__Macro__TypeNotationsAssignment_5 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1126:1: ( ( rule__Macro__TypeNotationsAssignment_5 ) ) ( ( rule__Macro__TypeNotationsAssignment_5 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1126:1: ( ( rule__Macro__TypeNotationsAssignment_5 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1127:1: ( rule__Macro__TypeNotationsAssignment_5 )
            {
             before(grammarAccess.getMacroAccess().getTypeNotationsAssignment_5()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1128:1: ( rule__Macro__TypeNotationsAssignment_5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1128:2: rule__Macro__TypeNotationsAssignment_5
            {
            pushFollow(FOLLOW_rule__Macro__TypeNotationsAssignment_5_in_rule__Macro__Group__5__Impl2308);
            rule__Macro__TypeNotationsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getMacroAccess().getTypeNotationsAssignment_5()); 

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1131:1: ( ( rule__Macro__TypeNotationsAssignment_5 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1132:1: ( rule__Macro__TypeNotationsAssignment_5 )*
            {
             before(grammarAccess.getMacroAccess().getTypeNotationsAssignment_5()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1133:1: ( rule__Macro__TypeNotationsAssignment_5 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1133:2: rule__Macro__TypeNotationsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__Macro__TypeNotationsAssignment_5_in_rule__Macro__Group__5__Impl2320);
            	    rule__Macro__TypeNotationsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getMacroAccess().getTypeNotationsAssignment_5()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__5__Impl"


    // $ANTLR start "rule__Macro__Group__6"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1144:1: rule__Macro__Group__6 : rule__Macro__Group__6__Impl rule__Macro__Group__7 ;
    public final void rule__Macro__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1148:1: ( rule__Macro__Group__6__Impl rule__Macro__Group__7 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1149:2: rule__Macro__Group__6__Impl rule__Macro__Group__7
            {
            pushFollow(FOLLOW_rule__Macro__Group__6__Impl_in_rule__Macro__Group__62353);
            rule__Macro__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Macro__Group__7_in_rule__Macro__Group__62356);
            rule__Macro__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__6"


    // $ANTLR start "rule__Macro__Group__6__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1156:1: rule__Macro__Group__6__Impl : ( 'VALUE NOTATION' ) ;
    public final void rule__Macro__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1160:1: ( ( 'VALUE NOTATION' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1161:1: ( 'VALUE NOTATION' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1161:1: ( 'VALUE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1162:1: 'VALUE NOTATION'
            {
             before(grammarAccess.getMacroAccess().getVALUENOTATIONKeyword_6()); 
            match(input,26,FOLLOW_26_in_rule__Macro__Group__6__Impl2384); 
             after(grammarAccess.getMacroAccess().getVALUENOTATIONKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__6__Impl"


    // $ANTLR start "rule__Macro__Group__7"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1175:1: rule__Macro__Group__7 : rule__Macro__Group__7__Impl rule__Macro__Group__8 ;
    public final void rule__Macro__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1179:1: ( rule__Macro__Group__7__Impl rule__Macro__Group__8 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1180:2: rule__Macro__Group__7__Impl rule__Macro__Group__8
            {
            pushFollow(FOLLOW_rule__Macro__Group__7__Impl_in_rule__Macro__Group__72415);
            rule__Macro__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Macro__Group__8_in_rule__Macro__Group__72418);
            rule__Macro__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__7"


    // $ANTLR start "rule__Macro__Group__7__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1187:1: rule__Macro__Group__7__Impl : ( ( rule__Macro__ValueNotationAssignment_7 ) ) ;
    public final void rule__Macro__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1191:1: ( ( ( rule__Macro__ValueNotationAssignment_7 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1192:1: ( ( rule__Macro__ValueNotationAssignment_7 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1192:1: ( ( rule__Macro__ValueNotationAssignment_7 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1193:1: ( rule__Macro__ValueNotationAssignment_7 )
            {
             before(grammarAccess.getMacroAccess().getValueNotationAssignment_7()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1194:1: ( rule__Macro__ValueNotationAssignment_7 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1194:2: rule__Macro__ValueNotationAssignment_7
            {
            pushFollow(FOLLOW_rule__Macro__ValueNotationAssignment_7_in_rule__Macro__Group__7__Impl2445);
            rule__Macro__ValueNotationAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getMacroAccess().getValueNotationAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__7__Impl"


    // $ANTLR start "rule__Macro__Group__8"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1204:1: rule__Macro__Group__8 : rule__Macro__Group__8__Impl rule__Macro__Group__9 ;
    public final void rule__Macro__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1208:1: ( rule__Macro__Group__8__Impl rule__Macro__Group__9 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1209:2: rule__Macro__Group__8__Impl rule__Macro__Group__9
            {
            pushFollow(FOLLOW_rule__Macro__Group__8__Impl_in_rule__Macro__Group__82475);
            rule__Macro__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Macro__Group__9_in_rule__Macro__Group__82478);
            rule__Macro__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__8"


    // $ANTLR start "rule__Macro__Group__8__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1216:1: rule__Macro__Group__8__Impl : ( ( ( rule__Macro__InnerTypesAssignment_8 ) ) ( ( rule__Macro__InnerTypesAssignment_8 )* ) ) ;
    public final void rule__Macro__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1220:1: ( ( ( ( rule__Macro__InnerTypesAssignment_8 ) ) ( ( rule__Macro__InnerTypesAssignment_8 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1221:1: ( ( ( rule__Macro__InnerTypesAssignment_8 ) ) ( ( rule__Macro__InnerTypesAssignment_8 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1221:1: ( ( ( rule__Macro__InnerTypesAssignment_8 ) ) ( ( rule__Macro__InnerTypesAssignment_8 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1222:1: ( ( rule__Macro__InnerTypesAssignment_8 ) ) ( ( rule__Macro__InnerTypesAssignment_8 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1222:1: ( ( rule__Macro__InnerTypesAssignment_8 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1223:1: ( rule__Macro__InnerTypesAssignment_8 )
            {
             before(grammarAccess.getMacroAccess().getInnerTypesAssignment_8()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1224:1: ( rule__Macro__InnerTypesAssignment_8 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1224:2: rule__Macro__InnerTypesAssignment_8
            {
            pushFollow(FOLLOW_rule__Macro__InnerTypesAssignment_8_in_rule__Macro__Group__8__Impl2507);
            rule__Macro__InnerTypesAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getMacroAccess().getInnerTypesAssignment_8()); 

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1227:1: ( ( rule__Macro__InnerTypesAssignment_8 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1228:1: ( rule__Macro__InnerTypesAssignment_8 )*
            {
             before(grammarAccess.getMacroAccess().getInnerTypesAssignment_8()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1229:1: ( rule__Macro__InnerTypesAssignment_8 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_MODULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1229:2: rule__Macro__InnerTypesAssignment_8
            	    {
            	    pushFollow(FOLLOW_rule__Macro__InnerTypesAssignment_8_in_rule__Macro__Group__8__Impl2519);
            	    rule__Macro__InnerTypesAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getMacroAccess().getInnerTypesAssignment_8()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__8__Impl"


    // $ANTLR start "rule__Macro__Group__9"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1240:1: rule__Macro__Group__9 : rule__Macro__Group__9__Impl ;
    public final void rule__Macro__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1244:1: ( rule__Macro__Group__9__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1245:2: rule__Macro__Group__9__Impl
            {
            pushFollow(FOLLOW_rule__Macro__Group__9__Impl_in_rule__Macro__Group__92552);
            rule__Macro__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__9"


    // $ANTLR start "rule__Macro__Group__9__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1251:1: rule__Macro__Group__9__Impl : ( 'END' ) ;
    public final void rule__Macro__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1255:1: ( ( 'END' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1256:1: ( 'END' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1256:1: ( 'END' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1257:1: 'END'
            {
             before(grammarAccess.getMacroAccess().getENDKeyword_9()); 
            match(input,23,FOLLOW_23_in_rule__Macro__Group__9__Impl2580); 
             after(grammarAccess.getMacroAccess().getENDKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__9__Impl"


    // $ANTLR start "rule__MacroValue__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1290:1: rule__MacroValue__Group__0 : rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1 ;
    public final void rule__MacroValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1294:1: ( rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1295:2: rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__0__Impl_in_rule__MacroValue__Group__02631);
            rule__MacroValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MacroValue__Group__1_in_rule__MacroValue__Group__02634);
            rule__MacroValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MacroValue__Group__0"


    // $ANTLR start "rule__MacroValue__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1302:1: rule__MacroValue__Group__0__Impl : ( () ) ;
    public final void rule__MacroValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1306:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1307:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1307:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1308:1: ()
            {
             before(grammarAccess.getMacroValueAccess().getMacroValueAction_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1309:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1311:1: 
            {
            }

             after(grammarAccess.getMacroValueAccess().getMacroValueAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MacroValue__Group__0__Impl"


    // $ANTLR start "rule__MacroValue__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1321:1: rule__MacroValue__Group__1 : rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2 ;
    public final void rule__MacroValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1325:1: ( rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1326:2: rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__1__Impl_in_rule__MacroValue__Group__12692);
            rule__MacroValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MacroValue__Group__2_in_rule__MacroValue__Group__12695);
            rule__MacroValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MacroValue__Group__1"


    // $ANTLR start "rule__MacroValue__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1333:1: rule__MacroValue__Group__1__Impl : ( 'value(' ) ;
    public final void rule__MacroValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1337:1: ( ( 'value(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1338:1: ( 'value(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1338:1: ( 'value(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1339:1: 'value('
            {
             before(grammarAccess.getMacroValueAccess().getValueKeyword_1()); 
            match(input,27,FOLLOW_27_in_rule__MacroValue__Group__1__Impl2723); 
             after(grammarAccess.getMacroValueAccess().getValueKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MacroValue__Group__1__Impl"


    // $ANTLR start "rule__MacroValue__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1352:1: rule__MacroValue__Group__2 : rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3 ;
    public final void rule__MacroValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1356:1: ( rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1357:2: rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__2__Impl_in_rule__MacroValue__Group__22754);
            rule__MacroValue__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MacroValue__Group__3_in_rule__MacroValue__Group__22757);
            rule__MacroValue__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MacroValue__Group__2"


    // $ANTLR start "rule__MacroValue__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1364:1: rule__MacroValue__Group__2__Impl : ( ( rule__MacroValue__TypeAssignment_2 )? ) ;
    public final void rule__MacroValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1368:1: ( ( ( rule__MacroValue__TypeAssignment_2 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1369:1: ( ( rule__MacroValue__TypeAssignment_2 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1369:1: ( ( rule__MacroValue__TypeAssignment_2 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1370:1: ( rule__MacroValue__TypeAssignment_2 )?
            {
             before(grammarAccess.getMacroValueAccess().getTypeAssignment_2()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1371:1: ( rule__MacroValue__TypeAssignment_2 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=18 && LA10_0<=19)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1371:2: rule__MacroValue__TypeAssignment_2
                    {
                    pushFollow(FOLLOW_rule__MacroValue__TypeAssignment_2_in_rule__MacroValue__Group__2__Impl2784);
                    rule__MacroValue__TypeAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMacroValueAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MacroValue__Group__2__Impl"


    // $ANTLR start "rule__MacroValue__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1381:1: rule__MacroValue__Group__3 : rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4 ;
    public final void rule__MacroValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1385:1: ( rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1386:2: rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__3__Impl_in_rule__MacroValue__Group__32815);
            rule__MacroValue__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MacroValue__Group__4_in_rule__MacroValue__Group__32818);
            rule__MacroValue__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MacroValue__Group__3"


    // $ANTLR start "rule__MacroValue__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1393:1: rule__MacroValue__Group__3__Impl : ( RULE_ANY_OTHER ) ;
    public final void rule__MacroValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1397:1: ( ( RULE_ANY_OTHER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1398:1: ( RULE_ANY_OTHER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1398:1: ( RULE_ANY_OTHER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1399:1: RULE_ANY_OTHER
            {
             before(grammarAccess.getMacroValueAccess().getANY_OTHERTerminalRuleCall_3()); 
            match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_rule__MacroValue__Group__3__Impl2845); 
             after(grammarAccess.getMacroValueAccess().getANY_OTHERTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MacroValue__Group__3__Impl"


    // $ANTLR start "rule__MacroValue__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1410:1: rule__MacroValue__Group__4 : rule__MacroValue__Group__4__Impl ;
    public final void rule__MacroValue__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1414:1: ( rule__MacroValue__Group__4__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1415:2: rule__MacroValue__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__4__Impl_in_rule__MacroValue__Group__42874);
            rule__MacroValue__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MacroValue__Group__4"


    // $ANTLR start "rule__MacroValue__Group__4__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1421:1: rule__MacroValue__Group__4__Impl : ( ')' ) ;
    public final void rule__MacroValue__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1425:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1426:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1426:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1427:1: ')'
            {
             before(grammarAccess.getMacroValueAccess().getRightParenthesisKeyword_4()); 
            match(input,28,FOLLOW_28_in_rule__MacroValue__Group__4__Impl2902); 
             after(grammarAccess.getMacroValueAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MacroValue__Group__4__Impl"


    // $ANTLR start "rule__ValueAssignment__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1450:1: rule__ValueAssignment__Group__0 : rule__ValueAssignment__Group__0__Impl rule__ValueAssignment__Group__1 ;
    public final void rule__ValueAssignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1454:1: ( rule__ValueAssignment__Group__0__Impl rule__ValueAssignment__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1455:2: rule__ValueAssignment__Group__0__Impl rule__ValueAssignment__Group__1
            {
            pushFollow(FOLLOW_rule__ValueAssignment__Group__0__Impl_in_rule__ValueAssignment__Group__02943);
            rule__ValueAssignment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ValueAssignment__Group__1_in_rule__ValueAssignment__Group__02946);
            rule__ValueAssignment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueAssignment__Group__0"


    // $ANTLR start "rule__ValueAssignment__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1462:1: rule__ValueAssignment__Group__0__Impl : ( ( rule__ValueAssignment__TypeReferenceAssignment_0 ) ) ;
    public final void rule__ValueAssignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1466:1: ( ( ( rule__ValueAssignment__TypeReferenceAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1467:1: ( ( rule__ValueAssignment__TypeReferenceAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1467:1: ( ( rule__ValueAssignment__TypeReferenceAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1468:1: ( rule__ValueAssignment__TypeReferenceAssignment_0 )
            {
             before(grammarAccess.getValueAssignmentAccess().getTypeReferenceAssignment_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1469:1: ( rule__ValueAssignment__TypeReferenceAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1469:2: rule__ValueAssignment__TypeReferenceAssignment_0
            {
            pushFollow(FOLLOW_rule__ValueAssignment__TypeReferenceAssignment_0_in_rule__ValueAssignment__Group__0__Impl2973);
            rule__ValueAssignment__TypeReferenceAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getValueAssignmentAccess().getTypeReferenceAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueAssignment__Group__0__Impl"


    // $ANTLR start "rule__ValueAssignment__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1479:1: rule__ValueAssignment__Group__1 : rule__ValueAssignment__Group__1__Impl rule__ValueAssignment__Group__2 ;
    public final void rule__ValueAssignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1483:1: ( rule__ValueAssignment__Group__1__Impl rule__ValueAssignment__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1484:2: rule__ValueAssignment__Group__1__Impl rule__ValueAssignment__Group__2
            {
            pushFollow(FOLLOW_rule__ValueAssignment__Group__1__Impl_in_rule__ValueAssignment__Group__13003);
            rule__ValueAssignment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ValueAssignment__Group__2_in_rule__ValueAssignment__Group__13006);
            rule__ValueAssignment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueAssignment__Group__1"


    // $ANTLR start "rule__ValueAssignment__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1491:1: rule__ValueAssignment__Group__1__Impl : ( '::=' ) ;
    public final void rule__ValueAssignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1495:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1496:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1496:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1497:1: '::='
            {
             before(grammarAccess.getValueAssignmentAccess().getColonColonEqualsSignKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__ValueAssignment__Group__1__Impl3034); 
             after(grammarAccess.getValueAssignmentAccess().getColonColonEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueAssignment__Group__1__Impl"


    // $ANTLR start "rule__ValueAssignment__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1510:1: rule__ValueAssignment__Group__2 : rule__ValueAssignment__Group__2__Impl ;
    public final void rule__ValueAssignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1514:1: ( rule__ValueAssignment__Group__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1515:2: rule__ValueAssignment__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ValueAssignment__Group__2__Impl_in_rule__ValueAssignment__Group__23065);
            rule__ValueAssignment__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueAssignment__Group__2"


    // $ANTLR start "rule__ValueAssignment__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1521:1: rule__ValueAssignment__Group__2__Impl : ( ( rule__ValueAssignment__ValueAssignment_2 ) ) ;
    public final void rule__ValueAssignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1525:1: ( ( ( rule__ValueAssignment__ValueAssignment_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1526:1: ( ( rule__ValueAssignment__ValueAssignment_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1526:1: ( ( rule__ValueAssignment__ValueAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1527:1: ( rule__ValueAssignment__ValueAssignment_2 )
            {
             before(grammarAccess.getValueAssignmentAccess().getValueAssignment_2()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1528:1: ( rule__ValueAssignment__ValueAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1528:2: rule__ValueAssignment__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__ValueAssignment__ValueAssignment_2_in_rule__ValueAssignment__Group__2__Impl3092);
            rule__ValueAssignment__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getValueAssignmentAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueAssignment__Group__2__Impl"


    // $ANTLR start "rule__Or__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1544:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1548:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1549:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_rule__Or__Group__0__Impl_in_rule__Or__Group__03128);
            rule__Or__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Or__Group__1_in_rule__Or__Group__03131);
            rule__Or__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0"


    // $ANTLR start "rule__Or__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1556:1: rule__Or__Group__0__Impl : ( ruleValueType ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1560:1: ( ( ruleValueType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1561:1: ( ruleValueType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1561:1: ( ruleValueType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1562:1: ruleValueType
            {
             before(grammarAccess.getOrAccess().getValueTypeParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleValueType_in_rule__Or__Group__0__Impl3158);
            ruleValueType();

            state._fsp--;

             after(grammarAccess.getOrAccess().getValueTypeParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0__Impl"


    // $ANTLR start "rule__Or__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1573:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1577:1: ( rule__Or__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1578:2: rule__Or__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Or__Group__1__Impl_in_rule__Or__Group__13187);
            rule__Or__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1"


    // $ANTLR start "rule__Or__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1584:1: rule__Or__Group__1__Impl : ( ( rule__Or__Group_1__0 )* ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1588:1: ( ( ( rule__Or__Group_1__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1589:1: ( ( rule__Or__Group_1__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1589:1: ( ( rule__Or__Group_1__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1590:1: ( rule__Or__Group_1__0 )*
            {
             before(grammarAccess.getOrAccess().getGroup_1()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1591:1: ( rule__Or__Group_1__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==29) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1591:2: rule__Or__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Or__Group_1__0_in_rule__Or__Group__1__Impl3214);
            	    rule__Or__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getOrAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1__Impl"


    // $ANTLR start "rule__Or__Group_1__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1605:1: rule__Or__Group_1__0 : rule__Or__Group_1__0__Impl rule__Or__Group_1__1 ;
    public final void rule__Or__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1609:1: ( rule__Or__Group_1__0__Impl rule__Or__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1610:2: rule__Or__Group_1__0__Impl rule__Or__Group_1__1
            {
            pushFollow(FOLLOW_rule__Or__Group_1__0__Impl_in_rule__Or__Group_1__03249);
            rule__Or__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Or__Group_1__1_in_rule__Or__Group_1__03252);
            rule__Or__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0"


    // $ANTLR start "rule__Or__Group_1__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1617:1: rule__Or__Group_1__0__Impl : ( ( rule__Or__Group_1_0__0 ) ) ;
    public final void rule__Or__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1621:1: ( ( ( rule__Or__Group_1_0__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1622:1: ( ( rule__Or__Group_1_0__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1622:1: ( ( rule__Or__Group_1_0__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1623:1: ( rule__Or__Group_1_0__0 )
            {
             before(grammarAccess.getOrAccess().getGroup_1_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1624:1: ( rule__Or__Group_1_0__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1624:2: rule__Or__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__Or__Group_1_0__0_in_rule__Or__Group_1__0__Impl3279);
            rule__Or__Group_1_0__0();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getGroup_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__0__Impl"


    // $ANTLR start "rule__Or__Group_1__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1634:1: rule__Or__Group_1__1 : rule__Or__Group_1__1__Impl ;
    public final void rule__Or__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1638:1: ( rule__Or__Group_1__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1639:2: rule__Or__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Or__Group_1__1__Impl_in_rule__Or__Group_1__13309);
            rule__Or__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1"


    // $ANTLR start "rule__Or__Group_1__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1645:1: rule__Or__Group_1__1__Impl : ( ( rule__Or__RightAssignment_1_1 ) ) ;
    public final void rule__Or__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1649:1: ( ( ( rule__Or__RightAssignment_1_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1650:1: ( ( rule__Or__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1650:1: ( ( rule__Or__RightAssignment_1_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1651:1: ( rule__Or__RightAssignment_1_1 )
            {
             before(grammarAccess.getOrAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1652:1: ( rule__Or__RightAssignment_1_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1652:2: rule__Or__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Or__RightAssignment_1_1_in_rule__Or__Group_1__1__Impl3336);
            rule__Or__RightAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getRightAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1__1__Impl"


    // $ANTLR start "rule__Or__Group_1_0__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1666:1: rule__Or__Group_1_0__0 : rule__Or__Group_1_0__0__Impl rule__Or__Group_1_0__1 ;
    public final void rule__Or__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1670:1: ( rule__Or__Group_1_0__0__Impl rule__Or__Group_1_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1671:2: rule__Or__Group_1_0__0__Impl rule__Or__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Or__Group_1_0__0__Impl_in_rule__Or__Group_1_0__03370);
            rule__Or__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Or__Group_1_0__1_in_rule__Or__Group_1_0__03373);
            rule__Or__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1_0__0"


    // $ANTLR start "rule__Or__Group_1_0__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1678:1: rule__Or__Group_1_0__0__Impl : ( () ) ;
    public final void rule__Or__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1682:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1683:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1683:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1684:1: ()
            {
             before(grammarAccess.getOrAccess().getOrLeftAction_1_0_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1685:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1687:1: 
            {
            }

             after(grammarAccess.getOrAccess().getOrLeftAction_1_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1_0__0__Impl"


    // $ANTLR start "rule__Or__Group_1_0__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1697:1: rule__Or__Group_1_0__1 : rule__Or__Group_1_0__1__Impl ;
    public final void rule__Or__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1701:1: ( rule__Or__Group_1_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1702:2: rule__Or__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Or__Group_1_0__1__Impl_in_rule__Or__Group_1_0__13431);
            rule__Or__Group_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1_0__1"


    // $ANTLR start "rule__Or__Group_1_0__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1708:1: rule__Or__Group_1_0__1__Impl : ( '|' ) ;
    public final void rule__Or__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1712:1: ( ( '|' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1713:1: ( '|' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1713:1: ( '|' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1714:1: '|'
            {
             before(grammarAccess.getOrAccess().getVerticalLineKeyword_1_0_1()); 
            match(input,29,FOLLOW_29_in_rule__Or__Group_1_0__1__Impl3459); 
             after(grammarAccess.getOrAccess().getVerticalLineKeyword_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group_1_0__1__Impl"


    // $ANTLR start "rule__ValueType__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1731:1: rule__ValueType__Group__0 : rule__ValueType__Group__0__Impl rule__ValueType__Group__1 ;
    public final void rule__ValueType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1735:1: ( rule__ValueType__Group__0__Impl rule__ValueType__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1736:2: rule__ValueType__Group__0__Impl rule__ValueType__Group__1
            {
            pushFollow(FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__03494);
            rule__ValueType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__03497);
            rule__ValueType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__0"


    // $ANTLR start "rule__ValueType__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1743:1: rule__ValueType__Group__0__Impl : ( ( rule__ValueType__NameAssignment_0 )? ) ;
    public final void rule__ValueType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1747:1: ( ( ( rule__ValueType__NameAssignment_0 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1748:1: ( ( rule__ValueType__NameAssignment_0 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1748:1: ( ( rule__ValueType__NameAssignment_0 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1749:1: ( rule__ValueType__NameAssignment_0 )?
            {
             before(grammarAccess.getValueTypeAccess().getNameAssignment_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1750:1: ( rule__ValueType__NameAssignment_0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_IA5STRING) ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>=RULE_IA5STRING && LA12_1<=RULE_ID)||LA12_1==31||LA12_1==33||LA12_1==36) ) {
                    alt12=1;
                }
            }
            switch (alt12) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1750:2: rule__ValueType__NameAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ValueType__NameAssignment_0_in_rule__ValueType__Group__0__Impl3524);
                    rule__ValueType__NameAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValueTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__0__Impl"


    // $ANTLR start "rule__ValueType__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1760:1: rule__ValueType__Group__1 : rule__ValueType__Group__1__Impl ;
    public final void rule__ValueType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1764:1: ( rule__ValueType__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1765:2: rule__ValueType__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__13555);
            rule__ValueType__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__1"


    // $ANTLR start "rule__ValueType__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1771:1: rule__ValueType__Group__1__Impl : ( ( rule__ValueType__Alternatives_1 ) ) ;
    public final void rule__ValueType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1775:1: ( ( ( rule__ValueType__Alternatives_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1776:1: ( ( rule__ValueType__Alternatives_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1776:1: ( ( rule__ValueType__Alternatives_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1777:1: ( rule__ValueType__Alternatives_1 )
            {
             before(grammarAccess.getValueTypeAccess().getAlternatives_1()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1778:1: ( rule__ValueType__Alternatives_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1778:2: rule__ValueType__Alternatives_1
            {
            pushFollow(FOLLOW_rule__ValueType__Alternatives_1_in_rule__ValueType__Group__1__Impl3582);
            rule__ValueType__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getValueTypeAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__Group__1__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_0__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1792:1: rule__ASN1_SIMPLE__Group_0__0 : rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1 ;
    public final void rule__ASN1_SIMPLE__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1796:1: ( rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1797:2: rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__0__Impl_in_rule__ASN1_SIMPLE__Group_0__03616);
            rule__ASN1_SIMPLE__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__1_in_rule__ASN1_SIMPLE__Group_0__03619);
            rule__ASN1_SIMPLE__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_0__0"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_0__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1804:1: rule__ASN1_SIMPLE__Group_0__0__Impl : ( () ) ;
    public final void rule__ASN1_SIMPLE__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1808:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1809:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1809:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1810:1: ()
            {
             before(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1811:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1813:1: 
            {
            }

             after(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_0__0__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_0__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1823:1: rule__ASN1_SIMPLE__Group_0__1 : rule__ASN1_SIMPLE__Group_0__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1827:1: ( rule__ASN1_SIMPLE__Group_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1828:2: rule__ASN1_SIMPLE__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__1__Impl_in_rule__ASN1_SIMPLE__Group_0__13677);
            rule__ASN1_SIMPLE__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_0__1"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_0__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1834:1: rule__ASN1_SIMPLE__Group_0__1__Impl : ( RULE_IA5STRING ) ;
    public final void rule__ASN1_SIMPLE__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1838:1: ( ( RULE_IA5STRING ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1839:1: ( RULE_IA5STRING )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1839:1: ( RULE_IA5STRING )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1840:1: RULE_IA5STRING
            {
             before(grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_0_1()); 
            match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_rule__ASN1_SIMPLE__Group_0__1__Impl3704); 
             after(grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_0__1__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1855:1: rule__ASN1_SIMPLE__Group_2__0 : rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1 ;
    public final void rule__ASN1_SIMPLE__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1859:1: ( rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1860:2: rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__0__Impl_in_rule__ASN1_SIMPLE__Group_2__03737);
            rule__ASN1_SIMPLE__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__1_in_rule__ASN1_SIMPLE__Group_2__03740);
            rule__ASN1_SIMPLE__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2__0"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1867:1: rule__ASN1_SIMPLE__Group_2__0__Impl : ( ruleASN1_INTEGER ) ;
    public final void rule__ASN1_SIMPLE__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1871:1: ( ( ruleASN1_INTEGER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1872:1: ( ruleASN1_INTEGER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1872:1: ( ruleASN1_INTEGER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1873:1: ruleASN1_INTEGER
            {
             before(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_rule__ASN1_SIMPLE__Group_2__0__Impl3767);
            ruleASN1_INTEGER();

            state._fsp--;

             after(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2__0__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1884:1: rule__ASN1_SIMPLE__Group_2__1 : rule__ASN1_SIMPLE__Group_2__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1888:1: ( rule__ASN1_SIMPLE__Group_2__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1889:2: rule__ASN1_SIMPLE__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__1__Impl_in_rule__ASN1_SIMPLE__Group_2__13796);
            rule__ASN1_SIMPLE__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2__1"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1895:1: rule__ASN1_SIMPLE__Group_2__1__Impl : ( ( rule__ASN1_SIMPLE__Group_2_1__0 )? ) ;
    public final void rule__ASN1_SIMPLE__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1899:1: ( ( ( rule__ASN1_SIMPLE__Group_2_1__0 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1900:1: ( ( rule__ASN1_SIMPLE__Group_2_1__0 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1900:1: ( ( rule__ASN1_SIMPLE__Group_2_1__0 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1901:1: ( rule__ASN1_SIMPLE__Group_2_1__0 )?
            {
             before(grammarAccess.getASN1_SIMPLEAccess().getGroup_2_1()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1902:1: ( rule__ASN1_SIMPLE__Group_2_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==30) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1902:2: rule__ASN1_SIMPLE__Group_2_1__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2_1__0_in_rule__ASN1_SIMPLE__Group_2__1__Impl3823);
                    rule__ASN1_SIMPLE__Group_2_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getASN1_SIMPLEAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2__1__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2_1__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1916:1: rule__ASN1_SIMPLE__Group_2_1__0 : rule__ASN1_SIMPLE__Group_2_1__0__Impl rule__ASN1_SIMPLE__Group_2_1__1 ;
    public final void rule__ASN1_SIMPLE__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1920:1: ( rule__ASN1_SIMPLE__Group_2_1__0__Impl rule__ASN1_SIMPLE__Group_2_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1921:2: rule__ASN1_SIMPLE__Group_2_1__0__Impl rule__ASN1_SIMPLE__Group_2_1__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2_1__0__Impl_in_rule__ASN1_SIMPLE__Group_2_1__03858);
            rule__ASN1_SIMPLE__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2_1__1_in_rule__ASN1_SIMPLE__Group_2_1__03861);
            rule__ASN1_SIMPLE__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2_1__0"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2_1__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1928:1: rule__ASN1_SIMPLE__Group_2_1__0__Impl : ( '(' ) ;
    public final void rule__ASN1_SIMPLE__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1932:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1933:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1933:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1934:1: '('
            {
             before(grammarAccess.getASN1_SIMPLEAccess().getLeftParenthesisKeyword_2_1_0()); 
            match(input,30,FOLLOW_30_in_rule__ASN1_SIMPLE__Group_2_1__0__Impl3889); 
             after(grammarAccess.getASN1_SIMPLEAccess().getLeftParenthesisKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2_1__0__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2_1__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1947:1: rule__ASN1_SIMPLE__Group_2_1__1 : rule__ASN1_SIMPLE__Group_2_1__1__Impl rule__ASN1_SIMPLE__Group_2_1__2 ;
    public final void rule__ASN1_SIMPLE__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1951:1: ( rule__ASN1_SIMPLE__Group_2_1__1__Impl rule__ASN1_SIMPLE__Group_2_1__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1952:2: rule__ASN1_SIMPLE__Group_2_1__1__Impl rule__ASN1_SIMPLE__Group_2_1__2
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2_1__1__Impl_in_rule__ASN1_SIMPLE__Group_2_1__13920);
            rule__ASN1_SIMPLE__Group_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2_1__2_in_rule__ASN1_SIMPLE__Group_2_1__13923);
            rule__ASN1_SIMPLE__Group_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2_1__1"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2_1__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1959:1: rule__ASN1_SIMPLE__Group_2_1__1__Impl : ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1 ) ) ;
    public final void rule__ASN1_SIMPLE__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1963:1: ( ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1964:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1964:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1965:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1 )
            {
             before(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_2_1_1()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1966:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1966:2: rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1_in_rule__ASN1_SIMPLE__Group_2_1__1__Impl3950);
            rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2_1__1__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2_1__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1976:1: rule__ASN1_SIMPLE__Group_2_1__2 : rule__ASN1_SIMPLE__Group_2_1__2__Impl ;
    public final void rule__ASN1_SIMPLE__Group_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1980:1: ( rule__ASN1_SIMPLE__Group_2_1__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1981:2: rule__ASN1_SIMPLE__Group_2_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2_1__2__Impl_in_rule__ASN1_SIMPLE__Group_2_1__23980);
            rule__ASN1_SIMPLE__Group_2_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2_1__2"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2_1__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1987:1: rule__ASN1_SIMPLE__Group_2_1__2__Impl : ( ')' ) ;
    public final void rule__ASN1_SIMPLE__Group_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1991:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1992:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1992:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1993:1: ')'
            {
             before(grammarAccess.getASN1_SIMPLEAccess().getRightParenthesisKeyword_2_1_2()); 
            match(input,28,FOLLOW_28_in_rule__ASN1_SIMPLE__Group_2_1__2__Impl4008); 
             after(grammarAccess.getASN1_SIMPLEAccess().getRightParenthesisKeyword_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2_1__2__Impl"


    // $ANTLR start "rule__ASN1_OCTET_STRING__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2012:1: rule__ASN1_OCTET_STRING__Group__0 : rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1 ;
    public final void rule__ASN1_OCTET_STRING__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2016:1: ( rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2017:2: rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__0__Impl_in_rule__ASN1_OCTET_STRING__Group__04045);
            rule__ASN1_OCTET_STRING__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__1_in_rule__ASN1_OCTET_STRING__Group__04048);
            rule__ASN1_OCTET_STRING__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_OCTET_STRING__Group__0"


    // $ANTLR start "rule__ASN1_OCTET_STRING__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2024:1: rule__ASN1_OCTET_STRING__Group__0__Impl : ( () ) ;
    public final void rule__ASN1_OCTET_STRING__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2028:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2029:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2029:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2030:1: ()
            {
             before(grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2031:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2033:1: 
            {
            }

             after(grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_OCTET_STRING__Group__0__Impl"


    // $ANTLR start "rule__ASN1_OCTET_STRING__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2043:1: rule__ASN1_OCTET_STRING__Group__1 : rule__ASN1_OCTET_STRING__Group__1__Impl rule__ASN1_OCTET_STRING__Group__2 ;
    public final void rule__ASN1_OCTET_STRING__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2047:1: ( rule__ASN1_OCTET_STRING__Group__1__Impl rule__ASN1_OCTET_STRING__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2048:2: rule__ASN1_OCTET_STRING__Group__1__Impl rule__ASN1_OCTET_STRING__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__1__Impl_in_rule__ASN1_OCTET_STRING__Group__14106);
            rule__ASN1_OCTET_STRING__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__2_in_rule__ASN1_OCTET_STRING__Group__14109);
            rule__ASN1_OCTET_STRING__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_OCTET_STRING__Group__1"


    // $ANTLR start "rule__ASN1_OCTET_STRING__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2055:1: rule__ASN1_OCTET_STRING__Group__1__Impl : ( 'OCTET STRING' ) ;
    public final void rule__ASN1_OCTET_STRING__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2059:1: ( ( 'OCTET STRING' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2060:1: ( 'OCTET STRING' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2060:1: ( 'OCTET STRING' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2061:1: 'OCTET STRING'
            {
             before(grammarAccess.getASN1_OCTET_STRINGAccess().getOCTETSTRINGKeyword_1()); 
            match(input,31,FOLLOW_31_in_rule__ASN1_OCTET_STRING__Group__1__Impl4137); 
             after(grammarAccess.getASN1_OCTET_STRINGAccess().getOCTETSTRINGKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_OCTET_STRING__Group__1__Impl"


    // $ANTLR start "rule__ASN1_OCTET_STRING__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2074:1: rule__ASN1_OCTET_STRING__Group__2 : rule__ASN1_OCTET_STRING__Group__2__Impl ;
    public final void rule__ASN1_OCTET_STRING__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2078:1: ( rule__ASN1_OCTET_STRING__Group__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2079:2: rule__ASN1_OCTET_STRING__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__2__Impl_in_rule__ASN1_OCTET_STRING__Group__24168);
            rule__ASN1_OCTET_STRING__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_OCTET_STRING__Group__2"


    // $ANTLR start "rule__ASN1_OCTET_STRING__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2085:1: rule__ASN1_OCTET_STRING__Group__2__Impl : ( 'TODO defintions.' ) ;
    public final void rule__ASN1_OCTET_STRING__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2089:1: ( ( 'TODO defintions.' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2090:1: ( 'TODO defintions.' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2090:1: ( 'TODO defintions.' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2091:1: 'TODO defintions.'
            {
             before(grammarAccess.getASN1_OCTET_STRINGAccess().getTODODefintionsKeyword_2()); 
            match(input,32,FOLLOW_32_in_rule__ASN1_OCTET_STRING__Group__2__Impl4196); 
             after(grammarAccess.getASN1_OCTET_STRINGAccess().getTODODefintionsKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_OCTET_STRING__Group__2__Impl"


    // $ANTLR start "rule__ASN1_INTEGER__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2110:1: rule__ASN1_INTEGER__Group__0 : rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1 ;
    public final void rule__ASN1_INTEGER__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2114:1: ( rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2115:2: rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__0__Impl_in_rule__ASN1_INTEGER__Group__04233);
            rule__ASN1_INTEGER__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__1_in_rule__ASN1_INTEGER__Group__04236);
            rule__ASN1_INTEGER__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_INTEGER__Group__0"


    // $ANTLR start "rule__ASN1_INTEGER__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2122:1: rule__ASN1_INTEGER__Group__0__Impl : ( 'INTEGER' ) ;
    public final void rule__ASN1_INTEGER__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2126:1: ( ( 'INTEGER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2127:1: ( 'INTEGER' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2127:1: ( 'INTEGER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2128:1: 'INTEGER'
            {
             before(grammarAccess.getASN1_INTEGERAccess().getINTEGERKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__ASN1_INTEGER__Group__0__Impl4264); 
             after(grammarAccess.getASN1_INTEGERAccess().getINTEGERKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_INTEGER__Group__0__Impl"


    // $ANTLR start "rule__ASN1_INTEGER__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2141:1: rule__ASN1_INTEGER__Group__1 : rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2 ;
    public final void rule__ASN1_INTEGER__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2145:1: ( rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2146:2: rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__1__Impl_in_rule__ASN1_INTEGER__Group__14295);
            rule__ASN1_INTEGER__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__2_in_rule__ASN1_INTEGER__Group__14298);
            rule__ASN1_INTEGER__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_INTEGER__Group__1"


    // $ANTLR start "rule__ASN1_INTEGER__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2153:1: rule__ASN1_INTEGER__Group__1__Impl : ( '{' ) ;
    public final void rule__ASN1_INTEGER__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2157:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2158:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2158:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2159:1: '{'
            {
             before(grammarAccess.getASN1_INTEGERAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__ASN1_INTEGER__Group__1__Impl4326); 
             after(grammarAccess.getASN1_INTEGERAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_INTEGER__Group__1__Impl"


    // $ANTLR start "rule__ASN1_INTEGER__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2172:1: rule__ASN1_INTEGER__Group__2 : rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3 ;
    public final void rule__ASN1_INTEGER__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2176:1: ( rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2177:2: rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__2__Impl_in_rule__ASN1_INTEGER__Group__24357);
            rule__ASN1_INTEGER__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__3_in_rule__ASN1_INTEGER__Group__24360);
            rule__ASN1_INTEGER__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_INTEGER__Group__2"


    // $ANTLR start "rule__ASN1_INTEGER__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2184:1: rule__ASN1_INTEGER__Group__2__Impl : ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) ) ;
    public final void rule__ASN1_INTEGER__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2188:1: ( ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2189:1: ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2189:1: ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2190:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2190:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2191:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )
            {
             before(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2192:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2192:2: rule__ASN1_INTEGER__ValuePairsAssignment_2
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl4389);
            rule__ASN1_INTEGER__ValuePairsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2195:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2196:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )*
            {
             before(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2197:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID||LA14_0==30) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2197:2: rule__ASN1_INTEGER__ValuePairsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl4401);
            	    rule__ASN1_INTEGER__ValuePairsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_INTEGER__Group__2__Impl"


    // $ANTLR start "rule__ASN1_INTEGER__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2208:1: rule__ASN1_INTEGER__Group__3 : rule__ASN1_INTEGER__Group__3__Impl ;
    public final void rule__ASN1_INTEGER__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2212:1: ( rule__ASN1_INTEGER__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2213:2: rule__ASN1_INTEGER__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__3__Impl_in_rule__ASN1_INTEGER__Group__34434);
            rule__ASN1_INTEGER__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_INTEGER__Group__3"


    // $ANTLR start "rule__ASN1_INTEGER__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2219:1: rule__ASN1_INTEGER__Group__3__Impl : ( '}' ) ;
    public final void rule__ASN1_INTEGER__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2223:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2224:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2224:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2225:1: '}'
            {
             before(grammarAccess.getASN1_INTEGERAccess().getRightCurlyBracketKeyword_3()); 
            match(input,35,FOLLOW_35_in_rule__ASN1_INTEGER__Group__3__Impl4462); 
             after(grammarAccess.getASN1_INTEGERAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_INTEGER__Group__3__Impl"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2246:1: rule__ASN1_VALUEPAIR__Group__0 : rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1 ;
    public final void rule__ASN1_VALUEPAIR__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2250:1: ( rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2251:2: rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__0__Impl_in_rule__ASN1_VALUEPAIR__Group__04501);
            rule__ASN1_VALUEPAIR__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__1_in_rule__ASN1_VALUEPAIR__Group__04504);
            rule__ASN1_VALUEPAIR__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__0"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2258:1: rule__ASN1_VALUEPAIR__Group__0__Impl : ( ( RULE_ID )? ) ;
    public final void rule__ASN1_VALUEPAIR__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2262:1: ( ( ( RULE_ID )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2263:1: ( ( RULE_ID )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2263:1: ( ( RULE_ID )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2264:1: ( RULE_ID )?
            {
             before(grammarAccess.getASN1_VALUEPAIRAccess().getIDTerminalRuleCall_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2265:1: ( RULE_ID )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2265:3: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ASN1_VALUEPAIR__Group__0__Impl4532); 

                    }
                    break;

            }

             after(grammarAccess.getASN1_VALUEPAIRAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__0__Impl"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2275:1: rule__ASN1_VALUEPAIR__Group__1 : rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2 ;
    public final void rule__ASN1_VALUEPAIR__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2279:1: ( rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2280:2: rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__1__Impl_in_rule__ASN1_VALUEPAIR__Group__14563);
            rule__ASN1_VALUEPAIR__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__2_in_rule__ASN1_VALUEPAIR__Group__14566);
            rule__ASN1_VALUEPAIR__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__1"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2287:1: rule__ASN1_VALUEPAIR__Group__1__Impl : ( '(' ) ;
    public final void rule__ASN1_VALUEPAIR__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2291:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2292:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2292:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2293:1: '('
            {
             before(grammarAccess.getASN1_VALUEPAIRAccess().getLeftParenthesisKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__ASN1_VALUEPAIR__Group__1__Impl4594); 
             after(grammarAccess.getASN1_VALUEPAIRAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__1__Impl"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2306:1: rule__ASN1_VALUEPAIR__Group__2 : rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3 ;
    public final void rule__ASN1_VALUEPAIR__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2310:1: ( rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2311:2: rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__2__Impl_in_rule__ASN1_VALUEPAIR__Group__24625);
            rule__ASN1_VALUEPAIR__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__3_in_rule__ASN1_VALUEPAIR__Group__24628);
            rule__ASN1_VALUEPAIR__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__2"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2318:1: rule__ASN1_VALUEPAIR__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__ASN1_VALUEPAIR__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2322:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2323:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2323:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2324:1: RULE_INT
            {
             before(grammarAccess.getASN1_VALUEPAIRAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_VALUEPAIR__Group__2__Impl4655); 
             after(grammarAccess.getASN1_VALUEPAIRAccess().getINTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__2__Impl"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2335:1: rule__ASN1_VALUEPAIR__Group__3 : rule__ASN1_VALUEPAIR__Group__3__Impl ;
    public final void rule__ASN1_VALUEPAIR__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2339:1: ( rule__ASN1_VALUEPAIR__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2340:2: rule__ASN1_VALUEPAIR__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__3__Impl_in_rule__ASN1_VALUEPAIR__Group__34684);
            rule__ASN1_VALUEPAIR__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__3"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2346:1: rule__ASN1_VALUEPAIR__Group__3__Impl : ( ')' ) ;
    public final void rule__ASN1_VALUEPAIR__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2350:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2351:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2351:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2352:1: ')'
            {
             before(grammarAccess.getASN1_VALUEPAIRAccess().getRightParenthesisKeyword_3()); 
            match(input,28,FOLLOW_28_in_rule__ASN1_VALUEPAIR__Group__3__Impl4712); 
             after(grammarAccess.getASN1_VALUEPAIRAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__3__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2373:1: rule__ASN1_CHOICE__Group__0 : rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1 ;
    public final void rule__ASN1_CHOICE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2377:1: ( rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2378:2: rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__0__Impl_in_rule__ASN1_CHOICE__Group__04751);
            rule__ASN1_CHOICE__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__1_in_rule__ASN1_CHOICE__Group__04754);
            rule__ASN1_CHOICE__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group__0"


    // $ANTLR start "rule__ASN1_CHOICE__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2385:1: rule__ASN1_CHOICE__Group__0__Impl : ( 'CHOICE' ) ;
    public final void rule__ASN1_CHOICE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2389:1: ( ( 'CHOICE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2390:1: ( 'CHOICE' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2390:1: ( 'CHOICE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2391:1: 'CHOICE'
            {
             before(grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__ASN1_CHOICE__Group__0__Impl4782); 
             after(grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group__0__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2404:1: rule__ASN1_CHOICE__Group__1 : rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2 ;
    public final void rule__ASN1_CHOICE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2408:1: ( rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2409:2: rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__1__Impl_in_rule__ASN1_CHOICE__Group__14813);
            rule__ASN1_CHOICE__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__2_in_rule__ASN1_CHOICE__Group__14816);
            rule__ASN1_CHOICE__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group__1"


    // $ANTLR start "rule__ASN1_CHOICE__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2416:1: rule__ASN1_CHOICE__Group__1__Impl : ( '{' ) ;
    public final void rule__ASN1_CHOICE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2420:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2421:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2421:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2422:1: '{'
            {
             before(grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__ASN1_CHOICE__Group__1__Impl4844); 
             after(grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group__1__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2435:1: rule__ASN1_CHOICE__Group__2 : rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3 ;
    public final void rule__ASN1_CHOICE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2439:1: ( rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2440:2: rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__2__Impl_in_rule__ASN1_CHOICE__Group__24875);
            rule__ASN1_CHOICE__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__3_in_rule__ASN1_CHOICE__Group__24878);
            rule__ASN1_CHOICE__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group__2"


    // $ANTLR start "rule__ASN1_CHOICE__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2447:1: rule__ASN1_CHOICE__Group__2__Impl : ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) ) ;
    public final void rule__ASN1_CHOICE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2451:1: ( ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2452:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2452:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2453:1: ( rule__ASN1_CHOICE__ChoicesAssignment_2 )
            {
             before(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_2()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2454:1: ( rule__ASN1_CHOICE__ChoicesAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2454:2: rule__ASN1_CHOICE__ChoicesAssignment_2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_2_in_rule__ASN1_CHOICE__Group__2__Impl4905);
            rule__ASN1_CHOICE__ChoicesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group__2__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2464:1: rule__ASN1_CHOICE__Group__3 : rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4 ;
    public final void rule__ASN1_CHOICE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2468:1: ( rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2469:2: rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__3__Impl_in_rule__ASN1_CHOICE__Group__34935);
            rule__ASN1_CHOICE__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__4_in_rule__ASN1_CHOICE__Group__34938);
            rule__ASN1_CHOICE__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group__3"


    // $ANTLR start "rule__ASN1_CHOICE__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2476:1: rule__ASN1_CHOICE__Group__3__Impl : ( ( rule__ASN1_CHOICE__Group_3__0 )* ) ;
    public final void rule__ASN1_CHOICE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2480:1: ( ( ( rule__ASN1_CHOICE__Group_3__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2481:1: ( ( rule__ASN1_CHOICE__Group_3__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2481:1: ( ( rule__ASN1_CHOICE__Group_3__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2482:1: ( rule__ASN1_CHOICE__Group_3__0 )*
            {
             before(grammarAccess.getASN1_CHOICEAccess().getGroup_3()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2483:1: ( rule__ASN1_CHOICE__Group_3__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==37) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2483:2: rule__ASN1_CHOICE__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__0_in_rule__ASN1_CHOICE__Group__3__Impl4965);
            	    rule__ASN1_CHOICE__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getASN1_CHOICEAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group__3__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2493:1: rule__ASN1_CHOICE__Group__4 : rule__ASN1_CHOICE__Group__4__Impl ;
    public final void rule__ASN1_CHOICE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2497:1: ( rule__ASN1_CHOICE__Group__4__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2498:2: rule__ASN1_CHOICE__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__4__Impl_in_rule__ASN1_CHOICE__Group__44996);
            rule__ASN1_CHOICE__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group__4"


    // $ANTLR start "rule__ASN1_CHOICE__Group__4__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2504:1: rule__ASN1_CHOICE__Group__4__Impl : ( '}' ) ;
    public final void rule__ASN1_CHOICE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2508:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2509:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2509:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2510:1: '}'
            {
             before(grammarAccess.getASN1_CHOICEAccess().getRightCurlyBracketKeyword_4()); 
            match(input,35,FOLLOW_35_in_rule__ASN1_CHOICE__Group__4__Impl5024); 
             after(grammarAccess.getASN1_CHOICEAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group__4__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group_3__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2533:1: rule__ASN1_CHOICE__Group_3__0 : rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1 ;
    public final void rule__ASN1_CHOICE__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2537:1: ( rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2538:2: rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__0__Impl_in_rule__ASN1_CHOICE__Group_3__05065);
            rule__ASN1_CHOICE__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__1_in_rule__ASN1_CHOICE__Group_3__05068);
            rule__ASN1_CHOICE__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group_3__0"


    // $ANTLR start "rule__ASN1_CHOICE__Group_3__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2545:1: rule__ASN1_CHOICE__Group_3__0__Impl : ( ',' ) ;
    public final void rule__ASN1_CHOICE__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2549:1: ( ( ',' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2550:1: ( ',' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2550:1: ( ',' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2551:1: ','
            {
             before(grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_3_0()); 
            match(input,37,FOLLOW_37_in_rule__ASN1_CHOICE__Group_3__0__Impl5096); 
             after(grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group_3__0__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group_3__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2564:1: rule__ASN1_CHOICE__Group_3__1 : rule__ASN1_CHOICE__Group_3__1__Impl ;
    public final void rule__ASN1_CHOICE__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2568:1: ( rule__ASN1_CHOICE__Group_3__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2569:2: rule__ASN1_CHOICE__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__1__Impl_in_rule__ASN1_CHOICE__Group_3__15127);
            rule__ASN1_CHOICE__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group_3__1"


    // $ANTLR start "rule__ASN1_CHOICE__Group_3__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2575:1: rule__ASN1_CHOICE__Group_3__1__Impl : ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) ) ;
    public final void rule__ASN1_CHOICE__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2579:1: ( ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2580:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2580:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2581:1: ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 )
            {
             before(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_3_1()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2582:1: ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2582:2: rule__ASN1_CHOICE__ChoicesAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_3_1_in_rule__ASN1_CHOICE__Group_3__1__Impl5154);
            rule__ASN1_CHOICE__ChoicesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__Group_3__1__Impl"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2596:1: rule__ASN1_CHOICE_ENTRY__Group__0 : rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1 ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2600:1: ( rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2601:2: rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__05188);
            rule__ASN1_CHOICE_ENTRY__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1_in_rule__ASN1_CHOICE_ENTRY__Group__05191);
            rule__ASN1_CHOICE_ENTRY__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__Group__0"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2608:1: rule__ASN1_CHOICE_ENTRY__Group__0__Impl : ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2612:1: ( ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2613:1: ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2613:1: ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2614:1: ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 )
            {
             before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdAssignment_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2615:1: ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2615:2: rule__ASN1_CHOICE_ENTRY__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__IdAssignment_0_in_rule__ASN1_CHOICE_ENTRY__Group__0__Impl5218);
            rule__ASN1_CHOICE_ENTRY__IdAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__Group__0__Impl"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2625:1: rule__ASN1_CHOICE_ENTRY__Group__1 : rule__ASN1_CHOICE_ENTRY__Group__1__Impl ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2629:1: ( rule__ASN1_CHOICE_ENTRY__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2630:2: rule__ASN1_CHOICE_ENTRY__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__15248);
            rule__ASN1_CHOICE_ENTRY__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__Group__1"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2636:1: rule__ASN1_CHOICE_ENTRY__Group__1__Impl : ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2640:1: ( ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2641:1: ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2641:1: ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2642:1: ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 )
            {
             before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeAssignment_1()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2643:1: ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2643:2: rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1_in_rule__ASN1_CHOICE_ENTRY__Group__1__Impl5275);
            rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__Group__1__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group_0__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2657:1: rule__ASN1_SUBTYPE__Group_0__0 : rule__ASN1_SUBTYPE__Group_0__0__Impl rule__ASN1_SUBTYPE__Group_0__1 ;
    public final void rule__ASN1_SUBTYPE__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2661:1: ( rule__ASN1_SUBTYPE__Group_0__0__Impl rule__ASN1_SUBTYPE__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2662:2: rule__ASN1_SUBTYPE__Group_0__0__Impl rule__ASN1_SUBTYPE__Group_0__1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_0__0__Impl_in_rule__ASN1_SUBTYPE__Group_0__05309);
            rule__ASN1_SUBTYPE__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_0__1_in_rule__ASN1_SUBTYPE__Group_0__05312);
            rule__ASN1_SUBTYPE__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SUBTYPE__Group_0__0"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group_0__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2669:1: rule__ASN1_SUBTYPE__Group_0__0__Impl : ( 'SIZE' ) ;
    public final void rule__ASN1_SUBTYPE__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2673:1: ( ( 'SIZE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2674:1: ( 'SIZE' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2674:1: ( 'SIZE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2675:1: 'SIZE'
            {
             before(grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_0_0()); 
            match(input,38,FOLLOW_38_in_rule__ASN1_SUBTYPE__Group_0__0__Impl5340); 
             after(grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SUBTYPE__Group_0__0__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group_0__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2688:1: rule__ASN1_SUBTYPE__Group_0__1 : rule__ASN1_SUBTYPE__Group_0__1__Impl ;
    public final void rule__ASN1_SUBTYPE__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2692:1: ( rule__ASN1_SUBTYPE__Group_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2693:2: rule__ASN1_SUBTYPE__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_0__1__Impl_in_rule__ASN1_SUBTYPE__Group_0__15371);
            rule__ASN1_SUBTYPE__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SUBTYPE__Group_0__1"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group_0__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2699:1: rule__ASN1_SUBTYPE__Group_0__1__Impl : ( ( rule__ASN1_SUBTYPE__RangeAssignment_0_1 ) ) ;
    public final void rule__ASN1_SUBTYPE__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2703:1: ( ( ( rule__ASN1_SUBTYPE__RangeAssignment_0_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2704:1: ( ( rule__ASN1_SUBTYPE__RangeAssignment_0_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2704:1: ( ( rule__ASN1_SUBTYPE__RangeAssignment_0_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2705:1: ( rule__ASN1_SUBTYPE__RangeAssignment_0_1 )
            {
             before(grammarAccess.getASN1_SUBTYPEAccess().getRangeAssignment_0_1()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2706:1: ( rule__ASN1_SUBTYPE__RangeAssignment_0_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2706:2: rule__ASN1_SUBTYPE__RangeAssignment_0_1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__RangeAssignment_0_1_in_rule__ASN1_SUBTYPE__Group_0__1__Impl5398);
            rule__ASN1_SUBTYPE__RangeAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getASN1_SUBTYPEAccess().getRangeAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SUBTYPE__Group_0__1__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2720:1: rule__ASN1_RANGE__Group__0 : rule__ASN1_RANGE__Group__0__Impl rule__ASN1_RANGE__Group__1 ;
    public final void rule__ASN1_RANGE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2724:1: ( rule__ASN1_RANGE__Group__0__Impl rule__ASN1_RANGE__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2725:2: rule__ASN1_RANGE__Group__0__Impl rule__ASN1_RANGE__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group__0__Impl_in_rule__ASN1_RANGE__Group__05432);
            rule__ASN1_RANGE__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_RANGE__Group__1_in_rule__ASN1_RANGE__Group__05435);
            rule__ASN1_RANGE__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group__0"


    // $ANTLR start "rule__ASN1_RANGE__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2732:1: rule__ASN1_RANGE__Group__0__Impl : ( () ) ;
    public final void rule__ASN1_RANGE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2736:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2737:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2737:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2738:1: ()
            {
             before(grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2739:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2741:1: 
            {
            }

             after(grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group__0__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2751:1: rule__ASN1_RANGE__Group__1 : rule__ASN1_RANGE__Group__1__Impl rule__ASN1_RANGE__Group__2 ;
    public final void rule__ASN1_RANGE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2755:1: ( rule__ASN1_RANGE__Group__1__Impl rule__ASN1_RANGE__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2756:2: rule__ASN1_RANGE__Group__1__Impl rule__ASN1_RANGE__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group__1__Impl_in_rule__ASN1_RANGE__Group__15493);
            rule__ASN1_RANGE__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_RANGE__Group__2_in_rule__ASN1_RANGE__Group__15496);
            rule__ASN1_RANGE__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group__1"


    // $ANTLR start "rule__ASN1_RANGE__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2763:1: rule__ASN1_RANGE__Group__1__Impl : ( '(' ) ;
    public final void rule__ASN1_RANGE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2767:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2768:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2768:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2769:1: '('
            {
             before(grammarAccess.getASN1_RANGEAccess().getLeftParenthesisKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__ASN1_RANGE__Group__1__Impl5524); 
             after(grammarAccess.getASN1_RANGEAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group__1__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2782:1: rule__ASN1_RANGE__Group__2 : rule__ASN1_RANGE__Group__2__Impl rule__ASN1_RANGE__Group__3 ;
    public final void rule__ASN1_RANGE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2786:1: ( rule__ASN1_RANGE__Group__2__Impl rule__ASN1_RANGE__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2787:2: rule__ASN1_RANGE__Group__2__Impl rule__ASN1_RANGE__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group__2__Impl_in_rule__ASN1_RANGE__Group__25555);
            rule__ASN1_RANGE__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_RANGE__Group__3_in_rule__ASN1_RANGE__Group__25558);
            rule__ASN1_RANGE__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group__2"


    // $ANTLR start "rule__ASN1_RANGE__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2794:1: rule__ASN1_RANGE__Group__2__Impl : ( ( rule__ASN1_RANGE__Group_2__0 ) ) ;
    public final void rule__ASN1_RANGE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2798:1: ( ( ( rule__ASN1_RANGE__Group_2__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2799:1: ( ( rule__ASN1_RANGE__Group_2__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2799:1: ( ( rule__ASN1_RANGE__Group_2__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2800:1: ( rule__ASN1_RANGE__Group_2__0 )
            {
             before(grammarAccess.getASN1_RANGEAccess().getGroup_2()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2801:1: ( rule__ASN1_RANGE__Group_2__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2801:2: rule__ASN1_RANGE__Group_2__0
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_2__0_in_rule__ASN1_RANGE__Group__2__Impl5585);
            rule__ASN1_RANGE__Group_2__0();

            state._fsp--;


            }

             after(grammarAccess.getASN1_RANGEAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group__2__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2811:1: rule__ASN1_RANGE__Group__3 : rule__ASN1_RANGE__Group__3__Impl ;
    public final void rule__ASN1_RANGE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2815:1: ( rule__ASN1_RANGE__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2816:2: rule__ASN1_RANGE__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group__3__Impl_in_rule__ASN1_RANGE__Group__35615);
            rule__ASN1_RANGE__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group__3"


    // $ANTLR start "rule__ASN1_RANGE__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2822:1: rule__ASN1_RANGE__Group__3__Impl : ( ')' ) ;
    public final void rule__ASN1_RANGE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2826:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2827:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2827:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2828:1: ')'
            {
             before(grammarAccess.getASN1_RANGEAccess().getRightParenthesisKeyword_3()); 
            match(input,28,FOLLOW_28_in_rule__ASN1_RANGE__Group__3__Impl5643); 
             after(grammarAccess.getASN1_RANGEAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group__3__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group_2__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2849:1: rule__ASN1_RANGE__Group_2__0 : rule__ASN1_RANGE__Group_2__0__Impl rule__ASN1_RANGE__Group_2__1 ;
    public final void rule__ASN1_RANGE__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2853:1: ( rule__ASN1_RANGE__Group_2__0__Impl rule__ASN1_RANGE__Group_2__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2854:2: rule__ASN1_RANGE__Group_2__0__Impl rule__ASN1_RANGE__Group_2__1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_2__0__Impl_in_rule__ASN1_RANGE__Group_2__05682);
            rule__ASN1_RANGE__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_2__1_in_rule__ASN1_RANGE__Group_2__05685);
            rule__ASN1_RANGE__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group_2__0"


    // $ANTLR start "rule__ASN1_RANGE__Group_2__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2861:1: rule__ASN1_RANGE__Group_2__0__Impl : ( ( rule__ASN1_RANGE__StartAssignment_2_0 ) ) ;
    public final void rule__ASN1_RANGE__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2865:1: ( ( ( rule__ASN1_RANGE__StartAssignment_2_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2866:1: ( ( rule__ASN1_RANGE__StartAssignment_2_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2866:1: ( ( rule__ASN1_RANGE__StartAssignment_2_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2867:1: ( rule__ASN1_RANGE__StartAssignment_2_0 )
            {
             before(grammarAccess.getASN1_RANGEAccess().getStartAssignment_2_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2868:1: ( rule__ASN1_RANGE__StartAssignment_2_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2868:2: rule__ASN1_RANGE__StartAssignment_2_0
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__StartAssignment_2_0_in_rule__ASN1_RANGE__Group_2__0__Impl5712);
            rule__ASN1_RANGE__StartAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getASN1_RANGEAccess().getStartAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group_2__0__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group_2__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2878:1: rule__ASN1_RANGE__Group_2__1 : rule__ASN1_RANGE__Group_2__1__Impl rule__ASN1_RANGE__Group_2__2 ;
    public final void rule__ASN1_RANGE__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2882:1: ( rule__ASN1_RANGE__Group_2__1__Impl rule__ASN1_RANGE__Group_2__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2883:2: rule__ASN1_RANGE__Group_2__1__Impl rule__ASN1_RANGE__Group_2__2
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_2__1__Impl_in_rule__ASN1_RANGE__Group_2__15742);
            rule__ASN1_RANGE__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_2__2_in_rule__ASN1_RANGE__Group_2__15745);
            rule__ASN1_RANGE__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group_2__1"


    // $ANTLR start "rule__ASN1_RANGE__Group_2__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2890:1: rule__ASN1_RANGE__Group_2__1__Impl : ( '..' ) ;
    public final void rule__ASN1_RANGE__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2894:1: ( ( '..' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2895:1: ( '..' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2895:1: ( '..' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2896:1: '..'
            {
             before(grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_2_1()); 
            match(input,39,FOLLOW_39_in_rule__ASN1_RANGE__Group_2__1__Impl5773); 
             after(grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group_2__1__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group_2__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2909:1: rule__ASN1_RANGE__Group_2__2 : rule__ASN1_RANGE__Group_2__2__Impl ;
    public final void rule__ASN1_RANGE__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2913:1: ( rule__ASN1_RANGE__Group_2__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2914:2: rule__ASN1_RANGE__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_2__2__Impl_in_rule__ASN1_RANGE__Group_2__25804);
            rule__ASN1_RANGE__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group_2__2"


    // $ANTLR start "rule__ASN1_RANGE__Group_2__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2920:1: rule__ASN1_RANGE__Group_2__2__Impl : ( ( rule__ASN1_RANGE__EndAssignment_2_2 ) ) ;
    public final void rule__ASN1_RANGE__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2924:1: ( ( ( rule__ASN1_RANGE__EndAssignment_2_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2925:1: ( ( rule__ASN1_RANGE__EndAssignment_2_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2925:1: ( ( rule__ASN1_RANGE__EndAssignment_2_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2926:1: ( rule__ASN1_RANGE__EndAssignment_2_2 )
            {
             before(grammarAccess.getASN1_RANGEAccess().getEndAssignment_2_2()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2927:1: ( rule__ASN1_RANGE__EndAssignment_2_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2927:2: rule__ASN1_RANGE__EndAssignment_2_2
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__EndAssignment_2_2_in_rule__ASN1_RANGE__Group_2__2__Impl5831);
            rule__ASN1_RANGE__EndAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getASN1_RANGEAccess().getEndAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group_2__2__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2943:1: rule__ObjectIdentifier__Group__0 : rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1 ;
    public final void rule__ObjectIdentifier__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2947:1: ( rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2948:2: rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__0__Impl_in_rule__ObjectIdentifier__Group__05867);
            rule__ObjectIdentifier__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__1_in_rule__ObjectIdentifier__Group__05870);
            rule__ObjectIdentifier__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__0"


    // $ANTLR start "rule__ObjectIdentifier__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2955:1: rule__ObjectIdentifier__Group__0__Impl : ( ( rule__ObjectIdentifier__DescriptorAssignment_0 ) ) ;
    public final void rule__ObjectIdentifier__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2959:1: ( ( ( rule__ObjectIdentifier__DescriptorAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2960:1: ( ( rule__ObjectIdentifier__DescriptorAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2960:1: ( ( rule__ObjectIdentifier__DescriptorAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2961:1: ( rule__ObjectIdentifier__DescriptorAssignment_0 )
            {
             before(grammarAccess.getObjectIdentifierAccess().getDescriptorAssignment_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2962:1: ( rule__ObjectIdentifier__DescriptorAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2962:2: rule__ObjectIdentifier__DescriptorAssignment_0
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__DescriptorAssignment_0_in_rule__ObjectIdentifier__Group__0__Impl5897);
            rule__ObjectIdentifier__DescriptorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getObjectIdentifierAccess().getDescriptorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__0__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2972:1: rule__ObjectIdentifier__Group__1 : rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2 ;
    public final void rule__ObjectIdentifier__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2976:1: ( rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2977:2: rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__1__Impl_in_rule__ObjectIdentifier__Group__15927);
            rule__ObjectIdentifier__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__2_in_rule__ObjectIdentifier__Group__15930);
            rule__ObjectIdentifier__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__1"


    // $ANTLR start "rule__ObjectIdentifier__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2984:1: rule__ObjectIdentifier__Group__1__Impl : ( 'OBJECT IDENTIFIER' ) ;
    public final void rule__ObjectIdentifier__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2988:1: ( ( 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2989:1: ( 'OBJECT IDENTIFIER' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2989:1: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2990:1: 'OBJECT IDENTIFIER'
            {
             before(grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_1()); 
            match(input,40,FOLLOW_40_in_rule__ObjectIdentifier__Group__1__Impl5958); 
             after(grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__1__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3003:1: rule__ObjectIdentifier__Group__2 : rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3 ;
    public final void rule__ObjectIdentifier__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3007:1: ( rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3008:2: rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__2__Impl_in_rule__ObjectIdentifier__Group__25989);
            rule__ObjectIdentifier__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__3_in_rule__ObjectIdentifier__Group__25992);
            rule__ObjectIdentifier__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__2"


    // $ANTLR start "rule__ObjectIdentifier__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3015:1: rule__ObjectIdentifier__Group__2__Impl : ( '::=' ) ;
    public final void rule__ObjectIdentifier__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3019:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3020:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3020:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3021:1: '::='
            {
             before(grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__ObjectIdentifier__Group__2__Impl6020); 
             after(grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__2__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3034:1: rule__ObjectIdentifier__Group__3 : rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4 ;
    public final void rule__ObjectIdentifier__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3038:1: ( rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3039:2: rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__3__Impl_in_rule__ObjectIdentifier__Group__36051);
            rule__ObjectIdentifier__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__4_in_rule__ObjectIdentifier__Group__36054);
            rule__ObjectIdentifier__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__3"


    // $ANTLR start "rule__ObjectIdentifier__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3046:1: rule__ObjectIdentifier__Group__3__Impl : ( '{' ) ;
    public final void rule__ObjectIdentifier__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3050:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3051:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3051:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3052:1: '{'
            {
             before(grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,34,FOLLOW_34_in_rule__ObjectIdentifier__Group__3__Impl6082); 
             after(grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__3__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3065:1: rule__ObjectIdentifier__Group__4 : rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5 ;
    public final void rule__ObjectIdentifier__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3069:1: ( rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3070:2: rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__4__Impl_in_rule__ObjectIdentifier__Group__46113);
            rule__ObjectIdentifier__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__5_in_rule__ObjectIdentifier__Group__46116);
            rule__ObjectIdentifier__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__4"


    // $ANTLR start "rule__ObjectIdentifier__Group__4__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3077:1: rule__ObjectIdentifier__Group__4__Impl : ( ( rule__ObjectIdentifier__OidValueAssignment_4 ) ) ;
    public final void rule__ObjectIdentifier__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3081:1: ( ( ( rule__ObjectIdentifier__OidValueAssignment_4 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3082:1: ( ( rule__ObjectIdentifier__OidValueAssignment_4 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3082:1: ( ( rule__ObjectIdentifier__OidValueAssignment_4 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3083:1: ( rule__ObjectIdentifier__OidValueAssignment_4 )
            {
             before(grammarAccess.getObjectIdentifierAccess().getOidValueAssignment_4()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3084:1: ( rule__ObjectIdentifier__OidValueAssignment_4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3084:2: rule__ObjectIdentifier__OidValueAssignment_4
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__OidValueAssignment_4_in_rule__ObjectIdentifier__Group__4__Impl6143);
            rule__ObjectIdentifier__OidValueAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getObjectIdentifierAccess().getOidValueAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__4__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3094:1: rule__ObjectIdentifier__Group__5 : rule__ObjectIdentifier__Group__5__Impl ;
    public final void rule__ObjectIdentifier__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3098:1: ( rule__ObjectIdentifier__Group__5__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3099:2: rule__ObjectIdentifier__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__5__Impl_in_rule__ObjectIdentifier__Group__56173);
            rule__ObjectIdentifier__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__5"


    // $ANTLR start "rule__ObjectIdentifier__Group__5__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3105:1: rule__ObjectIdentifier__Group__5__Impl : ( '}' ) ;
    public final void rule__ObjectIdentifier__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3109:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3110:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3110:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3111:1: '}'
            {
             before(grammarAccess.getObjectIdentifierAccess().getRightCurlyBracketKeyword_5()); 
            match(input,35,FOLLOW_35_in_rule__ObjectIdentifier__Group__5__Impl6201); 
             after(grammarAccess.getObjectIdentifierAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__Group__5__Impl"


    // $ANTLR start "rule__ObjectIdentifierValue__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3136:1: rule__ObjectIdentifierValue__Group__0 : rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1 ;
    public final void rule__ObjectIdentifierValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3140:1: ( rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3141:2: rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__0__Impl_in_rule__ObjectIdentifierValue__Group__06244);
            rule__ObjectIdentifierValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__1_in_rule__ObjectIdentifierValue__Group__06247);
            rule__ObjectIdentifierValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifierValue__Group__0"


    // $ANTLR start "rule__ObjectIdentifierValue__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3148:1: rule__ObjectIdentifierValue__Group__0__Impl : ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0 )? ) ;
    public final void rule__ObjectIdentifierValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3152:1: ( ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3153:1: ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3153:1: ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3154:1: ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0 )?
            {
             before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceAssignment_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3155:1: ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ASN1_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3155:2: rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_in_rule__ObjectIdentifierValue__Group__0__Impl6274);
                    rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifierValue__Group__0__Impl"


    // $ANTLR start "rule__ObjectIdentifierValue__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3165:1: rule__ObjectIdentifierValue__Group__1 : rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2 ;
    public final void rule__ObjectIdentifierValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3169:1: ( rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3170:2: rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__1__Impl_in_rule__ObjectIdentifierValue__Group__16305);
            rule__ObjectIdentifierValue__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__2_in_rule__ObjectIdentifierValue__Group__16308);
            rule__ObjectIdentifierValue__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifierValue__Group__1"


    // $ANTLR start "rule__ObjectIdentifierValue__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3177:1: rule__ObjectIdentifierValue__Group__1__Impl : ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) ) ;
    public final void rule__ObjectIdentifierValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3181:1: ( ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3182:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3182:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3183:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_1 )
            {
             before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_1()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3184:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3184:2: rule__ObjectIdentifierValue__SubIdsAssignment_1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_1_in_rule__ObjectIdentifierValue__Group__1__Impl6335);
            rule__ObjectIdentifierValue__SubIdsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifierValue__Group__1__Impl"


    // $ANTLR start "rule__ObjectIdentifierValue__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3194:1: rule__ObjectIdentifierValue__Group__2 : rule__ObjectIdentifierValue__Group__2__Impl ;
    public final void rule__ObjectIdentifierValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3198:1: ( rule__ObjectIdentifierValue__Group__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3199:2: rule__ObjectIdentifierValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__2__Impl_in_rule__ObjectIdentifierValue__Group__26365);
            rule__ObjectIdentifierValue__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifierValue__Group__2"


    // $ANTLR start "rule__ObjectIdentifierValue__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3205:1: rule__ObjectIdentifierValue__Group__2__Impl : ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* ) ;
    public final void rule__ObjectIdentifierValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3209:1: ( ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3210:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3210:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3211:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )*
            {
             before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_2()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3212:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_INT) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3212:2: rule__ObjectIdentifierValue__SubIdsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_2_in_rule__ObjectIdentifierValue__Group__2__Impl6392);
            	    rule__ObjectIdentifierValue__SubIdsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifierValue__Group__2__Impl"


    // $ANTLR start "rule__Module__IdAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3229:1: rule__Module__IdAssignment_0 : ( RULE_MODULE_ID ) ;
    public final void rule__Module__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3233:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3234:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3234:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3235:1: RULE_MODULE_ID
            {
             before(grammarAccess.getModuleAccess().getIdMODULE_IDTerminalRuleCall_0_0()); 
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__Module__IdAssignment_06434); 
             after(grammarAccess.getModuleAccess().getIdMODULE_IDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__IdAssignment_0"


    // $ANTLR start "rule__Module__AssignmentsAssignment_4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3244:1: rule__Module__AssignmentsAssignment_4 : ( ruleAssignment ) ;
    public final void rule__Module__AssignmentsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3248:1: ( ( ruleAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3249:1: ( ruleAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3249:1: ( ruleAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3250:1: ruleAssignment
            {
             before(grammarAccess.getModuleAccess().getAssignmentsAssignmentParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleAssignment_in_rule__Module__AssignmentsAssignment_46465);
            ruleAssignment();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getAssignmentsAssignmentParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__AssignmentsAssignment_4"


    // $ANTLR start "rule__Assignment__MacrosAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3259:1: rule__Assignment__MacrosAssignment_0 : ( ruleMacro ) ;
    public final void rule__Assignment__MacrosAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3263:1: ( ( ruleMacro ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3264:1: ( ruleMacro )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3264:1: ( ruleMacro )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3265:1: ruleMacro
            {
             before(grammarAccess.getAssignmentAccess().getMacrosMacroParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleMacro_in_rule__Assignment__MacrosAssignment_06496);
            ruleMacro();

            state._fsp--;

             after(grammarAccess.getAssignmentAccess().getMacrosMacroParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__MacrosAssignment_0"


    // $ANTLR start "rule__Assignment__TypesAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3274:1: rule__Assignment__TypesAssignment_1 : ( ruleValueAssignment ) ;
    public final void rule__Assignment__TypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3278:1: ( ( ruleValueAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3279:1: ( ruleValueAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3279:1: ( ruleValueAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3280:1: ruleValueAssignment
            {
             before(grammarAccess.getAssignmentAccess().getTypesValueAssignmentParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleValueAssignment_in_rule__Assignment__TypesAssignment_16527);
            ruleValueAssignment();

            state._fsp--;

             after(grammarAccess.getAssignmentAccess().getTypesValueAssignmentParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__TypesAssignment_1"


    // $ANTLR start "rule__Macro__DescriptorAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3289:1: rule__Macro__DescriptorAssignment_0 : ( ruleMacroDescriptor ) ;
    public final void rule__Macro__DescriptorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3293:1: ( ( ruleMacroDescriptor ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3294:1: ( ruleMacroDescriptor )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3294:1: ( ruleMacroDescriptor )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3295:1: ruleMacroDescriptor
            {
             before(grammarAccess.getMacroAccess().getDescriptorMacroDescriptorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleMacroDescriptor_in_rule__Macro__DescriptorAssignment_06558);
            ruleMacroDescriptor();

            state._fsp--;

             after(grammarAccess.getMacroAccess().getDescriptorMacroDescriptorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__DescriptorAssignment_0"


    // $ANTLR start "rule__Macro__TypeNotationsAssignment_5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3304:1: rule__Macro__TypeNotationsAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Macro__TypeNotationsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3308:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3309:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3309:1: ( ( RULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3310:1: ( RULE_ID )
            {
             before(grammarAccess.getMacroAccess().getTypeNotationsValueAssignmentCrossReference_5_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3311:1: ( RULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3312:1: RULE_ID
            {
             before(grammarAccess.getMacroAccess().getTypeNotationsValueAssignmentIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Macro__TypeNotationsAssignment_56593); 
             after(grammarAccess.getMacroAccess().getTypeNotationsValueAssignmentIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getMacroAccess().getTypeNotationsValueAssignmentCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__TypeNotationsAssignment_5"


    // $ANTLR start "rule__Macro__ValueNotationAssignment_7"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3323:1: rule__Macro__ValueNotationAssignment_7 : ( ruleMacroValue ) ;
    public final void rule__Macro__ValueNotationAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3327:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3328:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3328:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3329:1: ruleMacroValue
            {
             before(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleMacroValue_in_rule__Macro__ValueNotationAssignment_76628);
            ruleMacroValue();

            state._fsp--;

             after(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__ValueNotationAssignment_7"


    // $ANTLR start "rule__Macro__InnerTypesAssignment_8"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3338:1: rule__Macro__InnerTypesAssignment_8 : ( ruleValueAssignment ) ;
    public final void rule__Macro__InnerTypesAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3342:1: ( ( ruleValueAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3343:1: ( ruleValueAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3343:1: ( ruleValueAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3344:1: ruleValueAssignment
            {
             before(grammarAccess.getMacroAccess().getInnerTypesValueAssignmentParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleValueAssignment_in_rule__Macro__InnerTypesAssignment_86659);
            ruleValueAssignment();

            state._fsp--;

             after(grammarAccess.getMacroAccess().getInnerTypesValueAssignmentParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__InnerTypesAssignment_8"


    // $ANTLR start "rule__MacroValue__TypeAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3353:1: rule__MacroValue__TypeAssignment_2 : ( ruleMACRO_VALUE_TYPE ) ;
    public final void rule__MacroValue__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3357:1: ( ( ruleMACRO_VALUE_TYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3358:1: ( ruleMACRO_VALUE_TYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3358:1: ( ruleMACRO_VALUE_TYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3359:1: ruleMACRO_VALUE_TYPE
            {
             before(grammarAccess.getMacroValueAccess().getTypeMACRO_VALUE_TYPEEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_rule__MacroValue__TypeAssignment_26690);
            ruleMACRO_VALUE_TYPE();

            state._fsp--;

             after(grammarAccess.getMacroValueAccess().getTypeMACRO_VALUE_TYPEEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MacroValue__TypeAssignment_2"


    // $ANTLR start "rule__ValueAssignment__TypeReferenceAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3368:1: rule__ValueAssignment__TypeReferenceAssignment_0 : ( RULE_MODULE_ID ) ;
    public final void rule__ValueAssignment__TypeReferenceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3372:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3373:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3373:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3374:1: RULE_MODULE_ID
            {
             before(grammarAccess.getValueAssignmentAccess().getTypeReferenceMODULE_IDTerminalRuleCall_0_0()); 
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__ValueAssignment__TypeReferenceAssignment_06721); 
             after(grammarAccess.getValueAssignmentAccess().getTypeReferenceMODULE_IDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueAssignment__TypeReferenceAssignment_0"


    // $ANTLR start "rule__ValueAssignment__ValueAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3383:1: rule__ValueAssignment__ValueAssignment_2 : ( ruleOr ) ;
    public final void rule__ValueAssignment__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3387:1: ( ( ruleOr ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3388:1: ( ruleOr )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3388:1: ( ruleOr )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3389:1: ruleOr
            {
             before(grammarAccess.getValueAssignmentAccess().getValueOrParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleOr_in_rule__ValueAssignment__ValueAssignment_26752);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getValueAssignmentAccess().getValueOrParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueAssignment__ValueAssignment_2"


    // $ANTLR start "rule__Or__RightAssignment_1_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3398:1: rule__Or__RightAssignment_1_1 : ( ruleValueType ) ;
    public final void rule__Or__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3402:1: ( ( ruleValueType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3403:1: ( ruleValueType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3403:1: ( ruleValueType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3404:1: ruleValueType
            {
             before(grammarAccess.getOrAccess().getRightValueTypeParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleValueType_in_rule__Or__RightAssignment_1_16783);
            ruleValueType();

            state._fsp--;

             after(grammarAccess.getOrAccess().getRightValueTypeParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__RightAssignment_1_1"


    // $ANTLR start "rule__ValueType__NameAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3413:1: rule__ValueType__NameAssignment_0 : ( RULE_IA5STRING ) ;
    public final void rule__ValueType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3417:1: ( ( RULE_IA5STRING ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3418:1: ( RULE_IA5STRING )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3418:1: ( RULE_IA5STRING )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3419:1: RULE_IA5STRING
            {
             before(grammarAccess.getValueTypeAccess().getNameIA5STRINGTerminalRuleCall_0_0()); 
            match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_rule__ValueType__NameAssignment_06814); 
             after(grammarAccess.getValueTypeAccess().getNameIA5STRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__NameAssignment_0"


    // $ANTLR start "rule__ValueType__TypeAssignment_1_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3428:1: rule__ValueType__TypeAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__ValueType__TypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3432:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3433:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3433:1: ( ( RULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3434:1: ( RULE_ID )
            {
             before(grammarAccess.getValueTypeAccess().getTypeValueAssignmentCrossReference_1_0_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3435:1: ( RULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3436:1: RULE_ID
            {
             before(grammarAccess.getValueTypeAccess().getTypeValueAssignmentIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ValueType__TypeAssignment_1_06849); 
             after(grammarAccess.getValueTypeAccess().getTypeValueAssignmentIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getValueTypeAccess().getTypeValueAssignmentCrossReference_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__TypeAssignment_1_0"


    // $ANTLR start "rule__ValueType__SimpleTypeAssignment_1_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3447:1: rule__ValueType__SimpleTypeAssignment_1_1 : ( ruleASN1_TYPE ) ;
    public final void rule__ValueType__SimpleTypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3451:1: ( ( ruleASN1_TYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3452:1: ( ruleASN1_TYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3452:1: ( ruleASN1_TYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3453:1: ruleASN1_TYPE
            {
             before(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleASN1_TYPE_in_rule__ValueType__SimpleTypeAssignment_1_16884);
            ruleASN1_TYPE();

            state._fsp--;

             after(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__SimpleTypeAssignment_1_1"


    // $ANTLR start "rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3462:1: rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1 : ( ruleASN1_SUBTYPE ) ;
    public final void rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3466:1: ( ( ruleASN1_SUBTYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3467:1: ( ruleASN1_SUBTYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3467:1: ( ruleASN1_SUBTYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3468:1: ruleASN1_SUBTYPE
            {
             before(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_16915);
            ruleASN1_SUBTYPE();

            state._fsp--;

             after(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1"


    // $ANTLR start "rule__ASN1_INTEGER__ValuePairsAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3477:1: rule__ASN1_INTEGER__ValuePairsAssignment_2 : ( ruleASN1_VALUEPAIR ) ;
    public final void rule__ASN1_INTEGER__ValuePairsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3481:1: ( ( ruleASN1_VALUEPAIR ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3482:1: ( ruleASN1_VALUEPAIR )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3482:1: ( ruleASN1_VALUEPAIR )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3483:1: ruleASN1_VALUEPAIR
            {
             before(grammarAccess.getASN1_INTEGERAccess().getValuePairsASN1_VALUEPAIRParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_rule__ASN1_INTEGER__ValuePairsAssignment_26946);
            ruleASN1_VALUEPAIR();

            state._fsp--;

             after(grammarAccess.getASN1_INTEGERAccess().getValuePairsASN1_VALUEPAIRParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_INTEGER__ValuePairsAssignment_2"


    // $ANTLR start "rule__ASN1_CHOICE__ChoicesAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3492:1: rule__ASN1_CHOICE__ChoicesAssignment_2 : ( ruleASN1_CHOICE_ENTRY ) ;
    public final void rule__ASN1_CHOICE__ChoicesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3496:1: ( ( ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3497:1: ( ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3497:1: ( ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3498:1: ruleASN1_CHOICE_ENTRY
            {
             before(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_26977);
            ruleASN1_CHOICE_ENTRY();

            state._fsp--;

             after(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__ChoicesAssignment_2"


    // $ANTLR start "rule__ASN1_CHOICE__ChoicesAssignment_3_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3507:1: rule__ASN1_CHOICE__ChoicesAssignment_3_1 : ( ruleASN1_CHOICE_ENTRY ) ;
    public final void rule__ASN1_CHOICE__ChoicesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3511:1: ( ( ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3512:1: ( ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3512:1: ( ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3513:1: ruleASN1_CHOICE_ENTRY
            {
             before(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_3_17008);
            ruleASN1_CHOICE_ENTRY();

            state._fsp--;

             after(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE__ChoicesAssignment_3_1"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__IdAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3522:1: rule__ASN1_CHOICE_ENTRY__IdAssignment_0 : ( RULE_ASN1_ID ) ;
    public final void rule__ASN1_CHOICE_ENTRY__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3526:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3527:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3527:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3528:1: RULE_ASN1_ID
            {
             before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdASN1_IDTerminalRuleCall_0_0()); 
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__IdAssignment_07039); 
             after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdASN1_IDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__IdAssignment_0"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3537:1: rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3541:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3542:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3542:1: ( ( RULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3543:1: ( RULE_ID )
            {
             before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueTypeCrossReference_1_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3544:1: ( RULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3545:1: RULE_ID
            {
             before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueTypeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_17074); 
             after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueTypeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueTypeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1"


    // $ANTLR start "rule__ASN1_SUBTYPE__RangeAssignment_0_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3556:1: rule__ASN1_SUBTYPE__RangeAssignment_0_1 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SUBTYPE__RangeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3560:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3561:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3561:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3562:1: ruleASN1_RANGE
            {
             before(grammarAccess.getASN1_SUBTYPEAccess().getRangeASN1_RANGEParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangeAssignment_0_17109);
            ruleASN1_RANGE();

            state._fsp--;

             after(grammarAccess.getASN1_SUBTYPEAccess().getRangeASN1_RANGEParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SUBTYPE__RangeAssignment_0_1"


    // $ANTLR start "rule__ASN1_SUBTYPE__ValueAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3571:1: rule__ASN1_SUBTYPE__ValueAssignment_1 : ( RULE_INT ) ;
    public final void rule__ASN1_SUBTYPE__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3575:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3576:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3576:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3577:1: RULE_INT
            {
             before(grammarAccess.getASN1_SUBTYPEAccess().getValueINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_SUBTYPE__ValueAssignment_17140); 
             after(grammarAccess.getASN1_SUBTYPEAccess().getValueINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SUBTYPE__ValueAssignment_1"


    // $ANTLR start "rule__ASN1_RANGE__StartAssignment_2_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3586:1: rule__ASN1_RANGE__StartAssignment_2_0 : ( RULE_INT ) ;
    public final void rule__ASN1_RANGE__StartAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3590:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3591:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3591:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3592:1: RULE_INT
            {
             before(grammarAccess.getASN1_RANGEAccess().getStartINTTerminalRuleCall_2_0_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_RANGE__StartAssignment_2_07171); 
             after(grammarAccess.getASN1_RANGEAccess().getStartINTTerminalRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__StartAssignment_2_0"


    // $ANTLR start "rule__ASN1_RANGE__EndAssignment_2_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3601:1: rule__ASN1_RANGE__EndAssignment_2_2 : ( RULE_INT ) ;
    public final void rule__ASN1_RANGE__EndAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3605:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3606:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3606:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3607:1: RULE_INT
            {
             before(grammarAccess.getASN1_RANGEAccess().getEndINTTerminalRuleCall_2_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_RANGE__EndAssignment_2_27202); 
             after(grammarAccess.getASN1_RANGEAccess().getEndINTTerminalRuleCall_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__EndAssignment_2_2"


    // $ANTLR start "rule__ObjectIdentifier__DescriptorAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3616:1: rule__ObjectIdentifier__DescriptorAssignment_0 : ( RULE_ASN1_ID ) ;
    public final void rule__ObjectIdentifier__DescriptorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3620:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3621:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3621:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3622:1: RULE_ASN1_ID
            {
             before(grammarAccess.getObjectIdentifierAccess().getDescriptorASN1_IDTerminalRuleCall_0_0()); 
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifier__DescriptorAssignment_07233); 
             after(grammarAccess.getObjectIdentifierAccess().getDescriptorASN1_IDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__DescriptorAssignment_0"


    // $ANTLR start "rule__ObjectIdentifier__OidValueAssignment_4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3631:1: rule__ObjectIdentifier__OidValueAssignment_4 : ( ruleObjectIdentifierValue ) ;
    public final void rule__ObjectIdentifier__OidValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3635:1: ( ( ruleObjectIdentifierValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3636:1: ( ruleObjectIdentifierValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3636:1: ( ruleObjectIdentifierValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3637:1: ruleObjectIdentifierValue
            {
             before(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_rule__ObjectIdentifier__OidValueAssignment_47264);
            ruleObjectIdentifierValue();

            state._fsp--;

             after(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifier__OidValueAssignment_4"


    // $ANTLR start "rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3646:1: rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0 : ( ( RULE_ASN1_ID ) ) ;
    public final void rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3650:1: ( ( ( RULE_ASN1_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3651:1: ( ( RULE_ASN1_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3651:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3652:1: ( RULE_ASN1_ID )
            {
             before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_0()); 
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3653:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3654:1: RULE_ASN1_ID
            {
             before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierASN1_IDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_07299); 
             after(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierASN1_IDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0"


    // $ANTLR start "rule__ObjectIdentifierValue__SubIdsAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3665:1: rule__ObjectIdentifierValue__SubIdsAssignment_1 : ( RULE_INT ) ;
    public final void rule__ObjectIdentifierValue__SubIdsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3669:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3670:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3670:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3671:1: RULE_INT
            {
             before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_17334); 
             after(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifierValue__SubIdsAssignment_1"


    // $ANTLR start "rule__ObjectIdentifierValue__SubIdsAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3680:1: rule__ObjectIdentifierValue__SubIdsAssignment_2 : ( RULE_INT ) ;
    public final void rule__ObjectIdentifierValue__SubIdsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3684:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3685:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3685:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3686:1: RULE_INT
            {
             before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_27365); 
             after(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifierValue__SubIdsAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0_in_ruleModule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__Alternatives_in_ruleAssignment154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_entryRuleMacro181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacro188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__0_in_ruleMacro214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroDescriptor_in_entryRuleMacroDescriptor241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroDescriptor248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_ruleMacroDescriptor274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__0_in_ruleMacroValue333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueAssignment_in_entryRuleValueAssignment360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueAssignment367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueAssignment__Group__0_in_ruleValueAssignment393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOr_in_entryRuleOr420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOr427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Or__Group__0_in_ruleOr453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Group__0_in_ruleValueType513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_TYPE__Alternatives_in_ruleASN1_TYPE573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Alternatives_in_ruleASN1_SIMPLE633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__0_in_ruleASN1_OCTET_STRING693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__0_in_ruleASN1_INTEGER753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__0_in_ruleASN1_VALUEPAIR813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__0_in_ruleASN1_CHOICE873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0_in_ruleASN1_CHOICE_ENTRY933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Alternatives_in_ruleASN1_SUBTYPE993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE1020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group__0_in_ruleASN1_RANGE1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier1080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifier1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__0_in_ruleObjectIdentifier1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue1140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifierValue1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__0_in_ruleObjectIdentifierValue1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__Alternatives_in_ruleMACRO_VALUE_TYPE1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__MacrosAssignment_0_in_rule__Assignment__Alternatives1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__TypesAssignment_1_in_rule__Assignment__Alternatives1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_rule__Assignment__Alternatives1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__TypeAssignment_1_0_in_rule__ValueType__Alternatives_11315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__SimpleTypeAssignment_1_1_in_rule__ValueType__Alternatives_11333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_rule__ASN1_TYPE__Alternatives1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_rule__ASN1_TYPE__Alternatives1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__0_in_rule__ASN1_SIMPLE__Alternatives1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_rule__ASN1_SIMPLE__Alternatives1433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__0_in_rule__ASN1_SIMPLE__Alternatives1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_0__0_in_rule__ASN1_SUBTYPE__Alternatives1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__ValueAssignment_1_in_rule__ASN1_SUBTYPE__Alternatives1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__MACRO_VALUE_TYPE__Alternatives1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__MACRO_VALUE_TYPE__Alternatives1556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__01590 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Module__Group__1_in_rule__Module__Group__01593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__IdAssignment_0_in_rule__Module__Group__0__Impl1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__11650 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Module__Group__2_in_rule__Module__Group__11653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Module__Group__1__Impl1681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__21712 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Module__Group__3_in_rule__Module__Group__21715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Module__Group__2__Impl1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__3__Impl_in_rule__Module__Group__31774 = new BitSet(new long[]{0x0000000000800210L});
    public static final BitSet FOLLOW_rule__Module__Group__4_in_rule__Module__Group__31777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Module__Group__3__Impl1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__4__Impl_in_rule__Module__Group__41836 = new BitSet(new long[]{0x0000000000800210L});
    public static final BitSet FOLLOW_rule__Module__Group__5_in_rule__Module__Group__41839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__AssignmentsAssignment_4_in_rule__Module__Group__4__Impl1866 = new BitSet(new long[]{0x0000000000000212L});
    public static final BitSet FOLLOW_rule__Module__Group__5__Impl_in_rule__Module__Group__51897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Module__Group__5__Impl1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__0__Impl_in_rule__Macro__Group__01968 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__1_in_rule__Macro__Group__01971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__DescriptorAssignment_0_in_rule__Macro__Group__0__Impl1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__1__Impl_in_rule__Macro__Group__12028 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Macro__Group__2_in_rule__Macro__Group__12031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Macro__Group__1__Impl2059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__2__Impl_in_rule__Macro__Group__22090 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Macro__Group__3_in_rule__Macro__Group__22093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Macro__Group__2__Impl2121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__3__Impl_in_rule__Macro__Group__32152 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__4_in_rule__Macro__Group__32155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Macro__Group__3__Impl2183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__4__Impl_in_rule__Macro__Group__42214 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Macro__Group__5_in_rule__Macro__Group__42217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Macro__Group__4__Impl2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__5__Impl_in_rule__Macro__Group__52276 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__6_in_rule__Macro__Group__52279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__TypeNotationsAssignment_5_in_rule__Macro__Group__5__Impl2308 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_rule__Macro__TypeNotationsAssignment_5_in_rule__Macro__Group__5__Impl2320 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_rule__Macro__Group__6__Impl_in_rule__Macro__Group__62353 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__7_in_rule__Macro__Group__62356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Macro__Group__6__Impl2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__7__Impl_in_rule__Macro__Group__72415 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__8_in_rule__Macro__Group__72418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__ValueNotationAssignment_7_in_rule__Macro__Group__7__Impl2445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__8__Impl_in_rule__Macro__Group__82475 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Macro__Group__9_in_rule__Macro__Group__82478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__InnerTypesAssignment_8_in_rule__Macro__Group__8__Impl2507 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__InnerTypesAssignment_8_in_rule__Macro__Group__8__Impl2519 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__Group__9__Impl_in_rule__Macro__Group__92552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Macro__Group__9__Impl2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__0__Impl_in_rule__MacroValue__Group__02631 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__1_in_rule__MacroValue__Group__02634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__1__Impl_in_rule__MacroValue__Group__12692 = new BitSet(new long[]{0x00000000000C0020L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__2_in_rule__MacroValue__Group__12695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__MacroValue__Group__1__Impl2723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__2__Impl_in_rule__MacroValue__Group__22754 = new BitSet(new long[]{0x00000000000C0020L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__3_in_rule__MacroValue__Group__22757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__TypeAssignment_2_in_rule__MacroValue__Group__2__Impl2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__3__Impl_in_rule__MacroValue__Group__32815 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__4_in_rule__MacroValue__Group__32818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_rule__MacroValue__Group__3__Impl2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__4__Impl_in_rule__MacroValue__Group__42874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__MacroValue__Group__4__Impl2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueAssignment__Group__0__Impl_in_rule__ValueAssignment__Group__02943 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ValueAssignment__Group__1_in_rule__ValueAssignment__Group__02946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueAssignment__TypeReferenceAssignment_0_in_rule__ValueAssignment__Group__0__Impl2973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueAssignment__Group__1__Impl_in_rule__ValueAssignment__Group__13003 = new BitSet(new long[]{0x00000012800000C0L});
    public static final BitSet FOLLOW_rule__ValueAssignment__Group__2_in_rule__ValueAssignment__Group__13006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ValueAssignment__Group__1__Impl3034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueAssignment__Group__2__Impl_in_rule__ValueAssignment__Group__23065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueAssignment__ValueAssignment_2_in_rule__ValueAssignment__Group__2__Impl3092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Or__Group__0__Impl_in_rule__Or__Group__03128 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Or__Group__1_in_rule__Or__Group__03131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Or__Group__0__Impl3158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Or__Group__1__Impl_in_rule__Or__Group__13187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Or__Group_1__0_in_rule__Or__Group__1__Impl3214 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_rule__Or__Group_1__0__Impl_in_rule__Or__Group_1__03249 = new BitSet(new long[]{0x00000012800000C0L});
    public static final BitSet FOLLOW_rule__Or__Group_1__1_in_rule__Or__Group_1__03252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Or__Group_1_0__0_in_rule__Or__Group_1__0__Impl3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Or__Group_1__1__Impl_in_rule__Or__Group_1__13309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Or__RightAssignment_1_1_in_rule__Or__Group_1__1__Impl3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Or__Group_1_0__0__Impl_in_rule__Or__Group_1_0__03370 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Or__Group_1_0__1_in_rule__Or__Group_1_0__03373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Or__Group_1_0__1__Impl_in_rule__Or__Group_1_0__13431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Or__Group_1_0__1__Impl3459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__03494 = new BitSet(new long[]{0x00000012800000C0L});
    public static final BitSet FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__03497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__NameAssignment_0_in_rule__ValueType__Group__0__Impl3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__13555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Alternatives_1_in_rule__ValueType__Group__1__Impl3582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__0__Impl_in_rule__ASN1_SIMPLE__Group_0__03616 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__1_in_rule__ASN1_SIMPLE__Group_0__03619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__1__Impl_in_rule__ASN1_SIMPLE__Group_0__13677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_rule__ASN1_SIMPLE__Group_0__1__Impl3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__0__Impl_in_rule__ASN1_SIMPLE__Group_2__03737 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__1_in_rule__ASN1_SIMPLE__Group_2__03740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_rule__ASN1_SIMPLE__Group_2__0__Impl3767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__1__Impl_in_rule__ASN1_SIMPLE__Group_2__13796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2_1__0_in_rule__ASN1_SIMPLE__Group_2__1__Impl3823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2_1__0__Impl_in_rule__ASN1_SIMPLE__Group_2_1__03858 = new BitSet(new long[]{0x0000004000000100L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2_1__1_in_rule__ASN1_SIMPLE__Group_2_1__03861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ASN1_SIMPLE__Group_2_1__0__Impl3889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2_1__1__Impl_in_rule__ASN1_SIMPLE__Group_2_1__13920 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2_1__2_in_rule__ASN1_SIMPLE__Group_2_1__13923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_1_in_rule__ASN1_SIMPLE__Group_2_1__1__Impl3950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2_1__2__Impl_in_rule__ASN1_SIMPLE__Group_2_1__23980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ASN1_SIMPLE__Group_2_1__2__Impl4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__0__Impl_in_rule__ASN1_OCTET_STRING__Group__04045 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__1_in_rule__ASN1_OCTET_STRING__Group__04048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__1__Impl_in_rule__ASN1_OCTET_STRING__Group__14106 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__2_in_rule__ASN1_OCTET_STRING__Group__14109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ASN1_OCTET_STRING__Group__1__Impl4137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__2__Impl_in_rule__ASN1_OCTET_STRING__Group__24168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ASN1_OCTET_STRING__Group__2__Impl4196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__0__Impl_in_rule__ASN1_INTEGER__Group__04233 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__1_in_rule__ASN1_INTEGER__Group__04236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ASN1_INTEGER__Group__0__Impl4264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__1__Impl_in_rule__ASN1_INTEGER__Group__14295 = new BitSet(new long[]{0x0000000040000080L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__2_in_rule__ASN1_INTEGER__Group__14298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ASN1_INTEGER__Group__1__Impl4326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__2__Impl_in_rule__ASN1_INTEGER__Group__24357 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__3_in_rule__ASN1_INTEGER__Group__24360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl4389 = new BitSet(new long[]{0x0000000040000082L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl4401 = new BitSet(new long[]{0x0000000040000082L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__3__Impl_in_rule__ASN1_INTEGER__Group__34434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ASN1_INTEGER__Group__3__Impl4462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__0__Impl_in_rule__ASN1_VALUEPAIR__Group__04501 = new BitSet(new long[]{0x0000000040000080L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__1_in_rule__ASN1_VALUEPAIR__Group__04504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ASN1_VALUEPAIR__Group__0__Impl4532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__1__Impl_in_rule__ASN1_VALUEPAIR__Group__14563 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__2_in_rule__ASN1_VALUEPAIR__Group__14566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ASN1_VALUEPAIR__Group__1__Impl4594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__2__Impl_in_rule__ASN1_VALUEPAIR__Group__24625 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__3_in_rule__ASN1_VALUEPAIR__Group__24628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_VALUEPAIR__Group__2__Impl4655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__3__Impl_in_rule__ASN1_VALUEPAIR__Group__34684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ASN1_VALUEPAIR__Group__3__Impl4712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__0__Impl_in_rule__ASN1_CHOICE__Group__04751 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__1_in_rule__ASN1_CHOICE__Group__04754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ASN1_CHOICE__Group__0__Impl4782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__1__Impl_in_rule__ASN1_CHOICE__Group__14813 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__2_in_rule__ASN1_CHOICE__Group__14816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ASN1_CHOICE__Group__1__Impl4844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__2__Impl_in_rule__ASN1_CHOICE__Group__24875 = new BitSet(new long[]{0x0000002800000000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__3_in_rule__ASN1_CHOICE__Group__24878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_2_in_rule__ASN1_CHOICE__Group__2__Impl4905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__3__Impl_in_rule__ASN1_CHOICE__Group__34935 = new BitSet(new long[]{0x0000002800000000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__4_in_rule__ASN1_CHOICE__Group__34938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__0_in_rule__ASN1_CHOICE__Group__3__Impl4965 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__4__Impl_in_rule__ASN1_CHOICE__Group__44996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ASN1_CHOICE__Group__4__Impl5024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__0__Impl_in_rule__ASN1_CHOICE__Group_3__05065 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__1_in_rule__ASN1_CHOICE__Group_3__05068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ASN1_CHOICE__Group_3__0__Impl5096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__1__Impl_in_rule__ASN1_CHOICE__Group_3__15127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_3_1_in_rule__ASN1_CHOICE__Group_3__1__Impl5154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__05188 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1_in_rule__ASN1_CHOICE_ENTRY__Group__05191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__IdAssignment_0_in_rule__ASN1_CHOICE_ENTRY__Group__0__Impl5218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__15248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1_in_rule__ASN1_CHOICE_ENTRY__Group__1__Impl5275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_0__0__Impl_in_rule__ASN1_SUBTYPE__Group_0__05309 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_0__1_in_rule__ASN1_SUBTYPE__Group_0__05312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ASN1_SUBTYPE__Group_0__0__Impl5340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_0__1__Impl_in_rule__ASN1_SUBTYPE__Group_0__15371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__RangeAssignment_0_1_in_rule__ASN1_SUBTYPE__Group_0__1__Impl5398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group__0__Impl_in_rule__ASN1_RANGE__Group__05432 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group__1_in_rule__ASN1_RANGE__Group__05435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group__1__Impl_in_rule__ASN1_RANGE__Group__15493 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group__2_in_rule__ASN1_RANGE__Group__15496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ASN1_RANGE__Group__1__Impl5524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group__2__Impl_in_rule__ASN1_RANGE__Group__25555 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group__3_in_rule__ASN1_RANGE__Group__25558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_2__0_in_rule__ASN1_RANGE__Group__2__Impl5585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group__3__Impl_in_rule__ASN1_RANGE__Group__35615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ASN1_RANGE__Group__3__Impl5643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_2__0__Impl_in_rule__ASN1_RANGE__Group_2__05682 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_2__1_in_rule__ASN1_RANGE__Group_2__05685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__StartAssignment_2_0_in_rule__ASN1_RANGE__Group_2__0__Impl5712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_2__1__Impl_in_rule__ASN1_RANGE__Group_2__15742 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_2__2_in_rule__ASN1_RANGE__Group_2__15745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ASN1_RANGE__Group_2__1__Impl5773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_2__2__Impl_in_rule__ASN1_RANGE__Group_2__25804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__EndAssignment_2_2_in_rule__ASN1_RANGE__Group_2__2__Impl5831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__0__Impl_in_rule__ObjectIdentifier__Group__05867 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__1_in_rule__ObjectIdentifier__Group__05870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__DescriptorAssignment_0_in_rule__ObjectIdentifier__Group__0__Impl5897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__1__Impl_in_rule__ObjectIdentifier__Group__15927 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__2_in_rule__ObjectIdentifier__Group__15930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ObjectIdentifier__Group__1__Impl5958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__2__Impl_in_rule__ObjectIdentifier__Group__25989 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__3_in_rule__ObjectIdentifier__Group__25992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ObjectIdentifier__Group__2__Impl6020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__3__Impl_in_rule__ObjectIdentifier__Group__36051 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__4_in_rule__ObjectIdentifier__Group__36054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ObjectIdentifier__Group__3__Impl6082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__4__Impl_in_rule__ObjectIdentifier__Group__46113 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__5_in_rule__ObjectIdentifier__Group__46116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__OidValueAssignment_4_in_rule__ObjectIdentifier__Group__4__Impl6143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__5__Impl_in_rule__ObjectIdentifier__Group__56173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ObjectIdentifier__Group__5__Impl6201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__0__Impl_in_rule__ObjectIdentifierValue__Group__06244 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__1_in_rule__ObjectIdentifierValue__Group__06247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_in_rule__ObjectIdentifierValue__Group__0__Impl6274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__1__Impl_in_rule__ObjectIdentifierValue__Group__16305 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__2_in_rule__ObjectIdentifierValue__Group__16308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_1_in_rule__ObjectIdentifierValue__Group__1__Impl6335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__2__Impl_in_rule__ObjectIdentifierValue__Group__26365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_2_in_rule__ObjectIdentifierValue__Group__2__Impl6392 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__Module__IdAssignment_06434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_rule__Module__AssignmentsAssignment_46465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_rule__Assignment__MacrosAssignment_06496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueAssignment_in_rule__Assignment__TypesAssignment_16527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroDescriptor_in_rule__Macro__DescriptorAssignment_06558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Macro__TypeNotationsAssignment_56593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__Macro__ValueNotationAssignment_76628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueAssignment_in_rule__Macro__InnerTypesAssignment_86659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_rule__MacroValue__TypeAssignment_26690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__ValueAssignment__TypeReferenceAssignment_06721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOr_in_rule__ValueAssignment__ValueAssignment_26752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Or__RightAssignment_1_16783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_rule__ValueType__NameAssignment_06814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ValueType__TypeAssignment_1_06849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_rule__ValueType__SimpleTypeAssignment_1_16884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_16915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_rule__ASN1_INTEGER__ValuePairsAssignment_26946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_26977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_3_17008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__IdAssignment_07039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_17074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangeAssignment_0_17109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_SUBTYPE__ValueAssignment_17140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_RANGE__StartAssignment_2_07171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_RANGE__EndAssignment_2_27202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifier__DescriptorAssignment_07233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_rule__ObjectIdentifier__OidValueAssignment_47264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_07299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_17334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_27365 = new BitSet(new long[]{0x0000000000000002L});

}