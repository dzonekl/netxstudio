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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NEWLINE", "RULE_IA5STRING", "RULE_ASN1_ID", "RULE_INT", "RULE_MODULE_ID", "RULE_PARAMETER", "RULE_ALPHA_CAP", "RULE_ALPHA", "RULE_NUMERIC", "RULE_SL_ASN1_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'VALUE OBJECT IDENTIFIER'", "'IA5String'", "'DEFINITIONS'", "'::='", "'BEGIN'", "'END'", "'OBJECT IDENTIFIER'", "'{'", "'}'", "'MACRO'", "'TYPE NOTATION'", "'VALUE NOTATION'", "'|'", "'value'", "'('", "')'", "'Update'", "'empty'", "'SIZE'", "'..'", "'CHOICE'", "','", "'OCTET STRING'", "'INTEGER'"
    };
    public static final int RULE_NEWLINE=4;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:218:1: ruleTypeAssignment : ( ( rule__TypeAssignment__Group__0 ) ) ;
    public final void ruleTypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:222:2: ( ( ( rule__TypeAssignment__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:223:1: ( ( rule__TypeAssignment__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:223:1: ( ( rule__TypeAssignment__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:224:1: ( rule__TypeAssignment__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:225:1: ( rule__TypeAssignment__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:225:2: rule__TypeAssignment__Group__0
            {
            pushFollow(FOLLOW_rule__TypeAssignment__Group__0_in_ruleTypeAssignment409);
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


    // $ANTLR start "entryRuleValue"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:349:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:350:1: ( ruleValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:351:1: ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue676);
            ruleValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue683); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:358:1: ruleValue : ( ( rule__Value__Group__0 ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:362:2: ( ( ( rule__Value__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:363:1: ( ( rule__Value__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:363:1: ( ( rule__Value__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:364:1: ( rule__Value__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:365:1: ( rule__Value__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:365:2: rule__Value__Group__0
            {
            pushFollow(FOLLOW_rule__Value__Group__0_in_ruleValue709);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:377:1: entryRuleValueType : ruleValueType EOF ;
    public final void entryRuleValueType() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:378:1: ( ruleValueType EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:379:1: ruleValueType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeRule()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_entryRuleValueType736);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueType743); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:386:1: ruleValueType : ( ( rule__ValueType__Alternatives ) ) ;
    public final void ruleValueType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:390:2: ( ( ( rule__ValueType__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:391:1: ( ( rule__ValueType__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:391:1: ( ( rule__ValueType__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:392:1: ( rule__ValueType__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:393:1: ( rule__ValueType__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:393:2: rule__ValueType__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueType__Alternatives_in_ruleValueType769);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:405:1: entryRuleMacroValue : ruleMacroValue EOF ;
    public final void entryRuleMacroValue() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:406:1: ( ruleMacroValue EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:407:1: ruleMacroValue EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueRule()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_entryRuleMacroValue796);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroValueRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMacroValue803); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:414:1: ruleMacroValue : ( ( rule__MacroValue__Group__0 ) ) ;
    public final void ruleMacroValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:418:2: ( ( ( rule__MacroValue__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:419:1: ( ( rule__MacroValue__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:419:1: ( ( rule__MacroValue__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:420:1: ( rule__MacroValue__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:421:1: ( rule__MacroValue__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:421:2: rule__MacroValue__Group__0
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__0_in_ruleMacroValue829);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:433:1: entryRuleMACRO_VALUE_TYPE : ruleMACRO_VALUE_TYPE EOF ;
    public final void entryRuleMACRO_VALUE_TYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:434:1: ( ruleMACRO_VALUE_TYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:435:1: ruleMACRO_VALUE_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE856);
            ruleMACRO_VALUE_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_TYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE863); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:442:1: ruleMACRO_VALUE_TYPE : ( ( rule__MACRO_VALUE_TYPE__Alternatives ) ) ;
    public final void ruleMACRO_VALUE_TYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:446:2: ( ( ( rule__MACRO_VALUE_TYPE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:447:1: ( ( rule__MACRO_VALUE_TYPE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:447:1: ( ( rule__MACRO_VALUE_TYPE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:448:1: ( rule__MACRO_VALUE_TYPE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:449:1: ( rule__MACRO_VALUE_TYPE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:449:2: rule__MACRO_VALUE_TYPE__Alternatives
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__Alternatives_in_ruleMACRO_VALUE_TYPE889);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:461:1: entryRuleUpdateType : ruleUpdateType EOF ;
    public final void entryRuleUpdateType() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:462:1: ( ruleUpdateType EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:463:1: ruleUpdateType EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeRule()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_entryRuleUpdateType916);
            ruleUpdateType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUpdateTypeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpdateType923); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:470:1: ruleUpdateType : ( ( rule__UpdateType__Group__0 ) ) ;
    public final void ruleUpdateType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:474:2: ( ( ( rule__UpdateType__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:475:1: ( ( rule__UpdateType__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:475:1: ( ( rule__UpdateType__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:476:1: ( rule__UpdateType__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:477:1: ( rule__UpdateType__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:477:2: rule__UpdateType__Group__0
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__0_in_ruleUpdateType949);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:489:1: entryRuleMACRO_VALUE_CAP : ruleMACRO_VALUE_CAP EOF ;
    public final void entryRuleMACRO_VALUE_CAP() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:490:1: ( ruleMACRO_VALUE_CAP EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:491:1: ruleMACRO_VALUE_CAP EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP976);
            ruleMACRO_VALUE_CAP();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMACRO_VALUE_CAPRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP983); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:498:1: ruleMACRO_VALUE_CAP : ( ( rule__MACRO_VALUE_CAP__Alternatives ) ) ;
    public final void ruleMACRO_VALUE_CAP() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:502:2: ( ( ( rule__MACRO_VALUE_CAP__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:503:1: ( ( rule__MACRO_VALUE_CAP__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:503:1: ( ( rule__MACRO_VALUE_CAP__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:504:1: ( rule__MACRO_VALUE_CAP__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_CAPAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:505:1: ( rule__MACRO_VALUE_CAP__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:505:2: rule__MACRO_VALUE_CAP__Alternatives
            {
            pushFollow(FOLLOW_rule__MACRO_VALUE_CAP__Alternatives_in_ruleMACRO_VALUE_CAP1009);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:517:1: entryRuleASN1_TYPE : ruleASN1_TYPE EOF ;
    public final void entryRuleASN1_TYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:518:1: ( ruleASN1_TYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:519:1: ruleASN1_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_TYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE1036);
            ruleASN1_TYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_TYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_TYPE1043); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:526:1: ruleASN1_TYPE : ( ( rule__ASN1_TYPE__Alternatives ) ) ;
    public final void ruleASN1_TYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:530:2: ( ( ( rule__ASN1_TYPE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:531:1: ( ( rule__ASN1_TYPE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:531:1: ( ( rule__ASN1_TYPE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:532:1: ( rule__ASN1_TYPE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_TYPEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:533:1: ( rule__ASN1_TYPE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:533:2: rule__ASN1_TYPE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_TYPE__Alternatives_in_ruleASN1_TYPE1069);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:545:1: entryRuleASN1_SIMPLE : ruleASN1_SIMPLE EOF ;
    public final void entryRuleASN1_SIMPLE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:546:1: ( ruleASN1_SIMPLE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:547:1: ruleASN1_SIMPLE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE1096);
            ruleASN1_SIMPLE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SIMPLERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SIMPLE1103); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:554:1: ruleASN1_SIMPLE : ( ( rule__ASN1_SIMPLE__Alternatives ) ) ;
    public final void ruleASN1_SIMPLE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:558:2: ( ( ( rule__ASN1_SIMPLE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:559:1: ( ( rule__ASN1_SIMPLE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:559:1: ( ( rule__ASN1_SIMPLE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:560:1: ( rule__ASN1_SIMPLE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:561:1: ( rule__ASN1_SIMPLE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:561:2: rule__ASN1_SIMPLE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Alternatives_in_ruleASN1_SIMPLE1129);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:573:1: entryRuleASN1_OCTET_STRING : ruleASN1_OCTET_STRING EOF ;
    public final void entryRuleASN1_OCTET_STRING() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:574:1: ( ruleASN1_OCTET_STRING EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:575:1: ruleASN1_OCTET_STRING EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING1156);
            ruleASN1_OCTET_STRING();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_OCTET_STRINGRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING1163); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:582:1: ruleASN1_OCTET_STRING : ( ( rule__ASN1_OCTET_STRING__Group__0 ) ) ;
    public final void ruleASN1_OCTET_STRING() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:586:2: ( ( ( rule__ASN1_OCTET_STRING__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:587:1: ( ( rule__ASN1_OCTET_STRING__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:587:1: ( ( rule__ASN1_OCTET_STRING__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:588:1: ( rule__ASN1_OCTET_STRING__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:589:1: ( rule__ASN1_OCTET_STRING__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:589:2: rule__ASN1_OCTET_STRING__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__0_in_ruleASN1_OCTET_STRING1189);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:601:1: entryRuleASN1_INTEGER : ruleASN1_INTEGER EOF ;
    public final void entryRuleASN1_INTEGER() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:602:1: ( ruleASN1_INTEGER EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:603:1: ruleASN1_INTEGER EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER1216);
            ruleASN1_INTEGER();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_INTEGER1223); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:610:1: ruleASN1_INTEGER : ( ( rule__ASN1_INTEGER__Group__0 ) ) ;
    public final void ruleASN1_INTEGER() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:614:2: ( ( ( rule__ASN1_INTEGER__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:615:1: ( ( rule__ASN1_INTEGER__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:615:1: ( ( rule__ASN1_INTEGER__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:616:1: ( rule__ASN1_INTEGER__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:617:1: ( rule__ASN1_INTEGER__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:617:2: rule__ASN1_INTEGER__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__0_in_ruleASN1_INTEGER1249);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:629:1: entryRuleASN1_SUBTYPE : ruleASN1_SUBTYPE EOF ;
    public final void entryRuleASN1_SUBTYPE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:630:1: ( ruleASN1_SUBTYPE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:631:1: ruleASN1_SUBTYPE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE1276);
            ruleASN1_SUBTYPE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_SUBTYPERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_SUBTYPE1283); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:638:1: ruleASN1_SUBTYPE : ( ( rule__ASN1_SUBTYPE__Group__0 ) ) ;
    public final void ruleASN1_SUBTYPE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:642:2: ( ( ( rule__ASN1_SUBTYPE__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:643:1: ( ( rule__ASN1_SUBTYPE__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:643:1: ( ( rule__ASN1_SUBTYPE__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:644:1: ( rule__ASN1_SUBTYPE__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:645:1: ( rule__ASN1_SUBTYPE__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:645:2: rule__ASN1_SUBTYPE__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__0_in_ruleASN1_SUBTYPE1309);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:657:1: entryRuleASN1_RANGE : ruleASN1_RANGE EOF ;
    public final void entryRuleASN1_RANGE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:658:1: ( ruleASN1_RANGE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:659:1: ruleASN1_RANGE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE1336);
            ruleASN1_RANGE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_RANGERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_RANGE1343); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:666:1: ruleASN1_RANGE : ( ( rule__ASN1_RANGE__Alternatives ) ) ;
    public final void ruleASN1_RANGE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:670:2: ( ( ( rule__ASN1_RANGE__Alternatives ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:671:1: ( ( rule__ASN1_RANGE__Alternatives ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:671:1: ( ( rule__ASN1_RANGE__Alternatives ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:672:1: ( rule__ASN1_RANGE__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getAlternatives()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:673:1: ( rule__ASN1_RANGE__Alternatives )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:673:2: rule__ASN1_RANGE__Alternatives
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Alternatives_in_ruleASN1_RANGE1369);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:685:1: entryRuleASN1_VALUEPAIR : ruleASN1_VALUEPAIR EOF ;
    public final void entryRuleASN1_VALUEPAIR() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:686:1: ( ruleASN1_VALUEPAIR EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:687:1: ruleASN1_VALUEPAIR EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR1396);
            ruleASN1_VALUEPAIR();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_VALUEPAIRRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR1403); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:694:1: ruleASN1_VALUEPAIR : ( ( rule__ASN1_VALUEPAIR__Group__0 ) ) ;
    public final void ruleASN1_VALUEPAIR() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:698:2: ( ( ( rule__ASN1_VALUEPAIR__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:699:1: ( ( rule__ASN1_VALUEPAIR__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:699:1: ( ( rule__ASN1_VALUEPAIR__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:700:1: ( rule__ASN1_VALUEPAIR__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:701:1: ( rule__ASN1_VALUEPAIR__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:701:2: rule__ASN1_VALUEPAIR__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__0_in_ruleASN1_VALUEPAIR1429);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:713:1: entryRuleASN1_CHOICE : ruleASN1_CHOICE EOF ;
    public final void entryRuleASN1_CHOICE() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:714:1: ( ruleASN1_CHOICE EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:715:1: ruleASN1_CHOICE EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICERule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE1456);
            ruleASN1_CHOICE();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICERule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE1463); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:722:1: ruleASN1_CHOICE : ( ( rule__ASN1_CHOICE__Group__0 ) ) ;
    public final void ruleASN1_CHOICE() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:726:2: ( ( ( rule__ASN1_CHOICE__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:727:1: ( ( rule__ASN1_CHOICE__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:727:1: ( ( rule__ASN1_CHOICE__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:728:1: ( rule__ASN1_CHOICE__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:729:1: ( rule__ASN1_CHOICE__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:729:2: rule__ASN1_CHOICE__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__0_in_ruleASN1_CHOICE1489);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:741:1: entryRuleASN1_CHOICE_ENTRY : ruleASN1_CHOICE_ENTRY EOF ;
    public final void entryRuleASN1_CHOICE_ENTRY() throws RecognitionException {
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:742:1: ( ruleASN1_CHOICE_ENTRY EOF )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:743:1: ruleASN1_CHOICE_ENTRY EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY1516);
            ruleASN1_CHOICE_ENTRY();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_CHOICE_ENTRYRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY1523); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:750:1: ruleASN1_CHOICE_ENTRY : ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) ) ;
    public final void ruleASN1_CHOICE_ENTRY() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:754:2: ( ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:755:1: ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:755:1: ( ( rule__ASN1_CHOICE_ENTRY__Group__0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:756:1: ( rule__ASN1_CHOICE_ENTRY__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getGroup()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:757:1: ( rule__ASN1_CHOICE_ENTRY__Group__0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:757:2: rule__ASN1_CHOICE_ENTRY__Group__0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0_in_ruleASN1_CHOICE_ENTRY1549);
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


    // $ANTLR start "rule__Module__Alternatives_5"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:769:1: rule__Module__Alternatives_5 : ( ( ( rule__Module__IdentifiersAssignment_5_0 ) ) | ( ( rule__Module__TypesAssignment_5_1 ) ) | ( ( rule__Module__MacrosAssignment_5_2 ) ) );
    public final void rule__Module__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:773:1: ( ( ( rule__Module__IdentifiersAssignment_5_0 ) ) | ( ( rule__Module__TypesAssignment_5_1 ) ) | ( ( rule__Module__MacrosAssignment_5_2 ) ) )
            int alt1=3;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:774:1: ( ( rule__Module__IdentifiersAssignment_5_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:774:1: ( ( rule__Module__IdentifiersAssignment_5_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:775:1: ( rule__Module__IdentifiersAssignment_5_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModuleAccess().getIdentifiersAssignment_5_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:776:1: ( rule__Module__IdentifiersAssignment_5_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:776:2: rule__Module__IdentifiersAssignment_5_0
                    {
                    pushFollow(FOLLOW_rule__Module__IdentifiersAssignment_5_0_in_rule__Module__Alternatives_51585);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:780:6: ( ( rule__Module__TypesAssignment_5_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:780:6: ( ( rule__Module__TypesAssignment_5_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:781:1: ( rule__Module__TypesAssignment_5_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModuleAccess().getTypesAssignment_5_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:782:1: ( rule__Module__TypesAssignment_5_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:782:2: rule__Module__TypesAssignment_5_1
                    {
                    pushFollow(FOLLOW_rule__Module__TypesAssignment_5_1_in_rule__Module__Alternatives_51603);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:786:6: ( ( rule__Module__MacrosAssignment_5_2 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:786:6: ( ( rule__Module__MacrosAssignment_5_2 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:787:1: ( rule__Module__MacrosAssignment_5_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getModuleAccess().getMacrosAssignment_5_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:788:1: ( rule__Module__MacrosAssignment_5_2 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:788:2: rule__Module__MacrosAssignment_5_2
                    {
                    pushFollow(FOLLOW_rule__Module__MacrosAssignment_5_2_in_rule__Module__Alternatives_51621);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:797:1: rule__ObjectIdentifierValue__Alternatives_0 : ( ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) ) | ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) ) );
    public final void rule__ObjectIdentifierValue__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:801:1: ( ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) ) | ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) ) )
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:802:1: ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:802:1: ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:803:1: ( rule__ObjectIdentifierValue__RootAssignment_0_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectIdentifierValueAccess().getRootAssignment_0_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:804:1: ( rule__ObjectIdentifierValue__RootAssignment_0_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:804:2: rule__ObjectIdentifierValue__RootAssignment_0_0
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__RootAssignment_0_0_in_rule__ObjectIdentifierValue__Alternatives_01654);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:808:6: ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:808:6: ( ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:809:1: ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceAssignment_0_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:810:1: ( rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:810:2: rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1_in_rule__ObjectIdentifierValue__Alternatives_01672);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:819:1: rule__TypeAssignment__Alternatives_1 : ( ( ruleParamAssignment ) | ( ruleTypeReference ) | ( ruleMacroValue ) );
    public final void rule__TypeAssignment__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:823:1: ( ( ruleParamAssignment ) | ( ruleTypeReference ) | ( ruleMacroValue ) )
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
            case 29:
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:824:1: ( ruleParamAssignment )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:824:1: ( ruleParamAssignment )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:825:1: ruleParamAssignment
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAssignmentAccess().getParamAssignmentParserRuleCall_1_0()); 
                    }
                    pushFollow(FOLLOW_ruleParamAssignment_in_rule__TypeAssignment__Alternatives_11705);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:830:6: ( ruleTypeReference )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:830:6: ( ruleTypeReference )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:831:1: ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAssignmentAccess().getTypeReferenceParserRuleCall_1_1()); 
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeAssignment__Alternatives_11722);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:836:6: ( ruleMacroValue )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:836:6: ( ruleMacroValue )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:837:1: ruleMacroValue
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeAssignmentAccess().getMacroValueParserRuleCall_1_2()); 
                    }
                    pushFollow(FOLLOW_ruleMacroValue_in_rule__TypeAssignment__Alternatives_11739);
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


    // $ANTLR start "rule__TypeNotation__Alternatives"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:847:1: rule__TypeNotation__Alternatives : ( ( ruleTypeReference ) | ( ( rule__TypeNotation__ValueAssignment_1 ) ) );
    public final void rule__TypeNotation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:851:1: ( ( ruleTypeReference ) | ( ( rule__TypeNotation__ValueAssignment_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_MODULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==29) ) {
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:852:1: ( ruleTypeReference )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:852:1: ( ruleTypeReference )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:853:1: ruleTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeNotationAccess().getTypeReferenceParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeNotation__Alternatives1771);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:858:6: ( ( rule__TypeNotation__ValueAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:858:6: ( ( rule__TypeNotation__ValueAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:859:1: ( rule__TypeNotation__ValueAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getTypeNotationAccess().getValueAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:860:1: ( rule__TypeNotation__ValueAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:860:2: rule__TypeNotation__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TypeNotation__ValueAssignment_1_in_rule__TypeNotation__Alternatives1788);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:869:1: rule__ValueType__Alternatives : ( ( ( rule__ValueType__ParamAssignment_0 ) ) | ( ( rule__ValueType__TypesAssignment_1 ) ) | ( ( rule__ValueType__SimpleTypeAssignment_2 ) ) | ( ( rule__ValueType__MacroValueAssignment_3 ) ) | ( ( rule__ValueType__OiAssignment_4 ) ) );
    public final void rule__ValueType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:873:1: ( ( ( rule__ValueType__ParamAssignment_0 ) ) | ( ( rule__ValueType__TypesAssignment_1 ) ) | ( ( rule__ValueType__SimpleTypeAssignment_2 ) ) | ( ( rule__ValueType__MacroValueAssignment_3 ) ) | ( ( rule__ValueType__OiAssignment_4 ) ) )
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
            case 33:
            case 36:
            case 38:
            case 39:
                {
                alt5=3;
                }
                break;
            case 29:
                {
                alt5=4;
                }
                break;
            case 22:
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:874:1: ( ( rule__ValueType__ParamAssignment_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:874:1: ( ( rule__ValueType__ParamAssignment_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:875:1: ( rule__ValueType__ParamAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getParamAssignment_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:876:1: ( rule__ValueType__ParamAssignment_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:876:2: rule__ValueType__ParamAssignment_0
                    {
                    pushFollow(FOLLOW_rule__ValueType__ParamAssignment_0_in_rule__ValueType__Alternatives1821);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:880:6: ( ( rule__ValueType__TypesAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:880:6: ( ( rule__ValueType__TypesAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:881:1: ( rule__ValueType__TypesAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getTypesAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:882:1: ( rule__ValueType__TypesAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:882:2: rule__ValueType__TypesAssignment_1
                    {
                    pushFollow(FOLLOW_rule__ValueType__TypesAssignment_1_in_rule__ValueType__Alternatives1839);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:886:6: ( ( rule__ValueType__SimpleTypeAssignment_2 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:886:6: ( ( rule__ValueType__SimpleTypeAssignment_2 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:887:1: ( rule__ValueType__SimpleTypeAssignment_2 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getSimpleTypeAssignment_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:888:1: ( rule__ValueType__SimpleTypeAssignment_2 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:888:2: rule__ValueType__SimpleTypeAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ValueType__SimpleTypeAssignment_2_in_rule__ValueType__Alternatives1857);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:892:6: ( ( rule__ValueType__MacroValueAssignment_3 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:892:6: ( ( rule__ValueType__MacroValueAssignment_3 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:893:1: ( rule__ValueType__MacroValueAssignment_3 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getMacroValueAssignment_3()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:894:1: ( rule__ValueType__MacroValueAssignment_3 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:894:2: rule__ValueType__MacroValueAssignment_3
                    {
                    pushFollow(FOLLOW_rule__ValueType__MacroValueAssignment_3_in_rule__ValueType__Alternatives1875);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:898:6: ( ( rule__ValueType__OiAssignment_4 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:898:6: ( ( rule__ValueType__OiAssignment_4 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:899:1: ( rule__ValueType__OiAssignment_4 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getValueTypeAccess().getOiAssignment_4()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:900:1: ( rule__ValueType__OiAssignment_4 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:900:2: rule__ValueType__OiAssignment_4
                    {
                    pushFollow(FOLLOW_rule__ValueType__OiAssignment_4_in_rule__ValueType__Alternatives1893);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:909:1: rule__MACRO_VALUE_TYPE__Alternatives : ( ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) ) | ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 ) ) );
    public final void rule__MACRO_VALUE_TYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:913:1: ( ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) ) | ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==32) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=16 && LA6_0<=17)) ) {
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:914:1: ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:914:1: ( ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:915:1: ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateAssignment_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:916:1: ( rule__MACRO_VALUE_TYPE__UpdateAssignment_0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:916:2: rule__MACRO_VALUE_TYPE__UpdateAssignment_0
                    {
                    pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__UpdateAssignment_0_in_rule__MACRO_VALUE_TYPE__Alternatives1926);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:920:6: ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:920:6: ( ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:921:1: ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralAssignment_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:922:1: ( rule__MACRO_VALUE_TYPE__LiteralAssignment_1 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:922:2: rule__MACRO_VALUE_TYPE__LiteralAssignment_1
                    {
                    pushFollow(FOLLOW_rule__MACRO_VALUE_TYPE__LiteralAssignment_1_in_rule__MACRO_VALUE_TYPE__Alternatives1944);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:931:1: rule__MACRO_VALUE_CAP__Alternatives : ( ( 'VALUE OBJECT IDENTIFIER' ) | ( 'IA5String' ) );
    public final void rule__MACRO_VALUE_CAP__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:935:1: ( ( 'VALUE OBJECT IDENTIFIER' ) | ( 'IA5String' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            else if ( (LA7_0==17) ) {
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:936:1: ( 'VALUE OBJECT IDENTIFIER' )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:936:1: ( 'VALUE OBJECT IDENTIFIER' )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:937:1: 'VALUE OBJECT IDENTIFIER'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_CAPAccess().getVALUEOBJECTIDENTIFIERKeyword_0()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__MACRO_VALUE_CAP__Alternatives1978); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getMACRO_VALUE_CAPAccess().getVALUEOBJECTIDENTIFIERKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:944:6: ( 'IA5String' )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:944:6: ( 'IA5String' )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:945:1: 'IA5String'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getMACRO_VALUE_CAPAccess().getIA5StringKeyword_1()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__MACRO_VALUE_CAP__Alternatives1998); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:957:1: rule__ASN1_TYPE__Alternatives : ( ( ruleASN1_SIMPLE ) | ( ruleASN1_CHOICE ) );
    public final void rule__ASN1_TYPE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:961:1: ( ( ruleASN1_SIMPLE ) | ( ruleASN1_CHOICE ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_IA5STRING||LA8_0==33||(LA8_0>=38 && LA8_0<=39)) ) {
                alt8=1;
            }
            else if ( (LA8_0==36) ) {
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:962:1: ( ruleASN1_SIMPLE )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:962:1: ( ruleASN1_SIMPLE )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:963:1: ruleASN1_SIMPLE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_TYPEAccess().getASN1_SIMPLEParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleASN1_SIMPLE_in_rule__ASN1_TYPE__Alternatives2032);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:968:6: ( ruleASN1_CHOICE )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:968:6: ( ruleASN1_CHOICE )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:969:1: ruleASN1_CHOICE
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_TYPEAccess().getASN1_CHOICEParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleASN1_CHOICE_in_rule__ASN1_TYPE__Alternatives2049);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:979:1: rule__ASN1_SIMPLE__Alternatives : ( ( ( rule__ASN1_SIMPLE__Group_0__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_1__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_2__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_3__0 ) ) );
    public final void rule__ASN1_SIMPLE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:983:1: ( ( ( rule__ASN1_SIMPLE__Group_0__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_1__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_2__0 ) ) | ( ( rule__ASN1_SIMPLE__Group_3__0 ) ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt9=1;
                }
                break;
            case RULE_IA5STRING:
                {
                alt9=2;
                }
                break;
            case 38:
                {
                alt9=3;
                }
                break;
            case 39:
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:984:1: ( ( rule__ASN1_SIMPLE__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:984:1: ( ( rule__ASN1_SIMPLE__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:985:1: ( rule__ASN1_SIMPLE__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:986:1: ( rule__ASN1_SIMPLE__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:986:2: rule__ASN1_SIMPLE__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__0_in_rule__ASN1_SIMPLE__Alternatives2081);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:990:6: ( ( rule__ASN1_SIMPLE__Group_1__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:990:6: ( ( rule__ASN1_SIMPLE__Group_1__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:991:1: ( rule__ASN1_SIMPLE__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:992:1: ( rule__ASN1_SIMPLE__Group_1__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:992:2: rule__ASN1_SIMPLE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__0_in_rule__ASN1_SIMPLE__Alternatives2099);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:996:6: ( ( rule__ASN1_SIMPLE__Group_2__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:996:6: ( ( rule__ASN1_SIMPLE__Group_2__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:997:1: ( rule__ASN1_SIMPLE__Group_2__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_2()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:998:1: ( rule__ASN1_SIMPLE__Group_2__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:998:2: rule__ASN1_SIMPLE__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__0_in_rule__ASN1_SIMPLE__Alternatives2117);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1002:6: ( ( rule__ASN1_SIMPLE__Group_3__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1002:6: ( ( rule__ASN1_SIMPLE__Group_3__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1003:1: ( rule__ASN1_SIMPLE__Group_3__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_SIMPLEAccess().getGroup_3()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1004:1: ( rule__ASN1_SIMPLE__Group_3__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1004:2: rule__ASN1_SIMPLE__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__0_in_rule__ASN1_SIMPLE__Alternatives2135);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1013:1: rule__ASN1_RANGE__Alternatives : ( ( ( rule__ASN1_RANGE__Group_0__0 ) ) | ( ( rule__ASN1_RANGE__Group_1__0 ) ) );
    public final void rule__ASN1_RANGE__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1017:1: ( ( ( rule__ASN1_RANGE__Group_0__0 ) ) | ( ( rule__ASN1_RANGE__Group_1__0 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_INT) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==EOF||(LA10_1>=RULE_NEWLINE && LA10_1<=RULE_IA5STRING)||(LA10_1>=RULE_MODULE_ID && LA10_1<=RULE_PARAMETER)||LA10_1==22||(LA10_1>=28 && LA10_1<=29)||LA10_1==31||LA10_1==33||LA10_1==36||(LA10_1>=38 && LA10_1<=39)) ) {
                    alt10=1;
                }
                else if ( (LA10_1==35) ) {
                    alt10=2;
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1018:1: ( ( rule__ASN1_RANGE__Group_0__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1018:1: ( ( rule__ASN1_RANGE__Group_0__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1019:1: ( rule__ASN1_RANGE__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_RANGEAccess().getGroup_0()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1020:1: ( rule__ASN1_RANGE__Group_0__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1020:2: rule__ASN1_RANGE__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__0_in_rule__ASN1_RANGE__Alternatives2168);
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
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1024:6: ( ( rule__ASN1_RANGE__Group_1__0 ) )
                    {
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1024:6: ( ( rule__ASN1_RANGE__Group_1__0 ) )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1025:1: ( rule__ASN1_RANGE__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getASN1_RANGEAccess().getGroup_1()); 
                    }
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1026:1: ( rule__ASN1_RANGE__Group_1__0 )
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1026:2: rule__ASN1_RANGE__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__0_in_rule__ASN1_RANGE__Alternatives2186);
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


    // $ANTLR start "rule__Module__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1037:1: rule__Module__Group__0 : rule__Module__Group__0__Impl rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1041:1: ( rule__Module__Group__0__Impl rule__Module__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1042:2: rule__Module__Group__0__Impl rule__Module__Group__1
            {
            pushFollow(FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__02217);
            rule__Module__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__1_in_rule__Module__Group__02220);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1049:1: rule__Module__Group__0__Impl : ( ( rule__Module__NameAssignment_0 ) ) ;
    public final void rule__Module__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1053:1: ( ( ( rule__Module__NameAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1054:1: ( ( rule__Module__NameAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1054:1: ( ( rule__Module__NameAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1055:1: ( rule__Module__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNameAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1056:1: ( rule__Module__NameAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1056:2: rule__Module__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Module__NameAssignment_0_in_rule__Module__Group__0__Impl2247);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1066:1: rule__Module__Group__1 : rule__Module__Group__1__Impl rule__Module__Group__2 ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1070:1: ( rule__Module__Group__1__Impl rule__Module__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1071:2: rule__Module__Group__1__Impl rule__Module__Group__2
            {
            pushFollow(FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__12277);
            rule__Module__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__2_in_rule__Module__Group__12280);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1078:1: rule__Module__Group__1__Impl : ( 'DEFINITIONS' ) ;
    public final void rule__Module__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1082:1: ( ( 'DEFINITIONS' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1083:1: ( 'DEFINITIONS' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1083:1: ( 'DEFINITIONS' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1084:1: 'DEFINITIONS'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getDEFINITIONSKeyword_1()); 
            }
            match(input,18,FOLLOW_18_in_rule__Module__Group__1__Impl2308); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1097:1: rule__Module__Group__2 : rule__Module__Group__2__Impl rule__Module__Group__3 ;
    public final void rule__Module__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1101:1: ( rule__Module__Group__2__Impl rule__Module__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1102:2: rule__Module__Group__2__Impl rule__Module__Group__3
            {
            pushFollow(FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__22339);
            rule__Module__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__3_in_rule__Module__Group__22342);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1109:1: rule__Module__Group__2__Impl : ( '::=' ) ;
    public final void rule__Module__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1113:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1114:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1114:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1115:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getColonColonEqualsSignKeyword_2()); 
            }
            match(input,19,FOLLOW_19_in_rule__Module__Group__2__Impl2370); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1128:1: rule__Module__Group__3 : rule__Module__Group__3__Impl rule__Module__Group__4 ;
    public final void rule__Module__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1132:1: ( rule__Module__Group__3__Impl rule__Module__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1133:2: rule__Module__Group__3__Impl rule__Module__Group__4
            {
            pushFollow(FOLLOW_rule__Module__Group__3__Impl_in_rule__Module__Group__32401);
            rule__Module__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__4_in_rule__Module__Group__32404);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1140:1: rule__Module__Group__3__Impl : ( 'BEGIN' ) ;
    public final void rule__Module__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1144:1: ( ( 'BEGIN' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1145:1: ( 'BEGIN' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1145:1: ( 'BEGIN' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1146:1: 'BEGIN'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getBEGINKeyword_3()); 
            }
            match(input,20,FOLLOW_20_in_rule__Module__Group__3__Impl2432); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1159:1: rule__Module__Group__4 : rule__Module__Group__4__Impl rule__Module__Group__5 ;
    public final void rule__Module__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1163:1: ( rule__Module__Group__4__Impl rule__Module__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1164:2: rule__Module__Group__4__Impl rule__Module__Group__5
            {
            pushFollow(FOLLOW_rule__Module__Group__4__Impl_in_rule__Module__Group__42463);
            rule__Module__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__5_in_rule__Module__Group__42466);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1171:1: rule__Module__Group__4__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Module__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1175:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1176:1: ( RULE_NEWLINE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1176:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1177:1: RULE_NEWLINE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_4()); 
            }
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Module__Group__4__Impl2493); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1188:1: rule__Module__Group__5 : rule__Module__Group__5__Impl rule__Module__Group__6 ;
    public final void rule__Module__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1192:1: ( rule__Module__Group__5__Impl rule__Module__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1193:2: rule__Module__Group__5__Impl rule__Module__Group__6
            {
            pushFollow(FOLLOW_rule__Module__Group__5__Impl_in_rule__Module__Group__52522);
            rule__Module__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__6_in_rule__Module__Group__52525);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1200:1: rule__Module__Group__5__Impl : ( ( ( rule__Module__Alternatives_5 ) ) ( ( rule__Module__Alternatives_5 )* ) ) ;
    public final void rule__Module__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1204:1: ( ( ( ( rule__Module__Alternatives_5 ) ) ( ( rule__Module__Alternatives_5 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1205:1: ( ( ( rule__Module__Alternatives_5 ) ) ( ( rule__Module__Alternatives_5 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1205:1: ( ( ( rule__Module__Alternatives_5 ) ) ( ( rule__Module__Alternatives_5 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1206:1: ( ( rule__Module__Alternatives_5 ) ) ( ( rule__Module__Alternatives_5 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1206:1: ( ( rule__Module__Alternatives_5 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1207:1: ( rule__Module__Alternatives_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getAlternatives_5()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1208:1: ( rule__Module__Alternatives_5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1208:2: rule__Module__Alternatives_5
            {
            pushFollow(FOLLOW_rule__Module__Alternatives_5_in_rule__Module__Group__5__Impl2554);
            rule__Module__Alternatives_5();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getAlternatives_5()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1211:1: ( ( rule__Module__Alternatives_5 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1212:1: ( rule__Module__Alternatives_5 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getAlternatives_5()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1213:1: ( rule__Module__Alternatives_5 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_NEWLINE) ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==RULE_NEWLINE||LA11_1==RULE_ASN1_ID||LA11_1==RULE_MODULE_ID) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1213:2: rule__Module__Alternatives_5
            	    {
            	    pushFollow(FOLLOW_rule__Module__Alternatives_5_in_rule__Module__Group__5__Impl2566);
            	    rule__Module__Alternatives_5();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1224:1: rule__Module__Group__6 : rule__Module__Group__6__Impl rule__Module__Group__7 ;
    public final void rule__Module__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1228:1: ( rule__Module__Group__6__Impl rule__Module__Group__7 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1229:2: rule__Module__Group__6__Impl rule__Module__Group__7
            {
            pushFollow(FOLLOW_rule__Module__Group__6__Impl_in_rule__Module__Group__62599);
            rule__Module__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__7_in_rule__Module__Group__62602);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1236:1: rule__Module__Group__6__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Module__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1240:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1241:1: ( RULE_NEWLINE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1241:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1242:1: RULE_NEWLINE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_6()); 
            }
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Module__Group__6__Impl2629); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1253:1: rule__Module__Group__7 : rule__Module__Group__7__Impl rule__Module__Group__8 ;
    public final void rule__Module__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1257:1: ( rule__Module__Group__7__Impl rule__Module__Group__8 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1258:2: rule__Module__Group__7__Impl rule__Module__Group__8
            {
            pushFollow(FOLLOW_rule__Module__Group__7__Impl_in_rule__Module__Group__72658);
            rule__Module__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__8_in_rule__Module__Group__72661);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1265:1: rule__Module__Group__7__Impl : ( 'END' ) ;
    public final void rule__Module__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1269:1: ( ( 'END' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1270:1: ( 'END' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1270:1: ( 'END' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1271:1: 'END'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getENDKeyword_7()); 
            }
            match(input,21,FOLLOW_21_in_rule__Module__Group__7__Impl2689); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1284:1: rule__Module__Group__8 : rule__Module__Group__8__Impl ;
    public final void rule__Module__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1288:1: ( rule__Module__Group__8__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1289:2: rule__Module__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group__8__Impl_in_rule__Module__Group__82720);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1295:1: rule__Module__Group__8__Impl : ( ( RULE_NEWLINE )* ) ;
    public final void rule__Module__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1299:1: ( ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1300:1: ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1300:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1301:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_8()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1302:1: ( RULE_NEWLINE )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_NEWLINE) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1302:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Module__Group__8__Impl2748); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1330:1: rule__ObjectIdentifier__Group__0 : rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1 ;
    public final void rule__ObjectIdentifier__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1334:1: ( rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1335:2: rule__ObjectIdentifier__Group__0__Impl rule__ObjectIdentifier__Group__1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__0__Impl_in_rule__ObjectIdentifier__Group__02797);
            rule__ObjectIdentifier__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__1_in_rule__ObjectIdentifier__Group__02800);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1342:1: rule__ObjectIdentifier__Group__0__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__ObjectIdentifier__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1346:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1347:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1347:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1348:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1348:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1349:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1350:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1350:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ObjectIdentifier__Group__0__Impl2830); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getObjectIdentifierAccess().getNEWLINETerminalRuleCall_0()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1353:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1354:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1355:1: ( RULE_NEWLINE )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_NEWLINE) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1355:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__ObjectIdentifier__Group__0__Impl2843); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1366:1: rule__ObjectIdentifier__Group__1 : rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2 ;
    public final void rule__ObjectIdentifier__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1370:1: ( rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1371:2: rule__ObjectIdentifier__Group__1__Impl rule__ObjectIdentifier__Group__2
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__1__Impl_in_rule__ObjectIdentifier__Group__12876);
            rule__ObjectIdentifier__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__2_in_rule__ObjectIdentifier__Group__12879);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1378:1: rule__ObjectIdentifier__Group__1__Impl : ( ( rule__ObjectIdentifier__NameAssignment_1 ) ) ;
    public final void rule__ObjectIdentifier__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1382:1: ( ( ( rule__ObjectIdentifier__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1383:1: ( ( rule__ObjectIdentifier__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1383:1: ( ( rule__ObjectIdentifier__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1384:1: ( rule__ObjectIdentifier__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1385:1: ( rule__ObjectIdentifier__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1385:2: rule__ObjectIdentifier__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__NameAssignment_1_in_rule__ObjectIdentifier__Group__1__Impl2906);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1395:1: rule__ObjectIdentifier__Group__2 : rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3 ;
    public final void rule__ObjectIdentifier__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1399:1: ( rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1400:2: rule__ObjectIdentifier__Group__2__Impl rule__ObjectIdentifier__Group__3
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__2__Impl_in_rule__ObjectIdentifier__Group__22936);
            rule__ObjectIdentifier__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__3_in_rule__ObjectIdentifier__Group__22939);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1407:1: rule__ObjectIdentifier__Group__2__Impl : ( 'OBJECT IDENTIFIER' ) ;
    public final void rule__ObjectIdentifier__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1411:1: ( ( 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1412:1: ( 'OBJECT IDENTIFIER' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1412:1: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1413:1: 'OBJECT IDENTIFIER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOBJECTIDENTIFIERKeyword_2()); 
            }
            match(input,22,FOLLOW_22_in_rule__ObjectIdentifier__Group__2__Impl2967); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1426:1: rule__ObjectIdentifier__Group__3 : rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4 ;
    public final void rule__ObjectIdentifier__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1430:1: ( rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1431:2: rule__ObjectIdentifier__Group__3__Impl rule__ObjectIdentifier__Group__4
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__3__Impl_in_rule__ObjectIdentifier__Group__32998);
            rule__ObjectIdentifier__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__4_in_rule__ObjectIdentifier__Group__33001);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1438:1: rule__ObjectIdentifier__Group__3__Impl : ( '::=' ) ;
    public final void rule__ObjectIdentifier__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1442:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1443:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1443:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1444:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getColonColonEqualsSignKeyword_3()); 
            }
            match(input,19,FOLLOW_19_in_rule__ObjectIdentifier__Group__3__Impl3029); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1457:1: rule__ObjectIdentifier__Group__4 : rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5 ;
    public final void rule__ObjectIdentifier__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1461:1: ( rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1462:2: rule__ObjectIdentifier__Group__4__Impl rule__ObjectIdentifier__Group__5
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__4__Impl_in_rule__ObjectIdentifier__Group__43060);
            rule__ObjectIdentifier__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__5_in_rule__ObjectIdentifier__Group__43063);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1469:1: rule__ObjectIdentifier__Group__4__Impl : ( '{' ) ;
    public final void rule__ObjectIdentifier__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1473:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1474:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1474:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1475:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getLeftCurlyBracketKeyword_4()); 
            }
            match(input,23,FOLLOW_23_in_rule__ObjectIdentifier__Group__4__Impl3091); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1488:1: rule__ObjectIdentifier__Group__5 : rule__ObjectIdentifier__Group__5__Impl rule__ObjectIdentifier__Group__6 ;
    public final void rule__ObjectIdentifier__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1492:1: ( rule__ObjectIdentifier__Group__5__Impl rule__ObjectIdentifier__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1493:2: rule__ObjectIdentifier__Group__5__Impl rule__ObjectIdentifier__Group__6
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__5__Impl_in_rule__ObjectIdentifier__Group__53122);
            rule__ObjectIdentifier__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__6_in_rule__ObjectIdentifier__Group__53125);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1500:1: rule__ObjectIdentifier__Group__5__Impl : ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) ) ;
    public final void rule__ObjectIdentifier__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1504:1: ( ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1505:1: ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1505:1: ( ( rule__ObjectIdentifier__OidValueAssignment_5 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1506:1: ( rule__ObjectIdentifier__OidValueAssignment_5 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOidValueAssignment_5()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1507:1: ( rule__ObjectIdentifier__OidValueAssignment_5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1507:2: rule__ObjectIdentifier__OidValueAssignment_5
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__OidValueAssignment_5_in_rule__ObjectIdentifier__Group__5__Impl3152);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1517:1: rule__ObjectIdentifier__Group__6 : rule__ObjectIdentifier__Group__6__Impl ;
    public final void rule__ObjectIdentifier__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1521:1: ( rule__ObjectIdentifier__Group__6__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1522:2: rule__ObjectIdentifier__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ObjectIdentifier__Group__6__Impl_in_rule__ObjectIdentifier__Group__63182);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1528:1: rule__ObjectIdentifier__Group__6__Impl : ( '}' ) ;
    public final void rule__ObjectIdentifier__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1532:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1533:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1533:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1534:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getRightCurlyBracketKeyword_6()); 
            }
            match(input,24,FOLLOW_24_in_rule__ObjectIdentifier__Group__6__Impl3210); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1561:1: rule__ObjectIdentifierValue__Group__0 : rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1 ;
    public final void rule__ObjectIdentifierValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1565:1: ( rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1566:2: rule__ObjectIdentifierValue__Group__0__Impl rule__ObjectIdentifierValue__Group__1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__0__Impl_in_rule__ObjectIdentifierValue__Group__03255);
            rule__ObjectIdentifierValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__1_in_rule__ObjectIdentifierValue__Group__03258);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1573:1: rule__ObjectIdentifierValue__Group__0__Impl : ( ( rule__ObjectIdentifierValue__Alternatives_0 )? ) ;
    public final void rule__ObjectIdentifierValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1577:1: ( ( ( rule__ObjectIdentifierValue__Alternatives_0 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1578:1: ( ( rule__ObjectIdentifierValue__Alternatives_0 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1578:1: ( ( rule__ObjectIdentifierValue__Alternatives_0 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1579:1: ( rule__ObjectIdentifierValue__Alternatives_0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getAlternatives_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1580:1: ( rule__ObjectIdentifierValue__Alternatives_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ASN1_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1580:2: rule__ObjectIdentifierValue__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__ObjectIdentifierValue__Alternatives_0_in_rule__ObjectIdentifierValue__Group__0__Impl3285);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1590:1: rule__ObjectIdentifierValue__Group__1 : rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2 ;
    public final void rule__ObjectIdentifierValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1594:1: ( rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1595:2: rule__ObjectIdentifierValue__Group__1__Impl rule__ObjectIdentifierValue__Group__2
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__1__Impl_in_rule__ObjectIdentifierValue__Group__13316);
            rule__ObjectIdentifierValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__2_in_rule__ObjectIdentifierValue__Group__13319);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1602:1: rule__ObjectIdentifierValue__Group__1__Impl : ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) ) ;
    public final void rule__ObjectIdentifierValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1606:1: ( ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1607:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1607:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1608:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1609:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1609:2: rule__ObjectIdentifierValue__SubIdsAssignment_1
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_1_in_rule__ObjectIdentifierValue__Group__1__Impl3346);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1619:1: rule__ObjectIdentifierValue__Group__2 : rule__ObjectIdentifierValue__Group__2__Impl ;
    public final void rule__ObjectIdentifierValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1623:1: ( rule__ObjectIdentifierValue__Group__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1624:2: rule__ObjectIdentifierValue__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ObjectIdentifierValue__Group__2__Impl_in_rule__ObjectIdentifierValue__Group__23376);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1630:1: rule__ObjectIdentifierValue__Group__2__Impl : ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* ) ;
    public final void rule__ObjectIdentifierValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1634:1: ( ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1635:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1635:1: ( ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1636:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1637:1: ( rule__ObjectIdentifierValue__SubIdsAssignment_2 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_INT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1637:2: rule__ObjectIdentifierValue__SubIdsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_2_in_rule__ObjectIdentifierValue__Group__2__Impl3403);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1653:1: rule__TypeDefinition__Group__0 : rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1 ;
    public final void rule__TypeDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1657:1: ( rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1658:2: rule__TypeDefinition__Group__0__Impl rule__TypeDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__0__Impl_in_rule__TypeDefinition__Group__03440);
            rule__TypeDefinition__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeDefinition__Group__1_in_rule__TypeDefinition__Group__03443);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1665:1: rule__TypeDefinition__Group__0__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__TypeDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1669:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1670:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1670:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1671:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1671:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1672:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1673:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1673:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__TypeDefinition__Group__0__Impl3473); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1676:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1677:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1678:1: ( RULE_NEWLINE )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_NEWLINE) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1678:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__TypeDefinition__Group__0__Impl3486); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1689:1: rule__TypeDefinition__Group__1 : rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2 ;
    public final void rule__TypeDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1693:1: ( rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1694:2: rule__TypeDefinition__Group__1__Impl rule__TypeDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__1__Impl_in_rule__TypeDefinition__Group__13519);
            rule__TypeDefinition__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeDefinition__Group__2_in_rule__TypeDefinition__Group__13522);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1701:1: rule__TypeDefinition__Group__1__Impl : ( ( rule__TypeDefinition__NameAssignment_1 ) ) ;
    public final void rule__TypeDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1705:1: ( ( ( rule__TypeDefinition__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1706:1: ( ( rule__TypeDefinition__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1706:1: ( ( rule__TypeDefinition__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1707:1: ( rule__TypeDefinition__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1708:1: ( rule__TypeDefinition__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1708:2: rule__TypeDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TypeDefinition__NameAssignment_1_in_rule__TypeDefinition__Group__1__Impl3549);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1718:1: rule__TypeDefinition__Group__2 : rule__TypeDefinition__Group__2__Impl rule__TypeDefinition__Group__3 ;
    public final void rule__TypeDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1722:1: ( rule__TypeDefinition__Group__2__Impl rule__TypeDefinition__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1723:2: rule__TypeDefinition__Group__2__Impl rule__TypeDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__2__Impl_in_rule__TypeDefinition__Group__23579);
            rule__TypeDefinition__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeDefinition__Group__3_in_rule__TypeDefinition__Group__23582);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1730:1: rule__TypeDefinition__Group__2__Impl : ( '::=' ) ;
    public final void rule__TypeDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1734:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1735:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1735:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1736:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getColonColonEqualsSignKeyword_2()); 
            }
            match(input,19,FOLLOW_19_in_rule__TypeDefinition__Group__2__Impl3610); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1749:1: rule__TypeDefinition__Group__3 : rule__TypeDefinition__Group__3__Impl ;
    public final void rule__TypeDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1753:1: ( rule__TypeDefinition__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1754:2: rule__TypeDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TypeDefinition__Group__3__Impl_in_rule__TypeDefinition__Group__33641);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1760:1: rule__TypeDefinition__Group__3__Impl : ( ( ( rule__TypeDefinition__ValuesAssignment_3 ) ) ( ( rule__TypeDefinition__ValuesAssignment_3 )* ) ) ;
    public final void rule__TypeDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1764:1: ( ( ( ( rule__TypeDefinition__ValuesAssignment_3 ) ) ( ( rule__TypeDefinition__ValuesAssignment_3 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1765:1: ( ( ( rule__TypeDefinition__ValuesAssignment_3 ) ) ( ( rule__TypeDefinition__ValuesAssignment_3 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1765:1: ( ( ( rule__TypeDefinition__ValuesAssignment_3 ) ) ( ( rule__TypeDefinition__ValuesAssignment_3 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1766:1: ( ( rule__TypeDefinition__ValuesAssignment_3 ) ) ( ( rule__TypeDefinition__ValuesAssignment_3 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1766:1: ( ( rule__TypeDefinition__ValuesAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1767:1: ( rule__TypeDefinition__ValuesAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getValuesAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1768:1: ( rule__TypeDefinition__ValuesAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1768:2: rule__TypeDefinition__ValuesAssignment_3
            {
            pushFollow(FOLLOW_rule__TypeDefinition__ValuesAssignment_3_in_rule__TypeDefinition__Group__3__Impl3670);
            rule__TypeDefinition__ValuesAssignment_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeDefinitionAccess().getValuesAssignment_3()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1771:1: ( ( rule__TypeDefinition__ValuesAssignment_3 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1772:1: ( rule__TypeDefinition__ValuesAssignment_3 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getValuesAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1773:1: ( rule__TypeDefinition__ValuesAssignment_3 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_NEWLINE) ) {
                    int LA17_2 = input.LA(2);

                    if ( (LA17_2==RULE_MODULE_ID) ) {
                        int LA17_4 = input.LA(3);

                        if ( (LA17_4==EOF||(LA17_4>=RULE_NEWLINE && LA17_4<=RULE_IA5STRING)||(LA17_4>=RULE_MODULE_ID && LA17_4<=RULE_PARAMETER)||LA17_4==22||(LA17_4>=28 && LA17_4<=29)||LA17_4==33||LA17_4==36||(LA17_4>=38 && LA17_4<=39)) ) {
                            alt17=1;
                        }


                    }
                    else if ( (LA17_2==RULE_IA5STRING||LA17_2==RULE_PARAMETER||LA17_2==22||LA17_2==29||LA17_2==33||LA17_2==36||(LA17_2>=38 && LA17_2<=39)) ) {
                        alt17=1;
                    }


                }
                else if ( (LA17_0==RULE_IA5STRING||(LA17_0>=RULE_MODULE_ID && LA17_0<=RULE_PARAMETER)||LA17_0==22||LA17_0==29||LA17_0==33||LA17_0==36||(LA17_0>=38 && LA17_0<=39)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1773:2: rule__TypeDefinition__ValuesAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__TypeDefinition__ValuesAssignment_3_in_rule__TypeDefinition__Group__3__Impl3682);
            	    rule__TypeDefinition__ValuesAssignment_3();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1792:1: rule__Macro__Group__0 : rule__Macro__Group__0__Impl rule__Macro__Group__1 ;
    public final void rule__Macro__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1796:1: ( rule__Macro__Group__0__Impl rule__Macro__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1797:2: rule__Macro__Group__0__Impl rule__Macro__Group__1
            {
            pushFollow(FOLLOW_rule__Macro__Group__0__Impl_in_rule__Macro__Group__03723);
            rule__Macro__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__1_in_rule__Macro__Group__03726);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1804:1: rule__Macro__Group__0__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__Macro__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1808:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1809:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1809:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1810:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1810:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1811:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1812:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1812:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__0__Impl3756); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1815:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1816:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1817:1: ( RULE_NEWLINE )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_NEWLINE) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1817:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__0__Impl3769); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1828:1: rule__Macro__Group__1 : rule__Macro__Group__1__Impl rule__Macro__Group__2 ;
    public final void rule__Macro__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1832:1: ( rule__Macro__Group__1__Impl rule__Macro__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1833:2: rule__Macro__Group__1__Impl rule__Macro__Group__2
            {
            pushFollow(FOLLOW_rule__Macro__Group__1__Impl_in_rule__Macro__Group__13802);
            rule__Macro__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__2_in_rule__Macro__Group__13805);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1840:1: rule__Macro__Group__1__Impl : ( ( rule__Macro__NameAssignment_1 ) ) ;
    public final void rule__Macro__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1844:1: ( ( ( rule__Macro__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1845:1: ( ( rule__Macro__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1845:1: ( ( rule__Macro__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1846:1: ( rule__Macro__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1847:1: ( rule__Macro__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1847:2: rule__Macro__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Macro__NameAssignment_1_in_rule__Macro__Group__1__Impl3832);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1857:1: rule__Macro__Group__2 : rule__Macro__Group__2__Impl rule__Macro__Group__3 ;
    public final void rule__Macro__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1861:1: ( rule__Macro__Group__2__Impl rule__Macro__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1862:2: rule__Macro__Group__2__Impl rule__Macro__Group__3
            {
            pushFollow(FOLLOW_rule__Macro__Group__2__Impl_in_rule__Macro__Group__23862);
            rule__Macro__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__3_in_rule__Macro__Group__23865);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1869:1: rule__Macro__Group__2__Impl : ( 'MACRO' ) ;
    public final void rule__Macro__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1873:1: ( ( 'MACRO' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1874:1: ( 'MACRO' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1874:1: ( 'MACRO' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1875:1: 'MACRO'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getMACROKeyword_2()); 
            }
            match(input,25,FOLLOW_25_in_rule__Macro__Group__2__Impl3893); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1888:1: rule__Macro__Group__3 : rule__Macro__Group__3__Impl rule__Macro__Group__4 ;
    public final void rule__Macro__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1892:1: ( rule__Macro__Group__3__Impl rule__Macro__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1893:2: rule__Macro__Group__3__Impl rule__Macro__Group__4
            {
            pushFollow(FOLLOW_rule__Macro__Group__3__Impl_in_rule__Macro__Group__33924);
            rule__Macro__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__4_in_rule__Macro__Group__33927);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1900:1: rule__Macro__Group__3__Impl : ( '::=' ) ;
    public final void rule__Macro__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1904:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1905:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1905:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1906:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_3()); 
            }
            match(input,19,FOLLOW_19_in_rule__Macro__Group__3__Impl3955); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1919:1: rule__Macro__Group__4 : rule__Macro__Group__4__Impl rule__Macro__Group__5 ;
    public final void rule__Macro__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1923:1: ( rule__Macro__Group__4__Impl rule__Macro__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1924:2: rule__Macro__Group__4__Impl rule__Macro__Group__5
            {
            pushFollow(FOLLOW_rule__Macro__Group__4__Impl_in_rule__Macro__Group__43986);
            rule__Macro__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__5_in_rule__Macro__Group__43989);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1931:1: rule__Macro__Group__4__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Macro__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1935:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1936:1: ( RULE_NEWLINE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1936:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1937:1: RULE_NEWLINE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_4()); 
            }
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__4__Impl4016); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1948:1: rule__Macro__Group__5 : rule__Macro__Group__5__Impl rule__Macro__Group__6 ;
    public final void rule__Macro__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1952:1: ( rule__Macro__Group__5__Impl rule__Macro__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1953:2: rule__Macro__Group__5__Impl rule__Macro__Group__6
            {
            pushFollow(FOLLOW_rule__Macro__Group__5__Impl_in_rule__Macro__Group__54045);
            rule__Macro__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__6_in_rule__Macro__Group__54048);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1960:1: rule__Macro__Group__5__Impl : ( 'BEGIN' ) ;
    public final void rule__Macro__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1964:1: ( ( 'BEGIN' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1965:1: ( 'BEGIN' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1965:1: ( 'BEGIN' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1966:1: 'BEGIN'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getBEGINKeyword_5()); 
            }
            match(input,20,FOLLOW_20_in_rule__Macro__Group__5__Impl4076); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1979:1: rule__Macro__Group__6 : rule__Macro__Group__6__Impl rule__Macro__Group__7 ;
    public final void rule__Macro__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1983:1: ( rule__Macro__Group__6__Impl rule__Macro__Group__7 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1984:2: rule__Macro__Group__6__Impl rule__Macro__Group__7
            {
            pushFollow(FOLLOW_rule__Macro__Group__6__Impl_in_rule__Macro__Group__64107);
            rule__Macro__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__7_in_rule__Macro__Group__64110);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1991:1: rule__Macro__Group__6__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__Macro__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1995:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1996:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1996:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1997:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1997:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1998:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_6()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1999:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:1999:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__6__Impl4140); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_6()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2002:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2003:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_6()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2004:1: ( RULE_NEWLINE )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_NEWLINE) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2004:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__6__Impl4153); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_6()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2015:1: rule__Macro__Group__7 : rule__Macro__Group__7__Impl rule__Macro__Group__8 ;
    public final void rule__Macro__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2019:1: ( rule__Macro__Group__7__Impl rule__Macro__Group__8 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2020:2: rule__Macro__Group__7__Impl rule__Macro__Group__8
            {
            pushFollow(FOLLOW_rule__Macro__Group__7__Impl_in_rule__Macro__Group__74186);
            rule__Macro__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__8_in_rule__Macro__Group__74189);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2027:1: rule__Macro__Group__7__Impl : ( 'TYPE NOTATION' ) ;
    public final void rule__Macro__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2031:1: ( ( 'TYPE NOTATION' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2032:1: ( 'TYPE NOTATION' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2032:1: ( 'TYPE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2033:1: 'TYPE NOTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTYPENOTATIONKeyword_7()); 
            }
            match(input,26,FOLLOW_26_in_rule__Macro__Group__7__Impl4217); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2046:1: rule__Macro__Group__8 : rule__Macro__Group__8__Impl rule__Macro__Group__9 ;
    public final void rule__Macro__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2050:1: ( rule__Macro__Group__8__Impl rule__Macro__Group__9 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2051:2: rule__Macro__Group__8__Impl rule__Macro__Group__9
            {
            pushFollow(FOLLOW_rule__Macro__Group__8__Impl_in_rule__Macro__Group__84248);
            rule__Macro__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__9_in_rule__Macro__Group__84251);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2058:1: rule__Macro__Group__8__Impl : ( '::=' ) ;
    public final void rule__Macro__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2062:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2063:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2063:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2064:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_8()); 
            }
            match(input,19,FOLLOW_19_in_rule__Macro__Group__8__Impl4279); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2077:1: rule__Macro__Group__9 : rule__Macro__Group__9__Impl rule__Macro__Group__10 ;
    public final void rule__Macro__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2081:1: ( rule__Macro__Group__9__Impl rule__Macro__Group__10 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2082:2: rule__Macro__Group__9__Impl rule__Macro__Group__10
            {
            pushFollow(FOLLOW_rule__Macro__Group__9__Impl_in_rule__Macro__Group__94310);
            rule__Macro__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__10_in_rule__Macro__Group__94313);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2089:1: rule__Macro__Group__9__Impl : ( ( ( rule__Macro__TypeNotationsAssignment_9 ) ) ( ( rule__Macro__TypeNotationsAssignment_9 )* ) ) ;
    public final void rule__Macro__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2093:1: ( ( ( ( rule__Macro__TypeNotationsAssignment_9 ) ) ( ( rule__Macro__TypeNotationsAssignment_9 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2094:1: ( ( ( rule__Macro__TypeNotationsAssignment_9 ) ) ( ( rule__Macro__TypeNotationsAssignment_9 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2094:1: ( ( ( rule__Macro__TypeNotationsAssignment_9 ) ) ( ( rule__Macro__TypeNotationsAssignment_9 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2095:1: ( ( rule__Macro__TypeNotationsAssignment_9 ) ) ( ( rule__Macro__TypeNotationsAssignment_9 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2095:1: ( ( rule__Macro__TypeNotationsAssignment_9 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2096:1: ( rule__Macro__TypeNotationsAssignment_9 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTypeNotationsAssignment_9()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2097:1: ( rule__Macro__TypeNotationsAssignment_9 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2097:2: rule__Macro__TypeNotationsAssignment_9
            {
            pushFollow(FOLLOW_rule__Macro__TypeNotationsAssignment_9_in_rule__Macro__Group__9__Impl4342);
            rule__Macro__TypeNotationsAssignment_9();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getTypeNotationsAssignment_9()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2100:1: ( ( rule__Macro__TypeNotationsAssignment_9 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2101:1: ( rule__Macro__TypeNotationsAssignment_9 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTypeNotationsAssignment_9()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2102:1: ( rule__Macro__TypeNotationsAssignment_9 )*
            loop20:
            do {
                int alt20=2;
                alt20 = dfa20.predict(input);
                switch (alt20) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2102:2: rule__Macro__TypeNotationsAssignment_9
            	    {
            	    pushFollow(FOLLOW_rule__Macro__TypeNotationsAssignment_9_in_rule__Macro__Group__9__Impl4354);
            	    rule__Macro__TypeNotationsAssignment_9();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2113:1: rule__Macro__Group__10 : rule__Macro__Group__10__Impl rule__Macro__Group__11 ;
    public final void rule__Macro__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2117:1: ( rule__Macro__Group__10__Impl rule__Macro__Group__11 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2118:2: rule__Macro__Group__10__Impl rule__Macro__Group__11
            {
            pushFollow(FOLLOW_rule__Macro__Group__10__Impl_in_rule__Macro__Group__104387);
            rule__Macro__Group__10__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__11_in_rule__Macro__Group__104390);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2125:1: rule__Macro__Group__10__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__Macro__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2129:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2130:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2130:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2131:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2131:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2132:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_10()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2133:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2133:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__10__Impl4420); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_10()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2136:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2137:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_10()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2138:1: ( RULE_NEWLINE )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_NEWLINE) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2138:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__10__Impl4433); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_10()); 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2149:1: rule__Macro__Group__11 : rule__Macro__Group__11__Impl rule__Macro__Group__12 ;
    public final void rule__Macro__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2153:1: ( rule__Macro__Group__11__Impl rule__Macro__Group__12 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2154:2: rule__Macro__Group__11__Impl rule__Macro__Group__12
            {
            pushFollow(FOLLOW_rule__Macro__Group__11__Impl_in_rule__Macro__Group__114466);
            rule__Macro__Group__11__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__12_in_rule__Macro__Group__114469);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2161:1: rule__Macro__Group__11__Impl : ( 'VALUE NOTATION' ) ;
    public final void rule__Macro__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2165:1: ( ( 'VALUE NOTATION' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2166:1: ( 'VALUE NOTATION' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2166:1: ( 'VALUE NOTATION' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2167:1: 'VALUE NOTATION'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getVALUENOTATIONKeyword_11()); 
            }
            match(input,27,FOLLOW_27_in_rule__Macro__Group__11__Impl4497); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2180:1: rule__Macro__Group__12 : rule__Macro__Group__12__Impl rule__Macro__Group__13 ;
    public final void rule__Macro__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2184:1: ( rule__Macro__Group__12__Impl rule__Macro__Group__13 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2185:2: rule__Macro__Group__12__Impl rule__Macro__Group__13
            {
            pushFollow(FOLLOW_rule__Macro__Group__12__Impl_in_rule__Macro__Group__124528);
            rule__Macro__Group__12__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__13_in_rule__Macro__Group__124531);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2192:1: rule__Macro__Group__12__Impl : ( '::=' ) ;
    public final void rule__Macro__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2196:1: ( ( '::=' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2197:1: ( '::=' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2197:1: ( '::=' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2198:1: '::='
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getColonColonEqualsSignKeyword_12()); 
            }
            match(input,19,FOLLOW_19_in_rule__Macro__Group__12__Impl4559); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2211:1: rule__Macro__Group__13 : rule__Macro__Group__13__Impl rule__Macro__Group__14 ;
    public final void rule__Macro__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2215:1: ( rule__Macro__Group__13__Impl rule__Macro__Group__14 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2216:2: rule__Macro__Group__13__Impl rule__Macro__Group__14
            {
            pushFollow(FOLLOW_rule__Macro__Group__13__Impl_in_rule__Macro__Group__134590);
            rule__Macro__Group__13__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__14_in_rule__Macro__Group__134593);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2223:1: rule__Macro__Group__13__Impl : ( ( RULE_NEWLINE )? ) ;
    public final void rule__Macro__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2227:1: ( ( ( RULE_NEWLINE )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2228:1: ( ( RULE_NEWLINE )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2228:1: ( ( RULE_NEWLINE )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2229:1: ( RULE_NEWLINE )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_13()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2230:1: ( RULE_NEWLINE )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_NEWLINE) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2230:3: RULE_NEWLINE
                    {
                    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__13__Impl4621); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_13()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2240:1: rule__Macro__Group__14 : rule__Macro__Group__14__Impl rule__Macro__Group__15 ;
    public final void rule__Macro__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2244:1: ( rule__Macro__Group__14__Impl rule__Macro__Group__15 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2245:2: rule__Macro__Group__14__Impl rule__Macro__Group__15
            {
            pushFollow(FOLLOW_rule__Macro__Group__14__Impl_in_rule__Macro__Group__144652);
            rule__Macro__Group__14__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__15_in_rule__Macro__Group__144655);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2252:1: rule__Macro__Group__14__Impl : ( ( rule__Macro__ValueNotationAssignment_14 ) ) ;
    public final void rule__Macro__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2256:1: ( ( ( rule__Macro__ValueNotationAssignment_14 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2257:1: ( ( rule__Macro__ValueNotationAssignment_14 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2257:1: ( ( rule__Macro__ValueNotationAssignment_14 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2258:1: ( rule__Macro__ValueNotationAssignment_14 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getValueNotationAssignment_14()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2259:1: ( rule__Macro__ValueNotationAssignment_14 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2259:2: rule__Macro__ValueNotationAssignment_14
            {
            pushFollow(FOLLOW_rule__Macro__ValueNotationAssignment_14_in_rule__Macro__Group__14__Impl4682);
            rule__Macro__ValueNotationAssignment_14();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getValueNotationAssignment_14()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2269:1: rule__Macro__Group__15 : rule__Macro__Group__15__Impl rule__Macro__Group__16 ;
    public final void rule__Macro__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2273:1: ( rule__Macro__Group__15__Impl rule__Macro__Group__16 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2274:2: rule__Macro__Group__15__Impl rule__Macro__Group__16
            {
            pushFollow(FOLLOW_rule__Macro__Group__15__Impl_in_rule__Macro__Group__154712);
            rule__Macro__Group__15__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__16_in_rule__Macro__Group__154715);
            rule__Macro__Group__16();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2281:1: rule__Macro__Group__15__Impl : ( ( ( rule__Macro__InnerTypesAssignment_15 ) ) ( ( rule__Macro__InnerTypesAssignment_15 )* ) ) ;
    public final void rule__Macro__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2285:1: ( ( ( ( rule__Macro__InnerTypesAssignment_15 ) ) ( ( rule__Macro__InnerTypesAssignment_15 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2286:1: ( ( ( rule__Macro__InnerTypesAssignment_15 ) ) ( ( rule__Macro__InnerTypesAssignment_15 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2286:1: ( ( ( rule__Macro__InnerTypesAssignment_15 ) ) ( ( rule__Macro__InnerTypesAssignment_15 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2287:1: ( ( rule__Macro__InnerTypesAssignment_15 ) ) ( ( rule__Macro__InnerTypesAssignment_15 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2287:1: ( ( rule__Macro__InnerTypesAssignment_15 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2288:1: ( rule__Macro__InnerTypesAssignment_15 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesAssignment_15()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2289:1: ( rule__Macro__InnerTypesAssignment_15 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2289:2: rule__Macro__InnerTypesAssignment_15
            {
            pushFollow(FOLLOW_rule__Macro__InnerTypesAssignment_15_in_rule__Macro__Group__15__Impl4744);
            rule__Macro__InnerTypesAssignment_15();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesAssignment_15()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2292:1: ( ( rule__Macro__InnerTypesAssignment_15 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2293:1: ( rule__Macro__InnerTypesAssignment_15 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesAssignment_15()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2294:1: ( rule__Macro__InnerTypesAssignment_15 )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2294:2: rule__Macro__InnerTypesAssignment_15
            	    {
            	    pushFollow(FOLLOW_rule__Macro__InnerTypesAssignment_15_in_rule__Macro__Group__15__Impl4756);
            	    rule__Macro__InnerTypesAssignment_15();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesAssignment_15()); 
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
    // $ANTLR end "rule__Macro__Group__15__Impl"


    // $ANTLR start "rule__Macro__Group__16"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2305:1: rule__Macro__Group__16 : rule__Macro__Group__16__Impl rule__Macro__Group__17 ;
    public final void rule__Macro__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2309:1: ( rule__Macro__Group__16__Impl rule__Macro__Group__17 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2310:2: rule__Macro__Group__16__Impl rule__Macro__Group__17
            {
            pushFollow(FOLLOW_rule__Macro__Group__16__Impl_in_rule__Macro__Group__164789);
            rule__Macro__Group__16__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Macro__Group__17_in_rule__Macro__Group__164792);
            rule__Macro__Group__17();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__16"


    // $ANTLR start "rule__Macro__Group__16__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2317:1: rule__Macro__Group__16__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__Macro__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2321:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2322:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2322:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2323:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2323:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2324:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_16()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2325:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2325:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__16__Impl4822); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_16()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2328:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2329:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_16()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2330:1: ( RULE_NEWLINE )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_NEWLINE) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2330:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__16__Impl4835); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_16()); 
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
    // $ANTLR end "rule__Macro__Group__16__Impl"


    // $ANTLR start "rule__Macro__Group__17"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2341:1: rule__Macro__Group__17 : rule__Macro__Group__17__Impl ;
    public final void rule__Macro__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2345:1: ( rule__Macro__Group__17__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2346:2: rule__Macro__Group__17__Impl
            {
            pushFollow(FOLLOW_rule__Macro__Group__17__Impl_in_rule__Macro__Group__174868);
            rule__Macro__Group__17__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__17"


    // $ANTLR start "rule__Macro__Group__17__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2352:1: rule__Macro__Group__17__Impl : ( 'END' ) ;
    public final void rule__Macro__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2356:1: ( ( 'END' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2357:1: ( 'END' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2357:1: ( 'END' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2358:1: 'END'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getENDKeyword_17()); 
            }
            match(input,21,FOLLOW_21_in_rule__Macro__Group__17__Impl4896); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getENDKeyword_17()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__17__Impl"


    // $ANTLR start "rule__TypeAssignment__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2407:1: rule__TypeAssignment__Group__0 : rule__TypeAssignment__Group__0__Impl rule__TypeAssignment__Group__1 ;
    public final void rule__TypeAssignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2411:1: ( rule__TypeAssignment__Group__0__Impl rule__TypeAssignment__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2412:2: rule__TypeAssignment__Group__0__Impl rule__TypeAssignment__Group__1
            {
            pushFollow(FOLLOW_rule__TypeAssignment__Group__0__Impl_in_rule__TypeAssignment__Group__04963);
            rule__TypeAssignment__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeAssignment__Group__1_in_rule__TypeAssignment__Group__04966);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2419:1: rule__TypeAssignment__Group__0__Impl : ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) ;
    public final void rule__TypeAssignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2423:1: ( ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2424:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2424:1: ( ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2425:1: ( ( RULE_NEWLINE ) ) ( ( RULE_NEWLINE )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2425:1: ( ( RULE_NEWLINE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2426:1: ( RULE_NEWLINE )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2427:1: ( RULE_NEWLINE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2427:3: RULE_NEWLINE
            {
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__TypeAssignment__Group__0__Impl4996); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2430:1: ( ( RULE_NEWLINE )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2431:1: ( RULE_NEWLINE )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2432:1: ( RULE_NEWLINE )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_NEWLINE) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2432:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__TypeAssignment__Group__0__Impl5009); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2443:1: rule__TypeAssignment__Group__1 : rule__TypeAssignment__Group__1__Impl ;
    public final void rule__TypeAssignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2447:1: ( rule__TypeAssignment__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2448:2: rule__TypeAssignment__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeAssignment__Group__1__Impl_in_rule__TypeAssignment__Group__15042);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2454:1: rule__TypeAssignment__Group__1__Impl : ( ( rule__TypeAssignment__Alternatives_1 ) ) ;
    public final void rule__TypeAssignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2458:1: ( ( ( rule__TypeAssignment__Alternatives_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2459:1: ( ( rule__TypeAssignment__Alternatives_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2459:1: ( ( rule__TypeAssignment__Alternatives_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2460:1: ( rule__TypeAssignment__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeAssignmentAccess().getAlternatives_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2461:1: ( rule__TypeAssignment__Alternatives_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2461:2: rule__TypeAssignment__Alternatives_1
            {
            pushFollow(FOLLOW_rule__TypeAssignment__Alternatives_1_in_rule__TypeAssignment__Group__1__Impl5069);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2475:1: rule__ParamAssignment__Group__0 : rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1 ;
    public final void rule__ParamAssignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2479:1: ( rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2480:2: rule__ParamAssignment__Group__0__Impl rule__ParamAssignment__Group__1
            {
            pushFollow(FOLLOW_rule__ParamAssignment__Group__0__Impl_in_rule__ParamAssignment__Group__05103);
            rule__ParamAssignment__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ParamAssignment__Group__1_in_rule__ParamAssignment__Group__05106);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2487:1: rule__ParamAssignment__Group__0__Impl : ( ( rule__ParamAssignment__ParamAssignment_0 ) ) ;
    public final void rule__ParamAssignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2491:1: ( ( ( rule__ParamAssignment__ParamAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2492:1: ( ( rule__ParamAssignment__ParamAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2492:1: ( ( rule__ParamAssignment__ParamAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2493:1: ( rule__ParamAssignment__ParamAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getParamAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2494:1: ( rule__ParamAssignment__ParamAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2494:2: rule__ParamAssignment__ParamAssignment_0
            {
            pushFollow(FOLLOW_rule__ParamAssignment__ParamAssignment_0_in_rule__ParamAssignment__Group__0__Impl5133);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2504:1: rule__ParamAssignment__Group__1 : rule__ParamAssignment__Group__1__Impl ;
    public final void rule__ParamAssignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2508:1: ( rule__ParamAssignment__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2509:2: rule__ParamAssignment__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParamAssignment__Group__1__Impl_in_rule__ParamAssignment__Group__15163);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2515:1: rule__ParamAssignment__Group__1__Impl : ( ( rule__ParamAssignment__RightAssignment_1 ) ) ;
    public final void rule__ParamAssignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2519:1: ( ( ( rule__ParamAssignment__RightAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2520:1: ( ( rule__ParamAssignment__RightAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2520:1: ( ( rule__ParamAssignment__RightAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2521:1: ( rule__ParamAssignment__RightAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getRightAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2522:1: ( rule__ParamAssignment__RightAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2522:2: rule__ParamAssignment__RightAssignment_1
            {
            pushFollow(FOLLOW_rule__ParamAssignment__RightAssignment_1_in_rule__ParamAssignment__Group__1__Impl5190);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2536:1: rule__TypeReferenceExt__Group__0 : rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1 ;
    public final void rule__TypeReferenceExt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2540:1: ( rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2541:2: rule__TypeReferenceExt__Group__0__Impl rule__TypeReferenceExt__Group__1
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__0__Impl_in_rule__TypeReferenceExt__Group__05224);
            rule__TypeReferenceExt__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__1_in_rule__TypeReferenceExt__Group__05227);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2548:1: rule__TypeReferenceExt__Group__0__Impl : ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) ) ;
    public final void rule__TypeReferenceExt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2552:1: ( ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2553:1: ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2553:1: ( ( rule__TypeReferenceExt__ParentRefAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2554:1: ( rule__TypeReferenceExt__ParentRefAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getParentRefAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2555:1: ( rule__TypeReferenceExt__ParentRefAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2555:2: rule__TypeReferenceExt__ParentRefAssignment_0
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__ParentRefAssignment_0_in_rule__TypeReferenceExt__Group__0__Impl5254);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2565:1: rule__TypeReferenceExt__Group__1 : rule__TypeReferenceExt__Group__1__Impl ;
    public final void rule__TypeReferenceExt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2569:1: ( rule__TypeReferenceExt__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2570:2: rule__TypeReferenceExt__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__TypeReferenceExt__Group__1__Impl_in_rule__TypeReferenceExt__Group__15284);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2576:1: rule__TypeReferenceExt__Group__1__Impl : ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? ) ;
    public final void rule__TypeReferenceExt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2580:1: ( ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2581:1: ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2581:1: ( ( rule__TypeReferenceExt__ChildRefAssignment_1 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2582:1: ( rule__TypeReferenceExt__ChildRefAssignment_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getChildRefAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2583:1: ( rule__TypeReferenceExt__ChildRefAssignment_1 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_MODULE_ID) ) {
                int LA26_1 = input.LA(2);

                if ( (synpred33_InternalSmi()) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2583:2: rule__TypeReferenceExt__ChildRefAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_rule__TypeReferenceExt__Group__1__Impl5311);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2597:1: rule__Value__Group__0 : rule__Value__Group__0__Impl rule__Value__Group__1 ;
    public final void rule__Value__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2601:1: ( rule__Value__Group__0__Impl rule__Value__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2602:2: rule__Value__Group__0__Impl rule__Value__Group__1
            {
            pushFollow(FOLLOW_rule__Value__Group__0__Impl_in_rule__Value__Group__05346);
            rule__Value__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group__1_in_rule__Value__Group__05349);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2609:1: rule__Value__Group__0__Impl : ( ( RULE_NEWLINE )? ) ;
    public final void rule__Value__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2613:1: ( ( ( RULE_NEWLINE )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2614:1: ( ( RULE_NEWLINE )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2614:1: ( ( RULE_NEWLINE )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2615:1: ( RULE_NEWLINE )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2616:1: ( RULE_NEWLINE )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_NEWLINE) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2616:3: RULE_NEWLINE
                    {
                    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Value__Group__0__Impl5377); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_0()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2626:1: rule__Value__Group__1 : rule__Value__Group__1__Impl rule__Value__Group__2 ;
    public final void rule__Value__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2630:1: ( rule__Value__Group__1__Impl rule__Value__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2631:2: rule__Value__Group__1__Impl rule__Value__Group__2
            {
            pushFollow(FOLLOW_rule__Value__Group__1__Impl_in_rule__Value__Group__15408);
            rule__Value__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group__2_in_rule__Value__Group__15411);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2638:1: rule__Value__Group__1__Impl : ( ( rule__Value__ValueTypesAssignment_1 ) ) ;
    public final void rule__Value__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2642:1: ( ( ( rule__Value__ValueTypesAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2643:1: ( ( rule__Value__ValueTypesAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2643:1: ( ( rule__Value__ValueTypesAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2644:1: ( rule__Value__ValueTypesAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2645:1: ( rule__Value__ValueTypesAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2645:2: rule__Value__ValueTypesAssignment_1
            {
            pushFollow(FOLLOW_rule__Value__ValueTypesAssignment_1_in_rule__Value__Group__1__Impl5438);
            rule__Value__ValueTypesAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesAssignment_1()); 
            }

            }


            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2655:1: rule__Value__Group__2 : rule__Value__Group__2__Impl ;
    public final void rule__Value__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2659:1: ( rule__Value__Group__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2660:2: rule__Value__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group__2__Impl_in_rule__Value__Group__25468);
            rule__Value__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2666:1: rule__Value__Group__2__Impl : ( ( rule__Value__Group_2__0 )* ) ;
    public final void rule__Value__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2670:1: ( ( ( rule__Value__Group_2__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2671:1: ( ( rule__Value__Group_2__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2671:1: ( ( rule__Value__Group_2__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2672:1: ( rule__Value__Group_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getGroup_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2673:1: ( rule__Value__Group_2__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_NEWLINE) ) {
                    int LA28_2 = input.LA(2);

                    if ( (LA28_2==28) ) {
                        alt28=1;
                    }


                }
                else if ( (LA28_0==28) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2673:2: rule__Value__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Value__Group_2__0_in_rule__Value__Group__2__Impl5495);
            	    rule__Value__Group_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getGroup_2()); 
            }

            }


            }

        }
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


    // $ANTLR start "rule__Value__Group_2__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2689:1: rule__Value__Group_2__0 : rule__Value__Group_2__0__Impl rule__Value__Group_2__1 ;
    public final void rule__Value__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2693:1: ( rule__Value__Group_2__0__Impl rule__Value__Group_2__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2694:2: rule__Value__Group_2__0__Impl rule__Value__Group_2__1
            {
            pushFollow(FOLLOW_rule__Value__Group_2__0__Impl_in_rule__Value__Group_2__05532);
            rule__Value__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group_2__1_in_rule__Value__Group_2__05535);
            rule__Value__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__0"


    // $ANTLR start "rule__Value__Group_2__0__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2701:1: rule__Value__Group_2__0__Impl : ( ( RULE_NEWLINE )? ) ;
    public final void rule__Value__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2705:1: ( ( ( RULE_NEWLINE )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2706:1: ( ( RULE_NEWLINE )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2706:1: ( ( RULE_NEWLINE )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2707:1: ( RULE_NEWLINE )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_2_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2708:1: ( RULE_NEWLINE )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_NEWLINE) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2708:3: RULE_NEWLINE
                    {
                    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Value__Group_2__0__Impl5563); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__0__Impl"


    // $ANTLR start "rule__Value__Group_2__1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2718:1: rule__Value__Group_2__1 : rule__Value__Group_2__1__Impl rule__Value__Group_2__2 ;
    public final void rule__Value__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2722:1: ( rule__Value__Group_2__1__Impl rule__Value__Group_2__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2723:2: rule__Value__Group_2__1__Impl rule__Value__Group_2__2
            {
            pushFollow(FOLLOW_rule__Value__Group_2__1__Impl_in_rule__Value__Group_2__15594);
            rule__Value__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Value__Group_2__2_in_rule__Value__Group_2__15597);
            rule__Value__Group_2__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__1"


    // $ANTLR start "rule__Value__Group_2__1__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2730:1: rule__Value__Group_2__1__Impl : ( '|' ) ;
    public final void rule__Value__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2734:1: ( ( '|' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2735:1: ( '|' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2735:1: ( '|' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2736:1: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getVerticalLineKeyword_2_1()); 
            }
            match(input,28,FOLLOW_28_in_rule__Value__Group_2__1__Impl5625); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getVerticalLineKeyword_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__1__Impl"


    // $ANTLR start "rule__Value__Group_2__2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2749:1: rule__Value__Group_2__2 : rule__Value__Group_2__2__Impl ;
    public final void rule__Value__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2753:1: ( rule__Value__Group_2__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2754:2: rule__Value__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Value__Group_2__2__Impl_in_rule__Value__Group_2__25656);
            rule__Value__Group_2__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__2"


    // $ANTLR start "rule__Value__Group_2__2__Impl"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2760:1: rule__Value__Group_2__2__Impl : ( ( rule__Value__ValueTypesAssignment_2_2 ) ) ;
    public final void rule__Value__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2764:1: ( ( ( rule__Value__ValueTypesAssignment_2_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2765:1: ( ( rule__Value__ValueTypesAssignment_2_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2765:1: ( ( rule__Value__ValueTypesAssignment_2_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2766:1: ( rule__Value__ValueTypesAssignment_2_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesAssignment_2_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2767:1: ( rule__Value__ValueTypesAssignment_2_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2767:2: rule__Value__ValueTypesAssignment_2_2
            {
            pushFollow(FOLLOW_rule__Value__ValueTypesAssignment_2_2_in_rule__Value__Group_2__2__Impl5683);
            rule__Value__ValueTypesAssignment_2_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesAssignment_2_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Group_2__2__Impl"


    // $ANTLR start "rule__MacroValue__Group__0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2783:1: rule__MacroValue__Group__0 : rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1 ;
    public final void rule__MacroValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2787:1: ( rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2788:2: rule__MacroValue__Group__0__Impl rule__MacroValue__Group__1
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__0__Impl_in_rule__MacroValue__Group__05719);
            rule__MacroValue__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__1_in_rule__MacroValue__Group__05722);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2795:1: rule__MacroValue__Group__0__Impl : ( () ) ;
    public final void rule__MacroValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2799:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2800:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2800:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2801:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getMacroValueAction_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2802:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2804:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2814:1: rule__MacroValue__Group__1 : rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2 ;
    public final void rule__MacroValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2818:1: ( rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2819:2: rule__MacroValue__Group__1__Impl rule__MacroValue__Group__2
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__1__Impl_in_rule__MacroValue__Group__15780);
            rule__MacroValue__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__2_in_rule__MacroValue__Group__15783);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2826:1: rule__MacroValue__Group__1__Impl : ( 'value' ) ;
    public final void rule__MacroValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2830:1: ( ( 'value' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2831:1: ( 'value' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2831:1: ( 'value' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2832:1: 'value'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getValueKeyword_1()); 
            }
            match(input,29,FOLLOW_29_in_rule__MacroValue__Group__1__Impl5811); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2845:1: rule__MacroValue__Group__2 : rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3 ;
    public final void rule__MacroValue__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2849:1: ( rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2850:2: rule__MacroValue__Group__2__Impl rule__MacroValue__Group__3
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__2__Impl_in_rule__MacroValue__Group__25842);
            rule__MacroValue__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__3_in_rule__MacroValue__Group__25845);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2857:1: rule__MacroValue__Group__2__Impl : ( '(' ) ;
    public final void rule__MacroValue__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2861:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2862:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2862:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2863:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,30,FOLLOW_30_in_rule__MacroValue__Group__2__Impl5873); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2876:1: rule__MacroValue__Group__3 : rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4 ;
    public final void rule__MacroValue__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2880:1: ( rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2881:2: rule__MacroValue__Group__3__Impl rule__MacroValue__Group__4
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__3__Impl_in_rule__MacroValue__Group__35904);
            rule__MacroValue__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__MacroValue__Group__4_in_rule__MacroValue__Group__35907);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2888:1: rule__MacroValue__Group__3__Impl : ( ( rule__MacroValue__ValueTypeAssignment_3 ) ) ;
    public final void rule__MacroValue__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2892:1: ( ( ( rule__MacroValue__ValueTypeAssignment_3 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2893:1: ( ( rule__MacroValue__ValueTypeAssignment_3 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2893:1: ( ( rule__MacroValue__ValueTypeAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2894:1: ( rule__MacroValue__ValueTypeAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getValueTypeAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2895:1: ( rule__MacroValue__ValueTypeAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2895:2: rule__MacroValue__ValueTypeAssignment_3
            {
            pushFollow(FOLLOW_rule__MacroValue__ValueTypeAssignment_3_in_rule__MacroValue__Group__3__Impl5934);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2905:1: rule__MacroValue__Group__4 : rule__MacroValue__Group__4__Impl ;
    public final void rule__MacroValue__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2909:1: ( rule__MacroValue__Group__4__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2910:2: rule__MacroValue__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__MacroValue__Group__4__Impl_in_rule__MacroValue__Group__45964);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2916:1: rule__MacroValue__Group__4__Impl : ( ')' ) ;
    public final void rule__MacroValue__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2920:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2921:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2921:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2922:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getRightParenthesisKeyword_4()); 
            }
            match(input,31,FOLLOW_31_in_rule__MacroValue__Group__4__Impl5992); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2945:1: rule__UpdateType__Group__0 : rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1 ;
    public final void rule__UpdateType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2949:1: ( rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2950:2: rule__UpdateType__Group__0__Impl rule__UpdateType__Group__1
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__0__Impl_in_rule__UpdateType__Group__06033);
            rule__UpdateType__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__UpdateType__Group__1_in_rule__UpdateType__Group__06036);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2957:1: rule__UpdateType__Group__0__Impl : ( 'Update' ) ;
    public final void rule__UpdateType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2961:1: ( ( 'Update' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2962:1: ( 'Update' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2962:1: ( 'Update' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2963:1: 'Update'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getUpdateKeyword_0()); 
            }
            match(input,32,FOLLOW_32_in_rule__UpdateType__Group__0__Impl6064); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2976:1: rule__UpdateType__Group__1 : rule__UpdateType__Group__1__Impl ;
    public final void rule__UpdateType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2980:1: ( rule__UpdateType__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2981:2: rule__UpdateType__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__UpdateType__Group__1__Impl_in_rule__UpdateType__Group__16095);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2987:1: rule__UpdateType__Group__1__Impl : ( ( rule__UpdateType__TypeAssignment_1 ) ) ;
    public final void rule__UpdateType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2991:1: ( ( ( rule__UpdateType__TypeAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2992:1: ( ( rule__UpdateType__TypeAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2992:1: ( ( rule__UpdateType__TypeAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2993:1: ( rule__UpdateType__TypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getTypeAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2994:1: ( rule__UpdateType__TypeAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2994:2: rule__UpdateType__TypeAssignment_1
            {
            pushFollow(FOLLOW_rule__UpdateType__TypeAssignment_1_in_rule__UpdateType__Group__1__Impl6122);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3008:1: rule__ASN1_SIMPLE__Group_0__0 : rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1 ;
    public final void rule__ASN1_SIMPLE__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3012:1: ( rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3013:2: rule__ASN1_SIMPLE__Group_0__0__Impl rule__ASN1_SIMPLE__Group_0__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__0__Impl_in_rule__ASN1_SIMPLE__Group_0__06156);
            rule__ASN1_SIMPLE__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__1_in_rule__ASN1_SIMPLE__Group_0__06159);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3020:1: rule__ASN1_SIMPLE__Group_0__0__Impl : ( () ) ;
    public final void rule__ASN1_SIMPLE__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3024:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3025:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3025:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3026:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3027:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3029:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3039:1: rule__ASN1_SIMPLE__Group_0__1 : rule__ASN1_SIMPLE__Group_0__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3043:1: ( rule__ASN1_SIMPLE__Group_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3044:2: rule__ASN1_SIMPLE__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_0__1__Impl_in_rule__ASN1_SIMPLE__Group_0__16217);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3050:1: rule__ASN1_SIMPLE__Group_0__1__Impl : ( 'empty' ) ;
    public final void rule__ASN1_SIMPLE__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3054:1: ( ( 'empty' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3055:1: ( 'empty' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3055:1: ( 'empty' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3056:1: 'empty'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1()); 
            }
            match(input,33,FOLLOW_33_in_rule__ASN1_SIMPLE__Group_0__1__Impl6245); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3073:1: rule__ASN1_SIMPLE__Group_1__0 : rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1 ;
    public final void rule__ASN1_SIMPLE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3077:1: ( rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3078:2: rule__ASN1_SIMPLE__Group_1__0__Impl rule__ASN1_SIMPLE__Group_1__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__0__Impl_in_rule__ASN1_SIMPLE__Group_1__06280);
            rule__ASN1_SIMPLE__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__1_in_rule__ASN1_SIMPLE__Group_1__06283);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3085:1: rule__ASN1_SIMPLE__Group_1__0__Impl : ( () ) ;
    public final void rule__ASN1_SIMPLE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3089:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3090:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3090:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3091:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_SIMPLEAction_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3092:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3094:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3104:1: rule__ASN1_SIMPLE__Group_1__1 : rule__ASN1_SIMPLE__Group_1__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3108:1: ( rule__ASN1_SIMPLE__Group_1__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3109:2: rule__ASN1_SIMPLE__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_1__1__Impl_in_rule__ASN1_SIMPLE__Group_1__16341);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3115:1: rule__ASN1_SIMPLE__Group_1__1__Impl : ( RULE_IA5STRING ) ;
    public final void rule__ASN1_SIMPLE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3119:1: ( ( RULE_IA5STRING ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3120:1: ( RULE_IA5STRING )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3120:1: ( RULE_IA5STRING )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3121:1: RULE_IA5STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()); 
            }
            match(input,RULE_IA5STRING,FOLLOW_RULE_IA5STRING_in_rule__ASN1_SIMPLE__Group_1__1__Impl6368); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3136:1: rule__ASN1_SIMPLE__Group_2__0 : rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1 ;
    public final void rule__ASN1_SIMPLE__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3140:1: ( rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3141:2: rule__ASN1_SIMPLE__Group_2__0__Impl rule__ASN1_SIMPLE__Group_2__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__0__Impl_in_rule__ASN1_SIMPLE__Group_2__06401);
            rule__ASN1_SIMPLE__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__1_in_rule__ASN1_SIMPLE__Group_2__06404);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3148:1: rule__ASN1_SIMPLE__Group_2__0__Impl : ( ruleASN1_OCTET_STRING ) ;
    public final void rule__ASN1_SIMPLE__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3152:1: ( ( ruleASN1_OCTET_STRING ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3153:1: ( ruleASN1_OCTET_STRING )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3153:1: ( ruleASN1_OCTET_STRING )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3154:1: ruleASN1_OCTET_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_OCTET_STRINGParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_OCTET_STRING_in_rule__ASN1_SIMPLE__Group_2__0__Impl6431);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3165:1: rule__ASN1_SIMPLE__Group_2__1 : rule__ASN1_SIMPLE__Group_2__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3169:1: ( rule__ASN1_SIMPLE__Group_2__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3170:2: rule__ASN1_SIMPLE__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_2__1__Impl_in_rule__ASN1_SIMPLE__Group_2__16460);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3176:1: rule__ASN1_SIMPLE__Group_2__1__Impl : ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? ) ;
    public final void rule__ASN1_SIMPLE__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3180:1: ( ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3181:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3181:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3182:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_2_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3183:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_2_1 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==30) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3183:2: rule__ASN1_SIMPLE__ConstraintAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_in_rule__ASN1_SIMPLE__Group_2__1__Impl6487);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3197:1: rule__ASN1_SIMPLE__Group_3__0 : rule__ASN1_SIMPLE__Group_3__0__Impl rule__ASN1_SIMPLE__Group_3__1 ;
    public final void rule__ASN1_SIMPLE__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3201:1: ( rule__ASN1_SIMPLE__Group_3__0__Impl rule__ASN1_SIMPLE__Group_3__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3202:2: rule__ASN1_SIMPLE__Group_3__0__Impl rule__ASN1_SIMPLE__Group_3__1
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__0__Impl_in_rule__ASN1_SIMPLE__Group_3__06522);
            rule__ASN1_SIMPLE__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__1_in_rule__ASN1_SIMPLE__Group_3__06525);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3209:1: rule__ASN1_SIMPLE__Group_3__0__Impl : ( ruleASN1_INTEGER ) ;
    public final void rule__ASN1_SIMPLE__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3213:1: ( ( ruleASN1_INTEGER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3214:1: ( ruleASN1_INTEGER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3214:1: ( ruleASN1_INTEGER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3215:1: ruleASN1_INTEGER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getASN1_INTEGERParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_INTEGER_in_rule__ASN1_SIMPLE__Group_3__0__Impl6552);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3226:1: rule__ASN1_SIMPLE__Group_3__1 : rule__ASN1_SIMPLE__Group_3__1__Impl ;
    public final void rule__ASN1_SIMPLE__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3230:1: ( rule__ASN1_SIMPLE__Group_3__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3231:2: rule__ASN1_SIMPLE__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SIMPLE__Group_3__1__Impl_in_rule__ASN1_SIMPLE__Group_3__16581);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3237:1: rule__ASN1_SIMPLE__Group_3__1__Impl : ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? ) ;
    public final void rule__ASN1_SIMPLE__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3241:1: ( ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3242:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3242:1: ( ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3243:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintAssignment_3_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3244:1: ( rule__ASN1_SIMPLE__ConstraintAssignment_3_1 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_INT) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3244:2: rule__ASN1_SIMPLE__ConstraintAssignment_3_1
                    {
                    pushFollow(FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_3_1_in_rule__ASN1_SIMPLE__Group_3__1__Impl6608);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3258:1: rule__ASN1_OCTET_STRING__Group__0 : rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1 ;
    public final void rule__ASN1_OCTET_STRING__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3262:1: ( rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3263:2: rule__ASN1_OCTET_STRING__Group__0__Impl rule__ASN1_OCTET_STRING__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__0__Impl_in_rule__ASN1_OCTET_STRING__Group__06643);
            rule__ASN1_OCTET_STRING__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__1_in_rule__ASN1_OCTET_STRING__Group__06646);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3270:1: rule__ASN1_OCTET_STRING__Group__0__Impl : ( () ) ;
    public final void rule__ASN1_OCTET_STRING__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3274:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3275:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3275:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3276:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getASN1_OCTET_STRINGAction_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3277:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3279:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3289:1: rule__ASN1_OCTET_STRING__Group__1 : rule__ASN1_OCTET_STRING__Group__1__Impl ;
    public final void rule__ASN1_OCTET_STRING__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3293:1: ( rule__ASN1_OCTET_STRING__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3294:2: rule__ASN1_OCTET_STRING__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__Group__1__Impl_in_rule__ASN1_OCTET_STRING__Group__16704);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3300:1: rule__ASN1_OCTET_STRING__Group__1__Impl : ( ( rule__ASN1_OCTET_STRING__NameAssignment_1 ) ) ;
    public final void rule__ASN1_OCTET_STRING__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3304:1: ( ( ( rule__ASN1_OCTET_STRING__NameAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3305:1: ( ( rule__ASN1_OCTET_STRING__NameAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3305:1: ( ( rule__ASN1_OCTET_STRING__NameAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3306:1: ( rule__ASN1_OCTET_STRING__NameAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getNameAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3307:1: ( rule__ASN1_OCTET_STRING__NameAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3307:2: rule__ASN1_OCTET_STRING__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ASN1_OCTET_STRING__NameAssignment_1_in_rule__ASN1_OCTET_STRING__Group__1__Impl6731);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3321:1: rule__ASN1_INTEGER__Group__0 : rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1 ;
    public final void rule__ASN1_INTEGER__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3325:1: ( rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3326:2: rule__ASN1_INTEGER__Group__0__Impl rule__ASN1_INTEGER__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__0__Impl_in_rule__ASN1_INTEGER__Group__06765);
            rule__ASN1_INTEGER__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__1_in_rule__ASN1_INTEGER__Group__06768);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3333:1: rule__ASN1_INTEGER__Group__0__Impl : ( ( rule__ASN1_INTEGER__NameAssignment_0 ) ) ;
    public final void rule__ASN1_INTEGER__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3337:1: ( ( ( rule__ASN1_INTEGER__NameAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3338:1: ( ( rule__ASN1_INTEGER__NameAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3338:1: ( ( rule__ASN1_INTEGER__NameAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3339:1: ( rule__ASN1_INTEGER__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getNameAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3340:1: ( rule__ASN1_INTEGER__NameAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3340:2: rule__ASN1_INTEGER__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__NameAssignment_0_in_rule__ASN1_INTEGER__Group__0__Impl6795);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3350:1: rule__ASN1_INTEGER__Group__1 : rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2 ;
    public final void rule__ASN1_INTEGER__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3354:1: ( rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3355:2: rule__ASN1_INTEGER__Group__1__Impl rule__ASN1_INTEGER__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__1__Impl_in_rule__ASN1_INTEGER__Group__16825);
            rule__ASN1_INTEGER__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__2_in_rule__ASN1_INTEGER__Group__16828);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3362:1: rule__ASN1_INTEGER__Group__1__Impl : ( '{' ) ;
    public final void rule__ASN1_INTEGER__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3366:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3367:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3367:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3368:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,23,FOLLOW_23_in_rule__ASN1_INTEGER__Group__1__Impl6856); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3381:1: rule__ASN1_INTEGER__Group__2 : rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3 ;
    public final void rule__ASN1_INTEGER__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3385:1: ( rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3386:2: rule__ASN1_INTEGER__Group__2__Impl rule__ASN1_INTEGER__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__2__Impl_in_rule__ASN1_INTEGER__Group__26887);
            rule__ASN1_INTEGER__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__3_in_rule__ASN1_INTEGER__Group__26890);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3393:1: rule__ASN1_INTEGER__Group__2__Impl : ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) ) ;
    public final void rule__ASN1_INTEGER__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3397:1: ( ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3398:1: ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3398:1: ( ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3399:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) ) ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3399:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3400:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3401:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3401:2: rule__ASN1_INTEGER__ValuePairsAssignment_2
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6919);
            rule__ASN1_INTEGER__ValuePairsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            }

            }

            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3404:1: ( ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3405:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getValuePairsAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3406:1: ( rule__ASN1_INTEGER__ValuePairsAssignment_2 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ASN1_ID||LA32_0==30) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3406:2: rule__ASN1_INTEGER__ValuePairsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6931);
            	    rule__ASN1_INTEGER__ValuePairsAssignment_2();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3417:1: rule__ASN1_INTEGER__Group__3 : rule__ASN1_INTEGER__Group__3__Impl ;
    public final void rule__ASN1_INTEGER__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3421:1: ( rule__ASN1_INTEGER__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3422:2: rule__ASN1_INTEGER__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_INTEGER__Group__3__Impl_in_rule__ASN1_INTEGER__Group__36964);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3428:1: rule__ASN1_INTEGER__Group__3__Impl : ( '}' ) ;
    public final void rule__ASN1_INTEGER__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3432:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3433:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3433:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3434:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getRightCurlyBracketKeyword_3()); 
            }
            match(input,24,FOLLOW_24_in_rule__ASN1_INTEGER__Group__3__Impl6992); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3455:1: rule__ASN1_SUBTYPE__Group__0 : rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1 ;
    public final void rule__ASN1_SUBTYPE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3459:1: ( rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3460:2: rule__ASN1_SUBTYPE__Group__0__Impl rule__ASN1_SUBTYPE__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__0__Impl_in_rule__ASN1_SUBTYPE__Group__07031);
            rule__ASN1_SUBTYPE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__1_in_rule__ASN1_SUBTYPE__Group__07034);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3467:1: rule__ASN1_SUBTYPE__Group__0__Impl : ( '(' ) ;
    public final void rule__ASN1_SUBTYPE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3471:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3472:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3472:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3473:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,30,FOLLOW_30_in_rule__ASN1_SUBTYPE__Group__0__Impl7062); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3486:1: rule__ASN1_SUBTYPE__Group__1 : rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2 ;
    public final void rule__ASN1_SUBTYPE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3490:1: ( rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3491:2: rule__ASN1_SUBTYPE__Group__1__Impl rule__ASN1_SUBTYPE__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__1__Impl_in_rule__ASN1_SUBTYPE__Group__17093);
            rule__ASN1_SUBTYPE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__2_in_rule__ASN1_SUBTYPE__Group__17096);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3498:1: rule__ASN1_SUBTYPE__Group__1__Impl : ( 'SIZE' ) ;
    public final void rule__ASN1_SUBTYPE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3502:1: ( ( 'SIZE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3503:1: ( 'SIZE' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3503:1: ( 'SIZE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3504:1: 'SIZE'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getSIZEKeyword_1()); 
            }
            match(input,34,FOLLOW_34_in_rule__ASN1_SUBTYPE__Group__1__Impl7124); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3517:1: rule__ASN1_SUBTYPE__Group__2 : rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3 ;
    public final void rule__ASN1_SUBTYPE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3521:1: ( rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3522:2: rule__ASN1_SUBTYPE__Group__2__Impl rule__ASN1_SUBTYPE__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__2__Impl_in_rule__ASN1_SUBTYPE__Group__27155);
            rule__ASN1_SUBTYPE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__3_in_rule__ASN1_SUBTYPE__Group__27158);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3529:1: rule__ASN1_SUBTYPE__Group__2__Impl : ( '(' ) ;
    public final void rule__ASN1_SUBTYPE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3533:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3534:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3534:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3535:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getLeftParenthesisKeyword_2()); 
            }
            match(input,30,FOLLOW_30_in_rule__ASN1_SUBTYPE__Group__2__Impl7186); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3548:1: rule__ASN1_SUBTYPE__Group__3 : rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4 ;
    public final void rule__ASN1_SUBTYPE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3552:1: ( rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3553:2: rule__ASN1_SUBTYPE__Group__3__Impl rule__ASN1_SUBTYPE__Group__4
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__3__Impl_in_rule__ASN1_SUBTYPE__Group__37217);
            rule__ASN1_SUBTYPE__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__4_in_rule__ASN1_SUBTYPE__Group__37220);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3560:1: rule__ASN1_SUBTYPE__Group__3__Impl : ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) ) ;
    public final void rule__ASN1_SUBTYPE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3564:1: ( ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3565:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3565:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_3 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3566:1: ( rule__ASN1_SUBTYPE__RangesAssignment_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3567:1: ( rule__ASN1_SUBTYPE__RangesAssignment_3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3567:2: rule__ASN1_SUBTYPE__RangesAssignment_3
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_3_in_rule__ASN1_SUBTYPE__Group__3__Impl7247);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3577:1: rule__ASN1_SUBTYPE__Group__4 : rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5 ;
    public final void rule__ASN1_SUBTYPE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3581:1: ( rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3582:2: rule__ASN1_SUBTYPE__Group__4__Impl rule__ASN1_SUBTYPE__Group__5
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__4__Impl_in_rule__ASN1_SUBTYPE__Group__47277);
            rule__ASN1_SUBTYPE__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__5_in_rule__ASN1_SUBTYPE__Group__47280);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3589:1: rule__ASN1_SUBTYPE__Group__4__Impl : ( ( rule__ASN1_SUBTYPE__Group_4__0 )* ) ;
    public final void rule__ASN1_SUBTYPE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3593:1: ( ( ( rule__ASN1_SUBTYPE__Group_4__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3594:1: ( ( rule__ASN1_SUBTYPE__Group_4__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3594:1: ( ( rule__ASN1_SUBTYPE__Group_4__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3595:1: ( rule__ASN1_SUBTYPE__Group_4__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getGroup_4()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3596:1: ( rule__ASN1_SUBTYPE__Group_4__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==28) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3596:2: rule__ASN1_SUBTYPE__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__0_in_rule__ASN1_SUBTYPE__Group__4__Impl7307);
            	    rule__ASN1_SUBTYPE__Group_4__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3606:1: rule__ASN1_SUBTYPE__Group__5 : rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6 ;
    public final void rule__ASN1_SUBTYPE__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3610:1: ( rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3611:2: rule__ASN1_SUBTYPE__Group__5__Impl rule__ASN1_SUBTYPE__Group__6
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__5__Impl_in_rule__ASN1_SUBTYPE__Group__57338);
            rule__ASN1_SUBTYPE__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__6_in_rule__ASN1_SUBTYPE__Group__57341);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3618:1: rule__ASN1_SUBTYPE__Group__5__Impl : ( ')' ) ;
    public final void rule__ASN1_SUBTYPE__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3622:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3623:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3623:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3624:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_5()); 
            }
            match(input,31,FOLLOW_31_in_rule__ASN1_SUBTYPE__Group__5__Impl7369); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3637:1: rule__ASN1_SUBTYPE__Group__6 : rule__ASN1_SUBTYPE__Group__6__Impl ;
    public final void rule__ASN1_SUBTYPE__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3641:1: ( rule__ASN1_SUBTYPE__Group__6__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3642:2: rule__ASN1_SUBTYPE__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group__6__Impl_in_rule__ASN1_SUBTYPE__Group__67400);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3648:1: rule__ASN1_SUBTYPE__Group__6__Impl : ( ')' ) ;
    public final void rule__ASN1_SUBTYPE__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3652:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3653:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3653:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3654:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRightParenthesisKeyword_6()); 
            }
            match(input,31,FOLLOW_31_in_rule__ASN1_SUBTYPE__Group__6__Impl7428); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3681:1: rule__ASN1_SUBTYPE__Group_4__0 : rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1 ;
    public final void rule__ASN1_SUBTYPE__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3685:1: ( rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3686:2: rule__ASN1_SUBTYPE__Group_4__0__Impl rule__ASN1_SUBTYPE__Group_4__1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__0__Impl_in_rule__ASN1_SUBTYPE__Group_4__07473);
            rule__ASN1_SUBTYPE__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__1_in_rule__ASN1_SUBTYPE__Group_4__07476);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3693:1: rule__ASN1_SUBTYPE__Group_4__0__Impl : ( '|' ) ;
    public final void rule__ASN1_SUBTYPE__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3697:1: ( ( '|' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3698:1: ( '|' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3698:1: ( '|' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3699:1: '|'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getVerticalLineKeyword_4_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__ASN1_SUBTYPE__Group_4__0__Impl7504); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3712:1: rule__ASN1_SUBTYPE__Group_4__1 : rule__ASN1_SUBTYPE__Group_4__1__Impl ;
    public final void rule__ASN1_SUBTYPE__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3716:1: ( rule__ASN1_SUBTYPE__Group_4__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3717:2: rule__ASN1_SUBTYPE__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__Group_4__1__Impl_in_rule__ASN1_SUBTYPE__Group_4__17535);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3723:1: rule__ASN1_SUBTYPE__Group_4__1__Impl : ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) ) ;
    public final void rule__ASN1_SUBTYPE__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3727:1: ( ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3728:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3728:1: ( ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3729:1: ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesAssignment_4_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3730:1: ( rule__ASN1_SUBTYPE__RangesAssignment_4_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3730:2: rule__ASN1_SUBTYPE__RangesAssignment_4_1
            {
            pushFollow(FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_4_1_in_rule__ASN1_SUBTYPE__Group_4__1__Impl7562);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3744:1: rule__ASN1_RANGE__Group_0__0 : rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1 ;
    public final void rule__ASN1_RANGE__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3748:1: ( rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3749:2: rule__ASN1_RANGE__Group_0__0__Impl rule__ASN1_RANGE__Group_0__1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__0__Impl_in_rule__ASN1_RANGE__Group_0__07596);
            rule__ASN1_RANGE__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__1_in_rule__ASN1_RANGE__Group_0__07599);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3756:1: rule__ASN1_RANGE__Group_0__0__Impl : ( () ) ;
    public final void rule__ASN1_RANGE__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3760:1: ( ( () ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3761:1: ( () )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3761:1: ( () )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3762:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getASN1_RANGEAction_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3763:1: ()
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3765:1: 
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3775:1: rule__ASN1_RANGE__Group_0__1 : rule__ASN1_RANGE__Group_0__1__Impl ;
    public final void rule__ASN1_RANGE__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3779:1: ( rule__ASN1_RANGE__Group_0__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3780:2: rule__ASN1_RANGE__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_0__1__Impl_in_rule__ASN1_RANGE__Group_0__17657);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3786:1: rule__ASN1_RANGE__Group_0__1__Impl : ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) ) ;
    public final void rule__ASN1_RANGE__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3790:1: ( ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3791:1: ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3791:1: ( ( rule__ASN1_RANGE__ValueAssignment_0_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3792:1: ( rule__ASN1_RANGE__ValueAssignment_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getValueAssignment_0_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3793:1: ( rule__ASN1_RANGE__ValueAssignment_0_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3793:2: rule__ASN1_RANGE__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__ValueAssignment_0_1_in_rule__ASN1_RANGE__Group_0__1__Impl7684);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3807:1: rule__ASN1_RANGE__Group_1__0 : rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1 ;
    public final void rule__ASN1_RANGE__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3811:1: ( rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3812:2: rule__ASN1_RANGE__Group_1__0__Impl rule__ASN1_RANGE__Group_1__1
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__0__Impl_in_rule__ASN1_RANGE__Group_1__07718);
            rule__ASN1_RANGE__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__1_in_rule__ASN1_RANGE__Group_1__07721);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3819:1: rule__ASN1_RANGE__Group_1__0__Impl : ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) ) ;
    public final void rule__ASN1_RANGE__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3823:1: ( ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3824:1: ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3824:1: ( ( rule__ASN1_RANGE__StartAssignment_1_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3825:1: ( rule__ASN1_RANGE__StartAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getStartAssignment_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3826:1: ( rule__ASN1_RANGE__StartAssignment_1_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3826:2: rule__ASN1_RANGE__StartAssignment_1_0
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__StartAssignment_1_0_in_rule__ASN1_RANGE__Group_1__0__Impl7748);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3836:1: rule__ASN1_RANGE__Group_1__1 : rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2 ;
    public final void rule__ASN1_RANGE__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3840:1: ( rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3841:2: rule__ASN1_RANGE__Group_1__1__Impl rule__ASN1_RANGE__Group_1__2
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__1__Impl_in_rule__ASN1_RANGE__Group_1__17778);
            rule__ASN1_RANGE__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__2_in_rule__ASN1_RANGE__Group_1__17781);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3848:1: rule__ASN1_RANGE__Group_1__1__Impl : ( '..' ) ;
    public final void rule__ASN1_RANGE__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3852:1: ( ( '..' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3853:1: ( '..' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3853:1: ( '..' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3854:1: '..'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getFullStopFullStopKeyword_1_1()); 
            }
            match(input,35,FOLLOW_35_in_rule__ASN1_RANGE__Group_1__1__Impl7809); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3867:1: rule__ASN1_RANGE__Group_1__2 : rule__ASN1_RANGE__Group_1__2__Impl ;
    public final void rule__ASN1_RANGE__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3871:1: ( rule__ASN1_RANGE__Group_1__2__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3872:2: rule__ASN1_RANGE__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__Group_1__2__Impl_in_rule__ASN1_RANGE__Group_1__27840);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3878:1: rule__ASN1_RANGE__Group_1__2__Impl : ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) ) ;
    public final void rule__ASN1_RANGE__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3882:1: ( ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3883:1: ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3883:1: ( ( rule__ASN1_RANGE__EndAssignment_1_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3884:1: ( rule__ASN1_RANGE__EndAssignment_1_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getEndAssignment_1_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3885:1: ( rule__ASN1_RANGE__EndAssignment_1_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3885:2: rule__ASN1_RANGE__EndAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ASN1_RANGE__EndAssignment_1_2_in_rule__ASN1_RANGE__Group_1__2__Impl7867);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3901:1: rule__ASN1_VALUEPAIR__Group__0 : rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1 ;
    public final void rule__ASN1_VALUEPAIR__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3905:1: ( rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3906:2: rule__ASN1_VALUEPAIR__Group__0__Impl rule__ASN1_VALUEPAIR__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__0__Impl_in_rule__ASN1_VALUEPAIR__Group__07903);
            rule__ASN1_VALUEPAIR__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__1_in_rule__ASN1_VALUEPAIR__Group__07906);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3913:1: rule__ASN1_VALUEPAIR__Group__0__Impl : ( ( RULE_ASN1_ID )? ) ;
    public final void rule__ASN1_VALUEPAIR__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3917:1: ( ( ( RULE_ASN1_ID )? ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3918:1: ( ( RULE_ASN1_ID )? )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3918:1: ( ( RULE_ASN1_ID )? )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3919:1: ( RULE_ASN1_ID )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getASN1_IDTerminalRuleCall_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3920:1: ( RULE_ASN1_ID )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ASN1_ID) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3920:3: RULE_ASN1_ID
                    {
                    match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ASN1_VALUEPAIR__Group__0__Impl7934); if (state.failed) return ;

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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3930:1: rule__ASN1_VALUEPAIR__Group__1 : rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2 ;
    public final void rule__ASN1_VALUEPAIR__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3934:1: ( rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3935:2: rule__ASN1_VALUEPAIR__Group__1__Impl rule__ASN1_VALUEPAIR__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__1__Impl_in_rule__ASN1_VALUEPAIR__Group__17965);
            rule__ASN1_VALUEPAIR__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__2_in_rule__ASN1_VALUEPAIR__Group__17968);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3942:1: rule__ASN1_VALUEPAIR__Group__1__Impl : ( '(' ) ;
    public final void rule__ASN1_VALUEPAIR__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3946:1: ( ( '(' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3947:1: ( '(' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3947:1: ( '(' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3948:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,30,FOLLOW_30_in_rule__ASN1_VALUEPAIR__Group__1__Impl7996); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3961:1: rule__ASN1_VALUEPAIR__Group__2 : rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3 ;
    public final void rule__ASN1_VALUEPAIR__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3965:1: ( rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3966:2: rule__ASN1_VALUEPAIR__Group__2__Impl rule__ASN1_VALUEPAIR__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__2__Impl_in_rule__ASN1_VALUEPAIR__Group__28027);
            rule__ASN1_VALUEPAIR__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__3_in_rule__ASN1_VALUEPAIR__Group__28030);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3973:1: rule__ASN1_VALUEPAIR__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__ASN1_VALUEPAIR__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3977:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3978:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3978:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3979:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getINTTerminalRuleCall_2()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_VALUEPAIR__Group__2__Impl8057); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3990:1: rule__ASN1_VALUEPAIR__Group__3 : rule__ASN1_VALUEPAIR__Group__3__Impl ;
    public final void rule__ASN1_VALUEPAIR__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3994:1: ( rule__ASN1_VALUEPAIR__Group__3__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:3995:2: rule__ASN1_VALUEPAIR__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_VALUEPAIR__Group__3__Impl_in_rule__ASN1_VALUEPAIR__Group__38086);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4001:1: rule__ASN1_VALUEPAIR__Group__3__Impl : ( ')' ) ;
    public final void rule__ASN1_VALUEPAIR__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4005:1: ( ( ')' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4006:1: ( ')' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4006:1: ( ')' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4007:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_VALUEPAIRAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,31,FOLLOW_31_in_rule__ASN1_VALUEPAIR__Group__3__Impl8114); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4028:1: rule__ASN1_CHOICE__Group__0 : rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1 ;
    public final void rule__ASN1_CHOICE__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4032:1: ( rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4033:2: rule__ASN1_CHOICE__Group__0__Impl rule__ASN1_CHOICE__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__0__Impl_in_rule__ASN1_CHOICE__Group__08153);
            rule__ASN1_CHOICE__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__1_in_rule__ASN1_CHOICE__Group__08156);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4040:1: rule__ASN1_CHOICE__Group__0__Impl : ( 'CHOICE' ) ;
    public final void rule__ASN1_CHOICE__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4044:1: ( ( 'CHOICE' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4045:1: ( 'CHOICE' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4045:1: ( 'CHOICE' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4046:1: 'CHOICE'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getCHOICEKeyword_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__ASN1_CHOICE__Group__0__Impl8184); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4059:1: rule__ASN1_CHOICE__Group__1 : rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2 ;
    public final void rule__ASN1_CHOICE__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4063:1: ( rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4064:2: rule__ASN1_CHOICE__Group__1__Impl rule__ASN1_CHOICE__Group__2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__1__Impl_in_rule__ASN1_CHOICE__Group__18215);
            rule__ASN1_CHOICE__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__2_in_rule__ASN1_CHOICE__Group__18218);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4071:1: rule__ASN1_CHOICE__Group__1__Impl : ( '{' ) ;
    public final void rule__ASN1_CHOICE__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4075:1: ( ( '{' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4076:1: ( '{' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4076:1: ( '{' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4077:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,23,FOLLOW_23_in_rule__ASN1_CHOICE__Group__1__Impl8246); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4090:1: rule__ASN1_CHOICE__Group__2 : rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3 ;
    public final void rule__ASN1_CHOICE__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4094:1: ( rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4095:2: rule__ASN1_CHOICE__Group__2__Impl rule__ASN1_CHOICE__Group__3
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__2__Impl_in_rule__ASN1_CHOICE__Group__28277);
            rule__ASN1_CHOICE__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__3_in_rule__ASN1_CHOICE__Group__28280);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4102:1: rule__ASN1_CHOICE__Group__2__Impl : ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) ) ;
    public final void rule__ASN1_CHOICE__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4106:1: ( ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4107:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4107:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_2 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4108:1: ( rule__ASN1_CHOICE__ChoicesAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_2()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4109:1: ( rule__ASN1_CHOICE__ChoicesAssignment_2 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4109:2: rule__ASN1_CHOICE__ChoicesAssignment_2
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_2_in_rule__ASN1_CHOICE__Group__2__Impl8307);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4119:1: rule__ASN1_CHOICE__Group__3 : rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4 ;
    public final void rule__ASN1_CHOICE__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4123:1: ( rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4124:2: rule__ASN1_CHOICE__Group__3__Impl rule__ASN1_CHOICE__Group__4
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__3__Impl_in_rule__ASN1_CHOICE__Group__38337);
            rule__ASN1_CHOICE__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__4_in_rule__ASN1_CHOICE__Group__38340);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4131:1: rule__ASN1_CHOICE__Group__3__Impl : ( ( rule__ASN1_CHOICE__Group_3__0 )* ) ;
    public final void rule__ASN1_CHOICE__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4135:1: ( ( ( rule__ASN1_CHOICE__Group_3__0 )* ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4136:1: ( ( rule__ASN1_CHOICE__Group_3__0 )* )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4136:1: ( ( rule__ASN1_CHOICE__Group_3__0 )* )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4137:1: ( rule__ASN1_CHOICE__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getGroup_3()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4138:1: ( rule__ASN1_CHOICE__Group_3__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==37) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4138:2: rule__ASN1_CHOICE__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__0_in_rule__ASN1_CHOICE__Group__3__Impl8367);
            	    rule__ASN1_CHOICE__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4148:1: rule__ASN1_CHOICE__Group__4 : rule__ASN1_CHOICE__Group__4__Impl ;
    public final void rule__ASN1_CHOICE__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4152:1: ( rule__ASN1_CHOICE__Group__4__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4153:2: rule__ASN1_CHOICE__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group__4__Impl_in_rule__ASN1_CHOICE__Group__48398);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4159:1: rule__ASN1_CHOICE__Group__4__Impl : ( '}' ) ;
    public final void rule__ASN1_CHOICE__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4163:1: ( ( '}' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4164:1: ( '}' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4164:1: ( '}' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4165:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,24,FOLLOW_24_in_rule__ASN1_CHOICE__Group__4__Impl8426); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4188:1: rule__ASN1_CHOICE__Group_3__0 : rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1 ;
    public final void rule__ASN1_CHOICE__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4192:1: ( rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4193:2: rule__ASN1_CHOICE__Group_3__0__Impl rule__ASN1_CHOICE__Group_3__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__0__Impl_in_rule__ASN1_CHOICE__Group_3__08467);
            rule__ASN1_CHOICE__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__1_in_rule__ASN1_CHOICE__Group_3__08470);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4200:1: rule__ASN1_CHOICE__Group_3__0__Impl : ( ',' ) ;
    public final void rule__ASN1_CHOICE__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4204:1: ( ( ',' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4205:1: ( ',' )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4205:1: ( ',' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4206:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getCommaKeyword_3_0()); 
            }
            match(input,37,FOLLOW_37_in_rule__ASN1_CHOICE__Group_3__0__Impl8498); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4219:1: rule__ASN1_CHOICE__Group_3__1 : rule__ASN1_CHOICE__Group_3__1__Impl ;
    public final void rule__ASN1_CHOICE__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4223:1: ( rule__ASN1_CHOICE__Group_3__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4224:2: rule__ASN1_CHOICE__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__Group_3__1__Impl_in_rule__ASN1_CHOICE__Group_3__18529);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4230:1: rule__ASN1_CHOICE__Group_3__1__Impl : ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) ) ;
    public final void rule__ASN1_CHOICE__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4234:1: ( ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4235:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4235:1: ( ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4236:1: ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesAssignment_3_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4237:1: ( rule__ASN1_CHOICE__ChoicesAssignment_3_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4237:2: rule__ASN1_CHOICE__ChoicesAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_3_1_in_rule__ASN1_CHOICE__Group_3__1__Impl8556);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4251:1: rule__ASN1_CHOICE_ENTRY__Group__0 : rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1 ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4255:1: ( rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4256:2: rule__ASN1_CHOICE_ENTRY__Group__0__Impl rule__ASN1_CHOICE_ENTRY__Group__1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__08590);
            rule__ASN1_CHOICE_ENTRY__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1_in_rule__ASN1_CHOICE_ENTRY__Group__08593);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4263:1: rule__ASN1_CHOICE_ENTRY__Group__0__Impl : ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4267:1: ( ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4268:1: ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4268:1: ( ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4269:1: ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdAssignment_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4270:1: ( rule__ASN1_CHOICE_ENTRY__IdAssignment_0 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4270:2: rule__ASN1_CHOICE_ENTRY__IdAssignment_0
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__IdAssignment_0_in_rule__ASN1_CHOICE_ENTRY__Group__0__Impl8620);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4280:1: rule__ASN1_CHOICE_ENTRY__Group__1 : rule__ASN1_CHOICE_ENTRY__Group__1__Impl ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4284:1: ( rule__ASN1_CHOICE_ENTRY__Group__1__Impl )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4285:2: rule__ASN1_CHOICE_ENTRY__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__18650);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4291:1: rule__ASN1_CHOICE_ENTRY__Group__1__Impl : ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4295:1: ( ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4296:1: ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4296:1: ( ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4297:1: ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeAssignment_1()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4298:1: ( rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4298:2: rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1
            {
            pushFollow(FOLLOW_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1_in_rule__ASN1_CHOICE_ENTRY__Group__1__Impl8677);
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


    // $ANTLR start "rule__Module__NameAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4313:1: rule__Module__NameAssignment_0 : ( RULE_MODULE_ID ) ;
    public final void rule__Module__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4317:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4318:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4318:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4319:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNameMODULE_IDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__Module__NameAssignment_08716); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4328:1: rule__Module__IdentifiersAssignment_5_0 : ( ruleObjectIdentifier ) ;
    public final void rule__Module__IdentifiersAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4332:1: ( ( ruleObjectIdentifier ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4333:1: ( ruleObjectIdentifier )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4333:1: ( ruleObjectIdentifier )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4334:1: ruleObjectIdentifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getIdentifiersObjectIdentifierParserRuleCall_5_0_0()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifier_in_rule__Module__IdentifiersAssignment_5_08747);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4343:1: rule__Module__TypesAssignment_5_1 : ( ruleTypeDefinition ) ;
    public final void rule__Module__TypesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4347:1: ( ( ruleTypeDefinition ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4348:1: ( ruleTypeDefinition )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4348:1: ( ruleTypeDefinition )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4349:1: ruleTypeDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getTypesTypeDefinitionParserRuleCall_5_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_rule__Module__TypesAssignment_5_18778);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4358:1: rule__Module__MacrosAssignment_5_2 : ( ruleMacro ) ;
    public final void rule__Module__MacrosAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4362:1: ( ( ruleMacro ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4363:1: ( ruleMacro )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4363:1: ( ruleMacro )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4364:1: ruleMacro
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getMacrosMacroParserRuleCall_5_2_0()); 
            }
            pushFollow(FOLLOW_ruleMacro_in_rule__Module__MacrosAssignment_5_28809);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4373:1: rule__ObjectIdentifier__NameAssignment_1 : ( RULE_ASN1_ID ) ;
    public final void rule__ObjectIdentifier__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4377:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4378:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4378:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4379:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getNameASN1_IDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifier__NameAssignment_18840); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4388:1: rule__ObjectIdentifier__OidValueAssignment_5 : ( ruleObjectIdentifierValue ) ;
    public final void rule__ObjectIdentifier__OidValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4392:1: ( ( ruleObjectIdentifierValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4393:1: ( ruleObjectIdentifierValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4393:1: ( ruleObjectIdentifierValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4394:1: ruleObjectIdentifierValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierAccess().getOidValueObjectIdentifierValueParserRuleCall_5_0()); 
            }
            pushFollow(FOLLOW_ruleObjectIdentifierValue_in_rule__ObjectIdentifier__OidValueAssignment_58871);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4403:1: rule__ObjectIdentifierValue__RootAssignment_0_0 : ( RULE_ASN1_ID ) ;
    public final void rule__ObjectIdentifierValue__RootAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4407:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4408:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4408:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4409:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getRootASN1_IDTerminalRuleCall_0_0_0()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__RootAssignment_0_08902); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4418:1: rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1 : ( ( RULE_ASN1_ID ) ) ;
    public final void rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4422:1: ( ( ( RULE_ASN1_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4423:1: ( ( RULE_ASN1_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4423:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4424:1: ( RULE_ASN1_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierCrossReference_0_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4425:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4426:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getDescriptorReferenceObjectIdentifierASN1_IDTerminalRuleCall_0_1_0_1()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_18937); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4437:1: rule__ObjectIdentifierValue__SubIdsAssignment_1 : ( RULE_INT ) ;
    public final void rule__ObjectIdentifierValue__SubIdsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4441:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4442:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4442:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4443:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_18972); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4452:1: rule__ObjectIdentifierValue__SubIdsAssignment_2 : ( RULE_INT ) ;
    public final void rule__ObjectIdentifierValue__SubIdsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4456:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4457:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4457:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4458:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getObjectIdentifierValueAccess().getSubIdsINTTerminalRuleCall_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_29003); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4467:1: rule__TypeDefinition__NameAssignment_1 : ( RULE_MODULE_ID ) ;
    public final void rule__TypeDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4471:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4472:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4472:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4473:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getNameMODULE_IDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__TypeDefinition__NameAssignment_19034); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4482:1: rule__TypeDefinition__ValuesAssignment_3 : ( ruleValue ) ;
    public final void rule__TypeDefinition__ValuesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4486:1: ( ( ruleValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4487:1: ( ruleValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4487:1: ( ruleValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4488:1: ruleValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeDefinitionAccess().getValuesValueParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleValue_in_rule__TypeDefinition__ValuesAssignment_39065);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4497:1: rule__Macro__NameAssignment_1 : ( RULE_MODULE_ID ) ;
    public final void rule__Macro__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4501:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4502:1: ( RULE_MODULE_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4502:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4503:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getNameMODULE_IDTerminalRuleCall_1_0()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__Macro__NameAssignment_19096); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4512:1: rule__Macro__TypeNotationsAssignment_9 : ( ruleTypeAssignment ) ;
    public final void rule__Macro__TypeNotationsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4516:1: ( ( ruleTypeAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4517:1: ( ruleTypeAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4517:1: ( ruleTypeAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4518:1: ruleTypeAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getTypeNotationsTypeAssignmentParserRuleCall_9_0()); 
            }
            pushFollow(FOLLOW_ruleTypeAssignment_in_rule__Macro__TypeNotationsAssignment_99127);
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


    // $ANTLR start "rule__Macro__ValueNotationAssignment_14"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4527:1: rule__Macro__ValueNotationAssignment_14 : ( ruleMacroValue ) ;
    public final void rule__Macro__ValueNotationAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4531:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4532:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4532:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4533:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_14_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__Macro__ValueNotationAssignment_149158);
            ruleMacroValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getValueNotationMacroValueParserRuleCall_14_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__ValueNotationAssignment_14"


    // $ANTLR start "rule__Macro__InnerTypesAssignment_15"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4542:1: rule__Macro__InnerTypesAssignment_15 : ( ruleTypeDefinition ) ;
    public final void rule__Macro__InnerTypesAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4546:1: ( ( ruleTypeDefinition ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4547:1: ( ruleTypeDefinition )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4547:1: ( ruleTypeDefinition )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4548:1: ruleTypeDefinition
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_15_0()); 
            }
            pushFollow(FOLLOW_ruleTypeDefinition_in_rule__Macro__InnerTypesAssignment_159189);
            ruleTypeDefinition();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getMacroAccess().getInnerTypesTypeDefinitionParserRuleCall_15_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__InnerTypesAssignment_15"


    // $ANTLR start "rule__ParamAssignment__ParamAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4557:1: rule__ParamAssignment__ParamAssignment_0 : ( RULE_PARAMETER ) ;
    public final void rule__ParamAssignment__ParamAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4561:1: ( ( RULE_PARAMETER ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4562:1: ( RULE_PARAMETER )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4562:1: ( RULE_PARAMETER )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4563:1: RULE_PARAMETER
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getParamPARAMETERTerminalRuleCall_0_0()); 
            }
            match(input,RULE_PARAMETER,FOLLOW_RULE_PARAMETER_in_rule__ParamAssignment__ParamAssignment_09220); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4572:1: rule__ParamAssignment__RightAssignment_1 : ( ruleTypeNotation ) ;
    public final void rule__ParamAssignment__RightAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4576:1: ( ( ruleTypeNotation ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4577:1: ( ruleTypeNotation )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4577:1: ( ruleTypeNotation )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4578:1: ruleTypeNotation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getParamAssignmentAccess().getRightTypeNotationParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeNotation_in_rule__ParamAssignment__RightAssignment_19251);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4587:1: rule__TypeNotation__ValueAssignment_1 : ( ruleMacroValue ) ;
    public final void rule__TypeNotation__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4591:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4592:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4592:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4593:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeNotationAccess().getValueMacroValueParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__TypeNotation__ValueAssignment_19282);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4602:1: rule__TypeReferenceExt__ParentRefAssignment_0 : ( ruleTypeReference ) ;
    public final void rule__TypeReferenceExt__ParentRefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4606:1: ( ( ruleTypeReference ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4607:1: ( ruleTypeReference )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4607:1: ( ruleTypeReference )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4608:1: ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getParentRefTypeReferenceParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ParentRefAssignment_09313);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4617:1: rule__TypeReferenceExt__ChildRefAssignment_1 : ( ruleTypeReference ) ;
    public final void rule__TypeReferenceExt__ChildRefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4621:1: ( ( ruleTypeReference ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4622:1: ( ruleTypeReference )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4622:1: ( ruleTypeReference )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4623:1: ruleTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceExtAccess().getChildRefTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ChildRefAssignment_19344);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4632:1: rule__TypeReference__TypeAssignment : ( ( RULE_MODULE_ID ) ) ;
    public final void rule__TypeReference__TypeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4636:1: ( ( ( RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4637:1: ( ( RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4637:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4638:1: ( RULE_MODULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceAccess().getTypeTypeDefinitionCrossReference_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4639:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4640:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTypeReferenceAccess().getTypeTypeDefinitionMODULE_IDTerminalRuleCall_0_1()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__TypeReference__TypeAssignment9379); if (state.failed) return ;
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


    // $ANTLR start "rule__Value__ValueTypesAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4651:1: rule__Value__ValueTypesAssignment_1 : ( ruleValueType ) ;
    public final void rule__Value__ValueTypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4655:1: ( ( ruleValueType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4656:1: ( ruleValueType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4656:1: ( ruleValueType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4657:1: ruleValueType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_19414);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__ValueTypesAssignment_1"


    // $ANTLR start "rule__Value__ValueTypesAssignment_2_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4666:1: rule__Value__ValueTypesAssignment_2_2 : ( ruleValueType ) ;
    public final void rule__Value__ValueTypesAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4670:1: ( ( ruleValueType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4671:1: ( ruleValueType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4671:1: ( ruleValueType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4672:1: ruleValueType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_2_2_0()); 
            }
            pushFollow(FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_2_29445);
            ruleValueType();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValueAccess().getValueTypesValueTypeParserRuleCall_2_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__ValueTypesAssignment_2_2"


    // $ANTLR start "rule__ValueType__ParamAssignment_0"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4681:1: rule__ValueType__ParamAssignment_0 : ( ruleParamAssignment ) ;
    public final void rule__ValueType__ParamAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4685:1: ( ( ruleParamAssignment ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4686:1: ( ruleParamAssignment )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4686:1: ( ruleParamAssignment )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4687:1: ruleParamAssignment
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getParamParamAssignmentParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleParamAssignment_in_rule__ValueType__ParamAssignment_09476);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4696:1: rule__ValueType__TypesAssignment_1 : ( ruleTypeReferenceExt ) ;
    public final void rule__ValueType__TypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4700:1: ( ( ruleTypeReferenceExt ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4701:1: ( ruleTypeReferenceExt )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4701:1: ( ruleTypeReferenceExt )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4702:1: ruleTypeReferenceExt
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getTypesTypeReferenceExtParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTypeReferenceExt_in_rule__ValueType__TypesAssignment_19507);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4711:1: rule__ValueType__SimpleTypeAssignment_2 : ( ruleASN1_TYPE ) ;
    public final void rule__ValueType__SimpleTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4715:1: ( ( ruleASN1_TYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4716:1: ( ruleASN1_TYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4716:1: ( ruleASN1_TYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4717:1: ruleASN1_TYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getSimpleTypeASN1_TYPEParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_TYPE_in_rule__ValueType__SimpleTypeAssignment_29538);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4726:1: rule__ValueType__MacroValueAssignment_3 : ( ruleMacroValue ) ;
    public final void rule__ValueType__MacroValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4730:1: ( ( ruleMacroValue ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4731:1: ( ruleMacroValue )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4731:1: ( ruleMacroValue )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4732:1: ruleMacroValue
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getMacroValueMacroValueParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleMacroValue_in_rule__ValueType__MacroValueAssignment_39569);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4741:1: rule__ValueType__OiAssignment_4 : ( ( 'OBJECT IDENTIFIER' ) ) ;
    public final void rule__ValueType__OiAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4745:1: ( ( ( 'OBJECT IDENTIFIER' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:1: ( ( 'OBJECT IDENTIFIER' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4746:1: ( ( 'OBJECT IDENTIFIER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4747:1: ( 'OBJECT IDENTIFIER' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_4_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4748:1: ( 'OBJECT IDENTIFIER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4749:1: 'OBJECT IDENTIFIER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValueTypeAccess().getOiOBJECTIDENTIFIERKeyword_4_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__ValueType__OiAssignment_49605); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4764:1: rule__MacroValue__ValueTypeAssignment_3 : ( ruleMACRO_VALUE_TYPE ) ;
    public final void rule__MacroValue__ValueTypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4768:1: ( ( ruleMACRO_VALUE_TYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4769:1: ( ruleMACRO_VALUE_TYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4769:1: ( ruleMACRO_VALUE_TYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4770:1: ruleMACRO_VALUE_TYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMacroValueAccess().getValueTypeMACRO_VALUE_TYPEParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_TYPE_in_rule__MacroValue__ValueTypeAssignment_39644);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4779:1: rule__MACRO_VALUE_TYPE__UpdateAssignment_0 : ( ruleUpdateType ) ;
    public final void rule__MACRO_VALUE_TYPE__UpdateAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4783:1: ( ( ruleUpdateType ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4784:1: ( ruleUpdateType )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4784:1: ( ruleUpdateType )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4785:1: ruleUpdateType
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getUpdateUpdateTypeParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleUpdateType_in_rule__MACRO_VALUE_TYPE__UpdateAssignment_09675);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4794:1: rule__MACRO_VALUE_TYPE__LiteralAssignment_1 : ( ruleMACRO_VALUE_CAP ) ;
    public final void rule__MACRO_VALUE_TYPE__LiteralAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4798:1: ( ( ruleMACRO_VALUE_CAP ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4799:1: ( ruleMACRO_VALUE_CAP )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4799:1: ( ruleMACRO_VALUE_CAP )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4800:1: ruleMACRO_VALUE_CAP
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getMACRO_VALUE_TYPEAccess().getLiteralMACRO_VALUE_CAPParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleMACRO_VALUE_CAP_in_rule__MACRO_VALUE_TYPE__LiteralAssignment_19706);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4809:1: rule__UpdateType__TypeAssignment_1 : ( ( RULE_MODULE_ID ) ) ;
    public final void rule__UpdateType__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4813:1: ( ( ( RULE_MODULE_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4814:1: ( ( RULE_MODULE_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4814:1: ( ( RULE_MODULE_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4815:1: ( RULE_MODULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getTypeTypeDefinitionCrossReference_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4816:1: ( RULE_MODULE_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4817:1: RULE_MODULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUpdateTypeAccess().getTypeTypeDefinitionMODULE_IDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_MODULE_ID,FOLLOW_RULE_MODULE_ID_in_rule__UpdateType__TypeAssignment_19741); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4828:1: rule__ASN1_SIMPLE__ConstraintAssignment_2_1 : ( ruleASN1_SUBTYPE ) ;
    public final void rule__ASN1_SIMPLE__ConstraintAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4832:1: ( ( ruleASN1_SUBTYPE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4833:1: ( ruleASN1_SUBTYPE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4833:1: ( ruleASN1_SUBTYPE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4834:1: ruleASN1_SUBTYPE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_SUBTYPEParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_SUBTYPE_in_rule__ASN1_SIMPLE__ConstraintAssignment_2_19776);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4843:1: rule__ASN1_SIMPLE__ConstraintAssignment_3_1 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SIMPLE__ConstraintAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4847:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4848:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4848:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4849:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SIMPLEAccess().getConstraintASN1_RANGEParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SIMPLE__ConstraintAssignment_3_19807);
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


    // $ANTLR start "rule__ASN1_OCTET_STRING__NameAssignment_1"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4858:1: rule__ASN1_OCTET_STRING__NameAssignment_1 : ( ( 'OCTET STRING' ) ) ;
    public final void rule__ASN1_OCTET_STRING__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4862:1: ( ( ( 'OCTET STRING' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4863:1: ( ( 'OCTET STRING' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4863:1: ( ( 'OCTET STRING' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4864:1: ( 'OCTET STRING' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getNameOCTETSTRINGKeyword_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4865:1: ( 'OCTET STRING' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4866:1: 'OCTET STRING'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_OCTET_STRINGAccess().getNameOCTETSTRINGKeyword_1_0()); 
            }
            match(input,38,FOLLOW_38_in_rule__ASN1_OCTET_STRING__NameAssignment_19843); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4881:1: rule__ASN1_INTEGER__NameAssignment_0 : ( ( 'INTEGER' ) ) ;
    public final void rule__ASN1_INTEGER__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4885:1: ( ( ( 'INTEGER' ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4886:1: ( ( 'INTEGER' ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4886:1: ( ( 'INTEGER' ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4887:1: ( 'INTEGER' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getNameINTEGERKeyword_0_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4888:1: ( 'INTEGER' )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4889:1: 'INTEGER'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getNameINTEGERKeyword_0_0()); 
            }
            match(input,39,FOLLOW_39_in_rule__ASN1_INTEGER__NameAssignment_09887); if (state.failed) return ;
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


    // $ANTLR start "rule__ASN1_INTEGER__ValuePairsAssignment_2"
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4904:1: rule__ASN1_INTEGER__ValuePairsAssignment_2 : ( ruleASN1_VALUEPAIR ) ;
    public final void rule__ASN1_INTEGER__ValuePairsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4908:1: ( ( ruleASN1_VALUEPAIR ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4909:1: ( ruleASN1_VALUEPAIR )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4909:1: ( ruleASN1_VALUEPAIR )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4910:1: ruleASN1_VALUEPAIR
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_INTEGERAccess().getValuePairsASN1_VALUEPAIRParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_VALUEPAIR_in_rule__ASN1_INTEGER__ValuePairsAssignment_29926);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4919:1: rule__ASN1_SUBTYPE__RangesAssignment_3 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SUBTYPE__RangesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4923:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4924:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4924:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4925:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_3_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_39957);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4934:1: rule__ASN1_SUBTYPE__RangesAssignment_4_1 : ( ruleASN1_RANGE ) ;
    public final void rule__ASN1_SUBTYPE__RangesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4938:1: ( ( ruleASN1_RANGE ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4939:1: ( ruleASN1_RANGE )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4939:1: ( ruleASN1_RANGE )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4940:1: ruleASN1_RANGE
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_SUBTYPEAccess().getRangesASN1_RANGEParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_4_19988);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4949:1: rule__ASN1_RANGE__ValueAssignment_0_1 : ( RULE_INT ) ;
    public final void rule__ASN1_RANGE__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4953:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4954:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4954:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4955:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getValueINTTerminalRuleCall_0_1_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_RANGE__ValueAssignment_0_110019); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4964:1: rule__ASN1_RANGE__StartAssignment_1_0 : ( RULE_INT ) ;
    public final void rule__ASN1_RANGE__StartAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4968:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4969:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4969:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4970:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getStartINTTerminalRuleCall_1_0_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_RANGE__StartAssignment_1_010050); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4979:1: rule__ASN1_RANGE__EndAssignment_1_2 : ( RULE_INT ) ;
    public final void rule__ASN1_RANGE__EndAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4983:1: ( ( RULE_INT ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4984:1: ( RULE_INT )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4984:1: ( RULE_INT )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4985:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_RANGEAccess().getEndINTTerminalRuleCall_1_2_0()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__ASN1_RANGE__EndAssignment_1_210081); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4994:1: rule__ASN1_CHOICE__ChoicesAssignment_2 : ( ruleASN1_CHOICE_ENTRY ) ;
    public final void rule__ASN1_CHOICE__ChoicesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4998:1: ( ( ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4999:1: ( ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:4999:1: ( ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5000:1: ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_210112);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5009:1: rule__ASN1_CHOICE__ChoicesAssignment_3_1 : ( ruleASN1_CHOICE_ENTRY ) ;
    public final void rule__ASN1_CHOICE__ChoicesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5013:1: ( ( ruleASN1_CHOICE_ENTRY ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5014:1: ( ruleASN1_CHOICE_ENTRY )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5014:1: ( ruleASN1_CHOICE_ENTRY )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5015:1: ruleASN1_CHOICE_ENTRY
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICEAccess().getChoicesASN1_CHOICE_ENTRYParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_3_110143);
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5024:1: rule__ASN1_CHOICE_ENTRY__IdAssignment_0 : ( RULE_ASN1_ID ) ;
    public final void rule__ASN1_CHOICE_ENTRY__IdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5028:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5029:1: ( RULE_ASN1_ID )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5029:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5030:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getIdASN1_IDTerminalRuleCall_0_0()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__IdAssignment_010174); if (state.failed) return ;
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
    // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5039:1: rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1 : ( ( RULE_ASN1_ID ) ) ;
    public final void rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5043:1: ( ( ( RULE_ASN1_ID ) ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5044:1: ( ( RULE_ASN1_ID ) )
            {
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5044:1: ( ( RULE_ASN1_ID ) )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5045:1: ( RULE_ASN1_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueCrossReference_1_0()); 
            }
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5046:1: ( RULE_ASN1_ID )
            // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:5047:1: RULE_ASN1_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getASN1_CHOICE_ENTRYAccess().getValueTypeValueASN1_IDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ASN1_ID,FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_110209); if (state.failed) return ;
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

    // $ANTLR start synpred3_InternalSmi
    public final void synpred3_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:802:1: ( ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) ) )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:802:1: ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) )
        {
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:802:1: ( ( rule__ObjectIdentifierValue__RootAssignment_0_0 ) )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:803:1: ( rule__ObjectIdentifierValue__RootAssignment_0_0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getObjectIdentifierValueAccess().getRootAssignment_0_0()); 
        }
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:804:1: ( rule__ObjectIdentifierValue__RootAssignment_0_0 )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:804:2: rule__ObjectIdentifierValue__RootAssignment_0_0
        {
        pushFollow(FOLLOW_rule__ObjectIdentifierValue__RootAssignment_0_0_in_synpred3_InternalSmi1654);
        rule__ObjectIdentifierValue__RootAssignment_0_0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred3_InternalSmi

    // $ANTLR start synpred33_InternalSmi
    public final void synpred33_InternalSmi_fragment() throws RecognitionException {   
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2583:2: ( rule__TypeReferenceExt__ChildRefAssignment_1 )
        // ../com.netxforge.smi.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalSmi.g:2583:2: rule__TypeReferenceExt__ChildRefAssignment_1
        {
        pushFollow(FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_synpred33_InternalSmi5311);
        rule__TypeReferenceExt__ChildRefAssignment_1();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalSmi

    // Delegated rules

    public final boolean synpred33_InternalSmi() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalSmi_fragment(); // can never throw exception
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
        "\3\4\1\23\3\uffff";
    static final String DFA1_maxS =
        "\1\4\2\10\1\31\3\uffff";
    static final String DFA1_acceptS =
        "\4\uffff\1\1\1\3\1\2";
    static final String DFA1_specialS =
        "\7\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\4\1\uffff\1\3",
            "\1\2\1\uffff\1\4\1\uffff\1\3",
            "\1\6\5\uffff\1\5",
            "",
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
            return "769:1: rule__Module__Alternatives_5 : ( ( ( rule__Module__IdentifiersAssignment_5_0 ) ) | ( ( rule__Module__TypesAssignment_5_1 ) ) | ( ( rule__Module__MacrosAssignment_5_2 ) ) );";
        }
    }
    static final String DFA20_eotS =
        "\5\uffff";
    static final String DFA20_eofS =
        "\5\uffff";
    static final String DFA20_minS =
        "\3\4\2\uffff";
    static final String DFA20_maxS =
        "\1\4\2\35\2\uffff";
    static final String DFA20_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA20_specialS =
        "\5\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1",
            "\1\2\3\uffff\2\4\21\uffff\1\3\1\uffff\1\4",
            "\1\2\3\uffff\2\4\21\uffff\1\3\1\uffff\1\4",
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
            return "()* loopback of 2102:1: ( rule__Macro__TypeNotationsAssignment_9 )*";
        }
    }
    static final String DFA23_eotS =
        "\5\uffff";
    static final String DFA23_eofS =
        "\5\uffff";
    static final String DFA23_minS =
        "\3\4\2\uffff";
    static final String DFA23_maxS =
        "\1\4\2\25\2\uffff";
    static final String DFA23_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA23_specialS =
        "\5\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1",
            "\1\2\3\uffff\1\3\14\uffff\1\4",
            "\1\2\3\uffff\1\3\14\uffff\1\4",
            "",
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
            return "()* loopback of 2294:1: ( rule__Macro__InnerTypesAssignment_15 )*";
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
    public static final BitSet FOLLOW_ruleTypeAssignment_in_entryRuleTypeAssignment376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAssignment383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Group__0_in_ruleTypeAssignment409 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__0_in_ruleValue709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_entryRuleValueType736 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueType743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__Alternatives_in_ruleValueType769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_entryRuleMacroValue796 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMacroValue803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__0_in_ruleMacroValue829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_entryRuleMACRO_VALUE_TYPE856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_TYPE863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__Alternatives_in_ruleMACRO_VALUE_TYPE889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_entryRuleUpdateType916 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpdateType923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__0_in_ruleUpdateType949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_entryRuleMACRO_VALUE_CAP976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMACRO_VALUE_CAP983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_CAP__Alternatives_in_ruleMACRO_VALUE_CAP1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_entryRuleASN1_TYPE1036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_TYPE1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_TYPE__Alternatives_in_ruleASN1_TYPE1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_entryRuleASN1_SIMPLE1096 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SIMPLE1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Alternatives_in_ruleASN1_SIMPLE1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_entryRuleASN1_OCTET_STRING1156 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_OCTET_STRING1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__0_in_ruleASN1_OCTET_STRING1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_entryRuleASN1_INTEGER1216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_INTEGER1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__0_in_ruleASN1_INTEGER1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_entryRuleASN1_SUBTYPE1276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_SUBTYPE1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__0_in_ruleASN1_SUBTYPE1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_entryRuleASN1_RANGE1336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_RANGE1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Alternatives_in_ruleASN1_RANGE1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_entryRuleASN1_VALUEPAIR1396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_VALUEPAIR1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__0_in_ruleASN1_VALUEPAIR1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_entryRuleASN1_CHOICE1456 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE1463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__0_in_ruleASN1_CHOICE1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_entryRuleASN1_CHOICE_ENTRY1516 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASN1_CHOICE_ENTRY1523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0_in_ruleASN1_CHOICE_ENTRY1549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__IdentifiersAssignment_5_0_in_rule__Module__Alternatives_51585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__TypesAssignment_5_1_in_rule__Module__Alternatives_51603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__MacrosAssignment_5_2_in_rule__Module__Alternatives_51621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__RootAssignment_0_0_in_rule__ObjectIdentifierValue__Alternatives_01654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_1_in_rule__ObjectIdentifierValue__Alternatives_01672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_rule__TypeAssignment__Alternatives_11705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeAssignment__Alternatives_11722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__TypeAssignment__Alternatives_11739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeNotation__Alternatives1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeNotation__ValueAssignment_1_in_rule__TypeNotation__Alternatives1788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__ParamAssignment_0_in_rule__ValueType__Alternatives1821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__TypesAssignment_1_in_rule__ValueType__Alternatives1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__SimpleTypeAssignment_2_in_rule__ValueType__Alternatives1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__MacroValueAssignment_3_in_rule__ValueType__Alternatives1875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueType__OiAssignment_4_in_rule__ValueType__Alternatives1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__UpdateAssignment_0_in_rule__MACRO_VALUE_TYPE__Alternatives1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MACRO_VALUE_TYPE__LiteralAssignment_1_in_rule__MACRO_VALUE_TYPE__Alternatives1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__MACRO_VALUE_CAP__Alternatives1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__MACRO_VALUE_CAP__Alternatives1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SIMPLE_in_rule__ASN1_TYPE__Alternatives2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_in_rule__ASN1_TYPE__Alternatives2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__0_in_rule__ASN1_SIMPLE__Alternatives2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__0_in_rule__ASN1_SIMPLE__Alternatives2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__0_in_rule__ASN1_SIMPLE__Alternatives2117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__0_in_rule__ASN1_SIMPLE__Alternatives2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__0_in_rule__ASN1_RANGE__Alternatives2168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__0_in_rule__ASN1_RANGE__Alternatives2186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__02217 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Module__Group__1_in_rule__Module__Group__02220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__NameAssignment_0_in_rule__Module__Group__0__Impl2247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__12277 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Module__Group__2_in_rule__Module__Group__12280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Module__Group__1__Impl2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__22339 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Module__Group__3_in_rule__Module__Group__22342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Module__Group__2__Impl2370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__3__Impl_in_rule__Module__Group__32401 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Module__Group__4_in_rule__Module__Group__32404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Module__Group__3__Impl2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__4__Impl_in_rule__Module__Group__42463 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Module__Group__5_in_rule__Module__Group__42466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Module__Group__4__Impl2493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__5__Impl_in_rule__Module__Group__52522 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Module__Group__6_in_rule__Module__Group__52525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Alternatives_5_in_rule__Module__Group__5__Impl2554 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Module__Alternatives_5_in_rule__Module__Group__5__Impl2566 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Module__Group__6__Impl_in_rule__Module__Group__62599 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Module__Group__7_in_rule__Module__Group__62602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Module__Group__6__Impl2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__7__Impl_in_rule__Module__Group__72658 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Module__Group__8_in_rule__Module__Group__72661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Module__Group__7__Impl2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__8__Impl_in_rule__Module__Group__82720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Module__Group__8__Impl2748 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__0__Impl_in_rule__ObjectIdentifier__Group__02797 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__1_in_rule__ObjectIdentifier__Group__02800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ObjectIdentifier__Group__0__Impl2830 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__ObjectIdentifier__Group__0__Impl2843 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__1__Impl_in_rule__ObjectIdentifier__Group__12876 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__2_in_rule__ObjectIdentifier__Group__12879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__NameAssignment_1_in_rule__ObjectIdentifier__Group__1__Impl2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__2__Impl_in_rule__ObjectIdentifier__Group__22936 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__3_in_rule__ObjectIdentifier__Group__22939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ObjectIdentifier__Group__2__Impl2967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__3__Impl_in_rule__ObjectIdentifier__Group__32998 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__4_in_rule__ObjectIdentifier__Group__33001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ObjectIdentifier__Group__3__Impl3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__4__Impl_in_rule__ObjectIdentifier__Group__43060 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__5_in_rule__ObjectIdentifier__Group__43063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ObjectIdentifier__Group__4__Impl3091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__5__Impl_in_rule__ObjectIdentifier__Group__53122 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__6_in_rule__ObjectIdentifier__Group__53125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__OidValueAssignment_5_in_rule__ObjectIdentifier__Group__5__Impl3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifier__Group__6__Impl_in_rule__ObjectIdentifier__Group__63182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ObjectIdentifier__Group__6__Impl3210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__0__Impl_in_rule__ObjectIdentifierValue__Group__03255 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__1_in_rule__ObjectIdentifierValue__Group__03258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Alternatives_0_in_rule__ObjectIdentifierValue__Group__0__Impl3285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__1__Impl_in_rule__ObjectIdentifierValue__Group__13316 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__2_in_rule__ObjectIdentifierValue__Group__13319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_1_in_rule__ObjectIdentifierValue__Group__1__Impl3346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__Group__2__Impl_in_rule__ObjectIdentifierValue__Group__23376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__SubIdsAssignment_2_in_rule__ObjectIdentifierValue__Group__2__Impl3403 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__0__Impl_in_rule__TypeDefinition__Group__03440 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__1_in_rule__TypeDefinition__Group__03443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__TypeDefinition__Group__0__Impl3473 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__TypeDefinition__Group__0__Impl3486 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__1__Impl_in_rule__TypeDefinition__Group__13519 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__2_in_rule__TypeDefinition__Group__13522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__NameAssignment_1_in_rule__TypeDefinition__Group__1__Impl3549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__2__Impl_in_rule__TypeDefinition__Group__23579 = new BitSet(new long[]{0x000000D220400330L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__3_in_rule__TypeDefinition__Group__23582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__TypeDefinition__Group__2__Impl3610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__Group__3__Impl_in_rule__TypeDefinition__Group__33641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeDefinition__ValuesAssignment_3_in_rule__TypeDefinition__Group__3__Impl3670 = new BitSet(new long[]{0x000000D220400332L});
    public static final BitSet FOLLOW_rule__TypeDefinition__ValuesAssignment_3_in_rule__TypeDefinition__Group__3__Impl3682 = new BitSet(new long[]{0x000000D220400332L});
    public static final BitSet FOLLOW_rule__Macro__Group__0__Impl_in_rule__Macro__Group__03723 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Macro__Group__1_in_rule__Macro__Group__03726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__0__Impl3756 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__0__Impl3769 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__Group__1__Impl_in_rule__Macro__Group__13802 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__2_in_rule__Macro__Group__13805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__NameAssignment_1_in_rule__Macro__Group__1__Impl3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__2__Impl_in_rule__Macro__Group__23862 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Macro__Group__3_in_rule__Macro__Group__23865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Macro__Group__2__Impl3893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__3__Impl_in_rule__Macro__Group__33924 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__4_in_rule__Macro__Group__33927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Macro__Group__3__Impl3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__4__Impl_in_rule__Macro__Group__43986 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Macro__Group__5_in_rule__Macro__Group__43989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__4__Impl4016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__5__Impl_in_rule__Macro__Group__54045 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__6_in_rule__Macro__Group__54048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Macro__Group__5__Impl4076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__6__Impl_in_rule__Macro__Group__64107 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__7_in_rule__Macro__Group__64110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__6__Impl4140 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__6__Impl4153 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__Group__7__Impl_in_rule__Macro__Group__74186 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Macro__Group__8_in_rule__Macro__Group__74189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Macro__Group__7__Impl4217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__8__Impl_in_rule__Macro__Group__84248 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__9_in_rule__Macro__Group__84251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Macro__Group__8__Impl4279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__9__Impl_in_rule__Macro__Group__94310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__10_in_rule__Macro__Group__94313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__TypeNotationsAssignment_9_in_rule__Macro__Group__9__Impl4342 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__TypeNotationsAssignment_9_in_rule__Macro__Group__9__Impl4354 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__Group__10__Impl_in_rule__Macro__Group__104387 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__Macro__Group__11_in_rule__Macro__Group__104390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__10__Impl4420 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__10__Impl4433 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__Group__11__Impl_in_rule__Macro__Group__114466 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Macro__Group__12_in_rule__Macro__Group__114469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Macro__Group__11__Impl4497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__12__Impl_in_rule__Macro__Group__124528 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__13_in_rule__Macro__Group__124531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Macro__Group__12__Impl4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__13__Impl_in_rule__Macro__Group__134590 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__14_in_rule__Macro__Group__134593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__13__Impl4621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__14__Impl_in_rule__Macro__Group__144652 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__15_in_rule__Macro__Group__144655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__ValueNotationAssignment_14_in_rule__Macro__Group__14__Impl4682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__Group__15__Impl_in_rule__Macro__Group__154712 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Macro__Group__16_in_rule__Macro__Group__154715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Macro__InnerTypesAssignment_15_in_rule__Macro__Group__15__Impl4744 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__InnerTypesAssignment_15_in_rule__Macro__Group__15__Impl4756 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__Group__16__Impl_in_rule__Macro__Group__164789 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Macro__Group__17_in_rule__Macro__Group__164792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__16__Impl4822 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Macro__Group__16__Impl4835 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Macro__Group__17__Impl_in_rule__Macro__Group__174868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Macro__Group__17__Impl4896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Group__0__Impl_in_rule__TypeAssignment__Group__04963 = new BitSet(new long[]{0x0000000020000300L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Group__1_in_rule__TypeAssignment__Group__04966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__TypeAssignment__Group__0__Impl4996 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__TypeAssignment__Group__0__Impl5009 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Group__1__Impl_in_rule__TypeAssignment__Group__15042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeAssignment__Alternatives_1_in_rule__TypeAssignment__Group__1__Impl5069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__0__Impl_in_rule__ParamAssignment__Group__05103 = new BitSet(new long[]{0x0000000020000100L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__1_in_rule__ParamAssignment__Group__05106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__ParamAssignment_0_in_rule__ParamAssignment__Group__0__Impl5133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__Group__1__Impl_in_rule__ParamAssignment__Group__15163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParamAssignment__RightAssignment_1_in_rule__ParamAssignment__Group__1__Impl5190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__0__Impl_in_rule__TypeReferenceExt__Group__05224 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__1_in_rule__TypeReferenceExt__Group__05227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__ParentRefAssignment_0_in_rule__TypeReferenceExt__Group__0__Impl5254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__Group__1__Impl_in_rule__TypeReferenceExt__Group__15284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_rule__TypeReferenceExt__Group__1__Impl5311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__0__Impl_in_rule__Value__Group__05346 = new BitSet(new long[]{0x000000D220400330L});
    public static final BitSet FOLLOW_rule__Value__Group__1_in_rule__Value__Group__05349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Value__Group__0__Impl5377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__1__Impl_in_rule__Value__Group__15408 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_rule__Value__Group__2_in_rule__Value__Group__15411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ValueTypesAssignment_1_in_rule__Value__Group__1__Impl5438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group__2__Impl_in_rule__Value__Group__25468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_2__0_in_rule__Value__Group__2__Impl5495 = new BitSet(new long[]{0x0000000010000012L});
    public static final BitSet FOLLOW_rule__Value__Group_2__0__Impl_in_rule__Value__Group_2__05532 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_rule__Value__Group_2__1_in_rule__Value__Group_2__05535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Value__Group_2__0__Impl5563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_2__1__Impl_in_rule__Value__Group_2__15594 = new BitSet(new long[]{0x000000D220400330L});
    public static final BitSet FOLLOW_rule__Value__Group_2__2_in_rule__Value__Group_2__15597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Value__Group_2__1__Impl5625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Group_2__2__Impl_in_rule__Value__Group_2__25656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__ValueTypesAssignment_2_2_in_rule__Value__Group_2__2__Impl5683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__0__Impl_in_rule__MacroValue__Group__05719 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__1_in_rule__MacroValue__Group__05722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__1__Impl_in_rule__MacroValue__Group__15780 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__2_in_rule__MacroValue__Group__15783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__MacroValue__Group__1__Impl5811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__2__Impl_in_rule__MacroValue__Group__25842 = new BitSet(new long[]{0x0000000100030000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__3_in_rule__MacroValue__Group__25845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__MacroValue__Group__2__Impl5873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__3__Impl_in_rule__MacroValue__Group__35904 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__4_in_rule__MacroValue__Group__35907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__ValueTypeAssignment_3_in_rule__MacroValue__Group__3__Impl5934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MacroValue__Group__4__Impl_in_rule__MacroValue__Group__45964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__MacroValue__Group__4__Impl5992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__0__Impl_in_rule__UpdateType__Group__06033 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__1_in_rule__UpdateType__Group__06036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__UpdateType__Group__0__Impl6064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__Group__1__Impl_in_rule__UpdateType__Group__16095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UpdateType__TypeAssignment_1_in_rule__UpdateType__Group__1__Impl6122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__0__Impl_in_rule__ASN1_SIMPLE__Group_0__06156 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__1_in_rule__ASN1_SIMPLE__Group_0__06159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_0__1__Impl_in_rule__ASN1_SIMPLE__Group_0__16217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ASN1_SIMPLE__Group_0__1__Impl6245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__0__Impl_in_rule__ASN1_SIMPLE__Group_1__06280 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__1_in_rule__ASN1_SIMPLE__Group_1__06283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_1__1__Impl_in_rule__ASN1_SIMPLE__Group_1__16341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IA5STRING_in_rule__ASN1_SIMPLE__Group_1__1__Impl6368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__0__Impl_in_rule__ASN1_SIMPLE__Group_2__06401 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__1_in_rule__ASN1_SIMPLE__Group_2__06404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_OCTET_STRING_in_rule__ASN1_SIMPLE__Group_2__0__Impl6431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_2__1__Impl_in_rule__ASN1_SIMPLE__Group_2__16460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_2_1_in_rule__ASN1_SIMPLE__Group_2__1__Impl6487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__0__Impl_in_rule__ASN1_SIMPLE__Group_3__06522 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__1_in_rule__ASN1_SIMPLE__Group_3__06525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_INTEGER_in_rule__ASN1_SIMPLE__Group_3__0__Impl6552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__Group_3__1__Impl_in_rule__ASN1_SIMPLE__Group_3__16581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SIMPLE__ConstraintAssignment_3_1_in_rule__ASN1_SIMPLE__Group_3__1__Impl6608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__0__Impl_in_rule__ASN1_OCTET_STRING__Group__06643 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__1_in_rule__ASN1_OCTET_STRING__Group__06646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__Group__1__Impl_in_rule__ASN1_OCTET_STRING__Group__16704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_OCTET_STRING__NameAssignment_1_in_rule__ASN1_OCTET_STRING__Group__1__Impl6731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__0__Impl_in_rule__ASN1_INTEGER__Group__06765 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__1_in_rule__ASN1_INTEGER__Group__06768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__NameAssignment_0_in_rule__ASN1_INTEGER__Group__0__Impl6795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__1__Impl_in_rule__ASN1_INTEGER__Group__16825 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__2_in_rule__ASN1_INTEGER__Group__16828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ASN1_INTEGER__Group__1__Impl6856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__2__Impl_in_rule__ASN1_INTEGER__Group__26887 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__3_in_rule__ASN1_INTEGER__Group__26890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6919 = new BitSet(new long[]{0x0000000040000042L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__ValuePairsAssignment_2_in_rule__ASN1_INTEGER__Group__2__Impl6931 = new BitSet(new long[]{0x0000000040000042L});
    public static final BitSet FOLLOW_rule__ASN1_INTEGER__Group__3__Impl_in_rule__ASN1_INTEGER__Group__36964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ASN1_INTEGER__Group__3__Impl6992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__0__Impl_in_rule__ASN1_SUBTYPE__Group__07031 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__1_in_rule__ASN1_SUBTYPE__Group__07034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ASN1_SUBTYPE__Group__0__Impl7062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__1__Impl_in_rule__ASN1_SUBTYPE__Group__17093 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__2_in_rule__ASN1_SUBTYPE__Group__17096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ASN1_SUBTYPE__Group__1__Impl7124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__2__Impl_in_rule__ASN1_SUBTYPE__Group__27155 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__3_in_rule__ASN1_SUBTYPE__Group__27158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ASN1_SUBTYPE__Group__2__Impl7186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__3__Impl_in_rule__ASN1_SUBTYPE__Group__37217 = new BitSet(new long[]{0x0000000090000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__4_in_rule__ASN1_SUBTYPE__Group__37220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_3_in_rule__ASN1_SUBTYPE__Group__3__Impl7247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__4__Impl_in_rule__ASN1_SUBTYPE__Group__47277 = new BitSet(new long[]{0x0000000090000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__5_in_rule__ASN1_SUBTYPE__Group__47280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__0_in_rule__ASN1_SUBTYPE__Group__4__Impl7307 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__5__Impl_in_rule__ASN1_SUBTYPE__Group__57338 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__6_in_rule__ASN1_SUBTYPE__Group__57341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ASN1_SUBTYPE__Group__5__Impl7369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group__6__Impl_in_rule__ASN1_SUBTYPE__Group__67400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ASN1_SUBTYPE__Group__6__Impl7428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__0__Impl_in_rule__ASN1_SUBTYPE__Group_4__07473 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__1_in_rule__ASN1_SUBTYPE__Group_4__07476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ASN1_SUBTYPE__Group_4__0__Impl7504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__Group_4__1__Impl_in_rule__ASN1_SUBTYPE__Group_4__17535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_SUBTYPE__RangesAssignment_4_1_in_rule__ASN1_SUBTYPE__Group_4__1__Impl7562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__0__Impl_in_rule__ASN1_RANGE__Group_0__07596 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__1_in_rule__ASN1_RANGE__Group_0__07599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_0__1__Impl_in_rule__ASN1_RANGE__Group_0__17657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__ValueAssignment_0_1_in_rule__ASN1_RANGE__Group_0__1__Impl7684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__0__Impl_in_rule__ASN1_RANGE__Group_1__07718 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__1_in_rule__ASN1_RANGE__Group_1__07721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__StartAssignment_1_0_in_rule__ASN1_RANGE__Group_1__0__Impl7748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__1__Impl_in_rule__ASN1_RANGE__Group_1__17778 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__2_in_rule__ASN1_RANGE__Group_1__17781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ASN1_RANGE__Group_1__1__Impl7809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__Group_1__2__Impl_in_rule__ASN1_RANGE__Group_1__27840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_RANGE__EndAssignment_1_2_in_rule__ASN1_RANGE__Group_1__2__Impl7867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__0__Impl_in_rule__ASN1_VALUEPAIR__Group__07903 = new BitSet(new long[]{0x0000000040000040L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__1_in_rule__ASN1_VALUEPAIR__Group__07906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ASN1_VALUEPAIR__Group__0__Impl7934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__1__Impl_in_rule__ASN1_VALUEPAIR__Group__17965 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__2_in_rule__ASN1_VALUEPAIR__Group__17968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ASN1_VALUEPAIR__Group__1__Impl7996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__2__Impl_in_rule__ASN1_VALUEPAIR__Group__28027 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__3_in_rule__ASN1_VALUEPAIR__Group__28030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_VALUEPAIR__Group__2__Impl8057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_VALUEPAIR__Group__3__Impl_in_rule__ASN1_VALUEPAIR__Group__38086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ASN1_VALUEPAIR__Group__3__Impl8114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__0__Impl_in_rule__ASN1_CHOICE__Group__08153 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__1_in_rule__ASN1_CHOICE__Group__08156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ASN1_CHOICE__Group__0__Impl8184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__1__Impl_in_rule__ASN1_CHOICE__Group__18215 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__2_in_rule__ASN1_CHOICE__Group__18218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ASN1_CHOICE__Group__1__Impl8246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__2__Impl_in_rule__ASN1_CHOICE__Group__28277 = new BitSet(new long[]{0x0000002001000000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__3_in_rule__ASN1_CHOICE__Group__28280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_2_in_rule__ASN1_CHOICE__Group__2__Impl8307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__3__Impl_in_rule__ASN1_CHOICE__Group__38337 = new BitSet(new long[]{0x0000002001000000L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__4_in_rule__ASN1_CHOICE__Group__38340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__0_in_rule__ASN1_CHOICE__Group__3__Impl8367 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group__4__Impl_in_rule__ASN1_CHOICE__Group__48398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ASN1_CHOICE__Group__4__Impl8426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__0__Impl_in_rule__ASN1_CHOICE__Group_3__08467 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__1_in_rule__ASN1_CHOICE__Group_3__08470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__ASN1_CHOICE__Group_3__0__Impl8498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__Group_3__1__Impl_in_rule__ASN1_CHOICE__Group_3__18529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE__ChoicesAssignment_3_1_in_rule__ASN1_CHOICE__Group_3__1__Impl8556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__0__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__08590 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1_in_rule__ASN1_CHOICE_ENTRY__Group__08593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__IdAssignment_0_in_rule__ASN1_CHOICE_ENTRY__Group__0__Impl8620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__Group__1__Impl_in_rule__ASN1_CHOICE_ENTRY__Group__18650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_1_in_rule__ASN1_CHOICE_ENTRY__Group__1__Impl8677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__Module__NameAssignment_08716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifier_in_rule__Module__IdentifiersAssignment_5_08747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_rule__Module__TypesAssignment_5_18778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacro_in_rule__Module__MacrosAssignment_5_28809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifier__NameAssignment_18840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjectIdentifierValue_in_rule__ObjectIdentifier__OidValueAssignment_58871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__RootAssignment_0_08902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ObjectIdentifierValue__DescriptorReferenceAssignment_0_18937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_18972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ObjectIdentifierValue__SubIdsAssignment_29003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__TypeDefinition__NameAssignment_19034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__TypeDefinition__ValuesAssignment_39065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__Macro__NameAssignment_19096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAssignment_in_rule__Macro__TypeNotationsAssignment_99127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__Macro__ValueNotationAssignment_149158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_rule__Macro__InnerTypesAssignment_159189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_PARAMETER_in_rule__ParamAssignment__ParamAssignment_09220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNotation_in_rule__ParamAssignment__RightAssignment_19251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__TypeNotation__ValueAssignment_19282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ParentRefAssignment_09313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReference_in_rule__TypeReferenceExt__ChildRefAssignment_19344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__TypeReference__TypeAssignment9379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_19414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueType_in_rule__Value__ValueTypesAssignment_2_29445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParamAssignment_in_rule__ValueType__ParamAssignment_09476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeReferenceExt_in_rule__ValueType__TypesAssignment_19507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_TYPE_in_rule__ValueType__SimpleTypeAssignment_29538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMacroValue_in_rule__ValueType__MacroValueAssignment_39569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ValueType__OiAssignment_49605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_TYPE_in_rule__MacroValue__ValueTypeAssignment_39644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpdateType_in_rule__MACRO_VALUE_TYPE__UpdateAssignment_09675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMACRO_VALUE_CAP_in_rule__MACRO_VALUE_TYPE__LiteralAssignment_19706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MODULE_ID_in_rule__UpdateType__TypeAssignment_19741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_SUBTYPE_in_rule__ASN1_SIMPLE__ConstraintAssignment_2_19776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SIMPLE__ConstraintAssignment_3_19807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__ASN1_OCTET_STRING__NameAssignment_19843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__ASN1_INTEGER__NameAssignment_09887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_VALUEPAIR_in_rule__ASN1_INTEGER__ValuePairsAssignment_29926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_39957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_RANGE_in_rule__ASN1_SUBTYPE__RangesAssignment_4_19988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_RANGE__ValueAssignment_0_110019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_RANGE__StartAssignment_1_010050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__ASN1_RANGE__EndAssignment_1_210081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_210112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleASN1_CHOICE_ENTRY_in_rule__ASN1_CHOICE__ChoicesAssignment_3_110143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__IdAssignment_010174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ASN1_ID_in_rule__ASN1_CHOICE_ENTRY__ValueTypeAssignment_110209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ObjectIdentifierValue__RootAssignment_0_0_in_synpred3_InternalSmi1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TypeReferenceExt__ChildRefAssignment_1_in_synpred33_InternalSmi5311 = new BitSet(new long[]{0x0000000000000002L});

}