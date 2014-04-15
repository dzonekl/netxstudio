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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_CRNL", "RULE_IA5STRING", "RULE_ASN1_ID", "RULE_INT", "RULE_MODULE_ID", "RULE_PARAMETER", "RULE_ALPHA_CAP", "RULE_ALPHA", "RULE_NUMERIC", "RULE_SL_ASN1_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'VALUE OBJECT IDENTIFIER'", "'IA5String'", "'DEFINITIONS'", "'::='", "'BEGIN'", "'END'", "'OBJECT IDENTIFIER'", "'{'", "'}'", "'MACRO'", "'TYPE NOTATION'", "'VALUE NOTATION'", "'|'", "'value'", "'('", "')'", "'Update'", "'empty'", "'OCTET STRING'", "'INTEGER'", "'SIZE'", "'..'", "'CHOICE'", "','"
    };
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
    public static final int RULE_ASN1_ID=6;
    public static final int RULE_ALPHA=11;
    public static final int EOF=-1;
    public static final int RULE_MODULE_ID=8;
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
    public static final int RULE_CRNL=4;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:70:1: ruleModule : ( ( rule__Module__Alternatives ) ) ;
    public final void ruleModule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:74:2: ( ( ( rule__Module__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:75:1: ( ( rule__Module__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:75:1: ( ( rule__Module__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:76:1: ( rule__Module__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:77:1: ( rule__Module__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:77:2: rule__Module__Alternatives
            {
            pushFollow(FOLLOW_rule__Module__Alternatives_in_ruleModule100);
            rule__Module__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getAlternatives()); 
            }

            }


            }

        }
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


    // $ANTLR start "entryRuleTypeAssignment"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:209:1: entryRuleTypeAssignment : ruleTypeAssignment EOF ;
    public final void entryRuleTypeAssignment() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:210:1: ( ruleTypeAssignment EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:211:1: ruleTypeAssignment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment376);
            ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAssignmentRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAssignment383); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:218:1: ruleTypeAssignment : ( ( rule__TypeAssignment__Alternatives ) ) ;
    public final void ruleTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:222:2: ( ( ( rule__TypeAssignment__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:223:1: ( ( rule__TypeAssignment__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:223:1: ( ( rule__TypeAssignment__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:224:1: ( rule__TypeAssignment__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:225:1: ( rule__TypeAssignment__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:225:2: rule__TypeAssignment__Alternatives
            {
            pushFollow(FOLLOW_rule__TypeAssignment__Alternatives_in_ruleTypeAssignment409);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:237:1: entryRuleParamAssignment : ruleParamAssignment EOF ;
    public final void entryRuleParamAssignment() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:238:1: ( ruleParamAssignment EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:239:1: ruleParamAssignment EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment436);
            ruleParamAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getParamAssignmentRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParamAssignment443); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:246:1: ruleParamAssignment : ( ( rule__ParamAssignment__Group__0 ) ) ;
    public final void ruleParamAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:250:2: ( ( ( rule__ParamAssignment__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:251:1: ( ( rule__ParamAssignment__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:251:1: ( ( rule__ParamAssignment__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:252:1: ( rule__ParamAssignment__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:253:1: ( rule__ParamAssignment__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:253:2: rule__ParamAssignment__Group__0
            {
            pushFollow(FOLLOW_rule__ParamAssignment__Group__0_in_ruleParamAssignment469);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:265:1: entryRuleTypeNotation : ruleTypeNotation EOF ;
    public final void entryRuleTypeNotation() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:266:1: ( ruleTypeNotation EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:267:1: ruleTypeNotation EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationRule()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation496);
            ruleTypeNotation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeNotationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNotation503); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:274:1: ruleTypeNotation : ( ( rule__TypeNotation__Alternatives ) ) ;
    public final void ruleTypeNotation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:278:2: ( ( ( rule__TypeNotation__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:279:1: ( ( rule__TypeNotation__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:279:1: ( ( rule__TypeNotation__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:280:1: ( rule__TypeNotation__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:281:1: ( rule__TypeNotation__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:281:2: rule__TypeNotation__Alternatives
            {
            pushFollow(FOLLOW_rule__TypeNotation__Alternatives_in_ruleTypeNotation529);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:293:1: entryRuleTypeReferenceExt : ruleTypeReferenceExt EOF ;
    public final void entryRuleTypeReferenceExt() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:294:1: ( ruleTypeReferenceExt EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:295:1: ruleTypeReferenceExt EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt556);
            ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceExtRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReferenceExt563); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:302:1: ruleTypeReferenceExt : ( ( rule__TypeReferenceExt__Group__0 ) ) ;
    public final void ruleTypeReferenceExt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:306:2: ( ( ( rule__TypeReferenceExt__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:307:1: ( ( rule__TypeReferenceExt__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:307:1: ( ( rule__TypeReferenceExt__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:308:1: ( rule__TypeReferenceExt__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:309:1: ( rule__TypeReferenceExt__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:309:2: rule__TypeReferenceExt__Group__0
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__0_in_ruleTypeReferenceExt589);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:321:1: entryRuleTypeReference : ruleTypeReference EOF ;
    public final void entryRuleTypeReference() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:322:1: ( ruleTypeReference EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:323:1: ruleTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_entryRuleTypeReference616);
            ruleTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeReference623); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:330:1: ruleTypeReference : ( ( rule__TypeReference__TypeAssignment ) ) ;
    public final void ruleTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:334:2: ( ( ( rule__TypeReference__TypeAssignment ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:335:1: ( ( rule__TypeReference__TypeAssignment ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:335:1: ( ( rule__TypeReference__TypeAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:336:1: ( rule__TypeReference__TypeAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceAccess().getTypeAssignment()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:337:1: ( rule__TypeReference__TypeAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:337:2: rule__TypeReference__TypeAssignment
            {
            pushFollow(FOLLOW_rule__TypeReference__TypeAssignment_in_ruleTypeReference649);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:349:1: entryRuleScope : ruleScope EOF ;
    public final void entryRuleScope() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:350:1: ( ruleScope EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:351:1: ruleScope EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScopeRule()); 
            }
            pushFollow(FOLLOW_ruleScope_in_entryRuleScope676);
            ruleScope();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScopeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleScope683); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:358:1: ruleScope : ( ( rule__Scope__Group__0 ) ) ;
    public final void ruleScope() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:362:2: ( ( ( rule__Scope__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:363:1: ( ( rule__Scope__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:363:1: ( ( rule__Scope__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:364:1: ( rule__Scope__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScopeAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:365:1: ( rule__Scope__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:365:2: rule__Scope__Group__0
            {
            pushFollow(FOLLOW_rule__Scope__Group__0_in_ruleScope709);
            rule__Scope__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScopeAccess().getGroup()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:377:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:378:1: ( ruleValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:379:1: ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue736);
            ruleValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue743); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:386:1: ruleValue : ( ( rule__Value__Group__0 ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:390:2: ( ( ( rule__Value__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:391:1: ( ( rule__Value__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:391:1: ( ( rule__Value__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:392:1: ( rule__Value__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:393:1: ( rule__Value__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:393:2: rule__Value__Group__0
            {
            pushFollow(FOLLOW_rule__Value__Group__0_in_ruleValue769);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:405:1: entryRuleValueType : ruleValueType EOF ;
    public final void entryRuleValueType() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:406:1: ( ruleValueType EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:407:1: ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType796);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType803); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:414:1: ruleValueType : ( ( rule__ValueType__Alternatives ) ) ;
    public final void ruleValueType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:418:2: ( ( ( rule__ValueType__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:419:1: ( ( rule__ValueType__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:419:1: ( ( rule__ValueType__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:420:1: ( rule__ValueType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:421:1: ( rule__ValueType__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:421:2: rule__ValueType__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueType__Alternatives_in_ruleValueType829);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:433:1: entryRuleMacroValue : ruleMacroValue EOF ;
    public final void entryRuleMacroValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:434:1: ( ruleMacroValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:435:1: ruleMacroValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue856);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue863); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:442:1: ruleMacroValue : ( ( rule__MacroValue__Group__0 ) ) ;
    public final void ruleMacroValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:446:2: ( ( ( rule__MacroValue__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:447:1: ( ( rule__MacroValue__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:447:1: ( ( rule__MacroValue__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:448:1: ( rule__MacroValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:449:1: ( rule__MacroValue__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:449:2: rule__MacroValue__Group__0
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__0_in_ruleMacroValue889);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:461:1: entryRuleMACRO_VALUE_TYPE : ruleMACRO_VALUE_TYPE EOF ;
    public final void entryRuleMACRO_VALUE_TYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:462:1: ( ruleMACRO_VALUE_TYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:463:1: ruleMACRO_VALUE_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE916);
            ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE923); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:470:1: ruleMACRO_VALUE_TYPE : ( ( rule__MACRO_VALUE_TYPE__Alternatives ) ) ;
    public final void ruleMACRO_VALUE_TYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:474:2: ( ( ( rule__MACRO_VALUE_TYPE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:475:1: ( ( rule__MACRO_VALUE_TYPE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:475:1: ( ( rule__MACRO_VALUE_TYPE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:476:1: ( rule__MACRO_VALUE_TYPE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:477:1: ( rule__MACRO_VALUE_TYPE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:477:2: rule__MACRO_VALUE_TYPE__Alternatives
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__Alternatives_in_ruleMACRO_VALUE_TYPE949);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:489:1: entryRuleUpdateType : ruleUpdateType EOF ;
    public final void entryRuleUpdateType() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:490:1: ( ruleUpdateType EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:491:1: ruleUpdateType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_entryRuleUpdateType976);
            ruleUpdateType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpdateType983); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:498:1: ruleUpdateType : ( ( rule__UpdateType__Group__0 ) ) ;
    public final void ruleUpdateType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:502:2: ( ( ( rule__UpdateType__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:503:1: ( ( rule__UpdateType__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:503:1: ( ( rule__UpdateType__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:504:1: ( rule__UpdateType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:505:1: ( rule__UpdateType__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:505:2: rule__UpdateType__Group__0
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__0_in_ruleUpdateType1009);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:517:1: entryRuleMACRO_VALUE_CAP : ruleMACRO_VALUE_CAP EOF ;
    public final void entryRuleMACRO_VALUE_CAP() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:518:1: ( ruleMACRO_VALUE_CAP EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:519:1: ruleMACRO_VALUE_CAP EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP1036);
            ruleMACRO_VALUE_CAP();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP1043); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:526:1: ruleMACRO_VALUE_CAP : ( ( rule__MACRO_VALUE_CAP__Alternatives ) ) ;
    public final void ruleMACRO_VALUE_CAP() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:530:2: ( ( ( rule__MACRO_VALUE_CAP__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:531:1: ( ( rule__MACRO_VALUE_CAP__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:531:1: ( ( rule__MACRO_VALUE_CAP__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:532:1: ( rule__MACRO_VALUE_CAP__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:533:1: ( rule__MACRO_VALUE_CAP__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:533:2: rule__MACRO_VALUE_CAP__Alternatives
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__Alternatives_in_ruleMACRO_VALUE_CAP1069);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:545:1: entryRuleASN1_TYPE : ruleASN1_TYPE EOF ;
    public final void entryRuleASN1_TYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:546:1: ( ruleASN1_TYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:547:1: ruleASN1_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE1096);
            ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_TYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE1103); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:554:1: ruleASN1_TYPE : ( ( rule__ASN1_TYPE__Alternatives ) ) ;
    public final void ruleASN1_TYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:558:2: ( ( ( rule__ASN1_TYPE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:559:1: ( ( rule__ASN1_TYPE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:559:1: ( ( rule__ASN1_TYPE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:560:1: ( rule__ASN1_TYPE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_TYPEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:561:1: ( rule__ASN1_TYPE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:561:2: rule__ASN1_TYPE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_TYPE__Alternatives_in_ruleASN1_TYPE1129);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:573:1: entryRuleASN1_SIMPLE : ruleASN1_SIMPLE EOF ;
    public final void entryRuleASN1_SIMPLE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:574:1: ( ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:575:1: ruleASN1_SIMPLE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE1156);
            ruleASN1_SIMPLE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE1163); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:582:1: ruleASN1_SIMPLE : ( ( rule__ASN1_SIMPLE__Alternatives ) ) ;
    public final void ruleASN1_SIMPLE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:586:2: ( ( ( rule__ASN1_SIMPLE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:587:1: ( ( rule__ASN1_SIMPLE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:587:1: ( ( rule__ASN1_SIMPLE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:588:1: ( rule__ASN1_SIMPLE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:589:1: ( rule__ASN1_SIMPLE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:589:2: rule__ASN1_SIMPLE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Alternatives_in_ruleASN1_SIMPLE1189);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:601:1: entryRuleASN1_OCTET_STRING : ruleASN1_OCTET_STRING EOF ;
    public final void entryRuleASN1_OCTET_STRING() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:602:1: ( ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:603:1: ruleASN1_OCTET_STRING EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING1216);
            ruleASN1_OCTET_STRING();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING1223); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:610:1: ruleASN1_OCTET_STRING : ( ( rule__ASN1_OCTET_STRING__Group__0 ) ) ;
    public final void ruleASN1_OCTET_STRING() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:614:2: ( ( ( rule__ASN1_OCTET_STRING__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:615:1: ( ( rule__ASN1_OCTET_STRING__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:615:1: ( ( rule__ASN1_OCTET_STRING__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:616:1: ( rule__ASN1_OCTET_STRING__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:617:1: ( rule__ASN1_OCTET_STRING__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:617:2: rule__ASN1_OCTET_STRING__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__0_in_ruleASN1_OCTET_STRING1249);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:629:1: entryRuleASN1_INTEGER : ruleASN1_INTEGER EOF ;
    public final void entryRuleASN1_INTEGER() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:630:1: ( ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:631:1: ruleASN1_INTEGER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER1276);
            ruleASN1_INTEGER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER1283); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:638:1: ruleASN1_INTEGER : ( ( rule__ASN1_INTEGER__Group__0 ) ) ;
    public final void ruleASN1_INTEGER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:642:2: ( ( ( rule__ASN1_INTEGER__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:643:1: ( ( rule__ASN1_INTEGER__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:643:1: ( ( rule__ASN1_INTEGER__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:644:1: ( rule__ASN1_INTEGER__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:645:1: ( rule__ASN1_INTEGER__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:645:2: rule__ASN1_INTEGER__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__0_in_ruleASN1_INTEGER1309);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:657:1: entryRuleASN1_SUBTYPE : ruleASN1_SUBTYPE EOF ;
    public final void entryRuleASN1_SUBTYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:658:1: ( ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:659:1: ruleASN1_SUBTYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE1336);
            ruleASN1_SUBTYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE1343); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:666:1: ruleASN1_SUBTYPE : ( ( rule__ASN1_SUBTYPE__Group__0 ) ) ;
    public final void ruleASN1_SUBTYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:670:2: ( ( ( rule__ASN1_SUBTYPE__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:671:1: ( ( rule__ASN1_SUBTYPE__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:671:1: ( ( rule__ASN1_SUBTYPE__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:672:1: ( rule__ASN1_SUBTYPE__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:673:1: ( rule__ASN1_SUBTYPE__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:673:2: rule__ASN1_SUBTYPE__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__0_in_ruleASN1_SUBTYPE1369);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:685:1: entryRuleASN1_RANGE : ruleASN1_RANGE EOF ;
    public final void entryRuleASN1_RANGE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:686:1: ( ruleASN1_RANGE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:687:1: ruleASN1_RANGE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE1396);
            ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE1403); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:694:1: ruleASN1_RANGE : ( ( rule__ASN1_RANGE__Alternatives ) ) ;
    public final void ruleASN1_RANGE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:698:2: ( ( ( rule__ASN1_RANGE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:699:1: ( ( rule__ASN1_RANGE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:699:1: ( ( rule__ASN1_RANGE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:700:1: ( rule__ASN1_RANGE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:701:1: ( rule__ASN1_RANGE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:701:2: rule__ASN1_RANGE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Alternatives_in_ruleASN1_RANGE1429);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:713:1: entryRuleASN1_VALUEPAIR : ruleASN1_VALUEPAIR EOF ;
    public final void entryRuleASN1_VALUEPAIR() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:714:1: ( ruleASN1_VALUEPAIR EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:715:1: ruleASN1_VALUEPAIR EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR1456);
            ruleASN1_VALUEPAIR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_VALUEPAIRRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR1463); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:722:1: ruleASN1_VALUEPAIR : ( ( rule__ASN1_VALUEPAIR__Group__0 ) ) ;
    public final void ruleASN1_VALUEPAIR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:726:2: ( ( ( rule__ASN1_VALUEPAIR__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:727:1: ( ( rule__ASN1_VALUEPAIR__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:727:1: ( ( rule__ASN1_VALUEPAIR__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:728:1: ( rule__ASN1_VALUEPAIR__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:729:1: ( rule__ASN1_VALUEPAIR__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:729:2: rule__ASN1_VALUEPAIR__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__0_in_ruleASN1_VALUEPAIR1489);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:741:1: entryRuleASN1_CHOICE : ruleASN1_CHOICE EOF ;
    public final void entryRuleASN1_CHOICE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:742:1: ( ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:743:1: ruleASN1_CHOICE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE1516);
            ruleASN1_CHOICE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE1523); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:750:1: ruleASN1_CHOICE : ( ( rule__ASN1_CHOICE__Group__0 ) ) ;
    public final void ruleASN1_CHOICE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:754:2: ( ( ( rule__ASN1_CHOICE__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:755:1: ( ( rule__ASN1_CHOICE__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:755:1: ( ( rule__ASN1_CHOICE__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:756:1: ( rule__ASN1_CHOICE__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:757:1: ( rule__ASN1_CHOICE__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:757:2: rule__ASN1_CHOICE__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__0_in_ruleASN1_CHOICE1549);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:769:1: entryRuleASN1_CHOICE_ENTRY : ruleASN1_CHOICE_ENTRY EOF ;
    public final void entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:770:1: ( ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:771:1: ruleASN1_CHOICE_ENTRY EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY1576);
            ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY1583); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:778:1: ruleASN1_CHOICE_ENTRY : ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) ) ;
    public final void ruleASN1_CHOICE_ENTRY() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:782:2: ( ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:783:1: ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:783:1: ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:784:1: ( rule__ASN1_CHOICE_ENTRY__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:785:1: ( rule__ASN1_CHOICE_ENTRY__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:785:2: rule__ASN1_CHOICE_ENTRY__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0_in_ruleASN1_CHOICE_ENTRY1609);
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


    // $ANTLR start "rule__Module__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:797:1: rule__Module__Alternatives : ( ( ( rule__Module__Group_0__0 ) ) | ( ( rule__Module__Group_1__0 ) ) );
    public final void rule__Module__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:801:1: ( ( ( rule__Module__Group_0__0 ) ) | ( ( rule__Module__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_MODULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_CRNL||LA1_0==21) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:802:1: ( ( rule__Module__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:802:1: ( ( rule__Module__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:803:1: ( rule__Module__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModuleAccess().getGroup_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:804:1: ( rule__Module__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:804:2: rule__Module__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Module__Group_0__0_in_rule__Module__Alternatives1645);
                    rule__Module__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModuleAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:808:6: ( ( rule__Module__Group_1__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:808:6: ( ( rule__Module__Group_1__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:809:1: ( rule__Module__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModuleAccess().getGroup_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:810:1: ( rule__Module__Group_1__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:810:2: rule__Module__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Module__Group_1__0_in_rule__Module__Alternatives1663);
                    rule__Module__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModuleAccess().getGroup_1()); 
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
    // $ANTLR end "rule__Module__Alternatives"


    // $ANTLR start "rule__Module__Alternatives_0_5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:819:1: rule__Module__Alternatives_0_5 : ( ( ( rule__Module__IdentifiersAssignment_0_5_0 ) ) | ( ( rule__Module__TypesAssignment_0_5_1 ) ) | ( ( rule__Module__MacrosAssignment_0_5_2 ) ) );
    public final void rule__Module__Alternatives_0_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:823:1: ( ( ( rule__Module__IdentifiersAssignment_0_5_0 ) ) | ( ( rule__Module__TypesAssignment_0_5_1 ) ) | ( ( rule__Module__MacrosAssignment_0_5_2 ) ) )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_CRNL) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_MODULE_ID) ) {
                    int LA2_2 = input.LA(3);

                    if ( (LA2_2==19) ) {
                        alt2=2;
                    }
                    else if ( (LA2_2==25) ) {
                        alt2=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA2_1==RULE_ASN1_ID) ) {
                    alt2=1;
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:824:1: ( ( rule__Module__IdentifiersAssignment_0_5_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:824:1: ( ( rule__Module__IdentifiersAssignment_0_5_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:825:1: ( rule__Module__IdentifiersAssignment_0_5_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModuleAccess().getIdentifiersAssignment_0_5_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:826:1: ( rule__Module__IdentifiersAssignment_0_5_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:826:2: rule__Module__IdentifiersAssignment_0_5_0
                    {
                    pushFollow(FOLLOW_rule__Module__IdentifiersAssignment_0_5_0_in_rule__Module__Alternatives_0_51696);
                    rule__Module__IdentifiersAssignment_0_5_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModuleAccess().getIdentifiersAssignment_0_5_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:830:6: ( ( rule__Module__TypesAssignment_0_5_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:830:6: ( ( rule__Module__TypesAssignment_0_5_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:831:1: ( rule__Module__TypesAssignment_0_5_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModuleAccess().getTypesAssignment_0_5_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:832:1: ( rule__Module__TypesAssignment_0_5_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:832:2: rule__Module__TypesAssignment_0_5_1
                    {
                    pushFollow(FOLLOW_rule__Module__TypesAssignment_0_5_1_in_rule__Module__Alternatives_0_51714);
                    rule__Module__TypesAssignment_0_5_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModuleAccess().getTypesAssignment_0_5_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:836:6: ( ( rule__Module__MacrosAssignment_0_5_2 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:836:6: ( ( rule__Module__MacrosAssignment_0_5_2 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:837:1: ( rule__Module__MacrosAssignment_0_5_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModuleAccess().getMacrosAssignment_0_5_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:838:1: ( rule__Module__MacrosAssignment_0_5_2 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:838:2: rule__Module__MacrosAssignment_0_5_2
                    {
                    pushFollow(FOLLOW_rule__Module__MacrosAssignment_0_5_2_in_rule__Module__Alternatives_0_51732);
                    rule__Module__MacrosAssignment_0_5_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getModuleAccess().getMacrosAssignment_0_5_2()); 
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
    // $ANTLR end "rule__Module__Alternatives_0_5"


    // $ANTLR start "rule__ObjectIdentifierValue__Alternatives_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:847:1: rule__ObjectIdentifierValue__Alternatives_0 : ( ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) ) | ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) ) );
    public final void rule__ObjectIdentifierValue__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:851:1: ( ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) ) | ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ASN1_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (synpred4_InternalSmi()) ) {
                    alt3=1;
                }
                else if ( (true) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:852:1: ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:852:1: ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:853:1: ( rule__ObjectIdentifierValue__RootAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectIdentifierValueAccess().getRootAssignment_0_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:854:1: ( rule__ObjectIdentifierValue__RootAssignment_0_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:854:2: rule__ObjectIdentifierValue__RootAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__RootAssignment_0_0_in_rule__ObjectIdentifierValue__Alternatives_01765);
                    rule__ObjectIdentifierValue__RootAssignment_0_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getObjectIdentifierValueAccess().getRootAssignment_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:858:6: ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:858:6: ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:859:1: ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceAssignment_0_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:860:1: ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:860:2: rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1_in_rule__ObjectIdentifierValue__Alternatives_01783);
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


    // $ANTLR start "rule__TypeAssignment__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:869:1: rule__TypeAssignment__Alternatives : ( ( ruleParamAssignment ) | ( ruleTypeReference ) );
    public final void rule__TypeAssignment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:873:1: ( ( ruleParamAssignment ) | ( ruleTypeReference ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_PARAMETER) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_MODULE_ID) ) {
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:874:1: ( ruleParamAssignment )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:874:1: ( ruleParamAssignment )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:875:1: ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_rule__TypeAssignment__Alternatives1816);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:880:6: ( ruleTypeReference )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:880:6: ( ruleTypeReference )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:881:1: ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeAssignment__Alternatives1833);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:891:1: rule__TypeNotation__Alternatives : ( ( ruleTypeReference ) | ( ( rule__TypeNotation__ValueAssignment_1 ) ) );
    public final void rule__TypeNotation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:895:1: ( ( ruleTypeReference ) | ( ( rule__TypeNotation__ValueAssignment_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_MODULE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==29) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:896:1: ( ruleTypeReference )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:896:1: ( ruleTypeReference )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:897:1: ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeNotationAccess().getTypeReferenceParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeNotation__Alternatives1865);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:902:6: ( ( rule__TypeNotation__ValueAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:902:6: ( ( rule__TypeNotation__ValueAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:903:1: ( rule__TypeNotation__ValueAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeNotationAccess().getValueAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:904:1: ( rule__TypeNotation__ValueAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:904:2: rule__TypeNotation__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TypeNotation__ValueAssignment_1_in_rule__TypeNotation__Alternatives1882);
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


    // $ANTLR start "rule__ValueType__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:913:1: rule__ValueType__Alternatives : ( ( ( rule__ValueType__ParamAssignment_0 ) ) | ( ( rule__ValueType__TypeAssignment_1 ) ) | ( ( rule__ValueType__SimpleTypeAssignment_2 ) ) | ( ( rule__ValueType__MacroValueAssignment_3 ) ) | ( ( rule__ValueType__OiAssignment_4 ) ) );
    public final void rule__ValueType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:917:1: ( ( ( rule__ValueType__ParamAssignment_0 ) ) | ( ( rule__ValueType__TypeAssignment_1 ) ) | ( ( rule__ValueType__SimpleTypeAssignment_2 ) ) | ( ( rule__ValueType__MacroValueAssignment_3 ) ) | ( ( rule__ValueType__OiAssignment_4 ) ) )
            int alt6=5;
            switch ( input.LA(1) ) {
            case RULE_PARAMETER:
                {
                alt6=1;
                }
                break;
            case RULE_MODULE_ID:
                {
                alt6=2;
                }
                break;
            case RULE_IA5STRING:
            case 33:
            case 34:
            case 35:
            case 38:
                {
                alt6=3;
                }
                break;
            case 29:
                {
                alt6=4;
                }
                break;
            case 22:
                {
                alt6=5;
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:918:1: ( ( rule__ValueType__ParamAssignment_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:918:1: ( ( rule__ValueType__ParamAssignment_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:919:1: ( rule__ValueType__ParamAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getParamAssignment_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:920:1: ( rule__ValueType__ParamAssignment_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:920:2: rule__ValueType__ParamAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ValueType__ParamAssignment_0_in_rule__ValueType__Alternatives1915);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:924:6: ( ( rule__ValueType__TypeAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:924:6: ( ( rule__ValueType__TypeAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:925:1: ( rule__ValueType__TypeAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getTypeAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:926:1: ( rule__ValueType__TypeAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:926:2: rule__ValueType__TypeAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Alternatives1933);
                    rule__ValueType__TypeAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getValueTypeAccess().getTypeAssignment_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:930:6: ( ( rule__ValueType__SimpleTypeAssignment_2 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:930:6: ( ( rule__ValueType__SimpleTypeAssignment_2 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:931:1: ( rule__ValueType__SimpleTypeAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getSimpleTypeAssignment_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:932:1: ( rule__ValueType__SimpleTypeAssignment_2 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:932:2: rule__ValueType__SimpleTypeAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ValueType__SimpleTypeAssignment_2_in_rule__ValueType__Alternatives1951);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:936:6: ( ( rule__ValueType__MacroValueAssignment_3 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:936:6: ( ( rule__ValueType__MacroValueAssignment_3 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:937:1: ( rule__ValueType__MacroValueAssignment_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getMacroValueAssignment_3()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:938:1: ( rule__ValueType__MacroValueAssignment_3 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:938:2: rule__ValueType__MacroValueAssignment_3
                    {
                    pushFollow(FOLLOW_rule__ValueType__MacroValueAssignment_3_in_rule__ValueType__Alternatives1969);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:942:6: ( ( rule__ValueType__OiAssignment_4 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:942:6: ( ( rule__ValueType__OiAssignment_4 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:943:1: ( rule__ValueType__OiAssignment_4 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getOiAssignment_4()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:944:1: ( rule__ValueType__OiAssignment_4 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:944:2: rule__ValueType__OiAssignment_4
                    {
                    pushFollow(FOLLOW_rule__ValueType__OiAssignment_4_in_rule__ValueType__Alternatives1987);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:953:1: rule__MACRO_VALUE_TYPE__Alternatives : ( ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) ) | ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 ) ) );
    public final void rule__MACRO_VALUE_TYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:957:1: ( ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) ) | ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==32) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=16 && LA7_0<=17)) ) {
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:958:1: ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:958:1: ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:959:1: ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateAssignment_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:960:1: ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:960:2: rule__MACRO_VALUE_TYPE__UpdateAssignment_0
                    {
                    pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__UpdateAssignment_0_in_rule__MACRO_VALUE_TYPE__Alternatives2020);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:964:6: ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:964:6: ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:965:1: ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:966:1: ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:966:2: rule__MACRO_VALUE_TYPE__LiteralAssignment_1
                    {
                    pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__LiteralAssignment_1_in_rule__MACRO_VALUE_TYPE__Alternatives2038);
                    rule__MACRO_VALUE_TYPE__LiteralAssignment_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralAssignment_1()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:975:1: rule__MACRO_VALUE_CAP__Alternatives : ( ( 'VALUE OBJECT IDENTIFIER' ) | ( 'IA5String' ) );
    public final void rule__MACRO_VALUE_CAP__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:979:1: ( ( 'VALUE OBJECT IDENTIFIER' ) | ( 'IA5String' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            else if ( (LA8_0==17) ) {
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:980:1: ( 'VALUE OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:980:1: ( 'VALUE OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:981:1: 'VALUE OBJECT IDENTIFIER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_CAPAccess().getVALUEOBJECTIDENTIFIERKeyword_0()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__MACRO_VALUE_CAP__Alternatives2072); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMACRO_VALUE_CAPAccess().getVALUEOBJECTIDENTIFIERKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:988:6: ( 'IA5String' )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:988:6: ( 'IA5String' )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:989:1: 'IA5String'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_CAPAccess().getIA5StringKeyword_1()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__MACRO_VALUE_CAP__Alternatives2092); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMACRO_VALUE_CAPAccess().getIA5StringKeyword_1()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1001:1: rule__ASN1_TYPE__Alternatives : ( ( ruleASN1_SIMPLE ) | ( ruleASN1_CHOICE ) );
    public final void rule__ASN1_TYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1005:1: ( ( ruleASN1_SIMPLE ) | ( ruleASN1_CHOICE ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_IA5STRING||(LA9_0>=33 && LA9_0<=35)) ) {
                alt9=1;
            }
            else if ( (LA9_0==38) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1006:1: ( ruleASN1_SIMPLE )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1006:1: ( ruleASN1_SIMPLE )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1007:1: ruleASN1_SIMPLE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_rule__ASN1_TYPE__Alternatives2126);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1012:6: ( ruleASN1_CHOICE )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1012:6: ( ruleASN1_CHOICE )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1013:1: ruleASN1_CHOICE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_rule__ASN1_TYPE__Alternatives2143);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1023:1: rule__ASN1_SIMPLE__Alternatives : ( ( ( rule__ASN1_SIMPLE__Group_0__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_1__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_2__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_3__0 ) ) );
    public final void rule__ASN1_SIMPLE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1027:1: ( ( ( rule__ASN1_SIMPLE__Group_0__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_1__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_2__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_3__0 ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt10=1;
                }
                break;
            case RULE_IA5STRING:
                {
                alt10=2;
                }
                break;
            case 34:
                {
                alt10=3;
                }
                break;
            case 35:
                {
                alt10=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1028:1: ( ( rule__ASN1_SIMPLE__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1028:1: ( ( rule__ASN1_SIMPLE__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1029:1: ( rule__ASN1_SIMPLE__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1030:1: ( rule__ASN1_SIMPLE__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1030:2: rule__ASN1_SIMPLE__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__0_in_rule__ASN1_SIMPLE__Alternatives2175);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1034:6: ( ( rule__ASN1_SIMPLE__Group_1__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1034:6: ( ( rule__ASN1_SIMPLE__Group_1__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1035:1: ( rule__ASN1_SIMPLE__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1036:1: ( rule__ASN1_SIMPLE__Group_1__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1036:2: rule__ASN1_SIMPLE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__0_in_rule__ASN1_SIMPLE__Alternatives2193);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1040:6: ( ( rule__ASN1_SIMPLE__Group_2__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1040:6: ( ( rule__ASN1_SIMPLE__Group_2__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1041:1: ( rule__ASN1_SIMPLE__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1042:1: ( rule__ASN1_SIMPLE__Group_2__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1042:2: rule__ASN1_SIMPLE__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__0_in_rule__ASN1_SIMPLE__Alternatives2211);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1046:6: ( ( rule__ASN1_SIMPLE__Group_3__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1046:6: ( ( rule__ASN1_SIMPLE__Group_3__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1047:1: ( rule__ASN1_SIMPLE__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_3()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1048:1: ( rule__ASN1_SIMPLE__Group_3__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1048:2: rule__ASN1_SIMPLE__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__0_in_rule__ASN1_SIMPLE__Alternatives2229);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1057:1: rule__ASN1_RANGE__Alternatives : ( ( ( rule__ASN1_RANGE__Group_0__0 ) ) | ( ( rule__ASN1_RANGE__Group_1__0 ) ) );
    public final void rule__ASN1_RANGE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1061:1: ( ( ( rule__ASN1_RANGE__Group_0__0 ) ) | ( ( rule__ASN1_RANGE__Group_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_INT) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==37) ) {
                    alt11=2;
                }
                else if ( (LA11_1==EOF||(LA11_1>=RULE_CRNL && LA11_1<=RULE_IA5STRING)||(LA11_1>=RULE_MODULE_ID && LA11_1<=RULE_PARAMETER)||LA11_1==22||(LA11_1>=28 && LA11_1<=29)||LA11_1==31||(LA11_1>=33 && LA11_1<=35)||LA11_1==38) ) {
                    alt11=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1062:1: ( ( rule__ASN1_RANGE__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1062:1: ( ( rule__ASN1_RANGE__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1063:1: ( rule__ASN1_RANGE__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_RANGEAccess().getGroup_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1064:1: ( rule__ASN1_RANGE__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1064:2: rule__ASN1_RANGE__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__0_in_rule__ASN1_RANGE__Alternatives2262);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1068:6: ( ( rule__ASN1_RANGE__Group_1__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1068:6: ( ( rule__ASN1_RANGE__Group_1__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1069:1: ( rule__ASN1_RANGE__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_RANGEAccess().getGroup_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1070:1: ( rule__ASN1_RANGE__Group_1__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1070:2: rule__ASN1_RANGE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__0_in_rule__ASN1_RANGE__Alternatives2280);
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


    // $ANTLR start "rule__Module__Group_0__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1081:1: rule__Module__Group_0__0 : rule__Module__Group_0__0__Impl rule__Module__Group_0__1 ;
    public final void rule__Module__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1085:1: ( rule__Module__Group_0__0__Impl rule__Module__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1086:2: rule__Module__Group_0__0__Impl rule__Module__Group_0__1
            {
            pushFollow(FOLLOW_rule__Module__Group_0__0__Impl_in_rule__Module__Group_0__02311);
            rule__Module__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group_0__1_in_rule__Module__Group_0__02314);
            rule__Module__Group_0__1();

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
    // $ANTLR end "rule__Module__Group_0__0"


    // $ANTLR start "rule__Module__Group_0__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1093:1: rule__Module__Group_0__0__Impl : ( ( rule__Module__NameAssignment_0_0 ) ) ;
    public final void rule__Module__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1097:1: ( ( ( rule__Module__NameAssignment_0_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1098:1: ( ( rule__Module__NameAssignment_0_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1098:1: ( ( rule__Module__NameAssignment_0_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1099:1: ( rule__Module__NameAssignment_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNameAssignment_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1100:1: ( rule__Module__NameAssignment_0_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1100:2: rule__Module__NameAssignment_0_0
            {
            pushFollow(FOLLOW_rule__Module__NameAssignment_0_0_in_rule__Module__Group_0__0__Impl2341);
            rule__Module__NameAssignment_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getNameAssignment_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_0__0__Impl"


    // $ANTLR start "rule__Module__Group_0__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1110:1: rule__Module__Group_0__1 : rule__Module__Group_0__1__Impl rule__Module__Group_0__2 ;
    public final void rule__Module__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1114:1: ( rule__Module__Group_0__1__Impl rule__Module__Group_0__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1115:2: rule__Module__Group_0__1__Impl rule__Module__Group_0__2
            {
            pushFollow(FOLLOW_rule__Module__Group_0__1__Impl_in_rule__Module__Group_0__12371);
            rule__Module__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group_0__2_in_rule__Module__Group_0__12374);
            rule__Module__Group_0__2();

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
    // $ANTLR end "rule__Module__Group_0__1"


    // $ANTLR start "rule__Module__Group_0__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1122:1: rule__Module__Group_0__1__Impl : ( 'DEFINITIONS' ) ;
    public final void rule__Module__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1126:1: ( ( 'DEFINITIONS' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1127:1: ( 'DEFINITIONS' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1127:1: ( 'DEFINITIONS' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1128:1: 'DEFINITIONS'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getDEFINITIONSKeyword_0_1()); 
            }
            match(input,18,FOLLOW_18_in_rule__Module__Group_0__1__Impl2402); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getDEFINITIONSKeyword_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_0__1__Impl"


    // $ANTLR start "rule__Module__Group_0__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1141:1: rule__Module__Group_0__2 : rule__Module__Group_0__2__Impl rule__Module__Group_0__3 ;
    public final void rule__Module__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1145:1: ( rule__Module__Group_0__2__Impl rule__Module__Group_0__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1146:2: rule__Module__Group_0__2__Impl rule__Module__Group_0__3
            {
            pushFollow(FOLLOW_rule__Module__Group_0__2__Impl_in_rule__Module__Group_0__22433);
            rule__Module__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group_0__3_in_rule__Module__Group_0__22436);
            rule__Module__Group_0__3();

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
    // $ANTLR end "rule__Module__Group_0__2"


    // $ANTLR start "rule__Module__Group_0__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1153:1: rule__Module__Group_0__2__Impl : ( '::=' ) ;
    public final void rule__Module__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1157:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1158:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1158:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1159:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_0_2()); 
            }
            match(input,19,FOLLOW_19_in_rule__Module__Group_0__2__Impl2464); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_0__2__Impl"


    // $ANTLR start "rule__Module__Group_0__3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1172:1: rule__Module__Group_0__3 : rule__Module__Group_0__3__Impl rule__Module__Group_0__4 ;
    public final void rule__Module__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1176:1: ( rule__Module__Group_0__3__Impl rule__Module__Group_0__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1177:2: rule__Module__Group_0__3__Impl rule__Module__Group_0__4
            {
            pushFollow(FOLLOW_rule__Module__Group_0__3__Impl_in_rule__Module__Group_0__32495);
            rule__Module__Group_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group_0__4_in_rule__Module__Group_0__32498);
            rule__Module__Group_0__4();

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
    // $ANTLR end "rule__Module__Group_0__3"


    // $ANTLR start "rule__Module__Group_0__3__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1184:1: rule__Module__Group_0__3__Impl : ( 'BEGIN' ) ;
    public final void rule__Module__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1188:1: ( ( 'BEGIN' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1189:1: ( 'BEGIN' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1189:1: ( 'BEGIN' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1190:1: 'BEGIN'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getBEGINKeyword_0_3()); 
            }
            match(input,20,FOLLOW_20_in_rule__Module__Group_0__3__Impl2526); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getBEGINKeyword_0_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_0__3__Impl"


    // $ANTLR start "rule__Module__Group_0__4"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1203:1: rule__Module__Group_0__4 : rule__Module__Group_0__4__Impl rule__Module__Group_0__5 ;
    public final void rule__Module__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1207:1: ( rule__Module__Group_0__4__Impl rule__Module__Group_0__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1208:2: rule__Module__Group_0__4__Impl rule__Module__Group_0__5
            {
            pushFollow(FOLLOW_rule__Module__Group_0__4__Impl_in_rule__Module__Group_0__42557);
            rule__Module__Group_0__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group_0__5_in_rule__Module__Group_0__42560);
            rule__Module__Group_0__5();

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
    // $ANTLR end "rule__Module__Group_0__4"


    // $ANTLR start "rule__Module__Group_0__4__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1215:1: rule__Module__Group_0__4__Impl : ( RULE_CRNL ) ;
    public final void rule__Module__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1219:1: ( ( RULE_CRNL ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1220:1: ( RULE_CRNL )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1220:1: ( RULE_CRNL )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1221:1: RULE_CRNL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getCRNLTerminalRuleCall_0_4()); 
            }
            match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_rule__Module__Group_0__4__Impl2587); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getCRNLTerminalRuleCall_0_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_0__4__Impl"


    // $ANTLR start "rule__Module__Group_0__5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1232:1: rule__Module__Group_0__5 : rule__Module__Group_0__5__Impl ;
    public final void rule__Module__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1236:1: ( rule__Module__Group_0__5__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1237:2: rule__Module__Group_0__5__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group_0__5__Impl_in_rule__Module__Group_0__52616);
            rule__Module__Group_0__5__Impl();

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
    // $ANTLR end "rule__Module__Group_0__5"


    // $ANTLR start "rule__Module__Group_0__5__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1243:1: rule__Module__Group_0__5__Impl : ( ( ( rule__Module__Alternatives_0_5 ) ) ( ( rule__Module__Alternatives_0_5 )* ) ) ;
    public final void rule__Module__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1247:1: ( ( ( ( rule__Module__Alternatives_0_5 ) ) ( ( rule__Module__Alternatives_0_5 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1248:1: ( ( ( rule__Module__Alternatives_0_5 ) ) ( ( rule__Module__Alternatives_0_5 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1248:1: ( ( ( rule__Module__Alternatives_0_5 ) ) ( ( rule__Module__Alternatives_0_5 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1249:1: ( ( rule__Module__Alternatives_0_5 ) ) ( ( rule__Module__Alternatives_0_5 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1249:1: ( ( rule__Module__Alternatives_0_5 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1250:1: ( rule__Module__Alternatives_0_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getAlternatives_0_5()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1251:1: ( rule__Module__Alternatives_0_5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1251:2: rule__Module__Alternatives_0_5
            {
            pushFollow(FOLLOW_rule__Module__Alternatives_0_5_in_rule__Module__Group_0__5__Impl2645);
            rule__Module__Alternatives_0_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getAlternatives_0_5()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1254:1: ( ( rule__Module__Alternatives_0_5 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1255:1: ( rule__Module__Alternatives_0_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getAlternatives_0_5()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1256:1: ( rule__Module__Alternatives_0_5 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_CRNL) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1256:2: rule__Module__Alternatives_0_5
            	    {
            	    pushFollow(FOLLOW_rule__Module__Alternatives_0_5_in_rule__Module__Group_0__5__Impl2657);
            	    rule__Module__Alternatives_0_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getAlternatives_0_5()); 
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
    // $ANTLR end "rule__Module__Group_0__5__Impl"


    // $ANTLR start "rule__Module__Group_1__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1279:1: rule__Module__Group_1__0 : rule__Module__Group_1__0__Impl rule__Module__Group_1__1 ;
    public final void rule__Module__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1283:1: ( rule__Module__Group_1__0__Impl rule__Module__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1284:2: rule__Module__Group_1__0__Impl rule__Module__Group_1__1
            {
            pushFollow(FOLLOW_rule__Module__Group_1__0__Impl_in_rule__Module__Group_1__02702);
            rule__Module__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group_1__1_in_rule__Module__Group_1__02705);
            rule__Module__Group_1__1();

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
    // $ANTLR end "rule__Module__Group_1__0"


    // $ANTLR start "rule__Module__Group_1__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1291:1: rule__Module__Group_1__0__Impl : ( () ) ;
    public final void rule__Module__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1295:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1296:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1296:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1297:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getModuleAction_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1298:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1300:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getModuleAction_1_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_1__0__Impl"


    // $ANTLR start "rule__Module__Group_1__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1310:1: rule__Module__Group_1__1 : rule__Module__Group_1__1__Impl rule__Module__Group_1__2 ;
    public final void rule__Module__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1314:1: ( rule__Module__Group_1__1__Impl rule__Module__Group_1__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1315:2: rule__Module__Group_1__1__Impl rule__Module__Group_1__2
            {
            pushFollow(FOLLOW_rule__Module__Group_1__1__Impl_in_rule__Module__Group_1__12763);
            rule__Module__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group_1__2_in_rule__Module__Group_1__12766);
            rule__Module__Group_1__2();

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
    // $ANTLR end "rule__Module__Group_1__1"


    // $ANTLR start "rule__Module__Group_1__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1322:1: rule__Module__Group_1__1__Impl : ( ( RULE_CRNL )* ) ;
    public final void rule__Module__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1326:1: ( ( ( RULE_CRNL )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1327:1: ( ( RULE_CRNL )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1327:1: ( ( RULE_CRNL )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1328:1: ( RULE_CRNL )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getCRNLTerminalRuleCall_1_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1329:1: ( RULE_CRNL )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_CRNL) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1329:3: RULE_CRNL
            	    {
            	    match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_rule__Module__Group_1__1__Impl2794); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getCRNLTerminalRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_1__1__Impl"


    // $ANTLR start "rule__Module__Group_1__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1339:1: rule__Module__Group_1__2 : rule__Module__Group_1__2__Impl ;
    public final void rule__Module__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1343:1: ( rule__Module__Group_1__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1344:2: rule__Module__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group_1__2__Impl_in_rule__Module__Group_1__22825);
            rule__Module__Group_1__2__Impl();

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
    // $ANTLR end "rule__Module__Group_1__2"


    // $ANTLR start "rule__Module__Group_1__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1350:1: rule__Module__Group_1__2__Impl : ( 'END' ) ;
    public final void rule__Module__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1354:1: ( ( 'END' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1355:1: ( 'END' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1355:1: ( 'END' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1356:1: 'END'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getENDKeyword_1_2()); 
            }
            match(input,21,FOLLOW_21_in_rule__Module__Group_1__2__Impl2853); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getENDKeyword_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_1__2__Impl"


    // $ANTLR start "rule__ObjectIdentifier__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1375:1: rule__ObjectIdentifier__Group__0 : rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1 ;
    public final void rule__ObjectIdentifier__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1379:1: ( rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1380:2: rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__0__Impl_in_rule__ObjectIdentifier__Group__02890);
            rule__ObjectIdentifier__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__1_in_rule__ObjectIdentifier__Group__02893);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1387:1: rule__ObjectIdentifier__Group__0__Impl : ( RULE_CRNL ) ;
    public final void rule__ObjectIdentifier__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1391:1: ( ( RULE_CRNL ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1392:1: ( RULE_CRNL )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1392:1: ( RULE_CRNL )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1393:1: RULE_CRNL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getCRNLTerminalRuleCall_0()); 
            }
            match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_rule__ObjectIdentifier__Group__0__Impl2920); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getCRNLTerminalRuleCall_0()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1404:1: rule__ObjectIdentifier__Group__1 : rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2 ;
    public final void rule__ObjectIdentifier__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1408:1: ( rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1409:2: rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__1__Impl_in_rule__ObjectIdentifier__Group__12949);
            rule__ObjectIdentifier__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__2_in_rule__ObjectIdentifier__Group__12952);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1416:1: rule__ObjectIdentifier__Group__1__Impl : ( ( rule__ObjectIdentifier__NameAssignment_1 ) ) ;
    public final void rule__ObjectIdentifier__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1420:1: ( ( ( rule__ObjectIdentifier__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1421:1: ( ( rule__ObjectIdentifier__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1421:1: ( ( rule__ObjectIdentifier__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1422:1: ( rule__ObjectIdentifier__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1423:1: ( rule__ObjectIdentifier__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1423:2: rule__ObjectIdentifier__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__NameAssignment_1_in_rule__ObjectIdentifier__Group__1__Impl2979);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1433:1: rule__ObjectIdentifier__Group__2 : rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3 ;
    public final void rule__ObjectIdentifier__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1437:1: ( rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1438:2: rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__2__Impl_in_rule__ObjectIdentifier__Group__23009);
            rule__ObjectIdentifier__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__3_in_rule__ObjectIdentifier__Group__23012);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1445:1: rule__ObjectIdentifier__Group__2__Impl : ( 'OBJECT IDENTIFIER' ) ;
    public final void rule__ObjectIdentifier__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1449:1: ( ( 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1450:1: ( 'OBJECT IDENTIFIER' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1450:1: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1451:1: 'OBJECT IDENTIFIER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_2()); 
            }
            match(input,22,FOLLOW_22_in_rule__ObjectIdentifier__Group__2__Impl3040); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1464:1: rule__ObjectIdentifier__Group__3 : rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4 ;
    public final void rule__ObjectIdentifier__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1468:1: ( rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1469:2: rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__3__Impl_in_rule__ObjectIdentifier__Group__33071);
            rule__ObjectIdentifier__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__4_in_rule__ObjectIdentifier__Group__33074);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1476:1: rule__ObjectIdentifier__Group__3__Impl : ( '::=' ) ;
    public final void rule__ObjectIdentifier__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1480:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1481:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1481:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1482:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_3()); 
            }
            match(input,19,FOLLOW_19_in_rule__ObjectIdentifier__Group__3__Impl3102); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1495:1: rule__ObjectIdentifier__Group__4 : rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5 ;
    public final void rule__ObjectIdentifier__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1499:1: ( rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1500:2: rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__4__Impl_in_rule__ObjectIdentifier__Group__43133);
            rule__ObjectIdentifier__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__5_in_rule__ObjectIdentifier__Group__43136);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1507:1: rule__ObjectIdentifier__Group__4__Impl : ( '{' ) ;
    public final void rule__ObjectIdentifier__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1511:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1512:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1512:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1513:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,23,FOLLOW_23_in_rule__ObjectIdentifier__Group__4__Impl3164); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1526:1: rule__ObjectIdentifier__Group__5 : rule__ObjectIdentifier__Group__5__Impl rule__ObjectIdentifier__Group__6 ;
    public final void rule__ObjectIdentifier__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1530:1: ( rule__ObjectIdentifier__Group__5__Impl rule__ObjectIdentifier__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1531:2: rule__ObjectIdentifier__Group__5__Impl rule__ObjectIdentifier__Group__6
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__5__Impl_in_rule__ObjectIdentifier__Group__53195);
            rule__ObjectIdentifier__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__6_in_rule__ObjectIdentifier__Group__53198);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1538:1: rule__ObjectIdentifier__Group__5__Impl : ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) ) ;
    public final void rule__ObjectIdentifier__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1542:1: ( ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1543:1: ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1543:1: ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1544:1: ( rule__ObjectIdentifier__OidValueAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOidValueAssignment_5()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1545:1: ( rule__ObjectIdentifier__OidValueAssignment_5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1545:2: rule__ObjectIdentifier__OidValueAssignment_5
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__OidValueAssignment_5_in_rule__ObjectIdentifier__Group__5__Impl3225);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1555:1: rule__ObjectIdentifier__Group__6 : rule__ObjectIdentifier__Group__6__Impl ;
    public final void rule__ObjectIdentifier__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1559:1: ( rule__ObjectIdentifier__Group__6__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1560:2: rule__ObjectIdentifier__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__6__Impl_in_rule__ObjectIdentifier__Group__63255);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1566:1: rule__ObjectIdentifier__Group__6__Impl : ( '}' ) ;
    public final void rule__ObjectIdentifier__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1570:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1571:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1571:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1572:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,24,FOLLOW_24_in_rule__ObjectIdentifier__Group__6__Impl3283); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1599:1: rule__ObjectIdentifierValue__Group__0 : rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1 ;
    public final void rule__ObjectIdentifierValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1603:1: ( rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1604:2: rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__0__Impl_in_rule__ObjectIdentifierValue__Group__03328);
            rule__ObjectIdentifierValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__1_in_rule__ObjectIdentifierValue__Group__03331);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1611:1: rule__ObjectIdentifierValue__Group__0__Impl : ( ( rule__ObjectIdentifierValue__Alternatives_0 )? ) ;
    public final void rule__ObjectIdentifierValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1615:1: ( ( ( rule__ObjectIdentifierValue__Alternatives_0 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1616:1: ( ( rule__ObjectIdentifierValue__Alternatives_0 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1616:1: ( ( rule__ObjectIdentifierValue__Alternatives_0 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1617:1: ( rule__ObjectIdentifierValue__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getAlternatives_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1618:1: ( rule__ObjectIdentifierValue__Alternatives_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ASN1_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1618:2: rule__ObjectIdentifierValue__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__Alternatives_0_in_rule__ObjectIdentifierValue__Group__0__Impl3358);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1628:1: rule__ObjectIdentifierValue__Group__1 : rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2 ;
    public final void rule__ObjectIdentifierValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1632:1: ( rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1633:2: rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__1__Impl_in_rule__ObjectIdentifierValue__Group__13389);
            rule__ObjectIdentifierValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__2_in_rule__ObjectIdentifierValue__Group__13392);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1640:1: rule__ObjectIdentifierValue__Group__1__Impl : ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) ) ;
    public final void rule__ObjectIdentifierValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1644:1: ( ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1645:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1645:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1646:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1647:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1647:2: rule__ObjectIdentifierValue__SubIdsAssignment_1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_1_in_rule__ObjectIdentifierValue__Group__1__Impl3419);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1657:1: rule__ObjectIdentifierValue__Group__2 : rule__ObjectIdentifierValue__Group__2__Impl ;
    public final void rule__ObjectIdentifierValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1661:1: ( rule__ObjectIdentifierValue__Group__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1662:2: rule__ObjectIdentifierValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__2__Impl_in_rule__ObjectIdentifierValue__Group__23449);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1668:1: rule__ObjectIdentifierValue__Group__2__Impl : ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* ) ;
    public final void rule__ObjectIdentifierValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1672:1: ( ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1673:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1673:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1674:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1675:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_INT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1675:2: rule__ObjectIdentifierValue__SubIdsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_2_in_rule__ObjectIdentifierValue__Group__2__Impl3476);
            	    rule__ObjectIdentifierValue__SubIdsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1691:1: rule__TypeDefinition__Group__0 : rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1 ;
    public final void rule__TypeDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1695:1: ( rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1696:2: rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__0__Impl_in_rule__TypeDefinition__Group__03513);
            rule__TypeDefinition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeDefinition__Group__1_in_rule__TypeDefinition__Group__03516);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1703:1: rule__TypeDefinition__Group__0__Impl : ( RULE_CRNL ) ;
    public final void rule__TypeDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1707:1: ( ( RULE_CRNL ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1708:1: ( RULE_CRNL )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1708:1: ( RULE_CRNL )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1709:1: RULE_CRNL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getCRNLTerminalRuleCall_0()); 
            }
            match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_rule__TypeDefinition__Group__0__Impl3543); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getCRNLTerminalRuleCall_0()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1720:1: rule__TypeDefinition__Group__1 : rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2 ;
    public final void rule__TypeDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1724:1: ( rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1725:2: rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__1__Impl_in_rule__TypeDefinition__Group__13572);
            rule__TypeDefinition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeDefinition__Group__2_in_rule__TypeDefinition__Group__13575);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1732:1: rule__TypeDefinition__Group__1__Impl : ( ( rule__TypeDefinition__NameAssignment_1 ) ) ;
    public final void rule__TypeDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1736:1: ( ( ( rule__TypeDefinition__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1737:1: ( ( rule__TypeDefinition__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1737:1: ( ( rule__TypeDefinition__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1738:1: ( rule__TypeDefinition__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1739:1: ( rule__TypeDefinition__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1739:2: rule__TypeDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeDefinition__NameAssignment_1_in_rule__TypeDefinition__Group__1__Impl3602);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1749:1: rule__TypeDefinition__Group__2 : rule__TypeDefinition__Group__2__Impl rule__TypeDefinition__Group__3 ;
    public final void rule__TypeDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1753:1: ( rule__TypeDefinition__Group__2__Impl rule__TypeDefinition__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1754:2: rule__TypeDefinition__Group__2__Impl rule__TypeDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__2__Impl_in_rule__TypeDefinition__Group__23632);
            rule__TypeDefinition__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeDefinition__Group__3_in_rule__TypeDefinition__Group__23635);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1761:1: rule__TypeDefinition__Group__2__Impl : ( '::=' ) ;
    public final void rule__TypeDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1765:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1766:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1766:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1767:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getColonColonEqualsSignKeyword_2()); 
            }
            match(input,19,FOLLOW_19_in_rule__TypeDefinition__Group__2__Impl3663); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1780:1: rule__TypeDefinition__Group__3 : rule__TypeDefinition__Group__3__Impl ;
    public final void rule__TypeDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1784:1: ( rule__TypeDefinition__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1785:2: rule__TypeDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__3__Impl_in_rule__TypeDefinition__Group__33694);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1791:1: rule__TypeDefinition__Group__3__Impl : ( ( rule__TypeDefinition__ScopeAssignment_3 ) ) ;
    public final void rule__TypeDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1795:1: ( ( ( rule__TypeDefinition__ScopeAssignment_3 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1796:1: ( ( rule__TypeDefinition__ScopeAssignment_3 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1796:1: ( ( rule__TypeDefinition__ScopeAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1797:1: ( rule__TypeDefinition__ScopeAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getScopeAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1798:1: ( rule__TypeDefinition__ScopeAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1798:2: rule__TypeDefinition__ScopeAssignment_3
            {
            pushFollow(FOLLOW_rule__TypeDefinition__ScopeAssignment_3_in_rule__TypeDefinition__Group__3__Impl3721);
            rule__TypeDefinition__ScopeAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getScopeAssignment_3()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1816:1: rule__Macro__Group__0 : rule__Macro__Group__0__Impl rule__Macro__Group__1 ;
    public final void rule__Macro__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1820:1: ( rule__Macro__Group__0__Impl rule__Macro__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1821:2: rule__Macro__Group__0__Impl rule__Macro__Group__1
            {
            pushFollow(FOLLOW_rule__Macro__Group__0__Impl_in_rule__Macro__Group__03759);
            rule__Macro__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__1_in_rule__Macro__Group__03762);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1828:1: rule__Macro__Group__0__Impl : ( RULE_CRNL ) ;
    public final void rule__Macro__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1832:1: ( ( RULE_CRNL ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1833:1: ( RULE_CRNL )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1833:1: ( RULE_CRNL )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1834:1: RULE_CRNL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_0()); 
            }
            match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_rule__Macro__Group__0__Impl3789); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_0()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1845:1: rule__Macro__Group__1 : rule__Macro__Group__1__Impl rule__Macro__Group__2 ;
    public final void rule__Macro__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1849:1: ( rule__Macro__Group__1__Impl rule__Macro__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1850:2: rule__Macro__Group__1__Impl rule__Macro__Group__2
            {
            pushFollow(FOLLOW_rule__Macro__Group__1__Impl_in_rule__Macro__Group__13818);
            rule__Macro__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__2_in_rule__Macro__Group__13821);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1857:1: rule__Macro__Group__1__Impl : ( ( rule__Macro__NameAssignment_1 ) ) ;
    public final void rule__Macro__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1861:1: ( ( ( rule__Macro__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1862:1: ( ( rule__Macro__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1862:1: ( ( rule__Macro__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1863:1: ( rule__Macro__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1864:1: ( rule__Macro__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1864:2: rule__Macro__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Macro__NameAssignment_1_in_rule__Macro__Group__1__Impl3848);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1874:1: rule__Macro__Group__2 : rule__Macro__Group__2__Impl rule__Macro__Group__3 ;
    public final void rule__Macro__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1878:1: ( rule__Macro__Group__2__Impl rule__Macro__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1879:2: rule__Macro__Group__2__Impl rule__Macro__Group__3
            {
            pushFollow(FOLLOW_rule__Macro__Group__2__Impl_in_rule__Macro__Group__23878);
            rule__Macro__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__3_in_rule__Macro__Group__23881);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1886:1: rule__Macro__Group__2__Impl : ( 'MACRO' ) ;
    public final void rule__Macro__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1890:1: ( ( 'MACRO' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1891:1: ( 'MACRO' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1891:1: ( 'MACRO' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1892:1: 'MACRO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getMACROKeyword_2()); 
            }
            match(input,25,FOLLOW_25_in_rule__Macro__Group__2__Impl3909); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1905:1: rule__Macro__Group__3 : rule__Macro__Group__3__Impl rule__Macro__Group__4 ;
    public final void rule__Macro__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1909:1: ( rule__Macro__Group__3__Impl rule__Macro__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1910:2: rule__Macro__Group__3__Impl rule__Macro__Group__4
            {
            pushFollow(FOLLOW_rule__Macro__Group__3__Impl_in_rule__Macro__Group__33940);
            rule__Macro__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__4_in_rule__Macro__Group__33943);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1917:1: rule__Macro__Group__3__Impl : ( '::=' ) ;
    public final void rule__Macro__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1921:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1922:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1922:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1923:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_3()); 
            }
            match(input,19,FOLLOW_19_in_rule__Macro__Group__3__Impl3971); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1936:1: rule__Macro__Group__4 : rule__Macro__Group__4__Impl rule__Macro__Group__5 ;
    public final void rule__Macro__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1940:1: ( rule__Macro__Group__4__Impl rule__Macro__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1941:2: rule__Macro__Group__4__Impl rule__Macro__Group__5
            {
            pushFollow(FOLLOW_rule__Macro__Group__4__Impl_in_rule__Macro__Group__44002);
            rule__Macro__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__5_in_rule__Macro__Group__44005);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1948:1: rule__Macro__Group__4__Impl : ( RULE_CRNL ) ;
    public final void rule__Macro__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1952:1: ( ( RULE_CRNL ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1953:1: ( RULE_CRNL )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1953:1: ( RULE_CRNL )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1954:1: RULE_CRNL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_4()); 
            }
            match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_rule__Macro__Group__4__Impl4032); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_4()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1965:1: rule__Macro__Group__5 : rule__Macro__Group__5__Impl rule__Macro__Group__6 ;
    public final void rule__Macro__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1969:1: ( rule__Macro__Group__5__Impl rule__Macro__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1970:2: rule__Macro__Group__5__Impl rule__Macro__Group__6
            {
            pushFollow(FOLLOW_rule__Macro__Group__5__Impl_in_rule__Macro__Group__54061);
            rule__Macro__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__6_in_rule__Macro__Group__54064);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1977:1: rule__Macro__Group__5__Impl : ( 'BEGIN' ) ;
    public final void rule__Macro__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1981:1: ( ( 'BEGIN' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1982:1: ( 'BEGIN' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1982:1: ( 'BEGIN' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1983:1: 'BEGIN'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getBEGINKeyword_5()); 
            }
            match(input,20,FOLLOW_20_in_rule__Macro__Group__5__Impl4092); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1996:1: rule__Macro__Group__6 : rule__Macro__Group__6__Impl rule__Macro__Group__7 ;
    public final void rule__Macro__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2000:1: ( rule__Macro__Group__6__Impl rule__Macro__Group__7 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2001:2: rule__Macro__Group__6__Impl rule__Macro__Group__7
            {
            pushFollow(FOLLOW_rule__Macro__Group__6__Impl_in_rule__Macro__Group__64123);
            rule__Macro__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__7_in_rule__Macro__Group__64126);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2008:1: rule__Macro__Group__6__Impl : ( RULE_CRNL ) ;
    public final void rule__Macro__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2012:1: ( ( RULE_CRNL ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2013:1: ( RULE_CRNL )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2013:1: ( RULE_CRNL )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2014:1: RULE_CRNL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_6()); 
            }
            match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_rule__Macro__Group__6__Impl4153); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_6()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2025:1: rule__Macro__Group__7 : rule__Macro__Group__7__Impl rule__Macro__Group__8 ;
    public final void rule__Macro__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2029:1: ( rule__Macro__Group__7__Impl rule__Macro__Group__8 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2030:2: rule__Macro__Group__7__Impl rule__Macro__Group__8
            {
            pushFollow(FOLLOW_rule__Macro__Group__7__Impl_in_rule__Macro__Group__74182);
            rule__Macro__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__8_in_rule__Macro__Group__74185);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2037:1: rule__Macro__Group__7__Impl : ( 'TYPE NOTATION' ) ;
    public final void rule__Macro__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2041:1: ( ( 'TYPE NOTATION' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2042:1: ( 'TYPE NOTATION' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2042:1: ( 'TYPE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2043:1: 'TYPE NOTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTYPENOTATIONKeyword_7()); 
            }
            match(input,26,FOLLOW_26_in_rule__Macro__Group__7__Impl4213); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getTYPENOTATIONKeyword_7()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2056:1: rule__Macro__Group__8 : rule__Macro__Group__8__Impl rule__Macro__Group__9 ;
    public final void rule__Macro__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2060:1: ( rule__Macro__Group__8__Impl rule__Macro__Group__9 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2061:2: rule__Macro__Group__8__Impl rule__Macro__Group__9
            {
            pushFollow(FOLLOW_rule__Macro__Group__8__Impl_in_rule__Macro__Group__84244);
            rule__Macro__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__9_in_rule__Macro__Group__84247);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2068:1: rule__Macro__Group__8__Impl : ( '::=' ) ;
    public final void rule__Macro__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2072:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2073:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2073:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2074:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_8()); 
            }
            match(input,19,FOLLOW_19_in_rule__Macro__Group__8__Impl4275); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2087:1: rule__Macro__Group__9 : rule__Macro__Group__9__Impl rule__Macro__Group__10 ;
    public final void rule__Macro__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2091:1: ( rule__Macro__Group__9__Impl rule__Macro__Group__10 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2092:2: rule__Macro__Group__9__Impl rule__Macro__Group__10
            {
            pushFollow(FOLLOW_rule__Macro__Group__9__Impl_in_rule__Macro__Group__94306);
            rule__Macro__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__10_in_rule__Macro__Group__94309);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2099:1: rule__Macro__Group__9__Impl : ( ( ( rule__Macro__TypeNotationsAssignment_9 ) ) ( ( rule__Macro__TypeNotationsAssignment_9 )* ) ) ;
    public final void rule__Macro__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2103:1: ( ( ( ( rule__Macro__TypeNotationsAssignment_9 ) ) ( ( rule__Macro__TypeNotationsAssignment_9 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2104:1: ( ( ( rule__Macro__TypeNotationsAssignment_9 ) ) ( ( rule__Macro__TypeNotationsAssignment_9 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2104:1: ( ( ( rule__Macro__TypeNotationsAssignment_9 ) ) ( ( rule__Macro__TypeNotationsAssignment_9 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2105:1: ( ( rule__Macro__TypeNotationsAssignment_9 ) ) ( ( rule__Macro__TypeNotationsAssignment_9 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2105:1: ( ( rule__Macro__TypeNotationsAssignment_9 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2106:1: ( rule__Macro__TypeNotationsAssignment_9 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTypeNotationsAssignment_9()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2107:1: ( rule__Macro__TypeNotationsAssignment_9 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2107:2: rule__Macro__TypeNotationsAssignment_9
            {
            pushFollow(FOLLOW_rule__Macro__TypeNotationsAssignment_9_in_rule__Macro__Group__9__Impl4338);
            rule__Macro__TypeNotationsAssignment_9();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getTypeNotationsAssignment_9()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2110:1: ( ( rule__Macro__TypeNotationsAssignment_9 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2111:1: ( rule__Macro__TypeNotationsAssignment_9 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTypeNotationsAssignment_9()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2112:1: ( rule__Macro__TypeNotationsAssignment_9 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_MODULE_ID && LA16_0<=RULE_PARAMETER)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2112:2: rule__Macro__TypeNotationsAssignment_9
            	    {
            	    pushFollow(FOLLOW_rule__Macro__TypeNotationsAssignment_9_in_rule__Macro__Group__9__Impl4350);
            	    rule__Macro__TypeNotationsAssignment_9();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getTypeNotationsAssignment_9()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2123:1: rule__Macro__Group__10 : rule__Macro__Group__10__Impl rule__Macro__Group__11 ;
    public final void rule__Macro__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2127:1: ( rule__Macro__Group__10__Impl rule__Macro__Group__11 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2128:2: rule__Macro__Group__10__Impl rule__Macro__Group__11
            {
            pushFollow(FOLLOW_rule__Macro__Group__10__Impl_in_rule__Macro__Group__104383);
            rule__Macro__Group__10__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__11_in_rule__Macro__Group__104386);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2135:1: rule__Macro__Group__10__Impl : ( RULE_CRNL ) ;
    public final void rule__Macro__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2139:1: ( ( RULE_CRNL ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2140:1: ( RULE_CRNL )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2140:1: ( RULE_CRNL )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2141:1: RULE_CRNL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_10()); 
            }
            match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_rule__Macro__Group__10__Impl4413); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getCRNLTerminalRuleCall_10()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2152:1: rule__Macro__Group__11 : rule__Macro__Group__11__Impl rule__Macro__Group__12 ;
    public final void rule__Macro__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2156:1: ( rule__Macro__Group__11__Impl rule__Macro__Group__12 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2157:2: rule__Macro__Group__11__Impl rule__Macro__Group__12
            {
            pushFollow(FOLLOW_rule__Macro__Group__11__Impl_in_rule__Macro__Group__114442);
            rule__Macro__Group__11__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__12_in_rule__Macro__Group__114445);
            rule__Macro__Group__12();

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2164:1: rule__Macro__Group__11__Impl : ( 'VALUE NOTATION' ) ;
    public final void rule__Macro__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2168:1: ( ( 'VALUE NOTATION' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2169:1: ( 'VALUE NOTATION' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2169:1: ( 'VALUE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2170:1: 'VALUE NOTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getVALUENOTATIONKeyword_11()); 
            }
            match(input,27,FOLLOW_27_in_rule__Macro__Group__11__Impl4473); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getVALUENOTATIONKeyword_11()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Macro__Group__12"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2183:1: rule__Macro__Group__12 : rule__Macro__Group__12__Impl rule__Macro__Group__13 ;
    public final void rule__Macro__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2187:1: ( rule__Macro__Group__12__Impl rule__Macro__Group__13 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2188:2: rule__Macro__Group__12__Impl rule__Macro__Group__13
            {
            pushFollow(FOLLOW_rule__Macro__Group__12__Impl_in_rule__Macro__Group__124504);
            rule__Macro__Group__12__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__13_in_rule__Macro__Group__124507);
            rule__Macro__Group__13();

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
    // $ANTLR end "rule__Macro__Group__12"


    // $ANTLR start "rule__Macro__Group__12__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2195:1: rule__Macro__Group__12__Impl : ( '::=' ) ;
    public final void rule__Macro__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2199:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2200:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2200:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2201:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_12()); 
            }
            match(input,19,FOLLOW_19_in_rule__Macro__Group__12__Impl4535); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_12()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__12__Impl"


    // $ANTLR start "rule__Macro__Group__13"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2214:1: rule__Macro__Group__13 : rule__Macro__Group__13__Impl rule__Macro__Group__14 ;
    public final void rule__Macro__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2218:1: ( rule__Macro__Group__13__Impl rule__Macro__Group__14 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2219:2: rule__Macro__Group__13__Impl rule__Macro__Group__14
            {
            pushFollow(FOLLOW_rule__Macro__Group__13__Impl_in_rule__Macro__Group__134566);
            rule__Macro__Group__13__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__14_in_rule__Macro__Group__134569);
            rule__Macro__Group__14();

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
    // $ANTLR end "rule__Macro__Group__13"


    // $ANTLR start "rule__Macro__Group__13__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2226:1: rule__Macro__Group__13__Impl : ( ( rule__Macro__ValueNotationAssignment_13 ) ) ;
    public final void rule__Macro__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2230:1: ( ( ( rule__Macro__ValueNotationAssignment_13 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2231:1: ( ( rule__Macro__ValueNotationAssignment_13 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2231:1: ( ( rule__Macro__ValueNotationAssignment_13 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2232:1: ( rule__Macro__ValueNotationAssignment_13 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getValueNotationAssignment_13()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2233:1: ( rule__Macro__ValueNotationAssignment_13 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2233:2: rule__Macro__ValueNotationAssignment_13
            {
            pushFollow(FOLLOW_rule__Macro__ValueNotationAssignment_13_in_rule__Macro__Group__13__Impl4596);
            rule__Macro__ValueNotationAssignment_13();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getValueNotationAssignment_13()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__13__Impl"


    // $ANTLR start "rule__Macro__Group__14"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2243:1: rule__Macro__Group__14 : rule__Macro__Group__14__Impl rule__Macro__Group__15 ;
    public final void rule__Macro__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2247:1: ( rule__Macro__Group__14__Impl rule__Macro__Group__15 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2248:2: rule__Macro__Group__14__Impl rule__Macro__Group__15
            {
            pushFollow(FOLLOW_rule__Macro__Group__14__Impl_in_rule__Macro__Group__144626);
            rule__Macro__Group__14__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__15_in_rule__Macro__Group__144629);
            rule__Macro__Group__15();

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
    // $ANTLR end "rule__Macro__Group__14"


    // $ANTLR start "rule__Macro__Group__14__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2255:1: rule__Macro__Group__14__Impl : ( ( ( rule__Macro__InnerTypesAssignment_14 ) ) ( ( rule__Macro__InnerTypesAssignment_14 )* ) ) ;
    public final void rule__Macro__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2259:1: ( ( ( ( rule__Macro__InnerTypesAssignment_14 ) ) ( ( rule__Macro__InnerTypesAssignment_14 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2260:1: ( ( ( rule__Macro__InnerTypesAssignment_14 ) ) ( ( rule__Macro__InnerTypesAssignment_14 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2260:1: ( ( ( rule__Macro__InnerTypesAssignment_14 ) ) ( ( rule__Macro__InnerTypesAssignment_14 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2261:1: ( ( rule__Macro__InnerTypesAssignment_14 ) ) ( ( rule__Macro__InnerTypesAssignment_14 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2261:1: ( ( rule__Macro__InnerTypesAssignment_14 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2262:1: ( rule__Macro__InnerTypesAssignment_14 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesAssignment_14()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2263:1: ( rule__Macro__InnerTypesAssignment_14 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2263:2: rule__Macro__InnerTypesAssignment_14
            {
            pushFollow(FOLLOW_rule__Macro__InnerTypesAssignment_14_in_rule__Macro__Group__14__Impl4658);
            rule__Macro__InnerTypesAssignment_14();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesAssignment_14()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2266:1: ( ( rule__Macro__InnerTypesAssignment_14 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2267:1: ( rule__Macro__InnerTypesAssignment_14 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesAssignment_14()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2268:1: ( rule__Macro__InnerTypesAssignment_14 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_CRNL) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2268:2: rule__Macro__InnerTypesAssignment_14
            	    {
            	    pushFollow(FOLLOW_rule__Macro__InnerTypesAssignment_14_in_rule__Macro__Group__14__Impl4670);
            	    rule__Macro__InnerTypesAssignment_14();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesAssignment_14()); 
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
    // $ANTLR end "rule__Macro__Group__14__Impl"


    // $ANTLR start "rule__Macro__Group__15"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2279:1: rule__Macro__Group__15 : rule__Macro__Group__15__Impl ;
    public final void rule__Macro__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2283:1: ( rule__Macro__Group__15__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2284:2: rule__Macro__Group__15__Impl
            {
            pushFollow(FOLLOW_rule__Macro__Group__15__Impl_in_rule__Macro__Group__154703);
            rule__Macro__Group__15__Impl();

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
    // $ANTLR end "rule__Macro__Group__15"


    // $ANTLR start "rule__Macro__Group__15__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2290:1: rule__Macro__Group__15__Impl : ( 'END' ) ;
    public final void rule__Macro__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2294:1: ( ( 'END' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2295:1: ( 'END' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2295:1: ( 'END' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2296:1: 'END'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getENDKeyword_15()); 
            }
            match(input,21,FOLLOW_21_in_rule__Macro__Group__15__Impl4731); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getENDKeyword_15()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__15__Impl"


    // $ANTLR start "rule__ParamAssignment__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2341:1: rule__ParamAssignment__Group__0 : rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1 ;
    public final void rule__ParamAssignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2345:1: ( rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2346:2: rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1
            {
            pushFollow(FOLLOW_rule__ParamAssignment__Group__0__Impl_in_rule__ParamAssignment__Group__04794);
            rule__ParamAssignment__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ParamAssignment__Group__1_in_rule__ParamAssignment__Group__04797);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2353:1: rule__ParamAssignment__Group__0__Impl : ( ( rule__ParamAssignment__ParamAssignment_0 ) ) ;
    public final void rule__ParamAssignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2357:1: ( ( ( rule__ParamAssignment__ParamAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2358:1: ( ( rule__ParamAssignment__ParamAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2358:1: ( ( rule__ParamAssignment__ParamAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2359:1: ( rule__ParamAssignment__ParamAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getParamAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2360:1: ( rule__ParamAssignment__ParamAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2360:2: rule__ParamAssignment__ParamAssignment_0
            {
            pushFollow(FOLLOW_rule__ParamAssignment__ParamAssignment_0_in_rule__ParamAssignment__Group__0__Impl4824);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2370:1: rule__ParamAssignment__Group__1 : rule__ParamAssignment__Group__1__Impl ;
    public final void rule__ParamAssignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2374:1: ( rule__ParamAssignment__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2375:2: rule__ParamAssignment__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParamAssignment__Group__1__Impl_in_rule__ParamAssignment__Group__14854);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2381:1: rule__ParamAssignment__Group__1__Impl : ( ( rule__ParamAssignment__RightAssignment_1 ) ) ;
    public final void rule__ParamAssignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2385:1: ( ( ( rule__ParamAssignment__RightAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2386:1: ( ( rule__ParamAssignment__RightAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2386:1: ( ( rule__ParamAssignment__RightAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2387:1: ( rule__ParamAssignment__RightAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getRightAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2388:1: ( rule__ParamAssignment__RightAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2388:2: rule__ParamAssignment__RightAssignment_1
            {
            pushFollow(FOLLOW_rule__ParamAssignment__RightAssignment_1_in_rule__ParamAssignment__Group__1__Impl4881);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2402:1: rule__TypeReferenceExt__Group__0 : rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1 ;
    public final void rule__TypeReferenceExt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2406:1: ( rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2407:2: rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__0__Impl_in_rule__TypeReferenceExt__Group__04915);
            rule__TypeReferenceExt__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__1_in_rule__TypeReferenceExt__Group__04918);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2414:1: rule__TypeReferenceExt__Group__0__Impl : ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) ) ;
    public final void rule__TypeReferenceExt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2418:1: ( ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2419:1: ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2419:1: ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2420:1: ( rule__TypeReferenceExt__ParentRefAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getParentRefAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2421:1: ( rule__TypeReferenceExt__ParentRefAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2421:2: rule__TypeReferenceExt__ParentRefAssignment_0
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__ParentRefAssignment_0_in_rule__TypeReferenceExt__Group__0__Impl4945);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2431:1: rule__TypeReferenceExt__Group__1 : rule__TypeReferenceExt__Group__1__Impl ;
    public final void rule__TypeReferenceExt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2435:1: ( rule__TypeReferenceExt__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2436:2: rule__TypeReferenceExt__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__1__Impl_in_rule__TypeReferenceExt__Group__14975);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2442:1: rule__TypeReferenceExt__Group__1__Impl : ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? ) ;
    public final void rule__TypeReferenceExt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2446:1: ( ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2447:1: ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2447:1: ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2448:1: ( rule__TypeReferenceExt__ChildRefAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getChildRefAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2449:1: ( rule__TypeReferenceExt__ChildRefAssignment_1 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_MODULE_ID) ) {
                int LA18_1 = input.LA(2);

                if ( (synpred24_InternalSmi()) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2449:2: rule__TypeReferenceExt__ChildRefAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_rule__TypeReferenceExt__Group__1__Impl5002);
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


    // $ANTLR start "rule__Scope__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2463:1: rule__Scope__Group__0 : rule__Scope__Group__0__Impl rule__Scope__Group__1 ;
    public final void rule__Scope__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2467:1: ( rule__Scope__Group__0__Impl rule__Scope__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2468:2: rule__Scope__Group__0__Impl rule__Scope__Group__1
            {
            pushFollow(FOLLOW_rule__Scope__Group__0__Impl_in_rule__Scope__Group__05037);
            rule__Scope__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Scope__Group__1_in_rule__Scope__Group__05040);
            rule__Scope__Group__1();

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
    // $ANTLR end "rule__Scope__Group__0"


    // $ANTLR start "rule__Scope__Group__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2475:1: rule__Scope__Group__0__Impl : ( ( ( rule__Scope__ValuesAssignment_0 ) ) ( ( rule__Scope__ValuesAssignment_0 )* ) ) ;
    public final void rule__Scope__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2479:1: ( ( ( ( rule__Scope__ValuesAssignment_0 ) ) ( ( rule__Scope__ValuesAssignment_0 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2480:1: ( ( ( rule__Scope__ValuesAssignment_0 ) ) ( ( rule__Scope__ValuesAssignment_0 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2480:1: ( ( ( rule__Scope__ValuesAssignment_0 ) ) ( ( rule__Scope__ValuesAssignment_0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2481:1: ( ( rule__Scope__ValuesAssignment_0 ) ) ( ( rule__Scope__ValuesAssignment_0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2481:1: ( ( rule__Scope__ValuesAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2482:1: ( rule__Scope__ValuesAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScopeAccess().getValuesAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2483:1: ( rule__Scope__ValuesAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2483:2: rule__Scope__ValuesAssignment_0
            {
            pushFollow(FOLLOW_rule__Scope__ValuesAssignment_0_in_rule__Scope__Group__0__Impl5069);
            rule__Scope__ValuesAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScopeAccess().getValuesAssignment_0()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2486:1: ( ( rule__Scope__ValuesAssignment_0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2487:1: ( rule__Scope__ValuesAssignment_0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScopeAccess().getValuesAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2488:1: ( rule__Scope__ValuesAssignment_0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_IA5STRING||(LA19_0>=RULE_MODULE_ID && LA19_0<=RULE_PARAMETER)||LA19_0==22||LA19_0==29||(LA19_0>=33 && LA19_0<=35)||LA19_0==38) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2488:2: rule__Scope__ValuesAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__Scope__ValuesAssignment_0_in_rule__Scope__Group__0__Impl5081);
            	    rule__Scope__ValuesAssignment_0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getScopeAccess().getValuesAssignment_0()); 
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
    // $ANTLR end "rule__Scope__Group__0__Impl"


    // $ANTLR start "rule__Scope__Group__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2499:1: rule__Scope__Group__1 : rule__Scope__Group__1__Impl ;
    public final void rule__Scope__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2503:1: ( rule__Scope__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2504:2: rule__Scope__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Scope__Group__1__Impl_in_rule__Scope__Group__15114);
            rule__Scope__Group__1__Impl();

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
    // $ANTLR end "rule__Scope__Group__1"


    // $ANTLR start "rule__Scope__Group__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2510:1: rule__Scope__Group__1__Impl : ( RULE_CRNL ) ;
    public final void rule__Scope__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2514:1: ( ( RULE_CRNL ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2515:1: ( RULE_CRNL )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2515:1: ( RULE_CRNL )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2516:1: RULE_CRNL
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScopeAccess().getCRNLTerminalRuleCall_1()); 
            }
            match(input,RULE_CRNL,FOLLOW_RULE_CRNL_in_rule__Scope__Group__1__Impl5141); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScopeAccess().getCRNLTerminalRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scope__Group__1__Impl"


    // $ANTLR start "rule__Value__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2531:1: rule__Value__Group__0 : rule__Value__Group__0__Impl rule__Value__Group__1 ;
    public final void rule__Value__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2535:1: ( rule__Value__Group__0__Impl rule__Value__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2536:2: rule__Value__Group__0__Impl rule__Value__Group__1
            {
            pushFollow(FOLLOW_rule__Value__Group__0__Impl_in_rule__Value__Group__05174);
            rule__Value__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group__1_in_rule__Value__Group__05177);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2543:1: rule__Value__Group__0__Impl : ( ( rule__Value__ValueTypesAssignment_0 ) ) ;
    public final void rule__Value__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2547:1: ( ( ( rule__Value__ValueTypesAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2548:1: ( ( rule__Value__ValueTypesAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2548:1: ( ( rule__Value__ValueTypesAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2549:1: ( rule__Value__ValueTypesAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2550:1: ( rule__Value__ValueTypesAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2550:2: rule__Value__ValueTypesAssignment_0
            {
            pushFollow(FOLLOW_rule__Value__ValueTypesAssignment_0_in_rule__Value__Group__0__Impl5204);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2560:1: rule__Value__Group__1 : rule__Value__Group__1__Impl ;
    public final void rule__Value__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2564:1: ( rule__Value__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2565:2: rule__Value__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group__1__Impl_in_rule__Value__Group__15234);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2571:1: rule__Value__Group__1__Impl : ( ( rule__Value__Group_1__0 )* ) ;
    public final void rule__Value__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2575:1: ( ( ( rule__Value__Group_1__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2576:1: ( ( rule__Value__Group_1__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2576:1: ( ( rule__Value__Group_1__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2577:1: ( rule__Value__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getGroup_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2578:1: ( rule__Value__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==28) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2578:2: rule__Value__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Value__Group_1__0_in_rule__Value__Group__1__Impl5261);
            	    rule__Value__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2592:1: rule__Value__Group_1__0 : rule__Value__Group_1__0__Impl rule__Value__Group_1__1 ;
    public final void rule__Value__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2596:1: ( rule__Value__Group_1__0__Impl rule__Value__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2597:2: rule__Value__Group_1__0__Impl rule__Value__Group_1__1
            {
            pushFollow(FOLLOW_rule__Value__Group_1__0__Impl_in_rule__Value__Group_1__05296);
            rule__Value__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group_1__1_in_rule__Value__Group_1__05299);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2604:1: rule__Value__Group_1__0__Impl : ( '|' ) ;
    public final void rule__Value__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2608:1: ( ( '|' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2609:1: ( '|' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2609:1: ( '|' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2610:1: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getVerticalLineKeyword_1_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__Value__Group_1__0__Impl5327); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2623:1: rule__Value__Group_1__1 : rule__Value__Group_1__1__Impl ;
    public final void rule__Value__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2627:1: ( rule__Value__Group_1__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2628:2: rule__Value__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group_1__1__Impl_in_rule__Value__Group_1__15358);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2634:1: rule__Value__Group_1__1__Impl : ( ( rule__Value__ValueTypesAssignment_1_1 ) ) ;
    public final void rule__Value__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2638:1: ( ( ( rule__Value__ValueTypesAssignment_1_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2639:1: ( ( rule__Value__ValueTypesAssignment_1_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2639:1: ( ( rule__Value__ValueTypesAssignment_1_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2640:1: ( rule__Value__ValueTypesAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesAssignment_1_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2641:1: ( rule__Value__ValueTypesAssignment_1_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2641:2: rule__Value__ValueTypesAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Value__ValueTypesAssignment_1_1_in_rule__Value__Group_1__1__Impl5385);
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


    // $ANTLR start "rule__MacroValue__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2655:1: rule__MacroValue__Group__0 : rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1 ;
    public final void rule__MacroValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2659:1: ( rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2660:2: rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__0__Impl_in_rule__MacroValue__Group__05419);
            rule__MacroValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__1_in_rule__MacroValue__Group__05422);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2667:1: rule__MacroValue__Group__0__Impl : ( () ) ;
    public final void rule__MacroValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2671:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2672:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2672:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2673:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getMacroValueAction_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2674:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2676:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2686:1: rule__MacroValue__Group__1 : rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2 ;
    public final void rule__MacroValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2690:1: ( rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2691:2: rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__1__Impl_in_rule__MacroValue__Group__15480);
            rule__MacroValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__2_in_rule__MacroValue__Group__15483);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2698:1: rule__MacroValue__Group__1__Impl : ( 'value' ) ;
    public final void rule__MacroValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2702:1: ( ( 'value' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2703:1: ( 'value' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2703:1: ( 'value' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2704:1: 'value'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getValueKeyword_1()); 
            }
            match(input,29,FOLLOW_29_in_rule__MacroValue__Group__1__Impl5511); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2717:1: rule__MacroValue__Group__2 : rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3 ;
    public final void rule__MacroValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2721:1: ( rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2722:2: rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__2__Impl_in_rule__MacroValue__Group__25542);
            rule__MacroValue__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__3_in_rule__MacroValue__Group__25545);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2729:1: rule__MacroValue__Group__2__Impl : ( '(' ) ;
    public final void rule__MacroValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2733:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2734:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2734:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2735:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,30,FOLLOW_30_in_rule__MacroValue__Group__2__Impl5573); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2748:1: rule__MacroValue__Group__3 : rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4 ;
    public final void rule__MacroValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2752:1: ( rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2753:2: rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__3__Impl_in_rule__MacroValue__Group__35604);
            rule__MacroValue__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__4_in_rule__MacroValue__Group__35607);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2760:1: rule__MacroValue__Group__3__Impl : ( ( rule__MacroValue__TypeAssignment_3 ) ) ;
    public final void rule__MacroValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2764:1: ( ( ( rule__MacroValue__TypeAssignment_3 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2765:1: ( ( rule__MacroValue__TypeAssignment_3 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2765:1: ( ( rule__MacroValue__TypeAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2766:1: ( rule__MacroValue__TypeAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getTypeAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2767:1: ( rule__MacroValue__TypeAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2767:2: rule__MacroValue__TypeAssignment_3
            {
            pushFollow(FOLLOW_rule__MacroValue__TypeAssignment_3_in_rule__MacroValue__Group__3__Impl5634);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2777:1: rule__MacroValue__Group__4 : rule__MacroValue__Group__4__Impl ;
    public final void rule__MacroValue__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2781:1: ( rule__MacroValue__Group__4__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2782:2: rule__MacroValue__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__4__Impl_in_rule__MacroValue__Group__45664);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2788:1: rule__MacroValue__Group__4__Impl : ( ')' ) ;
    public final void rule__MacroValue__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2792:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2793:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2793:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2794:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,31,FOLLOW_31_in_rule__MacroValue__Group__4__Impl5692); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2817:1: rule__UpdateType__Group__0 : rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1 ;
    public final void rule__UpdateType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2821:1: ( rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2822:2: rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__0__Impl_in_rule__UpdateType__Group__05733);
            rule__UpdateType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__UpdateType__Group__1_in_rule__UpdateType__Group__05736);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2829:1: rule__UpdateType__Group__0__Impl : ( 'Update' ) ;
    public final void rule__UpdateType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2833:1: ( ( 'Update' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2834:1: ( 'Update' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2834:1: ( 'Update' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2835:1: 'Update'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getUpdateKeyword_0()); 
            }
            match(input,32,FOLLOW_32_in_rule__UpdateType__Group__0__Impl5764); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2848:1: rule__UpdateType__Group__1 : rule__UpdateType__Group__1__Impl ;
    public final void rule__UpdateType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2852:1: ( rule__UpdateType__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2853:2: rule__UpdateType__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__1__Impl_in_rule__UpdateType__Group__15795);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2859:1: rule__UpdateType__Group__1__Impl : ( ( rule__UpdateType__TypeAssignment_1 ) ) ;
    public final void rule__UpdateType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2863:1: ( ( ( rule__UpdateType__TypeAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2864:1: ( ( rule__UpdateType__TypeAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2864:1: ( ( rule__UpdateType__TypeAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2865:1: ( rule__UpdateType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getTypeAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2866:1: ( rule__UpdateType__TypeAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2866:2: rule__UpdateType__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__UpdateType__TypeAssignment_1_in_rule__UpdateType__Group__1__Impl5822);
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


    // $ANTLR start "rule__ASN1_SIMPLE__Group_0__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2880:1: rule__ASN1_SIMPLE__Group_0__0 : rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1 ;
    public final void rule__ASN1_SIMPLE__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2884:1: ( rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2885:2: rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__0__Impl_in_rule__ASN1_SIMPLE__Group_0__05856);
            rule__ASN1_SIMPLE__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__1_in_rule__ASN1_SIMPLE__Group_0__05859);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2892:1: rule__ASN1_SIMPLE__Group_0__0__Impl : ( () ) ;
    public final void rule__ASN1_SIMPLE__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2896:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2897:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2897:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2898:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2899:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2901:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2911:1: rule__ASN1_SIMPLE__Group_0__1 : rule__ASN1_SIMPLE__Group_0__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2915:1: ( rule__ASN1_SIMPLE__Group_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2916:2: rule__ASN1_SIMPLE__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__1__Impl_in_rule__ASN1_SIMPLE__Group_0__15917);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2922:1: rule__ASN1_SIMPLE__Group_0__1__Impl : ( 'empty' ) ;
    public final void rule__ASN1_SIMPLE__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2926:1: ( ( 'empty' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2927:1: ( 'empty' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2927:1: ( 'empty' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2928:1: 'empty'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1()); 
            }
            match(input,33,FOLLOW_33_in_rule__ASN1_SIMPLE__Group_0__1__Impl5945); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2945:1: rule__ASN1_SIMPLE__Group_1__0 : rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1 ;
    public final void rule__ASN1_SIMPLE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2949:1: ( rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2950:2: rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__0__Impl_in_rule__ASN1_SIMPLE__Group_1__05980);
            rule__ASN1_SIMPLE__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__1_in_rule__ASN1_SIMPLE__Group_1__05983);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2957:1: rule__ASN1_SIMPLE__Group_1__0__Impl : ( () ) ;
    public final void rule__ASN1_SIMPLE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2961:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2962:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2962:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2963:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2964:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2966:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2976:1: rule__ASN1_SIMPLE__Group_1__1 : rule__ASN1_SIMPLE__Group_1__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2980:1: ( rule__ASN1_SIMPLE__Group_1__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2981:2: rule__ASN1_SIMPLE__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__1__Impl_in_rule__ASN1_SIMPLE__Group_1__16041);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2987:1: rule__ASN1_SIMPLE__Group_1__1__Impl : ( RULE_IA5STRING ) ;
    public final void rule__ASN1_SIMPLE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2991:1: ( ( RULE_IA5STRING ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2992:1: ( RULE_IA5STRING )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2992:1: ( RULE_IA5STRING )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2993:1: RULE_IA5STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()); 
            }
            match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_rule__ASN1_SIMPLE__Group_1__1__Impl6068); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3008:1: rule__ASN1_SIMPLE__Group_2__0 : rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1 ;
    public final void rule__ASN1_SIMPLE__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3012:1: ( rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3013:2: rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__0__Impl_in_rule__ASN1_SIMPLE__Group_2__06101);
            rule__ASN1_SIMPLE__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__1_in_rule__ASN1_SIMPLE__Group_2__06104);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3020:1: rule__ASN1_SIMPLE__Group_2__0__Impl : ( ruleASN1_OCTET_STRING ) ;
    public final void rule__ASN1_SIMPLE__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3024:1: ( ( ruleASN1_OCTET_STRING ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3025:1: ( ruleASN1_OCTET_STRING )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3025:1: ( ruleASN1_OCTET_STRING )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3026:1: ruleASN1_OCTET_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_rule__ASN1_SIMPLE__Group_2__0__Impl6131);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3037:1: rule__ASN1_SIMPLE__Group_2__1 : rule__ASN1_SIMPLE__Group_2__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3041:1: ( rule__ASN1_SIMPLE__Group_2__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3042:2: rule__ASN1_SIMPLE__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__1__Impl_in_rule__ASN1_SIMPLE__Group_2__16160);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3048:1: rule__ASN1_SIMPLE__Group_2__1__Impl : ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? ) ;
    public final void rule__ASN1_SIMPLE__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3052:1: ( ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3053:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3053:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3054:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_2_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3055:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3055:2: rule__ASN1_SIMPLE__ConstraintAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_in_rule__ASN1_SIMPLE__Group_2__1__Impl6187);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3069:1: rule__ASN1_SIMPLE__Group_3__0 : rule__ASN1_SIMPLE__Group_3__0__Impl rule__ASN1_SIMPLE__Group_3__1 ;
    public final void rule__ASN1_SIMPLE__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3073:1: ( rule__ASN1_SIMPLE__Group_3__0__Impl rule__ASN1_SIMPLE__Group_3__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3074:2: rule__ASN1_SIMPLE__Group_3__0__Impl rule__ASN1_SIMPLE__Group_3__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__0__Impl_in_rule__ASN1_SIMPLE__Group_3__06222);
            rule__ASN1_SIMPLE__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__1_in_rule__ASN1_SIMPLE__Group_3__06225);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3081:1: rule__ASN1_SIMPLE__Group_3__0__Impl : ( ruleASN1_INTEGER ) ;
    public final void rule__ASN1_SIMPLE__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3085:1: ( ( ruleASN1_INTEGER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3086:1: ( ruleASN1_INTEGER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3086:1: ( ruleASN1_INTEGER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3087:1: ruleASN1_INTEGER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_rule__ASN1_SIMPLE__Group_3__0__Impl6252);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3098:1: rule__ASN1_SIMPLE__Group_3__1 : rule__ASN1_SIMPLE__Group_3__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3102:1: ( rule__ASN1_SIMPLE__Group_3__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3103:2: rule__ASN1_SIMPLE__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__1__Impl_in_rule__ASN1_SIMPLE__Group_3__16281);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3109:1: rule__ASN1_SIMPLE__Group_3__1__Impl : ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? ) ;
    public final void rule__ASN1_SIMPLE__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3113:1: ( ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3114:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3114:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3115:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_3_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3116:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_INT) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3116:2: rule__ASN1_SIMPLE__ConstraintAssignment_3_1
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_3_1_in_rule__ASN1_SIMPLE__Group_3__1__Impl6308);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3130:1: rule__ASN1_OCTET_STRING__Group__0 : rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1 ;
    public final void rule__ASN1_OCTET_STRING__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3134:1: ( rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3135:2: rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__0__Impl_in_rule__ASN1_OCTET_STRING__Group__06343);
            rule__ASN1_OCTET_STRING__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__1_in_rule__ASN1_OCTET_STRING__Group__06346);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3142:1: rule__ASN1_OCTET_STRING__Group__0__Impl : ( () ) ;
    public final void rule__ASN1_OCTET_STRING__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3146:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3147:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3147:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3148:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3149:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3151:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3161:1: rule__ASN1_OCTET_STRING__Group__1 : rule__ASN1_OCTET_STRING__Group__1__Impl ;
    public final void rule__ASN1_OCTET_STRING__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3165:1: ( rule__ASN1_OCTET_STRING__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3166:2: rule__ASN1_OCTET_STRING__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__1__Impl_in_rule__ASN1_OCTET_STRING__Group__16404);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3172:1: rule__ASN1_OCTET_STRING__Group__1__Impl : ( 'OCTET STRING' ) ;
    public final void rule__ASN1_OCTET_STRING__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3176:1: ( ( 'OCTET STRING' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3177:1: ( 'OCTET STRING' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3177:1: ( 'OCTET STRING' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3178:1: 'OCTET STRING'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getOCTETSTRINGKeyword_1()); 
            }
            match(input,34,FOLLOW_34_in_rule__ASN1_OCTET_STRING__Group__1__Impl6432); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3195:1: rule__ASN1_INTEGER__Group__0 : rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1 ;
    public final void rule__ASN1_INTEGER__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3199:1: ( rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3200:2: rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__0__Impl_in_rule__ASN1_INTEGER__Group__06467);
            rule__ASN1_INTEGER__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__1_in_rule__ASN1_INTEGER__Group__06470);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3207:1: rule__ASN1_INTEGER__Group__0__Impl : ( 'INTEGER' ) ;
    public final void rule__ASN1_INTEGER__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3211:1: ( ( 'INTEGER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3212:1: ( 'INTEGER' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3212:1: ( 'INTEGER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3213:1: 'INTEGER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getINTEGERKeyword_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__ASN1_INTEGER__Group__0__Impl6498); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3226:1: rule__ASN1_INTEGER__Group__1 : rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2 ;
    public final void rule__ASN1_INTEGER__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3230:1: ( rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3231:2: rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__1__Impl_in_rule__ASN1_INTEGER__Group__16529);
            rule__ASN1_INTEGER__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__2_in_rule__ASN1_INTEGER__Group__16532);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3238:1: rule__ASN1_INTEGER__Group__1__Impl : ( '{' ) ;
    public final void rule__ASN1_INTEGER__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3242:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3243:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3243:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3244:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,23,FOLLOW_23_in_rule__ASN1_INTEGER__Group__1__Impl6560); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3257:1: rule__ASN1_INTEGER__Group__2 : rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3 ;
    public final void rule__ASN1_INTEGER__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3261:1: ( rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3262:2: rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__2__Impl_in_rule__ASN1_INTEGER__Group__26591);
            rule__ASN1_INTEGER__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__3_in_rule__ASN1_INTEGER__Group__26594);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3269:1: rule__ASN1_INTEGER__Group__2__Impl : ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) ) ;
    public final void rule__ASN1_INTEGER__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3273:1: ( ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3274:1: ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3274:1: ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3275:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3275:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3276:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3277:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3277:2: rule__ASN1_INTEGER__ValuePairsAssignment_2
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6623);
            rule__ASN1_INTEGER__ValuePairsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3280:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3281:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3282:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ASN1_ID||LA23_0==30) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3282:2: rule__ASN1_INTEGER__ValuePairsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6635);
            	    rule__ASN1_INTEGER__ValuePairsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3293:1: rule__ASN1_INTEGER__Group__3 : rule__ASN1_INTEGER__Group__3__Impl ;
    public final void rule__ASN1_INTEGER__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3297:1: ( rule__ASN1_INTEGER__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3298:2: rule__ASN1_INTEGER__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__3__Impl_in_rule__ASN1_INTEGER__Group__36668);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3304:1: rule__ASN1_INTEGER__Group__3__Impl : ( '}' ) ;
    public final void rule__ASN1_INTEGER__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3308:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3309:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3309:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3310:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,24,FOLLOW_24_in_rule__ASN1_INTEGER__Group__3__Impl6696); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3331:1: rule__ASN1_SUBTYPE__Group__0 : rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1 ;
    public final void rule__ASN1_SUBTYPE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3335:1: ( rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3336:2: rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__0__Impl_in_rule__ASN1_SUBTYPE__Group__06735);
            rule__ASN1_SUBTYPE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__1_in_rule__ASN1_SUBTYPE__Group__06738);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3343:1: rule__ASN1_SUBTYPE__Group__0__Impl : ( '(' ) ;
    public final void rule__ASN1_SUBTYPE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3347:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3348:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3348:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3349:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__ASN1_SUBTYPE__Group__0__Impl6766); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3362:1: rule__ASN1_SUBTYPE__Group__1 : rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2 ;
    public final void rule__ASN1_SUBTYPE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3366:1: ( rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3367:2: rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__1__Impl_in_rule__ASN1_SUBTYPE__Group__16797);
            rule__ASN1_SUBTYPE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__2_in_rule__ASN1_SUBTYPE__Group__16800);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3374:1: rule__ASN1_SUBTYPE__Group__1__Impl : ( 'SIZE' ) ;
    public final void rule__ASN1_SUBTYPE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3378:1: ( ( 'SIZE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3379:1: ( 'SIZE' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3379:1: ( 'SIZE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3380:1: 'SIZE'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_1()); 
            }
            match(input,36,FOLLOW_36_in_rule__ASN1_SUBTYPE__Group__1__Impl6828); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3393:1: rule__ASN1_SUBTYPE__Group__2 : rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3 ;
    public final void rule__ASN1_SUBTYPE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3397:1: ( rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3398:2: rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__2__Impl_in_rule__ASN1_SUBTYPE__Group__26859);
            rule__ASN1_SUBTYPE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__3_in_rule__ASN1_SUBTYPE__Group__26862);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3405:1: rule__ASN1_SUBTYPE__Group__2__Impl : ( '(' ) ;
    public final void rule__ASN1_SUBTYPE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3409:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3410:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3410:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3411:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,30,FOLLOW_30_in_rule__ASN1_SUBTYPE__Group__2__Impl6890); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3424:1: rule__ASN1_SUBTYPE__Group__3 : rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4 ;
    public final void rule__ASN1_SUBTYPE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3428:1: ( rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3429:2: rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__3__Impl_in_rule__ASN1_SUBTYPE__Group__36921);
            rule__ASN1_SUBTYPE__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__4_in_rule__ASN1_SUBTYPE__Group__36924);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3436:1: rule__ASN1_SUBTYPE__Group__3__Impl : ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) ) ;
    public final void rule__ASN1_SUBTYPE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3440:1: ( ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3441:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3441:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3442:1: ( rule__ASN1_SUBTYPE__RangesAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3443:1: ( rule__ASN1_SUBTYPE__RangesAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3443:2: rule__ASN1_SUBTYPE__RangesAssignment_3
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_3_in_rule__ASN1_SUBTYPE__Group__3__Impl6951);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3453:1: rule__ASN1_SUBTYPE__Group__4 : rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5 ;
    public final void rule__ASN1_SUBTYPE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3457:1: ( rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3458:2: rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__4__Impl_in_rule__ASN1_SUBTYPE__Group__46981);
            rule__ASN1_SUBTYPE__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__5_in_rule__ASN1_SUBTYPE__Group__46984);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3465:1: rule__ASN1_SUBTYPE__Group__4__Impl : ( ( rule__ASN1_SUBTYPE__Group_4__0 )* ) ;
    public final void rule__ASN1_SUBTYPE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3469:1: ( ( ( rule__ASN1_SUBTYPE__Group_4__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3470:1: ( ( rule__ASN1_SUBTYPE__Group_4__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3470:1: ( ( rule__ASN1_SUBTYPE__Group_4__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3471:1: ( rule__ASN1_SUBTYPE__Group_4__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getGroup_4()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3472:1: ( rule__ASN1_SUBTYPE__Group_4__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==28) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3472:2: rule__ASN1_SUBTYPE__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__0_in_rule__ASN1_SUBTYPE__Group__4__Impl7011);
            	    rule__ASN1_SUBTYPE__Group_4__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3482:1: rule__ASN1_SUBTYPE__Group__5 : rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6 ;
    public final void rule__ASN1_SUBTYPE__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3486:1: ( rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3487:2: rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__5__Impl_in_rule__ASN1_SUBTYPE__Group__57042);
            rule__ASN1_SUBTYPE__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__6_in_rule__ASN1_SUBTYPE__Group__57045);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3494:1: rule__ASN1_SUBTYPE__Group__5__Impl : ( ')' ) ;
    public final void rule__ASN1_SUBTYPE__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3498:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3499:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3499:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3500:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,31,FOLLOW_31_in_rule__ASN1_SUBTYPE__Group__5__Impl7073); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3513:1: rule__ASN1_SUBTYPE__Group__6 : rule__ASN1_SUBTYPE__Group__6__Impl ;
    public final void rule__ASN1_SUBTYPE__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3517:1: ( rule__ASN1_SUBTYPE__Group__6__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3518:2: rule__ASN1_SUBTYPE__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__6__Impl_in_rule__ASN1_SUBTYPE__Group__67104);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3524:1: rule__ASN1_SUBTYPE__Group__6__Impl : ( ')' ) ;
    public final void rule__ASN1_SUBTYPE__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3528:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3529:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3529:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3530:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,31,FOLLOW_31_in_rule__ASN1_SUBTYPE__Group__6__Impl7132); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3557:1: rule__ASN1_SUBTYPE__Group_4__0 : rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1 ;
    public final void rule__ASN1_SUBTYPE__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3561:1: ( rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3562:2: rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__0__Impl_in_rule__ASN1_SUBTYPE__Group_4__07177);
            rule__ASN1_SUBTYPE__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__1_in_rule__ASN1_SUBTYPE__Group_4__07180);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3569:1: rule__ASN1_SUBTYPE__Group_4__0__Impl : ( '|' ) ;
    public final void rule__ASN1_SUBTYPE__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3573:1: ( ( '|' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3574:1: ( '|' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3574:1: ( '|' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3575:1: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getVerticalLineKeyword_4_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__ASN1_SUBTYPE__Group_4__0__Impl7208); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3588:1: rule__ASN1_SUBTYPE__Group_4__1 : rule__ASN1_SUBTYPE__Group_4__1__Impl ;
    public final void rule__ASN1_SUBTYPE__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3592:1: ( rule__ASN1_SUBTYPE__Group_4__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3593:2: rule__ASN1_SUBTYPE__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__1__Impl_in_rule__ASN1_SUBTYPE__Group_4__17239);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3599:1: rule__ASN1_SUBTYPE__Group_4__1__Impl : ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) ) ;
    public final void rule__ASN1_SUBTYPE__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3603:1: ( ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3604:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3604:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3605:1: ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_4_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3606:1: ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3606:2: rule__ASN1_SUBTYPE__RangesAssignment_4_1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_4_1_in_rule__ASN1_SUBTYPE__Group_4__1__Impl7266);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3620:1: rule__ASN1_RANGE__Group_0__0 : rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1 ;
    public final void rule__ASN1_RANGE__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3624:1: ( rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3625:2: rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__0__Impl_in_rule__ASN1_RANGE__Group_0__07300);
            rule__ASN1_RANGE__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__1_in_rule__ASN1_RANGE__Group_0__07303);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3632:1: rule__ASN1_RANGE__Group_0__0__Impl : ( () ) ;
    public final void rule__ASN1_RANGE__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3636:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3637:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3637:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3638:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3639:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3641:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3651:1: rule__ASN1_RANGE__Group_0__1 : rule__ASN1_RANGE__Group_0__1__Impl ;
    public final void rule__ASN1_RANGE__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3655:1: ( rule__ASN1_RANGE__Group_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3656:2: rule__ASN1_RANGE__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__1__Impl_in_rule__ASN1_RANGE__Group_0__17361);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3662:1: rule__ASN1_RANGE__Group_0__1__Impl : ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) ) ;
    public final void rule__ASN1_RANGE__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3666:1: ( ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3667:1: ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3667:1: ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3668:1: ( rule__ASN1_RANGE__ValueAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getValueAssignment_0_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3669:1: ( rule__ASN1_RANGE__ValueAssignment_0_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3669:2: rule__ASN1_RANGE__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__ValueAssignment_0_1_in_rule__ASN1_RANGE__Group_0__1__Impl7388);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3683:1: rule__ASN1_RANGE__Group_1__0 : rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1 ;
    public final void rule__ASN1_RANGE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3687:1: ( rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3688:2: rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__0__Impl_in_rule__ASN1_RANGE__Group_1__07422);
            rule__ASN1_RANGE__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__1_in_rule__ASN1_RANGE__Group_1__07425);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3695:1: rule__ASN1_RANGE__Group_1__0__Impl : ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) ) ;
    public final void rule__ASN1_RANGE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3699:1: ( ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3700:1: ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3700:1: ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3701:1: ( rule__ASN1_RANGE__StartAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getStartAssignment_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3702:1: ( rule__ASN1_RANGE__StartAssignment_1_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3702:2: rule__ASN1_RANGE__StartAssignment_1_0
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__StartAssignment_1_0_in_rule__ASN1_RANGE__Group_1__0__Impl7452);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3712:1: rule__ASN1_RANGE__Group_1__1 : rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2 ;
    public final void rule__ASN1_RANGE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3716:1: ( rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3717:2: rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__1__Impl_in_rule__ASN1_RANGE__Group_1__17482);
            rule__ASN1_RANGE__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__2_in_rule__ASN1_RANGE__Group_1__17485);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3724:1: rule__ASN1_RANGE__Group_1__1__Impl : ( '..' ) ;
    public final void rule__ASN1_RANGE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3728:1: ( ( '..' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3729:1: ( '..' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3729:1: ( '..' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3730:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_1_1()); 
            }
            match(input,37,FOLLOW_37_in_rule__ASN1_RANGE__Group_1__1__Impl7513); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3743:1: rule__ASN1_RANGE__Group_1__2 : rule__ASN1_RANGE__Group_1__2__Impl ;
    public final void rule__ASN1_RANGE__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3747:1: ( rule__ASN1_RANGE__Group_1__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3748:2: rule__ASN1_RANGE__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__2__Impl_in_rule__ASN1_RANGE__Group_1__27544);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3754:1: rule__ASN1_RANGE__Group_1__2__Impl : ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) ) ;
    public final void rule__ASN1_RANGE__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3758:1: ( ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3759:1: ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3759:1: ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3760:1: ( rule__ASN1_RANGE__EndAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getEndAssignment_1_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3761:1: ( rule__ASN1_RANGE__EndAssignment_1_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3761:2: rule__ASN1_RANGE__EndAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__EndAssignment_1_2_in_rule__ASN1_RANGE__Group_1__2__Impl7571);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3777:1: rule__ASN1_VALUEPAIR__Group__0 : rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1 ;
    public final void rule__ASN1_VALUEPAIR__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3781:1: ( rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3782:2: rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__0__Impl_in_rule__ASN1_VALUEPAIR__Group__07607);
            rule__ASN1_VALUEPAIR__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__1_in_rule__ASN1_VALUEPAIR__Group__07610);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3789:1: rule__ASN1_VALUEPAIR__Group__0__Impl : ( ( RULE_ASN1_ID )? ) ;
    public final void rule__ASN1_VALUEPAIR__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3793:1: ( ( ( RULE_ASN1_ID )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3794:1: ( ( RULE_ASN1_ID )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3794:1: ( ( RULE_ASN1_ID )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3795:1: ( RULE_ASN1_ID )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getASN1_IDTerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3796:1: ( RULE_ASN1_ID )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ASN1_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3796:3: RULE_ASN1_ID
                    {
                    match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ASN1_VALUEPAIR__Group__0__Impl7638); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_VALUEPAIRAccess().getASN1_IDTerminalRuleCall_0()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3806:1: rule__ASN1_VALUEPAIR__Group__1 : rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2 ;
    public final void rule__ASN1_VALUEPAIR__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3810:1: ( rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3811:2: rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__1__Impl_in_rule__ASN1_VALUEPAIR__Group__17669);
            rule__ASN1_VALUEPAIR__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__2_in_rule__ASN1_VALUEPAIR__Group__17672);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3818:1: rule__ASN1_VALUEPAIR__Group__1__Impl : ( '(' ) ;
    public final void rule__ASN1_VALUEPAIR__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3822:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3823:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3823:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3824:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,30,FOLLOW_30_in_rule__ASN1_VALUEPAIR__Group__1__Impl7700); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3837:1: rule__ASN1_VALUEPAIR__Group__2 : rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3 ;
    public final void rule__ASN1_VALUEPAIR__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3841:1: ( rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3842:2: rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__2__Impl_in_rule__ASN1_VALUEPAIR__Group__27731);
            rule__ASN1_VALUEPAIR__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__3_in_rule__ASN1_VALUEPAIR__Group__27734);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3849:1: rule__ASN1_VALUEPAIR__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__ASN1_VALUEPAIR__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3853:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3854:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3854:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3855:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getINTTerminalRuleCall_2()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_VALUEPAIR__Group__2__Impl7761); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3866:1: rule__ASN1_VALUEPAIR__Group__3 : rule__ASN1_VALUEPAIR__Group__3__Impl ;
    public final void rule__ASN1_VALUEPAIR__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3870:1: ( rule__ASN1_VALUEPAIR__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3871:2: rule__ASN1_VALUEPAIR__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__3__Impl_in_rule__ASN1_VALUEPAIR__Group__37790);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3877:1: rule__ASN1_VALUEPAIR__Group__3__Impl : ( ')' ) ;
    public final void rule__ASN1_VALUEPAIR__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3881:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3882:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3882:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3883:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,31,FOLLOW_31_in_rule__ASN1_VALUEPAIR__Group__3__Impl7818); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3904:1: rule__ASN1_CHOICE__Group__0 : rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1 ;
    public final void rule__ASN1_CHOICE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3908:1: ( rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3909:2: rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__0__Impl_in_rule__ASN1_CHOICE__Group__07857);
            rule__ASN1_CHOICE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__1_in_rule__ASN1_CHOICE__Group__07860);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3916:1: rule__ASN1_CHOICE__Group__0__Impl : ( 'CHOICE' ) ;
    public final void rule__ASN1_CHOICE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3920:1: ( ( 'CHOICE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3921:1: ( 'CHOICE' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3921:1: ( 'CHOICE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3922:1: 'CHOICE'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0()); 
            }
            match(input,38,FOLLOW_38_in_rule__ASN1_CHOICE__Group__0__Impl7888); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3935:1: rule__ASN1_CHOICE__Group__1 : rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2 ;
    public final void rule__ASN1_CHOICE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3939:1: ( rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3940:2: rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__1__Impl_in_rule__ASN1_CHOICE__Group__17919);
            rule__ASN1_CHOICE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__2_in_rule__ASN1_CHOICE__Group__17922);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3947:1: rule__ASN1_CHOICE__Group__1__Impl : ( '{' ) ;
    public final void rule__ASN1_CHOICE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3951:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3952:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3952:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3953:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,23,FOLLOW_23_in_rule__ASN1_CHOICE__Group__1__Impl7950); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3966:1: rule__ASN1_CHOICE__Group__2 : rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3 ;
    public final void rule__ASN1_CHOICE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3970:1: ( rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3971:2: rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__2__Impl_in_rule__ASN1_CHOICE__Group__27981);
            rule__ASN1_CHOICE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__3_in_rule__ASN1_CHOICE__Group__27984);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3978:1: rule__ASN1_CHOICE__Group__2__Impl : ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) ) ;
    public final void rule__ASN1_CHOICE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3982:1: ( ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3983:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3983:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3984:1: ( rule__ASN1_CHOICE__ChoicesAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3985:1: ( rule__ASN1_CHOICE__ChoicesAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3985:2: rule__ASN1_CHOICE__ChoicesAssignment_2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_2_in_rule__ASN1_CHOICE__Group__2__Impl8011);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3995:1: rule__ASN1_CHOICE__Group__3 : rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4 ;
    public final void rule__ASN1_CHOICE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3999:1: ( rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4000:2: rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__3__Impl_in_rule__ASN1_CHOICE__Group__38041);
            rule__ASN1_CHOICE__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__4_in_rule__ASN1_CHOICE__Group__38044);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4007:1: rule__ASN1_CHOICE__Group__3__Impl : ( ( rule__ASN1_CHOICE__Group_3__0 )* ) ;
    public final void rule__ASN1_CHOICE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4011:1: ( ( ( rule__ASN1_CHOICE__Group_3__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4012:1: ( ( rule__ASN1_CHOICE__Group_3__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4012:1: ( ( rule__ASN1_CHOICE__Group_3__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4013:1: ( rule__ASN1_CHOICE__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getGroup_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4014:1: ( rule__ASN1_CHOICE__Group_3__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==39) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4014:2: rule__ASN1_CHOICE__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__0_in_rule__ASN1_CHOICE__Group__3__Impl8071);
            	    rule__ASN1_CHOICE__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4024:1: rule__ASN1_CHOICE__Group__4 : rule__ASN1_CHOICE__Group__4__Impl ;
    public final void rule__ASN1_CHOICE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4028:1: ( rule__ASN1_CHOICE__Group__4__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4029:2: rule__ASN1_CHOICE__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__4__Impl_in_rule__ASN1_CHOICE__Group__48102);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4035:1: rule__ASN1_CHOICE__Group__4__Impl : ( '}' ) ;
    public final void rule__ASN1_CHOICE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4039:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4040:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4040:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4041:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,24,FOLLOW_24_in_rule__ASN1_CHOICE__Group__4__Impl8130); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4064:1: rule__ASN1_CHOICE__Group_3__0 : rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1 ;
    public final void rule__ASN1_CHOICE__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4068:1: ( rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4069:2: rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__0__Impl_in_rule__ASN1_CHOICE__Group_3__08171);
            rule__ASN1_CHOICE__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__1_in_rule__ASN1_CHOICE__Group_3__08174);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4076:1: rule__ASN1_CHOICE__Group_3__0__Impl : ( ',' ) ;
    public final void rule__ASN1_CHOICE__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4080:1: ( ( ',' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4081:1: ( ',' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4081:1: ( ',' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4082:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_3_0()); 
            }
            match(input,39,FOLLOW_39_in_rule__ASN1_CHOICE__Group_3__0__Impl8202); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4095:1: rule__ASN1_CHOICE__Group_3__1 : rule__ASN1_CHOICE__Group_3__1__Impl ;
    public final void rule__ASN1_CHOICE__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4099:1: ( rule__ASN1_CHOICE__Group_3__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4100:2: rule__ASN1_CHOICE__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__1__Impl_in_rule__ASN1_CHOICE__Group_3__18233);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4106:1: rule__ASN1_CHOICE__Group_3__1__Impl : ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) ) ;
    public final void rule__ASN1_CHOICE__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4110:1: ( ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4111:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4111:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4112:1: ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_3_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4113:1: ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4113:2: rule__ASN1_CHOICE__ChoicesAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_3_1_in_rule__ASN1_CHOICE__Group_3__1__Impl8260);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4127:1: rule__ASN1_CHOICE_ENTRY__Group__0 : rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1 ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4131:1: ( rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4132:2: rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__08294);
            rule__ASN1_CHOICE_ENTRY__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1_in_rule__ASN1_CHOICE_ENTRY__Group__08297);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4139:1: rule__ASN1_CHOICE_ENTRY__Group__0__Impl : ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4143:1: ( ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4144:1: ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4144:1: ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4145:1: ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4146:1: ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4146:2: rule__ASN1_CHOICE_ENTRY__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__IdAssignment_0_in_rule__ASN1_CHOICE_ENTRY__Group__0__Impl8324);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4156:1: rule__ASN1_CHOICE_ENTRY__Group__1 : rule__ASN1_CHOICE_ENTRY__Group__1__Impl ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4160:1: ( rule__ASN1_CHOICE_ENTRY__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4161:2: rule__ASN1_CHOICE_ENTRY__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__18354);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4167:1: rule__ASN1_CHOICE_ENTRY__Group__1__Impl : ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4171:1: ( ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4172:1: ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4172:1: ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4173:1: ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4174:1: ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4174:2: rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1_in_rule__ASN1_CHOICE_ENTRY__Group__1__Impl8381);
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


    // $ANTLR start "rule__Module__NameAssignment_0_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4189:1: rule__Module__NameAssignment_0_0 : ( RULE_MODULE_ID ) ;
    public final void rule__Module__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4193:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4194:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4194:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4195:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNameMODULE_IDTerminalRuleCall_0_0_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__Module__NameAssignment_0_08420); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getNameMODULE_IDTerminalRuleCall_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__NameAssignment_0_0"


    // $ANTLR start "rule__Module__IdentifiersAssignment_0_5_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4204:1: rule__Module__IdentifiersAssignment_0_5_0 : ( ruleObjectIdentifier ) ;
    public final void rule__Module__IdentifiersAssignment_0_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4208:1: ( ( ruleObjectIdentifier ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4209:1: ( ruleObjectIdentifier )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4209:1: ( ruleObjectIdentifier )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4210:1: ruleObjectIdentifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getIdentifiersObjectIdentifierParserRuleCall_0_5_0_0()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifier_in_rule__Module__IdentifiersAssignment_0_5_08451);
            ruleObjectIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getIdentifiersObjectIdentifierParserRuleCall_0_5_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__IdentifiersAssignment_0_5_0"


    // $ANTLR start "rule__Module__TypesAssignment_0_5_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4219:1: rule__Module__TypesAssignment_0_5_1 : ( ruleTypeDefinition ) ;
    public final void rule__Module__TypesAssignment_0_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4223:1: ( ( ruleTypeDefinition ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4224:1: ( ruleTypeDefinition )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4224:1: ( ruleTypeDefinition )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4225:1: ruleTypeDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getTypesTypeDefinitionParserRuleCall_0_5_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_rule__Module__TypesAssignment_0_5_18482);
            ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getTypesTypeDefinitionParserRuleCall_0_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__TypesAssignment_0_5_1"


    // $ANTLR start "rule__Module__MacrosAssignment_0_5_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4234:1: rule__Module__MacrosAssignment_0_5_2 : ( ruleMacro ) ;
    public final void rule__Module__MacrosAssignment_0_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4238:1: ( ( ruleMacro ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4239:1: ( ruleMacro )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4239:1: ( ruleMacro )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4240:1: ruleMacro
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getMacrosMacroParserRuleCall_0_5_2_0()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_rule__Module__MacrosAssignment_0_5_28513);
            ruleMacro();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getMacrosMacroParserRuleCall_0_5_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__MacrosAssignment_0_5_2"


    // $ANTLR start "rule__ObjectIdentifier__NameAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4249:1: rule__ObjectIdentifier__NameAssignment_1 : ( RULE_ASN1_ID ) ;
    public final void rule__ObjectIdentifier__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4253:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4254:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4254:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4255:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNameASN1_IDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifier__NameAssignment_18544); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4264:1: rule__ObjectIdentifier__OidValueAssignment_5 : ( ruleObjectIdentifierValue ) ;
    public final void rule__ObjectIdentifier__OidValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4268:1: ( ( ruleObjectIdentifierValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4269:1: ( ruleObjectIdentifierValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4269:1: ( ruleObjectIdentifierValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4270:1: ruleObjectIdentifierValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_rule__ObjectIdentifier__OidValueAssignment_58575);
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


    // $ANTLR start "rule__ObjectIdentifierValue__RootAssignment_0_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4279:1: rule__ObjectIdentifierValue__RootAssignment_0_0 : ( RULE_ASN1_ID ) ;
    public final void rule__ObjectIdentifierValue__RootAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4283:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4284:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4284:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4285:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getRootASN1_IDTerminalRuleCall_0_0_0()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__RootAssignment_0_08606); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierValueAccess().getRootASN1_IDTerminalRuleCall_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectIdentifierValue__RootAssignment_0_0"


    // $ANTLR start "rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4294:1: rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 : ( ( RULE_ASN1_ID ) ) ;
    public final void rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4298:1: ( ( ( RULE_ASN1_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4299:1: ( ( RULE_ASN1_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4299:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4300:1: ( RULE_ASN1_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4301:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4302:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierASN1_IDTerminalRuleCall_0_1_0_1()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_18641); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4313:1: rule__ObjectIdentifierValue__SubIdsAssignment_1 : ( RULE_INT ) ;
    public final void rule__ObjectIdentifierValue__SubIdsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4317:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4318:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4318:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4319:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_18676); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4328:1: rule__ObjectIdentifierValue__SubIdsAssignment_2 : ( RULE_INT ) ;
    public final void rule__ObjectIdentifierValue__SubIdsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4332:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4333:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4333:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4334:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_28707); if (state.failed) return ;
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


    // $ANTLR start "rule__TypeDefinition__NameAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4343:1: rule__TypeDefinition__NameAssignment_1 : ( RULE_MODULE_ID ) ;
    public final void rule__TypeDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4347:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4348:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4348:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4349:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNameMODULE_IDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__TypeDefinition__NameAssignment_18738); if (state.failed) return ;
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


    // $ANTLR start "rule__TypeDefinition__ScopeAssignment_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4358:1: rule__TypeDefinition__ScopeAssignment_3 : ( ruleScope ) ;
    public final void rule__TypeDefinition__ScopeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4362:1: ( ( ruleScope ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4363:1: ( ruleScope )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4363:1: ( ruleScope )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4364:1: ruleScope
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getScopeScopeParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleScope_in_rule__TypeDefinition__ScopeAssignment_38769);
            ruleScope();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getScopeScopeParserRuleCall_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeDefinition__ScopeAssignment_3"


    // $ANTLR start "rule__Macro__NameAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4373:1: rule__Macro__NameAssignment_1 : ( RULE_MODULE_ID ) ;
    public final void rule__Macro__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4377:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4378:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4378:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4379:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNameMODULE_IDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__Macro__NameAssignment_18800); if (state.failed) return ;
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


    // $ANTLR start "rule__Macro__TypeNotationsAssignment_9"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4388:1: rule__Macro__TypeNotationsAssignment_9 : ( ruleTypeAssignment ) ;
    public final void rule__Macro__TypeNotationsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4392:1: ( ( ruleTypeAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4393:1: ( ruleTypeAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4393:1: ( ruleTypeAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4394:1: ruleTypeAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTypeNotationsTypeAssignmentParserRuleCall_9_0()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_rule__Macro__TypeNotationsAssignment_98831);
            ruleTypeAssignment();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getTypeNotationsTypeAssignmentParserRuleCall_9_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__TypeNotationsAssignment_9"


    // $ANTLR start "rule__Macro__ValueNotationAssignment_13"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4403:1: rule__Macro__ValueNotationAssignment_13 : ( ruleMacroValue ) ;
    public final void rule__Macro__ValueNotationAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4407:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4408:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4408:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4409:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_13_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__Macro__ValueNotationAssignment_138862);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_13_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__ValueNotationAssignment_13"


    // $ANTLR start "rule__Macro__InnerTypesAssignment_14"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4418:1: rule__Macro__InnerTypesAssignment_14 : ( ruleTypeDefinition ) ;
    public final void rule__Macro__InnerTypesAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4422:1: ( ( ruleTypeDefinition ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4423:1: ( ruleTypeDefinition )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4423:1: ( ruleTypeDefinition )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4424:1: ruleTypeDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_14_0()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_rule__Macro__InnerTypesAssignment_148893);
            ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_14_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__InnerTypesAssignment_14"


    // $ANTLR start "rule__ParamAssignment__ParamAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4433:1: rule__ParamAssignment__ParamAssignment_0 : ( RULE_PARAMETER ) ;
    public final void rule__ParamAssignment__ParamAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4437:1: ( ( RULE_PARAMETER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4438:1: ( RULE_PARAMETER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4438:1: ( RULE_PARAMETER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4439:1: RULE_PARAMETER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getParamPARAMETERTerminalRuleCall_0_0()); 
            }
            match(input,RULE_PARAMETER,FOLLOW_RULE_PARAMETER_in_rule__ParamAssignment__ParamAssignment_08924); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4448:1: rule__ParamAssignment__RightAssignment_1 : ( ruleTypeNotation ) ;
    public final void rule__ParamAssignment__RightAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4452:1: ( ( ruleTypeNotation ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4453:1: ( ruleTypeNotation )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4453:1: ( ruleTypeNotation )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4454:1: ruleTypeNotation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getRightTypeNotationParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_rule__ParamAssignment__RightAssignment_18955);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4463:1: rule__TypeNotation__ValueAssignment_1 : ( ruleMacroValue ) ;
    public final void rule__TypeNotation__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4467:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4468:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4468:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4469:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getValueMacroValueParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__TypeNotation__ValueAssignment_18986);
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


    // $ANTLR start "rule__TypeReferenceExt__ParentRefAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4478:1: rule__TypeReferenceExt__ParentRefAssignment_0 : ( ruleTypeReference ) ;
    public final void rule__TypeReferenceExt__ParentRefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4482:1: ( ( ruleTypeReference ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4483:1: ( ruleTypeReference )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4483:1: ( ruleTypeReference )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4484:1: ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getParentRefTypeReferenceParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ParentRefAssignment_09017);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4493:1: rule__TypeReferenceExt__ChildRefAssignment_1 : ( ruleTypeReference ) ;
    public final void rule__TypeReferenceExt__ChildRefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4497:1: ( ( ruleTypeReference ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4498:1: ( ruleTypeReference )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4498:1: ( ruleTypeReference )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4499:1: ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getChildRefTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ChildRefAssignment_19048);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4508:1: rule__TypeReference__TypeAssignment : ( ( RULE_MODULE_ID ) ) ;
    public final void rule__TypeReference__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4512:1: ( ( ( RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4513:1: ( ( RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4513:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4514:1: ( RULE_MODULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceAccess().getTypeTypeDefinitionCrossReference_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4515:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4516:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceAccess().getTypeTypeDefinitionMODULE_IDTerminalRuleCall_0_1()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__TypeReference__TypeAssignment9083); if (state.failed) return ;
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


    // $ANTLR start "rule__Scope__ValuesAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4527:1: rule__Scope__ValuesAssignment_0 : ( ruleValue ) ;
    public final void rule__Scope__ValuesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4531:1: ( ( ruleValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4532:1: ( ruleValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4532:1: ( ruleValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4533:1: ruleValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getScopeAccess().getValuesValueParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleValue_in_rule__Scope__ValuesAssignment_09118);
            ruleValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getScopeAccess().getValuesValueParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Scope__ValuesAssignment_0"


    // $ANTLR start "rule__Value__ValueTypesAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4542:1: rule__Value__ValueTypesAssignment_0 : ( ruleValueType ) ;
    public final void rule__Value__ValueTypesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4546:1: ( ( ruleValueType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4547:1: ( ruleValueType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4547:1: ( ruleValueType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4548:1: ruleValueType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_09149);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4557:1: rule__Value__ValueTypesAssignment_1_1 : ( ruleValueType ) ;
    public final void rule__Value__ValueTypesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4561:1: ( ( ruleValueType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4562:1: ( ruleValueType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4562:1: ( ruleValueType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4563:1: ruleValueType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_1_19180);
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


    // $ANTLR start "rule__ValueType__ParamAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4572:1: rule__ValueType__ParamAssignment_0 : ( ruleParamAssignment ) ;
    public final void rule__ValueType__ParamAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4576:1: ( ( ruleParamAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4577:1: ( ruleParamAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4577:1: ( ruleParamAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4578:1: ruleParamAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_rule__ValueType__ParamAssignment_09211);
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


    // $ANTLR start "rule__ValueType__TypeAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4587:1: rule__ValueType__TypeAssignment_1 : ( ruleTypeReferenceExt ) ;
    public final void rule__ValueType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4591:1: ( ( ruleTypeReferenceExt ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4592:1: ( ruleTypeReferenceExt )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4592:1: ( ruleTypeReferenceExt )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4593:1: ruleTypeReferenceExt
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypeTypeReferenceExtParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_rule__ValueType__TypeAssignment_19242);
            ruleTypeReferenceExt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeAccess().getTypeTypeReferenceExtParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueType__TypeAssignment_1"


    // $ANTLR start "rule__ValueType__SimpleTypeAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4602:1: rule__ValueType__SimpleTypeAssignment_2 : ( ruleASN1_TYPE ) ;
    public final void rule__ValueType__SimpleTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4606:1: ( ( ruleASN1_TYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4607:1: ( ruleASN1_TYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4607:1: ( ruleASN1_TYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4608:1: ruleASN1_TYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_rule__ValueType__SimpleTypeAssignment_29273);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4617:1: rule__ValueType__MacroValueAssignment_3 : ( ruleMacroValue ) ;
    public final void rule__ValueType__MacroValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4621:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4622:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4622:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4623:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__ValueType__MacroValueAssignment_39304);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4632:1: rule__ValueType__OiAssignment_4 : ( ( 'OBJECT IDENTIFIER' ) ) ;
    public final void rule__ValueType__OiAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4636:1: ( ( ( 'OBJECT IDENTIFIER' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4637:1: ( ( 'OBJECT IDENTIFIER' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4637:1: ( ( 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4638:1: ( 'OBJECT IDENTIFIER' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_4_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4639:1: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4640:1: 'OBJECT IDENTIFIER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_4_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__ValueType__OiAssignment_49340); if (state.failed) return ;
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


    // $ANTLR start "rule__MacroValue__TypeAssignment_3"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4655:1: rule__MacroValue__TypeAssignment_3 : ( ruleMACRO_VALUE_TYPE ) ;
    public final void rule__MacroValue__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4659:1: ( ( ruleMACRO_VALUE_TYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4660:1: ( ruleMACRO_VALUE_TYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4660:1: ( ruleMACRO_VALUE_TYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4661:1: ruleMACRO_VALUE_TYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getTypeMACRO_VALUE_TYPEParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_rule__MacroValue__TypeAssignment_39379);
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


    // $ANTLR start "rule__MACRO_VALUE_TYPE__UpdateAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4670:1: rule__MACRO_VALUE_TYPE__UpdateAssignment_0 : ( ruleUpdateType ) ;
    public final void rule__MACRO_VALUE_TYPE__UpdateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4674:1: ( ( ruleUpdateType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4675:1: ( ruleUpdateType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4675:1: ( ruleUpdateType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4676:1: ruleUpdateType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateUpdateTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_rule__MACRO_VALUE_TYPE__UpdateAssignment_09410);
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


    // $ANTLR start "rule__MACRO_VALUE_TYPE__LiteralAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4685:1: rule__MACRO_VALUE_TYPE__LiteralAssignment_1 : ( ruleMACRO_VALUE_CAP ) ;
    public final void rule__MACRO_VALUE_TYPE__LiteralAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4689:1: ( ( ruleMACRO_VALUE_CAP ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4690:1: ( ruleMACRO_VALUE_CAP )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4690:1: ( ruleMACRO_VALUE_CAP )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4691:1: ruleMACRO_VALUE_CAP
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralMACRO_VALUE_CAPParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_rule__MACRO_VALUE_TYPE__LiteralAssignment_19441);
            ruleMACRO_VALUE_CAP();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralMACRO_VALUE_CAPParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MACRO_VALUE_TYPE__LiteralAssignment_1"


    // $ANTLR start "rule__UpdateType__TypeAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4700:1: rule__UpdateType__TypeAssignment_1 : ( ( RULE_MODULE_ID ) ) ;
    public final void rule__UpdateType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4704:1: ( ( ( RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4705:1: ( ( RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4705:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4706:1: ( RULE_MODULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getTypeTypeDefinitionCrossReference_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4707:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4708:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getTypeTypeDefinitionMODULE_IDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__UpdateType__TypeAssignment_19476); if (state.failed) return ;
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


    // $ANTLR start "rule__ASN1_SIMPLE__ConstraintAssignment_2_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4719:1: rule__ASN1_SIMPLE__ConstraintAssignment_2_1 : ( ruleASN1_SUBTYPE ) ;
    public final void rule__ASN1_SIMPLE__ConstraintAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4723:1: ( ( ruleASN1_SUBTYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4724:1: ( ruleASN1_SUBTYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4724:1: ( ruleASN1_SUBTYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4725:1: ruleASN1_SUBTYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_rule__ASN1_SIMPLE__ConstraintAssignment_2_19511);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4734:1: rule__ASN1_SIMPLE__ConstraintAssignment_3_1 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SIMPLE__ConstraintAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4738:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4739:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4739:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4740:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_RANGEParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SIMPLE__ConstraintAssignment_3_19542);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4749:1: rule__ASN1_INTEGER__ValuePairsAssignment_2 : ( ruleASN1_VALUEPAIR ) ;
    public final void rule__ASN1_INTEGER__ValuePairsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4753:1: ( ( ruleASN1_VALUEPAIR ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4754:1: ( ruleASN1_VALUEPAIR )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4754:1: ( ruleASN1_VALUEPAIR )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4755:1: ruleASN1_VALUEPAIR
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getValuePairsASN1_VALUEPAIRParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_rule__ASN1_INTEGER__ValuePairsAssignment_29573);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4764:1: rule__ASN1_SUBTYPE__RangesAssignment_3 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SUBTYPE__RangesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4768:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4769:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4769:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4770:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_39604);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4779:1: rule__ASN1_SUBTYPE__RangesAssignment_4_1 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SUBTYPE__RangesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4783:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4784:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4784:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4785:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_4_19635);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4794:1: rule__ASN1_RANGE__ValueAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__ASN1_RANGE__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4798:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4799:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4799:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4800:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getValueINTTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_RANGE__ValueAssignment_0_19666); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4809:1: rule__ASN1_RANGE__StartAssignment_1_0 : ( RULE_INT ) ;
    public final void rule__ASN1_RANGE__StartAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4813:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4814:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4814:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4815:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getStartINTTerminalRuleCall_1_0_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_RANGE__StartAssignment_1_09697); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4824:1: rule__ASN1_RANGE__EndAssignment_1_2 : ( RULE_INT ) ;
    public final void rule__ASN1_RANGE__EndAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4828:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4829:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4829:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4830:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getEndINTTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_RANGE__EndAssignment_1_29728); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4839:1: rule__ASN1_CHOICE__ChoicesAssignment_2 : ( ruleASN1_CHOICE_ENTRY ) ;
    public final void rule__ASN1_CHOICE__ChoicesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4843:1: ( ( ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4844:1: ( ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4844:1: ( ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4845:1: ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_29759);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4854:1: rule__ASN1_CHOICE__ChoicesAssignment_3_1 : ( ruleASN1_CHOICE_ENTRY ) ;
    public final void rule__ASN1_CHOICE__ChoicesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4858:1: ( ( ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4859:1: ( ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4859:1: ( ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4860:1: ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_3_19790);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4869:1: rule__ASN1_CHOICE_ENTRY__IdAssignment_0 : ( RULE_ASN1_ID ) ;
    public final void rule__ASN1_CHOICE_ENTRY__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4873:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4874:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4874:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4875:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdASN1_IDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__IdAssignment_09821); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4884:1: rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 : ( ( RULE_ASN1_ID ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4888:1: ( ( ( RULE_ASN1_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4889:1: ( ( RULE_ASN1_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4889:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4890:1: ( RULE_ASN1_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueCrossReference_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4891:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4892:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueASN1_IDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_19856); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueASN1_IDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueCrossReference_1_0()); 
            }

            }


            }

        }
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

    // $ANTLR start synpred4_InternalSmi
    public final void synpred4_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:852:1: ( ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) ) )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:852:1: ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) )
        {
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:852:1: ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:853:1: ( rule__ObjectIdentifierValue__RootAssignment_0_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectIdentifierValueAccess().getRootAssignment_0_0()); 
        }
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:854:1: ( rule__ObjectIdentifierValue__RootAssignment_0_0 )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:854:2: rule__ObjectIdentifierValue__RootAssignment_0_0
        {
        pushFollow(FOLLOW_rule__ObjectIdentifierValue__RootAssignment_0_0_in_synpred4_InternalSmi1765);
        rule__ObjectIdentifierValue__RootAssignment_0_0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred4_InternalSmi

    // $ANTLR start synpred24_InternalSmi
    public final void synpred24_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2449:2: ( rule__TypeReferenceExt__ChildRefAssignment_1 )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2449:2: rule__TypeReferenceExt__ChildRefAssignment_1
        {
        pushFollow(FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_synpred24_InternalSmi5002);
        rule__TypeReferenceExt__ChildRefAssignment_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalSmi

    // Delegated rules

    public final boolean synpred24_InternalSmi() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalSmi_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalSmi() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalSmi_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Alternatives_in_ruleModule100 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAssignment383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Alternatives_in_ruleTypeAssignment409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_entryRuleParamAssignment436 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParamAssignment443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__0_in_ruleParamAssignment469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_entryRuleTypeNotation496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNotation503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotation__Alternatives_in_ruleTypeNotation529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_entryRuleTypeReferenceExt556 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReferenceExt563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__0_in_ruleTypeReferenceExt589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_entryRuleTypeReference616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeReference623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReference__TypeAssignment_in_ruleTypeReference649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScope_in_entryRuleScope676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleScope683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scope__Group__0_in_ruleScope709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue736 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__0_in_ruleValue769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType796 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Alternatives_in_ruleValueType829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__0_in_ruleMacroValue889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE916 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__Alternatives_in_ruleMACRO_VALUE_TYPE949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_entryRuleUpdateType976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpdateType983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__0_in_ruleUpdateType1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP1036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__Alternatives_in_ruleMACRO_VALUE_CAP1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE1096 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_TYPE__Alternatives_in_ruleASN1_TYPE1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE1156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Alternatives_in_ruleASN1_SIMPLE1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING1216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__0_in_ruleASN1_OCTET_STRING1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER1276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__0_in_ruleASN1_INTEGER1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE1336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__0_in_ruleASN1_SUBTYPE1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE1396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Alternatives_in_ruleASN1_RANGE1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR1456 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR1463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__0_in_ruleASN1_VALUEPAIR1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE1516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE1523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__0_in_ruleASN1_CHOICE1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY1576 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY1583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0_in_ruleASN1_CHOICE_ENTRY1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_0__0_in_rule__Module__Alternatives1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_1__0_in_rule__Module__Alternatives1663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__IdentifiersAssignment_0_5_0_in_rule__Module__Alternatives_0_51696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__TypesAssignment_0_5_1_in_rule__Module__Alternatives_0_51714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__MacrosAssignment_0_5_2_in_rule__Module__Alternatives_0_51732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__RootAssignment_0_0_in_rule__ObjectIdentifierValue__Alternatives_01765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1_in_rule__ObjectIdentifierValue__Alternatives_01783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_rule__TypeAssignment__Alternatives1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeAssignment__Alternatives1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeNotation__Alternatives1865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotation__ValueAssignment_1_in_rule__TypeNotation__Alternatives1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__ParamAssignment_0_in_rule__ValueType__Alternatives1915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__TypeAssignment_1_in_rule__ValueType__Alternatives1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__SimpleTypeAssignment_2_in_rule__ValueType__Alternatives1951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__MacroValueAssignment_3_in_rule__ValueType__Alternatives1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__OiAssignment_4_in_rule__ValueType__Alternatives1987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__UpdateAssignment_0_in_rule__MACRO_VALUE_TYPE__Alternatives2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__LiteralAssignment_1_in_rule__MACRO_VALUE_TYPE__Alternatives2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__MACRO_VALUE_CAP__Alternatives2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__MACRO_VALUE_CAP__Alternatives2092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_rule__ASN1_TYPE__Alternatives2126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_rule__ASN1_TYPE__Alternatives2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__0_in_rule__ASN1_SIMPLE__Alternatives2175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__0_in_rule__ASN1_SIMPLE__Alternatives2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__0_in_rule__ASN1_SIMPLE__Alternatives2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__0_in_rule__ASN1_SIMPLE__Alternatives2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__0_in_rule__ASN1_RANGE__Alternatives2262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__0_in_rule__ASN1_RANGE__Alternatives2280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_0__0__Impl_in_rule__Module__Group_0__02311 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Module__Group_0__1_in_rule__Module__Group_0__02314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__NameAssignment_0_0_in_rule__Module__Group_0__0__Impl2341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_0__1__Impl_in_rule__Module__Group_0__12371 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Module__Group_0__2_in_rule__Module__Group_0__12374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Module__Group_0__1__Impl2402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_0__2__Impl_in_rule__Module__Group_0__22433 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Module__Group_0__3_in_rule__Module__Group_0__22436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Module__Group_0__2__Impl2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_0__3__Impl_in_rule__Module__Group_0__32495 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Module__Group_0__4_in_rule__Module__Group_0__32498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Module__Group_0__3__Impl2526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_0__4__Impl_in_rule__Module__Group_0__42557 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Module__Group_0__5_in_rule__Module__Group_0__42560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_rule__Module__Group_0__4__Impl2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_0__5__Impl_in_rule__Module__Group_0__52616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Alternatives_0_5_in_rule__Module__Group_0__5__Impl2645 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Module__Alternatives_0_5_in_rule__Module__Group_0__5__Impl2657 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Module__Group_1__0__Impl_in_rule__Module__Group_1__02702 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_rule__Module__Group_1__1_in_rule__Module__Group_1__02705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_1__1__Impl_in_rule__Module__Group_1__12763 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_rule__Module__Group_1__2_in_rule__Module__Group_1__12766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_rule__Module__Group_1__1__Impl2794 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Module__Group_1__2__Impl_in_rule__Module__Group_1__22825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Module__Group_1__2__Impl2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__0__Impl_in_rule__ObjectIdentifier__Group__02890 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__1_in_rule__ObjectIdentifier__Group__02893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_rule__ObjectIdentifier__Group__0__Impl2920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__1__Impl_in_rule__ObjectIdentifier__Group__12949 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__2_in_rule__ObjectIdentifier__Group__12952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__NameAssignment_1_in_rule__ObjectIdentifier__Group__1__Impl2979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__2__Impl_in_rule__ObjectIdentifier__Group__23009 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__3_in_rule__ObjectIdentifier__Group__23012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ObjectIdentifier__Group__2__Impl3040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__3__Impl_in_rule__ObjectIdentifier__Group__33071 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__4_in_rule__ObjectIdentifier__Group__33074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ObjectIdentifier__Group__3__Impl3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__4__Impl_in_rule__ObjectIdentifier__Group__43133 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__5_in_rule__ObjectIdentifier__Group__43136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ObjectIdentifier__Group__4__Impl3164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__5__Impl_in_rule__ObjectIdentifier__Group__53195 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__6_in_rule__ObjectIdentifier__Group__53198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__OidValueAssignment_5_in_rule__ObjectIdentifier__Group__5__Impl3225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__6__Impl_in_rule__ObjectIdentifier__Group__63255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ObjectIdentifier__Group__6__Impl3283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__0__Impl_in_rule__ObjectIdentifierValue__Group__03328 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__1_in_rule__ObjectIdentifierValue__Group__03331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Alternatives_0_in_rule__ObjectIdentifierValue__Group__0__Impl3358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__1__Impl_in_rule__ObjectIdentifierValue__Group__13389 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__2_in_rule__ObjectIdentifierValue__Group__13392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_1_in_rule__ObjectIdentifierValue__Group__1__Impl3419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__2__Impl_in_rule__ObjectIdentifierValue__Group__23449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_2_in_rule__ObjectIdentifierValue__Group__2__Impl3476 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__0__Impl_in_rule__TypeDefinition__Group__03513 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__1_in_rule__TypeDefinition__Group__03516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_rule__TypeDefinition__Group__0__Impl3543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__1__Impl_in_rule__TypeDefinition__Group__13572 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__2_in_rule__TypeDefinition__Group__13575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__NameAssignment_1_in_rule__TypeDefinition__Group__1__Impl3602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__2__Impl_in_rule__TypeDefinition__Group__23632 = new BitSet(new long[]{0x0000004E20400320L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__3_in_rule__TypeDefinition__Group__23635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__TypeDefinition__Group__2__Impl3663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__3__Impl_in_rule__TypeDefinition__Group__33694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__ScopeAssignment_3_in_rule__TypeDefinition__Group__3__Impl3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__0__Impl_in_rule__Macro__Group__03759 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Macro__Group__1_in_rule__Macro__Group__03762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_rule__Macro__Group__0__Impl3789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__1__Impl_in_rule__Macro__Group__13818 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__2_in_rule__Macro__Group__13821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__NameAssignment_1_in_rule__Macro__Group__1__Impl3848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__2__Impl_in_rule__Macro__Group__23878 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Macro__Group__3_in_rule__Macro__Group__23881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Macro__Group__2__Impl3909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__3__Impl_in_rule__Macro__Group__33940 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__4_in_rule__Macro__Group__33943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Macro__Group__3__Impl3971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__4__Impl_in_rule__Macro__Group__44002 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Macro__Group__5_in_rule__Macro__Group__44005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_rule__Macro__Group__4__Impl4032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__5__Impl_in_rule__Macro__Group__54061 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__6_in_rule__Macro__Group__54064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Macro__Group__5__Impl4092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__6__Impl_in_rule__Macro__Group__64123 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__7_in_rule__Macro__Group__64126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_rule__Macro__Group__6__Impl4153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__7__Impl_in_rule__Macro__Group__74182 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Macro__Group__8_in_rule__Macro__Group__74185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Macro__Group__7__Impl4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__8__Impl_in_rule__Macro__Group__84244 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_rule__Macro__Group__9_in_rule__Macro__Group__84247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Macro__Group__8__Impl4275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__9__Impl_in_rule__Macro__Group__94306 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__10_in_rule__Macro__Group__94309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__TypeNotationsAssignment_9_in_rule__Macro__Group__9__Impl4338 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_rule__Macro__TypeNotationsAssignment_9_in_rule__Macro__Group__9__Impl4350 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_rule__Macro__Group__10__Impl_in_rule__Macro__Group__104383 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__11_in_rule__Macro__Group__104386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_rule__Macro__Group__10__Impl4413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__11__Impl_in_rule__Macro__Group__114442 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Macro__Group__12_in_rule__Macro__Group__114445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Macro__Group__11__Impl4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__12__Impl_in_rule__Macro__Group__124504 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__13_in_rule__Macro__Group__124507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Macro__Group__12__Impl4535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__13__Impl_in_rule__Macro__Group__134566 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__14_in_rule__Macro__Group__134569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__ValueNotationAssignment_13_in_rule__Macro__Group__13__Impl4596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__14__Impl_in_rule__Macro__Group__144626 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Macro__Group__15_in_rule__Macro__Group__144629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__InnerTypesAssignment_14_in_rule__Macro__Group__14__Impl4658 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__InnerTypesAssignment_14_in_rule__Macro__Group__14__Impl4670 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__Group__15__Impl_in_rule__Macro__Group__154703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Macro__Group__15__Impl4731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__0__Impl_in_rule__ParamAssignment__Group__04794 = new BitSet(new long[]{0x0000000020000100L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__1_in_rule__ParamAssignment__Group__04797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__ParamAssignment_0_in_rule__ParamAssignment__Group__0__Impl4824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__1__Impl_in_rule__ParamAssignment__Group__14854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__RightAssignment_1_in_rule__ParamAssignment__Group__1__Impl4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__0__Impl_in_rule__TypeReferenceExt__Group__04915 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__1_in_rule__TypeReferenceExt__Group__04918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__ParentRefAssignment_0_in_rule__TypeReferenceExt__Group__0__Impl4945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__1__Impl_in_rule__TypeReferenceExt__Group__14975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_rule__TypeReferenceExt__Group__1__Impl5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scope__Group__0__Impl_in_rule__Scope__Group__05037 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Scope__Group__1_in_rule__Scope__Group__05040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Scope__ValuesAssignment_0_in_rule__Scope__Group__0__Impl5069 = new BitSet(new long[]{0x0000004E20400322L});
    public static final BitSet FOLLOW_rule__Scope__ValuesAssignment_0_in_rule__Scope__Group__0__Impl5081 = new BitSet(new long[]{0x0000004E20400322L});
    public static final BitSet FOLLOW_rule__Scope__Group__1__Impl_in_rule__Scope__Group__15114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_CRNL_in_rule__Scope__Group__1__Impl5141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__0__Impl_in_rule__Value__Group__05174 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__Value__Group__1_in_rule__Value__Group__05177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ValueTypesAssignment_0_in_rule__Value__Group__0__Impl5204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__1__Impl_in_rule__Value__Group__15234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_1__0_in_rule__Value__Group__1__Impl5261 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__Value__Group_1__0__Impl_in_rule__Value__Group_1__05296 = new BitSet(new long[]{0x0000004E20400320L});
    public static final BitSet FOLLOW_rule__Value__Group_1__1_in_rule__Value__Group_1__05299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Value__Group_1__0__Impl5327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_1__1__Impl_in_rule__Value__Group_1__15358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ValueTypesAssignment_1_1_in_rule__Value__Group_1__1__Impl5385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__0__Impl_in_rule__MacroValue__Group__05419 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__1_in_rule__MacroValue__Group__05422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__1__Impl_in_rule__MacroValue__Group__15480 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__2_in_rule__MacroValue__Group__15483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__MacroValue__Group__1__Impl5511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__2__Impl_in_rule__MacroValue__Group__25542 = new BitSet(new long[]{0x0000000100030000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__3_in_rule__MacroValue__Group__25545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__MacroValue__Group__2__Impl5573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__3__Impl_in_rule__MacroValue__Group__35604 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__4_in_rule__MacroValue__Group__35607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__TypeAssignment_3_in_rule__MacroValue__Group__3__Impl5634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__4__Impl_in_rule__MacroValue__Group__45664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__MacroValue__Group__4__Impl5692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__0__Impl_in_rule__UpdateType__Group__05733 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__1_in_rule__UpdateType__Group__05736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__UpdateType__Group__0__Impl5764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__1__Impl_in_rule__UpdateType__Group__15795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__TypeAssignment_1_in_rule__UpdateType__Group__1__Impl5822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__0__Impl_in_rule__ASN1_SIMPLE__Group_0__05856 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__1_in_rule__ASN1_SIMPLE__Group_0__05859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__1__Impl_in_rule__ASN1_SIMPLE__Group_0__15917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ASN1_SIMPLE__Group_0__1__Impl5945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__0__Impl_in_rule__ASN1_SIMPLE__Group_1__05980 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__1_in_rule__ASN1_SIMPLE__Group_1__05983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__1__Impl_in_rule__ASN1_SIMPLE__Group_1__16041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_rule__ASN1_SIMPLE__Group_1__1__Impl6068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__0__Impl_in_rule__ASN1_SIMPLE__Group_2__06101 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__1_in_rule__ASN1_SIMPLE__Group_2__06104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_rule__ASN1_SIMPLE__Group_2__0__Impl6131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__1__Impl_in_rule__ASN1_SIMPLE__Group_2__16160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_in_rule__ASN1_SIMPLE__Group_2__1__Impl6187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__0__Impl_in_rule__ASN1_SIMPLE__Group_3__06222 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__1_in_rule__ASN1_SIMPLE__Group_3__06225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_rule__ASN1_SIMPLE__Group_3__0__Impl6252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__1__Impl_in_rule__ASN1_SIMPLE__Group_3__16281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_3_1_in_rule__ASN1_SIMPLE__Group_3__1__Impl6308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__0__Impl_in_rule__ASN1_OCTET_STRING__Group__06343 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__1_in_rule__ASN1_OCTET_STRING__Group__06346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__1__Impl_in_rule__ASN1_OCTET_STRING__Group__16404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ASN1_OCTET_STRING__Group__1__Impl6432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__0__Impl_in_rule__ASN1_INTEGER__Group__06467 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__1_in_rule__ASN1_INTEGER__Group__06470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ASN1_INTEGER__Group__0__Impl6498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__1__Impl_in_rule__ASN1_INTEGER__Group__16529 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__2_in_rule__ASN1_INTEGER__Group__16532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ASN1_INTEGER__Group__1__Impl6560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__2__Impl_in_rule__ASN1_INTEGER__Group__26591 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__3_in_rule__ASN1_INTEGER__Group__26594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6623 = new BitSet(new long[]{0x0000000040000042L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6635 = new BitSet(new long[]{0x0000000040000042L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__3__Impl_in_rule__ASN1_INTEGER__Group__36668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ASN1_INTEGER__Group__3__Impl6696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__0__Impl_in_rule__ASN1_SUBTYPE__Group__06735 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__1_in_rule__ASN1_SUBTYPE__Group__06738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ASN1_SUBTYPE__Group__0__Impl6766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__1__Impl_in_rule__ASN1_SUBTYPE__Group__16797 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__2_in_rule__ASN1_SUBTYPE__Group__16800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ASN1_SUBTYPE__Group__1__Impl6828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__2__Impl_in_rule__ASN1_SUBTYPE__Group__26859 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__3_in_rule__ASN1_SUBTYPE__Group__26862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ASN1_SUBTYPE__Group__2__Impl6890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__3__Impl_in_rule__ASN1_SUBTYPE__Group__36921 = new BitSet(new long[]{0x0000000090000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__4_in_rule__ASN1_SUBTYPE__Group__36924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_3_in_rule__ASN1_SUBTYPE__Group__3__Impl6951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__4__Impl_in_rule__ASN1_SUBTYPE__Group__46981 = new BitSet(new long[]{0x0000000090000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__5_in_rule__ASN1_SUBTYPE__Group__46984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__0_in_rule__ASN1_SUBTYPE__Group__4__Impl7011 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__5__Impl_in_rule__ASN1_SUBTYPE__Group__57042 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__6_in_rule__ASN1_SUBTYPE__Group__57045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ASN1_SUBTYPE__Group__5__Impl7073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__6__Impl_in_rule__ASN1_SUBTYPE__Group__67104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ASN1_SUBTYPE__Group__6__Impl7132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__0__Impl_in_rule__ASN1_SUBTYPE__Group_4__07177 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__1_in_rule__ASN1_SUBTYPE__Group_4__07180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ASN1_SUBTYPE__Group_4__0__Impl7208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__1__Impl_in_rule__ASN1_SUBTYPE__Group_4__17239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_4_1_in_rule__ASN1_SUBTYPE__Group_4__1__Impl7266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__0__Impl_in_rule__ASN1_RANGE__Group_0__07300 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__1_in_rule__ASN1_RANGE__Group_0__07303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__1__Impl_in_rule__ASN1_RANGE__Group_0__17361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__ValueAssignment_0_1_in_rule__ASN1_RANGE__Group_0__1__Impl7388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__0__Impl_in_rule__ASN1_RANGE__Group_1__07422 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__1_in_rule__ASN1_RANGE__Group_1__07425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__StartAssignment_1_0_in_rule__ASN1_RANGE__Group_1__0__Impl7452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__1__Impl_in_rule__ASN1_RANGE__Group_1__17482 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__2_in_rule__ASN1_RANGE__Group_1__17485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ASN1_RANGE__Group_1__1__Impl7513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__2__Impl_in_rule__ASN1_RANGE__Group_1__27544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__EndAssignment_1_2_in_rule__ASN1_RANGE__Group_1__2__Impl7571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__0__Impl_in_rule__ASN1_VALUEPAIR__Group__07607 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__1_in_rule__ASN1_VALUEPAIR__Group__07610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ASN1_VALUEPAIR__Group__0__Impl7638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__1__Impl_in_rule__ASN1_VALUEPAIR__Group__17669 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__2_in_rule__ASN1_VALUEPAIR__Group__17672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ASN1_VALUEPAIR__Group__1__Impl7700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__2__Impl_in_rule__ASN1_VALUEPAIR__Group__27731 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__3_in_rule__ASN1_VALUEPAIR__Group__27734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_VALUEPAIR__Group__2__Impl7761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__3__Impl_in_rule__ASN1_VALUEPAIR__Group__37790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ASN1_VALUEPAIR__Group__3__Impl7818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__0__Impl_in_rule__ASN1_CHOICE__Group__07857 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__1_in_rule__ASN1_CHOICE__Group__07860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ASN1_CHOICE__Group__0__Impl7888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__1__Impl_in_rule__ASN1_CHOICE__Group__17919 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__2_in_rule__ASN1_CHOICE__Group__17922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ASN1_CHOICE__Group__1__Impl7950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__2__Impl_in_rule__ASN1_CHOICE__Group__27981 = new BitSet(new long[]{0x0000008001000000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__3_in_rule__ASN1_CHOICE__Group__27984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_2_in_rule__ASN1_CHOICE__Group__2__Impl8011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__3__Impl_in_rule__ASN1_CHOICE__Group__38041 = new BitSet(new long[]{0x0000008001000000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__4_in_rule__ASN1_CHOICE__Group__38044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__0_in_rule__ASN1_CHOICE__Group__3__Impl8071 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__4__Impl_in_rule__ASN1_CHOICE__Group__48102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ASN1_CHOICE__Group__4__Impl8130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__0__Impl_in_rule__ASN1_CHOICE__Group_3__08171 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__1_in_rule__ASN1_CHOICE__Group_3__08174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ASN1_CHOICE__Group_3__0__Impl8202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__1__Impl_in_rule__ASN1_CHOICE__Group_3__18233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_3_1_in_rule__ASN1_CHOICE__Group_3__1__Impl8260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__08294 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1_in_rule__ASN1_CHOICE_ENTRY__Group__08297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__IdAssignment_0_in_rule__ASN1_CHOICE_ENTRY__Group__0__Impl8324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__18354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1_in_rule__ASN1_CHOICE_ENTRY__Group__1__Impl8381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__Module__NameAssignment_0_08420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_rule__Module__IdentifiersAssignment_0_5_08451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_rule__Module__TypesAssignment_0_5_18482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_rule__Module__MacrosAssignment_0_5_28513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifier__NameAssignment_18544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_rule__ObjectIdentifier__OidValueAssignment_58575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__RootAssignment_0_08606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_18641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_18676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_28707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__TypeDefinition__NameAssignment_18738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleScope_in_rule__TypeDefinition__ScopeAssignment_38769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__Macro__NameAssignment_18800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_rule__Macro__TypeNotationsAssignment_98831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__Macro__ValueNotationAssignment_138862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_rule__Macro__InnerTypesAssignment_148893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PARAMETER_in_rule__ParamAssignment__ParamAssignment_08924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_rule__ParamAssignment__RightAssignment_18955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__TypeNotation__ValueAssignment_18986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ParentRefAssignment_09017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ChildRefAssignment_19048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__TypeReference__TypeAssignment9083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__Scope__ValuesAssignment_09118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_09149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_1_19180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_rule__ValueType__ParamAssignment_09211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_rule__ValueType__TypeAssignment_19242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_rule__ValueType__SimpleTypeAssignment_29273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__ValueType__MacroValueAssignment_39304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ValueType__OiAssignment_49340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_rule__MacroValue__TypeAssignment_39379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_rule__MACRO_VALUE_TYPE__UpdateAssignment_09410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_rule__MACRO_VALUE_TYPE__LiteralAssignment_19441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__UpdateType__TypeAssignment_19476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_rule__ASN1_SIMPLE__ConstraintAssignment_2_19511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SIMPLE__ConstraintAssignment_3_19542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_rule__ASN1_INTEGER__ValuePairsAssignment_29573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_39604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_4_19635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_RANGE__ValueAssignment_0_19666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_RANGE__StartAssignment_1_09697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_RANGE__EndAssignment_1_29728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_29759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_3_19790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__IdAssignment_09821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_19856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__RootAssignment_0_0_in_synpred4_InternalSmi1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_synpred24_InternalSmi5002 = new BitSet(new long[]{0x0000000000000002L});

}