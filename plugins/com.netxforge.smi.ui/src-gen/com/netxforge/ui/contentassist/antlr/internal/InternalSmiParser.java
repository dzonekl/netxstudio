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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_IA5STRING", "RULE_MODULE_ID", "RULE_ASN1_ID", "RULE_BIG_INTEGER", "RULE_PARAMETER", "RULE_ALPHA_CAP", "RULE_ALPHA", "RULE_NUMERIC", "RULE_SL_ASN1_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'DEFINITIONS'", "'::='", "'BEGIN'", "'END'", "'OBJECT IDENTIFIER'", "'{'", "'}'", "'MACRO'", "'|'", "'[APPLICATION'", "']'", "'value'", "'('", "')'", "'VALUE'", "'Update'", "'empty'", "'SIZE'", "'..'", "'CHOICE'", "','", "'TYPE NOTATION'", "'VALUE NOTATION'", "'IMPLICIT'", "'IA5String'", "'OCTET STRING'", "'INTEGER'"
    };
    public static final int T__42=42;
    public static final int T__40=40;
    public static final int RULE_NEWLINE=4;
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
    public static final int RULE_ANY_OTHER=15;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_ASN1_ID=7;
    public static final int RULE_ALPHA=11;
    public static final int EOF=-1;
    public static final int RULE_MODULE_ID=6;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_BIG_INTEGER=8;
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


    // $ANTLR start "entryRuleObjectIdentifier"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:89:1: entryRuleObjectIdentifier : ruleObjectIdentifier EOF ;
    public final void entryRuleObjectIdentifier() throws RecognitionException {

        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_ASN1_COMMENT");

        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:93:1: ( ruleObjectIdentifier EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:94:1: ruleObjectIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier132);
            ruleObjectIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifier139); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "entryRuleObjectIdentifier"


    // $ANTLR start "ruleObjectIdentifier"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:104:1: ruleObjectIdentifier : ( ( rule__ObjectIdentifier__Group__0 ) ) ;
    public final void ruleObjectIdentifier() throws RecognitionException {

        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_SL_ASN1_COMMENT");
        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:109:2: ( ( ( rule__ObjectIdentifier__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:110:1: ( ( rule__ObjectIdentifier__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:110:1: ( ( rule__ObjectIdentifier__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:111:1: ( rule__ObjectIdentifier__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:112:1: ( rule__ObjectIdentifier__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:112:2: rule__ObjectIdentifier__Group__0
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__0_in_ruleObjectIdentifier169);
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
            	myHiddenTokenState.restore();

        }
        return ;
    }
    // $ANTLR end "ruleObjectIdentifier"


    // $ANTLR start "entryRuleObjectIdentifierValue"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:125:1: entryRuleObjectIdentifierValue : ruleObjectIdentifierValue EOF ;
    public final void entryRuleObjectIdentifierValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:126:1: ( ruleObjectIdentifierValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:127:1: ruleObjectIdentifierValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueRule()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue196);
            ruleObjectIdentifierValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjectIdentifierValue203); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:134:1: ruleObjectIdentifierValue : ( ( rule__ObjectIdentifierValue__Group__0 ) ) ;
    public final void ruleObjectIdentifierValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:138:2: ( ( ( rule__ObjectIdentifierValue__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:139:1: ( ( rule__ObjectIdentifierValue__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:139:1: ( ( rule__ObjectIdentifierValue__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:140:1: ( rule__ObjectIdentifierValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:141:1: ( rule__ObjectIdentifierValue__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:141:2: rule__ObjectIdentifierValue__Group__0
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__0_in_ruleObjectIdentifierValue229);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:153:1: entryRuleTypeDefinition : ruleTypeDefinition EOF ;
    public final void entryRuleTypeDefinition() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:154:1: ( ruleTypeDefinition EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:155:1: ruleTypeDefinition EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition256);
            ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDefinition263); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:162:1: ruleTypeDefinition : ( ( rule__TypeDefinition__Group__0 ) ) ;
    public final void ruleTypeDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:166:2: ( ( ( rule__TypeDefinition__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:167:1: ( ( rule__TypeDefinition__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:167:1: ( ( rule__TypeDefinition__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:168:1: ( rule__TypeDefinition__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:169:1: ( rule__TypeDefinition__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:169:2: rule__TypeDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__0_in_ruleTypeDefinition289);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:181:1: entryRuleMacro : ruleMacro EOF ;
    public final void entryRuleMacro() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:182:1: ( ruleMacro EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:183:1: ruleMacro EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroRule()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_entryRuleMacro316);
            ruleMacro();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacro323); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:190:1: ruleMacro : ( ( rule__Macro__Group__0 ) ) ;
    public final void ruleMacro() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:194:2: ( ( ( rule__Macro__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:195:1: ( ( rule__Macro__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:195:1: ( ( rule__Macro__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:196:1: ( rule__Macro__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:197:1: ( rule__Macro__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:197:2: rule__Macro__Group__0
            {
            pushFollow(FOLLOW_rule__Macro__Group__0_in_ruleMacro349);
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


    // $ANTLR start "entryRuleTypeNotation"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:209:1: entryRuleTypeNotation : ruleTypeNotation EOF ;
    public final void entryRuleTypeNotation() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:210:1: ( ruleTypeNotation EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:211:1: ruleTypeNotation EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation376);
            ruleTypeNotation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotation383); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:218:1: ruleTypeNotation : ( ( rule__TypeNotation__Group__0 ) ) ;
    public final void ruleTypeNotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:222:2: ( ( ( rule__TypeNotation__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:223:1: ( ( rule__TypeNotation__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:223:1: ( ( rule__TypeNotation__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:224:1: ( rule__TypeNotation__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:225:1: ( rule__TypeNotation__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:225:2: rule__TypeNotation__Group__0
            {
            pushFollow(FOLLOW_rule__TypeNotation__Group__0_in_ruleTypeNotation409);
            rule__TypeNotation__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getGroup()); 
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


    // $ANTLR start "entryRuleValueNotation"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:237:1: entryRuleValueNotation : ruleValueNotation EOF ;
    public final void entryRuleValueNotation() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:238:1: ( ruleValueNotation EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:239:1: ruleValueNotation EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueNotationRule()); 
            }
            pushFollow(FOLLOW_ruleValueNotation_in_entryRuleValueNotation436);
            ruleValueNotation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueNotationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueNotation443); if (state.failed) return ;

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
    // $ANTLR end "entryRuleValueNotation"


    // $ANTLR start "ruleValueNotation"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:246:1: ruleValueNotation : ( ( rule__ValueNotation__Group__0 ) ) ;
    public final void ruleValueNotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:250:2: ( ( ( rule__ValueNotation__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:251:1: ( ( rule__ValueNotation__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:251:1: ( ( rule__ValueNotation__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:252:1: ( rule__ValueNotation__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueNotationAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:253:1: ( rule__ValueNotation__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:253:2: rule__ValueNotation__Group__0
            {
            pushFollow(FOLLOW_rule__ValueNotation__Group__0_in_ruleValueNotation469);
            rule__ValueNotation__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueNotationAccess().getGroup()); 
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
    // $ANTLR end "ruleValueNotation"


    // $ANTLR start "entryRuleTypeAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:265:1: entryRuleTypeAssignment : ruleTypeAssignment EOF ;
    public final void entryRuleTypeAssignment() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:266:1: ( ruleTypeAssignment EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:267:1: ruleTypeAssignment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment496);
            ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAssignmentRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAssignment503); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:274:1: ruleTypeAssignment : ( ( rule__TypeAssignment__Group__0 ) ) ;
    public final void ruleTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:278:2: ( ( ( rule__TypeAssignment__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:279:1: ( ( rule__TypeAssignment__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:279:1: ( ( rule__TypeAssignment__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:280:1: ( rule__TypeAssignment__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:281:1: ( rule__TypeAssignment__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:281:2: rule__TypeAssignment__Group__0
            {
            pushFollow(FOLLOW_rule__TypeAssignment__Group__0_in_ruleTypeAssignment529);
            rule__TypeAssignment__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAssignmentAccess().getGroup()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:293:1: entryRuleParamAssignment : ruleParamAssignment EOF ;
    public final void entryRuleParamAssignment() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:294:1: ( ruleParamAssignment EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:295:1: ruleParamAssignment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment556);
            ruleParamAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAssignmentRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamAssignment563); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:302:1: ruleParamAssignment : ( ( rule__ParamAssignment__Group__0 ) ) ;
    public final void ruleParamAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:306:2: ( ( ( rule__ParamAssignment__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:307:1: ( ( rule__ParamAssignment__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:307:1: ( ( rule__ParamAssignment__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:308:1: ( rule__ParamAssignment__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:309:1: ( rule__ParamAssignment__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:309:2: rule__ParamAssignment__Group__0
            {
            pushFollow(FOLLOW_rule__ParamAssignment__Group__0_in_ruleParamAssignment589);
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


    // $ANTLR start "entryRuleTypeNotationRight"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:321:1: entryRuleTypeNotationRight : ruleTypeNotationRight EOF ;
    public final void entryRuleTypeNotationRight() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:322:1: ( ruleTypeNotationRight EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:323:1: ruleTypeNotationRight EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationRightRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotationRight_in_entryRuleTypeNotationRight616);
            ruleTypeNotationRight();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationRightRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotationRight623); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTypeNotationRight"


    // $ANTLR start "ruleTypeNotationRight"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:330:1: ruleTypeNotationRight : ( ( rule__TypeNotationRight__Alternatives ) ) ;
    public final void ruleTypeNotationRight() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:334:2: ( ( ( rule__TypeNotationRight__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:335:1: ( ( rule__TypeNotationRight__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:335:1: ( ( rule__TypeNotationRight__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:336:1: ( rule__TypeNotationRight__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationRightAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:337:1: ( rule__TypeNotationRight__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:337:2: rule__TypeNotationRight__Alternatives
            {
            pushFollow(FOLLOW_rule__TypeNotationRight__Alternatives_in_ruleTypeNotationRight649);
            rule__TypeNotationRight__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationRightAccess().getAlternatives()); 
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
    // $ANTLR end "ruleTypeNotationRight"


    // $ANTLR start "entryRuleTypeReferenceExt"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:349:1: entryRuleTypeReferenceExt : ruleTypeReferenceExt EOF ;
    public final void entryRuleTypeReferenceExt() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:350:1: ( ruleTypeReferenceExt EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:351:1: ruleTypeReferenceExt EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt676);
            ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceExtRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReferenceExt683); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:358:1: ruleTypeReferenceExt : ( ( rule__TypeReferenceExt__Group__0 ) ) ;
    public final void ruleTypeReferenceExt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:362:2: ( ( ( rule__TypeReferenceExt__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:363:1: ( ( rule__TypeReferenceExt__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:363:1: ( ( rule__TypeReferenceExt__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:364:1: ( rule__TypeReferenceExt__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:365:1: ( rule__TypeReferenceExt__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:365:2: rule__TypeReferenceExt__Group__0
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__0_in_ruleTypeReferenceExt709);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:377:1: entryRuleTypeReference : ruleTypeReference EOF ;
    public final void entryRuleTypeReference() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:378:1: ( ruleTypeReference EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:379:1: ruleTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_entryRuleTypeReference736);
            ruleTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReference743); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:386:1: ruleTypeReference : ( ( rule__TypeReference__TypeAssignment ) ) ;
    public final void ruleTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:390:2: ( ( ( rule__TypeReference__TypeAssignment ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:391:1: ( ( rule__TypeReference__TypeAssignment ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:391:1: ( ( rule__TypeReference__TypeAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:392:1: ( rule__TypeReference__TypeAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceAccess().getTypeAssignment()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:393:1: ( rule__TypeReference__TypeAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:393:2: rule__TypeReference__TypeAssignment
            {
            pushFollow(FOLLOW_rule__TypeReference__TypeAssignment_in_ruleTypeReference769);
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


    // $ANTLR start "entryRuleValue"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:405:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:406:1: ( ruleValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:407:1: ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue796);
            ruleValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue803); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:414:1: ruleValue : ( ( rule__Value__Group__0 ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:418:2: ( ( ( rule__Value__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:419:1: ( ( rule__Value__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:419:1: ( ( rule__Value__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:420:1: ( rule__Value__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:421:1: ( rule__Value__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:421:2: rule__Value__Group__0
            {
            pushFollow(FOLLOW_rule__Value__Group__0_in_ruleValue829);
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


    // $ANTLR start "entryRuleTag"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:433:1: entryRuleTag : ruleTag EOF ;
    public final void entryRuleTag() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:434:1: ( ruleTag EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:435:1: ruleTag EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTagRule()); 
            }
            pushFollow(FOLLOW_ruleTag_in_entryRuleTag856);
            ruleTag();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTagRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTag863); if (state.failed) return ;

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
    // $ANTLR end "entryRuleTag"


    // $ANTLR start "ruleTag"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:442:1: ruleTag : ( ( rule__Tag__Group__0 ) ) ;
    public final void ruleTag() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:446:2: ( ( ( rule__Tag__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:447:1: ( ( rule__Tag__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:447:1: ( ( rule__Tag__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:448:1: ( rule__Tag__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTagAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:449:1: ( rule__Tag__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:449:2: rule__Tag__Group__0
            {
            pushFollow(FOLLOW_rule__Tag__Group__0_in_ruleTag889);
            rule__Tag__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTagAccess().getGroup()); 
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
    // $ANTLR end "ruleTag"


    // $ANTLR start "entryRuleValueType"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:461:1: entryRuleValueType : ruleValueType EOF ;
    public final void entryRuleValueType() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:462:1: ( ruleValueType EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:463:1: ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType916);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType923); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:470:1: ruleValueType : ( ( rule__ValueType__Alternatives ) ) ;
    public final void ruleValueType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:474:2: ( ( ( rule__ValueType__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:475:1: ( ( rule__ValueType__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:475:1: ( ( rule__ValueType__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:476:1: ( rule__ValueType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:477:1: ( rule__ValueType__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:477:2: rule__ValueType__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueType__Alternatives_in_ruleValueType949);
            rule__ValueType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getAlternatives()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:489:1: entryRuleMacroValue : ruleMacroValue EOF ;
    public final void entryRuleMacroValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:490:1: ( ruleMacroValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:491:1: ruleMacroValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue976);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue983); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:498:1: ruleMacroValue : ( ( rule__MacroValue__Group__0 ) ) ;
    public final void ruleMacroValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:502:2: ( ( ( rule__MacroValue__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:503:1: ( ( rule__MacroValue__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:503:1: ( ( rule__MacroValue__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:504:1: ( rule__MacroValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:505:1: ( rule__MacroValue__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:505:2: rule__MacroValue__Group__0
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__0_in_ruleMacroValue1009);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:517:1: entryRuleMACRO_VALUE_TYPE : ruleMACRO_VALUE_TYPE EOF ;
    public final void entryRuleMACRO_VALUE_TYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:518:1: ( ruleMACRO_VALUE_TYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:519:1: ruleMACRO_VALUE_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE1036);
            ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE1043); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:526:1: ruleMACRO_VALUE_TYPE : ( ( rule__MACRO_VALUE_TYPE__Alternatives ) ) ;
    public final void ruleMACRO_VALUE_TYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:530:2: ( ( ( rule__MACRO_VALUE_TYPE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:531:1: ( ( rule__MACRO_VALUE_TYPE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:531:1: ( ( rule__MACRO_VALUE_TYPE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:532:1: ( rule__MACRO_VALUE_TYPE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:533:1: ( rule__MACRO_VALUE_TYPE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:533:2: rule__MACRO_VALUE_TYPE__Alternatives
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__Alternatives_in_ruleMACRO_VALUE_TYPE1069);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:545:1: entryRuleUpdateType : ruleUpdateType EOF ;
    public final void entryRuleUpdateType() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:546:1: ( ruleUpdateType EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:547:1: ruleUpdateType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_entryRuleUpdateType1096);
            ruleUpdateType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpdateType1103); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:554:1: ruleUpdateType : ( ( rule__UpdateType__Group__0 ) ) ;
    public final void ruleUpdateType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:558:2: ( ( ( rule__UpdateType__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:559:1: ( ( rule__UpdateType__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:559:1: ( ( rule__UpdateType__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:560:1: ( rule__UpdateType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:561:1: ( rule__UpdateType__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:561:2: rule__UpdateType__Group__0
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__0_in_ruleUpdateType1129);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:573:1: entryRuleMACRO_VALUE_CAP : ruleMACRO_VALUE_CAP EOF ;
    public final void entryRuleMACRO_VALUE_CAP() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:574:1: ( ruleMACRO_VALUE_CAP EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:575:1: ruleMACRO_VALUE_CAP EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP1156);
            ruleMACRO_VALUE_CAP();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP1163); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:582:1: ruleMACRO_VALUE_CAP : ( ( rule__MACRO_VALUE_CAP__Alternatives ) ) ;
    public final void ruleMACRO_VALUE_CAP() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:586:2: ( ( ( rule__MACRO_VALUE_CAP__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:587:1: ( ( rule__MACRO_VALUE_CAP__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:587:1: ( ( rule__MACRO_VALUE_CAP__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:588:1: ( rule__MACRO_VALUE_CAP__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:589:1: ( rule__MACRO_VALUE_CAP__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:589:2: rule__MACRO_VALUE_CAP__Alternatives
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__Alternatives_in_ruleMACRO_VALUE_CAP1189);
            rule__MACRO_VALUE_CAP__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPAccess().getAlternatives()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:601:1: entryRuleASN1_TYPE : ruleASN1_TYPE EOF ;
    public final void entryRuleASN1_TYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:602:1: ( ruleASN1_TYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:603:1: ruleASN1_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE1216);
            ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_TYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE1223); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:610:1: ruleASN1_TYPE : ( ( rule__ASN1_TYPE__Alternatives ) ) ;
    public final void ruleASN1_TYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:614:2: ( ( ( rule__ASN1_TYPE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:615:1: ( ( rule__ASN1_TYPE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:615:1: ( ( rule__ASN1_TYPE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:616:1: ( rule__ASN1_TYPE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_TYPEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:617:1: ( rule__ASN1_TYPE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:617:2: rule__ASN1_TYPE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_TYPE__Alternatives_in_ruleASN1_TYPE1249);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:629:1: entryRuleASN1_SIMPLE : ruleASN1_SIMPLE EOF ;
    public final void entryRuleASN1_SIMPLE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:630:1: ( ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:631:1: ruleASN1_SIMPLE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE1276);
            ruleASN1_SIMPLE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE1283); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:638:1: ruleASN1_SIMPLE : ( ( rule__ASN1_SIMPLE__Alternatives ) ) ;
    public final void ruleASN1_SIMPLE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:642:2: ( ( ( rule__ASN1_SIMPLE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:643:1: ( ( rule__ASN1_SIMPLE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:643:1: ( ( rule__ASN1_SIMPLE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:644:1: ( rule__ASN1_SIMPLE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:645:1: ( rule__ASN1_SIMPLE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:645:2: rule__ASN1_SIMPLE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Alternatives_in_ruleASN1_SIMPLE1309);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:657:1: entryRuleASN1_OCTET_STRING : ruleASN1_OCTET_STRING EOF ;
    public final void entryRuleASN1_OCTET_STRING() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:658:1: ( ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:659:1: ruleASN1_OCTET_STRING EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING1336);
            ruleASN1_OCTET_STRING();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING1343); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:666:1: ruleASN1_OCTET_STRING : ( ( rule__ASN1_OCTET_STRING__Group__0 ) ) ;
    public final void ruleASN1_OCTET_STRING() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:670:2: ( ( ( rule__ASN1_OCTET_STRING__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:671:1: ( ( rule__ASN1_OCTET_STRING__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:671:1: ( ( rule__ASN1_OCTET_STRING__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:672:1: ( rule__ASN1_OCTET_STRING__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:673:1: ( rule__ASN1_OCTET_STRING__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:673:2: rule__ASN1_OCTET_STRING__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__0_in_ruleASN1_OCTET_STRING1369);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:685:1: entryRuleASN1_INTEGER : ruleASN1_INTEGER EOF ;
    public final void entryRuleASN1_INTEGER() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:686:1: ( ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:687:1: ruleASN1_INTEGER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER1396);
            ruleASN1_INTEGER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER1403); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:694:1: ruleASN1_INTEGER : ( ( rule__ASN1_INTEGER__Group__0 ) ) ;
    public final void ruleASN1_INTEGER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:698:2: ( ( ( rule__ASN1_INTEGER__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:699:1: ( ( rule__ASN1_INTEGER__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:699:1: ( ( rule__ASN1_INTEGER__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:700:1: ( rule__ASN1_INTEGER__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:701:1: ( rule__ASN1_INTEGER__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:701:2: rule__ASN1_INTEGER__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__0_in_ruleASN1_INTEGER1429);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:713:1: entryRuleASN1_SUBTYPE : ruleASN1_SUBTYPE EOF ;
    public final void entryRuleASN1_SUBTYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:714:1: ( ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:715:1: ruleASN1_SUBTYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE1456);
            ruleASN1_SUBTYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE1463); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:722:1: ruleASN1_SUBTYPE : ( ( rule__ASN1_SUBTYPE__Group__0 ) ) ;
    public final void ruleASN1_SUBTYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:726:2: ( ( ( rule__ASN1_SUBTYPE__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:727:1: ( ( rule__ASN1_SUBTYPE__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:727:1: ( ( rule__ASN1_SUBTYPE__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:728:1: ( rule__ASN1_SUBTYPE__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:729:1: ( rule__ASN1_SUBTYPE__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:729:2: rule__ASN1_SUBTYPE__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__0_in_ruleASN1_SUBTYPE1489);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:741:1: entryRuleASN1_RANGE : ruleASN1_RANGE EOF ;
    public final void entryRuleASN1_RANGE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:742:1: ( ruleASN1_RANGE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:743:1: ruleASN1_RANGE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE1516);
            ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE1523); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:750:1: ruleASN1_RANGE : ( ( rule__ASN1_RANGE__Alternatives ) ) ;
    public final void ruleASN1_RANGE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:754:2: ( ( ( rule__ASN1_RANGE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:755:1: ( ( rule__ASN1_RANGE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:755:1: ( ( rule__ASN1_RANGE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:756:1: ( rule__ASN1_RANGE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:757:1: ( rule__ASN1_RANGE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:757:2: rule__ASN1_RANGE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Alternatives_in_ruleASN1_RANGE1549);
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


    // $ANTLR start "entryRuleASN1_CHOICE"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:771:1: entryRuleASN1_CHOICE : ruleASN1_CHOICE EOF ;
    public final void entryRuleASN1_CHOICE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:772:1: ( ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:773:1: ruleASN1_CHOICE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE1578);
            ruleASN1_CHOICE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE1585); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:780:1: ruleASN1_CHOICE : ( ( rule__ASN1_CHOICE__Group__0 ) ) ;
    public final void ruleASN1_CHOICE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:784:2: ( ( ( rule__ASN1_CHOICE__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:785:1: ( ( rule__ASN1_CHOICE__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:785:1: ( ( rule__ASN1_CHOICE__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:786:1: ( rule__ASN1_CHOICE__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:787:1: ( rule__ASN1_CHOICE__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:787:2: rule__ASN1_CHOICE__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__0_in_ruleASN1_CHOICE1611);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:799:1: entryRuleASN1_CHOICE_ENTRY : ruleASN1_CHOICE_ENTRY EOF ;
    public final void entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:800:1: ( ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:801:1: ruleASN1_CHOICE_ENTRY EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY1638);
            ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY1645); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:808:1: ruleASN1_CHOICE_ENTRY : ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) ) ;
    public final void ruleASN1_CHOICE_ENTRY() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:812:2: ( ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:813:1: ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:813:1: ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:814:1: ( rule__ASN1_CHOICE_ENTRY__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:815:1: ( rule__ASN1_CHOICE_ENTRY__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:815:2: rule__ASN1_CHOICE_ENTRY__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0_in_ruleASN1_CHOICE_ENTRY1671);
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


    // $ANTLR start "entryRuleChoiceType"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:827:1: entryRuleChoiceType : ruleChoiceType EOF ;
    public final void entryRuleChoiceType() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:828:1: ( ruleChoiceType EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:829:1: ruleChoiceType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getChoiceTypeRule()); 
            }
            pushFollow(FOLLOW_ruleChoiceType_in_entryRuleChoiceType1698);
            ruleChoiceType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getChoiceTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleChoiceType1705); if (state.failed) return ;

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
    // $ANTLR end "entryRuleChoiceType"


    // $ANTLR start "ruleChoiceType"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:836:1: ruleChoiceType : ( ( rule__ChoiceType__Alternatives ) ) ;
    public final void ruleChoiceType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:840:2: ( ( ( rule__ChoiceType__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:841:1: ( ( rule__ChoiceType__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:841:1: ( ( rule__ChoiceType__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:842:1: ( rule__ChoiceType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getChoiceTypeAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:843:1: ( rule__ChoiceType__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:843:2: rule__ChoiceType__Alternatives
            {
            pushFollow(FOLLOW_rule__ChoiceType__Alternatives_in_ruleChoiceType1731);
            rule__ChoiceType__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getChoiceTypeAccess().getAlternatives()); 
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
    // $ANTLR end "ruleChoiceType"


    // $ANTLR start "rule__Module__Alternatives_5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:855:1: rule__Module__Alternatives_5 : ( ( ( rule__Module__IdentifiersAssignment_5_0 ) ) | ( ( rule__Module__TypesAssignment_5_1 ) ) | ( ( rule__Module__MacrosAssignment_5_2 ) ) );
    public final void rule__Module__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:859:1: ( ( ( rule__Module__IdentifiersAssignment_5_0 ) ) | ( ( rule__Module__TypesAssignment_5_1 ) ) | ( ( rule__Module__MacrosAssignment_5_2 ) ) )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:860:1: ( ( rule__Module__IdentifiersAssignment_5_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:860:1: ( ( rule__Module__IdentifiersAssignment_5_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:861:1: ( rule__Module__IdentifiersAssignment_5_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModuleAccess().getIdentifiersAssignment_5_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:862:1: ( rule__Module__IdentifiersAssignment_5_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:862:2: rule__Module__IdentifiersAssignment_5_0
                    {
                    pushFollow(FOLLOW_rule__Module__IdentifiersAssignment_5_0_in_rule__Module__Alternatives_51767);
                    rule__Module__IdentifiersAssignment_5_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModuleAccess().getIdentifiersAssignment_5_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:866:6: ( ( rule__Module__TypesAssignment_5_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:866:6: ( ( rule__Module__TypesAssignment_5_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:867:1: ( rule__Module__TypesAssignment_5_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModuleAccess().getTypesAssignment_5_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:868:1: ( rule__Module__TypesAssignment_5_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:868:2: rule__Module__TypesAssignment_5_1
                    {
                    pushFollow(FOLLOW_rule__Module__TypesAssignment_5_1_in_rule__Module__Alternatives_51785);
                    rule__Module__TypesAssignment_5_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModuleAccess().getTypesAssignment_5_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:872:6: ( ( rule__Module__MacrosAssignment_5_2 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:872:6: ( ( rule__Module__MacrosAssignment_5_2 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:873:1: ( rule__Module__MacrosAssignment_5_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModuleAccess().getMacrosAssignment_5_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:874:1: ( rule__Module__MacrosAssignment_5_2 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:874:2: rule__Module__MacrosAssignment_5_2
                    {
                    pushFollow(FOLLOW_rule__Module__MacrosAssignment_5_2_in_rule__Module__Alternatives_51803);
                    rule__Module__MacrosAssignment_5_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModuleAccess().getMacrosAssignment_5_2()); 
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
    // $ANTLR end "rule__Module__Alternatives_5"


    // $ANTLR start "rule__ObjectIdentifierValue__Alternatives_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:883:1: rule__ObjectIdentifierValue__Alternatives_0 : ( ( ( rule__ObjectIdentifierValue__NameAssignment_0_0 ) ) | ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) ) );
    public final void rule__ObjectIdentifierValue__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:887:1: ( ( ( rule__ObjectIdentifierValue__NameAssignment_0_0 ) ) | ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ASN1_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred3_InternalSmi()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:888:1: ( ( rule__ObjectIdentifierValue__NameAssignment_0_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:888:1: ( ( rule__ObjectIdentifierValue__NameAssignment_0_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:889:1: ( rule__ObjectIdentifierValue__NameAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectIdentifierValueAccess().getNameAssignment_0_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:890:1: ( rule__ObjectIdentifierValue__NameAssignment_0_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:890:2: rule__ObjectIdentifierValue__NameAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__NameAssignment_0_0_in_rule__ObjectIdentifierValue__Alternatives_01836);
                    rule__ObjectIdentifierValue__NameAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectIdentifierValueAccess().getNameAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:894:6: ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:894:6: ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:895:1: ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceAssignment_0_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:896:1: ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:896:2: rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1_in_rule__ObjectIdentifierValue__Alternatives_01854);
                    rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceAssignment_0_1()); 
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


    // $ANTLR start "rule__TypeAssignment__Alternatives_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:905:1: rule__TypeAssignment__Alternatives_1 : ( ( ruleParamAssignment ) | ( ruleTypeReference ) | ( ruleMacroValue ) );
    public final void rule__TypeAssignment__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:909:1: ( ( ruleParamAssignment ) | ( ruleTypeReference ) | ( ruleMacroValue ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt3=1;
                }
                break;
            case RULE_MODULE_ID:
                {
                alt3=2;
                }
                break;
            case 27:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:910:1: ( ruleParamAssignment )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:910:1: ( ruleParamAssignment )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:911:1: ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_1_0()); 
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_rule__TypeAssignment__Alternatives_11887);
                    ruleParamAssignment();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:916:6: ( ruleTypeReference )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:916:6: ( ruleTypeReference )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:917:1: ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1_1()); 
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeAssignment__Alternatives_11904);
                    ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:922:6: ( ruleMacroValue )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:922:6: ( ruleMacroValue )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:923:1: ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAssignmentAccess().getMacroValueParserRuleCall_1_2()); 
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_rule__TypeAssignment__Alternatives_11921);
                    ruleMacroValue();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeAssignmentAccess().getMacroValueParserRuleCall_1_2()); 
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
    // $ANTLR end "rule__TypeAssignment__Alternatives_1"


    // $ANTLR start "rule__TypeNotationRight__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:933:1: rule__TypeNotationRight__Alternatives : ( ( ruleTypeReference ) | ( ( rule__TypeNotationRight__ValueAssignment_1 ) ) );
    public final void rule__TypeNotationRight__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:937:1: ( ( ruleTypeReference ) | ( ( rule__TypeNotationRight__ValueAssignment_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_MODULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==27) ) {
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:938:1: ( ruleTypeReference )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:938:1: ( ruleTypeReference )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:939:1: ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeNotationRightAccess().getTypeReferenceParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeNotationRight__Alternatives1953);
                    ruleTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeNotationRightAccess().getTypeReferenceParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:944:6: ( ( rule__TypeNotationRight__ValueAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:944:6: ( ( rule__TypeNotationRight__ValueAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:945:1: ( rule__TypeNotationRight__ValueAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeNotationRightAccess().getValueAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:946:1: ( rule__TypeNotationRight__ValueAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:946:2: rule__TypeNotationRight__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TypeNotationRight__ValueAssignment_1_in_rule__TypeNotationRight__Alternatives1970);
                    rule__TypeNotationRight__ValueAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getTypeNotationRightAccess().getValueAssignment_1()); 
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
    // $ANTLR end "rule__TypeNotationRight__Alternatives"


    // $ANTLR start "rule__ValueType__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:955:1: rule__ValueType__Alternatives : ( ( ( rule__ValueType__ParamAssignment_0 ) ) | ( ( rule__ValueType__TypesAssignment_1 ) ) | ( ( rule__ValueType__SimpleTypeAssignment_2 ) ) | ( ( rule__ValueType__MacroValueAssignment_3 ) ) | ( ( rule__ValueType__OiAssignment_4 ) ) );
    public final void rule__ValueType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:959:1: ( ( ( rule__ValueType__ParamAssignment_0 ) ) | ( ( rule__ValueType__TypesAssignment_1 ) ) | ( ( rule__ValueType__SimpleTypeAssignment_2 ) ) | ( ( rule__ValueType__MacroValueAssignment_3 ) ) | ( ( rule__ValueType__OiAssignment_4 ) ) )
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
            case 32:
            case 35:
            case 41:
            case 42:
                {
                alt5=3;
                }
                break;
            case 27:
                {
                alt5=4;
                }
                break;
            case 20:
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:960:1: ( ( rule__ValueType__ParamAssignment_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:960:1: ( ( rule__ValueType__ParamAssignment_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:961:1: ( rule__ValueType__ParamAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getParamAssignment_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:962:1: ( rule__ValueType__ParamAssignment_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:962:2: rule__ValueType__ParamAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ValueType__ParamAssignment_0_in_rule__ValueType__Alternatives2003);
                    rule__ValueType__ParamAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getParamAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:966:6: ( ( rule__ValueType__TypesAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:966:6: ( ( rule__ValueType__TypesAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:967:1: ( rule__ValueType__TypesAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getTypesAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:968:1: ( rule__ValueType__TypesAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:968:2: rule__ValueType__TypesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ValueType__TypesAssignment_1_in_rule__ValueType__Alternatives2021);
                    rule__ValueType__TypesAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getTypesAssignment_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:972:6: ( ( rule__ValueType__SimpleTypeAssignment_2 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:972:6: ( ( rule__ValueType__SimpleTypeAssignment_2 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:973:1: ( rule__ValueType__SimpleTypeAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getSimpleTypeAssignment_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:974:1: ( rule__ValueType__SimpleTypeAssignment_2 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:974:2: rule__ValueType__SimpleTypeAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ValueType__SimpleTypeAssignment_2_in_rule__ValueType__Alternatives2039);
                    rule__ValueType__SimpleTypeAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getSimpleTypeAssignment_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:978:6: ( ( rule__ValueType__MacroValueAssignment_3 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:978:6: ( ( rule__ValueType__MacroValueAssignment_3 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:979:1: ( rule__ValueType__MacroValueAssignment_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getMacroValueAssignment_3()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:980:1: ( rule__ValueType__MacroValueAssignment_3 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:980:2: rule__ValueType__MacroValueAssignment_3
                    {
                    pushFollow(FOLLOW_rule__ValueType__MacroValueAssignment_3_in_rule__ValueType__Alternatives2057);
                    rule__ValueType__MacroValueAssignment_3();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getMacroValueAssignment_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:984:6: ( ( rule__ValueType__OiAssignment_4 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:984:6: ( ( rule__ValueType__OiAssignment_4 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:985:1: ( rule__ValueType__OiAssignment_4 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getOiAssignment_4()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:986:1: ( rule__ValueType__OiAssignment_4 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:986:2: rule__ValueType__OiAssignment_4
                    {
                    pushFollow(FOLLOW_rule__ValueType__OiAssignment_4_in_rule__ValueType__Alternatives2075);
                    rule__ValueType__OiAssignment_4();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getOiAssignment_4()); 
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
    // $ANTLR end "rule__ValueType__Alternatives"


    // $ANTLR start "rule__MACRO_VALUE_TYPE__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:995:1: rule__MACRO_VALUE_TYPE__Alternatives : ( ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) ) | ( ( rule__MACRO_VALUE_TYPE__Group_1__0 ) ) | ( ( rule__MACRO_VALUE_TYPE__StringAssignment_2 ) ) );
    public final void rule__MACRO_VALUE_TYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:999:1: ( ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) ) | ( ( rule__MACRO_VALUE_TYPE__Group_1__0 ) ) | ( ( rule__MACRO_VALUE_TYPE__StringAssignment_2 ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt6=1;
                }
                break;
            case 30:
                {
                alt6=2;
                }
                break;
            case 40:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1000:1: ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1000:1: ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1001:1: ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateAssignment_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1002:1: ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1002:2: rule__MACRO_VALUE_TYPE__UpdateAssignment_0
                    {
                    pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__UpdateAssignment_0_in_rule__MACRO_VALUE_TYPE__Alternatives2108);
                    rule__MACRO_VALUE_TYPE__UpdateAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1006:6: ( ( rule__MACRO_VALUE_TYPE__Group_1__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1006:6: ( ( rule__MACRO_VALUE_TYPE__Group_1__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1007:1: ( rule__MACRO_VALUE_TYPE__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_TYPEAccess().getGroup_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1008:1: ( rule__MACRO_VALUE_TYPE__Group_1__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1008:2: rule__MACRO_VALUE_TYPE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__Group_1__0_in_rule__MACRO_VALUE_TYPE__Alternatives2126);
                    rule__MACRO_VALUE_TYPE__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMACRO_VALUE_TYPEAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1012:6: ( ( rule__MACRO_VALUE_TYPE__StringAssignment_2 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1012:6: ( ( rule__MACRO_VALUE_TYPE__StringAssignment_2 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1013:1: ( rule__MACRO_VALUE_TYPE__StringAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_TYPEAccess().getStringAssignment_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1014:1: ( rule__MACRO_VALUE_TYPE__StringAssignment_2 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1014:2: rule__MACRO_VALUE_TYPE__StringAssignment_2
                    {
                    pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__StringAssignment_2_in_rule__MACRO_VALUE_TYPE__Alternatives2144);
                    rule__MACRO_VALUE_TYPE__StringAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMACRO_VALUE_TYPEAccess().getStringAssignment_2()); 
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


    // $ANTLR start "rule__MACRO_VALUE_CAP__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1023:1: rule__MACRO_VALUE_CAP__Alternatives : ( ( ( rule__MACRO_VALUE_CAP__Group_0__0 ) ) | ( ( rule__MACRO_VALUE_CAP__RefAssignment_1 ) ) );
    public final void rule__MACRO_VALUE_CAP__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1027:1: ( ( ( rule__MACRO_VALUE_CAP__Group_0__0 ) ) | ( ( rule__MACRO_VALUE_CAP__RefAssignment_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_MODULE_ID) ) {
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1028:1: ( ( rule__MACRO_VALUE_CAP__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1028:1: ( ( rule__MACRO_VALUE_CAP__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1029:1: ( rule__MACRO_VALUE_CAP__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_CAPAccess().getGroup_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1030:1: ( rule__MACRO_VALUE_CAP__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1030:2: rule__MACRO_VALUE_CAP__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__Group_0__0_in_rule__MACRO_VALUE_CAP__Alternatives2177);
                    rule__MACRO_VALUE_CAP__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMACRO_VALUE_CAPAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1034:6: ( ( rule__MACRO_VALUE_CAP__RefAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1034:6: ( ( rule__MACRO_VALUE_CAP__RefAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1035:1: ( rule__MACRO_VALUE_CAP__RefAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_CAPAccess().getRefAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1036:1: ( rule__MACRO_VALUE_CAP__RefAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1036:2: rule__MACRO_VALUE_CAP__RefAssignment_1
                    {
                    pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__RefAssignment_1_in_rule__MACRO_VALUE_CAP__Alternatives2195);
                    rule__MACRO_VALUE_CAP__RefAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMACRO_VALUE_CAPAccess().getRefAssignment_1()); 
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
    // $ANTLR end "rule__MACRO_VALUE_CAP__Alternatives"


    // $ANTLR start "rule__ASN1_TYPE__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1045:1: rule__ASN1_TYPE__Alternatives : ( ( ruleASN1_SIMPLE ) | ( ruleASN1_CHOICE ) );
    public final void rule__ASN1_TYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1049:1: ( ( ruleASN1_SIMPLE ) | ( ruleASN1_CHOICE ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_IA5STRING||LA8_0==32||(LA8_0>=41 && LA8_0<=42)) ) {
                alt8=1;
            }
            else if ( (LA8_0==35) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1050:1: ( ruleASN1_SIMPLE )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1050:1: ( ruleASN1_SIMPLE )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1051:1: ruleASN1_SIMPLE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_rule__ASN1_TYPE__Alternatives2228);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1056:6: ( ruleASN1_CHOICE )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1056:6: ( ruleASN1_CHOICE )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1057:1: ruleASN1_CHOICE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_rule__ASN1_TYPE__Alternatives2245);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1067:1: rule__ASN1_SIMPLE__Alternatives : ( ( ( rule__ASN1_SIMPLE__Group_0__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_1__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_2__0 ) ) | ( ruleASN1_INTEGER ) );
    public final void rule__ASN1_SIMPLE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1071:1: ( ( ( rule__ASN1_SIMPLE__Group_0__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_1__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_2__0 ) ) | ( ruleASN1_INTEGER ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt9=1;
                }
                break;
            case RULE_IA5STRING:
                {
                alt9=2;
                }
                break;
            case 41:
                {
                alt9=3;
                }
                break;
            case 42:
                {
                alt9=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1072:1: ( ( rule__ASN1_SIMPLE__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1072:1: ( ( rule__ASN1_SIMPLE__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1073:1: ( rule__ASN1_SIMPLE__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1074:1: ( rule__ASN1_SIMPLE__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1074:2: rule__ASN1_SIMPLE__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__0_in_rule__ASN1_SIMPLE__Alternatives2277);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1078:6: ( ( rule__ASN1_SIMPLE__Group_1__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1078:6: ( ( rule__ASN1_SIMPLE__Group_1__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1079:1: ( rule__ASN1_SIMPLE__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1080:1: ( rule__ASN1_SIMPLE__Group_1__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1080:2: rule__ASN1_SIMPLE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__0_in_rule__ASN1_SIMPLE__Alternatives2295);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1084:6: ( ( rule__ASN1_SIMPLE__Group_2__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1084:6: ( ( rule__ASN1_SIMPLE__Group_2__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1085:1: ( rule__ASN1_SIMPLE__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1086:1: ( rule__ASN1_SIMPLE__Group_2__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1086:2: rule__ASN1_SIMPLE__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__0_in_rule__ASN1_SIMPLE__Alternatives2313);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1090:6: ( ruleASN1_INTEGER )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1090:6: ( ruleASN1_INTEGER )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1091:1: ruleASN1_INTEGER
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3()); 
                    }
                    pushFollow(FOLLOW_ruleASN1_INTEGER_in_rule__ASN1_SIMPLE__Alternatives2331);
                    ruleASN1_INTEGER();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1101:1: rule__ASN1_RANGE__Alternatives : ( ( ( rule__ASN1_RANGE__Group_0__0 ) ) | ( ( rule__ASN1_RANGE__Group_1__0 ) ) );
    public final void rule__ASN1_RANGE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1105:1: ( ( ( rule__ASN1_RANGE__Group_0__0 ) ) | ( ( rule__ASN1_RANGE__Group_1__0 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_BIG_INTEGER) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==34) ) {
                    alt10=2;
                }
                else if ( (LA10_1==EOF||LA10_1==24||LA10_1==29) ) {
                    alt10=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1106:1: ( ( rule__ASN1_RANGE__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1106:1: ( ( rule__ASN1_RANGE__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1107:1: ( rule__ASN1_RANGE__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_RANGEAccess().getGroup_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1108:1: ( rule__ASN1_RANGE__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1108:2: rule__ASN1_RANGE__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__0_in_rule__ASN1_RANGE__Alternatives2363);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1112:6: ( ( rule__ASN1_RANGE__Group_1__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1112:6: ( ( rule__ASN1_RANGE__Group_1__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1113:1: ( rule__ASN1_RANGE__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_RANGEAccess().getGroup_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1114:1: ( rule__ASN1_RANGE__Group_1__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1114:2: rule__ASN1_RANGE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__0_in_rule__ASN1_RANGE__Alternatives2381);
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


    // $ANTLR start "rule__ChoiceType__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1123:1: rule__ChoiceType__Alternatives : ( ( ( rule__ChoiceType__TypeRefAssignment_0 ) ) | ( ( rule__ChoiceType__SimpleTypeAssignment_1 ) ) | ( ( rule__ChoiceType__OiAssignment_2 ) ) );
    public final void rule__ChoiceType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1127:1: ( ( ( rule__ChoiceType__TypeRefAssignment_0 ) ) | ( ( rule__ChoiceType__SimpleTypeAssignment_1 ) ) | ( ( rule__ChoiceType__OiAssignment_2 ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case RULE_MODULE_ID:
                {
                alt11=1;
                }
                break;
            case RULE_IA5STRING:
            case 32:
            case 35:
            case 41:
            case 42:
                {
                alt11=2;
                }
                break;
            case 20:
                {
                alt11=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1128:1: ( ( rule__ChoiceType__TypeRefAssignment_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1128:1: ( ( rule__ChoiceType__TypeRefAssignment_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1129:1: ( rule__ChoiceType__TypeRefAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getChoiceTypeAccess().getTypeRefAssignment_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1130:1: ( rule__ChoiceType__TypeRefAssignment_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1130:2: rule__ChoiceType__TypeRefAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ChoiceType__TypeRefAssignment_0_in_rule__ChoiceType__Alternatives2414);
                    rule__ChoiceType__TypeRefAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getChoiceTypeAccess().getTypeRefAssignment_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1134:6: ( ( rule__ChoiceType__SimpleTypeAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1134:6: ( ( rule__ChoiceType__SimpleTypeAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1135:1: ( rule__ChoiceType__SimpleTypeAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getChoiceTypeAccess().getSimpleTypeAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1136:1: ( rule__ChoiceType__SimpleTypeAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1136:2: rule__ChoiceType__SimpleTypeAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ChoiceType__SimpleTypeAssignment_1_in_rule__ChoiceType__Alternatives2432);
                    rule__ChoiceType__SimpleTypeAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getChoiceTypeAccess().getSimpleTypeAssignment_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1140:6: ( ( rule__ChoiceType__OiAssignment_2 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1140:6: ( ( rule__ChoiceType__OiAssignment_2 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1141:1: ( rule__ChoiceType__OiAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getChoiceTypeAccess().getOiAssignment_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1142:1: ( rule__ChoiceType__OiAssignment_2 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1142:2: rule__ChoiceType__OiAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ChoiceType__OiAssignment_2_in_rule__ChoiceType__Alternatives2450);
                    rule__ChoiceType__OiAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getChoiceTypeAccess().getOiAssignment_2()); 
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
    // $ANTLR end "rule__ChoiceType__Alternatives"


    // $ANTLR start "rule__Module__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1153:1: rule__Module__Group__0 : rule__Module__Group__0__Impl rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1157:1: ( rule__Module__Group__0__Impl rule__Module__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1158:2: rule__Module__Group__0__Impl rule__Module__Group__1
            {
            pushFollow(FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__02481);
            rule__Module__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__1_in_rule__Module__Group__02484);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1165:1: rule__Module__Group__0__Impl : ( ( rule__Module__NameAssignment_0 ) ) ;
    public final void rule__Module__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1169:1: ( ( ( rule__Module__NameAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1170:1: ( ( rule__Module__NameAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1170:1: ( ( rule__Module__NameAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1171:1: ( rule__Module__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNameAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1172:1: ( rule__Module__NameAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1172:2: rule__Module__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Module__NameAssignment_0_in_rule__Module__Group__0__Impl2511);
            rule__Module__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getNameAssignment_0()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1182:1: rule__Module__Group__1 : rule__Module__Group__1__Impl rule__Module__Group__2 ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1186:1: ( rule__Module__Group__1__Impl rule__Module__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1187:2: rule__Module__Group__1__Impl rule__Module__Group__2
            {
            pushFollow(FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__12541);
            rule__Module__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__2_in_rule__Module__Group__12544);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1194:1: rule__Module__Group__1__Impl : ( 'DEFINITIONS' ) ;
    public final void rule__Module__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1198:1: ( ( 'DEFINITIONS' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1199:1: ( 'DEFINITIONS' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1199:1: ( 'DEFINITIONS' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1200:1: 'DEFINITIONS'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getDEFINITIONSKeyword_1()); 
            }
            match(input,16,FOLLOW_16_in_rule__Module__Group__1__Impl2572); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1213:1: rule__Module__Group__2 : rule__Module__Group__2__Impl rule__Module__Group__3 ;
    public final void rule__Module__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1217:1: ( rule__Module__Group__2__Impl rule__Module__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1218:2: rule__Module__Group__2__Impl rule__Module__Group__3
            {
            pushFollow(FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__22603);
            rule__Module__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__3_in_rule__Module__Group__22606);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1225:1: rule__Module__Group__2__Impl : ( '::=' ) ;
    public final void rule__Module__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1229:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1230:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1230:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1231:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_2()); 
            }
            match(input,17,FOLLOW_17_in_rule__Module__Group__2__Impl2634); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1244:1: rule__Module__Group__3 : rule__Module__Group__3__Impl rule__Module__Group__4 ;
    public final void rule__Module__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1248:1: ( rule__Module__Group__3__Impl rule__Module__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1249:2: rule__Module__Group__3__Impl rule__Module__Group__4
            {
            pushFollow(FOLLOW_rule__Module__Group__3__Impl_in_rule__Module__Group__32665);
            rule__Module__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__4_in_rule__Module__Group__32668);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1256:1: rule__Module__Group__3__Impl : ( 'BEGIN' ) ;
    public final void rule__Module__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1260:1: ( ( 'BEGIN' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1261:1: ( 'BEGIN' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1261:1: ( 'BEGIN' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1262:1: 'BEGIN'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getBEGINKeyword_3()); 
            }
            match(input,18,FOLLOW_18_in_rule__Module__Group__3__Impl2696); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1275:1: rule__Module__Group__4 : rule__Module__Group__4__Impl rule__Module__Group__5 ;
    public final void rule__Module__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1279:1: ( rule__Module__Group__4__Impl rule__Module__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1280:2: rule__Module__Group__4__Impl rule__Module__Group__5
            {
            pushFollow(FOLLOW_rule__Module__Group__4__Impl_in_rule__Module__Group__42727);
            rule__Module__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__5_in_rule__Module__Group__42730);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1287:1: rule__Module__Group__4__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Module__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1291:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1292:1: ( RULE_NEWLINE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1292:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1293:1: RULE_NEWLINE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_4()); 
            }
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Module__Group__4__Impl2757); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_4()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1304:1: rule__Module__Group__5 : rule__Module__Group__5__Impl rule__Module__Group__6 ;
    public final void rule__Module__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1308:1: ( rule__Module__Group__5__Impl rule__Module__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1309:2: rule__Module__Group__5__Impl rule__Module__Group__6
            {
            pushFollow(FOLLOW_rule__Module__Group__5__Impl_in_rule__Module__Group__52786);
            rule__Module__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__6_in_rule__Module__Group__52789);
            rule__Module__Group__6();

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1316:1: rule__Module__Group__5__Impl : ( ( ( rule__Module__Alternatives_5 ) ) ( ( rule__Module__Alternatives_5 )* ) ) ;
    public final void rule__Module__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1320:1: ( ( ( ( rule__Module__Alternatives_5 ) ) ( ( rule__Module__Alternatives_5 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1321:1: ( ( ( rule__Module__Alternatives_5 ) ) ( ( rule__Module__Alternatives_5 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1321:1: ( ( ( rule__Module__Alternatives_5 ) ) ( ( rule__Module__Alternatives_5 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1322:1: ( ( rule__Module__Alternatives_5 ) ) ( ( rule__Module__Alternatives_5 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1322:1: ( ( rule__Module__Alternatives_5 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1323:1: ( rule__Module__Alternatives_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getAlternatives_5()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1324:1: ( rule__Module__Alternatives_5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1324:2: rule__Module__Alternatives_5
            {
            pushFollow(FOLLOW_rule__Module__Alternatives_5_in_rule__Module__Group__5__Impl2818);
            rule__Module__Alternatives_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getAlternatives_5()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1327:1: ( ( rule__Module__Alternatives_5 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1328:1: ( rule__Module__Alternatives_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getAlternatives_5()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1329:1: ( rule__Module__Alternatives_5 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NEWLINE) ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1==RULE_NEWLINE||(LA12_1>=RULE_MODULE_ID && LA12_1<=RULE_ASN1_ID)) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1329:2: rule__Module__Alternatives_5
            	    {
            	    pushFollow(FOLLOW_rule__Module__Alternatives_5_in_rule__Module__Group__5__Impl2830);
            	    rule__Module__Alternatives_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getAlternatives_5()); 
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
    // $ANTLR end "rule__Module__Group__5__Impl"


    // $ANTLR start "rule__Module__Group__6"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1340:1: rule__Module__Group__6 : rule__Module__Group__6__Impl rule__Module__Group__7 ;
    public final void rule__Module__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1344:1: ( rule__Module__Group__6__Impl rule__Module__Group__7 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1345:2: rule__Module__Group__6__Impl rule__Module__Group__7
            {
            pushFollow(FOLLOW_rule__Module__Group__6__Impl_in_rule__Module__Group__62863);
            rule__Module__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__7_in_rule__Module__Group__62866);
            rule__Module__Group__7();

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
    // $ANTLR end "rule__Module__Group__6"


    // $ANTLR start "rule__Module__Group__6__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1352:1: rule__Module__Group__6__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Module__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1356:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1357:1: ( RULE_NEWLINE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1357:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1358:1: RULE_NEWLINE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_6()); 
            }
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Module__Group__6__Impl2893); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_6()); 
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
    // $ANTLR end "rule__Module__Group__6__Impl"


    // $ANTLR start "rule__Module__Group__7"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1369:1: rule__Module__Group__7 : rule__Module__Group__7__Impl rule__Module__Group__8 ;
    public final void rule__Module__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1373:1: ( rule__Module__Group__7__Impl rule__Module__Group__8 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1374:2: rule__Module__Group__7__Impl rule__Module__Group__8
            {
            pushFollow(FOLLOW_rule__Module__Group__7__Impl_in_rule__Module__Group__72922);
            rule__Module__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__8_in_rule__Module__Group__72925);
            rule__Module__Group__8();

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
    // $ANTLR end "rule__Module__Group__7"


    // $ANTLR start "rule__Module__Group__7__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1381:1: rule__Module__Group__7__Impl : ( 'END' ) ;
    public final void rule__Module__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1385:1: ( ( 'END' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1386:1: ( 'END' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1386:1: ( 'END' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1387:1: 'END'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getENDKeyword_7()); 
            }
            match(input,19,FOLLOW_19_in_rule__Module__Group__7__Impl2953); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getENDKeyword_7()); 
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
    // $ANTLR end "rule__Module__Group__7__Impl"


    // $ANTLR start "rule__Module__Group__8"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1400:1: rule__Module__Group__8 : rule__Module__Group__8__Impl ;
    public final void rule__Module__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1404:1: ( rule__Module__Group__8__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1405:2: rule__Module__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group__8__Impl_in_rule__Module__Group__82984);
            rule__Module__Group__8__Impl();

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
    // $ANTLR end "rule__Module__Group__8"


    // $ANTLR start "rule__Module__Group__8__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1411:1: rule__Module__Group__8__Impl : ( ( RULE_NEWLINE )* ) ;
    public final void rule__Module__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1415:1: ( ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1416:1: ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1416:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1417:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_8()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1418:1: ( RULE_NEWLINE )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_NEWLINE) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1418:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Module__Group__8__Impl3012); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_8()); 
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
    // $ANTLR end "rule__Module__Group__8__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1446:1: rule__ObjectIdentifier__Group__0 : rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1 ;
    public final void rule__ObjectIdentifier__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1450:1: ( rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1451:2: rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__0__Impl_in_rule__ObjectIdentifier__Group__03061);
            rule__ObjectIdentifier__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__1_in_rule__ObjectIdentifier__Group__03064);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1458:1: rule__ObjectIdentifier__Group__0__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__ObjectIdentifier__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1462:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1463:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1463:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1464:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1464:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1465:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1466:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1466:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ObjectIdentifier__Group__0__Impl3094); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getNEWLINETerminalRuleCall_0()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1469:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1470:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1471:1: ( RULE_NEWLINE )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_NEWLINE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1471:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ObjectIdentifier__Group__0__Impl3107); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getNEWLINETerminalRuleCall_0()); 
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
    // $ANTLR end "rule__ObjectIdentifier__Group__0__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1482:1: rule__ObjectIdentifier__Group__1 : rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2 ;
    public final void rule__ObjectIdentifier__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1486:1: ( rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1487:2: rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__1__Impl_in_rule__ObjectIdentifier__Group__13140);
            rule__ObjectIdentifier__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__2_in_rule__ObjectIdentifier__Group__13143);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1494:1: rule__ObjectIdentifier__Group__1__Impl : ( ( rule__ObjectIdentifier__NameAssignment_1 ) ) ;
    public final void rule__ObjectIdentifier__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1498:1: ( ( ( rule__ObjectIdentifier__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1499:1: ( ( rule__ObjectIdentifier__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1499:1: ( ( rule__ObjectIdentifier__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1500:1: ( rule__ObjectIdentifier__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1501:1: ( rule__ObjectIdentifier__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1501:2: rule__ObjectIdentifier__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__NameAssignment_1_in_rule__ObjectIdentifier__Group__1__Impl3170);
            rule__ObjectIdentifier__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getNameAssignment_1()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1511:1: rule__ObjectIdentifier__Group__2 : rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3 ;
    public final void rule__ObjectIdentifier__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1515:1: ( rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1516:2: rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__2__Impl_in_rule__ObjectIdentifier__Group__23200);
            rule__ObjectIdentifier__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__3_in_rule__ObjectIdentifier__Group__23203);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1523:1: rule__ObjectIdentifier__Group__2__Impl : ( 'OBJECT IDENTIFIER' ) ;
    public final void rule__ObjectIdentifier__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1527:1: ( ( 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1528:1: ( 'OBJECT IDENTIFIER' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1528:1: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1529:1: 'OBJECT IDENTIFIER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_2()); 
            }
            match(input,20,FOLLOW_20_in_rule__ObjectIdentifier__Group__2__Impl3231); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_2()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1542:1: rule__ObjectIdentifier__Group__3 : rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4 ;
    public final void rule__ObjectIdentifier__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1546:1: ( rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1547:2: rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__3__Impl_in_rule__ObjectIdentifier__Group__33262);
            rule__ObjectIdentifier__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__4_in_rule__ObjectIdentifier__Group__33265);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1554:1: rule__ObjectIdentifier__Group__3__Impl : ( '::=' ) ;
    public final void rule__ObjectIdentifier__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1558:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1559:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1559:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1560:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_3()); 
            }
            match(input,17,FOLLOW_17_in_rule__ObjectIdentifier__Group__3__Impl3293); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_3()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1573:1: rule__ObjectIdentifier__Group__4 : rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5 ;
    public final void rule__ObjectIdentifier__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1577:1: ( rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1578:2: rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__4__Impl_in_rule__ObjectIdentifier__Group__43324);
            rule__ObjectIdentifier__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__5_in_rule__ObjectIdentifier__Group__43327);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1585:1: rule__ObjectIdentifier__Group__4__Impl : ( '{' ) ;
    public final void rule__ObjectIdentifier__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1589:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1590:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1590:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1591:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,21,FOLLOW_21_in_rule__ObjectIdentifier__Group__4__Impl3355); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_4()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1604:1: rule__ObjectIdentifier__Group__5 : rule__ObjectIdentifier__Group__5__Impl rule__ObjectIdentifier__Group__6 ;
    public final void rule__ObjectIdentifier__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1608:1: ( rule__ObjectIdentifier__Group__5__Impl rule__ObjectIdentifier__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1609:2: rule__ObjectIdentifier__Group__5__Impl rule__ObjectIdentifier__Group__6
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__5__Impl_in_rule__ObjectIdentifier__Group__53386);
            rule__ObjectIdentifier__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__6_in_rule__ObjectIdentifier__Group__53389);
            rule__ObjectIdentifier__Group__6();

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1616:1: rule__ObjectIdentifier__Group__5__Impl : ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) ) ;
    public final void rule__ObjectIdentifier__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1620:1: ( ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1621:1: ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1621:1: ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1622:1: ( rule__ObjectIdentifier__OidValueAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOidValueAssignment_5()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1623:1: ( rule__ObjectIdentifier__OidValueAssignment_5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1623:2: rule__ObjectIdentifier__OidValueAssignment_5
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__OidValueAssignment_5_in_rule__ObjectIdentifier__Group__5__Impl3416);
            rule__ObjectIdentifier__OidValueAssignment_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getOidValueAssignment_5()); 
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


    // $ANTLR start "rule__ObjectIdentifier__Group__6"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1633:1: rule__ObjectIdentifier__Group__6 : rule__ObjectIdentifier__Group__6__Impl ;
    public final void rule__ObjectIdentifier__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1637:1: ( rule__ObjectIdentifier__Group__6__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1638:2: rule__ObjectIdentifier__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__6__Impl_in_rule__ObjectIdentifier__Group__63446);
            rule__ObjectIdentifier__Group__6__Impl();

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
    // $ANTLR end "rule__ObjectIdentifier__Group__6"


    // $ANTLR start "rule__ObjectIdentifier__Group__6__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1644:1: rule__ObjectIdentifier__Group__6__Impl : ( '}' ) ;
    public final void rule__ObjectIdentifier__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1648:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1649:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1649:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1650:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,22,FOLLOW_22_in_rule__ObjectIdentifier__Group__6__Impl3474); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getRightCurlyBracketKeyword_6()); 
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
    // $ANTLR end "rule__ObjectIdentifier__Group__6__Impl"


    // $ANTLR start "rule__ObjectIdentifierValue__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1677:1: rule__ObjectIdentifierValue__Group__0 : rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1 ;
    public final void rule__ObjectIdentifierValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1681:1: ( rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1682:2: rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__0__Impl_in_rule__ObjectIdentifierValue__Group__03519);
            rule__ObjectIdentifierValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__1_in_rule__ObjectIdentifierValue__Group__03522);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1689:1: rule__ObjectIdentifierValue__Group__0__Impl : ( ( rule__ObjectIdentifierValue__Alternatives_0 )? ) ;
    public final void rule__ObjectIdentifierValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1693:1: ( ( ( rule__ObjectIdentifierValue__Alternatives_0 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1694:1: ( ( rule__ObjectIdentifierValue__Alternatives_0 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1694:1: ( ( rule__ObjectIdentifierValue__Alternatives_0 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1695:1: ( rule__ObjectIdentifierValue__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getAlternatives_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1696:1: ( rule__ObjectIdentifierValue__Alternatives_0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ASN1_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1696:2: rule__ObjectIdentifierValue__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__Alternatives_0_in_rule__ObjectIdentifierValue__Group__0__Impl3549);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1706:1: rule__ObjectIdentifierValue__Group__1 : rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2 ;
    public final void rule__ObjectIdentifierValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1710:1: ( rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1711:2: rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__1__Impl_in_rule__ObjectIdentifierValue__Group__13580);
            rule__ObjectIdentifierValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__2_in_rule__ObjectIdentifierValue__Group__13583);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1718:1: rule__ObjectIdentifierValue__Group__1__Impl : ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) ) ;
    public final void rule__ObjectIdentifierValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1722:1: ( ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1723:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1723:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1724:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1725:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1725:2: rule__ObjectIdentifierValue__SubIdsAssignment_1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_1_in_rule__ObjectIdentifierValue__Group__1__Impl3610);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1735:1: rule__ObjectIdentifierValue__Group__2 : rule__ObjectIdentifierValue__Group__2__Impl ;
    public final void rule__ObjectIdentifierValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1739:1: ( rule__ObjectIdentifierValue__Group__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1740:2: rule__ObjectIdentifierValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__2__Impl_in_rule__ObjectIdentifierValue__Group__23640);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1746:1: rule__ObjectIdentifierValue__Group__2__Impl : ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* ) ;
    public final void rule__ObjectIdentifierValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1750:1: ( ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1751:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1751:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1752:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1753:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_BIG_INTEGER) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1753:2: rule__ObjectIdentifierValue__SubIdsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_2_in_rule__ObjectIdentifierValue__Group__2__Impl3667);
            	    rule__ObjectIdentifierValue__SubIdsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1769:1: rule__TypeDefinition__Group__0 : rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1 ;
    public final void rule__TypeDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1773:1: ( rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1774:2: rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__0__Impl_in_rule__TypeDefinition__Group__03704);
            rule__TypeDefinition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeDefinition__Group__1_in_rule__TypeDefinition__Group__03707);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1781:1: rule__TypeDefinition__Group__0__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__TypeDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1785:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1786:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1786:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1787:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1787:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1788:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1789:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1789:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__TypeDefinition__Group__0__Impl3737); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1792:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1793:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1794:1: ( RULE_NEWLINE )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_NEWLINE) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1794:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__TypeDefinition__Group__0__Impl3750); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0()); 
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
    // $ANTLR end "rule__TypeDefinition__Group__0__Impl"


    // $ANTLR start "rule__TypeDefinition__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1805:1: rule__TypeDefinition__Group__1 : rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2 ;
    public final void rule__TypeDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1809:1: ( rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1810:2: rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__1__Impl_in_rule__TypeDefinition__Group__13783);
            rule__TypeDefinition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeDefinition__Group__2_in_rule__TypeDefinition__Group__13786);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1817:1: rule__TypeDefinition__Group__1__Impl : ( ( rule__TypeDefinition__NameAssignment_1 ) ) ;
    public final void rule__TypeDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1821:1: ( ( ( rule__TypeDefinition__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1822:1: ( ( rule__TypeDefinition__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1822:1: ( ( rule__TypeDefinition__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1823:1: ( rule__TypeDefinition__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1824:1: ( rule__TypeDefinition__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1824:2: rule__TypeDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeDefinition__NameAssignment_1_in_rule__TypeDefinition__Group__1__Impl3813);
            rule__TypeDefinition__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getNameAssignment_1()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1834:1: rule__TypeDefinition__Group__2 : rule__TypeDefinition__Group__2__Impl rule__TypeDefinition__Group__3 ;
    public final void rule__TypeDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1838:1: ( rule__TypeDefinition__Group__2__Impl rule__TypeDefinition__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1839:2: rule__TypeDefinition__Group__2__Impl rule__TypeDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__2__Impl_in_rule__TypeDefinition__Group__23843);
            rule__TypeDefinition__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeDefinition__Group__3_in_rule__TypeDefinition__Group__23846);
            rule__TypeDefinition__Group__3();

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1846:1: rule__TypeDefinition__Group__2__Impl : ( '::=' ) ;
    public final void rule__TypeDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1850:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1851:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1851:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1852:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getColonColonEqualsSignKeyword_2()); 
            }
            match(input,17,FOLLOW_17_in_rule__TypeDefinition__Group__2__Impl3874); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getColonColonEqualsSignKeyword_2()); 
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


    // $ANTLR start "rule__TypeDefinition__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1865:1: rule__TypeDefinition__Group__3 : rule__TypeDefinition__Group__3__Impl ;
    public final void rule__TypeDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1869:1: ( rule__TypeDefinition__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1870:2: rule__TypeDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__3__Impl_in_rule__TypeDefinition__Group__33905);
            rule__TypeDefinition__Group__3__Impl();

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
    // $ANTLR end "rule__TypeDefinition__Group__3"


    // $ANTLR start "rule__TypeDefinition__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1876:1: rule__TypeDefinition__Group__3__Impl : ( ( ( rule__TypeDefinition__ValuesAssignment_3 ) ) ( ( rule__TypeDefinition__ValuesAssignment_3 )* ) ) ;
    public final void rule__TypeDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1880:1: ( ( ( ( rule__TypeDefinition__ValuesAssignment_3 ) ) ( ( rule__TypeDefinition__ValuesAssignment_3 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1881:1: ( ( ( rule__TypeDefinition__ValuesAssignment_3 ) ) ( ( rule__TypeDefinition__ValuesAssignment_3 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1881:1: ( ( ( rule__TypeDefinition__ValuesAssignment_3 ) ) ( ( rule__TypeDefinition__ValuesAssignment_3 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1882:1: ( ( rule__TypeDefinition__ValuesAssignment_3 ) ) ( ( rule__TypeDefinition__ValuesAssignment_3 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1882:1: ( ( rule__TypeDefinition__ValuesAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1883:1: ( rule__TypeDefinition__ValuesAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getValuesAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1884:1: ( rule__TypeDefinition__ValuesAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1884:2: rule__TypeDefinition__ValuesAssignment_3
            {
            pushFollow(FOLLOW_rule__TypeDefinition__ValuesAssignment_3_in_rule__TypeDefinition__Group__3__Impl3934);
            rule__TypeDefinition__ValuesAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getValuesAssignment_3()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1887:1: ( ( rule__TypeDefinition__ValuesAssignment_3 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1888:1: ( rule__TypeDefinition__ValuesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getValuesAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1889:1: ( rule__TypeDefinition__ValuesAssignment_3 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_NEWLINE) ) {
                    int LA18_2 = input.LA(2);

                    if ( (LA18_2==RULE_IA5STRING||LA18_2==RULE_PARAMETER||LA18_2==20||LA18_2==25||LA18_2==27||LA18_2==32||LA18_2==35||LA18_2==39||(LA18_2>=41 && LA18_2<=42)) ) {
                        alt18=1;
                    }
                    else if ( (LA18_2==RULE_MODULE_ID) ) {
                        int LA18_4 = input.LA(3);

                        if ( (LA18_4==EOF||(LA18_4>=RULE_NEWLINE && LA18_4<=RULE_MODULE_ID)||LA18_4==RULE_PARAMETER||LA18_4==20||(LA18_4>=24 && LA18_4<=25)||LA18_4==27||LA18_4==32||LA18_4==35||LA18_4==39||(LA18_4>=41 && LA18_4<=42)) ) {
                            alt18=1;
                        }


                    }


                }
                else if ( ((LA18_0>=RULE_IA5STRING && LA18_0<=RULE_MODULE_ID)||LA18_0==RULE_PARAMETER||LA18_0==20||LA18_0==25||LA18_0==27||LA18_0==32||LA18_0==35||LA18_0==39||(LA18_0>=41 && LA18_0<=42)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1889:2: rule__TypeDefinition__ValuesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__TypeDefinition__ValuesAssignment_3_in_rule__TypeDefinition__Group__3__Impl3946);
            	    rule__TypeDefinition__ValuesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getValuesAssignment_3()); 
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
    // $ANTLR end "rule__TypeDefinition__Group__3__Impl"


    // $ANTLR start "rule__Macro__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1908:1: rule__Macro__Group__0 : rule__Macro__Group__0__Impl rule__Macro__Group__1 ;
    public final void rule__Macro__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1912:1: ( rule__Macro__Group__0__Impl rule__Macro__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1913:2: rule__Macro__Group__0__Impl rule__Macro__Group__1
            {
            pushFollow(FOLLOW_rule__Macro__Group__0__Impl_in_rule__Macro__Group__03987);
            rule__Macro__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__1_in_rule__Macro__Group__03990);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1920:1: rule__Macro__Group__0__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__Macro__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1924:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1925:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1925:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1926:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1926:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1927:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1928:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1928:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__0__Impl4020); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1931:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1932:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1933:1: ( RULE_NEWLINE )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_NEWLINE) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1933:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__0__Impl4033); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0()); 
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
    // $ANTLR end "rule__Macro__Group__0__Impl"


    // $ANTLR start "rule__Macro__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1944:1: rule__Macro__Group__1 : rule__Macro__Group__1__Impl rule__Macro__Group__2 ;
    public final void rule__Macro__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1948:1: ( rule__Macro__Group__1__Impl rule__Macro__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1949:2: rule__Macro__Group__1__Impl rule__Macro__Group__2
            {
            pushFollow(FOLLOW_rule__Macro__Group__1__Impl_in_rule__Macro__Group__14066);
            rule__Macro__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__2_in_rule__Macro__Group__14069);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1956:1: rule__Macro__Group__1__Impl : ( ( rule__Macro__NameAssignment_1 ) ) ;
    public final void rule__Macro__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1960:1: ( ( ( rule__Macro__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1961:1: ( ( rule__Macro__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1961:1: ( ( rule__Macro__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1962:1: ( rule__Macro__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1963:1: ( rule__Macro__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1963:2: rule__Macro__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Macro__NameAssignment_1_in_rule__Macro__Group__1__Impl4096);
            rule__Macro__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNameAssignment_1()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1973:1: rule__Macro__Group__2 : rule__Macro__Group__2__Impl rule__Macro__Group__3 ;
    public final void rule__Macro__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1977:1: ( rule__Macro__Group__2__Impl rule__Macro__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1978:2: rule__Macro__Group__2__Impl rule__Macro__Group__3
            {
            pushFollow(FOLLOW_rule__Macro__Group__2__Impl_in_rule__Macro__Group__24126);
            rule__Macro__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__3_in_rule__Macro__Group__24129);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1985:1: rule__Macro__Group__2__Impl : ( 'MACRO' ) ;
    public final void rule__Macro__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1989:1: ( ( 'MACRO' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1990:1: ( 'MACRO' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1990:1: ( 'MACRO' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1991:1: 'MACRO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getMACROKeyword_2()); 
            }
            match(input,23,FOLLOW_23_in_rule__Macro__Group__2__Impl4157); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getMACROKeyword_2()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2004:1: rule__Macro__Group__3 : rule__Macro__Group__3__Impl rule__Macro__Group__4 ;
    public final void rule__Macro__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2008:1: ( rule__Macro__Group__3__Impl rule__Macro__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2009:2: rule__Macro__Group__3__Impl rule__Macro__Group__4
            {
            pushFollow(FOLLOW_rule__Macro__Group__3__Impl_in_rule__Macro__Group__34188);
            rule__Macro__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__4_in_rule__Macro__Group__34191);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2016:1: rule__Macro__Group__3__Impl : ( '::=' ) ;
    public final void rule__Macro__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2020:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2021:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2021:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2022:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_3()); 
            }
            match(input,17,FOLLOW_17_in_rule__Macro__Group__3__Impl4219); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_3()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2035:1: rule__Macro__Group__4 : rule__Macro__Group__4__Impl rule__Macro__Group__5 ;
    public final void rule__Macro__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2039:1: ( rule__Macro__Group__4__Impl rule__Macro__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2040:2: rule__Macro__Group__4__Impl rule__Macro__Group__5
            {
            pushFollow(FOLLOW_rule__Macro__Group__4__Impl_in_rule__Macro__Group__44250);
            rule__Macro__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__5_in_rule__Macro__Group__44253);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2047:1: rule__Macro__Group__4__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Macro__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2051:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2052:1: ( RULE_NEWLINE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2052:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2053:1: RULE_NEWLINE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_4()); 
            }
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__4__Impl4280); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_4()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2064:1: rule__Macro__Group__5 : rule__Macro__Group__5__Impl rule__Macro__Group__6 ;
    public final void rule__Macro__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2068:1: ( rule__Macro__Group__5__Impl rule__Macro__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2069:2: rule__Macro__Group__5__Impl rule__Macro__Group__6
            {
            pushFollow(FOLLOW_rule__Macro__Group__5__Impl_in_rule__Macro__Group__54309);
            rule__Macro__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__6_in_rule__Macro__Group__54312);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2076:1: rule__Macro__Group__5__Impl : ( 'BEGIN' ) ;
    public final void rule__Macro__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2080:1: ( ( 'BEGIN' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2081:1: ( 'BEGIN' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2081:1: ( 'BEGIN' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2082:1: 'BEGIN'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getBEGINKeyword_5()); 
            }
            match(input,18,FOLLOW_18_in_rule__Macro__Group__5__Impl4340); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getBEGINKeyword_5()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2095:1: rule__Macro__Group__6 : rule__Macro__Group__6__Impl rule__Macro__Group__7 ;
    public final void rule__Macro__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2099:1: ( rule__Macro__Group__6__Impl rule__Macro__Group__7 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2100:2: rule__Macro__Group__6__Impl rule__Macro__Group__7
            {
            pushFollow(FOLLOW_rule__Macro__Group__6__Impl_in_rule__Macro__Group__64371);
            rule__Macro__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__7_in_rule__Macro__Group__64374);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2107:1: rule__Macro__Group__6__Impl : ( ( rule__Macro__TypeNotationAssignment_6 ) ) ;
    public final void rule__Macro__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2111:1: ( ( ( rule__Macro__TypeNotationAssignment_6 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2112:1: ( ( rule__Macro__TypeNotationAssignment_6 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2112:1: ( ( rule__Macro__TypeNotationAssignment_6 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2113:1: ( rule__Macro__TypeNotationAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTypeNotationAssignment_6()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2114:1: ( rule__Macro__TypeNotationAssignment_6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2114:2: rule__Macro__TypeNotationAssignment_6
            {
            pushFollow(FOLLOW_rule__Macro__TypeNotationAssignment_6_in_rule__Macro__Group__6__Impl4401);
            rule__Macro__TypeNotationAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getTypeNotationAssignment_6()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2124:1: rule__Macro__Group__7 : rule__Macro__Group__7__Impl rule__Macro__Group__8 ;
    public final void rule__Macro__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2128:1: ( rule__Macro__Group__7__Impl rule__Macro__Group__8 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2129:2: rule__Macro__Group__7__Impl rule__Macro__Group__8
            {
            pushFollow(FOLLOW_rule__Macro__Group__7__Impl_in_rule__Macro__Group__74431);
            rule__Macro__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__8_in_rule__Macro__Group__74434);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2136:1: rule__Macro__Group__7__Impl : ( ( rule__Macro__ValueNotationAssignment_7 ) ) ;
    public final void rule__Macro__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2140:1: ( ( ( rule__Macro__ValueNotationAssignment_7 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2141:1: ( ( rule__Macro__ValueNotationAssignment_7 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2141:1: ( ( rule__Macro__ValueNotationAssignment_7 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2142:1: ( rule__Macro__ValueNotationAssignment_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getValueNotationAssignment_7()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2143:1: ( rule__Macro__ValueNotationAssignment_7 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2143:2: rule__Macro__ValueNotationAssignment_7
            {
            pushFollow(FOLLOW_rule__Macro__ValueNotationAssignment_7_in_rule__Macro__Group__7__Impl4461);
            rule__Macro__ValueNotationAssignment_7();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getValueNotationAssignment_7()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2153:1: rule__Macro__Group__8 : rule__Macro__Group__8__Impl rule__Macro__Group__9 ;
    public final void rule__Macro__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2157:1: ( rule__Macro__Group__8__Impl rule__Macro__Group__9 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2158:2: rule__Macro__Group__8__Impl rule__Macro__Group__9
            {
            pushFollow(FOLLOW_rule__Macro__Group__8__Impl_in_rule__Macro__Group__84491);
            rule__Macro__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__9_in_rule__Macro__Group__84494);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2165:1: rule__Macro__Group__8__Impl : ( ( ( rule__Macro__InnerTypesAssignment_8 ) ) ( ( rule__Macro__InnerTypesAssignment_8 )* ) ) ;
    public final void rule__Macro__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2169:1: ( ( ( ( rule__Macro__InnerTypesAssignment_8 ) ) ( ( rule__Macro__InnerTypesAssignment_8 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2170:1: ( ( ( rule__Macro__InnerTypesAssignment_8 ) ) ( ( rule__Macro__InnerTypesAssignment_8 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2170:1: ( ( ( rule__Macro__InnerTypesAssignment_8 ) ) ( ( rule__Macro__InnerTypesAssignment_8 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2171:1: ( ( rule__Macro__InnerTypesAssignment_8 ) ) ( ( rule__Macro__InnerTypesAssignment_8 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2171:1: ( ( rule__Macro__InnerTypesAssignment_8 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2172:1: ( rule__Macro__InnerTypesAssignment_8 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesAssignment_8()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2173:1: ( rule__Macro__InnerTypesAssignment_8 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2173:2: rule__Macro__InnerTypesAssignment_8
            {
            pushFollow(FOLLOW_rule__Macro__InnerTypesAssignment_8_in_rule__Macro__Group__8__Impl4523);
            rule__Macro__InnerTypesAssignment_8();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesAssignment_8()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2176:1: ( ( rule__Macro__InnerTypesAssignment_8 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2177:1: ( rule__Macro__InnerTypesAssignment_8 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesAssignment_8()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2178:1: ( rule__Macro__InnerTypesAssignment_8 )*
            loop20:
            do {
                int alt20=2;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2178:2: rule__Macro__InnerTypesAssignment_8
            	    {
            	    pushFollow(FOLLOW_rule__Macro__InnerTypesAssignment_8_in_rule__Macro__Group__8__Impl4535);
            	    rule__Macro__InnerTypesAssignment_8();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesAssignment_8()); 
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
    // $ANTLR end "rule__Macro__Group__8__Impl"


    // $ANTLR start "rule__Macro__Group__9"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2189:1: rule__Macro__Group__9 : rule__Macro__Group__9__Impl rule__Macro__Group__10 ;
    public final void rule__Macro__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2193:1: ( rule__Macro__Group__9__Impl rule__Macro__Group__10 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2194:2: rule__Macro__Group__9__Impl rule__Macro__Group__10
            {
            pushFollow(FOLLOW_rule__Macro__Group__9__Impl_in_rule__Macro__Group__94568);
            rule__Macro__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__10_in_rule__Macro__Group__94571);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2201:1: rule__Macro__Group__9__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__Macro__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2205:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2206:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2206:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2207:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2207:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2208:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_9()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2209:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2209:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__9__Impl4601); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_9()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2212:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2213:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_9()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2214:1: ( RULE_NEWLINE )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_NEWLINE) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2214:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__9__Impl4614); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_9()); 
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
    // $ANTLR end "rule__Macro__Group__9__Impl"


    // $ANTLR start "rule__Macro__Group__10"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2225:1: rule__Macro__Group__10 : rule__Macro__Group__10__Impl ;
    public final void rule__Macro__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2229:1: ( rule__Macro__Group__10__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2230:2: rule__Macro__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__Macro__Group__10__Impl_in_rule__Macro__Group__104647);
            rule__Macro__Group__10__Impl();

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2236:1: rule__Macro__Group__10__Impl : ( 'END' ) ;
    public final void rule__Macro__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2240:1: ( ( 'END' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2241:1: ( 'END' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2241:1: ( 'END' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2242:1: 'END'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getENDKeyword_10()); 
            }
            match(input,19,FOLLOW_19_in_rule__Macro__Group__10__Impl4675); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getENDKeyword_10()); 
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


    // $ANTLR start "rule__TypeNotation__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2277:1: rule__TypeNotation__Group__0 : rule__TypeNotation__Group__0__Impl rule__TypeNotation__Group__1 ;
    public final void rule__TypeNotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2281:1: ( rule__TypeNotation__Group__0__Impl rule__TypeNotation__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2282:2: rule__TypeNotation__Group__0__Impl rule__TypeNotation__Group__1
            {
            pushFollow(FOLLOW_rule__TypeNotation__Group__0__Impl_in_rule__TypeNotation__Group__04728);
            rule__TypeNotation__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeNotation__Group__1_in_rule__TypeNotation__Group__04731);
            rule__TypeNotation__Group__1();

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
    // $ANTLR end "rule__TypeNotation__Group__0"


    // $ANTLR start "rule__TypeNotation__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2289:1: rule__TypeNotation__Group__0__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__TypeNotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2293:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2294:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2294:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2295:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2295:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2296:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2297:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2297:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__TypeNotation__Group__0__Impl4761); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getNEWLINETerminalRuleCall_0()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2300:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2301:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2302:1: ( RULE_NEWLINE )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_NEWLINE) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2302:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__TypeNotation__Group__0__Impl4774); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getNEWLINETerminalRuleCall_0()); 
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
    // $ANTLR end "rule__TypeNotation__Group__0__Impl"


    // $ANTLR start "rule__TypeNotation__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2313:1: rule__TypeNotation__Group__1 : rule__TypeNotation__Group__1__Impl rule__TypeNotation__Group__2 ;
    public final void rule__TypeNotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2317:1: ( rule__TypeNotation__Group__1__Impl rule__TypeNotation__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2318:2: rule__TypeNotation__Group__1__Impl rule__TypeNotation__Group__2
            {
            pushFollow(FOLLOW_rule__TypeNotation__Group__1__Impl_in_rule__TypeNotation__Group__14807);
            rule__TypeNotation__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeNotation__Group__2_in_rule__TypeNotation__Group__14810);
            rule__TypeNotation__Group__2();

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
    // $ANTLR end "rule__TypeNotation__Group__1"


    // $ANTLR start "rule__TypeNotation__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2325:1: rule__TypeNotation__Group__1__Impl : ( ( rule__TypeNotation__NameAssignment_1 ) ) ;
    public final void rule__TypeNotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2329:1: ( ( ( rule__TypeNotation__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2330:1: ( ( rule__TypeNotation__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2330:1: ( ( rule__TypeNotation__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2331:1: ( rule__TypeNotation__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2332:1: ( rule__TypeNotation__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2332:2: rule__TypeNotation__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeNotation__NameAssignment_1_in_rule__TypeNotation__Group__1__Impl4837);
            rule__TypeNotation__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getNameAssignment_1()); 
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
    // $ANTLR end "rule__TypeNotation__Group__1__Impl"


    // $ANTLR start "rule__TypeNotation__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2342:1: rule__TypeNotation__Group__2 : rule__TypeNotation__Group__2__Impl rule__TypeNotation__Group__3 ;
    public final void rule__TypeNotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2346:1: ( rule__TypeNotation__Group__2__Impl rule__TypeNotation__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2347:2: rule__TypeNotation__Group__2__Impl rule__TypeNotation__Group__3
            {
            pushFollow(FOLLOW_rule__TypeNotation__Group__2__Impl_in_rule__TypeNotation__Group__24867);
            rule__TypeNotation__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeNotation__Group__3_in_rule__TypeNotation__Group__24870);
            rule__TypeNotation__Group__3();

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
    // $ANTLR end "rule__TypeNotation__Group__2"


    // $ANTLR start "rule__TypeNotation__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2354:1: rule__TypeNotation__Group__2__Impl : ( '::=' ) ;
    public final void rule__TypeNotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2358:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2359:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2359:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2360:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getColonColonEqualsSignKeyword_2()); 
            }
            match(input,17,FOLLOW_17_in_rule__TypeNotation__Group__2__Impl4898); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getColonColonEqualsSignKeyword_2()); 
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
    // $ANTLR end "rule__TypeNotation__Group__2__Impl"


    // $ANTLR start "rule__TypeNotation__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2373:1: rule__TypeNotation__Group__3 : rule__TypeNotation__Group__3__Impl ;
    public final void rule__TypeNotation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2377:1: ( rule__TypeNotation__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2378:2: rule__TypeNotation__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TypeNotation__Group__3__Impl_in_rule__TypeNotation__Group__34929);
            rule__TypeNotation__Group__3__Impl();

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
    // $ANTLR end "rule__TypeNotation__Group__3"


    // $ANTLR start "rule__TypeNotation__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2384:1: rule__TypeNotation__Group__3__Impl : ( ( ( rule__TypeNotation__TypeNotationsAssignment_3 ) ) ( ( rule__TypeNotation__TypeNotationsAssignment_3 )* ) ) ;
    public final void rule__TypeNotation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2388:1: ( ( ( ( rule__TypeNotation__TypeNotationsAssignment_3 ) ) ( ( rule__TypeNotation__TypeNotationsAssignment_3 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2389:1: ( ( ( rule__TypeNotation__TypeNotationsAssignment_3 ) ) ( ( rule__TypeNotation__TypeNotationsAssignment_3 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2389:1: ( ( ( rule__TypeNotation__TypeNotationsAssignment_3 ) ) ( ( rule__TypeNotation__TypeNotationsAssignment_3 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2390:1: ( ( rule__TypeNotation__TypeNotationsAssignment_3 ) ) ( ( rule__TypeNotation__TypeNotationsAssignment_3 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2390:1: ( ( rule__TypeNotation__TypeNotationsAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2391:1: ( rule__TypeNotation__TypeNotationsAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getTypeNotationsAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2392:1: ( rule__TypeNotation__TypeNotationsAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2392:2: rule__TypeNotation__TypeNotationsAssignment_3
            {
            pushFollow(FOLLOW_rule__TypeNotation__TypeNotationsAssignment_3_in_rule__TypeNotation__Group__3__Impl4958);
            rule__TypeNotation__TypeNotationsAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getTypeNotationsAssignment_3()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2395:1: ( ( rule__TypeNotation__TypeNotationsAssignment_3 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2396:1: ( rule__TypeNotation__TypeNotationsAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getTypeNotationsAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2397:1: ( rule__TypeNotation__TypeNotationsAssignment_3 )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2397:2: rule__TypeNotation__TypeNotationsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__TypeNotation__TypeNotationsAssignment_3_in_rule__TypeNotation__Group__3__Impl4970);
            	    rule__TypeNotation__TypeNotationsAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getTypeNotationsAssignment_3()); 
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
    // $ANTLR end "rule__TypeNotation__Group__3__Impl"


    // $ANTLR start "rule__ValueNotation__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2416:1: rule__ValueNotation__Group__0 : rule__ValueNotation__Group__0__Impl rule__ValueNotation__Group__1 ;
    public final void rule__ValueNotation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2420:1: ( rule__ValueNotation__Group__0__Impl rule__ValueNotation__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2421:2: rule__ValueNotation__Group__0__Impl rule__ValueNotation__Group__1
            {
            pushFollow(FOLLOW_rule__ValueNotation__Group__0__Impl_in_rule__ValueNotation__Group__05011);
            rule__ValueNotation__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ValueNotation__Group__1_in_rule__ValueNotation__Group__05014);
            rule__ValueNotation__Group__1();

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
    // $ANTLR end "rule__ValueNotation__Group__0"


    // $ANTLR start "rule__ValueNotation__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2428:1: rule__ValueNotation__Group__0__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__ValueNotation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2432:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2433:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2433:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2434:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2434:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2435:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueNotationAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2436:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2436:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ValueNotation__Group__0__Impl5044); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueNotationAccess().getNEWLINETerminalRuleCall_0()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2439:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2440:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueNotationAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2441:1: ( RULE_NEWLINE )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_NEWLINE) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2441:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ValueNotation__Group__0__Impl5057); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueNotationAccess().getNEWLINETerminalRuleCall_0()); 
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
    // $ANTLR end "rule__ValueNotation__Group__0__Impl"


    // $ANTLR start "rule__ValueNotation__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2452:1: rule__ValueNotation__Group__1 : rule__ValueNotation__Group__1__Impl rule__ValueNotation__Group__2 ;
    public final void rule__ValueNotation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2456:1: ( rule__ValueNotation__Group__1__Impl rule__ValueNotation__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2457:2: rule__ValueNotation__Group__1__Impl rule__ValueNotation__Group__2
            {
            pushFollow(FOLLOW_rule__ValueNotation__Group__1__Impl_in_rule__ValueNotation__Group__15090);
            rule__ValueNotation__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ValueNotation__Group__2_in_rule__ValueNotation__Group__15093);
            rule__ValueNotation__Group__2();

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
    // $ANTLR end "rule__ValueNotation__Group__1"


    // $ANTLR start "rule__ValueNotation__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2464:1: rule__ValueNotation__Group__1__Impl : ( ( rule__ValueNotation__NameAssignment_1 ) ) ;
    public final void rule__ValueNotation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2468:1: ( ( ( rule__ValueNotation__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2469:1: ( ( rule__ValueNotation__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2469:1: ( ( rule__ValueNotation__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2470:1: ( rule__ValueNotation__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueNotationAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2471:1: ( rule__ValueNotation__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2471:2: rule__ValueNotation__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ValueNotation__NameAssignment_1_in_rule__ValueNotation__Group__1__Impl5120);
            rule__ValueNotation__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueNotationAccess().getNameAssignment_1()); 
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
    // $ANTLR end "rule__ValueNotation__Group__1__Impl"


    // $ANTLR start "rule__ValueNotation__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2481:1: rule__ValueNotation__Group__2 : rule__ValueNotation__Group__2__Impl rule__ValueNotation__Group__3 ;
    public final void rule__ValueNotation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2485:1: ( rule__ValueNotation__Group__2__Impl rule__ValueNotation__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2486:2: rule__ValueNotation__Group__2__Impl rule__ValueNotation__Group__3
            {
            pushFollow(FOLLOW_rule__ValueNotation__Group__2__Impl_in_rule__ValueNotation__Group__25150);
            rule__ValueNotation__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ValueNotation__Group__3_in_rule__ValueNotation__Group__25153);
            rule__ValueNotation__Group__3();

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
    // $ANTLR end "rule__ValueNotation__Group__2"


    // $ANTLR start "rule__ValueNotation__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2493:1: rule__ValueNotation__Group__2__Impl : ( '::=' ) ;
    public final void rule__ValueNotation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2497:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2498:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2498:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2499:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueNotationAccess().getColonColonEqualsSignKeyword_2()); 
            }
            match(input,17,FOLLOW_17_in_rule__ValueNotation__Group__2__Impl5181); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueNotationAccess().getColonColonEqualsSignKeyword_2()); 
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
    // $ANTLR end "rule__ValueNotation__Group__2__Impl"


    // $ANTLR start "rule__ValueNotation__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2512:1: rule__ValueNotation__Group__3 : rule__ValueNotation__Group__3__Impl rule__ValueNotation__Group__4 ;
    public final void rule__ValueNotation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2516:1: ( rule__ValueNotation__Group__3__Impl rule__ValueNotation__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2517:2: rule__ValueNotation__Group__3__Impl rule__ValueNotation__Group__4
            {
            pushFollow(FOLLOW_rule__ValueNotation__Group__3__Impl_in_rule__ValueNotation__Group__35212);
            rule__ValueNotation__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ValueNotation__Group__4_in_rule__ValueNotation__Group__35215);
            rule__ValueNotation__Group__4();

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
    // $ANTLR end "rule__ValueNotation__Group__3"


    // $ANTLR start "rule__ValueNotation__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2524:1: rule__ValueNotation__Group__3__Impl : ( ( RULE_NEWLINE )? ) ;
    public final void rule__ValueNotation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2528:1: ( ( ( RULE_NEWLINE )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2529:1: ( ( RULE_NEWLINE )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2529:1: ( ( RULE_NEWLINE )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2530:1: ( RULE_NEWLINE )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueNotationAccess().getNEWLINETerminalRuleCall_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2531:1: ( RULE_NEWLINE )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_NEWLINE) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2531:3: RULE_NEWLINE
                    {
                    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ValueNotation__Group__3__Impl5243); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueNotationAccess().getNEWLINETerminalRuleCall_3()); 
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
    // $ANTLR end "rule__ValueNotation__Group__3__Impl"


    // $ANTLR start "rule__ValueNotation__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2541:1: rule__ValueNotation__Group__4 : rule__ValueNotation__Group__4__Impl ;
    public final void rule__ValueNotation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2545:1: ( rule__ValueNotation__Group__4__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2546:2: rule__ValueNotation__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ValueNotation__Group__4__Impl_in_rule__ValueNotation__Group__45274);
            rule__ValueNotation__Group__4__Impl();

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
    // $ANTLR end "rule__ValueNotation__Group__4"


    // $ANTLR start "rule__ValueNotation__Group__4__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2552:1: rule__ValueNotation__Group__4__Impl : ( ( rule__ValueNotation__ValueNotationAssignment_4 ) ) ;
    public final void rule__ValueNotation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2556:1: ( ( ( rule__ValueNotation__ValueNotationAssignment_4 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2557:1: ( ( rule__ValueNotation__ValueNotationAssignment_4 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2557:1: ( ( rule__ValueNotation__ValueNotationAssignment_4 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2558:1: ( rule__ValueNotation__ValueNotationAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueNotationAccess().getValueNotationAssignment_4()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2559:1: ( rule__ValueNotation__ValueNotationAssignment_4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2559:2: rule__ValueNotation__ValueNotationAssignment_4
            {
            pushFollow(FOLLOW_rule__ValueNotation__ValueNotationAssignment_4_in_rule__ValueNotation__Group__4__Impl5301);
            rule__ValueNotation__ValueNotationAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueNotationAccess().getValueNotationAssignment_4()); 
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
    // $ANTLR end "rule__ValueNotation__Group__4__Impl"


    // $ANTLR start "rule__TypeAssignment__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2579:1: rule__TypeAssignment__Group__0 : rule__TypeAssignment__Group__0__Impl rule__TypeAssignment__Group__1 ;
    public final void rule__TypeAssignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2583:1: ( rule__TypeAssignment__Group__0__Impl rule__TypeAssignment__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2584:2: rule__TypeAssignment__Group__0__Impl rule__TypeAssignment__Group__1
            {
            pushFollow(FOLLOW_rule__TypeAssignment__Group__0__Impl_in_rule__TypeAssignment__Group__05341);
            rule__TypeAssignment__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeAssignment__Group__1_in_rule__TypeAssignment__Group__05344);
            rule__TypeAssignment__Group__1();

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
    // $ANTLR end "rule__TypeAssignment__Group__0"


    // $ANTLR start "rule__TypeAssignment__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2591:1: rule__TypeAssignment__Group__0__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__TypeAssignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2595:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2596:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2596:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2597:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2597:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2598:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2599:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2599:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__TypeAssignment__Group__0__Impl5374); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2602:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2603:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2604:1: ( RULE_NEWLINE )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_NEWLINE) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2604:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__TypeAssignment__Group__0__Impl5387); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
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
    // $ANTLR end "rule__TypeAssignment__Group__0__Impl"


    // $ANTLR start "rule__TypeAssignment__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2615:1: rule__TypeAssignment__Group__1 : rule__TypeAssignment__Group__1__Impl ;
    public final void rule__TypeAssignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2619:1: ( rule__TypeAssignment__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2620:2: rule__TypeAssignment__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeAssignment__Group__1__Impl_in_rule__TypeAssignment__Group__15420);
            rule__TypeAssignment__Group__1__Impl();

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
    // $ANTLR end "rule__TypeAssignment__Group__1"


    // $ANTLR start "rule__TypeAssignment__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2626:1: rule__TypeAssignment__Group__1__Impl : ( ( rule__TypeAssignment__Alternatives_1 ) ) ;
    public final void rule__TypeAssignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2630:1: ( ( ( rule__TypeAssignment__Alternatives_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2631:1: ( ( rule__TypeAssignment__Alternatives_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2631:1: ( ( rule__TypeAssignment__Alternatives_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2632:1: ( rule__TypeAssignment__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentAccess().getAlternatives_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2633:1: ( rule__TypeAssignment__Alternatives_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2633:2: rule__TypeAssignment__Alternatives_1
            {
            pushFollow(FOLLOW_rule__TypeAssignment__Alternatives_1_in_rule__TypeAssignment__Group__1__Impl5447);
            rule__TypeAssignment__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAssignmentAccess().getAlternatives_1()); 
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
    // $ANTLR end "rule__TypeAssignment__Group__1__Impl"


    // $ANTLR start "rule__ParamAssignment__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2647:1: rule__ParamAssignment__Group__0 : rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1 ;
    public final void rule__ParamAssignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2651:1: ( rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2652:2: rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1
            {
            pushFollow(FOLLOW_rule__ParamAssignment__Group__0__Impl_in_rule__ParamAssignment__Group__05481);
            rule__ParamAssignment__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ParamAssignment__Group__1_in_rule__ParamAssignment__Group__05484);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2659:1: rule__ParamAssignment__Group__0__Impl : ( ( rule__ParamAssignment__ParamAssignment_0 ) ) ;
    public final void rule__ParamAssignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2663:1: ( ( ( rule__ParamAssignment__ParamAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2664:1: ( ( rule__ParamAssignment__ParamAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2664:1: ( ( rule__ParamAssignment__ParamAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2665:1: ( rule__ParamAssignment__ParamAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getParamAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2666:1: ( rule__ParamAssignment__ParamAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2666:2: rule__ParamAssignment__ParamAssignment_0
            {
            pushFollow(FOLLOW_rule__ParamAssignment__ParamAssignment_0_in_rule__ParamAssignment__Group__0__Impl5511);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2676:1: rule__ParamAssignment__Group__1 : rule__ParamAssignment__Group__1__Impl ;
    public final void rule__ParamAssignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2680:1: ( rule__ParamAssignment__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2681:2: rule__ParamAssignment__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParamAssignment__Group__1__Impl_in_rule__ParamAssignment__Group__15541);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2687:1: rule__ParamAssignment__Group__1__Impl : ( ( rule__ParamAssignment__RightAssignment_1 ) ) ;
    public final void rule__ParamAssignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2691:1: ( ( ( rule__ParamAssignment__RightAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2692:1: ( ( rule__ParamAssignment__RightAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2692:1: ( ( rule__ParamAssignment__RightAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2693:1: ( rule__ParamAssignment__RightAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getRightAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2694:1: ( rule__ParamAssignment__RightAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2694:2: rule__ParamAssignment__RightAssignment_1
            {
            pushFollow(FOLLOW_rule__ParamAssignment__RightAssignment_1_in_rule__ParamAssignment__Group__1__Impl5568);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2708:1: rule__TypeReferenceExt__Group__0 : rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1 ;
    public final void rule__TypeReferenceExt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2712:1: ( rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2713:2: rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__0__Impl_in_rule__TypeReferenceExt__Group__05602);
            rule__TypeReferenceExt__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__1_in_rule__TypeReferenceExt__Group__05605);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2720:1: rule__TypeReferenceExt__Group__0__Impl : ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) ) ;
    public final void rule__TypeReferenceExt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2724:1: ( ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2725:1: ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2725:1: ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2726:1: ( rule__TypeReferenceExt__ParentRefAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getParentRefAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2727:1: ( rule__TypeReferenceExt__ParentRefAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2727:2: rule__TypeReferenceExt__ParentRefAssignment_0
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__ParentRefAssignment_0_in_rule__TypeReferenceExt__Group__0__Impl5632);
            rule__TypeReferenceExt__ParentRefAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceExtAccess().getParentRefAssignment_0()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2737:1: rule__TypeReferenceExt__Group__1 : rule__TypeReferenceExt__Group__1__Impl ;
    public final void rule__TypeReferenceExt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2741:1: ( rule__TypeReferenceExt__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2742:2: rule__TypeReferenceExt__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__1__Impl_in_rule__TypeReferenceExt__Group__15662);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2748:1: rule__TypeReferenceExt__Group__1__Impl : ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? ) ;
    public final void rule__TypeReferenceExt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2752:1: ( ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2753:1: ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2753:1: ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2754:1: ( rule__TypeReferenceExt__ChildRefAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getChildRefAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2755:1: ( rule__TypeReferenceExt__ChildRefAssignment_1 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_MODULE_ID) ) {
                int LA27_1 = input.LA(2);

                if ( (synpred36_InternalSmi()) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2755:2: rule__TypeReferenceExt__ChildRefAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_rule__TypeReferenceExt__Group__1__Impl5689);
                    rule__TypeReferenceExt__ChildRefAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceExtAccess().getChildRefAssignment_1()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2769:1: rule__Value__Group__0 : rule__Value__Group__0__Impl rule__Value__Group__1 ;
    public final void rule__Value__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2773:1: ( rule__Value__Group__0__Impl rule__Value__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2774:2: rule__Value__Group__0__Impl rule__Value__Group__1
            {
            pushFollow(FOLLOW_rule__Value__Group__0__Impl_in_rule__Value__Group__05724);
            rule__Value__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group__1_in_rule__Value__Group__05727);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2781:1: rule__Value__Group__0__Impl : ( ( rule__Value__TagAssignment_0 )? ) ;
    public final void rule__Value__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2785:1: ( ( ( rule__Value__TagAssignment_0 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2786:1: ( ( rule__Value__TagAssignment_0 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2786:1: ( ( rule__Value__TagAssignment_0 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2787:1: ( rule__Value__TagAssignment_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getTagAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2788:1: ( rule__Value__TagAssignment_0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_NEWLINE) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==25) ) {
                    alt28=1;
                }
            }
            else if ( (LA28_0==25) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2788:2: rule__Value__TagAssignment_0
                    {
                    pushFollow(FOLLOW_rule__Value__TagAssignment_0_in_rule__Value__Group__0__Impl5754);
                    rule__Value__TagAssignment_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getTagAssignment_0()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2798:1: rule__Value__Group__1 : rule__Value__Group__1__Impl rule__Value__Group__2 ;
    public final void rule__Value__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2802:1: ( rule__Value__Group__1__Impl rule__Value__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2803:2: rule__Value__Group__1__Impl rule__Value__Group__2
            {
            pushFollow(FOLLOW_rule__Value__Group__1__Impl_in_rule__Value__Group__15785);
            rule__Value__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group__2_in_rule__Value__Group__15788);
            rule__Value__Group__2();

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2810:1: rule__Value__Group__1__Impl : ( ( RULE_NEWLINE )? ) ;
    public final void rule__Value__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2814:1: ( ( ( RULE_NEWLINE )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2815:1: ( ( RULE_NEWLINE )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2815:1: ( ( RULE_NEWLINE )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2816:1: ( RULE_NEWLINE )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2817:1: ( RULE_NEWLINE )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_NEWLINE) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2817:3: RULE_NEWLINE
                    {
                    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Value__Group__1__Impl5816); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_1()); 
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


    // $ANTLR start "rule__Value__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2827:1: rule__Value__Group__2 : rule__Value__Group__2__Impl rule__Value__Group__3 ;
    public final void rule__Value__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2831:1: ( rule__Value__Group__2__Impl rule__Value__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2832:2: rule__Value__Group__2__Impl rule__Value__Group__3
            {
            pushFollow(FOLLOW_rule__Value__Group__2__Impl_in_rule__Value__Group__25847);
            rule__Value__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group__3_in_rule__Value__Group__25850);
            rule__Value__Group__3();

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
    // $ANTLR end "rule__Value__Group__2"


    // $ANTLR start "rule__Value__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2839:1: rule__Value__Group__2__Impl : ( ( rule__Value__ImplicitAssignment_2 )? ) ;
    public final void rule__Value__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2843:1: ( ( ( rule__Value__ImplicitAssignment_2 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2844:1: ( ( rule__Value__ImplicitAssignment_2 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2844:1: ( ( rule__Value__ImplicitAssignment_2 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2845:1: ( rule__Value__ImplicitAssignment_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getImplicitAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2846:1: ( rule__Value__ImplicitAssignment_2 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==39) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2846:2: rule__Value__ImplicitAssignment_2
                    {
                    pushFollow(FOLLOW_rule__Value__ImplicitAssignment_2_in_rule__Value__Group__2__Impl5877);
                    rule__Value__ImplicitAssignment_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getImplicitAssignment_2()); 
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
    // $ANTLR end "rule__Value__Group__2__Impl"


    // $ANTLR start "rule__Value__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2856:1: rule__Value__Group__3 : rule__Value__Group__3__Impl rule__Value__Group__4 ;
    public final void rule__Value__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2860:1: ( rule__Value__Group__3__Impl rule__Value__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2861:2: rule__Value__Group__3__Impl rule__Value__Group__4
            {
            pushFollow(FOLLOW_rule__Value__Group__3__Impl_in_rule__Value__Group__35908);
            rule__Value__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group__4_in_rule__Value__Group__35911);
            rule__Value__Group__4();

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
    // $ANTLR end "rule__Value__Group__3"


    // $ANTLR start "rule__Value__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2868:1: rule__Value__Group__3__Impl : ( ( rule__Value__ValueTypesAssignment_3 ) ) ;
    public final void rule__Value__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2872:1: ( ( ( rule__Value__ValueTypesAssignment_3 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2873:1: ( ( rule__Value__ValueTypesAssignment_3 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2873:1: ( ( rule__Value__ValueTypesAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2874:1: ( rule__Value__ValueTypesAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2875:1: ( rule__Value__ValueTypesAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2875:2: rule__Value__ValueTypesAssignment_3
            {
            pushFollow(FOLLOW_rule__Value__ValueTypesAssignment_3_in_rule__Value__Group__3__Impl5938);
            rule__Value__ValueTypesAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesAssignment_3()); 
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
    // $ANTLR end "rule__Value__Group__3__Impl"


    // $ANTLR start "rule__Value__Group__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2885:1: rule__Value__Group__4 : rule__Value__Group__4__Impl ;
    public final void rule__Value__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2889:1: ( rule__Value__Group__4__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2890:2: rule__Value__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group__4__Impl_in_rule__Value__Group__45968);
            rule__Value__Group__4__Impl();

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
    // $ANTLR end "rule__Value__Group__4"


    // $ANTLR start "rule__Value__Group__4__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2896:1: rule__Value__Group__4__Impl : ( ( rule__Value__Group_4__0 )* ) ;
    public final void rule__Value__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2900:1: ( ( ( rule__Value__Group_4__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2901:1: ( ( rule__Value__Group_4__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2901:1: ( ( rule__Value__Group_4__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2902:1: ( rule__Value__Group_4__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getGroup_4()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2903:1: ( rule__Value__Group_4__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_NEWLINE) ) {
                    int LA31_2 = input.LA(2);

                    if ( (LA31_2==24) ) {
                        alt31=1;
                    }


                }
                else if ( (LA31_0==24) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2903:2: rule__Value__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__Value__Group_4__0_in_rule__Value__Group__4__Impl5995);
            	    rule__Value__Group_4__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getGroup_4()); 
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
    // $ANTLR end "rule__Value__Group__4__Impl"


    // $ANTLR start "rule__Value__Group_4__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2923:1: rule__Value__Group_4__0 : rule__Value__Group_4__0__Impl rule__Value__Group_4__1 ;
    public final void rule__Value__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2927:1: ( rule__Value__Group_4__0__Impl rule__Value__Group_4__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2928:2: rule__Value__Group_4__0__Impl rule__Value__Group_4__1
            {
            pushFollow(FOLLOW_rule__Value__Group_4__0__Impl_in_rule__Value__Group_4__06036);
            rule__Value__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group_4__1_in_rule__Value__Group_4__06039);
            rule__Value__Group_4__1();

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
    // $ANTLR end "rule__Value__Group_4__0"


    // $ANTLR start "rule__Value__Group_4__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2935:1: rule__Value__Group_4__0__Impl : ( ( RULE_NEWLINE )? ) ;
    public final void rule__Value__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2939:1: ( ( ( RULE_NEWLINE )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2940:1: ( ( RULE_NEWLINE )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2940:1: ( ( RULE_NEWLINE )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2941:1: ( RULE_NEWLINE )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_4_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2942:1: ( RULE_NEWLINE )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_NEWLINE) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2942:3: RULE_NEWLINE
                    {
                    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Value__Group_4__0__Impl6067); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_4_0()); 
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
    // $ANTLR end "rule__Value__Group_4__0__Impl"


    // $ANTLR start "rule__Value__Group_4__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2952:1: rule__Value__Group_4__1 : rule__Value__Group_4__1__Impl rule__Value__Group_4__2 ;
    public final void rule__Value__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2956:1: ( rule__Value__Group_4__1__Impl rule__Value__Group_4__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2957:2: rule__Value__Group_4__1__Impl rule__Value__Group_4__2
            {
            pushFollow(FOLLOW_rule__Value__Group_4__1__Impl_in_rule__Value__Group_4__16098);
            rule__Value__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group_4__2_in_rule__Value__Group_4__16101);
            rule__Value__Group_4__2();

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
    // $ANTLR end "rule__Value__Group_4__1"


    // $ANTLR start "rule__Value__Group_4__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2964:1: rule__Value__Group_4__1__Impl : ( '|' ) ;
    public final void rule__Value__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2968:1: ( ( '|' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2969:1: ( '|' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2969:1: ( '|' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2970:1: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getVerticalLineKeyword_4_1()); 
            }
            match(input,24,FOLLOW_24_in_rule__Value__Group_4__1__Impl6129); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getVerticalLineKeyword_4_1()); 
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
    // $ANTLR end "rule__Value__Group_4__1__Impl"


    // $ANTLR start "rule__Value__Group_4__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2983:1: rule__Value__Group_4__2 : rule__Value__Group_4__2__Impl ;
    public final void rule__Value__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2987:1: ( rule__Value__Group_4__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2988:2: rule__Value__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group_4__2__Impl_in_rule__Value__Group_4__26160);
            rule__Value__Group_4__2__Impl();

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
    // $ANTLR end "rule__Value__Group_4__2"


    // $ANTLR start "rule__Value__Group_4__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2994:1: rule__Value__Group_4__2__Impl : ( ( rule__Value__ValueTypesAssignment_4_2 ) ) ;
    public final void rule__Value__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2998:1: ( ( ( rule__Value__ValueTypesAssignment_4_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2999:1: ( ( rule__Value__ValueTypesAssignment_4_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2999:1: ( ( rule__Value__ValueTypesAssignment_4_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3000:1: ( rule__Value__ValueTypesAssignment_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesAssignment_4_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3001:1: ( rule__Value__ValueTypesAssignment_4_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3001:2: rule__Value__ValueTypesAssignment_4_2
            {
            pushFollow(FOLLOW_rule__Value__ValueTypesAssignment_4_2_in_rule__Value__Group_4__2__Impl6187);
            rule__Value__ValueTypesAssignment_4_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesAssignment_4_2()); 
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
    // $ANTLR end "rule__Value__Group_4__2__Impl"


    // $ANTLR start "rule__Tag__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3017:1: rule__Tag__Group__0 : rule__Tag__Group__0__Impl rule__Tag__Group__1 ;
    public final void rule__Tag__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3021:1: ( rule__Tag__Group__0__Impl rule__Tag__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3022:2: rule__Tag__Group__0__Impl rule__Tag__Group__1
            {
            pushFollow(FOLLOW_rule__Tag__Group__0__Impl_in_rule__Tag__Group__06223);
            rule__Tag__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Tag__Group__1_in_rule__Tag__Group__06226);
            rule__Tag__Group__1();

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
    // $ANTLR end "rule__Tag__Group__0"


    // $ANTLR start "rule__Tag__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3029:1: rule__Tag__Group__0__Impl : ( ( RULE_NEWLINE )? ) ;
    public final void rule__Tag__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3033:1: ( ( ( RULE_NEWLINE )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3034:1: ( ( RULE_NEWLINE )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3034:1: ( ( RULE_NEWLINE )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3035:1: ( RULE_NEWLINE )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTagAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3036:1: ( RULE_NEWLINE )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_NEWLINE) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3036:3: RULE_NEWLINE
                    {
                    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Tag__Group__0__Impl6254); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTagAccess().getNEWLINETerminalRuleCall_0()); 
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
    // $ANTLR end "rule__Tag__Group__0__Impl"


    // $ANTLR start "rule__Tag__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3046:1: rule__Tag__Group__1 : rule__Tag__Group__1__Impl rule__Tag__Group__2 ;
    public final void rule__Tag__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3050:1: ( rule__Tag__Group__1__Impl rule__Tag__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3051:2: rule__Tag__Group__1__Impl rule__Tag__Group__2
            {
            pushFollow(FOLLOW_rule__Tag__Group__1__Impl_in_rule__Tag__Group__16285);
            rule__Tag__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Tag__Group__2_in_rule__Tag__Group__16288);
            rule__Tag__Group__2();

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
    // $ANTLR end "rule__Tag__Group__1"


    // $ANTLR start "rule__Tag__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3058:1: rule__Tag__Group__1__Impl : ( '[APPLICATION' ) ;
    public final void rule__Tag__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3062:1: ( ( '[APPLICATION' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3063:1: ( '[APPLICATION' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3063:1: ( '[APPLICATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3064:1: '[APPLICATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTagAccess().getAPPLICATIONKeyword_1()); 
            }
            match(input,25,FOLLOW_25_in_rule__Tag__Group__1__Impl6316); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTagAccess().getAPPLICATIONKeyword_1()); 
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
    // $ANTLR end "rule__Tag__Group__1__Impl"


    // $ANTLR start "rule__Tag__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3077:1: rule__Tag__Group__2 : rule__Tag__Group__2__Impl rule__Tag__Group__3 ;
    public final void rule__Tag__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3081:1: ( rule__Tag__Group__2__Impl rule__Tag__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3082:2: rule__Tag__Group__2__Impl rule__Tag__Group__3
            {
            pushFollow(FOLLOW_rule__Tag__Group__2__Impl_in_rule__Tag__Group__26347);
            rule__Tag__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Tag__Group__3_in_rule__Tag__Group__26350);
            rule__Tag__Group__3();

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
    // $ANTLR end "rule__Tag__Group__2"


    // $ANTLR start "rule__Tag__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3089:1: rule__Tag__Group__2__Impl : ( ( rule__Tag__TagValueAssignment_2 ) ) ;
    public final void rule__Tag__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3093:1: ( ( ( rule__Tag__TagValueAssignment_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3094:1: ( ( rule__Tag__TagValueAssignment_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3094:1: ( ( rule__Tag__TagValueAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3095:1: ( rule__Tag__TagValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTagAccess().getTagValueAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3096:1: ( rule__Tag__TagValueAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3096:2: rule__Tag__TagValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Tag__TagValueAssignment_2_in_rule__Tag__Group__2__Impl6377);
            rule__Tag__TagValueAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTagAccess().getTagValueAssignment_2()); 
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
    // $ANTLR end "rule__Tag__Group__2__Impl"


    // $ANTLR start "rule__Tag__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3106:1: rule__Tag__Group__3 : rule__Tag__Group__3__Impl ;
    public final void rule__Tag__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3110:1: ( rule__Tag__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3111:2: rule__Tag__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Tag__Group__3__Impl_in_rule__Tag__Group__36407);
            rule__Tag__Group__3__Impl();

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
    // $ANTLR end "rule__Tag__Group__3"


    // $ANTLR start "rule__Tag__Group__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3117:1: rule__Tag__Group__3__Impl : ( ']' ) ;
    public final void rule__Tag__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3121:1: ( ( ']' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3122:1: ( ']' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3122:1: ( ']' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3123:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTagAccess().getRightSquareBracketKeyword_3()); 
            }
            match(input,26,FOLLOW_26_in_rule__Tag__Group__3__Impl6435); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTagAccess().getRightSquareBracketKeyword_3()); 
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
    // $ANTLR end "rule__Tag__Group__3__Impl"


    // $ANTLR start "rule__MacroValue__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3144:1: rule__MacroValue__Group__0 : rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1 ;
    public final void rule__MacroValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3148:1: ( rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3149:2: rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__0__Impl_in_rule__MacroValue__Group__06474);
            rule__MacroValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__1_in_rule__MacroValue__Group__06477);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3156:1: rule__MacroValue__Group__0__Impl : ( () ) ;
    public final void rule__MacroValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3160:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3161:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3161:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3162:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getMacroValueAction_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3163:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3165:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3175:1: rule__MacroValue__Group__1 : rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2 ;
    public final void rule__MacroValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3179:1: ( rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3180:2: rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__1__Impl_in_rule__MacroValue__Group__16535);
            rule__MacroValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__2_in_rule__MacroValue__Group__16538);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3187:1: rule__MacroValue__Group__1__Impl : ( 'value' ) ;
    public final void rule__MacroValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3191:1: ( ( 'value' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3192:1: ( 'value' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3192:1: ( 'value' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3193:1: 'value'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getValueKeyword_1()); 
            }
            match(input,27,FOLLOW_27_in_rule__MacroValue__Group__1__Impl6566); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3206:1: rule__MacroValue__Group__2 : rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3 ;
    public final void rule__MacroValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3210:1: ( rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3211:2: rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__2__Impl_in_rule__MacroValue__Group__26597);
            rule__MacroValue__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__3_in_rule__MacroValue__Group__26600);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3218:1: rule__MacroValue__Group__2__Impl : ( '(' ) ;
    public final void rule__MacroValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3222:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3223:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3223:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3224:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,28,FOLLOW_28_in_rule__MacroValue__Group__2__Impl6628); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3237:1: rule__MacroValue__Group__3 : rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4 ;
    public final void rule__MacroValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3241:1: ( rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3242:2: rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__3__Impl_in_rule__MacroValue__Group__36659);
            rule__MacroValue__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__4_in_rule__MacroValue__Group__36662);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3249:1: rule__MacroValue__Group__3__Impl : ( ( rule__MacroValue__ValueTypeAssignment_3 ) ) ;
    public final void rule__MacroValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3253:1: ( ( ( rule__MacroValue__ValueTypeAssignment_3 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3254:1: ( ( rule__MacroValue__ValueTypeAssignment_3 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3254:1: ( ( rule__MacroValue__ValueTypeAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3255:1: ( rule__MacroValue__ValueTypeAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getValueTypeAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3256:1: ( rule__MacroValue__ValueTypeAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3256:2: rule__MacroValue__ValueTypeAssignment_3
            {
            pushFollow(FOLLOW_rule__MacroValue__ValueTypeAssignment_3_in_rule__MacroValue__Group__3__Impl6689);
            rule__MacroValue__ValueTypeAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueAccess().getValueTypeAssignment_3()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3266:1: rule__MacroValue__Group__4 : rule__MacroValue__Group__4__Impl ;
    public final void rule__MacroValue__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3270:1: ( rule__MacroValue__Group__4__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3271:2: rule__MacroValue__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__4__Impl_in_rule__MacroValue__Group__46719);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3277:1: rule__MacroValue__Group__4__Impl : ( ')' ) ;
    public final void rule__MacroValue__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3281:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3282:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3282:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3283:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,29,FOLLOW_29_in_rule__MacroValue__Group__4__Impl6747); if (state.failed) return ;
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


    // $ANTLR start "rule__MACRO_VALUE_TYPE__Group_1__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3306:1: rule__MACRO_VALUE_TYPE__Group_1__0 : rule__MACRO_VALUE_TYPE__Group_1__0__Impl rule__MACRO_VALUE_TYPE__Group_1__1 ;
    public final void rule__MACRO_VALUE_TYPE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3310:1: ( rule__MACRO_VALUE_TYPE__Group_1__0__Impl rule__MACRO_VALUE_TYPE__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3311:2: rule__MACRO_VALUE_TYPE__Group_1__0__Impl rule__MACRO_VALUE_TYPE__Group_1__1
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__Group_1__0__Impl_in_rule__MACRO_VALUE_TYPE__Group_1__06788);
            rule__MACRO_VALUE_TYPE__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__Group_1__1_in_rule__MACRO_VALUE_TYPE__Group_1__06791);
            rule__MACRO_VALUE_TYPE__Group_1__1();

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
    // $ANTLR end "rule__MACRO_VALUE_TYPE__Group_1__0"


    // $ANTLR start "rule__MACRO_VALUE_TYPE__Group_1__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3318:1: rule__MACRO_VALUE_TYPE__Group_1__0__Impl : ( 'VALUE' ) ;
    public final void rule__MACRO_VALUE_TYPE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3322:1: ( ( 'VALUE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3323:1: ( 'VALUE' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3323:1: ( 'VALUE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3324:1: 'VALUE'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getVALUEKeyword_1_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__MACRO_VALUE_TYPE__Group_1__0__Impl6819); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPEAccess().getVALUEKeyword_1_0()); 
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
    // $ANTLR end "rule__MACRO_VALUE_TYPE__Group_1__0__Impl"


    // $ANTLR start "rule__MACRO_VALUE_TYPE__Group_1__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3337:1: rule__MACRO_VALUE_TYPE__Group_1__1 : rule__MACRO_VALUE_TYPE__Group_1__1__Impl ;
    public final void rule__MACRO_VALUE_TYPE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3341:1: ( rule__MACRO_VALUE_TYPE__Group_1__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3342:2: rule__MACRO_VALUE_TYPE__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__Group_1__1__Impl_in_rule__MACRO_VALUE_TYPE__Group_1__16850);
            rule__MACRO_VALUE_TYPE__Group_1__1__Impl();

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
    // $ANTLR end "rule__MACRO_VALUE_TYPE__Group_1__1"


    // $ANTLR start "rule__MACRO_VALUE_TYPE__Group_1__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3348:1: rule__MACRO_VALUE_TYPE__Group_1__1__Impl : ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1 ) ) ;
    public final void rule__MACRO_VALUE_TYPE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3352:1: ( ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3353:1: ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3353:1: ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3354:1: ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralAssignment_1_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3355:1: ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3355:2: rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1_in_rule__MACRO_VALUE_TYPE__Group_1__1__Impl6877);
            rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralAssignment_1_1()); 
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
    // $ANTLR end "rule__MACRO_VALUE_TYPE__Group_1__1__Impl"


    // $ANTLR start "rule__UpdateType__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3369:1: rule__UpdateType__Group__0 : rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1 ;
    public final void rule__UpdateType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3373:1: ( rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3374:2: rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__0__Impl_in_rule__UpdateType__Group__06911);
            rule__UpdateType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__UpdateType__Group__1_in_rule__UpdateType__Group__06914);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3381:1: rule__UpdateType__Group__0__Impl : ( 'Update' ) ;
    public final void rule__UpdateType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3385:1: ( ( 'Update' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3386:1: ( 'Update' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3386:1: ( 'Update' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3387:1: 'Update'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getUpdateKeyword_0()); 
            }
            match(input,31,FOLLOW_31_in_rule__UpdateType__Group__0__Impl6942); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3400:1: rule__UpdateType__Group__1 : rule__UpdateType__Group__1__Impl ;
    public final void rule__UpdateType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3404:1: ( rule__UpdateType__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3405:2: rule__UpdateType__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__1__Impl_in_rule__UpdateType__Group__16973);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3411:1: rule__UpdateType__Group__1__Impl : ( ( rule__UpdateType__RefAssignment_1 ) ) ;
    public final void rule__UpdateType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3415:1: ( ( ( rule__UpdateType__RefAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3416:1: ( ( rule__UpdateType__RefAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3416:1: ( ( rule__UpdateType__RefAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3417:1: ( rule__UpdateType__RefAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getRefAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3418:1: ( rule__UpdateType__RefAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3418:2: rule__UpdateType__RefAssignment_1
            {
            pushFollow(FOLLOW_rule__UpdateType__RefAssignment_1_in_rule__UpdateType__Group__1__Impl7000);
            rule__UpdateType__RefAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateTypeAccess().getRefAssignment_1()); 
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


    // $ANTLR start "rule__MACRO_VALUE_CAP__Group_0__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3432:1: rule__MACRO_VALUE_CAP__Group_0__0 : rule__MACRO_VALUE_CAP__Group_0__0__Impl rule__MACRO_VALUE_CAP__Group_0__1 ;
    public final void rule__MACRO_VALUE_CAP__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3436:1: ( rule__MACRO_VALUE_CAP__Group_0__0__Impl rule__MACRO_VALUE_CAP__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3437:2: rule__MACRO_VALUE_CAP__Group_0__0__Impl rule__MACRO_VALUE_CAP__Group_0__1
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__Group_0__0__Impl_in_rule__MACRO_VALUE_CAP__Group_0__07034);
            rule__MACRO_VALUE_CAP__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__Group_0__1_in_rule__MACRO_VALUE_CAP__Group_0__07037);
            rule__MACRO_VALUE_CAP__Group_0__1();

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
    // $ANTLR end "rule__MACRO_VALUE_CAP__Group_0__0"


    // $ANTLR start "rule__MACRO_VALUE_CAP__Group_0__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3444:1: rule__MACRO_VALUE_CAP__Group_0__0__Impl : ( () ) ;
    public final void rule__MACRO_VALUE_CAP__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3448:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3449:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3449:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3450:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getMACRO_VALUE_CAPAction_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3451:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3453:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPAccess().getMACRO_VALUE_CAPAction_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MACRO_VALUE_CAP__Group_0__0__Impl"


    // $ANTLR start "rule__MACRO_VALUE_CAP__Group_0__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3463:1: rule__MACRO_VALUE_CAP__Group_0__1 : rule__MACRO_VALUE_CAP__Group_0__1__Impl ;
    public final void rule__MACRO_VALUE_CAP__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3467:1: ( rule__MACRO_VALUE_CAP__Group_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3468:2: rule__MACRO_VALUE_CAP__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__Group_0__1__Impl_in_rule__MACRO_VALUE_CAP__Group_0__17095);
            rule__MACRO_VALUE_CAP__Group_0__1__Impl();

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
    // $ANTLR end "rule__MACRO_VALUE_CAP__Group_0__1"


    // $ANTLR start "rule__MACRO_VALUE_CAP__Group_0__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3474:1: rule__MACRO_VALUE_CAP__Group_0__1__Impl : ( 'OBJECT IDENTIFIER' ) ;
    public final void rule__MACRO_VALUE_CAP__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3478:1: ( ( 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3479:1: ( 'OBJECT IDENTIFIER' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3479:1: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3480:1: 'OBJECT IDENTIFIER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getOBJECTIDENTIFIERKeyword_0_1()); 
            }
            match(input,20,FOLLOW_20_in_rule__MACRO_VALUE_CAP__Group_0__1__Impl7123); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPAccess().getOBJECTIDENTIFIERKeyword_0_1()); 
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
    // $ANTLR end "rule__MACRO_VALUE_CAP__Group_0__1__Impl"


    // $ANTLR start "rule__ASN1_SIMPLE__Group_0__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3497:1: rule__ASN1_SIMPLE__Group_0__0 : rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1 ;
    public final void rule__ASN1_SIMPLE__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3501:1: ( rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3502:2: rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__0__Impl_in_rule__ASN1_SIMPLE__Group_0__07158);
            rule__ASN1_SIMPLE__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__1_in_rule__ASN1_SIMPLE__Group_0__07161);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3509:1: rule__ASN1_SIMPLE__Group_0__0__Impl : ( () ) ;
    public final void rule__ASN1_SIMPLE__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3513:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3514:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3514:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3515:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3516:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3518:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3528:1: rule__ASN1_SIMPLE__Group_0__1 : rule__ASN1_SIMPLE__Group_0__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3532:1: ( rule__ASN1_SIMPLE__Group_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3533:2: rule__ASN1_SIMPLE__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__1__Impl_in_rule__ASN1_SIMPLE__Group_0__17219);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3539:1: rule__ASN1_SIMPLE__Group_0__1__Impl : ( 'empty' ) ;
    public final void rule__ASN1_SIMPLE__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3543:1: ( ( 'empty' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3544:1: ( 'empty' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3544:1: ( 'empty' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3545:1: 'empty'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1()); 
            }
            match(input,32,FOLLOW_32_in_rule__ASN1_SIMPLE__Group_0__1__Impl7247); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3562:1: rule__ASN1_SIMPLE__Group_1__0 : rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1 ;
    public final void rule__ASN1_SIMPLE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3566:1: ( rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3567:2: rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__0__Impl_in_rule__ASN1_SIMPLE__Group_1__07282);
            rule__ASN1_SIMPLE__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__1_in_rule__ASN1_SIMPLE__Group_1__07285);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3574:1: rule__ASN1_SIMPLE__Group_1__0__Impl : ( () ) ;
    public final void rule__ASN1_SIMPLE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3578:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3579:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3579:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3580:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3581:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3583:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3593:1: rule__ASN1_SIMPLE__Group_1__1 : rule__ASN1_SIMPLE__Group_1__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3597:1: ( rule__ASN1_SIMPLE__Group_1__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3598:2: rule__ASN1_SIMPLE__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__1__Impl_in_rule__ASN1_SIMPLE__Group_1__17343);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3604:1: rule__ASN1_SIMPLE__Group_1__1__Impl : ( RULE_IA5STRING ) ;
    public final void rule__ASN1_SIMPLE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3608:1: ( ( RULE_IA5STRING ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3609:1: ( RULE_IA5STRING )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3609:1: ( RULE_IA5STRING )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3610:1: RULE_IA5STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()); 
            }
            match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_rule__ASN1_SIMPLE__Group_1__1__Impl7370); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3625:1: rule__ASN1_SIMPLE__Group_2__0 : rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1 ;
    public final void rule__ASN1_SIMPLE__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3629:1: ( rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3630:2: rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__0__Impl_in_rule__ASN1_SIMPLE__Group_2__07403);
            rule__ASN1_SIMPLE__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__1_in_rule__ASN1_SIMPLE__Group_2__07406);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3637:1: rule__ASN1_SIMPLE__Group_2__0__Impl : ( ruleASN1_OCTET_STRING ) ;
    public final void rule__ASN1_SIMPLE__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3641:1: ( ( ruleASN1_OCTET_STRING ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3642:1: ( ruleASN1_OCTET_STRING )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3642:1: ( ruleASN1_OCTET_STRING )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3643:1: ruleASN1_OCTET_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_rule__ASN1_SIMPLE__Group_2__0__Impl7433);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3654:1: rule__ASN1_SIMPLE__Group_2__1 : rule__ASN1_SIMPLE__Group_2__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3658:1: ( rule__ASN1_SIMPLE__Group_2__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3659:2: rule__ASN1_SIMPLE__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__1__Impl_in_rule__ASN1_SIMPLE__Group_2__17462);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3665:1: rule__ASN1_SIMPLE__Group_2__1__Impl : ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? ) ;
    public final void rule__ASN1_SIMPLE__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3669:1: ( ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3670:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3670:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3671:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_2_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3672:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==28) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3672:2: rule__ASN1_SIMPLE__ConstraintAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_in_rule__ASN1_SIMPLE__Group_2__1__Impl7489);
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


    // $ANTLR start "rule__ASN1_OCTET_STRING__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3686:1: rule__ASN1_OCTET_STRING__Group__0 : rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1 ;
    public final void rule__ASN1_OCTET_STRING__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3690:1: ( rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3691:2: rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__0__Impl_in_rule__ASN1_OCTET_STRING__Group__07524);
            rule__ASN1_OCTET_STRING__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__1_in_rule__ASN1_OCTET_STRING__Group__07527);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3698:1: rule__ASN1_OCTET_STRING__Group__0__Impl : ( () ) ;
    public final void rule__ASN1_OCTET_STRING__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3702:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3703:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3703:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3704:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3705:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3707:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3717:1: rule__ASN1_OCTET_STRING__Group__1 : rule__ASN1_OCTET_STRING__Group__1__Impl ;
    public final void rule__ASN1_OCTET_STRING__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3721:1: ( rule__ASN1_OCTET_STRING__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3722:2: rule__ASN1_OCTET_STRING__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__1__Impl_in_rule__ASN1_OCTET_STRING__Group__17585);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3728:1: rule__ASN1_OCTET_STRING__Group__1__Impl : ( ( rule__ASN1_OCTET_STRING__NameAssignment_1 ) ) ;
    public final void rule__ASN1_OCTET_STRING__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3732:1: ( ( ( rule__ASN1_OCTET_STRING__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3733:1: ( ( rule__ASN1_OCTET_STRING__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3733:1: ( ( rule__ASN1_OCTET_STRING__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3734:1: ( rule__ASN1_OCTET_STRING__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3735:1: ( rule__ASN1_OCTET_STRING__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3735:2: rule__ASN1_OCTET_STRING__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__NameAssignment_1_in_rule__ASN1_OCTET_STRING__Group__1__Impl7612);
            rule__ASN1_OCTET_STRING__NameAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_OCTET_STRINGAccess().getNameAssignment_1()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3749:1: rule__ASN1_INTEGER__Group__0 : rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1 ;
    public final void rule__ASN1_INTEGER__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3753:1: ( rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3754:2: rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__0__Impl_in_rule__ASN1_INTEGER__Group__07646);
            rule__ASN1_INTEGER__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__1_in_rule__ASN1_INTEGER__Group__07649);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3761:1: rule__ASN1_INTEGER__Group__0__Impl : ( ( rule__ASN1_INTEGER__NameAssignment_0 ) ) ;
    public final void rule__ASN1_INTEGER__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3765:1: ( ( ( rule__ASN1_INTEGER__NameAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3766:1: ( ( rule__ASN1_INTEGER__NameAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3766:1: ( ( rule__ASN1_INTEGER__NameAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3767:1: ( rule__ASN1_INTEGER__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getNameAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3768:1: ( rule__ASN1_INTEGER__NameAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3768:2: rule__ASN1_INTEGER__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__NameAssignment_0_in_rule__ASN1_INTEGER__Group__0__Impl7676);
            rule__ASN1_INTEGER__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getNameAssignment_0()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3778:1: rule__ASN1_INTEGER__Group__1 : rule__ASN1_INTEGER__Group__1__Impl ;
    public final void rule__ASN1_INTEGER__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3782:1: ( rule__ASN1_INTEGER__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3783:2: rule__ASN1_INTEGER__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__1__Impl_in_rule__ASN1_INTEGER__Group__17706);
            rule__ASN1_INTEGER__Group__1__Impl();

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3789:1: rule__ASN1_INTEGER__Group__1__Impl : ( ( rule__ASN1_INTEGER__Group_1__0 )? ) ;
    public final void rule__ASN1_INTEGER__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3793:1: ( ( ( rule__ASN1_INTEGER__Group_1__0 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3794:1: ( ( rule__ASN1_INTEGER__Group_1__0 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3794:1: ( ( rule__ASN1_INTEGER__Group_1__0 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3795:1: ( rule__ASN1_INTEGER__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getGroup_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3796:1: ( rule__ASN1_INTEGER__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==28) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3796:2: rule__ASN1_INTEGER__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_INTEGER__Group_1__0_in_rule__ASN1_INTEGER__Group__1__Impl7733);
                    rule__ASN1_INTEGER__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getGroup_1()); 
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


    // $ANTLR start "rule__ASN1_INTEGER__Group_1__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3810:1: rule__ASN1_INTEGER__Group_1__0 : rule__ASN1_INTEGER__Group_1__0__Impl rule__ASN1_INTEGER__Group_1__1 ;
    public final void rule__ASN1_INTEGER__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3814:1: ( rule__ASN1_INTEGER__Group_1__0__Impl rule__ASN1_INTEGER__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3815:2: rule__ASN1_INTEGER__Group_1__0__Impl rule__ASN1_INTEGER__Group_1__1
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group_1__0__Impl_in_rule__ASN1_INTEGER__Group_1__07768);
            rule__ASN1_INTEGER__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group_1__1_in_rule__ASN1_INTEGER__Group_1__07771);
            rule__ASN1_INTEGER__Group_1__1();

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
    // $ANTLR end "rule__ASN1_INTEGER__Group_1__0"


    // $ANTLR start "rule__ASN1_INTEGER__Group_1__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3822:1: rule__ASN1_INTEGER__Group_1__0__Impl : ( '(' ) ;
    public final void rule__ASN1_INTEGER__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3826:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3827:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3827:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3828:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getLeftParenthesisKeyword_1_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__ASN1_INTEGER__Group_1__0__Impl7799); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getLeftParenthesisKeyword_1_0()); 
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
    // $ANTLR end "rule__ASN1_INTEGER__Group_1__0__Impl"


    // $ANTLR start "rule__ASN1_INTEGER__Group_1__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3841:1: rule__ASN1_INTEGER__Group_1__1 : rule__ASN1_INTEGER__Group_1__1__Impl rule__ASN1_INTEGER__Group_1__2 ;
    public final void rule__ASN1_INTEGER__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3845:1: ( rule__ASN1_INTEGER__Group_1__1__Impl rule__ASN1_INTEGER__Group_1__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3846:2: rule__ASN1_INTEGER__Group_1__1__Impl rule__ASN1_INTEGER__Group_1__2
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group_1__1__Impl_in_rule__ASN1_INTEGER__Group_1__17830);
            rule__ASN1_INTEGER__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group_1__2_in_rule__ASN1_INTEGER__Group_1__17833);
            rule__ASN1_INTEGER__Group_1__2();

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
    // $ANTLR end "rule__ASN1_INTEGER__Group_1__1"


    // $ANTLR start "rule__ASN1_INTEGER__Group_1__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3853:1: rule__ASN1_INTEGER__Group_1__1__Impl : ( ( rule__ASN1_INTEGER__RangeAssignment_1_1 ) ) ;
    public final void rule__ASN1_INTEGER__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3857:1: ( ( ( rule__ASN1_INTEGER__RangeAssignment_1_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3858:1: ( ( rule__ASN1_INTEGER__RangeAssignment_1_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3858:1: ( ( rule__ASN1_INTEGER__RangeAssignment_1_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3859:1: ( rule__ASN1_INTEGER__RangeAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getRangeAssignment_1_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3860:1: ( rule__ASN1_INTEGER__RangeAssignment_1_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3860:2: rule__ASN1_INTEGER__RangeAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__RangeAssignment_1_1_in_rule__ASN1_INTEGER__Group_1__1__Impl7860);
            rule__ASN1_INTEGER__RangeAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getRangeAssignment_1_1()); 
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
    // $ANTLR end "rule__ASN1_INTEGER__Group_1__1__Impl"


    // $ANTLR start "rule__ASN1_INTEGER__Group_1__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3870:1: rule__ASN1_INTEGER__Group_1__2 : rule__ASN1_INTEGER__Group_1__2__Impl ;
    public final void rule__ASN1_INTEGER__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3874:1: ( rule__ASN1_INTEGER__Group_1__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3875:2: rule__ASN1_INTEGER__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group_1__2__Impl_in_rule__ASN1_INTEGER__Group_1__27890);
            rule__ASN1_INTEGER__Group_1__2__Impl();

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
    // $ANTLR end "rule__ASN1_INTEGER__Group_1__2"


    // $ANTLR start "rule__ASN1_INTEGER__Group_1__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3881:1: rule__ASN1_INTEGER__Group_1__2__Impl : ( ')' ) ;
    public final void rule__ASN1_INTEGER__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3885:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3886:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3886:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3887:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getRightParenthesisKeyword_1_2()); 
            }
            match(input,29,FOLLOW_29_in_rule__ASN1_INTEGER__Group_1__2__Impl7918); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getRightParenthesisKeyword_1_2()); 
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
    // $ANTLR end "rule__ASN1_INTEGER__Group_1__2__Impl"


    // $ANTLR start "rule__ASN1_SUBTYPE__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3906:1: rule__ASN1_SUBTYPE__Group__0 : rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1 ;
    public final void rule__ASN1_SUBTYPE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3910:1: ( rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3911:2: rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__0__Impl_in_rule__ASN1_SUBTYPE__Group__07955);
            rule__ASN1_SUBTYPE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__1_in_rule__ASN1_SUBTYPE__Group__07958);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3918:1: rule__ASN1_SUBTYPE__Group__0__Impl : ( '(' ) ;
    public final void rule__ASN1_SUBTYPE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3922:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3923:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3923:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3924:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__ASN1_SUBTYPE__Group__0__Impl7986); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3937:1: rule__ASN1_SUBTYPE__Group__1 : rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2 ;
    public final void rule__ASN1_SUBTYPE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3941:1: ( rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3942:2: rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__1__Impl_in_rule__ASN1_SUBTYPE__Group__18017);
            rule__ASN1_SUBTYPE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__2_in_rule__ASN1_SUBTYPE__Group__18020);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3949:1: rule__ASN1_SUBTYPE__Group__1__Impl : ( 'SIZE' ) ;
    public final void rule__ASN1_SUBTYPE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3953:1: ( ( 'SIZE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3954:1: ( 'SIZE' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3954:1: ( 'SIZE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3955:1: 'SIZE'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_1()); 
            }
            match(input,33,FOLLOW_33_in_rule__ASN1_SUBTYPE__Group__1__Impl8048); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3968:1: rule__ASN1_SUBTYPE__Group__2 : rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3 ;
    public final void rule__ASN1_SUBTYPE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3972:1: ( rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3973:2: rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__2__Impl_in_rule__ASN1_SUBTYPE__Group__28079);
            rule__ASN1_SUBTYPE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__3_in_rule__ASN1_SUBTYPE__Group__28082);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3980:1: rule__ASN1_SUBTYPE__Group__2__Impl : ( '(' ) ;
    public final void rule__ASN1_SUBTYPE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3984:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3985:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3985:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3986:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,28,FOLLOW_28_in_rule__ASN1_SUBTYPE__Group__2__Impl8110); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3999:1: rule__ASN1_SUBTYPE__Group__3 : rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4 ;
    public final void rule__ASN1_SUBTYPE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4003:1: ( rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4004:2: rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__3__Impl_in_rule__ASN1_SUBTYPE__Group__38141);
            rule__ASN1_SUBTYPE__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__4_in_rule__ASN1_SUBTYPE__Group__38144);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4011:1: rule__ASN1_SUBTYPE__Group__3__Impl : ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) ) ;
    public final void rule__ASN1_SUBTYPE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4015:1: ( ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4016:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4016:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4017:1: ( rule__ASN1_SUBTYPE__RangesAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4018:1: ( rule__ASN1_SUBTYPE__RangesAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4018:2: rule__ASN1_SUBTYPE__RangesAssignment_3
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_3_in_rule__ASN1_SUBTYPE__Group__3__Impl8171);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4028:1: rule__ASN1_SUBTYPE__Group__4 : rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5 ;
    public final void rule__ASN1_SUBTYPE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4032:1: ( rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4033:2: rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__4__Impl_in_rule__ASN1_SUBTYPE__Group__48201);
            rule__ASN1_SUBTYPE__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__5_in_rule__ASN1_SUBTYPE__Group__48204);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4040:1: rule__ASN1_SUBTYPE__Group__4__Impl : ( ( rule__ASN1_SUBTYPE__Group_4__0 )* ) ;
    public final void rule__ASN1_SUBTYPE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4044:1: ( ( ( rule__ASN1_SUBTYPE__Group_4__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4045:1: ( ( rule__ASN1_SUBTYPE__Group_4__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4045:1: ( ( rule__ASN1_SUBTYPE__Group_4__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4046:1: ( rule__ASN1_SUBTYPE__Group_4__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getGroup_4()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4047:1: ( rule__ASN1_SUBTYPE__Group_4__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==24) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4047:2: rule__ASN1_SUBTYPE__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__0_in_rule__ASN1_SUBTYPE__Group__4__Impl8231);
            	    rule__ASN1_SUBTYPE__Group_4__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4057:1: rule__ASN1_SUBTYPE__Group__5 : rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6 ;
    public final void rule__ASN1_SUBTYPE__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4061:1: ( rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4062:2: rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__5__Impl_in_rule__ASN1_SUBTYPE__Group__58262);
            rule__ASN1_SUBTYPE__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__6_in_rule__ASN1_SUBTYPE__Group__58265);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4069:1: rule__ASN1_SUBTYPE__Group__5__Impl : ( ')' ) ;
    public final void rule__ASN1_SUBTYPE__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4073:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4074:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4074:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4075:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,29,FOLLOW_29_in_rule__ASN1_SUBTYPE__Group__5__Impl8293); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4088:1: rule__ASN1_SUBTYPE__Group__6 : rule__ASN1_SUBTYPE__Group__6__Impl ;
    public final void rule__ASN1_SUBTYPE__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4092:1: ( rule__ASN1_SUBTYPE__Group__6__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4093:2: rule__ASN1_SUBTYPE__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__6__Impl_in_rule__ASN1_SUBTYPE__Group__68324);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4099:1: rule__ASN1_SUBTYPE__Group__6__Impl : ( ')' ) ;
    public final void rule__ASN1_SUBTYPE__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4103:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4104:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4104:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4105:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,29,FOLLOW_29_in_rule__ASN1_SUBTYPE__Group__6__Impl8352); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4132:1: rule__ASN1_SUBTYPE__Group_4__0 : rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1 ;
    public final void rule__ASN1_SUBTYPE__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4136:1: ( rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4137:2: rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__0__Impl_in_rule__ASN1_SUBTYPE__Group_4__08397);
            rule__ASN1_SUBTYPE__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__1_in_rule__ASN1_SUBTYPE__Group_4__08400);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4144:1: rule__ASN1_SUBTYPE__Group_4__0__Impl : ( '|' ) ;
    public final void rule__ASN1_SUBTYPE__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4148:1: ( ( '|' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4149:1: ( '|' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4149:1: ( '|' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4150:1: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getVerticalLineKeyword_4_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__ASN1_SUBTYPE__Group_4__0__Impl8428); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4163:1: rule__ASN1_SUBTYPE__Group_4__1 : rule__ASN1_SUBTYPE__Group_4__1__Impl ;
    public final void rule__ASN1_SUBTYPE__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4167:1: ( rule__ASN1_SUBTYPE__Group_4__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4168:2: rule__ASN1_SUBTYPE__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__1__Impl_in_rule__ASN1_SUBTYPE__Group_4__18459);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4174:1: rule__ASN1_SUBTYPE__Group_4__1__Impl : ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) ) ;
    public final void rule__ASN1_SUBTYPE__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4178:1: ( ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4179:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4179:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4180:1: ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_4_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4181:1: ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4181:2: rule__ASN1_SUBTYPE__RangesAssignment_4_1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_4_1_in_rule__ASN1_SUBTYPE__Group_4__1__Impl8486);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4195:1: rule__ASN1_RANGE__Group_0__0 : rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1 ;
    public final void rule__ASN1_RANGE__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4199:1: ( rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4200:2: rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__0__Impl_in_rule__ASN1_RANGE__Group_0__08520);
            rule__ASN1_RANGE__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__1_in_rule__ASN1_RANGE__Group_0__08523);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4207:1: rule__ASN1_RANGE__Group_0__0__Impl : ( () ) ;
    public final void rule__ASN1_RANGE__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4211:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4212:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4212:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4213:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4214:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4216:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4226:1: rule__ASN1_RANGE__Group_0__1 : rule__ASN1_RANGE__Group_0__1__Impl ;
    public final void rule__ASN1_RANGE__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4230:1: ( rule__ASN1_RANGE__Group_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4231:2: rule__ASN1_RANGE__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__1__Impl_in_rule__ASN1_RANGE__Group_0__18581);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4237:1: rule__ASN1_RANGE__Group_0__1__Impl : ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) ) ;
    public final void rule__ASN1_RANGE__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4241:1: ( ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4242:1: ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4242:1: ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4243:1: ( rule__ASN1_RANGE__ValueAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getValueAssignment_0_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4244:1: ( rule__ASN1_RANGE__ValueAssignment_0_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4244:2: rule__ASN1_RANGE__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__ValueAssignment_0_1_in_rule__ASN1_RANGE__Group_0__1__Impl8608);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4258:1: rule__ASN1_RANGE__Group_1__0 : rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1 ;
    public final void rule__ASN1_RANGE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4262:1: ( rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4263:2: rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__0__Impl_in_rule__ASN1_RANGE__Group_1__08642);
            rule__ASN1_RANGE__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__1_in_rule__ASN1_RANGE__Group_1__08645);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4270:1: rule__ASN1_RANGE__Group_1__0__Impl : ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) ) ;
    public final void rule__ASN1_RANGE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4274:1: ( ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4275:1: ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4275:1: ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4276:1: ( rule__ASN1_RANGE__StartAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getStartAssignment_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4277:1: ( rule__ASN1_RANGE__StartAssignment_1_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4277:2: rule__ASN1_RANGE__StartAssignment_1_0
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__StartAssignment_1_0_in_rule__ASN1_RANGE__Group_1__0__Impl8672);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4287:1: rule__ASN1_RANGE__Group_1__1 : rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2 ;
    public final void rule__ASN1_RANGE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4291:1: ( rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4292:2: rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__1__Impl_in_rule__ASN1_RANGE__Group_1__18702);
            rule__ASN1_RANGE__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__2_in_rule__ASN1_RANGE__Group_1__18705);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4299:1: rule__ASN1_RANGE__Group_1__1__Impl : ( '..' ) ;
    public final void rule__ASN1_RANGE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4303:1: ( ( '..' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4304:1: ( '..' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4304:1: ( '..' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4305:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_1_1()); 
            }
            match(input,34,FOLLOW_34_in_rule__ASN1_RANGE__Group_1__1__Impl8733); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4318:1: rule__ASN1_RANGE__Group_1__2 : rule__ASN1_RANGE__Group_1__2__Impl ;
    public final void rule__ASN1_RANGE__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4322:1: ( rule__ASN1_RANGE__Group_1__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4323:2: rule__ASN1_RANGE__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__2__Impl_in_rule__ASN1_RANGE__Group_1__28764);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4329:1: rule__ASN1_RANGE__Group_1__2__Impl : ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) ) ;
    public final void rule__ASN1_RANGE__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4333:1: ( ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4334:1: ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4334:1: ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4335:1: ( rule__ASN1_RANGE__EndAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getEndAssignment_1_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4336:1: ( rule__ASN1_RANGE__EndAssignment_1_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4336:2: rule__ASN1_RANGE__EndAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__EndAssignment_1_2_in_rule__ASN1_RANGE__Group_1__2__Impl8791);
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


    // $ANTLR start "rule__ASN1_CHOICE__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4353:1: rule__ASN1_CHOICE__Group__0 : rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1 ;
    public final void rule__ASN1_CHOICE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4357:1: ( rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4358:2: rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__0__Impl_in_rule__ASN1_CHOICE__Group__08828);
            rule__ASN1_CHOICE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__1_in_rule__ASN1_CHOICE__Group__08831);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4365:1: rule__ASN1_CHOICE__Group__0__Impl : ( 'CHOICE' ) ;
    public final void rule__ASN1_CHOICE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4369:1: ( ( 'CHOICE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4370:1: ( 'CHOICE' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4370:1: ( 'CHOICE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4371:1: 'CHOICE'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__ASN1_CHOICE__Group__0__Impl8859); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4384:1: rule__ASN1_CHOICE__Group__1 : rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2 ;
    public final void rule__ASN1_CHOICE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4388:1: ( rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4389:2: rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__1__Impl_in_rule__ASN1_CHOICE__Group__18890);
            rule__ASN1_CHOICE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__2_in_rule__ASN1_CHOICE__Group__18893);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4396:1: rule__ASN1_CHOICE__Group__1__Impl : ( '{' ) ;
    public final void rule__ASN1_CHOICE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4400:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4401:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4401:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4402:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,21,FOLLOW_21_in_rule__ASN1_CHOICE__Group__1__Impl8921); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4415:1: rule__ASN1_CHOICE__Group__2 : rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3 ;
    public final void rule__ASN1_CHOICE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4419:1: ( rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4420:2: rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__2__Impl_in_rule__ASN1_CHOICE__Group__28952);
            rule__ASN1_CHOICE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__3_in_rule__ASN1_CHOICE__Group__28955);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4427:1: rule__ASN1_CHOICE__Group__2__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__ASN1_CHOICE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4431:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4432:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4432:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4433:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4433:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4434:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4435:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4435:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group__2__Impl8985); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_2()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4438:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4439:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4440:1: ( RULE_NEWLINE )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_NEWLINE) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4440:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group__2__Impl8998); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_2()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group__2__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4451:1: rule__ASN1_CHOICE__Group__3 : rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4 ;
    public final void rule__ASN1_CHOICE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4455:1: ( rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4456:2: rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__3__Impl_in_rule__ASN1_CHOICE__Group__39031);
            rule__ASN1_CHOICE__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__4_in_rule__ASN1_CHOICE__Group__39034);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4463:1: rule__ASN1_CHOICE__Group__3__Impl : ( ( rule__ASN1_CHOICE__ChoiceTypeAssignment_3 ) ) ;
    public final void rule__ASN1_CHOICE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4467:1: ( ( ( rule__ASN1_CHOICE__ChoiceTypeAssignment_3 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4468:1: ( ( rule__ASN1_CHOICE__ChoiceTypeAssignment_3 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4468:1: ( ( rule__ASN1_CHOICE__ChoiceTypeAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4469:1: ( rule__ASN1_CHOICE__ChoiceTypeAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4470:1: ( rule__ASN1_CHOICE__ChoiceTypeAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4470:2: rule__ASN1_CHOICE__ChoiceTypeAssignment_3
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__ChoiceTypeAssignment_3_in_rule__ASN1_CHOICE__Group__3__Impl9061);
            rule__ASN1_CHOICE__ChoiceTypeAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeAssignment_3()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4480:1: rule__ASN1_CHOICE__Group__4 : rule__ASN1_CHOICE__Group__4__Impl rule__ASN1_CHOICE__Group__5 ;
    public final void rule__ASN1_CHOICE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4484:1: ( rule__ASN1_CHOICE__Group__4__Impl rule__ASN1_CHOICE__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4485:2: rule__ASN1_CHOICE__Group__4__Impl rule__ASN1_CHOICE__Group__5
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__4__Impl_in_rule__ASN1_CHOICE__Group__49091);
            rule__ASN1_CHOICE__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__5_in_rule__ASN1_CHOICE__Group__49094);
            rule__ASN1_CHOICE__Group__5();

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4492:1: rule__ASN1_CHOICE__Group__4__Impl : ( ( rule__ASN1_CHOICE__Group_4__0 )* ) ;
    public final void rule__ASN1_CHOICE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4496:1: ( ( ( rule__ASN1_CHOICE__Group_4__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4497:1: ( ( rule__ASN1_CHOICE__Group_4__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4497:1: ( ( rule__ASN1_CHOICE__Group_4__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4498:1: ( rule__ASN1_CHOICE__Group_4__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getGroup_4()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4499:1: ( rule__ASN1_CHOICE__Group_4__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==36) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4499:2: rule__ASN1_CHOICE__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_4__0_in_rule__ASN1_CHOICE__Group__4__Impl9121);
            	    rule__ASN1_CHOICE__Group_4__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getGroup_4()); 
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


    // $ANTLR start "rule__ASN1_CHOICE__Group__5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4509:1: rule__ASN1_CHOICE__Group__5 : rule__ASN1_CHOICE__Group__5__Impl rule__ASN1_CHOICE__Group__6 ;
    public final void rule__ASN1_CHOICE__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4513:1: ( rule__ASN1_CHOICE__Group__5__Impl rule__ASN1_CHOICE__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4514:2: rule__ASN1_CHOICE__Group__5__Impl rule__ASN1_CHOICE__Group__6
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__5__Impl_in_rule__ASN1_CHOICE__Group__59152);
            rule__ASN1_CHOICE__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__6_in_rule__ASN1_CHOICE__Group__59155);
            rule__ASN1_CHOICE__Group__6();

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
    // $ANTLR end "rule__ASN1_CHOICE__Group__5"


    // $ANTLR start "rule__ASN1_CHOICE__Group__5__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4521:1: rule__ASN1_CHOICE__Group__5__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__ASN1_CHOICE__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4525:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4526:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4526:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4527:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4527:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4528:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_5()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4529:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4529:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group__5__Impl9185); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_5()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4532:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4533:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_5()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4534:1: ( RULE_NEWLINE )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_NEWLINE) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4534:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group__5__Impl9198); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_5()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group__5__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group__6"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4545:1: rule__ASN1_CHOICE__Group__6 : rule__ASN1_CHOICE__Group__6__Impl ;
    public final void rule__ASN1_CHOICE__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4549:1: ( rule__ASN1_CHOICE__Group__6__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4550:2: rule__ASN1_CHOICE__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__6__Impl_in_rule__ASN1_CHOICE__Group__69231);
            rule__ASN1_CHOICE__Group__6__Impl();

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
    // $ANTLR end "rule__ASN1_CHOICE__Group__6"


    // $ANTLR start "rule__ASN1_CHOICE__Group__6__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4556:1: rule__ASN1_CHOICE__Group__6__Impl : ( '}' ) ;
    public final void rule__ASN1_CHOICE__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4560:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4561:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4561:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4562:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,22,FOLLOW_22_in_rule__ASN1_CHOICE__Group__6__Impl9259); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getRightCurlyBracketKeyword_6()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group__6__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group_4__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4589:1: rule__ASN1_CHOICE__Group_4__0 : rule__ASN1_CHOICE__Group_4__0__Impl rule__ASN1_CHOICE__Group_4__1 ;
    public final void rule__ASN1_CHOICE__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4593:1: ( rule__ASN1_CHOICE__Group_4__0__Impl rule__ASN1_CHOICE__Group_4__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4594:2: rule__ASN1_CHOICE__Group_4__0__Impl rule__ASN1_CHOICE__Group_4__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_4__0__Impl_in_rule__ASN1_CHOICE__Group_4__09304);
            rule__ASN1_CHOICE__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_4__1_in_rule__ASN1_CHOICE__Group_4__09307);
            rule__ASN1_CHOICE__Group_4__1();

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
    // $ANTLR end "rule__ASN1_CHOICE__Group_4__0"


    // $ANTLR start "rule__ASN1_CHOICE__Group_4__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4601:1: rule__ASN1_CHOICE__Group_4__0__Impl : ( ',' ) ;
    public final void rule__ASN1_CHOICE__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4605:1: ( ( ',' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4606:1: ( ',' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4606:1: ( ',' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4607:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_4_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__ASN1_CHOICE__Group_4__0__Impl9335); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_4_0()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group_4__0__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group_4__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4620:1: rule__ASN1_CHOICE__Group_4__1 : rule__ASN1_CHOICE__Group_4__1__Impl rule__ASN1_CHOICE__Group_4__2 ;
    public final void rule__ASN1_CHOICE__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4624:1: ( rule__ASN1_CHOICE__Group_4__1__Impl rule__ASN1_CHOICE__Group_4__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4625:2: rule__ASN1_CHOICE__Group_4__1__Impl rule__ASN1_CHOICE__Group_4__2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_4__1__Impl_in_rule__ASN1_CHOICE__Group_4__19366);
            rule__ASN1_CHOICE__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_4__2_in_rule__ASN1_CHOICE__Group_4__19369);
            rule__ASN1_CHOICE__Group_4__2();

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
    // $ANTLR end "rule__ASN1_CHOICE__Group_4__1"


    // $ANTLR start "rule__ASN1_CHOICE__Group_4__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4632:1: rule__ASN1_CHOICE__Group_4__1__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__ASN1_CHOICE__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4636:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4637:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4637:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4638:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4638:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4639:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_4_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4640:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4640:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group_4__1__Impl9399); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_4_1()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4643:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4644:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_4_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4645:1: ( RULE_NEWLINE )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_NEWLINE) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4645:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group_4__1__Impl9412); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_4_1()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group_4__1__Impl"


    // $ANTLR start "rule__ASN1_CHOICE__Group_4__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4656:1: rule__ASN1_CHOICE__Group_4__2 : rule__ASN1_CHOICE__Group_4__2__Impl ;
    public final void rule__ASN1_CHOICE__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4660:1: ( rule__ASN1_CHOICE__Group_4__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4661:2: rule__ASN1_CHOICE__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_4__2__Impl_in_rule__ASN1_CHOICE__Group_4__29445);
            rule__ASN1_CHOICE__Group_4__2__Impl();

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
    // $ANTLR end "rule__ASN1_CHOICE__Group_4__2"


    // $ANTLR start "rule__ASN1_CHOICE__Group_4__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4667:1: rule__ASN1_CHOICE__Group_4__2__Impl : ( ( rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2 ) ) ;
    public final void rule__ASN1_CHOICE__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4671:1: ( ( ( rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4672:1: ( ( rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4672:1: ( ( rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4673:1: ( rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeAssignment_4_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4674:1: ( rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4674:2: rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2_in_rule__ASN1_CHOICE__Group_4__2__Impl9472);
            rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeAssignment_4_2()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__Group_4__2__Impl"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4690:1: rule__ASN1_CHOICE_ENTRY__Group__0 : rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1 ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4694:1: ( rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4695:2: rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__09508);
            rule__ASN1_CHOICE_ENTRY__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1_in_rule__ASN1_CHOICE_ENTRY__Group__09511);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4702:1: rule__ASN1_CHOICE_ENTRY__Group__0__Impl : ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4706:1: ( ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4707:1: ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4707:1: ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4708:1: ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4709:1: ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4709:2: rule__ASN1_CHOICE_ENTRY__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__IdAssignment_0_in_rule__ASN1_CHOICE_ENTRY__Group__0__Impl9538);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4719:1: rule__ASN1_CHOICE_ENTRY__Group__1 : rule__ASN1_CHOICE_ENTRY__Group__1__Impl rule__ASN1_CHOICE_ENTRY__Group__2 ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4723:1: ( rule__ASN1_CHOICE_ENTRY__Group__1__Impl rule__ASN1_CHOICE_ENTRY__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4724:2: rule__ASN1_CHOICE_ENTRY__Group__1__Impl rule__ASN1_CHOICE_ENTRY__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__19568);
            rule__ASN1_CHOICE_ENTRY__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__2_in_rule__ASN1_CHOICE_ENTRY__Group__19571);
            rule__ASN1_CHOICE_ENTRY__Group__2();

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4731:1: rule__ASN1_CHOICE_ENTRY__Group__1__Impl : ( ( RULE_NEWLINE )? ) ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4735:1: ( ( ( RULE_NEWLINE )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4736:1: ( ( RULE_NEWLINE )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4736:1: ( ( RULE_NEWLINE )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4737:1: ( RULE_NEWLINE )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getNEWLINETerminalRuleCall_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4738:1: ( RULE_NEWLINE )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_NEWLINE) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4738:3: RULE_NEWLINE
                    {
                    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE_ENTRY__Group__1__Impl9599); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getNEWLINETerminalRuleCall_1()); 
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


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__Group__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4748:1: rule__ASN1_CHOICE_ENTRY__Group__2 : rule__ASN1_CHOICE_ENTRY__Group__2__Impl ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4752:1: ( rule__ASN1_CHOICE_ENTRY__Group__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4753:2: rule__ASN1_CHOICE_ENTRY__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__2__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__29630);
            rule__ASN1_CHOICE_ENTRY__Group__2__Impl();

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
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__Group__2"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__Group__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4759:1: rule__ASN1_CHOICE_ENTRY__Group__2__Impl : ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2 ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4763:1: ( ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4764:1: ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4764:1: ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4765:1: ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4766:1: ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4766:2: rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2_in_rule__ASN1_CHOICE_ENTRY__Group__2__Impl9657);
            rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeAssignment_2()); 
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
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__Group__2__Impl"


    // $ANTLR start "rule__Module__NameAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4783:1: rule__Module__NameAssignment_0 : ( RULE_MODULE_ID ) ;
    public final void rule__Module__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4787:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4788:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4788:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4789:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNameMODULE_IDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__Module__NameAssignment_09698); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getNameMODULE_IDTerminalRuleCall_0_0()); 
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
    // $ANTLR end "rule__Module__NameAssignment_0"


    // $ANTLR start "rule__Module__IdentifiersAssignment_5_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4798:1: rule__Module__IdentifiersAssignment_5_0 : ( ruleObjectIdentifier ) ;
    public final void rule__Module__IdentifiersAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4802:1: ( ( ruleObjectIdentifier ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4803:1: ( ruleObjectIdentifier )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4803:1: ( ruleObjectIdentifier )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4804:1: ruleObjectIdentifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getIdentifiersObjectIdentifierParserRuleCall_5_0_0()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifier_in_rule__Module__IdentifiersAssignment_5_09729);
            ruleObjectIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getIdentifiersObjectIdentifierParserRuleCall_5_0_0()); 
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
    // $ANTLR end "rule__Module__IdentifiersAssignment_5_0"


    // $ANTLR start "rule__Module__TypesAssignment_5_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4813:1: rule__Module__TypesAssignment_5_1 : ( ruleTypeDefinition ) ;
    public final void rule__Module__TypesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4817:1: ( ( ruleTypeDefinition ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4818:1: ( ruleTypeDefinition )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4818:1: ( ruleTypeDefinition )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4819:1: ruleTypeDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getTypesTypeDefinitionParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_rule__Module__TypesAssignment_5_19760);
            ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getTypesTypeDefinitionParserRuleCall_5_1_0()); 
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
    // $ANTLR end "rule__Module__TypesAssignment_5_1"


    // $ANTLR start "rule__Module__MacrosAssignment_5_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4828:1: rule__Module__MacrosAssignment_5_2 : ( ruleMacro ) ;
    public final void rule__Module__MacrosAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4832:1: ( ( ruleMacro ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4833:1: ( ruleMacro )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4833:1: ( ruleMacro )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4834:1: ruleMacro
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getMacrosMacroParserRuleCall_5_2_0()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_rule__Module__MacrosAssignment_5_29791);
            ruleMacro();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getMacrosMacroParserRuleCall_5_2_0()); 
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
    // $ANTLR end "rule__Module__MacrosAssignment_5_2"


    // $ANTLR start "rule__ObjectIdentifier__NameAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4843:1: rule__ObjectIdentifier__NameAssignment_1 : ( RULE_ASN1_ID ) ;
    public final void rule__ObjectIdentifier__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4847:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4848:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4848:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4849:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNameASN1_IDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifier__NameAssignment_19822); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getNameASN1_IDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__ObjectIdentifier__NameAssignment_1"


    // $ANTLR start "rule__ObjectIdentifier__OidValueAssignment_5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4858:1: rule__ObjectIdentifier__OidValueAssignment_5 : ( ruleObjectIdentifierValue ) ;
    public final void rule__ObjectIdentifier__OidValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4862:1: ( ( ruleObjectIdentifierValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4863:1: ( ruleObjectIdentifierValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4863:1: ( ruleObjectIdentifierValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4864:1: ruleObjectIdentifierValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_rule__ObjectIdentifier__OidValueAssignment_59853);
            ruleObjectIdentifierValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_5_0()); 
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
    // $ANTLR end "rule__ObjectIdentifier__OidValueAssignment_5"


    // $ANTLR start "rule__ObjectIdentifierValue__NameAssignment_0_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4873:1: rule__ObjectIdentifierValue__NameAssignment_0_0 : ( RULE_ASN1_ID ) ;
    public final void rule__ObjectIdentifierValue__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4877:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4878:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4878:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4879:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getNameASN1_IDTerminalRuleCall_0_0_0()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__NameAssignment_0_09884); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getNameASN1_IDTerminalRuleCall_0_0_0()); 
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
    // $ANTLR end "rule__ObjectIdentifierValue__NameAssignment_0_0"


    // $ANTLR start "rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4888:1: rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 : ( ( RULE_ASN1_ID ) ) ;
    public final void rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4892:1: ( ( ( RULE_ASN1_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4893:1: ( ( RULE_ASN1_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4893:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4894:1: ( RULE_ASN1_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4895:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4896:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierASN1_IDTerminalRuleCall_0_1_0_1()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_19919); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierASN1_IDTerminalRuleCall_0_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_1_0()); 
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
    // $ANTLR end "rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1"


    // $ANTLR start "rule__ObjectIdentifierValue__SubIdsAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4907:1: rule__ObjectIdentifierValue__SubIdsAssignment_1 : ( RULE_BIG_INTEGER ) ;
    public final void rule__ObjectIdentifierValue__SubIdsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4911:1: ( ( RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4912:1: ( RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4912:1: ( RULE_BIG_INTEGER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4913:1: RULE_BIG_INTEGER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsBIG_INTEGERTerminalRuleCall_1_0()); 
            }
            match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_rule__ObjectIdentifierValue__SubIdsAssignment_19954); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getSubIdsBIG_INTEGERTerminalRuleCall_1_0()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4922:1: rule__ObjectIdentifierValue__SubIdsAssignment_2 : ( RULE_BIG_INTEGER ) ;
    public final void rule__ObjectIdentifierValue__SubIdsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4926:1: ( ( RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4927:1: ( RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4927:1: ( RULE_BIG_INTEGER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4928:1: RULE_BIG_INTEGER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsBIG_INTEGERTerminalRuleCall_2_0()); 
            }
            match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_rule__ObjectIdentifierValue__SubIdsAssignment_29985); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getSubIdsBIG_INTEGERTerminalRuleCall_2_0()); 
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


    // $ANTLR start "rule__TypeDefinition__NameAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4937:1: rule__TypeDefinition__NameAssignment_1 : ( RULE_MODULE_ID ) ;
    public final void rule__TypeDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4941:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4942:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4942:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4943:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNameMODULE_IDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__TypeDefinition__NameAssignment_110016); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getNameMODULE_IDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__TypeDefinition__NameAssignment_1"


    // $ANTLR start "rule__TypeDefinition__ValuesAssignment_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4952:1: rule__TypeDefinition__ValuesAssignment_3 : ( ruleValue ) ;
    public final void rule__TypeDefinition__ValuesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4956:1: ( ( ruleValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4957:1: ( ruleValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4957:1: ( ruleValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4958:1: ruleValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getValuesValueParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleValue_in_rule__TypeDefinition__ValuesAssignment_310047);
            ruleValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getValuesValueParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__TypeDefinition__ValuesAssignment_3"


    // $ANTLR start "rule__Macro__NameAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4967:1: rule__Macro__NameAssignment_1 : ( RULE_MODULE_ID ) ;
    public final void rule__Macro__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4971:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4972:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4972:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4973:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNameMODULE_IDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__Macro__NameAssignment_110078); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNameMODULE_IDTerminalRuleCall_1_0()); 
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
    // $ANTLR end "rule__Macro__NameAssignment_1"


    // $ANTLR start "rule__Macro__TypeNotationAssignment_6"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4982:1: rule__Macro__TypeNotationAssignment_6 : ( ruleTypeNotation ) ;
    public final void rule__Macro__TypeNotationAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4986:1: ( ( ruleTypeNotation ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4987:1: ( ruleTypeNotation )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4987:1: ( ruleTypeNotation )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4988:1: ruleTypeNotation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTypeNotationTypeNotationParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_rule__Macro__TypeNotationAssignment_610109);
            ruleTypeNotation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getTypeNotationTypeNotationParserRuleCall_6_0()); 
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
    // $ANTLR end "rule__Macro__TypeNotationAssignment_6"


    // $ANTLR start "rule__Macro__ValueNotationAssignment_7"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4997:1: rule__Macro__ValueNotationAssignment_7 : ( ruleValueNotation ) ;
    public final void rule__Macro__ValueNotationAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5001:1: ( ( ruleValueNotation ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5002:1: ( ruleValueNotation )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5002:1: ( ruleValueNotation )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5003:1: ruleValueNotation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getValueNotationValueNotationParserRuleCall_7_0()); 
            }
            pushFollow(FOLLOW_ruleValueNotation_in_rule__Macro__ValueNotationAssignment_710140);
            ruleValueNotation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getValueNotationValueNotationParserRuleCall_7_0()); 
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
    // $ANTLR end "rule__Macro__ValueNotationAssignment_7"


    // $ANTLR start "rule__Macro__InnerTypesAssignment_8"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5012:1: rule__Macro__InnerTypesAssignment_8 : ( ruleTypeDefinition ) ;
    public final void rule__Macro__InnerTypesAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5016:1: ( ( ruleTypeDefinition ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5017:1: ( ruleTypeDefinition )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5017:1: ( ruleTypeDefinition )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5018:1: ruleTypeDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_8_0()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_rule__Macro__InnerTypesAssignment_810171);
            ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_8_0()); 
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
    // $ANTLR end "rule__Macro__InnerTypesAssignment_8"


    // $ANTLR start "rule__TypeNotation__NameAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5027:1: rule__TypeNotation__NameAssignment_1 : ( ( 'TYPE NOTATION' ) ) ;
    public final void rule__TypeNotation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5031:1: ( ( ( 'TYPE NOTATION' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5032:1: ( ( 'TYPE NOTATION' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5032:1: ( ( 'TYPE NOTATION' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5033:1: ( 'TYPE NOTATION' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getNameTYPENOTATIONKeyword_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5034:1: ( 'TYPE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5035:1: 'TYPE NOTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getNameTYPENOTATIONKeyword_1_0()); 
            }
            match(input,37,FOLLOW_37_in_rule__TypeNotation__NameAssignment_110207); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getNameTYPENOTATIONKeyword_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getNameTYPENOTATIONKeyword_1_0()); 
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
    // $ANTLR end "rule__TypeNotation__NameAssignment_1"


    // $ANTLR start "rule__TypeNotation__TypeNotationsAssignment_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5050:1: rule__TypeNotation__TypeNotationsAssignment_3 : ( ruleTypeAssignment ) ;
    public final void rule__TypeNotation__TypeNotationsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5054:1: ( ( ruleTypeAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5055:1: ( ruleTypeAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5055:1: ( ruleTypeAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5056:1: ruleTypeAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getTypeNotationsTypeAssignmentParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_rule__TypeNotation__TypeNotationsAssignment_310246);
            ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationAccess().getTypeNotationsTypeAssignmentParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__TypeNotation__TypeNotationsAssignment_3"


    // $ANTLR start "rule__ValueNotation__NameAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5065:1: rule__ValueNotation__NameAssignment_1 : ( ( 'VALUE NOTATION' ) ) ;
    public final void rule__ValueNotation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5069:1: ( ( ( 'VALUE NOTATION' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5070:1: ( ( 'VALUE NOTATION' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5070:1: ( ( 'VALUE NOTATION' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5071:1: ( 'VALUE NOTATION' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueNotationAccess().getNameVALUENOTATIONKeyword_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5072:1: ( 'VALUE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5073:1: 'VALUE NOTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueNotationAccess().getNameVALUENOTATIONKeyword_1_0()); 
            }
            match(input,38,FOLLOW_38_in_rule__ValueNotation__NameAssignment_110282); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueNotationAccess().getNameVALUENOTATIONKeyword_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueNotationAccess().getNameVALUENOTATIONKeyword_1_0()); 
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
    // $ANTLR end "rule__ValueNotation__NameAssignment_1"


    // $ANTLR start "rule__ValueNotation__ValueNotationAssignment_4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5088:1: rule__ValueNotation__ValueNotationAssignment_4 : ( ruleMacroValue ) ;
    public final void rule__ValueNotation__ValueNotationAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5092:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5093:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5093:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5094:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueNotationAccess().getValueNotationMacroValueParserRuleCall_4_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__ValueNotation__ValueNotationAssignment_410321);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueNotationAccess().getValueNotationMacroValueParserRuleCall_4_0()); 
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
    // $ANTLR end "rule__ValueNotation__ValueNotationAssignment_4"


    // $ANTLR start "rule__ParamAssignment__ParamAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5103:1: rule__ParamAssignment__ParamAssignment_0 : ( RULE_PARAMETER ) ;
    public final void rule__ParamAssignment__ParamAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5107:1: ( ( RULE_PARAMETER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5108:1: ( RULE_PARAMETER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5108:1: ( RULE_PARAMETER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5109:1: RULE_PARAMETER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getParamPARAMETERTerminalRuleCall_0_0()); 
            }
            match(input,RULE_PARAMETER,FOLLOW_RULE_PARAMETER_in_rule__ParamAssignment__ParamAssignment_010352); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5118:1: rule__ParamAssignment__RightAssignment_1 : ( ruleTypeNotationRight ) ;
    public final void rule__ParamAssignment__RightAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5122:1: ( ( ruleTypeNotationRight ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5123:1: ( ruleTypeNotationRight )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5123:1: ( ruleTypeNotationRight )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5124:1: ruleTypeNotationRight
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getRightTypeNotationRightParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeNotationRight_in_rule__ParamAssignment__RightAssignment_110383);
            ruleTypeNotationRight();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAssignmentAccess().getRightTypeNotationRightParserRuleCall_1_0()); 
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


    // $ANTLR start "rule__TypeNotationRight__ValueAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5133:1: rule__TypeNotationRight__ValueAssignment_1 : ( ruleMacroValue ) ;
    public final void rule__TypeNotationRight__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5137:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5138:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5138:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5139:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationRightAccess().getValueMacroValueParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__TypeNotationRight__ValueAssignment_110414);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationRightAccess().getValueMacroValueParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__TypeNotationRight__ValueAssignment_1"


    // $ANTLR start "rule__TypeReferenceExt__ParentRefAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5148:1: rule__TypeReferenceExt__ParentRefAssignment_0 : ( ruleTypeReference ) ;
    public final void rule__TypeReferenceExt__ParentRefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5152:1: ( ( ruleTypeReference ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5153:1: ( ruleTypeReference )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5153:1: ( ruleTypeReference )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5154:1: ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getParentRefTypeReferenceParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ParentRefAssignment_010445);
            ruleTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceExtAccess().getParentRefTypeReferenceParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__TypeReferenceExt__ParentRefAssignment_0"


    // $ANTLR start "rule__TypeReferenceExt__ChildRefAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5163:1: rule__TypeReferenceExt__ChildRefAssignment_1 : ( ruleTypeReference ) ;
    public final void rule__TypeReferenceExt__ChildRefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5167:1: ( ( ruleTypeReference ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5168:1: ( ruleTypeReference )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5168:1: ( ruleTypeReference )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5169:1: ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getChildRefTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ChildRefAssignment_110476);
            ruleTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceExtAccess().getChildRefTypeReferenceParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__TypeReferenceExt__ChildRefAssignment_1"


    // $ANTLR start "rule__TypeReference__TypeAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5178:1: rule__TypeReference__TypeAssignment : ( ( RULE_MODULE_ID ) ) ;
    public final void rule__TypeReference__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5182:1: ( ( ( RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5183:1: ( ( RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5183:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5184:1: ( RULE_MODULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceAccess().getTypeTypeDefinitionCrossReference_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5185:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5186:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceAccess().getTypeTypeDefinitionMODULE_IDTerminalRuleCall_0_1()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__TypeReference__TypeAssignment10511); if (state.failed) return ;
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


    // $ANTLR start "rule__Value__TagAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5197:1: rule__Value__TagAssignment_0 : ( ruleTag ) ;
    public final void rule__Value__TagAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5201:1: ( ( ruleTag ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5202:1: ( ruleTag )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5202:1: ( ruleTag )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5203:1: ruleTag
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getTagTagParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleTag_in_rule__Value__TagAssignment_010546);
            ruleTag();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getTagTagParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__Value__TagAssignment_0"


    // $ANTLR start "rule__Value__ImplicitAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5212:1: rule__Value__ImplicitAssignment_2 : ( ( 'IMPLICIT' ) ) ;
    public final void rule__Value__ImplicitAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5216:1: ( ( ( 'IMPLICIT' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5217:1: ( ( 'IMPLICIT' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5217:1: ( ( 'IMPLICIT' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5218:1: ( 'IMPLICIT' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getImplicitIMPLICITKeyword_2_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5219:1: ( 'IMPLICIT' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5220:1: 'IMPLICIT'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getImplicitIMPLICITKeyword_2_0()); 
            }
            match(input,39,FOLLOW_39_in_rule__Value__ImplicitAssignment_210582); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getImplicitIMPLICITKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getImplicitIMPLICITKeyword_2_0()); 
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
    // $ANTLR end "rule__Value__ImplicitAssignment_2"


    // $ANTLR start "rule__Value__ValueTypesAssignment_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5235:1: rule__Value__ValueTypesAssignment_3 : ( ruleValueType ) ;
    public final void rule__Value__ValueTypesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5239:1: ( ( ruleValueType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5240:1: ( ruleValueType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5240:1: ( ruleValueType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5241:1: ruleValueType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_310621);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__Value__ValueTypesAssignment_3"


    // $ANTLR start "rule__Value__ValueTypesAssignment_4_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5250:1: rule__Value__ValueTypesAssignment_4_2 : ( ruleValueType ) ;
    public final void rule__Value__ValueTypesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5254:1: ( ( ruleValueType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5255:1: ( ruleValueType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5255:1: ( ruleValueType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5256:1: ruleValueType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_4_2_0()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_4_210652);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_4_2_0()); 
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
    // $ANTLR end "rule__Value__ValueTypesAssignment_4_2"


    // $ANTLR start "rule__Tag__TagValueAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5265:1: rule__Tag__TagValueAssignment_2 : ( RULE_BIG_INTEGER ) ;
    public final void rule__Tag__TagValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5269:1: ( ( RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5270:1: ( RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5270:1: ( RULE_BIG_INTEGER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5271:1: RULE_BIG_INTEGER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTagAccess().getTagValueBIG_INTEGERTerminalRuleCall_2_0()); 
            }
            match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_rule__Tag__TagValueAssignment_210683); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTagAccess().getTagValueBIG_INTEGERTerminalRuleCall_2_0()); 
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
    // $ANTLR end "rule__Tag__TagValueAssignment_2"


    // $ANTLR start "rule__ValueType__ParamAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5280:1: rule__ValueType__ParamAssignment_0 : ( ruleParamAssignment ) ;
    public final void rule__ValueType__ParamAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5284:1: ( ( ruleParamAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5285:1: ( ruleParamAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5285:1: ( ruleParamAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5286:1: ruleParamAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_rule__ValueType__ParamAssignment_010714);
            ruleParamAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__ValueType__ParamAssignment_0"


    // $ANTLR start "rule__ValueType__TypesAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5295:1: rule__ValueType__TypesAssignment_1 : ( ruleTypeReferenceExt ) ;
    public final void rule__ValueType__TypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5299:1: ( ( ruleTypeReferenceExt ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5300:1: ( ruleTypeReferenceExt )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5300:1: ( ruleTypeReferenceExt )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5301:1: ruleTypeReferenceExt
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypesTypeReferenceExtParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_rule__ValueType__TypesAssignment_110745);
            ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getTypesTypeReferenceExtParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__ValueType__TypesAssignment_1"


    // $ANTLR start "rule__ValueType__SimpleTypeAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5310:1: rule__ValueType__SimpleTypeAssignment_2 : ( ruleASN1_TYPE ) ;
    public final void rule__ValueType__SimpleTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5314:1: ( ( ruleASN1_TYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5315:1: ( ruleASN1_TYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5315:1: ( ruleASN1_TYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5316:1: ruleASN1_TYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_rule__ValueType__SimpleTypeAssignment_210776);
            ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__ValueType__SimpleTypeAssignment_2"


    // $ANTLR start "rule__ValueType__MacroValueAssignment_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5325:1: rule__ValueType__MacroValueAssignment_3 : ( ruleMacroValue ) ;
    public final void rule__ValueType__MacroValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5329:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5330:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5330:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5331:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__ValueType__MacroValueAssignment_310807);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__ValueType__MacroValueAssignment_3"


    // $ANTLR start "rule__ValueType__OiAssignment_4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5340:1: rule__ValueType__OiAssignment_4 : ( ( 'OBJECT IDENTIFIER' ) ) ;
    public final void rule__ValueType__OiAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5344:1: ( ( ( 'OBJECT IDENTIFIER' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5345:1: ( ( 'OBJECT IDENTIFIER' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5345:1: ( ( 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5346:1: ( 'OBJECT IDENTIFIER' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_4_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5347:1: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5348:1: 'OBJECT IDENTIFIER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_4_0()); 
            }
            match(input,20,FOLLOW_20_in_rule__ValueType__OiAssignment_410843); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_4_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_4_0()); 
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
    // $ANTLR end "rule__ValueType__OiAssignment_4"


    // $ANTLR start "rule__MacroValue__ValueTypeAssignment_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5363:1: rule__MacroValue__ValueTypeAssignment_3 : ( ruleMACRO_VALUE_TYPE ) ;
    public final void rule__MacroValue__ValueTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5367:1: ( ( ruleMACRO_VALUE_TYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5368:1: ( ruleMACRO_VALUE_TYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5368:1: ( ruleMACRO_VALUE_TYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5369:1: ruleMACRO_VALUE_TYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getValueTypeMACRO_VALUE_TYPEParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_rule__MacroValue__ValueTypeAssignment_310882);
            ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueAccess().getValueTypeMACRO_VALUE_TYPEParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__MacroValue__ValueTypeAssignment_3"


    // $ANTLR start "rule__MACRO_VALUE_TYPE__UpdateAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5378:1: rule__MACRO_VALUE_TYPE__UpdateAssignment_0 : ( ruleUpdateType ) ;
    public final void rule__MACRO_VALUE_TYPE__UpdateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5382:1: ( ( ruleUpdateType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5383:1: ( ruleUpdateType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5383:1: ( ruleUpdateType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5384:1: ruleUpdateType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateUpdateTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_rule__MACRO_VALUE_TYPE__UpdateAssignment_010913);
            ruleUpdateType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateUpdateTypeParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__MACRO_VALUE_TYPE__UpdateAssignment_0"


    // $ANTLR start "rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5393:1: rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1 : ( ruleMACRO_VALUE_CAP ) ;
    public final void rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5397:1: ( ( ruleMACRO_VALUE_CAP ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5398:1: ( ruleMACRO_VALUE_CAP )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5398:1: ( ruleMACRO_VALUE_CAP )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5399:1: ruleMACRO_VALUE_CAP
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralMACRO_VALUE_CAPParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_rule__MACRO_VALUE_TYPE__LiteralAssignment_1_110944);
            ruleMACRO_VALUE_CAP();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralMACRO_VALUE_CAPParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1"


    // $ANTLR start "rule__MACRO_VALUE_TYPE__StringAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5408:1: rule__MACRO_VALUE_TYPE__StringAssignment_2 : ( ( 'IA5String' ) ) ;
    public final void rule__MACRO_VALUE_TYPE__StringAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5412:1: ( ( ( 'IA5String' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5413:1: ( ( 'IA5String' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5413:1: ( ( 'IA5String' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5414:1: ( 'IA5String' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getStringIA5StringKeyword_2_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5415:1: ( 'IA5String' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5416:1: 'IA5String'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getStringIA5StringKeyword_2_0()); 
            }
            match(input,40,FOLLOW_40_in_rule__MACRO_VALUE_TYPE__StringAssignment_210980); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPEAccess().getStringIA5StringKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPEAccess().getStringIA5StringKeyword_2_0()); 
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
    // $ANTLR end "rule__MACRO_VALUE_TYPE__StringAssignment_2"


    // $ANTLR start "rule__UpdateType__RefAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5431:1: rule__UpdateType__RefAssignment_1 : ( ruleTypeReference ) ;
    public final void rule__UpdateType__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5435:1: ( ( ruleTypeReference ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5436:1: ( ruleTypeReference )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5436:1: ( ruleTypeReference )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5437:1: ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getRefTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_rule__UpdateType__RefAssignment_111019);
            ruleTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateTypeAccess().getRefTypeReferenceParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__UpdateType__RefAssignment_1"


    // $ANTLR start "rule__MACRO_VALUE_CAP__RefAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5446:1: rule__MACRO_VALUE_CAP__RefAssignment_1 : ( ruleTypeReference ) ;
    public final void rule__MACRO_VALUE_CAP__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5450:1: ( ( ruleTypeReference ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5451:1: ( ruleTypeReference )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5451:1: ( ruleTypeReference )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5452:1: ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getRefTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_rule__MACRO_VALUE_CAP__RefAssignment_111050);
            ruleTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPAccess().getRefTypeReferenceParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__MACRO_VALUE_CAP__RefAssignment_1"


    // $ANTLR start "rule__ASN1_SIMPLE__ConstraintAssignment_2_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5461:1: rule__ASN1_SIMPLE__ConstraintAssignment_2_1 : ( ruleASN1_SUBTYPE ) ;
    public final void rule__ASN1_SIMPLE__ConstraintAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5465:1: ( ( ruleASN1_SUBTYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5466:1: ( ruleASN1_SUBTYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5466:1: ( ruleASN1_SUBTYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5467:1: ruleASN1_SUBTYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_rule__ASN1_SIMPLE__ConstraintAssignment_2_111081);
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


    // $ANTLR start "rule__ASN1_OCTET_STRING__NameAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5476:1: rule__ASN1_OCTET_STRING__NameAssignment_1 : ( ( 'OCTET STRING' ) ) ;
    public final void rule__ASN1_OCTET_STRING__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5480:1: ( ( ( 'OCTET STRING' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5481:1: ( ( 'OCTET STRING' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5481:1: ( ( 'OCTET STRING' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5482:1: ( 'OCTET STRING' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getNameOCTETSTRINGKeyword_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5483:1: ( 'OCTET STRING' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5484:1: 'OCTET STRING'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getNameOCTETSTRINGKeyword_1_0()); 
            }
            match(input,41,FOLLOW_41_in_rule__ASN1_OCTET_STRING__NameAssignment_111117); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_OCTET_STRINGAccess().getNameOCTETSTRINGKeyword_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_OCTET_STRINGAccess().getNameOCTETSTRINGKeyword_1_0()); 
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
    // $ANTLR end "rule__ASN1_OCTET_STRING__NameAssignment_1"


    // $ANTLR start "rule__ASN1_INTEGER__NameAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5499:1: rule__ASN1_INTEGER__NameAssignment_0 : ( ( 'INTEGER' ) ) ;
    public final void rule__ASN1_INTEGER__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5503:1: ( ( ( 'INTEGER' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5504:1: ( ( 'INTEGER' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5504:1: ( ( 'INTEGER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5505:1: ( 'INTEGER' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getNameINTEGERKeyword_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5506:1: ( 'INTEGER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5507:1: 'INTEGER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getNameINTEGERKeyword_0_0()); 
            }
            match(input,42,FOLLOW_42_in_rule__ASN1_INTEGER__NameAssignment_011161); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getNameINTEGERKeyword_0_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getNameINTEGERKeyword_0_0()); 
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
    // $ANTLR end "rule__ASN1_INTEGER__NameAssignment_0"


    // $ANTLR start "rule__ASN1_INTEGER__RangeAssignment_1_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5522:1: rule__ASN1_INTEGER__RangeAssignment_1_1 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_INTEGER__RangeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5526:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5527:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5527:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5528:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getRangeASN1_RANGEParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_INTEGER__RangeAssignment_1_111200);
            ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getRangeASN1_RANGEParserRuleCall_1_1_0()); 
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
    // $ANTLR end "rule__ASN1_INTEGER__RangeAssignment_1_1"


    // $ANTLR start "rule__ASN1_SUBTYPE__RangesAssignment_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5537:1: rule__ASN1_SUBTYPE__RangesAssignment_3 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SUBTYPE__RangesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5541:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5542:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5542:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5543:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_311231);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5552:1: rule__ASN1_SUBTYPE__RangesAssignment_4_1 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SUBTYPE__RangesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5556:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5557:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5557:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5558:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_4_111262);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5567:1: rule__ASN1_RANGE__ValueAssignment_0_1 : ( RULE_BIG_INTEGER ) ;
    public final void rule__ASN1_RANGE__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5571:1: ( ( RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5572:1: ( RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5572:1: ( RULE_BIG_INTEGER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5573:1: RULE_BIG_INTEGER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getValueBIG_INTEGERTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_rule__ASN1_RANGE__ValueAssignment_0_111293); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getValueBIG_INTEGERTerminalRuleCall_0_1_0()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5582:1: rule__ASN1_RANGE__StartAssignment_1_0 : ( RULE_BIG_INTEGER ) ;
    public final void rule__ASN1_RANGE__StartAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5586:1: ( ( RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5587:1: ( RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5587:1: ( RULE_BIG_INTEGER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5588:1: RULE_BIG_INTEGER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getStartBIG_INTEGERTerminalRuleCall_1_0_0()); 
            }
            match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_rule__ASN1_RANGE__StartAssignment_1_011324); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getStartBIG_INTEGERTerminalRuleCall_1_0_0()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5597:1: rule__ASN1_RANGE__EndAssignment_1_2 : ( RULE_BIG_INTEGER ) ;
    public final void rule__ASN1_RANGE__EndAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5601:1: ( ( RULE_BIG_INTEGER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5602:1: ( RULE_BIG_INTEGER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5602:1: ( RULE_BIG_INTEGER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5603:1: RULE_BIG_INTEGER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getEndBIG_INTEGERTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_BIG_INTEGER,FOLLOW_RULE_BIG_INTEGER_in_rule__ASN1_RANGE__EndAssignment_1_211355); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGEAccess().getEndBIG_INTEGERTerminalRuleCall_1_2_0()); 
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


    // $ANTLR start "rule__ASN1_CHOICE__ChoiceTypeAssignment_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5612:1: rule__ASN1_CHOICE__ChoiceTypeAssignment_3 : ( ruleASN1_CHOICE_ENTRY ) ;
    public final void rule__ASN1_CHOICE__ChoiceTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5616:1: ( ( ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5617:1: ( ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5617:1: ( ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5618:1: ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoiceTypeAssignment_311386);
            ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_3_0()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__ChoiceTypeAssignment_3"


    // $ANTLR start "rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5627:1: rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2 : ( ruleASN1_CHOICE_ENTRY ) ;
    public final void rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5631:1: ( ( ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5632:1: ( ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5632:1: ( ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5633:1: ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_4_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoiceTypeAssignment_4_211417);
            ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICEAccess().getChoiceTypeASN1_CHOICE_ENTRYParserRuleCall_4_2_0()); 
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
    // $ANTLR end "rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2"


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__IdAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5642:1: rule__ASN1_CHOICE_ENTRY__IdAssignment_0 : ( RULE_ASN1_ID ) ;
    public final void rule__ASN1_CHOICE_ENTRY__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5646:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5647:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5647:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5648:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdASN1_IDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__IdAssignment_011448); if (state.failed) return ;
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


    // $ANTLR start "rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5657:1: rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2 : ( ruleChoiceType ) ;
    public final void rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5661:1: ( ( ruleChoiceType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5662:1: ( ruleChoiceType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5662:1: ( ruleChoiceType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5663:1: ruleChoiceType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeChoiceTypeParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleChoiceType_in_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_211479);
            ruleChoiceType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeChoiceTypeParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2"


    // $ANTLR start "rule__ChoiceType__TypeRefAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5672:1: rule__ChoiceType__TypeRefAssignment_0 : ( ruleTypeReference ) ;
    public final void rule__ChoiceType__TypeRefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5676:1: ( ( ruleTypeReference ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5677:1: ( ruleTypeReference )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5677:1: ( ruleTypeReference )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5678:1: ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getChoiceTypeAccess().getTypeRefTypeReferenceParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_rule__ChoiceType__TypeRefAssignment_011510);
            ruleTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getChoiceTypeAccess().getTypeRefTypeReferenceParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__ChoiceType__TypeRefAssignment_0"


    // $ANTLR start "rule__ChoiceType__SimpleTypeAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5687:1: rule__ChoiceType__SimpleTypeAssignment_1 : ( ruleASN1_TYPE ) ;
    public final void rule__ChoiceType__SimpleTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5691:1: ( ( ruleASN1_TYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5692:1: ( ruleASN1_TYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5692:1: ( ruleASN1_TYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5693:1: ruleASN1_TYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getChoiceTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_rule__ChoiceType__SimpleTypeAssignment_111541);
            ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getChoiceTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_1_0()); 
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
    // $ANTLR end "rule__ChoiceType__SimpleTypeAssignment_1"


    // $ANTLR start "rule__ChoiceType__OiAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5702:1: rule__ChoiceType__OiAssignment_2 : ( ( 'OBJECT IDENTIFIER' ) ) ;
    public final void rule__ChoiceType__OiAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5706:1: ( ( ( 'OBJECT IDENTIFIER' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5707:1: ( ( 'OBJECT IDENTIFIER' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5707:1: ( ( 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5708:1: ( 'OBJECT IDENTIFIER' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getChoiceTypeAccess().getOiOBJECTIDENTIFIERKeyword_2_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5709:1: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5710:1: 'OBJECT IDENTIFIER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getChoiceTypeAccess().getOiOBJECTIDENTIFIERKeyword_2_0()); 
            }
            match(input,20,FOLLOW_20_in_rule__ChoiceType__OiAssignment_211577); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getChoiceTypeAccess().getOiOBJECTIDENTIFIERKeyword_2_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getChoiceTypeAccess().getOiOBJECTIDENTIFIERKeyword_2_0()); 
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
    // $ANTLR end "rule__ChoiceType__OiAssignment_2"

    // $ANTLR start synpred3_InternalSmi
    public final void synpred3_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:888:1: ( ( ( rule__ObjectIdentifierValue__NameAssignment_0_0 ) ) )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:888:1: ( ( rule__ObjectIdentifierValue__NameAssignment_0_0 ) )
        {
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:888:1: ( ( rule__ObjectIdentifierValue__NameAssignment_0_0 ) )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:889:1: ( rule__ObjectIdentifierValue__NameAssignment_0_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectIdentifierValueAccess().getNameAssignment_0_0()); 
        }
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:890:1: ( rule__ObjectIdentifierValue__NameAssignment_0_0 )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:890:2: rule__ObjectIdentifierValue__NameAssignment_0_0
        {
        pushFollow(FOLLOW_rule__ObjectIdentifierValue__NameAssignment_0_0_in_synpred3_InternalSmi1836);
        rule__ObjectIdentifierValue__NameAssignment_0_0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred3_InternalSmi

    // $ANTLR start synpred36_InternalSmi
    public final void synpred36_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2755:2: ( rule__TypeReferenceExt__ChildRefAssignment_1 )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2755:2: rule__TypeReferenceExt__ChildRefAssignment_1
        {
        pushFollow(FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_synpred36_InternalSmi5689);
        rule__TypeReferenceExt__ChildRefAssignment_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_InternalSmi

    // Delegated rules

    public final boolean synpred36_InternalSmi() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalSmi_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalSmi() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalSmi_fragment(); // can never throw exception
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
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA1_eotS =
        "\7\uffff";
    static final String DFA1_eofS =
        "\7\uffff";
    static final String DFA1_minS =
        "\3\4\1\uffff\1\21\2\uffff";
    static final String DFA1_maxS =
        "\1\4\2\7\1\uffff\1\27\2\uffff";
    static final String DFA1_acceptS =
        "\3\uffff\1\1\1\uffff\1\2\1\3";
    static final String DFA1_specialS =
        "\7\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\4\1\3",
            "\1\2\1\uffff\1\4\1\3",
            "",
            "\1\5\5\uffff\1\6",
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
            return "855:1: rule__Module__Alternatives_5 : ( ( ( rule__Module__IdentifiersAssignment_5_0 ) ) | ( ( rule__Module__TypesAssignment_5_1 ) ) | ( ( rule__Module__MacrosAssignment_5_2 ) ) );";
        }
    }
    static final String DFA20_eotS =
        "\5\uffff";
    static final String DFA20_eofS =
        "\5\uffff";
    static final String DFA20_minS =
        "\3\4\2\uffff";
    static final String DFA20_maxS =
        "\1\4\2\23\2\uffff";
    static final String DFA20_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA20_specialS =
        "\5\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\4\14\uffff\1\3",
            "\1\2\1\uffff\1\4\14\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "()* loopback of 2178:1: ( rule__Macro__InnerTypesAssignment_8 )*";
        }
    }
    static final String DFA23_eotS =
        "\5\uffff";
    static final String DFA23_eofS =
        "\1\1\4\uffff";
    static final String DFA23_minS =
        "\1\4\1\uffff\2\4\1\uffff";
    static final String DFA23_maxS =
        "\1\4\1\uffff\2\46\1\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\2\2\uffff\1\1";
    static final String DFA23_specialS =
        "\5\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\2",
            "",
            "\1\3\1\uffff\1\4\2\uffff\1\4\21\uffff\1\4\12\uffff\1\1",
            "\1\3\1\uffff\1\4\2\uffff\1\4\21\uffff\1\4\12\uffff\1\1",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "()* loopback of 2397:1: ( rule__TypeNotation__TypeNotationsAssignment_3 )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0_in_ruleModule100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_entryRuleObjectIdentifier132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifier139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__0_in_ruleObjectIdentifier169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_entryRuleObjectIdentifierValue196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjectIdentifierValue203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__0_in_ruleObjectIdentifierValue229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDefinition263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__0_in_ruleTypeDefinition289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_entryRuleMacro316 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacro323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__0_in_ruleMacro349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotation383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotation__Group__0_in_ruleTypeNotation409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNotation_in_entryRuleValueNotation436 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueNotation443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNotation__Group__0_in_ruleValueNotation469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAssignment503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Group__0_in_ruleTypeAssignment529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamAssignment563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__0_in_ruleParamAssignment589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotationRight_in_entryRuleTypeNotationRight616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotationRight623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotationRight__Alternatives_in_ruleTypeNotationRight649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReferenceExt683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__0_in_ruleTypeReferenceExt709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_entryRuleTypeReference736 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReference743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReference__TypeAssignment_in_ruleTypeReference769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue796 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__0_in_ruleValue829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTag_in_entryRuleTag856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTag863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tag__Group__0_in_ruleTag889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType916 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Alternatives_in_ruleValueType949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__0_in_ruleMacroValue1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE1036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__Alternatives_in_ruleMACRO_VALUE_TYPE1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_entryRuleUpdateType1096 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpdateType1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__0_in_ruleUpdateType1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP1156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__Alternatives_in_ruleMACRO_VALUE_CAP1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE1216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_TYPE__Alternatives_in_ruleASN1_TYPE1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE1276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Alternatives_in_ruleASN1_SIMPLE1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING1336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__0_in_ruleASN1_OCTET_STRING1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER1396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__0_in_ruleASN1_INTEGER1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE1456 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE1463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__0_in_ruleASN1_SUBTYPE1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE1516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE1523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Alternatives_in_ruleASN1_RANGE1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE1578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE1585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__0_in_ruleASN1_CHOICE1611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY1638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0_in_ruleASN1_CHOICE_ENTRY1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoiceType_in_entryRuleChoiceType1698 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChoiceType1705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoiceType__Alternatives_in_ruleChoiceType1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__IdentifiersAssignment_5_0_in_rule__Module__Alternatives_51767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__TypesAssignment_5_1_in_rule__Module__Alternatives_51785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__MacrosAssignment_5_2_in_rule__Module__Alternatives_51803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__NameAssignment_0_0_in_rule__ObjectIdentifierValue__Alternatives_01836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1_in_rule__ObjectIdentifierValue__Alternatives_01854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_rule__TypeAssignment__Alternatives_11887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeAssignment__Alternatives_11904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__TypeAssignment__Alternatives_11921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeNotationRight__Alternatives1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotationRight__ValueAssignment_1_in_rule__TypeNotationRight__Alternatives1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__ParamAssignment_0_in_rule__ValueType__Alternatives2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__TypesAssignment_1_in_rule__ValueType__Alternatives2021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__SimpleTypeAssignment_2_in_rule__ValueType__Alternatives2039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__MacroValueAssignment_3_in_rule__ValueType__Alternatives2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__OiAssignment_4_in_rule__ValueType__Alternatives2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__UpdateAssignment_0_in_rule__MACRO_VALUE_TYPE__Alternatives2108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__Group_1__0_in_rule__MACRO_VALUE_TYPE__Alternatives2126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__StringAssignment_2_in_rule__MACRO_VALUE_TYPE__Alternatives2144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__Group_0__0_in_rule__MACRO_VALUE_CAP__Alternatives2177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__RefAssignment_1_in_rule__MACRO_VALUE_CAP__Alternatives2195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_rule__ASN1_TYPE__Alternatives2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_rule__ASN1_TYPE__Alternatives2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__0_in_rule__ASN1_SIMPLE__Alternatives2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__0_in_rule__ASN1_SIMPLE__Alternatives2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__0_in_rule__ASN1_SIMPLE__Alternatives2313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_rule__ASN1_SIMPLE__Alternatives2331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__0_in_rule__ASN1_RANGE__Alternatives2363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__0_in_rule__ASN1_RANGE__Alternatives2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoiceType__TypeRefAssignment_0_in_rule__ChoiceType__Alternatives2414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoiceType__SimpleTypeAssignment_1_in_rule__ChoiceType__Alternatives2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ChoiceType__OiAssignment_2_in_rule__ChoiceType__Alternatives2450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__02481 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Module__Group__1_in_rule__Module__Group__02484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__NameAssignment_0_in_rule__Module__Group__0__Impl2511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__12541 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Module__Group__2_in_rule__Module__Group__12544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Module__Group__1__Impl2572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__22603 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Module__Group__3_in_rule__Module__Group__22606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Module__Group__2__Impl2634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__3__Impl_in_rule__Module__Group__32665 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Module__Group__4_in_rule__Module__Group__32668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Module__Group__3__Impl2696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__4__Impl_in_rule__Module__Group__42727 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Module__Group__5_in_rule__Module__Group__42730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Module__Group__4__Impl2757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__5__Impl_in_rule__Module__Group__52786 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Module__Group__6_in_rule__Module__Group__52789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Alternatives_5_in_rule__Module__Group__5__Impl2818 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Module__Alternatives_5_in_rule__Module__Group__5__Impl2830 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Module__Group__6__Impl_in_rule__Module__Group__62863 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Module__Group__7_in_rule__Module__Group__62866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Module__Group__6__Impl2893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__7__Impl_in_rule__Module__Group__72922 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Module__Group__8_in_rule__Module__Group__72925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Module__Group__7__Impl2953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__8__Impl_in_rule__Module__Group__82984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Module__Group__8__Impl3012 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__0__Impl_in_rule__ObjectIdentifier__Group__03061 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__1_in_rule__ObjectIdentifier__Group__03064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ObjectIdentifier__Group__0__Impl3094 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ObjectIdentifier__Group__0__Impl3107 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__1__Impl_in_rule__ObjectIdentifier__Group__13140 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__2_in_rule__ObjectIdentifier__Group__13143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__NameAssignment_1_in_rule__ObjectIdentifier__Group__1__Impl3170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__2__Impl_in_rule__ObjectIdentifier__Group__23200 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__3_in_rule__ObjectIdentifier__Group__23203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ObjectIdentifier__Group__2__Impl3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__3__Impl_in_rule__ObjectIdentifier__Group__33262 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__4_in_rule__ObjectIdentifier__Group__33265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ObjectIdentifier__Group__3__Impl3293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__4__Impl_in_rule__ObjectIdentifier__Group__43324 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__5_in_rule__ObjectIdentifier__Group__43327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ObjectIdentifier__Group__4__Impl3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__5__Impl_in_rule__ObjectIdentifier__Group__53386 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__6_in_rule__ObjectIdentifier__Group__53389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__OidValueAssignment_5_in_rule__ObjectIdentifier__Group__5__Impl3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__6__Impl_in_rule__ObjectIdentifier__Group__63446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ObjectIdentifier__Group__6__Impl3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__0__Impl_in_rule__ObjectIdentifierValue__Group__03519 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__1_in_rule__ObjectIdentifierValue__Group__03522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Alternatives_0_in_rule__ObjectIdentifierValue__Group__0__Impl3549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__1__Impl_in_rule__ObjectIdentifierValue__Group__13580 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__2_in_rule__ObjectIdentifierValue__Group__13583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_1_in_rule__ObjectIdentifierValue__Group__1__Impl3610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__2__Impl_in_rule__ObjectIdentifierValue__Group__23640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_2_in_rule__ObjectIdentifierValue__Group__2__Impl3667 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__0__Impl_in_rule__TypeDefinition__Group__03704 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__1_in_rule__TypeDefinition__Group__03707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__TypeDefinition__Group__0__Impl3737 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__TypeDefinition__Group__0__Impl3750 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__1__Impl_in_rule__TypeDefinition__Group__13783 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__2_in_rule__TypeDefinition__Group__13786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__NameAssignment_1_in_rule__TypeDefinition__Group__1__Impl3813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__2__Impl_in_rule__TypeDefinition__Group__23843 = new BitSet(new long[]{0x000006890A100270L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__3_in_rule__TypeDefinition__Group__23846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__TypeDefinition__Group__2__Impl3874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__3__Impl_in_rule__TypeDefinition__Group__33905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__ValuesAssignment_3_in_rule__TypeDefinition__Group__3__Impl3934 = new BitSet(new long[]{0x000006890A100272L});
    public static final BitSet FOLLOW_rule__TypeDefinition__ValuesAssignment_3_in_rule__TypeDefinition__Group__3__Impl3946 = new BitSet(new long[]{0x000006890A100272L});
    public static final BitSet FOLLOW_rule__Macro__Group__0__Impl_in_rule__Macro__Group__03987 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Macro__Group__1_in_rule__Macro__Group__03990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__0__Impl4020 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__0__Impl4033 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__Group__1__Impl_in_rule__Macro__Group__14066 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Macro__Group__2_in_rule__Macro__Group__14069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__NameAssignment_1_in_rule__Macro__Group__1__Impl4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__2__Impl_in_rule__Macro__Group__24126 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Macro__Group__3_in_rule__Macro__Group__24129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Macro__Group__2__Impl4157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__3__Impl_in_rule__Macro__Group__34188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__4_in_rule__Macro__Group__34191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Macro__Group__3__Impl4219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__4__Impl_in_rule__Macro__Group__44250 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Macro__Group__5_in_rule__Macro__Group__44253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__4__Impl4280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__5__Impl_in_rule__Macro__Group__54309 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__6_in_rule__Macro__Group__54312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Macro__Group__5__Impl4340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__6__Impl_in_rule__Macro__Group__64371 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__7_in_rule__Macro__Group__64374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__TypeNotationAssignment_6_in_rule__Macro__Group__6__Impl4401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__7__Impl_in_rule__Macro__Group__74431 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__8_in_rule__Macro__Group__74434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__ValueNotationAssignment_7_in_rule__Macro__Group__7__Impl4461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__8__Impl_in_rule__Macro__Group__84491 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__9_in_rule__Macro__Group__84494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__InnerTypesAssignment_8_in_rule__Macro__Group__8__Impl4523 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__InnerTypesAssignment_8_in_rule__Macro__Group__8__Impl4535 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__Group__9__Impl_in_rule__Macro__Group__94568 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Macro__Group__10_in_rule__Macro__Group__94571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__9__Impl4601 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__9__Impl4614 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__Group__10__Impl_in_rule__Macro__Group__104647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Macro__Group__10__Impl4675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotation__Group__0__Impl_in_rule__TypeNotation__Group__04728 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__TypeNotation__Group__1_in_rule__TypeNotation__Group__04731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__TypeNotation__Group__0__Impl4761 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__TypeNotation__Group__0__Impl4774 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__TypeNotation__Group__1__Impl_in_rule__TypeNotation__Group__14807 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__TypeNotation__Group__2_in_rule__TypeNotation__Group__14810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotation__NameAssignment_1_in_rule__TypeNotation__Group__1__Impl4837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotation__Group__2__Impl_in_rule__TypeNotation__Group__24867 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TypeNotation__Group__3_in_rule__TypeNotation__Group__24870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__TypeNotation__Group__2__Impl4898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotation__Group__3__Impl_in_rule__TypeNotation__Group__34929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotation__TypeNotationsAssignment_3_in_rule__TypeNotation__Group__3__Impl4958 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__TypeNotation__TypeNotationsAssignment_3_in_rule__TypeNotation__Group__3__Impl4970 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ValueNotation__Group__0__Impl_in_rule__ValueNotation__Group__05011 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ValueNotation__Group__1_in_rule__ValueNotation__Group__05014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ValueNotation__Group__0__Impl5044 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ValueNotation__Group__0__Impl5057 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ValueNotation__Group__1__Impl_in_rule__ValueNotation__Group__15090 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__ValueNotation__Group__2_in_rule__ValueNotation__Group__15093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNotation__NameAssignment_1_in_rule__ValueNotation__Group__1__Impl5120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNotation__Group__2__Impl_in_rule__ValueNotation__Group__25150 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_rule__ValueNotation__Group__3_in_rule__ValueNotation__Group__25153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ValueNotation__Group__2__Impl5181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNotation__Group__3__Impl_in_rule__ValueNotation__Group__35212 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_rule__ValueNotation__Group__4_in_rule__ValueNotation__Group__35215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ValueNotation__Group__3__Impl5243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNotation__Group__4__Impl_in_rule__ValueNotation__Group__45274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueNotation__ValueNotationAssignment_4_in_rule__ValueNotation__Group__4__Impl5301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Group__0__Impl_in_rule__TypeAssignment__Group__05341 = new BitSet(new long[]{0x0000000008000240L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Group__1_in_rule__TypeAssignment__Group__05344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__TypeAssignment__Group__0__Impl5374 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__TypeAssignment__Group__0__Impl5387 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Group__1__Impl_in_rule__TypeAssignment__Group__15420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Alternatives_1_in_rule__TypeAssignment__Group__1__Impl5447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__0__Impl_in_rule__ParamAssignment__Group__05481 = new BitSet(new long[]{0x0000000008000040L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__1_in_rule__ParamAssignment__Group__05484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__ParamAssignment_0_in_rule__ParamAssignment__Group__0__Impl5511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__1__Impl_in_rule__ParamAssignment__Group__15541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__RightAssignment_1_in_rule__ParamAssignment__Group__1__Impl5568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__0__Impl_in_rule__TypeReferenceExt__Group__05602 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__1_in_rule__TypeReferenceExt__Group__05605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__ParentRefAssignment_0_in_rule__TypeReferenceExt__Group__0__Impl5632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__1__Impl_in_rule__TypeReferenceExt__Group__15662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_rule__TypeReferenceExt__Group__1__Impl5689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__0__Impl_in_rule__Value__Group__05724 = new BitSet(new long[]{0x000006890A100270L});
    public static final BitSet FOLLOW_rule__Value__Group__1_in_rule__Value__Group__05727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__TagAssignment_0_in_rule__Value__Group__0__Impl5754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__1__Impl_in_rule__Value__Group__15785 = new BitSet(new long[]{0x000006890A100270L});
    public static final BitSet FOLLOW_rule__Value__Group__2_in_rule__Value__Group__15788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Value__Group__1__Impl5816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__2__Impl_in_rule__Value__Group__25847 = new BitSet(new long[]{0x000006890A100270L});
    public static final BitSet FOLLOW_rule__Value__Group__3_in_rule__Value__Group__25850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ImplicitAssignment_2_in_rule__Value__Group__2__Impl5877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__3__Impl_in_rule__Value__Group__35908 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_rule__Value__Group__4_in_rule__Value__Group__35911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ValueTypesAssignment_3_in_rule__Value__Group__3__Impl5938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__4__Impl_in_rule__Value__Group__45968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_4__0_in_rule__Value__Group__4__Impl5995 = new BitSet(new long[]{0x0000000001000012L});
    public static final BitSet FOLLOW_rule__Value__Group_4__0__Impl_in_rule__Value__Group_4__06036 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_rule__Value__Group_4__1_in_rule__Value__Group_4__06039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Value__Group_4__0__Impl6067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_4__1__Impl_in_rule__Value__Group_4__16098 = new BitSet(new long[]{0x000006890A100270L});
    public static final BitSet FOLLOW_rule__Value__Group_4__2_in_rule__Value__Group_4__16101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Value__Group_4__1__Impl6129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_4__2__Impl_in_rule__Value__Group_4__26160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ValueTypesAssignment_4_2_in_rule__Value__Group_4__2__Impl6187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tag__Group__0__Impl_in_rule__Tag__Group__06223 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__Tag__Group__1_in_rule__Tag__Group__06226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Tag__Group__0__Impl6254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tag__Group__1__Impl_in_rule__Tag__Group__16285 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Tag__Group__2_in_rule__Tag__Group__16288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Tag__Group__1__Impl6316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tag__Group__2__Impl_in_rule__Tag__Group__26347 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Tag__Group__3_in_rule__Tag__Group__26350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tag__TagValueAssignment_2_in_rule__Tag__Group__2__Impl6377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Tag__Group__3__Impl_in_rule__Tag__Group__36407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Tag__Group__3__Impl6435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__0__Impl_in_rule__MacroValue__Group__06474 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__1_in_rule__MacroValue__Group__06477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__1__Impl_in_rule__MacroValue__Group__16535 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__2_in_rule__MacroValue__Group__16538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__MacroValue__Group__1__Impl6566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__2__Impl_in_rule__MacroValue__Group__26597 = new BitSet(new long[]{0x00000100C0000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__3_in_rule__MacroValue__Group__26600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__MacroValue__Group__2__Impl6628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__3__Impl_in_rule__MacroValue__Group__36659 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__4_in_rule__MacroValue__Group__36662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__ValueTypeAssignment_3_in_rule__MacroValue__Group__3__Impl6689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__4__Impl_in_rule__MacroValue__Group__46719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__MacroValue__Group__4__Impl6747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__Group_1__0__Impl_in_rule__MACRO_VALUE_TYPE__Group_1__06788 = new BitSet(new long[]{0x0000000000100040L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__Group_1__1_in_rule__MACRO_VALUE_TYPE__Group_1__06791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__MACRO_VALUE_TYPE__Group_1__0__Impl6819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__Group_1__1__Impl_in_rule__MACRO_VALUE_TYPE__Group_1__16850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__LiteralAssignment_1_1_in_rule__MACRO_VALUE_TYPE__Group_1__1__Impl6877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__0__Impl_in_rule__UpdateType__Group__06911 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__1_in_rule__UpdateType__Group__06914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__UpdateType__Group__0__Impl6942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__1__Impl_in_rule__UpdateType__Group__16973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__RefAssignment_1_in_rule__UpdateType__Group__1__Impl7000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__Group_0__0__Impl_in_rule__MACRO_VALUE_CAP__Group_0__07034 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__Group_0__1_in_rule__MACRO_VALUE_CAP__Group_0__07037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__Group_0__1__Impl_in_rule__MACRO_VALUE_CAP__Group_0__17095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__MACRO_VALUE_CAP__Group_0__1__Impl7123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__0__Impl_in_rule__ASN1_SIMPLE__Group_0__07158 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__1_in_rule__ASN1_SIMPLE__Group_0__07161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__1__Impl_in_rule__ASN1_SIMPLE__Group_0__17219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ASN1_SIMPLE__Group_0__1__Impl7247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__0__Impl_in_rule__ASN1_SIMPLE__Group_1__07282 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__1_in_rule__ASN1_SIMPLE__Group_1__07285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__1__Impl_in_rule__ASN1_SIMPLE__Group_1__17343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_rule__ASN1_SIMPLE__Group_1__1__Impl7370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__0__Impl_in_rule__ASN1_SIMPLE__Group_2__07403 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__1_in_rule__ASN1_SIMPLE__Group_2__07406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_rule__ASN1_SIMPLE__Group_2__0__Impl7433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__1__Impl_in_rule__ASN1_SIMPLE__Group_2__17462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_in_rule__ASN1_SIMPLE__Group_2__1__Impl7489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__0__Impl_in_rule__ASN1_OCTET_STRING__Group__07524 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__1_in_rule__ASN1_OCTET_STRING__Group__07527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__1__Impl_in_rule__ASN1_OCTET_STRING__Group__17585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__NameAssignment_1_in_rule__ASN1_OCTET_STRING__Group__1__Impl7612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__0__Impl_in_rule__ASN1_INTEGER__Group__07646 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__1_in_rule__ASN1_INTEGER__Group__07649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__NameAssignment_0_in_rule__ASN1_INTEGER__Group__0__Impl7676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__1__Impl_in_rule__ASN1_INTEGER__Group__17706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group_1__0_in_rule__ASN1_INTEGER__Group__1__Impl7733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group_1__0__Impl_in_rule__ASN1_INTEGER__Group_1__07768 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group_1__1_in_rule__ASN1_INTEGER__Group_1__07771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ASN1_INTEGER__Group_1__0__Impl7799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group_1__1__Impl_in_rule__ASN1_INTEGER__Group_1__17830 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group_1__2_in_rule__ASN1_INTEGER__Group_1__17833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__RangeAssignment_1_1_in_rule__ASN1_INTEGER__Group_1__1__Impl7860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group_1__2__Impl_in_rule__ASN1_INTEGER__Group_1__27890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ASN1_INTEGER__Group_1__2__Impl7918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__0__Impl_in_rule__ASN1_SUBTYPE__Group__07955 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__1_in_rule__ASN1_SUBTYPE__Group__07958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ASN1_SUBTYPE__Group__0__Impl7986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__1__Impl_in_rule__ASN1_SUBTYPE__Group__18017 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__2_in_rule__ASN1_SUBTYPE__Group__18020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ASN1_SUBTYPE__Group__1__Impl8048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__2__Impl_in_rule__ASN1_SUBTYPE__Group__28079 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__3_in_rule__ASN1_SUBTYPE__Group__28082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ASN1_SUBTYPE__Group__2__Impl8110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__3__Impl_in_rule__ASN1_SUBTYPE__Group__38141 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__4_in_rule__ASN1_SUBTYPE__Group__38144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_3_in_rule__ASN1_SUBTYPE__Group__3__Impl8171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__4__Impl_in_rule__ASN1_SUBTYPE__Group__48201 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__5_in_rule__ASN1_SUBTYPE__Group__48204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__0_in_rule__ASN1_SUBTYPE__Group__4__Impl8231 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__5__Impl_in_rule__ASN1_SUBTYPE__Group__58262 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__6_in_rule__ASN1_SUBTYPE__Group__58265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ASN1_SUBTYPE__Group__5__Impl8293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__6__Impl_in_rule__ASN1_SUBTYPE__Group__68324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ASN1_SUBTYPE__Group__6__Impl8352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__0__Impl_in_rule__ASN1_SUBTYPE__Group_4__08397 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__1_in_rule__ASN1_SUBTYPE__Group_4__08400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ASN1_SUBTYPE__Group_4__0__Impl8428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__1__Impl_in_rule__ASN1_SUBTYPE__Group_4__18459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_4_1_in_rule__ASN1_SUBTYPE__Group_4__1__Impl8486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__0__Impl_in_rule__ASN1_RANGE__Group_0__08520 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__1_in_rule__ASN1_RANGE__Group_0__08523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__1__Impl_in_rule__ASN1_RANGE__Group_0__18581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__ValueAssignment_0_1_in_rule__ASN1_RANGE__Group_0__1__Impl8608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__0__Impl_in_rule__ASN1_RANGE__Group_1__08642 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__1_in_rule__ASN1_RANGE__Group_1__08645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__StartAssignment_1_0_in_rule__ASN1_RANGE__Group_1__0__Impl8672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__1__Impl_in_rule__ASN1_RANGE__Group_1__18702 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__2_in_rule__ASN1_RANGE__Group_1__18705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ASN1_RANGE__Group_1__1__Impl8733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__2__Impl_in_rule__ASN1_RANGE__Group_1__28764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__EndAssignment_1_2_in_rule__ASN1_RANGE__Group_1__2__Impl8791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__0__Impl_in_rule__ASN1_CHOICE__Group__08828 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__1_in_rule__ASN1_CHOICE__Group__08831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ASN1_CHOICE__Group__0__Impl8859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__1__Impl_in_rule__ASN1_CHOICE__Group__18890 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__2_in_rule__ASN1_CHOICE__Group__18893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ASN1_CHOICE__Group__1__Impl8921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__2__Impl_in_rule__ASN1_CHOICE__Group__28952 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__3_in_rule__ASN1_CHOICE__Group__28955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group__2__Impl8985 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group__2__Impl8998 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__3__Impl_in_rule__ASN1_CHOICE__Group__39031 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__4_in_rule__ASN1_CHOICE__Group__39034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__ChoiceTypeAssignment_3_in_rule__ASN1_CHOICE__Group__3__Impl9061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__4__Impl_in_rule__ASN1_CHOICE__Group__49091 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__5_in_rule__ASN1_CHOICE__Group__49094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_4__0_in_rule__ASN1_CHOICE__Group__4__Impl9121 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__5__Impl_in_rule__ASN1_CHOICE__Group__59152 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__6_in_rule__ASN1_CHOICE__Group__59155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group__5__Impl9185 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group__5__Impl9198 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__6__Impl_in_rule__ASN1_CHOICE__Group__69231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ASN1_CHOICE__Group__6__Impl9259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_4__0__Impl_in_rule__ASN1_CHOICE__Group_4__09304 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_4__1_in_rule__ASN1_CHOICE__Group_4__09307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ASN1_CHOICE__Group_4__0__Impl9335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_4__1__Impl_in_rule__ASN1_CHOICE__Group_4__19366 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_4__2_in_rule__ASN1_CHOICE__Group_4__19369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group_4__1__Impl9399 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE__Group_4__1__Impl9412 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_4__2__Impl_in_rule__ASN1_CHOICE__Group_4__29445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__ChoiceTypeAssignment_4_2_in_rule__ASN1_CHOICE__Group_4__2__Impl9472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__09508 = new BitSet(new long[]{0x0000060900100070L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1_in_rule__ASN1_CHOICE_ENTRY__Group__09511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__IdAssignment_0_in_rule__ASN1_CHOICE_ENTRY__Group__0__Impl9538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__19568 = new BitSet(new long[]{0x0000060900100070L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__2_in_rule__ASN1_CHOICE_ENTRY__Group__19571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ASN1_CHOICE_ENTRY__Group__1__Impl9599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__2__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__29630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_2_in_rule__ASN1_CHOICE_ENTRY__Group__2__Impl9657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__Module__NameAssignment_09698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_rule__Module__IdentifiersAssignment_5_09729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_rule__Module__TypesAssignment_5_19760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_rule__Module__MacrosAssignment_5_29791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifier__NameAssignment_19822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_rule__ObjectIdentifier__OidValueAssignment_59853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__NameAssignment_0_09884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_19919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_rule__ObjectIdentifierValue__SubIdsAssignment_19954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_rule__ObjectIdentifierValue__SubIdsAssignment_29985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__TypeDefinition__NameAssignment_110016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__TypeDefinition__ValuesAssignment_310047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__Macro__NameAssignment_110078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_rule__Macro__TypeNotationAssignment_610109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueNotation_in_rule__Macro__ValueNotationAssignment_710140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_rule__Macro__InnerTypesAssignment_810171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__TypeNotation__NameAssignment_110207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_rule__TypeNotation__TypeNotationsAssignment_310246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ValueNotation__NameAssignment_110282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__ValueNotation__ValueNotationAssignment_410321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PARAMETER_in_rule__ParamAssignment__ParamAssignment_010352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotationRight_in_rule__ParamAssignment__RightAssignment_110383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__TypeNotationRight__ValueAssignment_110414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ParentRefAssignment_010445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ChildRefAssignment_110476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__TypeReference__TypeAssignment10511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTag_in_rule__Value__TagAssignment_010546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Value__ImplicitAssignment_210582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_310621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_4_210652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_rule__Tag__TagValueAssignment_210683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_rule__ValueType__ParamAssignment_010714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_rule__ValueType__TypesAssignment_110745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_rule__ValueType__SimpleTypeAssignment_210776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__ValueType__MacroValueAssignment_310807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ValueType__OiAssignment_410843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_rule__MacroValue__ValueTypeAssignment_310882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_rule__MACRO_VALUE_TYPE__UpdateAssignment_010913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_rule__MACRO_VALUE_TYPE__LiteralAssignment_1_110944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__MACRO_VALUE_TYPE__StringAssignment_210980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__UpdateType__RefAssignment_111019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__MACRO_VALUE_CAP__RefAssignment_111050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_rule__ASN1_SIMPLE__ConstraintAssignment_2_111081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__ASN1_OCTET_STRING__NameAssignment_111117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ASN1_INTEGER__NameAssignment_011161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_INTEGER__RangeAssignment_1_111200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_311231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_4_111262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_rule__ASN1_RANGE__ValueAssignment_0_111293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_rule__ASN1_RANGE__StartAssignment_1_011324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIG_INTEGER_in_rule__ASN1_RANGE__EndAssignment_1_211355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoiceTypeAssignment_311386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoiceTypeAssignment_4_211417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__IdAssignment_011448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChoiceType_in_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_211479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__ChoiceType__TypeRefAssignment_011510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_rule__ChoiceType__SimpleTypeAssignment_111541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ChoiceType__OiAssignment_211577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__NameAssignment_0_0_in_synpred3_InternalSmi1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_synpred36_InternalSmi5689 = new BitSet(new long[]{0x0000000000000002L});

}