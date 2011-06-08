package com.netxforge.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import com.netxforge.services.NetxscriptGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalNetxscriptParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_NUMBER", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'-'", "'+'", "'false'", "'count()'", "'sum()'", "'min()'", "'max()'", "'mean()'", "'deviation()'", "'mod'", "'import'", "'def'", "'('", "')'", "','", "'{'", "'}'", "';'", "'return'", "'if'", "'else'", "'while'", "'var'", "'='", "'&&'", "'||'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'*'", "'/'", "'%'", "'.'", "'['", "']'", "'this'", "'->'", "'RES'", "'LINK'", "'!'", "'true'"
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
    public static final int T__55=55;
    public static final int T__19=19;
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
    public String getGrammarFileName() { return "../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g"; }


     
     	private NetxscriptGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(NetxscriptGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleMod"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:61:1: entryRuleMod : ruleMod EOF ;
    public final void entryRuleMod() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:62:1: ( ruleMod EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:63:1: ruleMod EOF
            {
             before(grammarAccess.getModRule()); 
            pushFollow(FOLLOW_ruleMod_in_entryRuleMod61);
            ruleMod();

            state._fsp--;

             after(grammarAccess.getModRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMod68); 

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
    // $ANTLR end "entryRuleMod"


    // $ANTLR start "ruleMod"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:70:1: ruleMod : ( ( rule__Mod__Group__0 ) ) ;
    public final void ruleMod() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:74:2: ( ( ( rule__Mod__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:75:1: ( ( rule__Mod__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:75:1: ( ( rule__Mod__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:76:1: ( rule__Mod__Group__0 )
            {
             before(grammarAccess.getModAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:77:1: ( rule__Mod__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:77:2: rule__Mod__Group__0
            {
            pushFollow(FOLLOW_rule__Mod__Group__0_in_ruleMod94);
            rule__Mod__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMod"


    // $ANTLR start "entryRuleImport"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:91:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:92:1: ( ruleImport EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:93:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport123);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport130); 

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:100:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:104:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:105:1: ( ( rule__Import__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:105:1: ( ( rule__Import__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:106:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:107:1: ( rule__Import__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:107:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport156);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleFunction"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:119:1: entryRuleFunction : ruleFunction EOF ;
    public final void entryRuleFunction() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:120:1: ( ruleFunction EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:121:1: ruleFunction EOF
            {
             before(grammarAccess.getFunctionRule()); 
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction183);
            ruleFunction();

            state._fsp--;

             after(grammarAccess.getFunctionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction190); 

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
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:128:1: ruleFunction : ( ( rule__Function__Group__0 ) ) ;
    public final void ruleFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:132:2: ( ( ( rule__Function__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:133:1: ( ( rule__Function__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:133:1: ( ( rule__Function__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:134:1: ( rule__Function__Group__0 )
            {
             before(grammarAccess.getFunctionAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:135:1: ( rule__Function__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:135:2: rule__Function__Group__0
            {
            pushFollow(FOLLOW_rule__Function__Group__0_in_ruleFunction216);
            rule__Function__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleArgument"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:147:1: entryRuleArgument : ruleArgument EOF ;
    public final void entryRuleArgument() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:148:1: ( ruleArgument EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:149:1: ruleArgument EOF
            {
             before(grammarAccess.getArgumentRule()); 
            pushFollow(FOLLOW_ruleArgument_in_entryRuleArgument243);
            ruleArgument();

            state._fsp--;

             after(grammarAccess.getArgumentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgument250); 

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
    // $ANTLR end "entryRuleArgument"


    // $ANTLR start "ruleArgument"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:156:1: ruleArgument : ( ( rule__Argument__NameAssignment ) ) ;
    public final void ruleArgument() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:160:2: ( ( ( rule__Argument__NameAssignment ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:161:1: ( ( rule__Argument__NameAssignment ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:161:1: ( ( rule__Argument__NameAssignment ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:162:1: ( rule__Argument__NameAssignment )
            {
             before(grammarAccess.getArgumentAccess().getNameAssignment()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:163:1: ( rule__Argument__NameAssignment )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:163:2: rule__Argument__NameAssignment
            {
            pushFollow(FOLLOW_rule__Argument__NameAssignment_in_ruleArgument276);
            rule__Argument__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getArgumentAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleBlock"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:179:1: entryRuleBlock : ruleBlock EOF ;
    public final void entryRuleBlock() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:180:1: ( ruleBlock EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:181:1: ruleBlock EOF
            {
             before(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock307);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getBlockRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock314); 

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
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:188:1: ruleBlock : ( ( rule__Block__Group__0 ) ) ;
    public final void ruleBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:192:2: ( ( ( rule__Block__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:193:1: ( ( rule__Block__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:193:1: ( ( rule__Block__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:194:1: ( rule__Block__Group__0 )
            {
             before(grammarAccess.getBlockAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:195:1: ( rule__Block__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:195:2: rule__Block__Group__0
            {
            pushFollow(FOLLOW_rule__Block__Group__0_in_ruleBlock340);
            rule__Block__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBlockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:207:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:208:1: ( ruleStatement EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:209:1: ruleStatement EOF
            {
             before(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement367);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement374); 

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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:216:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:220:2: ( ( ( rule__Statement__Alternatives ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:221:1: ( ( rule__Statement__Alternatives ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:221:1: ( ( rule__Statement__Alternatives ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:222:1: ( rule__Statement__Alternatives )
            {
             before(grammarAccess.getStatementAccess().getAlternatives()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:223:1: ( rule__Statement__Alternatives )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:223:2: rule__Statement__Alternatives
            {
            pushFollow(FOLLOW_rule__Statement__Alternatives_in_ruleStatement400);
            rule__Statement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStatementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleReturnStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:235:1: entryRuleReturnStatement : ruleReturnStatement EOF ;
    public final void entryRuleReturnStatement() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:236:1: ( ruleReturnStatement EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:237:1: ruleReturnStatement EOF
            {
             before(grammarAccess.getReturnStatementRule()); 
            pushFollow(FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement427);
            ruleReturnStatement();

            state._fsp--;

             after(grammarAccess.getReturnStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReturnStatement434); 

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
    // $ANTLR end "entryRuleReturnStatement"


    // $ANTLR start "ruleReturnStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:244:1: ruleReturnStatement : ( ( rule__ReturnStatement__Group__0 ) ) ;
    public final void ruleReturnStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:248:2: ( ( ( rule__ReturnStatement__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:249:1: ( ( rule__ReturnStatement__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:249:1: ( ( rule__ReturnStatement__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:250:1: ( rule__ReturnStatement__Group__0 )
            {
             before(grammarAccess.getReturnStatementAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:251:1: ( rule__ReturnStatement__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:251:2: rule__ReturnStatement__Group__0
            {
            pushFollow(FOLLOW_rule__ReturnStatement__Group__0_in_ruleReturnStatement460);
            rule__ReturnStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReturnStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReturnStatement"


    // $ANTLR start "entryRuleIfStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:263:1: entryRuleIfStatement : ruleIfStatement EOF ;
    public final void entryRuleIfStatement() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:264:1: ( ruleIfStatement EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:265:1: ruleIfStatement EOF
            {
             before(grammarAccess.getIfStatementRule()); 
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement487);
            ruleIfStatement();

            state._fsp--;

             after(grammarAccess.getIfStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement494); 

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
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:272:1: ruleIfStatement : ( ( rule__IfStatement__Group__0 ) ) ;
    public final void ruleIfStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:276:2: ( ( ( rule__IfStatement__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:277:1: ( ( rule__IfStatement__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:277:1: ( ( rule__IfStatement__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:278:1: ( rule__IfStatement__Group__0 )
            {
             before(grammarAccess.getIfStatementAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:279:1: ( rule__IfStatement__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:279:2: rule__IfStatement__Group__0
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__0_in_ruleIfStatement520);
            rule__IfStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIfStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleWhileStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:291:1: entryRuleWhileStatement : ruleWhileStatement EOF ;
    public final void entryRuleWhileStatement() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:292:1: ( ruleWhileStatement EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:293:1: ruleWhileStatement EOF
            {
             before(grammarAccess.getWhileStatementRule()); 
            pushFollow(FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement547);
            ruleWhileStatement();

            state._fsp--;

             after(grammarAccess.getWhileStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileStatement554); 

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
    // $ANTLR end "entryRuleWhileStatement"


    // $ANTLR start "ruleWhileStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:300:1: ruleWhileStatement : ( ( rule__WhileStatement__Group__0 ) ) ;
    public final void ruleWhileStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:304:2: ( ( ( rule__WhileStatement__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:305:1: ( ( rule__WhileStatement__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:305:1: ( ( rule__WhileStatement__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:306:1: ( rule__WhileStatement__Group__0 )
            {
             before(grammarAccess.getWhileStatementAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:307:1: ( rule__WhileStatement__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:307:2: rule__WhileStatement__Group__0
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__0_in_ruleWhileStatement580);
            rule__WhileStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWhileStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleVariableStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:319:1: entryRuleVariableStatement : ruleVariableStatement EOF ;
    public final void entryRuleVariableStatement() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:320:1: ( ruleVariableStatement EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:321:1: ruleVariableStatement EOF
            {
             before(grammarAccess.getVariableStatementRule()); 
            pushFollow(FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement607);
            ruleVariableStatement();

            state._fsp--;

             after(grammarAccess.getVariableStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableStatement614); 

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
    // $ANTLR end "entryRuleVariableStatement"


    // $ANTLR start "ruleVariableStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:328:1: ruleVariableStatement : ( ( rule__VariableStatement__Group__0 ) ) ;
    public final void ruleVariableStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:332:2: ( ( ( rule__VariableStatement__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:333:1: ( ( rule__VariableStatement__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:333:1: ( ( rule__VariableStatement__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:334:1: ( rule__VariableStatement__Group__0 )
            {
             before(grammarAccess.getVariableStatementAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:335:1: ( rule__VariableStatement__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:335:2: rule__VariableStatement__Group__0
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__0_in_ruleVariableStatement640);
            rule__VariableStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVariableStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariableStatement"


    // $ANTLR start "entryRuleAssignmentStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:347:1: entryRuleAssignmentStatement : ruleAssignmentStatement EOF ;
    public final void entryRuleAssignmentStatement() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:348:1: ( ruleAssignmentStatement EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:349:1: ruleAssignmentStatement EOF
            {
             before(grammarAccess.getAssignmentStatementRule()); 
            pushFollow(FOLLOW_ruleAssignmentStatement_in_entryRuleAssignmentStatement667);
            ruleAssignmentStatement();

            state._fsp--;

             after(grammarAccess.getAssignmentStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentStatement674); 

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
    // $ANTLR end "entryRuleAssignmentStatement"


    // $ANTLR start "ruleAssignmentStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:356:1: ruleAssignmentStatement : ( ( rule__AssignmentStatement__Group__0 ) ) ;
    public final void ruleAssignmentStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:360:2: ( ( ( rule__AssignmentStatement__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:361:1: ( ( rule__AssignmentStatement__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:361:1: ( ( rule__AssignmentStatement__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:362:1: ( rule__AssignmentStatement__Group__0 )
            {
             before(grammarAccess.getAssignmentStatementAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:363:1: ( rule__AssignmentStatement__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:363:2: rule__AssignmentStatement__Group__0
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__0_in_ruleAssignmentStatement700);
            rule__AssignmentStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignmentStatement"


    // $ANTLR start "entryRuleReferenceAssignmentStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:375:1: entryRuleReferenceAssignmentStatement : ruleReferenceAssignmentStatement EOF ;
    public final void entryRuleReferenceAssignmentStatement() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:376:1: ( ruleReferenceAssignmentStatement EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:377:1: ruleReferenceAssignmentStatement EOF
            {
             before(grammarAccess.getReferenceAssignmentStatementRule()); 
            pushFollow(FOLLOW_ruleReferenceAssignmentStatement_in_entryRuleReferenceAssignmentStatement727);
            ruleReferenceAssignmentStatement();

            state._fsp--;

             after(grammarAccess.getReferenceAssignmentStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceAssignmentStatement734); 

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
    // $ANTLR end "entryRuleReferenceAssignmentStatement"


    // $ANTLR start "ruleReferenceAssignmentStatement"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:384:1: ruleReferenceAssignmentStatement : ( ( rule__ReferenceAssignmentStatement__Group__0 ) ) ;
    public final void ruleReferenceAssignmentStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:388:2: ( ( ( rule__ReferenceAssignmentStatement__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:389:1: ( ( rule__ReferenceAssignmentStatement__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:389:1: ( ( rule__ReferenceAssignmentStatement__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:390:1: ( rule__ReferenceAssignmentStatement__Group__0 )
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:391:1: ( rule__ReferenceAssignmentStatement__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:391:2: rule__ReferenceAssignmentStatement__Group__0
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__0_in_ruleReferenceAssignmentStatement760);
            rule__ReferenceAssignmentStatement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAssignmentStatementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReferenceAssignmentStatement"


    // $ANTLR start "entryRuleExpression"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:403:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:404:1: ( ruleExpression EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:405:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression787);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression794); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:412:1: ruleExpression : ( ruleLogical ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:416:2: ( ( ruleLogical ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:417:1: ( ruleLogical )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:417:1: ( ruleLogical )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:418:1: ruleLogical
            {
             before(grammarAccess.getExpressionAccess().getLogicalParserRuleCall()); 
            pushFollow(FOLLOW_ruleLogical_in_ruleExpression820);
            ruleLogical();

            state._fsp--;

             after(grammarAccess.getExpressionAccess().getLogicalParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLogical"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:431:1: entryRuleLogical : ruleLogical EOF ;
    public final void entryRuleLogical() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:432:1: ( ruleLogical EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:433:1: ruleLogical EOF
            {
             before(grammarAccess.getLogicalRule()); 
            pushFollow(FOLLOW_ruleLogical_in_entryRuleLogical846);
            ruleLogical();

            state._fsp--;

             after(grammarAccess.getLogicalRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogical853); 

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
    // $ANTLR end "entryRuleLogical"


    // $ANTLR start "ruleLogical"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:440:1: ruleLogical : ( ( rule__Logical__Group__0 ) ) ;
    public final void ruleLogical() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:444:2: ( ( ( rule__Logical__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:445:1: ( ( rule__Logical__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:445:1: ( ( rule__Logical__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:446:1: ( rule__Logical__Group__0 )
            {
             before(grammarAccess.getLogicalAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:447:1: ( rule__Logical__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:447:2: rule__Logical__Group__0
            {
            pushFollow(FOLLOW_rule__Logical__Group__0_in_ruleLogical879);
            rule__Logical__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLogicalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLogical"


    // $ANTLR start "entryRuleEquality"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:459:1: entryRuleEquality : ruleEquality EOF ;
    public final void entryRuleEquality() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:460:1: ( ruleEquality EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:461:1: ruleEquality EOF
            {
             before(grammarAccess.getEqualityRule()); 
            pushFollow(FOLLOW_ruleEquality_in_entryRuleEquality906);
            ruleEquality();

            state._fsp--;

             after(grammarAccess.getEqualityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquality913); 

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
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:468:1: ruleEquality : ( ( rule__Equality__Group__0 ) ) ;
    public final void ruleEquality() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:472:2: ( ( ( rule__Equality__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:473:1: ( ( rule__Equality__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:473:1: ( ( rule__Equality__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:474:1: ( rule__Equality__Group__0 )
            {
             before(grammarAccess.getEqualityAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:475:1: ( rule__Equality__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:475:2: rule__Equality__Group__0
            {
            pushFollow(FOLLOW_rule__Equality__Group__0_in_ruleEquality939);
            rule__Equality__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEqualityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleComparison"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:487:1: entryRuleComparison : ruleComparison EOF ;
    public final void entryRuleComparison() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:488:1: ( ruleComparison EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:489:1: ruleComparison EOF
            {
             before(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_ruleComparison_in_entryRuleComparison966);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getComparisonRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparison973); 

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
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:496:1: ruleComparison : ( ( rule__Comparison__Group__0 ) ) ;
    public final void ruleComparison() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:500:2: ( ( ( rule__Comparison__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:501:1: ( ( rule__Comparison__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:501:1: ( ( rule__Comparison__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:502:1: ( rule__Comparison__Group__0 )
            {
             before(grammarAccess.getComparisonAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:503:1: ( rule__Comparison__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:503:2: rule__Comparison__Group__0
            {
            pushFollow(FOLLOW_rule__Comparison__Group__0_in_ruleComparison999);
            rule__Comparison__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleAddition"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:515:1: entryRuleAddition : ruleAddition EOF ;
    public final void entryRuleAddition() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:516:1: ( ruleAddition EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:517:1: ruleAddition EOF
            {
             before(grammarAccess.getAdditionRule()); 
            pushFollow(FOLLOW_ruleAddition_in_entryRuleAddition1026);
            ruleAddition();

            state._fsp--;

             after(grammarAccess.getAdditionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAddition1033); 

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
    // $ANTLR end "entryRuleAddition"


    // $ANTLR start "ruleAddition"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:524:1: ruleAddition : ( ( rule__Addition__Group__0 ) ) ;
    public final void ruleAddition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:528:2: ( ( ( rule__Addition__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:529:1: ( ( rule__Addition__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:529:1: ( ( rule__Addition__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:530:1: ( rule__Addition__Group__0 )
            {
             before(grammarAccess.getAdditionAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:531:1: ( rule__Addition__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:531:2: rule__Addition__Group__0
            {
            pushFollow(FOLLOW_rule__Addition__Group__0_in_ruleAddition1059);
            rule__Addition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAdditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAddition"


    // $ANTLR start "entryRuleMultiplication"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:543:1: entryRuleMultiplication : ruleMultiplication EOF ;
    public final void entryRuleMultiplication() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:544:1: ( ruleMultiplication EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:545:1: ruleMultiplication EOF
            {
             before(grammarAccess.getMultiplicationRule()); 
            pushFollow(FOLLOW_ruleMultiplication_in_entryRuleMultiplication1086);
            ruleMultiplication();

            state._fsp--;

             after(grammarAccess.getMultiplicationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplication1093); 

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
    // $ANTLR end "entryRuleMultiplication"


    // $ANTLR start "ruleMultiplication"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:552:1: ruleMultiplication : ( ( rule__Multiplication__Group__0 ) ) ;
    public final void ruleMultiplication() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:556:2: ( ( ( rule__Multiplication__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:557:1: ( ( rule__Multiplication__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:557:1: ( ( rule__Multiplication__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:558:1: ( rule__Multiplication__Group__0 )
            {
             before(grammarAccess.getMultiplicationAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:559:1: ( rule__Multiplication__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:559:2: rule__Multiplication__Group__0
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__0_in_ruleMultiplication1119);
            rule__Multiplication__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiplication"


    // $ANTLR start "entryRuleUnary"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:571:1: entryRuleUnary : ruleUnary EOF ;
    public final void entryRuleUnary() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:572:1: ( ruleUnary EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:573:1: ruleUnary EOF
            {
             before(grammarAccess.getUnaryRule()); 
            pushFollow(FOLLOW_ruleUnary_in_entryRuleUnary1146);
            ruleUnary();

            state._fsp--;

             after(grammarAccess.getUnaryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnary1153); 

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
    // $ANTLR end "entryRuleUnary"


    // $ANTLR start "ruleUnary"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:580:1: ruleUnary : ( ( rule__Unary__Alternatives ) ) ;
    public final void ruleUnary() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:584:2: ( ( ( rule__Unary__Alternatives ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:585:1: ( ( rule__Unary__Alternatives ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:585:1: ( ( rule__Unary__Alternatives ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:586:1: ( rule__Unary__Alternatives )
            {
             before(grammarAccess.getUnaryAccess().getAlternatives()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:587:1: ( rule__Unary__Alternatives )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:587:2: rule__Unary__Alternatives
            {
            pushFollow(FOLLOW_rule__Unary__Alternatives_in_ruleUnary1179);
            rule__Unary__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnaryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnary"


    // $ANTLR start "entryRuleUnaryOperator"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:599:1: entryRuleUnaryOperator : ruleUnaryOperator EOF ;
    public final void entryRuleUnaryOperator() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:600:1: ( ruleUnaryOperator EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:601:1: ruleUnaryOperator EOF
            {
             before(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator1206);
            ruleUnaryOperator();

            state._fsp--;

             after(grammarAccess.getUnaryOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryOperator1213); 

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
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:608:1: ruleUnaryOperator : ( ( rule__UnaryOperator__Alternatives ) ) ;
    public final void ruleUnaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:612:2: ( ( ( rule__UnaryOperator__Alternatives ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:613:1: ( ( rule__UnaryOperator__Alternatives ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:613:1: ( ( rule__UnaryOperator__Alternatives ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:614:1: ( rule__UnaryOperator__Alternatives )
            {
             before(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:615:1: ( rule__UnaryOperator__Alternatives )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:615:2: rule__UnaryOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator1239);
            rule__UnaryOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:627:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:628:1: ( rulePrimaryExpression EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:629:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1266);
            rulePrimaryExpression();

            state._fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression1273); 

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:636:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:640:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:641:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:641:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:642:1: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:643:1: ( rule__PrimaryExpression__Alternatives )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:643:2: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression1299);
            rule__PrimaryExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleLiteral"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:655:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:656:1: ( ruleLiteral EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:657:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1326);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1333); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:664:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:668:2: ( ( ( rule__Literal__Alternatives ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:669:1: ( ( rule__Literal__Alternatives ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:669:1: ( ( rule__Literal__Alternatives ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:670:1: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:671:1: ( rule__Literal__Alternatives )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:671:2: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_in_ruleLiteral1359);
            rule__Literal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:683:1: entryRuleParenthesizedExpression : ruleParenthesizedExpression EOF ;
    public final void entryRuleParenthesizedExpression() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:684:1: ( ruleParenthesizedExpression EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:685:1: ruleParenthesizedExpression EOF
            {
             before(grammarAccess.getParenthesizedExpressionRule()); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression1386);
            ruleParenthesizedExpression();

            state._fsp--;

             after(grammarAccess.getParenthesizedExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression1393); 

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
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:692:1: ruleParenthesizedExpression : ( ( rule__ParenthesizedExpression__Group__0 ) ) ;
    public final void ruleParenthesizedExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:696:2: ( ( ( rule__ParenthesizedExpression__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:697:1: ( ( rule__ParenthesizedExpression__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:697:1: ( ( rule__ParenthesizedExpression__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:698:1: ( rule__ParenthesizedExpression__Group__0 )
            {
             before(grammarAccess.getParenthesizedExpressionAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:699:1: ( rule__ParenthesizedExpression__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:699:2: rule__ParenthesizedExpression__Group__0
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__0_in_ruleParenthesizedExpression1419);
            rule__ParenthesizedExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParenthesizedExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleFunctionCall"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:711:1: entryRuleFunctionCall : ruleFunctionCall EOF ;
    public final void entryRuleFunctionCall() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:712:1: ( ruleFunctionCall EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:713:1: ruleFunctionCall EOF
            {
             before(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall1446);
            ruleFunctionCall();

            state._fsp--;

             after(grammarAccess.getFunctionCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionCall1453); 

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
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:720:1: ruleFunctionCall : ( ( rule__FunctionCall__Group__0 ) ) ;
    public final void ruleFunctionCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:724:2: ( ( ( rule__FunctionCall__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:725:1: ( ( rule__FunctionCall__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:725:1: ( ( rule__FunctionCall__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:726:1: ( rule__FunctionCall__Group__0 )
            {
             before(grammarAccess.getFunctionCallAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:727:1: ( rule__FunctionCall__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:727:2: rule__FunctionCall__Group__0
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__0_in_ruleFunctionCall1479);
            rule__FunctionCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleVarOrArgumentCall"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:739:1: entryRuleVarOrArgumentCall : ruleVarOrArgumentCall EOF ;
    public final void entryRuleVarOrArgumentCall() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:740:1: ( ruleVarOrArgumentCall EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:741:1: ruleVarOrArgumentCall EOF
            {
             before(grammarAccess.getVarOrArgumentCallRule()); 
            pushFollow(FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall1506);
            ruleVarOrArgumentCall();

            state._fsp--;

             after(grammarAccess.getVarOrArgumentCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarOrArgumentCall1513); 

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
    // $ANTLR end "entryRuleVarOrArgumentCall"


    // $ANTLR start "ruleVarOrArgumentCall"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:748:1: ruleVarOrArgumentCall : ( ( rule__VarOrArgumentCall__Group__0 ) ) ;
    public final void ruleVarOrArgumentCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:752:2: ( ( ( rule__VarOrArgumentCall__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:753:1: ( ( rule__VarOrArgumentCall__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:753:1: ( ( rule__VarOrArgumentCall__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:754:1: ( rule__VarOrArgumentCall__Group__0 )
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:755:1: ( rule__VarOrArgumentCall__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:755:2: rule__VarOrArgumentCall__Group__0
            {
            pushFollow(FOLLOW_rule__VarOrArgumentCall__Group__0_in_ruleVarOrArgumentCall1539);
            rule__VarOrArgumentCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVarOrArgumentCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVarOrArgumentCall"


    // $ANTLR start "entryRuleNativeExpression"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:767:1: entryRuleNativeExpression : ruleNativeExpression EOF ;
    public final void entryRuleNativeExpression() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:768:1: ( ruleNativeExpression EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:769:1: ruleNativeExpression EOF
            {
             before(grammarAccess.getNativeExpressionRule()); 
            pushFollow(FOLLOW_ruleNativeExpression_in_entryRuleNativeExpression1566);
            ruleNativeExpression();

            state._fsp--;

             after(grammarAccess.getNativeExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNativeExpression1573); 

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
    // $ANTLR end "entryRuleNativeExpression"


    // $ANTLR start "ruleNativeExpression"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:776:1: ruleNativeExpression : ( ( rule__NativeExpression__Group__0 ) ) ;
    public final void ruleNativeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:780:2: ( ( ( rule__NativeExpression__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:781:1: ( ( rule__NativeExpression__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:781:1: ( ( rule__NativeExpression__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:782:1: ( rule__NativeExpression__Group__0 )
            {
             before(grammarAccess.getNativeExpressionAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:783:1: ( rule__NativeExpression__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:783:2: rule__NativeExpression__Group__0
            {
            pushFollow(FOLLOW_rule__NativeExpression__Group__0_in_ruleNativeExpression1599);
            rule__NativeExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNativeExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNativeExpression"


    // $ANTLR start "entryRuleRange"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:795:1: entryRuleRange : ruleRange EOF ;
    public final void entryRuleRange() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:796:1: ( ruleRange EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:797:1: ruleRange EOF
            {
             before(grammarAccess.getRangeRule()); 
            pushFollow(FOLLOW_ruleRange_in_entryRuleRange1626);
            ruleRange();

            state._fsp--;

             after(grammarAccess.getRangeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRange1633); 

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
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:804:1: ruleRange : ( ruleRangeLiteral ) ;
    public final void ruleRange() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:808:2: ( ( ruleRangeLiteral ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:809:1: ( ruleRangeLiteral )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:809:1: ( ruleRangeLiteral )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:810:1: ruleRangeLiteral
            {
             before(grammarAccess.getRangeAccess().getRangeLiteralParserRuleCall()); 
            pushFollow(FOLLOW_ruleRangeLiteral_in_ruleRange1659);
            ruleRangeLiteral();

            state._fsp--;

             after(grammarAccess.getRangeAccess().getRangeLiteralParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleRangeLiteral"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:823:1: entryRuleRangeLiteral : ruleRangeLiteral EOF ;
    public final void entryRuleRangeLiteral() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:824:1: ( ruleRangeLiteral EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:825:1: ruleRangeLiteral EOF
            {
             before(grammarAccess.getRangeLiteralRule()); 
            pushFollow(FOLLOW_ruleRangeLiteral_in_entryRuleRangeLiteral1685);
            ruleRangeLiteral();

            state._fsp--;

             after(grammarAccess.getRangeLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeLiteral1692); 

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
    // $ANTLR end "entryRuleRangeLiteral"


    // $ANTLR start "ruleRangeLiteral"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:832:1: ruleRangeLiteral : ( ( rule__RangeLiteral__Group__0 ) ) ;
    public final void ruleRangeLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:836:2: ( ( ( rule__RangeLiteral__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:837:1: ( ( rule__RangeLiteral__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:837:1: ( ( rule__RangeLiteral__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:838:1: ( rule__RangeLiteral__Group__0 )
            {
             before(grammarAccess.getRangeLiteralAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:839:1: ( rule__RangeLiteral__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:839:2: rule__RangeLiteral__Group__0
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__0_in_ruleRangeLiteral1718);
            rule__RangeLiteral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRangeLiteralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRangeLiteral"


    // $ANTLR start "entryRuleReference"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:851:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:852:1: ( ruleReference EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:853:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference1745);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference1752); 

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
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:860:1: ruleReference : ( ruleContextRef ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:864:2: ( ( ruleContextRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:865:1: ( ruleContextRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:865:1: ( ruleContextRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:866:1: ruleContextRef
            {
             before(grammarAccess.getReferenceAccess().getContextRefParserRuleCall()); 
            pushFollow(FOLLOW_ruleContextRef_in_ruleReference1778);
            ruleContextRef();

            state._fsp--;

             after(grammarAccess.getReferenceAccess().getContextRefParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleContextRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:879:1: entryRuleContextRef : ruleContextRef EOF ;
    public final void entryRuleContextRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:880:1: ( ruleContextRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:881:1: ruleContextRef EOF
            {
             before(grammarAccess.getContextRefRule()); 
            pushFollow(FOLLOW_ruleContextRef_in_entryRuleContextRef1804);
            ruleContextRef();

            state._fsp--;

             after(grammarAccess.getContextRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextRef1811); 

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
    // $ANTLR end "entryRuleContextRef"


    // $ANTLR start "ruleContextRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:888:1: ruleContextRef : ( ( rule__ContextRef__Group__0 ) ) ;
    public final void ruleContextRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:892:2: ( ( ( rule__ContextRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:893:1: ( ( rule__ContextRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:893:1: ( ( rule__ContextRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:894:1: ( rule__ContextRef__Group__0 )
            {
             before(grammarAccess.getContextRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:895:1: ( rule__ContextRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:895:2: rule__ContextRef__Group__0
            {
            pushFollow(FOLLOW_rule__ContextRef__Group__0_in_ruleContextRef1837);
            rule__ContextRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getContextRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContextRef"


    // $ANTLR start "entryRuleNodeRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:907:1: entryRuleNodeRef : ruleNodeRef EOF ;
    public final void entryRuleNodeRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:908:1: ( ruleNodeRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:909:1: ruleNodeRef EOF
            {
             before(grammarAccess.getNodeRefRule()); 
            pushFollow(FOLLOW_ruleNodeRef_in_entryRuleNodeRef1864);
            ruleNodeRef();

            state._fsp--;

             after(grammarAccess.getNodeRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNodeRef1871); 

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
    // $ANTLR end "entryRuleNodeRef"


    // $ANTLR start "ruleNodeRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:916:1: ruleNodeRef : ( ( rule__NodeRef__Group__0 ) ) ;
    public final void ruleNodeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:920:2: ( ( ( rule__NodeRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:921:1: ( ( rule__NodeRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:921:1: ( ( rule__NodeRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:922:1: ( rule__NodeRef__Group__0 )
            {
             before(grammarAccess.getNodeRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:923:1: ( rule__NodeRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:923:2: rule__NodeRef__Group__0
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__0_in_ruleNodeRef1897);
            rule__NodeRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeRef"


    // $ANTLR start "entryRulePrimaryNodeRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:935:1: entryRulePrimaryNodeRef : rulePrimaryNodeRef EOF ;
    public final void entryRulePrimaryNodeRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:936:1: ( rulePrimaryNodeRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:937:1: rulePrimaryNodeRef EOF
            {
             before(grammarAccess.getPrimaryNodeRefRule()); 
            pushFollow(FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef1924);
            rulePrimaryNodeRef();

            state._fsp--;

             after(grammarAccess.getPrimaryNodeRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryNodeRef1931); 

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
    // $ANTLR end "entryRulePrimaryNodeRef"


    // $ANTLR start "rulePrimaryNodeRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:944:1: rulePrimaryNodeRef : ( ( rule__PrimaryNodeRef__Group__0 ) ) ;
    public final void rulePrimaryNodeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:948:2: ( ( ( rule__PrimaryNodeRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:949:1: ( ( rule__PrimaryNodeRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:949:1: ( ( rule__PrimaryNodeRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:950:1: ( rule__PrimaryNodeRef__Group__0 )
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:951:1: ( rule__PrimaryNodeRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:951:2: rule__PrimaryNodeRef__Group__0
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__0_in_rulePrimaryNodeRef1957);
            rule__PrimaryNodeRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryNodeRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryNodeRef"


    // $ANTLR start "entryRuleLeafRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:963:1: entryRuleLeafRef : ruleLeafRef EOF ;
    public final void entryRuleLeafRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:964:1: ( ruleLeafRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:965:1: ruleLeafRef EOF
            {
             before(grammarAccess.getLeafRefRule()); 
            pushFollow(FOLLOW_ruleLeafRef_in_entryRuleLeafRef1984);
            ruleLeafRef();

            state._fsp--;

             after(grammarAccess.getLeafRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLeafRef1991); 

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
    // $ANTLR end "entryRuleLeafRef"


    // $ANTLR start "ruleLeafRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:972:1: ruleLeafRef : ( ( rule__LeafRef__Alternatives ) ) ;
    public final void ruleLeafRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:976:2: ( ( ( rule__LeafRef__Alternatives ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:977:1: ( ( rule__LeafRef__Alternatives ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:977:1: ( ( rule__LeafRef__Alternatives ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:978:1: ( rule__LeafRef__Alternatives )
            {
             before(grammarAccess.getLeafRefAccess().getAlternatives()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:979:1: ( rule__LeafRef__Alternatives )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:979:2: rule__LeafRef__Alternatives
            {
            pushFollow(FOLLOW_rule__LeafRef__Alternatives_in_ruleLeafRef2017);
            rule__LeafRef__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLeafRefAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLeafRef"


    // $ANTLR start "entryRuleResourceRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:991:1: entryRuleResourceRef : ruleResourceRef EOF ;
    public final void entryRuleResourceRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:992:1: ( ruleResourceRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:993:1: ruleResourceRef EOF
            {
             before(grammarAccess.getResourceRefRule()); 
            pushFollow(FOLLOW_ruleResourceRef_in_entryRuleResourceRef2044);
            ruleResourceRef();

            state._fsp--;

             after(grammarAccess.getResourceRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResourceRef2051); 

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
    // $ANTLR end "entryRuleResourceRef"


    // $ANTLR start "ruleResourceRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1000:1: ruleResourceRef : ( ( rule__ResourceRef__Group__0 ) ) ;
    public final void ruleResourceRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1004:2: ( ( ( rule__ResourceRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1005:1: ( ( rule__ResourceRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1005:1: ( ( rule__ResourceRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1006:1: ( rule__ResourceRef__Group__0 )
            {
             before(grammarAccess.getResourceRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1007:1: ( rule__ResourceRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1007:2: rule__ResourceRef__Group__0
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__0_in_ruleResourceRef2077);
            rule__ResourceRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResourceRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResourceRef"


    // $ANTLR start "entryRuleLinkRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1019:1: entryRuleLinkRef : ruleLinkRef EOF ;
    public final void entryRuleLinkRef() throws RecognitionException {
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1020:1: ( ruleLinkRef EOF )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1021:1: ruleLinkRef EOF
            {
             before(grammarAccess.getLinkRefRule()); 
            pushFollow(FOLLOW_ruleLinkRef_in_entryRuleLinkRef2104);
            ruleLinkRef();

            state._fsp--;

             after(grammarAccess.getLinkRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLinkRef2111); 

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
    // $ANTLR end "entryRuleLinkRef"


    // $ANTLR start "ruleLinkRef"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1028:1: ruleLinkRef : ( ( rule__LinkRef__Group__0 ) ) ;
    public final void ruleLinkRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1032:2: ( ( ( rule__LinkRef__Group__0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1033:1: ( ( rule__LinkRef__Group__0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1033:1: ( ( rule__LinkRef__Group__0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1034:1: ( rule__LinkRef__Group__0 )
            {
             before(grammarAccess.getLinkRefAccess().getGroup()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1035:1: ( rule__LinkRef__Group__0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1035:2: rule__LinkRef__Group__0
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__0_in_ruleLinkRef2137);
            rule__LinkRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLinkRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLinkRef"


    // $ANTLR start "ruleNativeFunction"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1048:1: ruleNativeFunction : ( ( rule__NativeFunction__Alternatives ) ) ;
    public final void ruleNativeFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1052:1: ( ( ( rule__NativeFunction__Alternatives ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1053:1: ( ( rule__NativeFunction__Alternatives ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1053:1: ( ( rule__NativeFunction__Alternatives ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1054:1: ( rule__NativeFunction__Alternatives )
            {
             before(grammarAccess.getNativeFunctionAccess().getAlternatives()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1055:1: ( rule__NativeFunction__Alternatives )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1055:2: rule__NativeFunction__Alternatives
            {
            pushFollow(FOLLOW_rule__NativeFunction__Alternatives_in_ruleNativeFunction2174);
            rule__NativeFunction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNativeFunctionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNativeFunction"


    // $ANTLR start "rule__Mod__Alternatives_2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1066:1: rule__Mod__Alternatives_2 : ( ( ( ( rule__Mod__FunctionsAssignment_2_0 ) ) ( ( rule__Mod__FunctionsAssignment_2_0 )* ) ) | ( ( ( rule__Mod__StatementsAssignment_2_1 ) ) ( ( rule__Mod__StatementsAssignment_2_1 )* ) ) );
    public final void rule__Mod__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1070:1: ( ( ( ( rule__Mod__FunctionsAssignment_2_0 ) ) ( ( rule__Mod__FunctionsAssignment_2_0 )* ) ) | ( ( ( rule__Mod__StatementsAssignment_2_1 ) ) ( ( rule__Mod__StatementsAssignment_2_1 )* ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==23) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID||LA3_0==RULE_NUMBER||(LA3_0>=12 && LA3_0<=14)||LA3_0==24||LA3_0==27||(LA3_0>=30 && LA3_0<=31)||(LA3_0>=33 && LA3_0<=34)||LA3_0==48||LA3_0==50||(LA3_0>=54 && LA3_0<=55)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1071:1: ( ( ( rule__Mod__FunctionsAssignment_2_0 ) ) ( ( rule__Mod__FunctionsAssignment_2_0 )* ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1071:1: ( ( ( rule__Mod__FunctionsAssignment_2_0 ) ) ( ( rule__Mod__FunctionsAssignment_2_0 )* ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1072:1: ( ( rule__Mod__FunctionsAssignment_2_0 ) ) ( ( rule__Mod__FunctionsAssignment_2_0 )* )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1072:1: ( ( rule__Mod__FunctionsAssignment_2_0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1073:1: ( rule__Mod__FunctionsAssignment_2_0 )
                    {
                     before(grammarAccess.getModAccess().getFunctionsAssignment_2_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1074:1: ( rule__Mod__FunctionsAssignment_2_0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1074:2: rule__Mod__FunctionsAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__Mod__FunctionsAssignment_2_0_in_rule__Mod__Alternatives_22211);
                    rule__Mod__FunctionsAssignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getModAccess().getFunctionsAssignment_2_0()); 

                    }

                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1077:1: ( ( rule__Mod__FunctionsAssignment_2_0 )* )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1078:1: ( rule__Mod__FunctionsAssignment_2_0 )*
                    {
                     before(grammarAccess.getModAccess().getFunctionsAssignment_2_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1079:1: ( rule__Mod__FunctionsAssignment_2_0 )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==23) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1079:2: rule__Mod__FunctionsAssignment_2_0
                    	    {
                    	    pushFollow(FOLLOW_rule__Mod__FunctionsAssignment_2_0_in_rule__Mod__Alternatives_22223);
                    	    rule__Mod__FunctionsAssignment_2_0();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                     after(grammarAccess.getModAccess().getFunctionsAssignment_2_0()); 

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1084:6: ( ( ( rule__Mod__StatementsAssignment_2_1 ) ) ( ( rule__Mod__StatementsAssignment_2_1 )* ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1084:6: ( ( ( rule__Mod__StatementsAssignment_2_1 ) ) ( ( rule__Mod__StatementsAssignment_2_1 )* ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1085:1: ( ( rule__Mod__StatementsAssignment_2_1 ) ) ( ( rule__Mod__StatementsAssignment_2_1 )* )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1085:1: ( ( rule__Mod__StatementsAssignment_2_1 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1086:1: ( rule__Mod__StatementsAssignment_2_1 )
                    {
                     before(grammarAccess.getModAccess().getStatementsAssignment_2_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1087:1: ( rule__Mod__StatementsAssignment_2_1 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1087:2: rule__Mod__StatementsAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__Mod__StatementsAssignment_2_1_in_rule__Mod__Alternatives_22246);
                    rule__Mod__StatementsAssignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getModAccess().getStatementsAssignment_2_1()); 

                    }

                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1090:1: ( ( rule__Mod__StatementsAssignment_2_1 )* )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1091:1: ( rule__Mod__StatementsAssignment_2_1 )*
                    {
                     before(grammarAccess.getModAccess().getStatementsAssignment_2_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1092:1: ( rule__Mod__StatementsAssignment_2_1 )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID||LA2_0==RULE_NUMBER||(LA2_0>=12 && LA2_0<=14)||LA2_0==24||LA2_0==27||(LA2_0>=30 && LA2_0<=31)||(LA2_0>=33 && LA2_0<=34)||LA2_0==48||LA2_0==50||(LA2_0>=54 && LA2_0<=55)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1092:2: rule__Mod__StatementsAssignment_2_1
                    	    {
                    	    pushFollow(FOLLOW_rule__Mod__StatementsAssignment_2_1_in_rule__Mod__Alternatives_22258);
                    	    rule__Mod__StatementsAssignment_2_1();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                     after(grammarAccess.getModAccess().getStatementsAssignment_2_1()); 

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
    // $ANTLR end "rule__Mod__Alternatives_2"


    // $ANTLR start "rule__Statement__Alternatives"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1103:1: rule__Statement__Alternatives : ( ( ( rule__Statement__Group_0__0 ) ) | ( ruleIfStatement ) | ( ruleWhileStatement ) | ( ruleBlock ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1107:1: ( ( ( rule__Statement__Group_0__0 ) ) | ( ruleIfStatement ) | ( ruleWhileStatement ) | ( ruleBlock ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_NUMBER:
            case 12:
            case 13:
            case 14:
            case 24:
            case 30:
            case 34:
            case 48:
            case 50:
            case 54:
            case 55:
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
            case 27:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1108:1: ( ( rule__Statement__Group_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1108:1: ( ( rule__Statement__Group_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1109:1: ( rule__Statement__Group_0__0 )
                    {
                     before(grammarAccess.getStatementAccess().getGroup_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1110:1: ( rule__Statement__Group_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1110:2: rule__Statement__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Statement__Group_0__0_in_rule__Statement__Alternatives2295);
                    rule__Statement__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStatementAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1114:6: ( ruleIfStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1114:6: ( ruleIfStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1115:1: ruleIfStatement
                    {
                     before(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIfStatement_in_rule__Statement__Alternatives2313);
                    ruleIfStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1120:6: ( ruleWhileStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1120:6: ( ruleWhileStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1121:1: ruleWhileStatement
                    {
                     before(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleWhileStatement_in_rule__Statement__Alternatives2330);
                    ruleWhileStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1126:6: ( ruleBlock )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1126:6: ( ruleBlock )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1127:1: ruleBlock
                    {
                     before(grammarAccess.getStatementAccess().getBlockParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleBlock_in_rule__Statement__Alternatives2347);
                    ruleBlock();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getBlockParserRuleCall_3()); 

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
    // $ANTLR end "rule__Statement__Alternatives"


    // $ANTLR start "rule__Statement__Alternatives_0_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1137:1: rule__Statement__Alternatives_0_0 : ( ( ruleVariableStatement ) | ( ruleAssignmentStatement ) | ( ruleReferenceAssignmentStatement ) | ( ( rule__Statement__ExpressionAssignment_0_0_3 ) ) | ( ruleReturnStatement ) );
    public final void rule__Statement__Alternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1141:1: ( ( ruleVariableStatement ) | ( ruleAssignmentStatement ) | ( ruleReferenceAssignmentStatement ) | ( ( rule__Statement__ExpressionAssignment_0_0_3 ) ) | ( ruleReturnStatement ) )
            int alt5=5;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1142:1: ( ruleVariableStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1142:1: ( ruleVariableStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1143:1: ruleVariableStatement
                    {
                     before(grammarAccess.getStatementAccess().getVariableStatementParserRuleCall_0_0_0()); 
                    pushFollow(FOLLOW_ruleVariableStatement_in_rule__Statement__Alternatives_0_02379);
                    ruleVariableStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getVariableStatementParserRuleCall_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1148:6: ( ruleAssignmentStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1148:6: ( ruleAssignmentStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1149:1: ruleAssignmentStatement
                    {
                     before(grammarAccess.getStatementAccess().getAssignmentStatementParserRuleCall_0_0_1()); 
                    pushFollow(FOLLOW_ruleAssignmentStatement_in_rule__Statement__Alternatives_0_02396);
                    ruleAssignmentStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getAssignmentStatementParserRuleCall_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1154:6: ( ruleReferenceAssignmentStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1154:6: ( ruleReferenceAssignmentStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1155:1: ruleReferenceAssignmentStatement
                    {
                     before(grammarAccess.getStatementAccess().getReferenceAssignmentStatementParserRuleCall_0_0_2()); 
                    pushFollow(FOLLOW_ruleReferenceAssignmentStatement_in_rule__Statement__Alternatives_0_02413);
                    ruleReferenceAssignmentStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getReferenceAssignmentStatementParserRuleCall_0_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1160:6: ( ( rule__Statement__ExpressionAssignment_0_0_3 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1160:6: ( ( rule__Statement__ExpressionAssignment_0_0_3 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1161:1: ( rule__Statement__ExpressionAssignment_0_0_3 )
                    {
                     before(grammarAccess.getStatementAccess().getExpressionAssignment_0_0_3()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1162:1: ( rule__Statement__ExpressionAssignment_0_0_3 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1162:2: rule__Statement__ExpressionAssignment_0_0_3
                    {
                    pushFollow(FOLLOW_rule__Statement__ExpressionAssignment_0_0_3_in_rule__Statement__Alternatives_0_02430);
                    rule__Statement__ExpressionAssignment_0_0_3();

                    state._fsp--;


                    }

                     after(grammarAccess.getStatementAccess().getExpressionAssignment_0_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1166:6: ( ruleReturnStatement )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1166:6: ( ruleReturnStatement )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1167:1: ruleReturnStatement
                    {
                     before(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_0_0_4()); 
                    pushFollow(FOLLOW_ruleReturnStatement_in_rule__Statement__Alternatives_0_02448);
                    ruleReturnStatement();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_0_0_4()); 

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
    // $ANTLR end "rule__Statement__Alternatives_0_0"


    // $ANTLR start "rule__Logical__Alternatives_1_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1177:1: rule__Logical__Alternatives_1_0 : ( ( ( rule__Logical__Group_1_0_0__0 ) ) | ( ( rule__Logical__Group_1_0_1__0 ) ) );
    public final void rule__Logical__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1181:1: ( ( ( rule__Logical__Group_1_0_0__0 ) ) | ( ( rule__Logical__Group_1_0_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==36) ) {
                alt6=1;
            }
            else if ( (LA6_0==37) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1182:1: ( ( rule__Logical__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1182:1: ( ( rule__Logical__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1183:1: ( rule__Logical__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getLogicalAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1184:1: ( rule__Logical__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1184:2: rule__Logical__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Logical__Group_1_0_0__0_in_rule__Logical__Alternatives_1_02480);
                    rule__Logical__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLogicalAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1188:6: ( ( rule__Logical__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1188:6: ( ( rule__Logical__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1189:1: ( rule__Logical__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getLogicalAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1190:1: ( rule__Logical__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1190:2: rule__Logical__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Logical__Group_1_0_1__0_in_rule__Logical__Alternatives_1_02498);
                    rule__Logical__Group_1_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLogicalAccess().getGroup_1_0_1()); 

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
    // $ANTLR end "rule__Logical__Alternatives_1_0"


    // $ANTLR start "rule__Equality__Alternatives_1_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1199:1: rule__Equality__Alternatives_1_0 : ( ( ( rule__Equality__Group_1_0_0__0 ) ) | ( ( rule__Equality__Group_1_0_1__0 ) ) );
    public final void rule__Equality__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1203:1: ( ( ( rule__Equality__Group_1_0_0__0 ) ) | ( ( rule__Equality__Group_1_0_1__0 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==38) ) {
                alt7=1;
            }
            else if ( (LA7_0==39) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1204:1: ( ( rule__Equality__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1204:1: ( ( rule__Equality__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1205:1: ( rule__Equality__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getEqualityAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1206:1: ( rule__Equality__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1206:2: rule__Equality__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Equality__Group_1_0_0__0_in_rule__Equality__Alternatives_1_02531);
                    rule__Equality__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEqualityAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1210:6: ( ( rule__Equality__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1210:6: ( ( rule__Equality__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1211:1: ( rule__Equality__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getEqualityAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1212:1: ( rule__Equality__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1212:2: rule__Equality__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Equality__Group_1_0_1__0_in_rule__Equality__Alternatives_1_02549);
                    rule__Equality__Group_1_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEqualityAccess().getGroup_1_0_1()); 

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
    // $ANTLR end "rule__Equality__Alternatives_1_0"


    // $ANTLR start "rule__Comparison__Alternatives_1_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1221:1: rule__Comparison__Alternatives_1_0 : ( ( ( rule__Comparison__Group_1_0_0__0 ) ) | ( ( rule__Comparison__Group_1_0_1__0 ) ) | ( ( rule__Comparison__Group_1_0_2__0 ) ) | ( ( rule__Comparison__Group_1_0_3__0 ) ) );
    public final void rule__Comparison__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1225:1: ( ( ( rule__Comparison__Group_1_0_0__0 ) ) | ( ( rule__Comparison__Group_1_0_1__0 ) ) | ( ( rule__Comparison__Group_1_0_2__0 ) ) | ( ( rule__Comparison__Group_1_0_3__0 ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt8=1;
                }
                break;
            case 41:
                {
                alt8=2;
                }
                break;
            case 42:
                {
                alt8=3;
                }
                break;
            case 43:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1226:1: ( ( rule__Comparison__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1226:1: ( ( rule__Comparison__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1227:1: ( rule__Comparison__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1228:1: ( rule__Comparison__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1228:2: rule__Comparison__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__0_in_rule__Comparison__Alternatives_1_02582);
                    rule__Comparison__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1232:6: ( ( rule__Comparison__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1232:6: ( ( rule__Comparison__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1233:1: ( rule__Comparison__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1234:1: ( rule__Comparison__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1234:2: rule__Comparison__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__0_in_rule__Comparison__Alternatives_1_02600);
                    rule__Comparison__Group_1_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getGroup_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1238:6: ( ( rule__Comparison__Group_1_0_2__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1238:6: ( ( rule__Comparison__Group_1_0_2__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1239:1: ( rule__Comparison__Group_1_0_2__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_2()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1240:1: ( rule__Comparison__Group_1_0_2__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1240:2: rule__Comparison__Group_1_0_2__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__0_in_rule__Comparison__Alternatives_1_02618);
                    rule__Comparison__Group_1_0_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getGroup_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1244:6: ( ( rule__Comparison__Group_1_0_3__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1244:6: ( ( rule__Comparison__Group_1_0_3__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1245:1: ( rule__Comparison__Group_1_0_3__0 )
                    {
                     before(grammarAccess.getComparisonAccess().getGroup_1_0_3()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1246:1: ( rule__Comparison__Group_1_0_3__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1246:2: rule__Comparison__Group_1_0_3__0
                    {
                    pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__0_in_rule__Comparison__Alternatives_1_02636);
                    rule__Comparison__Group_1_0_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getGroup_1_0_3()); 

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
    // $ANTLR end "rule__Comparison__Alternatives_1_0"


    // $ANTLR start "rule__Addition__Alternatives_1_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1255:1: rule__Addition__Alternatives_1_0 : ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) );
    public final void rule__Addition__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1259:1: ( ( ( rule__Addition__Group_1_0_0__0 ) ) | ( ( rule__Addition__Group_1_0_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==13) ) {
                alt9=1;
            }
            else if ( (LA9_0==12) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1260:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1260:1: ( ( rule__Addition__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1261:1: ( rule__Addition__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1262:1: ( rule__Addition__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1262:2: rule__Addition__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_02669);
                    rule__Addition__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAdditionAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1266:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1266:6: ( ( rule__Addition__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1267:1: ( rule__Addition__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1268:1: ( rule__Addition__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1268:2: rule__Addition__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_02687);
                    rule__Addition__Group_1_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAdditionAccess().getGroup_1_0_1()); 

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
    // $ANTLR end "rule__Addition__Alternatives_1_0"


    // $ANTLR start "rule__Multiplication__Alternatives_1_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1277:1: rule__Multiplication__Alternatives_1_0 : ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) | ( ( rule__Multiplication__Group_1_0_2__0 ) ) );
    public final void rule__Multiplication__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1281:1: ( ( ( rule__Multiplication__Group_1_0_0__0 ) ) | ( ( rule__Multiplication__Group_1_0_1__0 ) ) | ( ( rule__Multiplication__Group_1_0_2__0 ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt10=1;
                }
                break;
            case 45:
                {
                alt10=2;
                }
                break;
            case 46:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1282:1: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1282:1: ( ( rule__Multiplication__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1283:1: ( rule__Multiplication__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1284:1: ( rule__Multiplication__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1284:2: rule__Multiplication__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__0_in_rule__Multiplication__Alternatives_1_02720);
                    rule__Multiplication__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultiplicationAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1288:6: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1288:6: ( ( rule__Multiplication__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1289:1: ( rule__Multiplication__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1290:1: ( rule__Multiplication__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1290:2: rule__Multiplication__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__0_in_rule__Multiplication__Alternatives_1_02738);
                    rule__Multiplication__Group_1_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultiplicationAccess().getGroup_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1294:6: ( ( rule__Multiplication__Group_1_0_2__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1294:6: ( ( rule__Multiplication__Group_1_0_2__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1295:1: ( rule__Multiplication__Group_1_0_2__0 )
                    {
                     before(grammarAccess.getMultiplicationAccess().getGroup_1_0_2()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1296:1: ( rule__Multiplication__Group_1_0_2__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1296:2: rule__Multiplication__Group_1_0_2__0
                    {
                    pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__0_in_rule__Multiplication__Alternatives_1_02756);
                    rule__Multiplication__Group_1_0_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMultiplicationAccess().getGroup_1_0_2()); 

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
    // $ANTLR end "rule__Multiplication__Alternatives_1_0"


    // $ANTLR start "rule__Unary__Alternatives"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1305:1: rule__Unary__Alternatives : ( ( rulePrimaryExpression ) | ( ( rule__Unary__Group_1__0 ) ) );
    public final void rule__Unary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1309:1: ( ( rulePrimaryExpression ) | ( ( rule__Unary__Group_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||LA11_0==RULE_NUMBER||LA11_0==14||LA11_0==24||LA11_0==48||LA11_0==50||LA11_0==55) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=12 && LA11_0<=13)||LA11_0==54) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1310:1: ( rulePrimaryExpression )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1310:1: ( rulePrimaryExpression )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1311:1: rulePrimaryExpression
                    {
                     before(grammarAccess.getUnaryAccess().getPrimaryExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rule__Unary__Alternatives2789);
                    rulePrimaryExpression();

                    state._fsp--;

                     after(grammarAccess.getUnaryAccess().getPrimaryExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1316:6: ( ( rule__Unary__Group_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1316:6: ( ( rule__Unary__Group_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1317:1: ( rule__Unary__Group_1__0 )
                    {
                     before(grammarAccess.getUnaryAccess().getGroup_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1318:1: ( rule__Unary__Group_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1318:2: rule__Unary__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Unary__Group_1__0_in_rule__Unary__Alternatives2806);
                    rule__Unary__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnaryAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Unary__Alternatives"


    // $ANTLR start "rule__Unary__Alternatives_1_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1327:1: rule__Unary__Alternatives_1_0 : ( ( ( rule__Unary__Group_1_0_0__0 ) ) | ( ( rule__Unary__Group_1_0_1__0 ) ) );
    public final void rule__Unary__Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1331:1: ( ( ( rule__Unary__Group_1_0_0__0 ) ) | ( ( rule__Unary__Group_1_0_1__0 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==54) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=12 && LA12_0<=13)) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1332:1: ( ( rule__Unary__Group_1_0_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1332:1: ( ( rule__Unary__Group_1_0_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1333:1: ( rule__Unary__Group_1_0_0__0 )
                    {
                     before(grammarAccess.getUnaryAccess().getGroup_1_0_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1334:1: ( rule__Unary__Group_1_0_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1334:2: rule__Unary__Group_1_0_0__0
                    {
                    pushFollow(FOLLOW_rule__Unary__Group_1_0_0__0_in_rule__Unary__Alternatives_1_02839);
                    rule__Unary__Group_1_0_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnaryAccess().getGroup_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1338:6: ( ( rule__Unary__Group_1_0_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1338:6: ( ( rule__Unary__Group_1_0_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1339:1: ( rule__Unary__Group_1_0_1__0 )
                    {
                     before(grammarAccess.getUnaryAccess().getGroup_1_0_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1340:1: ( rule__Unary__Group_1_0_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1340:2: rule__Unary__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Unary__Group_1_0_1__0_in_rule__Unary__Alternatives_1_02857);
                    rule__Unary__Group_1_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getUnaryAccess().getGroup_1_0_1()); 

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
    // $ANTLR end "rule__Unary__Alternatives_1_0"


    // $ANTLR start "rule__UnaryOperator__Alternatives"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1349:1: rule__UnaryOperator__Alternatives : ( ( '-' ) | ( '+' ) );
    public final void rule__UnaryOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1353:1: ( ( '-' ) | ( '+' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==12) ) {
                alt13=1;
            }
            else if ( (LA13_0==13) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1354:1: ( '-' )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1354:1: ( '-' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1355:1: '-'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 
                    match(input,12,FOLLOW_12_in_rule__UnaryOperator__Alternatives2891); 
                     after(grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1362:6: ( '+' )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1362:6: ( '+' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1363:1: '+'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getPlusSignKeyword_1()); 
                    match(input,13,FOLLOW_13_in_rule__UnaryOperator__Alternatives2911); 
                     after(grammarAccess.getUnaryOperatorAccess().getPlusSignKeyword_1()); 

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
    // $ANTLR end "rule__UnaryOperator__Alternatives"


    // $ANTLR start "rule__PrimaryExpression__Alternatives"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1375:1: rule__PrimaryExpression__Alternatives : ( ( ruleLiteral ) | ( ruleRange ) | ( ruleNativeExpression ) | ( ruleReference ) | ( ruleFunctionCall ) | ( ruleVarOrArgumentCall ) | ( ruleParenthesizedExpression ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1379:1: ( ( ruleLiteral ) | ( ruleRange ) | ( ruleNativeExpression ) | ( ruleReference ) | ( ruleFunctionCall ) | ( ruleVarOrArgumentCall ) | ( ruleParenthesizedExpression ) )
            int alt14=7;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1380:1: ( ruleLiteral )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1380:1: ( ruleLiteral )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1381:1: ruleLiteral
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleLiteral_in_rule__PrimaryExpression__Alternatives2945);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1386:6: ( ruleRange )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1386:6: ( ruleRange )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1387:1: ruleRange
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getRangeParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleRange_in_rule__PrimaryExpression__Alternatives2962);
                    ruleRange();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getRangeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1392:6: ( ruleNativeExpression )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1392:6: ( ruleNativeExpression )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1393:1: ruleNativeExpression
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getNativeExpressionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleNativeExpression_in_rule__PrimaryExpression__Alternatives2979);
                    ruleNativeExpression();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getNativeExpressionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1398:6: ( ruleReference )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1398:6: ( ruleReference )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1399:1: ruleReference
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getReferenceParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleReference_in_rule__PrimaryExpression__Alternatives2996);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getReferenceParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1404:6: ( ruleFunctionCall )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1404:6: ( ruleFunctionCall )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1405:1: ruleFunctionCall
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleFunctionCall_in_rule__PrimaryExpression__Alternatives3013);
                    ruleFunctionCall();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1410:6: ( ruleVarOrArgumentCall )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1410:6: ( ruleVarOrArgumentCall )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1411:1: ruleVarOrArgumentCall
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getVarOrArgumentCallParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleVarOrArgumentCall_in_rule__PrimaryExpression__Alternatives3030);
                    ruleVarOrArgumentCall();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getVarOrArgumentCallParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1416:6: ( ruleParenthesizedExpression )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1416:6: ( ruleParenthesizedExpression )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1417:1: ruleParenthesizedExpression
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_rule__PrimaryExpression__Alternatives3047);
                    ruleParenthesizedExpression();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_6()); 

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
    // $ANTLR end "rule__PrimaryExpression__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1427:1: rule__Literal__Alternatives : ( ( ( rule__Literal__Group_0__0 ) ) | ( ( rule__Literal__Group_1__0 ) ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1431:1: ( ( ( rule__Literal__Group_0__0 ) ) | ( ( rule__Literal__Group_1__0 ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_NUMBER) ) {
                alt15=1;
            }
            else if ( (LA15_0==14||LA15_0==55) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1432:1: ( ( rule__Literal__Group_0__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1432:1: ( ( rule__Literal__Group_0__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1433:1: ( rule__Literal__Group_0__0 )
                    {
                     before(grammarAccess.getLiteralAccess().getGroup_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1434:1: ( rule__Literal__Group_0__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1434:2: rule__Literal__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Literal__Group_0__0_in_rule__Literal__Alternatives3079);
                    rule__Literal__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1438:6: ( ( rule__Literal__Group_1__0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1438:6: ( ( rule__Literal__Group_1__0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1439:1: ( rule__Literal__Group_1__0 )
                    {
                     before(grammarAccess.getLiteralAccess().getGroup_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1440:1: ( rule__Literal__Group_1__0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1440:2: rule__Literal__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Literal__Group_1__0_in_rule__Literal__Alternatives3097);
                    rule__Literal__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__Literal__Alternatives_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1449:1: rule__Literal__Alternatives_1_1 : ( ( ( rule__Literal__ConditionAssignment_1_1_0 ) ) | ( 'false' ) );
    public final void rule__Literal__Alternatives_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1453:1: ( ( ( rule__Literal__ConditionAssignment_1_1_0 ) ) | ( 'false' ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==55) ) {
                alt16=1;
            }
            else if ( (LA16_0==14) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1454:1: ( ( rule__Literal__ConditionAssignment_1_1_0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1454:1: ( ( rule__Literal__ConditionAssignment_1_1_0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1455:1: ( rule__Literal__ConditionAssignment_1_1_0 )
                    {
                     before(grammarAccess.getLiteralAccess().getConditionAssignment_1_1_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1456:1: ( rule__Literal__ConditionAssignment_1_1_0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1456:2: rule__Literal__ConditionAssignment_1_1_0
                    {
                    pushFollow(FOLLOW_rule__Literal__ConditionAssignment_1_1_0_in_rule__Literal__Alternatives_1_13130);
                    rule__Literal__ConditionAssignment_1_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralAccess().getConditionAssignment_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1460:6: ( 'false' )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1460:6: ( 'false' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1461:1: 'false'
                    {
                     before(grammarAccess.getLiteralAccess().getFalseKeyword_1_1_1()); 
                    match(input,14,FOLLOW_14_in_rule__Literal__Alternatives_1_13149); 
                     after(grammarAccess.getLiteralAccess().getFalseKeyword_1_1_1()); 

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
    // $ANTLR end "rule__Literal__Alternatives_1_1"


    // $ANTLR start "rule__NativeExpression__Alternatives_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1473:1: rule__NativeExpression__Alternatives_1 : ( ( ( rule__NativeExpression__RangeAssignment_1_0 ) ) | ( ( rule__NativeExpression__RefAssignment_1_1 ) ) );
    public final void rule__NativeExpression__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1477:1: ( ( ( rule__NativeExpression__RangeAssignment_1_0 ) ) | ( ( rule__NativeExpression__RefAssignment_1_1 ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==48) ) {
                alt17=1;
            }
            else if ( (LA17_0==50) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1478:1: ( ( rule__NativeExpression__RangeAssignment_1_0 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1478:1: ( ( rule__NativeExpression__RangeAssignment_1_0 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1479:1: ( rule__NativeExpression__RangeAssignment_1_0 )
                    {
                     before(grammarAccess.getNativeExpressionAccess().getRangeAssignment_1_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1480:1: ( rule__NativeExpression__RangeAssignment_1_0 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1480:2: rule__NativeExpression__RangeAssignment_1_0
                    {
                    pushFollow(FOLLOW_rule__NativeExpression__RangeAssignment_1_0_in_rule__NativeExpression__Alternatives_13183);
                    rule__NativeExpression__RangeAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNativeExpressionAccess().getRangeAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1484:6: ( ( rule__NativeExpression__RefAssignment_1_1 ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1484:6: ( ( rule__NativeExpression__RefAssignment_1_1 ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1485:1: ( rule__NativeExpression__RefAssignment_1_1 )
                    {
                     before(grammarAccess.getNativeExpressionAccess().getRefAssignment_1_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1486:1: ( rule__NativeExpression__RefAssignment_1_1 )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1486:2: rule__NativeExpression__RefAssignment_1_1
                    {
                    pushFollow(FOLLOW_rule__NativeExpression__RefAssignment_1_1_in_rule__NativeExpression__Alternatives_13201);
                    rule__NativeExpression__RefAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getNativeExpressionAccess().getRefAssignment_1_1()); 

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
    // $ANTLR end "rule__NativeExpression__Alternatives_1"


    // $ANTLR start "rule__LeafRef__Alternatives"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1495:1: rule__LeafRef__Alternatives : ( ( ruleResourceRef ) | ( ruleLinkRef ) );
    public final void rule__LeafRef__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1499:1: ( ( ruleResourceRef ) | ( ruleLinkRef ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==52) ) {
                alt18=1;
            }
            else if ( (LA18_0==53) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1500:1: ( ruleResourceRef )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1500:1: ( ruleResourceRef )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1501:1: ruleResourceRef
                    {
                     before(grammarAccess.getLeafRefAccess().getResourceRefParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleResourceRef_in_rule__LeafRef__Alternatives3234);
                    ruleResourceRef();

                    state._fsp--;

                     after(grammarAccess.getLeafRefAccess().getResourceRefParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1506:6: ( ruleLinkRef )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1506:6: ( ruleLinkRef )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1507:1: ruleLinkRef
                    {
                     before(grammarAccess.getLeafRefAccess().getLinkRefParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleLinkRef_in_rule__LeafRef__Alternatives3251);
                    ruleLinkRef();

                    state._fsp--;

                     after(grammarAccess.getLeafRefAccess().getLinkRefParserRuleCall_1()); 

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
    // $ANTLR end "rule__LeafRef__Alternatives"


    // $ANTLR start "rule__NativeFunction__Alternatives"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1517:1: rule__NativeFunction__Alternatives : ( ( ( 'count()' ) ) | ( ( 'sum()' ) ) | ( ( 'min()' ) ) | ( ( 'max()' ) ) | ( ( 'mean()' ) ) | ( ( 'deviation()' ) ) );
    public final void rule__NativeFunction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1521:1: ( ( ( 'count()' ) ) | ( ( 'sum()' ) ) | ( ( 'min()' ) ) | ( ( 'max()' ) ) | ( ( 'mean()' ) ) | ( ( 'deviation()' ) ) )
            int alt19=6;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt19=1;
                }
                break;
            case 16:
                {
                alt19=2;
                }
                break;
            case 17:
                {
                alt19=3;
                }
                break;
            case 18:
                {
                alt19=4;
                }
                break;
            case 19:
                {
                alt19=5;
                }
                break;
            case 20:
                {
                alt19=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1522:1: ( ( 'count()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1522:1: ( ( 'count()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1523:1: ( 'count()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1524:1: ( 'count()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1524:3: 'count()'
                    {
                    match(input,15,FOLLOW_15_in_rule__NativeFunction__Alternatives3284); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getCOUNTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1529:6: ( ( 'sum()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1529:6: ( ( 'sum()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1530:1: ( 'sum()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1531:1: ( 'sum()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1531:3: 'sum()'
                    {
                    match(input,16,FOLLOW_16_in_rule__NativeFunction__Alternatives3305); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getSUMEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1536:6: ( ( 'min()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1536:6: ( ( 'min()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1537:1: ( 'min()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1538:1: ( 'min()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1538:3: 'min()'
                    {
                    match(input,17,FOLLOW_17_in_rule__NativeFunction__Alternatives3326); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getMINEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1543:6: ( ( 'max()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1543:6: ( ( 'max()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1544:1: ( 'max()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1545:1: ( 'max()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1545:3: 'max()'
                    {
                    match(input,18,FOLLOW_18_in_rule__NativeFunction__Alternatives3347); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getMAXEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1550:6: ( ( 'mean()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1550:6: ( ( 'mean()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1551:1: ( 'mean()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1552:1: ( 'mean()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1552:3: 'mean()'
                    {
                    match(input,19,FOLLOW_19_in_rule__NativeFunction__Alternatives3368); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getMEANEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1557:6: ( ( 'deviation()' ) )
                    {
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1557:6: ( ( 'deviation()' ) )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1558:1: ( 'deviation()' )
                    {
                     before(grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5()); 
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1559:1: ( 'deviation()' )
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1559:3: 'deviation()'
                    {
                    match(input,20,FOLLOW_20_in_rule__NativeFunction__Alternatives3389); 

                    }

                     after(grammarAccess.getNativeFunctionAccess().getDEVIATIONEnumLiteralDeclaration_5()); 

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
    // $ANTLR end "rule__NativeFunction__Alternatives"


    // $ANTLR start "rule__Mod__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1571:1: rule__Mod__Group__0 : rule__Mod__Group__0__Impl rule__Mod__Group__1 ;
    public final void rule__Mod__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1575:1: ( rule__Mod__Group__0__Impl rule__Mod__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1576:2: rule__Mod__Group__0__Impl rule__Mod__Group__1
            {
            pushFollow(FOLLOW_rule__Mod__Group__0__Impl_in_rule__Mod__Group__03422);
            rule__Mod__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mod__Group__1_in_rule__Mod__Group__03425);
            rule__Mod__Group__1();

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
    // $ANTLR end "rule__Mod__Group__0"


    // $ANTLR start "rule__Mod__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1583:1: rule__Mod__Group__0__Impl : ( ( rule__Mod__Group_0__0 )? ) ;
    public final void rule__Mod__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1587:1: ( ( ( rule__Mod__Group_0__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1588:1: ( ( rule__Mod__Group_0__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1588:1: ( ( rule__Mod__Group_0__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1589:1: ( rule__Mod__Group_0__0 )?
            {
             before(grammarAccess.getModAccess().getGroup_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1590:1: ( rule__Mod__Group_0__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==21) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1590:2: rule__Mod__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Mod__Group_0__0_in_rule__Mod__Group__0__Impl3452);
                    rule__Mod__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group__0__Impl"


    // $ANTLR start "rule__Mod__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1600:1: rule__Mod__Group__1 : rule__Mod__Group__1__Impl rule__Mod__Group__2 ;
    public final void rule__Mod__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1604:1: ( rule__Mod__Group__1__Impl rule__Mod__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1605:2: rule__Mod__Group__1__Impl rule__Mod__Group__2
            {
            pushFollow(FOLLOW_rule__Mod__Group__1__Impl_in_rule__Mod__Group__13483);
            rule__Mod__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mod__Group__2_in_rule__Mod__Group__13486);
            rule__Mod__Group__2();

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
    // $ANTLR end "rule__Mod__Group__1"


    // $ANTLR start "rule__Mod__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1612:1: rule__Mod__Group__1__Impl : ( ( rule__Mod__ImportsAssignment_1 )* ) ;
    public final void rule__Mod__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1616:1: ( ( ( rule__Mod__ImportsAssignment_1 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1617:1: ( ( rule__Mod__ImportsAssignment_1 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1617:1: ( ( rule__Mod__ImportsAssignment_1 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1618:1: ( rule__Mod__ImportsAssignment_1 )*
            {
             before(grammarAccess.getModAccess().getImportsAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1619:1: ( rule__Mod__ImportsAssignment_1 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1619:2: rule__Mod__ImportsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Mod__ImportsAssignment_1_in_rule__Mod__Group__1__Impl3513);
            	    rule__Mod__ImportsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getModAccess().getImportsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group__1__Impl"


    // $ANTLR start "rule__Mod__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1629:1: rule__Mod__Group__2 : rule__Mod__Group__2__Impl ;
    public final void rule__Mod__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1633:1: ( rule__Mod__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1634:2: rule__Mod__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Mod__Group__2__Impl_in_rule__Mod__Group__23544);
            rule__Mod__Group__2__Impl();

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
    // $ANTLR end "rule__Mod__Group__2"


    // $ANTLR start "rule__Mod__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1640:1: rule__Mod__Group__2__Impl : ( ( rule__Mod__Alternatives_2 ) ) ;
    public final void rule__Mod__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1644:1: ( ( ( rule__Mod__Alternatives_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1645:1: ( ( rule__Mod__Alternatives_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1645:1: ( ( rule__Mod__Alternatives_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1646:1: ( rule__Mod__Alternatives_2 )
            {
             before(grammarAccess.getModAccess().getAlternatives_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1647:1: ( rule__Mod__Alternatives_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1647:2: rule__Mod__Alternatives_2
            {
            pushFollow(FOLLOW_rule__Mod__Alternatives_2_in_rule__Mod__Group__2__Impl3571);
            rule__Mod__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getModAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group__2__Impl"


    // $ANTLR start "rule__Mod__Group_0__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1663:1: rule__Mod__Group_0__0 : rule__Mod__Group_0__0__Impl rule__Mod__Group_0__1 ;
    public final void rule__Mod__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1667:1: ( rule__Mod__Group_0__0__Impl rule__Mod__Group_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1668:2: rule__Mod__Group_0__0__Impl rule__Mod__Group_0__1
            {
            pushFollow(FOLLOW_rule__Mod__Group_0__0__Impl_in_rule__Mod__Group_0__03607);
            rule__Mod__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Mod__Group_0__1_in_rule__Mod__Group_0__03610);
            rule__Mod__Group_0__1();

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
    // $ANTLR end "rule__Mod__Group_0__0"


    // $ANTLR start "rule__Mod__Group_0__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1675:1: rule__Mod__Group_0__0__Impl : ( 'mod' ) ;
    public final void rule__Mod__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1679:1: ( ( 'mod' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1680:1: ( 'mod' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1680:1: ( 'mod' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1681:1: 'mod'
            {
             before(grammarAccess.getModAccess().getModKeyword_0_0()); 
            match(input,21,FOLLOW_21_in_rule__Mod__Group_0__0__Impl3638); 
             after(grammarAccess.getModAccess().getModKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group_0__0__Impl"


    // $ANTLR start "rule__Mod__Group_0__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1694:1: rule__Mod__Group_0__1 : rule__Mod__Group_0__1__Impl ;
    public final void rule__Mod__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1698:1: ( rule__Mod__Group_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1699:2: rule__Mod__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Mod__Group_0__1__Impl_in_rule__Mod__Group_0__13669);
            rule__Mod__Group_0__1__Impl();

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
    // $ANTLR end "rule__Mod__Group_0__1"


    // $ANTLR start "rule__Mod__Group_0__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1705:1: rule__Mod__Group_0__1__Impl : ( ( rule__Mod__NameAssignment_0_1 ) ) ;
    public final void rule__Mod__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1709:1: ( ( ( rule__Mod__NameAssignment_0_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1710:1: ( ( rule__Mod__NameAssignment_0_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1710:1: ( ( rule__Mod__NameAssignment_0_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1711:1: ( rule__Mod__NameAssignment_0_1 )
            {
             before(grammarAccess.getModAccess().getNameAssignment_0_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1712:1: ( rule__Mod__NameAssignment_0_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1712:2: rule__Mod__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Mod__NameAssignment_0_1_in_rule__Mod__Group_0__1__Impl3696);
            rule__Mod__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getModAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__Group_0__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1727:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1731:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1732:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03731);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03734);
            rule__Import__Group__1();

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
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1739:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1743:1: ( ( 'import' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1744:1: ( 'import' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1744:1: ( 'import' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1745:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,22,FOLLOW_22_in_rule__Import__Group__0__Impl3762); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1758:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1762:1: ( rule__Import__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1763:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13793);
            rule__Import__Group__1__Impl();

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
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1769:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1773:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1774:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1774:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1775:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1776:1: ( rule__Import__ImportURIAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1776:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl3820);
            rule__Import__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Function__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1790:1: rule__Function__Group__0 : rule__Function__Group__0__Impl rule__Function__Group__1 ;
    public final void rule__Function__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1794:1: ( rule__Function__Group__0__Impl rule__Function__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1795:2: rule__Function__Group__0__Impl rule__Function__Group__1
            {
            pushFollow(FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__03854);
            rule__Function__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__1_in_rule__Function__Group__03857);
            rule__Function__Group__1();

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
    // $ANTLR end "rule__Function__Group__0"


    // $ANTLR start "rule__Function__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1802:1: rule__Function__Group__0__Impl : ( 'def' ) ;
    public final void rule__Function__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1806:1: ( ( 'def' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1807:1: ( 'def' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1807:1: ( 'def' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1808:1: 'def'
            {
             before(grammarAccess.getFunctionAccess().getDefKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__Function__Group__0__Impl3885); 
             after(grammarAccess.getFunctionAccess().getDefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__0__Impl"


    // $ANTLR start "rule__Function__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1821:1: rule__Function__Group__1 : rule__Function__Group__1__Impl rule__Function__Group__2 ;
    public final void rule__Function__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1825:1: ( rule__Function__Group__1__Impl rule__Function__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1826:2: rule__Function__Group__1__Impl rule__Function__Group__2
            {
            pushFollow(FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__13916);
            rule__Function__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__2_in_rule__Function__Group__13919);
            rule__Function__Group__2();

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
    // $ANTLR end "rule__Function__Group__1"


    // $ANTLR start "rule__Function__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1833:1: rule__Function__Group__1__Impl : ( ( rule__Function__NameAssignment_1 ) ) ;
    public final void rule__Function__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1837:1: ( ( ( rule__Function__NameAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1838:1: ( ( rule__Function__NameAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1838:1: ( ( rule__Function__NameAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1839:1: ( rule__Function__NameAssignment_1 )
            {
             before(grammarAccess.getFunctionAccess().getNameAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1840:1: ( rule__Function__NameAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1840:2: rule__Function__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl3946);
            rule__Function__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__1__Impl"


    // $ANTLR start "rule__Function__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1850:1: rule__Function__Group__2 : rule__Function__Group__2__Impl rule__Function__Group__3 ;
    public final void rule__Function__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1854:1: ( rule__Function__Group__2__Impl rule__Function__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1855:2: rule__Function__Group__2__Impl rule__Function__Group__3
            {
            pushFollow(FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__23976);
            rule__Function__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__3_in_rule__Function__Group__23979);
            rule__Function__Group__3();

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
    // $ANTLR end "rule__Function__Group__2"


    // $ANTLR start "rule__Function__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1862:1: rule__Function__Group__2__Impl : ( '(' ) ;
    public final void rule__Function__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1866:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1867:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1867:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1868:1: '('
            {
             before(grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__Function__Group__2__Impl4007); 
             after(grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__2__Impl"


    // $ANTLR start "rule__Function__Group__3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1881:1: rule__Function__Group__3 : rule__Function__Group__3__Impl rule__Function__Group__4 ;
    public final void rule__Function__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1885:1: ( rule__Function__Group__3__Impl rule__Function__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1886:2: rule__Function__Group__3__Impl rule__Function__Group__4
            {
            pushFollow(FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__34038);
            rule__Function__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__4_in_rule__Function__Group__34041);
            rule__Function__Group__4();

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
    // $ANTLR end "rule__Function__Group__3"


    // $ANTLR start "rule__Function__Group__3__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1893:1: rule__Function__Group__3__Impl : ( ( rule__Function__Group_3__0 )? ) ;
    public final void rule__Function__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1897:1: ( ( ( rule__Function__Group_3__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1898:1: ( ( rule__Function__Group_3__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1898:1: ( ( rule__Function__Group_3__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1899:1: ( rule__Function__Group_3__0 )?
            {
             before(grammarAccess.getFunctionAccess().getGroup_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1900:1: ( rule__Function__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1900:2: rule__Function__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Function__Group_3__0_in_rule__Function__Group__3__Impl4068);
                    rule__Function__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFunctionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__3__Impl"


    // $ANTLR start "rule__Function__Group__4"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1910:1: rule__Function__Group__4 : rule__Function__Group__4__Impl rule__Function__Group__5 ;
    public final void rule__Function__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1914:1: ( rule__Function__Group__4__Impl rule__Function__Group__5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1915:2: rule__Function__Group__4__Impl rule__Function__Group__5
            {
            pushFollow(FOLLOW_rule__Function__Group__4__Impl_in_rule__Function__Group__44099);
            rule__Function__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group__5_in_rule__Function__Group__44102);
            rule__Function__Group__5();

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
    // $ANTLR end "rule__Function__Group__4"


    // $ANTLR start "rule__Function__Group__4__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1922:1: rule__Function__Group__4__Impl : ( ')' ) ;
    public final void rule__Function__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1926:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1927:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1927:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1928:1: ')'
            {
             before(grammarAccess.getFunctionAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__Function__Group__4__Impl4130); 
             after(grammarAccess.getFunctionAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__4__Impl"


    // $ANTLR start "rule__Function__Group__5"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1941:1: rule__Function__Group__5 : rule__Function__Group__5__Impl ;
    public final void rule__Function__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1945:1: ( rule__Function__Group__5__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1946:2: rule__Function__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group__5__Impl_in_rule__Function__Group__54161);
            rule__Function__Group__5__Impl();

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
    // $ANTLR end "rule__Function__Group__5"


    // $ANTLR start "rule__Function__Group__5__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1952:1: rule__Function__Group__5__Impl : ( ( rule__Function__BlockAssignment_5 ) ) ;
    public final void rule__Function__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1956:1: ( ( ( rule__Function__BlockAssignment_5 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1957:1: ( ( rule__Function__BlockAssignment_5 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1957:1: ( ( rule__Function__BlockAssignment_5 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1958:1: ( rule__Function__BlockAssignment_5 )
            {
             before(grammarAccess.getFunctionAccess().getBlockAssignment_5()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1959:1: ( rule__Function__BlockAssignment_5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1959:2: rule__Function__BlockAssignment_5
            {
            pushFollow(FOLLOW_rule__Function__BlockAssignment_5_in_rule__Function__Group__5__Impl4188);
            rule__Function__BlockAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getBlockAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group__5__Impl"


    // $ANTLR start "rule__Function__Group_3__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1981:1: rule__Function__Group_3__0 : rule__Function__Group_3__0__Impl rule__Function__Group_3__1 ;
    public final void rule__Function__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1985:1: ( rule__Function__Group_3__0__Impl rule__Function__Group_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1986:2: rule__Function__Group_3__0__Impl rule__Function__Group_3__1
            {
            pushFollow(FOLLOW_rule__Function__Group_3__0__Impl_in_rule__Function__Group_3__04230);
            rule__Function__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group_3__1_in_rule__Function__Group_3__04233);
            rule__Function__Group_3__1();

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
    // $ANTLR end "rule__Function__Group_3__0"


    // $ANTLR start "rule__Function__Group_3__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1993:1: rule__Function__Group_3__0__Impl : ( ( rule__Function__ArgsAssignment_3_0 ) ) ;
    public final void rule__Function__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1997:1: ( ( ( rule__Function__ArgsAssignment_3_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1998:1: ( ( rule__Function__ArgsAssignment_3_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1998:1: ( ( rule__Function__ArgsAssignment_3_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:1999:1: ( rule__Function__ArgsAssignment_3_0 )
            {
             before(grammarAccess.getFunctionAccess().getArgsAssignment_3_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2000:1: ( rule__Function__ArgsAssignment_3_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2000:2: rule__Function__ArgsAssignment_3_0
            {
            pushFollow(FOLLOW_rule__Function__ArgsAssignment_3_0_in_rule__Function__Group_3__0__Impl4260);
            rule__Function__ArgsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getArgsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group_3__0__Impl"


    // $ANTLR start "rule__Function__Group_3__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2010:1: rule__Function__Group_3__1 : rule__Function__Group_3__1__Impl ;
    public final void rule__Function__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2014:1: ( rule__Function__Group_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2015:2: rule__Function__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group_3__1__Impl_in_rule__Function__Group_3__14290);
            rule__Function__Group_3__1__Impl();

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
    // $ANTLR end "rule__Function__Group_3__1"


    // $ANTLR start "rule__Function__Group_3__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2021:1: rule__Function__Group_3__1__Impl : ( ( rule__Function__Group_3_1__0 )* ) ;
    public final void rule__Function__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2025:1: ( ( ( rule__Function__Group_3_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2026:1: ( ( rule__Function__Group_3_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2026:1: ( ( rule__Function__Group_3_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2027:1: ( rule__Function__Group_3_1__0 )*
            {
             before(grammarAccess.getFunctionAccess().getGroup_3_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2028:1: ( rule__Function__Group_3_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==26) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2028:2: rule__Function__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Function__Group_3_1__0_in_rule__Function__Group_3__1__Impl4317);
            	    rule__Function__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getFunctionAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group_3__1__Impl"


    // $ANTLR start "rule__Function__Group_3_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2042:1: rule__Function__Group_3_1__0 : rule__Function__Group_3_1__0__Impl rule__Function__Group_3_1__1 ;
    public final void rule__Function__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2046:1: ( rule__Function__Group_3_1__0__Impl rule__Function__Group_3_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2047:2: rule__Function__Group_3_1__0__Impl rule__Function__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Function__Group_3_1__0__Impl_in_rule__Function__Group_3_1__04352);
            rule__Function__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Function__Group_3_1__1_in_rule__Function__Group_3_1__04355);
            rule__Function__Group_3_1__1();

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
    // $ANTLR end "rule__Function__Group_3_1__0"


    // $ANTLR start "rule__Function__Group_3_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2054:1: rule__Function__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__Function__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2058:1: ( ( ',' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2059:1: ( ',' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2059:1: ( ',' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2060:1: ','
            {
             before(grammarAccess.getFunctionAccess().getCommaKeyword_3_1_0()); 
            match(input,26,FOLLOW_26_in_rule__Function__Group_3_1__0__Impl4383); 
             after(grammarAccess.getFunctionAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group_3_1__0__Impl"


    // $ANTLR start "rule__Function__Group_3_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2073:1: rule__Function__Group_3_1__1 : rule__Function__Group_3_1__1__Impl ;
    public final void rule__Function__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2077:1: ( rule__Function__Group_3_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2078:2: rule__Function__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Function__Group_3_1__1__Impl_in_rule__Function__Group_3_1__14414);
            rule__Function__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__Function__Group_3_1__1"


    // $ANTLR start "rule__Function__Group_3_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2084:1: rule__Function__Group_3_1__1__Impl : ( ( rule__Function__ArgsAssignment_3_1_1 ) ) ;
    public final void rule__Function__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2088:1: ( ( ( rule__Function__ArgsAssignment_3_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2089:1: ( ( rule__Function__ArgsAssignment_3_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2089:1: ( ( rule__Function__ArgsAssignment_3_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2090:1: ( rule__Function__ArgsAssignment_3_1_1 )
            {
             before(grammarAccess.getFunctionAccess().getArgsAssignment_3_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2091:1: ( rule__Function__ArgsAssignment_3_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2091:2: rule__Function__ArgsAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__Function__ArgsAssignment_3_1_1_in_rule__Function__Group_3_1__1__Impl4441);
            rule__Function__ArgsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getFunctionAccess().getArgsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__Group_3_1__1__Impl"


    // $ANTLR start "rule__Block__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2105:1: rule__Block__Group__0 : rule__Block__Group__0__Impl rule__Block__Group__1 ;
    public final void rule__Block__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2109:1: ( rule__Block__Group__0__Impl rule__Block__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2110:2: rule__Block__Group__0__Impl rule__Block__Group__1
            {
            pushFollow(FOLLOW_rule__Block__Group__0__Impl_in_rule__Block__Group__04475);
            rule__Block__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Block__Group__1_in_rule__Block__Group__04478);
            rule__Block__Group__1();

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
    // $ANTLR end "rule__Block__Group__0"


    // $ANTLR start "rule__Block__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2117:1: rule__Block__Group__0__Impl : ( () ) ;
    public final void rule__Block__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2121:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2122:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2122:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2123:1: ()
            {
             before(grammarAccess.getBlockAccess().getBlockAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2124:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2126:1: 
            {
            }

             after(grammarAccess.getBlockAccess().getBlockAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__0__Impl"


    // $ANTLR start "rule__Block__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2136:1: rule__Block__Group__1 : rule__Block__Group__1__Impl rule__Block__Group__2 ;
    public final void rule__Block__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2140:1: ( rule__Block__Group__1__Impl rule__Block__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2141:2: rule__Block__Group__1__Impl rule__Block__Group__2
            {
            pushFollow(FOLLOW_rule__Block__Group__1__Impl_in_rule__Block__Group__14536);
            rule__Block__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Block__Group__2_in_rule__Block__Group__14539);
            rule__Block__Group__2();

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
    // $ANTLR end "rule__Block__Group__1"


    // $ANTLR start "rule__Block__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2148:1: rule__Block__Group__1__Impl : ( '{' ) ;
    public final void rule__Block__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2152:1: ( ( '{' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2153:1: ( '{' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2153:1: ( '{' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2154:1: '{'
            {
             before(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,27,FOLLOW_27_in_rule__Block__Group__1__Impl4567); 
             after(grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__1__Impl"


    // $ANTLR start "rule__Block__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2167:1: rule__Block__Group__2 : rule__Block__Group__2__Impl rule__Block__Group__3 ;
    public final void rule__Block__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2171:1: ( rule__Block__Group__2__Impl rule__Block__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2172:2: rule__Block__Group__2__Impl rule__Block__Group__3
            {
            pushFollow(FOLLOW_rule__Block__Group__2__Impl_in_rule__Block__Group__24598);
            rule__Block__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Block__Group__3_in_rule__Block__Group__24601);
            rule__Block__Group__3();

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
    // $ANTLR end "rule__Block__Group__2"


    // $ANTLR start "rule__Block__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2179:1: rule__Block__Group__2__Impl : ( ( rule__Block__StatementsAssignment_2 )* ) ;
    public final void rule__Block__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2183:1: ( ( ( rule__Block__StatementsAssignment_2 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2184:1: ( ( rule__Block__StatementsAssignment_2 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2184:1: ( ( rule__Block__StatementsAssignment_2 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2185:1: ( rule__Block__StatementsAssignment_2 )*
            {
             before(grammarAccess.getBlockAccess().getStatementsAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2186:1: ( rule__Block__StatementsAssignment_2 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID||LA24_0==RULE_NUMBER||(LA24_0>=12 && LA24_0<=14)||LA24_0==24||LA24_0==27||(LA24_0>=30 && LA24_0<=31)||(LA24_0>=33 && LA24_0<=34)||LA24_0==48||LA24_0==50||(LA24_0>=54 && LA24_0<=55)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2186:2: rule__Block__StatementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Block__StatementsAssignment_2_in_rule__Block__Group__2__Impl4628);
            	    rule__Block__StatementsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getBlockAccess().getStatementsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__2__Impl"


    // $ANTLR start "rule__Block__Group__3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2196:1: rule__Block__Group__3 : rule__Block__Group__3__Impl ;
    public final void rule__Block__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2200:1: ( rule__Block__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2201:2: rule__Block__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Block__Group__3__Impl_in_rule__Block__Group__34659);
            rule__Block__Group__3__Impl();

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
    // $ANTLR end "rule__Block__Group__3"


    // $ANTLR start "rule__Block__Group__3__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2207:1: rule__Block__Group__3__Impl : ( '}' ) ;
    public final void rule__Block__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2211:1: ( ( '}' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2212:1: ( '}' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2212:1: ( '}' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2213:1: '}'
            {
             before(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3()); 
            match(input,28,FOLLOW_28_in_rule__Block__Group__3__Impl4687); 
             after(grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__Group__3__Impl"


    // $ANTLR start "rule__Statement__Group_0__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2234:1: rule__Statement__Group_0__0 : rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1 ;
    public final void rule__Statement__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2238:1: ( rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2239:2: rule__Statement__Group_0__0__Impl rule__Statement__Group_0__1
            {
            pushFollow(FOLLOW_rule__Statement__Group_0__0__Impl_in_rule__Statement__Group_0__04726);
            rule__Statement__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Statement__Group_0__1_in_rule__Statement__Group_0__04729);
            rule__Statement__Group_0__1();

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
    // $ANTLR end "rule__Statement__Group_0__0"


    // $ANTLR start "rule__Statement__Group_0__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2246:1: rule__Statement__Group_0__0__Impl : ( ( rule__Statement__Alternatives_0_0 ) ) ;
    public final void rule__Statement__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2250:1: ( ( ( rule__Statement__Alternatives_0_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2251:1: ( ( rule__Statement__Alternatives_0_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2251:1: ( ( rule__Statement__Alternatives_0_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2252:1: ( rule__Statement__Alternatives_0_0 )
            {
             before(grammarAccess.getStatementAccess().getAlternatives_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2253:1: ( rule__Statement__Alternatives_0_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2253:2: rule__Statement__Alternatives_0_0
            {
            pushFollow(FOLLOW_rule__Statement__Alternatives_0_0_in_rule__Statement__Group_0__0__Impl4756);
            rule__Statement__Alternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getStatementAccess().getAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_0__0__Impl"


    // $ANTLR start "rule__Statement__Group_0__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2263:1: rule__Statement__Group_0__1 : rule__Statement__Group_0__1__Impl ;
    public final void rule__Statement__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2267:1: ( rule__Statement__Group_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2268:2: rule__Statement__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Statement__Group_0__1__Impl_in_rule__Statement__Group_0__14786);
            rule__Statement__Group_0__1__Impl();

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
    // $ANTLR end "rule__Statement__Group_0__1"


    // $ANTLR start "rule__Statement__Group_0__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2274:1: rule__Statement__Group_0__1__Impl : ( ';' ) ;
    public final void rule__Statement__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2278:1: ( ( ';' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2279:1: ( ';' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2279:1: ( ';' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2280:1: ';'
            {
             before(grammarAccess.getStatementAccess().getSemicolonKeyword_0_1()); 
            match(input,29,FOLLOW_29_in_rule__Statement__Group_0__1__Impl4814); 
             after(grammarAccess.getStatementAccess().getSemicolonKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Group_0__1__Impl"


    // $ANTLR start "rule__ReturnStatement__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2297:1: rule__ReturnStatement__Group__0 : rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1 ;
    public final void rule__ReturnStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2301:1: ( rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2302:2: rule__ReturnStatement__Group__0__Impl rule__ReturnStatement__Group__1
            {
            pushFollow(FOLLOW_rule__ReturnStatement__Group__0__Impl_in_rule__ReturnStatement__Group__04849);
            rule__ReturnStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReturnStatement__Group__1_in_rule__ReturnStatement__Group__04852);
            rule__ReturnStatement__Group__1();

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
    // $ANTLR end "rule__ReturnStatement__Group__0"


    // $ANTLR start "rule__ReturnStatement__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2309:1: rule__ReturnStatement__Group__0__Impl : ( () ) ;
    public final void rule__ReturnStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2313:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2314:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2314:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2315:1: ()
            {
             before(grammarAccess.getReturnStatementAccess().getReturnAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2316:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2318:1: 
            {
            }

             after(grammarAccess.getReturnStatementAccess().getReturnAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReturnStatement__Group__0__Impl"


    // $ANTLR start "rule__ReturnStatement__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2328:1: rule__ReturnStatement__Group__1 : rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2 ;
    public final void rule__ReturnStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2332:1: ( rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2333:2: rule__ReturnStatement__Group__1__Impl rule__ReturnStatement__Group__2
            {
            pushFollow(FOLLOW_rule__ReturnStatement__Group__1__Impl_in_rule__ReturnStatement__Group__14910);
            rule__ReturnStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReturnStatement__Group__2_in_rule__ReturnStatement__Group__14913);
            rule__ReturnStatement__Group__2();

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
    // $ANTLR end "rule__ReturnStatement__Group__1"


    // $ANTLR start "rule__ReturnStatement__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2340:1: rule__ReturnStatement__Group__1__Impl : ( 'return' ) ;
    public final void rule__ReturnStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2344:1: ( ( 'return' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2345:1: ( 'return' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2345:1: ( 'return' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2346:1: 'return'
            {
             before(grammarAccess.getReturnStatementAccess().getReturnKeyword_1()); 
            match(input,30,FOLLOW_30_in_rule__ReturnStatement__Group__1__Impl4941); 
             after(grammarAccess.getReturnStatementAccess().getReturnKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReturnStatement__Group__1__Impl"


    // $ANTLR start "rule__ReturnStatement__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2359:1: rule__ReturnStatement__Group__2 : rule__ReturnStatement__Group__2__Impl ;
    public final void rule__ReturnStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2363:1: ( rule__ReturnStatement__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2364:2: rule__ReturnStatement__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ReturnStatement__Group__2__Impl_in_rule__ReturnStatement__Group__24972);
            rule__ReturnStatement__Group__2__Impl();

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
    // $ANTLR end "rule__ReturnStatement__Group__2"


    // $ANTLR start "rule__ReturnStatement__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2370:1: rule__ReturnStatement__Group__2__Impl : ( ( rule__ReturnStatement__ExpressionAssignment_2 )? ) ;
    public final void rule__ReturnStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2374:1: ( ( ( rule__ReturnStatement__ExpressionAssignment_2 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2375:1: ( ( rule__ReturnStatement__ExpressionAssignment_2 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2375:1: ( ( rule__ReturnStatement__ExpressionAssignment_2 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2376:1: ( rule__ReturnStatement__ExpressionAssignment_2 )?
            {
             before(grammarAccess.getReturnStatementAccess().getExpressionAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2377:1: ( rule__ReturnStatement__ExpressionAssignment_2 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID||LA25_0==RULE_NUMBER||(LA25_0>=12 && LA25_0<=14)||LA25_0==24||LA25_0==48||LA25_0==50||(LA25_0>=54 && LA25_0<=55)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2377:2: rule__ReturnStatement__ExpressionAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ReturnStatement__ExpressionAssignment_2_in_rule__ReturnStatement__Group__2__Impl4999);
                    rule__ReturnStatement__ExpressionAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReturnStatementAccess().getExpressionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReturnStatement__Group__2__Impl"


    // $ANTLR start "rule__IfStatement__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2393:1: rule__IfStatement__Group__0 : rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1 ;
    public final void rule__IfStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2397:1: ( rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2398:2: rule__IfStatement__Group__0__Impl rule__IfStatement__Group__1
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__0__Impl_in_rule__IfStatement__Group__05036);
            rule__IfStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__1_in_rule__IfStatement__Group__05039);
            rule__IfStatement__Group__1();

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
    // $ANTLR end "rule__IfStatement__Group__0"


    // $ANTLR start "rule__IfStatement__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2405:1: rule__IfStatement__Group__0__Impl : ( () ) ;
    public final void rule__IfStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2409:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2410:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2410:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2411:1: ()
            {
             before(grammarAccess.getIfStatementAccess().getIfAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2412:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2414:1: 
            {
            }

             after(grammarAccess.getIfStatementAccess().getIfAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__0__Impl"


    // $ANTLR start "rule__IfStatement__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2424:1: rule__IfStatement__Group__1 : rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2 ;
    public final void rule__IfStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2428:1: ( rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2429:2: rule__IfStatement__Group__1__Impl rule__IfStatement__Group__2
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__1__Impl_in_rule__IfStatement__Group__15097);
            rule__IfStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__2_in_rule__IfStatement__Group__15100);
            rule__IfStatement__Group__2();

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
    // $ANTLR end "rule__IfStatement__Group__1"


    // $ANTLR start "rule__IfStatement__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2436:1: rule__IfStatement__Group__1__Impl : ( 'if' ) ;
    public final void rule__IfStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2440:1: ( ( 'if' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2441:1: ( 'if' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2441:1: ( 'if' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2442:1: 'if'
            {
             before(grammarAccess.getIfStatementAccess().getIfKeyword_1()); 
            match(input,31,FOLLOW_31_in_rule__IfStatement__Group__1__Impl5128); 
             after(grammarAccess.getIfStatementAccess().getIfKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__1__Impl"


    // $ANTLR start "rule__IfStatement__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2455:1: rule__IfStatement__Group__2 : rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3 ;
    public final void rule__IfStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2459:1: ( rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2460:2: rule__IfStatement__Group__2__Impl rule__IfStatement__Group__3
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__2__Impl_in_rule__IfStatement__Group__25159);
            rule__IfStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__3_in_rule__IfStatement__Group__25162);
            rule__IfStatement__Group__3();

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
    // $ANTLR end "rule__IfStatement__Group__2"


    // $ANTLR start "rule__IfStatement__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2467:1: rule__IfStatement__Group__2__Impl : ( '(' ) ;
    public final void rule__IfStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2471:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2472:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2472:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2473:1: '('
            {
             before(grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__IfStatement__Group__2__Impl5190); 
             after(grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__2__Impl"


    // $ANTLR start "rule__IfStatement__Group__3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2486:1: rule__IfStatement__Group__3 : rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4 ;
    public final void rule__IfStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2490:1: ( rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2491:2: rule__IfStatement__Group__3__Impl rule__IfStatement__Group__4
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__3__Impl_in_rule__IfStatement__Group__35221);
            rule__IfStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__4_in_rule__IfStatement__Group__35224);
            rule__IfStatement__Group__4();

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
    // $ANTLR end "rule__IfStatement__Group__3"


    // $ANTLR start "rule__IfStatement__Group__3__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2498:1: rule__IfStatement__Group__3__Impl : ( ( rule__IfStatement__IfAssignment_3 ) ) ;
    public final void rule__IfStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2502:1: ( ( ( rule__IfStatement__IfAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2503:1: ( ( rule__IfStatement__IfAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2503:1: ( ( rule__IfStatement__IfAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2504:1: ( rule__IfStatement__IfAssignment_3 )
            {
             before(grammarAccess.getIfStatementAccess().getIfAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2505:1: ( rule__IfStatement__IfAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2505:2: rule__IfStatement__IfAssignment_3
            {
            pushFollow(FOLLOW_rule__IfStatement__IfAssignment_3_in_rule__IfStatement__Group__3__Impl5251);
            rule__IfStatement__IfAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIfStatementAccess().getIfAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__3__Impl"


    // $ANTLR start "rule__IfStatement__Group__4"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2515:1: rule__IfStatement__Group__4 : rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5 ;
    public final void rule__IfStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2519:1: ( rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2520:2: rule__IfStatement__Group__4__Impl rule__IfStatement__Group__5
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__4__Impl_in_rule__IfStatement__Group__45281);
            rule__IfStatement__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__5_in_rule__IfStatement__Group__45284);
            rule__IfStatement__Group__5();

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
    // $ANTLR end "rule__IfStatement__Group__4"


    // $ANTLR start "rule__IfStatement__Group__4__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2527:1: rule__IfStatement__Group__4__Impl : ( ')' ) ;
    public final void rule__IfStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2531:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2532:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2532:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2533:1: ')'
            {
             before(grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__IfStatement__Group__4__Impl5312); 
             after(grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__4__Impl"


    // $ANTLR start "rule__IfStatement__Group__5"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2546:1: rule__IfStatement__Group__5 : rule__IfStatement__Group__5__Impl rule__IfStatement__Group__6 ;
    public final void rule__IfStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2550:1: ( rule__IfStatement__Group__5__Impl rule__IfStatement__Group__6 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2551:2: rule__IfStatement__Group__5__Impl rule__IfStatement__Group__6
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__5__Impl_in_rule__IfStatement__Group__55343);
            rule__IfStatement__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group__6_in_rule__IfStatement__Group__55346);
            rule__IfStatement__Group__6();

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
    // $ANTLR end "rule__IfStatement__Group__5"


    // $ANTLR start "rule__IfStatement__Group__5__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2558:1: rule__IfStatement__Group__5__Impl : ( ( rule__IfStatement__ThenAssignment_5 ) ) ;
    public final void rule__IfStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2562:1: ( ( ( rule__IfStatement__ThenAssignment_5 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2563:1: ( ( rule__IfStatement__ThenAssignment_5 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2563:1: ( ( rule__IfStatement__ThenAssignment_5 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2564:1: ( rule__IfStatement__ThenAssignment_5 )
            {
             before(grammarAccess.getIfStatementAccess().getThenAssignment_5()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2565:1: ( rule__IfStatement__ThenAssignment_5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2565:2: rule__IfStatement__ThenAssignment_5
            {
            pushFollow(FOLLOW_rule__IfStatement__ThenAssignment_5_in_rule__IfStatement__Group__5__Impl5373);
            rule__IfStatement__ThenAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getIfStatementAccess().getThenAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__5__Impl"


    // $ANTLR start "rule__IfStatement__Group__6"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2575:1: rule__IfStatement__Group__6 : rule__IfStatement__Group__6__Impl ;
    public final void rule__IfStatement__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2579:1: ( rule__IfStatement__Group__6__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2580:2: rule__IfStatement__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__IfStatement__Group__6__Impl_in_rule__IfStatement__Group__65403);
            rule__IfStatement__Group__6__Impl();

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
    // $ANTLR end "rule__IfStatement__Group__6"


    // $ANTLR start "rule__IfStatement__Group__6__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2586:1: rule__IfStatement__Group__6__Impl : ( ( rule__IfStatement__Group_6__0 )? ) ;
    public final void rule__IfStatement__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2590:1: ( ( ( rule__IfStatement__Group_6__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2591:1: ( ( rule__IfStatement__Group_6__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2591:1: ( ( rule__IfStatement__Group_6__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2592:1: ( rule__IfStatement__Group_6__0 )?
            {
             before(grammarAccess.getIfStatementAccess().getGroup_6()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2593:1: ( rule__IfStatement__Group_6__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==32) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2593:2: rule__IfStatement__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__IfStatement__Group_6__0_in_rule__IfStatement__Group__6__Impl5430);
                    rule__IfStatement__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIfStatementAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group__6__Impl"


    // $ANTLR start "rule__IfStatement__Group_6__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2617:1: rule__IfStatement__Group_6__0 : rule__IfStatement__Group_6__0__Impl rule__IfStatement__Group_6__1 ;
    public final void rule__IfStatement__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2621:1: ( rule__IfStatement__Group_6__0__Impl rule__IfStatement__Group_6__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2622:2: rule__IfStatement__Group_6__0__Impl rule__IfStatement__Group_6__1
            {
            pushFollow(FOLLOW_rule__IfStatement__Group_6__0__Impl_in_rule__IfStatement__Group_6__05475);
            rule__IfStatement__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__IfStatement__Group_6__1_in_rule__IfStatement__Group_6__05478);
            rule__IfStatement__Group_6__1();

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
    // $ANTLR end "rule__IfStatement__Group_6__0"


    // $ANTLR start "rule__IfStatement__Group_6__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2629:1: rule__IfStatement__Group_6__0__Impl : ( 'else' ) ;
    public final void rule__IfStatement__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2633:1: ( ( 'else' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2634:1: ( 'else' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2634:1: ( 'else' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2635:1: 'else'
            {
             before(grammarAccess.getIfStatementAccess().getElseKeyword_6_0()); 
            match(input,32,FOLLOW_32_in_rule__IfStatement__Group_6__0__Impl5506); 
             after(grammarAccess.getIfStatementAccess().getElseKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group_6__0__Impl"


    // $ANTLR start "rule__IfStatement__Group_6__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2648:1: rule__IfStatement__Group_6__1 : rule__IfStatement__Group_6__1__Impl ;
    public final void rule__IfStatement__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2652:1: ( rule__IfStatement__Group_6__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2653:2: rule__IfStatement__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__IfStatement__Group_6__1__Impl_in_rule__IfStatement__Group_6__15537);
            rule__IfStatement__Group_6__1__Impl();

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
    // $ANTLR end "rule__IfStatement__Group_6__1"


    // $ANTLR start "rule__IfStatement__Group_6__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2659:1: rule__IfStatement__Group_6__1__Impl : ( ( rule__IfStatement__ElseAssignment_6_1 ) ) ;
    public final void rule__IfStatement__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2663:1: ( ( ( rule__IfStatement__ElseAssignment_6_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2664:1: ( ( rule__IfStatement__ElseAssignment_6_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2664:1: ( ( rule__IfStatement__ElseAssignment_6_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2665:1: ( rule__IfStatement__ElseAssignment_6_1 )
            {
             before(grammarAccess.getIfStatementAccess().getElseAssignment_6_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2666:1: ( rule__IfStatement__ElseAssignment_6_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2666:2: rule__IfStatement__ElseAssignment_6_1
            {
            pushFollow(FOLLOW_rule__IfStatement__ElseAssignment_6_1_in_rule__IfStatement__Group_6__1__Impl5564);
            rule__IfStatement__ElseAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getIfStatementAccess().getElseAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__Group_6__1__Impl"


    // $ANTLR start "rule__WhileStatement__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2680:1: rule__WhileStatement__Group__0 : rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1 ;
    public final void rule__WhileStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2684:1: ( rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2685:2: rule__WhileStatement__Group__0__Impl rule__WhileStatement__Group__1
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__0__Impl_in_rule__WhileStatement__Group__05598);
            rule__WhileStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__1_in_rule__WhileStatement__Group__05601);
            rule__WhileStatement__Group__1();

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
    // $ANTLR end "rule__WhileStatement__Group__0"


    // $ANTLR start "rule__WhileStatement__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2692:1: rule__WhileStatement__Group__0__Impl : ( () ) ;
    public final void rule__WhileStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2696:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2697:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2697:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2698:1: ()
            {
             before(grammarAccess.getWhileStatementAccess().getWhileAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2699:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2701:1: 
            {
            }

             after(grammarAccess.getWhileStatementAccess().getWhileAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__0__Impl"


    // $ANTLR start "rule__WhileStatement__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2711:1: rule__WhileStatement__Group__1 : rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2 ;
    public final void rule__WhileStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2715:1: ( rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2716:2: rule__WhileStatement__Group__1__Impl rule__WhileStatement__Group__2
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__1__Impl_in_rule__WhileStatement__Group__15659);
            rule__WhileStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__2_in_rule__WhileStatement__Group__15662);
            rule__WhileStatement__Group__2();

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
    // $ANTLR end "rule__WhileStatement__Group__1"


    // $ANTLR start "rule__WhileStatement__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2723:1: rule__WhileStatement__Group__1__Impl : ( 'while' ) ;
    public final void rule__WhileStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2727:1: ( ( 'while' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2728:1: ( 'while' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2728:1: ( 'while' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2729:1: 'while'
            {
             before(grammarAccess.getWhileStatementAccess().getWhileKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__WhileStatement__Group__1__Impl5690); 
             after(grammarAccess.getWhileStatementAccess().getWhileKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__1__Impl"


    // $ANTLR start "rule__WhileStatement__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2742:1: rule__WhileStatement__Group__2 : rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3 ;
    public final void rule__WhileStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2746:1: ( rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2747:2: rule__WhileStatement__Group__2__Impl rule__WhileStatement__Group__3
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__2__Impl_in_rule__WhileStatement__Group__25721);
            rule__WhileStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__3_in_rule__WhileStatement__Group__25724);
            rule__WhileStatement__Group__3();

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
    // $ANTLR end "rule__WhileStatement__Group__2"


    // $ANTLR start "rule__WhileStatement__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2754:1: rule__WhileStatement__Group__2__Impl : ( '(' ) ;
    public final void rule__WhileStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2758:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2759:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2759:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2760:1: '('
            {
             before(grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__WhileStatement__Group__2__Impl5752); 
             after(grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__2__Impl"


    // $ANTLR start "rule__WhileStatement__Group__3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2773:1: rule__WhileStatement__Group__3 : rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4 ;
    public final void rule__WhileStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2777:1: ( rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2778:2: rule__WhileStatement__Group__3__Impl rule__WhileStatement__Group__4
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__3__Impl_in_rule__WhileStatement__Group__35783);
            rule__WhileStatement__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__4_in_rule__WhileStatement__Group__35786);
            rule__WhileStatement__Group__4();

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
    // $ANTLR end "rule__WhileStatement__Group__3"


    // $ANTLR start "rule__WhileStatement__Group__3__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2785:1: rule__WhileStatement__Group__3__Impl : ( ( rule__WhileStatement__PredicateAssignment_3 ) ) ;
    public final void rule__WhileStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2789:1: ( ( ( rule__WhileStatement__PredicateAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2790:1: ( ( rule__WhileStatement__PredicateAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2790:1: ( ( rule__WhileStatement__PredicateAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2791:1: ( rule__WhileStatement__PredicateAssignment_3 )
            {
             before(grammarAccess.getWhileStatementAccess().getPredicateAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2792:1: ( rule__WhileStatement__PredicateAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2792:2: rule__WhileStatement__PredicateAssignment_3
            {
            pushFollow(FOLLOW_rule__WhileStatement__PredicateAssignment_3_in_rule__WhileStatement__Group__3__Impl5813);
            rule__WhileStatement__PredicateAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getWhileStatementAccess().getPredicateAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__3__Impl"


    // $ANTLR start "rule__WhileStatement__Group__4"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2802:1: rule__WhileStatement__Group__4 : rule__WhileStatement__Group__4__Impl rule__WhileStatement__Group__5 ;
    public final void rule__WhileStatement__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2806:1: ( rule__WhileStatement__Group__4__Impl rule__WhileStatement__Group__5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2807:2: rule__WhileStatement__Group__4__Impl rule__WhileStatement__Group__5
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__4__Impl_in_rule__WhileStatement__Group__45843);
            rule__WhileStatement__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__WhileStatement__Group__5_in_rule__WhileStatement__Group__45846);
            rule__WhileStatement__Group__5();

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
    // $ANTLR end "rule__WhileStatement__Group__4"


    // $ANTLR start "rule__WhileStatement__Group__4__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2814:1: rule__WhileStatement__Group__4__Impl : ( ')' ) ;
    public final void rule__WhileStatement__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2818:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2819:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2819:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2820:1: ')'
            {
             before(grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__WhileStatement__Group__4__Impl5874); 
             after(grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__4__Impl"


    // $ANTLR start "rule__WhileStatement__Group__5"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2833:1: rule__WhileStatement__Group__5 : rule__WhileStatement__Group__5__Impl ;
    public final void rule__WhileStatement__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2837:1: ( rule__WhileStatement__Group__5__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2838:2: rule__WhileStatement__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__WhileStatement__Group__5__Impl_in_rule__WhileStatement__Group__55905);
            rule__WhileStatement__Group__5__Impl();

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
    // $ANTLR end "rule__WhileStatement__Group__5"


    // $ANTLR start "rule__WhileStatement__Group__5__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2844:1: rule__WhileStatement__Group__5__Impl : ( ( rule__WhileStatement__BodyAssignment_5 ) ) ;
    public final void rule__WhileStatement__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2848:1: ( ( ( rule__WhileStatement__BodyAssignment_5 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2849:1: ( ( rule__WhileStatement__BodyAssignment_5 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2849:1: ( ( rule__WhileStatement__BodyAssignment_5 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2850:1: ( rule__WhileStatement__BodyAssignment_5 )
            {
             before(grammarAccess.getWhileStatementAccess().getBodyAssignment_5()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2851:1: ( rule__WhileStatement__BodyAssignment_5 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2851:2: rule__WhileStatement__BodyAssignment_5
            {
            pushFollow(FOLLOW_rule__WhileStatement__BodyAssignment_5_in_rule__WhileStatement__Group__5__Impl5932);
            rule__WhileStatement__BodyAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getWhileStatementAccess().getBodyAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__Group__5__Impl"


    // $ANTLR start "rule__VariableStatement__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2873:1: rule__VariableStatement__Group__0 : rule__VariableStatement__Group__0__Impl rule__VariableStatement__Group__1 ;
    public final void rule__VariableStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2877:1: ( rule__VariableStatement__Group__0__Impl rule__VariableStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2878:2: rule__VariableStatement__Group__0__Impl rule__VariableStatement__Group__1
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__0__Impl_in_rule__VariableStatement__Group__05974);
            rule__VariableStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group__1_in_rule__VariableStatement__Group__05977);
            rule__VariableStatement__Group__1();

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
    // $ANTLR end "rule__VariableStatement__Group__0"


    // $ANTLR start "rule__VariableStatement__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2885:1: rule__VariableStatement__Group__0__Impl : ( () ) ;
    public final void rule__VariableStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2889:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2890:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2890:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2891:1: ()
            {
             before(grammarAccess.getVariableStatementAccess().getVariableAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2892:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2894:1: 
            {
            }

             after(grammarAccess.getVariableStatementAccess().getVariableAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableStatement__Group__0__Impl"


    // $ANTLR start "rule__VariableStatement__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2904:1: rule__VariableStatement__Group__1 : rule__VariableStatement__Group__1__Impl rule__VariableStatement__Group__2 ;
    public final void rule__VariableStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2908:1: ( rule__VariableStatement__Group__1__Impl rule__VariableStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2909:2: rule__VariableStatement__Group__1__Impl rule__VariableStatement__Group__2
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__1__Impl_in_rule__VariableStatement__Group__16035);
            rule__VariableStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group__2_in_rule__VariableStatement__Group__16038);
            rule__VariableStatement__Group__2();

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
    // $ANTLR end "rule__VariableStatement__Group__1"


    // $ANTLR start "rule__VariableStatement__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2916:1: rule__VariableStatement__Group__1__Impl : ( 'var' ) ;
    public final void rule__VariableStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2920:1: ( ( 'var' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2921:1: ( 'var' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2921:1: ( 'var' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2922:1: 'var'
            {
             before(grammarAccess.getVariableStatementAccess().getVarKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__VariableStatement__Group__1__Impl6066); 
             after(grammarAccess.getVariableStatementAccess().getVarKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableStatement__Group__1__Impl"


    // $ANTLR start "rule__VariableStatement__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2935:1: rule__VariableStatement__Group__2 : rule__VariableStatement__Group__2__Impl rule__VariableStatement__Group__3 ;
    public final void rule__VariableStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2939:1: ( rule__VariableStatement__Group__2__Impl rule__VariableStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2940:2: rule__VariableStatement__Group__2__Impl rule__VariableStatement__Group__3
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__2__Impl_in_rule__VariableStatement__Group__26097);
            rule__VariableStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group__3_in_rule__VariableStatement__Group__26100);
            rule__VariableStatement__Group__3();

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
    // $ANTLR end "rule__VariableStatement__Group__2"


    // $ANTLR start "rule__VariableStatement__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2947:1: rule__VariableStatement__Group__2__Impl : ( ( rule__VariableStatement__NameAssignment_2 ) ) ;
    public final void rule__VariableStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2951:1: ( ( ( rule__VariableStatement__NameAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2952:1: ( ( rule__VariableStatement__NameAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2952:1: ( ( rule__VariableStatement__NameAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2953:1: ( rule__VariableStatement__NameAssignment_2 )
            {
             before(grammarAccess.getVariableStatementAccess().getNameAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2954:1: ( rule__VariableStatement__NameAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2954:2: rule__VariableStatement__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__VariableStatement__NameAssignment_2_in_rule__VariableStatement__Group__2__Impl6127);
            rule__VariableStatement__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getVariableStatementAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableStatement__Group__2__Impl"


    // $ANTLR start "rule__VariableStatement__Group__3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2964:1: rule__VariableStatement__Group__3 : rule__VariableStatement__Group__3__Impl ;
    public final void rule__VariableStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2968:1: ( rule__VariableStatement__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2969:2: rule__VariableStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group__3__Impl_in_rule__VariableStatement__Group__36157);
            rule__VariableStatement__Group__3__Impl();

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
    // $ANTLR end "rule__VariableStatement__Group__3"


    // $ANTLR start "rule__VariableStatement__Group__3__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2975:1: rule__VariableStatement__Group__3__Impl : ( ( rule__VariableStatement__Group_3__0 )? ) ;
    public final void rule__VariableStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2979:1: ( ( ( rule__VariableStatement__Group_3__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2980:1: ( ( rule__VariableStatement__Group_3__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2980:1: ( ( rule__VariableStatement__Group_3__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2981:1: ( rule__VariableStatement__Group_3__0 )?
            {
             before(grammarAccess.getVariableStatementAccess().getGroup_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2982:1: ( rule__VariableStatement__Group_3__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==35) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:2982:2: rule__VariableStatement__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__VariableStatement__Group_3__0_in_rule__VariableStatement__Group__3__Impl6184);
                    rule__VariableStatement__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableStatementAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableStatement__Group__3__Impl"


    // $ANTLR start "rule__VariableStatement__Group_3__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3000:1: rule__VariableStatement__Group_3__0 : rule__VariableStatement__Group_3__0__Impl rule__VariableStatement__Group_3__1 ;
    public final void rule__VariableStatement__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3004:1: ( rule__VariableStatement__Group_3__0__Impl rule__VariableStatement__Group_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3005:2: rule__VariableStatement__Group_3__0__Impl rule__VariableStatement__Group_3__1
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group_3__0__Impl_in_rule__VariableStatement__Group_3__06223);
            rule__VariableStatement__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableStatement__Group_3__1_in_rule__VariableStatement__Group_3__06226);
            rule__VariableStatement__Group_3__1();

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
    // $ANTLR end "rule__VariableStatement__Group_3__0"


    // $ANTLR start "rule__VariableStatement__Group_3__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3012:1: rule__VariableStatement__Group_3__0__Impl : ( '=' ) ;
    public final void rule__VariableStatement__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3016:1: ( ( '=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3017:1: ( '=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3017:1: ( '=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3018:1: '='
            {
             before(grammarAccess.getVariableStatementAccess().getEqualsSignKeyword_3_0()); 
            match(input,35,FOLLOW_35_in_rule__VariableStatement__Group_3__0__Impl6254); 
             after(grammarAccess.getVariableStatementAccess().getEqualsSignKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableStatement__Group_3__0__Impl"


    // $ANTLR start "rule__VariableStatement__Group_3__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3031:1: rule__VariableStatement__Group_3__1 : rule__VariableStatement__Group_3__1__Impl ;
    public final void rule__VariableStatement__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3035:1: ( rule__VariableStatement__Group_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3036:2: rule__VariableStatement__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__VariableStatement__Group_3__1__Impl_in_rule__VariableStatement__Group_3__16285);
            rule__VariableStatement__Group_3__1__Impl();

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
    // $ANTLR end "rule__VariableStatement__Group_3__1"


    // $ANTLR start "rule__VariableStatement__Group_3__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3042:1: rule__VariableStatement__Group_3__1__Impl : ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) ) ;
    public final void rule__VariableStatement__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3046:1: ( ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3047:1: ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3047:1: ( ( rule__VariableStatement__ExpressionAssignment_3_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3048:1: ( rule__VariableStatement__ExpressionAssignment_3_1 )
            {
             before(grammarAccess.getVariableStatementAccess().getExpressionAssignment_3_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3049:1: ( rule__VariableStatement__ExpressionAssignment_3_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3049:2: rule__VariableStatement__ExpressionAssignment_3_1
            {
            pushFollow(FOLLOW_rule__VariableStatement__ExpressionAssignment_3_1_in_rule__VariableStatement__Group_3__1__Impl6312);
            rule__VariableStatement__ExpressionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getVariableStatementAccess().getExpressionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableStatement__Group_3__1__Impl"


    // $ANTLR start "rule__AssignmentStatement__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3063:1: rule__AssignmentStatement__Group__0 : rule__AssignmentStatement__Group__0__Impl rule__AssignmentStatement__Group__1 ;
    public final void rule__AssignmentStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3067:1: ( rule__AssignmentStatement__Group__0__Impl rule__AssignmentStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3068:2: rule__AssignmentStatement__Group__0__Impl rule__AssignmentStatement__Group__1
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__0__Impl_in_rule__AssignmentStatement__Group__06346);
            rule__AssignmentStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignmentStatement__Group__1_in_rule__AssignmentStatement__Group__06349);
            rule__AssignmentStatement__Group__1();

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
    // $ANTLR end "rule__AssignmentStatement__Group__0"


    // $ANTLR start "rule__AssignmentStatement__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3075:1: rule__AssignmentStatement__Group__0__Impl : ( () ) ;
    public final void rule__AssignmentStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3079:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3080:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3080:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3081:1: ()
            {
             before(grammarAccess.getAssignmentStatementAccess().getAssignmentAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3082:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3084:1: 
            {
            }

             after(grammarAccess.getAssignmentStatementAccess().getAssignmentAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentStatement__Group__0__Impl"


    // $ANTLR start "rule__AssignmentStatement__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3094:1: rule__AssignmentStatement__Group__1 : rule__AssignmentStatement__Group__1__Impl rule__AssignmentStatement__Group__2 ;
    public final void rule__AssignmentStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3098:1: ( rule__AssignmentStatement__Group__1__Impl rule__AssignmentStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3099:2: rule__AssignmentStatement__Group__1__Impl rule__AssignmentStatement__Group__2
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__1__Impl_in_rule__AssignmentStatement__Group__16407);
            rule__AssignmentStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignmentStatement__Group__2_in_rule__AssignmentStatement__Group__16410);
            rule__AssignmentStatement__Group__2();

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
    // $ANTLR end "rule__AssignmentStatement__Group__1"


    // $ANTLR start "rule__AssignmentStatement__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3106:1: rule__AssignmentStatement__Group__1__Impl : ( ( rule__AssignmentStatement__VarAssignment_1 ) ) ;
    public final void rule__AssignmentStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3110:1: ( ( ( rule__AssignmentStatement__VarAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3111:1: ( ( rule__AssignmentStatement__VarAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3111:1: ( ( rule__AssignmentStatement__VarAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3112:1: ( rule__AssignmentStatement__VarAssignment_1 )
            {
             before(grammarAccess.getAssignmentStatementAccess().getVarAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3113:1: ( rule__AssignmentStatement__VarAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3113:2: rule__AssignmentStatement__VarAssignment_1
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__VarAssignment_1_in_rule__AssignmentStatement__Group__1__Impl6437);
            rule__AssignmentStatement__VarAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentStatementAccess().getVarAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentStatement__Group__1__Impl"


    // $ANTLR start "rule__AssignmentStatement__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3123:1: rule__AssignmentStatement__Group__2 : rule__AssignmentStatement__Group__2__Impl rule__AssignmentStatement__Group__3 ;
    public final void rule__AssignmentStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3127:1: ( rule__AssignmentStatement__Group__2__Impl rule__AssignmentStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3128:2: rule__AssignmentStatement__Group__2__Impl rule__AssignmentStatement__Group__3
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__2__Impl_in_rule__AssignmentStatement__Group__26467);
            rule__AssignmentStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AssignmentStatement__Group__3_in_rule__AssignmentStatement__Group__26470);
            rule__AssignmentStatement__Group__3();

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
    // $ANTLR end "rule__AssignmentStatement__Group__2"


    // $ANTLR start "rule__AssignmentStatement__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3135:1: rule__AssignmentStatement__Group__2__Impl : ( '=' ) ;
    public final void rule__AssignmentStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3139:1: ( ( '=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3140:1: ( '=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3140:1: ( '=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3141:1: '='
            {
             before(grammarAccess.getAssignmentStatementAccess().getEqualsSignKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__AssignmentStatement__Group__2__Impl6498); 
             after(grammarAccess.getAssignmentStatementAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentStatement__Group__2__Impl"


    // $ANTLR start "rule__AssignmentStatement__Group__3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3154:1: rule__AssignmentStatement__Group__3 : rule__AssignmentStatement__Group__3__Impl ;
    public final void rule__AssignmentStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3158:1: ( rule__AssignmentStatement__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3159:2: rule__AssignmentStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__Group__3__Impl_in_rule__AssignmentStatement__Group__36529);
            rule__AssignmentStatement__Group__3__Impl();

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
    // $ANTLR end "rule__AssignmentStatement__Group__3"


    // $ANTLR start "rule__AssignmentStatement__Group__3__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3165:1: rule__AssignmentStatement__Group__3__Impl : ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) ) ;
    public final void rule__AssignmentStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3169:1: ( ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3170:1: ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3170:1: ( ( rule__AssignmentStatement__ExpressionAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3171:1: ( rule__AssignmentStatement__ExpressionAssignment_3 )
            {
             before(grammarAccess.getAssignmentStatementAccess().getExpressionAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3172:1: ( rule__AssignmentStatement__ExpressionAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3172:2: rule__AssignmentStatement__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_rule__AssignmentStatement__ExpressionAssignment_3_in_rule__AssignmentStatement__Group__3__Impl6556);
            rule__AssignmentStatement__ExpressionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentStatementAccess().getExpressionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentStatement__Group__3__Impl"


    // $ANTLR start "rule__ReferenceAssignmentStatement__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3190:1: rule__ReferenceAssignmentStatement__Group__0 : rule__ReferenceAssignmentStatement__Group__0__Impl rule__ReferenceAssignmentStatement__Group__1 ;
    public final void rule__ReferenceAssignmentStatement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3194:1: ( rule__ReferenceAssignmentStatement__Group__0__Impl rule__ReferenceAssignmentStatement__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3195:2: rule__ReferenceAssignmentStatement__Group__0__Impl rule__ReferenceAssignmentStatement__Group__1
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__0__Impl_in_rule__ReferenceAssignmentStatement__Group__06594);
            rule__ReferenceAssignmentStatement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__1_in_rule__ReferenceAssignmentStatement__Group__06597);
            rule__ReferenceAssignmentStatement__Group__1();

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
    // $ANTLR end "rule__ReferenceAssignmentStatement__Group__0"


    // $ANTLR start "rule__ReferenceAssignmentStatement__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3202:1: rule__ReferenceAssignmentStatement__Group__0__Impl : ( () ) ;
    public final void rule__ReferenceAssignmentStatement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3206:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3207:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3207:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3208:1: ()
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignementAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3209:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3211:1: 
            {
            }

             after(grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignementAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceAssignmentStatement__Group__0__Impl"


    // $ANTLR start "rule__ReferenceAssignmentStatement__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3221:1: rule__ReferenceAssignmentStatement__Group__1 : rule__ReferenceAssignmentStatement__Group__1__Impl rule__ReferenceAssignmentStatement__Group__2 ;
    public final void rule__ReferenceAssignmentStatement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3225:1: ( rule__ReferenceAssignmentStatement__Group__1__Impl rule__ReferenceAssignmentStatement__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3226:2: rule__ReferenceAssignmentStatement__Group__1__Impl rule__ReferenceAssignmentStatement__Group__2
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__1__Impl_in_rule__ReferenceAssignmentStatement__Group__16655);
            rule__ReferenceAssignmentStatement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__2_in_rule__ReferenceAssignmentStatement__Group__16658);
            rule__ReferenceAssignmentStatement__Group__2();

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
    // $ANTLR end "rule__ReferenceAssignmentStatement__Group__1"


    // $ANTLR start "rule__ReferenceAssignmentStatement__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3233:1: rule__ReferenceAssignmentStatement__Group__1__Impl : ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) ) ;
    public final void rule__ReferenceAssignmentStatement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3237:1: ( ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3238:1: ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3238:1: ( ( rule__ReferenceAssignmentStatement__RefAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3239:1: ( rule__ReferenceAssignmentStatement__RefAssignment_1 )
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3240:1: ( rule__ReferenceAssignmentStatement__RefAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3240:2: rule__ReferenceAssignmentStatement__RefAssignment_1
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__RefAssignment_1_in_rule__ReferenceAssignmentStatement__Group__1__Impl6685);
            rule__ReferenceAssignmentStatement__RefAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAssignmentStatementAccess().getRefAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceAssignmentStatement__Group__1__Impl"


    // $ANTLR start "rule__ReferenceAssignmentStatement__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3250:1: rule__ReferenceAssignmentStatement__Group__2 : rule__ReferenceAssignmentStatement__Group__2__Impl rule__ReferenceAssignmentStatement__Group__3 ;
    public final void rule__ReferenceAssignmentStatement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3254:1: ( rule__ReferenceAssignmentStatement__Group__2__Impl rule__ReferenceAssignmentStatement__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3255:2: rule__ReferenceAssignmentStatement__Group__2__Impl rule__ReferenceAssignmentStatement__Group__3
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__2__Impl_in_rule__ReferenceAssignmentStatement__Group__26715);
            rule__ReferenceAssignmentStatement__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__3_in_rule__ReferenceAssignmentStatement__Group__26718);
            rule__ReferenceAssignmentStatement__Group__3();

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
    // $ANTLR end "rule__ReferenceAssignmentStatement__Group__2"


    // $ANTLR start "rule__ReferenceAssignmentStatement__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3262:1: rule__ReferenceAssignmentStatement__Group__2__Impl : ( '=' ) ;
    public final void rule__ReferenceAssignmentStatement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3266:1: ( ( '=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3267:1: ( '=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3267:1: ( '=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3268:1: '='
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getEqualsSignKeyword_2()); 
            match(input,35,FOLLOW_35_in_rule__ReferenceAssignmentStatement__Group__2__Impl6746); 
             after(grammarAccess.getReferenceAssignmentStatementAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceAssignmentStatement__Group__2__Impl"


    // $ANTLR start "rule__ReferenceAssignmentStatement__Group__3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3281:1: rule__ReferenceAssignmentStatement__Group__3 : rule__ReferenceAssignmentStatement__Group__3__Impl ;
    public final void rule__ReferenceAssignmentStatement__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3285:1: ( rule__ReferenceAssignmentStatement__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3286:2: rule__ReferenceAssignmentStatement__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__Group__3__Impl_in_rule__ReferenceAssignmentStatement__Group__36777);
            rule__ReferenceAssignmentStatement__Group__3__Impl();

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
    // $ANTLR end "rule__ReferenceAssignmentStatement__Group__3"


    // $ANTLR start "rule__ReferenceAssignmentStatement__Group__3__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3292:1: rule__ReferenceAssignmentStatement__Group__3__Impl : ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) ) ;
    public final void rule__ReferenceAssignmentStatement__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3296:1: ( ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3297:1: ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3297:1: ( ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3298:1: ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 )
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3299:1: ( rule__ReferenceAssignmentStatement__ExpressionAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3299:2: rule__ReferenceAssignmentStatement__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_rule__ReferenceAssignmentStatement__ExpressionAssignment_3_in_rule__ReferenceAssignmentStatement__Group__3__Impl6804);
            rule__ReferenceAssignmentStatement__ExpressionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceAssignmentStatement__Group__3__Impl"


    // $ANTLR start "rule__Logical__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3317:1: rule__Logical__Group__0 : rule__Logical__Group__0__Impl rule__Logical__Group__1 ;
    public final void rule__Logical__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3321:1: ( rule__Logical__Group__0__Impl rule__Logical__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3322:2: rule__Logical__Group__0__Impl rule__Logical__Group__1
            {
            pushFollow(FOLLOW_rule__Logical__Group__0__Impl_in_rule__Logical__Group__06842);
            rule__Logical__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group__1_in_rule__Logical__Group__06845);
            rule__Logical__Group__1();

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
    // $ANTLR end "rule__Logical__Group__0"


    // $ANTLR start "rule__Logical__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3329:1: rule__Logical__Group__0__Impl : ( ruleEquality ) ;
    public final void rule__Logical__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3333:1: ( ( ruleEquality ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3334:1: ( ruleEquality )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3334:1: ( ruleEquality )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3335:1: ruleEquality
            {
             before(grammarAccess.getLogicalAccess().getEqualityParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleEquality_in_rule__Logical__Group__0__Impl6872);
            ruleEquality();

            state._fsp--;

             after(grammarAccess.getLogicalAccess().getEqualityParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logical__Group__0__Impl"


    // $ANTLR start "rule__Logical__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3346:1: rule__Logical__Group__1 : rule__Logical__Group__1__Impl ;
    public final void rule__Logical__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3350:1: ( rule__Logical__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3351:2: rule__Logical__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group__1__Impl_in_rule__Logical__Group__16901);
            rule__Logical__Group__1__Impl();

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
    // $ANTLR end "rule__Logical__Group__1"


    // $ANTLR start "rule__Logical__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3357:1: rule__Logical__Group__1__Impl : ( ( rule__Logical__Group_1__0 )* ) ;
    public final void rule__Logical__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3361:1: ( ( ( rule__Logical__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3362:1: ( ( rule__Logical__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3362:1: ( ( rule__Logical__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3363:1: ( rule__Logical__Group_1__0 )*
            {
             before(grammarAccess.getLogicalAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3364:1: ( rule__Logical__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=36 && LA28_0<=37)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3364:2: rule__Logical__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Logical__Group_1__0_in_rule__Logical__Group__1__Impl6928);
            	    rule__Logical__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getLogicalAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logical__Group__1__Impl"


    // $ANTLR start "rule__Logical__Group_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3378:1: rule__Logical__Group_1__0 : rule__Logical__Group_1__0__Impl rule__Logical__Group_1__1 ;
    public final void rule__Logical__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3382:1: ( rule__Logical__Group_1__0__Impl rule__Logical__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3383:2: rule__Logical__Group_1__0__Impl rule__Logical__Group_1__1
            {
            pushFollow(FOLLOW_rule__Logical__Group_1__0__Impl_in_rule__Logical__Group_1__06963);
            rule__Logical__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group_1__1_in_rule__Logical__Group_1__06966);
            rule__Logical__Group_1__1();

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
    // $ANTLR end "rule__Logical__Group_1__0"


    // $ANTLR start "rule__Logical__Group_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3390:1: rule__Logical__Group_1__0__Impl : ( ( rule__Logical__Alternatives_1_0 ) ) ;
    public final void rule__Logical__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3394:1: ( ( ( rule__Logical__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3395:1: ( ( rule__Logical__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3395:1: ( ( rule__Logical__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3396:1: ( rule__Logical__Alternatives_1_0 )
            {
             before(grammarAccess.getLogicalAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3397:1: ( rule__Logical__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3397:2: rule__Logical__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Logical__Alternatives_1_0_in_rule__Logical__Group_1__0__Impl6993);
            rule__Logical__Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getLogicalAccess().getAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logical__Group_1__0__Impl"


    // $ANTLR start "rule__Logical__Group_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3407:1: rule__Logical__Group_1__1 : rule__Logical__Group_1__1__Impl ;
    public final void rule__Logical__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3411:1: ( rule__Logical__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3412:2: rule__Logical__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group_1__1__Impl_in_rule__Logical__Group_1__17023);
            rule__Logical__Group_1__1__Impl();

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
    // $ANTLR end "rule__Logical__Group_1__1"


    // $ANTLR start "rule__Logical__Group_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3418:1: rule__Logical__Group_1__1__Impl : ( ( rule__Logical__RightAssignment_1_1 ) ) ;
    public final void rule__Logical__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3422:1: ( ( ( rule__Logical__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3423:1: ( ( rule__Logical__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3423:1: ( ( rule__Logical__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3424:1: ( rule__Logical__RightAssignment_1_1 )
            {
             before(grammarAccess.getLogicalAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3425:1: ( rule__Logical__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3425:2: rule__Logical__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Logical__RightAssignment_1_1_in_rule__Logical__Group_1__1__Impl7050);
            rule__Logical__RightAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLogicalAccess().getRightAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logical__Group_1__1__Impl"


    // $ANTLR start "rule__Logical__Group_1_0_0__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3439:1: rule__Logical__Group_1_0_0__0 : rule__Logical__Group_1_0_0__0__Impl rule__Logical__Group_1_0_0__1 ;
    public final void rule__Logical__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3443:1: ( rule__Logical__Group_1_0_0__0__Impl rule__Logical__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3444:2: rule__Logical__Group_1_0_0__0__Impl rule__Logical__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_0__0__Impl_in_rule__Logical__Group_1_0_0__07084);
            rule__Logical__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group_1_0_0__1_in_rule__Logical__Group_1_0_0__07087);
            rule__Logical__Group_1_0_0__1();

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
    // $ANTLR end "rule__Logical__Group_1_0_0__0"


    // $ANTLR start "rule__Logical__Group_1_0_0__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3451:1: rule__Logical__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Logical__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3455:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3456:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3456:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3457:1: ()
            {
             before(grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3458:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3460:1: 
            {
            }

             after(grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logical__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__Logical__Group_1_0_0__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3470:1: rule__Logical__Group_1_0_0__1 : rule__Logical__Group_1_0_0__1__Impl ;
    public final void rule__Logical__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3474:1: ( rule__Logical__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3475:2: rule__Logical__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_0__1__Impl_in_rule__Logical__Group_1_0_0__17145);
            rule__Logical__Group_1_0_0__1__Impl();

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
    // $ANTLR end "rule__Logical__Group_1_0_0__1"


    // $ANTLR start "rule__Logical__Group_1_0_0__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3481:1: rule__Logical__Group_1_0_0__1__Impl : ( '&&' ) ;
    public final void rule__Logical__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3485:1: ( ( '&&' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3486:1: ( '&&' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3486:1: ( '&&' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3487:1: '&&'
            {
             before(grammarAccess.getLogicalAccess().getAmpersandAmpersandKeyword_1_0_0_1()); 
            match(input,36,FOLLOW_36_in_rule__Logical__Group_1_0_0__1__Impl7173); 
             after(grammarAccess.getLogicalAccess().getAmpersandAmpersandKeyword_1_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logical__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__Logical__Group_1_0_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3504:1: rule__Logical__Group_1_0_1__0 : rule__Logical__Group_1_0_1__0__Impl rule__Logical__Group_1_0_1__1 ;
    public final void rule__Logical__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3508:1: ( rule__Logical__Group_1_0_1__0__Impl rule__Logical__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3509:2: rule__Logical__Group_1_0_1__0__Impl rule__Logical__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_1__0__Impl_in_rule__Logical__Group_1_0_1__07208);
            rule__Logical__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Logical__Group_1_0_1__1_in_rule__Logical__Group_1_0_1__07211);
            rule__Logical__Group_1_0_1__1();

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
    // $ANTLR end "rule__Logical__Group_1_0_1__0"


    // $ANTLR start "rule__Logical__Group_1_0_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3516:1: rule__Logical__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Logical__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3520:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3521:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3521:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3522:1: ()
            {
             before(grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3523:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3525:1: 
            {
            }

             after(grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logical__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Logical__Group_1_0_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3535:1: rule__Logical__Group_1_0_1__1 : rule__Logical__Group_1_0_1__1__Impl ;
    public final void rule__Logical__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3539:1: ( rule__Logical__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3540:2: rule__Logical__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Logical__Group_1_0_1__1__Impl_in_rule__Logical__Group_1_0_1__17269);
            rule__Logical__Group_1_0_1__1__Impl();

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
    // $ANTLR end "rule__Logical__Group_1_0_1__1"


    // $ANTLR start "rule__Logical__Group_1_0_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3546:1: rule__Logical__Group_1_0_1__1__Impl : ( '||' ) ;
    public final void rule__Logical__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3550:1: ( ( '||' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3551:1: ( '||' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3551:1: ( '||' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3552:1: '||'
            {
             before(grammarAccess.getLogicalAccess().getVerticalLineVerticalLineKeyword_1_0_1_1()); 
            match(input,37,FOLLOW_37_in_rule__Logical__Group_1_0_1__1__Impl7297); 
             after(grammarAccess.getLogicalAccess().getVerticalLineVerticalLineKeyword_1_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logical__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Equality__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3569:1: rule__Equality__Group__0 : rule__Equality__Group__0__Impl rule__Equality__Group__1 ;
    public final void rule__Equality__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3573:1: ( rule__Equality__Group__0__Impl rule__Equality__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3574:2: rule__Equality__Group__0__Impl rule__Equality__Group__1
            {
            pushFollow(FOLLOW_rule__Equality__Group__0__Impl_in_rule__Equality__Group__07332);
            rule__Equality__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group__1_in_rule__Equality__Group__07335);
            rule__Equality__Group__1();

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
    // $ANTLR end "rule__Equality__Group__0"


    // $ANTLR start "rule__Equality__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3581:1: rule__Equality__Group__0__Impl : ( ruleComparison ) ;
    public final void rule__Equality__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3585:1: ( ( ruleComparison ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3586:1: ( ruleComparison )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3586:1: ( ruleComparison )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3587:1: ruleComparison
            {
             before(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleComparison_in_rule__Equality__Group__0__Impl7362);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__0__Impl"


    // $ANTLR start "rule__Equality__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3598:1: rule__Equality__Group__1 : rule__Equality__Group__1__Impl ;
    public final void rule__Equality__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3602:1: ( rule__Equality__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3603:2: rule__Equality__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group__1__Impl_in_rule__Equality__Group__17391);
            rule__Equality__Group__1__Impl();

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
    // $ANTLR end "rule__Equality__Group__1"


    // $ANTLR start "rule__Equality__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3609:1: rule__Equality__Group__1__Impl : ( ( rule__Equality__Group_1__0 )* ) ;
    public final void rule__Equality__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3613:1: ( ( ( rule__Equality__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3614:1: ( ( rule__Equality__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3614:1: ( ( rule__Equality__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3615:1: ( rule__Equality__Group_1__0 )*
            {
             before(grammarAccess.getEqualityAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3616:1: ( rule__Equality__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=38 && LA29_0<=39)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3616:2: rule__Equality__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Equality__Group_1__0_in_rule__Equality__Group__1__Impl7418);
            	    rule__Equality__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getEqualityAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group__1__Impl"


    // $ANTLR start "rule__Equality__Group_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3630:1: rule__Equality__Group_1__0 : rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 ;
    public final void rule__Equality__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3634:1: ( rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3635:2: rule__Equality__Group_1__0__Impl rule__Equality__Group_1__1
            {
            pushFollow(FOLLOW_rule__Equality__Group_1__0__Impl_in_rule__Equality__Group_1__07453);
            rule__Equality__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group_1__1_in_rule__Equality__Group_1__07456);
            rule__Equality__Group_1__1();

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
    // $ANTLR end "rule__Equality__Group_1__0"


    // $ANTLR start "rule__Equality__Group_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3642:1: rule__Equality__Group_1__0__Impl : ( ( rule__Equality__Alternatives_1_0 ) ) ;
    public final void rule__Equality__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3646:1: ( ( ( rule__Equality__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3647:1: ( ( rule__Equality__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3647:1: ( ( rule__Equality__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3648:1: ( rule__Equality__Alternatives_1_0 )
            {
             before(grammarAccess.getEqualityAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3649:1: ( rule__Equality__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3649:2: rule__Equality__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Equality__Alternatives_1_0_in_rule__Equality__Group_1__0__Impl7483);
            rule__Equality__Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getEqualityAccess().getAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__0__Impl"


    // $ANTLR start "rule__Equality__Group_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3659:1: rule__Equality__Group_1__1 : rule__Equality__Group_1__1__Impl ;
    public final void rule__Equality__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3663:1: ( rule__Equality__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3664:2: rule__Equality__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group_1__1__Impl_in_rule__Equality__Group_1__17513);
            rule__Equality__Group_1__1__Impl();

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
    // $ANTLR end "rule__Equality__Group_1__1"


    // $ANTLR start "rule__Equality__Group_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3670:1: rule__Equality__Group_1__1__Impl : ( ( rule__Equality__RightAssignment_1_1 ) ) ;
    public final void rule__Equality__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3674:1: ( ( ( rule__Equality__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3675:1: ( ( rule__Equality__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3675:1: ( ( rule__Equality__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3676:1: ( rule__Equality__RightAssignment_1_1 )
            {
             before(grammarAccess.getEqualityAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3677:1: ( rule__Equality__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3677:2: rule__Equality__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Equality__RightAssignment_1_1_in_rule__Equality__Group_1__1__Impl7540);
            rule__Equality__RightAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEqualityAccess().getRightAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1__1__Impl"


    // $ANTLR start "rule__Equality__Group_1_0_0__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3691:1: rule__Equality__Group_1_0_0__0 : rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1 ;
    public final void rule__Equality__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3695:1: ( rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3696:2: rule__Equality__Group_1_0_0__0__Impl rule__Equality__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_0__0__Impl_in_rule__Equality__Group_1_0_0__07574);
            rule__Equality__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group_1_0_0__1_in_rule__Equality__Group_1_0_0__07577);
            rule__Equality__Group_1_0_0__1();

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
    // $ANTLR end "rule__Equality__Group_1_0_0__0"


    // $ANTLR start "rule__Equality__Group_1_0_0__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3703:1: rule__Equality__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Equality__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3707:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3708:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3708:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3709:1: ()
            {
             before(grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3710:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3712:1: 
            {
            }

             after(grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__Equality__Group_1_0_0__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3722:1: rule__Equality__Group_1_0_0__1 : rule__Equality__Group_1_0_0__1__Impl ;
    public final void rule__Equality__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3726:1: ( rule__Equality__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3727:2: rule__Equality__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_0__1__Impl_in_rule__Equality__Group_1_0_0__17635);
            rule__Equality__Group_1_0_0__1__Impl();

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
    // $ANTLR end "rule__Equality__Group_1_0_0__1"


    // $ANTLR start "rule__Equality__Group_1_0_0__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3733:1: rule__Equality__Group_1_0_0__1__Impl : ( '==' ) ;
    public final void rule__Equality__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3737:1: ( ( '==' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3738:1: ( '==' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3738:1: ( '==' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3739:1: '=='
            {
             before(grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1()); 
            match(input,38,FOLLOW_38_in_rule__Equality__Group_1_0_0__1__Impl7663); 
             after(grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__Equality__Group_1_0_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3756:1: rule__Equality__Group_1_0_1__0 : rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1 ;
    public final void rule__Equality__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3760:1: ( rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3761:2: rule__Equality__Group_1_0_1__0__Impl rule__Equality__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_1__0__Impl_in_rule__Equality__Group_1_0_1__07698);
            rule__Equality__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Equality__Group_1_0_1__1_in_rule__Equality__Group_1_0_1__07701);
            rule__Equality__Group_1_0_1__1();

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
    // $ANTLR end "rule__Equality__Group_1_0_1__0"


    // $ANTLR start "rule__Equality__Group_1_0_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3768:1: rule__Equality__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Equality__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3772:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3773:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3773:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3774:1: ()
            {
             before(grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3775:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3777:1: 
            {
            }

             after(grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Equality__Group_1_0_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3787:1: rule__Equality__Group_1_0_1__1 : rule__Equality__Group_1_0_1__1__Impl ;
    public final void rule__Equality__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3791:1: ( rule__Equality__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3792:2: rule__Equality__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Equality__Group_1_0_1__1__Impl_in_rule__Equality__Group_1_0_1__17759);
            rule__Equality__Group_1_0_1__1__Impl();

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
    // $ANTLR end "rule__Equality__Group_1_0_1__1"


    // $ANTLR start "rule__Equality__Group_1_0_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3798:1: rule__Equality__Group_1_0_1__1__Impl : ( '!=' ) ;
    public final void rule__Equality__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3802:1: ( ( '!=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3803:1: ( '!=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3803:1: ( '!=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3804:1: '!='
            {
             before(grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1()); 
            match(input,39,FOLLOW_39_in_rule__Equality__Group_1_0_1__1__Impl7787); 
             after(grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Comparison__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3821:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3825:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3826:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__07822);
            rule__Comparison__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__07825);
            rule__Comparison__Group__1();

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
    // $ANTLR end "rule__Comparison__Group__0"


    // $ANTLR start "rule__Comparison__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3833:1: rule__Comparison__Group__0__Impl : ( ruleAddition ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3837:1: ( ( ruleAddition ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3838:1: ( ruleAddition )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3838:1: ( ruleAddition )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3839:1: ruleAddition
            {
             before(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAddition_in_rule__Comparison__Group__0__Impl7852);
            ruleAddition();

            state._fsp--;

             after(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0__Impl"


    // $ANTLR start "rule__Comparison__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3850:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3854:1: ( rule__Comparison__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3855:2: rule__Comparison__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__17881);
            rule__Comparison__Group__1__Impl();

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
    // $ANTLR end "rule__Comparison__Group__1"


    // $ANTLR start "rule__Comparison__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3861:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__Group_1__0 )* ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3865:1: ( ( ( rule__Comparison__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3866:1: ( ( rule__Comparison__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3866:1: ( ( rule__Comparison__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3867:1: ( rule__Comparison__Group_1__0 )*
            {
             before(grammarAccess.getComparisonAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3868:1: ( rule__Comparison__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=40 && LA30_0<=43)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3868:2: rule__Comparison__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl7908);
            	    rule__Comparison__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getComparisonAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3882:1: rule__Comparison__Group_1__0 : rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 ;
    public final void rule__Comparison__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3886:1: ( rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3887:2: rule__Comparison__Group_1__0__Impl rule__Comparison__Group_1__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__07943);
            rule__Comparison__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__07946);
            rule__Comparison__Group_1__1();

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
    // $ANTLR end "rule__Comparison__Group_1__0"


    // $ANTLR start "rule__Comparison__Group_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3894:1: rule__Comparison__Group_1__0__Impl : ( ( rule__Comparison__Alternatives_1_0 ) ) ;
    public final void rule__Comparison__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3898:1: ( ( ( rule__Comparison__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3899:1: ( ( rule__Comparison__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3899:1: ( ( rule__Comparison__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3900:1: ( rule__Comparison__Alternatives_1_0 )
            {
             before(grammarAccess.getComparisonAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3901:1: ( rule__Comparison__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3901:2: rule__Comparison__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Comparison__Alternatives_1_0_in_rule__Comparison__Group_1__0__Impl7973);
            rule__Comparison__Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3911:1: rule__Comparison__Group_1__1 : rule__Comparison__Group_1__1__Impl ;
    public final void rule__Comparison__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3915:1: ( rule__Comparison__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3916:2: rule__Comparison__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__18003);
            rule__Comparison__Group_1__1__Impl();

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
    // $ANTLR end "rule__Comparison__Group_1__1"


    // $ANTLR start "rule__Comparison__Group_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3922:1: rule__Comparison__Group_1__1__Impl : ( ( rule__Comparison__RightAssignment_1_1 ) ) ;
    public final void rule__Comparison__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3926:1: ( ( ( rule__Comparison__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3927:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3927:1: ( ( rule__Comparison__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3928:1: ( rule__Comparison__RightAssignment_1_1 )
            {
             before(grammarAccess.getComparisonAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3929:1: ( rule__Comparison__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3929:2: rule__Comparison__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl8030);
            rule__Comparison__RightAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getRightAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_0__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3943:1: rule__Comparison__Group_1_0_0__0 : rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1 ;
    public final void rule__Comparison__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3947:1: ( rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3948:2: rule__Comparison__Group_1_0_0__0__Impl rule__Comparison__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__0__Impl_in_rule__Comparison__Group_1_0_0__08064);
            rule__Comparison__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__1_in_rule__Comparison__Group_1_0_0__08067);
            rule__Comparison__Group_1_0_0__1();

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
    // $ANTLR end "rule__Comparison__Group_1_0_0__0"


    // $ANTLR start "rule__Comparison__Group_1_0_0__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3955:1: rule__Comparison__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3959:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3960:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3960:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3961:1: ()
            {
             before(grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3962:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3964:1: 
            {
            }

             after(grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_0__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3974:1: rule__Comparison__Group_1_0_0__1 : rule__Comparison__Group_1_0_0__1__Impl ;
    public final void rule__Comparison__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3978:1: ( rule__Comparison__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3979:2: rule__Comparison__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_0__1__Impl_in_rule__Comparison__Group_1_0_0__18125);
            rule__Comparison__Group_1_0_0__1__Impl();

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
    // $ANTLR end "rule__Comparison__Group_1_0_0__1"


    // $ANTLR start "rule__Comparison__Group_1_0_0__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3985:1: rule__Comparison__Group_1_0_0__1__Impl : ( '<' ) ;
    public final void rule__Comparison__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3989:1: ( ( '<' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3990:1: ( '<' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3990:1: ( '<' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:3991:1: '<'
            {
             before(grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_0_1()); 
            match(input,40,FOLLOW_40_in_rule__Comparison__Group_1_0_0__1__Impl8153); 
             after(grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4008:1: rule__Comparison__Group_1_0_1__0 : rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1 ;
    public final void rule__Comparison__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4012:1: ( rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4013:2: rule__Comparison__Group_1_0_1__0__Impl rule__Comparison__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__0__Impl_in_rule__Comparison__Group_1_0_1__08188);
            rule__Comparison__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__1_in_rule__Comparison__Group_1_0_1__08191);
            rule__Comparison__Group_1_0_1__1();

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
    // $ANTLR end "rule__Comparison__Group_1_0_1__0"


    // $ANTLR start "rule__Comparison__Group_1_0_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4020:1: rule__Comparison__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4024:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4025:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4025:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4026:1: ()
            {
             before(grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4027:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4029:1: 
            {
            }

             after(grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4039:1: rule__Comparison__Group_1_0_1__1 : rule__Comparison__Group_1_0_1__1__Impl ;
    public final void rule__Comparison__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4043:1: ( rule__Comparison__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4044:2: rule__Comparison__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_1__1__Impl_in_rule__Comparison__Group_1_0_1__18249);
            rule__Comparison__Group_1_0_1__1__Impl();

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
    // $ANTLR end "rule__Comparison__Group_1_0_1__1"


    // $ANTLR start "rule__Comparison__Group_1_0_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4050:1: rule__Comparison__Group_1_0_1__1__Impl : ( '<=' ) ;
    public final void rule__Comparison__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4054:1: ( ( '<=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4055:1: ( '<=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4055:1: ( '<=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4056:1: '<='
            {
             before(grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1()); 
            match(input,41,FOLLOW_41_in_rule__Comparison__Group_1_0_1__1__Impl8277); 
             after(grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_2__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4073:1: rule__Comparison__Group_1_0_2__0 : rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1 ;
    public final void rule__Comparison__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4077:1: ( rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4078:2: rule__Comparison__Group_1_0_2__0__Impl rule__Comparison__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__0__Impl_in_rule__Comparison__Group_1_0_2__08312);
            rule__Comparison__Group_1_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__1_in_rule__Comparison__Group_1_0_2__08315);
            rule__Comparison__Group_1_0_2__1();

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
    // $ANTLR end "rule__Comparison__Group_1_0_2__0"


    // $ANTLR start "rule__Comparison__Group_1_0_2__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4085:1: rule__Comparison__Group_1_0_2__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4089:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4090:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4090:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4091:1: ()
            {
             before(grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4092:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4094:1: 
            {
            }

             after(grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_2__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_2__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4104:1: rule__Comparison__Group_1_0_2__1 : rule__Comparison__Group_1_0_2__1__Impl ;
    public final void rule__Comparison__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4108:1: ( rule__Comparison__Group_1_0_2__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4109:2: rule__Comparison__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_2__1__Impl_in_rule__Comparison__Group_1_0_2__18373);
            rule__Comparison__Group_1_0_2__1__Impl();

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
    // $ANTLR end "rule__Comparison__Group_1_0_2__1"


    // $ANTLR start "rule__Comparison__Group_1_0_2__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4115:1: rule__Comparison__Group_1_0_2__1__Impl : ( '>' ) ;
    public final void rule__Comparison__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4119:1: ( ( '>' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4120:1: ( '>' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4120:1: ( '>' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4121:1: '>'
            {
             before(grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1()); 
            match(input,42,FOLLOW_42_in_rule__Comparison__Group_1_0_2__1__Impl8401); 
             after(grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_2__1__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_3__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4138:1: rule__Comparison__Group_1_0_3__0 : rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1 ;
    public final void rule__Comparison__Group_1_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4142:1: ( rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4143:2: rule__Comparison__Group_1_0_3__0__Impl rule__Comparison__Group_1_0_3__1
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__0__Impl_in_rule__Comparison__Group_1_0_3__08436);
            rule__Comparison__Group_1_0_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__1_in_rule__Comparison__Group_1_0_3__08439);
            rule__Comparison__Group_1_0_3__1();

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
    // $ANTLR end "rule__Comparison__Group_1_0_3__0"


    // $ANTLR start "rule__Comparison__Group_1_0_3__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4150:1: rule__Comparison__Group_1_0_3__0__Impl : ( () ) ;
    public final void rule__Comparison__Group_1_0_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4154:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4155:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4155:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4156:1: ()
            {
             before(grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4157:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4159:1: 
            {
            }

             after(grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_3__0__Impl"


    // $ANTLR start "rule__Comparison__Group_1_0_3__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4169:1: rule__Comparison__Group_1_0_3__1 : rule__Comparison__Group_1_0_3__1__Impl ;
    public final void rule__Comparison__Group_1_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4173:1: ( rule__Comparison__Group_1_0_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4174:2: rule__Comparison__Group_1_0_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Comparison__Group_1_0_3__1__Impl_in_rule__Comparison__Group_1_0_3__18497);
            rule__Comparison__Group_1_0_3__1__Impl();

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
    // $ANTLR end "rule__Comparison__Group_1_0_3__1"


    // $ANTLR start "rule__Comparison__Group_1_0_3__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4180:1: rule__Comparison__Group_1_0_3__1__Impl : ( '>=' ) ;
    public final void rule__Comparison__Group_1_0_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4184:1: ( ( '>=' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4185:1: ( '>=' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4185:1: ( '>=' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4186:1: '>='
            {
             before(grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_3_1()); 
            match(input,43,FOLLOW_43_in_rule__Comparison__Group_1_0_3__1__Impl8525); 
             after(grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group_1_0_3__1__Impl"


    // $ANTLR start "rule__Addition__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4203:1: rule__Addition__Group__0 : rule__Addition__Group__0__Impl rule__Addition__Group__1 ;
    public final void rule__Addition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4207:1: ( rule__Addition__Group__0__Impl rule__Addition__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4208:2: rule__Addition__Group__0__Impl rule__Addition__Group__1
            {
            pushFollow(FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__08560);
            rule__Addition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__08563);
            rule__Addition__Group__1();

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
    // $ANTLR end "rule__Addition__Group__0"


    // $ANTLR start "rule__Addition__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4215:1: rule__Addition__Group__0__Impl : ( ruleMultiplication ) ;
    public final void rule__Addition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4219:1: ( ( ruleMultiplication ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4220:1: ( ruleMultiplication )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4220:1: ( ruleMultiplication )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4221:1: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl8590);
            ruleMultiplication();

            state._fsp--;

             after(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__0__Impl"


    // $ANTLR start "rule__Addition__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4232:1: rule__Addition__Group__1 : rule__Addition__Group__1__Impl ;
    public final void rule__Addition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4236:1: ( rule__Addition__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4237:2: rule__Addition__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__18619);
            rule__Addition__Group__1__Impl();

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
    // $ANTLR end "rule__Addition__Group__1"


    // $ANTLR start "rule__Addition__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4243:1: rule__Addition__Group__1__Impl : ( ( rule__Addition__Group_1__0 )* ) ;
    public final void rule__Addition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4247:1: ( ( ( rule__Addition__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4248:1: ( ( rule__Addition__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4248:1: ( ( rule__Addition__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4249:1: ( rule__Addition__Group_1__0 )*
            {
             before(grammarAccess.getAdditionAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4250:1: ( rule__Addition__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=12 && LA31_0<=13)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4250:2: rule__Addition__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl8646);
            	    rule__Addition__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getAdditionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group__1__Impl"


    // $ANTLR start "rule__Addition__Group_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4264:1: rule__Addition__Group_1__0 : rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 ;
    public final void rule__Addition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4268:1: ( rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4269:2: rule__Addition__Group_1__0__Impl rule__Addition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__08681);
            rule__Addition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__08684);
            rule__Addition__Group_1__1();

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
    // $ANTLR end "rule__Addition__Group_1__0"


    // $ANTLR start "rule__Addition__Group_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4276:1: rule__Addition__Group_1__0__Impl : ( ( rule__Addition__Alternatives_1_0 ) ) ;
    public final void rule__Addition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4280:1: ( ( ( rule__Addition__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4281:1: ( ( rule__Addition__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4281:1: ( ( rule__Addition__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4282:1: ( rule__Addition__Alternatives_1_0 )
            {
             before(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4283:1: ( rule__Addition__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4283:2: rule__Addition__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl8711);
            rule__Addition__Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAdditionAccess().getAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__0__Impl"


    // $ANTLR start "rule__Addition__Group_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4293:1: rule__Addition__Group_1__1 : rule__Addition__Group_1__1__Impl ;
    public final void rule__Addition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4297:1: ( rule__Addition__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4298:2: rule__Addition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__18741);
            rule__Addition__Group_1__1__Impl();

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
    // $ANTLR end "rule__Addition__Group_1__1"


    // $ANTLR start "rule__Addition__Group_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4304:1: rule__Addition__Group_1__1__Impl : ( ( rule__Addition__RightAssignment_1_1 ) ) ;
    public final void rule__Addition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4308:1: ( ( ( rule__Addition__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4309:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4309:1: ( ( rule__Addition__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4310:1: ( rule__Addition__RightAssignment_1_1 )
            {
             before(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4311:1: ( rule__Addition__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4311:2: rule__Addition__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl8768);
            rule__Addition__RightAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAdditionAccess().getRightAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1__1__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_0__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4325:1: rule__Addition__Group_1_0_0__0 : rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 ;
    public final void rule__Addition__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4329:1: ( rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4330:2: rule__Addition__Group_1_0_0__0__Impl rule__Addition__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__08802);
            rule__Addition__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__08805);
            rule__Addition__Group_1_0_0__1();

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
    // $ANTLR end "rule__Addition__Group_1_0_0__0"


    // $ANTLR start "rule__Addition__Group_1_0_0__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4337:1: rule__Addition__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4341:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4342:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4342:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4343:1: ()
            {
             before(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4344:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4346:1: 
            {
            }

             after(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_0__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4356:1: rule__Addition__Group_1_0_0__1 : rule__Addition__Group_1_0_0__1__Impl ;
    public final void rule__Addition__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4360:1: ( rule__Addition__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4361:2: rule__Addition__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__18863);
            rule__Addition__Group_1_0_0__1__Impl();

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
    // $ANTLR end "rule__Addition__Group_1_0_0__1"


    // $ANTLR start "rule__Addition__Group_1_0_0__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4367:1: rule__Addition__Group_1_0_0__1__Impl : ( '+' ) ;
    public final void rule__Addition__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4371:1: ( ( '+' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4372:1: ( '+' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4372:1: ( '+' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4373:1: '+'
            {
             before(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 
            match(input,13,FOLLOW_13_in_rule__Addition__Group_1_0_0__1__Impl8891); 
             after(grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4390:1: rule__Addition__Group_1_0_1__0 : rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 ;
    public final void rule__Addition__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4394:1: ( rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4395:2: rule__Addition__Group_1_0_1__0__Impl rule__Addition__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__08926);
            rule__Addition__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__08929);
            rule__Addition__Group_1_0_1__1();

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
    // $ANTLR end "rule__Addition__Group_1_0_1__0"


    // $ANTLR start "rule__Addition__Group_1_0_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4402:1: rule__Addition__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Addition__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4406:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4407:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4407:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4408:1: ()
            {
             before(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4409:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4411:1: 
            {
            }

             after(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Addition__Group_1_0_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4421:1: rule__Addition__Group_1_0_1__1 : rule__Addition__Group_1_0_1__1__Impl ;
    public final void rule__Addition__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4425:1: ( rule__Addition__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4426:2: rule__Addition__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__18987);
            rule__Addition__Group_1_0_1__1__Impl();

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
    // $ANTLR end "rule__Addition__Group_1_0_1__1"


    // $ANTLR start "rule__Addition__Group_1_0_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4432:1: rule__Addition__Group_1_0_1__1__Impl : ( '-' ) ;
    public final void rule__Addition__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4436:1: ( ( '-' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4437:1: ( '-' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4437:1: ( '-' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4438:1: '-'
            {
             before(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 
            match(input,12,FOLLOW_12_in_rule__Addition__Group_1_0_1__1__Impl9015); 
             after(grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Multiplication__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4455:1: rule__Multiplication__Group__0 : rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 ;
    public final void rule__Multiplication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4459:1: ( rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4460:2: rule__Multiplication__Group__0__Impl rule__Multiplication__Group__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__09050);
            rule__Multiplication__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__09053);
            rule__Multiplication__Group__1();

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
    // $ANTLR end "rule__Multiplication__Group__0"


    // $ANTLR start "rule__Multiplication__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4467:1: rule__Multiplication__Group__0__Impl : ( ruleUnary ) ;
    public final void rule__Multiplication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4471:1: ( ( ruleUnary ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4472:1: ( ruleUnary )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4472:1: ( ruleUnary )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4473:1: ruleUnary
            {
             before(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleUnary_in_rule__Multiplication__Group__0__Impl9080);
            ruleUnary();

            state._fsp--;

             after(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__0__Impl"


    // $ANTLR start "rule__Multiplication__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4484:1: rule__Multiplication__Group__1 : rule__Multiplication__Group__1__Impl ;
    public final void rule__Multiplication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4488:1: ( rule__Multiplication__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4489:2: rule__Multiplication__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__19109);
            rule__Multiplication__Group__1__Impl();

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
    // $ANTLR end "rule__Multiplication__Group__1"


    // $ANTLR start "rule__Multiplication__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4495:1: rule__Multiplication__Group__1__Impl : ( ( rule__Multiplication__Group_1__0 )* ) ;
    public final void rule__Multiplication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4499:1: ( ( ( rule__Multiplication__Group_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4500:1: ( ( rule__Multiplication__Group_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4500:1: ( ( rule__Multiplication__Group_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4501:1: ( rule__Multiplication__Group_1__0 )*
            {
             before(grammarAccess.getMultiplicationAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4502:1: ( rule__Multiplication__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=44 && LA32_0<=46)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4502:2: rule__Multiplication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl9136);
            	    rule__Multiplication__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getMultiplicationAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group__1__Impl"


    // $ANTLR start "rule__Multiplication__Group_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4516:1: rule__Multiplication__Group_1__0 : rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 ;
    public final void rule__Multiplication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4520:1: ( rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4521:2: rule__Multiplication__Group_1__0__Impl rule__Multiplication__Group_1__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__09171);
            rule__Multiplication__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__09174);
            rule__Multiplication__Group_1__1();

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
    // $ANTLR end "rule__Multiplication__Group_1__0"


    // $ANTLR start "rule__Multiplication__Group_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4528:1: rule__Multiplication__Group_1__0__Impl : ( ( rule__Multiplication__Alternatives_1_0 ) ) ;
    public final void rule__Multiplication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4532:1: ( ( ( rule__Multiplication__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4533:1: ( ( rule__Multiplication__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4533:1: ( ( rule__Multiplication__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4534:1: ( rule__Multiplication__Alternatives_1_0 )
            {
             before(grammarAccess.getMultiplicationAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4535:1: ( rule__Multiplication__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4535:2: rule__Multiplication__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Multiplication__Alternatives_1_0_in_rule__Multiplication__Group_1__0__Impl9201);
            rule__Multiplication__Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__0__Impl"


    // $ANTLR start "rule__Multiplication__Group_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4545:1: rule__Multiplication__Group_1__1 : rule__Multiplication__Group_1__1__Impl ;
    public final void rule__Multiplication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4549:1: ( rule__Multiplication__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4550:2: rule__Multiplication__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__19231);
            rule__Multiplication__Group_1__1__Impl();

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
    // $ANTLR end "rule__Multiplication__Group_1__1"


    // $ANTLR start "rule__Multiplication__Group_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4556:1: rule__Multiplication__Group_1__1__Impl : ( ( rule__Multiplication__RightAssignment_1_1 ) ) ;
    public final void rule__Multiplication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4560:1: ( ( ( rule__Multiplication__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4561:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4561:1: ( ( rule__Multiplication__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4562:1: ( rule__Multiplication__RightAssignment_1_1 )
            {
             before(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4563:1: ( rule__Multiplication__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4563:2: rule__Multiplication__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl9258);
            rule__Multiplication__RightAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1__1__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0_0__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4577:1: rule__Multiplication__Group_1_0_0__0 : rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1 ;
    public final void rule__Multiplication__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4581:1: ( rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4582:2: rule__Multiplication__Group_1_0_0__0__Impl rule__Multiplication__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__0__Impl_in_rule__Multiplication__Group_1_0_0__09292);
            rule__Multiplication__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__1_in_rule__Multiplication__Group_1_0_0__09295);
            rule__Multiplication__Group_1_0_0__1();

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
    // $ANTLR end "rule__Multiplication__Group_1_0_0__0"


    // $ANTLR start "rule__Multiplication__Group_1_0_0__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4589:1: rule__Multiplication__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4593:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4594:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4594:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4595:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4596:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4598:1: 
            {
            }

             after(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0_0__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4608:1: rule__Multiplication__Group_1_0_0__1 : rule__Multiplication__Group_1_0_0__1__Impl ;
    public final void rule__Multiplication__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4612:1: ( rule__Multiplication__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4613:2: rule__Multiplication__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_0__1__Impl_in_rule__Multiplication__Group_1_0_0__19353);
            rule__Multiplication__Group_1_0_0__1__Impl();

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
    // $ANTLR end "rule__Multiplication__Group_1_0_0__1"


    // $ANTLR start "rule__Multiplication__Group_1_0_0__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4619:1: rule__Multiplication__Group_1_0_0__1__Impl : ( '*' ) ;
    public final void rule__Multiplication__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4623:1: ( ( '*' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4624:1: ( '*' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4624:1: ( '*' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4625:1: '*'
            {
             before(grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1()); 
            match(input,44,FOLLOW_44_in_rule__Multiplication__Group_1_0_0__1__Impl9381); 
             after(grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4642:1: rule__Multiplication__Group_1_0_1__0 : rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1 ;
    public final void rule__Multiplication__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4646:1: ( rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4647:2: rule__Multiplication__Group_1_0_1__0__Impl rule__Multiplication__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__0__Impl_in_rule__Multiplication__Group_1_0_1__09416);
            rule__Multiplication__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__1_in_rule__Multiplication__Group_1_0_1__09419);
            rule__Multiplication__Group_1_0_1__1();

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
    // $ANTLR end "rule__Multiplication__Group_1_0_1__0"


    // $ANTLR start "rule__Multiplication__Group_1_0_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4654:1: rule__Multiplication__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4658:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4659:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4659:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4660:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4661:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4663:1: 
            {
            }

             after(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4673:1: rule__Multiplication__Group_1_0_1__1 : rule__Multiplication__Group_1_0_1__1__Impl ;
    public final void rule__Multiplication__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4677:1: ( rule__Multiplication__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4678:2: rule__Multiplication__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_1__1__Impl_in_rule__Multiplication__Group_1_0_1__19477);
            rule__Multiplication__Group_1_0_1__1__Impl();

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
    // $ANTLR end "rule__Multiplication__Group_1_0_1__1"


    // $ANTLR start "rule__Multiplication__Group_1_0_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4684:1: rule__Multiplication__Group_1_0_1__1__Impl : ( '/' ) ;
    public final void rule__Multiplication__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4688:1: ( ( '/' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4689:1: ( '/' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4689:1: ( '/' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4690:1: '/'
            {
             before(grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1()); 
            match(input,45,FOLLOW_45_in_rule__Multiplication__Group_1_0_1__1__Impl9505); 
             after(grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0_2__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4707:1: rule__Multiplication__Group_1_0_2__0 : rule__Multiplication__Group_1_0_2__0__Impl rule__Multiplication__Group_1_0_2__1 ;
    public final void rule__Multiplication__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4711:1: ( rule__Multiplication__Group_1_0_2__0__Impl rule__Multiplication__Group_1_0_2__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4712:2: rule__Multiplication__Group_1_0_2__0__Impl rule__Multiplication__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__0__Impl_in_rule__Multiplication__Group_1_0_2__09540);
            rule__Multiplication__Group_1_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__1_in_rule__Multiplication__Group_1_0_2__09543);
            rule__Multiplication__Group_1_0_2__1();

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
    // $ANTLR end "rule__Multiplication__Group_1_0_2__0"


    // $ANTLR start "rule__Multiplication__Group_1_0_2__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4719:1: rule__Multiplication__Group_1_0_2__0__Impl : ( () ) ;
    public final void rule__Multiplication__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4723:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4724:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4724:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4725:1: ()
            {
             before(grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4726:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4728:1: 
            {
            }

             after(grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_2__0__Impl"


    // $ANTLR start "rule__Multiplication__Group_1_0_2__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4738:1: rule__Multiplication__Group_1_0_2__1 : rule__Multiplication__Group_1_0_2__1__Impl ;
    public final void rule__Multiplication__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4742:1: ( rule__Multiplication__Group_1_0_2__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4743:2: rule__Multiplication__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Multiplication__Group_1_0_2__1__Impl_in_rule__Multiplication__Group_1_0_2__19601);
            rule__Multiplication__Group_1_0_2__1__Impl();

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
    // $ANTLR end "rule__Multiplication__Group_1_0_2__1"


    // $ANTLR start "rule__Multiplication__Group_1_0_2__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4749:1: rule__Multiplication__Group_1_0_2__1__Impl : ( '%' ) ;
    public final void rule__Multiplication__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4753:1: ( ( '%' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4754:1: ( '%' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4754:1: ( '%' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4755:1: '%'
            {
             before(grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1()); 
            match(input,46,FOLLOW_46_in_rule__Multiplication__Group_1_0_2__1__Impl9629); 
             after(grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__Group_1_0_2__1__Impl"


    // $ANTLR start "rule__Unary__Group_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4772:1: rule__Unary__Group_1__0 : rule__Unary__Group_1__0__Impl rule__Unary__Group_1__1 ;
    public final void rule__Unary__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4776:1: ( rule__Unary__Group_1__0__Impl rule__Unary__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4777:2: rule__Unary__Group_1__0__Impl rule__Unary__Group_1__1
            {
            pushFollow(FOLLOW_rule__Unary__Group_1__0__Impl_in_rule__Unary__Group_1__09664);
            rule__Unary__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Unary__Group_1__1_in_rule__Unary__Group_1__09667);
            rule__Unary__Group_1__1();

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
    // $ANTLR end "rule__Unary__Group_1__0"


    // $ANTLR start "rule__Unary__Group_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4784:1: rule__Unary__Group_1__0__Impl : ( ( rule__Unary__Alternatives_1_0 ) ) ;
    public final void rule__Unary__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4788:1: ( ( ( rule__Unary__Alternatives_1_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4789:1: ( ( rule__Unary__Alternatives_1_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4789:1: ( ( rule__Unary__Alternatives_1_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4790:1: ( rule__Unary__Alternatives_1_0 )
            {
             before(grammarAccess.getUnaryAccess().getAlternatives_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4791:1: ( rule__Unary__Alternatives_1_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4791:2: rule__Unary__Alternatives_1_0
            {
            pushFollow(FOLLOW_rule__Unary__Alternatives_1_0_in_rule__Unary__Group_1__0__Impl9694);
            rule__Unary__Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getUnaryAccess().getAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unary__Group_1__0__Impl"


    // $ANTLR start "rule__Unary__Group_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4801:1: rule__Unary__Group_1__1 : rule__Unary__Group_1__1__Impl ;
    public final void rule__Unary__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4805:1: ( rule__Unary__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4806:2: rule__Unary__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Unary__Group_1__1__Impl_in_rule__Unary__Group_1__19724);
            rule__Unary__Group_1__1__Impl();

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
    // $ANTLR end "rule__Unary__Group_1__1"


    // $ANTLR start "rule__Unary__Group_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4812:1: rule__Unary__Group_1__1__Impl : ( ( rule__Unary__RightAssignment_1_1 ) ) ;
    public final void rule__Unary__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4816:1: ( ( ( rule__Unary__RightAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4817:1: ( ( rule__Unary__RightAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4817:1: ( ( rule__Unary__RightAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4818:1: ( rule__Unary__RightAssignment_1_1 )
            {
             before(grammarAccess.getUnaryAccess().getRightAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4819:1: ( rule__Unary__RightAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4819:2: rule__Unary__RightAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Unary__RightAssignment_1_1_in_rule__Unary__Group_1__1__Impl9751);
            rule__Unary__RightAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getUnaryAccess().getRightAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unary__Group_1__1__Impl"


    // $ANTLR start "rule__Unary__Group_1_0_0__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4833:1: rule__Unary__Group_1_0_0__0 : rule__Unary__Group_1_0_0__0__Impl rule__Unary__Group_1_0_0__1 ;
    public final void rule__Unary__Group_1_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4837:1: ( rule__Unary__Group_1_0_0__0__Impl rule__Unary__Group_1_0_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4838:2: rule__Unary__Group_1_0_0__0__Impl rule__Unary__Group_1_0_0__1
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_0__0__Impl_in_rule__Unary__Group_1_0_0__09785);
            rule__Unary__Group_1_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Unary__Group_1_0_0__1_in_rule__Unary__Group_1_0_0__09788);
            rule__Unary__Group_1_0_0__1();

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
    // $ANTLR end "rule__Unary__Group_1_0_0__0"


    // $ANTLR start "rule__Unary__Group_1_0_0__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4845:1: rule__Unary__Group_1_0_0__0__Impl : ( () ) ;
    public final void rule__Unary__Group_1_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4849:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4850:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4850:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4851:1: ()
            {
             before(grammarAccess.getUnaryAccess().getNegationAction_1_0_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4852:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4854:1: 
            {
            }

             after(grammarAccess.getUnaryAccess().getNegationAction_1_0_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unary__Group_1_0_0__0__Impl"


    // $ANTLR start "rule__Unary__Group_1_0_0__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4864:1: rule__Unary__Group_1_0_0__1 : rule__Unary__Group_1_0_0__1__Impl ;
    public final void rule__Unary__Group_1_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4868:1: ( rule__Unary__Group_1_0_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4869:2: rule__Unary__Group_1_0_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_0__1__Impl_in_rule__Unary__Group_1_0_0__19846);
            rule__Unary__Group_1_0_0__1__Impl();

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
    // $ANTLR end "rule__Unary__Group_1_0_0__1"


    // $ANTLR start "rule__Unary__Group_1_0_0__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4875:1: rule__Unary__Group_1_0_0__1__Impl : ( ( rule__Unary__OpAssignment_1_0_0_1 ) ) ;
    public final void rule__Unary__Group_1_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4879:1: ( ( ( rule__Unary__OpAssignment_1_0_0_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4880:1: ( ( rule__Unary__OpAssignment_1_0_0_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4880:1: ( ( rule__Unary__OpAssignment_1_0_0_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4881:1: ( rule__Unary__OpAssignment_1_0_0_1 )
            {
             before(grammarAccess.getUnaryAccess().getOpAssignment_1_0_0_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4882:1: ( rule__Unary__OpAssignment_1_0_0_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4882:2: rule__Unary__OpAssignment_1_0_0_1
            {
            pushFollow(FOLLOW_rule__Unary__OpAssignment_1_0_0_1_in_rule__Unary__Group_1_0_0__1__Impl9873);
            rule__Unary__OpAssignment_1_0_0_1();

            state._fsp--;


            }

             after(grammarAccess.getUnaryAccess().getOpAssignment_1_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unary__Group_1_0_0__1__Impl"


    // $ANTLR start "rule__Unary__Group_1_0_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4896:1: rule__Unary__Group_1_0_1__0 : rule__Unary__Group_1_0_1__0__Impl rule__Unary__Group_1_0_1__1 ;
    public final void rule__Unary__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4900:1: ( rule__Unary__Group_1_0_1__0__Impl rule__Unary__Group_1_0_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4901:2: rule__Unary__Group_1_0_1__0__Impl rule__Unary__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_1__0__Impl_in_rule__Unary__Group_1_0_1__09907);
            rule__Unary__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Unary__Group_1_0_1__1_in_rule__Unary__Group_1_0_1__09910);
            rule__Unary__Group_1_0_1__1();

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
    // $ANTLR end "rule__Unary__Group_1_0_1__0"


    // $ANTLR start "rule__Unary__Group_1_0_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4908:1: rule__Unary__Group_1_0_1__0__Impl : ( () ) ;
    public final void rule__Unary__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4912:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4913:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4913:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4914:1: ()
            {
             before(grammarAccess.getUnaryAccess().getUnaryPlusMinusAction_1_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4915:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4917:1: 
            {
            }

             after(grammarAccess.getUnaryAccess().getUnaryPlusMinusAction_1_0_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unary__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Unary__Group_1_0_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4927:1: rule__Unary__Group_1_0_1__1 : rule__Unary__Group_1_0_1__1__Impl ;
    public final void rule__Unary__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4931:1: ( rule__Unary__Group_1_0_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4932:2: rule__Unary__Group_1_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Unary__Group_1_0_1__1__Impl_in_rule__Unary__Group_1_0_1__19968);
            rule__Unary__Group_1_0_1__1__Impl();

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
    // $ANTLR end "rule__Unary__Group_1_0_1__1"


    // $ANTLR start "rule__Unary__Group_1_0_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4938:1: rule__Unary__Group_1_0_1__1__Impl : ( ( rule__Unary__OpAssignment_1_0_1_1 ) ) ;
    public final void rule__Unary__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4942:1: ( ( ( rule__Unary__OpAssignment_1_0_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4943:1: ( ( rule__Unary__OpAssignment_1_0_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4943:1: ( ( rule__Unary__OpAssignment_1_0_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4944:1: ( rule__Unary__OpAssignment_1_0_1_1 )
            {
             before(grammarAccess.getUnaryAccess().getOpAssignment_1_0_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4945:1: ( rule__Unary__OpAssignment_1_0_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4945:2: rule__Unary__OpAssignment_1_0_1_1
            {
            pushFollow(FOLLOW_rule__Unary__OpAssignment_1_0_1_1_in_rule__Unary__Group_1_0_1__1__Impl9995);
            rule__Unary__OpAssignment_1_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getUnaryAccess().getOpAssignment_1_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unary__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Literal__Group_0__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4959:1: rule__Literal__Group_0__0 : rule__Literal__Group_0__0__Impl rule__Literal__Group_0__1 ;
    public final void rule__Literal__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4963:1: ( rule__Literal__Group_0__0__Impl rule__Literal__Group_0__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4964:2: rule__Literal__Group_0__0__Impl rule__Literal__Group_0__1
            {
            pushFollow(FOLLOW_rule__Literal__Group_0__0__Impl_in_rule__Literal__Group_0__010029);
            rule__Literal__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Literal__Group_0__1_in_rule__Literal__Group_0__010032);
            rule__Literal__Group_0__1();

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
    // $ANTLR end "rule__Literal__Group_0__0"


    // $ANTLR start "rule__Literal__Group_0__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4971:1: rule__Literal__Group_0__0__Impl : ( () ) ;
    public final void rule__Literal__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4975:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4976:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4976:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4977:1: ()
            {
             before(grammarAccess.getLiteralAccess().getNumberLiteralAction_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4978:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4980:1: 
            {
            }

             after(grammarAccess.getLiteralAccess().getNumberLiteralAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_0__0__Impl"


    // $ANTLR start "rule__Literal__Group_0__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4990:1: rule__Literal__Group_0__1 : rule__Literal__Group_0__1__Impl ;
    public final void rule__Literal__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4994:1: ( rule__Literal__Group_0__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:4995:2: rule__Literal__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Literal__Group_0__1__Impl_in_rule__Literal__Group_0__110090);
            rule__Literal__Group_0__1__Impl();

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
    // $ANTLR end "rule__Literal__Group_0__1"


    // $ANTLR start "rule__Literal__Group_0__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5001:1: rule__Literal__Group_0__1__Impl : ( ( rule__Literal__ValueAssignment_0_1 ) ) ;
    public final void rule__Literal__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5005:1: ( ( ( rule__Literal__ValueAssignment_0_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5006:1: ( ( rule__Literal__ValueAssignment_0_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5006:1: ( ( rule__Literal__ValueAssignment_0_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5007:1: ( rule__Literal__ValueAssignment_0_1 )
            {
             before(grammarAccess.getLiteralAccess().getValueAssignment_0_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5008:1: ( rule__Literal__ValueAssignment_0_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5008:2: rule__Literal__ValueAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Literal__ValueAssignment_0_1_in_rule__Literal__Group_0__1__Impl10117);
            rule__Literal__ValueAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getValueAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_0__1__Impl"


    // $ANTLR start "rule__Literal__Group_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5022:1: rule__Literal__Group_1__0 : rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1 ;
    public final void rule__Literal__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5026:1: ( rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5027:2: rule__Literal__Group_1__0__Impl rule__Literal__Group_1__1
            {
            pushFollow(FOLLOW_rule__Literal__Group_1__0__Impl_in_rule__Literal__Group_1__010151);
            rule__Literal__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Literal__Group_1__1_in_rule__Literal__Group_1__010154);
            rule__Literal__Group_1__1();

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
    // $ANTLR end "rule__Literal__Group_1__0"


    // $ANTLR start "rule__Literal__Group_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5034:1: rule__Literal__Group_1__0__Impl : ( () ) ;
    public final void rule__Literal__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5038:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5039:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5039:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5040:1: ()
            {
             before(grammarAccess.getLiteralAccess().getBooleanLiteralAction_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5041:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5043:1: 
            {
            }

             after(grammarAccess.getLiteralAccess().getBooleanLiteralAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_1__0__Impl"


    // $ANTLR start "rule__Literal__Group_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5053:1: rule__Literal__Group_1__1 : rule__Literal__Group_1__1__Impl ;
    public final void rule__Literal__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5057:1: ( rule__Literal__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5058:2: rule__Literal__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Literal__Group_1__1__Impl_in_rule__Literal__Group_1__110212);
            rule__Literal__Group_1__1__Impl();

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
    // $ANTLR end "rule__Literal__Group_1__1"


    // $ANTLR start "rule__Literal__Group_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5064:1: rule__Literal__Group_1__1__Impl : ( ( rule__Literal__Alternatives_1_1 ) ) ;
    public final void rule__Literal__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5068:1: ( ( ( rule__Literal__Alternatives_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5069:1: ( ( rule__Literal__Alternatives_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5069:1: ( ( rule__Literal__Alternatives_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5070:1: ( rule__Literal__Alternatives_1_1 )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5071:1: ( rule__Literal__Alternatives_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5071:2: rule__Literal__Alternatives_1_1
            {
            pushFollow(FOLLOW_rule__Literal__Alternatives_1_1_in_rule__Literal__Group_1__1__Impl10239);
            rule__Literal__Alternatives_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getAlternatives_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__Group_1__1__Impl"


    // $ANTLR start "rule__ParenthesizedExpression__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5085:1: rule__ParenthesizedExpression__Group__0 : rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1 ;
    public final void rule__ParenthesizedExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5089:1: ( rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5090:2: rule__ParenthesizedExpression__Group__0__Impl rule__ParenthesizedExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__0__Impl_in_rule__ParenthesizedExpression__Group__010273);
            rule__ParenthesizedExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__1_in_rule__ParenthesizedExpression__Group__010276);
            rule__ParenthesizedExpression__Group__1();

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
    // $ANTLR end "rule__ParenthesizedExpression__Group__0"


    // $ANTLR start "rule__ParenthesizedExpression__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5097:1: rule__ParenthesizedExpression__Group__0__Impl : ( '(' ) ;
    public final void rule__ParenthesizedExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5101:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5102:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5102:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5103:1: '('
            {
             before(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__ParenthesizedExpression__Group__0__Impl10304); 
             after(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__Group__0__Impl"


    // $ANTLR start "rule__ParenthesizedExpression__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5116:1: rule__ParenthesizedExpression__Group__1 : rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2 ;
    public final void rule__ParenthesizedExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5120:1: ( rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5121:2: rule__ParenthesizedExpression__Group__1__Impl rule__ParenthesizedExpression__Group__2
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__1__Impl_in_rule__ParenthesizedExpression__Group__110335);
            rule__ParenthesizedExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__2_in_rule__ParenthesizedExpression__Group__110338);
            rule__ParenthesizedExpression__Group__2();

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
    // $ANTLR end "rule__ParenthesizedExpression__Group__1"


    // $ANTLR start "rule__ParenthesizedExpression__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5128:1: rule__ParenthesizedExpression__Group__1__Impl : ( ruleExpression ) ;
    public final void rule__ParenthesizedExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5132:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5133:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5133:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5134:1: ruleExpression
            {
             before(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ParenthesizedExpression__Group__1__Impl10365);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__Group__1__Impl"


    // $ANTLR start "rule__ParenthesizedExpression__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5145:1: rule__ParenthesizedExpression__Group__2 : rule__ParenthesizedExpression__Group__2__Impl ;
    public final void rule__ParenthesizedExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5149:1: ( rule__ParenthesizedExpression__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5150:2: rule__ParenthesizedExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ParenthesizedExpression__Group__2__Impl_in_rule__ParenthesizedExpression__Group__210394);
            rule__ParenthesizedExpression__Group__2__Impl();

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
    // $ANTLR end "rule__ParenthesizedExpression__Group__2"


    // $ANTLR start "rule__ParenthesizedExpression__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5156:1: rule__ParenthesizedExpression__Group__2__Impl : ( ')' ) ;
    public final void rule__ParenthesizedExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5160:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5161:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5161:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5162:1: ')'
            {
             before(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); 
            match(input,25,FOLLOW_25_in_rule__ParenthesizedExpression__Group__2__Impl10422); 
             after(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParenthesizedExpression__Group__2__Impl"


    // $ANTLR start "rule__FunctionCall__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5181:1: rule__FunctionCall__Group__0 : rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1 ;
    public final void rule__FunctionCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5185:1: ( rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5186:2: rule__FunctionCall__Group__0__Impl rule__FunctionCall__Group__1
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__0__Impl_in_rule__FunctionCall__Group__010459);
            rule__FunctionCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__1_in_rule__FunctionCall__Group__010462);
            rule__FunctionCall__Group__1();

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
    // $ANTLR end "rule__FunctionCall__Group__0"


    // $ANTLR start "rule__FunctionCall__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5193:1: rule__FunctionCall__Group__0__Impl : ( () ) ;
    public final void rule__FunctionCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5197:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5198:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5198:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5199:1: ()
            {
             before(grammarAccess.getFunctionCallAccess().getFunctionCallAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5200:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5202:1: 
            {
            }

             after(grammarAccess.getFunctionCallAccess().getFunctionCallAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__0__Impl"


    // $ANTLR start "rule__FunctionCall__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5212:1: rule__FunctionCall__Group__1 : rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2 ;
    public final void rule__FunctionCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5216:1: ( rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5217:2: rule__FunctionCall__Group__1__Impl rule__FunctionCall__Group__2
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__1__Impl_in_rule__FunctionCall__Group__110520);
            rule__FunctionCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__2_in_rule__FunctionCall__Group__110523);
            rule__FunctionCall__Group__2();

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
    // $ANTLR end "rule__FunctionCall__Group__1"


    // $ANTLR start "rule__FunctionCall__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5224:1: rule__FunctionCall__Group__1__Impl : ( ( rule__FunctionCall__FuncAssignment_1 ) ) ;
    public final void rule__FunctionCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5228:1: ( ( ( rule__FunctionCall__FuncAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5229:1: ( ( rule__FunctionCall__FuncAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5229:1: ( ( rule__FunctionCall__FuncAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5230:1: ( rule__FunctionCall__FuncAssignment_1 )
            {
             before(grammarAccess.getFunctionCallAccess().getFuncAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5231:1: ( rule__FunctionCall__FuncAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5231:2: rule__FunctionCall__FuncAssignment_1
            {
            pushFollow(FOLLOW_rule__FunctionCall__FuncAssignment_1_in_rule__FunctionCall__Group__1__Impl10550);
            rule__FunctionCall__FuncAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFunctionCallAccess().getFuncAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__1__Impl"


    // $ANTLR start "rule__FunctionCall__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5241:1: rule__FunctionCall__Group__2 : rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3 ;
    public final void rule__FunctionCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5245:1: ( rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5246:2: rule__FunctionCall__Group__2__Impl rule__FunctionCall__Group__3
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__2__Impl_in_rule__FunctionCall__Group__210580);
            rule__FunctionCall__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__3_in_rule__FunctionCall__Group__210583);
            rule__FunctionCall__Group__3();

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
    // $ANTLR end "rule__FunctionCall__Group__2"


    // $ANTLR start "rule__FunctionCall__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5253:1: rule__FunctionCall__Group__2__Impl : ( '(' ) ;
    public final void rule__FunctionCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5257:1: ( ( '(' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5258:1: ( '(' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5258:1: ( '(' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5259:1: '('
            {
             before(grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2()); 
            match(input,24,FOLLOW_24_in_rule__FunctionCall__Group__2__Impl10611); 
             after(grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__2__Impl"


    // $ANTLR start "rule__FunctionCall__Group__3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5272:1: rule__FunctionCall__Group__3 : rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4 ;
    public final void rule__FunctionCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5276:1: ( rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5277:2: rule__FunctionCall__Group__3__Impl rule__FunctionCall__Group__4
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__3__Impl_in_rule__FunctionCall__Group__310642);
            rule__FunctionCall__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group__4_in_rule__FunctionCall__Group__310645);
            rule__FunctionCall__Group__4();

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
    // $ANTLR end "rule__FunctionCall__Group__3"


    // $ANTLR start "rule__FunctionCall__Group__3__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5284:1: rule__FunctionCall__Group__3__Impl : ( ( rule__FunctionCall__Group_3__0 )? ) ;
    public final void rule__FunctionCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5288:1: ( ( ( rule__FunctionCall__Group_3__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5289:1: ( ( rule__FunctionCall__Group_3__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5289:1: ( ( rule__FunctionCall__Group_3__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5290:1: ( rule__FunctionCall__Group_3__0 )?
            {
             before(grammarAccess.getFunctionCallAccess().getGroup_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5291:1: ( rule__FunctionCall__Group_3__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID||LA33_0==RULE_NUMBER||(LA33_0>=12 && LA33_0<=14)||LA33_0==24||LA33_0==48||LA33_0==50||(LA33_0>=54 && LA33_0<=55)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5291:2: rule__FunctionCall__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__FunctionCall__Group_3__0_in_rule__FunctionCall__Group__3__Impl10672);
                    rule__FunctionCall__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFunctionCallAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__3__Impl"


    // $ANTLR start "rule__FunctionCall__Group__4"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5301:1: rule__FunctionCall__Group__4 : rule__FunctionCall__Group__4__Impl ;
    public final void rule__FunctionCall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5305:1: ( rule__FunctionCall__Group__4__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5306:2: rule__FunctionCall__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group__4__Impl_in_rule__FunctionCall__Group__410703);
            rule__FunctionCall__Group__4__Impl();

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
    // $ANTLR end "rule__FunctionCall__Group__4"


    // $ANTLR start "rule__FunctionCall__Group__4__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5312:1: rule__FunctionCall__Group__4__Impl : ( ')' ) ;
    public final void rule__FunctionCall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5316:1: ( ( ')' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5317:1: ( ')' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5317:1: ( ')' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5318:1: ')'
            {
             before(grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4()); 
            match(input,25,FOLLOW_25_in_rule__FunctionCall__Group__4__Impl10731); 
             after(grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group__4__Impl"


    // $ANTLR start "rule__FunctionCall__Group_3__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5341:1: rule__FunctionCall__Group_3__0 : rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1 ;
    public final void rule__FunctionCall__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5345:1: ( rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5346:2: rule__FunctionCall__Group_3__0__Impl rule__FunctionCall__Group_3__1
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3__0__Impl_in_rule__FunctionCall__Group_3__010772);
            rule__FunctionCall__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group_3__1_in_rule__FunctionCall__Group_3__010775);
            rule__FunctionCall__Group_3__1();

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
    // $ANTLR end "rule__FunctionCall__Group_3__0"


    // $ANTLR start "rule__FunctionCall__Group_3__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5353:1: rule__FunctionCall__Group_3__0__Impl : ( ( rule__FunctionCall__ArgsAssignment_3_0 ) ) ;
    public final void rule__FunctionCall__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5357:1: ( ( ( rule__FunctionCall__ArgsAssignment_3_0 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5358:1: ( ( rule__FunctionCall__ArgsAssignment_3_0 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5358:1: ( ( rule__FunctionCall__ArgsAssignment_3_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5359:1: ( rule__FunctionCall__ArgsAssignment_3_0 )
            {
             before(grammarAccess.getFunctionCallAccess().getArgsAssignment_3_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5360:1: ( rule__FunctionCall__ArgsAssignment_3_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5360:2: rule__FunctionCall__ArgsAssignment_3_0
            {
            pushFollow(FOLLOW_rule__FunctionCall__ArgsAssignment_3_0_in_rule__FunctionCall__Group_3__0__Impl10802);
            rule__FunctionCall__ArgsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getFunctionCallAccess().getArgsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3__0__Impl"


    // $ANTLR start "rule__FunctionCall__Group_3__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5370:1: rule__FunctionCall__Group_3__1 : rule__FunctionCall__Group_3__1__Impl ;
    public final void rule__FunctionCall__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5374:1: ( rule__FunctionCall__Group_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5375:2: rule__FunctionCall__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3__1__Impl_in_rule__FunctionCall__Group_3__110832);
            rule__FunctionCall__Group_3__1__Impl();

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
    // $ANTLR end "rule__FunctionCall__Group_3__1"


    // $ANTLR start "rule__FunctionCall__Group_3__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5381:1: rule__FunctionCall__Group_3__1__Impl : ( ( rule__FunctionCall__Group_3_1__0 )* ) ;
    public final void rule__FunctionCall__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5385:1: ( ( ( rule__FunctionCall__Group_3_1__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5386:1: ( ( rule__FunctionCall__Group_3_1__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5386:1: ( ( rule__FunctionCall__Group_3_1__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5387:1: ( rule__FunctionCall__Group_3_1__0 )*
            {
             before(grammarAccess.getFunctionCallAccess().getGroup_3_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5388:1: ( rule__FunctionCall__Group_3_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==26) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5388:2: rule__FunctionCall__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__0_in_rule__FunctionCall__Group_3__1__Impl10859);
            	    rule__FunctionCall__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getFunctionCallAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3__1__Impl"


    // $ANTLR start "rule__FunctionCall__Group_3_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5402:1: rule__FunctionCall__Group_3_1__0 : rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1 ;
    public final void rule__FunctionCall__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5406:1: ( rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5407:2: rule__FunctionCall__Group_3_1__0__Impl rule__FunctionCall__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__0__Impl_in_rule__FunctionCall__Group_3_1__010894);
            rule__FunctionCall__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__1_in_rule__FunctionCall__Group_3_1__010897);
            rule__FunctionCall__Group_3_1__1();

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
    // $ANTLR end "rule__FunctionCall__Group_3_1__0"


    // $ANTLR start "rule__FunctionCall__Group_3_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5414:1: rule__FunctionCall__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__FunctionCall__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5418:1: ( ( ',' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5419:1: ( ',' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5419:1: ( ',' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5420:1: ','
            {
             before(grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0()); 
            match(input,26,FOLLOW_26_in_rule__FunctionCall__Group_3_1__0__Impl10925); 
             after(grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3_1__0__Impl"


    // $ANTLR start "rule__FunctionCall__Group_3_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5433:1: rule__FunctionCall__Group_3_1__1 : rule__FunctionCall__Group_3_1__1__Impl ;
    public final void rule__FunctionCall__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5437:1: ( rule__FunctionCall__Group_3_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5438:2: rule__FunctionCall__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__FunctionCall__Group_3_1__1__Impl_in_rule__FunctionCall__Group_3_1__110956);
            rule__FunctionCall__Group_3_1__1__Impl();

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
    // $ANTLR end "rule__FunctionCall__Group_3_1__1"


    // $ANTLR start "rule__FunctionCall__Group_3_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5444:1: rule__FunctionCall__Group_3_1__1__Impl : ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) ) ;
    public final void rule__FunctionCall__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5448:1: ( ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5449:1: ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5449:1: ( ( rule__FunctionCall__ArgsAssignment_3_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5450:1: ( rule__FunctionCall__ArgsAssignment_3_1_1 )
            {
             before(grammarAccess.getFunctionCallAccess().getArgsAssignment_3_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5451:1: ( rule__FunctionCall__ArgsAssignment_3_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5451:2: rule__FunctionCall__ArgsAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__FunctionCall__ArgsAssignment_3_1_1_in_rule__FunctionCall__Group_3_1__1__Impl10983);
            rule__FunctionCall__ArgsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getFunctionCallAccess().getArgsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__Group_3_1__1__Impl"


    // $ANTLR start "rule__VarOrArgumentCall__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5465:1: rule__VarOrArgumentCall__Group__0 : rule__VarOrArgumentCall__Group__0__Impl rule__VarOrArgumentCall__Group__1 ;
    public final void rule__VarOrArgumentCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5469:1: ( rule__VarOrArgumentCall__Group__0__Impl rule__VarOrArgumentCall__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5470:2: rule__VarOrArgumentCall__Group__0__Impl rule__VarOrArgumentCall__Group__1
            {
            pushFollow(FOLLOW_rule__VarOrArgumentCall__Group__0__Impl_in_rule__VarOrArgumentCall__Group__011017);
            rule__VarOrArgumentCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VarOrArgumentCall__Group__1_in_rule__VarOrArgumentCall__Group__011020);
            rule__VarOrArgumentCall__Group__1();

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
    // $ANTLR end "rule__VarOrArgumentCall__Group__0"


    // $ANTLR start "rule__VarOrArgumentCall__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5477:1: rule__VarOrArgumentCall__Group__0__Impl : ( () ) ;
    public final void rule__VarOrArgumentCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5481:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5482:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5482:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5483:1: ()
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getVarOrArgumentCallAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5484:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5486:1: 
            {
            }

             after(grammarAccess.getVarOrArgumentCallAccess().getVarOrArgumentCallAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarOrArgumentCall__Group__0__Impl"


    // $ANTLR start "rule__VarOrArgumentCall__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5496:1: rule__VarOrArgumentCall__Group__1 : rule__VarOrArgumentCall__Group__1__Impl ;
    public final void rule__VarOrArgumentCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5500:1: ( rule__VarOrArgumentCall__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5501:2: rule__VarOrArgumentCall__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__VarOrArgumentCall__Group__1__Impl_in_rule__VarOrArgumentCall__Group__111078);
            rule__VarOrArgumentCall__Group__1__Impl();

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
    // $ANTLR end "rule__VarOrArgumentCall__Group__1"


    // $ANTLR start "rule__VarOrArgumentCall__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5507:1: rule__VarOrArgumentCall__Group__1__Impl : ( ( rule__VarOrArgumentCall__CallAssignment_1 ) ) ;
    public final void rule__VarOrArgumentCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5511:1: ( ( ( rule__VarOrArgumentCall__CallAssignment_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5512:1: ( ( rule__VarOrArgumentCall__CallAssignment_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5512:1: ( ( rule__VarOrArgumentCall__CallAssignment_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5513:1: ( rule__VarOrArgumentCall__CallAssignment_1 )
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getCallAssignment_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5514:1: ( rule__VarOrArgumentCall__CallAssignment_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5514:2: rule__VarOrArgumentCall__CallAssignment_1
            {
            pushFollow(FOLLOW_rule__VarOrArgumentCall__CallAssignment_1_in_rule__VarOrArgumentCall__Group__1__Impl11105);
            rule__VarOrArgumentCall__CallAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVarOrArgumentCallAccess().getCallAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarOrArgumentCall__Group__1__Impl"


    // $ANTLR start "rule__NativeExpression__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5528:1: rule__NativeExpression__Group__0 : rule__NativeExpression__Group__0__Impl rule__NativeExpression__Group__1 ;
    public final void rule__NativeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5532:1: ( rule__NativeExpression__Group__0__Impl rule__NativeExpression__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5533:2: rule__NativeExpression__Group__0__Impl rule__NativeExpression__Group__1
            {
            pushFollow(FOLLOW_rule__NativeExpression__Group__0__Impl_in_rule__NativeExpression__Group__011139);
            rule__NativeExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NativeExpression__Group__1_in_rule__NativeExpression__Group__011142);
            rule__NativeExpression__Group__1();

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
    // $ANTLR end "rule__NativeExpression__Group__0"


    // $ANTLR start "rule__NativeExpression__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5540:1: rule__NativeExpression__Group__0__Impl : ( () ) ;
    public final void rule__NativeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5544:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5545:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5545:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5546:1: ()
            {
             before(grammarAccess.getNativeExpressionAccess().getNativeExpressionAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5547:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5549:1: 
            {
            }

             after(grammarAccess.getNativeExpressionAccess().getNativeExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NativeExpression__Group__0__Impl"


    // $ANTLR start "rule__NativeExpression__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5559:1: rule__NativeExpression__Group__1 : rule__NativeExpression__Group__1__Impl rule__NativeExpression__Group__2 ;
    public final void rule__NativeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5563:1: ( rule__NativeExpression__Group__1__Impl rule__NativeExpression__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5564:2: rule__NativeExpression__Group__1__Impl rule__NativeExpression__Group__2
            {
            pushFollow(FOLLOW_rule__NativeExpression__Group__1__Impl_in_rule__NativeExpression__Group__111200);
            rule__NativeExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NativeExpression__Group__2_in_rule__NativeExpression__Group__111203);
            rule__NativeExpression__Group__2();

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
    // $ANTLR end "rule__NativeExpression__Group__1"


    // $ANTLR start "rule__NativeExpression__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5571:1: rule__NativeExpression__Group__1__Impl : ( ( rule__NativeExpression__Alternatives_1 ) ) ;
    public final void rule__NativeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5575:1: ( ( ( rule__NativeExpression__Alternatives_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5576:1: ( ( rule__NativeExpression__Alternatives_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5576:1: ( ( rule__NativeExpression__Alternatives_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5577:1: ( rule__NativeExpression__Alternatives_1 )
            {
             before(grammarAccess.getNativeExpressionAccess().getAlternatives_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5578:1: ( rule__NativeExpression__Alternatives_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5578:2: rule__NativeExpression__Alternatives_1
            {
            pushFollow(FOLLOW_rule__NativeExpression__Alternatives_1_in_rule__NativeExpression__Group__1__Impl11230);
            rule__NativeExpression__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getNativeExpressionAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NativeExpression__Group__1__Impl"


    // $ANTLR start "rule__NativeExpression__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5588:1: rule__NativeExpression__Group__2 : rule__NativeExpression__Group__2__Impl rule__NativeExpression__Group__3 ;
    public final void rule__NativeExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5592:1: ( rule__NativeExpression__Group__2__Impl rule__NativeExpression__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5593:2: rule__NativeExpression__Group__2__Impl rule__NativeExpression__Group__3
            {
            pushFollow(FOLLOW_rule__NativeExpression__Group__2__Impl_in_rule__NativeExpression__Group__211260);
            rule__NativeExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NativeExpression__Group__3_in_rule__NativeExpression__Group__211263);
            rule__NativeExpression__Group__3();

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
    // $ANTLR end "rule__NativeExpression__Group__2"


    // $ANTLR start "rule__NativeExpression__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5600:1: rule__NativeExpression__Group__2__Impl : ( '.' ) ;
    public final void rule__NativeExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5604:1: ( ( '.' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5605:1: ( '.' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5605:1: ( '.' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5606:1: '.'
            {
             before(grammarAccess.getNativeExpressionAccess().getFullStopKeyword_2()); 
            match(input,47,FOLLOW_47_in_rule__NativeExpression__Group__2__Impl11291); 
             after(grammarAccess.getNativeExpressionAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NativeExpression__Group__2__Impl"


    // $ANTLR start "rule__NativeExpression__Group__3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5619:1: rule__NativeExpression__Group__3 : rule__NativeExpression__Group__3__Impl ;
    public final void rule__NativeExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5623:1: ( rule__NativeExpression__Group__3__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5624:2: rule__NativeExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__NativeExpression__Group__3__Impl_in_rule__NativeExpression__Group__311322);
            rule__NativeExpression__Group__3__Impl();

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
    // $ANTLR end "rule__NativeExpression__Group__3"


    // $ANTLR start "rule__NativeExpression__Group__3__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5630:1: rule__NativeExpression__Group__3__Impl : ( ( rule__NativeExpression__NativeFunctionAssignment_3 ) ) ;
    public final void rule__NativeExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5634:1: ( ( ( rule__NativeExpression__NativeFunctionAssignment_3 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5635:1: ( ( rule__NativeExpression__NativeFunctionAssignment_3 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5635:1: ( ( rule__NativeExpression__NativeFunctionAssignment_3 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5636:1: ( rule__NativeExpression__NativeFunctionAssignment_3 )
            {
             before(grammarAccess.getNativeExpressionAccess().getNativeFunctionAssignment_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5637:1: ( rule__NativeExpression__NativeFunctionAssignment_3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5637:2: rule__NativeExpression__NativeFunctionAssignment_3
            {
            pushFollow(FOLLOW_rule__NativeExpression__NativeFunctionAssignment_3_in_rule__NativeExpression__Group__3__Impl11349);
            rule__NativeExpression__NativeFunctionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getNativeExpressionAccess().getNativeFunctionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NativeExpression__Group__3__Impl"


    // $ANTLR start "rule__RangeLiteral__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5655:1: rule__RangeLiteral__Group__0 : rule__RangeLiteral__Group__0__Impl rule__RangeLiteral__Group__1 ;
    public final void rule__RangeLiteral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5659:1: ( rule__RangeLiteral__Group__0__Impl rule__RangeLiteral__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5660:2: rule__RangeLiteral__Group__0__Impl rule__RangeLiteral__Group__1
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__0__Impl_in_rule__RangeLiteral__Group__011387);
            rule__RangeLiteral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeLiteral__Group__1_in_rule__RangeLiteral__Group__011390);
            rule__RangeLiteral__Group__1();

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
    // $ANTLR end "rule__RangeLiteral__Group__0"


    // $ANTLR start "rule__RangeLiteral__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5667:1: rule__RangeLiteral__Group__0__Impl : ( () ) ;
    public final void rule__RangeLiteral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5671:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5672:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5672:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5673:1: ()
            {
             before(grammarAccess.getRangeLiteralAccess().getRangeLiteralAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5674:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5676:1: 
            {
            }

             after(grammarAccess.getRangeLiteralAccess().getRangeLiteralAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeLiteral__Group__0__Impl"


    // $ANTLR start "rule__RangeLiteral__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5686:1: rule__RangeLiteral__Group__1 : rule__RangeLiteral__Group__1__Impl rule__RangeLiteral__Group__2 ;
    public final void rule__RangeLiteral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5690:1: ( rule__RangeLiteral__Group__1__Impl rule__RangeLiteral__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5691:2: rule__RangeLiteral__Group__1__Impl rule__RangeLiteral__Group__2
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__1__Impl_in_rule__RangeLiteral__Group__111448);
            rule__RangeLiteral__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeLiteral__Group__2_in_rule__RangeLiteral__Group__111451);
            rule__RangeLiteral__Group__2();

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
    // $ANTLR end "rule__RangeLiteral__Group__1"


    // $ANTLR start "rule__RangeLiteral__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5698:1: rule__RangeLiteral__Group__1__Impl : ( '[' ) ;
    public final void rule__RangeLiteral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5702:1: ( ( '[' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5703:1: ( '[' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5703:1: ( '[' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5704:1: '['
            {
             before(grammarAccess.getRangeLiteralAccess().getLeftSquareBracketKeyword_1()); 
            match(input,48,FOLLOW_48_in_rule__RangeLiteral__Group__1__Impl11479); 
             after(grammarAccess.getRangeLiteralAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeLiteral__Group__1__Impl"


    // $ANTLR start "rule__RangeLiteral__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5717:1: rule__RangeLiteral__Group__2 : rule__RangeLiteral__Group__2__Impl rule__RangeLiteral__Group__3 ;
    public final void rule__RangeLiteral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5721:1: ( rule__RangeLiteral__Group__2__Impl rule__RangeLiteral__Group__3 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5722:2: rule__RangeLiteral__Group__2__Impl rule__RangeLiteral__Group__3
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__2__Impl_in_rule__RangeLiteral__Group__211510);
            rule__RangeLiteral__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeLiteral__Group__3_in_rule__RangeLiteral__Group__211513);
            rule__RangeLiteral__Group__3();

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
    // $ANTLR end "rule__RangeLiteral__Group__2"


    // $ANTLR start "rule__RangeLiteral__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5729:1: rule__RangeLiteral__Group__2__Impl : ( ( rule__RangeLiteral__ValuesAssignment_2 ) ) ;
    public final void rule__RangeLiteral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5733:1: ( ( ( rule__RangeLiteral__ValuesAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5734:1: ( ( rule__RangeLiteral__ValuesAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5734:1: ( ( rule__RangeLiteral__ValuesAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5735:1: ( rule__RangeLiteral__ValuesAssignment_2 )
            {
             before(grammarAccess.getRangeLiteralAccess().getValuesAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5736:1: ( rule__RangeLiteral__ValuesAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5736:2: rule__RangeLiteral__ValuesAssignment_2
            {
            pushFollow(FOLLOW_rule__RangeLiteral__ValuesAssignment_2_in_rule__RangeLiteral__Group__2__Impl11540);
            rule__RangeLiteral__ValuesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRangeLiteralAccess().getValuesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeLiteral__Group__2__Impl"


    // $ANTLR start "rule__RangeLiteral__Group__3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5746:1: rule__RangeLiteral__Group__3 : rule__RangeLiteral__Group__3__Impl rule__RangeLiteral__Group__4 ;
    public final void rule__RangeLiteral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5750:1: ( rule__RangeLiteral__Group__3__Impl rule__RangeLiteral__Group__4 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5751:2: rule__RangeLiteral__Group__3__Impl rule__RangeLiteral__Group__4
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__3__Impl_in_rule__RangeLiteral__Group__311570);
            rule__RangeLiteral__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeLiteral__Group__4_in_rule__RangeLiteral__Group__311573);
            rule__RangeLiteral__Group__4();

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
    // $ANTLR end "rule__RangeLiteral__Group__3"


    // $ANTLR start "rule__RangeLiteral__Group__3__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5758:1: rule__RangeLiteral__Group__3__Impl : ( ( rule__RangeLiteral__Group_3__0 )* ) ;
    public final void rule__RangeLiteral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5762:1: ( ( ( rule__RangeLiteral__Group_3__0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5763:1: ( ( rule__RangeLiteral__Group_3__0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5763:1: ( ( rule__RangeLiteral__Group_3__0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5764:1: ( rule__RangeLiteral__Group_3__0 )*
            {
             before(grammarAccess.getRangeLiteralAccess().getGroup_3()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5765:1: ( rule__RangeLiteral__Group_3__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==26) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5765:2: rule__RangeLiteral__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__RangeLiteral__Group_3__0_in_rule__RangeLiteral__Group__3__Impl11600);
            	    rule__RangeLiteral__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getRangeLiteralAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeLiteral__Group__3__Impl"


    // $ANTLR start "rule__RangeLiteral__Group__4"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5775:1: rule__RangeLiteral__Group__4 : rule__RangeLiteral__Group__4__Impl ;
    public final void rule__RangeLiteral__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5779:1: ( rule__RangeLiteral__Group__4__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5780:2: rule__RangeLiteral__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group__4__Impl_in_rule__RangeLiteral__Group__411631);
            rule__RangeLiteral__Group__4__Impl();

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
    // $ANTLR end "rule__RangeLiteral__Group__4"


    // $ANTLR start "rule__RangeLiteral__Group__4__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5786:1: rule__RangeLiteral__Group__4__Impl : ( ']' ) ;
    public final void rule__RangeLiteral__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5790:1: ( ( ']' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5791:1: ( ']' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5791:1: ( ']' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5792:1: ']'
            {
             before(grammarAccess.getRangeLiteralAccess().getRightSquareBracketKeyword_4()); 
            match(input,49,FOLLOW_49_in_rule__RangeLiteral__Group__4__Impl11659); 
             after(grammarAccess.getRangeLiteralAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeLiteral__Group__4__Impl"


    // $ANTLR start "rule__RangeLiteral__Group_3__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5815:1: rule__RangeLiteral__Group_3__0 : rule__RangeLiteral__Group_3__0__Impl rule__RangeLiteral__Group_3__1 ;
    public final void rule__RangeLiteral__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5819:1: ( rule__RangeLiteral__Group_3__0__Impl rule__RangeLiteral__Group_3__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5820:2: rule__RangeLiteral__Group_3__0__Impl rule__RangeLiteral__Group_3__1
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group_3__0__Impl_in_rule__RangeLiteral__Group_3__011700);
            rule__RangeLiteral__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RangeLiteral__Group_3__1_in_rule__RangeLiteral__Group_3__011703);
            rule__RangeLiteral__Group_3__1();

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
    // $ANTLR end "rule__RangeLiteral__Group_3__0"


    // $ANTLR start "rule__RangeLiteral__Group_3__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5827:1: rule__RangeLiteral__Group_3__0__Impl : ( ',' ) ;
    public final void rule__RangeLiteral__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5831:1: ( ( ',' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5832:1: ( ',' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5832:1: ( ',' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5833:1: ','
            {
             before(grammarAccess.getRangeLiteralAccess().getCommaKeyword_3_0()); 
            match(input,26,FOLLOW_26_in_rule__RangeLiteral__Group_3__0__Impl11731); 
             after(grammarAccess.getRangeLiteralAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeLiteral__Group_3__0__Impl"


    // $ANTLR start "rule__RangeLiteral__Group_3__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5846:1: rule__RangeLiteral__Group_3__1 : rule__RangeLiteral__Group_3__1__Impl ;
    public final void rule__RangeLiteral__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5850:1: ( rule__RangeLiteral__Group_3__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5851:2: rule__RangeLiteral__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__RangeLiteral__Group_3__1__Impl_in_rule__RangeLiteral__Group_3__111762);
            rule__RangeLiteral__Group_3__1__Impl();

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
    // $ANTLR end "rule__RangeLiteral__Group_3__1"


    // $ANTLR start "rule__RangeLiteral__Group_3__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5857:1: rule__RangeLiteral__Group_3__1__Impl : ( ( rule__RangeLiteral__ValuesAssignment_3_1 ) ) ;
    public final void rule__RangeLiteral__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5861:1: ( ( ( rule__RangeLiteral__ValuesAssignment_3_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5862:1: ( ( rule__RangeLiteral__ValuesAssignment_3_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5862:1: ( ( rule__RangeLiteral__ValuesAssignment_3_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5863:1: ( rule__RangeLiteral__ValuesAssignment_3_1 )
            {
             before(grammarAccess.getRangeLiteralAccess().getValuesAssignment_3_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5864:1: ( rule__RangeLiteral__ValuesAssignment_3_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5864:2: rule__RangeLiteral__ValuesAssignment_3_1
            {
            pushFollow(FOLLOW_rule__RangeLiteral__ValuesAssignment_3_1_in_rule__RangeLiteral__Group_3__1__Impl11789);
            rule__RangeLiteral__ValuesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getRangeLiteralAccess().getValuesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeLiteral__Group_3__1__Impl"


    // $ANTLR start "rule__ContextRef__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5878:1: rule__ContextRef__Group__0 : rule__ContextRef__Group__0__Impl rule__ContextRef__Group__1 ;
    public final void rule__ContextRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5882:1: ( rule__ContextRef__Group__0__Impl rule__ContextRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5883:2: rule__ContextRef__Group__0__Impl rule__ContextRef__Group__1
            {
            pushFollow(FOLLOW_rule__ContextRef__Group__0__Impl_in_rule__ContextRef__Group__011823);
            rule__ContextRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ContextRef__Group__1_in_rule__ContextRef__Group__011826);
            rule__ContextRef__Group__1();

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
    // $ANTLR end "rule__ContextRef__Group__0"


    // $ANTLR start "rule__ContextRef__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5890:1: rule__ContextRef__Group__0__Impl : ( 'this' ) ;
    public final void rule__ContextRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5894:1: ( ( 'this' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5895:1: ( 'this' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5895:1: ( 'this' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5896:1: 'this'
            {
             before(grammarAccess.getContextRefAccess().getThisKeyword_0()); 
            match(input,50,FOLLOW_50_in_rule__ContextRef__Group__0__Impl11854); 
             after(grammarAccess.getContextRefAccess().getThisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextRef__Group__0__Impl"


    // $ANTLR start "rule__ContextRef__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5909:1: rule__ContextRef__Group__1 : rule__ContextRef__Group__1__Impl ;
    public final void rule__ContextRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5913:1: ( rule__ContextRef__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5914:2: rule__ContextRef__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ContextRef__Group__1__Impl_in_rule__ContextRef__Group__111885);
            rule__ContextRef__Group__1__Impl();

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
    // $ANTLR end "rule__ContextRef__Group__1"


    // $ANTLR start "rule__ContextRef__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5920:1: rule__ContextRef__Group__1__Impl : ( ruleNodeRef ) ;
    public final void rule__ContextRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5924:1: ( ( ruleNodeRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5925:1: ( ruleNodeRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5925:1: ( ruleNodeRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5926:1: ruleNodeRef
            {
             before(grammarAccess.getContextRefAccess().getNodeRefParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleNodeRef_in_rule__ContextRef__Group__1__Impl11912);
            ruleNodeRef();

            state._fsp--;

             after(grammarAccess.getContextRefAccess().getNodeRefParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextRef__Group__1__Impl"


    // $ANTLR start "rule__NodeRef__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5941:1: rule__NodeRef__Group__0 : rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 ;
    public final void rule__NodeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5945:1: ( rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5946:2: rule__NodeRef__Group__0__Impl rule__NodeRef__Group__1
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__011945);
            rule__NodeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__011948);
            rule__NodeRef__Group__1();

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
    // $ANTLR end "rule__NodeRef__Group__0"


    // $ANTLR start "rule__NodeRef__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5953:1: rule__NodeRef__Group__0__Impl : ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) ) ;
    public final void rule__NodeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5957:1: ( ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5958:1: ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5958:1: ( ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5959:1: ( ( rule__NodeRef__NodesAssignment_0 ) ) ( ( rule__NodeRef__NodesAssignment_0 )* )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5959:1: ( ( rule__NodeRef__NodesAssignment_0 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5960:1: ( rule__NodeRef__NodesAssignment_0 )
            {
             before(grammarAccess.getNodeRefAccess().getNodesAssignment_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5961:1: ( rule__NodeRef__NodesAssignment_0 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5961:2: rule__NodeRef__NodesAssignment_0
            {
            pushFollow(FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl11977);
            rule__NodeRef__NodesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getNodesAssignment_0()); 

            }

            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5964:1: ( ( rule__NodeRef__NodesAssignment_0 )* )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5965:1: ( rule__NodeRef__NodesAssignment_0 )*
            {
             before(grammarAccess.getNodeRefAccess().getNodesAssignment_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5966:1: ( rule__NodeRef__NodesAssignment_0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==47) ) {
                    int LA36_2 = input.LA(2);

                    if ( (LA36_2==RULE_ID) ) {
                        alt36=1;
                    }


                }


                switch (alt36) {
            	case 1 :
            	    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5966:2: rule__NodeRef__NodesAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl11989);
            	    rule__NodeRef__NodesAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getNodeRefAccess().getNodesAssignment_0()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__0__Impl"


    // $ANTLR start "rule__NodeRef__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5977:1: rule__NodeRef__Group__1 : rule__NodeRef__Group__1__Impl ;
    public final void rule__NodeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5981:1: ( rule__NodeRef__Group__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5982:2: rule__NodeRef__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__112022);
            rule__NodeRef__Group__1__Impl();

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
    // $ANTLR end "rule__NodeRef__Group__1"


    // $ANTLR start "rule__NodeRef__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5988:1: rule__NodeRef__Group__1__Impl : ( ( rule__NodeRef__Group_1__0 )? ) ;
    public final void rule__NodeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5992:1: ( ( ( rule__NodeRef__Group_1__0 )? ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5993:1: ( ( rule__NodeRef__Group_1__0 )? )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5993:1: ( ( rule__NodeRef__Group_1__0 )? )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5994:1: ( rule__NodeRef__Group_1__0 )?
            {
             before(grammarAccess.getNodeRefAccess().getGroup_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5995:1: ( rule__NodeRef__Group_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==51) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:5995:2: rule__NodeRef__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__NodeRef__Group_1__0_in_rule__NodeRef__Group__1__Impl12049);
                    rule__NodeRef__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeRefAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group__1__Impl"


    // $ANTLR start "rule__NodeRef__Group_1__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6009:1: rule__NodeRef__Group_1__0 : rule__NodeRef__Group_1__0__Impl rule__NodeRef__Group_1__1 ;
    public final void rule__NodeRef__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6013:1: ( rule__NodeRef__Group_1__0__Impl rule__NodeRef__Group_1__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6014:2: rule__NodeRef__Group_1__0__Impl rule__NodeRef__Group_1__1
            {
            pushFollow(FOLLOW_rule__NodeRef__Group_1__0__Impl_in_rule__NodeRef__Group_1__012084);
            rule__NodeRef__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NodeRef__Group_1__1_in_rule__NodeRef__Group_1__012087);
            rule__NodeRef__Group_1__1();

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
    // $ANTLR end "rule__NodeRef__Group_1__0"


    // $ANTLR start "rule__NodeRef__Group_1__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6021:1: rule__NodeRef__Group_1__0__Impl : ( '->' ) ;
    public final void rule__NodeRef__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6025:1: ( ( '->' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6026:1: ( '->' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6026:1: ( '->' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6027:1: '->'
            {
             before(grammarAccess.getNodeRefAccess().getHyphenMinusGreaterThanSignKeyword_1_0()); 
            match(input,51,FOLLOW_51_in_rule__NodeRef__Group_1__0__Impl12115); 
             after(grammarAccess.getNodeRefAccess().getHyphenMinusGreaterThanSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group_1__0__Impl"


    // $ANTLR start "rule__NodeRef__Group_1__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6040:1: rule__NodeRef__Group_1__1 : rule__NodeRef__Group_1__1__Impl ;
    public final void rule__NodeRef__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6044:1: ( rule__NodeRef__Group_1__1__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6045:2: rule__NodeRef__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__NodeRef__Group_1__1__Impl_in_rule__NodeRef__Group_1__112146);
            rule__NodeRef__Group_1__1__Impl();

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
    // $ANTLR end "rule__NodeRef__Group_1__1"


    // $ANTLR start "rule__NodeRef__Group_1__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6051:1: rule__NodeRef__Group_1__1__Impl : ( ( rule__NodeRef__RefAssignment_1_1 ) ) ;
    public final void rule__NodeRef__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6055:1: ( ( ( rule__NodeRef__RefAssignment_1_1 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6056:1: ( ( rule__NodeRef__RefAssignment_1_1 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6056:1: ( ( rule__NodeRef__RefAssignment_1_1 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6057:1: ( rule__NodeRef__RefAssignment_1_1 )
            {
             before(grammarAccess.getNodeRefAccess().getRefAssignment_1_1()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6058:1: ( rule__NodeRef__RefAssignment_1_1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6058:2: rule__NodeRef__RefAssignment_1_1
            {
            pushFollow(FOLLOW_rule__NodeRef__RefAssignment_1_1_in_rule__NodeRef__Group_1__1__Impl12173);
            rule__NodeRef__RefAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeRefAccess().getRefAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__Group_1__1__Impl"


    // $ANTLR start "rule__PrimaryNodeRef__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6072:1: rule__PrimaryNodeRef__Group__0 : rule__PrimaryNodeRef__Group__0__Impl rule__PrimaryNodeRef__Group__1 ;
    public final void rule__PrimaryNodeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6076:1: ( rule__PrimaryNodeRef__Group__0__Impl rule__PrimaryNodeRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6077:2: rule__PrimaryNodeRef__Group__0__Impl rule__PrimaryNodeRef__Group__1
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__0__Impl_in_rule__PrimaryNodeRef__Group__012207);
            rule__PrimaryNodeRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__1_in_rule__PrimaryNodeRef__Group__012210);
            rule__PrimaryNodeRef__Group__1();

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
    // $ANTLR end "rule__PrimaryNodeRef__Group__0"


    // $ANTLR start "rule__PrimaryNodeRef__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6084:1: rule__PrimaryNodeRef__Group__0__Impl : ( () ) ;
    public final void rule__PrimaryNodeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6088:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6089:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6089:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6090:1: ()
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeRefAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6091:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6093:1: 
            {
            }

             after(grammarAccess.getPrimaryNodeRefAccess().getNodeRefAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryNodeRef__Group__0__Impl"


    // $ANTLR start "rule__PrimaryNodeRef__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6103:1: rule__PrimaryNodeRef__Group__1 : rule__PrimaryNodeRef__Group__1__Impl rule__PrimaryNodeRef__Group__2 ;
    public final void rule__PrimaryNodeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6107:1: ( rule__PrimaryNodeRef__Group__1__Impl rule__PrimaryNodeRef__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6108:2: rule__PrimaryNodeRef__Group__1__Impl rule__PrimaryNodeRef__Group__2
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__1__Impl_in_rule__PrimaryNodeRef__Group__112268);
            rule__PrimaryNodeRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__2_in_rule__PrimaryNodeRef__Group__112271);
            rule__PrimaryNodeRef__Group__2();

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
    // $ANTLR end "rule__PrimaryNodeRef__Group__1"


    // $ANTLR start "rule__PrimaryNodeRef__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6115:1: rule__PrimaryNodeRef__Group__1__Impl : ( '.' ) ;
    public final void rule__PrimaryNodeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6119:1: ( ( '.' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6120:1: ( '.' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6120:1: ( '.' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6121:1: '.'
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getFullStopKeyword_1()); 
            match(input,47,FOLLOW_47_in_rule__PrimaryNodeRef__Group__1__Impl12299); 
             after(grammarAccess.getPrimaryNodeRefAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryNodeRef__Group__1__Impl"


    // $ANTLR start "rule__PrimaryNodeRef__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6134:1: rule__PrimaryNodeRef__Group__2 : rule__PrimaryNodeRef__Group__2__Impl ;
    public final void rule__PrimaryNodeRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6138:1: ( rule__PrimaryNodeRef__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6139:2: rule__PrimaryNodeRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__Group__2__Impl_in_rule__PrimaryNodeRef__Group__212330);
            rule__PrimaryNodeRef__Group__2__Impl();

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
    // $ANTLR end "rule__PrimaryNodeRef__Group__2"


    // $ANTLR start "rule__PrimaryNodeRef__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6145:1: rule__PrimaryNodeRef__Group__2__Impl : ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) ) ;
    public final void rule__PrimaryNodeRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6149:1: ( ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6150:1: ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6150:1: ( ( rule__PrimaryNodeRef__NodeAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6151:1: ( rule__PrimaryNodeRef__NodeAssignment_2 )
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6152:1: ( rule__PrimaryNodeRef__NodeAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6152:2: rule__PrimaryNodeRef__NodeAssignment_2
            {
            pushFollow(FOLLOW_rule__PrimaryNodeRef__NodeAssignment_2_in_rule__PrimaryNodeRef__Group__2__Impl12357);
            rule__PrimaryNodeRef__NodeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryNodeRefAccess().getNodeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryNodeRef__Group__2__Impl"


    // $ANTLR start "rule__ResourceRef__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6168:1: rule__ResourceRef__Group__0 : rule__ResourceRef__Group__0__Impl rule__ResourceRef__Group__1 ;
    public final void rule__ResourceRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6172:1: ( rule__ResourceRef__Group__0__Impl rule__ResourceRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6173:2: rule__ResourceRef__Group__0__Impl rule__ResourceRef__Group__1
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__0__Impl_in_rule__ResourceRef__Group__012393);
            rule__ResourceRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResourceRef__Group__1_in_rule__ResourceRef__Group__012396);
            rule__ResourceRef__Group__1();

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
    // $ANTLR end "rule__ResourceRef__Group__0"


    // $ANTLR start "rule__ResourceRef__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6180:1: rule__ResourceRef__Group__0__Impl : ( () ) ;
    public final void rule__ResourceRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6184:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6185:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6185:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6186:1: ()
            {
             before(grammarAccess.getResourceRefAccess().getResourceRefAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6187:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6189:1: 
            {
            }

             after(grammarAccess.getResourceRefAccess().getResourceRefAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResourceRef__Group__0__Impl"


    // $ANTLR start "rule__ResourceRef__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6199:1: rule__ResourceRef__Group__1 : rule__ResourceRef__Group__1__Impl rule__ResourceRef__Group__2 ;
    public final void rule__ResourceRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6203:1: ( rule__ResourceRef__Group__1__Impl rule__ResourceRef__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6204:2: rule__ResourceRef__Group__1__Impl rule__ResourceRef__Group__2
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__1__Impl_in_rule__ResourceRef__Group__112454);
            rule__ResourceRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResourceRef__Group__2_in_rule__ResourceRef__Group__112457);
            rule__ResourceRef__Group__2();

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
    // $ANTLR end "rule__ResourceRef__Group__1"


    // $ANTLR start "rule__ResourceRef__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6211:1: rule__ResourceRef__Group__1__Impl : ( 'RES' ) ;
    public final void rule__ResourceRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6215:1: ( ( 'RES' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6216:1: ( 'RES' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6216:1: ( 'RES' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6217:1: 'RES'
            {
             before(grammarAccess.getResourceRefAccess().getRESKeyword_1()); 
            match(input,52,FOLLOW_52_in_rule__ResourceRef__Group__1__Impl12485); 
             after(grammarAccess.getResourceRefAccess().getRESKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResourceRef__Group__1__Impl"


    // $ANTLR start "rule__ResourceRef__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6230:1: rule__ResourceRef__Group__2 : rule__ResourceRef__Group__2__Impl ;
    public final void rule__ResourceRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6234:1: ( rule__ResourceRef__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6235:2: rule__ResourceRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ResourceRef__Group__2__Impl_in_rule__ResourceRef__Group__212516);
            rule__ResourceRef__Group__2__Impl();

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
    // $ANTLR end "rule__ResourceRef__Group__2"


    // $ANTLR start "rule__ResourceRef__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6241:1: rule__ResourceRef__Group__2__Impl : ( ( rule__ResourceRef__ResourceAssignment_2 ) ) ;
    public final void rule__ResourceRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6245:1: ( ( ( rule__ResourceRef__ResourceAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6246:1: ( ( rule__ResourceRef__ResourceAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6246:1: ( ( rule__ResourceRef__ResourceAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6247:1: ( rule__ResourceRef__ResourceAssignment_2 )
            {
             before(grammarAccess.getResourceRefAccess().getResourceAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6248:1: ( rule__ResourceRef__ResourceAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6248:2: rule__ResourceRef__ResourceAssignment_2
            {
            pushFollow(FOLLOW_rule__ResourceRef__ResourceAssignment_2_in_rule__ResourceRef__Group__2__Impl12543);
            rule__ResourceRef__ResourceAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getResourceRefAccess().getResourceAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResourceRef__Group__2__Impl"


    // $ANTLR start "rule__LinkRef__Group__0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6264:1: rule__LinkRef__Group__0 : rule__LinkRef__Group__0__Impl rule__LinkRef__Group__1 ;
    public final void rule__LinkRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6268:1: ( rule__LinkRef__Group__0__Impl rule__LinkRef__Group__1 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6269:2: rule__LinkRef__Group__0__Impl rule__LinkRef__Group__1
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__0__Impl_in_rule__LinkRef__Group__012579);
            rule__LinkRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LinkRef__Group__1_in_rule__LinkRef__Group__012582);
            rule__LinkRef__Group__1();

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
    // $ANTLR end "rule__LinkRef__Group__0"


    // $ANTLR start "rule__LinkRef__Group__0__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6276:1: rule__LinkRef__Group__0__Impl : ( () ) ;
    public final void rule__LinkRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6280:1: ( ( () ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6281:1: ( () )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6281:1: ( () )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6282:1: ()
            {
             before(grammarAccess.getLinkRefAccess().getLinkRefAction_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6283:1: ()
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6285:1: 
            {
            }

             after(grammarAccess.getLinkRefAccess().getLinkRefAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkRef__Group__0__Impl"


    // $ANTLR start "rule__LinkRef__Group__1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6295:1: rule__LinkRef__Group__1 : rule__LinkRef__Group__1__Impl rule__LinkRef__Group__2 ;
    public final void rule__LinkRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6299:1: ( rule__LinkRef__Group__1__Impl rule__LinkRef__Group__2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6300:2: rule__LinkRef__Group__1__Impl rule__LinkRef__Group__2
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__1__Impl_in_rule__LinkRef__Group__112640);
            rule__LinkRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__LinkRef__Group__2_in_rule__LinkRef__Group__112643);
            rule__LinkRef__Group__2();

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
    // $ANTLR end "rule__LinkRef__Group__1"


    // $ANTLR start "rule__LinkRef__Group__1__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6307:1: rule__LinkRef__Group__1__Impl : ( 'LINK' ) ;
    public final void rule__LinkRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6311:1: ( ( 'LINK' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6312:1: ( 'LINK' )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6312:1: ( 'LINK' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6313:1: 'LINK'
            {
             before(grammarAccess.getLinkRefAccess().getLINKKeyword_1()); 
            match(input,53,FOLLOW_53_in_rule__LinkRef__Group__1__Impl12671); 
             after(grammarAccess.getLinkRefAccess().getLINKKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkRef__Group__1__Impl"


    // $ANTLR start "rule__LinkRef__Group__2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6326:1: rule__LinkRef__Group__2 : rule__LinkRef__Group__2__Impl ;
    public final void rule__LinkRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6330:1: ( rule__LinkRef__Group__2__Impl )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6331:2: rule__LinkRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__LinkRef__Group__2__Impl_in_rule__LinkRef__Group__212702);
            rule__LinkRef__Group__2__Impl();

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
    // $ANTLR end "rule__LinkRef__Group__2"


    // $ANTLR start "rule__LinkRef__Group__2__Impl"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6337:1: rule__LinkRef__Group__2__Impl : ( ( rule__LinkRef__LinkAssignment_2 ) ) ;
    public final void rule__LinkRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6341:1: ( ( ( rule__LinkRef__LinkAssignment_2 ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6342:1: ( ( rule__LinkRef__LinkAssignment_2 ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6342:1: ( ( rule__LinkRef__LinkAssignment_2 ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6343:1: ( rule__LinkRef__LinkAssignment_2 )
            {
             before(grammarAccess.getLinkRefAccess().getLinkAssignment_2()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6344:1: ( rule__LinkRef__LinkAssignment_2 )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6344:2: rule__LinkRef__LinkAssignment_2
            {
            pushFollow(FOLLOW_rule__LinkRef__LinkAssignment_2_in_rule__LinkRef__Group__2__Impl12729);
            rule__LinkRef__LinkAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLinkRefAccess().getLinkAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkRef__Group__2__Impl"


    // $ANTLR start "rule__Mod__NameAssignment_0_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6361:1: rule__Mod__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Mod__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6365:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6366:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6366:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6367:1: RULE_ID
            {
             before(grammarAccess.getModAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Mod__NameAssignment_0_112770); 
             after(grammarAccess.getModAccess().getNameIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__NameAssignment_0_1"


    // $ANTLR start "rule__Mod__ImportsAssignment_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6376:1: rule__Mod__ImportsAssignment_1 : ( ruleImport ) ;
    public final void rule__Mod__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6380:1: ( ( ruleImport ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6381:1: ( ruleImport )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6381:1: ( ruleImport )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6382:1: ruleImport
            {
             before(grammarAccess.getModAccess().getImportsImportParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Mod__ImportsAssignment_112801);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getModAccess().getImportsImportParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__ImportsAssignment_1"


    // $ANTLR start "rule__Mod__FunctionsAssignment_2_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6391:1: rule__Mod__FunctionsAssignment_2_0 : ( ruleFunction ) ;
    public final void rule__Mod__FunctionsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6395:1: ( ( ruleFunction ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6396:1: ( ruleFunction )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6396:1: ( ruleFunction )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6397:1: ruleFunction
            {
             before(grammarAccess.getModAccess().getFunctionsFunctionParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_ruleFunction_in_rule__Mod__FunctionsAssignment_2_012832);
            ruleFunction();

            state._fsp--;

             after(grammarAccess.getModAccess().getFunctionsFunctionParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__FunctionsAssignment_2_0"


    // $ANTLR start "rule__Mod__StatementsAssignment_2_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6406:1: rule__Mod__StatementsAssignment_2_1 : ( ruleStatement ) ;
    public final void rule__Mod__StatementsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6410:1: ( ( ruleStatement ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6411:1: ( ruleStatement )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6411:1: ( ruleStatement )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6412:1: ruleStatement
            {
             before(grammarAccess.getModAccess().getStatementsStatementParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Mod__StatementsAssignment_2_112863);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getModAccess().getStatementsStatementParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Mod__StatementsAssignment_2_1"


    // $ANTLR start "rule__Import__ImportURIAssignment_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6422:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6426:1: ( ( RULE_STRING ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6427:1: ( RULE_STRING )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6427:1: ( RULE_STRING )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6428:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_112895); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportURIAssignment_1"


    // $ANTLR start "rule__Function__NameAssignment_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6437:1: rule__Function__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Function__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6441:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6442:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6442:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6443:1: RULE_ID
            {
             before(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Function__NameAssignment_112926); 
             after(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__NameAssignment_1"


    // $ANTLR start "rule__Function__ArgsAssignment_3_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6452:1: rule__Function__ArgsAssignment_3_0 : ( ruleArgument ) ;
    public final void rule__Function__ArgsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6456:1: ( ( ruleArgument ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6457:1: ( ruleArgument )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6457:1: ( ruleArgument )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6458:1: ruleArgument
            {
             before(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_012957);
            ruleArgument();

            state._fsp--;

             after(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__ArgsAssignment_3_0"


    // $ANTLR start "rule__Function__ArgsAssignment_3_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6467:1: rule__Function__ArgsAssignment_3_1_1 : ( ruleArgument ) ;
    public final void rule__Function__ArgsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6471:1: ( ( ruleArgument ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6472:1: ( ruleArgument )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6472:1: ( ruleArgument )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6473:1: ruleArgument
            {
             before(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_1_112988);
            ruleArgument();

            state._fsp--;

             after(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__ArgsAssignment_3_1_1"


    // $ANTLR start "rule__Function__BlockAssignment_5"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6482:1: rule__Function__BlockAssignment_5 : ( ruleBlock ) ;
    public final void rule__Function__BlockAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6486:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6487:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6487:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6488:1: ruleBlock
            {
             before(grammarAccess.getFunctionAccess().getBlockBlockParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__Function__BlockAssignment_513019);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getFunctionAccess().getBlockBlockParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Function__BlockAssignment_5"


    // $ANTLR start "rule__Argument__NameAssignment"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6497:1: rule__Argument__NameAssignment : ( RULE_ID ) ;
    public final void rule__Argument__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6501:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6502:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6502:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6503:1: RULE_ID
            {
             before(grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Argument__NameAssignment13050); 
             after(grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Argument__NameAssignment"


    // $ANTLR start "rule__Block__StatementsAssignment_2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6512:1: rule__Block__StatementsAssignment_2 : ( ruleStatement ) ;
    public final void rule__Block__StatementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6516:1: ( ( ruleStatement ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6517:1: ( ruleStatement )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6517:1: ( ruleStatement )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6518:1: ruleStatement
            {
             before(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Block__StatementsAssignment_213081);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Block__StatementsAssignment_2"


    // $ANTLR start "rule__Statement__ExpressionAssignment_0_0_3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6527:1: rule__Statement__ExpressionAssignment_0_0_3 : ( ruleExpression ) ;
    public final void rule__Statement__ExpressionAssignment_0_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6531:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6532:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6532:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6533:1: ruleExpression
            {
             before(grammarAccess.getStatementAccess().getExpressionExpressionParserRuleCall_0_0_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__Statement__ExpressionAssignment_0_0_313112);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getStatementAccess().getExpressionExpressionParserRuleCall_0_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__ExpressionAssignment_0_0_3"


    // $ANTLR start "rule__ReturnStatement__ExpressionAssignment_2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6542:1: rule__ReturnStatement__ExpressionAssignment_2 : ( ruleExpression ) ;
    public final void rule__ReturnStatement__ExpressionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6546:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6547:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6547:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6548:1: ruleExpression
            {
             before(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ReturnStatement__ExpressionAssignment_213143);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReturnStatement__ExpressionAssignment_2"


    // $ANTLR start "rule__IfStatement__IfAssignment_3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6557:1: rule__IfStatement__IfAssignment_3 : ( ruleLogical ) ;
    public final void rule__IfStatement__IfAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6561:1: ( ( ruleLogical ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6562:1: ( ruleLogical )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6562:1: ( ruleLogical )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6563:1: ruleLogical
            {
             before(grammarAccess.getIfStatementAccess().getIfLogicalParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleLogical_in_rule__IfStatement__IfAssignment_313174);
            ruleLogical();

            state._fsp--;

             after(grammarAccess.getIfStatementAccess().getIfLogicalParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__IfAssignment_3"


    // $ANTLR start "rule__IfStatement__ThenAssignment_5"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6572:1: rule__IfStatement__ThenAssignment_5 : ( ruleBlock ) ;
    public final void rule__IfStatement__ThenAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6576:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6577:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6577:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6578:1: ruleBlock
            {
             before(grammarAccess.getIfStatementAccess().getThenBlockParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__IfStatement__ThenAssignment_513205);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getIfStatementAccess().getThenBlockParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__ThenAssignment_5"


    // $ANTLR start "rule__IfStatement__ElseAssignment_6_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6587:1: rule__IfStatement__ElseAssignment_6_1 : ( ruleBlock ) ;
    public final void rule__IfStatement__ElseAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6591:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6592:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6592:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6593:1: ruleBlock
            {
             before(grammarAccess.getIfStatementAccess().getElseBlockParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__IfStatement__ElseAssignment_6_113236);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getIfStatementAccess().getElseBlockParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfStatement__ElseAssignment_6_1"


    // $ANTLR start "rule__WhileStatement__PredicateAssignment_3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6602:1: rule__WhileStatement__PredicateAssignment_3 : ( ruleLogical ) ;
    public final void rule__WhileStatement__PredicateAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6606:1: ( ( ruleLogical ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6607:1: ( ruleLogical )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6607:1: ( ruleLogical )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6608:1: ruleLogical
            {
             before(grammarAccess.getWhileStatementAccess().getPredicateLogicalParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleLogical_in_rule__WhileStatement__PredicateAssignment_313267);
            ruleLogical();

            state._fsp--;

             after(grammarAccess.getWhileStatementAccess().getPredicateLogicalParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__PredicateAssignment_3"


    // $ANTLR start "rule__WhileStatement__BodyAssignment_5"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6617:1: rule__WhileStatement__BodyAssignment_5 : ( ruleBlock ) ;
    public final void rule__WhileStatement__BodyAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6621:1: ( ( ruleBlock ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6622:1: ( ruleBlock )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6622:1: ( ruleBlock )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6623:1: ruleBlock
            {
             before(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleBlock_in_rule__WhileStatement__BodyAssignment_513298);
            ruleBlock();

            state._fsp--;

             after(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WhileStatement__BodyAssignment_5"


    // $ANTLR start "rule__VariableStatement__NameAssignment_2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6632:1: rule__VariableStatement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__VariableStatement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6636:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6637:1: ( RULE_ID )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6637:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6638:1: RULE_ID
            {
             before(grammarAccess.getVariableStatementAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VariableStatement__NameAssignment_213329); 
             after(grammarAccess.getVariableStatementAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableStatement__NameAssignment_2"


    // $ANTLR start "rule__VariableStatement__ExpressionAssignment_3_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6647:1: rule__VariableStatement__ExpressionAssignment_3_1 : ( ruleExpression ) ;
    public final void rule__VariableStatement__ExpressionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6651:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6652:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6652:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6653:1: ruleExpression
            {
             before(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__VariableStatement__ExpressionAssignment_3_113360);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableStatement__ExpressionAssignment_3_1"


    // $ANTLR start "rule__AssignmentStatement__VarAssignment_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6662:1: rule__AssignmentStatement__VarAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AssignmentStatement__VarAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6666:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6667:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6667:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6668:1: ( RULE_ID )
            {
             before(grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentCrossReference_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6669:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6670:1: RULE_ID
            {
             before(grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AssignmentStatement__VarAssignment_113395); 
             after(grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentStatement__VarAssignment_1"


    // $ANTLR start "rule__AssignmentStatement__ExpressionAssignment_3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6681:1: rule__AssignmentStatement__ExpressionAssignment_3 : ( ruleExpression ) ;
    public final void rule__AssignmentStatement__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6685:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6686:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6686:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6687:1: ruleExpression
            {
             before(grammarAccess.getAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__AssignmentStatement__ExpressionAssignment_313430);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AssignmentStatement__ExpressionAssignment_3"


    // $ANTLR start "rule__ReferenceAssignmentStatement__RefAssignment_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6696:1: rule__ReferenceAssignmentStatement__RefAssignment_1 : ( ruleContextRef ) ;
    public final void rule__ReferenceAssignmentStatement__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6700:1: ( ( ruleContextRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6701:1: ( ruleContextRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6701:1: ( ruleContextRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6702:1: ruleContextRef
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getRefContextRefParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleContextRef_in_rule__ReferenceAssignmentStatement__RefAssignment_113461);
            ruleContextRef();

            state._fsp--;

             after(grammarAccess.getReferenceAssignmentStatementAccess().getRefContextRefParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceAssignmentStatement__RefAssignment_1"


    // $ANTLR start "rule__ReferenceAssignmentStatement__ExpressionAssignment_3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6711:1: rule__ReferenceAssignmentStatement__ExpressionAssignment_3 : ( ruleExpression ) ;
    public final void rule__ReferenceAssignmentStatement__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6715:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6716:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6716:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6717:1: ruleExpression
            {
             before(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__ReferenceAssignmentStatement__ExpressionAssignment_313492);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReferenceAssignmentStatement__ExpressionAssignment_3"


    // $ANTLR start "rule__Logical__RightAssignment_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6726:1: rule__Logical__RightAssignment_1_1 : ( ruleEquality ) ;
    public final void rule__Logical__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6730:1: ( ( ruleEquality ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6731:1: ( ruleEquality )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6731:1: ( ruleEquality )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6732:1: ruleEquality
            {
             before(grammarAccess.getLogicalAccess().getRightEqualityParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleEquality_in_rule__Logical__RightAssignment_1_113523);
            ruleEquality();

            state._fsp--;

             after(grammarAccess.getLogicalAccess().getRightEqualityParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Logical__RightAssignment_1_1"


    // $ANTLR start "rule__Equality__RightAssignment_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6741:1: rule__Equality__RightAssignment_1_1 : ( ruleComparison ) ;
    public final void rule__Equality__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6745:1: ( ( ruleComparison ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6746:1: ( ruleComparison )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6746:1: ( ruleComparison )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6747:1: ruleComparison
            {
             before(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleComparison_in_rule__Equality__RightAssignment_1_113554);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equality__RightAssignment_1_1"


    // $ANTLR start "rule__Comparison__RightAssignment_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6756:1: rule__Comparison__RightAssignment_1_1 : ( ruleAddition ) ;
    public final void rule__Comparison__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6760:1: ( ( ruleAddition ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6761:1: ( ruleAddition )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6761:1: ( ruleAddition )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6762:1: ruleAddition
            {
             before(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleAddition_in_rule__Comparison__RightAssignment_1_113585);
            ruleAddition();

            state._fsp--;

             after(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__RightAssignment_1_1"


    // $ANTLR start "rule__Addition__RightAssignment_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6771:1: rule__Addition__RightAssignment_1_1 : ( ruleMultiplication ) ;
    public final void rule__Addition__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6775:1: ( ( ruleMultiplication ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6776:1: ( ruleMultiplication )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6776:1: ( ruleMultiplication )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6777:1: ruleMultiplication
            {
             before(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_113616);
            ruleMultiplication();

            state._fsp--;

             after(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Addition__RightAssignment_1_1"


    // $ANTLR start "rule__Multiplication__RightAssignment_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6786:1: rule__Multiplication__RightAssignment_1_1 : ( ruleUnary ) ;
    public final void rule__Multiplication__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6790:1: ( ( ruleUnary ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6791:1: ( ruleUnary )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6791:1: ( ruleUnary )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6792:1: ruleUnary
            {
             before(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleUnary_in_rule__Multiplication__RightAssignment_1_113647);
            ruleUnary();

            state._fsp--;

             after(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Multiplication__RightAssignment_1_1"


    // $ANTLR start "rule__Unary__OpAssignment_1_0_0_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6801:1: rule__Unary__OpAssignment_1_0_0_1 : ( ( '!' ) ) ;
    public final void rule__Unary__OpAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6805:1: ( ( ( '!' ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6806:1: ( ( '!' ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6806:1: ( ( '!' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6807:1: ( '!' )
            {
             before(grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_0_0_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6808:1: ( '!' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6809:1: '!'
            {
             before(grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_0_0_1_0()); 
            match(input,54,FOLLOW_54_in_rule__Unary__OpAssignment_1_0_0_113683); 
             after(grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_0_0_1_0()); 

            }

             after(grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_0_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unary__OpAssignment_1_0_0_1"


    // $ANTLR start "rule__Unary__OpAssignment_1_0_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6824:1: rule__Unary__OpAssignment_1_0_1_1 : ( ruleUnaryOperator ) ;
    public final void rule__Unary__OpAssignment_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6828:1: ( ( ruleUnaryOperator ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6829:1: ( ruleUnaryOperator )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6829:1: ( ruleUnaryOperator )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6830:1: ruleUnaryOperator
            {
             before(grammarAccess.getUnaryAccess().getOpUnaryOperatorParserRuleCall_1_0_1_1_0()); 
            pushFollow(FOLLOW_ruleUnaryOperator_in_rule__Unary__OpAssignment_1_0_1_113722);
            ruleUnaryOperator();

            state._fsp--;

             after(grammarAccess.getUnaryAccess().getOpUnaryOperatorParserRuleCall_1_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unary__OpAssignment_1_0_1_1"


    // $ANTLR start "rule__Unary__RightAssignment_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6839:1: rule__Unary__RightAssignment_1_1 : ( ruleUnary ) ;
    public final void rule__Unary__RightAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6843:1: ( ( ruleUnary ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6844:1: ( ruleUnary )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6844:1: ( ruleUnary )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6845:1: ruleUnary
            {
             before(grammarAccess.getUnaryAccess().getRightUnaryParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleUnary_in_rule__Unary__RightAssignment_1_113753);
            ruleUnary();

            state._fsp--;

             after(grammarAccess.getUnaryAccess().getRightUnaryParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Unary__RightAssignment_1_1"


    // $ANTLR start "rule__Literal__ValueAssignment_0_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6854:1: rule__Literal__ValueAssignment_0_1 : ( RULE_NUMBER ) ;
    public final void rule__Literal__ValueAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6858:1: ( ( RULE_NUMBER ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6859:1: ( RULE_NUMBER )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6859:1: ( RULE_NUMBER )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6860:1: RULE_NUMBER
            {
             before(grammarAccess.getLiteralAccess().getValueNUMBERTerminalRuleCall_0_1_0()); 
            match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__Literal__ValueAssignment_0_113784); 
             after(grammarAccess.getLiteralAccess().getValueNUMBERTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__ValueAssignment_0_1"


    // $ANTLR start "rule__Literal__ConditionAssignment_1_1_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6869:1: rule__Literal__ConditionAssignment_1_1_0 : ( ( 'true' ) ) ;
    public final void rule__Literal__ConditionAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6873:1: ( ( ( 'true' ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6874:1: ( ( 'true' ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6874:1: ( ( 'true' ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6875:1: ( 'true' )
            {
             before(grammarAccess.getLiteralAccess().getConditionTrueKeyword_1_1_0_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6876:1: ( 'true' )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6877:1: 'true'
            {
             before(grammarAccess.getLiteralAccess().getConditionTrueKeyword_1_1_0_0()); 
            match(input,55,FOLLOW_55_in_rule__Literal__ConditionAssignment_1_1_013820); 
             after(grammarAccess.getLiteralAccess().getConditionTrueKeyword_1_1_0_0()); 

            }

             after(grammarAccess.getLiteralAccess().getConditionTrueKeyword_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Literal__ConditionAssignment_1_1_0"


    // $ANTLR start "rule__FunctionCall__FuncAssignment_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6892:1: rule__FunctionCall__FuncAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__FunctionCall__FuncAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6896:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6897:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6897:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6898:1: ( RULE_ID )
            {
             before(grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionCrossReference_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6899:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6900:1: RULE_ID
            {
             before(grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FunctionCall__FuncAssignment_113863); 
             after(grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__FuncAssignment_1"


    // $ANTLR start "rule__FunctionCall__ArgsAssignment_3_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6911:1: rule__FunctionCall__ArgsAssignment_3_0 : ( ruleExpression ) ;
    public final void rule__FunctionCall__ArgsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6915:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6916:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6916:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6917:1: ruleExpression
            {
             before(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_013898);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__ArgsAssignment_3_0"


    // $ANTLR start "rule__FunctionCall__ArgsAssignment_3_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6926:1: rule__FunctionCall__ArgsAssignment_3_1_1 : ( ruleExpression ) ;
    public final void rule__FunctionCall__ArgsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6930:1: ( ( ruleExpression ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6931:1: ( ruleExpression )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6931:1: ( ruleExpression )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6932:1: ruleExpression
            {
             before(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_1_113929);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FunctionCall__ArgsAssignment_3_1_1"


    // $ANTLR start "rule__VarOrArgumentCall__CallAssignment_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6941:1: rule__VarOrArgumentCall__CallAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__VarOrArgumentCall__CallAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6945:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6946:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6946:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6947:1: ( RULE_ID )
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getCallAbstractVarOrArgumentCrossReference_1_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6948:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6949:1: RULE_ID
            {
             before(grammarAccess.getVarOrArgumentCallAccess().getCallAbstractVarOrArgumentIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__VarOrArgumentCall__CallAssignment_113964); 
             after(grammarAccess.getVarOrArgumentCallAccess().getCallAbstractVarOrArgumentIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getVarOrArgumentCallAccess().getCallAbstractVarOrArgumentCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarOrArgumentCall__CallAssignment_1"


    // $ANTLR start "rule__NativeExpression__RangeAssignment_1_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6960:1: rule__NativeExpression__RangeAssignment_1_0 : ( ruleRangeLiteral ) ;
    public final void rule__NativeExpression__RangeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6964:1: ( ( ruleRangeLiteral ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6965:1: ( ruleRangeLiteral )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6965:1: ( ruleRangeLiteral )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6966:1: ruleRangeLiteral
            {
             before(grammarAccess.getNativeExpressionAccess().getRangeRangeLiteralParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleRangeLiteral_in_rule__NativeExpression__RangeAssignment_1_013999);
            ruleRangeLiteral();

            state._fsp--;

             after(grammarAccess.getNativeExpressionAccess().getRangeRangeLiteralParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NativeExpression__RangeAssignment_1_0"


    // $ANTLR start "rule__NativeExpression__RefAssignment_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6975:1: rule__NativeExpression__RefAssignment_1_1 : ( ruleReference ) ;
    public final void rule__NativeExpression__RefAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6979:1: ( ( ruleReference ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6980:1: ( ruleReference )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6980:1: ( ruleReference )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6981:1: ruleReference
            {
             before(grammarAccess.getNativeExpressionAccess().getRefReferenceParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleReference_in_rule__NativeExpression__RefAssignment_1_114030);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getNativeExpressionAccess().getRefReferenceParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NativeExpression__RefAssignment_1_1"


    // $ANTLR start "rule__NativeExpression__NativeFunctionAssignment_3"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6990:1: rule__NativeExpression__NativeFunctionAssignment_3 : ( ruleNativeFunction ) ;
    public final void rule__NativeExpression__NativeFunctionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6994:1: ( ( ruleNativeFunction ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6995:1: ( ruleNativeFunction )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6995:1: ( ruleNativeFunction )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:6996:1: ruleNativeFunction
            {
             before(grammarAccess.getNativeExpressionAccess().getNativeFunctionNativeFunctionEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNativeFunction_in_rule__NativeExpression__NativeFunctionAssignment_314061);
            ruleNativeFunction();

            state._fsp--;

             after(grammarAccess.getNativeExpressionAccess().getNativeFunctionNativeFunctionEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NativeExpression__NativeFunctionAssignment_3"


    // $ANTLR start "rule__RangeLiteral__ValuesAssignment_2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7005:1: rule__RangeLiteral__ValuesAssignment_2 : ( RULE_NUMBER ) ;
    public final void rule__RangeLiteral__ValuesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7009:1: ( ( RULE_NUMBER ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7010:1: ( RULE_NUMBER )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7010:1: ( RULE_NUMBER )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7011:1: RULE_NUMBER
            {
             before(grammarAccess.getRangeLiteralAccess().getValuesNUMBERTerminalRuleCall_2_0()); 
            match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__RangeLiteral__ValuesAssignment_214092); 
             after(grammarAccess.getRangeLiteralAccess().getValuesNUMBERTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeLiteral__ValuesAssignment_2"


    // $ANTLR start "rule__RangeLiteral__ValuesAssignment_3_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7020:1: rule__RangeLiteral__ValuesAssignment_3_1 : ( RULE_NUMBER ) ;
    public final void rule__RangeLiteral__ValuesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7024:1: ( ( RULE_NUMBER ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7025:1: ( RULE_NUMBER )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7025:1: ( RULE_NUMBER )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7026:1: RULE_NUMBER
            {
             before(grammarAccess.getRangeLiteralAccess().getValuesNUMBERTerminalRuleCall_3_1_0()); 
            match(input,RULE_NUMBER,FOLLOW_RULE_NUMBER_in_rule__RangeLiteral__ValuesAssignment_3_114123); 
             after(grammarAccess.getRangeLiteralAccess().getValuesNUMBERTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RangeLiteral__ValuesAssignment_3_1"


    // $ANTLR start "rule__NodeRef__NodesAssignment_0"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7035:1: rule__NodeRef__NodesAssignment_0 : ( rulePrimaryNodeRef ) ;
    public final void rule__NodeRef__NodesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7039:1: ( ( rulePrimaryNodeRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7040:1: ( rulePrimaryNodeRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7040:1: ( rulePrimaryNodeRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7041:1: rulePrimaryNodeRef
            {
             before(grammarAccess.getNodeRefAccess().getNodesPrimaryNodeRefParserRuleCall_0_0()); 
            pushFollow(FOLLOW_rulePrimaryNodeRef_in_rule__NodeRef__NodesAssignment_014154);
            rulePrimaryNodeRef();

            state._fsp--;

             after(grammarAccess.getNodeRefAccess().getNodesPrimaryNodeRefParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__NodesAssignment_0"


    // $ANTLR start "rule__NodeRef__RefAssignment_1_1"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7050:1: rule__NodeRef__RefAssignment_1_1 : ( ruleLeafRef ) ;
    public final void rule__NodeRef__RefAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7054:1: ( ( ruleLeafRef ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7055:1: ( ruleLeafRef )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7055:1: ( ruleLeafRef )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7056:1: ruleLeafRef
            {
             before(grammarAccess.getNodeRefAccess().getRefLeafRefParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleLeafRef_in_rule__NodeRef__RefAssignment_1_114185);
            ruleLeafRef();

            state._fsp--;

             after(grammarAccess.getNodeRefAccess().getRefLeafRefParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeRef__RefAssignment_1_1"


    // $ANTLR start "rule__PrimaryNodeRef__NodeAssignment_2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7065:1: rule__PrimaryNodeRef__NodeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__PrimaryNodeRef__NodeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7069:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7070:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7070:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7071:1: ( RULE_ID )
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeNodeCrossReference_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7072:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7073:1: RULE_ID
            {
             before(grammarAccess.getPrimaryNodeRefAccess().getNodeNodeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PrimaryNodeRef__NodeAssignment_214220); 
             after(grammarAccess.getPrimaryNodeRefAccess().getNodeNodeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getPrimaryNodeRefAccess().getNodeNodeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryNodeRef__NodeAssignment_2"


    // $ANTLR start "rule__ResourceRef__ResourceAssignment_2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7084:1: rule__ResourceRef__ResourceAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ResourceRef__ResourceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7088:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7089:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7089:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7090:1: ( RULE_ID )
            {
             before(grammarAccess.getResourceRefAccess().getResourceResourceCrossReference_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7091:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7092:1: RULE_ID
            {
             before(grammarAccess.getResourceRefAccess().getResourceResourceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ResourceRef__ResourceAssignment_214259); 
             after(grammarAccess.getResourceRefAccess().getResourceResourceIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getResourceRefAccess().getResourceResourceCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResourceRef__ResourceAssignment_2"


    // $ANTLR start "rule__LinkRef__LinkAssignment_2"
    // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7103:1: rule__LinkRef__LinkAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__LinkRef__LinkAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7107:1: ( ( ( RULE_ID ) ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7108:1: ( ( RULE_ID ) )
            {
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7108:1: ( ( RULE_ID ) )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7109:1: ( RULE_ID )
            {
             before(grammarAccess.getLinkRefAccess().getLinkLinkCrossReference_2_0()); 
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7110:1: ( RULE_ID )
            // ../com.netxforge.netxscript.a.ui/src-gen/com/netxforge/ui/contentassist/antlr/internal/InternalNetxscript.g:7111:1: RULE_ID
            {
             before(grammarAccess.getLinkRefAccess().getLinkLinkIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__LinkRef__LinkAssignment_214298); 
             after(grammarAccess.getLinkRefAccess().getLinkLinkIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getLinkRefAccess().getLinkLinkCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkRef__LinkAssignment_2"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA5_eotS =
        "\21\uffff";
    static final String DFA5_eofS =
        "\21\uffff";
    static final String DFA5_minS =
        "\1\4\1\uffff\1\14\1\57\3\uffff\1\4\1\14\1\4\1\64\1\uffff\1\14\2"+
        "\4\2\14";
    static final String DFA5_maxS =
        "\1\67\1\uffff\1\56\1\57\3\uffff\1\4\1\63\1\24\1\65\1\uffff\1\63"+
        "\2\4\2\57";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\2\4\uffff\1\3\5\uffff";
    static final String DFA5_specialS =
        "\21\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\1\uffff\1\4\5\uffff\3\4\11\uffff\1\4\5\uffff\1\5\3\uffff"+
            "\1\1\15\uffff\1\4\1\uffff\1\3\3\uffff\2\4",
            "",
            "\2\4\12\uffff\1\4\4\uffff\1\4\5\uffff\1\6\13\4",
            "\1\7",
            "",
            "",
            "",
            "\1\10",
            "\2\4\17\uffff\1\4\5\uffff\1\13\13\4\1\11\3\uffff\1\12",
            "\1\14\12\uffff\6\4",
            "\1\15\1\16",
            "",
            "\2\4\17\uffff\1\4\5\uffff\1\13\13\4\1\11\3\uffff\1\12",
            "\1\17",
            "\1\20",
            "\2\4\17\uffff\1\4\5\uffff\1\13\14\4",
            "\2\4\17\uffff\1\4\5\uffff\1\13\14\4"
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1137:1: rule__Statement__Alternatives_0_0 : ( ( ruleVariableStatement ) | ( ruleAssignmentStatement ) | ( ruleReferenceAssignmentStatement ) | ( ( rule__Statement__ExpressionAssignment_0_0_3 ) ) | ( ruleReturnStatement ) );";
        }
    }
    static final String DFA14_eotS =
        "\30\uffff";
    static final String DFA14_eofS =
        "\4\uffff\1\11\6\uffff\1\17\1\22\6\uffff\1\22\2\uffff\2\22";
    static final String DFA14_minS =
        "\1\4\1\uffff\1\6\1\57\1\14\1\uffff\1\32\1\4\2\uffff\1\6\2\14\1\32"+
        "\2\uffff\1\4\1\64\1\uffff\1\14\2\4\2\14";
    static final String DFA14_maxS =
        "\1\67\1\uffff\1\6\1\57\1\56\1\uffff\1\61\1\4\2\uffff\1\6\1\57\1"+
        "\63\1\61\2\uffff\1\24\1\65\1\uffff\1\63\2\4\2\57";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\3\uffff\1\7\2\uffff\1\5\1\6\4\uffff\1\3\1\2\2\uffff"+
        "\1\4\5\uffff";
    static final String DFA14_specialS =
        "\30\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\4\1\uffff\1\1\7\uffff\1\1\11\uffff\1\5\27\uffff\1\2\1\uffff"+
            "\1\3\4\uffff\1\1",
            "",
            "\1\6",
            "\1\7",
            "\2\11\12\uffff\1\10\2\11\2\uffff\1\11\6\uffff\13\11",
            "",
            "\1\12\26\uffff\1\13",
            "\1\14",
            "",
            "",
            "\1\15",
            "\2\17\13\uffff\2\17\2\uffff\1\17\6\uffff\13\17\1\16",
            "\2\22\13\uffff\2\22\2\uffff\1\22\6\uffff\13\22\1\20\3\uffff"+
            "\1\21",
            "\1\12\26\uffff\1\13",
            "",
            "",
            "\1\23\12\uffff\6\16",
            "\1\24\1\25",
            "",
            "\2\22\13\uffff\2\22\2\uffff\1\22\6\uffff\13\22\1\20\3\uffff"+
            "\1\21",
            "\1\26",
            "\1\27",
            "\2\22\13\uffff\2\22\2\uffff\1\22\6\uffff\13\22\1\16",
            "\2\22\13\uffff\2\22\2\uffff\1\22\6\uffff\13\22\1\16"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1375:1: rule__PrimaryExpression__Alternatives : ( ( ruleLiteral ) | ( ruleRange ) | ( ruleNativeExpression ) | ( ruleReference ) | ( ruleFunctionCall ) | ( ruleVarOrArgumentCall ) | ( ruleParenthesizedExpression ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleMod_in_entryRuleMod61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMod68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group__0_in_ruleMod94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0_in_ruleFunction216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_entryRuleArgument243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgument250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Argument__NameAssignment_in_ruleArgument276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__Group__0_in_ruleBlock340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Alternatives_in_ruleStatement400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReturnStatement434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__0_in_ruleReturnStatement460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__0_in_ruleIfStatement520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__0_in_ruleWhileStatement580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_entryRuleVariableStatement607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableStatement614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__0_in_ruleVariableStatement640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_entryRuleAssignmentStatement667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentStatement674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__0_in_ruleAssignmentStatement700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_entryRuleReferenceAssignmentStatement727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAssignmentStatement734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__0_in_ruleReferenceAssignmentStatement760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_ruleExpression820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_entryRuleLogical846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogical853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group__0_in_ruleLogical879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_entryRuleEquality906 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquality913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group__0_in_ruleEquality939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_entryRuleComparison966 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparison973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__0_in_ruleComparison999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_entryRuleAddition1026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAddition1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__0_in_ruleAddition1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_entryRuleMultiplication1086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplication1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__0_in_ruleMultiplication1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_entryRuleUnary1146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnary1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Alternatives_in_ruleUnary1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_entryRuleUnaryOperator1206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperator1213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__UnaryOperator__Alternatives_in_ruleUnaryOperator1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression1266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_in_ruleLiteral1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression1386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__0_in_ruleParenthesizedExpression1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_entryRuleFunctionCall1446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionCall1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__0_in_ruleFunctionCall1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_entryRuleVarOrArgumentCall1506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarOrArgumentCall1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__Group__0_in_ruleVarOrArgumentCall1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeExpression_in_entryRuleNativeExpression1566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNativeExpression1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__0_in_ruleNativeExpression1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_entryRuleRange1626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRange1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_ruleRange1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_entryRuleRangeLiteral1685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeLiteral1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__0_in_ruleRangeLiteral1718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_ruleReference1778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_entryRuleContextRef1804 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextRef1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__0_in_ruleContextRef1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_entryRuleNodeRef1864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNodeRef1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__0_in_ruleNodeRef1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_entryRulePrimaryNodeRef1924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryNodeRef1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__0_in_rulePrimaryNodeRef1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLeafRef_in_entryRuleLeafRef1984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLeafRef1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LeafRef__Alternatives_in_ruleLeafRef2017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_entryRuleResourceRef2044 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResourceRef2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__0_in_ruleResourceRef2077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_entryRuleLinkRef2104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLinkRef2111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__0_in_ruleLinkRef2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeFunction__Alternatives_in_ruleNativeFunction2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__FunctionsAssignment_2_0_in_rule__Mod__Alternatives_22211 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__Mod__FunctionsAssignment_2_0_in_rule__Mod__Alternatives_22223 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__Mod__StatementsAssignment_2_1_in_rule__Mod__Alternatives_22246 = new BitSet(new long[]{0x00C50006C9007052L});
    public static final BitSet FOLLOW_rule__Mod__StatementsAssignment_2_1_in_rule__Mod__Alternatives_22258 = new BitSet(new long[]{0x00C50006C9007052L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__0_in_rule__Statement__Alternatives2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_rule__Statement__Alternatives2313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_rule__Statement__Alternatives2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__Statement__Alternatives2347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableStatement_in_rule__Statement__Alternatives_0_02379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentStatement_in_rule__Statement__Alternatives_0_02396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceAssignmentStatement_in_rule__Statement__Alternatives_0_02413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__ExpressionAssignment_0_0_3_in_rule__Statement__Alternatives_0_02430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_rule__Statement__Alternatives_0_02448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__0_in_rule__Logical__Alternatives_1_02480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__0_in_rule__Logical__Alternatives_1_02498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__0_in_rule__Equality__Alternatives_1_02531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__0_in_rule__Equality__Alternatives_1_02549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__0_in_rule__Comparison__Alternatives_1_02582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__0_in_rule__Comparison__Alternatives_1_02600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__0_in_rule__Comparison__Alternatives_1_02618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__0_in_rule__Comparison__Alternatives_1_02636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0_in_rule__Addition__Alternatives_1_02669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0_in_rule__Addition__Alternatives_1_02687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__0_in_rule__Multiplication__Alternatives_1_02720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__0_in_rule__Multiplication__Alternatives_1_02738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__0_in_rule__Multiplication__Alternatives_1_02756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__Unary__Alternatives2789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__0_in_rule__Unary__Alternatives2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__0_in_rule__Unary__Alternatives_1_02839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__0_in_rule__Unary__Alternatives_1_02857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__UnaryOperator__Alternatives2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__UnaryOperator__Alternatives2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rule__PrimaryExpression__Alternatives2945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_rule__PrimaryExpression__Alternatives2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeExpression_in_rule__PrimaryExpression__Alternatives2979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__PrimaryExpression__Alternatives2996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionCall_in_rule__PrimaryExpression__Alternatives3013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarOrArgumentCall_in_rule__PrimaryExpression__Alternatives3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_rule__PrimaryExpression__Alternatives3047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_0__0_in_rule__Literal__Alternatives3079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__0_in_rule__Literal__Alternatives3097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__ConditionAssignment_1_1_0_in_rule__Literal__Alternatives_1_13130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Literal__Alternatives_1_13149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__RangeAssignment_1_0_in_rule__NativeExpression__Alternatives_13183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__RefAssignment_1_1_in_rule__NativeExpression__Alternatives_13201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResourceRef_in_rule__LeafRef__Alternatives3234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkRef_in_rule__LeafRef__Alternatives3251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__NativeFunction__Alternatives3284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__NativeFunction__Alternatives3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__NativeFunction__Alternatives3326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__NativeFunction__Alternatives3347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__NativeFunction__Alternatives3368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__NativeFunction__Alternatives3389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group__0__Impl_in_rule__Mod__Group__03422 = new BitSet(new long[]{0x00C50006C9C07050L});
    public static final BitSet FOLLOW_rule__Mod__Group__1_in_rule__Mod__Group__03425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__0_in_rule__Mod__Group__0__Impl3452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group__1__Impl_in_rule__Mod__Group__13483 = new BitSet(new long[]{0x00C50006C9C07050L});
    public static final BitSet FOLLOW_rule__Mod__Group__2_in_rule__Mod__Group__13486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__ImportsAssignment_1_in_rule__Mod__Group__1__Impl3513 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__Mod__Group__2__Impl_in_rule__Mod__Group__23544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Alternatives_2_in_rule__Mod__Group__2__Impl3571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__0__Impl_in_rule__Mod__Group_0__03607 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__1_in_rule__Mod__Group_0__03610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Mod__Group_0__0__Impl3638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__Group_0__1__Impl_in_rule__Mod__Group_0__13669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Mod__NameAssignment_0_1_in_rule__Mod__Group_0__1__Impl3696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03731 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Import__Group__0__Impl3762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1__Impl3820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__0__Impl_in_rule__Function__Group__03854 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Function__Group__1_in_rule__Function__Group__03857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Function__Group__0__Impl3885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__1__Impl_in_rule__Function__Group__13916 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Function__Group__2_in_rule__Function__Group__13919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__NameAssignment_1_in_rule__Function__Group__1__Impl3946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__2__Impl_in_rule__Function__Group__23976 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__Function__Group__3_in_rule__Function__Group__23979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__Function__Group__2__Impl4007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__3__Impl_in_rule__Function__Group__34038 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__Function__Group__4_in_rule__Function__Group__34041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3__0_in_rule__Function__Group__3__Impl4068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__4__Impl_in_rule__Function__Group__44099 = new BitSet(new long[]{0x00C50006C9007050L});
    public static final BitSet FOLLOW_rule__Function__Group__5_in_rule__Function__Group__44102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__Function__Group__4__Impl4130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group__5__Impl_in_rule__Function__Group__54161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__BlockAssignment_5_in_rule__Function__Group__5__Impl4188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3__0__Impl_in_rule__Function__Group_3__04230 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__Function__Group_3__1_in_rule__Function__Group_3__04233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__ArgsAssignment_3_0_in_rule__Function__Group_3__0__Impl4260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3__1__Impl_in_rule__Function__Group_3__14290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__0_in_rule__Function__Group_3__1__Impl4317 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__0__Impl_in_rule__Function__Group_3_1__04352 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__1_in_rule__Function__Group_3_1__04355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__Function__Group_3_1__0__Impl4383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__Group_3_1__1__Impl_in_rule__Function__Group_3_1__14414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Function__ArgsAssignment_3_1_1_in_rule__Function__Group_3_1__1__Impl4441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__Group__0__Impl_in_rule__Block__Group__04475 = new BitSet(new long[]{0x00C50006C9007050L});
    public static final BitSet FOLLOW_rule__Block__Group__1_in_rule__Block__Group__04478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__Group__1__Impl_in_rule__Block__Group__14536 = new BitSet(new long[]{0x00C50006D9007050L});
    public static final BitSet FOLLOW_rule__Block__Group__2_in_rule__Block__Group__14539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Block__Group__1__Impl4567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__Group__2__Impl_in_rule__Block__Group__24598 = new BitSet(new long[]{0x00C50006D9007050L});
    public static final BitSet FOLLOW_rule__Block__Group__3_in_rule__Block__Group__24601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Block__StatementsAssignment_2_in_rule__Block__Group__2__Impl4628 = new BitSet(new long[]{0x00C50006C9007052L});
    public static final BitSet FOLLOW_rule__Block__Group__3__Impl_in_rule__Block__Group__34659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Block__Group__3__Impl4687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__0__Impl_in_rule__Statement__Group_0__04726 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__1_in_rule__Statement__Group_0__04729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Alternatives_0_0_in_rule__Statement__Group_0__0__Impl4756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Group_0__1__Impl_in_rule__Statement__Group_0__14786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Statement__Group_0__1__Impl4814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__0__Impl_in_rule__ReturnStatement__Group__04849 = new BitSet(new long[]{0x00C5000441007050L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__1_in_rule__ReturnStatement__Group__04852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__1__Impl_in_rule__ReturnStatement__Group__14910 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__2_in_rule__ReturnStatement__Group__14913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ReturnStatement__Group__1__Impl4941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__Group__2__Impl_in_rule__ReturnStatement__Group__24972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReturnStatement__ExpressionAssignment_2_in_rule__ReturnStatement__Group__2__Impl4999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__0__Impl_in_rule__IfStatement__Group__05036 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__1_in_rule__IfStatement__Group__05039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__1__Impl_in_rule__IfStatement__Group__15097 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__2_in_rule__IfStatement__Group__15100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__IfStatement__Group__1__Impl5128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__2__Impl_in_rule__IfStatement__Group__25159 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__3_in_rule__IfStatement__Group__25162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__IfStatement__Group__2__Impl5190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__3__Impl_in_rule__IfStatement__Group__35221 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__4_in_rule__IfStatement__Group__35224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__IfAssignment_3_in_rule__IfStatement__Group__3__Impl5251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__4__Impl_in_rule__IfStatement__Group__45281 = new BitSet(new long[]{0x00C50006C9007050L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__5_in_rule__IfStatement__Group__45284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__IfStatement__Group__4__Impl5312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__5__Impl_in_rule__IfStatement__Group__55343 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__6_in_rule__IfStatement__Group__55346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__ThenAssignment_5_in_rule__IfStatement__Group__5__Impl5373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group__6__Impl_in_rule__IfStatement__Group__65403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__0_in_rule__IfStatement__Group__6__Impl5430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__0__Impl_in_rule__IfStatement__Group_6__05475 = new BitSet(new long[]{0x00C50006C9007050L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__1_in_rule__IfStatement__Group_6__05478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__IfStatement__Group_6__0__Impl5506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__Group_6__1__Impl_in_rule__IfStatement__Group_6__15537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IfStatement__ElseAssignment_6_1_in_rule__IfStatement__Group_6__1__Impl5564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__0__Impl_in_rule__WhileStatement__Group__05598 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__1_in_rule__WhileStatement__Group__05601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__1__Impl_in_rule__WhileStatement__Group__15659 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__2_in_rule__WhileStatement__Group__15662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__WhileStatement__Group__1__Impl5690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__2__Impl_in_rule__WhileStatement__Group__25721 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__3_in_rule__WhileStatement__Group__25724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__WhileStatement__Group__2__Impl5752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__3__Impl_in_rule__WhileStatement__Group__35783 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__4_in_rule__WhileStatement__Group__35786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__PredicateAssignment_3_in_rule__WhileStatement__Group__3__Impl5813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__4__Impl_in_rule__WhileStatement__Group__45843 = new BitSet(new long[]{0x00C50006C9007050L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__5_in_rule__WhileStatement__Group__45846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__WhileStatement__Group__4__Impl5874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__Group__5__Impl_in_rule__WhileStatement__Group__55905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__WhileStatement__BodyAssignment_5_in_rule__WhileStatement__Group__5__Impl5932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__0__Impl_in_rule__VariableStatement__Group__05974 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__1_in_rule__VariableStatement__Group__05977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__1__Impl_in_rule__VariableStatement__Group__16035 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__2_in_rule__VariableStatement__Group__16038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__VariableStatement__Group__1__Impl6066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__2__Impl_in_rule__VariableStatement__Group__26097 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__3_in_rule__VariableStatement__Group__26100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__NameAssignment_2_in_rule__VariableStatement__Group__2__Impl6127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group__3__Impl_in_rule__VariableStatement__Group__36157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__0_in_rule__VariableStatement__Group__3__Impl6184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__0__Impl_in_rule__VariableStatement__Group_3__06223 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__1_in_rule__VariableStatement__Group_3__06226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__VariableStatement__Group_3__0__Impl6254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__Group_3__1__Impl_in_rule__VariableStatement__Group_3__16285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableStatement__ExpressionAssignment_3_1_in_rule__VariableStatement__Group_3__1__Impl6312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__0__Impl_in_rule__AssignmentStatement__Group__06346 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__1_in_rule__AssignmentStatement__Group__06349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__1__Impl_in_rule__AssignmentStatement__Group__16407 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__2_in_rule__AssignmentStatement__Group__16410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__VarAssignment_1_in_rule__AssignmentStatement__Group__1__Impl6437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__2__Impl_in_rule__AssignmentStatement__Group__26467 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__3_in_rule__AssignmentStatement__Group__26470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__AssignmentStatement__Group__2__Impl6498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__Group__3__Impl_in_rule__AssignmentStatement__Group__36529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AssignmentStatement__ExpressionAssignment_3_in_rule__AssignmentStatement__Group__3__Impl6556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__0__Impl_in_rule__ReferenceAssignmentStatement__Group__06594 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__1_in_rule__ReferenceAssignmentStatement__Group__06597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__1__Impl_in_rule__ReferenceAssignmentStatement__Group__16655 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__2_in_rule__ReferenceAssignmentStatement__Group__16658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__RefAssignment_1_in_rule__ReferenceAssignmentStatement__Group__1__Impl6685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__2__Impl_in_rule__ReferenceAssignmentStatement__Group__26715 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__3_in_rule__ReferenceAssignmentStatement__Group__26718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ReferenceAssignmentStatement__Group__2__Impl6746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__Group__3__Impl_in_rule__ReferenceAssignmentStatement__Group__36777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceAssignmentStatement__ExpressionAssignment_3_in_rule__ReferenceAssignmentStatement__Group__3__Impl6804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group__0__Impl_in_rule__Logical__Group__06842 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__Logical__Group__1_in_rule__Logical__Group__06845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_rule__Logical__Group__0__Impl6872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group__1__Impl_in_rule__Logical__Group__16901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__0_in_rule__Logical__Group__1__Impl6928 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__0__Impl_in_rule__Logical__Group_1__06963 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__1_in_rule__Logical__Group_1__06966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Alternatives_1_0_in_rule__Logical__Group_1__0__Impl6993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1__1__Impl_in_rule__Logical__Group_1__17023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__RightAssignment_1_1_in_rule__Logical__Group_1__1__Impl7050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__0__Impl_in_rule__Logical__Group_1_0_0__07084 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__1_in_rule__Logical__Group_1_0_0__07087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_0__1__Impl_in_rule__Logical__Group_1_0_0__17145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Logical__Group_1_0_0__1__Impl7173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__0__Impl_in_rule__Logical__Group_1_0_1__07208 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__1_in_rule__Logical__Group_1_0_1__07211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Logical__Group_1_0_1__1__Impl_in_rule__Logical__Group_1_0_1__17269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Logical__Group_1_0_1__1__Impl7297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group__0__Impl_in_rule__Equality__Group__07332 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_rule__Equality__Group__1_in_rule__Equality__Group__07335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__Equality__Group__0__Impl7362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group__1__Impl_in_rule__Equality__Group__17391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__0_in_rule__Equality__Group__1__Impl7418 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__0__Impl_in_rule__Equality__Group_1__07453 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__1_in_rule__Equality__Group_1__07456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Alternatives_1_0_in_rule__Equality__Group_1__0__Impl7483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1__1__Impl_in_rule__Equality__Group_1__17513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__RightAssignment_1_1_in_rule__Equality__Group_1__1__Impl7540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__0__Impl_in_rule__Equality__Group_1_0_0__07574 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__1_in_rule__Equality__Group_1_0_0__07577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_0__1__Impl_in_rule__Equality__Group_1_0_0__17635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Equality__Group_1_0_0__1__Impl7663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__0__Impl_in_rule__Equality__Group_1_0_1__07698 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__1_in_rule__Equality__Group_1_0_1__07701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Equality__Group_1_0_1__1__Impl_in_rule__Equality__Group_1_0_1__17759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Equality__Group_1_0_1__1__Impl7787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__0__Impl_in_rule__Comparison__Group__07822 = new BitSet(new long[]{0x00000F0000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1_in_rule__Comparison__Group__07825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_rule__Comparison__Group__0__Impl7852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group__1__Impl_in_rule__Comparison__Group__17881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0_in_rule__Comparison__Group__1__Impl7908 = new BitSet(new long[]{0x00000F0000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__0__Impl_in_rule__Comparison__Group_1__07943 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1_in_rule__Comparison__Group_1__07946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Alternatives_1_0_in_rule__Comparison__Group_1__0__Impl7973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1__1__Impl_in_rule__Comparison__Group_1__18003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__RightAssignment_1_1_in_rule__Comparison__Group_1__1__Impl8030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__0__Impl_in_rule__Comparison__Group_1_0_0__08064 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__1_in_rule__Comparison__Group_1_0_0__08067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_0__1__Impl_in_rule__Comparison__Group_1_0_0__18125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Comparison__Group_1_0_0__1__Impl8153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__0__Impl_in_rule__Comparison__Group_1_0_1__08188 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__1_in_rule__Comparison__Group_1_0_1__08191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_1__1__Impl_in_rule__Comparison__Group_1_0_1__18249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Comparison__Group_1_0_1__1__Impl8277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__0__Impl_in_rule__Comparison__Group_1_0_2__08312 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__1_in_rule__Comparison__Group_1_0_2__08315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_2__1__Impl_in_rule__Comparison__Group_1_0_2__18373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Comparison__Group_1_0_2__1__Impl8401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__0__Impl_in_rule__Comparison__Group_1_0_3__08436 = new BitSet(new long[]{0x00000F0000000000L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__1_in_rule__Comparison__Group_1_0_3__08439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Comparison__Group_1_0_3__1__Impl_in_rule__Comparison__Group_1_0_3__18497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Comparison__Group_1_0_3__1__Impl8525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__0__Impl_in_rule__Addition__Group__08560 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_rule__Addition__Group__1_in_rule__Addition__Group__08563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__Group__0__Impl8590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group__1__Impl_in_rule__Addition__Group__18619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0_in_rule__Addition__Group__1__Impl8646 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__0__Impl_in_rule__Addition__Group_1__08681 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1_in_rule__Addition__Group_1__08684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Alternatives_1_0_in_rule__Addition__Group_1__0__Impl8711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1__1__Impl_in_rule__Addition__Group_1__18741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__RightAssignment_1_1_in_rule__Addition__Group_1__1__Impl8768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__0__Impl_in_rule__Addition__Group_1_0_0__08802 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1_in_rule__Addition__Group_1_0_0__08805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_0__1__Impl_in_rule__Addition__Group_1_0_0__18863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Addition__Group_1_0_0__1__Impl8891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__0__Impl_in_rule__Addition__Group_1_0_1__08926 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1_in_rule__Addition__Group_1_0_1__08929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Addition__Group_1_0_1__1__Impl_in_rule__Addition__Group_1_0_1__18987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Addition__Group_1_0_1__1__Impl9015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__0__Impl_in_rule__Multiplication__Group__09050 = new BitSet(new long[]{0x0000700000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1_in_rule__Multiplication__Group__09053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_rule__Multiplication__Group__0__Impl9080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group__1__Impl_in_rule__Multiplication__Group__19109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0_in_rule__Multiplication__Group__1__Impl9136 = new BitSet(new long[]{0x0000700000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__0__Impl_in_rule__Multiplication__Group_1__09171 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1_in_rule__Multiplication__Group_1__09174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Alternatives_1_0_in_rule__Multiplication__Group_1__0__Impl9201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1__1__Impl_in_rule__Multiplication__Group_1__19231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__RightAssignment_1_1_in_rule__Multiplication__Group_1__1__Impl9258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__0__Impl_in_rule__Multiplication__Group_1_0_0__09292 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__1_in_rule__Multiplication__Group_1_0_0__09295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_0__1__Impl_in_rule__Multiplication__Group_1_0_0__19353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__Multiplication__Group_1_0_0__1__Impl9381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__0__Impl_in_rule__Multiplication__Group_1_0_1__09416 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__1_in_rule__Multiplication__Group_1_0_1__09419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_1__1__Impl_in_rule__Multiplication__Group_1_0_1__19477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__Multiplication__Group_1_0_1__1__Impl9505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__0__Impl_in_rule__Multiplication__Group_1_0_2__09540 = new BitSet(new long[]{0x0000700000000000L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__1_in_rule__Multiplication__Group_1_0_2__09543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Multiplication__Group_1_0_2__1__Impl_in_rule__Multiplication__Group_1_0_2__19601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__Multiplication__Group_1_0_2__1__Impl9629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__0__Impl_in_rule__Unary__Group_1__09664 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__1_in_rule__Unary__Group_1__09667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Alternatives_1_0_in_rule__Unary__Group_1__0__Impl9694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1__1__Impl_in_rule__Unary__Group_1__19724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__RightAssignment_1_1_in_rule__Unary__Group_1__1__Impl9751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__0__Impl_in_rule__Unary__Group_1_0_0__09785 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__1_in_rule__Unary__Group_1_0_0__09788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_0__1__Impl_in_rule__Unary__Group_1_0_0__19846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__OpAssignment_1_0_0_1_in_rule__Unary__Group_1_0_0__1__Impl9873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__0__Impl_in_rule__Unary__Group_1_0_1__09907 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__1_in_rule__Unary__Group_1_0_1__09910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__Group_1_0_1__1__Impl_in_rule__Unary__Group_1_0_1__19968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Unary__OpAssignment_1_0_1_1_in_rule__Unary__Group_1_0_1__1__Impl9995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_0__0__Impl_in_rule__Literal__Group_0__010029 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Literal__Group_0__1_in_rule__Literal__Group_0__010032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_0__1__Impl_in_rule__Literal__Group_0__110090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__ValueAssignment_0_1_in_rule__Literal__Group_0__1__Impl10117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__0__Impl_in_rule__Literal__Group_1__010151 = new BitSet(new long[]{0x0080000000004040L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__1_in_rule__Literal__Group_1__010154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Group_1__1__Impl_in_rule__Literal__Group_1__110212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Literal__Alternatives_1_1_in_rule__Literal__Group_1__1__Impl10239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__0__Impl_in_rule__ParenthesizedExpression__Group__010273 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__1_in_rule__ParenthesizedExpression__Group__010276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ParenthesizedExpression__Group__0__Impl10304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__1__Impl_in_rule__ParenthesizedExpression__Group__110335 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__2_in_rule__ParenthesizedExpression__Group__110338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ParenthesizedExpression__Group__1__Impl10365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParenthesizedExpression__Group__2__Impl_in_rule__ParenthesizedExpression__Group__210394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ParenthesizedExpression__Group__2__Impl10422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__0__Impl_in_rule__FunctionCall__Group__010459 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__1_in_rule__FunctionCall__Group__010462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__1__Impl_in_rule__FunctionCall__Group__110520 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__2_in_rule__FunctionCall__Group__110523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__FuncAssignment_1_in_rule__FunctionCall__Group__1__Impl10550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__2__Impl_in_rule__FunctionCall__Group__210580 = new BitSet(new long[]{0x00C5000003007050L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__3_in_rule__FunctionCall__Group__210583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__FunctionCall__Group__2__Impl10611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__3__Impl_in_rule__FunctionCall__Group__310642 = new BitSet(new long[]{0x00C5000003007050L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__4_in_rule__FunctionCall__Group__310645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__0_in_rule__FunctionCall__Group__3__Impl10672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group__4__Impl_in_rule__FunctionCall__Group__410703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__FunctionCall__Group__4__Impl10731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__0__Impl_in_rule__FunctionCall__Group_3__010772 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__1_in_rule__FunctionCall__Group_3__010775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__ArgsAssignment_3_0_in_rule__FunctionCall__Group_3__0__Impl10802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3__1__Impl_in_rule__FunctionCall__Group_3__110832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__0_in_rule__FunctionCall__Group_3__1__Impl10859 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__0__Impl_in_rule__FunctionCall__Group_3_1__010894 = new BitSet(new long[]{0x00C5000001007050L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__1_in_rule__FunctionCall__Group_3_1__010897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__FunctionCall__Group_3_1__0__Impl10925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__Group_3_1__1__Impl_in_rule__FunctionCall__Group_3_1__110956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FunctionCall__ArgsAssignment_3_1_1_in_rule__FunctionCall__Group_3_1__1__Impl10983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__Group__0__Impl_in_rule__VarOrArgumentCall__Group__011017 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__Group__1_in_rule__VarOrArgumentCall__Group__011020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__Group__1__Impl_in_rule__VarOrArgumentCall__Group__111078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VarOrArgumentCall__CallAssignment_1_in_rule__VarOrArgumentCall__Group__1__Impl11105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__0__Impl_in_rule__NativeExpression__Group__011139 = new BitSet(new long[]{0x0005000000000000L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__1_in_rule__NativeExpression__Group__011142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__1__Impl_in_rule__NativeExpression__Group__111200 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__2_in_rule__NativeExpression__Group__111203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Alternatives_1_in_rule__NativeExpression__Group__1__Impl11230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__2__Impl_in_rule__NativeExpression__Group__211260 = new BitSet(new long[]{0x00000000001F8000L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__3_in_rule__NativeExpression__Group__211263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__NativeExpression__Group__2__Impl11291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__Group__3__Impl_in_rule__NativeExpression__Group__311322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NativeExpression__NativeFunctionAssignment_3_in_rule__NativeExpression__Group__3__Impl11349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__0__Impl_in_rule__RangeLiteral__Group__011387 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__1_in_rule__RangeLiteral__Group__011390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__1__Impl_in_rule__RangeLiteral__Group__111448 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__2_in_rule__RangeLiteral__Group__111451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__RangeLiteral__Group__1__Impl11479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__2__Impl_in_rule__RangeLiteral__Group__211510 = new BitSet(new long[]{0x0002000004000000L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__3_in_rule__RangeLiteral__Group__211513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__ValuesAssignment_2_in_rule__RangeLiteral__Group__2__Impl11540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__3__Impl_in_rule__RangeLiteral__Group__311570 = new BitSet(new long[]{0x0002000004000000L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__4_in_rule__RangeLiteral__Group__311573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group_3__0_in_rule__RangeLiteral__Group__3__Impl11600 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group__4__Impl_in_rule__RangeLiteral__Group__411631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__RangeLiteral__Group__4__Impl11659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group_3__0__Impl_in_rule__RangeLiteral__Group_3__011700 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group_3__1_in_rule__RangeLiteral__Group_3__011703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__RangeLiteral__Group_3__0__Impl11731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__Group_3__1__Impl_in_rule__RangeLiteral__Group_3__111762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RangeLiteral__ValuesAssignment_3_1_in_rule__RangeLiteral__Group_3__1__Impl11789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__0__Impl_in_rule__ContextRef__Group__011823 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__1_in_rule__ContextRef__Group__011826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ContextRef__Group__0__Impl11854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ContextRef__Group__1__Impl_in_rule__ContextRef__Group__111885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNodeRef_in_rule__ContextRef__Group__1__Impl11912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__0__Impl_in_rule__NodeRef__Group__011945 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1_in_rule__NodeRef__Group__011948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl11977 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__NodesAssignment_0_in_rule__NodeRef__Group__0__Impl11989 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group__1__Impl_in_rule__NodeRef__Group__112022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__0_in_rule__NodeRef__Group__1__Impl12049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__0__Impl_in_rule__NodeRef__Group_1__012084 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__1_in_rule__NodeRef__Group_1__012087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rule__NodeRef__Group_1__0__Impl12115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__Group_1__1__Impl_in_rule__NodeRef__Group_1__112146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NodeRef__RefAssignment_1_1_in_rule__NodeRef__Group_1__1__Impl12173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__0__Impl_in_rule__PrimaryNodeRef__Group__012207 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__1_in_rule__PrimaryNodeRef__Group__012210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__1__Impl_in_rule__PrimaryNodeRef__Group__112268 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__2_in_rule__PrimaryNodeRef__Group__112271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__PrimaryNodeRef__Group__1__Impl12299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__Group__2__Impl_in_rule__PrimaryNodeRef__Group__212330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryNodeRef__NodeAssignment_2_in_rule__PrimaryNodeRef__Group__2__Impl12357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__0__Impl_in_rule__ResourceRef__Group__012393 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__1_in_rule__ResourceRef__Group__012396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__1__Impl_in_rule__ResourceRef__Group__112454 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__2_in_rule__ResourceRef__Group__112457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rule__ResourceRef__Group__1__Impl12485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__Group__2__Impl_in_rule__ResourceRef__Group__212516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResourceRef__ResourceAssignment_2_in_rule__ResourceRef__Group__2__Impl12543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__0__Impl_in_rule__LinkRef__Group__012579 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__1_in_rule__LinkRef__Group__012582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__1__Impl_in_rule__LinkRef__Group__112640 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__2_in_rule__LinkRef__Group__112643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rule__LinkRef__Group__1__Impl12671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__Group__2__Impl_in_rule__LinkRef__Group__212702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__LinkRef__LinkAssignment_2_in_rule__LinkRef__Group__2__Impl12729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Mod__NameAssignment_0_112770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Mod__ImportsAssignment_112801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_rule__Mod__FunctionsAssignment_2_012832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Mod__StatementsAssignment_2_112863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_112895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Function__NameAssignment_112926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_012957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgument_in_rule__Function__ArgsAssignment_3_1_112988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__Function__BlockAssignment_513019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Argument__NameAssignment13050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Block__StatementsAssignment_213081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__Statement__ExpressionAssignment_0_0_313112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ReturnStatement__ExpressionAssignment_213143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_rule__IfStatement__IfAssignment_313174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__IfStatement__ThenAssignment_513205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__IfStatement__ElseAssignment_6_113236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogical_in_rule__WhileStatement__PredicateAssignment_313267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_rule__WhileStatement__BodyAssignment_513298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VariableStatement__NameAssignment_213329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__VariableStatement__ExpressionAssignment_3_113360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AssignmentStatement__VarAssignment_113395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__AssignmentStatement__ExpressionAssignment_313430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextRef_in_rule__ReferenceAssignmentStatement__RefAssignment_113461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__ReferenceAssignmentStatement__ExpressionAssignment_313492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquality_in_rule__Logical__RightAssignment_1_113523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparison_in_rule__Equality__RightAssignment_1_113554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAddition_in_rule__Comparison__RightAssignment_1_113585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplication_in_rule__Addition__RightAssignment_1_113616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_rule__Multiplication__RightAssignment_1_113647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_rule__Unary__OpAssignment_1_0_0_113683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_rule__Unary__OpAssignment_1_0_1_113722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_rule__Unary__RightAssignment_1_113753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__Literal__ValueAssignment_0_113784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_rule__Literal__ConditionAssignment_1_1_013820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FunctionCall__FuncAssignment_113863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_013898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_rule__FunctionCall__ArgsAssignment_3_1_113929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__VarOrArgumentCall__CallAssignment_113964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeLiteral_in_rule__NativeExpression__RangeAssignment_1_013999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__NativeExpression__RefAssignment_1_114030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNativeFunction_in_rule__NativeExpression__NativeFunctionAssignment_314061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__RangeLiteral__ValuesAssignment_214092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NUMBER_in_rule__RangeLiteral__ValuesAssignment_3_114123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryNodeRef_in_rule__NodeRef__NodesAssignment_014154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLeafRef_in_rule__NodeRef__RefAssignment_1_114185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PrimaryNodeRef__NodeAssignment_214220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ResourceRef__ResourceAssignment_214259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__LinkRef__LinkAssignment_214298 = new BitSet(new long[]{0x0000000000000002L});

}