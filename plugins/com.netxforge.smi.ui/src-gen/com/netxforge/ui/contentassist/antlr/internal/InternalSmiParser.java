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
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSmiParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ASN1_ID", "RULE_IA5STRING", "RULE_ID", "RULE_INT", "RULE_MODULE_ID", "RULE_PARAMETER", "RULE_ALPHA_CAP", "RULE_ALPHA", "RULE_NUMERIC", "RULE_SL_ASN1_COMMENT", "RULE_WS", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'OBJECT IDENTIFIER'", "'IA5String'", "'DEFINITIONS'", "'::='", "'BEGIN'", "'END'", "'{'", "'}'", "'MACRO'", "'TYPE NOTATION'", "'VALUE NOTATION'", "'|'", "'value'", "'('", "')'", "'Update'", "'empty'", "'OCTET STRING'", "'INTEGER'", "'SIZE'", "'..'", "'CHOICE'", "','", "'VALUE'"
    };
    public static final int T__42=42;
    public static final int RULE_ID=6;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_ALPHA_CAP=10;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int RULE_IA5STRING=5;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=18;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_ASN1_ID=4;
    public static final int RULE_ALPHA=11;
    public static final int RULE_SL_COMMENT=17;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=16;
    public static final int RULE_MODULE_ID=8;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=15;
    public static final int T__32=32;
    public static final int RULE_NUMERIC=12;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_INT=7;
    public static final int RULE_WS=14;
    public static final int RULE_SL_ASN1_COMMENT=13;
    public static final int RULE_PARAMETER=9;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:61:1: entryRuleModule : ruleModule EOF ;
    public final void entryRuleModule() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:62:1: ( ruleModule EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:63:1: ruleModule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleRule()); 
            }
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule67);
            ruleModule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule74); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:70:1: ruleModule : ( ( rule__Module__Group__0 ) ) ;
    public final void ruleModule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:74:2: ( ( ( rule__Module__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:75:1: ( ( rule__Module__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:75:1: ( ( rule__Module__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:76:1: ( rule__Module__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:77:1: ( rule__Module__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:77:2: rule__Module__Group__0
            {
            pushFollow(FOLLOW_rule__Module__Group__0_in_ruleModule100);
            rule__Module__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getGroup()); 
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
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:89:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:90:1: ( ruleAssignment EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:91:1: ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment127);
            ruleAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment134); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:98:1: ruleAssignment : ( ( rule__Assignment__Alternatives ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:102:2: ( ( ( rule__Assignment__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:103:1: ( ( rule__Assignment__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:103:1: ( ( rule__Assignment__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:104:1: ( rule__Assignment__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:105:1: ( rule__Assignment__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:105:2: rule__Assignment__Alternatives
            {
            pushFollow(FOLLOW_rule__Assignment__Alternatives_in_ruleAssignment160);
            rule__Assignment__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getAlternatives()); 
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
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleObjectIdentifier"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:117:1: entryRuleObjectIdentifier : ruleObjectIdentifier EOF ;
    public final void entryRuleObjectIdentifier() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:118:1: ( ruleObjectIdentifier EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:119:1: ruleObjectIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier187);
            ruleObjectIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifier194); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:126:1: ruleObjectIdentifier : ( ( rule__ObjectIdentifier__Group__0 ) ) ;
    public final void ruleObjectIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:130:2: ( ( ( rule__ObjectIdentifier__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:131:1: ( ( rule__ObjectIdentifier__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:131:1: ( ( rule__ObjectIdentifier__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:132:1: ( rule__ObjectIdentifier__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:133:1: ( rule__ObjectIdentifier__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:133:2: rule__ObjectIdentifier__Group__0
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__0_in_ruleObjectIdentifier220);
            rule__ObjectIdentifier__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getGroup()); 
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
    // $ANTLR end "ruleObjectIdentifier"


    // $ANTLR start "entryRuleObjectIdentifierValue"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:145:1: entryRuleObjectIdentifierValue : ruleObjectIdentifierValue EOF ;
    public final void entryRuleObjectIdentifierValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:146:1: ( ruleObjectIdentifierValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:147:1: ruleObjectIdentifierValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue247);
            ruleObjectIdentifierValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifierValue254); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:154:1: ruleObjectIdentifierValue : ( ( rule__ObjectIdentifierValue__Group__0 ) ) ;
    public final void ruleObjectIdentifierValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:158:2: ( ( ( rule__ObjectIdentifierValue__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:159:1: ( ( rule__ObjectIdentifierValue__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:159:1: ( ( rule__ObjectIdentifierValue__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:160:1: ( rule__ObjectIdentifierValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:161:1: ( rule__ObjectIdentifierValue__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:161:2: rule__ObjectIdentifierValue__Group__0
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__0_in_ruleObjectIdentifierValue280);
            rule__ObjectIdentifierValue__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getGroup()); 
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
    // $ANTLR end "ruleObjectIdentifierValue"


    // $ANTLR start "entryRuleTypeDefinition"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:173:1: entryRuleTypeDefinition : ruleTypeDefinition EOF ;
    public final void entryRuleTypeDefinition() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:174:1: ( ruleTypeDefinition EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:175:1: ruleTypeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition307);
            ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDefinition314); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTypeDefinition"


    // $ANTLR start "ruleTypeDefinition"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:182:1: ruleTypeDefinition : ( ( rule__TypeDefinition__Group__0 ) ) ;
    public final void ruleTypeDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:186:2: ( ( ( rule__TypeDefinition__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:187:1: ( ( rule__TypeDefinition__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:187:1: ( ( rule__TypeDefinition__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:188:1: ( rule__TypeDefinition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:189:1: ( rule__TypeDefinition__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:189:2: rule__TypeDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__0_in_ruleTypeDefinition340);
            rule__TypeDefinition__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getGroup()); 
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
    // $ANTLR end "ruleTypeDefinition"


    // $ANTLR start "entryRuleMacro"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:201:1: entryRuleMacro : ruleMacro EOF ;
    public final void entryRuleMacro() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:202:1: ( ruleMacro EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:203:1: ruleMacro EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroRule()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_entryRuleMacro367);
            ruleMacro();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacro374); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:210:1: ruleMacro : ( ( rule__Macro__Group__0 ) ) ;
    public final void ruleMacro() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:214:2: ( ( ( rule__Macro__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:215:1: ( ( rule__Macro__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:215:1: ( ( rule__Macro__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:216:1: ( rule__Macro__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:217:1: ( rule__Macro__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:217:2: rule__Macro__Group__0
            {
            pushFollow(FOLLOW_rule__Macro__Group__0_in_ruleMacro400);
            rule__Macro__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getGroup()); 
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
    // $ANTLR end "ruleMacro"


    // $ANTLR start "entryRuleTypeAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:229:1: entryRuleTypeAssignment : ruleTypeAssignment EOF ;
    public final void entryRuleTypeAssignment() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:230:1: ( ruleTypeAssignment EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:231:1: ruleTypeAssignment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment427);
            ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAssignmentRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAssignment434); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTypeAssignment"


    // $ANTLR start "ruleTypeAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:238:1: ruleTypeAssignment : ( ( rule__TypeAssignment__Alternatives ) ) ;
    public final void ruleTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:242:2: ( ( ( rule__TypeAssignment__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:243:1: ( ( rule__TypeAssignment__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:243:1: ( ( rule__TypeAssignment__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:244:1: ( rule__TypeAssignment__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:245:1: ( rule__TypeAssignment__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:245:2: rule__TypeAssignment__Alternatives
            {
            pushFollow(FOLLOW_rule__TypeAssignment__Alternatives_in_ruleTypeAssignment460);
            rule__TypeAssignment__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAssignmentAccess().getAlternatives()); 
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
    // $ANTLR end "ruleTypeAssignment"


    // $ANTLR start "entryRuleParamAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:257:1: entryRuleParamAssignment : ruleParamAssignment EOF ;
    public final void entryRuleParamAssignment() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:258:1: ( ruleParamAssignment EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:259:1: ruleParamAssignment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment487);
            ruleParamAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAssignmentRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamAssignment494); if (state.failed) return ;

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
    // $ANTLR end "entryRuleParamAssignment"


    // $ANTLR start "ruleParamAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:266:1: ruleParamAssignment : ( ( rule__ParamAssignment__Group__0 ) ) ;
    public final void ruleParamAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:270:2: ( ( ( rule__ParamAssignment__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:271:1: ( ( rule__ParamAssignment__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:271:1: ( ( rule__ParamAssignment__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:272:1: ( rule__ParamAssignment__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:273:1: ( rule__ParamAssignment__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:273:2: rule__ParamAssignment__Group__0
            {
            pushFollow(FOLLOW_rule__ParamAssignment__Group__0_in_ruleParamAssignment520);
            rule__ParamAssignment__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAssignmentAccess().getGroup()); 
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
    // $ANTLR end "ruleParamAssignment"


    // $ANTLR start "entryRuleTypeNotation"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:285:1: entryRuleTypeNotation : ruleTypeNotation EOF ;
    public final void entryRuleTypeNotation() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:286:1: ( ruleTypeNotation EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:287:1: ruleTypeNotation EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation547);
            ruleTypeNotation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotation554); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTypeNotation"


    // $ANTLR start "ruleTypeNotation"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:294:1: ruleTypeNotation : ( ( rule__TypeNotation__Alternatives ) ) ;
    public final void ruleTypeNotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:298:2: ( ( ( rule__TypeNotation__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:299:1: ( ( rule__TypeNotation__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:299:1: ( ( rule__TypeNotation__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:300:1: ( rule__TypeNotation__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:301:1: ( rule__TypeNotation__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:301:2: rule__TypeNotation__Alternatives
            {
            pushFollow(FOLLOW_rule__TypeNotation__Alternatives_in_ruleTypeNotation580);
            rule__TypeNotation__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getAlternatives()); 
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
    // $ANTLR end "ruleTypeNotation"


    // $ANTLR start "entryRuleTypeReferenceExt"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:313:1: entryRuleTypeReferenceExt : ruleTypeReferenceExt EOF ;
    public final void entryRuleTypeReferenceExt() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:314:1: ( ruleTypeReferenceExt EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:315:1: ruleTypeReferenceExt EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt607);
            ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceExtRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReferenceExt614); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTypeReferenceExt"


    // $ANTLR start "ruleTypeReferenceExt"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:322:1: ruleTypeReferenceExt : ( ( rule__TypeReferenceExt__Group__0 ) ) ;
    public final void ruleTypeReferenceExt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:326:2: ( ( ( rule__TypeReferenceExt__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:327:1: ( ( rule__TypeReferenceExt__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:327:1: ( ( rule__TypeReferenceExt__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:328:1: ( rule__TypeReferenceExt__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:329:1: ( rule__TypeReferenceExt__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:329:2: rule__TypeReferenceExt__Group__0
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__0_in_ruleTypeReferenceExt640);
            rule__TypeReferenceExt__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceExtAccess().getGroup()); 
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
    // $ANTLR end "ruleTypeReferenceExt"


    // $ANTLR start "entryRuleTypeReference"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:341:1: entryRuleTypeReference : ruleTypeReference EOF ;
    public final void entryRuleTypeReference() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:342:1: ( ruleTypeReference EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:343:1: ruleTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_entryRuleTypeReference667);
            ruleTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReference674); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTypeReference"


    // $ANTLR start "ruleTypeReference"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:350:1: ruleTypeReference : ( ( rule__TypeReference__TypeAssignment ) ) ;
    public final void ruleTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:354:2: ( ( ( rule__TypeReference__TypeAssignment ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:355:1: ( ( rule__TypeReference__TypeAssignment ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:355:1: ( ( rule__TypeReference__TypeAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:356:1: ( rule__TypeReference__TypeAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceAccess().getTypeAssignment()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:357:1: ( rule__TypeReference__TypeAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:357:2: rule__TypeReference__TypeAssignment
            {
            pushFollow(FOLLOW_rule__TypeReference__TypeAssignment_in_ruleTypeReference700);
            rule__TypeReference__TypeAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceAccess().getTypeAssignment()); 
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
    // $ANTLR end "ruleTypeReference"


    // $ANTLR start "entryRuleScope"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:369:1: entryRuleScope : ruleScope EOF ;
    public final void entryRuleScope() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:370:1: ( ruleScope EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:371:1: ruleScope EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScopeRule()); 
            }
            pushFollow(FOLLOW_ruleScope_in_entryRuleScope727);
            ruleScope();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScopeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScope734); if (state.failed) return ;

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
    // $ANTLR end "entryRuleScope"


    // $ANTLR start "ruleScope"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:378:1: ruleScope : ( ( rule__Scope__ScopeAssignment ) ) ;
    public final void ruleScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:382:2: ( ( ( rule__Scope__ScopeAssignment ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:383:1: ( ( rule__Scope__ScopeAssignment ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:383:1: ( ( rule__Scope__ScopeAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:384:1: ( rule__Scope__ScopeAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScopeAccess().getScopeAssignment()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:385:1: ( rule__Scope__ScopeAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:385:2: rule__Scope__ScopeAssignment
            {
            pushFollow(FOLLOW_rule__Scope__ScopeAssignment_in_ruleScope760);
            rule__Scope__ScopeAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScopeAccess().getScopeAssignment()); 
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
    // $ANTLR end "ruleScope"


    // $ANTLR start "entryRuleValue"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:397:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:398:1: ( ruleValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:399:1: ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue787);
            ruleValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue794); if (state.failed) return ;

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
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:406:1: ruleValue : ( ( rule__Value__Group__0 ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:410:2: ( ( ( rule__Value__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:411:1: ( ( rule__Value__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:411:1: ( ( rule__Value__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:412:1: ( rule__Value__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:413:1: ( rule__Value__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:413:2: rule__Value__Group__0
            {
            pushFollow(FOLLOW_rule__Value__Group__0_in_ruleValue820);
            rule__Value__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getGroup()); 
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
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleValueType"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:425:1: entryRuleValueType : ruleValueType EOF ;
    public final void entryRuleValueType() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:426:1: ( ruleValueType EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:427:1: ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType847);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType854); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:434:1: ruleValueType : ( ( rule__ValueType__Group__0 ) ) ;
    public final void ruleValueType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:438:2: ( ( ( rule__ValueType__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:439:1: ( ( rule__ValueType__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:439:1: ( ( rule__ValueType__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:440:1: ( rule__ValueType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:441:1: ( rule__ValueType__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:441:2: rule__ValueType__Group__0
            {
            pushFollow(FOLLOW_rule__ValueType__Group__0_in_ruleValueType880);
            rule__ValueType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getGroup()); 
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
    // $ANTLR end "ruleValueType"


    // $ANTLR start "entryRuleMacroValue"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:453:1: entryRuleMacroValue : ruleMacroValue EOF ;
    public final void entryRuleMacroValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:454:1: ( ruleMacroValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:455:1: ruleMacroValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue907);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue914); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:462:1: ruleMacroValue : ( ( rule__MacroValue__Group__0 ) ) ;
    public final void ruleMacroValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:466:2: ( ( ( rule__MacroValue__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:467:1: ( ( rule__MacroValue__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:467:1: ( ( rule__MacroValue__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:468:1: ( rule__MacroValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:469:1: ( rule__MacroValue__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:469:2: rule__MacroValue__Group__0
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__0_in_ruleMacroValue940);
            rule__MacroValue__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueAccess().getGroup()); 
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
    // $ANTLR end "ruleMacroValue"


    // $ANTLR start "entryRuleMACRO_VALUE_TYPE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:481:1: entryRuleMACRO_VALUE_TYPE : ruleMACRO_VALUE_TYPE EOF ;
    public final void entryRuleMACRO_VALUE_TYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:482:1: ( ruleMACRO_VALUE_TYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:483:1: ruleMACRO_VALUE_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE967);
            ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE974); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMACRO_VALUE_TYPE"


    // $ANTLR start "ruleMACRO_VALUE_TYPE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:490:1: ruleMACRO_VALUE_TYPE : ( ( rule__MACRO_VALUE_TYPE__Alternatives ) ) ;
    public final void ruleMACRO_VALUE_TYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:494:2: ( ( ( rule__MACRO_VALUE_TYPE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:495:1: ( ( rule__MACRO_VALUE_TYPE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:495:1: ( ( rule__MACRO_VALUE_TYPE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:496:1: ( rule__MACRO_VALUE_TYPE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:497:1: ( rule__MACRO_VALUE_TYPE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:497:2: rule__MACRO_VALUE_TYPE__Alternatives
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__Alternatives_in_ruleMACRO_VALUE_TYPE1000);
            rule__MACRO_VALUE_TYPE__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPEAccess().getAlternatives()); 
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
    // $ANTLR end "ruleMACRO_VALUE_TYPE"


    // $ANTLR start "entryRuleUpdateType"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:509:1: entryRuleUpdateType : ruleUpdateType EOF ;
    public final void entryRuleUpdateType() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:510:1: ( ruleUpdateType EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:511:1: ruleUpdateType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_entryRuleUpdateType1027);
            ruleUpdateType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpdateType1034); if (state.failed) return ;

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
    // $ANTLR end "entryRuleUpdateType"


    // $ANTLR start "ruleUpdateType"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:518:1: ruleUpdateType : ( ( rule__UpdateType__Group__0 ) ) ;
    public final void ruleUpdateType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:522:2: ( ( ( rule__UpdateType__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:523:1: ( ( rule__UpdateType__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:523:1: ( ( rule__UpdateType__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:524:1: ( rule__UpdateType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:525:1: ( rule__UpdateType__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:525:2: rule__UpdateType__Group__0
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__0_in_ruleUpdateType1060);
            rule__UpdateType__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateTypeAccess().getGroup()); 
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
    // $ANTLR end "ruleUpdateType"


    // $ANTLR start "entryRuleMACRO_VALUE_CAP"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:537:1: entryRuleMACRO_VALUE_CAP : ruleMACRO_VALUE_CAP EOF ;
    public final void entryRuleMACRO_VALUE_CAP() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:538:1: ( ruleMACRO_VALUE_CAP EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:539:1: ruleMACRO_VALUE_CAP EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP1087);
            ruleMACRO_VALUE_CAP();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP1094); if (state.failed) return ;

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
    // $ANTLR end "entryRuleMACRO_VALUE_CAP"


    // $ANTLR start "ruleMACRO_VALUE_CAP"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:546:1: ruleMACRO_VALUE_CAP : ( ( rule__MACRO_VALUE_CAP__Group__0 ) ) ;
    public final void ruleMACRO_VALUE_CAP() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:550:2: ( ( ( rule__MACRO_VALUE_CAP__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:551:1: ( ( rule__MACRO_VALUE_CAP__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:551:1: ( ( rule__MACRO_VALUE_CAP__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:552:1: ( rule__MACRO_VALUE_CAP__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:553:1: ( rule__MACRO_VALUE_CAP__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:553:2: rule__MACRO_VALUE_CAP__Group__0
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__Group__0_in_ruleMACRO_VALUE_CAP1120);
            rule__MACRO_VALUE_CAP__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPAccess().getGroup()); 
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
    // $ANTLR end "ruleMACRO_VALUE_CAP"


    // $ANTLR start "entryRuleASN1_TYPE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:565:1: entryRuleASN1_TYPE : ruleASN1_TYPE EOF ;
    public final void entryRuleASN1_TYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:566:1: ( ruleASN1_TYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:567:1: ruleASN1_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE1147);
            ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_TYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE1154); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:574:1: ruleASN1_TYPE : ( ( rule__ASN1_TYPE__Alternatives ) ) ;
    public final void ruleASN1_TYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:578:2: ( ( ( rule__ASN1_TYPE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:579:1: ( ( rule__ASN1_TYPE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:579:1: ( ( rule__ASN1_TYPE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:580:1: ( rule__ASN1_TYPE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_TYPEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:581:1: ( rule__ASN1_TYPE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:581:2: rule__ASN1_TYPE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_TYPE__Alternatives_in_ruleASN1_TYPE1180);
            rule__ASN1_TYPE__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_TYPEAccess().getAlternatives()); 
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
    // $ANTLR end "ruleASN1_TYPE"


    // $ANTLR start "entryRuleASN1_SIMPLE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:593:1: entryRuleASN1_SIMPLE : ruleASN1_SIMPLE EOF ;
    public final void entryRuleASN1_SIMPLE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:594:1: ( ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:595:1: ruleASN1_SIMPLE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE1207);
            ruleASN1_SIMPLE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE1214); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:602:1: ruleASN1_SIMPLE : ( ( rule__ASN1_SIMPLE__Alternatives ) ) ;
    public final void ruleASN1_SIMPLE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:606:2: ( ( ( rule__ASN1_SIMPLE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:607:1: ( ( rule__ASN1_SIMPLE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:607:1: ( ( rule__ASN1_SIMPLE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:608:1: ( rule__ASN1_SIMPLE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:609:1: ( rule__ASN1_SIMPLE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:609:2: rule__ASN1_SIMPLE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Alternatives_in_ruleASN1_SIMPLE1240);
            rule__ASN1_SIMPLE__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLEAccess().getAlternatives()); 
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
    // $ANTLR end "ruleASN1_SIMPLE"


    // $ANTLR start "entryRuleASN1_OCTET_STRING"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:621:1: entryRuleASN1_OCTET_STRING : ruleASN1_OCTET_STRING EOF ;
    public final void entryRuleASN1_OCTET_STRING() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:622:1: ( ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:623:1: ruleASN1_OCTET_STRING EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING1267);
            ruleASN1_OCTET_STRING();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING1274); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:630:1: ruleASN1_OCTET_STRING : ( ( rule__ASN1_OCTET_STRING__Group__0 ) ) ;
    public final void ruleASN1_OCTET_STRING() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:634:2: ( ( ( rule__ASN1_OCTET_STRING__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:635:1: ( ( rule__ASN1_OCTET_STRING__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:635:1: ( ( rule__ASN1_OCTET_STRING__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:636:1: ( rule__ASN1_OCTET_STRING__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:637:1: ( rule__ASN1_OCTET_STRING__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:637:2: rule__ASN1_OCTET_STRING__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__0_in_ruleASN1_OCTET_STRING1300);
            rule__ASN1_OCTET_STRING__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_OCTET_STRINGAccess().getGroup()); 
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
    // $ANTLR end "ruleASN1_OCTET_STRING"


    // $ANTLR start "entryRuleASN1_INTEGER"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:649:1: entryRuleASN1_INTEGER : ruleASN1_INTEGER EOF ;
    public final void entryRuleASN1_INTEGER() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:650:1: ( ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:651:1: ruleASN1_INTEGER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER1327);
            ruleASN1_INTEGER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER1334); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:658:1: ruleASN1_INTEGER : ( ( rule__ASN1_INTEGER__Group__0 ) ) ;
    public final void ruleASN1_INTEGER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:662:2: ( ( ( rule__ASN1_INTEGER__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:663:1: ( ( rule__ASN1_INTEGER__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:663:1: ( ( rule__ASN1_INTEGER__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:664:1: ( rule__ASN1_INTEGER__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:665:1: ( rule__ASN1_INTEGER__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:665:2: rule__ASN1_INTEGER__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__0_in_ruleASN1_INTEGER1360);
            rule__ASN1_INTEGER__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getGroup()); 
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
    // $ANTLR end "ruleASN1_INTEGER"


    // $ANTLR start "entryRuleASN1_SUBTYPE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:677:1: entryRuleASN1_SUBTYPE : ruleASN1_SUBTYPE EOF ;
    public final void entryRuleASN1_SUBTYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:678:1: ( ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:679:1: ruleASN1_SUBTYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE1387);
            ruleASN1_SUBTYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE1394); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:686:1: ruleASN1_SUBTYPE : ( ( rule__ASN1_SUBTYPE__Group__0 ) ) ;
    public final void ruleASN1_SUBTYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:690:2: ( ( ( rule__ASN1_SUBTYPE__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:691:1: ( ( rule__ASN1_SUBTYPE__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:691:1: ( ( rule__ASN1_SUBTYPE__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:692:1: ( rule__ASN1_SUBTYPE__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:693:1: ( rule__ASN1_SUBTYPE__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:693:2: rule__ASN1_SUBTYPE__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__0_in_ruleASN1_SUBTYPE1420);
            rule__ASN1_SUBTYPE__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getGroup()); 
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
    // $ANTLR end "ruleASN1_SUBTYPE"


    // $ANTLR start "entryRuleASN1_RANGE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:705:1: entryRuleASN1_RANGE : ruleASN1_RANGE EOF ;
    public final void entryRuleASN1_RANGE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:706:1: ( ruleASN1_RANGE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:707:1: ruleASN1_RANGE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE1447);
            ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE1454); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:714:1: ruleASN1_RANGE : ( ( rule__ASN1_RANGE__Alternatives ) ) ;
    public final void ruleASN1_RANGE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:718:2: ( ( ( rule__ASN1_RANGE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:719:1: ( ( rule__ASN1_RANGE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:719:1: ( ( rule__ASN1_RANGE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:720:1: ( rule__ASN1_RANGE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:721:1: ( rule__ASN1_RANGE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:721:2: rule__ASN1_RANGE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Alternatives_in_ruleASN1_RANGE1480);
            rule__ASN1_RANGE__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getAlternatives()); 
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
    // $ANTLR end "ruleASN1_RANGE"


    // $ANTLR start "entryRuleASN1_VALUEPAIR"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:733:1: entryRuleASN1_VALUEPAIR : ruleASN1_VALUEPAIR EOF ;
    public final void entryRuleASN1_VALUEPAIR() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:734:1: ( ruleASN1_VALUEPAIR EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:735:1: ruleASN1_VALUEPAIR EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR1507);
            ruleASN1_VALUEPAIR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_VALUEPAIRRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR1514); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:742:1: ruleASN1_VALUEPAIR : ( ( rule__ASN1_VALUEPAIR__Group__0 ) ) ;
    public final void ruleASN1_VALUEPAIR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:746:2: ( ( ( rule__ASN1_VALUEPAIR__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:747:1: ( ( rule__ASN1_VALUEPAIR__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:747:1: ( ( rule__ASN1_VALUEPAIR__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:748:1: ( rule__ASN1_VALUEPAIR__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:749:1: ( rule__ASN1_VALUEPAIR__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:749:2: rule__ASN1_VALUEPAIR__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__0_in_ruleASN1_VALUEPAIR1540);
            rule__ASN1_VALUEPAIR__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_VALUEPAIRAccess().getGroup()); 
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
    // $ANTLR end "ruleASN1_VALUEPAIR"


    // $ANTLR start "entryRuleASN1_CHOICE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:761:1: entryRuleASN1_CHOICE : ruleASN1_CHOICE EOF ;
    public final void entryRuleASN1_CHOICE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:762:1: ( ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:763:1: ruleASN1_CHOICE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE1567);
            ruleASN1_CHOICE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE1574); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:770:1: ruleASN1_CHOICE : ( ( rule__ASN1_CHOICE__Group__0 ) ) ;
    public final void ruleASN1_CHOICE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:774:2: ( ( ( rule__ASN1_CHOICE__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:775:1: ( ( rule__ASN1_CHOICE__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:775:1: ( ( rule__ASN1_CHOICE__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:776:1: ( rule__ASN1_CHOICE__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:777:1: ( rule__ASN1_CHOICE__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:777:2: rule__ASN1_CHOICE__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__0_in_ruleASN1_CHOICE1600);
            rule__ASN1_CHOICE__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getGroup()); 
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
    // $ANTLR end "ruleASN1_CHOICE"


    // $ANTLR start "entryRuleASN1_CHOICE_ENTRY"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:789:1: entryRuleASN1_CHOICE_ENTRY : ruleASN1_CHOICE_ENTRY EOF ;
    public final void entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:790:1: ( ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:791:1: ruleASN1_CHOICE_ENTRY EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY1627);
            ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY1634); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:798:1: ruleASN1_CHOICE_ENTRY : ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) ) ;
    public final void ruleASN1_CHOICE_ENTRY() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:802:2: ( ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:803:1: ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:803:1: ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:804:1: ( rule__ASN1_CHOICE_ENTRY__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:805:1: ( rule__ASN1_CHOICE_ENTRY__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:805:2: rule__ASN1_CHOICE_ENTRY__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0_in_ruleASN1_CHOICE_ENTRY1660);
            rule__ASN1_CHOICE_ENTRY__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getGroup()); 
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
    // $ANTLR end "ruleASN1_CHOICE_ENTRY"


    // $ANTLR start "ruleVALUE_CAP_LITERALS"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:818:1: ruleVALUE_CAP_LITERALS : ( ( rule__VALUE_CAP_LITERALS__Alternatives ) ) ;
    public final void ruleVALUE_CAP_LITERALS() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:822:1: ( ( ( rule__VALUE_CAP_LITERALS__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:823:1: ( ( rule__VALUE_CAP_LITERALS__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:823:1: ( ( rule__VALUE_CAP_LITERALS__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:824:1: ( rule__VALUE_CAP_LITERALS__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getVALUE_CAP_LITERALSAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:825:1: ( rule__VALUE_CAP_LITERALS__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:825:2: rule__VALUE_CAP_LITERALS__Alternatives
            {
            pushFollow(FOLLOW_rule__VALUE_CAP_LITERALS__Alternatives_in_ruleVALUE_CAP_LITERALS1697);
            rule__VALUE_CAP_LITERALS__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getVALUE_CAP_LITERALSAccess().getAlternatives()); 
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
    // $ANTLR end "ruleVALUE_CAP_LITERALS"


    // $ANTLR start "rule__Assignment__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:836:1: rule__Assignment__Alternatives : ( ( ( rule__Assignment__IdentifierAssignment_0 ) ) | ( ( rule__Assignment__TypeAssignment_1 ) ) | ( ( rule__Assignment__MacroAssignment_2 ) ) );
    public final void rule__Assignment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:840:1: ( ( ( rule__Assignment__IdentifierAssignment_0 ) ) | ( ( rule__Assignment__TypeAssignment_1 ) ) | ( ( rule__Assignment__MacroAssignment_2 ) ) )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ASN1_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_MODULE_ID) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==22) ) {
                    alt1=2;
                }
                else if ( (LA1_2==27) ) {
                    alt1=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:841:1: ( ( rule__Assignment__IdentifierAssignment_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:841:1: ( ( rule__Assignment__IdentifierAssignment_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:842:1: ( rule__Assignment__IdentifierAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentAccess().getIdentifierAssignment_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:843:1: ( rule__Assignment__IdentifierAssignment_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:843:2: rule__Assignment__IdentifierAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Assignment__IdentifierAssignment_0_in_rule__Assignment__Alternatives1732);
                    rule__Assignment__IdentifierAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentAccess().getIdentifierAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:847:6: ( ( rule__Assignment__TypeAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:847:6: ( ( rule__Assignment__TypeAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:848:1: ( rule__Assignment__TypeAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentAccess().getTypeAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:849:1: ( rule__Assignment__TypeAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:849:2: rule__Assignment__TypeAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Assignment__TypeAssignment_1_in_rule__Assignment__Alternatives1750);
                    rule__Assignment__TypeAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentAccess().getTypeAssignment_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:853:6: ( ( rule__Assignment__MacroAssignment_2 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:853:6: ( ( rule__Assignment__MacroAssignment_2 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:854:1: ( rule__Assignment__MacroAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAssignmentAccess().getMacroAssignment_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:855:1: ( rule__Assignment__MacroAssignment_2 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:855:2: rule__Assignment__MacroAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Assignment__MacroAssignment_2_in_rule__Assignment__Alternatives1768);
                    rule__Assignment__MacroAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAssignmentAccess().getMacroAssignment_2()); 
                    }

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


    // $ANTLR start "rule__ObjectIdentifierValue__Alternatives_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:864:1: rule__ObjectIdentifierValue__Alternatives_0 : ( ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0 ) ) | ( RULE_ASN1_ID ) );
    public final void rule__ObjectIdentifierValue__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:868:1: ( ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0 ) ) | ( RULE_ASN1_ID ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ASN1_ID) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:869:1: ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:869:1: ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:870:1: ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceAssignment_0_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:871:1: ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:871:2: rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0_in_rule__ObjectIdentifierValue__Alternatives_01801);
                    rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:875:6: ( RULE_ASN1_ID )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:875:6: ( RULE_ASN1_ID )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:876:1: RULE_ASN1_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectIdentifierValueAccess().getASN1_IDTerminalRuleCall_0_1()); 
                    }
                    match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__Alternatives_01819); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectIdentifierValueAccess().getASN1_IDTerminalRuleCall_0_1()); 
                    }

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
    // $ANTLR end "rule__ObjectIdentifierValue__Alternatives_0"


    // $ANTLR start "rule__TypeAssignment__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:886:1: rule__TypeAssignment__Alternatives : ( ( ruleParamAssignment ) | ( ruleTypeReference ) );
    public final void rule__TypeAssignment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:890:1: ( ( ruleParamAssignment ) | ( ruleTypeReference ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_PARAMETER) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_MODULE_ID) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:891:1: ( ruleParamAssignment )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:891:1: ( ruleParamAssignment )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:892:1: ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_rule__TypeAssignment__Alternatives1851);
                    ruleParamAssignment();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:897:6: ( ruleTypeReference )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:897:6: ( ruleTypeReference )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:898:1: ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeAssignment__Alternatives1868);
                    ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1()); 
                    }

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
    // $ANTLR end "rule__TypeAssignment__Alternatives"


    // $ANTLR start "rule__TypeNotation__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:908:1: rule__TypeNotation__Alternatives : ( ( ruleTypeReference ) | ( ( rule__TypeNotation__ValueAssignment_1 ) ) );
    public final void rule__TypeNotation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:912:1: ( ( ruleTypeReference ) | ( ( rule__TypeNotation__ValueAssignment_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_MODULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==31) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:913:1: ( ruleTypeReference )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:913:1: ( ruleTypeReference )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:914:1: ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeNotationAccess().getTypeReferenceParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeNotation__Alternatives1900);
                    ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeNotationAccess().getTypeReferenceParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:919:6: ( ( rule__TypeNotation__ValueAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:919:6: ( ( rule__TypeNotation__ValueAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:920:1: ( rule__TypeNotation__ValueAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeNotationAccess().getValueAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:921:1: ( rule__TypeNotation__ValueAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:921:2: rule__TypeNotation__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TypeNotation__ValueAssignment_1_in_rule__TypeNotation__Alternatives1917);
                    rule__TypeNotation__ValueAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeNotationAccess().getValueAssignment_1()); 
                    }

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
    // $ANTLR end "rule__TypeNotation__Alternatives"


    // $ANTLR start "rule__ValueType__Alternatives_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:930:1: rule__ValueType__Alternatives_1 : ( ( ( rule__ValueType__ParamAssignment_1_0 ) ) | ( ( rule__ValueType__TypeAssignment_1_1 ) ) | ( ( rule__ValueType__SimpleTypeAssignment_1_2 ) ) | ( ( rule__ValueType__MacroValueAssignment_1_3 ) ) | ( ( rule__ValueType__OiAssignment_1_4 ) ) );
    public final void rule__ValueType__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:934:1: ( ( ( rule__ValueType__ParamAssignment_1_0 ) ) | ( ( rule__ValueType__TypeAssignment_1_1 ) ) | ( ( rule__ValueType__SimpleTypeAssignment_1_2 ) ) | ( ( rule__ValueType__MacroValueAssignment_1_3 ) ) | ( ( rule__ValueType__OiAssignment_1_4 ) ) )
            int alt5=5;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt5=1;
                }
                break;
            case RULE_MODULE_ID:
                {
                alt5=2;
                }
                break;
            case RULE_IA5STRING:
            case 35:
            case 36:
            case 37:
            case 40:
                {
                alt5=3;
                }
                break;
            case 31:
                {
                alt5=4;
                }
                break;
            case 19:
                {
                alt5=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:935:1: ( ( rule__ValueType__ParamAssignment_1_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:935:1: ( ( rule__ValueType__ParamAssignment_1_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:936:1: ( rule__ValueType__ParamAssignment_1_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getParamAssignment_1_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:937:1: ( rule__ValueType__ParamAssignment_1_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:937:2: rule__ValueType__ParamAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__ValueType__ParamAssignment_1_0_in_rule__ValueType__Alternatives_11950);
                    rule__ValueType__ParamAssignment_1_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getParamAssignment_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:941:6: ( ( rule__ValueType__TypeAssignment_1_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:941:6: ( ( rule__ValueType__TypeAssignment_1_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:942:1: ( rule__ValueType__TypeAssignment_1_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getTypeAssignment_1_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:943:1: ( rule__ValueType__TypeAssignment_1_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:943:2: rule__ValueType__TypeAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__ValueType__TypeAssignment_1_1_in_rule__ValueType__Alternatives_11968);
                    rule__ValueType__TypeAssignment_1_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getTypeAssignment_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:947:6: ( ( rule__ValueType__SimpleTypeAssignment_1_2 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:947:6: ( ( rule__ValueType__SimpleTypeAssignment_1_2 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:948:1: ( rule__ValueType__SimpleTypeAssignment_1_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getSimpleTypeAssignment_1_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:949:1: ( rule__ValueType__SimpleTypeAssignment_1_2 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:949:2: rule__ValueType__SimpleTypeAssignment_1_2
                    {
                    pushFollow(FOLLOW_rule__ValueType__SimpleTypeAssignment_1_2_in_rule__ValueType__Alternatives_11986);
                    rule__ValueType__SimpleTypeAssignment_1_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getSimpleTypeAssignment_1_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:953:6: ( ( rule__ValueType__MacroValueAssignment_1_3 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:953:6: ( ( rule__ValueType__MacroValueAssignment_1_3 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:954:1: ( rule__ValueType__MacroValueAssignment_1_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getMacroValueAssignment_1_3()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:955:1: ( rule__ValueType__MacroValueAssignment_1_3 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:955:2: rule__ValueType__MacroValueAssignment_1_3
                    {
                    pushFollow(FOLLOW_rule__ValueType__MacroValueAssignment_1_3_in_rule__ValueType__Alternatives_12004);
                    rule__ValueType__MacroValueAssignment_1_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getMacroValueAssignment_1_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:959:6: ( ( rule__ValueType__OiAssignment_1_4 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:959:6: ( ( rule__ValueType__OiAssignment_1_4 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:960:1: ( rule__ValueType__OiAssignment_1_4 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getOiAssignment_1_4()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:961:1: ( rule__ValueType__OiAssignment_1_4 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:961:2: rule__ValueType__OiAssignment_1_4
                    {
                    pushFollow(FOLLOW_rule__ValueType__OiAssignment_1_4_in_rule__ValueType__Alternatives_12022);
                    rule__ValueType__OiAssignment_1_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getOiAssignment_1_4()); 
                    }

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


    // $ANTLR start "rule__MACRO_VALUE_TYPE__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:970:1: rule__MACRO_VALUE_TYPE__Alternatives : ( ( ( rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0 ) ) | ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_1 ) ) );
    public final void rule__MACRO_VALUE_TYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:974:1: ( ( ( rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0 ) ) | ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==42) ) {
                alt6=1;
            }
            else if ( (LA6_0==34) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:975:1: ( ( rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:975:1: ( ( rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:976:1: ( rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_TYPEAccess().getValLiteralAssignment_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:977:1: ( rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:977:2: rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0
                    {
                    pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0_in_rule__MACRO_VALUE_TYPE__Alternatives2055);
                    rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMACRO_VALUE_TYPEAccess().getValLiteralAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:981:6: ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:981:6: ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:982:1: ( rule__MACRO_VALUE_TYPE__UpdateAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:983:1: ( rule__MACRO_VALUE_TYPE__UpdateAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:983:2: rule__MACRO_VALUE_TYPE__UpdateAssignment_1
                    {
                    pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__UpdateAssignment_1_in_rule__MACRO_VALUE_TYPE__Alternatives2073);
                    rule__MACRO_VALUE_TYPE__UpdateAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateAssignment_1()); 
                    }

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


    // $ANTLR start "rule__ASN1_TYPE__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:992:1: rule__ASN1_TYPE__Alternatives : ( ( ruleASN1_SIMPLE ) | ( ruleASN1_CHOICE ) );
    public final void rule__ASN1_TYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:996:1: ( ( ruleASN1_SIMPLE ) | ( ruleASN1_CHOICE ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_IA5STRING||(LA7_0>=35 && LA7_0<=37)) ) {
                alt7=1;
            }
            else if ( (LA7_0==40) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:997:1: ( ruleASN1_SIMPLE )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:997:1: ( ruleASN1_SIMPLE )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:998:1: ruleASN1_SIMPLE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_rule__ASN1_TYPE__Alternatives2106);
                    ruleASN1_SIMPLE();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1003:6: ( ruleASN1_CHOICE )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1003:6: ( ruleASN1_CHOICE )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1004:1: ruleASN1_CHOICE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_rule__ASN1_TYPE__Alternatives2123);
                    ruleASN1_CHOICE();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                    }

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1014:1: rule__ASN1_SIMPLE__Alternatives : ( ( ( rule__ASN1_SIMPLE__Group_0__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_1__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_2__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_3__0 ) ) );
    public final void rule__ASN1_SIMPLE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1018:1: ( ( ( rule__ASN1_SIMPLE__Group_0__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_1__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_2__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_3__0 ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt8=1;
                }
                break;
            case RULE_IA5STRING:
                {
                alt8=2;
                }
                break;
            case 36:
                {
                alt8=3;
                }
                break;
            case 37:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1019:1: ( ( rule__ASN1_SIMPLE__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1019:1: ( ( rule__ASN1_SIMPLE__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1020:1: ( rule__ASN1_SIMPLE__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1021:1: ( rule__ASN1_SIMPLE__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1021:2: rule__ASN1_SIMPLE__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__0_in_rule__ASN1_SIMPLE__Alternatives2155);
                    rule__ASN1_SIMPLE__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getASN1_SIMPLEAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1025:6: ( ( rule__ASN1_SIMPLE__Group_1__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1025:6: ( ( rule__ASN1_SIMPLE__Group_1__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1026:1: ( rule__ASN1_SIMPLE__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1027:1: ( rule__ASN1_SIMPLE__Group_1__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1027:2: rule__ASN1_SIMPLE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__0_in_rule__ASN1_SIMPLE__Alternatives2173);
                    rule__ASN1_SIMPLE__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getASN1_SIMPLEAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1031:6: ( ( rule__ASN1_SIMPLE__Group_2__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1031:6: ( ( rule__ASN1_SIMPLE__Group_2__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1032:1: ( rule__ASN1_SIMPLE__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1033:1: ( rule__ASN1_SIMPLE__Group_2__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1033:2: rule__ASN1_SIMPLE__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__0_in_rule__ASN1_SIMPLE__Alternatives2191);
                    rule__ASN1_SIMPLE__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getASN1_SIMPLEAccess().getGroup_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1037:6: ( ( rule__ASN1_SIMPLE__Group_3__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1037:6: ( ( rule__ASN1_SIMPLE__Group_3__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1038:1: ( rule__ASN1_SIMPLE__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_3()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1039:1: ( rule__ASN1_SIMPLE__Group_3__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1039:2: rule__ASN1_SIMPLE__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__0_in_rule__ASN1_SIMPLE__Alternatives2209);
                    rule__ASN1_SIMPLE__Group_3__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getASN1_SIMPLEAccess().getGroup_3()); 
                    }

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


    // $ANTLR start "rule__ASN1_RANGE__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1048:1: rule__ASN1_RANGE__Alternatives : ( ( ( rule__ASN1_RANGE__Group_0__0 ) ) | ( ( rule__ASN1_RANGE__Group_1__0 ) ) );
    public final void rule__ASN1_RANGE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1052:1: ( ( ( rule__ASN1_RANGE__Group_0__0 ) ) | ( ( rule__ASN1_RANGE__Group_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_INT) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==39) ) {
                    alt9=2;
                }
                else if ( (LA9_1==EOF||LA9_1==RULE_ASN1_ID||LA9_1==RULE_MODULE_ID||LA9_1==24||LA9_1==30||LA9_1==33) ) {
                    alt9=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1053:1: ( ( rule__ASN1_RANGE__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1053:1: ( ( rule__ASN1_RANGE__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1054:1: ( rule__ASN1_RANGE__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_RANGEAccess().getGroup_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1055:1: ( rule__ASN1_RANGE__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1055:2: rule__ASN1_RANGE__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__0_in_rule__ASN1_RANGE__Alternatives2242);
                    rule__ASN1_RANGE__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getASN1_RANGEAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1059:6: ( ( rule__ASN1_RANGE__Group_1__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1059:6: ( ( rule__ASN1_RANGE__Group_1__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1060:1: ( rule__ASN1_RANGE__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_RANGEAccess().getGroup_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1061:1: ( rule__ASN1_RANGE__Group_1__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1061:2: rule__ASN1_RANGE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__0_in_rule__ASN1_RANGE__Alternatives2260);
                    rule__ASN1_RANGE__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getASN1_RANGEAccess().getGroup_1()); 
                    }

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
    // $ANTLR end "rule__ASN1_RANGE__Alternatives"


    // $ANTLR start "rule__VALUE_CAP_LITERALS__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1070:1: rule__VALUE_CAP_LITERALS__Alternatives : ( ( ( 'OBJECT IDENTIFIER' ) ) | ( ( 'IA5String' ) ) );
    public final void rule__VALUE_CAP_LITERALS__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1074:1: ( ( ( 'OBJECT IDENTIFIER' ) ) | ( ( 'IA5String' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            else if ( (LA10_0==20) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1075:1: ( ( 'OBJECT IDENTIFIER' ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1075:1: ( ( 'OBJECT IDENTIFIER' ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1076:1: ( 'OBJECT IDENTIFIER' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVALUE_CAP_LITERALSAccess().getOiLiteralEnumLiteralDeclaration_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1077:1: ( 'OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1077:3: 'OBJECT IDENTIFIER'
                    {
                    match(input,19,FOLLOW_19_in_rule__VALUE_CAP_LITERALS__Alternatives2294); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVALUE_CAP_LITERALSAccess().getOiLiteralEnumLiteralDeclaration_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1082:6: ( ( 'IA5String' ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1082:6: ( ( 'IA5String' ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1083:1: ( 'IA5String' )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getVALUE_CAP_LITERALSAccess().getIa5StringLiteralEnumLiteralDeclaration_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1084:1: ( 'IA5String' )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1084:3: 'IA5String'
                    {
                    match(input,20,FOLLOW_20_in_rule__VALUE_CAP_LITERALS__Alternatives2315); if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getVALUE_CAP_LITERALSAccess().getIa5StringLiteralEnumLiteralDeclaration_1()); 
                    }

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
    // $ANTLR end "rule__VALUE_CAP_LITERALS__Alternatives"


    // $ANTLR start "rule__Module__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1096:1: rule__Module__Group__0 : rule__Module__Group__0__Impl rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1100:1: ( rule__Module__Group__0__Impl rule__Module__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1101:2: rule__Module__Group__0__Impl rule__Module__Group__1
            {
            pushFollow(FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__02348);
            rule__Module__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__1_in_rule__Module__Group__02351);
            rule__Module__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1108:1: rule__Module__Group__0__Impl : ( ( rule__Module__IdAssignment_0 ) ) ;
    public final void rule__Module__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1112:1: ( ( ( rule__Module__IdAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1113:1: ( ( rule__Module__IdAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1113:1: ( ( rule__Module__IdAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1114:1: ( rule__Module__IdAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getIdAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1115:1: ( rule__Module__IdAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1115:2: rule__Module__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__Module__IdAssignment_0_in_rule__Module__Group__0__Impl2378);
            rule__Module__IdAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getIdAssignment_0()); 
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
    // $ANTLR end "rule__Module__Group__0__Impl"


    // $ANTLR start "rule__Module__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1125:1: rule__Module__Group__1 : rule__Module__Group__1__Impl rule__Module__Group__2 ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1129:1: ( rule__Module__Group__1__Impl rule__Module__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1130:2: rule__Module__Group__1__Impl rule__Module__Group__2
            {
            pushFollow(FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__12408);
            rule__Module__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__2_in_rule__Module__Group__12411);
            rule__Module__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1137:1: rule__Module__Group__1__Impl : ( 'DEFINITIONS' ) ;
    public final void rule__Module__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1141:1: ( ( 'DEFINITIONS' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1142:1: ( 'DEFINITIONS' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1142:1: ( 'DEFINITIONS' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1143:1: 'DEFINITIONS'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getDEFINITIONSKeyword_1()); 
            }
            match(input,21,FOLLOW_21_in_rule__Module__Group__1__Impl2439); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getDEFINITIONSKeyword_1()); 
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
    // $ANTLR end "rule__Module__Group__1__Impl"


    // $ANTLR start "rule__Module__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1156:1: rule__Module__Group__2 : rule__Module__Group__2__Impl rule__Module__Group__3 ;
    public final void rule__Module__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1160:1: ( rule__Module__Group__2__Impl rule__Module__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1161:2: rule__Module__Group__2__Impl rule__Module__Group__3
            {
            pushFollow(FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__22470);
            rule__Module__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__3_in_rule__Module__Group__22473);
            rule__Module__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1168:1: rule__Module__Group__2__Impl : ( '::=' ) ;
    public final void rule__Module__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1172:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1173:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1173:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1174:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_2()); 
            }
            match(input,22,FOLLOW_22_in_rule__Module__Group__2__Impl2501); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_2()); 
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
    // $ANTLR end "rule__Module__Group__2__Impl"


    // $ANTLR start "rule__Module__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1187:1: rule__Module__Group__3 : rule__Module__Group__3__Impl rule__Module__Group__4 ;
    public final void rule__Module__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1191:1: ( rule__Module__Group__3__Impl rule__Module__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1192:2: rule__Module__Group__3__Impl rule__Module__Group__4
            {
            pushFollow(FOLLOW_rule__Module__Group__3__Impl_in_rule__Module__Group__32532);
            rule__Module__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__4_in_rule__Module__Group__32535);
            rule__Module__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1199:1: rule__Module__Group__3__Impl : ( 'BEGIN' ) ;
    public final void rule__Module__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1203:1: ( ( 'BEGIN' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1204:1: ( 'BEGIN' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1204:1: ( 'BEGIN' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1205:1: 'BEGIN'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getBEGINKeyword_3()); 
            }
            match(input,23,FOLLOW_23_in_rule__Module__Group__3__Impl2563); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getBEGINKeyword_3()); 
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
    // $ANTLR end "rule__Module__Group__3__Impl"


    // $ANTLR start "rule__Module__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1218:1: rule__Module__Group__4 : rule__Module__Group__4__Impl rule__Module__Group__5 ;
    public final void rule__Module__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1222:1: ( rule__Module__Group__4__Impl rule__Module__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1223:2: rule__Module__Group__4__Impl rule__Module__Group__5
            {
            pushFollow(FOLLOW_rule__Module__Group__4__Impl_in_rule__Module__Group__42594);
            rule__Module__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__5_in_rule__Module__Group__42597);
            rule__Module__Group__5();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1230:1: rule__Module__Group__4__Impl : ( ( rule__Module__AssignmentsAssignment_4 )* ) ;
    public final void rule__Module__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1234:1: ( ( ( rule__Module__AssignmentsAssignment_4 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1235:1: ( ( rule__Module__AssignmentsAssignment_4 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1235:1: ( ( rule__Module__AssignmentsAssignment_4 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1236:1: ( rule__Module__AssignmentsAssignment_4 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getAssignmentsAssignment_4()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1237:1: ( rule__Module__AssignmentsAssignment_4 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ASN1_ID||LA11_0==RULE_MODULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1237:2: rule__Module__AssignmentsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Module__AssignmentsAssignment_4_in_rule__Module__Group__4__Impl2624);
            	    rule__Module__AssignmentsAssignment_4();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getAssignmentsAssignment_4()); 
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
    // $ANTLR end "rule__Module__Group__4__Impl"


    // $ANTLR start "rule__Module__Group__5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1247:1: rule__Module__Group__5 : rule__Module__Group__5__Impl ;
    public final void rule__Module__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1251:1: ( rule__Module__Group__5__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1252:2: rule__Module__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group__5__Impl_in_rule__Module__Group__52655);
            rule__Module__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1258:1: rule__Module__Group__5__Impl : ( 'END' ) ;
    public final void rule__Module__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1262:1: ( ( 'END' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1263:1: ( 'END' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1263:1: ( 'END' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1264:1: 'END'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getENDKeyword_5()); 
            }
            match(input,24,FOLLOW_24_in_rule__Module__Group__5__Impl2683); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getENDKeyword_5()); 
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
    // $ANTLR end "rule__Module__Group__5__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1289:1: rule__ObjectIdentifier__Group__0 : rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1 ;
    public final void rule__ObjectIdentifier__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1293:1: ( rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1294:2: rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__0__Impl_in_rule__ObjectIdentifier__Group__02726);
            rule__ObjectIdentifier__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__1_in_rule__ObjectIdentifier__Group__02729);
            rule__ObjectIdentifier__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1301:1: rule__ObjectIdentifier__Group__0__Impl : ( ( rule__ObjectIdentifier__NameAssignment_0 ) ) ;
    public final void rule__ObjectIdentifier__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1305:1: ( ( ( rule__ObjectIdentifier__NameAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1306:1: ( ( rule__ObjectIdentifier__NameAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1306:1: ( ( rule__ObjectIdentifier__NameAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1307:1: ( rule__ObjectIdentifier__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNameAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1308:1: ( rule__ObjectIdentifier__NameAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1308:2: rule__ObjectIdentifier__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__NameAssignment_0_in_rule__ObjectIdentifier__Group__0__Impl2756);
            rule__ObjectIdentifier__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__ObjectIdentifier__Group__0__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1318:1: rule__ObjectIdentifier__Group__1 : rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2 ;
    public final void rule__ObjectIdentifier__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1322:1: ( rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1323:2: rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__1__Impl_in_rule__ObjectIdentifier__Group__12786);
            rule__ObjectIdentifier__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__2_in_rule__ObjectIdentifier__Group__12789);
            rule__ObjectIdentifier__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1330:1: rule__ObjectIdentifier__Group__1__Impl : ( 'OBJECT IDENTIFIER' ) ;
    public final void rule__ObjectIdentifier__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1334:1: ( ( 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1335:1: ( 'OBJECT IDENTIFIER' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1335:1: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1336:1: 'OBJECT IDENTIFIER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_1()); 
            }
            match(input,19,FOLLOW_19_in_rule__ObjectIdentifier__Group__1__Impl2817); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_1()); 
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
    // $ANTLR end "rule__ObjectIdentifier__Group__1__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1349:1: rule__ObjectIdentifier__Group__2 : rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3 ;
    public final void rule__ObjectIdentifier__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1353:1: ( rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1354:2: rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__2__Impl_in_rule__ObjectIdentifier__Group__22848);
            rule__ObjectIdentifier__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__3_in_rule__ObjectIdentifier__Group__22851);
            rule__ObjectIdentifier__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1361:1: rule__ObjectIdentifier__Group__2__Impl : ( '::=' ) ;
    public final void rule__ObjectIdentifier__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1365:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1366:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1366:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1367:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_2()); 
            }
            match(input,22,FOLLOW_22_in_rule__ObjectIdentifier__Group__2__Impl2879); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_2()); 
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
    // $ANTLR end "rule__ObjectIdentifier__Group__2__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1380:1: rule__ObjectIdentifier__Group__3 : rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4 ;
    public final void rule__ObjectIdentifier__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1384:1: ( rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1385:2: rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__3__Impl_in_rule__ObjectIdentifier__Group__32910);
            rule__ObjectIdentifier__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__4_in_rule__ObjectIdentifier__Group__32913);
            rule__ObjectIdentifier__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1392:1: rule__ObjectIdentifier__Group__3__Impl : ( '{' ) ;
    public final void rule__ObjectIdentifier__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1396:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1397:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1397:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1398:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_3()); 
            }
            match(input,25,FOLLOW_25_in_rule__ObjectIdentifier__Group__3__Impl2941); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__ObjectIdentifier__Group__3__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1411:1: rule__ObjectIdentifier__Group__4 : rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5 ;
    public final void rule__ObjectIdentifier__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1415:1: ( rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1416:2: rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__4__Impl_in_rule__ObjectIdentifier__Group__42972);
            rule__ObjectIdentifier__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__5_in_rule__ObjectIdentifier__Group__42975);
            rule__ObjectIdentifier__Group__5();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1423:1: rule__ObjectIdentifier__Group__4__Impl : ( ( rule__ObjectIdentifier__OidValueAssignment_4 ) ) ;
    public final void rule__ObjectIdentifier__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1427:1: ( ( ( rule__ObjectIdentifier__OidValueAssignment_4 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1428:1: ( ( rule__ObjectIdentifier__OidValueAssignment_4 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1428:1: ( ( rule__ObjectIdentifier__OidValueAssignment_4 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1429:1: ( rule__ObjectIdentifier__OidValueAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOidValueAssignment_4()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1430:1: ( rule__ObjectIdentifier__OidValueAssignment_4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1430:2: rule__ObjectIdentifier__OidValueAssignment_4
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__OidValueAssignment_4_in_rule__ObjectIdentifier__Group__4__Impl3002);
            rule__ObjectIdentifier__OidValueAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getOidValueAssignment_4()); 
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
    // $ANTLR end "rule__ObjectIdentifier__Group__4__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1440:1: rule__ObjectIdentifier__Group__5 : rule__ObjectIdentifier__Group__5__Impl ;
    public final void rule__ObjectIdentifier__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1444:1: ( rule__ObjectIdentifier__Group__5__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1445:2: rule__ObjectIdentifier__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__5__Impl_in_rule__ObjectIdentifier__Group__53032);
            rule__ObjectIdentifier__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1451:1: rule__ObjectIdentifier__Group__5__Impl : ( '}' ) ;
    public final void rule__ObjectIdentifier__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1455:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1456:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1456:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1457:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,26,FOLLOW_26_in_rule__ObjectIdentifier__Group__5__Impl3060); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getRightCurlyBracketKeyword_5()); 
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
    // $ANTLR end "rule__ObjectIdentifier__Group__5__Impl"


    // $ANTLR start "rule__ObjectIdentifierValue__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1482:1: rule__ObjectIdentifierValue__Group__0 : rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1 ;
    public final void rule__ObjectIdentifierValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1486:1: ( rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1487:2: rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__0__Impl_in_rule__ObjectIdentifierValue__Group__03103);
            rule__ObjectIdentifierValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__1_in_rule__ObjectIdentifierValue__Group__03106);
            rule__ObjectIdentifierValue__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1494:1: rule__ObjectIdentifierValue__Group__0__Impl : ( ( rule__ObjectIdentifierValue__Alternatives_0 )? ) ;
    public final void rule__ObjectIdentifierValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1498:1: ( ( ( rule__ObjectIdentifierValue__Alternatives_0 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1499:1: ( ( rule__ObjectIdentifierValue__Alternatives_0 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1499:1: ( ( rule__ObjectIdentifierValue__Alternatives_0 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1500:1: ( rule__ObjectIdentifierValue__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getAlternatives_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1501:1: ( rule__ObjectIdentifierValue__Alternatives_0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ASN1_ID||LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1501:2: rule__ObjectIdentifierValue__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__Alternatives_0_in_rule__ObjectIdentifierValue__Group__0__Impl3133);
                    rule__ObjectIdentifierValue__Alternatives_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getAlternatives_0()); 
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
    // $ANTLR end "rule__ObjectIdentifierValue__Group__0__Impl"


    // $ANTLR start "rule__ObjectIdentifierValue__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1511:1: rule__ObjectIdentifierValue__Group__1 : rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2 ;
    public final void rule__ObjectIdentifierValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1515:1: ( rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1516:2: rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__1__Impl_in_rule__ObjectIdentifierValue__Group__13164);
            rule__ObjectIdentifierValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__2_in_rule__ObjectIdentifierValue__Group__13167);
            rule__ObjectIdentifierValue__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1523:1: rule__ObjectIdentifierValue__Group__1__Impl : ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) ) ;
    public final void rule__ObjectIdentifierValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1527:1: ( ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1528:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1528:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1529:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1530:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1530:2: rule__ObjectIdentifierValue__SubIdsAssignment_1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_1_in_rule__ObjectIdentifierValue__Group__1__Impl3194);
            rule__ObjectIdentifierValue__SubIdsAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_1()); 
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
    // $ANTLR end "rule__ObjectIdentifierValue__Group__1__Impl"


    // $ANTLR start "rule__ObjectIdentifierValue__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1540:1: rule__ObjectIdentifierValue__Group__2 : rule__ObjectIdentifierValue__Group__2__Impl ;
    public final void rule__ObjectIdentifierValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1544:1: ( rule__ObjectIdentifierValue__Group__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1545:2: rule__ObjectIdentifierValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__2__Impl_in_rule__ObjectIdentifierValue__Group__23224);
            rule__ObjectIdentifierValue__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1551:1: rule__ObjectIdentifierValue__Group__2__Impl : ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* ) ;
    public final void rule__ObjectIdentifierValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1555:1: ( ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1556:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1556:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1557:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1558:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_INT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1558:2: rule__ObjectIdentifierValue__SubIdsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_2_in_rule__ObjectIdentifierValue__Group__2__Impl3251);
            	    rule__ObjectIdentifierValue__SubIdsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_2()); 
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
    // $ANTLR end "rule__ObjectIdentifierValue__Group__2__Impl"


    // $ANTLR start "rule__TypeDefinition__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1574:1: rule__TypeDefinition__Group__0 : rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1 ;
    public final void rule__TypeDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1578:1: ( rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1579:2: rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__0__Impl_in_rule__TypeDefinition__Group__03288);
            rule__TypeDefinition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeDefinition__Group__1_in_rule__TypeDefinition__Group__03291);
            rule__TypeDefinition__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TypeDefinition__Group__0"


    // $ANTLR start "rule__TypeDefinition__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1586:1: rule__TypeDefinition__Group__0__Impl : ( ( rule__TypeDefinition__NameAssignment_0 ) ) ;
    public final void rule__TypeDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1590:1: ( ( ( rule__TypeDefinition__NameAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1591:1: ( ( rule__TypeDefinition__NameAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1591:1: ( ( rule__TypeDefinition__NameAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1592:1: ( rule__TypeDefinition__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNameAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1593:1: ( rule__TypeDefinition__NameAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1593:2: rule__TypeDefinition__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__TypeDefinition__NameAssignment_0_in_rule__TypeDefinition__Group__0__Impl3318);
            rule__TypeDefinition__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__TypeDefinition__Group__0__Impl"


    // $ANTLR start "rule__TypeDefinition__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1603:1: rule__TypeDefinition__Group__1 : rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2 ;
    public final void rule__TypeDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1607:1: ( rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1608:2: rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__1__Impl_in_rule__TypeDefinition__Group__13348);
            rule__TypeDefinition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeDefinition__Group__2_in_rule__TypeDefinition__Group__13351);
            rule__TypeDefinition__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TypeDefinition__Group__1"


    // $ANTLR start "rule__TypeDefinition__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1615:1: rule__TypeDefinition__Group__1__Impl : ( '::=' ) ;
    public final void rule__TypeDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1619:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1620:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1620:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1621:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getColonColonEqualsSignKeyword_1()); 
            }
            match(input,22,FOLLOW_22_in_rule__TypeDefinition__Group__1__Impl3379); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getColonColonEqualsSignKeyword_1()); 
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
    // $ANTLR end "rule__TypeDefinition__Group__1__Impl"


    // $ANTLR start "rule__TypeDefinition__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1634:1: rule__TypeDefinition__Group__2 : rule__TypeDefinition__Group__2__Impl ;
    public final void rule__TypeDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1638:1: ( rule__TypeDefinition__Group__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1639:2: rule__TypeDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__2__Impl_in_rule__TypeDefinition__Group__23410);
            rule__TypeDefinition__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TypeDefinition__Group__2"


    // $ANTLR start "rule__TypeDefinition__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1645:1: rule__TypeDefinition__Group__2__Impl : ( ( rule__TypeDefinition__ScopeAssignment_2 ) ) ;
    public final void rule__TypeDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1649:1: ( ( ( rule__TypeDefinition__ScopeAssignment_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1650:1: ( ( rule__TypeDefinition__ScopeAssignment_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1650:1: ( ( rule__TypeDefinition__ScopeAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1651:1: ( rule__TypeDefinition__ScopeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getScopeAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1652:1: ( rule__TypeDefinition__ScopeAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1652:2: rule__TypeDefinition__ScopeAssignment_2
            {
            pushFollow(FOLLOW_rule__TypeDefinition__ScopeAssignment_2_in_rule__TypeDefinition__Group__2__Impl3437);
            rule__TypeDefinition__ScopeAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getScopeAssignment_2()); 
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
    // $ANTLR end "rule__TypeDefinition__Group__2__Impl"


    // $ANTLR start "rule__Macro__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1668:1: rule__Macro__Group__0 : rule__Macro__Group__0__Impl rule__Macro__Group__1 ;
    public final void rule__Macro__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1672:1: ( rule__Macro__Group__0__Impl rule__Macro__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1673:2: rule__Macro__Group__0__Impl rule__Macro__Group__1
            {
            pushFollow(FOLLOW_rule__Macro__Group__0__Impl_in_rule__Macro__Group__03473);
            rule__Macro__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__1_in_rule__Macro__Group__03476);
            rule__Macro__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1680:1: rule__Macro__Group__0__Impl : ( ( rule__Macro__NameAssignment_0 ) ) ;
    public final void rule__Macro__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1684:1: ( ( ( rule__Macro__NameAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1685:1: ( ( rule__Macro__NameAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1685:1: ( ( rule__Macro__NameAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1686:1: ( rule__Macro__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNameAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1687:1: ( rule__Macro__NameAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1687:2: rule__Macro__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Macro__NameAssignment_0_in_rule__Macro__Group__0__Impl3503);
            rule__Macro__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__Macro__Group__0__Impl"


    // $ANTLR start "rule__Macro__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1697:1: rule__Macro__Group__1 : rule__Macro__Group__1__Impl rule__Macro__Group__2 ;
    public final void rule__Macro__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1701:1: ( rule__Macro__Group__1__Impl rule__Macro__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1702:2: rule__Macro__Group__1__Impl rule__Macro__Group__2
            {
            pushFollow(FOLLOW_rule__Macro__Group__1__Impl_in_rule__Macro__Group__13533);
            rule__Macro__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__2_in_rule__Macro__Group__13536);
            rule__Macro__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1709:1: rule__Macro__Group__1__Impl : ( 'MACRO' ) ;
    public final void rule__Macro__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1713:1: ( ( 'MACRO' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1714:1: ( 'MACRO' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1714:1: ( 'MACRO' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1715:1: 'MACRO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getMACROKeyword_1()); 
            }
            match(input,27,FOLLOW_27_in_rule__Macro__Group__1__Impl3564); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getMACROKeyword_1()); 
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
    // $ANTLR end "rule__Macro__Group__1__Impl"


    // $ANTLR start "rule__Macro__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1728:1: rule__Macro__Group__2 : rule__Macro__Group__2__Impl rule__Macro__Group__3 ;
    public final void rule__Macro__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1732:1: ( rule__Macro__Group__2__Impl rule__Macro__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1733:2: rule__Macro__Group__2__Impl rule__Macro__Group__3
            {
            pushFollow(FOLLOW_rule__Macro__Group__2__Impl_in_rule__Macro__Group__23595);
            rule__Macro__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__3_in_rule__Macro__Group__23598);
            rule__Macro__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1740:1: rule__Macro__Group__2__Impl : ( '::=' ) ;
    public final void rule__Macro__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1744:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1745:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1745:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1746:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_2()); 
            }
            match(input,22,FOLLOW_22_in_rule__Macro__Group__2__Impl3626); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_2()); 
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
    // $ANTLR end "rule__Macro__Group__2__Impl"


    // $ANTLR start "rule__Macro__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1759:1: rule__Macro__Group__3 : rule__Macro__Group__3__Impl rule__Macro__Group__4 ;
    public final void rule__Macro__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1763:1: ( rule__Macro__Group__3__Impl rule__Macro__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1764:2: rule__Macro__Group__3__Impl rule__Macro__Group__4
            {
            pushFollow(FOLLOW_rule__Macro__Group__3__Impl_in_rule__Macro__Group__33657);
            rule__Macro__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__4_in_rule__Macro__Group__33660);
            rule__Macro__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1771:1: rule__Macro__Group__3__Impl : ( 'BEGIN' ) ;
    public final void rule__Macro__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1775:1: ( ( 'BEGIN' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1776:1: ( 'BEGIN' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1776:1: ( 'BEGIN' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1777:1: 'BEGIN'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getBEGINKeyword_3()); 
            }
            match(input,23,FOLLOW_23_in_rule__Macro__Group__3__Impl3688); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getBEGINKeyword_3()); 
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
    // $ANTLR end "rule__Macro__Group__3__Impl"


    // $ANTLR start "rule__Macro__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1790:1: rule__Macro__Group__4 : rule__Macro__Group__4__Impl rule__Macro__Group__5 ;
    public final void rule__Macro__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1794:1: ( rule__Macro__Group__4__Impl rule__Macro__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1795:2: rule__Macro__Group__4__Impl rule__Macro__Group__5
            {
            pushFollow(FOLLOW_rule__Macro__Group__4__Impl_in_rule__Macro__Group__43719);
            rule__Macro__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__5_in_rule__Macro__Group__43722);
            rule__Macro__Group__5();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1802:1: rule__Macro__Group__4__Impl : ( 'TYPE NOTATION' ) ;
    public final void rule__Macro__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1806:1: ( ( 'TYPE NOTATION' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1807:1: ( 'TYPE NOTATION' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1807:1: ( 'TYPE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1808:1: 'TYPE NOTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTYPENOTATIONKeyword_4()); 
            }
            match(input,28,FOLLOW_28_in_rule__Macro__Group__4__Impl3750); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getTYPENOTATIONKeyword_4()); 
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
    // $ANTLR end "rule__Macro__Group__4__Impl"


    // $ANTLR start "rule__Macro__Group__5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1821:1: rule__Macro__Group__5 : rule__Macro__Group__5__Impl rule__Macro__Group__6 ;
    public final void rule__Macro__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1825:1: ( rule__Macro__Group__5__Impl rule__Macro__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1826:2: rule__Macro__Group__5__Impl rule__Macro__Group__6
            {
            pushFollow(FOLLOW_rule__Macro__Group__5__Impl_in_rule__Macro__Group__53781);
            rule__Macro__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__6_in_rule__Macro__Group__53784);
            rule__Macro__Group__6();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1833:1: rule__Macro__Group__5__Impl : ( '::=' ) ;
    public final void rule__Macro__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1837:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1838:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1838:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1839:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_5()); 
            }
            match(input,22,FOLLOW_22_in_rule__Macro__Group__5__Impl3812); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_5()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1852:1: rule__Macro__Group__6 : rule__Macro__Group__6__Impl rule__Macro__Group__7 ;
    public final void rule__Macro__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1856:1: ( rule__Macro__Group__6__Impl rule__Macro__Group__7 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1857:2: rule__Macro__Group__6__Impl rule__Macro__Group__7
            {
            pushFollow(FOLLOW_rule__Macro__Group__6__Impl_in_rule__Macro__Group__63843);
            rule__Macro__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__7_in_rule__Macro__Group__63846);
            rule__Macro__Group__7();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1864:1: rule__Macro__Group__6__Impl : ( ( ( rule__Macro__TypeNotationsAssignment_6 ) ) ( ( rule__Macro__TypeNotationsAssignment_6 )* ) ) ;
    public final void rule__Macro__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1868:1: ( ( ( ( rule__Macro__TypeNotationsAssignment_6 ) ) ( ( rule__Macro__TypeNotationsAssignment_6 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1869:1: ( ( ( rule__Macro__TypeNotationsAssignment_6 ) ) ( ( rule__Macro__TypeNotationsAssignment_6 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1869:1: ( ( ( rule__Macro__TypeNotationsAssignment_6 ) ) ( ( rule__Macro__TypeNotationsAssignment_6 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1870:1: ( ( rule__Macro__TypeNotationsAssignment_6 ) ) ( ( rule__Macro__TypeNotationsAssignment_6 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1870:1: ( ( rule__Macro__TypeNotationsAssignment_6 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1871:1: ( rule__Macro__TypeNotationsAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTypeNotationsAssignment_6()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1872:1: ( rule__Macro__TypeNotationsAssignment_6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1872:2: rule__Macro__TypeNotationsAssignment_6
            {
            pushFollow(FOLLOW_rule__Macro__TypeNotationsAssignment_6_in_rule__Macro__Group__6__Impl3875);
            rule__Macro__TypeNotationsAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getTypeNotationsAssignment_6()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1875:1: ( ( rule__Macro__TypeNotationsAssignment_6 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1876:1: ( rule__Macro__TypeNotationsAssignment_6 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTypeNotationsAssignment_6()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1877:1: ( rule__Macro__TypeNotationsAssignment_6 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=RULE_MODULE_ID && LA14_0<=RULE_PARAMETER)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1877:2: rule__Macro__TypeNotationsAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__Macro__TypeNotationsAssignment_6_in_rule__Macro__Group__6__Impl3887);
            	    rule__Macro__TypeNotationsAssignment_6();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getTypeNotationsAssignment_6()); 
            }

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
    // $ANTLR end "rule__Macro__Group__6__Impl"


    // $ANTLR start "rule__Macro__Group__7"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1888:1: rule__Macro__Group__7 : rule__Macro__Group__7__Impl rule__Macro__Group__8 ;
    public final void rule__Macro__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1892:1: ( rule__Macro__Group__7__Impl rule__Macro__Group__8 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1893:2: rule__Macro__Group__7__Impl rule__Macro__Group__8
            {
            pushFollow(FOLLOW_rule__Macro__Group__7__Impl_in_rule__Macro__Group__73920);
            rule__Macro__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__8_in_rule__Macro__Group__73923);
            rule__Macro__Group__8();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1900:1: rule__Macro__Group__7__Impl : ( 'VALUE NOTATION' ) ;
    public final void rule__Macro__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1904:1: ( ( 'VALUE NOTATION' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1905:1: ( 'VALUE NOTATION' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1905:1: ( 'VALUE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1906:1: 'VALUE NOTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getVALUENOTATIONKeyword_7()); 
            }
            match(input,29,FOLLOW_29_in_rule__Macro__Group__7__Impl3951); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getVALUENOTATIONKeyword_7()); 
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
    // $ANTLR end "rule__Macro__Group__7__Impl"


    // $ANTLR start "rule__Macro__Group__8"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1919:1: rule__Macro__Group__8 : rule__Macro__Group__8__Impl rule__Macro__Group__9 ;
    public final void rule__Macro__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1923:1: ( rule__Macro__Group__8__Impl rule__Macro__Group__9 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1924:2: rule__Macro__Group__8__Impl rule__Macro__Group__9
            {
            pushFollow(FOLLOW_rule__Macro__Group__8__Impl_in_rule__Macro__Group__83982);
            rule__Macro__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__9_in_rule__Macro__Group__83985);
            rule__Macro__Group__9();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1931:1: rule__Macro__Group__8__Impl : ( '::=' ) ;
    public final void rule__Macro__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1935:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1936:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1936:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1937:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_8()); 
            }
            match(input,22,FOLLOW_22_in_rule__Macro__Group__8__Impl4013); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_8()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1950:1: rule__Macro__Group__9 : rule__Macro__Group__9__Impl rule__Macro__Group__10 ;
    public final void rule__Macro__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1954:1: ( rule__Macro__Group__9__Impl rule__Macro__Group__10 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1955:2: rule__Macro__Group__9__Impl rule__Macro__Group__10
            {
            pushFollow(FOLLOW_rule__Macro__Group__9__Impl_in_rule__Macro__Group__94044);
            rule__Macro__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__10_in_rule__Macro__Group__94047);
            rule__Macro__Group__10();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1962:1: rule__Macro__Group__9__Impl : ( ( rule__Macro__ValueNotationAssignment_9 ) ) ;
    public final void rule__Macro__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1966:1: ( ( ( rule__Macro__ValueNotationAssignment_9 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1967:1: ( ( rule__Macro__ValueNotationAssignment_9 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1967:1: ( ( rule__Macro__ValueNotationAssignment_9 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1968:1: ( rule__Macro__ValueNotationAssignment_9 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getValueNotationAssignment_9()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1969:1: ( rule__Macro__ValueNotationAssignment_9 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1969:2: rule__Macro__ValueNotationAssignment_9
            {
            pushFollow(FOLLOW_rule__Macro__ValueNotationAssignment_9_in_rule__Macro__Group__9__Impl4074);
            rule__Macro__ValueNotationAssignment_9();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getValueNotationAssignment_9()); 
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
    // $ANTLR end "rule__Macro__Group__9__Impl"


    // $ANTLR start "rule__Macro__Group__10"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1979:1: rule__Macro__Group__10 : rule__Macro__Group__10__Impl rule__Macro__Group__11 ;
    public final void rule__Macro__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1983:1: ( rule__Macro__Group__10__Impl rule__Macro__Group__11 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1984:2: rule__Macro__Group__10__Impl rule__Macro__Group__11
            {
            pushFollow(FOLLOW_rule__Macro__Group__10__Impl_in_rule__Macro__Group__104104);
            rule__Macro__Group__10__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__11_in_rule__Macro__Group__104107);
            rule__Macro__Group__11();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Macro__Group__10"


    // $ANTLR start "rule__Macro__Group__10__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1991:1: rule__Macro__Group__10__Impl : ( ( ( rule__Macro__InnerTypesAssignment_10 ) ) ( ( rule__Macro__InnerTypesAssignment_10 )* ) ) ;
    public final void rule__Macro__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1995:1: ( ( ( ( rule__Macro__InnerTypesAssignment_10 ) ) ( ( rule__Macro__InnerTypesAssignment_10 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1996:1: ( ( ( rule__Macro__InnerTypesAssignment_10 ) ) ( ( rule__Macro__InnerTypesAssignment_10 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1996:1: ( ( ( rule__Macro__InnerTypesAssignment_10 ) ) ( ( rule__Macro__InnerTypesAssignment_10 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1997:1: ( ( rule__Macro__InnerTypesAssignment_10 ) ) ( ( rule__Macro__InnerTypesAssignment_10 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1997:1: ( ( rule__Macro__InnerTypesAssignment_10 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1998:1: ( rule__Macro__InnerTypesAssignment_10 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesAssignment_10()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1999:1: ( rule__Macro__InnerTypesAssignment_10 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1999:2: rule__Macro__InnerTypesAssignment_10
            {
            pushFollow(FOLLOW_rule__Macro__InnerTypesAssignment_10_in_rule__Macro__Group__10__Impl4136);
            rule__Macro__InnerTypesAssignment_10();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesAssignment_10()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2002:1: ( ( rule__Macro__InnerTypesAssignment_10 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2003:1: ( rule__Macro__InnerTypesAssignment_10 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesAssignment_10()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2004:1: ( rule__Macro__InnerTypesAssignment_10 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_MODULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2004:2: rule__Macro__InnerTypesAssignment_10
            	    {
            	    pushFollow(FOLLOW_rule__Macro__InnerTypesAssignment_10_in_rule__Macro__Group__10__Impl4148);
            	    rule__Macro__InnerTypesAssignment_10();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesAssignment_10()); 
            }

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
    // $ANTLR end "rule__Macro__Group__10__Impl"


    // $ANTLR start "rule__Macro__Group__11"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2015:1: rule__Macro__Group__11 : rule__Macro__Group__11__Impl ;
    public final void rule__Macro__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2019:1: ( rule__Macro__Group__11__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2020:2: rule__Macro__Group__11__Impl
            {
            pushFollow(FOLLOW_rule__Macro__Group__11__Impl_in_rule__Macro__Group__114181);
            rule__Macro__Group__11__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Macro__Group__11"


    // $ANTLR start "rule__Macro__Group__11__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2026:1: rule__Macro__Group__11__Impl : ( 'END' ) ;
    public final void rule__Macro__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2030:1: ( ( 'END' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2031:1: ( 'END' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2031:1: ( 'END' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2032:1: 'END'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getENDKeyword_11()); 
            }
            match(input,24,FOLLOW_24_in_rule__Macro__Group__11__Impl4209); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getENDKeyword_11()); 
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
    // $ANTLR end "rule__Macro__Group__11__Impl"


    // $ANTLR start "rule__ParamAssignment__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2069:1: rule__ParamAssignment__Group__0 : rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1 ;
    public final void rule__ParamAssignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2073:1: ( rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2074:2: rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1
            {
            pushFollow(FOLLOW_rule__ParamAssignment__Group__0__Impl_in_rule__ParamAssignment__Group__04264);
            rule__ParamAssignment__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ParamAssignment__Group__1_in_rule__ParamAssignment__Group__04267);
            rule__ParamAssignment__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ParamAssignment__Group__0"


    // $ANTLR start "rule__ParamAssignment__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2081:1: rule__ParamAssignment__Group__0__Impl : ( ( rule__ParamAssignment__ParamAssignment_0 ) ) ;
    public final void rule__ParamAssignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2085:1: ( ( ( rule__ParamAssignment__ParamAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2086:1: ( ( rule__ParamAssignment__ParamAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2086:1: ( ( rule__ParamAssignment__ParamAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2087:1: ( rule__ParamAssignment__ParamAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getParamAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2088:1: ( rule__ParamAssignment__ParamAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2088:2: rule__ParamAssignment__ParamAssignment_0
            {
            pushFollow(FOLLOW_rule__ParamAssignment__ParamAssignment_0_in_rule__ParamAssignment__Group__0__Impl4294);
            rule__ParamAssignment__ParamAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAssignmentAccess().getParamAssignment_0()); 
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
    // $ANTLR end "rule__ParamAssignment__Group__0__Impl"


    // $ANTLR start "rule__ParamAssignment__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2098:1: rule__ParamAssignment__Group__1 : rule__ParamAssignment__Group__1__Impl ;
    public final void rule__ParamAssignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2102:1: ( rule__ParamAssignment__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2103:2: rule__ParamAssignment__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParamAssignment__Group__1__Impl_in_rule__ParamAssignment__Group__14324);
            rule__ParamAssignment__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ParamAssignment__Group__1"


    // $ANTLR start "rule__ParamAssignment__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2109:1: rule__ParamAssignment__Group__1__Impl : ( ( rule__ParamAssignment__RightAssignment_1 ) ) ;
    public final void rule__ParamAssignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2113:1: ( ( ( rule__ParamAssignment__RightAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2114:1: ( ( rule__ParamAssignment__RightAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2114:1: ( ( rule__ParamAssignment__RightAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2115:1: ( rule__ParamAssignment__RightAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getRightAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2116:1: ( rule__ParamAssignment__RightAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2116:2: rule__ParamAssignment__RightAssignment_1
            {
            pushFollow(FOLLOW_rule__ParamAssignment__RightAssignment_1_in_rule__ParamAssignment__Group__1__Impl4351);
            rule__ParamAssignment__RightAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAssignmentAccess().getRightAssignment_1()); 
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
    // $ANTLR end "rule__ParamAssignment__Group__1__Impl"


    // $ANTLR start "rule__TypeReferenceExt__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2130:1: rule__TypeReferenceExt__Group__0 : rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1 ;
    public final void rule__TypeReferenceExt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2134:1: ( rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2135:2: rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__0__Impl_in_rule__TypeReferenceExt__Group__04385);
            rule__TypeReferenceExt__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__1_in_rule__TypeReferenceExt__Group__04388);
            rule__TypeReferenceExt__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TypeReferenceExt__Group__0"


    // $ANTLR start "rule__TypeReferenceExt__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2142:1: rule__TypeReferenceExt__Group__0__Impl : ( ruleTypeReference ) ;
    public final void rule__TypeReferenceExt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2146:1: ( ( ruleTypeReference ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2147:1: ( ruleTypeReference )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2147:1: ( ruleTypeReference )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2148:1: ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getTypeReferenceParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__Group__0__Impl4415);
            ruleTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceExtAccess().getTypeReferenceParserRuleCall_0()); 
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
    // $ANTLR end "rule__TypeReferenceExt__Group__0__Impl"


    // $ANTLR start "rule__TypeReferenceExt__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2159:1: rule__TypeReferenceExt__Group__1 : rule__TypeReferenceExt__Group__1__Impl ;
    public final void rule__TypeReferenceExt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2163:1: ( rule__TypeReferenceExt__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2164:2: rule__TypeReferenceExt__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__1__Impl_in_rule__TypeReferenceExt__Group__14444);
            rule__TypeReferenceExt__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__TypeReferenceExt__Group__1"


    // $ANTLR start "rule__TypeReferenceExt__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2170:1: rule__TypeReferenceExt__Group__1__Impl : ( ( rule__TypeReferenceExt__RightAssignment_1 )? ) ;
    public final void rule__TypeReferenceExt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2174:1: ( ( ( rule__TypeReferenceExt__RightAssignment_1 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2175:1: ( ( rule__TypeReferenceExt__RightAssignment_1 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2175:1: ( ( rule__TypeReferenceExt__RightAssignment_1 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2176:1: ( rule__TypeReferenceExt__RightAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getRightAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2177:1: ( rule__TypeReferenceExt__RightAssignment_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_MODULE_ID) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==EOF||LA16_1==RULE_ASN1_ID||LA16_1==RULE_MODULE_ID||LA16_1==24||LA16_1==30) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2177:2: rule__TypeReferenceExt__RightAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TypeReferenceExt__RightAssignment_1_in_rule__TypeReferenceExt__Group__1__Impl4471);
                    rule__TypeReferenceExt__RightAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceExtAccess().getRightAssignment_1()); 
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
    // $ANTLR end "rule__TypeReferenceExt__Group__1__Impl"


    // $ANTLR start "rule__Value__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2191:1: rule__Value__Group__0 : rule__Value__Group__0__Impl rule__Value__Group__1 ;
    public final void rule__Value__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2195:1: ( rule__Value__Group__0__Impl rule__Value__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2196:2: rule__Value__Group__0__Impl rule__Value__Group__1
            {
            pushFollow(FOLLOW_rule__Value__Group__0__Impl_in_rule__Value__Group__04506);
            rule__Value__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group__1_in_rule__Value__Group__04509);
            rule__Value__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Value__Group__0"


    // $ANTLR start "rule__Value__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2203:1: rule__Value__Group__0__Impl : ( ( rule__Value__ValueTypesAssignment_0 ) ) ;
    public final void rule__Value__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2207:1: ( ( ( rule__Value__ValueTypesAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2208:1: ( ( rule__Value__ValueTypesAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2208:1: ( ( rule__Value__ValueTypesAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2209:1: ( rule__Value__ValueTypesAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2210:1: ( rule__Value__ValueTypesAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2210:2: rule__Value__ValueTypesAssignment_0
            {
            pushFollow(FOLLOW_rule__Value__ValueTypesAssignment_0_in_rule__Value__Group__0__Impl4536);
            rule__Value__ValueTypesAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesAssignment_0()); 
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
    // $ANTLR end "rule__Value__Group__0__Impl"


    // $ANTLR start "rule__Value__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2220:1: rule__Value__Group__1 : rule__Value__Group__1__Impl ;
    public final void rule__Value__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2224:1: ( rule__Value__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2225:2: rule__Value__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group__1__Impl_in_rule__Value__Group__14566);
            rule__Value__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Value__Group__1"


    // $ANTLR start "rule__Value__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2231:1: rule__Value__Group__1__Impl : ( ( rule__Value__Group_1__0 )* ) ;
    public final void rule__Value__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2235:1: ( ( ( rule__Value__Group_1__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2236:1: ( ( rule__Value__Group_1__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2236:1: ( ( rule__Value__Group_1__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2237:1: ( rule__Value__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getGroup_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2238:1: ( rule__Value__Group_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==30) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2238:2: rule__Value__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Value__Group_1__0_in_rule__Value__Group__1__Impl4593);
            	    rule__Value__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getGroup_1()); 
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
    // $ANTLR end "rule__Value__Group__1__Impl"


    // $ANTLR start "rule__Value__Group_1__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2252:1: rule__Value__Group_1__0 : rule__Value__Group_1__0__Impl rule__Value__Group_1__1 ;
    public final void rule__Value__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2256:1: ( rule__Value__Group_1__0__Impl rule__Value__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2257:2: rule__Value__Group_1__0__Impl rule__Value__Group_1__1
            {
            pushFollow(FOLLOW_rule__Value__Group_1__0__Impl_in_rule__Value__Group_1__04628);
            rule__Value__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group_1__1_in_rule__Value__Group_1__04631);
            rule__Value__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Value__Group_1__0"


    // $ANTLR start "rule__Value__Group_1__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2264:1: rule__Value__Group_1__0__Impl : ( '|' ) ;
    public final void rule__Value__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2268:1: ( ( '|' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2269:1: ( '|' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2269:1: ( '|' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2270:1: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getVerticalLineKeyword_1_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__Value__Group_1__0__Impl4659); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getVerticalLineKeyword_1_0()); 
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
    // $ANTLR end "rule__Value__Group_1__0__Impl"


    // $ANTLR start "rule__Value__Group_1__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2283:1: rule__Value__Group_1__1 : rule__Value__Group_1__1__Impl ;
    public final void rule__Value__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2287:1: ( rule__Value__Group_1__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2288:2: rule__Value__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group_1__1__Impl_in_rule__Value__Group_1__14690);
            rule__Value__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__Value__Group_1__1"


    // $ANTLR start "rule__Value__Group_1__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2294:1: rule__Value__Group_1__1__Impl : ( ( rule__Value__ValueTypesAssignment_1_1 ) ) ;
    public final void rule__Value__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2298:1: ( ( ( rule__Value__ValueTypesAssignment_1_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2299:1: ( ( rule__Value__ValueTypesAssignment_1_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2299:1: ( ( rule__Value__ValueTypesAssignment_1_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2300:1: ( rule__Value__ValueTypesAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesAssignment_1_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2301:1: ( rule__Value__ValueTypesAssignment_1_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2301:2: rule__Value__ValueTypesAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Value__ValueTypesAssignment_1_1_in_rule__Value__Group_1__1__Impl4717);
            rule__Value__ValueTypesAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesAssignment_1_1()); 
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
    // $ANTLR end "rule__Value__Group_1__1__Impl"


    // $ANTLR start "rule__ValueType__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2315:1: rule__ValueType__Group__0 : rule__ValueType__Group__0__Impl rule__ValueType__Group__1 ;
    public final void rule__ValueType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2319:1: ( rule__ValueType__Group__0__Impl rule__ValueType__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2320:2: rule__ValueType__Group__0__Impl rule__ValueType__Group__1
            {
            pushFollow(FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__04751);
            rule__ValueType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__04754);
            rule__ValueType__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2327:1: rule__ValueType__Group__0__Impl : ( ( rule__ValueType__NameAssignment_0 )? ) ;
    public final void rule__ValueType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2331:1: ( ( ( rule__ValueType__NameAssignment_0 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2332:1: ( ( rule__ValueType__NameAssignment_0 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2332:1: ( ( rule__ValueType__NameAssignment_0 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2333:1: ( rule__ValueType__NameAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2334:1: ( rule__ValueType__NameAssignment_0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_IA5STRING) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==RULE_IA5STRING||LA18_1==RULE_PARAMETER||LA18_1==19||LA18_1==31||(LA18_1>=35 && LA18_1<=37)||LA18_1==40) ) {
                    alt18=1;
                }
                else if ( (LA18_1==RULE_MODULE_ID) ) {
                    int LA18_4 = input.LA(3);

                    if ( (LA18_4==EOF||LA18_4==RULE_ASN1_ID||LA18_4==RULE_MODULE_ID||LA18_4==24||LA18_4==30) ) {
                        alt18=1;
                    }
                }
            }
            switch (alt18) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2334:2: rule__ValueType__NameAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ValueType__NameAssignment_0_in_rule__ValueType__Group__0__Impl4781);
                    rule__ValueType__NameAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getNameAssignment_0()); 
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
    // $ANTLR end "rule__ValueType__Group__0__Impl"


    // $ANTLR start "rule__ValueType__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2344:1: rule__ValueType__Group__1 : rule__ValueType__Group__1__Impl ;
    public final void rule__ValueType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2348:1: ( rule__ValueType__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2349:2: rule__ValueType__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__14812);
            rule__ValueType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2355:1: rule__ValueType__Group__1__Impl : ( ( rule__ValueType__Alternatives_1 ) ) ;
    public final void rule__ValueType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2359:1: ( ( ( rule__ValueType__Alternatives_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2360:1: ( ( rule__ValueType__Alternatives_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2360:1: ( ( rule__ValueType__Alternatives_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2361:1: ( rule__ValueType__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2362:1: ( rule__ValueType__Alternatives_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2362:2: rule__ValueType__Alternatives_1
            {
            pushFollow(FOLLOW_rule__ValueType__Alternatives_1_in_rule__ValueType__Group__1__Impl4839);
            rule__ValueType__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getAlternatives_1()); 
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
    // $ANTLR end "rule__ValueType__Group__1__Impl"


    // $ANTLR start "rule__MacroValue__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2376:1: rule__MacroValue__Group__0 : rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1 ;
    public final void rule__MacroValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2380:1: ( rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2381:2: rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__0__Impl_in_rule__MacroValue__Group__04873);
            rule__MacroValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__1_in_rule__MacroValue__Group__04876);
            rule__MacroValue__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2388:1: rule__MacroValue__Group__0__Impl : ( () ) ;
    public final void rule__MacroValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2392:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2393:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2393:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2394:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getMacroValueAction_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2395:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2397:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueAccess().getMacroValueAction_0()); 
            }

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2407:1: rule__MacroValue__Group__1 : rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2 ;
    public final void rule__MacroValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2411:1: ( rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2412:2: rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__1__Impl_in_rule__MacroValue__Group__14934);
            rule__MacroValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__2_in_rule__MacroValue__Group__14937);
            rule__MacroValue__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2419:1: rule__MacroValue__Group__1__Impl : ( 'value' ) ;
    public final void rule__MacroValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2423:1: ( ( 'value' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2424:1: ( 'value' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2424:1: ( 'value' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2425:1: 'value'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getValueKeyword_1()); 
            }
            match(input,31,FOLLOW_31_in_rule__MacroValue__Group__1__Impl4965); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueAccess().getValueKeyword_1()); 
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
    // $ANTLR end "rule__MacroValue__Group__1__Impl"


    // $ANTLR start "rule__MacroValue__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2438:1: rule__MacroValue__Group__2 : rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3 ;
    public final void rule__MacroValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2442:1: ( rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2443:2: rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__2__Impl_in_rule__MacroValue__Group__24996);
            rule__MacroValue__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__3_in_rule__MacroValue__Group__24999);
            rule__MacroValue__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2450:1: rule__MacroValue__Group__2__Impl : ( '(' ) ;
    public final void rule__MacroValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2454:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2455:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2455:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2456:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,32,FOLLOW_32_in_rule__MacroValue__Group__2__Impl5027); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueAccess().getLeftParenthesisKeyword_2()); 
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
    // $ANTLR end "rule__MacroValue__Group__2__Impl"


    // $ANTLR start "rule__MacroValue__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2469:1: rule__MacroValue__Group__3 : rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4 ;
    public final void rule__MacroValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2473:1: ( rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2474:2: rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__3__Impl_in_rule__MacroValue__Group__35058);
            rule__MacroValue__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__4_in_rule__MacroValue__Group__35061);
            rule__MacroValue__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2481:1: rule__MacroValue__Group__3__Impl : ( ( rule__MacroValue__TypeAssignment_3 ) ) ;
    public final void rule__MacroValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2485:1: ( ( ( rule__MacroValue__TypeAssignment_3 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2486:1: ( ( rule__MacroValue__TypeAssignment_3 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2486:1: ( ( rule__MacroValue__TypeAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2487:1: ( rule__MacroValue__TypeAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getTypeAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2488:1: ( rule__MacroValue__TypeAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2488:2: rule__MacroValue__TypeAssignment_3
            {
            pushFollow(FOLLOW_rule__MacroValue__TypeAssignment_3_in_rule__MacroValue__Group__3__Impl5088);
            rule__MacroValue__TypeAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueAccess().getTypeAssignment_3()); 
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
    // $ANTLR end "rule__MacroValue__Group__3__Impl"


    // $ANTLR start "rule__MacroValue__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2498:1: rule__MacroValue__Group__4 : rule__MacroValue__Group__4__Impl ;
    public final void rule__MacroValue__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2502:1: ( rule__MacroValue__Group__4__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2503:2: rule__MacroValue__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__4__Impl_in_rule__MacroValue__Group__45118);
            rule__MacroValue__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2509:1: rule__MacroValue__Group__4__Impl : ( ')' ) ;
    public final void rule__MacroValue__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2513:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2514:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2514:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2515:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,33,FOLLOW_33_in_rule__MacroValue__Group__4__Impl5146); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueAccess().getRightParenthesisKeyword_4()); 
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
    // $ANTLR end "rule__MacroValue__Group__4__Impl"


    // $ANTLR start "rule__UpdateType__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2538:1: rule__UpdateType__Group__0 : rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1 ;
    public final void rule__UpdateType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2542:1: ( rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2543:2: rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__0__Impl_in_rule__UpdateType__Group__05187);
            rule__UpdateType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__UpdateType__Group__1_in_rule__UpdateType__Group__05190);
            rule__UpdateType__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__UpdateType__Group__0"


    // $ANTLR start "rule__UpdateType__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2550:1: rule__UpdateType__Group__0__Impl : ( 'Update' ) ;
    public final void rule__UpdateType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2554:1: ( ( 'Update' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2555:1: ( 'Update' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2555:1: ( 'Update' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2556:1: 'Update'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getUpdateKeyword_0()); 
            }
            match(input,34,FOLLOW_34_in_rule__UpdateType__Group__0__Impl5218); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateTypeAccess().getUpdateKeyword_0()); 
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
    // $ANTLR end "rule__UpdateType__Group__0__Impl"


    // $ANTLR start "rule__UpdateType__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2569:1: rule__UpdateType__Group__1 : rule__UpdateType__Group__1__Impl ;
    public final void rule__UpdateType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2573:1: ( rule__UpdateType__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2574:2: rule__UpdateType__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__1__Impl_in_rule__UpdateType__Group__15249);
            rule__UpdateType__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__UpdateType__Group__1"


    // $ANTLR start "rule__UpdateType__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2580:1: rule__UpdateType__Group__1__Impl : ( ( rule__UpdateType__TypeAssignment_1 ) ) ;
    public final void rule__UpdateType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2584:1: ( ( ( rule__UpdateType__TypeAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2585:1: ( ( rule__UpdateType__TypeAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2585:1: ( ( rule__UpdateType__TypeAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2586:1: ( rule__UpdateType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getTypeAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2587:1: ( rule__UpdateType__TypeAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2587:2: rule__UpdateType__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__UpdateType__TypeAssignment_1_in_rule__UpdateType__Group__1__Impl5276);
            rule__UpdateType__TypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateTypeAccess().getTypeAssignment_1()); 
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
    // $ANTLR end "rule__UpdateType__Group__1__Impl"


    // $ANTLR start "rule__MACRO_VALUE_CAP__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2601:1: rule__MACRO_VALUE_CAP__Group__0 : rule__MACRO_VALUE_CAP__Group__0__Impl rule__MACRO_VALUE_CAP__Group__1 ;
    public final void rule__MACRO_VALUE_CAP__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2605:1: ( rule__MACRO_VALUE_CAP__Group__0__Impl rule__MACRO_VALUE_CAP__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2606:2: rule__MACRO_VALUE_CAP__Group__0__Impl rule__MACRO_VALUE_CAP__Group__1
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__Group__0__Impl_in_rule__MACRO_VALUE_CAP__Group__05310);
            rule__MACRO_VALUE_CAP__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__Group__1_in_rule__MACRO_VALUE_CAP__Group__05313);
            rule__MACRO_VALUE_CAP__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__MACRO_VALUE_CAP__Group__0"


    // $ANTLR start "rule__MACRO_VALUE_CAP__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2613:1: rule__MACRO_VALUE_CAP__Group__0__Impl : ( ( rule__MACRO_VALUE_CAP__ValueAssignment_0 ) ) ;
    public final void rule__MACRO_VALUE_CAP__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2617:1: ( ( ( rule__MACRO_VALUE_CAP__ValueAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2618:1: ( ( rule__MACRO_VALUE_CAP__ValueAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2618:1: ( ( rule__MACRO_VALUE_CAP__ValueAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2619:1: ( rule__MACRO_VALUE_CAP__ValueAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getValueAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2620:1: ( rule__MACRO_VALUE_CAP__ValueAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2620:2: rule__MACRO_VALUE_CAP__ValueAssignment_0
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__ValueAssignment_0_in_rule__MACRO_VALUE_CAP__Group__0__Impl5340);
            rule__MACRO_VALUE_CAP__ValueAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPAccess().getValueAssignment_0()); 
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
    // $ANTLR end "rule__MACRO_VALUE_CAP__Group__0__Impl"


    // $ANTLR start "rule__MACRO_VALUE_CAP__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2630:1: rule__MACRO_VALUE_CAP__Group__1 : rule__MACRO_VALUE_CAP__Group__1__Impl ;
    public final void rule__MACRO_VALUE_CAP__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2634:1: ( rule__MACRO_VALUE_CAP__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2635:2: rule__MACRO_VALUE_CAP__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__Group__1__Impl_in_rule__MACRO_VALUE_CAP__Group__15370);
            rule__MACRO_VALUE_CAP__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__MACRO_VALUE_CAP__Group__1"


    // $ANTLR start "rule__MACRO_VALUE_CAP__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2641:1: rule__MACRO_VALUE_CAP__Group__1__Impl : ( ( rule__MACRO_VALUE_CAP__LiteralAssignment_1 ) ) ;
    public final void rule__MACRO_VALUE_CAP__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2645:1: ( ( ( rule__MACRO_VALUE_CAP__LiteralAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2646:1: ( ( rule__MACRO_VALUE_CAP__LiteralAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2646:1: ( ( rule__MACRO_VALUE_CAP__LiteralAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2647:1: ( rule__MACRO_VALUE_CAP__LiteralAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getLiteralAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2648:1: ( rule__MACRO_VALUE_CAP__LiteralAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2648:2: rule__MACRO_VALUE_CAP__LiteralAssignment_1
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__LiteralAssignment_1_in_rule__MACRO_VALUE_CAP__Group__1__Impl5397);
            rule__MACRO_VALUE_CAP__LiteralAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPAccess().getLiteralAssignment_1()); 
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
    // $ANTLR end "rule__MACRO_VALUE_CAP__Group__1__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_0__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2662:1: rule__ASN1_SIMPLE__Group_0__0 : rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1 ;
    public final void rule__ASN1_SIMPLE__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2666:1: ( rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2667:2: rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__0__Impl_in_rule__ASN1_SIMPLE__Group_0__05431);
            rule__ASN1_SIMPLE__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__1_in_rule__ASN1_SIMPLE__Group_0__05434);
            rule__ASN1_SIMPLE__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2674:1: rule__ASN1_SIMPLE__Group_0__0__Impl : ( () ) ;
    public final void rule__ASN1_SIMPLE__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2678:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2679:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2679:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2680:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2681:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2683:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0()); 
            }

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2693:1: rule__ASN1_SIMPLE__Group_0__1 : rule__ASN1_SIMPLE__Group_0__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2697:1: ( rule__ASN1_SIMPLE__Group_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2698:2: rule__ASN1_SIMPLE__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__1__Impl_in_rule__ASN1_SIMPLE__Group_0__15492);
            rule__ASN1_SIMPLE__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2704:1: rule__ASN1_SIMPLE__Group_0__1__Impl : ( 'empty' ) ;
    public final void rule__ASN1_SIMPLE__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2708:1: ( ( 'empty' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2709:1: ( 'empty' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2709:1: ( 'empty' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2710:1: 'empty'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1()); 
            }
            match(input,35,FOLLOW_35_in_rule__ASN1_SIMPLE__Group_0__1__Impl5520); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1()); 
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
    // $ANTLR end "rule__ASN1_SIMPLE__Group_0__1__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_1__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2727:1: rule__ASN1_SIMPLE__Group_1__0 : rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1 ;
    public final void rule__ASN1_SIMPLE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2731:1: ( rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2732:2: rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__0__Impl_in_rule__ASN1_SIMPLE__Group_1__05555);
            rule__ASN1_SIMPLE__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__1_in_rule__ASN1_SIMPLE__Group_1__05558);
            rule__ASN1_SIMPLE__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SIMPLE__Group_1__0"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_1__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2739:1: rule__ASN1_SIMPLE__Group_1__0__Impl : ( () ) ;
    public final void rule__ASN1_SIMPLE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2743:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2744:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2744:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2745:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2746:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2748:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_SIMPLE__Group_1__0__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_1__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2758:1: rule__ASN1_SIMPLE__Group_1__1 : rule__ASN1_SIMPLE__Group_1__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2762:1: ( rule__ASN1_SIMPLE__Group_1__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2763:2: rule__ASN1_SIMPLE__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__1__Impl_in_rule__ASN1_SIMPLE__Group_1__15616);
            rule__ASN1_SIMPLE__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SIMPLE__Group_1__1"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_1__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2769:1: rule__ASN1_SIMPLE__Group_1__1__Impl : ( RULE_IA5STRING ) ;
    public final void rule__ASN1_SIMPLE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2773:1: ( ( RULE_IA5STRING ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2774:1: ( RULE_IA5STRING )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2774:1: ( RULE_IA5STRING )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2775:1: RULE_IA5STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()); 
            }
            match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_rule__ASN1_SIMPLE__Group_1__1__Impl5643); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()); 
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
    // $ANTLR end "rule__ASN1_SIMPLE__Group_1__1__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2790:1: rule__ASN1_SIMPLE__Group_2__0 : rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1 ;
    public final void rule__ASN1_SIMPLE__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2794:1: ( rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2795:2: rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__0__Impl_in_rule__ASN1_SIMPLE__Group_2__05676);
            rule__ASN1_SIMPLE__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__1_in_rule__ASN1_SIMPLE__Group_2__05679);
            rule__ASN1_SIMPLE__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2802:1: rule__ASN1_SIMPLE__Group_2__0__Impl : ( ruleASN1_OCTET_STRING ) ;
    public final void rule__ASN1_SIMPLE__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2806:1: ( ( ruleASN1_OCTET_STRING ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2807:1: ( ruleASN1_OCTET_STRING )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2807:1: ( ruleASN1_OCTET_STRING )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2808:1: ruleASN1_OCTET_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_rule__ASN1_SIMPLE__Group_2__0__Impl5706);
            ruleASN1_OCTET_STRING();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2__0__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_2__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2819:1: rule__ASN1_SIMPLE__Group_2__1 : rule__ASN1_SIMPLE__Group_2__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2823:1: ( rule__ASN1_SIMPLE__Group_2__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2824:2: rule__ASN1_SIMPLE__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__1__Impl_in_rule__ASN1_SIMPLE__Group_2__15735);
            rule__ASN1_SIMPLE__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2830:1: rule__ASN1_SIMPLE__Group_2__1__Impl : ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? ) ;
    public final void rule__ASN1_SIMPLE__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2834:1: ( ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2835:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2835:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2836:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_2_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2837:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==32) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2837:2: rule__ASN1_SIMPLE__ConstraintAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_in_rule__ASN1_SIMPLE__Group_2__1__Impl5762);
                    rule__ASN1_SIMPLE__ConstraintAssignment_2_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_2_1()); 
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
    // $ANTLR end "rule__ASN1_SIMPLE__Group_2__1__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_3__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2851:1: rule__ASN1_SIMPLE__Group_3__0 : rule__ASN1_SIMPLE__Group_3__0__Impl rule__ASN1_SIMPLE__Group_3__1 ;
    public final void rule__ASN1_SIMPLE__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2855:1: ( rule__ASN1_SIMPLE__Group_3__0__Impl rule__ASN1_SIMPLE__Group_3__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2856:2: rule__ASN1_SIMPLE__Group_3__0__Impl rule__ASN1_SIMPLE__Group_3__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__0__Impl_in_rule__ASN1_SIMPLE__Group_3__05797);
            rule__ASN1_SIMPLE__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__1_in_rule__ASN1_SIMPLE__Group_3__05800);
            rule__ASN1_SIMPLE__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SIMPLE__Group_3__0"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_3__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2863:1: rule__ASN1_SIMPLE__Group_3__0__Impl : ( ruleASN1_INTEGER ) ;
    public final void rule__ASN1_SIMPLE__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2867:1: ( ( ruleASN1_INTEGER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2868:1: ( ruleASN1_INTEGER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2868:1: ( ruleASN1_INTEGER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2869:1: ruleASN1_INTEGER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_rule__ASN1_SIMPLE__Group_3__0__Impl5827);
            ruleASN1_INTEGER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__ASN1_SIMPLE__Group_3__0__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_3__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2880:1: rule__ASN1_SIMPLE__Group_3__1 : rule__ASN1_SIMPLE__Group_3__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2884:1: ( rule__ASN1_SIMPLE__Group_3__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2885:2: rule__ASN1_SIMPLE__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__1__Impl_in_rule__ASN1_SIMPLE__Group_3__15856);
            rule__ASN1_SIMPLE__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SIMPLE__Group_3__1"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_3__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2891:1: rule__ASN1_SIMPLE__Group_3__1__Impl : ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? ) ;
    public final void rule__ASN1_SIMPLE__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2895:1: ( ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2896:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2896:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2897:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_3_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2898:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2898:2: rule__ASN1_SIMPLE__ConstraintAssignment_3_1
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_3_1_in_rule__ASN1_SIMPLE__Group_3__1__Impl5883);
                    rule__ASN1_SIMPLE__ConstraintAssignment_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_3_1()); 
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
    // $ANTLR end "rule__ASN1_SIMPLE__Group_3__1__Impl"


    // $ANTLR start "rule__ASN1_OCTET_STRING__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2912:1: rule__ASN1_OCTET_STRING__Group__0 : rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1 ;
    public final void rule__ASN1_OCTET_STRING__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2916:1: ( rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2917:2: rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__0__Impl_in_rule__ASN1_OCTET_STRING__Group__05918);
            rule__ASN1_OCTET_STRING__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__1_in_rule__ASN1_OCTET_STRING__Group__05921);
            rule__ASN1_OCTET_STRING__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2924:1: rule__ASN1_OCTET_STRING__Group__0__Impl : ( () ) ;
    public final void rule__ASN1_OCTET_STRING__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2928:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2929:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2929:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2930:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2931:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2933:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0()); 
            }

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2943:1: rule__ASN1_OCTET_STRING__Group__1 : rule__ASN1_OCTET_STRING__Group__1__Impl ;
    public final void rule__ASN1_OCTET_STRING__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2947:1: ( rule__ASN1_OCTET_STRING__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2948:2: rule__ASN1_OCTET_STRING__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__1__Impl_in_rule__ASN1_OCTET_STRING__Group__15979);
            rule__ASN1_OCTET_STRING__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2954:1: rule__ASN1_OCTET_STRING__Group__1__Impl : ( 'OCTET STRING' ) ;
    public final void rule__ASN1_OCTET_STRING__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2958:1: ( ( 'OCTET STRING' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2959:1: ( 'OCTET STRING' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2959:1: ( 'OCTET STRING' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2960:1: 'OCTET STRING'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getOCTETSTRINGKeyword_1()); 
            }
            match(input,36,FOLLOW_36_in_rule__ASN1_OCTET_STRING__Group__1__Impl6007); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_OCTET_STRINGAccess().getOCTETSTRINGKeyword_1()); 
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
    // $ANTLR end "rule__ASN1_OCTET_STRING__Group__1__Impl"


    // $ANTLR start "rule__ASN1_INTEGER__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2977:1: rule__ASN1_INTEGER__Group__0 : rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1 ;
    public final void rule__ASN1_INTEGER__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2981:1: ( rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2982:2: rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__0__Impl_in_rule__ASN1_INTEGER__Group__06042);
            rule__ASN1_INTEGER__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__1_in_rule__ASN1_INTEGER__Group__06045);
            rule__ASN1_INTEGER__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2989:1: rule__ASN1_INTEGER__Group__0__Impl : ( 'INTEGER' ) ;
    public final void rule__ASN1_INTEGER__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2993:1: ( ( 'INTEGER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2994:1: ( 'INTEGER' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2994:1: ( 'INTEGER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2995:1: 'INTEGER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getINTEGERKeyword_0()); 
            }
            match(input,37,FOLLOW_37_in_rule__ASN1_INTEGER__Group__0__Impl6073); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getINTEGERKeyword_0()); 
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
    // $ANTLR end "rule__ASN1_INTEGER__Group__0__Impl"


    // $ANTLR start "rule__ASN1_INTEGER__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3008:1: rule__ASN1_INTEGER__Group__1 : rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2 ;
    public final void rule__ASN1_INTEGER__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3012:1: ( rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3013:2: rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__1__Impl_in_rule__ASN1_INTEGER__Group__16104);
            rule__ASN1_INTEGER__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__2_in_rule__ASN1_INTEGER__Group__16107);
            rule__ASN1_INTEGER__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3020:1: rule__ASN1_INTEGER__Group__1__Impl : ( '{' ) ;
    public final void rule__ASN1_INTEGER__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3024:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3025:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3025:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3026:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,25,FOLLOW_25_in_rule__ASN1_INTEGER__Group__1__Impl6135); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getLeftCurlyBracketKeyword_1()); 
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
    // $ANTLR end "rule__ASN1_INTEGER__Group__1__Impl"


    // $ANTLR start "rule__ASN1_INTEGER__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3039:1: rule__ASN1_INTEGER__Group__2 : rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3 ;
    public final void rule__ASN1_INTEGER__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3043:1: ( rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3044:2: rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__2__Impl_in_rule__ASN1_INTEGER__Group__26166);
            rule__ASN1_INTEGER__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__3_in_rule__ASN1_INTEGER__Group__26169);
            rule__ASN1_INTEGER__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3051:1: rule__ASN1_INTEGER__Group__2__Impl : ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) ) ;
    public final void rule__ASN1_INTEGER__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3055:1: ( ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3056:1: ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3056:1: ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3057:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3057:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3058:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3059:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3059:2: rule__ASN1_INTEGER__ValuePairsAssignment_2
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6198);
            rule__ASN1_INTEGER__ValuePairsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3062:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3063:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3064:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID||LA21_0==32) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3064:2: rule__ASN1_INTEGER__ValuePairsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6210);
            	    rule__ASN1_INTEGER__ValuePairsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            }

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3075:1: rule__ASN1_INTEGER__Group__3 : rule__ASN1_INTEGER__Group__3__Impl ;
    public final void rule__ASN1_INTEGER__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3079:1: ( rule__ASN1_INTEGER__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3080:2: rule__ASN1_INTEGER__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__3__Impl_in_rule__ASN1_INTEGER__Group__36243);
            rule__ASN1_INTEGER__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3086:1: rule__ASN1_INTEGER__Group__3__Impl : ( '}' ) ;
    public final void rule__ASN1_INTEGER__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3090:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3091:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3091:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3092:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,26,FOLLOW_26_in_rule__ASN1_INTEGER__Group__3__Impl6271); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getRightCurlyBracketKeyword_3()); 
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
    // $ANTLR end "rule__ASN1_INTEGER__Group__3__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3113:1: rule__ASN1_SUBTYPE__Group__0 : rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1 ;
    public final void rule__ASN1_SUBTYPE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3117:1: ( rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3118:2: rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__0__Impl_in_rule__ASN1_SUBTYPE__Group__06310);
            rule__ASN1_SUBTYPE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__1_in_rule__ASN1_SUBTYPE__Group__06313);
            rule__ASN1_SUBTYPE__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__0"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3125:1: rule__ASN1_SUBTYPE__Group__0__Impl : ( '(' ) ;
    public final void rule__ASN1_SUBTYPE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3129:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3130:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3130:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3131:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,32,FOLLOW_32_in_rule__ASN1_SUBTYPE__Group__0__Impl6341); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_0()); 
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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__0__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3144:1: rule__ASN1_SUBTYPE__Group__1 : rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2 ;
    public final void rule__ASN1_SUBTYPE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3148:1: ( rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3149:2: rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__1__Impl_in_rule__ASN1_SUBTYPE__Group__16372);
            rule__ASN1_SUBTYPE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__2_in_rule__ASN1_SUBTYPE__Group__16375);
            rule__ASN1_SUBTYPE__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__1"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3156:1: rule__ASN1_SUBTYPE__Group__1__Impl : ( 'SIZE' ) ;
    public final void rule__ASN1_SUBTYPE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3160:1: ( ( 'SIZE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3161:1: ( 'SIZE' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3161:1: ( 'SIZE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3162:1: 'SIZE'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_1()); 
            }
            match(input,38,FOLLOW_38_in_rule__ASN1_SUBTYPE__Group__1__Impl6403); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_1()); 
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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__1__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3175:1: rule__ASN1_SUBTYPE__Group__2 : rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3 ;
    public final void rule__ASN1_SUBTYPE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3179:1: ( rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3180:2: rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__2__Impl_in_rule__ASN1_SUBTYPE__Group__26434);
            rule__ASN1_SUBTYPE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__3_in_rule__ASN1_SUBTYPE__Group__26437);
            rule__ASN1_SUBTYPE__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__2"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3187:1: rule__ASN1_SUBTYPE__Group__2__Impl : ( '(' ) ;
    public final void rule__ASN1_SUBTYPE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3191:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3192:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3192:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3193:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,32,FOLLOW_32_in_rule__ASN1_SUBTYPE__Group__2__Impl6465); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_2()); 
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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__2__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3206:1: rule__ASN1_SUBTYPE__Group__3 : rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4 ;
    public final void rule__ASN1_SUBTYPE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3210:1: ( rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3211:2: rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__3__Impl_in_rule__ASN1_SUBTYPE__Group__36496);
            rule__ASN1_SUBTYPE__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__4_in_rule__ASN1_SUBTYPE__Group__36499);
            rule__ASN1_SUBTYPE__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__3"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3218:1: rule__ASN1_SUBTYPE__Group__3__Impl : ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) ) ;
    public final void rule__ASN1_SUBTYPE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3222:1: ( ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3223:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3223:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3224:1: ( rule__ASN1_SUBTYPE__RangesAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3225:1: ( rule__ASN1_SUBTYPE__RangesAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3225:2: rule__ASN1_SUBTYPE__RangesAssignment_3
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_3_in_rule__ASN1_SUBTYPE__Group__3__Impl6526);
            rule__ASN1_SUBTYPE__RangesAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_3()); 
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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__3__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3235:1: rule__ASN1_SUBTYPE__Group__4 : rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5 ;
    public final void rule__ASN1_SUBTYPE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3239:1: ( rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3240:2: rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__4__Impl_in_rule__ASN1_SUBTYPE__Group__46556);
            rule__ASN1_SUBTYPE__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__5_in_rule__ASN1_SUBTYPE__Group__46559);
            rule__ASN1_SUBTYPE__Group__5();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__4"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__4__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3247:1: rule__ASN1_SUBTYPE__Group__4__Impl : ( ( rule__ASN1_SUBTYPE__Group_4__0 )* ) ;
    public final void rule__ASN1_SUBTYPE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3251:1: ( ( ( rule__ASN1_SUBTYPE__Group_4__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3252:1: ( ( rule__ASN1_SUBTYPE__Group_4__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3252:1: ( ( rule__ASN1_SUBTYPE__Group_4__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3253:1: ( rule__ASN1_SUBTYPE__Group_4__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getGroup_4()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3254:1: ( rule__ASN1_SUBTYPE__Group_4__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==30) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3254:2: rule__ASN1_SUBTYPE__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__0_in_rule__ASN1_SUBTYPE__Group__4__Impl6586);
            	    rule__ASN1_SUBTYPE__Group_4__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getGroup_4()); 
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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__4__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3264:1: rule__ASN1_SUBTYPE__Group__5 : rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6 ;
    public final void rule__ASN1_SUBTYPE__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3268:1: ( rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3269:2: rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__5__Impl_in_rule__ASN1_SUBTYPE__Group__56617);
            rule__ASN1_SUBTYPE__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__6_in_rule__ASN1_SUBTYPE__Group__56620);
            rule__ASN1_SUBTYPE__Group__6();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__5"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__5__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3276:1: rule__ASN1_SUBTYPE__Group__5__Impl : ( ')' ) ;
    public final void rule__ASN1_SUBTYPE__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3280:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3281:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3281:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3282:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,33,FOLLOW_33_in_rule__ASN1_SUBTYPE__Group__5__Impl6648); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_5()); 
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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__5__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__6"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3295:1: rule__ASN1_SUBTYPE__Group__6 : rule__ASN1_SUBTYPE__Group__6__Impl ;
    public final void rule__ASN1_SUBTYPE__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3299:1: ( rule__ASN1_SUBTYPE__Group__6__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3300:2: rule__ASN1_SUBTYPE__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__6__Impl_in_rule__ASN1_SUBTYPE__Group__66679);
            rule__ASN1_SUBTYPE__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__6"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__6__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3306:1: rule__ASN1_SUBTYPE__Group__6__Impl : ( ')' ) ;
    public final void rule__ASN1_SUBTYPE__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3310:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3311:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3311:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3312:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,33,FOLLOW_33_in_rule__ASN1_SUBTYPE__Group__6__Impl6707); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_6()); 
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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group__6__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group_4__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3339:1: rule__ASN1_SUBTYPE__Group_4__0 : rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1 ;
    public final void rule__ASN1_SUBTYPE__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3343:1: ( rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3344:2: rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__0__Impl_in_rule__ASN1_SUBTYPE__Group_4__06752);
            rule__ASN1_SUBTYPE__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__1_in_rule__ASN1_SUBTYPE__Group_4__06755);
            rule__ASN1_SUBTYPE__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group_4__0"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group_4__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3351:1: rule__ASN1_SUBTYPE__Group_4__0__Impl : ( '|' ) ;
    public final void rule__ASN1_SUBTYPE__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3355:1: ( ( '|' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3356:1: ( '|' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3356:1: ( '|' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3357:1: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getVerticalLineKeyword_4_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__ASN1_SUBTYPE__Group_4__0__Impl6783); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getVerticalLineKeyword_4_0()); 
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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group_4__0__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group_4__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3370:1: rule__ASN1_SUBTYPE__Group_4__1 : rule__ASN1_SUBTYPE__Group_4__1__Impl ;
    public final void rule__ASN1_SUBTYPE__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3374:1: ( rule__ASN1_SUBTYPE__Group_4__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3375:2: rule__ASN1_SUBTYPE__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__1__Impl_in_rule__ASN1_SUBTYPE__Group_4__16814);
            rule__ASN1_SUBTYPE__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group_4__1"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group_4__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3381:1: rule__ASN1_SUBTYPE__Group_4__1__Impl : ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) ) ;
    public final void rule__ASN1_SUBTYPE__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3385:1: ( ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3386:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3386:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3387:1: ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_4_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3388:1: ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3388:2: rule__ASN1_SUBTYPE__RangesAssignment_4_1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_4_1_in_rule__ASN1_SUBTYPE__Group_4__1__Impl6841);
            rule__ASN1_SUBTYPE__RangesAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_4_1()); 
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
    // $ANTLR end "rule__ASN1_SUBTYPE__Group_4__1__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group_0__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3402:1: rule__ASN1_RANGE__Group_0__0 : rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1 ;
    public final void rule__ASN1_RANGE__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3406:1: ( rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3407:2: rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__0__Impl_in_rule__ASN1_RANGE__Group_0__06875);
            rule__ASN1_RANGE__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__1_in_rule__ASN1_RANGE__Group_0__06878);
            rule__ASN1_RANGE__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_RANGE__Group_0__0"


    // $ANTLR start "rule__ASN1_RANGE__Group_0__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3414:1: rule__ASN1_RANGE__Group_0__0__Impl : ( () ) ;
    public final void rule__ASN1_RANGE__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3418:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3419:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3419:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3420:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3421:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3423:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ASN1_RANGE__Group_0__0__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group_0__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3433:1: rule__ASN1_RANGE__Group_0__1 : rule__ASN1_RANGE__Group_0__1__Impl ;
    public final void rule__ASN1_RANGE__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3437:1: ( rule__ASN1_RANGE__Group_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3438:2: rule__ASN1_RANGE__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__1__Impl_in_rule__ASN1_RANGE__Group_0__16936);
            rule__ASN1_RANGE__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_RANGE__Group_0__1"


    // $ANTLR start "rule__ASN1_RANGE__Group_0__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3444:1: rule__ASN1_RANGE__Group_0__1__Impl : ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) ) ;
    public final void rule__ASN1_RANGE__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3448:1: ( ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3449:1: ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3449:1: ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3450:1: ( rule__ASN1_RANGE__ValueAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getValueAssignment_0_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3451:1: ( rule__ASN1_RANGE__ValueAssignment_0_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3451:2: rule__ASN1_RANGE__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__ValueAssignment_0_1_in_rule__ASN1_RANGE__Group_0__1__Impl6963);
            rule__ASN1_RANGE__ValueAssignment_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getValueAssignment_0_1()); 
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
    // $ANTLR end "rule__ASN1_RANGE__Group_0__1__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group_1__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3465:1: rule__ASN1_RANGE__Group_1__0 : rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1 ;
    public final void rule__ASN1_RANGE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3469:1: ( rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3470:2: rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__0__Impl_in_rule__ASN1_RANGE__Group_1__06997);
            rule__ASN1_RANGE__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__1_in_rule__ASN1_RANGE__Group_1__07000);
            rule__ASN1_RANGE__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_RANGE__Group_1__0"


    // $ANTLR start "rule__ASN1_RANGE__Group_1__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3477:1: rule__ASN1_RANGE__Group_1__0__Impl : ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) ) ;
    public final void rule__ASN1_RANGE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3481:1: ( ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3482:1: ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3482:1: ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3483:1: ( rule__ASN1_RANGE__StartAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getStartAssignment_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3484:1: ( rule__ASN1_RANGE__StartAssignment_1_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3484:2: rule__ASN1_RANGE__StartAssignment_1_0
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__StartAssignment_1_0_in_rule__ASN1_RANGE__Group_1__0__Impl7027);
            rule__ASN1_RANGE__StartAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getStartAssignment_1_0()); 
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
    // $ANTLR end "rule__ASN1_RANGE__Group_1__0__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group_1__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3494:1: rule__ASN1_RANGE__Group_1__1 : rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2 ;
    public final void rule__ASN1_RANGE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3498:1: ( rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3499:2: rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__1__Impl_in_rule__ASN1_RANGE__Group_1__17057);
            rule__ASN1_RANGE__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__2_in_rule__ASN1_RANGE__Group_1__17060);
            rule__ASN1_RANGE__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_RANGE__Group_1__1"


    // $ANTLR start "rule__ASN1_RANGE__Group_1__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3506:1: rule__ASN1_RANGE__Group_1__1__Impl : ( '..' ) ;
    public final void rule__ASN1_RANGE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3510:1: ( ( '..' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3511:1: ( '..' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3511:1: ( '..' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3512:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_1_1()); 
            }
            match(input,39,FOLLOW_39_in_rule__ASN1_RANGE__Group_1__1__Impl7088); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_1_1()); 
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
    // $ANTLR end "rule__ASN1_RANGE__Group_1__1__Impl"


    // $ANTLR start "rule__ASN1_RANGE__Group_1__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3525:1: rule__ASN1_RANGE__Group_1__2 : rule__ASN1_RANGE__Group_1__2__Impl ;
    public final void rule__ASN1_RANGE__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3529:1: ( rule__ASN1_RANGE__Group_1__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3530:2: rule__ASN1_RANGE__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__2__Impl_in_rule__ASN1_RANGE__Group_1__27119);
            rule__ASN1_RANGE__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // $ANTLR end "rule__ASN1_RANGE__Group_1__2"


    // $ANTLR start "rule__ASN1_RANGE__Group_1__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3536:1: rule__ASN1_RANGE__Group_1__2__Impl : ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) ) ;
    public final void rule__ASN1_RANGE__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3540:1: ( ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3541:1: ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3541:1: ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3542:1: ( rule__ASN1_RANGE__EndAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getEndAssignment_1_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3543:1: ( rule__ASN1_RANGE__EndAssignment_1_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3543:2: rule__ASN1_RANGE__EndAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__EndAssignment_1_2_in_rule__ASN1_RANGE__Group_1__2__Impl7146);
            rule__ASN1_RANGE__EndAssignment_1_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getEndAssignment_1_2()); 
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
    // $ANTLR end "rule__ASN1_RANGE__Group_1__2__Impl"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3559:1: rule__ASN1_VALUEPAIR__Group__0 : rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1 ;
    public final void rule__ASN1_VALUEPAIR__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3563:1: ( rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3564:2: rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__0__Impl_in_rule__ASN1_VALUEPAIR__Group__07182);
            rule__ASN1_VALUEPAIR__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__1_in_rule__ASN1_VALUEPAIR__Group__07185);
            rule__ASN1_VALUEPAIR__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3571:1: rule__ASN1_VALUEPAIR__Group__0__Impl : ( ( RULE_ID )? ) ;
    public final void rule__ASN1_VALUEPAIR__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3575:1: ( ( ( RULE_ID )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3576:1: ( ( RULE_ID )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3576:1: ( ( RULE_ID )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3577:1: ( RULE_ID )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getIDTerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3578:1: ( RULE_ID )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3578:3: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ASN1_VALUEPAIR__Group__0__Impl7213); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_VALUEPAIRAccess().getIDTerminalRuleCall_0()); 
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
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__0__Impl"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3588:1: rule__ASN1_VALUEPAIR__Group__1 : rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2 ;
    public final void rule__ASN1_VALUEPAIR__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3592:1: ( rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3593:2: rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__1__Impl_in_rule__ASN1_VALUEPAIR__Group__17244);
            rule__ASN1_VALUEPAIR__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__2_in_rule__ASN1_VALUEPAIR__Group__17247);
            rule__ASN1_VALUEPAIR__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3600:1: rule__ASN1_VALUEPAIR__Group__1__Impl : ( '(' ) ;
    public final void rule__ASN1_VALUEPAIR__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3604:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3605:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3605:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3606:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,32,FOLLOW_32_in_rule__ASN1_VALUEPAIR__Group__1__Impl7275); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_VALUEPAIRAccess().getLeftParenthesisKeyword_1()); 
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
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__1__Impl"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3619:1: rule__ASN1_VALUEPAIR__Group__2 : rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3 ;
    public final void rule__ASN1_VALUEPAIR__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3623:1: ( rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3624:2: rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__2__Impl_in_rule__ASN1_VALUEPAIR__Group__27306);
            rule__ASN1_VALUEPAIR__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__3_in_rule__ASN1_VALUEPAIR__Group__27309);
            rule__ASN1_VALUEPAIR__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3631:1: rule__ASN1_VALUEPAIR__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__ASN1_VALUEPAIR__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3635:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3636:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3636:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3637:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getINTTerminalRuleCall_2()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_VALUEPAIR__Group__2__Impl7336); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_VALUEPAIRAccess().getINTTerminalRuleCall_2()); 
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
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__2__Impl"


    // $ANTLR start "rule__ASN1_VALUEPAIR__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3648:1: rule__ASN1_VALUEPAIR__Group__3 : rule__ASN1_VALUEPAIR__Group__3__Impl ;
    public final void rule__ASN1_VALUEPAIR__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3652:1: ( rule__ASN1_VALUEPAIR__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3653:2: rule__ASN1_VALUEPAIR__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__3__Impl_in_rule__ASN1_VALUEPAIR__Group__37365);
            rule__ASN1_VALUEPAIR__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3659:1: rule__ASN1_VALUEPAIR__Group__3__Impl : ( ')' ) ;
    public final void rule__ASN1_VALUEPAIR__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3663:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3664:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3664:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3665:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,33,FOLLOW_33_in_rule__ASN1_VALUEPAIR__Group__3__Impl7393); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_VALUEPAIRAccess().getRightParenthesisKeyword_3()); 
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
    // $ANTLR end "rule__ASN1_VALUEPAIR__Group__3__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3686:1: rule__ASN1_CHOICE__Group__0 : rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1 ;
    public final void rule__ASN1_CHOICE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3690:1: ( rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3691:2: rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__0__Impl_in_rule__ASN1_CHOICE__Group__07432);
            rule__ASN1_CHOICE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__1_in_rule__ASN1_CHOICE__Group__07435);
            rule__ASN1_CHOICE__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3698:1: rule__ASN1_CHOICE__Group__0__Impl : ( 'CHOICE' ) ;
    public final void rule__ASN1_CHOICE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3702:1: ( ( 'CHOICE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3703:1: ( 'CHOICE' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3703:1: ( 'CHOICE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3704:1: 'CHOICE'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0()); 
            }
            match(input,40,FOLLOW_40_in_rule__ASN1_CHOICE__Group__0__Impl7463); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group__0__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3717:1: rule__ASN1_CHOICE__Group__1 : rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2 ;
    public final void rule__ASN1_CHOICE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3721:1: ( rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3722:2: rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__1__Impl_in_rule__ASN1_CHOICE__Group__17494);
            rule__ASN1_CHOICE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__2_in_rule__ASN1_CHOICE__Group__17497);
            rule__ASN1_CHOICE__Group__2();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3729:1: rule__ASN1_CHOICE__Group__1__Impl : ( '{' ) ;
    public final void rule__ASN1_CHOICE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3733:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3734:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3734:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3735:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,25,FOLLOW_25_in_rule__ASN1_CHOICE__Group__1__Impl7525); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group__1__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3748:1: rule__ASN1_CHOICE__Group__2 : rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3 ;
    public final void rule__ASN1_CHOICE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3752:1: ( rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3753:2: rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__2__Impl_in_rule__ASN1_CHOICE__Group__27556);
            rule__ASN1_CHOICE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__3_in_rule__ASN1_CHOICE__Group__27559);
            rule__ASN1_CHOICE__Group__3();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3760:1: rule__ASN1_CHOICE__Group__2__Impl : ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) ) ;
    public final void rule__ASN1_CHOICE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3764:1: ( ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3765:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3765:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3766:1: ( rule__ASN1_CHOICE__ChoicesAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3767:1: ( rule__ASN1_CHOICE__ChoicesAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3767:2: rule__ASN1_CHOICE__ChoicesAssignment_2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_2_in_rule__ASN1_CHOICE__Group__2__Impl7586);
            rule__ASN1_CHOICE__ChoicesAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_2()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group__2__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3777:1: rule__ASN1_CHOICE__Group__3 : rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4 ;
    public final void rule__ASN1_CHOICE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3781:1: ( rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3782:2: rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__3__Impl_in_rule__ASN1_CHOICE__Group__37616);
            rule__ASN1_CHOICE__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__4_in_rule__ASN1_CHOICE__Group__37619);
            rule__ASN1_CHOICE__Group__4();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3789:1: rule__ASN1_CHOICE__Group__3__Impl : ( ( rule__ASN1_CHOICE__Group_3__0 )* ) ;
    public final void rule__ASN1_CHOICE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3793:1: ( ( ( rule__ASN1_CHOICE__Group_3__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3794:1: ( ( rule__ASN1_CHOICE__Group_3__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3794:1: ( ( rule__ASN1_CHOICE__Group_3__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3795:1: ( rule__ASN1_CHOICE__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getGroup_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3796:1: ( rule__ASN1_CHOICE__Group_3__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==41) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3796:2: rule__ASN1_CHOICE__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__0_in_rule__ASN1_CHOICE__Group__3__Impl7646);
            	    rule__ASN1_CHOICE__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getGroup_3()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group__3__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3806:1: rule__ASN1_CHOICE__Group__4 : rule__ASN1_CHOICE__Group__4__Impl ;
    public final void rule__ASN1_CHOICE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3810:1: ( rule__ASN1_CHOICE__Group__4__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3811:2: rule__ASN1_CHOICE__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__4__Impl_in_rule__ASN1_CHOICE__Group__47677);
            rule__ASN1_CHOICE__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3817:1: rule__ASN1_CHOICE__Group__4__Impl : ( '}' ) ;
    public final void rule__ASN1_CHOICE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3821:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3822:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3822:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3823:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,26,FOLLOW_26_in_rule__ASN1_CHOICE__Group__4__Impl7705); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getRightCurlyBracketKeyword_4()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group__4__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group_3__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3846:1: rule__ASN1_CHOICE__Group_3__0 : rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1 ;
    public final void rule__ASN1_CHOICE__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3850:1: ( rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3851:2: rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__0__Impl_in_rule__ASN1_CHOICE__Group_3__07746);
            rule__ASN1_CHOICE__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__1_in_rule__ASN1_CHOICE__Group_3__07749);
            rule__ASN1_CHOICE__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3858:1: rule__ASN1_CHOICE__Group_3__0__Impl : ( ',' ) ;
    public final void rule__ASN1_CHOICE__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3862:1: ( ( ',' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3863:1: ( ',' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3863:1: ( ',' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3864:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_3_0()); 
            }
            match(input,41,FOLLOW_41_in_rule__ASN1_CHOICE__Group_3__0__Impl7777); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_3_0()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group_3__0__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group_3__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3877:1: rule__ASN1_CHOICE__Group_3__1 : rule__ASN1_CHOICE__Group_3__1__Impl ;
    public final void rule__ASN1_CHOICE__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3881:1: ( rule__ASN1_CHOICE__Group_3__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3882:2: rule__ASN1_CHOICE__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__1__Impl_in_rule__ASN1_CHOICE__Group_3__17808);
            rule__ASN1_CHOICE__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3888:1: rule__ASN1_CHOICE__Group_3__1__Impl : ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) ) ;
    public final void rule__ASN1_CHOICE__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3892:1: ( ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3893:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3893:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3894:1: ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_3_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3895:1: ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3895:2: rule__ASN1_CHOICE__ChoicesAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_3_1_in_rule__ASN1_CHOICE__Group_3__1__Impl7835);
            rule__ASN1_CHOICE__ChoicesAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_3_1()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group_3__1__Impl"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3909:1: rule__ASN1_CHOICE_ENTRY__Group__0 : rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1 ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3913:1: ( rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3914:2: rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__07869);
            rule__ASN1_CHOICE_ENTRY__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1_in_rule__ASN1_CHOICE_ENTRY__Group__07872);
            rule__ASN1_CHOICE_ENTRY__Group__1();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3921:1: rule__ASN1_CHOICE_ENTRY__Group__0__Impl : ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3925:1: ( ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3926:1: ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3926:1: ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3927:1: ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3928:1: ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3928:2: rule__ASN1_CHOICE_ENTRY__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__IdAssignment_0_in_rule__ASN1_CHOICE_ENTRY__Group__0__Impl7899);
            rule__ASN1_CHOICE_ENTRY__IdAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdAssignment_0()); 
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
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__Group__0__Impl"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3938:1: rule__ASN1_CHOICE_ENTRY__Group__1 : rule__ASN1_CHOICE_ENTRY__Group__1__Impl ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3942:1: ( rule__ASN1_CHOICE_ENTRY__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3943:2: rule__ASN1_CHOICE_ENTRY__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__17929);
            rule__ASN1_CHOICE_ENTRY__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3949:1: rule__ASN1_CHOICE_ENTRY__Group__1__Impl : ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3953:1: ( ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3954:1: ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3954:1: ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3955:1: ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3956:1: ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3956:2: rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1_in_rule__ASN1_CHOICE_ENTRY__Group__1__Impl7956);
            rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeAssignment_1()); 
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
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__Group__1__Impl"


    // $ANTLR start "rule__Module__IdAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3971:1: rule__Module__IdAssignment_0 : ( RULE_MODULE_ID ) ;
    public final void rule__Module__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3975:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3976:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3976:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3977:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getIdMODULE_IDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__Module__IdAssignment_07995); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getIdMODULE_IDTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__Module__IdAssignment_0"


    // $ANTLR start "rule__Module__AssignmentsAssignment_4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3986:1: rule__Module__AssignmentsAssignment_4 : ( ruleAssignment ) ;
    public final void rule__Module__AssignmentsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3990:1: ( ( ruleAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3991:1: ( ruleAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3991:1: ( ruleAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3992:1: ruleAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getAssignmentsAssignmentParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_ruleAssignment_in_rule__Module__AssignmentsAssignment_48026);
            ruleAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getAssignmentsAssignmentParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__Module__AssignmentsAssignment_4"


    // $ANTLR start "rule__Assignment__IdentifierAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4001:1: rule__Assignment__IdentifierAssignment_0 : ( ruleObjectIdentifier ) ;
    public final void rule__Assignment__IdentifierAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4005:1: ( ( ruleObjectIdentifier ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4006:1: ( ruleObjectIdentifier )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4006:1: ( ruleObjectIdentifier )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4007:1: ruleObjectIdentifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getIdentifierObjectIdentifierParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifier_in_rule__Assignment__IdentifierAssignment_08057);
            ruleObjectIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getIdentifierObjectIdentifierParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Assignment__IdentifierAssignment_0"


    // $ANTLR start "rule__Assignment__TypeAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4016:1: rule__Assignment__TypeAssignment_1 : ( ruleTypeDefinition ) ;
    public final void rule__Assignment__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4020:1: ( ( ruleTypeDefinition ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4021:1: ( ruleTypeDefinition )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4021:1: ( ruleTypeDefinition )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4022:1: ruleTypeDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getTypeTypeDefinitionParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_rule__Assignment__TypeAssignment_18088);
            ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getTypeTypeDefinitionParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__Assignment__TypeAssignment_1"


    // $ANTLR start "rule__Assignment__MacroAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4031:1: rule__Assignment__MacroAssignment_2 : ( ruleMacro ) ;
    public final void rule__Assignment__MacroAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4035:1: ( ( ruleMacro ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4036:1: ( ruleMacro )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4036:1: ( ruleMacro )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4037:1: ruleMacro
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAssignmentAccess().getMacroMacroParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_rule__Assignment__MacroAssignment_28119);
            ruleMacro();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAssignmentAccess().getMacroMacroParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__Assignment__MacroAssignment_2"


    // $ANTLR start "rule__ObjectIdentifier__NameAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4046:1: rule__ObjectIdentifier__NameAssignment_0 : ( RULE_ASN1_ID ) ;
    public final void rule__ObjectIdentifier__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4050:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4051:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4051:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4052:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNameASN1_IDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifier__NameAssignment_08150); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getNameASN1_IDTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__ObjectIdentifier__NameAssignment_0"


    // $ANTLR start "rule__ObjectIdentifier__OidValueAssignment_4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4061:1: rule__ObjectIdentifier__OidValueAssignment_4 : ( ruleObjectIdentifierValue ) ;
    public final void rule__ObjectIdentifier__OidValueAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4065:1: ( ( ruleObjectIdentifierValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4066:1: ( ruleObjectIdentifierValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4066:1: ( ruleObjectIdentifierValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4067:1: ruleObjectIdentifierValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_rule__ObjectIdentifier__OidValueAssignment_48181);
            ruleObjectIdentifierValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__ObjectIdentifier__OidValueAssignment_4"


    // $ANTLR start "rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4076:1: rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4080:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4081:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4081:1: ( ( RULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4082:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4083:1: ( RULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4084:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierIDTerminalRuleCall_0_0_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_08216); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierIDTerminalRuleCall_0_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_0_0()); 
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
    // $ANTLR end "rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0"


    // $ANTLR start "rule__ObjectIdentifierValue__SubIdsAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4095:1: rule__ObjectIdentifierValue__SubIdsAssignment_1 : ( RULE_INT ) ;
    public final void rule__ObjectIdentifierValue__SubIdsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4099:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4100:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4100:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4101:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_18251); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__ObjectIdentifierValue__SubIdsAssignment_1"


    // $ANTLR start "rule__ObjectIdentifierValue__SubIdsAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4110:1: rule__ObjectIdentifierValue__SubIdsAssignment_2 : ( RULE_INT ) ;
    public final void rule__ObjectIdentifierValue__SubIdsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4114:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4115:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4115:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4116:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_28282); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__ObjectIdentifierValue__SubIdsAssignment_2"


    // $ANTLR start "rule__TypeDefinition__NameAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4125:1: rule__TypeDefinition__NameAssignment_0 : ( RULE_MODULE_ID ) ;
    public final void rule__TypeDefinition__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4129:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4130:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4130:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4131:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNameMODULE_IDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__TypeDefinition__NameAssignment_08313); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getNameMODULE_IDTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__TypeDefinition__NameAssignment_0"


    // $ANTLR start "rule__TypeDefinition__ScopeAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4140:1: rule__TypeDefinition__ScopeAssignment_2 : ( ruleScope ) ;
    public final void rule__TypeDefinition__ScopeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4144:1: ( ( ruleScope ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4145:1: ( ruleScope )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4145:1: ( ruleScope )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4146:1: ruleScope
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getScopeScopeParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleScope_in_rule__TypeDefinition__ScopeAssignment_28344);
            ruleScope();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getScopeScopeParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__TypeDefinition__ScopeAssignment_2"


    // $ANTLR start "rule__Macro__NameAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4155:1: rule__Macro__NameAssignment_0 : ( RULE_MODULE_ID ) ;
    public final void rule__Macro__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4159:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4160:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4160:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4161:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNameMODULE_IDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__Macro__NameAssignment_08375); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNameMODULE_IDTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__Macro__NameAssignment_0"


    // $ANTLR start "rule__Macro__TypeNotationsAssignment_6"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4170:1: rule__Macro__TypeNotationsAssignment_6 : ( ruleTypeAssignment ) ;
    public final void rule__Macro__TypeNotationsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4174:1: ( ( ruleTypeAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4175:1: ( ruleTypeAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4175:1: ( ruleTypeAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4176:1: ruleTypeAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTypeNotationsTypeAssignmentParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_rule__Macro__TypeNotationsAssignment_68406);
            ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getTypeNotationsTypeAssignmentParserRuleCall_6_0()); 
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
    // $ANTLR end "rule__Macro__TypeNotationsAssignment_6"


    // $ANTLR start "rule__Macro__ValueNotationAssignment_9"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4185:1: rule__Macro__ValueNotationAssignment_9 : ( ruleMacroValue ) ;
    public final void rule__Macro__ValueNotationAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4189:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4190:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4190:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4191:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_9_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__Macro__ValueNotationAssignment_98437);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_9_0()); 
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
    // $ANTLR end "rule__Macro__ValueNotationAssignment_9"


    // $ANTLR start "rule__Macro__InnerTypesAssignment_10"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4200:1: rule__Macro__InnerTypesAssignment_10 : ( ruleTypeDefinition ) ;
    public final void rule__Macro__InnerTypesAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4204:1: ( ( ruleTypeDefinition ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4205:1: ( ruleTypeDefinition )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4205:1: ( ruleTypeDefinition )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4206:1: ruleTypeDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_10_0()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_rule__Macro__InnerTypesAssignment_108468);
            ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_10_0()); 
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
    // $ANTLR end "rule__Macro__InnerTypesAssignment_10"


    // $ANTLR start "rule__ParamAssignment__ParamAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4215:1: rule__ParamAssignment__ParamAssignment_0 : ( RULE_PARAMETER ) ;
    public final void rule__ParamAssignment__ParamAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4219:1: ( ( RULE_PARAMETER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4220:1: ( RULE_PARAMETER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4220:1: ( RULE_PARAMETER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4221:1: RULE_PARAMETER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getParamPARAMETERTerminalRuleCall_0_0()); 
            }
            match(input,RULE_PARAMETER,FOLLOW_RULE_PARAMETER_in_rule__ParamAssignment__ParamAssignment_08499); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAssignmentAccess().getParamPARAMETERTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__ParamAssignment__ParamAssignment_0"


    // $ANTLR start "rule__ParamAssignment__RightAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4230:1: rule__ParamAssignment__RightAssignment_1 : ( ruleTypeNotation ) ;
    public final void rule__ParamAssignment__RightAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4234:1: ( ( ruleTypeNotation ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4235:1: ( ruleTypeNotation )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4235:1: ( ruleTypeNotation )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4236:1: ruleTypeNotation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getRightTypeNotationParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_rule__ParamAssignment__RightAssignment_18530);
            ruleTypeNotation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAssignmentAccess().getRightTypeNotationParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__ParamAssignment__RightAssignment_1"


    // $ANTLR start "rule__TypeNotation__ValueAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4245:1: rule__TypeNotation__ValueAssignment_1 : ( ruleMacroValue ) ;
    public final void rule__TypeNotation__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4249:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4250:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4250:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4251:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getValueMacroValueParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__TypeNotation__ValueAssignment_18561);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getValueMacroValueParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__TypeNotation__ValueAssignment_1"


    // $ANTLR start "rule__TypeReferenceExt__RightAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4260:1: rule__TypeReferenceExt__RightAssignment_1 : ( ruleTypeReference ) ;
    public final void rule__TypeReferenceExt__RightAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4264:1: ( ( ruleTypeReference ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4265:1: ( ruleTypeReference )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4265:1: ( ruleTypeReference )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4266:1: ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getRightTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__RightAssignment_18592);
            ruleTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceExtAccess().getRightTypeReferenceParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__TypeReferenceExt__RightAssignment_1"


    // $ANTLR start "rule__TypeReference__TypeAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4275:1: rule__TypeReference__TypeAssignment : ( ( RULE_MODULE_ID ) ) ;
    public final void rule__TypeReference__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4279:1: ( ( ( RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4280:1: ( ( RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4280:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4281:1: ( RULE_MODULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceAccess().getTypeTypeDefinitionCrossReference_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4282:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4283:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceAccess().getTypeTypeDefinitionMODULE_IDTerminalRuleCall_0_1()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__TypeReference__TypeAssignment8627); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceAccess().getTypeTypeDefinitionMODULE_IDTerminalRuleCall_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceAccess().getTypeTypeDefinitionCrossReference_0()); 
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
    // $ANTLR end "rule__TypeReference__TypeAssignment"


    // $ANTLR start "rule__Scope__ScopeAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4294:1: rule__Scope__ScopeAssignment : ( ruleValue ) ;
    public final void rule__Scope__ScopeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4298:1: ( ( ruleValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4299:1: ( ruleValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4299:1: ( ruleValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4300:1: ruleValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScopeAccess().getScopeValueParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleValue_in_rule__Scope__ScopeAssignment8662);
            ruleValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScopeAccess().getScopeValueParserRuleCall_0()); 
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
    // $ANTLR end "rule__Scope__ScopeAssignment"


    // $ANTLR start "rule__Value__ValueTypesAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4309:1: rule__Value__ValueTypesAssignment_0 : ( ruleValueType ) ;
    public final void rule__Value__ValueTypesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4313:1: ( ( ruleValueType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4314:1: ( ruleValueType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4314:1: ( ruleValueType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4315:1: ruleValueType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_08693);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Value__ValueTypesAssignment_0"


    // $ANTLR start "rule__Value__ValueTypesAssignment_1_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4324:1: rule__Value__ValueTypesAssignment_1_1 : ( ruleValueType ) ;
    public final void rule__Value__ValueTypesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4328:1: ( ( ruleValueType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4329:1: ( ruleValueType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4329:1: ( ruleValueType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4330:1: ruleValueType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_1_18724);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__Value__ValueTypesAssignment_1_1"


    // $ANTLR start "rule__ValueType__NameAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4339:1: rule__ValueType__NameAssignment_0 : ( RULE_IA5STRING ) ;
    public final void rule__ValueType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4343:1: ( ( RULE_IA5STRING ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4344:1: ( RULE_IA5STRING )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4344:1: ( RULE_IA5STRING )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4345:1: RULE_IA5STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getNameIA5STRINGTerminalRuleCall_0_0()); 
            }
            match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_rule__ValueType__NameAssignment_08755); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getNameIA5STRINGTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__ValueType__NameAssignment_0"


    // $ANTLR start "rule__ValueType__ParamAssignment_1_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4354:1: rule__ValueType__ParamAssignment_1_0 : ( ruleParamAssignment ) ;
    public final void rule__ValueType__ParamAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4358:1: ( ( ruleParamAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4359:1: ( ruleParamAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4359:1: ( ruleParamAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4360:1: ruleParamAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_rule__ValueType__ParamAssignment_1_08786);
            ruleParamAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_1_0_0()); 
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
    // $ANTLR end "rule__ValueType__ParamAssignment_1_0"


    // $ANTLR start "rule__ValueType__TypeAssignment_1_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4369:1: rule__ValueType__TypeAssignment_1_1 : ( ruleTypeReferenceExt ) ;
    public final void rule__ValueType__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4373:1: ( ( ruleTypeReferenceExt ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4374:1: ( ruleTypeReferenceExt )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4374:1: ( ruleTypeReferenceExt )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4375:1: ruleTypeReferenceExt
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeTypeReferenceExtParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_rule__ValueType__TypeAssignment_1_18817);
            ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getTypeTypeReferenceExtParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__ValueType__TypeAssignment_1_1"


    // $ANTLR start "rule__ValueType__SimpleTypeAssignment_1_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4384:1: rule__ValueType__SimpleTypeAssignment_1_2 : ( ruleASN1_TYPE ) ;
    public final void rule__ValueType__SimpleTypeAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4388:1: ( ( ruleASN1_TYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4389:1: ( ruleASN1_TYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4389:1: ( ruleASN1_TYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4390:1: ruleASN1_TYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_1_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_rule__ValueType__SimpleTypeAssignment_1_28848);
            ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_1_2_0()); 
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
    // $ANTLR end "rule__ValueType__SimpleTypeAssignment_1_2"


    // $ANTLR start "rule__ValueType__MacroValueAssignment_1_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4399:1: rule__ValueType__MacroValueAssignment_1_3 : ( ruleMacroValue ) ;
    public final void rule__ValueType__MacroValueAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4403:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4404:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4404:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4405:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_1_3_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__ValueType__MacroValueAssignment_1_38879);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_1_3_0()); 
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
    // $ANTLR end "rule__ValueType__MacroValueAssignment_1_3"


    // $ANTLR start "rule__ValueType__OiAssignment_1_4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4414:1: rule__ValueType__OiAssignment_1_4 : ( ( 'OBJECT IDENTIFIER' ) ) ;
    public final void rule__ValueType__OiAssignment_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4418:1: ( ( ( 'OBJECT IDENTIFIER' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4419:1: ( ( 'OBJECT IDENTIFIER' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4419:1: ( ( 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4420:1: ( 'OBJECT IDENTIFIER' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_1_4_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4421:1: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4422:1: 'OBJECT IDENTIFIER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_1_4_0()); 
            }
            match(input,19,FOLLOW_19_in_rule__ValueType__OiAssignment_1_48915); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_1_4_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_1_4_0()); 
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
    // $ANTLR end "rule__ValueType__OiAssignment_1_4"


    // $ANTLR start "rule__MacroValue__TypeAssignment_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4437:1: rule__MacroValue__TypeAssignment_3 : ( ruleMACRO_VALUE_TYPE ) ;
    public final void rule__MacroValue__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4441:1: ( ( ruleMACRO_VALUE_TYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4442:1: ( ruleMACRO_VALUE_TYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4442:1: ( ruleMACRO_VALUE_TYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4443:1: ruleMACRO_VALUE_TYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getTypeMACRO_VALUE_TYPEParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_rule__MacroValue__TypeAssignment_38954);
            ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueAccess().getTypeMACRO_VALUE_TYPEParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__MacroValue__TypeAssignment_3"


    // $ANTLR start "rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4452:1: rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0 : ( ruleMACRO_VALUE_CAP ) ;
    public final void rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4456:1: ( ( ruleMACRO_VALUE_CAP ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4457:1: ( ruleMACRO_VALUE_CAP )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4457:1: ( ruleMACRO_VALUE_CAP )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4458:1: ruleMACRO_VALUE_CAP
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getValLiteralMACRO_VALUE_CAPParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_rule__MACRO_VALUE_TYPE__ValLiteralAssignment_08985);
            ruleMACRO_VALUE_CAP();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPEAccess().getValLiteralMACRO_VALUE_CAPParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0"


    // $ANTLR start "rule__MACRO_VALUE_TYPE__UpdateAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4467:1: rule__MACRO_VALUE_TYPE__UpdateAssignment_1 : ( ruleUpdateType ) ;
    public final void rule__MACRO_VALUE_TYPE__UpdateAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4471:1: ( ( ruleUpdateType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4472:1: ( ruleUpdateType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4472:1: ( ruleUpdateType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4473:1: ruleUpdateType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateUpdateTypeParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_rule__MACRO_VALUE_TYPE__UpdateAssignment_19016);
            ruleUpdateType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateUpdateTypeParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__MACRO_VALUE_TYPE__UpdateAssignment_1"


    // $ANTLR start "rule__UpdateType__TypeAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4482:1: rule__UpdateType__TypeAssignment_1 : ( ( RULE_MODULE_ID ) ) ;
    public final void rule__UpdateType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4486:1: ( ( ( RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4487:1: ( ( RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4487:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4488:1: ( RULE_MODULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getTypeTypeDefinitionCrossReference_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4489:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4490:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getTypeTypeDefinitionMODULE_IDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__UpdateType__TypeAssignment_19051); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateTypeAccess().getTypeTypeDefinitionMODULE_IDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateTypeAccess().getTypeTypeDefinitionCrossReference_1_0()); 
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
    // $ANTLR end "rule__UpdateType__TypeAssignment_1"


    // $ANTLR start "rule__MACRO_VALUE_CAP__ValueAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4501:1: rule__MACRO_VALUE_CAP__ValueAssignment_0 : ( ( 'VALUE' ) ) ;
    public final void rule__MACRO_VALUE_CAP__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4505:1: ( ( ( 'VALUE' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4506:1: ( ( 'VALUE' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4506:1: ( ( 'VALUE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4507:1: ( 'VALUE' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getValueVALUEKeyword_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4508:1: ( 'VALUE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4509:1: 'VALUE'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getValueVALUEKeyword_0_0()); 
            }
            match(input,42,FOLLOW_42_in_rule__MACRO_VALUE_CAP__ValueAssignment_09091); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPAccess().getValueVALUEKeyword_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPAccess().getValueVALUEKeyword_0_0()); 
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
    // $ANTLR end "rule__MACRO_VALUE_CAP__ValueAssignment_0"


    // $ANTLR start "rule__MACRO_VALUE_CAP__LiteralAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4524:1: rule__MACRO_VALUE_CAP__LiteralAssignment_1 : ( ruleVALUE_CAP_LITERALS ) ;
    public final void rule__MACRO_VALUE_CAP__LiteralAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4528:1: ( ( ruleVALUE_CAP_LITERALS ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4529:1: ( ruleVALUE_CAP_LITERALS )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4529:1: ( ruleVALUE_CAP_LITERALS )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4530:1: ruleVALUE_CAP_LITERALS
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getLiteralVALUE_CAP_LITERALSEnumRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleVALUE_CAP_LITERALS_in_rule__MACRO_VALUE_CAP__LiteralAssignment_19130);
            ruleVALUE_CAP_LITERALS();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPAccess().getLiteralVALUE_CAP_LITERALSEnumRuleCall_1_0()); 
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
    // $ANTLR end "rule__MACRO_VALUE_CAP__LiteralAssignment_1"


    // $ANTLR start "rule__ASN1_SIMPLE__ConstraintAssignment_2_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4539:1: rule__ASN1_SIMPLE__ConstraintAssignment_2_1 : ( ruleASN1_SUBTYPE ) ;
    public final void rule__ASN1_SIMPLE__ConstraintAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4543:1: ( ( ruleASN1_SUBTYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4544:1: ( ruleASN1_SUBTYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4544:1: ( ruleASN1_SUBTYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4545:1: ruleASN1_SUBTYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_rule__ASN1_SIMPLE__ConstraintAssignment_2_19161);
            ruleASN1_SUBTYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_0()); 
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
    // $ANTLR end "rule__ASN1_SIMPLE__ConstraintAssignment_2_1"


    // $ANTLR start "rule__ASN1_SIMPLE__ConstraintAssignment_3_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4554:1: rule__ASN1_SIMPLE__ConstraintAssignment_3_1 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SIMPLE__ConstraintAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4558:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4559:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4559:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4560:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_RANGEParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SIMPLE__ConstraintAssignment_3_19192);
            ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_RANGEParserRuleCall_3_1_0()); 
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
    // $ANTLR end "rule__ASN1_SIMPLE__ConstraintAssignment_3_1"


    // $ANTLR start "rule__ASN1_INTEGER__ValuePairsAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4569:1: rule__ASN1_INTEGER__ValuePairsAssignment_2 : ( ruleASN1_VALUEPAIR ) ;
    public final void rule__ASN1_INTEGER__ValuePairsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4573:1: ( ( ruleASN1_VALUEPAIR ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4574:1: ( ruleASN1_VALUEPAIR )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4574:1: ( ruleASN1_VALUEPAIR )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4575:1: ruleASN1_VALUEPAIR
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getValuePairsASN1_VALUEPAIRParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_rule__ASN1_INTEGER__ValuePairsAssignment_29223);
            ruleASN1_VALUEPAIR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getValuePairsASN1_VALUEPAIRParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__ASN1_INTEGER__ValuePairsAssignment_2"


    // $ANTLR start "rule__ASN1_SUBTYPE__RangesAssignment_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4584:1: rule__ASN1_SUBTYPE__RangesAssignment_3 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SUBTYPE__RangesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4588:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4589:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4589:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4590:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_39254);
            ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__ASN1_SUBTYPE__RangesAssignment_3"


    // $ANTLR start "rule__ASN1_SUBTYPE__RangesAssignment_4_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4599:1: rule__ASN1_SUBTYPE__RangesAssignment_4_1 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SUBTYPE__RangesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4603:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4604:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4604:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4605:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_4_19285);
            ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_4_1_0()); 
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
    // $ANTLR end "rule__ASN1_SUBTYPE__RangesAssignment_4_1"


    // $ANTLR start "rule__ASN1_RANGE__ValueAssignment_0_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4614:1: rule__ASN1_RANGE__ValueAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__ASN1_RANGE__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4618:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4619:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4619:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4620:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getValueINTTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_RANGE__ValueAssignment_0_19316); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getValueINTTerminalRuleCall_0_1_0()); 
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
    // $ANTLR end "rule__ASN1_RANGE__ValueAssignment_0_1"


    // $ANTLR start "rule__ASN1_RANGE__StartAssignment_1_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4629:1: rule__ASN1_RANGE__StartAssignment_1_0 : ( RULE_INT ) ;
    public final void rule__ASN1_RANGE__StartAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4633:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4634:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4634:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4635:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getStartINTTerminalRuleCall_1_0_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_RANGE__StartAssignment_1_09347); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getStartINTTerminalRuleCall_1_0_0()); 
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
    // $ANTLR end "rule__ASN1_RANGE__StartAssignment_1_0"


    // $ANTLR start "rule__ASN1_RANGE__EndAssignment_1_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4644:1: rule__ASN1_RANGE__EndAssignment_1_2 : ( RULE_INT ) ;
    public final void rule__ASN1_RANGE__EndAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4648:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4649:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4649:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4650:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getEndINTTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_RANGE__EndAssignment_1_29378); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getEndINTTerminalRuleCall_1_2_0()); 
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
    // $ANTLR end "rule__ASN1_RANGE__EndAssignment_1_2"


    // $ANTLR start "rule__ASN1_CHOICE__ChoicesAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4659:1: rule__ASN1_CHOICE__ChoicesAssignment_2 : ( ruleASN1_CHOICE_ENTRY ) ;
    public final void rule__ASN1_CHOICE__ChoicesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4663:1: ( ( ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4664:1: ( ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4664:1: ( ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4665:1: ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_29409);
            ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__ChoicesAssignment_2"


    // $ANTLR start "rule__ASN1_CHOICE__ChoicesAssignment_3_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4674:1: rule__ASN1_CHOICE__ChoicesAssignment_3_1 : ( ruleASN1_CHOICE_ENTRY ) ;
    public final void rule__ASN1_CHOICE__ChoicesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4678:1: ( ( ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4679:1: ( ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4679:1: ( ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4680:1: ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_3_19440);
            ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_3_1_0()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__ChoicesAssignment_3_1"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__IdAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4689:1: rule__ASN1_CHOICE_ENTRY__IdAssignment_0 : ( RULE_ASN1_ID ) ;
    public final void rule__ASN1_CHOICE_ENTRY__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4693:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4694:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4694:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4695:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdASN1_IDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__IdAssignment_09471); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdASN1_IDTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__IdAssignment_0"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4704:1: rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4708:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4709:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4709:1: ( ( RULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4710:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueTypeCrossReference_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4711:1: ( RULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4712:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueTypeIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_19506); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueTypeIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueTypeCrossReference_1_0()); 
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
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0_in_ruleModule100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__Alternatives_in_ruleAssignment160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifier194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__0_in_ruleObjectIdentifier220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifierValue254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__0_in_ruleObjectIdentifierValue280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDefinition314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__0_in_ruleTypeDefinition340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_entryRuleMacro367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacro374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__0_in_ruleMacro400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAssignment434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Alternatives_in_ruleTypeAssignment460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamAssignment494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__0_in_ruleParamAssignment520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotation554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotation__Alternatives_in_ruleTypeNotation580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReferenceExt614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__0_in_ruleTypeReferenceExt640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_entryRuleTypeReference667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReference674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReference__TypeAssignment_in_ruleTypeReference700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScope_in_entryRuleScope727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScope734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scope__ScopeAssignment_in_ruleScope760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__0_in_ruleValue820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Group__0_in_ruleValueType880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__0_in_ruleMacroValue940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__Alternatives_in_ruleMACRO_VALUE_TYPE1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_entryRuleUpdateType1027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpdateType1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__0_in_ruleUpdateType1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP1087 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__Group__0_in_ruleMACRO_VALUE_CAP1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE1147 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_TYPE__Alternatives_in_ruleASN1_TYPE1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE1207 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Alternatives_in_ruleASN1_SIMPLE1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING1267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__0_in_ruleASN1_OCTET_STRING1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER1327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__0_in_ruleASN1_INTEGER1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE1387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__0_in_ruleASN1_SUBTYPE1420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE1447 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Alternatives_in_ruleASN1_RANGE1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR1507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__0_in_ruleASN1_VALUEPAIR1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE1567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__0_in_ruleASN1_CHOICE1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY1627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0_in_ruleASN1_CHOICE_ENTRY1660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VALUE_CAP_LITERALS__Alternatives_in_ruleVALUE_CAP_LITERALS1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__IdentifierAssignment_0_in_rule__Assignment__Alternatives1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__TypeAssignment_1_in_rule__Assignment__Alternatives1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Assignment__MacroAssignment_2_in_rule__Assignment__Alternatives1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_0_in_rule__ObjectIdentifierValue__Alternatives_01801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__Alternatives_01819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_rule__TypeAssignment__Alternatives1851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeAssignment__Alternatives1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeNotation__Alternatives1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotation__ValueAssignment_1_in_rule__TypeNotation__Alternatives1917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__ParamAssignment_1_0_in_rule__ValueType__Alternatives_11950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__TypeAssignment_1_1_in_rule__ValueType__Alternatives_11968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__SimpleTypeAssignment_1_2_in_rule__ValueType__Alternatives_11986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__MacroValueAssignment_1_3_in_rule__ValueType__Alternatives_12004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__OiAssignment_1_4_in_rule__ValueType__Alternatives_12022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__ValLiteralAssignment_0_in_rule__MACRO_VALUE_TYPE__Alternatives2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__UpdateAssignment_1_in_rule__MACRO_VALUE_TYPE__Alternatives2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_rule__ASN1_TYPE__Alternatives2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_rule__ASN1_TYPE__Alternatives2123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__0_in_rule__ASN1_SIMPLE__Alternatives2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__0_in_rule__ASN1_SIMPLE__Alternatives2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__0_in_rule__ASN1_SIMPLE__Alternatives2191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__0_in_rule__ASN1_SIMPLE__Alternatives2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__0_in_rule__ASN1_RANGE__Alternatives2242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__0_in_rule__ASN1_RANGE__Alternatives2260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__VALUE_CAP_LITERALS__Alternatives2294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__VALUE_CAP_LITERALS__Alternatives2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__02348 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Module__Group__1_in_rule__Module__Group__02351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__IdAssignment_0_in_rule__Module__Group__0__Impl2378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__12408 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Module__Group__2_in_rule__Module__Group__12411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Module__Group__1__Impl2439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__22470 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Module__Group__3_in_rule__Module__Group__22473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Module__Group__2__Impl2501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__3__Impl_in_rule__Module__Group__32532 = new BitSet(new long[]{0x0000000001000110L});
    public static final BitSet FOLLOW_rule__Module__Group__4_in_rule__Module__Group__32535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Module__Group__3__Impl2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__4__Impl_in_rule__Module__Group__42594 = new BitSet(new long[]{0x0000000001000110L});
    public static final BitSet FOLLOW_rule__Module__Group__5_in_rule__Module__Group__42597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__AssignmentsAssignment_4_in_rule__Module__Group__4__Impl2624 = new BitSet(new long[]{0x0000000000000112L});
    public static final BitSet FOLLOW_rule__Module__Group__5__Impl_in_rule__Module__Group__52655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Module__Group__5__Impl2683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__0__Impl_in_rule__ObjectIdentifier__Group__02726 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__1_in_rule__ObjectIdentifier__Group__02729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__NameAssignment_0_in_rule__ObjectIdentifier__Group__0__Impl2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__1__Impl_in_rule__ObjectIdentifier__Group__12786 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__2_in_rule__ObjectIdentifier__Group__12789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ObjectIdentifier__Group__1__Impl2817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__2__Impl_in_rule__ObjectIdentifier__Group__22848 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__3_in_rule__ObjectIdentifier__Group__22851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ObjectIdentifier__Group__2__Impl2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__3__Impl_in_rule__ObjectIdentifier__Group__32910 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__4_in_rule__ObjectIdentifier__Group__32913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ObjectIdentifier__Group__3__Impl2941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__4__Impl_in_rule__ObjectIdentifier__Group__42972 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__5_in_rule__ObjectIdentifier__Group__42975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__OidValueAssignment_4_in_rule__ObjectIdentifier__Group__4__Impl3002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__5__Impl_in_rule__ObjectIdentifier__Group__53032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ObjectIdentifier__Group__5__Impl3060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__0__Impl_in_rule__ObjectIdentifierValue__Group__03103 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__1_in_rule__ObjectIdentifierValue__Group__03106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Alternatives_0_in_rule__ObjectIdentifierValue__Group__0__Impl3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__1__Impl_in_rule__ObjectIdentifierValue__Group__13164 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__2_in_rule__ObjectIdentifierValue__Group__13167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_1_in_rule__ObjectIdentifierValue__Group__1__Impl3194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__2__Impl_in_rule__ObjectIdentifierValue__Group__23224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_2_in_rule__ObjectIdentifierValue__Group__2__Impl3251 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__0__Impl_in_rule__TypeDefinition__Group__03288 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__1_in_rule__TypeDefinition__Group__03291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__NameAssignment_0_in_rule__TypeDefinition__Group__0__Impl3318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__1__Impl_in_rule__TypeDefinition__Group__13348 = new BitSet(new long[]{0x0000013880080320L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__2_in_rule__TypeDefinition__Group__13351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__TypeDefinition__Group__1__Impl3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__2__Impl_in_rule__TypeDefinition__Group__23410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__ScopeAssignment_2_in_rule__TypeDefinition__Group__2__Impl3437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__0__Impl_in_rule__Macro__Group__03473 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__1_in_rule__Macro__Group__03476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__NameAssignment_0_in_rule__Macro__Group__0__Impl3503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__1__Impl_in_rule__Macro__Group__13533 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Macro__Group__2_in_rule__Macro__Group__13536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Macro__Group__1__Impl3564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__2__Impl_in_rule__Macro__Group__23595 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Macro__Group__3_in_rule__Macro__Group__23598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Macro__Group__2__Impl3626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__3__Impl_in_rule__Macro__Group__33657 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__4_in_rule__Macro__Group__33660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Macro__Group__3__Impl3688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__4__Impl_in_rule__Macro__Group__43719 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Macro__Group__5_in_rule__Macro__Group__43722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Macro__Group__4__Impl3750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__5__Impl_in_rule__Macro__Group__53781 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_rule__Macro__Group__6_in_rule__Macro__Group__53784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Macro__Group__5__Impl3812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__6__Impl_in_rule__Macro__Group__63843 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__7_in_rule__Macro__Group__63846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__TypeNotationsAssignment_6_in_rule__Macro__Group__6__Impl3875 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_rule__Macro__TypeNotationsAssignment_6_in_rule__Macro__Group__6__Impl3887 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_rule__Macro__Group__7__Impl_in_rule__Macro__Group__73920 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Macro__Group__8_in_rule__Macro__Group__73923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Macro__Group__7__Impl3951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__8__Impl_in_rule__Macro__Group__83982 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__9_in_rule__Macro__Group__83985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Macro__Group__8__Impl4013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__9__Impl_in_rule__Macro__Group__94044 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Macro__Group__10_in_rule__Macro__Group__94047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__ValueNotationAssignment_9_in_rule__Macro__Group__9__Impl4074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__10__Impl_in_rule__Macro__Group__104104 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__11_in_rule__Macro__Group__104107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__InnerTypesAssignment_10_in_rule__Macro__Group__10__Impl4136 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__Macro__InnerTypesAssignment_10_in_rule__Macro__Group__10__Impl4148 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__Macro__Group__11__Impl_in_rule__Macro__Group__114181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Macro__Group__11__Impl4209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__0__Impl_in_rule__ParamAssignment__Group__04264 = new BitSet(new long[]{0x0000000080000100L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__1_in_rule__ParamAssignment__Group__04267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__ParamAssignment_0_in_rule__ParamAssignment__Group__0__Impl4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__1__Impl_in_rule__ParamAssignment__Group__14324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__RightAssignment_1_in_rule__ParamAssignment__Group__1__Impl4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__0__Impl_in_rule__TypeReferenceExt__Group__04385 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__1_in_rule__TypeReferenceExt__Group__04388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__Group__0__Impl4415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__1__Impl_in_rule__TypeReferenceExt__Group__14444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__RightAssignment_1_in_rule__TypeReferenceExt__Group__1__Impl4471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__0__Impl_in_rule__Value__Group__04506 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Value__Group__1_in_rule__Value__Group__04509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ValueTypesAssignment_0_in_rule__Value__Group__0__Impl4536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__1__Impl_in_rule__Value__Group__14566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_1__0_in_rule__Value__Group__1__Impl4593 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__Value__Group_1__0__Impl_in_rule__Value__Group_1__04628 = new BitSet(new long[]{0x0000013880080320L});
    public static final BitSet FOLLOW_rule__Value__Group_1__1_in_rule__Value__Group_1__04631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Value__Group_1__0__Impl4659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_1__1__Impl_in_rule__Value__Group_1__14690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ValueTypesAssignment_1_1_in_rule__Value__Group_1__1__Impl4717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Group__0__Impl_in_rule__ValueType__Group__04751 = new BitSet(new long[]{0x0000013880080320L});
    public static final BitSet FOLLOW_rule__ValueType__Group__1_in_rule__ValueType__Group__04754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__NameAssignment_0_in_rule__ValueType__Group__0__Impl4781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Group__1__Impl_in_rule__ValueType__Group__14812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Alternatives_1_in_rule__ValueType__Group__1__Impl4839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__0__Impl_in_rule__MacroValue__Group__04873 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__1_in_rule__MacroValue__Group__04876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__1__Impl_in_rule__MacroValue__Group__14934 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__2_in_rule__MacroValue__Group__14937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__MacroValue__Group__1__Impl4965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__2__Impl_in_rule__MacroValue__Group__24996 = new BitSet(new long[]{0x0000040400000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__3_in_rule__MacroValue__Group__24999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__MacroValue__Group__2__Impl5027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__3__Impl_in_rule__MacroValue__Group__35058 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__4_in_rule__MacroValue__Group__35061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__TypeAssignment_3_in_rule__MacroValue__Group__3__Impl5088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__4__Impl_in_rule__MacroValue__Group__45118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__MacroValue__Group__4__Impl5146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__0__Impl_in_rule__UpdateType__Group__05187 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__1_in_rule__UpdateType__Group__05190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__UpdateType__Group__0__Impl5218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__1__Impl_in_rule__UpdateType__Group__15249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__TypeAssignment_1_in_rule__UpdateType__Group__1__Impl5276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__Group__0__Impl_in_rule__MACRO_VALUE_CAP__Group__05310 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__Group__1_in_rule__MACRO_VALUE_CAP__Group__05313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__ValueAssignment_0_in_rule__MACRO_VALUE_CAP__Group__0__Impl5340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__Group__1__Impl_in_rule__MACRO_VALUE_CAP__Group__15370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__LiteralAssignment_1_in_rule__MACRO_VALUE_CAP__Group__1__Impl5397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__0__Impl_in_rule__ASN1_SIMPLE__Group_0__05431 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__1_in_rule__ASN1_SIMPLE__Group_0__05434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__1__Impl_in_rule__ASN1_SIMPLE__Group_0__15492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ASN1_SIMPLE__Group_0__1__Impl5520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__0__Impl_in_rule__ASN1_SIMPLE__Group_1__05555 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__1_in_rule__ASN1_SIMPLE__Group_1__05558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__1__Impl_in_rule__ASN1_SIMPLE__Group_1__15616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_rule__ASN1_SIMPLE__Group_1__1__Impl5643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__0__Impl_in_rule__ASN1_SIMPLE__Group_2__05676 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__1_in_rule__ASN1_SIMPLE__Group_2__05679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_rule__ASN1_SIMPLE__Group_2__0__Impl5706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__1__Impl_in_rule__ASN1_SIMPLE__Group_2__15735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_in_rule__ASN1_SIMPLE__Group_2__1__Impl5762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__0__Impl_in_rule__ASN1_SIMPLE__Group_3__05797 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__1_in_rule__ASN1_SIMPLE__Group_3__05800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_rule__ASN1_SIMPLE__Group_3__0__Impl5827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__1__Impl_in_rule__ASN1_SIMPLE__Group_3__15856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_3_1_in_rule__ASN1_SIMPLE__Group_3__1__Impl5883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__0__Impl_in_rule__ASN1_OCTET_STRING__Group__05918 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__1_in_rule__ASN1_OCTET_STRING__Group__05921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__1__Impl_in_rule__ASN1_OCTET_STRING__Group__15979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ASN1_OCTET_STRING__Group__1__Impl6007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__0__Impl_in_rule__ASN1_INTEGER__Group__06042 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__1_in_rule__ASN1_INTEGER__Group__06045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ASN1_INTEGER__Group__0__Impl6073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__1__Impl_in_rule__ASN1_INTEGER__Group__16104 = new BitSet(new long[]{0x0000000100000040L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__2_in_rule__ASN1_INTEGER__Group__16107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ASN1_INTEGER__Group__1__Impl6135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__2__Impl_in_rule__ASN1_INTEGER__Group__26166 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__3_in_rule__ASN1_INTEGER__Group__26169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6198 = new BitSet(new long[]{0x0000000100000042L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6210 = new BitSet(new long[]{0x0000000100000042L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__3__Impl_in_rule__ASN1_INTEGER__Group__36243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ASN1_INTEGER__Group__3__Impl6271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__0__Impl_in_rule__ASN1_SUBTYPE__Group__06310 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__1_in_rule__ASN1_SUBTYPE__Group__06313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ASN1_SUBTYPE__Group__0__Impl6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__1__Impl_in_rule__ASN1_SUBTYPE__Group__16372 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__2_in_rule__ASN1_SUBTYPE__Group__16375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ASN1_SUBTYPE__Group__1__Impl6403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__2__Impl_in_rule__ASN1_SUBTYPE__Group__26434 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__3_in_rule__ASN1_SUBTYPE__Group__26437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ASN1_SUBTYPE__Group__2__Impl6465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__3__Impl_in_rule__ASN1_SUBTYPE__Group__36496 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__4_in_rule__ASN1_SUBTYPE__Group__36499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_3_in_rule__ASN1_SUBTYPE__Group__3__Impl6526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__4__Impl_in_rule__ASN1_SUBTYPE__Group__46556 = new BitSet(new long[]{0x0000000240000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__5_in_rule__ASN1_SUBTYPE__Group__46559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__0_in_rule__ASN1_SUBTYPE__Group__4__Impl6586 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__5__Impl_in_rule__ASN1_SUBTYPE__Group__56617 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__6_in_rule__ASN1_SUBTYPE__Group__56620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ASN1_SUBTYPE__Group__5__Impl6648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__6__Impl_in_rule__ASN1_SUBTYPE__Group__66679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ASN1_SUBTYPE__Group__6__Impl6707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__0__Impl_in_rule__ASN1_SUBTYPE__Group_4__06752 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__1_in_rule__ASN1_SUBTYPE__Group_4__06755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ASN1_SUBTYPE__Group_4__0__Impl6783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__1__Impl_in_rule__ASN1_SUBTYPE__Group_4__16814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_4_1_in_rule__ASN1_SUBTYPE__Group_4__1__Impl6841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__0__Impl_in_rule__ASN1_RANGE__Group_0__06875 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__1_in_rule__ASN1_RANGE__Group_0__06878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__1__Impl_in_rule__ASN1_RANGE__Group_0__16936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__ValueAssignment_0_1_in_rule__ASN1_RANGE__Group_0__1__Impl6963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__0__Impl_in_rule__ASN1_RANGE__Group_1__06997 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__1_in_rule__ASN1_RANGE__Group_1__07000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__StartAssignment_1_0_in_rule__ASN1_RANGE__Group_1__0__Impl7027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__1__Impl_in_rule__ASN1_RANGE__Group_1__17057 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__2_in_rule__ASN1_RANGE__Group_1__17060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ASN1_RANGE__Group_1__1__Impl7088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__2__Impl_in_rule__ASN1_RANGE__Group_1__27119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__EndAssignment_1_2_in_rule__ASN1_RANGE__Group_1__2__Impl7146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__0__Impl_in_rule__ASN1_VALUEPAIR__Group__07182 = new BitSet(new long[]{0x0000000100000040L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__1_in_rule__ASN1_VALUEPAIR__Group__07185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ASN1_VALUEPAIR__Group__0__Impl7213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__1__Impl_in_rule__ASN1_VALUEPAIR__Group__17244 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__2_in_rule__ASN1_VALUEPAIR__Group__17247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ASN1_VALUEPAIR__Group__1__Impl7275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__2__Impl_in_rule__ASN1_VALUEPAIR__Group__27306 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__3_in_rule__ASN1_VALUEPAIR__Group__27309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_VALUEPAIR__Group__2__Impl7336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__3__Impl_in_rule__ASN1_VALUEPAIR__Group__37365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ASN1_VALUEPAIR__Group__3__Impl7393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__0__Impl_in_rule__ASN1_CHOICE__Group__07432 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__1_in_rule__ASN1_CHOICE__Group__07435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ASN1_CHOICE__Group__0__Impl7463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__1__Impl_in_rule__ASN1_CHOICE__Group__17494 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__2_in_rule__ASN1_CHOICE__Group__17497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ASN1_CHOICE__Group__1__Impl7525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__2__Impl_in_rule__ASN1_CHOICE__Group__27556 = new BitSet(new long[]{0x0000020004000000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__3_in_rule__ASN1_CHOICE__Group__27559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_2_in_rule__ASN1_CHOICE__Group__2__Impl7586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__3__Impl_in_rule__ASN1_CHOICE__Group__37616 = new BitSet(new long[]{0x0000020004000000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__4_in_rule__ASN1_CHOICE__Group__37619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__0_in_rule__ASN1_CHOICE__Group__3__Impl7646 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__4__Impl_in_rule__ASN1_CHOICE__Group__47677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ASN1_CHOICE__Group__4__Impl7705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__0__Impl_in_rule__ASN1_CHOICE__Group_3__07746 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__1_in_rule__ASN1_CHOICE__Group_3__07749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ASN1_CHOICE__Group_3__0__Impl7777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__1__Impl_in_rule__ASN1_CHOICE__Group_3__17808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_3_1_in_rule__ASN1_CHOICE__Group_3__1__Impl7835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__07869 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1_in_rule__ASN1_CHOICE_ENTRY__Group__07872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__IdAssignment_0_in_rule__ASN1_CHOICE_ENTRY__Group__0__Impl7899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__17929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1_in_rule__ASN1_CHOICE_ENTRY__Group__1__Impl7956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__Module__IdAssignment_07995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_rule__Module__AssignmentsAssignment_48026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_rule__Assignment__IdentifierAssignment_08057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_rule__Assignment__TypeAssignment_18088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_rule__Assignment__MacroAssignment_28119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifier__NameAssignment_08150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_rule__ObjectIdentifier__OidValueAssignment_48181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_08216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_18251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_28282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__TypeDefinition__NameAssignment_08313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScope_in_rule__TypeDefinition__ScopeAssignment_28344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__Macro__NameAssignment_08375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_rule__Macro__TypeNotationsAssignment_68406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__Macro__ValueNotationAssignment_98437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_rule__Macro__InnerTypesAssignment_108468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PARAMETER_in_rule__ParamAssignment__ParamAssignment_08499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_rule__ParamAssignment__RightAssignment_18530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__TypeNotation__ValueAssignment_18561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__RightAssignment_18592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__TypeReference__TypeAssignment8627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__Scope__ScopeAssignment8662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_08693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_1_18724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_rule__ValueType__NameAssignment_08755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_rule__ValueType__ParamAssignment_1_08786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_rule__ValueType__TypeAssignment_1_18817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_rule__ValueType__SimpleTypeAssignment_1_28848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__ValueType__MacroValueAssignment_1_38879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ValueType__OiAssignment_1_48915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_rule__MacroValue__TypeAssignment_38954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_rule__MACRO_VALUE_TYPE__ValLiteralAssignment_08985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_rule__MACRO_VALUE_TYPE__UpdateAssignment_19016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__UpdateType__TypeAssignment_19051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__MACRO_VALUE_CAP__ValueAssignment_09091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVALUE_CAP_LITERALS_in_rule__MACRO_VALUE_CAP__LiteralAssignment_19130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_rule__ASN1_SIMPLE__ConstraintAssignment_2_19161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SIMPLE__ConstraintAssignment_3_19192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_rule__ASN1_INTEGER__ValuePairsAssignment_29223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_39254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_4_19285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_RANGE__ValueAssignment_0_19316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_RANGE__StartAssignment_1_09347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_RANGE__EndAssignment_1_29378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_29409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_3_19440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__IdAssignment_09471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_19506 = new BitSet(new long[]{0x0000000000000002L});

}